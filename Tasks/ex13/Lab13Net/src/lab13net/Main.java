/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab13net;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan Krupa
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
       FileReader fr = null;
        try {
            fr = new FileReader("../testfile.txt");
            String content="";
            int check;
            CharBuffer buf=CharBuffer.allocate(1024);
            while((check = fr.read(buf)) != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    content+=buf.get();
                }
                buf.clear();
            }   
            fr.close();
            System.out.println(content);
           }
        catch (FileNotFoundException ex) 
        {
                System.out.println(ex.toString());
        }
        catch (IOException ex) 
        {
                System.out.println(ex.toString());
        }
           
           
    }
    
}
