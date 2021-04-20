/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.ba.ui.properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

public class EmbeddedXtextAdapter extends OsateStyledTextXtextAdapter {
	private final static Injector injector = Aadl2Activator.getInstance()
			.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
	private final EmbeddedTextValue textValue;
	private static final IXtextFakeContextResourcesProvider contextFakeResourceProvider = IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER;

	public EmbeddedXtextAdapter(final IProject project, final EmbeddedTextValue textValue) {
		super(injector, contextFakeResourceProvider, project);
		this.textValue = textValue;
	}

	private SourceViewer getSourceviewer() {
		return super.getXtextSourceviewer();
	}

	@Override
	public XtextDocument getXtextDocument() {
		return super.getXtextDocument();
	}

	public String getText() {
		return BehaviorAnnexXtextUtil.getText(null, getFakeResource());
	}

	public XtextResource getFakeResource() {
		return getFakeResourceContext().getFakeResource();
	}

	public String serialize(final EObject rootElement) {
		return getFakeResource().getSerializer().serialize(rootElement);
	}

	@Override
	public void adapt(final StyledText styledText, final boolean decorate) {
		super.adapt(styledText, decorate);
		final XtextDocument xtextDoc = getXtextDocument();
		final SourceViewer srcViewer = getSourceviewer();
		xtextDoc.set(textValue.getWholeText());
		srcViewer.setDocument(xtextDoc, srcViewer.getAnnotationModel(), textValue.getEditableTextOffset(),
				textValue.getEditableText().length());
	}

	@Override
	public void adapt(final StyledText styledText) {
		adapt(styledText, true);
	}

	public String getEditableText() {
		return textValue.getEditableText();
	}
}
