package org.minjae.NetWorkscanner;


import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

class ScanTask implements Runnable {

    private String ip;
    private int port;

    public ScanTask(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    @Override
    public void run() {
        PortScanner.scanPort(ip, port);
    }
}

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
        for (int port = startPort; port <= endPort; port++) 
        {
            Thread thread = new Thread(new ScanTask(target, port));

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





