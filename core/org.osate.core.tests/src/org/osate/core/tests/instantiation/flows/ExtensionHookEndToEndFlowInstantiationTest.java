/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.instantiation.flows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.InstanceFactory;
import org.osate.aadl2.instance.ModeInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.CreateEndToEndFlowsSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.testsupport.Aadl2InjectorProvider;

/**
 * Pins the extension points {@code CreateEndToEndFlowsSwitch} exposes to subclasses. Instantiation is delegated to
 * collaborators, so every hook has to be routed back through the switch to stay overridable, and calling a hook
 * without an instantiation in progress has to fail rather than corrupt an unrelated component.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ExtensionHookEndToEndFlowInstantiationTest extends AbstractEndToEndFlowInstantiationTest {
	private static final String FILE = "BasicAndBranching.aadl";

	@Test
	public void testFlowImplementationHookIsCalledForEveryDescent() throws Exception {
		SystemInstance instance = instantiate(FILE, "BranchingTop.i");
		instance.getEndToEndFlows().clear();
		List<String> descents = new ArrayList<>();

		new CreateEndToEndFlowsSwitch(new NullProgressMonitor(), AnalysisErrorReporterManager.NULL_ERROR_MANANGER,
				null) {
			@Override
			protected boolean processFlowImpl(ComponentInstance component, EndToEndFlowInstance flowInstance,
					FlowImplementation flowImplementation) {
				descents.add(component.getName() + "." + flowImplementation.getSpecification().getName());
				return super.processFlowImpl(component, flowInstance, flowImplementation);
			}
		}.processPreOrderAll(instance);

		assertEquals(List.of("branched_1", "branched_2"), flowNames(instance));
		assertEquals(List.of("choice.fpath", "choice.fpath"), descents);
	}

	@Test
	public void testCloneNamingHooksNameBranchedFlows() throws Exception {
		SystemInstance instance = instantiate(FILE, "BranchingTop.i");
		instance.getEndToEndFlows().clear();
		List<String> calls = new ArrayList<>();

		new CreateEndToEndFlowsSwitch(new NullProgressMonitor(), AnalysisErrorReporterManager.NULL_ERROR_MANANGER,
				null) {
			private int count;

			@Override
			protected void resetETECloneCount() {
				calls.add("reset");
				count = 0;
				super.resetETECloneCount();
			}

			@Override
			protected void setCloneName(EndToEndFlowInstance flowInstance) {
				calls.add("name");
				flowInstance.setName(flowInstance.getEndToEndFlow().getName() + "_variant" + ++count);
			}
		}.processPreOrderAll(instance);

		assertEquals(List.of("branched_variant1", "branched_variant2"), flowNames(instance));
		assertEquals(List.of("reset", "name", "name"), calls);
	}

	@Test
	public void testModeHooksApplyToEveryCommittedFlow() throws Exception {
		SystemInstance instance = instantiate(FILE, "BranchingTop.i");
		instance.getEndToEndFlows().clear();
		List<String> resolved = new ArrayList<>();
		List<String> finalized = new ArrayList<>();

		new CreateEndToEndFlowsSwitch(new NullProgressMonitor(), AnalysisErrorReporterManager.NULL_ERROR_MANANGER,
				null) {
			@Override
			protected EList<ModeInstance> getModeInstances(ComponentInstance component, ModalElement element) {
				resolved.add(element.eClass().getName());
				return super.getModeInstances(component, element);
			}

			@Override
			protected void fillinModes(EndToEndFlowInstance flowInstance) {
				finalized.add(flowInstance.getName());
				super.fillinModes(flowInstance);
			}
		}.processPreOrderAll(instance);

		assertEquals(List.of("branched_1", "branched_2"), flowNames(instance));
		assertEquals(List.of("EndToEndFlow", "FlowImplementation", "FlowImplementation"), resolved);
		assertEquals(List.of("branched_1", "branched_2"), finalized);
	}

	@Test
	public void testTraversalHookWithoutActiveInstantiationFails() throws Exception {
		SystemInstance instance = instantiate(FILE, "BasicTop.i");
		EndToEndFlow declaration = flow(instance, "explicit").getEndToEndFlow();
		EndToEndFlowInstance detached = InstanceFactory.eINSTANCE.createEndToEndFlowInstance();
		detached.setName(declaration.getName());
		detached.setEndToEndFlow(declaration);
		HookAccess hookAccess = new HookAccess();

		IllegalStateException exception = assertThrows(IllegalStateException.class,
				() -> hookAccess.callProcessETE(instance, detached, declaration));

		assertEquals("No active end-to-end flow instantiation context", exception.getMessage());
	}

	private static final class HookAccess extends CreateEndToEndFlowsSwitch {
		HookAccess() {
			super(new NullProgressMonitor(), AnalysisErrorReporterManager.NULL_ERROR_MANANGER, null);
		}

		void callProcessETE(ComponentInstance component, EndToEndFlowInstance flowInstance, EndToEndFlow flow) {
			processETE(component, flowInstance, flow);
		}
	}
}
