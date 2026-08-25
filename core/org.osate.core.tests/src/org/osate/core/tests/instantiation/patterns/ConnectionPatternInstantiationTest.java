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
package org.osate.core.tests.instantiation.patterns;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingAnalysisErrorReporter.Message;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * What {@code Connection_Pattern} expands a connection between component arrays into: one connection
 * instance per pair of array elements the pattern pairs up.
 *
 * <p>
 * The expected pairs of the twelve patterns that agree with AS5506D section 9.2.3 are written from the
 * standard, not from what the instantiator produces. The two patterns of issue #3085 are pinned as they
 * are today, which is not what the standard says, and their tests say so.
 * </p>
 *
 * <p>
 * Every test reads the connection instances of the system instance in the order they were created,
 * which is the order the patterns enumerate the elements in, and insists that nothing was reported
 * unless the test is about a diagnostic.
 * </p>
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class ConnectionPatternInstantiationTest extends XtextTest {
	private static final String MODEL = "org.osate.core.tests/models/connectionPatternInstantiation/ConnectionPatterns.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * The connection instances an expanded connection produces carry the container-relative paths of
	 * their two ends as their name, with one index per array dimension. The other tests compare that
	 * name, so this one spells it out once.
	 */
	@Test
	public void expansionNamesEveryConnectionInstanceAfterItsEnds() throws Exception {
		var result = instantiate("Pair.one_to_one");

		assertEquals(List.of("src[1].out_p --> dst[1].in_p", "src[2].out_p --> dst[2].in_p",
				"src[3].out_p --> dst[3].in_p", "src[4].out_p --> dst[4].in_p", "src[5].out_p --> dst[5].in_p"),
				connectionNames(result));
		assertEquals(List.of(), diagnostics(result));
	}

	/** One_To_One pairs elements of equal index. */
	@Test
	public void oneToOnePairsEqualIndices() throws Exception {
		assertPattern("Pair.one_to_one", "1 -> 1", "2 -> 2", "3 -> 3", "4 -> 4", "5 -> 5");
	}

	/** Without a pattern the default expansion is One_To_One. */
	@Test
	public void defaultExpansionPairsEqualIndices() throws Exception {
		assertPattern("Pair.no_pattern", "1 -> 1", "2 -> 2", "3 -> 3", "4 -> 4", "5 -> 5");
	}

	/** Next shifts by one and the last element does not connect. */
	@Test
	public void nextShiftsByOneAndDropsTheLastElement() throws Exception {
		assertPattern("Pair.next", "1 -> 2", "2 -> 3", "3 -> 4", "4 -> 5");
	}

	/** Previous shifts back by one and the first element does not connect. */
	@Test
	public void previousShiftsBackByOneAndDropsTheFirstElement() throws Exception {
		assertPattern("Pair.previous", "2 -> 1", "3 -> 2", "4 -> 3", "5 -> 4");
	}

	/** Cyclic_Next shifts by one, and the last element connects to the first. */
	@Test
	public void cyclicNextShiftsByOneAndWraps() throws Exception {
		assertPattern("Pair.cyclic_next", "1 -> 2", "2 -> 3", "3 -> 4", "4 -> 5", "5 -> 1");
	}

	/** Cyclic_Previous shifts back by one, and the first element connects to the last. */
	@Test
	public void cyclicPreviousShiftsBackByOneAndWraps() throws Exception {
		assertPattern("Pair.cyclic_previous", "1 -> 5", "2 -> 1", "3 -> 2", "4 -> 3", "5 -> 4");
	}

	/** Next_Next shifts by two and the last two elements do not connect. */
	@Test
	public void nextNextShiftsByTwoAndDropsTheLastTwoElements() throws Exception {
		assertPattern("Pair.next_next", "1 -> 3", "2 -> 4", "3 -> 5");
	}

	/** Previous_Previous shifts back by two and the first two elements do not connect. */
	@Test
	public void previousPreviousShiftsBackByTwoAndDropsTheFirstTwoElements() throws Exception {
		assertPattern("Pair.previous_previous", "3 -> 1", "4 -> 2", "5 -> 3");
	}

	/**
	 * Issue #3085: Cyclic_Next_Next wraps the last two elements to the first two, as AS5506D section
	 * 9.2.3 requires, but shifts the interior of the dimension by one instead of by two. The expected
	 * pairs of the standard are {@code 1 -> 3}, {@code 2 -> 4}, {@code 3 -> 5}, {@code 4 -> 1} and
	 * {@code 5 -> 2}.
	 */
	@Test
	public void cyclicNextNextCurrentlyShiftsTheInteriorByOnlyOne() throws Exception {
		assertPattern("Pair.cyclic_next_next", "1 -> 2", "2 -> 3", "3 -> 4", "4 -> 1", "5 -> 2");
	}

	/**
	 * Issue #3085: Cyclic_Previous_Previous has the same defect as Cyclic_Next_Next. The expected pairs
	 * of the standard are {@code 1 -> 4}, {@code 2 -> 5}, {@code 3 -> 1}, {@code 4 -> 2} and
	 * {@code 5 -> 3}.
	 */
	@Test
	public void cyclicPreviousPreviousCurrentlyShiftsTheInteriorByOnlyOne() throws Exception {
		assertPattern("Pair.cyclic_previous_previous", "1 -> 4", "2 -> 5", "3 -> 2", "4 -> 3", "5 -> 4");
	}

	/** Even_To_Even connects the even elements to the same even element. */
	@Test
	public void evenToEvenPairsTheEvenIndices() throws Exception {
		assertPattern("Pair.even_to_even", "2 -> 2", "4 -> 4");
	}

	/** Odd_To_Odd connects the odd elements to the same odd element. */
	@Test
	public void oddToOddPairsTheOddIndices() throws Exception {
		assertPattern("Pair.odd_to_odd", "1 -> 1", "3 -> 3", "5 -> 5");
	}

	/** All_To_All connects every element to every element, and applies to arrays of different sizes. */
	@Test
	public void allToAllPairsEveryCombination() throws Exception {
		assertPattern("Pair.all_to_all", "1 -> 1", "1 -> 2", "2 -> 1", "2 -> 2", "3 -> 1", "3 -> 2");
	}

	/** One_To_All connects the one element of the scalar source to every element of the destination. */
	@Test
	public void oneToAllFansTheScalarSourceOut() throws Exception {
		assertPattern("Pair.one_to_all", " -> 1", " -> 2", " -> 3", " -> 4");
	}

	/** All_To_One connects every element of the source to the one element of the scalar destination. */
	@Test
	public void allToOneFansTheArrayIn() throws Exception {
		assertPattern("Pair.all_to_one", "1 -> ", "2 -> ", "3 -> ", "4 -> ");
	}

	/**
	 * The outer list of Connection_Pattern holds alternative patterns, and the connection instances are
	 * the union of what each of them produces.
	 */
	@Test
	public void severalPatternValuesUnionTheirConnections() throws Exception {
		assertPattern("Pair.next_and_previous", "1 -> 2", "2 -> 3", "3 -> 4", "4 -> 5", "2 -> 1", "3 -> 2", "4 -> 3",
				"5 -> 4");
	}

	/**
	 * A pattern value holds one pattern per array dimension, in the order the dimensions are declared,
	 * so One_To_One on the first and Next on the second dimension shift only the second index.
	 */
	@Test
	public void onePatternPerDimensionAppliesToThatDimension() throws Exception {
		assertPattern("Pair.two_dimensions", "1,1 -> 1,2", "1,2 -> 1,3", "2,1 -> 2,2", "2,2 -> 2,3");
	}

	/**
	 * A pattern that pairs elements up needs both dimensions to have the same size. Section 9.2.3 of
	 * AS5506D says that the common prefix is connected when one range is a subset of the other, but the
	 * description of the property in the same document, and OSATE, require equal sizes.
	 *
	 * <p>
	 * The expansion produced nothing, so the provisional connection instance that it would have replaced
	 * survives, and it is the one the error is reported on. A provisional connection instance names the
	 * first element of every array along its path and separates its ends with a single arrow, where an
	 * expanded one uses a double arrow.
	 * </p>
	 */
	@Test
	public void patternBetweenDimensionsOfDifferentSizesIsReported() throws Exception {
		var result = instantiate("Pair.size_mismatch");

		assertEquals(List.of("Error Pair_size_mismatch_Instance.src[1].out_p -> dst[1].in_p: "
				+ "Array size mismatch (One_To_One) on connection src[1].out_p -> dst[1].in_p "
				+ "in Pair_size_mismatch_Instance: 5 at source and 4 at destination."), diagnostics(result));
		assertEquals(List.of("src[1].out_p -> dst[1].in_p"), connectionNames(result));
	}

	// Fixture plumbing

	private InstantiationResult instantiate(String implementationName) throws Exception {
		AadlPackage pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		ComponentImplementation implementation = (ComponentImplementation) pkg.getOwnedPublicSection()
				.getOwnedClassifiers()
				.stream()
				.filter(classifier -> classifier.getName().equals(implementationName))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("No component implementation named " + implementationName));
		var errorManager = new AnalysisErrorReporterManager(QueuingAnalysisErrorReporter.factory);
		SystemInstance instance = InstantiateModel.instantiate(implementation, errorManager);
		var reporter = (QueuingAnalysisErrorReporter) errorManager.getReporter(instance.eResource());
		return new InstantiationResult(instance, reporter.getErrors());
	}

	/**
	 * Instantiate an implementation of the fixture and compare the array indices of every connection
	 * instance it produced, in the order they were created, against the expected pairs. An end that is
	 * not an array element contributes no index.
	 */
	private void assertPattern(String implementationName, String... expected) throws Exception {
		var result = instantiate(implementationName);

		assertEquals(List.of(expected), indexPairs(result));
		assertEquals(List.of(), diagnostics(result));
	}

	/** The indices of the two ends of every connection instance, as {@code src -> dst}. */
	private static List<String> indexPairs(InstantiationResult result) {
		return result.instance()
				.getConnectionInstances()
				.stream()
				.map(connection -> indices(connection, true) + " -> " + indices(connection, false))
				.toList();
	}

	private static String indices(ConnectionInstance connection, boolean source) {
		var end = source ? connection.getSource() : connection.getDestination();
		var container = end.getComponentInstance();
		return container.getIndices()
				.stream()
				.filter(index -> index != 0)
				.map(String::valueOf)
				.reduce((left, right) -> left + "," + right)
				.orElse("");
	}

	/** The names of the connection instances of the system instance, in the order they were created. */
	private static List<String> connectionNames(InstantiationResult result) {
		return result.instance().getConnectionInstances().stream().map(ConnectionInstance::getName).toList();
	}

	/** Every reported diagnostic as {@code kind path: message}, in the order it was reported. */
	private static List<String> diagnostics(InstantiationResult result) {
		return result.messages().stream().map(message -> message.kind + " " + where(message.where) + ": "
				+ message.message).toList();
	}

	private static String where(Element element) {
		return element instanceof InstanceObject instanceObject ? instanceObject.getInstanceObjectPath()
				: String.valueOf(element);
	}

	private record InstantiationResult(SystemInstance instance, List<Message> messages) {
	}
}
