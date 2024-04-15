/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj1.zt02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

/**
 *
 * @author Dan Krupa
 */
public class Main 
{
    public static void main(String[] args) throws IOException 
    {
       OsobniAuto ou = new OsobniAuto("SKoda");
        ou.transportuj();
        BalikSlov bs = new PevnyBalikSlov();
       System.out.println( bs.zjistiPocetSlov());
        //bs.tiskniPoctySouhlasek();
        BalikSlovZeSouboru bss = new BalikSlovZeSouboru("../Faust-Goethe.txt");
       
        Collection<String> wordy =  bs.vratSlovaPodleSouhlasek();
       
        for(int i = 0;i<wordy.size();i++)
       {
             System.out.println(wordy.toArray()[i].toString());
       }
        
       System.out.println( bss.zjistiPocetSlov());
         OpenPage("https://docs.oracle.com/javase/tutorial");
        Pair<NakladniAuto,Integer> duo = new Pair<>();
        duo.setVal1(new NakladniAuto("Tatra"));
        duo.setVal2(660);
    
    
    
    }
    public static void OpenPage(String name) throws MalformedURLException, IOException
    {
    
    URL url = new URL(name);
    
    
      URLConnection con = url.openConnection();
      
      
      
     Scanner sc =  new Scanner (new BufferedReader(new InputStreamReader(con.getInputStream())));
            OutputStreamWriter  bfwrite =new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream("out.html.gz")));
           
            while(sc.hasNext())
            {
                String elem = sc.next();
                bfwrite.write(elem,0,elem.length());
            }
            
            sc.close();
            bfwrite.close();
    
    }
    
    
    
    
}
