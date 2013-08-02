package edu.uah.rsesc.aadl.age.diagrams.common.util;

import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.styles.Point;

public class GraphicsAlgorithmUtil {
	/**
	 * Mirrors agraphics algorithm in the x axis
	 * @param ga the graphics algorithm to mirror
	 */
	public static void mirror(final GraphicsAlgorithm ga) {
		mirror(ga, ga);
	}
	
	/**
	 * Mirrors agraphics algorithm in the x axis
	 * @param rootGa the graphics algorithm that will be treated at the top level graphics algorithm. The top level graphics algorithm will not be moved.
	 * @param ga the graphics algorithm to mirror
	 */
	private static void mirror(final GraphicsAlgorithm rootGa, final GraphicsAlgorithm ga) {
		if(rootGa != ga) {
			ga.setX(ga.getParentGraphicsAlgorithm().getWidth() - ga.getX() - ga.getWidth());
		}
		
		if(ga instanceof Polyline) {
			// Mirror every point in the polyline
			final Polyline polyline = (Polyline)ga;
			for(final Point p : polyline.getPoints()) {
				p.setX(ga.getWidth()-p.getX());
			}
		}
		
		for(final GraphicsAlgorithm childGa : ga.getGraphicsAlgorithmChildren()) {
			mirror(rootGa, childGa);
		}
	}
}
