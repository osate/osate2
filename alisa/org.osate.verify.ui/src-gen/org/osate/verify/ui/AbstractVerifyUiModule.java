
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
package org.osate.verify.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Manual modifications go to {org.osate.verify.ui.VerifyUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractVerifyUiModule extends org.eclipse.xtext.ui.DefaultUiModule {
	
	public AbstractVerifyUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}
	
	
	// contributed by org.eclipse.xtext.ui.generator.ImplicitUiFragment
	public com.google.inject.Provider<org.eclipse.xtext.resource.containers.IAllContainersState> provideIAllContainersState() {
		return org.eclipse.xtext.ui.shared.Access.getJavaProjectsState();
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper> bindIProposalConflictHelper() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.AntlrProposalConflictHelper.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.osate.verify.parser.antlr.internal.InternalVerifyLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureHighlightingTokenDefProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.ITokenDefProvider.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher> bindPrefixMatcher() {
		return org.eclipse.xtext.ui.editor.contentassist.FQNPrefixMatcher.class;
	}

	// contributed by org.eclipse.xtext.generator.exporting.QualifiedNamesFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.ui.editor.IXtextEditorCallback> bindIXtextEditorCallback() {
		return org.eclipse.xtext.builder.nature.NatureAddingEditorCallback.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.generator.IContextualOutputConfigurationProvider> bindIContextualOutputConfigurationProvider() {
		return org.eclipse.xtext.builder.EclipseOutputConfigurationProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsPersisted(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)).to(org.eclipse.xtext.builder.builderState.IBuilderState.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource> bindDocumentBasedDirtyResource() {
		return org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.class;
	}

	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public Class<? extends org.eclipse.xtext.builder.IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return org.eclipse.xtext.builder.BuilderParticipant.class;
	}

	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public org.eclipse.core.resources.IWorkspaceRoot bindIWorkspaceRootToInstance() {
		return org.eclipse.core.resources.ResourcesPlugin.getWorkspace().getRoot();
	}

	// contributed by org.eclipse.xtext.generator.generator.GeneratorFragment
	public void configureBuilderPreferenceStoreInitializer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class).annotatedWith(com.google.inject.name.Names.named("builderPreferenceInitializer")).to(org.eclipse.xtext.builder.preferences.BuilderPreferenceAccess.Initializer.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return org.osate.verify.ui.labeling.VerifyLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(org.osate.verify.ui.labeling.VerifyDescriptionLabelProvider.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return org.osate.verify.ui.outline.VerifyOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return org.osate.verify.ui.outline.VerifyOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return org.osate.verify.ui.quickfix.VerifyQuickfixProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.ContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return org.osate.verify.ui.contentassist.VerifyProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
		return org.osate.verify.ui.contentassist.antlr.VerifyParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyLexer.class));
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(org.osate.verify.ui.contentassist.antlr.internal.InternalVerifyLexer.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameStrategy> bindIRenameStrategy() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultRenameStrategy.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IReferenceUpdater> bindIReferenceUpdater() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultReferenceUpdater.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public void configureIPreferenceStoreInitializer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer.class).annotatedWith(com.google.inject.name.Names.named("RefactoringPreferences")).to(org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences.Initializer.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.IRenameRefactoringProvider> bindIRenameRefactoringProvider() {
		return org.eclipse.xtext.ui.refactoring.impl.DefaultRenameRefactoringProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.refactoring.RefactorElementNameFragment
	public Class<? extends org.eclipse.xtext.ui.refactoring.ui.IRenameSupport.Factory> bindIRenameSupport$Factory() {
		return org.eclipse.xtext.ui.refactoring.ui.DefaultRenameSupport.Factory.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public com.google.inject.Provider<org.eclipse.xtext.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration> provideTemplatesLanguageConfiguration() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getTemplatesLanguageConfigurationProvider();
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public com.google.inject.Provider<org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistry> provideLanguageRegistry() {
		return org.eclipse.xtext.ui.codetemplates.ui.AccessibleCodetemplatesActivator.getLanguageRegistry();
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar> bindLanguageRegistrar() {
		return org.eclipse.xtext.ui.codetemplates.ui.registry.LanguageRegistrar.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.templates.XtextTemplatePreferencePage> bindXtextTemplatePreferencePage() {
		return org.eclipse.xtext.ui.codetemplates.ui.preferences.AdvancedTemplatesPreferencePage.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.templates.CodetemplatesGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.codetemplates.ui.partialEditing.IPartialContentAssistParser> bindIPartialContentAssistParser() {
		return org.osate.verify.ui.contentassist.antlr.PartialVerifyContentAssistParser.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public Class<? extends org.eclipse.compare.IViewerCreator> bindIViewerCreator() {
		return org.eclipse.xtext.ui.compare.DefaultViewerCreator.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public void configureCompareViewerTitle(com.google.inject.Binder binder) {
		binder.bind(String.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.UIBindings.COMPARE_VIEWER_TITLE)).toInstance("Verify Compare");
	}


}
