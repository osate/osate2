package edu.uah.rsesc.aadl.age.services;

import java.util.List;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.NamedElement;

/**
 * Includes methods for modifying diagrams.
 * @author philip.alldredge
 *
 */
public interface DiagramModificationService {
	public interface Modification
	{
		/**
		 * Returns the list of all diagrams of which the modification service/modification is aware.
		 * @return
		 */
		List<Diagram> getDiagrams();
		
		/**
		 * Mark diagram as dirty.
		 */
		void markDiagramAsDirty(final Diagram diagram);
		
		/**
		 * Mark all diagrams that represent component implementations derived from the specified component implementation as dirty.
		 * @param ci
		 */
		void markDiagramsOfDerivativeComponentImplementationsAsDirty(final ComponentImplementation ci);
		
		/**
		 * Marks linkages in all diagrams to the specified element as dirty.
		 * @param el
		 */
		void markLinkagesAsDirty(final NamedElement el);		
		
		/**
    	 * Makes the actual changes to the diagrams.
    	 */
		void commit();
	}
	
	/**
	 * Starts a modification. Returns a modification object that can be used to make modifications. Modifications are made with commit() is called.
	 * @return
	 */
	Modification startModification();
}
