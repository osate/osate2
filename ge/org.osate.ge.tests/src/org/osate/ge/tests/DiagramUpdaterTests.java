package org.osate.ge.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.osate.ge.internal.diagram.AgeDiagram;
import org.osate.ge.internal.diagram.DiagramConfiguration;
import org.osate.ge.internal.diagram.DiagramElement;
import org.osate.ge.internal.diagram.DiagramUpdater;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTree;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeFactory;
import org.osate.ge.internal.diagram.DiagramUpdater.BusinessObjectTreeNode;
import org.osate.ge.internal.diagram.DiagramUpdater.Listener;

// TODO: Document purpose
public class DiagramUpdaterTests {
	private static class TestBusinessObjectTreeFactory implements BusinessObjectTreeFactory {
		private Object[] model;
		public TestBusinessObjectTreeFactory(final Object[] model) {
			this.model = model;
		}
		
		public void setModel(final Object[] model) {
			this.model = model;
		}
		
		private static List<BusinessObjectTreeNode> createNodeList(final Object[] values) {
			final List<BusinessObjectTreeNode> result = new ArrayList<>();
			for(final Object value : values) {
				result.add(new BusinessObjectTreeNode() {
					@Override
					public Object getBusinessObject() {
						return value;
					}

					@Override
					public List<BusinessObjectTreeNode> getChildren() {
						if(value instanceof Object[]) {
							return createNodeList((Object[])value);
						} else {
							return Collections.emptyList();
						}
					}						
				});
			}
			return result;
		}
		
		@Override
		public BusinessObjectTree createBusinessObjectTree(DiagramConfiguration configuration) {
			final BusinessObjectTree tree = new BusinessObjectTree() {				
				@Override
				public List<BusinessObjectTreeNode> getRootNodes() {
					return createNodeList(model);
				}
			};
			
			return tree;
		}		
	}
	
	private Object[] testModel;
	private Listener testListener;
	private AgeDiagram diagram;
	private DiagramUpdater diagramUpdater;
	private TestBusinessObjectTreeFactory boTreeFactory;
	
	@Before 
	public void beforeTest() {
		testModel = new Object[] {
			new Object[] { 1, 2, new int[] { 4, 5, 6} },
			new int[] { 7 }
		};
			
		testListener = new Listener() {
		};
		
		diagram = new AgeDiagram();
		boTreeFactory = new TestBusinessObjectTreeFactory(testModel);
		diagramUpdater = new DiagramUpdater(boTreeFactory, testListener);
	}

	// Test that the diagram elements are created as expected
	@Test
	public void testDiagramElementCreation() {
		diagramUpdater.updateDiagram(diagram);		
		checkElements(diagram.getElements(), testModel);
	}
	
	// Test that when update is called multiple times, elements are not duplicated
	@Test
	public void testDiagramElementUpdating() {
		diagramUpdater.updateDiagram(diagram);		
		diagramUpdater.updateDiagram(diagram);	
		checkElements(diagram.getElements(), testModel);
	}
	
	// Test that when all objects are removed from the model, all elements are removed from the diagram.
	@Test
	public void testDiagramElementRemoval() {
		diagramUpdater.updateDiagram(diagram);		
		boTreeFactory.setModel(new Object[0]);		
		diagramUpdater.updateDiagram(diagram);	
		assertEquals(0, diagram.getElements().size());
	}
	
	// TODO: Test that when a single element is removed that only it is removed.
	// TODO: Test that when an element is updated, that they retain diagram information instead of removing old and recreated.	
	
	// TODO: More extensive tests. Check that BO are as expected.
	private void checkElements(final List<DiagramElement> elements, final Object model) {
		if(model instanceof Object[]) {
			final Object[] modelChildren = (Object[])model;
			assertEquals(modelChildren.length, elements.size());			
			for(int i = 0 ; i < modelChildren.length; i++) {				
				checkElements(elements.get(i).getChildren(), modelChildren[i]);			
			}
		} else {
			assertEquals(0, elements.size());
		}		
	}
}
