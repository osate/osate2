package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.AllPropagations;
import org.osate.aadl2.errormodel.instance.AllPropagationsNoError;
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.CountExpression;
import org.osate.aadl2.errormodel.instance.CountExpressionOperation;
import org.osate.aadl2.errormodel.instance.DestinationPropagationReference;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.EventReference;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.SourceStateReference;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class OutgoingPropagationConditionTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/OutgoingPropagationConditions/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testOverriddenCondition() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_condition.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("CONDITION1", condition.getName());
			assertEquals("CONDITION1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2", condition.getSource().getName());
			assertNull(condition.getCondition());
		});
	}

	@Test
	public void testInheritUnnamedConditions() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_conditions.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			// TODO Update after we create names for unnamed conditions.
			assertNull(condition.getName());
			assertSame(
					((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
							.getParsedAnnexSubclause()).getOutgoingPropagationConditions().get(0),
					condition.getOutgoingPropagationCondition());
			assertEquals("state3", condition.getSource().getName());
			assertNull(condition.getCondition());
		});
		with(annexInstance.getConditions().get(1), condition -> {
			// TODO Update after we create names for unnamed conditions.
			assertNull(condition.getName());
			assertSame(
					((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
							.getOwnedClassifiers()
							.get(1)
							.getOwnedAnnexSubclauses()
							.get(0)).getParsedAnnexSubclause()).getOutgoingPropagationConditions().get(0),
					condition.getOutgoingPropagationCondition());
			assertEquals("state2", condition.getSource().getName());
			assertNull(condition.getCondition());
		});
		with(annexInstance.getConditions().get(2), condition -> {
			// TODO Update after we create names for unnamed conditions.
			assertNull(condition.getName());
			assertSame(
					((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
							.getOwnedClassifiers()
							.get(0)
							.getOwnedAnnexSubclauses()
							.get(0)).getParsedAnnexSubclause()).getOutgoingPropagationConditions().get(0),
					condition.getOutgoingPropagationCondition());
			assertEquals("state1", condition.getSource().getName());
			assertNull(condition.getCondition());
		});
	}

	@Test
	public void testUntypedSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "untyped_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			with((SourceStateReference) condition.getSource(), source -> {
				assertEquals("state1", source.getName());
				assertEquals("state1", source.getState().getName());
				assertNull(source.getTypeSet());
			});
			assertNull(condition.getCondition());
		});
	}

	@Test
	public void testTypedSourceWithTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_with_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			with((SourceStateReference) condition.getSource(), source -> {
				assertEquals("state1 {ServiceError}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{ServiceError}", source.getTypeSet().getName());
			});
			assertNull(condition.getCondition());
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			with((SourceStateReference) condition.getSource(), source -> {
				assertEquals("state2 {ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getName());
				assertEquals("state2", source.getState().getName());
				assertEquals("{ItemTimingError, ValueRelatedError, ConcurrencyError * ReplicationError}",
						source.getTypeSet().getName());
			});
			assertNull(condition.getCondition());
		});
	}

	@Test
	public void testTypedSourceWithoutTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "typed_source_without_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			with((SourceStateReference) condition.getSource(), source -> {
				assertEquals("state1 {CommonErrors}", source.getName());
				assertEquals("state1", source.getState().getName());
				assertEquals("{CommonErrors}", source.getTypeSet().getName());
			});
			assertNull(condition.getCondition());
		});
	}

	@Test
	public void testAllSources() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_sources.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			with((AllSources) condition.getSource(), source -> {
				assertEquals("all", source.getName());
			});
			assertNull(condition.getCondition());
		});
	}

	@Test
	public void testConditionExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "condition_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("complicated_condition_expression", condition.getName());
			assertEquals("complicated_condition_expression", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3", condition.getSource().getName());
			with((CountExpression) condition.getCondition(), conditionExpression -> {
				assertEquals("count(f4 {ItemTimingError}, f5 {noerror}) == 2", conditionExpression.getName());
				assertEquals(2, conditionExpression.getOperands().size());
				with((ConditionPropagationReference) conditionExpression.getOperands().get(0), operand -> {
					assertEquals("f4 {ItemTimingError}", operand.getName());
					assertEquals("f4", operand.getPropagation().getName());
					assertEquals("{ItemTimingError}", operand.getTypeSet().getName());
				});
				with((NoErrorPropagationReference) conditionExpression.getOperands().get(1), operand -> {
					assertEquals("f5 {noerror}", operand.getName());
					assertEquals("f5", operand.getPropagation().getName());
				});
				assertEquals(CountExpressionOperation.EQUALS, conditionExpression.getOperation());
				assertEquals(2, conditionExpression.getCount());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("no_condition_expression", condition.getName());
			assertEquals("no_condition_expression", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertNull(condition.getCondition());
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("simple_condition_expression", condition.getName());
			assertEquals("simple_condition_expression", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2", condition.getSource().getName());
			with((EventReference) condition.getCondition(), conditionExpression -> {
				assertEquals("error1", conditionExpression.getName());
				assertEquals("error1", conditionExpression.getEvent().getName());
				assertNull(conditionExpression.getTypeSet());
			});
		});
	}

	@Test
	public void testDestinationWithType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "destination_with_type.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f1 {ServiceError}", destination.getName());
				assertEquals("f1", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("fg1.fg2.fg3.f2 {ServiceError}", destination.getName());
				assertEquals("fg1.fg2.fg3.f2", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("access {ServiceError}", destination.getName());
				assertEquals("access", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("processor {ServiceError}", destination.getName());
				assertEquals("processor", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testDestinationTypeFromSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "destination_type_from_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1 {ServiceError}", condition.getSource().getName());
			assertEquals("error1", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f1 {ServiceError}", destination.getName());
				assertEquals("f1", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2 {ServiceError}", condition.getSource().getName());
			assertEquals("error1", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f2 {ServiceError}", destination.getName());
				assertEquals("f2", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3 {ServiceError}", condition.getSource().getName());
			assertEquals("error2", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f3 {ServiceError}", destination.getName());
				assertEquals("f3", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4 {ServiceError}", condition.getSource().getName());
			assertEquals("error2", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f4 {ServiceError}", destination.getName());
				assertEquals("f4", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(4), condition -> {
			assertEquals("condition5", condition.getName());
			assertEquals("condition5", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state5 {ServiceError}", condition.getSource().getName());
			assertEquals("f9 {noerror}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f5 {ServiceError}", destination.getName());
				assertEquals("f5", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(5), condition -> {
			assertEquals("condition6", condition.getName());
			assertEquals("condition6", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state6 {ServiceError}", condition.getSource().getName());
			assertEquals("f9 {noerror}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f6 {ServiceError}", destination.getName());
				assertEquals("f6", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(6), condition -> {
			assertEquals("condition7", condition.getName());
			assertEquals("condition7", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state7 {ServiceError}", condition.getSource().getName());
			assertEquals("sub1.f10 {noerror}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f7 {ServiceError}", destination.getName());
				assertEquals("f7", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(7), condition -> {
			assertEquals("condition8", condition.getName());
			assertEquals("condition8", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state8 {ServiceError}", condition.getSource().getName());
			assertEquals("sub1.f10 {noerror}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f8 {ServiceError}", destination.getName());
				assertEquals("f8", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testDestinationTypeFromConditionExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "destination_type_from_condition_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertEquals("error1 {ServiceError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f1 {ServiceError}", destination.getName());
				assertEquals("f1", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2", condition.getSource().getName());
			assertEquals("f7 {ServiceError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f2 {ServiceError}", destination.getName());
				assertEquals("f2", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3", condition.getSource().getName());
			assertEquals("sub1.f9 {ServiceError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f3 {ServiceError}", destination.getName());
				assertEquals("f3", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4", condition.getSource().getName());
			assertEquals("error2 {ServiceError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f4 {ServiceError}", destination.getName());
				assertEquals("f4", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(4), condition -> {
			assertEquals("condition5", condition.getName());
			assertEquals("condition5", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state5", condition.getSource().getName());
			assertEquals("f8 {ServiceError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f5 {ServiceError}", destination.getName());
				assertEquals("f5", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(5), condition -> {
			assertEquals("condition6", condition.getName());
			assertEquals("condition6", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state6", condition.getSource().getName());
			assertEquals("sub1.f10 {ServiceError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f6 {ServiceError}", destination.getName());
				assertEquals("f6", destination.getPropagation().getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testCannotDetermingDestinationType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "cannot_determine_destination_type.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1 {ServiceError}", condition.getSource().getName());
			assertEquals("error1 {ItemTimingError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f1", destination.getName());
				assertEquals("f1", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2 {CommonErrors}", condition.getSource().getName());
			assertEquals("error1 {CommonErrors}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f2", destination.getName());
				assertEquals("f2", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3 {ServiceError, ItemTimingError}", condition.getSource().getName());
			assertEquals("error2", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f3", destination.getName());
				assertEquals("f3", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4", condition.getSource().getName());
			assertEquals("error1", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f4", destination.getName());
				assertEquals("f4", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(4), condition -> {
			assertEquals("condition5", condition.getName());
			assertEquals("condition5", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state5", condition.getSource().getName());
			assertEquals("f9 {noerror}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f5", destination.getName());
				assertEquals("f5", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(5), condition -> {
			assertEquals("condition6", condition.getName());
			assertEquals("condition6", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state6", condition.getSource().getName());
			assertEquals("sub1.f10 {noerror}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f6", destination.getName());
				assertEquals("f6", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(6), condition -> {
			assertEquals("condition7", condition.getName());
			assertEquals("condition7", condition.getOutgoingPropagationCondition().getName());
			assertEquals("all", condition.getSource().getName());
			assertEquals("error1 {CommonErrors}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f7", destination.getName());
				assertEquals("f7", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(7), condition -> {
			assertEquals("condition8", condition.getName());
			assertEquals("condition8", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state8", condition.getSource().getName());
			assertEquals("error1 {ServiceError, ItemTimingError}", condition.getCondition().getName());
			with((DestinationPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f8", destination.getName());
				assertEquals("f8", destination.getPropagation().getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
	}

	@Test
	public void testDestinationPropagationWithNoError() throws Exception {
		var pkg = testHelper.parseFile(PATH + "destination_propagation_with_no_error.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((NoErrorPropagationReference) condition.getDestination(), destination -> {
				assertEquals("f1 {noerror}", destination.getName());
				assertEquals("f1", destination.getPropagation().getName());
			});
		});
	}

	@Test
	public void testAllPropagationsWithType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_propagations_with_type.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testAllPropagationsTypeFromSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_propagations_type_from_source.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1 {ServiceError}", condition.getSource().getName());
			assertEquals("error1", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2 {ServiceError}", condition.getSource().getName());
			assertEquals("error1", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3 {ServiceError}", condition.getSource().getName());
			assertEquals("error2", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4 {ServiceError}", condition.getSource().getName());
			assertEquals("error2", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(4), condition -> {
			assertEquals("condition5", condition.getName());
			assertEquals("condition5", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state5 {ServiceError}", condition.getSource().getName());
			assertEquals("f1 {noerror}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(5), condition -> {
			assertEquals("condition6", condition.getName());
			assertEquals("condition6", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state6 {ServiceError}", condition.getSource().getName());
			assertEquals("f1 {noerror}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(6), condition -> {
			assertEquals("condition7", condition.getName());
			assertEquals("condition7", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state7 {ServiceError}", condition.getSource().getName());
			assertEquals("sub1.f2 {noerror}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(7), condition -> {
			assertEquals("condition8", condition.getName());
			assertEquals("condition8", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state8 {ServiceError}", condition.getSource().getName());
			assertEquals("sub1.f2 {noerror}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testAllPropagationsTypeFromConditionExpression() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_propagations_type_from_condition_expression.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertEquals("error1 {ServiceError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2", condition.getSource().getName());
			assertEquals("f1 {ServiceError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3", condition.getSource().getName());
			assertEquals("sub1.f3 {ServiceError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4", condition.getSource().getName());
			assertEquals("error2 {ServiceError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(4), condition -> {
			assertEquals("condition5", condition.getName());
			assertEquals("condition5", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state5", condition.getSource().getName());
			assertEquals("f2 {ServiceError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
		with(annexInstance.getConditions().get(5), condition -> {
			assertEquals("condition6", condition.getName());
			assertEquals("condition6", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state6", condition.getSource().getName());
			assertEquals("sub1.f4 {ServiceError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all {ServiceError}", destination.getName());
				assertEquals("{ServiceError}", destination.getTypeSet().getName());
				assertEquals("ServiceError", destination.getTypeToken().getName());
			});
		});
	}

	@Test
	public void testAllPropagationsCannotDetermineType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_propagations_cannot_determine_type.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1 {ServiceError}", condition.getSource().getName());
			assertEquals("error1 {ItemTimingError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(1), condition -> {
			assertEquals("condition2", condition.getName());
			assertEquals("condition2", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state2 {CommonErrors}", condition.getSource().getName());
			assertEquals("error1 {CommonErrors}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(2), condition -> {
			assertEquals("condition3", condition.getName());
			assertEquals("condition3", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state3 {ServiceError, ItemTimingError}", condition.getSource().getName());
			assertEquals("error2", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(3), condition -> {
			assertEquals("condition4", condition.getName());
			assertEquals("condition4", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state4", condition.getSource().getName());
			assertEquals("error1", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(4), condition -> {
			assertEquals("condition5", condition.getName());
			assertEquals("condition5", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state5", condition.getSource().getName());
			assertEquals("f1 {noerror}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(5), condition -> {
			assertEquals("condition6", condition.getName());
			assertEquals("condition6", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state6", condition.getSource().getName());
			assertEquals("sub1.f2 {noerror}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(6), condition -> {
			assertEquals("condition7", condition.getName());
			assertEquals("condition7", condition.getOutgoingPropagationCondition().getName());
			assertEquals("all", condition.getSource().getName());
			assertEquals("error1 {CommonErrors}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
		with(annexInstance.getConditions().get(7), condition -> {
			assertEquals("condition8", condition.getName());
			assertEquals("condition8", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state8", condition.getSource().getName());
			assertEquals("error1 {ServiceError, ItemTimingError}", condition.getCondition().getName());
			with((AllPropagations) condition.getDestination(), destination -> {
				assertEquals("all", destination.getName());
				assertNull(destination.getTypeSet());
				assertNull(destination.getTypeToken());
			});
		});
	}

	@Test
	public void testAllPropagationsNoError() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_propagations_no_error.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getConditions().size());
		with(annexInstance.getConditions().get(0), condition -> {
			assertEquals("condition1", condition.getName());
			assertEquals("condition1", condition.getOutgoingPropagationCondition().getName());
			assertEquals("state1", condition.getSource().getName());
			assertNull(condition.getCondition());
			with((AllPropagationsNoError) condition.getDestination(), destination -> {
				assertEquals("all {noerror}", destination.getName());
			});
		});
	}
}