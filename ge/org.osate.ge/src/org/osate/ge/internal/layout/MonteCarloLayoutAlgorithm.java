/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
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
