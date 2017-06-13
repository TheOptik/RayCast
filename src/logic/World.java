package logic;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import data.Vector3d;
import javafx.scene.paint.Color;
import scene.SceneObject;

public class World {
	
	public static final int HEIGHT = 500;
	public static final int WIDTH = 500;
	
	protected static final int NEAR_CLIP_DISTANCE = 500;
	
	private static final List<SceneObject> SCENE_OBJECTS = new LinkedList<>();
	
	public static void addObject(SceneObject object) {
		SCENE_OBJECTS.add(object);
		Collections.sort(SCENE_OBJECTS);
	}
	
	public static Color doRayCast(int x, int y) {
		Color color = Color.WHITE;
		Vector3d direction = new Vector3d(x - WIDTH / 2, y - HEIGHT / 2, NEAR_CLIP_DISTANCE);
		
		Ray ray = new Ray(direction, new Vector3d(0, 0, 0), 1);
		int length = SCENE_OBJECTS.size();
		SceneObject object;
		for (int i = 0; i < length; i++) {
			object = SCENE_OBJECTS.get(i);
			if (object.getPosition().z >= 0) {
				Color temp = object.intersect(ray);
				if (temp != null) {
					color = temp;
				}
			}
		}
		return color;
	}
	
	public static Color doRayCast(Ray ray) {
		Color color = Color.WHITE;
		
		int length = SCENE_OBJECTS.size();
		SceneObject object;
		for (int i = 0; i < length; i++) {
			object = SCENE_OBJECTS.get(i);
			if (object.getPosition().z >= 0) {
				Color temp = object.intersect(ray);
				if (temp != null) {
					color = temp;
				}
			}
		}
		return color;
	}
	
}
