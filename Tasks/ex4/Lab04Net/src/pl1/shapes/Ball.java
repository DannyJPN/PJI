/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl1.shapes;
import pl1.canvas.Canvas;
import pl1.types.*;
/**
 *
 * @author Dan Krupa
 */
public class Ball  {
    
    public Ellipse ball;
    public Direction8 dir;
    public Ball(int x,int y,int r,MyColor col,Direction8 d)
    {
        ball = new Ellipse(x,y,2*r,2*r,col);
      dir = d;
        
    }
    
    public void Move(int distance)
    {
        
        
        switch(dir)
        {
            case SOUTHEAST:{
                if(ball.getX()+ball.getWidth()>Canvas.getInstance().getWidth() )
                {
                dir = Direction8.SOUTHWEST;
                }
                if(ball.getY()+ball.getHeight()>Canvas.getInstance().getHeight() )
                {
                dir = Direction8.NORTHEAST;
                }
                
                
               
                
                break;}
              
           case NORTHEAST:{
                if(ball.getX()+ball.getWidth()>Canvas.getInstance().getWidth() )
                {
                dir = Direction8.NORTHWEST;
                }
                if(ball.getY()<0 )
                {
                dir = Direction8.SOUTHEAST;
                }
                
                
              
                
                break;}
             case SOUTHWEST:{
                if(ball.getX()<0 )
                {
                dir = Direction8.SOUTHEAST;
                }
                if(ball.getY()+ball.getHeight()>Canvas.getInstance().getHeight() )
                {
                dir = Direction8.NORTHWEST;
                }
                
                
              
                
                break;}
             case NORTHWEST:{
                if(ball.getX()<0 )
                {
                dir = Direction8.NORTHEAST;
                }
                if(ball.getY()<0 )
                {
                dir = Direction8.SOUTHWEST;
                }
                
                
             
                
                break;}
             
            
            
            
        }
        
         switch(dir)
        {
            case SOUTHEAST:{
                
                //ball = new Ellipse(ball.getX()+distance,ball.getY()+distance,ball.getHeight(),ball.getWidth(),ball.getColor());
                ball.moveDown(distance);ball.moveRight(distance);
                
                break;}
              
           case NORTHEAST:{
              
                
                //ball = new Ellipse(ball.getX()-distance,ball.getY()+distance,ball.getHeight(),ball.getWidth(),ball.getColor());
                ball.moveDown(-distance);ball.moveRight(distance);
                
                break;}
             case SOUTHWEST:{
               
               // ball = new Ellipse(ball.getX()+distance,ball.getY()-distance,ball.getHeight(),ball.getWidth(),ball.getColor());
                ball.moveDown(distance);ball.moveRight(-distance);
                
                break;}
             case NORTHWEST:{
               
              //  ball = new Ellipse(ball.getX()-distance,ball.getY()-distance,ball.getHeight(),ball.getWidth(),ball.getColor());
                ball.moveDown(-distance);ball.moveRight(-distance);
                
                break;}
             
            
            
            
        }
        
        
        
    }
    
    
}
