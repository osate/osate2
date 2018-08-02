package org.osate.ui.navigator;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.DecoratingStyledCellLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlNavigatorSorter extends ViewerComparator {
	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		if (e1 instanceof VirtualPluginResources) {
			return 1;
		} else if (e2 instanceof VirtualPluginResources) {
			return -1;
		} else if (e1 instanceof ContributedAadlStorage && e2 instanceof ContributedDirectory) {
			return 1;
		} else if (e1 instanceof ContributedDirectory && e2 instanceof ContributedAadlStorage) {
			return -1;
		} else if (e1 instanceof IFile && e2 instanceof IContainer) {
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

		int result = super.compare(viewer, e1, e2);
		System.out.println(getLabel(viewer, e1) + " " + getLabel(viewer, e2) + " " + result);
		return result;
	}

	private String getLabel(Viewer viewer, Object e1) {
		String name1;
		if (viewer == null || !(viewer instanceof ContentViewer)) {
			name1 = e1.toString();
		} else {
			IBaseLabelProvider prov = ((ContentViewer) viewer).getLabelProvider();
			if (prov instanceof ILabelProvider) {
				ILabelProvider lprov = (ILabelProvider) prov;
				if (lprov instanceof DecoratingStyledCellLabelProvider) {
					System.out.print("***");
					DecoratingStyledCellLabelProvider dprov = (DecoratingStyledCellLabelProvider) lprov;
					IStyledLabelProvider sprov = dprov.getStyledStringProvider();
					name1 = sprov.getStyledText(e1).getString();
				} else if (lprov instanceof DecoratingLabelProvider) {
					// Bug 364735: use the real label provider to avoid unstable
					// sort behavior if the decoration is running while sorting.
					// decorations are usually visual aids to the user and
					// shouldn't be used in ordering.
					System.out.print(" * ");
					DecoratingLabelProvider dprov = (DecoratingLabelProvider) lprov;
					lprov = dprov.getLabelProvider();
				} else {
					System.out.print("   ");
				}
				name1 = lprov.getText(e1);
			} else {
				name1 = e1.toString();
			}
		}
		if (name1 == null) {
			name1 = "";//$NON-NLS-1$
		}
		return name1;
	}
}
