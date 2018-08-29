package org.osate.xtext.aadl2.formatting2.regionaccess;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.NodeModelBasedRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.TextRegionAccessBuildingSequencer;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;

/**
 * Created to allow formatting for keyword only parser rules:
 * https://www.eclipse.org/forums/index.php/t/1088231/
 */
@SuppressWarnings("restriction")
public class Aadl2TextRegionAccessBuilder extends TextRegionAccessBuilder {
	private TextRegionAccessBuildingSequencer fromSequencer;
	private NodeModelBasedRegionAccessBuilder fromNodeModel;
	
	@Override
	public TextRegionAccessBuilder forNodeModel(XtextResource resource) {
		fromNodeModel = new NodeModelBasedRegionAccessBuilder() {
			@Override
			protected boolean include(INode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					AbstractRule rule = ((RuleCall) node.getGrammarElement()).getRule();
					if (GrammarUtil.isDatatypeRule(rule) && rule.getAlternatives() instanceof Group
							&& ((Group) rule.getAlternatives()).getElements().stream()
									.allMatch(element -> element instanceof Keyword)) {
						return false;
					}
				}
				return super.include(node);
			}
		}.withResource(resource);
		return this;
	}
	
	@Override
	public ISequenceAcceptor forSequence(ISerializationContext ctx, EObject root) {
		return this.fromSequencer = new TextRegionAccessBuildingSequencer().withRoot(ctx, root);
	}
	
	@Override
	public ITextRegionAccess create() {
		if (fromNodeModel != null)
			return fromNodeModel.create();
		if (fromSequencer != null)
			return fromSequencer.getRegionAccess();
		throw new IllegalStateException();
	}
}