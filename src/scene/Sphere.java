package scene;

import data.Vector3d;
import javafx.scene.paint.Color;
import logic.IntersectionResult;
import logic.Ray;
import logic.World;

public class Sphere extends SceneObject {
	
	protected final double radius;
	protected final Color color;
	
	public Sphere(Vector3d position, double radius, Color color) {
		super(position);
		this.radius = radius;
		this.color = color;
	}
	
	@Override
	public IntersectionResult intersect(Ray ray) {
		
		double intermediate1 = ray.origin.subtract(position).magnitude();
		double intermediate2 = ray.direction.dotProduct(ray.origin.subtract(position));
		
		double underRoot = intermediate2 * intermediate2 - intermediate1 * intermediate1 + radius * radius;
		
		if (underRoot > 0) {
			
			double rootUnderRoot = Math.sqrt(underRoot);
			double d1 = intermediate1 + rootUnderRoot;
			double d2 = intermediate1 - rootUnderRoot; // TODO: this should
														// always
														// be the actual
														// distance
			
			double distance = Math.min(d1, d2);
			
			if (ray.intensity > 0) {
				
				Vector3d colisionPoint = ray.origin.add(ray.direction.multiply(distance));
				Vector3d normal = colisionPoint.subtract(position);
				Color other = World.doRayCast(ray.reflect(normal, colisionPoint), this);
				Color col = mixColors(this.color, other);
				return new IntersectionResult(col, distance);
			}
			return new IntersectionResult(color, distance);
		} else {
			return new IntersectionResult(null, Double.POSITIVE_INFINITY);
		}
	}
	
	private static Color mixColors(Color color, Color other) {
		return new Color((2 * color.getRed() + other.getRed()) / 3, (2 * color.getGreen() + other.getGreen()) / 3,
				(2 * color.getBlue() + other.getBlue()) / 3, 1);
	}
	
	public void move(Vector3d vector) {
		this.position = this.position.add(vector);
	}
	
}
