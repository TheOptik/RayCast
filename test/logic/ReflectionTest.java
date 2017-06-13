package logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data.Vector3d;

public class ReflectionTest {
	
	@Test
	public void reflectionTest() throws Exception {
		
		Ray ray = new Ray(new Vector3d(1, 0, 0), new Vector3d(0, 0, 0), 1);
		Vector3d result = ray.reflect(new Vector3d(-1, -1, 0), new Vector3d(0, 0, 0)).direction;
		Vector3d expected = new Vector3d(0, -1, 0);
		assertEquals(expected.x, result.x, 0.0001);
		assertEquals(expected.y, result.y, 0.0001);
		assertEquals(expected.z, result.z, 0.0001);
		
	}
	
	@Test
	public void reflectionNewTest() throws Exception {
		
		Ray ray = new Ray(new Vector3d(1, 0, 0), new Vector3d(0, 0, 0), 1);
		Vector3d result = ray.reflectNew(new Vector3d(-1, -1, 0), new Vector3d(0, 0, 0)).direction;
		Vector3d expected = new Vector3d(0, -1, 0);
		assertEquals(expected.x, result.x, 0.0001);
		assertEquals(expected.y, result.y, 0.0001);
		assertEquals(expected.z, result.z, 0.0001);
		
	}
	
}
