package org.osate.ge.operations;

import org.eclipse.emf.ecore.EObject;

public interface ModelModifier<TagType, BusinessObjectType extends EObject, PrevResultUserType, ResultUserType> {
	/**
	 *
	 * @param tag
	 * @param boToModify
	 * @param prevResult
	 * @return must not return null.
	 */
	StepResult<ResultUserType> modify(TagType tag, BusinessObjectType boToModify, PrevResultUserType prevUserValue);
}
