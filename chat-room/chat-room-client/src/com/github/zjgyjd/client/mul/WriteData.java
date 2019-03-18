package com.github.zjgyjd.client.mul;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class WriteData extends Thread {
    private final Socket client;

    public WriteData(Socket client) {
        this.client = client;
    }


    @Override
    public void run() {
        try {
            OutputStream clientOutput = this.client.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(clientOutput);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                String data;
                data = scanner.nextLine();

                writer.write(data + "\n");
                writer.flush();
                if (data.equals("bye")) {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
