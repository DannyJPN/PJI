/*******************************************************************************
 * Jan Kožusznik
 * Copyright (c) 2016 All Right Reserved, http://www.kozusznik.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 ******************************************************************************/
package pl1.shapes.manager;

import java.util.List;
import java.util.Random;
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

  private static final String RECTANGLE = "Obdelník";

  private static final String TRIANGLE = "Trojúhelník";

  private static final String ELLIPSE = "Elipsa";

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

    if (e.isPrimaryButtonDown()) {
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
        deleteShape(e.getX(), e.getY());
      
      }
    }
  }

  public void mouseMoved(MouseEvent e) {
    actualX.setText(e.getX() + "");
    actualY.setText(e.getY() + "");
  }

  private void moveShape(double x, double y) {
     List<IPaintable> shapes =  CanvasManager.getInstance().get();
    
      for(int i =0;i<shapes.size();i++)
      {
          if(shapes.get(i) instanceof IClickable && ((IClickable)shapes.get(i)).isInBound(x, y))
          {
             System.out.println("Object clicked! " + i);
             moveTo(shapes.get(i),new Random().nextInt(250),new Random().nextInt(250));
          }
      }
      CanvasManager.getInstance().repaint();   
      
//TODO
    //pokud není vybrán žádný tvar:
    //   vybrat
    //jinak:
    // posunout daný tvar na specifickout pozici - zavolat metodu moveTo
    //moveTo(vybrany tvar, x, y);
  }

  private void doMoving(Object obj, double x, double y) {
    try {
      Thread.sleep(1000);
    
      if(obj instanceof Rectangle)
      {
          Rectangle r = (Rectangle)(obj);
          while(r.getX()!=x && r.getY()!=y)
          {
                if(r.getX()>x)
                {
                r.moveRight(-1);
                }
                if(r.getX()<x)
                {
                r.moveRight(1);
                }
                if(r.getY()>y)
                {
                r.moveDown(-1);
                }
                if(r.getY()<y)
                {
                r.moveDown(1);
                }
                
          }
      }
      else if(obj instanceof Ellipse)
      {
          Ellipse e = (Ellipse)(obj);
           while(e.getX()!=x && e.getY()!=y)
          {
                if(e.getX()>x)
                {
                e.moveRight(-1);
                }
                if(e.getX()<x)
                {
                e.moveRight(1);
                }
                if(e.getY()>y)
                {
                e.moveDown(-1);
                }
                if(e.getY()<y)
                {
                e.moveDown(1);
                }
                
          }
      }
      else if(obj instanceof Triangle)
      {
          Triangle t= (Triangle)(obj);
           while(t.getX()!=x && t.getY()!=y)
          {
                if(t.getX()>x)
                {
                t.moveRight(-1);
                }
                if(t.getX()<x)
                {
                t.moveRight(1);
                }
                if(t.getY()>y)
                {
                t.moveDown(-1);
                }
                if(t.getY()<y)
                {
                t.moveDown(1);
                }
                
          }
      }
      
      
      
      
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

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

  private void createShape(double x, double y, String value) {
    switch (value) {
      case RECTANGLE:
        CanvasManager.getInstance()
            .add(new Rectangle((int) x, (int) y, 50, 50));
        break;
      case TRIANGLE:
        CanvasManager.getInstance()
            .add(new Triangle((int) x, (int) y, 50, 50));
        break;
      case ELLIPSE:
        CanvasManager.getInstance()
            .add(new Ellipse((int) x, (int) y, 50, 50));
        break;
        
    }
  }
  private void deleteShape(double x,double y)
  {
      List<IPaintable> shapes =  CanvasManager.getInstance().get();
      for(int i =0;i<shapes.size();i++)
      {
          if(shapes.get(i) instanceof IClickable && ((IClickable)shapes.get(i)).isInBound(x, y))
          {
             System.out.println("Object clicked! " + i);
             shapes.remove(i);
          }
      }
      CanvasManager.getInstance().repaint();
  }

}
