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
package org.osate.ba.tests.characterization;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.QueuingParseErrorReporter.Message;
import org.osate.annexsupport.AnnexParserRegistry;
import org.osate.annexsupport.AnnexRegistry;
import org.osate.annexsupport.AnnexUnparserRegistry;
import org.osate.annexsupport.AnnexUtil;
import org.osate.ba.aadlba.AadlBaPackage;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.BehaviorAnnexStandaloneSetup;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

import com.google.inject.Inject;
import com.itemis.xtext.testing.FluentIssueCollection;

/**
 * Pins the current hand-written Behavior Annex implementation before the Xtext port. The test records diagnostics,
 * resolved strict-model shape, unparse/round-trip behavior, and source-position resolution for every checked-in BA
 * model, and verifies that the corpus instantiates every concrete holder class needed by the future translator.
 */
@RunWith(XtextRunner.class)
@InjectWith(Aadl2InjectorProvider.class)
public class BehaviorAnnexCharacterizationTest {
	private static final String ANNEX_NAME = BehaviorAnnexStandaloneSetup.ANNEX_NAME;
	private static final String GRAMMAR_HAZARDS_MODEL = "org.osate.ba.tests/models/characterization/GrammarHazards.aadl";
	private static final Set<String> UNREACHABLE_HOLDER_BASES = new HashSet<>();
	static {
		// No production parser, resolver, or type-checker path creates these concrete Ecore base classes. Production
		// always creates one of their semantic subclasses, so direct factory construction would not test real behavior.
		UNREACHABLE_HOLDER_BASES.add("CalledSubprogramHolder");
		UNREACHABLE_HOLDER_BASES.add("FeatureHolder");
		UNREACHABLE_HOLDER_BASES.add("SubcomponentHolder");
	}

	/*
	 * AadlBaParser.realLiteralChecker has a "mal-formatted real literal" message, but REAL_LIT accepts only decimal
	 * forms that Double.parseDouble accepts. Therefore no external source can reach that message. Do not manufacture a
	 * test-only path for it or require the Xtext implementation to reproduce dead recovery code.
	 */

	@Inject
	private TestHelper<Element> testHelper;

	@Inject
	private DeclarativeToStrictTranslator translator;

	@Test
	public void characterizeCurrentImplementation() throws Exception {
		final Set<String> instantiatedHolderClasses = new HashSet<>();
		for (final BehaviorAnnexCorpus.Case corpusCase : BehaviorAnnexCorpus.discover()) {
			final Element root = testHelper.parseFile(corpusCase.getPath(), corpusCase.getReferencedPaths());
			assertNotNull("Could not load " + corpusCase.getPath(), root);

			final FluentIssueCollection issueCollection = testHelper.testResource(root.eResource());
			GoldenFile.assertMatches("diagnostics", corpusCase.getId(),
					formatDiagnostics(issueCollection.getIssues()));

			final List<DefaultAnnexSubclause> annexes = AnnexUtil.getAllDefaultAnnexSubclauses(root);
			GoldenFile.assertMatches("resolved-model", corpusCase.getId(),
					formatResolvedModels(annexes, instantiatedHolderClasses));
			GoldenFile.assertMatches("positions", corpusCase.getId(), formatPositions(annexes));
			GoldenFile.assertMatches("unparse", corpusCase.getId(), formatUnparseAndCheckRoundTrip(annexes));
		}

		final Set<String> expectedHolderClasses = new TreeSet<>();
		for (final EClassifier classifier : AadlBaPackage.eINSTANCE.getEClassifiers()) {
			if (classifier instanceof EClass) {
				final EClass eClass = (EClass) classifier;
				if (!eClass.isAbstract() && eClass.getName().endsWith("Holder")) {
					expectedHolderClasses.add(eClass.getName());
				}
			}
		}

		final Set<String> incorrectlyInstantiatedBases = new TreeSet<>(instantiatedHolderClasses);
		incorrectlyInstantiatedBases.retainAll(UNREACHABLE_HOLDER_BASES);
		assertTrue("Generic holder bases must not be instantiated: " + incorrectlyInstantiatedBases,
				incorrectlyInstantiatedBases.isEmpty());
		expectedHolderClasses.removeAll(UNREACHABLE_HOLDER_BASES);
		expectedHolderClasses.removeAll(instantiatedHolderClasses);
		assertTrue("Concrete holder classes missing from the characterization corpus: " + expectedHolderClasses,
				expectedHolderClasses.isEmpty());
	}

	/**
	 * Keeps the concentrated lexer/operator hazard model valid. Unlike the legacy-error fixtures, this is an acceptance
	 * test that the Xtext grammar must continue to pass without changing its expectation.
	 */
	@Test
	public void grammarHazardsRemainAccepted() throws Exception {
		final FluentIssueCollection issues = testHelper.testFile(GRAMMAR_HAZARDS_MODEL);
		assertTrue(issues.getSummary(), issues.getIssues().isEmpty());
	}

	/**
	 * Defines the required outcome for the replacement serializer without requiring the legacy unparser's known
	 * failures to be reproduced. Phase 7 must switch this test to the Xtext serializer, remove {@link Ignore}, and make
	 * the complete corpus pass.
	 */
	@Test
	public void xtextSerializerMustRoundTripCompleteCorpus() throws Exception {
		for (final BehaviorAnnexCorpus.Case corpusCase : BehaviorAnnexCorpus.discover()) {
			final Element root = testHelper.parseFile(corpusCase.getPath(), corpusCase.getReferencedPaths());
			assertNotNull("Could not load " + corpusCase.getPath(), root);
			if (!testHelper.testResource(root.eResource()).getIssues().isEmpty()) {
				continue;
			}
			for (final DefaultAnnexSubclause annex : AnnexUtil.getAllDefaultAnnexSubclauses(root)) {
				if (annex.getParsedAnnexSubclause() instanceof
						org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex) {
					final String serialized = getUnparser().unparseAnnexSubclause(
							annex.getParsedAnnexSubclause(), "");
					assertRoundTrip(annex, serialized);
				}
			}
		}
	}

	/**
	 * Prevents the Xtext AST and translated strict model from inheriting legacy children that appear in
	 * {@link EObject#eContents()} without an {@link EObject#eContainingFeature()}.
	 */
	@Test
	public void xtextAndTranslatedModelsMustNotContainDetachedChildren() throws Exception {
		for (final BehaviorAnnexCorpus.Case corpusCase : BehaviorAnnexCorpus.discover()) {
			final Element root = testHelper.parseFile(corpusCase.getPath(), corpusCase.getReferencedPaths());
			assertNotNull("Could not load " + corpusCase.getPath(), root);
			if (!testHelper.testResource(root.eResource()).getIssues().isEmpty()) {
				continue;
			}
			for (final DefaultAnnexSubclause annex : AnnexUtil.getAllDefaultAnnexSubclauses(root)) {
				if (annex.getParsedAnnexSubclause() != null) {
					assertNoDetachedChildren(annex.getParsedAnnexSubclause());
					if (annex.getParsedAnnexSubclause() instanceof
							org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex source) {
						assertNoDetachedChildren(translator.translate(source,
								(org.osate.aadl2.ComponentClassifier) annex.getContainingClassifier())
								.getStrictAnnex());
					}
				}
			}
		}
	}

	private static void assertNoDetachedChildren(final EObject object) {
		for (final EObject child : object.eContents()) {
			assertNotNull("Detached " + child.eClass().getName() + " below " + object.eClass().getName(),
					child.eContainingFeature());
			assertNoDetachedChildren(child);
		}
	}

	private static String formatDiagnostics(final List<Issue> issues) {
		final List<String> lines = new ArrayList<>();
		for (final Issue issue : issues) {
			final String origin = Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode())
					? "linking"
					: issue.isSyntaxError() ? "syntax" : "semantic";
			lines.add(lower(issue.getSeverity().toString()) + " | " + origin + " | " + value(issue.getLineNumber())
					+ " | " + value(issue.getColumn()) + " | " + value(issue.getLength()) + " | "
					+ escape(issue.getMessage()));
		}
		Collections.sort(lines);
		return joinLines(lines);
	}

	private String formatResolvedModels(final List<DefaultAnnexSubclause> annexes,
			final Set<String> instantiatedHolderClasses) {
		final List<EObject> models = new ArrayList<>();
		final List<EObject> owners = new ArrayList<>();
		for (final DefaultAnnexSubclause defaultAnnex : annexes) {
			if (defaultAnnex.getParsedAnnexSubclause() instanceof
					org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex source) {
				try {
					models.add(translator.translate(source,
							(org.osate.aadl2.ComponentClassifier) defaultAnnex.getContainingClassifier())
							.getStrictAnnex());
				} catch (RuntimeException | StackOverflowError e) {
					models.add(null);
				}
			} else {
				models.add(null);
			}
			owners.add(defaultAnnex.getContainingClassifier());
		}
		return formatResolvedModels(models, owners, instantiatedHolderClasses);
	}

	static String formatResolvedModels(final List<? extends EObject> models, final List<? extends EObject> owners,
			final Set<String> instantiatedHolderClasses) {
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < models.size(); i++) {
			result.append("annex[").append(i).append("] owner=")
					.append(qualifiedName(owners.get(i))).append('\n');
			if (models.get(i) == null) {
				result.append("  <unparsed>\n");
			} else {
				appendModel(result, models.get(i), "parsedAnnexSubclause", 1, instantiatedHolderClasses);
			}
		}
		return result.toString();
	}

	private static void appendModel(final StringBuilder result, final EObject object, final String containment,
			final int depth, final Set<String> instantiatedHolderClasses) {
		indent(result, depth).append(containment).append(" : ").append(object.eClass().getName());
		final String name = name(object);
		if (name != null) {
			result.append(" name=").append(name);
		}

		if (object.eClass().getName().endsWith("Holder")) {
			instantiatedHolderClasses.add(object.eClass().getName());
			final EStructuralFeature elementFeature = object.eClass().getEStructuralFeature("element");
			if (elementFeature != null) {
				final Object element = object.eGet(elementFeature, false);
				if (element instanceof EObject) {
					final EObject resolved = (EObject) element;
					result.append(" element=").append(qualifiedName(resolved)).append(" [")
							.append(resolved.eClass().getName()).append(']');
				} else {
					result.append(" element=<null>");
				}
			}
		}
		result.append('\n');

		final Map<EStructuralFeature, Integer> indexes = new HashMap<>();
		for (final EObject child : object.eContents()) {
			final EStructuralFeature feature = child.eContainingFeature();
			if (feature == null) {
				appendModel(result, child, "<legacy-detached-child>", depth + 1, instantiatedHolderClasses);
				continue;
			}
			final int index = indexes.containsKey(feature) ? indexes.get(feature).intValue() : 0;
			indexes.put(feature, Integer.valueOf(index + 1));
			final String childContainment = feature.isMany() ? feature.getName() + "[" + index + "]"
					: feature.getName();
			appendModel(result, child, childContainment, depth + 1, instantiatedHolderClasses);
		}
	}

	private String formatUnparseAndCheckRoundTrip(final List<DefaultAnnexSubclause> annexes) throws Exception {
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < annexes.size(); i++) {
			final DefaultAnnexSubclause defaultAnnex = annexes.get(i);
			result.append("===== annex[").append(i).append("] owner=")
					.append(qualifiedName(defaultAnnex.getContainingClassifier())).append(" =====\n");
			if (!(defaultAnnex.getParsedAnnexSubclause() instanceof
					org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex)) {
				result.append("<unparsed>\n");
				continue;
			}

			final String first;
			try {
				first = getUnparser().unparseAnnexSubclause(defaultAnnex.getParsedAnnexSubclause(), "");
			} catch (RuntimeException e) {
				result.append("<xtext-serialization-exception> ").append(e.getClass().getName()).append(": ")
						.append(value(e.getMessage())).append('\n');
				continue;
			}
			result.append(first.replace("\t", "\\t"));
			if (!first.endsWith("\n")) {
				result.append('\n');
			}
			result.append("----- Xtext reparse -----\n");
			result.append(characterizeRoundTrip(defaultAnnex, first));
		}
		return result.toString();
	}

	private String characterizeRoundTrip(final DefaultAnnexSubclause defaultAnnex, final String first) throws Exception {
		final StringBuilder result = new StringBuilder();
		final RoundTripResult roundTrip = roundTrip(defaultAnnex, first);
		if (!roundTrip.parseMessages.isEmpty()) {
			result.append("parse-failure\n").append(formatMessages(roundTrip.parseMessages));
		} else {
			result.append("reparsed\n");
		}
		return result.toString();
	}

	private void assertRoundTrip(final DefaultAnnexSubclause defaultAnnex, final String serialized) throws Exception {
		final RoundTripResult roundTrip = roundTrip(defaultAnnex, serialized);
		assertEquals("Serialized output did not reparse for " + qualifiedName(defaultAnnex.getContainingClassifier())
				+ ":\n" + formatMessages(roundTrip.parseMessages) + "\n--- serialization ---\n" + serialized, 0,
				roundTrip.parseMessages.size());
	}

	private RoundTripResult roundTrip(final DefaultAnnexSubclause defaultAnnex, final String first) throws Exception {
			final QueuingParseErrorReporter reporter = new QueuingParseErrorReporter();
			reporter.setContextResource(defaultAnnex.eResource());
			final AnnexSubclause reparsed = getParser().parseAnnexSubclause(ANNEX_NAME, first,
					defaultAnnex.eResource().getURI().lastSegment(), 1, AnnexUtil.getAnnexOffset(defaultAnnex),
					reporter);
			if (reporter.getNumErrors() != 0 || !(reparsed instanceof
					org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex)) {
				return new RoundTripResult(first, null, reporter.getErrors());
			}
			return new RoundTripResult(first, first, Collections.emptyList());
	}

	private static org.osate.annexsupport.AnnexParser getParser() {
		return ((AnnexParserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_PARSER_EXT_ID))
				.getAnnexParser(ANNEX_NAME);
	}

	private static org.osate.annexsupport.AnnexUnparser getUnparser() {
		return ((AnnexUnparserRegistry) AnnexRegistry.getRegistry(AnnexRegistry.ANNEX_UNPARSER_EXT_ID))
				.getAnnexUnparser(ANNEX_NAME);
	}

	private static String formatMessages(final List<Message> messages) {
		final StringBuilder result = new StringBuilder();
		for (final Message message : messages) {
			result.append(message.kind).append(" line ").append(message.line).append(": ").append(message.message)
					.append('\n');
		}
		return result.toString();
	}

	private static String formatPositions(final List<DefaultAnnexSubclause> annexes) {
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < annexes.size(); i++) {
			final DefaultAnnexSubclause defaultAnnex = annexes.get(i);
			result.append("annex[").append(i).append("] owner=")
					.append(qualifiedName(defaultAnnex.getContainingClassifier())).append('\n');
			if (!(defaultAnnex.getParsedAnnexSubclause() instanceof
					org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex)) {
				result.append("  <unparsed>\n");
				continue;
			}

			final Set<String> positions = new TreeSet<>();
			final EObject behaviorAnnex = defaultAnnex.getParsedAnnexSubclause();
			final List<EObject> objects = new ArrayList<>();
			objects.add(behaviorAnnex);
			behaviorAnnex.eAllContents().forEachRemaining(objects::add);
			for (final EObject object : objects) {
				final INode node = NodeModelUtils.findActualNodeFor(object);
				if (node != null) {
					positions.add("(" + object.eClass().getName() + ", " + value(name(object)) + ", "
							+ node.getOffset() + ", " + node.getLength() + ")");
				}
			}
			for (final String position : positions) {
				result.append("  ").append(position).append('\n');
			}
		}
		return result.toString();
	}

	private static String qualifiedName(final EObject object) {
		if (object == null) {
			return "<null>";
		}
		if (object instanceof NamedElement) {
			final String qualifiedName = ((NamedElement) object).getQualifiedName();
			if (qualifiedName != null) {
				return qualifiedName;
			}
			final String name = ((NamedElement) object).getName();
			if (name != null) {
				return name;
			}
		}
		return object.eClass().getName();
	}

	private static String name(final EObject object) {
		if (object instanceof NamedElement) {
			return ((NamedElement) object).getName();
		}
		final EStructuralFeature nameFeature = object.eClass().getEStructuralFeature("name");
		if (nameFeature != null) {
			final Object value = object.eGet(nameFeature, false);
			return value == null ? null : value.toString();
		}
		return null;
	}

	private static String value(final Object value) {
		return value == null ? "<null>" : value.toString();
	}

	private static String lower(final String value) {
		return value == null ? "<null>" : value.toLowerCase();
	}

	private static String escape(final String value) {
		return value(value).replaceAll("@[0-9a-fA-F]+(?=[{\\[])", "@<identity>")
				.replace("\\", "\\\\")
				.replace("|", "\\|")
				.replace("\n", "\\n")
				.replace("\r", "\\r");
	}

	private static String joinLines(final List<String> lines) {
		final StringBuilder result = new StringBuilder();
		for (final String line : lines) {
			result.append(line).append('\n');
		}
		return result.toString();
	}

	private static StringBuilder indent(final StringBuilder result, final int depth) {
		for (int i = 0; i < depth; i++) {
			result.append("  ");
		}
		return result;
	}

	private static final class StageMessages {
		private final Map<MessageKey, List<String>> origins = new HashMap<>();
		private final List<Object> strongLocationReferences = new ArrayList<>();

		void retainLocations(final EObject root) {
			retainLocation(root);
			for (final Iterator<EObject> contents = root.eAllContents(); contents.hasNext();) {
				retainLocation(contents.next());
			}
		}

		private void retainLocation(final EObject object) {
			if (object instanceof Element) {
				final Object location = ((Element) object).getLocationReference();
				if (location != null) {
					strongLocationReferences.add(location);
				}
			}
		}

		void add(final String origin, final List<Message> messages) {
			for (final Message message : messages) {
				final MessageKey key = new MessageKey(message.kind, message.line, message.message);
				List<String> values = origins.get(key);
				if (values == null) {
					values = new ArrayList<>();
					origins.put(key, values);
				}
				values.add(origin);
			}
		}

		String takeOrigin(final Issue issue) {
			final MessageKey key = new MessageKey(severityKind(issue), issue.getLineNumber().intValue(),
					issue.getMessage());
			final List<String> values = origins.get(key);
			if (values != null && !values.isEmpty()) {
				return values.remove(0);
			}
			if (Diagnostic.LINKING_DIAGNOSTIC.equals(issue.getCode())) {
				return "linking";
			}
			return issue.isSyntaxError() ? "syntax" : "semantic";
		}

		private static String severityKind(final Issue issue) {
			switch (issue.getSeverity()) {
			case ERROR:
				return QueuingParseErrorReporter.ERROR;
			case WARNING:
				return QueuingParseErrorReporter.WARNING;
			case INFO:
			default:
				return QueuingParseErrorReporter.INFO;
			}
		}
	}

	private static final class MessageKey {
		private final String kind;
		private final int line;
		private final String message;

		MessageKey(final String kind, final int line, final String message) {
			this.kind = kind;
			this.line = line;
			this.message = message;
		}

		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + (kind == null ? 0 : kind.hashCode());
			result = 31 * result + line;
			result = 31 * result + (message == null ? 0 : message.hashCode());
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof MessageKey)) {
				return false;
			}
			final MessageKey other = (MessageKey) obj;
			return line == other.line && equal(kind, other.kind) && equal(message, other.message);
		}

		private static boolean equal(final Object left, final Object right) {
			return left == null ? right == null : left.equals(right);
		}
	}

	private static final class RoundTripResult {
		private final String first;
		private final String second;
		private final List<Message> parseMessages;

		RoundTripResult(final String first, final String second, final List<Message> parseMessages) {
			this.first = first;
			this.second = second;
			this.parseMessages = parseMessages;
		}
	}
}
