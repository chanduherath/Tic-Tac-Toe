package tiktaktoe;

import java.io.*;
import java.util.*;
import java.net.*;
import javax.swing.ImageIcon;

public class Server {
    ImageIcon pic2 = new ImageIcon(getClass().getResource("/Img/playerImg2.jpg"));
    LinkedList<Integer> serverqueue;
    ServerSocket myServer = null;
    Socket socket = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    public Server() {//Start Server
        serverqueue = new LinkedList<Integer>();
        try {
            myServer = new ServerSocket(1212);
        } catch (Exception e) {
            System.out.println(e);
        }

        //accept requests
        try {
            System.out.println("Waiting for a request...");
            socket = myServer.accept();
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress inet = socket.getInetAddress();
        System.out.println("Server address : " + inet.getHostAddress());
        
    }

    public void informClient(String msg) {
        try {
            System.out.print("Me Server :");
            oos.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
}
