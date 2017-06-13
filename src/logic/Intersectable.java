package logic;

@FunctionalInterface
public interface Intersectable {
	
	IntersectionResult intersect(Ray ray);
	
}
