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
package org.osate.xtext.aadl2.ba.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentImplementation;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.ErrorModelStandaloneSetup;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3293Test extends XtextTest {
	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validation;

	@Before
	public void registerEmv2() {
		ErrorModelStandaloneSetup.doSetup();
	}

	@Test
	public void highlightsSubcomponentFromDeclarationAndUses() throws Exception {
		assertOccurrences("Issue3293.aadl", "DesiredPositionState", 4, true);
	}

	@Test
	public void highlightsBehaviorVariablesAndIndexedUses() throws Exception {
		assertOccurrences("References.aadl", "counter", 6, true);
		assertOccurrences("References.aadl", "samples", 2, true);
	}

	@Test
	public void highlightsOnlyTheSelectedPathSegment() throws Exception {
		assertOccurrences("References.aadl", "storage", 2, true);
		assertOccurrences("References.aadl", "field", 2, true);
	}

	@Test
	public void highlightsPortReferences() throws Exception {
		assertOccurrences("References.aadl", "input", 3, true);
		assertOccurrences("References.aadl", "output", 2, true);
	}

	@Test
	public void preservesStateAndOrdinaryAadlReferences() throws Exception {
		assertOccurrences("References.aadl", "idle", 2, false);
		assertOccurrences("References.aadl", "Payload", 5, false);
	}

	@Test
	public void preservesEmv2References() throws Exception {
		assertOccurrences("Emv2.aadl", "event1", 2, false);
	}

	@Test
	public void distinguishesSameNamedVariablesInDifferentAnnexes() throws Exception {
		assertOccurrences("Scopes.aadl", "counter", 4, true, 0, 1);
		assertOccurrences("Scopes.aadl", "counter", 4, true, 2, 3);
	}

	private void assertOccurrences(final String file, final String name, final int count, final boolean selectUses,
			final int... occurrenceIndexes)
			throws Exception {
		var model = testHelper.parseFile("org.osate.xtext.aadl2.ba.tests/models/issue3293/" + file);
		validation.assertNoIssues(model);
		var resource = (XtextResource) model.eResource();
		var text = resource.getParseResult().getRootNode().getText();
		FrameworkUtil.getBundle(Aadl2Activator.class).start();
		var injector = Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
		var document = injector.getInstance(XtextDocument.class);
		document.set(text);
		document.setInput(resource);
		var editor = new XtextEditor() {
			@Override
			public IXtextDocument getDocument() {
				return document;
			}
		};
		var computer = injector.getInstance(IOccurrenceComputer.class);
		var allOffsets = new ArrayList<Integer>();
		for (var offset = text.indexOf(name); offset >= 0; offset = text.indexOf(name, offset + 1)) {
			allOffsets.add(offset);
		}
		assertEquals(count, allOffsets.size());
		var expected = occurrenceIndexes.length == 0 ? allOffsets
				: Arrays.stream(occurrenceIndexes).mapToObj(allOffsets::get).toList();
		if (file.equals("Issue3293.aadl")) {
			var target = ((ComponentImplementation) model.getOwnedPublicSection().getOwnedClassifiers().get(1))
					.getOwnedSubcomponents().get(0);
			assertSame(target, injector.getInstance(EObjectAtOffsetHelper.class).resolveElementAt(resource, expected.get(0)));
		}
		assertSame(resource, document.readOnly(state -> state));
		for (var offset : selectUses ? expected : List.of(expected.getFirst())) {
			var annotations = computer.createAnnotationMap(editor, new TextSelection(offset + 1, 0),
					SubMonitor.convert(new NullProgressMonitor()));
			assertEquals("Occurrences when selecting offset " + offset, expected,
					annotations.values().stream().map(position -> position.offset).sorted().toList());
			annotations.values().forEach(position -> assertEquals(name.length(), position.length));
		}
		document.disposeInput();
	}
}
