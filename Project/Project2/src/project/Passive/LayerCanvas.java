/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Passive;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.shape.Shape;
import project.Shapes.Rectangle;


/**
 *
 * @author OEM
 */
public class LayerCanvas {
   
    private double width,height,x,y;
    private int layercount;
    private List<Canvas> layers;
    private List<Shape> shapes;
    public LayerCanvas( )
    {
        this(0,0,1,500.0,500.0);
  
      
    }
    public LayerCanvas(double initx,double inity, int layernum,double width,double height)
    {
     this.x=initx;
     this.y=inity;
       this.width = width;
        this.height = height;
        layercount = layernum;
        layers = new ArrayList();
        shapes = new ArrayList();
        for(int i =0;i<layercount;i++)
        {
            layers.add(new Canvas(this.width,this.height));
            layers.get(i).setTranslateX(this.x);
            layers.get(i).setTranslateY(this.y);
            layers.get(i).setTranslateZ(i);
        }
        
    }
    
    public void AddLayer(Canvas l)
    {
     layers.add(l);
    }
    public void AddLayer(int index,Canvas l)
    {
     layers.add(index,l);
    }
    public void RemoveLayer(int index)
    {
     layers.remove(index);
    }
    public void RemoveLayer(Canvas l)
    {
     layers.remove(l);
    }

    public Canvas GetLayer(int index) 
    {
        return layers.get(index);
    }
     public List<Canvas> GetLayers() 
    {
        return layers;
    }
    public int GetLayerCount() 
    {
        return layers.size();
    }
    
    
    public void AddShape(Shape s)
    {
     shapes.add(s);
    }
    public void AddShape(int index,Shape s)
    {
     shapes.add(index,s);
    }
    public void RemoveShape(int index)
    {
     shapes.remove(index);
    }
    public void RemoveShape(Shape s)
    {
     shapes.remove(s);
    }

    public Shape GetShape(int index) 
    {
        return shapes.get(index);
    }
    public List<Shape> GetShapes() 
    {
        return shapes;
    }
    public int GetShapeCount() 
    {
        return layers.size();
    }
  
    public void Draw(Shape shape)
    {
        if(shape instanceof Rectangle)
        {
        ((Rectangle)(shape)).Draw(layers.get(((Rectangle)(shape)).getZ()).getGraphicsContext2D());
            
          
        
        }
        else
        {
        System.out.println("ERROR");
        }
    }
    public void Erase(Shape shape)
    {
        if(shape instanceof Rectangle)
        {
        layers.get(((Rectangle)(shape)).getZ()).getGraphicsContext2D().clearRect(((Rectangle)(shape)).getX() ,((Rectangle)(shape)).getY()  ,((Rectangle)(shape)).getWidth() , ((Rectangle)(shape)).getHeight() );
        
        }
        else
        {
        System.out.println("ERROR");
        }
    }
    
     

    
    
    
    
    
    
}
