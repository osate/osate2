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
