package logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import data.Vector3d;
import javafx.scene.paint.Color;
import scene.SceneObject;

public class World {
	
	public static final Color BACKGROUND_COLOR = new Color(0.8, 0.8, 0.8, 1);
	
	public static final int HEIGHT = 1000;
	public static final int WIDTH = 1900;
	
	protected static final int NEAR_CLIP_DISTANCE = 1000;
	
	private static final List<SceneObject> SCENE_OBJECTS = new LinkedList<>();
	
	public static void addObject(SceneObject object) {
		SCENE_OBJECTS.add(object);
		Collections.sort(SCENE_OBJECTS);
	}
	
	public static Color doRayCast(int x, int y) {
		Color color = BACKGROUND_COLOR;
		double nearestDistance = Double.POSITIVE_INFINITY;
		Vector3d direction = new Vector3d(x - WIDTH / 2, y - HEIGHT / 2, NEAR_CLIP_DISTANCE);
		
		Ray ray = new Ray(direction, new Vector3d(0, 0, 0), 1);
		int length = SCENE_OBJECTS.size();
		SceneObject object;
		for (int i = 0; i < length; i++) {
			object = SCENE_OBJECTS.get(i);
			if (object.getPosition().z >= 0) {
				IntersectionResult result = object.intersect(ray);
				Color temp = result.color;
				if (temp != null && nearestDistance > result.distance) {
					color = temp;
					nearestDistance = result.distance;
				}
			}
		}
		return color;
	}
	
	public static Color doRayCast(Ray ray, SceneObject origin) {
		Color color = Color.TRANSPARENT;
		double nearestDistance = Double.POSITIVE_INFINITY;
		IntersectionResult result;
		
		int length = SCENE_OBJECTS.size();
		SceneObject object;
		for (int i = 0; i < length; i++) {
			object = SCENE_OBJECTS.get(i);
			if (object != origin) {
				result = object.intersect(ray);
				Color temp = result.color;
				if (temp != null && nearestDistance > result.distance) {
					color = temp;
					nearestDistance = result.distance;
				}
			}
		}
		return color;
	}
	
}
