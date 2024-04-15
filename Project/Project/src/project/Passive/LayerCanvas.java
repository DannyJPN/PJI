/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Passive;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import project.Interfaces.IVisuallyChangable;
import project.Shapes.BackGround;
import project.Shapes.Brick;
import project.Shapes.Bullet;
import project.Shapes.Point;
import project.Shapes.ShooterOrb;



/**
 *
 * @author OEM
 */
public class LayerCanvas extends Pane
{
   
    private static final double DefaultXcoor = 0;
    private static final double DefaultYcoor = 0;
    private static final int DefaultLayerCount = 1;
    private static final double DefaultWidth = 300;
    private static final double DefaultHeight = 300;
    
    private double width,height,x,y;
    private int layercount;
    private List<Canvas> layers;
    private List<Brick> bricks;
    private Bullet bullet;
    
    private static final int BKGLAYER = 0;
    private static final int BRICKLAYER = 1;
    private static final int ORBLAYER = 2;
    private BackGround bckg;
    private ShooterOrb shooter;
    private ColorGenerator colgen;
    
    public LayerCanvas( )
    {
        this(DefaultXcoor,DefaultYcoor,DefaultLayerCount,DefaultWidth,DefaultHeight);
  
      
    }
    public LayerCanvas(double initx,double inity, int layernum,double width,double height)
    {
        this.x=initx;
        this.y=inity;
        this.width = width;
        this.height = height;
        layercount = layernum;
        layers = new ArrayList();
        bricks = new ArrayList();
        
        for(int i =0;i<layercount;i++)
        {
            layers.add(new Canvas(this.width,this.height));
            layers.get(i).setTranslateX(this.x);
            layers.get(i).setTranslateY(this.y);
            layers.get(i).setTranslateZ(i);
        }
    colgen = new ColorGenerator(Color.rgb(255, 0, 0), Color.rgb(0, 255, 0),Color.rgb(0, 0, 255)); 
             //layers.get(ORBLAYER).setOnMouseClicked(e -> produceBullet(e));  
    }
    
    
    public void setX(double x)
    {
        this.x=x;
    }
    public void setY(double y)
    {
        this.y=y;
    }
    @Override
    public void setWidth(double width)
    {
        this.width=width;
    }
    @Override
    public void setHeight(double height)
    {
        this.height=height;
    }
    
    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }
    public double getCanvWidth()
    {
        return width;
    }
    public double getCanvHeight()
    {
        return height;
    }
    
    
    
    public void addLayer(Canvas l)
    {
     layers.add(l);
    }
    public void addLayer(int index,Canvas l)
    {
     layers.add(index,l);
    }
    public void removeLayer(int index)
    {
     layers.remove(index);
    }
    public void removeLayer(Canvas l)
    {
     layers.remove(l);
    }

    public Canvas getLayer(int index) 
    {
        return layers.get(index);
    }
     public List<Canvas> getLayers() 
    {
        return layers;
    }
    public int getLayerCount() 
    {
        return layers.size();
    }
    
    
    public void addBrick(Brick b)
    {
     bricks.add(b);
    }
    public void addBrick(int index,Brick b)
    {
     bricks.add(index,b);
    }
    public void removeBrick(int index)
    {
     bricks.remove(index);
    }
    public void removeBrick(Brick b)
    {
     bricks.remove(b);
    }

    public Brick getBrick(int index) 
    {
        return bricks.get(index);
    }
    public List<Brick> getBricks() 
    {
        return bricks;
    }
    public int getBrickCount() 
    {
        return bricks.size();
    }
    public double getLowestBrickLevel()
    {
        double lowest=0;
        for(int i = 0;i<getBrickCount();i++)
        {
            if(getBrick(i).getBottom() >=lowest)
            {
                lowest = getBrick(i).getBottom() ;
            }
        }
        return lowest;
    }            
            
            
    public void draw(IVisuallyChangable shape)
    {
        
        shape.draw();
            
          
        
        
    }
    public void erase(IVisuallyChangable shape)
    {
        shape.erase();
    }

    public void drawLayer(int z) 
    {
        switch(z)
        {
            case BRICKLAYER:
            {
                for(int i = 0;i<getBrickCount();i++)
                {
                    getBrick(i).draw();
                
                }
                break;
            }
            
            case BKGLAYER:
            {
                if(bckg!=null)
                {
                    bckg.draw();
                }
                break;
            }
            case ORBLAYER:
            {
                if(shooter!=null)
                {
                    shooter.draw();
                }
                if(bullet!=null)
                {
                    bullet.draw();
                }
                break;
            }
            default:break;
        
        
        
        }
    }
     public void eraseLayer(int z) 
    {
        Canvas layer = layers.get(z);
        layer.getGraphicsContext2D().clearRect(0,0, layer.getWidth(), layer.getHeight());
    }
     
    public void repaintLayer(int z)
    {
        eraseLayer(z);
        drawLayer(z);
    
    }

    public void setBackGround(BackGround bkg) 
    {
        bckg = bkg;
    }
    public void removeBackGround() 
    {
        bckg = null;
    }
    public BackGround getBackGround()
    {
        return bckg;
    }

    public void initializeBricks(int difficulty)
   {
           Brick br;
            int brick_per_line = 15;
            double brickheight = getCanvHeight()/brick_per_line;
            double brickwidth = getCanvWidth()/brick_per_line;
            System.out.println("Height:"+brickheight+"\tWidth:"+brickwidth );
            for(int j = 0;j>-(10+5*difficulty);j--)
            {
                for(int i = 0;i<brick_per_line;i++)
                {
                   br = new Brick(i*brickwidth,j*brickheight,BRICKLAYER,brickwidth,brickheight,colgen.getRandomColor());
                   br.setPaintContext(getLayer(BRICKLAYER).getGraphicsContext2D());
                   //System.out.println(i*paintsystem.getCanvWidth()/10 + "\t Color = "+bkg.getFill());
                   
                
                    LayerCanvas.this.addBrick(br);
                 }
            }
   }
    
    public void moveBricks()
   {
       Brick brick;
       
           for(int i = 0;i<getBrickCount();i++)
           {
               brick =getBrick(i);
            
               //System.out.println(((Brick)(brick)).getName());
               
                brick.move();
               //System.out.println(brick.getX() +" " + brick.getY());
           }
           
       
            
   }
    
    public void flushBricks() 
    {
        if(!bricks.isEmpty())
        {
            bricks.clear();
        }
        repaintLayer(BRICKLAYER);
    }

    public void setShooterOrb(ShooterOrb sho) 
    {
        shooter = sho;
        shooter.setFill(colgen.getRandomColor());
    }
    public void removeShooterOrb() 
    {
        shooter = null;
    }
    public ShooterOrb getShooterOrb()
    {
        return shooter;
    } 
    
    public void produceBullet(Point clickpoint)
    {

        if(bullet != null || shooter ==null)
        {
            return;
        }
        bullet = shooter.shoot();
        bullet.setPaintContext(getLayer(ORBLAYER).getGraphicsContext2D());
        double dx = clickpoint.getX() - bullet.getCenterX();
        double dy = clickpoint.getY() - bullet.getCenterY();
        double dist =  Math.sqrt((dx*dx+dy*dy));
        double sin = dy/dist;
        double cos = dx/dist;
        
        bullet.setHorizontalSpeed(10*cos);
        bullet.setVerticalSpeed(10*sin);
        System.out.println("Speeds are X: "+cos+"/tY: "+sin);
        shooter.setFill(colgen.getRandomColor());
        
    }

    public void removeBullet() 
    {
        bullet=null;
    }

    public void moveBullet()
    {
        bullet.move();
    }

    public Bullet getBullet() 
    {
        return bullet;
    }
    public int bulletHasHitBrick()
    {
        boolean left,right,bottom,top;
        for(int i =0;i<getBrickCount();i++)
        {
            bottom =  getBullet().getTop()<=getBrick(i).getBottom() &&getBullet().getTop()>=getBrick(i).getTop() ;
            top =  getBullet().getBottom()<=getBrick(i).getBottom() &&getBullet().getBottom()>=getBrick(i).getTop() ;
            left = getBullet().getLeft()<=getBrick(i).getRight() &&getBullet().getLeft()>=getBrick(i).getLeft();
            right = getBullet().getRight()<=getBrick(i).getRight() &&getBullet().getRight()>=getBrick(i).getLeft();
            
            if((bottom||top)&&(left||right))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    
}
