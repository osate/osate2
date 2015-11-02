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
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.DirectionType
import org.osate.aadl2.Element
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.Port
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference
import org.osate.xtext.aadl2.errormodel.errorModel.OutgoingPropagationCondition
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet
import org.osate.xtext.aadl2.errormodel.serializer.ErrorModelCrossReferenceSerializer
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getAllContainingClassifierEMV2Subclauses
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getAllErrorFlows
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getAllPropagationPoints
import static extension org.osate.xtext.aadl2.errormodel.util.EMV2Util.getFeatureorPPRefs
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

	/*
	 * TODO: FINISH THIS!
	 * This method should be much more complicated.  It should mimic the behavior found in the method
	 * EMLinkingService.getLinkedObjects where the requiredType is NamedElement and the context is a
	 * ContainmentPathElement.  Right now, this method only includes ErrorFlows in the scope.  I did this just so that
	 * I could serialize models that contain properties applied to ErrorSources.
	 */
	override scope_ContainmentPathElement_namedElement(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allErrorFlows.scopeFor
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
		scopeForErrorTypes(context.useTypes, Optional.empty, [allErrorTypes + allTypesets])
	}
	
	def scope_FeatureorPPReference_featureorPP(Classifier context, EReference reference) {
		(context.getAllFeatures + context.allPropagationPoints + if (context instanceof ComponentImplementation) {
			context.allInternalFeatures
		} else {
			emptyList
		}).scopeFor
	}
	
	def scope_FeatureorPPReference_featureorPP(FeatureorPPReference context, EReference reference) {
		switch fg : context.featureorPP {
			FeatureGroup: fg.featureGroupType.getAllFeatures.scopeFor
			default: IScope.NULLSCOPE
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
		val lastSubcomponentClassifier = context.subcomponents.last.subcomponent.allClassifier
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
	
	def scope_ErrorBehaviorState(ErrorModelSubclause context, EReference reference) {
		context.useBehavior?.states?.scopeFor ?: IScope.NULLSCOPE
	}
	
	def scope_ConnectionErrorSource_connection(ComponentImplementation context, EReference reference) {
		context.allConnections.scopeFor
	}
	
	def scope_ConditionElement_incoming(ErrorBehaviorTransition context, EReference reference) {
		val stateMachine = context.getContainerOfType(ErrorBehaviorStateMachine)
		if (stateMachine != null) {
			stateMachine.events.scopeFor
		} else {
			scopeForEventOrPropagation(context.getContainerOfType(Classifier), true)
		}
	}
	
	def scope_ConditionElement_incoming(ErrorDetection context, EReference reference) {
		scopeForEventOrPropagation(context.getContainerOfType(Classifier), true)
	}
	
	def scope_ConditionElement_incoming(OutgoingPropagationCondition context, EReference reference) {
		scopeForEventOrPropagation(context.getContainerOfType(Classifier), false)
	}
	
	def scope_OutgoingPropagationCondition_outgoing(Classifier context, EReference reference) {
		context.scopeForErrorPropagation(DirectionType.OUT)
	}
	
	def scope_ErrorDetection_detectionReportingPort(Classifier context, EReference reference) {
		context.getAllFeatures.filter(Port).scopeFor
	}
	
	def scope_ErrorStateToModeMapping_mappedModes(ComponentClassifier context, EReference reference) {
		context.allModes.scopeFor
	}
	
	def private scopeWithoutEMV2Prefix(EObject context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.map[
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
	def private static scopeForErrorTypes(Iterable<ErrorModelLibrary> useTypes, Optional<ErrorModelLibrary> parentLibrary, (ErrorModelLibrary)=>Iterable<? extends ErrorTypes> elementGetter) {
		val useTypesPerLib = newHashMap(useTypes.map[getContainerOfType(AadlPackage).name -> elementGetter.apply(it).toSet])
		
		val contextErrorTypes = parentLibrary.map[elementGetter.apply(it).toSet]
		val partitionResult = (useTypesPerLib.values.flatten + contextErrorTypes.orElse(emptySet)).toSet.groupBy[name.toLowerCase].values.stream.collect(Collectors.partitioningBy[size == 1])
		
		//Add simple names to the scope for all ErrorTypes that do not have a naming conflict.
		val noConflictsDescriptions = partitionResult.get(true).flatten.map[EObjectDescription.create(QualifiedName.create(name), it)]
		
		val conflictsDescriptions = partitionResult.get(false).map[map[if (contextErrorTypes.present && contextErrorTypes.get.contains(it)) {
			//For ErrorTypes that are locally contained in parentLibrary or are in the extends hierarchy, they are referred to by their simple name.
			#[EObjectDescription.create(QualifiedName.create(name), it)]
		} else {
			/*
			 * For conflicting ErrorTypes that are contributed by the useTypes, they are qualified by the library names
			 * listed in the useTypes which contributes this ErrorTypes.
			 */
			useTypesPerLib.filter[libraryName, visibleErrorTypes | visibleErrorTypes.contains(it)].keySet.map[libraryName |
				EObjectDescription.create(QualifiedName.create(libraryName, name), it)
			]
		}]].flatten.flatten
		
		new SimpleScope(noConflictsDescriptions + conflictsDescriptions, true)
	}
	
	def private static scopeForErrorPropagation(Classifier context, DirectionType requiredDirection) {
		val propagations = context.allContainingClassifierEMV2Subclauses.map[propagations].flatten.filter[!not && direction == requiredDirection]
		new SimpleScope(propagations.map[EObjectDescription.create(propagationName, it)])
	}
	
	def private static getPropagationName(ErrorPropagation propagation) {
		propagation.kind ?: propagation.featureorPPRefs.join(".", [featureorPP.name])
	}
	
	def private static scopeForEventOrPropagation(Classifier classifier, boolean includeEvents) {
		val allSubclauses = classifier.allContainingClassifierEMV2Subclauses
		val localDescriptions = allSubclauses.map[
			val eventsDescriptions = if (includeEvents) {
				events.map[EObjectDescription.create(QualifiedName.create(name), it)]
			} else {
				emptySet
			}
			val inPropagations = propagations.filter[!not && direction == DirectionType.IN]
			val propagationsDescriptions = inPropagations.map[EObjectDescription.create(QualifiedName.create(propagationName), it)]
			eventsDescriptions + propagationsDescriptions
		].flatten
		val subcomponentDescriptions = if (classifier instanceof ComponentImplementation) {
			val validSubcomponents = classifier.allSubcomponents.filter[allClassifier != null]
			validSubcomponents.map[getSubcomponentPropagations(name + ".", allClassifier)].flatten
		} else {
			emptySet
		}
		new SimpleScope(localDescriptions + subcomponentDescriptions, true)
	}
	
	def private static Iterable<IEObjectDescription> getSubcomponentPropagations(String prefix, ComponentClassifier classifier) {
		val propagationsDescriptions = classifier.allContainingClassifierEMV2Subclauses.map[
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