import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, RedisException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        String message = "*5\r\n$5\r\nLPUSH\r\n$3\r\nkey\r\n$1\r\n1\r\n$1\r\n2\r\n$1\r\n3\r\n";
        ByteInputStream is = new ByteInputStream(message.getBytes(), message.getBytes().length);

        Command list = Protocol.readCommand(new ProtocolInputStream(is));
        list.run();
//        InputStream is = System.in;


//        List<Object> list = (List<Object>) Protocol.read(is);
//        for (Object b : list) {
//            System.out.println(b.toString());
//        }
        //1.通过class文件和git shell有序
        //echo -ne '+OK\r\n';
        //2.利用管道特性
        //echo -ne '+OK\r\n' | java Main
            //把前一个命令的标准输出作为后一个命令的标准输入
    }
}
