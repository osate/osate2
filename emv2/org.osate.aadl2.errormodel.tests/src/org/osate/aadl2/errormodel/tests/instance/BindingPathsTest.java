package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.osate.testsupport.ScopeFunctions.with;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@ExtendWith(InjectionExtension.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class BindingPathsTest {
	private static final String PATH = "org.osate.aadl2.errormodel.tests/models/instantiation/BindingPaths/";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void testThreadToProcessor() throws Exception {
		var pkg = testHelper.parseFile(PATH + "thread_to_processor.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: ps.t.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testProcessorToThread() throws Exception {
		var pkg = testHelper.parseFile(PATH + "processor_to_thread.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: proc.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testBidirectionalProcessorAndThread() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bidirectional_processor_and_thread.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: ps.t.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Processor Binding: proc.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testMultipleProcessors() throws Exception {
		var pkg = testHelper.parseFile(PATH + "multiple_processors.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: ps.t.EMV2.processor -> proc1.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Processor Binding: proc1.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Processor Binding: ps.t.EMV2.processor -> proc2.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Processor Binding: proc2.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAllProcessorBindingTargetTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_processor_binding_target_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(10, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: ps.t1.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Processor Binding: proc.EMV2.bindings -> ps.t1.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Processor Binding: ps.t2.EMV2.processor -> vp.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Processor Binding: vp.EMV2.bindings -> ps.t2.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("Processor Binding: ps.t3.EMV2.processor -> s2.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("Processor Binding: s2.EMV2.bindings -> ps.t3.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("Processor Binding: ps.t4.EMV2.processor -> dev.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("Processor Binding: dev.EMV2.bindings -> ps.t4.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("Processor Binding: ps.t5.EMV2.processor -> a.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("Processor Binding: a.EMV2.bindings -> ps.t5.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAllProcessorBindingSourceTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_processor_binding_source_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(12, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: dev.EMV2.processor -> proc6.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Processor Binding: proc6.EMV2.bindings -> dev.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Processor Binding: ps.EMV2.processor -> proc3.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Processor Binding: proc3.EMV2.bindings -> ps.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("Processor Binding: ps.t.EMV2.processor -> proc1.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("Processor Binding: proc1.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("Processor Binding: ps.tg.EMV2.processor -> proc2.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("Processor Binding: proc2.EMV2.bindings -> ps.tg.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("Processor Binding: s2.EMV2.processor -> proc4.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("Processor Binding: proc4.EMV2.bindings -> s2.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(10), bindingPath -> {
			assertEquals("Processor Binding: vp.EMV2.processor -> proc5.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(11), bindingPath -> {
			assertEquals("Processor Binding: proc5.EMV2.bindings -> vp.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testInheritedProcessorBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_processor_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Processor Binding: ps.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Processor Binding: proc.EMV2.bindings -> ps.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Processor Binding: ps.t.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals("processor", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Processor Binding: proc.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("processor", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testDataToMemory() throws Exception {
		var pkg = testHelper.parseFile(PATH + "data_to_memory.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: d.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testMemoryToData() throws Exception {
		var pkg = testHelper.parseFile(PATH + "memory_to_data.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testBidirectionalMemoryAndData() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bidirectional_memory_and_data.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: d.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testMultipleMemory() throws Exception {
		var pkg = testHelper.parseFile(PATH + "multiple_memory.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(4, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: d.EMV2.memory -> m1.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Memory Binding: m1.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Memory Binding: d.EMV2.memory -> m2.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Memory Binding: m2.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAllMemoryBindingTargetTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_memory_binding_target_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(10, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: d1.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> d1.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Memory Binding: d2.EMV2.memory -> s2.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Memory Binding: s2.EMV2.bindings -> d2.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("Memory Binding: d3.EMV2.memory -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("Memory Binding: proc.EMV2.bindings -> d3.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("Memory Binding: d4.EMV2.memory -> vp.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("Memory Binding: vp.EMV2.bindings -> d4.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("Memory Binding: d5.EMV2.memory -> a.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("Memory Binding: a.EMV2.bindings -> d5.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testAllMemoryBindingSourceTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_memory_binding_source_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(22, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: d.EMV2.memory -> m9.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Memory Binding: m9.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Memory Binding: dev.EMV2.memory -> m8.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Memory Binding: m8.EMV2.bindings -> dev.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("Memory Binding: m_source.EMV2.memory -> m1.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("Memory Binding: m1.EMV2.bindings -> m_source.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("Memory Binding: ps.EMV2.memory -> m4.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("Memory Binding: m4.EMV2.bindings -> ps.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("Memory Binding: ps.tg.EMV2.memory -> m3.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("Memory Binding: m3.EMV2.bindings -> ps.tg.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(10), bindingPath -> {
			assertEquals("Memory Binding: ps.tg.t.EMV2.memory -> m2.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(11), bindingPath -> {
			assertEquals("Memory Binding: m2.EMV2.bindings -> ps.tg.t.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(12), bindingPath -> {
			assertEquals("Memory Binding: proc.EMV2.memory -> m6.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(13), bindingPath -> {
			assertEquals("Memory Binding: m6.EMV2.bindings -> proc.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(14), bindingPath -> {
			assertEquals("Memory Binding: subp.EMV2.memory -> m12.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(15), bindingPath -> {
			assertEquals("Memory Binding: m12.EMV2.bindings -> subp.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(16), bindingPath -> {
			assertEquals("Memory Binding: subpg.EMV2.memory -> m13.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(17), bindingPath -> {
			assertEquals("Memory Binding: m13.EMV2.bindings -> subpg.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(18), bindingPath -> {
			assertEquals("Memory Binding: s2.EMV2.memory -> m5.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(19), bindingPath -> {
			assertEquals("Memory Binding: m5.EMV2.bindings -> s2.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(20), bindingPath -> {
			assertEquals("Memory Binding: vp.EMV2.memory -> m7.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(21), bindingPath -> {
			assertEquals("Memory Binding: m7.EMV2.bindings -> vp.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
	}

	@Test
	public void testInheritedMemoryBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_memory_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(8, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("Memory Binding: ps.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> ps.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("Memory Binding: ps.tg.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> ps.tg.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("Memory Binding: ps.tg.t.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> ps.tg.t.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("Memory Binding: ps.tg.t.d.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals("memory", bindingPath.getSourcePropagation().getName());
			assertEquals("bindings", bindingPath.getDestinationPropagation().getName());
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("Memory Binding: m.EMV2.bindings -> ps.tg.t.d.EMV2.memory", bindingPath.getName());
			assertEquals("bindings", bindingPath.getSourcePropagation().getName());
			assertEquals("memory", bindingPath.getDestinationPropagation().getName());
		});
	}
}