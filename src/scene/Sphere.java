package scene;

import data.Vector3d;
import javafx.scene.paint.Color;
import logic.Ray;
import logic.World;

public class Sphere extends SceneObject {
	
	protected final int radius;
	protected final Color color;
	
	public Sphere(Vector3d position, int radius, Color color) {
		super(position);
		this.radius = radius;
		this.color = color;
	}
	
	@Override
	public Color intersect(Ray ray) {
		
		double intermediate1 = ray.origin.subtract(position).magnitude();
		double intermediate2 = ray.direction.dotProduct(ray.origin.subtract(position));
		
		double underRoot = intermediate2 * intermediate2 - intermediate1 * intermediate1 + radius * radius;
		
		double rootUnderRoot = Math.sqrt(underRoot);
		double d1 = intermediate1 + rootUnderRoot;
		double d2 = intermediate1 - rootUnderRoot;
		
		double distance = Math.min(Math.max(d1, 0), Math.max(d2, 0));
		
		if (!Double.isNaN(distance)) {
			System.out.println(distance);
		}
		
		if (underRoot > 0 && distance > 0) {
			if (ray.intensity > 0) {
				
				Vector3d colisionPoint = ray.origin.add(ray.direction).multiply(distance).add(position);
				Vector3d normal = colisionPoint.subtract(position);
				Color other = World.doRayCast(ray.reflect(normal, colisionPoint));
				// System.out.println(other);
				Color col = mixColors(this.color, other);
				// System.out.println(col.getRed() + " " + col.getGreen() + " "
				// + col.getBlue());
				return col;
			}
			return color;
		} else {
			return null;
		}
	}
	
	private static Color mixColors(Color color, Color other) {
		return new Color((color.getRed() + other.getRed()) / 2, (color.getGreen() + other.getGreen()) / 2,
				(color.getBlue() + other.getBlue()) / 2, 1);
	}
	
	public void move(Vector3d vector) {
		this.position = this.position.add(vector);
	}
	
}
