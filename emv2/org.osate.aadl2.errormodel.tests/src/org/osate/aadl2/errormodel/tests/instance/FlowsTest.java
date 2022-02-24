package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.testsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.instance.ErrorPathInstance;
import org.osate.aadl2.errormodel.instance.ErrorSinkInstance;
import org.osate.aadl2.errormodel.instance.ErrorSourceInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class FlowsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/Flows/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testErrorSource() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_source_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("f", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ServiceError, ItemTimingError}", source.getTypeSet().getName());
		});
	}

	@Test
	public void testErrorSourceNoTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_source_no_types_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("f", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ServiceError, ItemTimingError, SequenceTimingError}", source.getTypeSet().getName());
		});
	}

	@Test
	public void testErrorSourceAll() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_source_all_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that 'all' error sources are not instantiated.
		assertEquals(0, annexInstance.getErrorFlows().size());
	}

	@Test
	public void testErrorSink() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_sink_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getErrorFlows().size());
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(0), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("f", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{ServiceError, ItemTimingError}", sink.getTypeSet().getName());
		});
	}

	@Test
	public void testErrorSinkNoTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_sink_no_types_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getErrorFlows().size());
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(0), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("f", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{ServiceError, ItemTimingError, SequenceTimingError}", sink.getTypeSet().getName());
		});
	}

	@Test
	public void testErrorSinkAll() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_sink_all_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that 'all' error sinks are not instantiated.
		assertEquals(0, annexInstance.getErrorFlows().size());
	}

	@Test
	public void testErrorPath() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_path_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getErrorFlows().size());
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(0), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("f_in", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{ServiceError}", path.getSourceTypeSet().getName());
			assertEquals("f_out", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ServiceError", path.getDestinationTypeToken().getName());
		});
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(1), path -> {
			assertEquals("path_2", path.getName());
			assertEquals("path_2", path.getErrorPath().getName());
			assertEquals("f_in", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{ItemTimingError, SequenceTimingError}", path.getSourceTypeSet().getName());
			assertEquals("f_out", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ConcurrencyError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testErrorPathWithProduct() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_path_with_product_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getErrorFlows().size());
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(0), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("f_in", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{ServiceError}", path.getSourceTypeSet().getName());
			assertEquals("f_out", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ConcurrencyError * ReplicationError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testErrorPathNoIncomingTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_path_no_incoming_types_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getErrorFlows().size());
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(0), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("f_in", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{ServiceError, ItemTimingError, SequenceTimingError}", path.getSourceTypeSet().getName());
			assertEquals("f_out", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ServiceError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testErrorPathNoOutgoingType() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_path_no_outgoing_type_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that error paths without a target type are not instantiated.
		assertEquals(0, annexInstance.getErrorFlows().size());
	}

	@Test
	public void testErrorPathWithUseMappings() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_path_with_use_mappings_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that error paths with a use mappings are not instantiated.
		assertEquals(0, annexInstance.getErrorFlows().size());
	}

	@Test
	public void testErrorPathAll() throws Exception {
		var pkg = testHelper.parseFile(PATH + "error_path_all_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that 'all' error paths are not instantiated.
		assertEquals(0, annexInstance.getErrorFlows().size());
	}

	@Test
	public void testOverriddenFlow() throws Exception {
		var pkg = testHelper.parseFile(PATH + "overridden_flow_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(2);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("f_out", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ItemValueError}", source.getTypeSet().getName());
		});
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(1), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("f_in", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{SequenceValueError}", sink.getTypeSet().getName());
		});
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(2), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("f_in", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{ServiceValueError}", path.getSourceTypeSet().getName());
			assertEquals("f_out", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ReplicationError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testFindFeaturePropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "find_feature_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("f_out", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ServiceError}", source.getTypeSet().getName());
		});
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(1), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("f_in", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{ItemTimingError}", sink.getTypeSet().getName());
		});
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(2), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("f_in", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{SequenceTimingError}", path.getSourceTypeSet().getName());
			assertEquals("f_out", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ServiceTimingError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testFindInternalFeaturePropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "find_internal_feature_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		// Tests that error flows which refer to propagations which refer to internal features are not instantiated.
		assertEquals(0, annexInstance.getErrorFlows().size());
	}

	@Test
	public void testFindPointPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "find_point_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("point2", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ServiceError}", source.getTypeSet().getName());
		});
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(1), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("point1", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{ItemTimingError}", sink.getTypeSet().getName());
		});
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(2), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("point1", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{SequenceTimingError}", path.getSourceTypeSet().getName());
			assertEquals("point2", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ServiceTimingError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testFindAccessPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "find_access_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("access", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ServiceError}", source.getTypeSet().getName());
		});
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(1), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("access", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{ItemTimingError}", sink.getTypeSet().getName());
		});
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(2), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("access", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{SequenceTimingError}", path.getSourceTypeSet().getName());
			assertEquals("access", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ServiceTimingError", path.getDestinationTypeToken().getName());
		});
	}

	@Test
	public void testFindBindingPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "find_binding_propagation_test.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(3, annexInstance.getErrorFlows().size());
		with((ErrorSourceInstance) annexInstance.getErrorFlows().get(0), source -> {
			assertEquals("source_1", source.getName());
			assertEquals("source_1", source.getErrorSource().getName());
			assertEquals("memory", source.getPropagation().getName());
			assertTrue(source.getPropagation().getErrorSources().contains(source));
			assertEquals("{ServiceError}", source.getTypeSet().getName());
		});
		with((ErrorSinkInstance) annexInstance.getErrorFlows().get(1), sink -> {
			assertEquals("sink_1", sink.getName());
			assertEquals("sink_1", sink.getErrorSink().getName());
			assertEquals("processor", sink.getPropagation().getName());
			assertTrue(sink.getPropagation().getErrorSinks().contains(sink));
			assertEquals("{ItemTimingError}", sink.getTypeSet().getName());
		});
		with((ErrorPathInstance) annexInstance.getErrorFlows().get(2), path -> {
			assertEquals("path_1", path.getName());
			assertEquals("path_1", path.getErrorPath().getName());
			assertEquals("processor", path.getSourcePropagation().getName());
			assertTrue(path.getSourcePropagation().getSourceErrorPaths().contains(path));
			assertEquals("{SequenceTimingError}", path.getSourceTypeSet().getName());
			assertEquals("memory", path.getDestinationPropagation().getName());
			assertTrue(path.getDestinationPropagation().getDestinationErrorPaths().contains(path));
			assertEquals("ServiceTimingError", path.getDestinationTypeToken().getName());
		});
	}
}