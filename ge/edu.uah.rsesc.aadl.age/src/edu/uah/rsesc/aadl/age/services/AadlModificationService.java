package edu.uah.rsesc.aadl.age.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;

/**
 * Service providing a mechanism for making changes to the model
 * @author philip.alldredge
 *
 */
public interface AadlModificationService {
	/**
	 * Modifies an AADL model. Performs any necessary work to ensure it is done safely and appropriately regardless of the current state.
	 * The modification is considered to have failed if the model that results from the modification contains validation errors.
	 * @param element a named element that is contained in the model to be modified
	 * @param modifier the modifier that will perform the actual modification
	 * @returns the result of the modification or null if the modification failed
	 */
	<E extends Element, R> R modify(E element, Modifier<E, R> modifier);
	
	public static interface Modifier<E, R> {
		R modify(Resource resource, final E element);
		
		/**
		 * Called after a modification has been made. Is not executed if the modification is aborted.
		 */
		void afterModification(Resource resource, E element);
	}
	
	public static abstract class AbstractModifier<E, R> implements Modifier<E,R> {
		@Override
		public abstract R modify(Resource resource, E element);		
		
		@Override
		public void afterModification(Resource resource, E element) {
			
		}
	}
}
