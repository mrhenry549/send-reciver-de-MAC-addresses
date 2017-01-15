package pt.atec.network;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import pt.atec.macgen.Gerador;

public class MACServer {

    private final int PORTO = 9983;
    
    PrintWriter out;
    BufferedReader in;
    Gerador gen;

    public MACServer() {
        gen = new Gerador();

        try {
            ServerSocket ssoc = new ServerSocket(PORTO);

            Socket client = ssoc.accept();

            out = new PrintWriter(client.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String inputLine, outputLine;

        String greet = gen.randomMACAddress();

        try {
            out.println("bom dia");
            
            inputLine = in.readLine();

            System.out.println(inputLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
