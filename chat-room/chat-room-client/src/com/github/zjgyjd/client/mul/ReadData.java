package com.github.zjgyjd.client.mul;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class ReadData extends Thread {
    private final Socket client;

    public ReadData(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            InputStream message = client.getInputStream();
            Scanner scanner = new Scanner(message);

            while (true) {
                String m = scanner.nextLine();
                if (!m.equals("bye")) {
                    System.out.println(m);
                }else{
                    this.client.close();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
