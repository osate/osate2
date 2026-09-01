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
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.Element;
import org.osate.annexsupport.AnnexUtil;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ba.behaviorAnnex.BehaviorAnnex;
import org.osate.xtext.aadl2.ba.translation.DeclarativeToStrictTranslator;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Replays the resolved-model characterization fence through the temporary Xtext front end. The test requires the
 * phase-5 translator to reproduce the legacy strict model, cache a translation per declarative annex, trace both model
 * directions by object identity, and construct containment-correct models without legacy detached children.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexTranslationInjectorProvider.class)
public class BehaviorAnnexTranslationTest {
	private static final Pattern LEGACY_ANNEX_NAME = Pattern.compile(
			"(?i)(\\bannex\\s+)behavior_specification(\\s*\\{\\*\\*)");
	private static final String XTEXT_ANNEX_NAME = "behavior_specification_xtext";

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
			final List<EObject> strictModels = new ArrayList<>();
			final List<EObject> owners = new ArrayList<>();
			for (final DefaultAnnexSubclause defaultAnnex : AnnexUtil.getAllDefaultAnnexSubclauses(root)) {
				if (!(defaultAnnex.getParsedAnnexSubclause() instanceof BehaviorAnnex)) {
					strictModels.add(null);
					owners.add(defaultAnnex.getContainingClassifier());
					continue;
				}

				final BehaviorAnnex declarative = (BehaviorAnnex) defaultAnnex.getParsedAnnexSubclause();
				final ComponentClassifier owner = (ComponentClassifier) defaultAnnex.getContainingClassifier();
				final DeclarativeToStrictTranslator.TranslationResult translation = translator.translate(declarative,
						owner);
				translatedAnnexCount++;
				assertSame("Translation was not cached for " + corpusCase.getPath(), translation,
						translator.translate(declarative, owner));
				assertSame(translation.getStrictAnnex(), translation.getStrict(declarative));
				assertSame(declarative, translation.getDeclarative(translation.getStrictAnnex()));
				assertCompleteReverseTrace(translation);
				assertNoDetachedChildren(declarative);
				assertNoDetachedChildren(translation.getStrictAnnex());
				strictModels.add(translation.getStrictAnnex());
				owners.add(owner);
			}

			GoldenFile.assertMatches("resolved-model", corpusCase.getId(), BehaviorAnnexCharacterizationTest
					.formatResolvedModels(strictModels, owners, new HashSet<>()));
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
		return LEGACY_ANNEX_NAME.matcher(source).replaceAll("$1" + XTEXT_ANNEX_NAME + "$2");
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

	private static void assertNoDetachedChildren(final EObject object) {
		for (final EObject child : object.eContents()) {
			assertNotNull("Detached " + child.eClass().getName() + " below " + object.eClass().getName(),
					child.eContainingFeature());
			assertNoDetachedChildren(child);
		}
	}
}
