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
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.CancelIndicator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.testsupport.TestHelper;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Annex source text is colored only by {@code Aadl2SemanticHighlightingCalculator}, because the AADL lexer reduces a
 * whole {@code {** **}} block to a single {@code ANNEXTEXT} token. That calculator has to be bound in the injector the
 * Eclipse editor actually builds, which is {@code Aadl2RuntimeModule + SharedStateModule + Aadl2UiModule};
 * {@code Aadl2IdeModule} is reachable only from the language server. Without the binding, Guice silently resolves
 * {@code @ImplementedBy(DefaultSemanticHighlightingCalculator)}, which ignores annex text.
 *
 * <p>
 * No annex language contributes an {@code org.osate.annexsupport.highlighter}, so the Behavior Annex is colored by the
 * calculator's generic fallback over the annex parse tree, exactly like EMV2.
 */
@RunWith(XtextRunner.class)
@InjectWith(BehaviorAnnexEmbeddedInjectorProvider.class)
public class Issue3162Test {
	private static final String MODEL = "org.osate.xtext.aadl2.ba.tests/models/issue3162/Issue3162.aadl";

	@Inject
	private TestHelper<AadlPackage> testHelper;

	@Test
	public void aadlEditorInjectorBindsTheAnnexAwareCalculator() throws Exception {
		assertEquals("org.osate.xtext.aadl2.ide.highlighting.Aadl2SemanticHighlightingCalculator",
				aadlEditorInjector().getInstance(ISemanticHighlightingCalculator.class).getClass().getName());
	}

	@Test
	public void behaviorAnnexTextIsColored() throws Exception {
		var resource = (XtextResource) testHelper.testFile(MODEL).getResource();
		var text = resource.getParseResult().getRootNode().getText();
		int annexStart = text.indexOf("{**");
		int annexEnd = text.indexOf("**}");
		assertTrue("The fixture must embed a behavior_specification annex", annexStart > 0 && annexEnd > annexStart);

		var colored = new ArrayList<int[]>();
		var styles = new ArrayList<String>();
		IHighlightedPositionAcceptor acceptor = (offset, length, ids) -> {
			colored.add(new int[] { offset, length });
			styles.add(String.join(",", ids));
		};
		aadlEditorInjector().getInstance(ISemanticHighlightingCalculator.class)
				.provideHighlightingFor(resource, acceptor, CancelIndicator.NullImpl);

		for (int[] position : colored) {
			assertTrue("Coloring must stay inside the annex block, got offset " + position[0],
					position[0] > annexStart && position[0] + position[1] <= annexEnd);
		}

		var keywords = new ArrayList<String>();
		var comments = new ArrayList<String>();
		for (int i = 0; i < colored.size(); i++) {
			var lexeme = text.substring(colored.get(i)[0], colored.get(i)[0] + colored.get(i)[1]);
			if (HighlightingStyles.KEYWORD_ID.equals(styles.get(i))) {
				keywords.add(lexeme);
			} else if (HighlightingStyles.COMMENT_ID.equals(styles.get(i))) {
				comments.add(lexeme.strip());
			}
		}

		assertEquals(List.of("variables", ":", "::", ";", "states", ":", "initial", "state", ";", ":", "final", "state",
				";", "transitions", ":", "-[", "]->", "{", ":=", "}", ";"), keywords);
		assertEquals(List.of("-- A comment inside the annex."), comments);
		assertEquals("Every colored position must be a keyword or a comment", keywords.size() + comments.size(),
				colored.size());
	}

	private Injector aadlEditorInjector() throws Exception {
		Bundle bundle = FrameworkUtil.getBundle(Aadl2Activator.class);
		if (bundle.getState() != Bundle.ACTIVE) {
			bundle.start();
		}
		return Aadl2Activator.getInstance().getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
	}
}
