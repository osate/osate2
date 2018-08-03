package org.osate.ge.internal.operations;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.ModelModifier;

class ModelModificationStepBuilder<TagType, BusinessObjectType extends EObject, PrevResultUserType, ResultUserType>
extends AbstractStepBuilder<ResultUserType> {
	private final TagType tag;
	private final BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider;
	private final ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier;

	public ModelModificationStepBuilder(final TagType tag,
			final BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider,
			final ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier) {
		this.tag = tag;
		this.boProvider = Objects.requireNonNull(boProvider, "boProvider must not be null");
		this.modifier = Objects.requireNonNull(modifier, "modifier must not be null");
	}

	@Override
	protected Step<?> buildStep(final Step<?> nextStep) {
		return new ModelModificationStep<>(nextStep, tag, boProvider, modifier);
	}
}
