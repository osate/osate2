/*
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE
 */
package org.osate.xtext.aadl2.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.osate.xtext.aadl2.ui.outline.Aadl2OutlinePage;

/**
 * Use this class to register components to be used within the IDE.
 */
public class Aadl2UiModule extends org.osate.xtext.aadl2.ui.AbstractAadl2UiModule {
	public Aadl2UiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
	return Aadl2OutlinePage.class;
	}
	// will need to add the same class to aadl2 and have it be an extension of the properties one.
	public Class<? extends org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return org.osate.xtext.aadl2.properties.ui.linking.PropertiesLinkingDiagnosticMessageProvider.class;
	}


	public Class<? extends org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		return org.osate.xtext.aadl2.ui.syntax.Aadl2SyntaxErrorMessageProvider.class;
	}

	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return org.osate.xtext.aadl2.ui.highlighting.Aadl2SemanticHighlightingCalculator.class;
	}

}
