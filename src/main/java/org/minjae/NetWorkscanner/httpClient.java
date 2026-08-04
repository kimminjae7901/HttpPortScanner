package org.minjae.NetWorkscanner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class httpClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("example.com", 80);

            OutputStream out = socket.getOutputStream();

            String request =
                    "GET / HTTP/1.1\r\n" +
                    "Host: example.com\r\n" +
                    "\r\n";

            out.write(request.getBytes());
            out.flush();

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            out.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

