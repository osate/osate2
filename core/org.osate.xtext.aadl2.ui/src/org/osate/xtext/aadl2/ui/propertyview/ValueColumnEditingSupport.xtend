/*
 *
 * <copyright>
 * Copyright  2014 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/org/documents/epl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.xtext.aadl2.ui.propertyview

import de.itemis.xtext.utils.jface.viewers.XtextStyledTextCellEditor
import org.eclipse.emf.common.util.URI
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
import static extension org.osate.aadl2.modelsupport.resources.OsateResourceUtil.convertToIResource
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.SaveOptions
import org.eclipse.xtext.serializer.ISerializer

package class ValueColumnEditingSupport extends EditingSupport {
	val static EMBEDDED_RESOURCE_NAME_SUFFIX = "_embedded_for_property_view_cell_editor"
	
	val AadlPropertyView propertyView
	
	val delim = System.getProperty("line.separator")
	
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
		new XtextStyledTextCellEditor(SWT.SINGLE, MyAadl2Activator.getInstance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2), getProject()) => [
			create(propertyView.treeViewer.tree)
		]
	}
	
	def private getProject() {
		if(propertyView.xtextDocument === null) {
			val NamedElement curSelection = propertyView.resourceSetFromSelection.getEObject(propertyView.input,
				true) as NamedElement
			curSelection.eResource.convertToIResource.project
		} else {
			propertyView.xtextDocument.readOnly[convertToIResource.project]
		}
	}
	
	override protected getValue(Object element) {
		if (propertyView.xtextDocument === null) {
			val inputElement = propertyView.resourceSetFromSelection.getEObject(propertyView.input,
				true) as NamedElement
			val xtextResource = inputElement.eResource as XtextResource
			val contents = xtextResource.contents
			val modelUnitNameEndOffset = contents.head.findNodesForFeature(
				Aadl2Package.eINSTANCE.namedElement_Name).head.endOffset
			val endNameEndOffset = contents.head.node.lastLeaf.previousNode.endOffset
			val text = xtextResource.parseResult.rootNode.text
			if (creatingNewLocalInEdit) {
				val ()=> String getPrefix = [|text.substring(0, updateOffset)]
				val ()=> String getSuffix = [|text.substring(updateOffset, updateOffset + text.length - updateOffset)]
				editNewProperty(element, inputElement, xtextResource.resourceSet, getPrefix, getSuffix, modelUnitNameEndOffset, endNameEndOffset)
			} else {
				val (ICompositeNode)=> String getPrefix = [expressionNode| text.substring(0, expressionNode.offset)]
				val (ICompositeNode)=> String getSuffix = [expressionNode| text.substring(expressionNode.endOffset,
					expressionNode.endOffset + text.length - expressionNode.endOffset)]
				editExistingProperty(element, xtextResource.resourceSet, xtextResource.serializer, getPrefix, getSuffix, modelUnitNameEndOffset, endNameEndOffset)
			}
		} else {
			propertyView.xtextDocument.readOnly [
				val modelUnitNameEndOffset = contents.head.findNodesForFeature(Aadl2Package.eINSTANCE.namedElement_Name).head.endOffset
				val endNameEndOffset = contents.head.node.lastLeaf.previousNode.endOffset
				if (creatingNewLocalInEdit) {
					val inputElement = resourceSet.getEObject(propertyView.input, true) as NamedElement
					val ()=> String getPrefix = [|propertyView.xtextDocument.get(0, updateOffset)]
					val ()=> String getSuffix = [|propertyView.xtextDocument.get(updateOffset,
							propertyView.xtextDocument.length - updateOffset)]
					editNewProperty(element, inputElement, resourceSet, getPrefix, getSuffix, modelUnitNameEndOffset, endNameEndOffset)
				} else {
					val (ICompositeNode)=> String getPrefix = [expressionNode| propertyView.xtextDocument.get(0, expressionNode.offset)]
					val (ICompositeNode)=> String getSuffix = [expressionNode| propertyView.xtextDocument.get(expressionNode.endOffset,
							propertyView.xtextDocument.length - expressionNode.endOffset)]
					editExistingProperty(element, resourceSet, serializer, getPrefix, getSuffix, modelUnitNameEndOffset, endNameEndOffset)
				}
			]
		}
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
		val strippedVal = (value as String).replaceAll("\\s+","")
		if(!(strippedVal as String).empty) {
			if (creatingNewLocalInEdit || initialEditablePart != strippedVal) {
				// insert new property value
				if (propertyView.xtextDocument !== null) {
					propertyView.xtextDocument.modify(new IUnitOfWork.Void<XtextResource> {
						override process(XtextResource state) throws Exception {
							state.update(updateOffset, updateLength, updatePrefix + strippedVal + updateSuffix)
						}
					})
	
					propertyView.treeViewer.refresh((element as TreeEntry).propertyParent)
	
					// select inserted/modified text in editor			
					val activeEditor = propertyView.site.workbenchWindow.activePage.activeEditor
					if (activeEditor instanceof ITextEditor) {
						activeEditor.selectAndReveal(updateOffset,
							updatePrefix.length + (strippedVal as String).length + updateSuffix.length)
					}
				} else {
					val inputElement = propertyView.resourceSetFromSelection.getEObject(propertyView.input,
						true) as NamedElement
					val xtextResource = inputElement.eResource as XtextResource
					propertyView.executeCommand([|
						xtextResource.update(updateOffset, updateLength, updatePrefix + strippedVal + updateSuffix)											
						xtextResource.save(SaveOptions.newBuilder().format().getOptions().toOptionsMap())
						propertyView.updateView(propertyView.input, null)
					])
				}
			}
		}
	}
	
	def private editNewProperty(Object element, NamedElement inputElement, ResourceSet resourceSet, ()=>String getPrefix, ()=>String getSuffix, int modelUnitNameEndOffset, int endNameEndOffset) {
		val propertyName = (element as TreeEntry).property.getQualifiedName.stripPredeclaredName
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
		val inPropertiesSection = newContained || inputElement instanceof AadlPackage || inputElement instanceof Classifier
		updatePrefix = ''
		if (firstPA) {
			updatePrefix += if (inPropertiesSection) {
				'''properties«delim»'''
			} else {
				''' {'''
			}
		} else {
			updatePrefix += delim
		}
		updatePrefix += '''«propertyName» => '''
		updateSuffix = ''
		if (newContained) {
			updateSuffix += ''' applies to «inputElement.name»'''
		}
		updateSuffix += ';'
		updateSuffix += if (inPropertiesSection) {
			''
		} else if (firstPA) {
			'}'
		} else {
			delim
		}
		val prefix = getPrefix.apply
		val suffix = getSuffix.apply
		new CellEditorPartialValue(
			'''«new StringBuilder(prefix).insert(modelUnitNameEndOffset, EMBEDDED_RESOURCE_NAME_SUFFIX)»«updatePrefix»''',
			initialEditablePart,
			'''«updateSuffix»«new StringBuilder(suffix).insert(endNameEndOffset - updateOffset, EMBEDDED_RESOURCE_NAME_SUFFIX)»'''
		)
	}
	
	def private editExistingProperty(Object element, ResourceSet resourceSet, ISerializer serializer, (ICompositeNode)=>String getPrefix, (ICompositeNode)=>String getSuffix, int modelUnitNameEndOffset, int endNameEndOffset) {
		val expression = getPropertyExpression(resourceSet, element)
		val expressionNode = expression.node
		updateOffset = expressionNode.offset
		updateLength = expressionNode.length
		updatePrefix = ""
		updateSuffix = ""
		initialEditablePart = serializer.serialize(expression).replaceAll("\n", "").replaceAll("\r", "").
			replaceAll("\t", "").trim
		val prefix = getPrefix.apply(expressionNode)
		val suffix = getSuffix.apply(expressionNode)
		new CellEditorPartialValue(
			new StringBuilder(prefix).insert(modelUnitNameEndOffset, EMBEDDED_RESOURCE_NAME_SUFFIX).
				toString,
			initialEditablePart,
			new StringBuilder(suffix).insert(endNameEndOffset - expressionNode.endOffset,
				EMBEDDED_RESOURCE_NAME_SUFFIX).toString
		)
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