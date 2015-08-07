package tiktaktoe;

import java.awt.Frame;
import java.net.*;
import java.io.*;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

class Client {

    ImageIcon pic1 = new ImageIcon(getClass().getResource("/Img/playerImg1.jpg"));
    LinkedList<Integer> clientqueue;
    Socket socket = null;
    ObjectInputStream ois = null;
    ObjectOutputStream oos = null;
    String serverIP = "localhost";

    public Client() {
        clientqueue = new LinkedList<Integer>();
        try {
            socket = new Socket("localhost", 1212);
            System.out.println("server connected....");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("No server Found....");//showing a warning message if there is no client to connect
            JOptionPane.showMessageDialog(new Frame(), "No server Found...");
        }
        try {
            InetAddress inet = socket.getInetAddress();
            System.out.println("Server address : " + inet.getHostAddress());
        } catch (Exception e) {
            System.out.println("No server Found");
        }

    }

    public Client(String serverIP) {//this constructer will execute if user  give an server ip address
        clientqueue = new LinkedList<Integer>();
        try {
            socket = new Socket(serverIP, 1212);
            System.out.println("server connected....");
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            InetAddress inet = socket.getInetAddress();
            System.out.println("Server address : " + inet.getHostAddress());
        } catch (Exception e) {
            System.out.println("No Server Found.");
        }
    }

    public void informServer(String msg) {//sent the string message to server
        try {
            System.out.print("Me Client :");
            oos.writeObject(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
