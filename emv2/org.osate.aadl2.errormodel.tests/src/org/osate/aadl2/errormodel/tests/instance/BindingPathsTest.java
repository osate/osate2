package org.osate.aadl2.errormodel.tests.instance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.osate.testsupport.ScopeFunctions.with;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.errormodel.instance.BindingPath;
import org.osate.aadl2.errormodel.instance.BindingType;
import org.osate.aadl2.errormodel.instance.EMV2AnnexInstance;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.aadl2.instance.InstanceObject;
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
			assertEquals("ps.t.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testProcessorToThread() throws Exception {
		var pkg = testHelper.parseFile(PATH + "processor_to_thread.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("proc.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testBidirectionalProcessorAndThread() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bidirectional_processor_and_thread.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("ps.t.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("proc.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testMultipleProcessors() throws Exception {
		var pkg = testHelper.parseFile(PATH + "multiple_processors.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("ps.t.EMV2.processor -> (proc1.EMV2.bindings, proc2.EMV2.bindings)",
					bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc1.EMV2.bindings", "s_i_Instance.proc2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("(proc1.EMV2.bindings, proc2.EMV2.bindings) -> ps.t.EMV2.processor",
					bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc1.EMV2.bindings", "s_i_Instance.proc2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testAllProcessorBindingTargetTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_processor_binding_target_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(10, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("ps.t1.EMV2.processor -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t1.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("proc.EMV2.bindings -> ps.t1.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t1.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("ps.t2.EMV2.processor -> vp.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t2.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("vp.EMV2.bindings -> ps.t2.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t2.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("ps.t3.EMV2.processor -> s2.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t3.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("s2.EMV2.bindings -> ps.t3.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t3.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("ps.t4.EMV2.processor -> dev.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t4.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("dev.EMV2.bindings -> ps.t4.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t4.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("ps.t5.EMV2.processor -> a.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t5.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.a.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("a.EMV2.bindings -> ps.t5.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.a.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t5.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testAllProcessorBindingSourceTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_processor_binding_source_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(12, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("dev.EMV2.processor -> proc6.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc6.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("proc6.EMV2.bindings -> dev.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc6.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("ps.EMV2.processor -> proc3.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc3.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("proc3.EMV2.bindings -> ps.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc3.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("ps.t.EMV2.processor -> proc1.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc1.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("proc1.EMV2.bindings -> ps.t.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc1.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("ps.tg.EMV2.processor -> proc2.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.tg.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("proc2.EMV2.bindings -> ps.tg.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.tg.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("s2.EMV2.processor -> proc4.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc4.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("proc4.EMV2.bindings -> s2.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc4.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(10), bindingPath -> {
			assertEquals("vp.EMV2.processor -> proc5.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc5.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(11), bindingPath -> {
			assertEquals("proc5.EMV2.bindings -> vp.EMV2.processor", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc5.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testInheritedProcessorBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_processor_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("(ps.EMV2.processor, ps.t.EMV2.processor) -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.processor", "s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("proc.EMV2.bindings -> (ps.EMV2.processor, ps.t.EMV2.processor)", bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.processor", "s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testInheritedProcessorBindingWithMultipleProcessors() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_processor_binding_with_multiple_processors.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("(ps.EMV2.processor, ps.t.EMV2.processor) -> (proc1.EMV2.bindings, proc2.EMV2.bindings)",
					bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.processor", "s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc1.EMV2.bindings", "s_i_Instance.proc2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("(proc1.EMV2.bindings, proc2.EMV2.bindings) -> (ps.EMV2.processor, ps.t.EMV2.processor)",
					bindingPath.getName());
			assertEquals(BindingType.PROCESSOR, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc1.EMV2.bindings", "s_i_Instance.proc2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.processor", "s_i_Instance.ps.t.EMV2.processor"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testSeparatedInheritedProcessorBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "separated_inherited_processor_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var instance = InstantiateModel.instantiate(system);
		with(instance.getComponentInstances().get(0), component -> {
			assertEquals("a", component.getName());
			var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
			assertEquals(2, annexInstance.getPropagationPaths().size());
			with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
				assertEquals("(ps.EMV2.processor, ps.t.EMV2.processor) -> proc.EMV2.bindings", bindingPath.getName());
				assertEquals(BindingType.PROCESSOR, bindingPath.getType());
				assertIterableEquals(
						List.of("top_i_Instance.a.ps.EMV2.processor", "top_i_Instance.a.ps.t.EMV2.processor"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(List.of("top_i_Instance.a.proc.EMV2.bindings"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
			with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
				assertEquals("proc.EMV2.bindings -> (ps.EMV2.processor, ps.t.EMV2.processor)", bindingPath.getName());
				assertEquals(BindingType.PROCESSOR, bindingPath.getType());
				assertIterableEquals(List.of("top_i_Instance.a.proc.EMV2.bindings"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(
						List.of("top_i_Instance.a.ps.EMV2.processor", "top_i_Instance.a.ps.t.EMV2.processor"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
		});
		with(instance.getComponentInstances().get(1), component -> {
			assertEquals("b", component.getName());
			var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
			assertEquals(2, annexInstance.getPropagationPaths().size());
			with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
				assertEquals("(ps.EMV2.processor, ps.t.EMV2.processor) -> proc.EMV2.bindings", bindingPath.getName());
				assertEquals(BindingType.PROCESSOR, bindingPath.getType());
				assertIterableEquals(
						List.of("top_i_Instance.b.ps.EMV2.processor", "top_i_Instance.b.ps.t.EMV2.processor"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(List.of("top_i_Instance.b.proc.EMV2.bindings"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
			with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
				assertEquals("proc.EMV2.bindings -> (ps.EMV2.processor, ps.t.EMV2.processor)", bindingPath.getName());
				assertEquals(BindingType.PROCESSOR, bindingPath.getType());
				assertIterableEquals(List.of("top_i_Instance.b.proc.EMV2.bindings"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(
						List.of("top_i_Instance.b.ps.EMV2.processor", "top_i_Instance.b.ps.t.EMV2.processor"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
		});
	}

	@Test
	public void testMissingThreadPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "missing_thread_propagation.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testMissingProcessorPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "missing_processor_propagation.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testDataToMemory() throws Exception {
		var pkg = testHelper.parseFile(PATH + "data_to_memory.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("d.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testMemoryToData() throws Exception {
		var pkg = testHelper.parseFile(PATH + "memory_to_data.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("m.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testBidirectionalMemoryAndData() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bidirectional_memory_and_data.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("d.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("m.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testMultipleMemory() throws Exception {
		var pkg = testHelper.parseFile(PATH + "multiple_memory.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("d.EMV2.memory -> (m1.EMV2.bindings, m2.EMV2.bindings)",
					bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m1.EMV2.bindings", "s_i_Instance.m2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("(m1.EMV2.bindings, m2.EMV2.bindings) -> d.EMV2.memory",
					bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m1.EMV2.bindings", "s_i_Instance.m2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testAllMemoryBindingTargetTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_memory_binding_target_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(10, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("d1.EMV2.memory -> m.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d1.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("m.EMV2.bindings -> d1.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d1.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("d2.EMV2.memory -> s2.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d2.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("s2.EMV2.bindings -> d2.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d2.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("d3.EMV2.memory -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d3.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("proc.EMV2.bindings -> d3.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d3.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("d4.EMV2.memory -> vp.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d4.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("vp.EMV2.bindings -> d4.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d4.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("d5.EMV2.memory -> a.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d5.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.a.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("a.EMV2.bindings -> d5.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.a.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d5.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testAllMemoryBindingSourceTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_memory_binding_source_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		/*
		 * This method also tests that BindingPath objects are not created when a data port or an event data port is the
		 * source of a memory binding.
		 */
		assertEquals(22, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("d.EMV2.memory -> m9.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m9.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("m9.EMV2.bindings -> d.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m9.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.d.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("dev.EMV2.memory -> m8.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m8.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("m8.EMV2.bindings -> dev.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m8.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("m_source.EMV2.memory -> m1.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m_source.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m1.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("m1.EMV2.bindings -> m_source.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m1.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m_source.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("ps.EMV2.memory -> m4.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m4.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("m4.EMV2.bindings -> ps.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m4.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("ps.tg.EMV2.memory -> m3.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.tg.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m3.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("m3.EMV2.bindings -> ps.tg.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m3.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.tg.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(10), bindingPath -> {
			assertEquals("ps.tg.t.EMV2.memory -> m2.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.tg.t.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(11), bindingPath -> {
			assertEquals("m2.EMV2.bindings -> ps.tg.t.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.tg.t.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(12), bindingPath -> {
			assertEquals("proc.EMV2.memory -> m6.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m6.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(13), bindingPath -> {
			assertEquals("m6.EMV2.bindings -> proc.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m6.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(14), bindingPath -> {
			assertEquals("subp.EMV2.memory -> m12.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.subp.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m12.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(15), bindingPath -> {
			assertEquals("m12.EMV2.bindings -> subp.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m12.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.subp.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(16), bindingPath -> {
			assertEquals("subpg.EMV2.memory -> m13.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.subpg.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m13.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(17), bindingPath -> {
			assertEquals("m13.EMV2.bindings -> subpg.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m13.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.subpg.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(18), bindingPath -> {
			assertEquals("s2.EMV2.memory -> m5.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m5.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(19), bindingPath -> {
			assertEquals("m5.EMV2.bindings -> s2.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m5.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(20), bindingPath -> {
			assertEquals("vp.EMV2.memory -> m7.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m7.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(21), bindingPath -> {
			assertEquals("m7.EMV2.bindings -> vp.EMV2.memory", bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m7.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testInheritedMemoryBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_memory_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals(
					"(ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory) -> m.EMV2.bindings",
					bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(
					List.of("s_i_Instance.ps.EMV2.memory", "s_i_Instance.ps.tg.EMV2.memory",
							"s_i_Instance.ps.tg.t.EMV2.memory", "s_i_Instance.ps.tg.t.d.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals(
					"m.EMV2.bindings -> (ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory)",
					bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(
					List.of("s_i_Instance.ps.EMV2.memory", "s_i_Instance.ps.tg.EMV2.memory",
							"s_i_Instance.ps.tg.t.EMV2.memory", "s_i_Instance.ps.tg.t.d.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testInheritedMemoryBindingWithMultipleMemories() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_memory_binding_with_multiple_memories.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals(
					"(ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory) -> (m1.EMV2.bindings, m2.EMV2.bindings)",
					bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(
					List.of("s_i_Instance.ps.EMV2.memory", "s_i_Instance.ps.tg.EMV2.memory",
							"s_i_Instance.ps.tg.t.EMV2.memory", "s_i_Instance.ps.tg.t.d.EMV2.memory"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m1.EMV2.bindings", "s_i_Instance.m2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals(
					"(m1.EMV2.bindings, m2.EMV2.bindings) -> (ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory)",
					bindingPath.getName());
			assertEquals(BindingType.MEMORY, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m1.EMV2.bindings", "s_i_Instance.m2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(
					List.of("s_i_Instance.ps.EMV2.memory", "s_i_Instance.ps.tg.EMV2.memory",
							"s_i_Instance.ps.tg.t.EMV2.memory", "s_i_Instance.ps.tg.t.d.EMV2.memory"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testSeparatedInheritedMemoryBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "separated_inherited_memory_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var instance = InstantiateModel.instantiate(system);
		with(instance.getComponentInstances().get(0), component -> {
			assertEquals("a", component.getName());
			var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
			assertEquals(2, annexInstance.getPropagationPaths().size());
			with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
				assertEquals(
						"(ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory) -> m.EMV2.bindings",
						bindingPath.getName());
				assertEquals(BindingType.MEMORY, bindingPath.getType());
				assertIterableEquals(
						List.of("top_i_Instance.a.ps.EMV2.memory", "top_i_Instance.a.ps.tg.EMV2.memory",
								"top_i_Instance.a.ps.tg.t.EMV2.memory", "top_i_Instance.a.ps.tg.t.d.EMV2.memory"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(List.of("top_i_Instance.a.m.EMV2.bindings"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
			with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
				assertEquals(
						"m.EMV2.bindings -> (ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory)",
						bindingPath.getName());
				assertEquals(BindingType.MEMORY, bindingPath.getType());
				assertIterableEquals(List.of("top_i_Instance.a.m.EMV2.bindings"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(
						List.of("top_i_Instance.a.ps.EMV2.memory", "top_i_Instance.a.ps.tg.EMV2.memory",
								"top_i_Instance.a.ps.tg.t.EMV2.memory", "top_i_Instance.a.ps.tg.t.d.EMV2.memory"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
		});
		with(instance.getComponentInstances().get(1), component -> {
			assertEquals("b", component.getName());
			var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
			assertEquals(2, annexInstance.getPropagationPaths().size());
			with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
				assertEquals(
						"(ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory) -> m.EMV2.bindings",
						bindingPath.getName());
				assertEquals(BindingType.MEMORY, bindingPath.getType());
				assertIterableEquals(
						List.of("top_i_Instance.b.ps.EMV2.memory", "top_i_Instance.b.ps.tg.EMV2.memory",
								"top_i_Instance.b.ps.tg.t.EMV2.memory", "top_i_Instance.b.ps.tg.t.d.EMV2.memory"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(List.of("top_i_Instance.b.m.EMV2.bindings"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
			with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
				assertEquals(
						"m.EMV2.bindings -> (ps.EMV2.memory, ps.tg.EMV2.memory, ps.tg.t.EMV2.memory, ps.tg.t.d.EMV2.memory)",
						bindingPath.getName());
				assertEquals(BindingType.MEMORY, bindingPath.getType());
				assertIterableEquals(List.of("top_i_Instance.b.m.EMV2.bindings"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(
						List.of("top_i_Instance.b.ps.EMV2.memory", "top_i_Instance.b.ps.tg.EMV2.memory",
								"top_i_Instance.b.ps.tg.t.EMV2.memory", "top_i_Instance.b.ps.tg.t.d.EMV2.memory"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
		});
	}

	@Test
	public void testMissingDataPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "missing_data_propagation.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testMissingMemoryPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "missing_memory_propagation.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testVirtualBusToBus() throws Exception {
		var pkg = testHelper.parseFile(PATH + "virtual_bus_to_bus.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("vb.EMV2.connection -> b.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testBusToVirtualBus() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bus_to_virtual_bus.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(1, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("b.EMV2.bindings -> vb.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testBidirectionalBusAndVirtualBus() throws Exception {
		var pkg = testHelper.parseFile(PATH + "bidirectional_bus_and_virtual_bus.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("vb.EMV2.connection -> b.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("b.EMV2.bindings -> vb.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testMultipleBuses() throws Exception {
		var pkg = testHelper.parseFile(PATH + "multiple_buses.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("vb.EMV2.connection -> b1.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b1.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("b3.EMV2.bindings -> vb.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b3.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testAllConnectionBindingTargetTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_connection_binding_target_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(16, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("vb1.EMV2.connection -> proc.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb1.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("proc.EMV2.bindings -> vb1.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.proc.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb1.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("vb2.EMV2.connection -> vp.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb2.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("vp.EMV2.bindings -> vb2.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vp.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb2.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("vb3.EMV2.connection -> b.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb3.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("b.EMV2.bindings -> vb3.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb3.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("vb4.EMV2.connection -> vb_target.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb4.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb_target.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("vb_target.EMV2.bindings -> vb4.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb_target.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb4.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("vb5.EMV2.connection -> dev.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb5.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("dev.EMV2.bindings -> vb5.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.dev.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb5.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(10), bindingPath -> {
			assertEquals("vb6.EMV2.connection -> m.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb6.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(11), bindingPath -> {
			assertEquals("m.EMV2.bindings -> vb6.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.m.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb6.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(12), bindingPath -> {
			assertEquals("vb7.EMV2.connection -> s2.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb7.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(13), bindingPath -> {
			assertEquals("s2.EMV2.bindings -> vb7.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb7.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(14), bindingPath -> {
			assertEquals("vb8.EMV2.connection -> a.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb8.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.a.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(15), bindingPath -> {
			assertEquals("a.EMV2.bindings -> vb8.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.a.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb8.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testAllConnectionBindingSourceTypes() throws Exception {
		var pkg = testHelper.parseFile(PATH + "all_connection_binding_source_types.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(10, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("ps.EMV2.connection -> b5.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b5.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("b5.EMV2.bindings -> ps.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b5.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(2), bindingPath -> {
			assertEquals("ps.t.EMV2.connection -> b3.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b3.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(3), bindingPath -> {
			assertEquals("b3.EMV2.bindings -> ps.t.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b3.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.t.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(4), bindingPath -> {
			assertEquals("ps.tg.EMV2.connection -> b4.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.ps.tg.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b4.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(5), bindingPath -> {
			assertEquals("b4.EMV2.bindings -> ps.tg.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b4.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.ps.tg.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(6), bindingPath -> {
			assertEquals("s2.EMV2.connection -> b6.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b6.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(7), bindingPath -> {
			assertEquals("b6.EMV2.bindings -> s2.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b6.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(8), bindingPath -> {
			assertEquals("vb.EMV2.connection -> b7.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b7.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(9), bindingPath -> {
			assertEquals("b7.EMV2.bindings -> vb.EMV2.connection", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b7.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.vb.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testInheritedConnectionBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_connection_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("(s2.EMV2.connection, s2.vb.EMV2.connection) -> b.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.connection", "s_i_Instance.s2.vb.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("b.EMV2.bindings -> (s2.EMV2.connection, s2.vb.EMV2.connection)", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.connection", "s_i_Instance.s2.vb.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testInheritedConnectionBindingWithMultipleBuses() throws Exception {
		var pkg = testHelper.parseFile(PATH + "inherited_connection_binding_with_multiple_buses.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var annexInstance = (EMV2AnnexInstance) InstantiateModel.instantiate(system).getAnnexInstances().get(0);
		assertEquals(2, annexInstance.getPropagationPaths().size());
		with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
			assertEquals("(s2.EMV2.connection, s2.vb.EMV2.connection) -> b1.EMV2.bindings", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.connection", "s_i_Instance.s2.vb.EMV2.connection"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.b1.EMV2.bindings"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
		with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
			assertEquals("b3.EMV2.bindings -> (s2.EMV2.connection, s2.vb.EMV2.connection)", bindingPath.getName());
			assertEquals(BindingType.CONNECTION, bindingPath.getType());
			assertIterableEquals(List.of("s_i_Instance.b3.EMV2.bindings"),
					bindingPath.getSourcePropagations().stream().map(InstanceObject::getInstanceObjectPath).toList());
			bindingPath.getSourcePropagations().forEach(propagation -> {
				assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
			});
			assertIterableEquals(List.of("s_i_Instance.s2.EMV2.connection", "s_i_Instance.s2.vb.EMV2.connection"),
					bindingPath.getDestinationPropagations()
							.stream()
							.map(InstanceObject::getInstanceObjectPath)
							.toList());
			bindingPath.getDestinationPropagations().forEach(propagation -> {
				assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
			});
		});
	}

	@Test
	public void testSeparatedInheritedConnectionBinding() throws Exception {
		var pkg = testHelper.parseFile(PATH + "separated_inherited_connection_binding.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		var instance = InstantiateModel.instantiate(system);
		with(instance.getComponentInstances().get(0), component -> {
			assertEquals("a", component.getName());
			var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
			assertEquals(2, annexInstance.getPropagationPaths().size());
			with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
				assertEquals("(s2.EMV2.connection, s2.vb.EMV2.connection) -> b.EMV2.bindings", bindingPath.getName());
				assertEquals(BindingType.CONNECTION, bindingPath.getType());
				assertIterableEquals(
						List.of("top_i_Instance.a.s2.EMV2.connection", "top_i_Instance.a.s2.vb.EMV2.connection"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(List.of("top_i_Instance.a.b.EMV2.bindings"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
			with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
				assertEquals("b.EMV2.bindings -> (s2.EMV2.connection, s2.vb.EMV2.connection)", bindingPath.getName());
				assertEquals(BindingType.CONNECTION, bindingPath.getType());
				assertIterableEquals(List.of("top_i_Instance.a.b.EMV2.bindings"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(
						List.of("top_i_Instance.a.s2.EMV2.connection", "top_i_Instance.a.s2.vb.EMV2.connection"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
		});
		with(instance.getComponentInstances().get(1), component -> {
			assertEquals("b", component.getName());
			var annexInstance = (EMV2AnnexInstance) component.getAnnexInstances().get(0);
			assertEquals(2, annexInstance.getPropagationPaths().size());
			with((BindingPath) annexInstance.getPropagationPaths().get(0), bindingPath -> {
				assertEquals("(s2.EMV2.connection, s2.vb.EMV2.connection) -> b.EMV2.bindings", bindingPath.getName());
				assertEquals(BindingType.CONNECTION, bindingPath.getType());
				assertIterableEquals(
						List.of("top_i_Instance.b.s2.EMV2.connection", "top_i_Instance.b.s2.vb.EMV2.connection"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(List.of("top_i_Instance.b.b.EMV2.bindings"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
			with((BindingPath) annexInstance.getPropagationPaths().get(1), bindingPath -> {
				assertEquals("b.EMV2.bindings -> (s2.EMV2.connection, s2.vb.EMV2.connection)", bindingPath.getName());
				assertEquals(BindingType.CONNECTION, bindingPath.getType());
				assertIterableEquals(List.of("top_i_Instance.b.b.EMV2.bindings"),
						bindingPath.getSourcePropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getSourcePropagations().forEach(propagation -> {
					assertTrue(propagation.getSourceBindingPaths().contains(bindingPath));
				});
				assertIterableEquals(
						List.of("top_i_Instance.b.s2.EMV2.connection", "top_i_Instance.b.s2.vb.EMV2.connection"),
						bindingPath.getDestinationPropagations()
								.stream()
								.map(InstanceObject::getInstanceObjectPath)
								.toList());
				bindingPath.getDestinationPropagations().forEach(propagation -> {
					assertTrue(propagation.getDestinationBindingPaths().contains(bindingPath));
				});
			});
		});
	}

	@Test
	public void testMissingVirtualBusPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "missing_virtual_bus_propagation.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}

	@Test
	public void testMissingBusPropagation() throws Exception {
		var pkg = testHelper.parseFile(PATH + "missing_bus_propagation.aadl");
		var system = (SystemImplementation) pkg.getPublicSection().getOwnedClassifiers().get(1);
		assertEquals(0, InstantiateModel.instantiate(system).getAnnexInstances().size());
	}
}