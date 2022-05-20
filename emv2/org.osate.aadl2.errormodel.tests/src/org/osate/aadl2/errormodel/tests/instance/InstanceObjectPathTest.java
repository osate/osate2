package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.pluginsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.TypeProductInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class InstanceObjectPathTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testInstanceObjectPath() throws Exception {
		var pkg = testHelper.parseFile(
				"org.osate.aadl2.errormodel.tests/models/instantiation/Flows/error_path_with_product_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		with(InstantiateModel.instantiate(system), systemInstance -> {
			assertEquals("s_i_Instance.f_in", systemInstance.getFeatureInstances().get(0).getInstanceObjectPath());
			assertEquals("s_i_Instance.f_out", systemInstance.getFeatureInstances().get(1).getInstanceObjectPath());
			with((EMV2AnnexInstance) systemInstance.getAnnexInstances().get(0), annex -> {
				with(annex.getPropagations().get(0), propagation -> {
					assertEquals("s_i_Instance.EMV2.f_in", propagation.getInstanceObjectPath());
					assertEquals("s_i_Instance.EMV2.f_in.{ServiceError}",
							propagation.getInTypeSet().getInstanceObjectPath());
					assertEquals("s_i_Instance.EMV2.f_in.{ServiceError}.ServiceError",
							propagation.getInTypeSet().getElements().get(0).getInstanceObjectPath());
				});
				with(annex.getPropagations().get(1), propagation -> {
					assertEquals(
							"s_i_Instance.EMV2.f_out.{ConcurrencyError, ConcurrencyError * ReplicationError}.ConcurrencyError * ReplicationError",
							propagation.getOutTypeSet().getElements().get(1).getInstanceObjectPath());
					assertEquals(
							"s_i_Instance.EMV2.f_out.{ConcurrencyError, ConcurrencyError * ReplicationError}.ConcurrencyError * ReplicationError.ReplicationError",
							((TypeProductInstance) propagation.getOutTypeSet().getElements().get(1)).getTypes()
									.get(1)
									.getInstanceObjectPath());
				});
				assertEquals("s_i_Instance.EMV2.path_1", annex.getErrorFlows().get(0).getInstanceObjectPath());
			});
		});
	}
}