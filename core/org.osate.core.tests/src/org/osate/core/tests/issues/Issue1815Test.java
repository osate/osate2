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
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue1815Test {
	private static final String PROJECT_LOCATION = "org.osate.core.tests/models/Issue1815/";

	private static final String NO_FLOW_PROPS = "NoFlowProps.aadl";

	private static final String TOP_IMPL = "Top.impl";

	private static final String SYSTEM_NAME = "Top_impl_Instance";

	private static final String FS = "fs";

	private static final String FS1 = "fs1";

	private static final String A1 = "a1";

	private static final String M1 = "m1";

	private static final String LATENCY = "Latency";

	@Inject
	TestHelper<AadlPackage> testHelper;

	@Test
	public void testSubcomponents1() throws Exception {
		AadlPackage pkg = testHelper.parseFile(PROJECT_LOCATION + NO_FLOW_PROPS);
		SystemImplementation sysImpl = (SystemImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> TOP_IMPL.equals(classifier.getName()))
				.findFirst()
				.orElse(null);
		AnalysisErrorReporterManager errorManager = new AnalysisErrorReporterManager(
				QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(sysImpl, errorManager);
		assertEquals(SYSTEM_NAME, instance.getName());
		var messages = ((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors();
		assertEquals(0, messages.size());

		checkPropertiesOfFlowSpecs(componentNamed(instance, A1));
		checkPropertiesOfFlowSpecs(componentNamed(instance, M1));
		checkPropertiesOfFlowSpecs(instance);
	}

	private static ComponentInstance componentNamed(ComponentInstance parent, String name) {
		return parent.getComponentInstances()
				.stream()
				.filter(component -> name.equals(component.getName()))
				.findFirst()
				.orElse(null);
	}

	private void checkPropertiesOfFlowSpecs(ComponentInstance ci) {
		checkForPropertyAssociation(ci, FS);
		checkForPropertyAssociation(ci, FS1);
	}

	/**
	 * Check that the given component instance has a flow spec with the given name, and that flow spec
	 * has a LATENCY property association.
	 */
	private void checkForPropertyAssociation(ComponentInstance ci, String flowSpecName) {
		var fs = ci.getFlowSpecifications()
				.stream()
				.filter(flowSpec -> flowSpecName.equals(flowSpec.getName()))
				.findFirst()
				.orElse(null);
		var propAssocs = fs.getOwnedPropertyAssociations();
		assertEquals(1, propAssocs.size());
		var pa = propAssocs.get(0);
		assertEquals(LATENCY, pa.getProperty().getName());
	}
}
