package org.osate.ui.navigator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;

public class AadlNavigatorSorter extends ViewerSorter {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof IFile && e2 instanceof IContainer) {
			return 1;
		} else if (e1 instanceof IContainer && e2 instanceof IFile) {
			return -1;
		} else if (e1 instanceof InstanceObject && e2 instanceof InstanceObject) {
			return 0;
		} else if (e1 instanceof NamedElement && e2 instanceof NamedElement) {
			NamedElement ne1 = (NamedElement) e1;
			NamedElement ne2 = (NamedElement) e2;
			ICompositeNode ne1Node = NodeModelUtils.getNode(ne1);
			ICompositeNode ne2Node = NodeModelUtils.getNode(ne2);
			if (null == ne1Node || null == ne2Node) {
				return 0;
			}
			int ne1Offset = ne1Node.getOffset();
			int ne2Offset = ne2Node.getOffset();
			return ne1Offset - ne2Offset;
		}

		return super.compare(viewer, e1, e2);
	}
}
