/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ui;

import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.ui.LanguageSpecific;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;
import org.eclipse.xtext.ui.editor.model.edit.ITextEditComposer;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.shared.Access;
import org.osate.xtext.aadl2.ui.containers.Aadl2ProjectsState;
import org.osate.xtext.aadl2.ui.containers.Aadl2ProjectsStateHelper;
import org.osate.xtext.aadl2.ui.contentassist.AnnexAwareContentAssistProcessor;
import org.osate.xtext.aadl2.ui.editor.Aadl2LanguageSpecificURIEditorOpener;
import org.osate.xtext.aadl2.ui.editor.Aadl2WorkspaceEncodingProvider;
import org.osate.xtext.aadl2.ui.editor.hover.Aadl2EObjectHoverProvider;
import org.osate.xtext.aadl2.ui.editor.model.Aadl2DocumentProvider;
import org.osate.xtext.aadl2.ui.editor.model.Aadl2ResourceForEditorInputFactory;
import org.osate.xtext.aadl2.ui.editor.model.edit.FormattingTextEditComposer;
import org.osate.xtext.aadl2.ui.editor.occurrences.Aadl2OccurrenceComputer;
import org.osate.xtext.aadl2.ui.outline.Aadl2OutlinePage;
import org.osate.xtext.aadl2.ui.refactoring.Aadl2DependentElementsCalculator;
import org.osate.xtext.aadl2.ui.refactoring.impl.Aadl2RenameStrategy;
import org.osate.xtext.aadl2.ui.resource.Aadl2Storage2UriMapper;

import com.google.inject.Binder;

/**
 * Use this class to register components to be used within the IDE.
 */
@SuppressWarnings("restriction")
public class Aadl2UiModule extends org.osate.xtext.aadl2.ui.AbstractAadl2UiModule {
	public Aadl2UiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return Aadl2OutlinePage.class;
	}

	public Class<? extends org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider> bindISyntaxErrorMessageProvider() {
		return org.osate.xtext.aadl2.ui.syntax.Aadl2SyntaxErrorMessageProvider.class;
	}

	public Class<? extends org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator> bindSemanticHighlightingCalculator() {
		return org.osate.xtext.aadl2.ui.highlighting.Aadl2SemanticHighlightingCalculator.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return org.osate.xtext.aadl2.ui.editor.autoedit.Aadl2AutoEditStrategyProvider.class;
	}

	public Class<? extends org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer> bindIOccurrenceComputer() {
		return Aadl2OccurrenceComputer.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameStrategy> bindIRenameStrategy() {
		return Aadl2RenameStrategy.class;
	}

	public Class<? extends org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkHelper> bindHyperlinkHelper() {
		return org.osate.xtext.aadl2.util.Aadl2HyperlinkHelper.class;
	}

	public Class<? extends org.eclipse.xtext.ui.editor.doubleClicking.AbstractWordAwareDoubleClickStrategy> bindLexerTokenAndCharacterPairAwareStrategy() {
		return org.osate.xtext.aadl2.parsing.Aadl2TokenStrategy.class;
	}

	public Class<? extends org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return org.osate.xtext.aadl2.parsing.Aadl2DoubleClickStrategyProvider.class;
	}

	@Override
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return Access.<IAllContainersState> provider(Aadl2ProjectsState.class);
	}

	public Class<? extends Aadl2ProjectsStateHelper> bindWorkspaceProjectsStateHelper() {
		return Aadl2ProjectsStateHelper.class;
	}

	@Override
	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return AnnexAwareContentAssistProcessor.class;
	}

	public Class<? extends IStorage2UriMapper> bindIStorage2UriMapper() {
		return Aadl2Storage2UriMapper.class;
	}

	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return Aadl2ResourceForEditorInputFactory.class;
	}

	@Override
	public void configureLanguageSpecificURIEditorOpener(Binder binder) {
		if (PlatformUI.isWorkbenchRunning()) {
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class).to(Aadl2LanguageSpecificURIEditorOpener.class);
		}
	}

	public Class<? extends XtextDocumentProvider> bindXtextDocumentProvider() {
		return Aadl2DocumentProvider.class;
	}

	public Class<? extends ITextEditComposer> bindITextEditComposer() {
		return FormattingTextEditComposer.class;
	}

	public Class<? extends IEncodingProvider> bindIEncodingProvider() {
		return Aadl2WorkspaceEncodingProvider.class;
	}

	public Class<? extends AbstractFileSystemAccess2> bindAbstractFileSystemAccess2() {
		return EclipseResourceFileSystemAccess2.class;
	}

	@Override
	public Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return Aadl2DependentElementsCalculator.class;
	}

	/**
	 * @since 3.0
	 */
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return Aadl2EObjectHoverProvider.class;
	}

}
