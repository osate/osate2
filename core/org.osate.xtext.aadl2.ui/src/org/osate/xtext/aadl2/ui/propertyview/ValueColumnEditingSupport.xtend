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
package org.osate.xtext.aadl2.ui.propertyview

import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jface.viewers.EditingSupport
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.SWT
import org.eclipse.ui.texteditor.ITextEditor
import org.eclipse.xtext.nodemodel.ICompositeNode
import org.eclipse.xtext.nodemodel.INode
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.ModalPath
import org.osate.aadl2.NamedElement
import org.osate.aadl2.Property
import org.osate.aadl2.PropertyAssociation
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.SubprogramCallSequence
import org.osate.xtext.aadl2.ui.MyAadl2Activator

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.findNodesForFeature
import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.getNode
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.toIFile

package class ValueColumnEditingSupport extends EditingSupport {
	val static EMBEDDED_RESOURCE_NAME_SUFFIX = "_embedded_for_property_view_cell_editor"
	
	val AadlPropertyView propertyView
	
	var creatingNewLocalInEdit = false
	var newContained = false
	var String initialEditablePart
	var int updateOffset
	var int updateLength
	var String updatePrefix
	var String updateSuffix

	package new(TreeViewer treeViewer, AadlPropertyView propertyView) {
		super(treeViewer)
		this.propertyView = propertyView
	}
	
	override protected canEdit(Object element) {
		if (propertyView.nextEditIsLocalCreation) {
			creatingNewLocalInEdit = true
			newContained = false
			propertyView.nextEditIsLocalCreation = false
			true
		} else if (propertyView.nextEditIsLocalContainedCreation) {
			creatingNewLocalInEdit = true
			newContained = true
			propertyView.nextEditIsLocalContainedCreation = false
			true
		} else {
			creatingNewLocalInEdit = false
			newContained = false
			propertyView.canEdit(element)
		}
	}
	
	override protected getCellEditor(Object element) {
		new OsateStyledTextCellEditor(SWT.SINGLE, MyAadl2Activator.getInstance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2), getProject()) => [
			create(propertyView.treeViewer.tree)
		]
	}
	
	def private getProject() {
		if(propertyView.xtextDocument === null) {
			val NamedElement curSelection = propertyView.resourceFromSelection.resourceSet.getEObject(propertyView.input,
				true) as NamedElement
			curSelection.eResource.URI.toIFile.project
		} else {
			propertyView.xtextDocument.readOnly[URI.toIFile.project]
		}
	}
	
	override protected getValue(Object element) {		
		propertyView.safeReadResource[extension resource|
			// Helper function. If length is negative then it is an offset from the end of the source
			val getText = if (propertyView.xtextDocument === null) {
				val xtextResource = resource as XtextResource
				val text = xtextResource.parseResult.rootNode.text;
				[int offset, int length |  
					val positiveLength = if(length < 0) {
						text.length + length
					} else {
						length;
					}
					
					text.substring(offset, offset + positiveLength)				
				]
			} else {
				[int offset, int length | 
					val positiveLength = if(length < 0) {
						propertyView.xtextDocument.length + length
					} else {
						length;
					}
					
					propertyView.xtextDocument.get(offset, positiveLength)				
				]
			}
			 
			val modelUnitNameEndOffset = contents.head.findNodesForFeature(Aadl2Package.eINSTANCE.namedElement_Name).head.endOffset
			val endNameEndOffset = contents.head.node.lastLeaf.previousNode.endOffset
			if (creatingNewLocalInEdit) {
				val propertyName = (element as TreeEntry).property.getQualifiedName.stripPredeclaredName
				val inputElement = resourceSet.getEObject(propertyView.input, true) as NamedElement
				val offsetElement = switch inputElement {
					AadlPackage,
					Classifier: inputElement
					case !newContained: inputElement
					default: inputElement.containingClassifier
				}
				val firstPA = offsetElement.ownedPropertyAssociations.empty
				initialEditablePart = ''
				updateOffset = if (firstPA) {
					switch offsetElement {
						AadlPackage,
						FeatureGroupType,
						ComponentClassifier case offsetElement.ownedAnnexSubclauses.empty: offsetElement.node.lastLeaf.previousNode.previousNode.offset
						ComponentClassifier: offsetElement.ownedAnnexSubclauses.head.node.offset
						Subcomponent case !offsetElement.ownedModeBindings.empty: offsetElement.ownedModeBindings.head.node.previousNode.previousNode.previousNode.offset
						ModalPath case !offsetElement.inModeOrTransitions.empty: {
							offsetElement.findNodesForFeature(Aadl2Package.eINSTANCE.modalPath_InModeOrTransition).head.previousNode.previousNode.previousNode.offset
						}
						SubprogramCallSequence case !offsetElement.inModes.empty: {
							offsetElement.findNodesForFeature(Aadl2Package.eINSTANCE.modalElement_InMode).head.previousNode.previousNode.previousNode.offset
						}
						default: offsetElement.node.lastLeaf.offset
					}
				} else {
					offsetElement.ownedPropertyAssociations.last.node.endOffset
				}
				updateLength = 0
				
				if (offsetElement instanceof AadlPackage) {
					if (firstPA) {
						updatePrefix = "properties" + System.lineSeparator + "\t" + propertyName + " => "
						updateSuffix = ";" + System.lineSeparator 
					} else {
						updatePrefix = System.lineSeparator + "\t" + propertyName + " => "
						updateSuffix = ";"
					}
				} else if (newContained) {
					if (firstPA) {
						updatePrefix = "\tproperties" + System.lineSeparator + "\t\t\t" + propertyName + " => "
						updateSuffix = " applies to " + inputElement.name + ";" + System.lineSeparator + "\t"
					} else {
						updatePrefix = System.lineSeparator + "\t\t\t" + propertyName + " => "
						updateSuffix = " applies to " + inputElement.name + ";"
					}
				} else if (offsetElement instanceof Classifier) {
					if (firstPA) {
						updatePrefix = "\tproperties" + System.lineSeparator + "\t\t\t" + propertyName + " => "
						updateSuffix = ";" + System.lineSeparator + "\t"
					} else {
						updatePrefix = System.lineSeparator + "\t\t\t" + propertyName + " => "
						updateSuffix = ";"
					}
				} else {
					if (firstPA) {
						updatePrefix = " {" + System.lineSeparator + "\t\t\t\t" + propertyName + " => "
						updateSuffix = ";" + System.lineSeparator + "\t\t\t}"
					} else {
						updatePrefix = System.lineSeparator + "\t\t\t\t" + propertyName + " => "
						updateSuffix = ";"
					}
				}

				val prefix = getText.apply(0, updateOffset)
				val suffix = getText.apply(updateOffset, -updateOffset)
				new CellEditorPartialValue('''«new StringBuilder(prefix).insert(modelUnitNameEndOffset, EMBEDDED_RESOURCE_NAME_SUFFIX)»«updatePrefix»''',
					initialEditablePart,
					'''«updateSuffix»«new StringBuilder(suffix).insert(endNameEndOffset - updateOffset, EMBEDDED_RESOURCE_NAME_SUFFIX)»'''
				)
			} else {
				val expression = getPropertyExpression(resourceSet, element)
				val expressionNode = expression.node
				updateOffset = expressionNode.offset
				updateLength = expressionNode.length
				updatePrefix = ""
				updateSuffix = ""
				initialEditablePart = (resource as XtextResource).serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").trim
				val prefix = getText.apply(0, expressionNode.offset)
				val suffix = getText.apply(expressionNode.endOffset, -expressionNode.endOffset)
				new CellEditorPartialValue(new StringBuilder(prefix).insert(modelUnitNameEndOffset, EMBEDDED_RESOURCE_NAME_SUFFIX).toString,
					initialEditablePart,
					new StringBuilder(suffix).insert(endNameEndOffset - expressionNode.endOffset, EMBEDDED_RESOURCE_NAME_SUFFIX).toString
				)
			}
		];
	}

	private def PropertyExpression getPropertyExpression(ResourceSet resourceSet, Object element) {
		switch treeElement : (element as TreeEntry).treeElement {
			URI: switch treeElementObject : resourceSet.getEObject(treeElement, true) {
				Property: {
					(resourceSet.getEObject(
						propertyView.cachedPropertyAssociations.get(((element as TreeEntry).parent as TreeEntry).treeElement).get(treeElement),
						true
					) as PropertyAssociation).ownedValues.head.ownedValue
				}
				BasicPropertyAssociation: treeElementObject.value
			}
			RangeElement: resourceSet.getEObject(treeElement.expressionURI, true) as PropertyExpression
			ListElement: resourceSet.getEObject(treeElement.expressionURI, true) as PropertyExpression
		}
	}

	private def stripPredeclaredName(String qualifiedName) {
		val predeclaredNames = #['communication_properties::', 'deployment_properties::', 'memory_properties::',
				'modeling_properties::', 'programming_properties::', 'thread_properties::', 'timing_properties::']
		val toStrip = predeclaredNames.findFirst[qualifiedName.toLowerCase.startsWith(it)]?:''
		qualifiedName.substring(toStrip.length)
	}

	override protected setValue(Object element, Object value) {
		if (creatingNewLocalInEdit || !(value as String).empty && initialEditablePart != value) {
			// insert new property value
			propertyView.modify(new IUnitOfWork.Void<XtextResource> {
				override process(XtextResource state) throws Exception {
					state.update(updateOffset, updateLength, updatePrefix + value + updateSuffix)
				}
			})
			
			propertyView.runCachePropertyLookupJob(propertyView.input, null)
			propertyView.treeViewer.refresh((element as TreeEntry).propertyParent)

			// select inserted/modified text in editor			
			val activeEditor = propertyView.site.workbenchWindow.activePage.activeEditor
			if (activeEditor instanceof ITextEditor) {
				activeEditor.selectAndReveal(updateOffset, updatePrefix.length +(value as String).length + updateSuffix.length)
			}
		}
	}
	
	def private static getLastLeaf(ICompositeNode node) {
		var INode result = node
		while (result instanceof ICompositeNode) {
			result = result.lastChild
		}
		result ?: node
	}
	
	def private static getPreviousNode(INode node) {
		var lln = node.previousSibling
		while (lln instanceof HiddenLeafNode) {
			lln = lln.previousSibling
		}
		lln
	}
	
	def private TreeEntry getPropertyParent(TreeEntry element) {
		if (element.treeElement instanceof URI && propertyView.safeRead[extension it | (element.treeElement as URI).getEObject(true) instanceof Property]) {
			element
		} else {
			(element.parent as TreeEntry).propertyParent
		}
	}

	def private Property getProperty(TreeEntry element) {
		propertyView.safeRead[extension it |
			if (element.treeElement instanceof URI && (element.treeElement as URI).getEObject(true) instanceof Property) {
				(element.treeElement as URI).getEObject(true)
			} else {
				(element.parent as TreeEntry).propertyParent
			}
		] as Property
	}
}