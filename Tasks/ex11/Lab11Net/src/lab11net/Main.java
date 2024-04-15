    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab11net;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

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
        int c;
        String infile = "../Faust-Goethe.txt";
        String numfile = "../doubles.txt";
            InputStream input = null;
            OutputStream output = null;
            Reader r = null;
            Writer w = null;
            GZIPOutputStream gout = null;
            BufferedReader bfread = null;
            BufferedWriter bfwrite = null;
            Scanner sc = null;
            Scanner scnum = null;
            
            
        try {    
            input = new FileInputStream(infile);
            output = new FileOutputStream("Goethe-copy.txt");
            
            while( (c = input.read() ) != -1)
            {
                output.write(c);
            }
            
            input.close();
            output.close();
             } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
         try{   
            input = new FileInputStream(infile);
            output = new FileOutputStream("Goethe-copyblock.txt");
            byte[] buffer = new byte[1024*1024];
            while( (c = input.read(buffer)) != -1)
            {
                output.write(buffer,0,c);
            }
            
            input.close();
            output.close();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try{    
            r = new FileReader(infile);
            w = new FileWriter("Goethe-copyCASE.txt");
            CharBuffer ch = CharBuffer.allocate(1024);
            while( (c = r.read(ch)) != -1)
            {
                ch.flip();
                while(ch.hasRemaining())
                {
                    char x = Character.toUpperCase(ch.get());
                    
                    w.write(x);
                }
                ch.clear();
                
            }
            
            r.close();
            w.close();
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{    
            input =new FileInputStream(infile);
            gout =new GZIPOutputStream(new FileOutputStream("Goethe.gz"));
            
           byte[] buffer = new byte[1024];
            while( (c = input.read(buffer)) != -1)
            {
                gout.write(buffer);
            }
            
            input.close();
            gout.close();
           
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{    
            bfread = new BufferedReader(new FileReader(infile));
            bfwrite =new BufferedWriter(new FileWriter("GoetheBUF.txt"));
            String line = "";
            int linecount = 0;
            while(bfread.ready())
            {
                line = (++linecount)+". " +bfread.readLine()+"\n";
                bfwrite.write(line, 0, line.length());
            }
            
            bfread.close();
            bfwrite.close();
           
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*try{    
            sc = new Scanner(new BufferedReader(new FileReader(infile)));
           sc.useDelimiter("[,|-|.| ]\\s*");
            while(sc.hasNext())
            {
                System.out.println(sc.next());
            
            }
            
            sc.close();
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        try{    
           
            scnum = new Scanner(new BufferedReader(new FileReader(numfile)));
            ArrayList<Double> nums = new ArrayList<>();
            double sum = 0;
            double count = 0;
            Double el=0.0;
            while(scnum.hasNext())
            {
                el=Double.parseDouble(scnum.next().replace(',', '.'));
               
                nums.add(el);
                sum+=el;
                count++;
            }
            System.out.println(sum/count);
            scnum.close();
           
        
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
