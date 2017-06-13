package logic;

import data.Vector3d;

public class Ray {
	
	public Vector3d direction;
	public Vector3d origin;
	public double intensity;
	
	/**
	 * @param direction
	 * @param origin
	 * @param intensity
	 */
	public Ray(Vector3d direction, Vector3d origin, double intensity) {
		super();
		this.direction = direction.normalize();
		this.origin = origin;
		this.intensity = intensity;
	}
	
	public Ray reflect(Vector3d normal, Vector3d origin) {
		Vector3d norm = normal.normalize();
		Vector3d dir = direction.subtract(norm.multiply(direction.dotProduct(norm)).multiply(2));
		return new Ray(dir, origin, 0);
	}
	
}
