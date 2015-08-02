package tiktaktoe;

import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;

class Client {
    ImageIcon pic1 = new ImageIcon(getClass().getResource("/Img/playerImg1.jpg"));
    LinkedList<Integer> clientqueue;
    Socket socket = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;

    public Client() {
        clientqueue = new LinkedList<Integer>();
        try {
            socket = new Socket("localhost", 1212);
            System.out.println("server connected....");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        InetAddress inet = socket.getInetAddress();
        System.out.println("Server address : " + inet.getHostAddress());
        

    }

    public void informServer(String msg) {
        try {
            System.out.print("Me Client :");
            oos.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
}
