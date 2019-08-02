import com.sun.jndi.ldap.ext.StartTlsResponseImpl;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class ProtocolInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected ProtocolInputStream(InputStream in) {
        super(in);
    }


    public String readLine() throws IOException {
        //"OK\r\n"//处理字符串类型将前面这一串返回
        StringBuilder sb = new StringBuilder();
        Boolean flag = true;
        int b = 0;
        while (true) {
            if (flag) {
                b = in.read();
            }
            if (b == -1) {
                throw new RuntimeException("读到结尾了");
            }
            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException("字符读到结尾了");
                }
                if (c == '\n') {
                    break;
                }
                if (c == '\r') {
                    sb.append((char) b);
                    b = c;
                    flag = false;
                } else {
                    sb.append((char) c);
                    flag = true;
                }
            } else {
                sb.append((char) b);
            }
        }
        return sb.toString();
    }

    public long readInteger() throws IOException {
        StringBuilder sb = new StringBuilder();
        boolean isF = true;
        while (true) {
            int b = in.read();
            if (b == '-' && isF) {
                sb.append((char) b);
                isF = false;
                continue;
            }
            if (b == -1) {
                throw new RuntimeException("读到结尾了");
            }
            if (b == '\r') {
                int c = in.read();
                if (c == -1) {
                    throw new RuntimeException("字符读到结尾了");
                }
                if (c == '\n') {
                    break;
                }
                throw new RuntimeException("类型错误");
            } else {
                if (b < '0' || b > '9') {
                    throw new RuntimeException("不是数字");
                }
                sb.append((char) b);
            }
        }
        return Long.parseLong(sb.toString());
    }


}
