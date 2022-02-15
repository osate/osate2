/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.internal.operations;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.operations.ModelModifier;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResult;

import com.google.common.collect.ImmutableList;

/**
 * Abstract class for step builders
 *
 * @param <P> the type of the user value of the result of the previous step
 */
abstract class AbstractStepBuilder<P> implements OperationBuilder<P> {
	private final List<AbstractStepBuilder<?>> nextStepBuilders = new ArrayList<>();

	@Override
	public <TagType, BusinessObjectType extends EObject, ResultUserType> OperationBuilder<ResultUserType> modifyModel(final TagType tag,
			BusinessObjectToModifyProvider<TagType, BusinessObjectType, P> boProvider,
			final ModelModifier<TagType, BusinessObjectType, P, ResultUserType> modifier) {
		return addNextStepBuilder(new ModelModificationStepBuilder<>(tag, boProvider, modifier));
	}

	@Override
	public <R> OperationBuilder<R> map(
			Function<P, StepResult<R>> mapper) {
		return addNextStepBuilder(new MapStepBuilder<>(mapper));
	}

	@Override
	public void executeOperation(final Function<P, Operation> opProvider) {
		addNextStepBuilder(new SuboperationStepBuilder<>(opProvider));
	}

	private <R> OperationBuilder<R> addNextStepBuilder(
			final AbstractStepBuilder<R> nextStepBuilder) {
		nextStepBuilders.add(nextStepBuilder);
		return nextStepBuilder;
	}

	/**
	 * Creates the step.
	 * @return the new step
	 */
	public final Step build() {
		final Step nextStep;
		if (nextStepBuilders.isEmpty()) {
			nextStep = null;
		} else if (nextStepBuilders.size() == 1) {
			nextStep = nextStepBuilders.get(0).build();
		} else {
			// If there are multiple next steps, use a split step which will execute multiple sequences
			nextStep = new SplitStep(
					nextStepBuilders.stream().map(b -> b.build()).collect(ImmutableList.toImmutableList()));
		}

		return buildStep(nextStep);
	}

	/**
	 * Creates the step. The type of step is dependent on the subclass which implements this method.
	 * @param nextStep the step to be executed after the step being created
	 * @return the step
	 */
	protected abstract Step buildStep(final Step nextStep);
}