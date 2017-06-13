package logic;

import javafx.scene.paint.Color;

public class IntersectionResult {
	
	protected Color color;
	protected double distance;
	
	/**
	 * @param object
	 * @param distance
	 */
	public IntersectionResult(Color color, double distance) {
		super();
		this.color = color;
		this.distance = distance;
	}
	
	public double getDistance() {
		return distance;
	}
	
	public Color getObject() {
		return color;
	}
	
}
