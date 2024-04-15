/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import pl1.canvas.Canvas;
import pl1.shapes.Ellipse;
import pl1.shapes.EllipseInRectangle;

/**
 *
 * @author Dan Krupa
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
        Canvas.getInstance();
     /* EllipseInRectangle e = new EllipseInRectangle();
    
    
     for(int i = 0; i<10;i++)
     {
         Canvas.getInstance().erase();
         e.SetPosition(i*10, i*10);
         Thread.sleep(500);
         
     }*/
     
       int minx,maxx,miny,maxy,count,vectx,vecty,time;
        minx = LoadMinX();
        maxx = LoadMaxX(minx);
        miny = LoadMinY();
        maxy = LoadMaxY(miny);
        count = LoadCount();
        vectx = LoadVectorX();
        vecty = LoadVectorY();
        time = LoadTimeMillis();
        
        
        
        System.out.println("Minx: "+minx);
        System.out.println("Maxx: "+maxx);
        System.out.println("Miny: "+miny);
        System.out.println("Maxy: "+maxy);
        System.out.println("Maxy: "+count);
        System.out.println("Vectx: "+vectx);
        System.out.println("Vecty: "+vecty);
        System.out.println("Time: "+time);
    
      
        Random n = new Random();
        ArrayList<EllipseInRectangle> list = new ArrayList<>();
        for(int i = 0;i<count;i++)
        {
            int x = n.nextInt(maxx-minx)+minx;
            int y = n.nextInt(maxy-miny)+miny;
            int h = n.nextInt(30-5)+5;
            int w = n.nextInt(30-5)+5;
            
    
        
        EllipseInRectangle elinrect = new EllipseInRectangle( x,y,w,h);
        list.add(elinrect);
        }
        
        
      
        while(list.size()>0)
        {
            for(int i = 0;i<list.size();i++)
            {
                int currentx = list.get(i).getX();
                int currenty = list.get(i).getY();
                System.out.println("x: "+currentx);
                System.out.println("y: "+currenty);
            
                System.out.println("____________________________________");
                list.get(i).SetPosition(currentx+vectx ,currenty +vecty);
               
                if(currentx > Canvas.getInstance().getWidth() || currentx<0 ||currenty<0 ||currenty > Canvas.getInstance().getHeight()  )
                {
                    list.remove(i);
                }
            }
            System.out.println("List length" + list.size());
            Thread.sleep(time);
        
        }
        
        
        
        
      
        
    }
    
    
    public static int LoadMinX()
    {
        
      
        while(true)
        {
            Scanner sc = new Scanner(System.in);
        System.out.print("Insert MinX <0,canvas.width>:   ");
         try
         {
            int minx = sc.nextInt();
            if(minx <0||minx>Canvas.getInstance().getWidth())
            {
          
            System.out.println("Error in range");
            }
            else
            {
               return minx;
            }
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
           
           
         }
         
        
        }   
         
      
    }
    
     public static int LoadMaxX(int minx)
    {
     
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert MaxX <minx,canvas.width>:   ");
         try
         {
            int maxx = sc.nextInt();
            if(maxx <minx||maxx>Canvas.getInstance().getWidth())
            {
          
            System.out.println("Error in range");
            }
            else
            {
               return maxx;
            }
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    
     public static int LoadMinY()
    {
       
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert MinY <0,canvas.height>:   ");
         try
         {
            int miny = sc.nextInt();
            if(miny <0||miny>Canvas.getInstance().getHeight())
            {
          
            System.out.println("Error in range");
            }
            else
            {
               return miny;
            }
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    
     public static int LoadMaxY(int miny)
    {
     
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert MaxY <miny,canvas.height>:   ");
         try
         {
            int maxy = sc.nextInt();
            if(maxy <miny||maxy>Canvas.getInstance().getHeight())
            {
          
            System.out.println("Error in range");
            }
            else
            {
               return maxy;
            }
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    public static int LoadCount()
    {
      
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert Count <0,100>:   ");
         try
         {
            int count = sc.nextInt();
            if(count <0||count>100)
            {
          
            System.out.println("Error in range");
            }
            else
            {
               return count;
            }
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    public static int LoadVectorX()
    {
      
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert Vector X coor:   ");
         try
         {
            int vectx = sc.nextInt();
           
               return vectx;
            
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    
    
    
    public static int LoadVectorY()
    {
       
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert Vector Y coor:   ");
         try
         {
            int vecty = sc.nextInt();
           
               return vecty;
            
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    
    public static int LoadTimeMillis()
    {
    
      
        while(true)
        {Scanner sc = new Scanner(System.in);
        System.out.print("Insert time in millis >0:   ");
         try
         {
            int millis = sc.nextInt();
            if(millis <0)
            {
          
            System.out.println("Error in range");
            }
            else
            {
               return millis;
            }
          }
        catch(Exception e)
         {
              
            System.out.println("Error in format");
            
         }
         
        
        }   
         
      
    }
    
}
