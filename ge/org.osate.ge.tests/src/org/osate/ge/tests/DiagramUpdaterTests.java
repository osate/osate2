package org.osate.ge.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.diagram.RelativeBusinessObjectReference;
import org.osate.ge.internal.graphics.AgeConnection;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramElementCollection;
import org.osate.ge.internal.diagram.DiagramUpdater;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTree;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeFactory;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeNode;
import org.osate.ge.internal.diagram.DiagramUpdater.ConnectionEndProvider;
import org.osate.ge.internal.diagram.DiagramUpdater.GraphicProvider;

public class DiagramUpdaterTests {
	// Class used for test business objects. Allowed to contain children or have a value specified but not both.
	private static class TestBusinessObject {
		private final int value;
		private final TestBusinessObject[] children;
		public boolean isConnection = false;
		public RelativeBusinessObjectReference connectionStartReference; // Reference to sibling which is the start of the connection
		public RelativeBusinessObjectReference connectionEndReference; // Reference to sibling which is the end of the connection
		
		public TestBusinessObject(final int value) {
			this.value = value;
			this.children = new TestBusinessObject[0];
		}
		
		public TestBusinessObject(final TestBusinessObject[] children) {
			this.value = -1;
			this.children = children;
		}

		public RelativeBusinessObjectReference getRelativeReference() {
			return new RelativeBusinessObjectReference("test_relative", Integer.toString(value), Integer.toString(children.length));
		}

		public CanonicalBusinessObjectReference getCanonicalReference() {
			return new CanonicalBusinessObjectReference("test_canonical", Integer.toString(value), Integer.toString(children.length));
		}
		
		public Point getTestPosition() {
			return new Point(value, children.length);
		}
		
		public void makeConnection(final TestBusinessObject startSiblingBo, final TestBusinessObject endSiblingBo) {
			this.isConnection = true;
			connectionStartReference = startSiblingBo == null ? null : startSiblingBo.getRelativeReference();
			connectionEndReference = endSiblingBo == null ? null : endSiblingBo.getRelativeReference();
		}
		
		public String toString() {
			return getRelativeReference().toString();
		}
	};
	
	private TestBusinessObject testModel;
	private AgeDiagram diagram;
	private DiagramUpdater diagramUpdater;
	private final BusinessObjectTreeFactory boTreeFactory = new BusinessObjectTreeFactory() {
		private List<BusinessObjectTreeNode> createNodeList(final TestBusinessObject bo) {
			final List<BusinessObjectTreeNode> result = new ArrayList<>();
			for(final TestBusinessObject child : bo.children) {
				result.add(new BusinessObjectTreeNode() {
					@Override
					public Object getBusinessObject() {
						return child;
					}

					@Override
					public Collection<BusinessObjectTreeNode> getChildren() {
						return createNodeList(child);
					}

					@Override
					public RelativeBusinessObjectReference getRelativeReference() {
						return child.getRelativeReference();
					}
					
					@Override
					public CanonicalBusinessObjectReference getCanonicalReference() {
						return child.getCanonicalReference();
					}
				});
			}

			return result;
		}
		
		@Override
		public BusinessObjectTree createBusinessObjectTree(DiagramConfiguration configuration) {
			final BusinessObjectTree tree = new BusinessObjectTree() {
				@Override
				public Collection<BusinessObjectTreeNode> getRootNodes() {
					return createNodeList(testModel);
				}
			};
			
			return tree;
		}		
	};
	
	private final GraphicProvider graphicProvider = new GraphicProvider() {
		@Override
		public Graphic getGraphic(final DiagramElement element) {
			final TestBusinessObject testBo = (TestBusinessObject)element.getBusinessObject();
			if(testBo.isConnection) {
				return ConnectionBuilder.create().build();
			} else {
				return RectangleBuilder.create().build();
			}
		}		
	};
	
	private final ConnectionEndProvider connectonEndProvider = new ConnectionEndProvider() {
		@Override
		public DiagramElement getConnectionStart(final DiagramElement e) {
			final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
			return e.getContainer().getDiagramElements().getByRelativeReference(bo.connectionStartReference);
		}

		@Override
		public DiagramElement getConnectionEnd(final DiagramElement e) {
			final TestBusinessObject bo = (TestBusinessObject)e.getBusinessObject();
			return e.getContainer().getDiagramElements().getByRelativeReference(bo.connectionEndReference);
		}		
	};
	
	// Helper method to reduce code length
	private static TestBusinessObject newBO(final int v) {
		return new TestBusinessObject(v);
	}
	
	private static TestBusinessObject newBO(final TestBusinessObject... args) {
		return new TestBusinessObject(args);
	}
	
	@Before 
	public void beforeTest() {
		// All even values so that all objects are not connections.
		testModel = newBO(
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
			
		diagram = new AgeDiagram();
		diagramUpdater = new DiagramUpdater(boTreeFactory, graphicProvider, connectonEndProvider);
	}

	// Test that the diagram elements are created as expected
	@Test
	public void testDiagramElementCreation() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel);
	}
	
	// Test that when update is called multiple times, elements are not duplicated
	@Test
	public void testDiagramElementUpdating() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		
		diagramUpdater.updateDiagram(diagram);	
		checkElements(diagram.getDiagramElements(), testModel);
	}
	
	// Test that when all objects are removed from the model, all elements are removed from the diagram.
	@Test
	public void testDiagramElementRemovalOfAll() {
		diagramUpdater.updateDiagram(diagram);	
		assignPositions(diagram.getDiagramElements());
		
		testModel = newBO();		
		diagramUpdater.updateDiagram(diagram);	
		assertThat(diagram.getDiagramElements().size(), is(equalTo(0)));
	}
	
	// Test that when part of the model is removed
	@Test
	public void testDiagramElementPartialRemoval() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel);
		testModel = newBO(testModel.children[0].children);
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel);
	}
	
	// Test that when a business object is replace by a new one with the same reference.
	@Test
	public void testDiagramElementUpdateBusinessObject() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel);
		final TestBusinessObject owner = testModel.children[1];
		final TestBusinessObject newBusinessObject = newBO(owner.children[0].value); // Create a copy with the same value. It is assumed that this element does not container children
		owner.children[0] = newBusinessObject;
		diagramUpdater.updateDiagram(diagram);	
		
		final DiagramElement element = diagram.getDiagramElements().getByRelativeReference(owner.getRelativeReference())
				.getDiagramElements().getByRelativeReference(newBusinessObject.getRelativeReference());
		assertThat(element.getBusinessObject(), is(sameInstance(newBusinessObject)));
		
		checkElements(diagram.getDiagramElements(), testModel);
	}
	
	// Test that when a business object is replace by a new one with a different reference.
	@Test
	public void testDiagramElementReplaceBusinessObjectWithNew() {
		diagramUpdater.updateDiagram(diagram);
		assignPositions(diagram.getDiagramElements());
		checkElements(diagram.getDiagramElements(), testModel);
		final TestBusinessObject owner = testModel.children[1];
		final TestBusinessObject newBusinessObject = newBO(42);
		owner.children[0] = newBusinessObject;
		diagramUpdater.updateDiagram(diagram);	
		
		// Get the new element
		final DiagramElement element = diagram.getDiagramElements().getByRelativeReference(owner.getRelativeReference())
				.getDiagramElements().getByRelativeReference(newBusinessObject.getRelativeReference());
		assertThat(element, is(notNullValue()));
		assertThat(element.getPosition(), is(nullValue()));
		assertThat(element.getBusinessObject(), is(sameInstance(newBusinessObject)));
		
		// Set the position of the element
		diagram.getDiagramElements().getByRelativeReference(owner.getRelativeReference())
			.getDiagramElements().getByRelativeReference(newBusinessObject.getRelativeReference())
			.setPosition(newBusinessObject.getTestPosition());
		
		checkElements(diagram.getDiagramElements(), testModel);
	}
	
	@Test 
	public void testConnectionEndPointsAreSet() {
		testModel = newBO(
			newBO(1), // Connection 
			newBO(2), 
			newBO(4)
		);
		testModel.children[0].makeConnection(testModel.children[1], testModel.children[2]);
		diagramUpdater.updateDiagram(diagram);
		
		final DiagramElement testConnectionDiagramElement = diagram.getDiagramElements().getByRelativeReference(testModel.children[0].getRelativeReference());
		assertThat(testConnectionDiagramElement.getGraphic(), instanceOf(AgeConnection.class));		
		assertThat(testConnectionDiagramElement.getStartElement(), notNullValue());
		assertThat(testConnectionDiagramElement.getEndElement(), notNullValue());
	}	
	
	@Test 
	public void testConnectionWithoutStartElementIsRemoved() {
		testModel = newBO(
			newBO(1), // Connection 
			newBO(2),
			newBO(4)
		);
		
		testModel.children[0].makeConnection(null, testModel.children[2]);
		diagramUpdater.updateDiagram(diagram);
		
		final DiagramElement testDiagramElement = diagram.getDiagramElements().getByRelativeReference(testModel.children[0].getRelativeReference());
		assertThat(testDiagramElement, nullValue());
		

	}
	
	@Test 
	public void testConnectionWithoutEndElementIsRemoved() {
		testModel = newBO(
			newBO(1), // Connection 
			newBO(2),
			newBO(4)
		);
		
		testModel.children[0].makeConnection(testModel.children[1], null);
		diagramUpdater.updateDiagram(diagram);
		
		final DiagramElement testDiagramElement = diagram.getDiagramElements().getByRelativeReference(testModel.children[0].getRelativeReference());
		assertThat(testDiagramElement, nullValue());
	}
	
	@Test 
	public void testConnectionWhichReferencesInvalidConnectonIsRemoved() {
		testModel = newBO(
			newBO(1), // Connection 
			newBO(2),
			newBO(3) // Invalid Connection
		);
		
		testModel.children[0].makeConnection(testModel.children[1], testModel.children[2]);
		testModel.children[2].makeConnection(null, null); // Invalid connection
		diagramUpdater.updateDiagram(diagram);
		
		final DiagramElement testDiagramElement = diagram.getDiagramElements().getByRelativeReference(testModel.children[0].getRelativeReference());
		assertThat(testDiagramElement, nullValue());
	}

	private static void assignPositions(final DiagramElementCollection elements) {
		for(final DiagramElement element : elements) {
			final TestBusinessObject bo = (TestBusinessObject)element.getBusinessObject();
			element.setPosition(bo.getTestPosition());
			
			// Assign positions to children
			assignPositions(element.getDiagramElements());
		}
	}
		
	private static void checkElements(final DiagramElementCollection elements, final TestBusinessObject parentBO) {
		// Check the number of elements in the model
		assertThat(elements.size(), is(equalTo(parentBO.children.length)));
		
		// Check that each element in the model is in the element set
		for(final TestBusinessObject child : parentBO.children) {
			boolean foundBO = false;
			final RelativeBusinessObjectReference modelChildRef = child.getRelativeReference();
			for(final DiagramElement e : elements) {
				final RelativeBusinessObjectReference elementRef = ((TestBusinessObject)e.getBusinessObject()).getRelativeReference();
				if(elementRef.equals(modelChildRef)) {
					foundBO = true;
					break;
				}
			}
			
			assertThat("The diagram does not contain an element for the business object: " + child, foundBO);
		}

		// Finish checking each element
		for(final DiagramElement e : elements) {
			// Check the position of the element
			final TestBusinessObject testBo = (TestBusinessObject)e.getBusinessObject();
			assertThat(e.getPosition(), is(equalTo(testBo.getTestPosition())));
			assertThat(e.getCanonicalReference(), is(equalTo(testBo.getCanonicalReference())));
			
			// Check the children
			checkElements(e.getDiagramElements(), (TestBusinessObject)e.getBusinessObject());
		}
	}
}
