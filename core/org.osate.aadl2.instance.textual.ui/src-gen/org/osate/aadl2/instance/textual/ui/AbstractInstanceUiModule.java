
/*
<copyright>
Copyright  2016 by Carnegie Mellon University, all rights reserved.

Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
at http://www.eclipse.org/org/documents/epl-v10.html.

NO WARRANTY

ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE ''DELIVERABLES'') ARE ON AN ''AS-IS'' BASIS.
CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.

Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
employees, and agents from all claims or demands made against them (and any related losses, expenses, or
attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
product liability, personal injury, death, damage to property, or violation of any laws or regulations.

Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
under the contract clause at 252.227.7013.
</copyright>
 */
package org.osate.aadl2.instance.textual.ui;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Manual modifications go to {org.osate.aadl2.instance.textual.ui.InstanceUiModule}
 */
@SuppressWarnings("all")
public abstract class AbstractInstanceUiModule extends org.eclipse.xtext.ui.DefaultUiModule {
	
	public AbstractInstanceUiModule(AbstractUIPlugin plugin) {
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
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.HIGHLIGHTING)).to(org.osate.aadl2.instance.textual.parser.antlr.internal.InternalInstanceLexer.class);
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

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public Class<? extends org.eclipse.jface.viewers.ILabelProvider> bindILabelProvider() {
		return org.osate.aadl2.instance.textual.ui.labeling.InstanceLabelProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.labeling.LabelProviderFragment
	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class).annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class).to(org.osate.aadl2.instance.textual.ui.labeling.InstanceDescriptionLabelProvider.class);
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.IOutlineTreeProvider> bindIOutlineTreeProvider() {
		return org.osate.aadl2.instance.textual.ui.outline.InstanceOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.outline.OutlineTreeProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.outline.impl.IOutlineTreeStructureProvider> bindIOutlineTreeStructureProvider() {
		return org.osate.aadl2.instance.textual.ui.outline.InstanceOutlineTreeProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.quickfix.QuickfixProviderFragment
	public Class<? extends org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider> bindIssueResolutionProvider() {
		return org.osate.aadl2.instance.textual.ui.quickfix.InstanceQuickfixProvider.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.contentAssist.ContentAssistFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider> bindIContentProposalProvider() {
		return org.osate.aadl2.instance.textual.ui.contentassist.InstanceProposalProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory> bindContentAssistContext$Factory() {
		return org.eclipse.xtext.ui.editor.contentassist.antlr.ParserBasedContentAssistContextFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public Class<? extends org.eclipse.xtext.ui.editor.contentassist.antlr.IContentAssistParser> bindIContentAssistParser() {
		return org.osate.aadl2.instance.textual.ui.contentassist.antlr.InstanceParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexerProvider(com.google.inject.Binder binder) {
		binder.bind(org.osate.aadl2.instance.textual.ui.contentassist.antlr.internal.InternalInstanceLexer.class).toProvider(org.eclipse.xtext.parser.antlr.LexerProvider.create(org.osate.aadl2.instance.textual.ui.contentassist.antlr.internal.InternalInstanceLexer.class));
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrUiGeneratorFragment
	public void configureContentAssistLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.LexerUIBindings.CONTENT_ASSIST)).to(org.osate.aadl2.instance.textual.ui.contentassist.antlr.internal.InternalInstanceLexer.class);
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
		return org.osate.aadl2.instance.textual.ui.contentassist.antlr.PartialInstanceContentAssistParser.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public Class<? extends org.eclipse.compare.IViewerCreator> bindIViewerCreator() {
		return org.eclipse.xtext.ui.compare.DefaultViewerCreator.class;
	}

	// contributed by org.eclipse.xtext.ui.generator.compare.CompareFragment
	public void configureCompareViewerTitle(com.google.inject.Binder binder) {
		binder.bind(String.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.ui.UIBindings.COMPARE_VIEWER_TITLE)).toInstance("Instance Compare");
	}


}
