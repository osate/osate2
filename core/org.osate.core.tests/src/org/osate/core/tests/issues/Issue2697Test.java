/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, ANY WARRANTY OF FITNESS FOR PURPOSE
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
 * conditions contained in any such separate license file distributed with such Third Party Software. The parties who
 * own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries to this license with
 * respect to the terms applicable to such Third Party Software. Third Party Software licenses only apply to the Third
 * Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.core.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.formatting2.regionaccess.ITextReplacement;
import org.eclipse.xtext.ide.refactoring.IRenameStrategy2;
import org.eclipse.xtext.ide.refactoring.RefactoringIssueAcceptor.Severity;
import org.eclipse.xtext.ide.refactoring.RenameChange;
import org.eclipse.xtext.ide.refactoring.RenameContext;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.IEmfResourceChange;
import org.eclipse.xtext.ide.serializer.ITextDocumentChange;
import org.eclipse.xtext.ide.server.rename.ServerRefactoringIssueAcceptor;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.Modules2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.testsupport.Aadl2InjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.Aadl2StandaloneSetup;
import org.osate.xtext.aadl2.ide.Aadl2IdeModule;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.itemis.xtext.testing.XtextTest;

/**
 * Tests serializer-based AADL renames used by language servers. Component implementations encode
 * their realized type in the semantic name, so both implementation and type renames must preserve
 * that coupling in declarations and closing identifiers while related resources receive matching
 * cross-reference edits.
 */
@RunWith(XtextRunner.class)
@InjectWith(Issue2697Test.IdeInjectorProvider.class)
public class Issue2697Test extends XtextTest {
	private static final String MODEL_PATH = "org.osate.core.tests/models/issue2697/Issue2697.aadl";
	private static final String REFERENCE_MODEL_PATH =
			"org.osate.core.tests/models/issue2697/Issue2697References.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Test
	public void implementationRenamePreservesTypePrefix() throws Exception {
		var pkg = testHelper.parseFile(MODEL_PATH);
		validationHelper.assertNoIssues(pkg);
		var implementation = (SystemImplementation) pkg.getOwnedPublicSection().getOwnedClassifiers().get(1);

		var renamedText = rename(implementation, "renamed");

		assertTrue(renamedText, renamedText.contains("system implementation Original.renamed"));
		assertTrue(renamedText, renamedText.contains("end Original.renamed;"));
		assertFalse(renamedText, renamedText.contains("Original.first"));
		validationHelper.assertNoIssues(testHelper.parseString(renamedText));
	}

	@Test
	public void typeRenameUpdatesImplementationPrefixes() throws Exception {
		var pkg = testHelper.parseFile(MODEL_PATH);
		validationHelper.assertNoIssues(pkg);
		var type = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().get(0);

		var renamedText = rename(type, "Renamed");

		assertTrue(renamedText, renamedText.contains("system Renamed"));
		assertTrue(renamedText, renamedText.contains("end Renamed;"));
		assertTrue(renamedText, renamedText.contains("system implementation Renamed.first"));
		assertTrue(renamedText, renamedText.contains("end Renamed.first;"));
		assertTrue(renamedText, renamedText.contains("system implementation Renamed.second"));
		assertTrue(renamedText, renamedText.contains("end Renamed.second;"));
		assertFalse(renamedText, renamedText.contains("Original"));
		validationHelper.assertNoIssues(testHelper.parseString(renamedText));
	}

	@Test
	public void typeRenameUpdatesCrossFileReferences() throws Exception {
		var pkg = testHelper.parseFile(MODEL_PATH, REFERENCE_MODEL_PATH);
		validationHelper.assertNoIssues(pkg);
		var referenceResource = pkg.eResource()
				.getResourceSet()
				.getResource(URI.createURI(REFERENCE_MODEL_PATH), false);
		var referencePkg = (AadlPackage) referenceResource.getContents().getFirst();
		validationHelper.assertNoIssues(referencePkg);
		var type = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().getFirst();

		var renamedTexts = renameResources(type, "Renamed");
		var renamedSource = renamedTexts.get(URI.createURI(MODEL_PATH));
		var renamedReferences = renamedTexts.get(URI.createURI(REFERENCE_MODEL_PATH));

		assertNotNull(renamedSource);
		assertNotNull(renamedReferences);
		assertTrue(renamedReferences, renamedReferences.contains("system issue2697::Renamed;"));
		assertTrue(renamedReferences, renamedReferences.contains("system issue2697::Renamed.first;"));
		assertFalse(renamedReferences, renamedReferences.contains("issue2697::Original"));
		validationHelper.assertNoIssues(testHelper.parseString(renamedReferences, renamedSource));
	}

	private static String rename(NamedElement target, String newName) {
		return renameResources(target, newName).get(target.eResource().getURI());
	}

	private static Map<URI, String> renameResources(NamedElement target, String newName) {
		var resource = (XtextResource) target.eResource();
		var originalTexts = new HashMap<URI, String>();
		for (var loadedResource : resource.getResourceSet().getResources()) {
			if (loadedResource instanceof XtextResource xtextResource && xtextResource.getParseResult() != null) {
				originalTexts.put(loadedResource.getURI(), xtextResource.getParseResult().getRootNode().getText());
			}
		}
		var services = resource.getResourceServiceProvider();
		var changeSerializer = services.get(IChangeSerializer.class);
		var renameStrategy = services.get(IRenameStrategy2.class);
		var issues = new ServerRefactoringIssueAcceptor();
		var change = new RenameChange(newName, EcoreUtil.getURI(target));
		var context = new RenameContext(List.of(change), resource.getResourceSet(), changeSerializer, issues);
		var changes = new ArrayList<IEmfResourceChange>();

		renameStrategy.applyRename(context);
		changeSerializer.applyModifications(changes::add);

		assertEquals(Severity.OK, issues.getMaximumSeverity());
		var renamedTexts = new HashMap<URI, String>();
		changes.stream()
				.filter(ITextDocumentChange.class::isInstance)
				.map(ITextDocumentChange.class::cast)
				.forEach(documentChange -> {
					var originalText = originalTexts.get(documentChange.getOldURI());
					if (originalText != null) {
						renamedTexts.put(documentChange.getOldURI(),
								applyReplacements(originalText, documentChange.getReplacements()));
					}
				});
		return renamedTexts;
	}

	private static String applyReplacements(String originalText, List<ITextReplacement> replacements) {
		var result = new StringBuilder(originalText);
		replacements.stream()
				.sorted(Comparator.comparingInt(ITextReplacement::getOffset).reversed())
				.forEach(replacement -> result.replace(replacement.getOffset(),
						replacement.getOffset() + replacement.getLength(), replacement.getReplacementText()));
		return result.toString();
	}

	public static class IdeInjectorProvider extends Aadl2InjectorProvider {
		@Override
		protected Injector internalCreateInjector() {
			return new Aadl2StandaloneSetup() {
				@Override
				public Injector createInjector() {
					return Guice.createInjector(
							Modules2.mixin(IdeInjectorProvider.this.createRuntimeModule(), new Aadl2IdeModule()));
				}
			}.createInjectorAndDoEMFRegistration();
		}
	}
}
