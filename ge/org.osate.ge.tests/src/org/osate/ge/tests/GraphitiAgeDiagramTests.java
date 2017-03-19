package org.osate.ge.tests;

import static org.osate.ge.tests.TestBusinessObject.newBO;

import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.junit.Test;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramUpdater;
import org.osate.ge.internal.graphiti.GraphitiAgeDiagram;

public class GraphitiAgeDiagramTests {
	private final TestBusinessObjectModel testModel = new TestBusinessObjectModel();
	
	@Test
	public void testInitializationFromExistingDiagram() {
		testModel.model = newBO(
				newBO( 
					newBO(2),
					newBO(4), 
					newBO( 
						newBO(6),
						newBO(8), 
						newBO(10)
					) 
				),
				newBO(
					newBO(12)
				)
			);
			
		final AgeDiagram diagram = new AgeDiagram();
		final DiagramUpdater diagramUpdater = new DiagramUpdater(testModel, testModel, testModel, testModel);
		
		diagramUpdater.updateDiagram(diagram);
		
		final GraphitiAgeDiagram graphitiDiagram = new GraphitiAgeDiagram(diagram);
		printGraphitiDiagram(graphitiDiagram.getGraphitiDiagram());
		
		// TODO: Assert things
		
		// Things that are needed and should be tested:
		// Shapes are created as appropriate
		// Connections to shapes are created as appropriate
		// Connection to Connections are created as appropriate
		// Nested connections are created as appropriate
		
		// Shapes are updated when AgeDiagram is updated
		// Shapes are ghosted as appropriate
		// Labels are created.
		// Connection decorators are created as appropriate?
		// Ability to get the diagram element from any pictogram element. Should walk to neared object.
		// Properly handling graphic changes. In particular free form to curved connection.
	}
	
	void printGraphitiDiagram(final Diagram diagram) {
		System.err.println("CONNECTIONS");
		for(final Connection c : diagram.getConnections()) {
			System.err.println("CONNECTION: " + c);
		}
		
		System.err.println("SHAPES");
		printGraphitiShapes(diagram);
	}
	
	void printGraphitiShapes(final ContainerShape shape) {
		System.err.println("START: " + shape);
		for(final Shape child : shape.getChildren()) {
			printGraphitiShapes((ContainerShape)child); // Only container shapes are used
		}
		System.err.println("END: " + shape);
	}
}
