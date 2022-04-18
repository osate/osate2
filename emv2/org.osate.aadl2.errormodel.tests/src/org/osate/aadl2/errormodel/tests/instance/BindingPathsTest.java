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
}