package org.osate.ge.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import java.util.EnumSet;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.osate.ge.internal.DockArea;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramElementField;
import org.osate.ge.internal.diagram.runtime.DiagramModification;
import org.osate.ge.internal.diagram.runtime.DiagramModificationListener;
import org.osate.ge.internal.diagram.runtime.DiagramModifier;
import org.osate.ge.internal.diagram.runtime.ElementAddedEvent;
import org.osate.ge.internal.diagram.runtime.ElementRemovedEvent;
import org.osate.ge.internal.diagram.runtime.ElementUpdatedEvent;
import org.osate.ge.internal.diagram.runtime.ModificationsCompletedEvent;
import org.osate.ge.internal.diagram.runtime.Point;
import org.osate.ge.internal.diagram.runtime.RelativeBusinessObjectReference;

/**
 * Contains tests for the AgeDiagram class. 
 *
 */
public class AgeDiagramTests {
	private Object dummyBoh = new Object(); // Dummy business object handler
	
	class TestModificationListener implements DiagramModificationListener {
		public int elementUpdatedEventsReceived = 0;
		public int elementAddedEventsReceived = 0;
		public int elementRemovedEventsReceived = 0;
		public int modificationsCompletedEventsReceived = 0;
		public ElementUpdatedEvent lastUpdateEvent;
		
		@Override
		public void elementAdded(final ElementAddedEvent e) {
			elementAddedEventsReceived++;
		}
		
		@Override
		public void elementUpdated(final ElementUpdatedEvent e) {
			elementUpdatedEventsReceived++;
			lastUpdateEvent = e;
		}
		
		@Override
		public void elementRemoved(final ElementRemovedEvent e) {
			elementRemovedEventsReceived++;
		}
		
		@Override
		public void modificationsCompleted(final ModificationsCompletedEvent e) {
			modificationsCompletedEventsReceived++;				
		}
		
		public final int getTotalEventsReceived() {
			return elementUpdatedEventsReceived + elementAddedEventsReceived + elementRemovedEventsReceived + modificationsCompletedEventsReceived;
		}
		
		public void reset() {
			elementUpdatedEventsReceived = 0;
			elementAddedEventsReceived = 0;
			elementRemovedEventsReceived = 0;				
			modificationsCompletedEventsReceived = 0;
			lastUpdateEvent = null;
		}
	}
	
	private TestModificationListener ml = new TestModificationListener();
	private AgeDiagram diagram;
	
	@Before 
	public void beforeTest() {
		diagram = new AgeDiagram();
		diagram.addModificationListener(ml);
	}
	
	// Ensure that the element updated added is received.
	@Test
	public void testElementAddedEvent() {
		// Test an add event
		final DiagramElement newElement = new DiagramElement(diagram, 1, dummyBoh, new RelativeBusinessObjectReference("1"), null);
		diagram.modify(new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				m.addElement(newElement);
			}
		});

		assertThat(ml.elementAddedEventsReceived, is(equalTo(1)));
		assertThat(ml.modificationsCompletedEventsReceived, is(equalTo(1)));
		assertThat(ml.getTotalEventsReceived(), is(equalTo(2)));
	}
	
	// Ensure that the element removed event is received.
	@Test
	public void testElementRemovedEvent() {
		final DiagramElement e = addRootElementAndResetCounter(1);
		
		// Test a remove event
		diagram.modify(new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				m.removeElement(e);
			}
		});

		assertThat(ml.elementRemovedEventsReceived, is(equalTo(1)));
		assertThat(ml.modificationsCompletedEventsReceived, is(equalTo(1)));
		assertThat(ml.getTotalEventsReceived(), is(equalTo(2)));
	}
	
	// Ensure that the element updated event is received.
	@Test
	public void testElementUpdatedEventSingle() {
		final DiagramElement e = addRootElementAndResetCounter(1);
		
		// Test the update event
		diagram.modify(new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				m.setPosition(e, new Point(100, 100));
			}
		});
		
		assertThat(ml.elementUpdatedEventsReceived, is(equalTo(1)));
		assertThat(ml.modificationsCompletedEventsReceived, is(equalTo(1)));
		assertThat(ml.getTotalEventsReceived(), is(equalTo(2)));
		assertThat(ml.lastUpdateEvent.updatedFields, is(equalTo(EnumSet.of(DiagramElementField.POSITION))));
	}
	
	// Ensure that a single event is received when the same element is updated multiple times.
	@Test
	public void testElementUpdatedEventMultiple() {
		final DiagramElement e = addRootElementAndResetCounter(1);
		
		// Test the update event
		diagram.modify(new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				m.setDockArea(e, DockArea.TOP);
				m.setPosition(e, new Point(100, 100));
			}
		});
		
		assertThat(ml.elementUpdatedEventsReceived, is(equalTo(1)));
		assertThat(ml.modificationsCompletedEventsReceived, is(equalTo(1)));
		assertThat(ml.getTotalEventsReceived(), is(equalTo(2)));
		assertThat(ml.lastUpdateEvent.updatedFields, is(equalTo(EnumSet.of(DiagramElementField.DOCK_AREA, DiagramElementField.POSITION))));
	}
	
	private DiagramElement addRootElementAndResetCounter(final int id) {
		final DiagramElement newElement = new DiagramElement(diagram, id, dummyBoh, new RelativeBusinessObjectReference(Integer.toString(id)), null);
		diagram.modify(new DiagramModifier() {			
			@Override
			public void modify(final DiagramModification m) {
				m.addElement(newElement);
			}
		});
		
		ml.reset();
		
		return newElement;
	}
	
}
