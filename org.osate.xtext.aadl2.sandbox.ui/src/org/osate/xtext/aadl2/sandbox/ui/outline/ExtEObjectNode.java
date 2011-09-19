package org.osate.xtext.aadl2.sandbox.ui.outline;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;

public class ExtEObjectNode extends EObjectNode {

	
	public ExtEObjectNode(EObject eObject, IOutlineNode parent, Image image, Object text, boolean isLeaf) {
		super(eObject,parent, image, text, isLeaf);
	}

}
