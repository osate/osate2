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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Property;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * Characterizes when {@code PropertyImpl} considers two property definitions equal.
 *
 * <p>
 * Property lookup compares one property definition against the property definition of every
 * property association it walks past, which makes this the most frequently executed comparison in
 * instantiation (issue #3095). The comparison is by qualified name and ignores case, so two
 * definitions that come from different property sets are distinct even when their simple names are
 * equal, and a definition read from one model equals a definition of the same qualified name that
 * was built elsewhere. {@code hashCode} agrees with that, so a hash based collection keyed by a
 * property definition holds one entry per definition. These tests pin those answers, so that an
 * optimization of the comparison is held to producing exactly them.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue3095Test extends XtextTest {
	private static final String PROJECT = "org.osate.core.tests/models/issue3095/";
	private static final String MODEL = PROJECT + "Issue3095.aadl";
	private static final String SET_A = PROJECT + "Issue3095A.aadl";
	private static final String SET_B = PROJECT + "Issue3095B.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void aPropertyDefinitionEqualsItself() throws Exception {
		Property countA = definitions().get("Issue3095A::Count");

		assertTrue(countA.equals(countA));
	}

	@Test
	public void definitionsOfTheSameNameInDifferentPropertySetsAreNotEqual() throws Exception {
		var definitions = definitions();
		Property countA = definitions.get("Issue3095A::Count");
		Property countB = definitions.get("Issue3095B::Count");

		assertEquals("Count", countA.getName());
		assertEquals("Count", countB.getName());
		assertFalse(countA.equals(countB));
		assertFalse(countB.equals(countA));
	}

	@Test
	public void definitionsOfDifferentNamesInOnePropertySetAreNotEqual() throws Exception {
		var definitions = definitions();
		Property countA = definitions.get("Issue3095A::Count");
		Property otherA = definitions.get("Issue3095A::Other");

		assertFalse(countA.equals(otherA));
		assertFalse(otherA.equals(countA));
	}

	/**
	 * The comparison is by qualified name, not by identity, so a separately built definition of the
	 * same qualified name is equal, and so is one that differs only in case.
	 */
	@Test
	public void aSeparatelyBuiltDefinitionOfTheSameQualifiedNameIsEqualIgnoringCase() throws Exception {
		Property countA = definitions().get("Issue3095A::Count");
		Property sameName = definition("Issue3095A", "Count");
		Property sameNameOtherCase = definition("issue3095a", "COUNT");

		assertEquals("Issue3095A::Count", sameName.getQualifiedName());
		assertTrue(countA.equals(sameName));
		assertTrue(sameName.equals(countA));
		assertEquals(countA.hashCode(), sameName.hashCode());

		assertEquals("issue3095a::COUNT", sameNameOtherCase.getQualifiedName());
		assertTrue(countA.equals(sameNameOtherCase));
		assertTrue(sameNameOtherCase.equals(countA));
	}

	/**
	 * Equal definitions hash alike, including when they differ only in case, so that a hash based
	 * collection keyed by a property definition holds one entry per definition.
	 */
	@Test
	public void equalDefinitionsHashAlikeIgnoringCase() throws Exception {
		Property countA = definitions().get("Issue3095A::Count");
		Property sameNameOtherCase = definition("issue3095a", "COUNT");

		assertTrue(countA.equals(sameNameOtherCase));
		assertEquals(countA.hashCode(), sameNameOtherCase.hashCode());
	}

	/**
	 * The consequence of the two agreeing: a definition that is already in a hash set is recognized as
	 * present even when it is spelled with different case.
	 */
	@Test
	public void aHashSetHoldsOneEntryPerDefinitionIgnoringCase() throws Exception {
		var definitions = definitions();
		Property countA = definitions.get("Issue3095A::Count");
		Property countB = definitions.get("Issue3095B::Count");

		Set<Property> set = new HashSet<>();
		set.add(countA);
		set.add(definition("issue3095a", "COUNT"));
		set.add(definition("ISSUE3095A", "count"));
		assertEquals(1, set.size());
		assertTrue(set.contains(countA));

		set.add(countB);
		assertEquals(2, set.size());
	}

	/** Definitions that are not equal are still allowed to hash alike, but these do not. */
	@Test
	public void definitionsOfDifferentQualifiedNamesHashDifferently() throws Exception {
		var definitions = definitions();
		Property countA = definitions.get("Issue3095A::Count");

		assertNotEquals(countA.hashCode(), definitions.get("Issue3095B::Count").hashCode());
		assertNotEquals(countA.hashCode(), definitions.get("Issue3095A::Other").hashCode());
	}

	@Test
	public void aSeparatelyBuiltDefinitionOfAnotherQualifiedNameIsNotEqual() throws Exception {
		Property countA = definitions().get("Issue3095A::Count");

		assertFalse(countA.equals(definition("Issue3095A", "Counter")));
		assertFalse(countA.equals(definition("Issue3095C", "Count")));
	}

	/**
	 * A definition with no name has no qualified name, and the comparison falls back to identity.
	 */
	@Test
	public void anUnnamedDefinitionIsEqualOnlyToItself() throws Exception {
		Property unnamed = Aadl2Factory.eINSTANCE.createProperty();
		Property alsoUnnamed = Aadl2Factory.eINSTANCE.createProperty();

		assertNull(unnamed.getQualifiedName());
		assertTrue(unnamed.equals(unnamed));
		assertFalse(unnamed.equals(alsoUnnamed));
		assertFalse(unnamed.equals(definitions().get("Issue3095A::Count")));
	}

	@Test
	public void aDefinitionIsNotEqualToSomethingThatIsNotAProperty() throws Exception {
		assertFalse(definitions().get("Issue3095A::Count").equals("Issue3095A::Count"));
	}

	/**
	 * The property definitions the fixture associates, keyed by qualified name, all read from one
	 * parse.
	 *
	 * <p>
	 * One parse per call matters: {@code TestHelper.parseFile} loads into a resource set it cleans
	 * between calls, so a definition read from an earlier parse is detached by the time a later parse
	 * returns, and comparing across parses compares against a stale object.
	 * </p>
	 */
	private Map<String, Property> definitions() throws Exception {
		AadlPackage pkg = testHelper.parseFile(MODEL, SET_A, SET_B);
		validationHelper.assertNoIssues(pkg);
		ComponentType top = (ComponentType) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top"))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No component type Top"));
		var byQualifiedName = new LinkedHashMap<String, Property>();
		for (var association : top.getOwnedPropertyAssociations()) {
			Property definition = association.getProperty();
			byQualifiedName.put(definition.getQualifiedName(), definition);
		}
		assertEquals(Set.of("Issue3095A::Count", "Issue3095B::Count", "Issue3095A::Other"),
				byQualifiedName.keySet());
		return byQualifiedName;
	}

	/** A property definition built in memory, in a property set of its own. */
	private static Property definition(String propertySetName, String propertyName) {
		var propertySet = Aadl2Factory.eINSTANCE.createPropertySet();
		propertySet.setName(propertySetName);
		Property definition = Aadl2Factory.eINSTANCE.createProperty();
		definition.setName(propertyName);
		propertySet.getOwnedProperties().add(definition);
		return definition;
	}
}
