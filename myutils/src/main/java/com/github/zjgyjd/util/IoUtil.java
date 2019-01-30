package com.github.zjgyjd.util;

import sun.nio.ByteBuffered;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * I/O处理工具
 * <p>
 * Author: zjgyjd
 * Created: 2018/10/13
 */
public final class IoUtil {

    private IoUtil() {
    }

    /**
     * 将Reader中的内容复制到Writer中 使用默认缓存大小
     *
     * @param reader Reader
     * @param writer Writer
     * @return 拷贝的字节数
     */
    public static long copy(Reader reader, Writer writer) {
        long len = 0;
        char[] buff = new char[1];
        try {
            while ((reader.read(buff)) != -1) {
                len++;
                writer.write(buff);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return -1;//失败
        }
        return len;//成功
    }


    /**
     * 拷贝流，使用默认Buffer大小
     *
     * @param in  输入流
     * @param out 输出流
     * @return 传输的byte数
     */
    public static long copy(InputStream in, OutputStream out) {
        int len = 0;
        byte[] buff = new byte[1024];
        long count = 0;
        try {
            while ((len = in.read(buff)) != -1) {
                if (len == 1024) {
                    count += 1024;
                } else {
                    count += len;
                }
                out.write(buff, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(len);
            return -1;
        }
        return count;
    }


    /**
     * 拷贝文件流，使用NIO
     *
     * @param in  输入
     * @param out 输出
     * @return 拷贝的字节数
     */
    public static long copy(FileInputStream in, FileOutputStream out) {
        return copy((InputStream) in, (OutputStream) out);
    }


    /**
     * 获得一个Reader
     *
     * @param in      输入流
     * @param charset 字符集
     * @return BufferedReader对象
     */
    public static BufferedReader getReader(InputStream in, Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(in, charset);
        return new BufferedReader(inputStreamReader);//缓冲流可以进行readerLine 读取一行
    }


    /**
     * 获得一个Writer
     *
     * @param out     输入流
     * @param charset 字符集
     * @return BufferedWriter对象
     */
    public static BufferedWriter getWriter(OutputStream out, Charset charset) {
        return new BufferedWriter(new OutputStreamWriter(out, charset));
    }


    /**
     * 从流中读取内容，读取完毕后并不关闭流
     *
     * @param in      输入流，读取完毕后并不关闭流
     * @param charset 字符集
     * @return 内容
     */
    public static String read(InputStream in, Charset charset) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, charset));
        String len;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = bufferedReader.readLine()) != null) {
            stringBuilder.append(len);
        }
        return stringBuilder.toString();
    }


    /**
     * 从Reader中读取String，读取完毕后并不关闭Reader
     *
     * @param reader Reader
     * @return String
     */
    public static String read(Reader reader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String len = null;
        BufferedReader bufferedReader = new BufferedReader(reader);
        while ((len = bufferedReader.readLine()) != null) {
            stringBuilder.append(len);
        }
        return stringBuilder.toString();
    }

    /**
     * 从FileChannel中读取内容
     *
     * @param fileChannel 文件管道
     * @param charset     字符集
     * @return 内容
     */
    public static String read(FileChannel fileChannel, Charset charset) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        int len = -1;
        fileChannel.read(charset.encode("UTE-8"));
        while ((len = fileChannel.read(buffer)) != -1) {
            buffer.flip();
            stringBuilder.append(charset.decode(buffer));
            buffer.clear();
        }

        return stringBuilder.toString();
    }


    /**
     * 将byte[]写到流中
     *
     * @param out        输出流
     * @param isCloseOut 写入完毕是否关闭输出流
     * @param content    写入的内容
     */
    public static void write(OutputStream out, boolean isCloseOut, byte[] content) {
        try {
            out.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isCloseOut) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 将多部分内容写到流中
     *
     * @param out        输出流
     * @param isCloseOut 写入完毕是否关闭输出流
     * @param contents   写入的内容
     */
    public static void write(OutputStream out, boolean isCloseOut, Serializable... contents) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(out)) {
            for (Serializable c : contents) {
                objectOutputStream.writeObject(c);
                objectOutputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isCloseOut) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 关闭<br>
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的对象
     */
    public static void close(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 关闭<br>
     * 关闭失败不会抛出异常
     *
     * @param closeable 被关闭的对象
     */
    public static void close(AutoCloseable closeable) {
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对比两个流内容是否相同<br>
     * 内部会转换流为 {@link BufferedInputStream}
     *
     * @param input1 第一个流
     * @param input2 第二个流
     * @return 两个流的内容一致返回true，否则false
     */
    public static boolean contentEquals(InputStream input1, InputStream input2) {
        try (BufferedInputStream in1 = new BufferedInputStream(input1);
             BufferedInputStream in2 = new BufferedInputStream(input2)) {
            byte[] buff1 = new byte[1024];
            byte[] buff2 = new byte[1024];
            int len1 = -1;
            int len2 = -1;
            while ((len1 = in1.read(buff1)) != -1 && (len2 = in2.read(buff2)) != -1) {
                if (!Arrays.equals(buff1, buff2)) {
                    return false;
                }
            }
            return (len1 = in1.read(buff1)) == -1 && (len2 = in2.read(buff2)) == -1;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
