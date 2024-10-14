package org.example.examples.socketNetworking;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private Socket socket = null;

    private ServerSocket serverSocket = null;
    private DataInputStream dataInputStream = null;

    public Server(int port) {



        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Started");

            System.out.println("Waiting for client...");

            socket = serverSocket.accept();
            System.out.println("Client accepted!");

            dataInputStream = new DataInputStream
                    (new BufferedInputStream
                            (socket.getInputStream()));


            String line = "";

            while (!line.equals("Over")) {
                try {
                    line = dataInputStream.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(line);


            }

            System.out.println("Server closing...");
            dataInputStream.close();
            serverSocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }





    }


    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
