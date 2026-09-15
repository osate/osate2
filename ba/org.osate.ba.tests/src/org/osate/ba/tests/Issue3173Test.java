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
package org.osate.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Issue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.IterativeVariableHolder;
import org.osate.ba.analyzers.TypeHolder;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.util.BehaviorAnnexUtil;

import com.google.inject.Inject;

/**
 * AS5506/3 Rev. A D.6 writes the iterator of a {@code for} and of a {@code forall} construct as
 * {@code element_identifier [ : data_unique_component_classifier_reference ]}, so the classifier is optional, and the
 * standard's own BA_example4 omits it. The semantics then give the iterator the type of the element the loop iterates:
 * an integer for an integer range, the data classifier of an input event data port, and the element classifier of a
 * data component array.
 * <p>
 * Verifies that both constructs parse without the classifier, that the strict model carries the type the iterated
 * values determine rather than leaving the iterator untyped, that reads of the iterator inside the loop carry that same
 * type, and that a loop without a classifier round-trips through the registered unparser. A written classifier of a
 * category other than data remains an error, because the inference must not silently replace a rejected declaration.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexInjectorProvider.class)
public class Issue3173Test {
	private static final String MODELS = "org.osate.ba.tests/models/issue3173/";

	/**
	 * The type of each iterator, in the order the annex writes the loops. An integer range makes the iterator a
	 * universal integer, which no data classifier denotes, exactly as a port count value is one; every other iterated
	 * value names the classifier of its elements, which for a Data Model array is the array's base type. The last loop
	 * is the positive control: a written classifier is still the iterator's type.
	 */
	private static final List<String> ITERATOR_TYPES = List.of("step -> Integer <no classifier>",
			"other -> Integer <no classifier>", "sample -> Integer Base_Types::Integer",
			"element -> Integer Base_Types::Integer", "entry -> Struct Issue3173::Pair",
			"typed -> Integer Base_Types::Integer");

	/** Each read of an iterator inside its loop body, with the type the read carries. */
	private static final List<String> ITERATOR_READS = List.of("step -> Integer <no classifier>",
			"other -> Integer <no classifier>", "sample -> Integer Base_Types::Integer",
			"element -> Integer Base_Types::Integer", "entry -> Struct Issue3173::Pair",
			"entry -> Struct Issue3173::Pair", "typed -> Integer Base_Types::Integer");

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	/**
	 * Each loop body names its iterator as the first operand of an arithmetic expression, and the applicable operator is
	 * selected by the type of that operand. An iterator left untyped is therefore reported even though the conformance
	 * check between the two operand types is currently disabled.
	 */
	@Test
	public void omittedIteratorClassifiersAreAccepted() throws Exception {
		validationHelper.assertNoIssues(testHelper.parseFile(MODELS + "Issue3173.aadl"));
	}

	@Test
	public void omittedIteratorClassifierTakesTheTypeOfTheIteratedElement() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3173.aadl");
		validationHelper.assertNoIssues(root);
		assertEquals(ITERATOR_TYPES, iteratorTypes(strictAnnex(root)));
	}

	@Test
	public void iteratorReadsCarryTheInferredType() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3173.aadl");
		validationHelper.assertNoIssues(root);
		var reads = new ArrayList<String>();
		for (var contents = strictAnnex(root).eAllContents(); contents.hasNext();) {
			if (contents.next() instanceof IterativeVariableHolder holder) {
				reads.add(holder.getElement().getName() + " -> " + describe(AadlBaUtils.getTypeHolder(holder)));
			}
		}
		assertEquals(ITERATOR_READS, reads);
	}

	/**
	 * Serializes a copy of the annex rather than the annex itself, because the registered unparser returns the source
	 * text of anything that still has a node model and the generated sequencers are what has to omit the classifier.
	 * The copy joins the parsed resource for the duration, since serializing the classifier cross-references needs the
	 * scope that resource provides.
	 */
	@Test
	public void omittedIteratorClassifierRoundTripsThroughTheUnparser() throws Exception {
		var root = testHelper.parseFile(MODELS + "Issue3173.aadl");
		validationHelper.assertNoIssues(root);
		var copy = EcoreUtil.copy(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst().getParsedAnnexSubclause());

		final String serialized;
		root.eResource().getContents().add(copy);
		try {
			serialized = ((AnnexUnparserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID))
					.getAnnexUnparser("behavior_specification")
					.unparseAnnexSubclause(copy, "");
		} finally {
			root.eResource().getContents().remove(copy);
		}
		// The serializer emits one flat line with a space around every token, so the assertions run on normalized text.
		var normalized = serialized.replaceAll("\\s+", " ").replace("( ", "(").replace(" )", ")");
		assertTrue(serialized, normalized.contains("for (step in 0 .. 2)"));
		assertTrue(serialized, normalized.contains("forall (other in 0 .. 2)"));
		assertTrue(serialized, normalized.contains("for (sample in readings)"));
		assertTrue(serialized, normalized.contains("forall (entry in pairs)"));
		assertTrue(serialized, normalized.contains("for (typed : Base_Types::Integer in 0 .. 2)"));

		var source = NodeModelUtils.getNode(root).getText();
		var reparsed = testHelper.parseString(source.substring(0, source.indexOf("{**") + 3) + serialized
				+ source.substring(source.indexOf("**}")));
		validationHelper.assertNoIssues(reparsed);
		assertEquals(ITERATOR_TYPES, iteratorTypes(strictAnnex(reparsed)));
	}

	/**
	 * A classifier of another category has no strict representation, so it is reported on the reference itself and the
	 * strict-model checkers do not run over the loop. Reporting it keeps the declaration rejected instead of having the
	 * iterated values supply a type for it.
	 */
	@Test
	public void writtenIteratorClassifierMustBeADataClassifier() throws Exception {
		var root = testHelper.parseFile(MODELS + "NonDataIteratorClassifier.aadl");
		var source = NodeModelUtils.getNode(root).getRootNode().getText();
		var issues = validationHelper.validate(root).stream().sorted(Comparator.comparing(Issue::getOffset)).toList();
		assertEquals(issues.toString(), 2, issues.size());
		assertEquals(List.of("helper", "helper.impl"), issues.stream().map(issue -> {
			assertEquals(Severity.ERROR, issue.getSeverity());
			var written = source.substring(issue.getOffset(), issue.getOffset() + issue.getLength());
			assertEquals("'" + written + "' is not a data classifier: a for or forall iterator can only name a data"
					+ " component classifier", issue.getMessage());
			return written;
		}).toList());
	}

	/** The name and type of every iterator of the annex, in the order the annex writes the loops. */
	private static List<String> iteratorTypes(final BehaviorAnnex annex) throws Exception {
		var result = new ArrayList<String>();
		for (var contents = annex.eAllContents(); contents.hasNext();) {
			if (contents.next() instanceof ForOrForAllStatement loop) {
				result.add(loop.getIterativeVariable().getName() + " -> "
						+ describe(AadlBaUtils.getTypeHolder(loop.getIterativeVariable())));
			}
		}
		return result;
	}

	private static String describe(final TypeHolder type) {
		return type.getDataRep().getName() + ' '
				+ (type.getKlass() == null ? "<no classifier>" : type.getKlass().getQualifiedName());
	}

	private static BehaviorAnnex strictAnnex(final AadlPackage root) {
		return BehaviorAnnexUtil.getStrictModel(AnnexUtil.getAllDefaultAnnexSubclauses(root).getFirst());
	}
}
