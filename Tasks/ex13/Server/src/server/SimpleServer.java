/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dan Krupa
 */
public class SimpleServer 
{
    ServerSocket server; 
    String message = "Hello from server!";   
    public void run()
    { 
        try
            {   
                server = new ServerSocket(5432, 5);
            
            
            
             
        listen();
            } 
        catch (Exception e) 
        {  }  
        
    }
     protected void listen()
     { 
         try {    
             while(true) 
             { 
                 Socket client = server.accept();        
                   ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());     
                   out.writeObject(message);             
                   out.close();        
                   client.close(); 
             }
         }
         catch (Exception e) { }     
     } 
}
