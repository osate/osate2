package org.osate.xtext.aadl2.errormodel.ui.contentassist.antlr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.ui.editor.contentassist.antlr.EntryPointFinder;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;

public class AnnexAwareEntryPointFinder extends EntryPointFinder {

	@Override
	public ICompositeNode findEntryPoint(IParseResult parseResult, int offset) {
		ICompositeNode rootNode = parseResult.getRootNode();
		EObject semanticObject = rootNode.getSemanticElement();

		if (semanticObject instanceof AnnexSubclause || semanticObject instanceof AnnexLibrary) {
			return rootNode;
		}
		return super.findEntryPoint(parseResult, offset);
	}

}
