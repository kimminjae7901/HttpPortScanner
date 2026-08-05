package org.minjae.HttpServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class HttpServer {
    public static void main(String[] args)
    {
        try {
            ServerSocket server=new ServerSocket(8080);
            Socket socket = server.accept();
            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String line;

            while (!(line = reader.readLine()).isEmpty()) {
                System.out.println(line);
            }

            OutputStream out=socket.getOutputStream();
            String body="<h1>Hello</h1>";
            String response =
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;

            out.write(response.getBytes());
            out.flush();
        } 
        catch (Exception e) {
        }


    }

}

