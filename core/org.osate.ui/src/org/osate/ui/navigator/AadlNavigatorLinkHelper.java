package org.osate.ui.navigator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.nodemodel.BidiIterable;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.impl.LeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.xtext.aadl2.ui.editor.ContributedAadlEditorInput;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

public class AadlNavigatorLinkHelper implements ILinkHelper {

	@Override
	public IStructuredSelection findSelection(IEditorInput anInput) {
		if (anInput instanceof ContributedAadlEditorInput) {
			try {
				return new StructuredSelection(((ContributedAadlEditorInput) anInput).getStorage());
			} catch (CoreException e) {
				return StructuredSelection.EMPTY;
			}
		} else {
			IFile file = ResourceUtil.getFile(anInput);
			if (file != null) {
				return new StructuredSelection(file);
			} else {
				return StructuredSelection.EMPTY;
			}
		}
	}

	@Override
	public void activateEditor(IWorkbenchPage page, IStructuredSelection structuredSelection) {
		if (structuredSelection == null || structuredSelection.isEmpty()) {
			return;
		}
		Object selected = structuredSelection.getFirstElement();
		if (selected instanceof IFile) {
			IEditorPart editor = page.findEditor(new FileEditorInput((IFile) selected));
			if (editor != null) {
				page.bringToTop(editor);
			}
		} else if (selected instanceof ContributedAadlStorage) {
			ContributedAadlStorage storage = (ContributedAadlStorage) selected;
			IEditorPart editor = page.findEditor(new ContributedAadlEditorInput(storage));
			if (editor != null) {
				page.bringToTop(editor);
			}
		} else if (shouldLink(selected)) {
			NamedElement ne = (NamedElement) selected;
			URI uri = ne.eResource().getURI();
			IEditorPart editor = null;
			if (uri.isPlatformResource()) {
				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IFile file = root.getFile(new Path(null, uri.toPlatformString(true)));
				editor = page.findEditor(new FileEditorInput(file));
			} else if (uri.isPlatformPlugin()) {
				ContributedAadlStorage storage = new ContributedAadlStorage(uri);
				editor = page.findEditor(new ContributedAadlEditorInput(storage));
			}
			if (editor != null) {
				int start = findOffset(ne);
				int length = ne.getName().length();
				TextSelection selection = new TextSelection(start, length);
				page.bringToTop(editor);
				editor.getEditorSite().getSelectionProvider().setSelection(selection);
			}
		}
	}

	protected boolean shouldLink(Object o) {
		return o instanceof AadlPackage || o instanceof Classifier || o instanceof Property
				|| o instanceof PropertyConstant || o instanceof PropertyType || o instanceof AnnexSubclause
				|| o instanceof AnnexLibrary;
	}

	private int findOffset(NamedElement classifier) {
		int retval = -1;
		String name = "";
		int offset = -1;
		ICompositeNode cNode = NodeModelUtils.getNode(classifier);
		List<LeafNode> nodes = resolveCompositeNodeToList(cNode);
		for (LeafNode leafNode : nodes) {
			if (leafNode.getGrammarElement() instanceof Keyword) {
				continue;
			}
			name += leafNode.getText();
			if (offset == -1) {
				offset = leafNode.getOffset();
			}
			if (name.equalsIgnoreCase(classifier.getName())) {
				return offset;
			}
			// component implementation name consists of 3 nodes: <typename> '.' <implname>
			name += ".";
		}
		return retval;
	}

	private List<LeafNode> resolveCompositeNodeToList(ICompositeNode cNode) {
		List<LeafNode> nodes = new ArrayList<LeafNode>();
		BidiIterable<INode> iterable = cNode.getChildren();
		Iterator<INode> iter = iterable.iterator();
		while (iter.hasNext()) {
			INode iterNode = iter.next();
			if (iterNode instanceof HiddenLeafNode) {
				continue;
			} else if (iterNode instanceof LeafNode) {
				nodes.add((LeafNode) iterNode);
			} else if (iterNode instanceof CompositeNode) {
				nodes.addAll(resolveCompositeNodeToList((CompositeNode) iterNode));
			}
		}
		return nodes;
	}

}
