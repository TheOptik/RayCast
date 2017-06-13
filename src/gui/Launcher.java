package gui;

import data.Vector3d;
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
		Canvas canvas = new Canvas(World.WIDTH, World.HEIGHT);
		Scene scene = new Scene(new VBox(canvas));
		
		primaryStage.setScene(scene);
		primaryStage.show();
		World.addObject(new Sphere(new Vector3d(3.7, 0, 10), 2, Color.BLACK));
		World.addObject(new Sphere(new Vector3d(-3.7, 0, 10), 2, Color.RED));
		World.addObject(new Sphere(new Vector3d(0, 2.6, 10), 2, Color.WHITE));
		World.addObject(new Sphere(new Vector3d(0, -2.6, 10), 2, Color.BLUE));
		
		World.addObject(new Sphere(new Vector3d(0, 0, 20), 5, Color.GRAY));
		
		PixelWriter writer = canvas.getGraphicsContext2D().getPixelWriter();
		
		for (int x = 0; x < World.WIDTH; x++) {
			for (int y = 0; y < World.WIDTH; y++) {
				
				writer.setColor(x, y, World.doRayCast(x, y));
				
			}
		}
		
	}
	
}
