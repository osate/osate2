package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.testsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class ConnectionPathsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/ConnectionPaths/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testAcrossPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "across_path_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("left.out_f -> right.in_f", connectionPath.getName());
			assertEquals("left.out_f -> right.in_f", connectionPath.getConnection().getName());
			assertEquals("out_f", connectionPath.getSourcePropagation().getName());
			assertEquals("in_f", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAcrossPathNotAtRoot() throws Exception {
		var pkg = testHelper.parseFile(PATH + "across_path_not_at_root_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var top = InstantiateModel.instantiate(system);
		var middle = top.getComponentInstances().get(0);
		var bottom = middle.getComponentInstances().get(0);
		var annexInstance = (EMV2AnnexInstance) bottom.getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("left.out_f -> right.in_f", connectionPath.getName());
			assertEquals("left.out_f -> right.in_f", connectionPath.getConnection().getName());
			assertEquals("out_f", connectionPath.getSourcePropagation().getName());
			assertEquals("in_f", connectionPath.getDestinationPropagation().getName());
		});
	}
}