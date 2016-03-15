package org.osate.ge.internal.layout;

import java.util.List;

import org.osate.ge.internal.layout.MonteCarloLayout.LayoutOperation;

public class MonteCarloLayoutAlgorithm implements LayoutAlgorithm {
	private static final long layoutTimeout = 2000; // In miliseconds
	private static final int minLayoutSamples = 200000;
	private static final int maxLayoutSamples = 1000000;

	@Override
	public void layout(final List<Shape> shapes, final List<Connection> connections) {
		final DefaultLayoutScorer scorer = new DefaultLayoutScorer();
		scorer.setShapeIntersectionsWeight(1.0);
		scorer.setConnectionIntersectionsWeight(0.1);
		scorer.setShapeConnectionIntersectionsWeight(0.1);
		scorer.setTargetConnectionLengthWeight(0.05);
		
		final MonteCarloLayout mc = new MonteCarloLayout(scorer);
		// Perform the layout. Continue the operation until the minimum number of samples has been reached and the timeout expired or the max number of samples is reached.
		final LayoutOperation op = mc.start(shapes, connections);
		final long startTime = System.currentTimeMillis();
		int sampleCount = 0;
		long elapsedTime;
		do {
			sampleCount++;
			op.next();
			elapsedTime = System.currentTimeMillis() - startTime;
		} while((((elapsedTime < layoutTimeout) && sampleCount < maxLayoutSamples) || sampleCount < minLayoutSamples));
		
		op.accept();
	}
}
