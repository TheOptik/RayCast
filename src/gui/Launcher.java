package gui;

import data.Vector3d;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.World;
import scene.Sphere;

public class Launcher extends Application {
	
	public static void main(String[] args) {
		launch();
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas canvas = new Canvas(500, 500);
		Scene scene = new Scene(new VBox(canvas));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		Sphere s = new Sphere(new Vector3d(0.3, 2, 40), 2, Color.BLACK);
		World.addObject(s);
		World.addObject(new Sphere(new Vector3d(0, 0, 43), 2, Color.RED));
		
		AnimationTimer timer = new AnimationTimer() {
			PixelWriter writer = canvas.getGraphicsContext2D().getPixelWriter();
			
			@Override
			public void handle(long now) {
				
				for (int x = 0; x < World.WIDTH; x++) {
					for (int y = 0; y < World.HEIGHT; y++) {
						writer.setColor(x, y, World.doRayCast(x, y));
					}
				}
				s.move(new Vector3d(0, 0, 0));
			}
		};
		timer.start();
		
	}
	
}
