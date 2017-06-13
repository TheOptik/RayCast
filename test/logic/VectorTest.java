package logic;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import data.Vector3d;

public class VectorTest {
	
	@Test
	public void dotProductTest() throws Exception {
		
		Vector3d v1 = new Vector3d(1, 2, 3);
		Vector3d v2 = new Vector3d(4, 5, 6);
		double result = v1.dotProduct(v2);
		assertEquals(32, result, 0.0001);
		
	}
	
	@Test
	public void normalizeTest() throws Exception {
		Vector3d v1 = new Vector3d(3, 1, 2);
		Vector3d result = v1.normalize();
		Vector3d expected = new Vector3d(0.802, 0.267, 0.534);
		
		assertEquals(expected.x, result.x, 0.0006);
		assertEquals(expected.y, result.y, 0.0006);
		assertEquals(expected.z, result.z, 0.0006);
		
	}
	
	@Test
	public void testMagnitude() throws Exception {
		Vector3d v1 = new Vector3d(3, 5, 9);
		assertEquals(10.7238, v1.magnitude(), 0.0001);
	}
	
}
