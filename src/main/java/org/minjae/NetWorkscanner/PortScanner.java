package org.minjae.NetWorkscanner;


import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
public class PortScanner
{
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        System.out.println("Target IP: ");

        String target=scanner.nextLine();

        System.out.println("Start Port: ");
        int startPort=scanner.nextInt();
          
        System.out.println("End Port: ");
        int endPort=scanner.nextInt();

        System.out.println();
        System.out.println("Scanning Start...");
        System.out.println();
        for(int port= startPort; port<=endPort; port++)
        {
            final int currentPort=port;

            Thread thread=new Thread(()->{
                scanPort(target,currentPort);
            });

            thread.start();
        }
        System.out.println("Scan Complete");

        scanner.close();
    }

    public static void scanPort(String ip, int port)
    {
        try{
            Socket socket=new Socket();
            socket.connect(new InetSocketAddress(ip,port),500);
            System.out.println("[OPEN]"+port);

            socket.close();
        }
        catch(Exception e){
        }
    }
}





