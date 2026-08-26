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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Property;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes which named elements accept which property definitions.
 *
 * <p>
 * {@code NamedElementImpl.acceptsProperty} decides this by walking the property's applies to list, and
 * the property caching phase of instantiation asks it for every pair of instance object and used
 * property definition, which makes it the most frequently executed test in a run (issue #3095). Three
 * answers matter and are easy to get wrong when the walk is rearranged: a property restricted to a
 * category is accepted only by that category, an abstract classifier accepts a property that applies
 * to anything at all, and a property that applies to nothing is accepted by no element, not even an
 * abstract one.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3095AcceptsPropertyTest extends XtextTest {
	private static final String PROJECT = "org.osate.core.tests/models/issue3095/";
	private static final String MODEL = PROJECT + "Issue3095Categories.aadl";
	private static final String PROPERTY_SET = PROJECT + "Issue3095AppliesTo.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void aPropertyThatAppliesToAllIsAcceptedByEveryCategory() throws Exception {
		var model = parse();
		Property anything = property(model, "Holder", "Issue3095AppliesTo::Anything");

		assertTrue(classifier(model, "Worker").acceptsProperty(anything));
		assertTrue(classifier(model, "Holder").acceptsProperty(anything));
		assertTrue(classifier(model, "AnythingGoes").acceptsProperty(anything));
	}

	@Test
	public void aPropertyRestrictedToOneCategoryIsAcceptedOnlyByThatCategory() throws Exception {
		var model = parse();
		Property threadOnly = property(model, "Worker", "Issue3095AppliesTo::ThreadOnly");

		assertTrue(classifier(model, "Worker").acceptsProperty(threadOnly));
		assertFalse(classifier(model, "Holder").acceptsProperty(threadOnly));
	}

	/**
	 * An abstract classifier accepts a property whatever category it is restricted to, because an
	 * abstract component stands in for a component of any category.
	 */
	@Test
	public void anAbstractClassifierAcceptsAPropertyRestrictedToAnotherCategory() throws Exception {
		var model = parse();
		Property threadOnly = property(model, "Worker", "Issue3095AppliesTo::ThreadOnly");

		assertTrue(classifier(model, "AnythingGoes").acceptsProperty(threadOnly));
	}

	/**
	 * A definition that applies to nothing is accepted by no element. The abstract case is the one worth
	 * pinning: being abstract does not make an element accept a property that applies to nothing.
	 */
	@Test
	public void aPropertyThatAppliesToNothingIsAcceptedByNoElement() throws Exception {
		var model = parse();
		Property appliesToNothing = Aadl2Factory.eINSTANCE.createProperty();
		appliesToNothing.setName("AppliesToNothing");

		assertTrue(appliesToNothing.getAppliesTos().isEmpty());
		assertFalse(classifier(model, "Worker").acceptsProperty(appliesToNothing));
		assertFalse(classifier(model, "Holder").acceptsProperty(appliesToNothing));
		assertFalse(classifier(model, "AnythingGoes").acceptsProperty(appliesToNothing));
	}

	/** The fixture's classifiers by name, all from one parse. */
	private Map<String, Classifier> parse() throws Exception {
		AadlPackage pkg = testHelper.parseFile(MODEL, PROPERTY_SET);
		validationHelper.assertNoIssues(pkg);
		var byName = new LinkedHashMap<String, Classifier>();
		for (Classifier classifier : pkg.getOwnedPublicSection().getOwnedClassifiers()) {
			byName.put(classifier.getName(), classifier);
		}
		return byName;
	}

	private static Classifier classifier(Map<String, Classifier> model, String name) {
		Classifier classifier = model.get(name);
		if (classifier == null) {
			throw new IllegalStateException("No classifier " + name + " in " + model.keySet());
		}
		return classifier;
	}

	/** The definition of {@code qualifiedName}, read from the named classifier's associations. */
	private static Property property(Map<String, Classifier> model, String classifierName, String qualifiedName) {
		return classifier(model, classifierName).getOwnedPropertyAssociations()
				.stream()
				.map(association -> association.getProperty())
				.filter(definition -> qualifiedName.equals(definition.getQualifiedName()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException(
						"No association naming " + qualifiedName + " on " + classifierName));
	}
}
