package org.osate.xtext.aadl2.errormodel.scoping

import com.google.inject.Inject
import java.util.Optional
import java.util.stream.Collectors
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.resource.EObjectDescription
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.osate.aadl2.BasicPropertyAssociation
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ContainmentPathElement
import org.osate.aadl2.DirectionType
import org.osate.aadl2.Element
import org.osate.aadl2.EnumerationType
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.PropertyType
import org.osate.aadl2.RecordType
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.TriggerPort
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2Path
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PathElement
import org.osate.xtext.aadl2.errormodel.errorModel.EMV2PropertyAssociation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedErrorEventOrPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet
import org.osate.xtext.aadl2.errormodel.serializer.ErrorModelCrossReferenceSerializer
import org.osate.xtext.aadl2.errormodel.util.EMV2Util
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.getBasePropertyType
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.*
import static extension org.osate.xtext.aadl2.errormodel.util.ErrorModelUtil.getAllErrorTypes
import static extension org.osate.xtext.aadl2.errormodel.util.ErrorModelUtil.getAllTypesets

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 * 
 */
class ErrorModelScopeProvider extends PropertiesScopeProvider {
	@Inject
	IQualifiedNameConverter qualifiedNameConverter
	
	override scope_NamedValue_namedValue(Element context, EReference reference) {
		var scope = delegateGetScope(context, reference)
		var PropertyType propertyType = null;
		//Inner value of a record value.
		propertyType = context.getContainerOfType(BasicPropertyAssociation)?.property?.propertyType
		if (propertyType == null) {
			//Value of an association.
			propertyType = context.getContainerOfType(EMV2PropertyAssociation)?.property?.propertyType
		}
		propertyType = propertyType.basePropertyType
		if (propertyType instanceof EnumerationType) {
			scope = propertyType.ownedLiterals.scopeFor(scope)
		}
		scope
	}
	
	override scope_BasicPropertyAssociation_property(Element context, EReference reference) {
		var parent = switch context {
			BasicPropertyAssociation case context.property.propertyType == null:
				context.owner
			default:
				context
		}
		while (parent != null && !(parent instanceof BasicPropertyAssociation || parent instanceof EMV2PropertyAssociation)) {
			parent = parent.owner
		}
		var PropertyType propertyType = null
		switch parent {
			BasicPropertyAssociation:
				propertyType = parent.property?.propertyType
			EMV2PropertyAssociation:
				propertyType = parent.property?.propertyType
		}
		propertyType = propertyType.basePropertyType
		if (propertyType instanceof RecordType) {
			propertyType.ownedFields.scopeFor
		} else {
			IScope::NULLSCOPE
		}
	}
	
	//TODO Implement test case after talking with Peter
	def scope_ContainmentPathElement_namedElement(ContainmentPathElement context, EReference reference) {
		switch parent : context.eContainer {
			EMV2Path: parent.getContainerOfType(ComponentImplementation)?.allSubcomponents?.filterRefined?.scopeFor ?: IScope.NULLSCOPE
			//TODO: This could change after talking with Peter about reference values
			ContainmentPathElement: switch previous : parent.namedElement {
				Subcomponent case !previous.eIsProxy: switch classifier : previous.allClassifier {
					ComponentImplementation: classifier.allSubcomponents.filterRefined.scopeFor
					default: IScope.NULLSCOPE
				}
				default: IScope.NULLSCOPE
			}
			//TODO: Ask Peter about reference values
			default: IScope.NULLSCOPE
		}
	}
	
	def scope_ErrorModelLibrary(EObject context, EReference reference) {
		scopeWithoutEMV2Prefix(context, reference)
	}

	def scope_TypeMappingSet(EObject context, EReference reference) {
		scopeWithoutEMV2Prefix(context, reference)
	}

	def scope_ErrorModelSubclause_useBehavior(EObject context, EReference reference) {
		scopeWithoutEMV2Prefix(context, reference)
	}

	def scope_TypeTransformationSet(EObject context, EReference reference) {
		scopeWithoutEMV2Prefix(context, reference)
	}
	
	def scope_EMV2PathElement_namedElement(EMV2PathElement context, EReference reference) {
		switch parent : context.eContainer {
			QualifiedErrorEventOrPropagation: {
				val topConditionExpression = parent.allContainers.filter(ConditionExpression).last
				switch parentOfCondition : topConditionExpression.eContainer {
					ErrorBehaviorTransition: switch parentOfTransition : parentOfCondition.eContainer {
						ErrorBehaviorStateMachine: parentOfTransition.events.scopeFor
						//ErrorModelSubclause
						default: IScope.NULLSCOPE
					}
					//OutgoingPropagationCondition
					//ErrorDetection
					default: IScope.NULLSCOPE
				}
			}
			EMV2Path: {
				val parentOfAssociation = parent.eContainer.eContainer
				switch parentOfAssociation {
					ErrorModelLibrary: (parentOfAssociation.allErrorTypes + parentOfAssociation.allTypesets).scopeFor
					ErrorBehaviorStateMachine: (parentOfAssociation.events + parentOfAssociation.states + parentOfAssociation.transitions).scopeFor
					//ErrorModelSubclause; parser rule: EMV2PropertyAssociation
					default: IScope.NULLSCOPE
				}
			}
			default: IScope.NULLSCOPE
		}
	}
	
	def private static getAllContainers(EObject object) {
		val containers = newArrayList
		for (var current = object.eContainer; current != null; current = current.eContainer) {
			containers += current
		}
		containers
	}

	def scope_ErrorType(ErrorModelLibrary context, EReference reference) {
		scopeForErrorTypes(context.useTypes, Optional.of(context), [allErrorTypes])
	}

	def scope_TypeSet_aliasedType(ErrorModelLibrary context, EReference reference) {
		scopeForErrorTypes(context.useTypes, Optional.of(context), [allTypesets])
	}

	def scope_TypeToken_type(ErrorModelLibrary context, EReference reference) {
		scopeForErrorTypes(context.useTypes, Optional.of(context), [allErrorTypes + allTypesets])
	}

	def scope_TypeToken_type(ErrorBehaviorStateMachine context, EReference reference) {
		scopeForErrorTypes(context.useTypes, Optional.empty, [allErrorTypes + allTypesets])
	}

	def scope_TypeToken_type(TypeMappingSet context, EReference reference) {
		scopeForErrorTypes(context.useTypes, Optional.empty, [allErrorTypes + allTypesets])
	}

	def scope_TypeToken_type(TypeTransformationSet context, EReference reference) {
		scopeForErrorTypes(context.useTypes, Optional.empty, [allErrorTypes + allTypesets])
	}

	def scope_TypeToken_type(ErrorModelSubclause context, EReference reference) {
		scopeForErrorTypes(EMV2Util.getUseTypes(context), Optional.empty, [allErrorTypes + allTypesets])
	}

	def scope_FeatureorPPReference_featureorPP(FeatureorPPReference context, EReference reference) {
		switch parent : context.eContainer {
			ErrorPropagation: {
				val classifier = parent.getContainerOfType(Classifier)
				(classifier.getAllFeatures + classifier.allPropagationPoints + if (classifier instanceof ComponentImplementation) {
					classifier.allInternalFeatures
				} else {
					emptyList
				}).scopeFor
			}
			FeatureorPPReference: switch previous : parent.featureorPP {
				FeatureGroup: previous.featureGroupType.getAllFeatures.scopeFor
				default: IScope.NULLSCOPE
			}
		}
	}

	def scope_ErrorSource_outgoing(Classifier context, EReference reference) {
		context.scopeForErrorPropagation(DirectionType.OUT)
	}

	def scope_ErrorSource_failureModeReference(ErrorModelSubclause context, EReference reference) {
		val typesets = context.useTypes.map[allTypesets].flatten
		val behaviorStates = context.useBehavior.states ?: <ErrorBehaviorState>emptyList;
		(typesets + behaviorStates).scopeFor
	}

	def scope_ErrorSink_incoming(Classifier context, EReference reference) {
		context.scopeForErrorPropagation(DirectionType.IN)
	}

	def scope_ErrorPath_incoming(Classifier context, EReference reference) {
		context.scopeForErrorPropagation(DirectionType.IN)
	}

	def scope_ErrorPath_outgoing(Classifier context, EReference reference) {
		context.scopeForErrorPropagation(DirectionType.OUT)
	}

	def scope_QualifiedPropagationPoint_propagationPoint(QualifiedPropagationPoint context, EReference reference) {
		val lastSubcomponentClassifier = context.subcomponent.subcomponent.allClassifier
		if (lastSubcomponentClassifier != null) {
			val allSubclauses = lastSubcomponentClassifier.allContainingClassifierEMV2Subclauses
			allSubclauses.map[points].flatten.scopeFor
		} else {
			IScope.NULLSCOPE
		}
	}

	def scope_RepairEvent_eventInitiator(Classifier context, EReference reference) {
		context.allMembers.filterRefined.scopeFor
	}

	def scope_RepairEvent_eventInitiator(ErrorBehaviorStateMachine context, EReference reference) {
		IScope.NULLSCOPE
	}

	def scope_RecoverEvent_eventInitiator(Classifier context, EReference reference) {
		context.allMembers.filterRefined.scopeFor
	}

	def scope_RecoverEvent_eventInitiator(ErrorBehaviorStateMachine context, EReference reference) {
		IScope.NULLSCOPE
	}

	def scope_ErrorBehaviorState(ErrorBehaviorStateMachine context, EReference reference) {
		context.states.scopeFor
	}

	def scope_ErrorBehaviorState(Classifier context, EReference reference) {
		val stateMachine = context.allContainingClassifierEMV2Subclauses.map[useBehavior].filterNull.head
		stateMachine?.states?.scopeFor ?: IScope.NULLSCOPE
	}

	def scope_ConnectionErrorSource_connection(ComponentImplementation context, EReference reference) {
		context.allConnections.scopeFor
	}

	def scope_OutgoingPropagationCondition_outgoing(Classifier context, EReference reference) {
		context.scopeForErrorPropagation(DirectionType.OUT)
	}

	def scope_ErrorDetection_detectionReportingPort(Classifier context, EReference reference) {
		val features = context.getAllFeatures.filter(TriggerPort)
		val internalFeatures = if (context instanceof ComponentImplementation) {
				context.allInternalFeatures
			} else {
				emptySet
			}
		(features + internalFeatures).scopeFor
	}

	def scope_ErrorStateToModeMapping_mappedModes(ComponentClassifier context, EReference reference) {
		context.allModes.scopeFor
	}

	def scope_QualifiedErrorBehaviorState_state(QualifiedErrorBehaviorState context, EReference reference) {
		val subcomponentClassifier = context.subcomponent.subcomponent.allClassifier
		val stateMachine = subcomponentClassifier?.allContainingClassifierEMV2Subclauses?.map[useBehavior]?.filterNull?.
			head
		stateMachine?.states?.scopeFor ?: IScope.NULLSCOPE
	}

	def scope_SubcomponentElement_subcomponent(ComponentImplementation context, EReference reference) {
		context.allSubcomponents.scopeFor
	}

	def scope_SubcomponentElement_subcomponent(QualifiedErrorBehaviorState context, EReference reference) {
		switch subcomponentClassifier : context.subcomponent.subcomponent.allClassifier {
			ComponentImplementation: subcomponentClassifier.allSubcomponents.scopeFor
			default: IScope.NULLSCOPE
		}
	}

	def scope_SubcomponentElement_subcomponent(QualifiedPropagationPoint context, EReference reference) {
		switch subcomponentClassifier : context.subcomponent.subcomponent.allClassifier {
			ComponentImplementation: subcomponentClassifier.allSubcomponents.scopeFor
			default: IScope.NULLSCOPE
		}
	}

	def private scopeWithoutEMV2Prefix(EObject context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.map [
			val nameAsString = name.toString("::")
			if (nameAsString.startsWith(ErrorModelCrossReferenceSerializer.PREFIX)) {
				val strippedName = nameAsString.substring(ErrorModelCrossReferenceSerializer.PREFIX.length)
				EObjectDescription.create(qualifiedNameConverter.toQualifiedName(strippedName), EObjectOrProxy)
			} else {
				it
			}
		], true)
	}

	/*
	 * The general rule of this scope is that ErrorTypes must be referred to by their simple name, not a qualified name.
	 * A qualified name is only legal if it is used to disambiguate two different ErrorTypes with the same name coming
	 * from different ErrorModelLibraries in the useTypes.  In the event of a naming conflict, a reference to an ErrorTypes
	 * is qualified with the name of the appropriate library listed in the useTypes.  This may not be the same as the
	 * library which contains the ErrorTypes definition.
	 * 
	 * This probably needs to be redesigned.  It may be better to include all simple names and all qualified names in the
	 * scope and then have the validator place errors on ambiguous simple names and warnings on unnecessary qualified names.
	 */
	def private static scopeForErrorTypes(Iterable<ErrorModelLibrary> useTypes,
		Optional<ErrorModelLibrary> parentLibrary, (ErrorModelLibrary)=>Iterable<? extends ErrorTypes> elementGetter) {
		val useTypesPerLib = newHashMap(useTypes.map[libraryName -> elementGetter.apply(it).toSet])

		val contextErrorTypes = parentLibrary.map[elementGetter.apply(it).toSet]
		val partitionResult = (useTypesPerLib.values.flatten + contextErrorTypes.orElse(emptySet)).toSet.groupBy [
			name.toLowerCase
		].values.stream.collect(Collectors.partitioningBy[size == 1])

		// Add simple names to the scope for all ErrorTypes that do not have a naming conflict.
		val noConflictsDescriptions = partitionResult.get(true).flatten.map [
			EObjectDescription.create(QualifiedName.create(name), it)
		]

		val conflictsDescriptions = partitionResult.get(false).map [
			map[
				if (contextErrorTypes.present && contextErrorTypes.get.contains(it)) {
					// For ErrorTypes that are locally contained in parentLibrary or are in the extends hierarchy, they are referred to by their simple name.
					#[EObjectDescription.create(QualifiedName.create(name), it)]
				} else {
					/*
					 * For conflicting ErrorTypes that are contributed by the useTypes, they are qualified by the library names
					 * listed in the useTypes which contributes this ErrorTypes.
					 */
					useTypesPerLib.filter[libraryName, visibleErrorTypes|visibleErrorTypes.contains(it)].keySet.map [ libraryName |
						EObjectDescription.create(QualifiedName.create(libraryName, name), it)
					]
				}
			]
		].flatten.flatten

		new SimpleScope(noConflictsDescriptions + conflictsDescriptions, true)
	}

	def public static eDescriptionsForErrorPropagation(Classifier context, DirectionType requiredDirection) {
		val propagations = context.allContainingClassifierEMV2Subclauses.map[propagations].flatten.filter [
			!not && direction == requiredDirection
		]
		propagations.map[EObjectDescription.create(propagationName, it)]
	}

	def public static scopeForErrorPropagation(Classifier context, DirectionType requiredDirection) {
		val propagations = context.allContainingClassifierEMV2Subclauses.map[propagations].flatten.filter [
			!not && direction == requiredDirection
		]
		new SimpleScope(propagations.map[EObjectDescription.create(propagationName, it)])
	}

	def public static getEventandIncomingPropagationDescriptions(Classifier classifier) {
		val stateMachine = classifier?.allContainingClassifierEMV2Subclauses?.map[useBehavior]?.filterNull?.head
		val ebsmevents = stateMachine?.events
		val ebsmeventDescriptions = ebsmevents?.map[EObjectDescription.create(QualifiedName.create(name), it)] ?: emptyList
		classifier.allContainingClassifierEMV2Subclauses.map [
			val eventsDescriptions = events.map[EObjectDescription.create(QualifiedName.create(name), it)]
			val flowDescriptions = flows.map[EObjectDescription.create(QualifiedName.create(name), it)]
			val inPropagations = propagations.filter[!not && direction == DirectionType.IN]
			val propagationsDescriptions = inPropagations.map [
				EObjectDescription.create(QualifiedName.create(propagationName), it)
			]
			eventsDescriptions + flowDescriptions + propagationsDescriptions
		].flatten + ebsmeventDescriptions
	}

	def private static Iterable<IEObjectDescription> getSubcomponentPropagations(String prefix,
		ComponentClassifier classifier) {
		val propagationsDescriptions = classifier.allContainingClassifierEMV2Subclauses.map [
			val outPropagations = propagations.filter[!not && direction == DirectionType.OUT]
			outPropagations.map[EObjectDescription.create(QualifiedName.create(prefix + propagationName), it)]
		].flatten

		val nextSubcomponentLevel = if (classifier instanceof ComponentImplementation) {
				val validSubcomponents = classifier.allSubcomponents.filter[allClassifier != null]
				validSubcomponents.map[getSubcomponentPropagations(prefix + name + ".", allClassifier)].flatten
			} else {
				emptySet
			}

		propagationsDescriptions + nextSubcomponentLevel
	}
}