package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.testsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.ConnectionPath;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.instantiator.EMV2AnnexInstantiator;
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

	@BeforeAll
	public static void enableEMV2Instantiator() {
		System.setProperty(EMV2AnnexInstantiator.PROPERTY_NAME, "true");
	}

	@Test
	public void testAcrossPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "across_path_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("left.out_f -> right.in_f", connectionPath.getName());
			assertEquals("left.out_f -> right.in_f", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_f"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_f", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
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
			assertIterableEquals(List.of("out_f"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_f", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_f", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testDownPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "down_path_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		// Tests that down connection paths are not instantiated.
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testUpPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "up_path_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		// Tests that up connection paths are not instantiated.
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testFeatureInFeatureGroup() throws Exception {
		var pkg = testHelper.parseFile(PATH + "feature_in_feature_group_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("left.left_feature_group.out_f -> right.right_feature_group.in_f", connectionPath.getName());
			assertEquals("left.left_feature_group.out_f -> right.right_feature_group.in_f",
					connectionPath.getConnection().getName());
			assertIterableEquals(List.of("left_feature_group.out_f"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("left_feature_group.out_f", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("right_feature_group.in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("right_feature_group.in_f", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testFeatureInMultipleFeatureGroups() throws Exception {
		var pkg = testHelper.parseFile(PATH + "feature_in_multiple_feature_groups_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals(
					"left.left_feature_group_1.left_feature_group_2.left_feature_group_3.out_f -> right.right_feature_group_1.right_feature_group_2.right_feature_group_3.in_f",
					connectionPath.getName());
			assertEquals(
					"left.left_feature_group_1.left_feature_group_2.left_feature_group_3.out_f -> right.right_feature_group_1.right_feature_group_2.right_feature_group_3.in_f",
					connectionPath.getConnection().getName());
			assertIterableEquals(List.of("left_feature_group_1.left_feature_group_2.left_feature_group_3.out_f"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("left_feature_group_1.left_feature_group_2.left_feature_group_3.out_f",
					connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("right_feature_group_1.right_feature_group_2.right_feature_group_3.in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("right_feature_group_1.right_feature_group_2.right_feature_group_3.in_f",
					connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testEmptyFeatureGroup() throws Exception {
		var pkg = testHelper.parseFile(PATH + "empty_feature_group_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("left.out_fg -> right.in_fg", connectionPath.getName());
			assertEquals("left.out_fg -> right.in_fg", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_fg"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_fg", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_fg"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_fg", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testFeatureGroupWithFeatures() throws Exception {
		var pkg = testHelper.parseFile(PATH + "feature_group_with_features_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("left.out_fg.f_1 -> right.in_fg.f_1", connectionPath.getName());
			assertEquals("left.out_fg.f_1 -> right.in_fg.f_1", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_fg.f_1"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_fg.f_1", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_fg.f_1"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_fg.f_1", connectionPath.getDestinationPropagation().getName());
		});
		with((ConnectionPath) annexInstance.getPropagationPaths().get(1), connectionPath -> {
			assertEquals("left.out_fg.f_2 -> right.in_fg.f_2", connectionPath.getName());
			assertEquals("left.out_fg.f_2 -> right.in_fg.f_2", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_fg.f_2"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_fg.f_2", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_fg.f_2"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_fg.f_2", connectionPath.getDestinationPropagation().getName());
		});
		with((ConnectionPath) annexInstance.getPropagationPaths().get(2), connectionPath -> {
			assertEquals("left.out_fg.f_3 -> right.in_fg.f_3", connectionPath.getName());
			assertEquals("left.out_fg.f_3 -> right.in_fg.f_3", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_fg.f_3"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_fg.f_3", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_fg.f_3"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_fg.f_3", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testPropagationsOnEveryLevel() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagations_on_every_level.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals(
					"left_process.left_tg.left_thread.out_f_thread -> right_process.right_tg.right_thread.in_f_thread",
					connectionPath.getName());
			assertEquals(
					"left_process.left_tg.left_thread.out_f_thread -> right_process.right_tg.right_thread.in_f_thread",
					connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_f_thread", "out_f_tg", "out_f_process"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_f_thread", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_f_thread", "in_f_tg", "in_f_process"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_f_thread", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testPropagationsOnSomeLevels() throws Exception {
		var pkg = testHelper.parseFile(PATH + "propagations_on_some_levels.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals(
					"left_process.left_tg.left_thread.out_f_thread -> right_process.right_tg.right_thread.in_f_thread",
					connectionPath.getName());
			assertEquals(
					"left_process.left_tg.left_thread.out_f_thread -> right_process.right_tg.right_thread.in_f_thread",
					connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_f_thread", "out_f_process"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("out_f_thread", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("in_f_tg", "in_f_process"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("in_f_tg", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testWrongDirection() throws Exception {
		var pkg = testHelper.parseFile(PATH + "wrong_direction.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		// Tests that propagation paths which go the wrong direction are not instantiated.
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testBidirectional() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bidirectional.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("right.right_feature -> left.left_feature", connectionPath.getName());
			assertEquals("right.right_feature -> left.left_feature", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("right_feature"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("right_feature", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("left_feature"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("left_feature", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAccessPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "access_path.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("b -> m.ba", connectionPath.getName());
			assertEquals("b -> m.ba", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("access"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("access", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("ba"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("ba", connectionPath.getDestinationPropagation().getName());
		});
		with((ConnectionPath) annexInstance.getPropagationPaths().get(1), connectionPath -> {
			assertEquals("m.ba -> b", connectionPath.getName());
			assertEquals("m.ba -> b", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("ba"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("ba", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("access"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("access", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAccessPathOneWay() throws Exception {
		var pkg = testHelper.parseFile(PATH + "access_path_one_way.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals("m.ba -> b", connectionPath.getName());
			assertEquals("m.ba -> b", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("ba"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("ba", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("access"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("access", connectionPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAccessPathOnEveryLevel() throws Exception {
		var pkg = testHelper.parseFile(PATH + "access_path_on_every_level.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((ConnectionPath) annexInstance.getPropagationPaths().get(0), connectionPath -> {
			assertEquals(
					"left_top.left_middle.left_bottom.b -> right_top.right_middle.right_bottom.m.requires_ba_memory",
					connectionPath.getName());
			assertEquals(
					"left_top.left_middle.left_bottom.b -> right_top.right_middle.right_bottom.m.requires_ba_memory",
					connectionPath.getConnection().getName());
			assertIterableEquals(List.of("access", "provides_ba_bottom", "provides_ba_middle", "provides_ba_top"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("access", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(
					List.of("requires_ba_memory", "requires_ba_bottom", "requires_ba_middle", "requires_ba_top"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("requires_ba_memory", connectionPath.getDestinationPropagation().getName());
		});
		with((ConnectionPath) annexInstance.getPropagationPaths().get(1), connectionPath -> {
			assertEquals(
					"right_top.right_middle.right_bottom.m.requires_ba_memory -> left_top.left_middle.left_bottom.b",
					connectionPath.getName());
			assertEquals(
					"right_top.right_middle.right_bottom.m.requires_ba_memory -> left_top.left_middle.left_bottom.b",
					connectionPath.getConnection().getName());
			assertIterableEquals(
					List.of("requires_ba_memory", "requires_ba_bottom", "requires_ba_middle", "requires_ba_top"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceConnectionPaths().contains(connectionPath));
			});
			assertEquals("requires_ba_memory", connectionPath.getSourcePropagation().getName());
			assertIterableEquals(List.of("access", "provides_ba_bottom", "provides_ba_middle", "provides_ba_top"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
			connectionPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationConnectionPaths().contains(connectionPath));
			});
			assertEquals("access", connectionPath.getDestinationPropagation().getName());
		});
	}
}