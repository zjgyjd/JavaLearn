import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

//import org.apache.juli.logging.Log;        用于打印日志暂时取消
//import org.apache.juli.logging.LogFactory;

//import util.HTMLFilter;//暂时不做解析

@ServerEndpoint(value = "/websocket/chat")
public class TomNb {

    //private static final Log log = LogFactory.getLog(ChatAnnotation.class); //取消

    private static final String GUEST_PREFIX = "Guest"; //客人的前缀
    private static final AtomicInteger connectionIds = new AtomicInteger(0); //连接的id
    private static final Set<TomNb> connections =
            new CopyOnWriteArraySet<>();                    //线程包下的线程安全Set

    private final String nickname;
    private Session session;

    public TomNb() {
        nickname = GUEST_PREFIX + connectionIds.getAndIncrement(); //确认出当前连接下的唯一顾客id
        //之后需要改进的,利用session将用户的名字读过来
    }


    @OnOpen
    public void start(Session session) {
        this.session = session;
        connections.add(this);
        String message = String.format("* %s %s", nickname, "has joined."); // 此时某个用户加入了会话大厅
        broadcast(message , null ,false);
    }


    @OnClose
    public void end() {
        connections.remove(this);
        String message = String.format("* %s %s",
                nickname, "has disconnected.");
        broadcast(message , null ,false);
    }


    @OnMessage
    public void incoming(String message) {
        // Never trust the client   永远不相信用户
//        String filteredMessage = String.format("%s: %s",
//                nickname, HTMLFilter.filter(message.toString()));
//        //进行了一个过滤,做了一个字符的转换,我们暂时不做
//        broadcast(filteredMessage);
        String filteredMessage = String.format("%s: %s",nickname, message.toString());
        //需要自己不要显示自己说的话,唯一的方法就是不向自己穿输,需要将自己传进去
        broadcast(filteredMessage , this , true);//这个地方在传输消息,表示在通话
    }




    @OnError
    public void onError(Throwable t) throws Throwable {
        //log.error("Chat Error: " + t.toString(), t);
        System.out.println("Chat Error: " + t.toString());
        //打印出错误信息
    }


    private static void broadcast(String msg , TomNb my , Boolean flag) {
        for (TomNb client : connections) { //遍历所有客户端,用于上传数据
            try {
                synchronized (client) {//对每一个用户上锁
                    if(flag && client == my){//此时说明不需要传给自己
                        continue;
                    }
                    client.session.getBasicRemote().sendText(msg);//这一步可以将服务器数据传到客户端
                }
            } catch (IOException e) {
                //log.debug("Chat Error: Failed to send message to client", e);
                System.out.println("Chat Error: Failed to send message to client" + e.getMessage());
                connections.remove(client);//此时一个将该用户踢除
                try {
                    client.session.close();//发生异常应该及时关闭session
                } catch (IOException e1) {
                    // Ignore
                }
                String message = String.format("* %s %s",
                        client.nickname, "has been disconnected."); //抛异常此时退出连接
                broadcast(message , null , false);//使循环继续,将该用户退出连接的消息告诉所有人
            }
        }
    }
}