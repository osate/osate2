/*******************************************************************************
 * Copyright (C) 2015 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.osate.ge.layout.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.JFrame;

import org.osate.ge.layout.Connection;
import org.osate.ge.layout.MonteCarloLayout;
import org.osate.ge.layout.Shape;
import org.osate.ge.layout.MonteCarloLayout.LayoutOperation;
import org.osate.ge.layout.Shape.PositionMode;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;

public class Main {	
	public static void main(String[] args) {
		final int numberOfTopShapes = 5;
		final int numberOfChildShapes = 4; // Must be even
		final int numberOfConnections = 5;
		
		// Create shapes
		final Random rand = new Random();

		// Create shapes
		final List<Shape> rootShapes = new ArrayList<Shape>(numberOfTopShapes);
		final Map<Object, String> objectToLabelMap = new HashMap<Object, String>();
		for(int i = 0; i < numberOfTopShapes; i++) 
		{
			PositionMode positionMode = Shape.PositionMode.FREE;
			final Shape newShape = new Shape(null, 0, 0, 200 + rand.nextInt(160), 200 + rand.nextInt(160), true, positionMode); 
			objectToLabelMap.put(newShape, "S" + i);
			rootShapes.add(newShape);
			
			for(int j = 0; j < numberOfChildShapes / 2; j++) {
				final Shape childShape = new Shape(newShape, 0, 0, 20 + rand.nextInt(40), 20 + rand.nextInt(40), true, Shape.PositionMode.SNAP_LEFT_RIGHT); 
				objectToLabelMap.put(childShape, "S" + i + "_S" + j);
			}
			
			for(int j = 0; j < numberOfChildShapes / 2; j++) {
				final Shape childShape = new Shape(newShape, 0, 0, 20 + rand.nextInt(40), 20 + rand.nextInt(40), true, Shape.PositionMode.FREE); 
				objectToLabelMap.put(childShape, "S" + i + "_F" + j);
			}
		}
		
		// Create connections between random components
		List<Connection> connections = new ArrayList<Connection>(numberOfConnections);
		for(int i = 0; i < numberOfConnections; i++) {
			boolean unique;
			Shape srcShape, dstShape;
			do {				
				// Determine the src and destination index
				final int srcShapeIdx = rand.nextInt(numberOfTopShapes);
				final int srchildShapeIdx = rand.nextInt(numberOfChildShapes);
				int dstShapeIdx;
				final int dstChildShapeIdx = rand.nextInt(numberOfChildShapes);
				do {
					dstShapeIdx = rand.nextInt(numberOfTopShapes);
					} while(srcShapeIdx == dstShapeIdx);
				
				// Get the shapes
				srcShape = rootShapes.get(srcShapeIdx).getChildren().get(srchildShapeIdx);
				dstShape = rootShapes.get(dstShapeIdx).getChildren().get(dstChildShapeIdx);
				
				// Check if a connections with those values or opposite values already exists
				unique = true;
				for(final Connection c : connections) {
					if((srcShape == c.getSource() && dstShape == c.getDestination()) || 
							(dstShape == c.getSource() && srcShape == c.getDestination())) {
						unique = false;
						break;
					}
				}				
			} while(!unique);
			
			// Create the connection
			final Connection newConnection = new Connection(srcShape, dstShape);
			connections.add(newConnection);
			objectToLabelMap.put(newConnection, "C" + i);
		}

		// Create an instance of the layout class
		final MonteCarloLayout layoutAlg = new MonteCarloLayout();
		layoutAlg.setShapeIntersectionsWeight(1.0);
		layoutAlg.setConnectionIntersectionsWeight(0.1);
		layoutAlg.setShapeConnectionIntersectionsWeight(0.1);
		layoutAlg.setTargetConnectionLengthWeight(0.05);
		
		// Perform the layout
		final LayoutOperation op = layoutAlg.start(rootShapes, connections);
		final int numberOfSamples = 100000;//2000000;	
		for(int i = 0; i < numberOfSamples; i++) {
			op.next();
		}

		op.accept();

		show(rootShapes, connections, objectToLabelMap);		
	}
	
	final static void show(final List<Shape> shapes, final List<Connection> connections, final Map<Object, String> labelMap) {
		// Create the objects for JGraph
		final mxGraph graph = new mxGraph();
		final Object parent = graph.getDefaultParent();
		
		graph.getModel().beginUpdate();
		try	{
			final Map<Shape, Object> shapeToVertexMap = new HashMap<Shape, Object>();
			for(final Shape shape : shapes) {
				shapeToVertexMap.put(shape, graph.insertVertex(parent, null, labelMap.get(shape), shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight()));
				
				for(final Shape childShape : shape.getChildren()) {
					shapeToVertexMap.put(childShape, graph.insertVertex(parent, null, labelMap.get(childShape), childShape.getAbsoluteX(), childShape.getAbsoluteY(), childShape.getWidth(), childShape.getHeight()));
				}
			}
			
			for(final Connection c : connections) {
				graph.insertEdge(parent, null, labelMap.get(c), shapeToVertexMap.get(c.getSource()), shapeToVertexMap.get(c.getDestination()));
			}	
		}
		finally	{
			graph.getModel().endUpdate();
		}

		final mxGraphComponent graphComponent = new mxGraphComponent(graph);
		graphComponent.setEnabled(false);
		
		// Create the frame
		final JFrame frame = new JFrame();
		frame.getContentPane().add(graphComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 800);
		frame.setVisible(true);
	}

}
