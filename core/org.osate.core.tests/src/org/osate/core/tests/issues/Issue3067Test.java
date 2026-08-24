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
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3067Test extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/issue3067/Issue3067.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * The feature is declared with a feature prototype, and the subcomponent binds that prototype to
	 * {@code in data port}. The category of the feature instance therefore has to be that of a data port.
	 * <p>
	 * Instantiation instead reports the category of an abstract feature, because the branch of
	 * {@code InstantiateModel.filloutFeatureInstance()} that resolves a feature prototype is guarded by
	 * {@code feature.getPrototype() instanceof FeaturePrototype}. {@code Feature.getPrototype()} yields a
	 * {@code ComponentPrototype}, which a {@code FeaturePrototype} never is, so the guard never holds and
	 * the category falls back to the declarative metaclass of the feature. The feature prototype of an
	 * abstract feature is reached through {@code AbstractFeature.getFeaturePrototype()} instead.
	 */
	@Test
	public void featurePrototypeDeterminesFeatureInstanceCategory() throws Exception {
		var pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		var top = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.i"))
				.findFirst()
				.orElseThrow();

		var instance = InstantiateModel.instantiate(top);

		var sub = instance.getComponentInstances()
				.stream()
				.filter(componentInstance -> componentInstance.getName().equals("sub"))
				.findFirst()
				.orElseThrow();
		var feature = sub.getFeatureInstances()
				.stream()
				.filter(featureInstance -> featureInstance.getName().equals("f"))
				.findFirst()
				.orElseThrow();
		assertEquals(FeatureCategory.DATA_PORT, feature.getCategory());
	}
}
