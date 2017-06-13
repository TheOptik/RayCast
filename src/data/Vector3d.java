package data;

public class Vector3d {
	
	public double x;
	public double y;
	public double z;
	
	/**
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vector3d(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3d add(Vector3d other) {
		return new Vector3d(x + other.x, y + other.y, z + other.z);
	}
	
	public Vector3d multiply(double scale) {
		return new Vector3d(x * scale, y * scale, z * scale);
	}
	
	public Vector3d subtract(Vector3d other) {
		return new Vector3d(x - other.x, y - other.y, z - other.z);
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y + z * z);
	}
	
	public Vector3d normalize() {
		double magnitude = this.magnitude();
		return new Vector3d(x / magnitude, y / magnitude, z / magnitude);
	}
	
	@Override
	public String toString() {
		StringBuilder resultBuilder = new StringBuilder();
		
		resultBuilder.append("[x: ");
		resultBuilder.append(x);
		resultBuilder.append(", y: ");
		resultBuilder.append(y);
		resultBuilder.append(", z: ");
		resultBuilder.append(z);
		resultBuilder.append(']');
		
		return resultBuilder.toString();
	}
	
	public double dotProduct(Vector3d other) {
		
		return x * other.x + y * other.y + z * other.z;
		
	}
	
}
