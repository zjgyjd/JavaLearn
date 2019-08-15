import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@ServerEndpoint("/websocket/text")
public class Test {
    @OnOpen
    public void onOpen(){
        System.out.println("打开了webSocket");
    }
    @OnClose
    public void onClose(){
        System.out.println("关闭了webSocket");
    }
    @OnMessage
    public void onMessage(Session session, String msg){
        System.out.println("send message"+msg);
        if(session.isOpen()){
            try {
                session.getBasicRemote().sendText(msg);//传输数据,服务器到-->客户端
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
