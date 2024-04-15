/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package cz.kozusznik.pl1.shapes.manager;

import cz.kozusznik.pl1.shapes.tools.Transformer;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * @author Jan Kožusznik
 * @version 0.1
 */
public class ManipulationPanelController {

  private static AbstractShape chosen = null;
  private static final String RECTANGLE = "Obdelník";

  private static final String TRIANGLE = "Trojúhelník";

  private static final String ELLIPSE = "Elipsa";

  private ArrayList<IPaintable> createdObjects = new ArrayList<>();
  @FXML
  private ComboBox<String> toCreate;

  @FXML
  private RadioButton createRB;

  @FXML
  private RadioButton moveRB;

  @FXML
  private RadioButton modifyRB;

  @FXML
  private RadioButton deleteRB;

  @FXML
  private TextField actualX;

  @FXML
  private TextField actualY;

  @FXML
  private TextField selectedX;

  @FXML
  private TextField selectedY;

  @FXML
  private TextField multiplyFactor;

  @FXML
  private Node controlPanel;

  /**
   *
   */
  public ManipulationPanelController() {
    Platform.runLater(() -> {
      toCreate.setItems(
          FXCollections.observableArrayList(RECTANGLE, TRIANGLE, ELLIPSE));
      toCreate.setValue(RECTANGLE);
    });
  }

  public void mousePressed(MouseEvent e) {

    if (e.isPrimaryButtonDown()) 
    {
      selectedX.setText(e.getX() + "");
      selectedY.setText(e.getY() + "");
      if (createRB.isSelected()) 
      {
        createShape(e.getX(), e.getY(), toCreate.getValue());
      } 
      else if (moveRB.isSelected())
      {
        moveShape(e.getX(), e.getY());
      } 
      else if (deleteRB.isSelected())
      {
        for (IPaintable i : createdObjects) 
        {
          if (i instanceof IClickable)
          {
            IClickable cl = (IClickable) i;
            if (cl.isInBound(e.getX(), e.getY()))
            {
              createdObjects.remove(i);
              CanvasManager.getInstance().remove(i);
              break;
            }
          }
        }
      }
      else if(modifyRB.isSelected())
      {
         transformShape(e.getX(),e.getY());
      }
      
      
    }
  }

  public void mouseMoved(MouseEvent e) {
    actualX.setText(e.getX() + "");
    actualY.setText(e.getY() + "");
  }

  private void moveShape(double x, double y) {
    
      if(chosen!=null)
      {
            moveTo(chosen,x,y);
            CanvasManager.getInstance().repaint();  
            chosen =null;
      }
      else
      {
           List<IPaintable> shapes =  CanvasManager.getInstance().get();
    
             for(int i =0;i<shapes.size();i++)
             {
                if(shapes.get(i) instanceof IClickable && ((IClickable)shapes.get(i)).isInBound(x, y))
                {
                   System.out.println("Object clicked! " + i);
                   chosen = (AbstractShape)(shapes.get(i));
                    break;
             
                }
             }
      }
  
      
       
      

//TODO
    //pokud není vybrán žádný tvar:
    //   vybrat
    //jinak:
    // posunout daný tvar na specifickout pozici - zavolat metodu moveTo
    //moveTo(null, x, y);
  }

  private void doMoving(Object obj, double x, double y) {
      
      try {
     
      AbstractShape sh=null;
      if(obj instanceof Rectangle)
      {
          sh =  (Rectangle)(obj);
       
      }
      else if(obj instanceof Ellipse)
      {
          sh = (Ellipse)(obj);
        
      }
      else if(obj instanceof Triangle)
      {
         sh= (Triangle)(obj);
      
      }
      
      
         while(sh.getX()!=x && sh.getY()!=y)
          {
              Thread.sleep(10);
                if(sh.getX()>x)
                {
                sh.moveRight(-1);
                }
                else if(sh.getX()<x)
                {
                sh.moveRight(1);
                }
                 if(sh.getY()>y)
                {
                sh.moveDown(-1);
                }
                else if(sh.getY()<y)
                {
                sh.moveDown(1);
                }
                
          }
         
           while(sh.getX()!=x )
          {
              Thread.sleep(10);
                if(sh.getX()>x)
                {
                sh.moveRight(-1);
                }
                else if(sh.getX()<x)
                {
                sh.moveRight(1);
                }
             
                
          }
         
         while(sh.getY()!=y )
          {
              Thread.sleep(10);
                if(sh.getY()>y)
                {
                sh.moveDown(-1);
                }
                else if(sh.getY()<y)
                {
                sh.moveDown(1);
                }
             
                
          }
      
      
        } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

      
    //TODO zde bude kod pro volání objektu, který zajistí animaci
  };

  private void moveTo(Object obj, double x, double y) {
    new Thread() {
      @Override
      public void run() {
        controlPanel.setDisable(true);
        doMoving(obj, x, y);
        controlPanel.setDisable(false);
      }

    }.start();
  }

   private void transformShape(double x, double y) {
    
      if(chosen!=null)
      {
          double factor = 1;
          try
          {
              String sfactor = multiplyFactor.getText();
              if("".equals(sfactor))
              {
              factor = 1;
              }
              else
              {
                factor = Double.parseDouble( sfactor);
                if(factor<0)
                 {
                     System.out.println("Negative");
                   return;
                  }
              }
              
          }
          catch(NumberFormatException ex)
          {
              System.out.println("Format Error");
              return;
          }
          Transformer t = new Transformer();
          t.transform(chosen,x,y,factor);
           // moveTo(chosen,x,y);
            
           CanvasManager.getInstance().repaint();  
            chosen =null;
      }
      else
      {
           List<IPaintable> shapes =  CanvasManager.getInstance().get();
    
             for(int i =0;i<shapes.size();i++)
             {
                if(shapes.get(i) instanceof IClickable && ((IClickable)shapes.get(i)).isInBound(x, y))
                {
                   System.out.println("Object clicked! " + i);
                   chosen = (AbstractShape)(shapes.get(i));
                    break;
             
                }
             }
      }
  
      
       
      

//TODO
    //pokud není vybrán žádný tvar:
    //   vybrat
    //jinak:
    // posunout daný tvar na specifickout pozici - zavolat metodu moveTo
    //moveTo(null, x, y);
  }

 
 
  
  
  
  
  
  
  
  
  private void createShape(double x, double y, String value) {
    switch (value) {
      case RECTANGLE:
        CanvasManager.getInstance()
            .add(add(new Rectangle((int) x, (int) y, 50, 50)));
        break;
      case ELLIPSE:
        CanvasManager.getInstance()
            .add(add(new Ellipse((int) x, (int) y, 50, 50)));
        break;
      case TRIANGLE:
        CanvasManager.getInstance()
            .add(add(new Triangle((int) x, (int) y, 50, 50)));
        break;
        
    }
  }

  private IPaintable add(IPaintable shape) {
    createdObjects.add(shape);
    return shape;
  }

}
