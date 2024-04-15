/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.kozusznik.pl1.shapes.tools;

/**
 *
 * @author Stanislav
 */
public class Transformer
{
  
    public  void transform(ITransformable shape,double x,double y,double factor)
    {
      new Thread() 
        {
      @Override
      public void run() {
        
        doTransforming(shape, x, y,factor);
       
         }

    }.start();
        
        
        
    }
    private  void doTransforming(ITransformable sh, double x, double y,double factor) {
      
      try {
     
      int movestep = 1;
      int sizestep =1;
      
      int finalw = (int)(sh.getWidth()*factor);
      int finalh = (int)(sh.getHeight()*factor);
      
      while(sh.getX()!=x && sh.getY()!=y  &&sh.getHeight() != finalh && sh.getWidth() != finalw )
          {
              Thread.sleep(10);
                if(sh.getX()>x)
                {
                sh.moveRight(-movestep);
                }
                else if(sh.getX()<x)
                {
                sh.moveRight(movestep);
                }
                 if(sh.getY()>y)
                {
                sh.moveDown(-movestep);
                }
                else if(sh.getY()<y)
                {
                sh.moveDown(movestep);
                }
              if(sh.getWidth()>finalw)
              {
                  sh.setWidth( sh.getWidth() -sizestep);
              }
              else if(sh.getWidth()<finalw)
              {
                  sh.setWidth( sh.getWidth() +sizestep);
              }
              if(sh.getHeight()>finalh)
              {
                  sh.setHeight( sh.getHeight() -sizestep);
              }
              else if(sh.getHeight()<finalh)
              {
                  sh.setHeight( sh.getHeight() +sizestep);
              }
                 
                 
                 
                 
                
          }
         
           while(sh.getX()!=x )
          {
              Thread.sleep(10);
                if(sh.getX()>x)
                {
                sh.moveRight(-movestep);
                }
                else if(sh.getX()<x)
                {
                sh.moveRight(movestep);
                }
             
                
          }
         
         while(sh.getY()!=y )
          {
              Thread.sleep(10);
                if(sh.getY()>y)
                {
                sh.moveDown(-movestep);
                }
                else if(sh.getY()<y)
                {
                sh.moveDown(movestep);
                }
             
                
          }
         
             /*
            while( sh.getHeight() != finalh && sh.getWidth() != finalw)
            {
              Thread.sleep(10);
              if(sh.getWidth()>finalw)
              {
                  sh.setWidth( sh.getWidth() -sizestep);
              }
              else if(sh.getWidth()<finalw)
              {
                  sh.setWidth( sh.getWidth() +sizestep);
              }
              if(sh.getHeight()>finalh)
              {
                  sh.setHeight( sh.getHeight() -sizestep);
              }
              else if(sh.getHeight()<finalh)
              {
                  sh.setHeight( sh.getHeight() +sizestep);
              }
                  
                 
             }*/
             
            while( sh.getHeight() != finalh )
            {
              Thread.sleep(10);
              if(sh.getHeight()>finalh)
              {
                  sh.setHeight( sh.getHeight() -sizestep);
              }
              else if(sh.getHeight()<finalh)
              {
                  sh.setHeight( sh.getHeight() +sizestep);
              }
                  
                 
            }
            
            while( sh.getWidth() != finalw )
            {
              Thread.sleep(10);
              if(sh.getWidth()>finalw)
              {
                  sh.setWidth( sh.getWidth() -sizestep);
              }
              else if(sh.getWidth()<finalw)
              {
                  sh.setWidth( sh.getWidth() +sizestep);
              }
                  
                 
            } 
         
         
         
         
         
         
         
         
         
         
      
        } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

      
    //TODO zde bude kod pro volání objektu, který zajistí animaci
  };

    

}
