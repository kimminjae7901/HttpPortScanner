package org.minjae.httpClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class httpClient {

    public static void main(String[] args) {

        try {
            Scanner scanner=new Scanner(System.in);
            System.out.println("도메인을 입력하시오: ");
            String host=scanner.nextLine();

            Socket socket = new Socket(host, 80);

            OutputStream out = socket.getOutputStream();
            
            String request =
                    "GET / HTTP/1.1\r\n" +
                    "Host: " +host+ "\r\n" +
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

