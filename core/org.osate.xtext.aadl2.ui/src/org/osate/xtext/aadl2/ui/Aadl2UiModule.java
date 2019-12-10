/*
 * /**
 * <copyright>
 * Copyright  2012 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
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

	@SuppressWarnings("restriction")
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
}
