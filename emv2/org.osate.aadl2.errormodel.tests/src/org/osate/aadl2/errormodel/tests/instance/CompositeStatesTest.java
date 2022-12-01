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
import org.osate.aadl2.errormodel.instance.ConditionPropagationReference;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.NoErrorPropagationReference;
import org.osate.aadl2.errormodel.instance.StateReference;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class CompositeStatesTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/CompositeStates/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testOverriddenComposite() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_composite.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("COMPOSITE1", composite.getName());
			assertEquals("COMPOSITE1", composite.getComposite().getName());
		});
	}

	@Test
	public void testInheritUnnamedComposite() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherit_unnamed_composite.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			// TODO Test name after we generate names for unnamed composites.
			assertNull(composite.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().get(0))
					.getParsedAnnexSubclause()).getStates().get(0), composite.getComposite());
		});
		with(annexInstance.getComposites().get(1), composite -> {
			// TODO Test name after we generate names for unnamed composites.
			assertNull(composite.getName());
			assertSame(((ErrorModelSubclause) ((DefaultAnnexSubclause) pkg.getPublicSection()
					.getOwnedClassifiers()
					.get(0)
					.getOwnedAnnexSubclauses()
					.get(0)).getParsedAnnexSubclause()).getStates().get(0), composite.getComposite());
		});
	}

	@Test
	public void testPropagationReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagation_reference.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("f1 {CommonErrors}", condition.getName());
				assertEquals("f1", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("composite2", composite.getName());
			assertEquals("composite2", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("f2 {ServiceError}", condition.getName());
				assertEquals("f2", condition.getPropagation().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(2), composite -> {
			assertEquals("composite3", composite.getName());
			assertEquals("composite3", composite.getComposite().getName());
			with((NoErrorPropagationReference) composite.getCondition(), condition -> {
				assertEquals("f3 {noerror}", condition.getName());
				assertEquals("f3", condition.getPropagation().getName());
			});
		});
		with(annexInstance.getComposites().get(3), composite -> {
			assertEquals("composite4", composite.getName());
			assertEquals("composite4", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("memory {CommonErrors}", condition.getName());
				assertEquals("memory", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(4), composite -> {
			assertEquals("composite5", composite.getName());
			assertEquals("composite5", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("fg1.f4 {ServiceError, ItemTimingError}", condition.getName());
				assertEquals("fg1.f4", condition.getPropagation().getName());
				assertEquals("{ServiceError, ItemTimingError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(5), composite -> {
			assertEquals("composite6", composite.getName());
			assertEquals("composite6", composite.getComposite().getName());
			with((ConditionPropagationReference) composite.getCondition(), condition -> {
				assertEquals("fg1.fg2.fg3.f5 {CommonErrors}", condition.getName());
				assertEquals("fg1.fg2.fg3.f5", condition.getPropagation().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
	}

	@Test
	public void testStateReference() throws Exception {
		var pkg = testHelper.parseFile(PATH + "state_reference.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(6, annexInstance.getComposites().size());
		with(annexInstance.getComposites().get(0), composite -> {
			assertEquals("composite1", composite.getName());
			assertEquals("composite1", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.state1", condition.getName());
				assertEquals("state1", condition.getState().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getComposites().get(1), composite -> {
			assertEquals("composite2", composite.getName());
			assertEquals("composite2", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.state2 {ServiceError}", condition.getName());
				assertEquals("state2", condition.getState().getName());
				assertEquals("{ServiceError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(2), composite -> {
			assertEquals("composite3", composite.getName());
			assertEquals("composite3", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.state3 {CommonErrors}", condition.getName());
				assertEquals("state3", condition.getState().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(3), composite -> {
			assertEquals("composite4", composite.getName());
			assertEquals("composite4", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.state4", condition.getName());
				assertEquals("state4", condition.getState().getName());
				assertNull(condition.getTypeSet());
			});
		});
		with(annexInstance.getComposites().get(4), composite -> {
			assertEquals("composite5", composite.getName());
			assertEquals("composite5", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.state5 {ServiceError, ItemTimingError}", condition.getName());
				assertEquals("state5", condition.getState().getName());
				assertEquals("{ServiceError, ItemTimingError}", condition.getTypeSet().getName());
			});
		});
		with(annexInstance.getComposites().get(5), composite -> {
			assertEquals("composite6", composite.getName());
			assertEquals("composite6", composite.getComposite().getName());
			with((StateReference) composite.getCondition(), condition -> {
				assertEquals("sub1.sub2.sub3.state6 {CommonErrors}", condition.getName());
				assertEquals("state6", condition.getState().getName());
				assertEquals("{CommonErrors}", condition.getTypeSet().getName());
			});
		});
	}
}