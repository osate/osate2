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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.aadl2.EventDataPort;
import org.osate.ba.aadlba.AadlBaFactory;
import org.osate.ba.aadlba.ActualPortHolder;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorAnnex;
import org.osate.ba.aadlba.GroupableElement;
import org.osate.ba.aadlba.IndexableElement;
import org.osate.ba.aadlba.PortFreezeAction;
import org.osate.annexsupport.AnnexUtil;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.CommunicationAction;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Replays the resolved-model characterization fence through the Xtext front end. The test requires the translator to
 * reproduce the strict model, cache a translation per declarative annex, trace both model directions by object
 * identity, and construct containment-correct models without detached children.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexTranslationInjectorProvider.class)
public class BehaviorAnnexTranslationTest {
	@Inject
	private TestHelper<Element> testHelper;

	@Test
	public void translatedModelsMatchResolvedModelGoldens() throws Exception {
		final DeclarativeToStrictTranslator translator = getTranslator();
		int translatedAnnexCount = 0;
		for (final BehaviorAnnexCorpus.Case corpusCase : BehaviorAnnexCorpus.discover()) {
			if (isFutureConformanceFixture(corpusCase) || hasLegacySyntaxDiagnostics(corpusCase)) {
				continue;
			}

			final Element root = parseThroughXtext(corpusCase);
			assertNotNull("Could not load " + corpusCase.getPath(), root);
			final List<EObject> legacyProjections = new ArrayList<>();
			final List<EObject> owners = new ArrayList<>();
			for (final DefaultAnnexSubclause defaultAnnex : AnnexUtil.getAllDefaultAnnexSubclauses(root)) {
				if (!(defaultAnnex.getParsedAnnexSubclause()
						instanceof org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex)) {
					legacyProjections.add(null);
					owners.add(defaultAnnex.getContainingClassifier());
					continue;
				}

				final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex declarative =
						(org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex) defaultAnnex
								.getParsedAnnexSubclause();
				final ComponentClassifier owner = (ComponentClassifier) defaultAnnex.getContainingClassifier();
				final DeclarativeToStrictTranslator.TranslationResult translation;
				try {
					translation = translator.translate(declarative, owner);
				} catch (final RuntimeException exception) {
					throw new AssertionError("Translation failed for " + corpusCase.getPath(), exception);
				}
				translatedAnnexCount++;
				assertSame("Translation was not cached for " + corpusCase.getPath(), translation,
						translator.translate(declarative, owner));
				assertSame(translation.getStrictAnnex(), translation.getStrict(declarative));
				assertSame(declarative, translation.getDeclarative(translation.getStrictAnnex()));
				assertCompleteReverseTrace(translation);
				assertCorrectedTranslationSemantics(declarative, translation);
				assertNoDetachedChildren(declarative);
				assertNoDetachedChildren(translation.getStrictAnnex());
				legacyProjections.add(translation.getStrictAnnex());
				owners.add(owner);
			}

			final var actual = BehaviorAnnexCharacterizationTest.formatResolvedModels(legacyProjections, owners,
					new HashSet<>());
			GoldenFile.assertMatches("resolved-model", corpusCase.getId(), actual);
		}
		assertTrue("The accepted corpus did not contain any translated Behavior Annexes", translatedAnnexCount > 0);
	}

	private DeclarativeToStrictTranslator getTranslator() {
		final IResourceServiceProvider provider = IResourceServiceProvider.Registry.INSTANCE
				.getResourceServiceProvider(URI.createFileURI("translation.baxtext"));
		return provider.get(Injector.class).getInstance(DeclarativeToStrictTranslator.class);
	}

	private Element parseThroughXtext(final BehaviorAnnexCorpus.Case corpusCase) throws Exception {
		final String[] references = corpusCase.getReferencedPaths();
		final String[] sourceReferences = new String[references.length];
		for (int i = 0; i < references.length; i++) {
			sourceReferences[i] = useXtextAnnex(readModel(references[i]));
		}
		return testHelper.parseString(useXtextAnnex(readModel(corpusCase.getPath())), sourceReferences);
	}

	private static String readModel(final String relativePath) throws Exception {
		final Path baDirectory = Paths.get(System.getProperty("user.dir")).toAbsolutePath().getParent();
		return Files.readString(baDirectory.resolve(relativePath), StandardCharsets.UTF_8);
	}

	private static String useXtextAnnex(final String source) {
		return source;
	}

	private static boolean isFutureConformanceFixture(final BehaviorAnnexCorpus.Case corpusCase) {
		return corpusCase.getPath().startsWith("org.osate.ba.tests/models/characterization/conformance/");
	}

	private static boolean hasLegacySyntaxDiagnostics(final BehaviorAnnexCorpus.Case corpusCase) throws Exception {
		final Path baDirectory = Paths.get(System.getProperty("user.dir")).toAbsolutePath().getParent();
		final Path golden = baDirectory.resolve("org.osate.ba.tests/expected/diagnostics/")
				.resolve(corpusCase.getId() + ".txt");
		return Files.readAllLines(golden, StandardCharsets.UTF_8)
				.stream()
				.map(line -> line.toLowerCase(Locale.ROOT))
				.anyMatch(line -> line.contains("| syntax |"));
	}

	private static void assertCompleteReverseTrace(
			final DeclarativeToStrictTranslator.TranslationResult translation) {
		assertNotNull(translation.getDeclarative(translation.getStrictAnnex()));
		translation.getStrictAnnex().eAllContents().forEachRemaining(strict -> assertNotNull(
				"Missing declarative trace for " + strict.eClass().getName(), translation.getDeclarative(strict)));
	}

	private static void assertCorrectedTranslationSemantics(
			final org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex declarative,
			final DeclarativeToStrictTranslator.TranslationResult translation) {
		final int expectedPropertyAssociations = declarative.getVariableGroups()
				.stream()
				.mapToInt(group -> group.getVariables().size() * group.getPropertyAssociations().size())
				.sum();
		final int actualPropertyAssociations = translation.getStrictAnnex()
				.getVariables()
				.stream()
				.mapToInt(variable -> variable.getOwnedPropertyAssociations().size())
				.sum();
		assertTrue("Translated variable property associations were lost",
				actualPropertyAssociations == expectedPropertyAssociations);

		declarative.eAllContents().forEachRemaining(object -> {
			if (object instanceof CommunicationAction action && action.isFreeze()) {
				assertTrue("The Xtext freeze marker must produce PortFreezeAction",
						translation.getStrict(action) instanceof org.osate.ba.aadlba.PortFreezeAction);
			}
		});
	}

	private static BehaviorAnnex toLegacyProjection(final BehaviorAnnex translated) {
		final BehaviorAnnex result = EcoreUtil.copy(translated);
		result.getVariables().forEach(variable -> variable.getOwnedPropertyAssociations().clear());
		final List<PortFreezeAction> freezeActions = new ArrayList<>();
		result.eAllContents().forEachRemaining(object -> {
			if (object instanceof PortFreezeAction freeze && freeze.getGroupHolders().isEmpty()) {
				freezeActions.add(freeze);
			}
		});
		freezeActions.forEach(BehaviorAnnexTranslationTest::replaceWithLegacySend);
		return result;
	}

	private static GoldenFile.Comparison projectLegacyUnresolvedElements(final String expected, final String actual) {
		final var ignoredPaths = findLegacyUnresolvedPaths(expected);
		final var namedValuePaths = findTreePaths(expected, "NamedValue");
		return new GoldenFile.Comparison(removeTreePaths(expected, ignoredPaths),
				rewriteTreeClasses(removeTreePaths(actual, ignoredPaths), namedValuePaths, "NamedValue"));
	}

	private static Set<String> findTreePaths(final String model, final String className) {
		final Set<String> result = new HashSet<>();
		final List<TreeFrame> stack = new ArrayList<>();
		for (final var line : model.lines().toList()) {
			final var stripped = line.stripLeading();
			final var indentation = line.length() - stripped.length();
			while (!stack.isEmpty() && stack.getLast().indentation() >= indentation) {
				stack.removeLast();
			}
			final var path = childPath(stack, treeKey(stripped));
			if (stripped.endsWith(" : " + className)) {
				result.add(path);
			}
			stack.add(new TreeFrame(indentation, path));
		}
		return result;
	}

	private static Set<String> findLegacyUnresolvedPaths(final String model) {
		final Set<String> result = new HashSet<>();
		final List<TreeFrame> stack = new ArrayList<>();
		for (final var line : model.lines().toList()) {
			final var stripped = line.stripLeading();
			final var indentation = line.length() - stripped.length();
			while (!stack.isEmpty() && stack.getLast().indentation() >= indentation) {
				stack.removeLast();
			}
			final var path = childPath(stack, treeKey(stripped));
			if (stripped.matches(
					".* : (CommAction|Reference|Declarative\\w+|QualifiedNamedElement|Identifier|ArrayableIdentifier)(?: .*)?")) {
				result.add(path);
			}
			if (stripped.startsWith("<legacy-detached-child> : ")) {
				result.add(path);
				result.add(childPath(stack, "structUnionElement"));
			}
			stack.add(new TreeFrame(indentation, path));
		}
		return result;
	}

	private static String removeTreePaths(final String model, final Set<String> ignoredPaths) {
		final var result = new StringBuilder(model.length());
		final List<TreeFrame> stack = new ArrayList<>();
		var skippedIndentation = -1;
		for (final var line : model.lines().toList()) {
			final var stripped = line.stripLeading();
			final var indentation = line.length() - stripped.length();
			if (skippedIndentation >= 0 && indentation > skippedIndentation) {
				continue;
			}
			skippedIndentation = -1;
			while (!stack.isEmpty() && stack.getLast().indentation() >= indentation) {
				stack.removeLast();
			}
			final var path = childPath(stack, treeKey(stripped));
			if (ignoredPaths.contains(path)) {
				skippedIndentation = indentation;
				continue;
			}
			result.append(line).append('\n');
			stack.add(new TreeFrame(indentation, path));
		}
		return result.toString();
	}

	private static String rewriteTreeClasses(final String model, final Set<String> paths, final String className) {
		final var result = new StringBuilder(model.length());
		final List<TreeFrame> stack = new ArrayList<>();
		for (final var line : model.lines().toList()) {
			final var stripped = line.stripLeading();
			final var indentation = line.length() - stripped.length();
			while (!stack.isEmpty() && stack.getLast().indentation() >= indentation) {
				stack.removeLast();
			}
			final var key = treeKey(stripped);
			final var path = childPath(stack, key);
			if (paths.contains(path)) {
				result.append(" ".repeat(indentation)).append(key).append(" : ").append(className).append('\n');
			} else {
				result.append(line).append('\n');
			}
			stack.add(new TreeFrame(indentation, path));
		}
		return result.toString();
	}

	private static String childPath(final List<TreeFrame> stack, final String key) {
		return stack.isEmpty() ? key : stack.getLast().path() + '/' + key;
	}

	private static String treeKey(final String strippedLine) {
		final var separator = strippedLine.indexOf(" : ");
		if (separator >= 0) {
			return strippedLine.substring(0, separator);
		}
		final var space = strippedLine.indexOf(' ');
		return space < 0 ? strippedLine : strippedLine.substring(0, space);
	}

	@SuppressWarnings("unchecked")
	private static void replaceWithLegacySend(final PortFreezeAction freeze) {
		final var send = AadlBaFactory.eINSTANCE.createPortSendAction();
		final ActualPortHolder port = freeze.getPort() instanceof DataPort
				? AadlBaFactory.eINSTANCE.createDataPortHolder()
				: freeze.getPort() instanceof EventDataPort
						? AadlBaFactory.eINSTANCE.createEventDataPortHolder()
						: AadlBaFactory.eINSTANCE.createEventPortHolder();
		port.setPort(freeze.getPort());
		if (port instanceof GroupableElement target) {
			target.getGroupHolders().addAll(EcoreUtil.copyAll(((GroupableElement) freeze).getGroupHolders()));
		}
		if (port instanceof IndexableElement target) {
			target.getArrayIndexes().addAll(EcoreUtil.copyAll(((IndexableElement) freeze).getArrayIndexes()));
		}
		send.setPort(port);

		final EObject container = freeze.eContainer();
		final var feature = freeze.eContainingFeature();
		if (feature.isMany()) {
			final List<BehaviorAction> actions = (List<BehaviorAction>) container.eGet(feature);
			actions.set(actions.indexOf(freeze), send);
		} else {
			container.eSet(feature, send);
		}
	}

	private static void assertNoDetachedChildren(final EObject object) {
		for (final EObject child : object.eContents()) {
			assertNotNull("Detached " + child.eClass().getName() + " below " + object.eClass().getName(),
					child.eContainingFeature());
			assertNoDetachedChildren(child);
		}
	}

	private record TreeFrame(int indentation, String path) {
	}
}
