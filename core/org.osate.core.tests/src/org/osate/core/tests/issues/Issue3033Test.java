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
 * conditions contained in any such separate license file distributed with such Third Party Software. The parties who
 * own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this license with
 * respect to the terms applicable to such Third Party Software. Third Party Software licenses only apply to the Third
 * Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.EndToEndFlowInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.core.tests.instantiation.InstanceRoots;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Connections and end to end flows belong to a system instance. Referenced feature classifiers are
 * represented by additional component-instance roots, but those roots have no system operation modes
 * in which connections or flows could be instantiated.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3033Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3033/Issue3033.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void referencedClassifierHasNoConnectionsOrEndToEndFlows() throws Exception {
		AadlPackage pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		ComponentImplementation implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);

		SystemInstance instance = InstantiateModel.instantiate(implementation, errorManager);

		assertNotNull(instance);
		ComponentInstance referenced = InstanceRoots.referenced(instance)
				.stream()
				.filter(root -> root.getName().equals("Issue3033::Inner.i"))
				.findFirst()
				.orElseThrow();
		assertEquals(List.of("consumer", "producer"),
				referenced.getComponentInstances().stream().map(ComponentInstance::getName).sorted().toList());
		assertEquals(List.of(), referenced.getAllConnectionInstances());
		assertEquals(List.of(), collectEndToEndFlows(referenced, new ArrayList<>()));
		assertEquals(List.of(),
				((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors());
	}

	private static List<EndToEndFlowInstance> collectEndToEndFlows(ComponentInstance component,
			List<EndToEndFlowInstance> result) {
		result.addAll(component.getEndToEndFlows());
		component.getComponentInstances().forEach(child -> collectEndToEndFlows(child, result));
		return result;
	}
}
