package org.osate.ui.navigator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.ide.IDE;
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
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
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
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty())
			return;
		if (aSelection.getFirstElement() instanceof ContributedAadlStorage) {
			ContributedAadlStorage storage = (ContributedAadlStorage)aSelection.getFirstElement();
			IEditorPart editor = aPage.findEditor(new ContributedAadlEditorInput(storage));
			if (editor != null) {
				aPage.bringToTop(editor);
			}
		} else if (aSelection.getFirstElement() instanceof IFile) {
			IEditorInput fileInput = new FileEditorInput((IFile) aSelection.getFirstElement());
			IEditorPart editor = null;
			if ((editor = aPage.findEditor(fileInput)) != null)
				aPage.bringToTop(editor);
		} else if (aSelection.getFirstElement() instanceof Classifier) {
			Classifier classifier = (Classifier) aSelection.getFirstElement();
			int start = findOffsetForClassifierName(classifier);
			int length = classifier.getName().length();
			TextSelection selection = new TextSelection(start, length);
			IFile file = (IFile) OsateResourceUtil.convertToIResource(classifier.eResource());
			setSelection(aPage, file, selection);
		} else if (aSelection.getFirstElement() instanceof Property) {
			Property property = (Property) aSelection.getFirstElement();
			int start = findOffsetForPropertyName(property);
			int length = property.getName().length();
			TextSelection selection = new TextSelection(start, length);
			IFile file = (IFile) OsateResourceUtil.convertToIResource(property.eResource());
			setSelection(aPage, file, selection);
		} else if (aSelection.getFirstElement() instanceof PropertyConstant) {
			PropertyConstant propertyConstant = (PropertyConstant) aSelection.getFirstElement();
			int start = findOffsetForPropertyConstantName(propertyConstant);
			int length = propertyConstant.getName().length();
			TextSelection selection = new TextSelection(start, length);
			IFile file = (IFile) OsateResourceUtil.convertToIResource(propertyConstant.eResource());
			setSelection(aPage, file, selection);
		} else if (aSelection.getFirstElement() instanceof PropertyType) {
			PropertyType propertyType = (PropertyType) aSelection.getFirstElement();
			int start = findOffsetForPropertyTypeName(propertyType);
			int length = propertyType.getName().length();
			TextSelection selection = new TextSelection(start, length);
			IFile file = (IFile) OsateResourceUtil.convertToIResource(propertyType.eResource());
			setSelection(aPage, file, selection);
//		} else if (aSelection.getFirstElement() instanceof InstanceObject) {
//			InstanceObject instanceObject = (InstanceObject) aSelection.getFirstElement();
//			int start = findOffsetForPropertyTypeName(propertyType);
//			int length = propertyType.getName().length();
//			TextSelection selection = new TextSelection(start, length);
//			IFile file = (IFile) OsateResourceUtil.convertToIResource(propertyType.eResource());
//			setSelection(aPage, file, selection);
		}
	}

	private void setSelection(IWorkbenchPage page, IFile file, TextSelection textSelection) {
		IEditorPart editor;
		try {
			editor = IDE.openEditor(page, file, false);
			editor.getEditorSite().getSelectionProvider().setSelection(textSelection);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}

	private int findOffsetForClassifierName(Classifier classifier) {
		int retval = -1;
		ICompositeNode cNode = NodeModelUtils.getNode(classifier);
		List<LeafNode> nodes = resolveCompositeNodeToList(cNode);
		for (LeafNode leafNode : nodes) {
			if (leafNode.getGrammarElement() instanceof Keyword) {
				continue;
			}
			if (leafNode.getText().toLowerCase().equalsIgnoreCase(classifier.getName())) {
				return leafNode.getOffset();
			}
		}
		return retval;
	}

	private int findOffsetForPropertyName(Property property) {
		int retval = -1;
		ICompositeNode cNode = NodeModelUtils.getNode(property);
		List<LeafNode> nodes = resolveCompositeNodeToList(cNode);
		for (LeafNode leafNode : nodes) {
			if (leafNode.getText().toLowerCase().equalsIgnoreCase(property.getName())) {
				return leafNode.getOffset();
			}
		}
		return retval;
	}

	private int findOffsetForPropertyConstantName(PropertyConstant property) {
		int retval = -1;
		ICompositeNode cNode = NodeModelUtils.getNode(property);
		List<LeafNode> nodes = resolveCompositeNodeToList(cNode);
		for (LeafNode leafNode : nodes) {
			if (leafNode.getText().toLowerCase().equalsIgnoreCase(property.getName())) {
				return leafNode.getOffset();
			}
		}
		return retval;
	}

	private int findOffsetForPropertyTypeName(PropertyType property) {
		int retval = -1;
		ICompositeNode cNode = NodeModelUtils.getNode(property);
		List<LeafNode> nodes = resolveCompositeNodeToList(cNode);
		for (LeafNode leafNode : nodes) {
			if (leafNode.getText().toLowerCase().equalsIgnoreCase(property.getName())) {
				return leafNode.getOffset();
			}
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
