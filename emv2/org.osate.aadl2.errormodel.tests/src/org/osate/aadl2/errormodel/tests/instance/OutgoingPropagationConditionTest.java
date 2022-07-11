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
import org.osate.aadl2.errormodel.instance.AllSources;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
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
		});
	}
}