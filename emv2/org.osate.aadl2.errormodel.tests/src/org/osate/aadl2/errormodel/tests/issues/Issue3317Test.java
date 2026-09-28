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
package org.osate.aadl2.errormodel.tests.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper;
import org.eclipse.xtext.ui.editor.hyperlinking.XtextHyperlink;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.errormodel.tests.ErrorModelInjectorProvider;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.util.Aadl2HyperlinkHelper;

import com.google.inject.Inject;
import com.itemis.xtext.testing.XtextTest;

/**
 * An annex-specific null position must allow normal Xtext hyperlink resolution to continue.
 */
@RunWith(XtextRunner.class)
@InjectWith(ErrorModelInjectorProvider.class)
public class Issue3317Test extends XtextTest {
	private static final String MODEL = "org.osate.aadl2.errormodel.tests/models/issue3317/Issue3317.aadl";
	private static final String ERROR_TYPE = "ErrorLibrary::AboveRange";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	private AadlPackage pkg;
	private XtextResource resource;
	private String text;
	private HyperlinkHelper hyperlinkHelper;

	@Before
	public void loadModel() {
		pkg = testHelper.parseFile(MODEL);
		validationHelper.assertNoIssues(pkg);
		resource = (XtextResource) pkg.eResource();
		text = resource.getParseResult().getRootNode().getText();
		hyperlinkHelper = Aadl2Activator.getInstance()
				.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2)
				.getInstance(HyperlinkHelper.class);
		assertTrue(hyperlinkHelper instanceof Aadl2HyperlinkHelper);
	}

	@Test
	public void hyperlinksToQualifiedErrorType() {
		var referenceOffset = text.indexOf(ERROR_TYPE);
		var nameOffset = text.indexOf("AboveRange", referenceOffset);
		assertTrue(referenceOffset >= 0);
		var system = (SystemType) pkg.getOwnedPublicSection().getOwnedClassifiers().getFirst();
		var annex = (ErrorModelSubclause) ((DefaultAnnexSubclause) system.getOwnedAnnexSubclauses().getFirst())
				.getParsedAnnexSubclause();
		var target = annex.getPropagations().getFirst().getTypeSet().getTypeTokens().getFirst().getType().getFirst();
		assertTrue(target instanceof ErrorType);
		assertEquals("AboveRange", target.getName());
		var targetURI = resource.getResourceSet().getURIConverter().normalize(EcoreUtil.getURI(target));
		for (var offset = nameOffset; offset < nameOffset + "AboveRange".length(); offset++) {
			var links = hyperlinksAt(offset);
			assertEquals(1, links.size());
			var link = (XtextHyperlink) links.getFirst();
			assertEquals(referenceOffset, link.getHyperlinkRegion().getOffset());
			assertEquals(ERROR_TYPE.length(), link.getHyperlinkRegion().getLength());
			assertEquals(targetURI, link.getURI());
		}
	}

	@Test
	public void annexKeywordsHaveNoHyperlink() {
		var keywordOffset = text.indexOf("error propagations");
		assertTrue(keywordOffset >= 0);
		assertTrue(hyperlinksAt(keywordOffset + 2).isEmpty());
		assertTrue(hyperlinksAt(keywordOffset + "error prop".length()).isEmpty());
	}

	@Test
	public void preservesAadlClassifierHyperlinks() {
		var referenceOffset = text.indexOf("child: system S") + "child: system ".length();
		assertEquals('S', text.charAt(referenceOffset));
		var links = hyperlinksAt(referenceOffset);
		assertEquals(1, links.size());
		var link = (XtextHyperlink) links.getFirst();
		assertEquals(referenceOffset, link.getHyperlinkRegion().getOffset());
		assertEquals(1, link.getHyperlinkRegion().getLength());
		assertSame(pkg.getOwnedPublicSection().getOwnedClassifiers().getFirst(),
				resource.getResourceSet().getEObject(link.getURI(), true));
	}

	private List<IHyperlink> hyperlinksAt(int offset) {
		var links = new ArrayList<IHyperlink>();
		// Use the public acceptor overload so that an exception fails the test instead of merely being logged.
		hyperlinkHelper.createHyperlinksByOffset(resource, offset, links::add);
		return links;
	}
}
