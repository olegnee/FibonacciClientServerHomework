package com.company;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    static Socket socket;

    public static void main(String[] args) throws IOException {
        socket = new Socket("127.0.0.1", 55555);
        System.out.println("Client connected.");
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(
                     new OutputStreamWriter(socket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Tell me wanted number or write 0 to exit");
                int wantedNumber = scanner.nextInt();
                if (wantedNumber == 0) {
                    out.println(0);
                    break;
                }
                out.println(wantedNumber);
                int newNumber = in.read();
                System.out.println("Your number is " + newNumber);


            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
