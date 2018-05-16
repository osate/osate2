package org.osate.ge.operations;

import java.util.function.Function;
import java.util.function.Supplier;

import org.eclipse.emf.ecore.EObject;

public interface OperationBuilder<PrevResultUserType> {
	interface BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> {
		BusinessObjectType getBusinessObject(TagType tag, PrevResultUserType previousUserValue);
	}

	<TagType, BusinessObjectType extends EObject, ResultUserType> OperationBuilder<ResultUserType> modifyModel(
			TagType obj, BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider,
			ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier);

	/**
	 * Modifies the previous result. The previous result is expected to be an EObject belonging to the AADL model.
	 * @param modifier must not return null
	 * @return
	 */
	@SuppressWarnings("unchecked")
	default <TagType, ResultUserType> OperationBuilder<ResultUserType> modifyPreviousResult(
			final Function<PrevResultUserType, StepResult<ResultUserType>> modifier) {

		return modifyModel(null, (tag, prevResult) -> {
			if (!(prevResult instanceof EObject)) {
				throw new IllegalStateException("Previous result must be an EObject. Previous result: " + prevResult);
			}
			return (EObject) prevResult;
		}, (tag, boToModify, prevResult) -> modifier.apply((PrevResultUserType) boToModify));
	}

	<ResultUserType> OperationBuilder<ResultUserType> map(
			Function<PrevResultUserType, StepResult<ResultUserType>> mapper);

	/**
	 * A map which ignores the previous result.
	 * @param supplier
	 * @return
	 */
	default <ResultUserType> OperationBuilder<ResultUserType> supply(
			final Supplier<StepResult<ResultUserType>> supplier) {
		return map(prevResult -> supplier.get());
	}
}
