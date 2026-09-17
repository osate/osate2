/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.xtext.aadl2.ui.propertyview;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.ModalPath;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.ui.MyAadl2Activator;

class ValueColumnEditingSupport extends EditingSupport {
	private static final String EMBEDDED_RESOURCE_NAME_SUFFIX = "_embedded_for_property_view_cell_editor";

	private static final List<String> PREDECLARED_PROPERTY_SET_PREFIXES = List.of("communication_properties::",
			"deployment_properties::", "memory_properties::", "modeling_properties::", "programming_properties::",
			"thread_properties::", "timing_properties::");

	private final AadlPropertyView propertyView;

	private boolean creatingNewLocalInEdit = false;

	private boolean newContained = false;

	private String initialEditablePart;

	private int updateOffset;

	private int updateLength;

	private String updatePrefix;

	private String updateSuffix;

	ValueColumnEditingSupport(TreeViewer treeViewer, AadlPropertyView propertyView) {
		super(treeViewer);
		this.propertyView = propertyView;
	}

	@Override
	protected boolean canEdit(Object element) {
		if (propertyView.nextEditIsLocalCreation) {
			creatingNewLocalInEdit = true;
			newContained = false;
			propertyView.nextEditIsLocalCreation = false;
			return true;
		}
		if (propertyView.nextEditIsLocalContainedCreation) {
			creatingNewLocalInEdit = true;
			newContained = true;
			propertyView.nextEditIsLocalContainedCreation = false;
			return true;
		}
		creatingNewLocalInEdit = false;
		newContained = false;
		return propertyView.canEdit(element);
	}

	@Override
	protected CellEditor getCellEditor(Object element) {
		var cellEditor = new OsateStyledTextCellEditor(SWT.SINGLE,
				MyAadl2Activator.getInstance().getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2), getProject());
		cellEditor.create(propertyView.treeViewer.getTree());
		return cellEditor;
	}

	private IProject getProject() {
		if (propertyView.xtextDocument == null) {
			var curSelection = (NamedElement) propertyView.resourceFromSelection.getResourceSet()
					.getEObject(propertyView.getInput(), true);
			return OsateResourceUtil.toIFile(curSelection.eResource().getURI()).getProject();
		}
		return propertyView.xtextDocument
				.readOnly(resource -> OsateResourceUtil.toIFile(resource.getURI()).getProject());
	}

	@Override
	protected Object getValue(Object element) {
		return propertyView.safeReadResource(resource -> {
			/*
			 * The whole source text. The Xtend original read only the pieces it needed, through the document or the
			 * parse result, but those pieces were always a prefix and a suffix of this text.
			 */
			var text = propertyView.xtextDocument == null
					? ((XtextResource) resource).getParseResult().getRootNode().getText()
					: propertyView.xtextDocument.get();
			var modelUnit = resource.getContents().getFirst();
			var modelUnitNameEndOffset = NodeModelUtils
					.findNodesForFeature(modelUnit, Aadl2Package.eINSTANCE.getNamedElement_Name())
					.getFirst()
					.getEndOffset();
			var endNameEndOffset = getPreviousNode(getLastLeaf(NodeModelUtils.getNode(modelUnit))).getEndOffset();
			if (creatingNewLocalInEdit) {
				prepareNewAssociation(resource.getResourceSet(), (TreeEntry) element);
			} else {
				prepareExistingValue(resource, (TreeEntry) element);
			}
			return cellEditorValue(text, modelUnitNameEndOffset, endNameEndOffset);
		});
	}

	/**
	 * The text that the cell editor shows: the source text with the part that is being edited replaced by the initial
	 * editable part. The name of the model unit is renamed in both halves, so that the resource embedded in the cell
	 * editor does not collide with the resource being edited.
	 */
	private CellEditorPartialValue cellEditorValue(String text, int modelUnitNameEndOffset, int endNameEndOffset) {
		var editEndOffset = updateOffset + updateLength;
		return new CellEditorPartialValue(
				renameModelUnit(text.substring(0, updateOffset), modelUnitNameEndOffset) + updatePrefix,
				initialEditablePart,
				updateSuffix + renameModelUnit(text.substring(editEndOffset), endNameEndOffset - editEndOffset));
	}

	private static String renameModelUnit(String text, int nameEndOffset) {
		return new StringBuilder(text).insert(nameEndOffset, EMBEDDED_RESOURCE_NAME_SUFFIX).toString();
	}

	/**
	 * Prepares the edit of the value of an existing property association, record field, range bound or list element.
	 */
	private void prepareExistingValue(Resource resource, TreeEntry element) {
		var expression = getPropertyExpression(resource.getResourceSet(), element);
		var expressionNode = NodeModelUtils.getNode(expression);
		updateOffset = expressionNode.getOffset();
		updateLength = expressionNode.getLength();
		updatePrefix = "";
		updateSuffix = "";
		initialEditablePart = ValueColumnLabelProvider.serializeSingleLine(expression,
				((XtextResource) resource).getSerializer());
	}

	/**
	 * Prepares the insertion of a new local, possibly contained, property association: an empty editable part between
	 * the text that declares the association and the text that terminates it.
	 */
	private void prepareNewAssociation(ResourceSet resourceSet, TreeEntry element) {
		var propertyName = stripPredeclaredName(getProperty(element).getQualifiedName());
		var inputElement = (NamedElement) resourceSet.getEObject(propertyView.getInput(), true);
		/* A contained association is declared by the classifier that contains the element it applies to. */
		var offsetElement = inputElement instanceof AadlPackage || inputElement instanceof Classifier || !newContained
				? inputElement
				: inputElement.getContainingClassifier();
		var firstPropertyAssociation = offsetElement.getOwnedPropertyAssociations().isEmpty();
		initialEditablePart = "";
		updateOffset = firstPropertyAssociation ? firstPropertyAssociationOffset(offsetElement)
				: NodeModelUtils.getNode(offsetElement.getOwnedPropertyAssociations().getLast()).getEndOffset();
		updateLength = 0;
		var lineSeparator = System.lineSeparator();
		if (offsetElement instanceof AadlPackage) {
			if (firstPropertyAssociation) {
				updatePrefix = "properties" + lineSeparator + "\t" + propertyName + " => ";
				updateSuffix = ";" + lineSeparator;
			} else {
				updatePrefix = lineSeparator + "\t" + propertyName + " => ";
				updateSuffix = ";";
			}
		} else if (newContained) {
			if (firstPropertyAssociation) {
				updatePrefix = "\tproperties" + lineSeparator + "\t\t\t" + propertyName + " => ";
				updateSuffix = " applies to " + inputElement.getName() + ";" + lineSeparator + "\t";
			} else {
				updatePrefix = lineSeparator + "\t\t\t" + propertyName + " => ";
				updateSuffix = " applies to " + inputElement.getName() + ";";
			}
		} else if (offsetElement instanceof Classifier) {
			if (firstPropertyAssociation) {
				updatePrefix = "\tproperties" + lineSeparator + "\t\t\t" + propertyName + " => ";
				updateSuffix = ";" + lineSeparator + "\t";
			} else {
				updatePrefix = lineSeparator + "\t\t\t" + propertyName + " => ";
				updateSuffix = ";";
			}
		} else {
			/* A property association of an element that has none is written in a new curly brace block. */
			if (firstPropertyAssociation) {
				updatePrefix = " {" + lineSeparator + "\t\t\t\t" + propertyName + " => ";
				updateSuffix = ";" + lineSeparator + "\t\t\t}";
			} else {
				updatePrefix = lineSeparator + "\t\t\t\t" + propertyName + " => ";
				updateSuffix = ";";
			}
		}
	}

	/**
	 * The offset at which the first property association of the element is inserted: in front of the text that follows
	 * the place where the properties section belongs.
	 */
	private static int firstPropertyAssociationOffset(NamedElement offsetElement) {
		return switch (offsetElement) {
		case AadlPackage aadlPackage -> beforeEndKeywordOffset(offsetElement);
		case FeatureGroupType featureGroupType -> beforeEndKeywordOffset(offsetElement);
		case ComponentClassifier classifier when classifier.getOwnedAnnexSubclauses().isEmpty() ->
			beforeEndKeywordOffset(offsetElement);
		case ComponentClassifier componentClassifier ->
			NodeModelUtils.getNode(componentClassifier.getOwnedAnnexSubclauses().getFirst()).getOffset();
		case Subcomponent subcomponent when !subcomponent.getOwnedModeBindings().isEmpty() ->
			getPreviousNode(getPreviousNode(
					getPreviousNode(NodeModelUtils.getNode(subcomponent.getOwnedModeBindings().getFirst()))))
					.getOffset();
		case ModalPath modalPath when !modalPath.getInModeOrTransitions().isEmpty() ->
			getPreviousNode(getPreviousNode(getPreviousNode(NodeModelUtils
					.findNodesForFeature(modalPath, Aadl2Package.eINSTANCE.getModalPath_InModeOrTransition())
					.getFirst()))).getOffset();
		case SubprogramCallSequence callSequence when !callSequence.getInModes().isEmpty() ->
			getPreviousNode(getPreviousNode(getPreviousNode(
					NodeModelUtils.findNodesForFeature(callSequence, Aadl2Package.eINSTANCE.getModalElement_InMode())
							.getFirst())))
					.getOffset();
		default -> getLastLeaf(NodeModelUtils.getNode(offsetElement)).getOffset();
		};
	}

	/** The offset in front of the "end" keyword and the name that follows it. */
	private static int beforeEndKeywordOffset(NamedElement element) {
		return getPreviousNode(getPreviousNode(getLastLeaf(NodeModelUtils.getNode(element)))).getOffset();
	}

	private PropertyExpression getPropertyExpression(ResourceSet resourceSet, TreeEntry element) {
		return switch (element.getTreeElement()) {
		case URI treeElement -> switch (resourceSet.getEObject(treeElement, true)) {
		case Property property -> {
			var propertySetEntry = (TreeEntry) element.getParent();
			var associationURI = propertyView.cachedPropertyAssociations.get(propertySetEntry.getTreeElement())
					.get(treeElement);
			var association = (PropertyAssociation) resourceSet.getEObject(associationURI, true);
			yield association.getOwnedValues().getFirst().getOwnedValue();
		}
		case BasicPropertyAssociation fieldValue -> fieldValue.getValue();
		case null, default -> null;
		};
		case RangeElement rangeElement ->
			(PropertyExpression) resourceSet.getEObject(rangeElement.getExpressionURI(), true);
		case ListElement listElement ->
			(PropertyExpression) resourceSet.getEObject(listElement.getExpressionURI(), true);
		case null, default -> null;
		};
	}

	private static String stripPredeclaredName(String qualifiedName) {
		var toStrip = PREDECLARED_PROPERTY_SET_PREFIXES.stream()
				.filter(prefix -> qualifiedName.toLowerCase().startsWith(prefix))
				.findFirst()
				.orElse("");
		return qualifiedName.substring(toStrip.length());
	}

	@Override
	protected void setValue(Object element, Object value) {
		var newValue = (String) value;
		if (creatingNewLocalInEdit || !newValue.isEmpty() && !newValue.equals(initialEditablePart)) {
			// insert new property value
			propertyView.modify(new IUnitOfWork.Void<XtextResource>() {
				@Override
				public void process(XtextResource state) throws Exception {
					state.update(updateOffset, updateLength, updatePrefix + newValue + updateSuffix);
				}
			});

			propertyView.runCachePropertyLookupJob(propertyView.getInput(), null);
			propertyView.treeViewer.refresh(getPropertyParent((TreeEntry) element));

			// select inserted/modified text in editor
			var activeEditor = propertyView.getSite().getWorkbenchWindow().getActivePage().getActiveEditor();
			if (activeEditor instanceof ITextEditor textEditor) {
				textEditor.selectAndReveal(updateOffset,
						updatePrefix.length() + newValue.length() + updateSuffix.length());
			}
		}
	}

	private static INode getLastLeaf(ICompositeNode node) {
		INode result = node;
		while (result instanceof ICompositeNode composite) {
			result = composite.getLastChild();
		}
		return result != null ? result : node;
	}

	private static INode getPreviousNode(INode node) {
		var previous = node.getPreviousSibling();
		while (previous instanceof HiddenLeafNode) {
			previous = previous.getPreviousSibling();
		}
		return previous;
	}

	private TreeEntry getPropertyParent(TreeEntry element) {
		if (element.getTreeElement() instanceof URI treeElement && propertyView
				.safeRead(resourceSet -> resourceSet.getEObject(treeElement, true) instanceof Property)) {
			return element;
		}
		return getPropertyParent((TreeEntry) element.getParent());
	}

	/**
	 * The property definition that a new local property association is created for. The entry is always the entry of a
	 * property, because that is the only entry the create actions are enabled on.
	 */
	private Property getProperty(TreeEntry element) {
		var propertyURI = (URI) element.getTreeElement();
		return propertyView.safeRead(resourceSet -> (Property) resourceSet.getEObject(propertyURI, true));
	}
}
