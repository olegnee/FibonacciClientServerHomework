package com.company;

import java.io.*;
import java.net.*;

public class Server {
    static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        serverSocket = new ServerSocket(55555);
        while (true) {
            try (Socket socket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                int wantedNumber = in.read();
                if (wantedNumber == 0) break;
                int clientWantedNumber = fibonacciWantedNumber(wantedNumber);
                out.println(clientWantedNumber);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private static int fibonacciWantedNumber(int wantedNumber) {
        int newNumber = 0;
        int someNum1 = 0;
        int someNum2 = 1;

        if (wantedNumber == 1) {
            newNumber = someNum1;
        } else if (wantedNumber == 2) {
            newNumber = someNum2;
        } else {
            for (int i = 0; i < wantedNumber; ++i) {
                newNumber = someNum1;
                int sum = someNum1 + someNum2;
                someNum1 = someNum2;
                someNum2 = sum;
                System.out.println();
            }

        }
        return newNumber;
    }
}