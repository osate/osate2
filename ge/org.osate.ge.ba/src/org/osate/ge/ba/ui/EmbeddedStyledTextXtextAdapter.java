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
package org.osate.ge.ba.ui;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ListBasedDiagnosticConsumer;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.osate.ge.ba.ui.properties.EditableEmbeddedTextValue;
import org.osate.ge.ba.util.BehaviorAnnexXtextUtil;
import org.osate.xtext.aadl2.ui.internal.Aadl2Activator;
import org.osate.xtext.aadl2.ui.propertyview.OsateStyledTextXtextAdapter;
import org.yakindu.base.xtext.utils.jface.viewers.context.IXtextFakeContextResourcesProvider;

import com.google.inject.Injector;

/**
 * Embeds AADL source specified by {@link EditableEmbeddedTextValue} with Xtext highlighting in a {@link StyledText}
 * @since 2.0
 */
class EmbeddedStyledTextXtextAdapter extends OsateStyledTextXtextAdapter {
	private final static Injector injector = Aadl2Activator.getInstance()
			.getInjector(Aadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2);
	private final EditableEmbeddedTextValue embeddedTextValue;
	private static final IXtextFakeContextResourcesProvider contextFakeResourceProvider = IXtextFakeContextResourcesProvider.NULL_CONTEXT_PROVIDER;

	/**
	 * Instantiates the Embedded Styled Text Xtext Adapter for embedding AADL source in a {@link StyledText}
	 * @param embeddedTextValue the text information for the embedded AADL source
	 */
	public EmbeddedStyledTextXtextAdapter(final EditableEmbeddedTextValue embeddedTextValue) {
		super(injector, contextFakeResourceProvider, embeddedTextValue.getProject());
		this.embeddedTextValue = embeddedTextValue;
	}

	@Override
	public void adapt(final StyledText styledText, final boolean decorate) {
		super.adapt(styledText, decorate);
		final XtextDocument xtextDoc = getXtextDocument();
		final SourceViewer srcViewer = getXtextSourceviewer();
		final String prefixWithNewLineEnding = embeddedTextValue.getPrefix() + "\n";
		final String suffixWithNewLineBeginning = "\n" + embeddedTextValue.getSuffix();
		final String editableText = embeddedTextValue.getEditableText();
		final String wholeText = new StringBuilder(prefixWithNewLineEnding).append(editableText)
				.append(suffixWithNewLineBeginning)
				.toString();
		xtextDoc.set(wholeText);
		srcViewer.setDocument(xtextDoc, srcViewer.getAnnotationModel(), prefixWithNewLineEnding.length(),
				editableText.length());
	}

	/**
	 * Returns the editable embedded text value
	 * @return the editable embedded text value
	 * @since 2.0
	 */
	public EditableEmbeddedTextValue getEmbeddedTextValue() {
		return embeddedTextValue;
	}

	@Override
	public void adapt(final StyledText styledText) {
		adapt(styledText, false);
	}

	/**
	 * Returns an optional of the modified full AADL source if edited region is a valid modification.  Empty if modification is invalid.
	 * @param newText the text to replace editable text region
	 * @return an optional of the modified full AADL source if edited region is a valid modification.  Empty if modification is invalid.
	 * @since 2.0
	 */
	public Optional<String> getValidModifiedSource(final String newText) {
		final String originalSrc = getOriginalSource();
		String modifiedSrc = null;
		try {
			// AADL source text to load
			modifiedSrc = embeddedTextValue.getModifiedAADLSourceForNewText(newText)
					.orElse(serialize(getXtextParseResult().getRootASTElement()));
			loadSource(modifiedSrc);

			final EObject tmpBo = getFakeResource()
					.getEObject(EcoreUtil.getURI(embeddedTextValue.getElementToModify()).fragment());
			if (tmpBo == null || !embeddedTextValue.isValidModification(tmpBo, newText)) {
				modifiedSrc = null;
			}
		} catch (final Exception ex) {
			modifiedSrc = null;
		} finally {
			// Load original source
			loadSource(originalSrc);
		}

		return Optional.ofNullable(modifiedSrc);
	}

	private String getOriginalSource() {
		// Update save button based on whether the text entered into the
		// styled text is a serializable condition
		final EObject rootElement = getXtextParseResult().getRootASTElement();
		final XtextResource resource = getFakeResource();
		// Link model
		resource.getLinker().linkModel(rootElement, new ListBasedDiagnosticConsumer());

		// Original source text
		return BehaviorAnnexXtextUtil.getText(null, resource);
	}

	private void loadSource(final String src) {
		try {
			getFakeResource().unload();
			getFakeResource().load(new ByteArrayInputStream(src.getBytes()), null);
		} catch (final IOException e) {
			throw new RuntimeException("Serialized source cannot be loaded");
		}
	}

	private XtextResource getFakeResource() {
		return getFakeResourceContext().getFakeResource();
	}

	private String serialize(final EObject rootElement) {
		return getFakeResource().getSerializer().serialize(rootElement);
	}
}
