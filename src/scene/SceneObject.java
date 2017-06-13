package scene;

import data.Vector3d;
import logic.Intersectable;

public abstract class SceneObject implements Intersectable, Comparable<SceneObject> {
	
	protected Vector3d position;
	
	/**
	 * @param position
	 */
	public SceneObject(Vector3d position) {
		super();
		this.position = position;
	}
	
	public Vector3d getPosition() {
		return position;
	}
	
	@Override
	public int compareTo(SceneObject other) {
		return -Double.compare(this.position.z, other.position.z);
	}
	
	@Override
	public boolean equals(Object obj) {
		return false;
	}
	
}
