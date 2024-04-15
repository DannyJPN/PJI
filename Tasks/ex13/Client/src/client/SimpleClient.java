/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Dan Krupa
 */
public class SimpleClient 
{
    public void run(String host) {
    try {
        Socket server = new Socket(host,8080);
                BufferedWriter  bw = new BufferedWriter(new OutputStreamWriter(server.getOutputStream()));
        
         
             String msg = "Kru0142";
                bw.write( msg );
                bw.newLine(); 
                bw.flush();
                
                bw.close();
            
        server.close();
    }
    catch (IOException e) 
        {
     System.out.println("Error while getting message!");
        }
    }
}

