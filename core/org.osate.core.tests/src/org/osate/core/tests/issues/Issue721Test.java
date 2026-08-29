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
 * aries to this license with respect to the terms applicable to the Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.ReferenceValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.AssertHelper;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;
import com.itemis.xtext.testing.XtextTest;

/**
 * A reference term that selects more than one element of a subcomponent array must cache a list of
 * instance references. Issue #721 left the declarative reference in place and reported an
 * instantiation error because reference instantiation rejected every path with multiple matches.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class Issue721Test extends XtextTest {
	private static final String PROJECT = "org.osate.core.tests/models/issue721/";
	private static final String MODEL = PROJECT + "Issue721.aadl";
	private static final String RANGE_MODEL = PROJECT + "Issue721Range.aadl";
	private static final String INVALID_MODEL = PROJECT + "Issue721Invalid.aadl";
	private static final String PROPERTIES = PROJECT + "Issue721Properties.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/** An unindexed array expands to one reference per element, in array order. */
	@Test
	public void wholeArrayReferenceExpandsToList() throws Exception {
		var result = instantiate(MODEL, "Top.whole_array");

		assertEquals(List.of(), result.errors());
		assertEquals(List.of("workers[1]", "workers[2]", "workers[3]"), referencedPaths(result, "Targets"));
	}

	/** A range expands to the elements within its bounds and produces no obsolete validation warning. */
	@Test
	public void arrayRangeReferenceExpandsToList() throws Exception {
		var result = instantiate(RANGE_MODEL, "Top.selected_range");

		assertEquals(List.of(), result.errors());
		assertEquals(List.of("workers[2]", "workers[3]"), referencedPaths(result, "Targets"));
	}

	/** The remainder of the path is resolved separately below every selected array element. */
	@Test
	public void pathContinuesThroughEveryArrayElement() throws Exception {
		var result = instantiate(MODEL, "Top.nested_path");

		assertEquals(List.of(), result.errors());
		assertEquals(List.of("workers[1].output", "workers[2].output", "workers[3].output"),
				referencedPaths(result, "Feature_Targets"));
	}

	/** A path that identifies one array element keeps the existing scalar reference representation. */
	@Test
	public void singleArrayElementRemainsOneReference() throws Exception {
		var result = instantiate(MODEL, "Top.single_element");
		var value = propertyValue(result.instance(), "Target");

		assertEquals(List.of(), result.errors());
		assertTrue("not an instance reference: " + value, value instanceof InstanceReferenceValue);
		assertEquals("workers[2]",
				relativePath(result.instance(), ((InstanceReferenceValue) value).getReferencedInstanceObject()));
	}

	/** Every element of a multidimensional array is returned with the last dimension changing fastest. */
	@Test
	public void multidimensionalWholeArrayExpandsInIndexOrder() throws Exception {
		var result = instantiate(MODEL, "Top.multidimensional_whole");

		assertEquals(List.of(), result.errors());
		assertEquals(List.of("grid[1][1]", "grid[1][2]", "grid[1][3]", "grid[2][1]", "grid[2][2]",
				"grid[2][3]"), referencedPaths(result, "Targets"));
	}

	/** A range in each dimension returns the Cartesian product of the selected indices. */
	@Test
	public void multidimensionalRangesExpandAcrossDimensions() throws Exception {
		var result = instantiate(RANGE_MODEL, "Top.multidimensional_range");

		assertEquals(List.of(), result.errors());
		assertEquals(List.of("grid[2][1]", "grid[2][2]", "grid[3][1]", "grid[3][2]"),
				referencedPaths(result, "Targets"));
	}

	/** Indexing every dimension of a multidimensional array preserves a scalar reference value. */
	@Test
	public void multidimensionalIndexedElementRemainsOneReference() throws Exception {
		var result = instantiate(MODEL, "Top.multidimensional_single");
		var value = propertyValue(result.instance(), "Target");

		assertEquals(List.of(), result.errors());
		assertTrue("not an instance reference: " + value, value instanceof InstanceReferenceValue);
		assertEquals("grid[2][3]",
				relativePath(result.instance(), ((InstanceReferenceValue) value).getReferencedInstanceObject()));
	}

	/** Multiple array elements along one path expand to the Cartesian product in traversal order. */
	@Test
	public void nestedArrayPathExpandsEveryArraySegment() throws Exception {
		var result = instantiate(MODEL, "Top.nested_arrays");

		assertEquals(List.of(), result.errors());
		assertEquals(List.of("outer[1].inner[1]", "outer[1].inner[2]", "outer[1].inner[3]",
				"outer[2].inner[1]", "outer[2].inner[2]", "outer[2].inner[3]"),
				referencedPaths(result, "Targets"));
	}

	/** Indexing either nested array restricts only that path segment; the other segment still expands. */
	@Test
	public void indexingOneNestedArrayRestrictsOnlyThatSegment() throws Exception {
		var outerIndexed = instantiate(MODEL, "Top.indexed_outer_array");
		var innerIndexed = instantiate(MODEL, "Top.indexed_inner_array");

		assertEquals(List.of(), outerIndexed.errors());
		assertEquals(List.of("outer[2].inner[1]", "outer[2].inner[2]", "outer[2].inner[3]"),
				referencedPaths(outerIndexed, "Targets"));
		assertEquals(List.of(), innerIndexed.errors());
		assertEquals(List.of("outer[1].inner[2]", "outer[2].inner[2]"),
				referencedPaths(innerIndexed, "Targets"));
	}

	/**
	 * Validation accounts for the evaluated list type and checks the terminal element against the
	 * reference constraints of the list element type.
	 */
	@Test
	public void arrayReferenceMustMatchListAndElementTypes() throws Exception {
		FluentIssueCollection result = issues = testHelper.testFile(INVALID_MODEL, PROPERTIES);
		var expected = new FluentIssueCollection(result.getResource(), new ArrayList<>(), new ArrayList<>());
		var pkg = (AadlPackage) result.getResource().getContents().getFirst();
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals("Top.invalid"))
				.findFirst()
				.orElseThrow();

		AssertHelper.assertError(referenceValue(implementation, "Scalar_Target"), result.getIssues(), expected,
				"Assigning a list of reference values to property 'Issue721Properties::Scalar_Target' of type 'ReferenceType'");
		AssertHelper.assertError(referenceValue(implementation, "Wrong_Targets"), result.getIssues(), expected,
				"Assigning reference value with incorrect Named Element class to property 'Issue721Properties::Wrong_Targets' of type 'ListType'");
		expected.sizeIs(result.getIssues().size());
		assertConstraints(expected);
	}

	private Result instantiate(String model, String implementationName) throws Exception {
		var pkg = testHelper.parseFile(model, PROPERTIES);
		validationHelper.assertNoIssues(pkg);
		var implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow();
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		var instance = InstantiateModel.instantiate(implementation, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());

		return new Result(instance, reporter.getErrors());
	}

	private static List<String> referencedPaths(Result result, String propertyName) {
		var value = propertyValue(result.instance(), propertyName);
		assertTrue("not a list value: " + value, value instanceof ListValue);

		return ((ListValue) value).getOwnedListElements()
				.stream()
				.map(element -> {
					assertTrue("not an instance reference: " + element, element instanceof InstanceReferenceValue);
					return relativePath(result.instance(),
							((InstanceReferenceValue) element).getReferencedInstanceObject());
				})
				.toList();
	}

	private static PropertyExpression propertyValue(SystemInstance instance, String propertyName) {
		var associations = instance.getOwnedPropertyAssociations()
				.stream()
				.filter(association -> association.getProperty().getName().equals(propertyName))
				.toList();

		assertEquals(1, associations.size());
		return associations.getFirst().getOwnedValues().getFirst().getOwnedValue();
	}

	private static ReferenceValue referenceValue(ComponentImplementation implementation, String propertyName) {
		var association = implementation.getOwnedPropertyAssociations()
				.stream()
				.filter(candidate -> candidate.getProperty().getName().equals(propertyName))
				.findFirst()
				.orElseThrow();
		return (ReferenceValue) association.getOwnedValues().getFirst().getOwnedValue();
	}

	private static String relativePath(SystemInstance instance, InstanceObject object) {
		var prefix = instance.getInstanceObjectPath() + ".";
		var path = object.getInstanceObjectPath();

		assertTrue(path, path.startsWith(prefix));
		return path.substring(prefix.length());
	}

	private record Result(SystemInstance instance, List<Message> errors) {
	}
}
