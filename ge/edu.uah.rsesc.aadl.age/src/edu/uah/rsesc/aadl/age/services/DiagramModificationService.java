package edu.uah.rsesc.aadl.age.services;

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
