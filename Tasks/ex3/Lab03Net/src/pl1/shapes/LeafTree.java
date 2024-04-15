package pl1.shapes;

import static java.lang.Math.*;
import java.util.ArrayList;
import java.util.Random;
import pl1.types.MyColor;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author OEM
 */
public class LeafTree
{
 Rectangle hitbox;
 Rectangle trunk;
 ArrayList <Ellipse> leaves;
 int width,height,trunkwidth,trunkheight;
 MyColor leafcolor,trunkcolor;
  int x,y;
  int leafdiameter;
  Ellipse leafhitbox;
 public LeafTree(int xcoor,int ycoor,int w,int h,int tw,int th,int leafdiam,MyColor colorleaf,MyColor colortrunk) throws InterruptedException
 {
     x=xcoor;
     y=ycoor;
     width =w;
     height = h;
     trunkwidth = tw;
     trunkheight = th;
     leafcolor = colorleaf; 
     trunkcolor = colortrunk;
     leafdiameter = leafdiam;
     hitbox = new Rectangle(x,y,width,height,MyColor.NONE);
     trunk = new Rectangle(x+width/2-trunkwidth/2,y+height-trunkheight,trunkwidth,trunkheight,trunkcolor);
     leafhitbox = new Ellipse(x,y,width,height - trunkheight,colorleaf);
     leaves = new ArrayList<>();
     Random n = new Random();
     int lcx,lcy;
     int a = leafhitbox.getWidth()/2, b = leafhitbox.getHeight()/2;
     double cx = leafhitbox.getCentralX(),cy= leafhitbox.getCentralY();
    //System.out.println("CX = "+cx+" \tCY = "+cy+" ");
       
     for(int i = 0;i < (Math.PI*a*b)/((Math.PI*pow(leafdiam/2,2))/3);i++)
     {
     
        do
        {
         
         lcx = n.nextInt(leafhitbox.getWidth()+leafhitbox.getX());
         lcy = n.nextInt(leafhitbox.getHeight()+leafhitbox.getY()) ;
         
         //System.out.println(i+".\tLCX = "+lcx+" \tLCY = "+lcy);
        
         //System.out.println("F2 = "+pow((lcx-cx)/a,2)+" \tS2 = "+pow((lcy-cy)/b,2)+"\t Sum = "+(pow((lcx-cx)/a,2)+ pow((lcy-cy)/b,2)));

         
        }while((pow((lcx-cx)/a,2)+ pow((lcy-cy)/b,2)) >1);
        //System.out.println("X:"+(lcx-leafdiameter/2)+"\tY:"+(lcy-leafdiameter/2));
     //leaves.add(new Ellipse(lcx-leafdiameter/2,lcy-leafdiameter/2,leafdiameter,leafdiameter,leafcolor));
     //System.out.println("END");
     //Thread.sleep(500);
     }
    

 }
    
 
 public void erase()
 {
 hitbox.erase();
 trunk.erase();
 leafhitbox.erase();
 for(int i = 0; i<leaves.size();i++)
 {
 leaves.get(i).erase();
 }
 
 
 
 }
     
 public void paint()
 {
 hitbox.paint();
 trunk.paint();
 leafhitbox.paint();
 for(int i = 0; i<leaves.size();i++)
 {
 leaves.get(i).paint();
 }
 
 
 
 }
    
}
