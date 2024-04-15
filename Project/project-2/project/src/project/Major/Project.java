/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project.Major;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import project.Passive.LayerCanvas;
import project.Shapes.Rectangle;

/**
 *
 * @author OEM
 */
public class Project extends Application {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		launch(args);

	}
	
	private Rectangle r;
	private LayerCanvas paintSystem;
	private Thread thread;
	
	@Override
	public void start(Stage primaryStage) throws InterruptedException, IOException {

		StackPane root = new StackPane();
		root.setPrefWidth(1000);
		root.setPrefHeight(1000);

		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("manipulation_panel.fxml"));
			fxmlLoader.setControllerFactory(__ -> Project.this);
			Parent fxml = fxmlLoader.load();
			StackPane.setAlignment(fxml, Pos.TOP_LEFT);
			root.getChildren().add(fxml);
		} catch (IOException exception) {
			throw new RuntimeException(exception);
		}

		this.paintSystem = new LayerCanvas(160, 0, 3, 800, 600);
		this.r = new Rectangle(0, 0, 0, 100, 100);
		r.setFill(Color.ALICEBLUE);
		r.setStroke(Color.DARKCYAN);
		r.setStrokeWidth(5);
		paintSystem.AddShape(r);
		paintSystem.Draw(r);
		root.getChildren().add(paintSystem.GetLayer(0));
		StackPane.setAlignment(paintSystem.GetLayer(0), Pos.TOP_LEFT);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Hello World!");
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest((WindowEvent t) -> {
			System.exit(0);
		});

		
		
	}

	@FXML
	private void RunGame(ActionEvent event) {
		System.out.println("NewGame buton pressed");
		startThread();
	}

	@FXML
	private void StopGame(ActionEvent event) {
		System.out.println("StopGame buton pressed");
		stopThread();
	}

	synchronized private void startThread() {
		if (thread != null) {
			return;
		}
		
		thread = new Thread("New Thread") {
			@Override
			public void run() {
				System.out.println("Thread started");
				for (int i = 1; (r.getX() + r.getWidth() < paintSystem.GetLayer(0).getWidth()
						&& r.getY() + r.getHeight() < paintSystem.GetLayer(0).getHeight()); i++) {
					try {
						paintSystem.Erase(r);
						r.setX(r.getX() + 10);
						r.setY(r.getY() + 10);
						paintSystem.Draw(r);
						Thread.sleep(100);
						System.out.println("Thread rot " + i + "\tX: " + (r.getX()) + "\tY: " + (r.getY()));
					} catch (InterruptedException ex) {
						break;
					}
				}
				synchronized (Project.this) {
					thread = null;
				}
				System.out.println("Thread stopped");
			}
		};
		thread.start();
	}
	
	synchronized private void stopThread() {
		if (thread == null) {
			return;
		}
		thread.interrupt();

	}

	

	
	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(5);
		gc.strokeLine(40, 10, 10, 40);
		gc.fillOval(10, 60, 30, 30);
		gc.strokeOval(60, 60, 30, 30);
		gc.fillRoundRect(110, 60, 30, 30, 10, 10);
		gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
		gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
		gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
		gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
		gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
		gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
		gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
		gc.fillPolygon(new double[] { 10, 40, 10, 40 }, new double[] { 210, 210, 240, 240 }, 4);
		gc.strokePolygon(new double[] { 60, 90, 60, 90 }, new double[] { 210, 210, 240, 240 }, 4);
		gc.strokePolyline(new double[] { 110, 140, 110, 140 }, new double[] { 210, 210, 240, 240 }, 4);
	}

	
}
