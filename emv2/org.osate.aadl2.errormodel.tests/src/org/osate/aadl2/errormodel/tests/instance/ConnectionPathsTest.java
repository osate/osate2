package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.osate.testsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
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
			assertIterableEquals(List.of("out_f"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("right_feature_group.in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("right_feature_group_1.right_feature_group_2.right_feature_group_3.in_f"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("in_fg"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("in_fg.f_1"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
		});
		with((ConnectionPath) annexInstance.getPropagationPaths().get(1), connectionPath -> {
			assertEquals("left.out_fg.f_2 -> right.in_fg.f_2", connectionPath.getName());
			assertEquals("left.out_fg.f_2 -> right.in_fg.f_2", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_fg.f_2"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("in_fg.f_2"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
		});
		with((ConnectionPath) annexInstance.getPropagationPaths().get(2), connectionPath -> {
			assertEquals("left.out_fg.f_3 -> right.in_fg.f_3", connectionPath.getName());
			assertEquals("left.out_fg.f_3 -> right.in_fg.f_3", connectionPath.getConnection().getName());
			assertIterableEquals(List.of("out_fg.f_3"),
					connectionPath.getSourcePropagations().stream().map(NamedElement::getName).toList());
			assertIterableEquals(List.of("in_fg.f_3"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("in_f_thread", "in_f_tg", "in_f_process"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
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
			assertIterableEquals(List.of("in_f_tg", "in_f_process"),
					connectionPath.getDestinationPropagations().stream().map(NamedElement::getName).toList());
		});
	}
}