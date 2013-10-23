package edu.uah.rsesc.aadl.age.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.NamedElement;

import edu.uah.rsesc.aadl.age.services.impl.DefaultDiagramService;
import edu.uah.rsesc.aadl.age.services.impl.SimpleServiceFactory;

// TODO: Review. Rename as appropriate
/**
 * Service for finding, opening, and creating diagrams. Registered as an Eclipse service.
 * @author philip.alldredge
 *
 */
public interface DiagramService {
	public static class Factory extends SimpleServiceFactory {
		public Factory() {
			super(DiagramService.class, DefaultDiagramService.class);
		}
	}	
	
	// TODO: Rename
	public static interface DiagramCallback {
		void onDiagram(final Diagram diagram);
	}
	
	/**
	 * Perform a read-only operation on all diagrams using a callback
	 * @param cb
	 */
	public void readDiagrams(final DiagramCallback cb);
	
	public List<Diagram> findDiagramsByRootBusinessObject(final NamedElement ne);
	
	/**
	 * Opens the first found existing diagram for an element. If a diagram is not found, a diagram of the appropriate type is created.
	 * @param element the element for which to open/create the diagram
	 */
	public void openOrCreateDiagramForRootBusinessObject(final NamedElement element);
}
