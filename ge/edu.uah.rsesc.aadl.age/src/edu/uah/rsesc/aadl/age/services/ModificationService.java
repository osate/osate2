package edu.uah.rsesc.aadl.age.services;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.NamedElement;

/**
 * Service providing a mechanism for making changes to the model
 * @author philip.alldredge
 *
 */
public interface ModificationService {
	/**
	 * Modifies an AADL model. Performs any necessary work to ensure it is done safely and appropriately regardless of the current state.
	 * The modification is considered to have failed if the model that results from the modification contains validation errors.
	 * @param element a named element that is contained in the model to be modified
	 * @param modifier the modifier that will perform the actual modification
	 * @returns the result of the modification or null if the modification failed
	 */
	<MR> MR modifyModel(NamedElement element, Modifier<MR> modifier);
	
	public interface Modifier<R> {
		R modify(final Resource resource);
	}
}
