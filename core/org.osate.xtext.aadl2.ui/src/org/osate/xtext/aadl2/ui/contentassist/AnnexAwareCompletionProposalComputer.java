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
package org.osate.xtext.aadl2.ui.contentassist;

import java.util.Collection;
import java.util.LinkedHashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.codetemplates.ui.contentassist.DummyTextViewer;
import org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext.Factory;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.annexsupport.AnnexParseUtil;
import org.osate.annexsupport.AnnexUtil;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.MembersInjector;

@SuppressWarnings("restriction")
public class AnnexAwareCompletionProposalComputer extends CompletionProposalComputer {

	private final int offset;
	private ITextViewer viewer;
	private AnnexState state;

	private final Collection<ICompletionProposal> proposals;

	static class AnnexState implements State {

		private State delegate;

		@Inject
		private ContentAssistContext.Factory contextFactory;

		@Inject(optional = true)
		private ITemplateProposalProvider templateProposalProvider;

		@Inject(optional = true)
		private IContentProposalProvider contentProposalProvider;

		AnnexState(State delegate) {
			this.delegate = delegate;
		}

		@Override
		public ITemplateProposalProvider getTemplateProposalProvider() {
			return (templateProposalProvider != null) ? templateProposalProvider
					: delegate.getTemplateProposalProvider();
		}

		@Override
		public IContentProposalProvider getContentProposalProvider() {
			return (contentProposalProvider != null) ? contentProposalProvider : delegate.getContentProposalProvider();
		}

		@Override
		public Factory getContextFactory() {
			return (contextFactory != null) ? contextFactory : delegate.getContextFactory();
		}

		@Override
		public ICompletionProposalAcceptor decorateAcceptor(ICompletionProposalAcceptor acceptor) {
			return delegate.decorateAcceptor(acceptor);
		}

		@Override
		public ITemplateAcceptor decorateAcceptor(ITemplateAcceptor acceptor) {
			return delegate.decorateAcceptor(acceptor);
		}
	}

	public AnnexAwareCompletionProposalComputer(State state, ITextViewer viewer, int offset) {
		super(state, viewer, offset);
		proposals = new LinkedHashSet<ICompletionProposal>(30);
		this.offset = offset;
		this.viewer = viewer;
		this.state = new AnnexState(state);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer#exec(org.eclipse.xtext.resource.XtextResource)
	 */
	@Override
	public ICompletionProposal[] exec(XtextResource resource) throws Exception {
		INode node = NodeModelUtils.findLeafNodeAtOffset(resource.getParseResult().getRootNode(), offset);
		IParseResult originalResult = resource.getParseResult();

		try {
			if (node != null) {
				EObject semanticObject = NodeModelUtils.findActualSemanticObjectFor(node);

				if (semanticObject != null) {
					EObject annexObject = null;

					if (semanticObject instanceof DefaultAnnexSubclause) {
						annexObject = ((DefaultAnnexSubclause) semanticObject).getParsedAnnexSubclause();
					} else if (semanticObject instanceof DefaultAnnexLibrary) {
						annexObject = ((DefaultAnnexLibrary) semanticObject).getParsedAnnexLibrary();
					}

					if (annexObject != null && offset >= NodeModelUtils.findActualNodeFor(semanticObject).getOffset()) {
						IParseResult annexParseResult = AnnexParseUtil.getParseResult(annexObject);

						if (annexParseResult != null) {
							Injector injector = AnnexUtil.getInjector(annexParseResult);
							if (injector != null) {
								MembersInjector<AnnexState> memInject = injector.getMembersInjector(AnnexState.class);
	
								memInject.injectMembers(state);
								resource.setParseResult(annexParseResult);
	
								ISelection selection = viewer.getSelectionProvider().getSelection();
								String content = AnnexParseUtil.genWhitespace(node.getTotalOffset())
										+ AnnexUtil.getSourceText(annexObject).replaceFirst("\\{\\*\\*", "   ");
								IDocument document = new DummyXtextDocument(content);
								viewer = new DummyTextViewer(selection, document);
							}
						}
					}
					execOriginal(resource);
				}
			}
		} finally {
			resource.setParseResult(originalResult);
		}
		return proposals.toArray(new ICompletionProposal[proposals.size()]);
	}

	public void execOriginal(XtextResource resource) throws Exception {
		ICompletionProposalAcceptor proposalAcceptor = state.decorateAcceptor((ICompletionProposalAcceptor) this);
		ContentAssistContext[] contexts = createContentAssistContexts(resource);
		for (ContentAssistContext context : contexts) {
			if (proposalAcceptor.canAcceptMoreProposals()) {
				state.getContentProposalProvider().createProposals(context, proposalAcceptor);
			}
		}
		ITemplateAcceptor templateAcceptor = state.decorateAcceptor((ITemplateAcceptor) this);
		for (ContentAssistContext context : contexts) {
			if (templateAcceptor.canAcceptMoreTemplates() && context.getReplaceRegion().getOffset() >= 0) {
				state.getTemplateProposalProvider().createTemplates(context, templateAcceptor);
			}
		}
	}

	@Override
	protected ContentAssistContext[] createContentAssistContexts(XtextResource resource) {
		return state.getContextFactory().create(viewer, offset, resource);
	}

	@Override
	public void accept(ICompletionProposal proposal) {
		if (proposal == null) {
			throw new NullPointerException("proposal may not be null");
		}
		proposals.add(proposal);
	}

	@Override
	public void accept(TemplateProposal template) {
		if (template == null) {
			throw new NullPointerException("template may not be null");
		}
		proposals.add(template);
	}

}
