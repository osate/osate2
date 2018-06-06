package org.osate.ge.internal.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.ModelModifier;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;

import com.google.common.collect.ImmutableList;

abstract class AbstractStepBuilder<PrevResultUserType> implements OperationBuilder<PrevResultUserType> {
	private final List<AbstractStepBuilder<?>> nextStepBuilders = new ArrayList<>();

	@Override
	public <TagType, BusinessObjectType extends EObject, ResultUserType> OperationBuilder<ResultUserType> modifyModel(final TagType tag,
			BusinessObjectProvider<TagType, BusinessObjectType, PrevResultUserType> boProvider,
			final ModelModifier<TagType, BusinessObjectType, PrevResultUserType, ResultUserType> modifier) {
		return addNextStepBuilder(new ModelModificationStepBuilder<>(tag, boProvider, modifier));
	}

	@Override
	public <ResultUserType> OperationBuilder<ResultUserType> map(
			Function<PrevResultUserType, StepResult<ResultUserType>> mapper) {
		return addNextStepBuilder(new MapStepBuilder<>(mapper));
	}

	private <ResultUserType> OperationBuilder<ResultUserType> addNextStepBuilder(
			final AbstractStepBuilder<ResultUserType> nextStepBuilder) {
		nextStepBuilders.add(nextStepBuilder);
		return nextStepBuilder;
	}

	public final Step<?> build() {
		final Step<?> nextStep;
		if (nextStepBuilders.isEmpty()) {
			nextStep = null;
		} else if (nextStepBuilders.size() == 1) {
			nextStep = nextStepBuilders.get(0).build();
		} else {
			nextStep = new SplitStep(
					nextStepBuilders.stream().map(b -> b.build()).collect(ImmutableList.toImmutableList()));
		}

		return buildStep(nextStep);
	}

	protected abstract Step<?> buildStep(final Step<?> nextStep);
}