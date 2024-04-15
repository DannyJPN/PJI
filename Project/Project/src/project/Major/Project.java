/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Major;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import project.Passive.LayerCanvas;
import project.Shapes.BackGround;
import project.Shapes.Brick;
import project.Shapes.Bullet;
import project.Shapes.Point;
import project.Shapes.ShooterOrb;


/**
 *
 * @author OEM
 */


public class Project extends Application
{
    private Thread brickmover,bulletthread; 
    private LayerCanvas paintsystem;
    private static final int BKGLAYER = 0;
    private static final int BRICKLAYER = 1;
    private static final int ORBLAYER = 2;
    @FXML
    private  TextField difficulty;
    boolean paused = false;
    private int level;
    
    private Point clickpoint;
    
    @Override
    public void start(Stage primaryStage) throws InterruptedException, IOException
    {
       
        initializeEnvironment(primaryStage);
     
         
             
        
          
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
       
        
    }
    
    @FXML
   synchronized private void startGame(ActionEvent event)
    {
       
       try
       {
       
           level = Integer.parseInt(difficulty.getText());
           
       }
       catch(NumberFormatException ex)
       {
           level = 1;
       }
    
       if(level<0)
       {
           level = 1;
       } 
    System.out.println("NewGame buton pressed");
    System.out.println();
    
    
    if(brickmover !=null)
        {
            brickmover.interrupt();
    
            brickmover = null;
            System.out.println("Interrupted");
            
        paintsystem.flushBricks();
        paintsystem.repaintLayer(BRICKLAYER);
        }
    
    
    paintsystem.initializeBricks(level);
    paintsystem.repaintLayer(BRICKLAYER);
    paintsystem.setShooterOrb(new ShooterOrb(paintsystem.getCanvWidth()/2,paintsystem.getCanvHeight(),ORBLAYER,30,30));
    paintsystem.getShooterOrb().setPaintContext(paintsystem.getLayer(ORBLAYER).getGraphicsContext2D());
    paintsystem.repaintLayer(ORBLAYER);
    
      startBricksThread();
    }
   
   
   @FXML
    private void loadGame(ActionEvent event)
    {
    System.out.println("LoadGame buton pressed");
    stopBricksThread();
    
    if(brickmover !=null)
        {
            brickmover.interrupt();
    
            brickmover = null;
            System.out.println("Interrupted");
            
        paintsystem.flushBricks();
        paintsystem.repaintLayer(BRICKLAYER);
        }
    
       
        BufferedReader brickload = null;
        BufferedReader levelload = null;
        try {
                brickload = new BufferedReader(new FileReader("saved_game.csv"));
                levelload = new BufferedReader(new FileReader("level.csv"));
               String line;
               String[] elements;
                while( (line = brickload.readLine()) !=null)
               {
                   elements = line.split(";");
                   if(elements.length!=8)
                   {
                       System.out.println("FILE CORRUPTED");
                       return;
                   }
                   try
                   {
                       Color col =Color.rgb(Integer.parseInt(elements[5]),Integer.parseInt(elements[6]),Integer.parseInt(elements[7]));
                           Brick b = new Brick(Double.parseDouble(elements[1]),Double.parseDouble(elements[2]),BRICKLAYER,Double.parseDouble(elements[4]),Double.parseDouble(elements[3]),col);
                           b.setPaintContext(paintsystem.getLayer(BRICKLAYER).getGraphicsContext2D());
                           paintsystem.addBrick(Integer.parseInt(elements[0]),b);
                           
                           
                       
                   }
                   catch(NumberFormatException e)
                   {
                       System.out.println("FILE CORRUPTED FORMAT");
                   
                   }
               }
                
                String lev = levelload.readLine();
                try
                {
                    level = Integer.parseInt(lev);
                }
                catch(NumberFormatException e)
                {
                       System.out.println("FILE CORRUPTED FORMAT LEVEL");
                
                }
                 brickload.close();
                 levelload.close();
                 
            } catch (IOException ex) 
            {
               System.out.println("File location invalid");
            }
           System.out.println("Game Loaded!");
            
    
    
    
    
    paintsystem.repaintLayer(BRICKLAYER);
    paintsystem.setShooterOrb(new ShooterOrb(paintsystem.getCanvWidth()/2,paintsystem.getCanvHeight(),ORBLAYER,20,20));
    paintsystem.getShooterOrb().setPaintContext(paintsystem.getLayer(ORBLAYER).getGraphicsContext2D());
    paintsystem.repaintLayer(ORBLAYER);
    
    startBricksThread();
    }
    
  
   
   
   
    @FXML
    private void stopGame(ActionEvent event)
    {
        
            System.out.println("StopGame buton pressed");
         paused = !paused;
    
    }
    
    
    @FXML
   private void quitGame(ActionEvent event)
    {
        if(paintsystem.getShooterOrb()!=null)
        {
            saveGame(event);
        
        }
        System.exit(0);
    }
    @FXML
    synchronized private void saveGame(ActionEvent event)
    {
           boolean paused_orig = paused;
        FileWriter bricksave = null;
        FileWriter levelsave = null;
        try {
            paused = true;
                bricksave = new FileWriter("saved_game.csv",false);
                levelsave = new FileWriter("level.csv",false);
               for(int i=0;i<paintsystem.getBrickCount();i++)
                {
                    
                 bricksave.write(i+";");
                 bricksave.write(paintsystem.getBrick(i).getX()+";");
                 bricksave.write(paintsystem.getBrick(i).getY()+";");
                 bricksave.write(paintsystem.getBrick(i).getHeight()+";");
                 bricksave.write(paintsystem.getBrick(i).getWidth()+";");
                 bricksave.write((int) (((Color)(paintsystem.getBrick(i).getFill())).getRed()*255)+";");
                 bricksave.write((int) (((Color)(paintsystem.getBrick(i).getFill())).getGreen()*255)+";");
                 bricksave.write((int) (((Color)(paintsystem.getBrick(i).getFill())).getBlue()*255)+"\n");
                 
                }  
                 bricksave.close();
                 levelsave.write(level+"\n");
                 levelsave.close();
                 
            } catch (IOException ex) 
            {
               System.out.println("File location invalid");
            }
           System.out.println("Game Saved!");
            paused = paused_orig;
    }
   
   
   private void initializeEnvironment(Stage stage) throws IOException
   {
       
       
        StackPane root = new StackPane();
         root.setPrefWidth(1000);
         root.setPrefHeight(1000);
         
         
         Scene scene = new Scene(root,root.getPrefWidth()-160,root.getPrefHeight()-300);
        stage.setTitle("Shooter");
        stage.setScene(scene);
        stage.show();
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.setOnCloseRequest((WindowEvent t) -> {System.exit(0);});
        Parent fxml = getFXML("manipulation_panel.fxml").load();
        StackPane.setAlignment(fxml,Pos.TOP_LEFT);
        root.getChildren().add(fxml);
        initializePaintingSystem(root);
   }
   
   
   
   private FXMLLoader getFXML(String fxml_filename)
   {
   
         
             FXMLLoader fxmlload= new FXMLLoader(getClass().getResource(fxml_filename));
             fxmlload.setControllerFactory(___ -> Project.this);
            return fxmlload;
            
        
         
         
   }
   
   private void initializePaintingSystem(StackPane root)
   {
       
        this.paintsystem = new LayerCanvas(160,0,3,root.getWidth()-20-160,root.getHeight()-20);
        
        for(int i =0;i<paintsystem.getLayerCount();i++)
        {
            root.getChildren().add(paintsystem.getLayer(i)); 
            StackPane.setAlignment(paintsystem.getLayer(i),Pos.TOP_LEFT);
        
        }
        BackGround bkg=new BackGround(paintsystem.getLayer(BKGLAYER).getWidth(),paintsystem.getLayer(BKGLAYER).getHeight(),Color.BLANCHEDALMOND);
        bkg.setPaintContext(paintsystem.getLayer(BKGLAYER).getGraphicsContext2D());
        paintsystem.setBackGround(bkg);
       
       paintsystem.drawLayer(BKGLAYER);
       
             paintsystem.getLayer(ORBLAYER).setOnMouseClicked(e -> emitBullet(e));
   }

    synchronized private void startBricksThread()
    {
         brickmover = new Thread() 
       {
       
        @Override
        public void run() 
        {
            //double steps = (paintsystem.getCanvHeight()-(paintsystem.getBrick(0)).getCanvHeight() - paintsystem.getShooterOrb().getCanvHeight()/2)/paintsystem.getBrick(0).getVerticalSpeed();
            try {
                
            while(paintsystem.getLowestBrickLevel()<=paintsystem.getShooterOrb().getTop())
            {
                //System.out.println(steps);
                if(!paused)
                {
                
                paintsystem.moveBricks();
                paintsystem.repaintLayer(BRICKLAYER);
               
                
                    Thread.sleep(1000 - (level-1)*50);
                
                   // System.out.println("THREAD BLOCKED");
                }
                 //   System.out.println("THREAD Moved");
                
                
                
            }
                }
            catch (InterruptedException ex) 
                {
                    System.out.println("Nechcou cihly usnout když lowest level ="+paintsystem.getLowestBrickLevel());
                }
                
            paintsystem.removeShooterOrb();
            String msg = paintsystem.getBrickCount()==0?"YOU WON!!":"GAME OVER";
            System.out.println(msg);
        }
     };
      brickmover.start();
    }

  synchronized private void stopBricksThread() 
    {
        if(brickmover!=null)
        {
            System.out.println("STOPTHREAD CALLED");
            //brickmover.wait(2000);
            brickmover.interrupt();
        }
       
    }

   private void emitBullet(MouseEvent e)
   {
       if(paintsystem.getShooterOrb()!=null)
       {
       clickpoint = new Point(e.getX(),e.getY());
        paintsystem.produceBullet(clickpoint);
        paintsystem.repaintLayer(ORBLAYER);
        guideBullet();
       }
   }

    synchronized private void guideBullet() 
    {
        bulletthread = new Thread()
        {
            @Override
            public void run()
            {
                    Bullet bullet = paintsystem.getBullet();
                 //  System.out.println("Movement started: \t"+bullet.getCenterX()+"\t"+bullet.getCenterY());
                    
            try
            {
                int hitbrick = -1;
                    while((hitbrick = paintsystem.bulletHasHitBrick()) ==-1 && bullet.getTop()<paintsystem.getCanvHeight())
                    {
                        paintsystem.moveBullet();
                        paintsystem.repaintLayer(ORBLAYER);
                   //     System.out.println("Movement to: \t"+bullet.getCenterX()+"\t"+bullet.getCenterY());
                        
                        Thread.sleep(5);
                        if(bullet.getLeft()<=0 || bullet.getRight()>=paintsystem.getCanvWidth())
                        {
                            bullet.setHorizontalSpeed(bullet.getHorizontalSpeed()*(-1));
                        }
                        if(bullet.getTop()<=0)
                        {
                         bullet.setVerticalSpeed(bullet.getVerticalSpeed()*(-1));
                        }
                        
                        
                   }
                    
                   // System.out.println("Movement finished: \t"+bullet.getCenterX()+"\t"+bullet.getCenterY());
                    System.out.println("Brick hit = "+hitbrick);
                boolean redmatch=     ((Color)(bullet.getFill())).getRed()==((Color)(paintsystem.getBrick(hitbrick).getFill())).getRed() ;
                boolean greenmatch=       ((Color)(bullet.getFill())).getGreen()==((Color)(paintsystem.getBrick(hitbrick).getFill())).getGreen() ;
               boolean bluematch=       ((Color)(bullet.getFill())).getBlue()==((Color)(paintsystem.getBrick(hitbrick).getFill())).getBlue() ;
                            
                    
                    
                    if(hitbrick!=-1&&redmatch&&greenmatch&&bluematch)
                    {
                        paintsystem.removeBrick(hitbrick);
                    }
                    paintsystem.removeBullet();
                    paintsystem.repaintLayer(ORBLAYER);
                    paintsystem.repaintLayer(BRICKLAYER);
                    
            }
            catch (InterruptedException ex) 
                {
                    System.out.println("Nechce kulka usnout když X ="+paintsystem.getBullet().getCenterX()+"a Y = "+paintsystem.getBullet().getCenterY());
                }
                 
            }
        };
        bulletthread.start();
    }
   
   
    
}
