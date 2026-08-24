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
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Whether a feature group prototype is bound is decided by the actual it resolves to, not by the
 * prototype bindings that actual carries of its own. A bound prototype whose actual names a feature
 * group type has no bindings of its own and must not be reported as unbound.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3075Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3075/Issue3075.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Both feature groups expand into the members of {@code FGT}. Only the one whose prototype has no
	 * actual, and therefore falls back to its constraining feature group type, is reported.
	 */
	@Test
	public void onlyAnUnboundFeatureGroupPrototypeIsReported() throws Exception {
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
		assertEquals(List.of("p"), memberNames(featureGroup(instance, "bound")));
		assertEquals(List.of("p"), memberNames(featureGroup(instance, "constrained")));
		assertEquals(List.of("Warning Top_i_Instance.constrained.fg: Feature group prototype of "
				+ "Top_i_Instance.constrained.fg is not bound yet to feature group type"),
				((QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource())).getErrors()
						.stream()
						.map(message -> message.kind + " "
								+ ((InstanceObject) message.where).getInstanceObjectPath() + ": " + message.message)
						.toList());
	}

	private static FeatureInstance featureGroup(SystemInstance instance, String subcomponentName) {
		ComponentInstance subcomponent = instance.getComponentInstances()
				.stream()
				.filter(component -> component.getName().equals(subcomponentName))
				.findFirst()
				.orElseThrow();
		return subcomponent.getFeatureInstances()
				.stream()
				.filter(feature -> feature.getName().equals("fg"))
				.findFirst()
				.orElseThrow();
	}

	private static List<String> memberNames(FeatureInstance group) {
		return group.getFeatureInstances().stream().map(FeatureInstance::getName).toList();
	}
}
