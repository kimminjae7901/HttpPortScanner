package org.minjae.HttpServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpServer {
    public static void main(String[] args)
    {
        try {
            ServerSocket server=new ServerSocket(8080);
            System.out.println("Server started : 8080");
            Socket socket = server.accept();
            System.out.println("Client connected");
            BufferedReader reader =
                new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String line;

            while (!(line = reader.readLine()).isEmpty()) {
                System.out.println(line);
            }

            OutputStream out=socket.getOutputStream();
            Path path=Paths.get("src\\main\\java\\org\\minjae\\HttpServer\\WebServer.html");

            String html = Files.readString(path);

            String body=html;
            String response =
                "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/html\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;

            out.write(response.getBytes());
            out.flush();

            socket.close();
            server.close();
        } 
        catch (Exception e) {
        }


    }

}

