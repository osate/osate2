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

package org.osate.xtext.aadl2.ui.quickfix;

import com.google.inject.Inject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.ui.editor.IURIEditorOpener
import org.eclipse.xtext.ui.editor.model.edit.IModification
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification
import org.eclipse.xtext.ui.editor.quickfix.Fix
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor
import org.eclipse.xtext.util.concurrent.IUnitOfWork
import org.eclipse.xtext.validation.Issue
import org.osate.aadl2.AbstractFeature
import org.osate.aadl2.Access
import org.osate.aadl2.AccessType
import org.osate.aadl2.ComponentPrototype
import org.osate.aadl2.Connection
import org.osate.aadl2.DirectedFeature
import org.osate.aadl2.EnumerationLiteral
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.FeaturePrototype
import org.osate.aadl2.FeaturePrototypeBinding
import org.osate.aadl2.FeaturePrototypeReference
import org.osate.aadl2.GroupExtension
import org.osate.aadl2.ModalElement
import org.osate.aadl2.ModalPath
import org.osate.aadl2.ModalPropertyValue
import org.osate.aadl2.Mode
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.NamedElement
import org.osate.aadl2.NumericRange
import org.osate.aadl2.PackageSection
import org.osate.aadl2.PortSpecification
import org.osate.aadl2.PropertyExpression
import org.osate.aadl2.PropertySet
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.UnitLiteral
import org.osate.xtext.aadl2.properties.ui.quickfix.PropertiesQuickfixProvider
import org.osate.xtext.aadl2.validation.Aadl2JavaValidator

class Aadl2QuickfixProvider extends PropertiesQuickfixProvider {
	@Inject
	IURIEditorOpener editorOpener
	
	/**
	 * QuickFix for matching the defining and ending identifiers of classifiers, packages, and property sets.
	 * The issue data array is expected to have three elements:
	 *
	 * issue.getData()[0]: The defining identifier of the classifier or model unit.
	 * issue.getData()[1]: The ending identifier of the classifier or model unit.
	 * issue.getData()[2]: The offset of the ending identifier within the Xtext document.
	 */
	@Fix(Aadl2JavaValidator.MISMATCHED_BEGINNING_AND_ENDING_IDENTIFIERS)
	def void fixMismatchedBeginningAndEndingIdentifiers(Issue issue, IssueResolutionAcceptor acceptor) {
		val String beginningName = issue.getData().get(0);
		val String endingName = issue.getData().get(1);
		val int endingIdentifierOffset = Integer.parseInt(issue.getData().get(2));
		acceptor.accept(issue, "Change defining identifier to '" + endingName + "'", null, null,
				new ISemanticModification() {
					override void apply(EObject element, IModificationContext context) throws Exception {
						(element as NamedElement).setName(endingName);
					}
				});
		acceptor.accept(issue, "Change ending identifier to '" + beginningName + "'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(endingIdentifierOffset, endingName.length(), beginningName);
			}
		});
	}

	/**
	 * QuickFix for Non-unique ComponentType names, most likely "refined to" missing.
	 * The issue data array is expected to have three elements:
	 *
	 * issue.getData()[0]: The name of the element.
	 * issue.getData()[1]: The offset of the ":".
	 * issue.getData()[2]: replacement value.
	 */
	@Fix(Aadl2JavaValidator.DUPLICATE_COMPONENT_TYPE_NAME)
	def void fixDuplicateComponentType(Issue issue, IssueResolutionAcceptor acceptor) {
		val String componentTypeName = issue.getData().get(0);
		val int offset = Integer.parseInt(issue.getData().get(1));
		val String replacementVal = issue.getData().get(2);
		
		acceptor.accept(issue, "Add 'refined to' to '" + componentTypeName + "'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offset, 1, replacementVal);
			} 
		});
	}

	/**
	 * QuickFix for duplicate literal in an enumeration
	 * issue.getData()[0]: The name of the EnumerationLiteral.
	 */
	@Fix(Aadl2JavaValidator.DUPLICATE_LITERAL_IN_ENUMERATION)
	def void fixDuplicateLiteralInEnumeration(Issue issue, IssueResolutionAcceptor acceptor) {
		val String dupeLiteralName = issue.getData().get(0);
		acceptor.accept(issue, "Remove duplicate literal '" + dupeLiteralName + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val el = element as EnumerationLiteral
					val enumContainer = el.eContainer as EnumerationType
					enumContainer.ownedLiterals.remove(el)
				}
		});
	}

	/**
	 * QuickFix for unit literal being out of sequence
	 * issue.getData(0) UnitLiteral.baseUnit.name
	 * issue.getData(1) ... issue.getData(n): Alternating strings of the UnitLiteral names and URI.
	 */
	@Fix(Aadl2JavaValidator.UNIT_LITERAL_OUT_OF_ORDER)
	def void fixUnitLiteralOutOfOrder(Issue issue, IssueResolutionAcceptor acceptor) {
		val baseUnitName = issue.data.head
		val iter = issue.data.iterator
		
		if(iter.hasNext) iter.next
		
		while(iter.hasNext){
			val ulName = iter.next
			val nextUri = iter.next
			acceptor.accept(issue, "Change unit base type '" + baseUnitName + "' to '" + ulName + "'", null, null,
					new ISemanticModification() {
						override void apply(EObject element, IModificationContext context) throws Exception {
							val ResourceSet resourceSet = element.eResource().getResourceSet();
							val UnitLiteral newBaseUnit = resourceSet.getEObject(URI.createURI(nextUri), true) as UnitLiteral;
							(element as UnitLiteral).baseUnit = newBaseUnit
						}
					}
			);
		}
	}


	/**
	 * QuickFix for mode in modal property value not being defined for the container
	 * issue.getData(0) mode.name
	 * issue.getData(1) undefinedMode URI 
	 * issue.getData(2) containerName
	 * issue.getData(3) containerURI
	 * issue.getData(4) ModalPropertyValue 
	 * issue.getData(5) ... issue.getData(n): Alternating strings of proposed replacement mode names and URI.
	 *  
	 */
	@Fix(Aadl2JavaValidator.MODE_NOT_DEFINED_IN_CONTAINER)
	def void fixModeNotDefinedInContainer(Issue issue, IssueResolutionAcceptor acceptor) {
		val modeName = issue.data.head		
		val undefinedModeURI =  issue.data.get(1)
		val containerName = issue.data.get(2)	
		val containerURI = issue.data.get(3)
		val modalPropertyValueURI = issue.data.get(4)

		acceptor.accept(issue, "Add '" + modeName + "' to in modes of '" + containerName + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val ResourceSet resourceSet = element.eResource().getResourceSet();
					val ModalElement container = resourceSet.getEObject(URI.createURI(containerURI), true) as ModalElement;
					val Mode undefinedMode = resourceSet.getEObject(URI.createURI(undefinedModeURI), true) as Mode;
			
					switch container {
						ModalPath : container.inModeOrTransitions.add(undefinedMode)
						default : container.inModes.add(undefinedMode)
					}
				}
			}
		);

		val iter = issue.data.iterator
		for (var i=0;i<5;i++){
			if(iter.hasNext) iter.next
		}
	
		while(iter.hasNext){
			val replacementName = iter.next
			val nextUri = iter.next

			acceptor.accept(issue, "Replace '" + modeName + "' with '" + replacementName + "'", null, null,
					new ISemanticModification() {
						override void apply(EObject element, IModificationContext context) throws Exception {
							val ResourceSet resourceSet = element.eResource().getResourceSet();
							val Mode replacementMode = resourceSet.getEObject(URI.createURI(nextUri), true) as Mode;
							val Mode undefinedMode = resourceSet.getEObject(URI.createURI(undefinedModeURI), true) as Mode;
							val ModalPropertyValue mpv = resourceSet.getEObject(URI.createURI(modalPropertyValueURI), true) as ModalPropertyValue
							mpv.inModes.remove(undefinedMode)
							mpv.inModes.add(replacementMode);
						}
						
					}
					
			);
		}
	}
	
	/**
	 * QuickFix for using self keyword when not allowed
	 * issue.getData(0) offSet
	 * issue.getData(1) connectionEndURI
	 */
	@Fix(Aadl2JavaValidator.SELF_NOT_ALLOWED)
	def void fixSelfNotAllowed(Issue issue, IssueResolutionAcceptor acceptor) {
		val offSet = Integer.parseInt(issue.getData().head)
		val alternateConnectionEndType = issue.data.get(1)
		acceptor.accept(issue, "Remove 'self'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offSet, 5, "")
			}
		});
		if (alternateConnectionEndType.equals("processor")){
			acceptor.accept(issue, "Replace 'self' with 'processor'", null, null, new IModification() {
				override void apply(IModificationContext context) throws Exception {
					context.getXtextDocument().replace(offSet, 4, "processor")
				}
			});
		}
	}
	
	/**
	 * QuickFix for using processor keyword when not allowed
	 * issue.getData(0) offSet
	 * issue.getData(1) connectionEndURI
	 */
	@Fix(Aadl2JavaValidator.PROCESSOR_NOT_ALLOWED)
	def void fixProcessorNotAllowed(Issue issue, IssueResolutionAcceptor acceptor) {
		val offSet = Integer.parseInt(issue.getData().head)
		val alternateConnectionEndType = issue.data.get(1)
		acceptor.accept(issue, "Remove 'processor'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offSet, 10, "")
			}
		});
		if (alternateConnectionEndType.equals("self")){
			acceptor.accept(issue, "Replace 'processor' with 'self'", null, null, new IModification() {
				override void apply(IModificationContext context) throws Exception {
					context.getXtextDocument().replace(offSet, 9, "self")
				}
			});
		}
	}

	/**
	 * QuickFix for flow impl kind not matching flow spec kind
	 * issue.getData(0) impl kind name
	 * issue.getData(1) flow spec name
	 * issue,getData(2) offSet
	 */
	@Fix(Aadl2JavaValidator.INCONSISTENT_FLOW_KIND)
	def void fixInconsistentFlowKind(Issue issue, IssueResolutionAcceptor acceptor) {
		val flowImplKindName = issue.data.head
		val flowSpecKindName = issue.data.get(1)
		val offSet = Integer.parseInt(issue.getData().get(2))

		acceptor.accept(issue, "Change '" + flowImplKindName + "' to '" + flowSpecKindName + "'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offSet, flowImplKindName.length, flowSpecKindName)
			}
		});
	}


	/**
	 * QuickFix for out flow feature identifier not matching the flow specification
	 * issue.getData(0) outImplName
	 * issue.getData(1) specName
	 * issue,getData(2) featureOffSet
	 * issue,getData(3) contextOffset
	 */
	@Fix(Aadl2JavaValidator.OUT_FLOW_FEATURE_IDENTIFIER_NOT_SPEC)
	def void fixOutFlowIdentifierNotSpec(Issue issue, IssueResolutionAcceptor acceptor) {
		val outImplName = issue.data.head
		val specName = issue.data.get(1)
		val featureOffSet = Integer.parseInt(issue.data.get(2))
		val contextOffset = Integer.parseInt(issue.data.get(3))

		acceptor.accept(issue, "Change '" + outImplName + "' to '" + specName + "'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				var useOffSet = featureOffSet
				var replacement = specName;
				if (0 < contextOffset){
					useOffSet = contextOffset
				}
				context.getXtextDocument().replace(useOffSet, outImplName.length, replacement)
			}
		});
	}

	/**
	 * QuickFix for in flow feature identifier not matching the flow specification
	 * issue.getData(0) inImplName
	 * issue.getData(1) specName
	 * issue,getData(2) featureOffSet
	 * issue,getData(3) contextOffset
	 */
	@Fix(Aadl2JavaValidator.IN_FLOW_FEATURE_IDENTIFIER_NOT_SPEC)
	def void fixInFlowIdentifierNotSpec(Issue issue, IssueResolutionAcceptor acceptor) {
		val inImplName = issue.data.head
		val specName = issue.data.get(1)
		val featureOffSet = Integer.parseInt(issue.data.get(2))
		acceptor.accept(issue, "Change '" + inImplName + "' to '" + specName + "'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				var useOffSet = featureOffSet
				var replacement = specName;
				context.getXtextDocument().replace(useOffSet, inImplName.length, replacement)
			}
		});
		
	}
	
	/**
	 * QuickFix for Subcomponent not in flow modes
	 * issue.getData(0) flowModeName
	 * issue.getData(1) flowModeURI
	 * issue,getData(2) subcomponentName
	 * issue,getData(3) subcomponentURI
	 */
	@Fix(Aadl2JavaValidator.SUBCOMPONENT_NOT_IN_FLOW_MODE)
	def void fixSubcomponentNotInFlowMode(Issue issue, IssueResolutionAcceptor acceptor) {
		val flowModeName = issue.data.head		
		val flowModeURI =  issue.data.get(1)
		val subcomponentName = issue.data.get(2)	
		val subcomponentURI = issue.data.get(3)

		acceptor.accept(issue, "Add mode '" + flowModeName + "' to in modes of '" + subcomponentName + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val suburi = URI.createURI(subcomponentURI);
					// The following opens up file if subcomponent is defined in a different file
					val doc = context.getXtextDocument(suburi)
					doc.modify(new IUnitOfWork.Void<XtextResource>{
						override process(XtextResource state) throws Exception {
							val flowMode = state.resourceSet.getEObject(URI.createURI(flowModeURI), true) as Mode;
							val subcomponent = state.resourceSet.getEObject(suburi, true) as Subcomponent;
							val modeBinding = subcomponent.createOwnedModeBinding
							modeBinding.parentMode = flowMode	
						}
					})
					editorOpener.open(suburi, true)
				}
			}
		);
	}

	/**
	 * QuickFix for Subcomponent not in flow modes
	 * issue.getData(0) flowModeName
	 * issue.getData(1) flowModeURI
	 * issue,getData(2) connectionName
	 * issue,getData(3) connectionURI
	 */
	@Fix(Aadl2JavaValidator.CONNECTION_NOT_IN_FLOW_MODE)
	def void fixConnectionNotInFlowMode(Issue issue, IssueResolutionAcceptor acceptor) {
		val flowModeName = issue.data.head		
		val flowModeURI =  issue.data.get(1)
		val connectionName = issue.data.get(2)	
		val connectionURI = issue.data.get(3)

		acceptor.accept(issue, "Add mode '" + flowModeName + "' to in modes of '" + connectionName + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val connuri = URI.createURI(connectionURI);
					// The following opens up file if connection is defined in a different file
					val doc = context.getXtextDocument(connuri)
					doc.modify(new IUnitOfWork.Void<XtextResource>{
						override process(XtextResource state) throws Exception {
							val flowMode = state.resourceSet.getEObject(URI.createURI(flowModeURI), true) as Mode;
							val connection = state.resourceSet.getEObject(connuri, true) as Connection;
							connection.inModeOrTransitions.add(flowMode)
						}
					})
					editorOpener.open(connuri, true)
				}
			}
		);
	}

	/**
	 * QuickFix for Subcomponent not in flow modes
	 * issue.getData(0) targetName
	 * issue.getData(1) targetURI
	 * issue,getData(2) neededModeName
	 * issue,getData(3) neededModeURI
	 */
	@Fix(Aadl2JavaValidator.END_TO_END_FLOW_SEGMENT_NOT_IN_MODE)
	def void fixEndToEndFlowSegmentNotInMode(Issue issue, IssueResolutionAcceptor acceptor) {
		val targetName = issue.data.head		
		val targetURI =  issue.data.get(1)
		val neededModeName = issue.data.get(2)	
		val neededModeURI = issue.data.get(3)

		acceptor.accept(issue, "Add mode '" + neededModeName + "' to in modes of '" + targetName + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val targeturi = URI.createURI(targetURI);
					// The following opens up file if connection is defined in a different file
					val doc = context.getXtextDocument(targeturi)
					doc.modify(new IUnitOfWork.Void<XtextResource>{
						override process(XtextResource state) throws Exception {
							val neededMode = state.resourceSet.getEObject(URI.createURI(neededModeURI), true) as Mode;
							val targetObject = state.resourceSet.getEObject(targeturi, true);
							switch targetObject {
								Subcomponent : {
									val modeBinding = targetObject.createOwnedModeBinding
									modeBinding.parentMode = neededMode	
								}
								ModalPath : targetObject.inModeOrTransitions.add(neededMode)
							}
						}
					})
					editorOpener.open(targeturi, true)
				}
			}
		);
	}

	/**
	 * QuickFix for generic text replacement
	 * issue.getData(0) changeFrom
	 * issue.getData(1) changeTo
	 * issue,getData(2) offSet
	 */
	@Fix(Aadl2JavaValidator.GENERIC_TEXT_REPLACEMENT)
	def void fixByGenericTextReplacement(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		val changeTo = issue.data.get(1)
		val offSet = Integer.parseInt(issue.getData().get(2))

		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null, new IModification() {
			override void apply(IModificationContext context) throws Exception {
				context.getXtextDocument().replace(offSet, changeFrom.length, changeTo)
			}
		});
	}

	/**
	 * QuickFix for Array size not same as reference list size
	 * issue.getData(0) arraySize
	 * issue.getData(1) referenceListSize
	 */
	@Fix(Aadl2JavaValidator.ARRAY_SIZE_NOT_EQUAL_REFERENCE_LIST_SIZE)
	def void fixArraySizeNotEqualRefernceListSize(Issue issue, IssueResolutionAcceptor acceptor) {
		val arraySize = Integer.parseInt(issue.data.head)		
		val referenceListSize =  Integer.parseInt(issue.data.get(1))

		acceptor.accept(issue, "Change Array size from '" + arraySize + "' to '" + referenceListSize + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val subcomponent = element as Subcomponent
					subcomponent.arrayDimensions.head.size.size = referenceListSize;
				}
			}
		);
	}

	/**
	 * QuickFix for Prototype must be an array because the refined prototype is an array
	 */
	@Fix(Aadl2JavaValidator.PROTOTYPE_NOT_ARRAY)
	def void fixPrototypeMusBeAnArray(Issue issue, IssueResolutionAcceptor acceptor) {

		acceptor.accept(issue, "Change prototype to an array", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val prototype = element as ComponentPrototype
					prototype.array = true;
				}
			}
		);
	}
	/**
	 * QuickFix for Prototype binding direction not consistent with formal
	 * issue.getData(0) = actualDirection.toString();
	 * issue.getData(1) = formalDirection.toString();
	 */
	@Fix(Aadl2JavaValidator.PROTOTYPE_BINDING_DIRECTION_NOT_CONSISTENT_WITH_FORMAL)
	def void fixPrototypeBindingDirection(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		val changeTo = issue.data.get(1)
	
		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val binding = element as FeaturePrototypeBinding
					val formal =  binding.formal as FeaturePrototype
					val actual = binding.actual
					switch actual {
						FeaturePrototypeReference: {
							actual.in = formal.in
							actual.out = formal.out
						}
						PortSpecification : {
							actual.in = formal.in
							actual.out = formal.out
						} 
					}
				}
			}
		);
	}

	/**
	 * QuickFix for incompatible direction for prototype refinement
	 * issue.getData(0) = changeFrom
	 * issue.getData(1) = changeTo;
	 */
	@Fix(Aadl2JavaValidator.INCOMPATIBLE_DIRECTION_FOR_PROTOTYPE_REFINEMENT)
	def void fixIncompatibleDirectionForPrototypeRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		val changeTo = issue.data.get(1)
	
		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val prototype = element as FeaturePrototype
					val refined = prototype.refined as FeaturePrototype
					prototype.in = refined.in			
					prototype.out = refined.out			
				}
			}
		);
	}
	/**
	 * QuickFix for incompatible  feature direction in refinement
	 * issue.getData(0) = changeFrom
	 * issue.getData(1) = changeTo;
	 */
	@Fix(Aadl2JavaValidator.INCOMPATIBLE_FEATURE_DIRECTION_IN_REFINEMENT)
	def void fixIncompatibleFeatureDirectionInRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		val changeTo = issue.data.get(1)
	
		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val feature = element as DirectedFeature
					val refined = feature.refined as DirectedFeature
					feature.in = refined.in			
					feature.out = refined.out			
				}
			}
		);
	}

	/**
	 * QuickFix for incompatible  feature direction in refinement
	 * issue.getData(0) = changeFrom
	 * issue.getData(1) = changeTo;
	 */
	@Fix(Aadl2JavaValidator.ABSTRACT_FEATURE_DIRECTION_DOES_NOT_MATCH_PROTOTYPE)
	def void fixAbstractFeatureDirectionDoesNotMatchPrototype(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		val changeTo = issue.data.get(1)
	
		acceptor.accept(issue, "Change '" + changeFrom + "' to '" + changeTo + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val feature = element as AbstractFeature
					val prototype = feature.featurePrototype
					feature.in = prototype.in		
					feature.out = prototype.out			
				}
			}
		);
	}
	/**
	 * QuickFix for incompatible feature direction in refinement
	 * issue.getData(0) = changeFrom
	 */
	@Fix(Aadl2JavaValidator.ABSTRACT_FEATURE_DIRECTION_NOT_IN_PROTOTYPE)
	def void fixAbstractFeatureDirectionNotInPrototype(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
	
		acceptor.accept(issue, "Remove '" + changeFrom + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val feature = element as AbstractFeature
					feature.in = false		
					feature.out = false			
				}
			}
		);
	}
	/**
	 * QuickFix for added direction in abstract feature refinement
	 * issue.getData(0) = changeFrom
	 */
	@Fix(Aadl2JavaValidator.ADDED_DIRECTION_IN_ABSTRACT_FEATURE_REFINEMENT)
	def void fixAddedDirectionInAbstractFeatureRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
	
		acceptor.accept(issue, "Remove '" + changeFrom + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val feature = element as AbstractFeature
					feature.in = false		
					feature.out = false			
				}
			}
		);
	}

	/**
	 * QuickFix for added prototype or classifier in abstract feature refinement
	 * issue.getData(0) = changeFrom
	 */
	@Fix(Aadl2JavaValidator.ADDED_PROTOTYPE_OR_CLASSIFIER_IN_ABSTRACT_FEATURE_REFINEMENT)
	def void fixAddedPrototypeOrClassifierInAbstractFeatureRefinement(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		acceptor.accept(issue, "Remove '" + changeFrom + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val feature = element as AbstractFeature
					feature.featurePrototype = null		
				}
			}
		);
	}

	/**
	 * QuickFix for chained inverse feature group types
	 */
	@Fix(Aadl2JavaValidator.CHAINED_INVERSE_FEATURE_GROUP_TYPES)
	def void fixChainedInverseFeatureGroupTypes(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove inverse", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val featureGroupType = element as FeatureGroupType
					featureGroupType.inverse = null		
				}
			}
		);
	}

	/**
	 * QuickFix for extending inverse feature group types
	 */
	@Fix(Aadl2JavaValidator.EXTENDED_INVERSE_FEATURE_GROUP_TYPE)
	def void fixExtendedInverseFeatureGroupTypes(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove extends", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val groupExtension = element as GroupExtension
					val featureGroup = groupExtension.eContainer as FeatureGroupType
					featureGroup.ownedExtension = null		
				}
			}
		);
	}

	/**
	 * QuickFix for extending inverse feature group types
	 */
	@Fix(Aadl2JavaValidator.INVERSE_IN_FEATURE_GROUP_TYPE_EXTENSION)
	def void fixInverseInFeatureGroupTypeExtension(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove extends", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val groupExtension = element as GroupExtension
					val featureGroup = groupExtension.eContainer as FeatureGroupType
					featureGroup.ownedExtension = null		
				}
			}
		);
		acceptor.accept(issue, "Remove inverse", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val groupExtension = element as GroupExtension
					val featureGroup = groupExtension.eContainer as FeatureGroupType
					featureGroup.inverse = null		
				}
			}
		);
	}

	/**
	 * QuickFix for inverse in feature group
	 */
	@Fix(Aadl2JavaValidator.INVERSE_IN_FEATURE_GROUP)
	def void fixInverseInFeatureGroup(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove inverse", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val featureGroup = element as FeatureGroup
					featureGroup.inverse = false	
				}
			}
		);
	}

	/**
	 * QuickFix for extending inverse feature group types
	 * issue.getData(0) = valid direction if any or empty String
	 * issue.getData(1) = current direction
	 */
	@Fix(Aadl2JavaValidator.DIRECTION_NOT_SAME_AS_FEATURE_GROUP_MEMBERS)
	def void fixDirectionNotTheSameAsFeatureGroupMembers(Issue issue, IssueResolutionAcceptor acceptor) {
		val validDirection = issue.data.head
		val currentDirection = issue.data.get(1)
		
		acceptor.accept(issue, "Remove '" + currentDirection + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val featureGroup = element as FeatureGroup
					featureGroup.in = false
					featureGroup.out = false
				}
			}
		);
		if (!validDirection.equals("")){
			acceptor.accept(issue, "Change direction from '" +  currentDirection +"' to '" + validDirection + "'" , null, null,
				new ISemanticModification() {
					override void apply(EObject element, IModificationContext context) throws Exception {
						val featureGroup = element as FeatureGroup
						switch validDirection {
							case  "in" : {
								featureGroup.in = true
								featureGroup.out = false
							}
							case "out" : {
								featureGroup.in = false
								featureGroup.out = true
							}
							default : {
								featureGroup.in = false
								featureGroup.out = false
							}
						}
					}
				}
			);
		}
	}
	/**
	 * QuickFix for reverse access kind
	 * issue.getData.get(0) changeFrom
	 * issue.getData.get(1) changeTo
	 */
	@Fix(Aadl2JavaValidator.REVERSE_ACCESS_KIND)
	def void fixReverseAccessKind(Issue issue, IssueResolutionAcceptor acceptor) {
		val changeFrom = issue.data.head
		val changeTo = issue.data.get(1)
		acceptor.accept(issue, "Change access from '" + changeFrom + "' to '" + changeTo + "'", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val access = element as Access
					access.kind = AccessType.getByName(changeTo)	
				}
			}
		);
	}
	/**
	 * QuickFix for swapping Upper and Lower bounds in a range value when the upper is less than the lower
	 * issue.getData.get(0) lowerURI
	 * issue.getData.get(1) upperURI
	 * issue.getData.get(2) keyword before the range
	 * issue.getData.get(3) offSet of keyword before the range
	 */
	@Fix(Aadl2JavaValidator.NUMERIC_RANGE_UPPER_LESS_THAN_LOWER)
	def void fixNumericRangeUpperLessThanLower(Issue issue, IssueResolutionAcceptor acceptor) {
		val lowerURI = issue.data.head
		val upperURI = issue.data.get(1)
		val changeFrom = issue.data.get(2)
		val offSet = Integer.parseInt(issue.data.get(3))
		val changeTo = changeFrom + " "
		/* Doing just a semantic modification here caused the new lowerbound of the range to butt up against the
		 * type keyword without any white space causing "aadlinteger 12 .. 5" to become "aadlinteger5 .. 12" after
		 * the change. The solution here was to make the semantic change and then a text change replacing 
		 * "aadlinteger" with "aadlinteger " 
		 */
		acceptor.accept(issue, "Switch upper and lower bounds of the range", null, null, new IModification(){
			override apply(IModificationContext context) throws Exception {
				context.xtextDocument.modify(new IUnitOfWork.Void<XtextResource>{
					override process(XtextResource state) throws Exception {
						val ResourceSet resourceSet = state.getResourceSet();
						val element = resourceSet.getEObject(issue.uriToProblem, true)
						val oldLower = resourceSet.getEObject(URI.createURI(lowerURI), true) as PropertyExpression
						val oldUpper = resourceSet.getEObject(URI.createURI(upperURI), true) as PropertyExpression
						(element as NumericRange).upperBound = oldLower;
						(element as NumericRange).lowerBound = oldUpper;
					}
					
				})
				context.xtextDocument.replace(offSet, changeFrom.length, changeTo)
			}
		})
	}

	/**
	 * QuickFix by making a connection bidirectional
	 */
	@Fix(Aadl2JavaValidator.MAKE_CONNECTION_BIDIRECTIONAL)
	def void fixMakeConnectionBiderctional(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Make connection bidirectional", null, null,
			new ISemanticModification() {
				override void apply(EObject element, IModificationContext context) throws Exception {
					val connection = element as Connection
					connection.bidirectional = true;	
				}
			}
		);
	}

	/**
	 * QuickFix for adding a removing unused propertySet in packageSection with clause
	 * The issue data array is expected to have two elements:
	 *
	 * issue.getData()[0]: The name of the package or property set
	 * issue.getData()[1]: The URI String of the referenced AadlPackage or PropertySet.
	 */
	@Fix(Aadl2JavaValidator.WITH_NOT_USED)
	def void fixWithNotUsed(Issue issue, IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Remove '" + issue.getData.get(0) + "' from the with clause", null, null,
				new ISemanticModification() {
					override void apply(EObject element, IModificationContext context) throws Exception {
						val ResourceSet resourceSet = element.eResource().getResourceSet()
						val importedModelUnit = resourceSet.getEObject(	URI.createURI(issue.getData.get(1)), true) as ModelUnit
						switch element{
							PackageSection : element.importedUnits.remove(importedModelUnit)
							PropertySet : {
								element.importedUnits.remove(importedModelUnit)
							}
						}
					}
				});
	}

}