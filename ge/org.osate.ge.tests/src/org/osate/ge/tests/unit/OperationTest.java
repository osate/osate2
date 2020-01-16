/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.tests.unit;

import static org.junit.Assert.assertEquals;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EObject;
import org.junit.Test;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.diagram.Point;
import org.osate.ge.internal.operations.DefaultOperationBuilder;
import org.osate.ge.internal.operations.DefaultStepResult;
import org.osate.ge.internal.operations.OperationExecutor;
import org.osate.ge.internal.operations.Step;
import org.osate.ge.internal.query.Queryable;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.operations.OperationBuilder;
import org.osate.ge.operations.StepResultBuilder;

import com.google.common.collect.ImmutableSet;

public class OperationTest {
	// Stub modification serviced used for testing.
	private final AadlModificationService modificationService = new AadlModificationService() {
		@Override
		public void modify(List<? extends Modification<?, ?>> modifications, ModificationPostprocessor postProcessor) {
			for (final Modification<?, ?> m : modifications) {
				executeModification(m);
			}

			postProcessor.modificationCompleted(true);
		}

		private <TagType, BusinessObjectType extends EObject> void executeModification(
				final Modification<TagType, BusinessObjectType> m) {
			final BusinessObjectType bo = m.getTagToBusinessObjectMapper().apply(m.getTag());
			if (bo != null) {
				m.getModifier().modify(m.getTag(), bo);
			}
		}
	};

	// Stub Business Object Context for use when a method requires a non-null BOC.
	private final BusinessObjectContext stubBoc = new BusinessObjectContext() {
		@Override
		public Collection<? extends Queryable> getChildren() {
			return Collections.emptyList();
		}

		@Override
		public BusinessObjectContext getParent() {
			return null;
		}

		@Override
		public Object getBusinessObject() {
			return null;
		}
	};

	private final EObject testBo = new Point();

	/**
	 * Tests a simple sequential modification
	 */
	@Test
	public void testSequential() {
		DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		final OperationBuilder<Integer> b = rootOpBuilder.map(arg -> StepResultBuilder.create(1).build());

		b.map(pr -> StepResultBuilder.create(pr + 2).build())
				.modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create(prevResult + 1).build();
				}).modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create().showNewBusinessObject(stubBoc, prevResult + 2).build();
				});

		final Step<?> firstStep = rootOpBuilder.build();
		final OperationExecutor executor = new OperationExecutor(modificationService);
		executor.execute(firstStep, (results) -> {
			// Verify that result was created.
			final ImmutableSet<Integer> expectedBosToShow = ImmutableSet.of(6);
			final Set<?> bosToShow = results.stream().map(r -> (DefaultStepResult<?>) r)
					.flatMap(r -> r.getContainerToBoToShowMap().values().stream()).collect(Collectors.toSet());
			assertEquals(expectedBosToShow, bosToShow);
		});
	}

	@Test
	public void testSplit() {
		DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		final OperationBuilder<Integer> b = rootOpBuilder.map(arg -> StepResultBuilder.create(1).build());

		b.map(pr -> StepResultBuilder.create(pr + 2).build())
				.modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create(prevResult + 1).build();
				}).modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create().showNewBusinessObject(stubBoc, prevResult + 2).build();
				});
		b.map(pr -> StepResultBuilder.create(pr + 6).build()).modifyModel(null, (tag, prevResult) -> testBo,
				(tag, boToModify, prevResult) -> {
					return StepResultBuilder.create().showNewBusinessObject(stubBoc, prevResult + 3).build();
				});

		final Step<?> firstStep = rootOpBuilder.build();
		final OperationExecutor executor = new OperationExecutor(modificationService);
		executor.execute(firstStep, (results) -> {
			// Verify that results were created from both paths
			final ImmutableSet<Integer> expectedBosToShow = ImmutableSet.of(6, 10);
			final Set<?> bosToShow = results.stream().map(r -> (DefaultStepResult<?>) r)
					.flatMap(r -> r.getContainerToBoToShowMap().values().stream()).collect(Collectors.toSet());
			assertEquals(expectedBosToShow, bosToShow);
		});
	}

	@Test
	public void testMapAfterModify() {
		DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		final OperationBuilder<Integer> b = rootOpBuilder.map(arg -> StepResultBuilder.create(1).build());

		b.map(pr -> StepResultBuilder.create(pr + 2).build())
				.modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create(prevResult + 1).build();
				}).map(pr -> StepResultBuilder.create().showNewBusinessObject(stubBoc, Integer.valueOf(100)).build());

		final Step<?> firstStep = rootOpBuilder.build();
		final OperationExecutor executor = new OperationExecutor(modificationService);
		executor.execute(firstStep, (results) -> {
			// Verify that result was created from the map after the modification
			final ImmutableSet<Integer> expectedBosToShow = ImmutableSet.of(100);
			final Set<?> bosToShow = results.stream().map(r -> (DefaultStepResult<?>) r)
					.flatMap(r -> r.getContainerToBoToShowMap().values().stream()).collect(Collectors.toSet());
			assertEquals(expectedBosToShow, bosToShow);
		});
	}

	@Test
	public void testMapWithoutodify() {
		DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		final OperationBuilder<Integer> b = rootOpBuilder.map(arg -> StepResultBuilder.create(1).build());

		b.map(pr -> StepResultBuilder.create().showNewBusinessObject(stubBoc, Integer.valueOf(100)).build());

		final Step<?> firstStep = rootOpBuilder.build();
		final OperationExecutor executor = new OperationExecutor(modificationService);
		executor.execute(firstStep, (results) -> {
			// Verify that result was created from the map after the modification
			final ImmutableSet<Integer> expectedBosToShow = ImmutableSet.of(100);
			final Set<?> bosToShow = results.stream().map(r -> (DefaultStepResult<?>) r)
					.flatMap(r -> r.getContainerToBoToShowMap().values().stream()).collect(Collectors.toSet());
			assertEquals(expectedBosToShow, bosToShow);
		});
	}

	@Test
	public void testAbort() {
		final DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		final OperationBuilder<Integer> b = rootOpBuilder.map(arg -> StepResultBuilder.create(1).build());

		final AtomicBoolean executed = new AtomicBoolean(false);
		b.map(pr -> StepResultBuilder.create(pr + 2).build())
				.modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create(prevResult + 1).abort().build();
				}).modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					executed.set(true);
					return StepResultBuilder.create().showNewBusinessObject(stubBoc, prevResult + 2).build();
				});

		final Step<?> firstStep = rootOpBuilder.build();
		final OperationExecutor executor = new OperationExecutor(modificationService);
		executor.execute(firstStep, (results) -> {
			assertEquals(false, executed.get());
		});
	}

	@Test
	public void testSplitAbort() {
		final DefaultOperationBuilder rootOpBuilder = new DefaultOperationBuilder();
		final OperationBuilder<Integer> b = rootOpBuilder.map(arg -> StepResultBuilder.create(1).build());

		final AtomicBoolean executed = new AtomicBoolean(false);
		b.map(pr -> StepResultBuilder.create(pr + 2).build())
				.modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					return StepResultBuilder.create(prevResult + 1).abort().build();
				}).modifyModel(null, (tag, prevResult) -> testBo, (tag, boToModify, prevResult) -> {
					executed.set(true);
					return StepResultBuilder.create().showNewBusinessObject(stubBoc, prevResult + 2).build();
				});
		b.map(pr -> StepResultBuilder.create(pr + 6).build()).modifyModel(null, (tag, prevResult) -> testBo,
				(tag, boToModify, prevResult) -> {
					executed.set(true);
					return StepResultBuilder.create().showNewBusinessObject(stubBoc, prevResult + 3).build();
				});

		final Step<?> firstStep = rootOpBuilder.build();
		final OperationExecutor executor = new OperationExecutor(modificationService);
		executor.execute(firstStep, (results) -> {
			assertEquals(false, executed.get());
		});
	}
}
