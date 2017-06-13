package logic;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface Intersectable {
	
	Color intersect(Ray ray);
	
}
