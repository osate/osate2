package org.osate.ge.internal.operations;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.ModelModifier;
import org.osate.ge.operations.OperationBuilder.BusinessObjectProvider;

class ModelModificationStep<TagType, BusinessObjectType extends EObject, PrevResultUserType, ResultUserType>
extends AbstractStep<ResultUserType> {
	private final TagType tag;
	private final BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider;
	private final ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier;

	public ModelModificationStep(final Step<?> nextStep, final TagType tag,
			final BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider,
			final ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier) {
		super(nextStep);
		this.tag = tag;
		this.boProvider = Objects.requireNonNull(boProvider, "boProvider must not be null");
		this.modifier = Objects.requireNonNull(modifier, "modifier must not be null");
	}

	public final TagType getTag() {
		return tag;
	}

	public final BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> getBusinessObjectProvider() {
		return boProvider;
	}

	public final ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> getModifier() {
		return modifier;
	}
}
