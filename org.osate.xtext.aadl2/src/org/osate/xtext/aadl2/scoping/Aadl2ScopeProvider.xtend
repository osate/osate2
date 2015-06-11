/*
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
package org.osate.xtext.aadl2.scoping;

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.naming.QualifiedName
import org.eclipse.xtext.scoping.IScope
import org.eclipse.xtext.scoping.impl.SimpleScope
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractSubcomponentType
import org.osate.aadl2.AccessType
import org.osate.aadl2.BehavioredImplementation
import org.osate.aadl2.BusSubcomponentType
import org.osate.aadl2.CallContext
import org.osate.aadl2.CalledSubprogram
import org.osate.aadl2.Classifier
import org.osate.aadl2.ComponentClassifier
import org.osate.aadl2.ComponentImplementation
import org.osate.aadl2.ComponentImplementationReference
import org.osate.aadl2.ComponentPrototype
import org.osate.aadl2.ComponentPrototypeActual
import org.osate.aadl2.ComponentType
import org.osate.aadl2.ConnectedElement
import org.osate.aadl2.Connection
import org.osate.aadl2.ConnectionEnd
import org.osate.aadl2.Context
import org.osate.aadl2.DataAccess
import org.osate.aadl2.DataSubcomponentType
import org.osate.aadl2.DeviceSubcomponentType
import org.osate.aadl2.Element
import org.osate.aadl2.EndToEndFlow
import org.osate.aadl2.EndToEndFlowSegment
import org.osate.aadl2.Feature
import org.osate.aadl2.FeatureGroup
import org.osate.aadl2.FeatureGroupPrototype
import org.osate.aadl2.FeatureGroupPrototypeActual
import org.osate.aadl2.FeatureGroupType
import org.osate.aadl2.FeaturePrototype
import org.osate.aadl2.FeatureType
import org.osate.aadl2.FlowElement
import org.osate.aadl2.FlowEnd
import org.osate.aadl2.FlowImplementation
import org.osate.aadl2.FlowSegment
import org.osate.aadl2.FlowSpecification
import org.osate.aadl2.MemorySubcomponentType
import org.osate.aadl2.ModeTransition
import org.osate.aadl2.ModeTransitionTrigger
import org.osate.aadl2.PackageSection
import org.osate.aadl2.PrivatePackageSection
import org.osate.aadl2.ProcessSubcomponentType
import org.osate.aadl2.ProcessorSubcomponentType
import org.osate.aadl2.Subcomponent
import org.osate.aadl2.SubcomponentType
import org.osate.aadl2.SubprogramAccess
import org.osate.aadl2.SubprogramCall
import org.osate.aadl2.SubprogramGroupAccess
import org.osate.aadl2.SubprogramGroupSubcomponent
import org.osate.aadl2.SubprogramGroupSubcomponentType
import org.osate.aadl2.SubprogramSubcomponent
import org.osate.aadl2.SubprogramSubcomponentType
import org.osate.aadl2.SystemSubcomponentType
import org.osate.aadl2.ThreadGroupSubcomponentType
import org.osate.aadl2.ThreadSubcomponentType
import org.osate.aadl2.TriggerPort
import org.osate.aadl2.UnitsType
import org.osate.aadl2.VirtualBusSubcomponentType
import org.osate.aadl2.VirtualProcessorSubcomponentType
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider

import static extension org.eclipse.xtext.EcoreUtil2.getContainerOfType

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class Aadl2ScopeProvider extends PropertiesScopeProvider {
	//Reference is from TypeExtension in Aadl2.xtext
	def scope_TypeExtension_extended(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from ImplementationExtension and ComponentImplementationReference in Aadl2.xtext
	def scope_ComponentImplementation(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from GroupExtension in Aadl2.xtext
	def scope_GroupExtension_extended(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from FeatureGroupPrototype in Aadl2.xtext
	def scope_FeatureGroupPrototype_constrainingFeatureGroupType(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from FeatureGroupType in Aadl2.xtext
	def scope_FeatureGroupType_inverse(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from Realization in Aadl2.xtext
	def scope_Realization_implemented(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from SubprogramCall in Aadl2.xtext
	def scope_SubprogramCall_context(Element context, EReference reference) {
		var scope = scope_Classifier(context, reference)
		context.getContainerOfType(BehavioredImplementation)?.members?.filter(CallContext)?.filterRefined?.scopeFor(scope) ?: scope
	}
	
	//Reference is from SubprogramCall in Aadl2.xtext
	def scope_SubprogramCall_calledSubprogram(Element context, EReference reference) {
		var scope = scope_Classifier(context, reference)
		val callContext = context.getContainerOfType(SubprogramCall)?.context
		if (callContext == null) {
			//No call context.  Add prototypes, subprogram accesses, and subprogram subcomponents from the classifier to the scope.
			scope = context.getContainerOfType(Classifier).members.filter(CalledSubprogram).filterRefined.scopeFor(scope)
		} else {
			scope = IScope::NULLSCOPE
			var Classifier callContextNamespace
			switch (callContext) {
				ComponentType: {
					//Reference is in the form of "component_type.implementation" or "package::component_type.implementation".  Add all implementations of the type from the type's package to the scope.
					val packageClassifiers = new ArrayList(callContext.getContainerOfType(AadlPackage).publicSection.ownedClassifiers)
					val packageSectionForComponentType = callContext.getContainerOfType(PackageSection)
					if (packageSectionForComponentType instanceof PrivatePackageSection && packageSectionForComponentType == context.getContainerOfType(PrivatePackageSection)) {
						packageClassifiers.addAll(packageSectionForComponentType.ownedClassifiers)
					}
					scope = packageClassifiers.filter(CalledSubprogram).filter(ComponentImplementation).filter[type == callContext].scopeFor(
						[QualifiedName::create(name.substring(name.lastIndexOf('.') + 1))], IScope::NULLSCOPE
					)
					callContextNamespace = callContext
				}
				SubprogramGroupSubcomponent:
					callContextNamespace = callContext.componentType
				SubprogramGroupAccess:
					if (callContext.kind == AccessType::REQUIRES && callContext.subprogramGroupFeatureClassifier instanceof Classifier) {
						callContextNamespace = callContext.subprogramGroupFeatureClassifier as Classifier
					}
				FeatureGroup:
					callContextNamespace = callContext.featureGroupType
			}
			scope = callContextNamespace?.members?.filter(CalledSubprogram)?.filterRefined?.scopeFor(scope) ?: scope
		}
		scope
	}
	
	//Reference is from Prototype in Aadl2.xtext
	def scope_ComponentPrototype_constrainingClassifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	/*
	 * Reference is from AbstractPrototype, BusPrototype, DataPrototype, DevicePrototype, MemoryPrototype,
	 * ProcessPrototype, ProcessorPrototype, SubprogramPrototype, SubprogramGroupPrototype, SystemPrototype,
	 * ThreadPrototype, ThreadGroupPrototype, VirtualBusPrototype, VirtualProcessorPrototype,
	 * FeatureGroupPrototype and FeaturePrototype in Aadl2.xtext
	 */
	def scope_Prototype_refined(Classifier context, EReference reference) {
		context.extended?.allPrototypes?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from FeaturePrototype in Aadl2.xtext
	def scope_FeaturePrototype_constrainingClassifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in Aadl2.xtext
	def scope_PrototypeBinding_formal(ComponentPrototypeActual context, EReference reference) {
		val subcomponentType = context.subcomponentType
		if (subcomponentType instanceof ComponentClassifier) {
			subcomponentType.allPrototypes.filterRefined.scopeFor
		} else {
			IScope::NULLSCOPE
		}
	}
	
	//Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in Aadl2.xtext
	def scope_PrototypeBinding_formal(FeatureGroupPrototypeActual context, EReference reference) {
		val featureType = context.featureType
		if (featureType instanceof FeatureGroupType) {
			featureType.allPrototypes.filterRefined.scopeFor
		} else {
			IScope::NULLSCOPE
		}
	}
	
	//Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in Aadl2.xtext
	def scope_PrototypeBinding_formal(ComponentImplementationReference context, EReference reference) {
		context.implementation?.allPrototypes?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in Aadl2.xtext
	def scope_PrototypeBinding_formal(Subcomponent context, EReference reference) {
		context.allClassifier?.allPrototypes?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in Aadl2.xtext
	def scope_PrototypeBinding_formal(Classifier context, EReference reference) {
		context.generals.map[allPrototypes].flatten.toSet.filterRefined.scopeFor
	}
	
	//Reference is from FeatureGroupPrototypeActual in Aadl2.xtext
	def scope_FeatureGroupPrototypeActual_featureType(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(FeatureGroupPrototype).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from PortSpecification in Aadl2.xtext
	def scope_PortSpecification_classifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from AccessSpecification in Aadl2.xtext
	def scope_AccessSpecification_classifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from FeaturePrototypeReference in Aadl2.xtext
	def scope_FeaturePrototypeReference_prototype(Classifier context, EReference reference) {
		context.allPrototypes.filter(FeaturePrototype).filterRefined.scopeFor
	}
	
	//Reference is from ComponentReference in Aadl2.xtext
	def scope_ComponentPrototypeActual_subcomponentType(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(SubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	/*
	 * Reference is from AbstractSubcomponent, SystemSubcomponent, ProcessSubcomponent, ThreadGroupSubcomponent,
	 * ThreadSubcomponent, SubprogramSubcomponent, SubprogramGroupSubcomponent, ProcessorSubcomponent,
	 * VirtualProcessorSubcomponent, DeviceSubcomponent, MemorySubcomponent, BusSubcomponent,
	 * VirtualBusSubcomponent, and DataSubcomponent in Aadl2.xtext
	 */
	def scope_Subcomponent_refined(ComponentImplementation context, EReference reference) {
		context.extended?.allSubcomponents?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from AbstractSubcomponent in Aadl2.xtext
	def scope_AbstractSubcomponent_abstractSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(AbstractSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from SystemSubcomponent in Aadl2.xtext
	def scope_SystemSubcomponent_systemSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(SystemSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from ProcessSubcomponent in Aadl2.xtext
	def scope_ProcessSubcomponent_processSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(ProcessSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from ThreadGroupSubcomponent in Aadl2.xtext
	def scope_ThreadGroupSubcomponent_threadGroupSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(ThreadGroupSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from ThreadSubcomponent in Aadl2.xtext
	def scope_ThreadSubcomponent_threadSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(ThreadSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from SubprogramSubcomponent in Aadl2.xtext
	def scope_SubprogramSubcomponent_subprogramSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(SubprogramSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from SubprogramGroupSubcomponent in Aadl2.xtext
	def scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(SubprogramGroupSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from ProcessorSubcomponent in Aadl2.xtext
	def scope_ProcessorSubcomponent_processorSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(ProcessorSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from VirtualProcessorSubcomponent in Aadl2.xtext
	def scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(VirtualProcessorSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from DeviceSubcomponent in Aadl2.xtext
	def scope_DeviceSubcomponent_deviceSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(DeviceSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from MemorySubcomponent in Aadl2.xtext
	def scope_MemorySubcomponent_memorySubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(MemorySubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from BusSubcomponent in Aadl2.xtext
	def scope_BusSubcomponent_busSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(BusSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from VirtualBusSubcomponent in Aadl2.xtext
	def scope_VirtualBusSubcomponent_virtualBusSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(VirtualBusSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from DataSubcomponent in Aadl2.xtext
	def scope_DataSubcomponent_dataSubcomponentType(Element context, EReference reference) {
		context.getContainerOfType(ComponentImplementation).allPrototypes.filter(DataSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from DataPort, EventDataPort, EventPort, FeatureGroup, Parameter, SubprogramAccess, SubprogramGroupAccess, BusAccess, DataAccess, and AbstractFeature in Aadl2.xtext
	def scope_Feature_refined(Classifier context, EReference reference) {
		context.extended?.getAllFeatures()?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from DataPort in Aadl2.xtext
	def scope_DataPort_dataFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(DataSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from EventDataPort in Aadl2.xtext
	def scope_EventDataPort_dataFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(DataSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from FeatureGroup in Aadl2.xtext
	def scope_FeatureGroup_featureType(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(FeatureType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from Parameter in Aadl2.xtext
	def scope_Parameter_dataFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(DataSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from SubprogramAccess in Aadl2.xtext
	def scope_SubprogramAccess_subprogramFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(SubprogramSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from SubprogramGroupAccess in Aadl2.xtext
	def scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(SubprogramGroupSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from BusAccess in Aadl2.xtext
	def scope_BusAccess_busFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(BusSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from DataAccess in Aadl2.xtext
	def scope_DataAccess_dataFeatureClassifier(Element context, EReference reference) {
		context.getContainerOfType(Classifier).allPrototypes.filter(DataSubcomponentType).filterRefined.scopeFor(scope_Classifier(context, reference))
	}
	
	//Reference is from AbstractFeature in Aadl2.xtext
	def scope_AbstractFeature_featurePrototype(Classifier context, EReference reference) {
		context.allPrototypes.filter(FeaturePrototype).filterRefined.scopeFor
	}
	
	//Reference is from EventDataSource in Aadl2.xtext
	def scope_EventDataSource_dataClassifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from PortProxy in Aadl2.xtext
	def scope_PortProxy_dataClassifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from SubprogramProxy in Aadl2.xtext
	def scope_SubprogramProxy_subprogramClassifier(Element context, EReference reference) {
		scope_Classifier(context, reference)
	}
	
	//Reference is from ConnectedElement in Aadl2.xtext
	def scope_ConnectedElement_context(ComponentImplementation context, EReference reference) {
		context.allContexts.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from ConnectedElement in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ConnectedElement.  When the
	 * ConnectedElement is a single identifier, e.g. "port1", then the passed context is a Connection.  In this case, we know that the ConnectedElement's
	 * Context is null even though we can't access it and check it here.  In all other cases, the passed context is a ConnectedElement, thus calling the other
	 * scope method.
	 */
	def scope_ConnectedElement_connectionEnd(Connection context, EReference reference) {
		context.getContainerOfType(Classifier).allConnectionEnds.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from ConnectedElement, ProcessorPort, ProcessorSubprogram, and InternalEvent in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ConnectedElement.  When the
	 * ConnectedElement is a qualified reference, e.g. "subcomponent1.port1" or "processor.portproxy1", then the passed context is a ConnectedElement and we
	 * can access and check the ConnectedElement's Context object.
	 */
	def scope_ConnectedElement_connectionEnd(ConnectedElement context, EReference reference) {
		context.context?.scopeForElementsOfContext(context.getContainerOfType(Classifier), [allConnectionEnds.filterRefined]) ?: scope_ConnectedElement_connectionEnd(context.owner as Connection, reference)
	}
	
	//Reference is from PortConnection, AccessConnection, FeatureGroupConnection, FeatureConnection, and ParameterConnection in Aadl2.xtext
	def scope_Connection_refined(ComponentImplementation context, EReference reference) {
		context.extended?.allConnections?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	/*
	 * Reference is from PortConnection, AccessConnection, FeatureGroupConnection, FeatureConnection, ParameterConnection, FlowSpecification,
	 * FlowImplementation, and EndToEndFlow in Aadl2.xtext
	 */
	def scope_ModalPath_inModeOrTransition(ComponentClassifier context, EReference reference) {
		(context.allModes + context.allModeTransitions).scopeFor
	}
	
	//Reference is from FlowEnd in Aadl2.xtext
	def scope_FlowEnd_context(ComponentType context, EReference reference) {
		context.allContexts.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from FlowEnd in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowEnd.  When the FlowEnd
	 * is a single identifier, e.g. "port1", then the passed context is a FlowSpecification.  In this case, we know that the FlowEnd's Context is null even
	 * though we can't access it and check it here.  When the FlowEnd is a qualified reference, e.g. "featuregroup1.port1", then the passed context is a
	 * FlowEnd, thus calling the other scope method.
	 */
	def scope_FlowEnd_feature(FlowSpecification context, EReference reference) {
		context.getContainerOfType(Classifier).getAllFeatures().filterRefined.scopeFor
	}
	
	/*
	 * Reference is from FlowEnd in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowEnd.  When the FlowEnd
	 * is a qualified reference, e.g. "featuregroup1.port1", then the passed context is a FlowEnd and we can access and check the FlowEnd's Context object.
	 */
	def scope_FlowEnd_feature(FlowEnd context, EReference reference) {
		context.context?.scopeForElementsOfContext(context.getContainerOfType(Classifier), [getAllFeatures().filterRefined]) ?: scope_FlowEnd_feature(context.owner as FlowSpecification, reference)
	}
	
	//Reference is from FlowSpecRefinement in Aadl2.xtext
	def scope_FlowSpecification_refined(ComponentType context, EReference reference) {
		context.extended?.allFlowSpecifications?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from FlowSourceImpl, FlowSinkImpl, and FlowPathImpl in Aadl2.xtext
	def scope_FlowImplementation_specification(ComponentImplementation context, EReference reference) {
		context.type?.allFlowSpecifications?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from EndToEndFlow in Aadl2.xtext
	def scope_EndToEndFlow_refined(ComponentImplementation context, EReference reference) {
		context.extended?.allEndToEndFlows?.filterRefined?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from SubcomponentFlow in Aadl2.xtext
	def scope_FlowSegment_context(ComponentImplementation context, EReference reference) {
		context.allContexts.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from SubcomponentFlow and ConnectionFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowSegment.  When the
	 * FlowSegment is a single identifier, e.g. "conn1", then the passed context is a FlowImplementation.  In this case, we know that the FlowSegment's Context
	 * is null even though we can't access it and check it here.  When the FlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the
	 * passed context is a FlowSegment, thus calling the other scope method.
	 */
	def scope_FlowSegment_flowElement(FlowImplementation context, EReference reference) {
		context.getContainerOfType(Classifier).allFlowElements.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from SubcomponentFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the FlowSegment.  When the
	 * FlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the passed context is a FlowSegment and we can access and check the
	 * FlowSegment's Context object.
	 */
	def scope_FlowSegment_flowElement(FlowSegment context, EReference reference) {
		context.context?.scopeForElementsOfContext(context.getContainerOfType(Classifier), [allFlowElements.filterRefined]) ?: scope_FlowSegment_flowElement(context.owner as FlowImplementation, reference)
	}
	
	//Reference is from ETESubcomponentFlow in Aadl2.xtext
	def scope_EndToEndFlowSegment_context(ComponentImplementation context, EReference reference) {
		context.allContexts.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from ETESubcomponentFlow and ETEConnectionFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the EndToEndFlowSegment.  When
	 * the EndToEndFlowSegment is a single identifier, e.g. "conn1", then the passed context is an EndToEndFlow.  In this case, we know that the
	 * EndToEndFlowSegment's Context is null even though we can't access it and check it here.  When the EndToEndFlowSegment is a qualified reference, e.g.
	 * "subcomponent1.flowpath1", then the passed context is an EndToEndFlowSegment, thus calling the other scope method.
	 */
	def scope_EndToEndFlowSegment_flowElement(EndToEndFlow context, EReference reference) {
		context.getContainerOfType(Classifier).allEndToEndFlowElements.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from ETESubcomponentFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the EndToEndFlowSegment.  When
	 * the EndToEndFlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the passed context is an EndToEndFlowSegment and we can access
	 * and check the EndToEndFlowSegment's Context object.
	 */
	def scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment context, EReference reference) {
		context.context?.scopeForElementsOfContext(context.getContainerOfType(Classifier), [allEndToEndFlowElements.filterRefined]) ?:
			scope_EndToEndFlowSegment_flowElement(context.owner as EndToEndFlow, reference)
	}
	
	//Reference is from ModeTransition in Aadl2.xtext
	def scope_ModeTransition_source(ComponentClassifier context, EReference reference) {
		context.allModes.scopeFor
	}
	
	//Reference is from ModeTransition in Aadl2.xtext
	def scope_ModeTransition_destination(ComponentClassifier context, EReference reference) {
		context.allModes.scopeFor
	}
	
	//Reference is from Trigger in Aadl2.xtext
	def scope_ModeTransitionTrigger_context(ComponentClassifier context, EReference reference) {
		context.allContexts.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from Trigger in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ModeTransitionTrigger.  When
	 * the ModeTransitionTrigger is a single identifier, e.g. "eventport1", then the passed context is a ModeTransition.  In this case, we know that the
	 * ModeTransitionTrigger's Context is null even though we can't access it and check it here.  When the ModeTransitionTrigger is a qualified reference, e.g.
	 * "featuregroup1.eventport1", then the passed context is a ModeTransitionTrigger, thus calling the other scope method.
	 */
	def scope_ModeTransitionTrigger_triggerPort(ModeTransition context, EReference reference) {
		context.getContainerOfType(Classifier).allTriggerPorts.filterRefined.scopeFor
	}
	
	/*
	 * Reference is from Trigger in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the form of the ModeTransitionTrigger.  When
	 * the ModeTransitionTrigger is a qualified reference, e.g. "featuregroup1.eventport1", then the passed context is a ModeTransitionTrigger and we can
	 * access and check the ModeTransitionTrigger's Context object.
	 */
	def scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger context, EReference reference) {
		context.context?.scopeForElementsOfContext(context.getContainerOfType(Classifier), [allTriggerPorts.filterRefined]) ?:
			scope_ModeTransitionTrigger_triggerPort(context.owner as ModeTransition, reference)
	}
	
	//Reference is from ModeRef in Aadl2.xtext
	def scope_ModeBinding_parentMode(ComponentImplementation context, EReference reference) {
		context.allModes.scopeFor
	}
	
	//Reference is from ModeRef in Aadl2.xtext
	def scope_ModeBinding_derivedMode(Subcomponent context, EReference reference) {
		switch subcomponentType : context.allSubcomponentType {
			ComponentClassifier:
				subcomponentType
			ComponentPrototype:
				subcomponentType.findClassifierForComponentPrototype(context.getContainerOfType(Classifier))
		}?.allModes?.scopeFor ?: IScope::NULLSCOPE
	}
	
	//Reference is from UnitLiteralConversion in Aadl2.xtext
	def scope_UnitLiteral_baseUnit(UnitsType context, EReference reference) {
		context.ownedLiterals.scopeFor
	}
	
	//Reference is from RealType, UnnamedRealType, IntegerType, and UnnamedIntegerType in Aadl2.xtext
	def scope_NumberType_referencedUnitsType(Element context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.filter[name == qualifiedName || AadlUtil::isPredeclaredPropertySet(qualifiedName.firstSegment)], true)
	}
	
	//Reference is from RangeType and UnnamedRangeType in Aadl2.xtext
	def scope_RangeType_numberType(Element context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.filter[name == qualifiedName || AadlUtil::isPredeclaredPropertySet(qualifiedName.firstSegment)], true)
	}
	
	//Reference is from RecordField in Aadl2.xtext
	def scope_BasicProperty_referencedPropertyType(Element context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.filter[name == qualifiedName || AadlUtil::isPredeclaredPropertySet(qualifiedName.firstSegment)], true)
	}
	
	//Reference is from ListType in Aadl2.xtext
	def scope_ListType_referencedElementType(Element context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.filter[name == qualifiedName || AadlUtil::isPredeclaredPropertySet(qualifiedName.firstSegment)], true)
	}
	
	//Reference is from PropertyConstant in Aadl2.xtext
	def scope_PropertyConstant_referencedPropertyType(Element context, EReference reference) {
		new SimpleScope(delegateGetScope(context, reference).allElements.filter[name == qualifiedName || AadlUtil::isPredeclaredPropertySet(qualifiedName.firstSegment)], true)
	}
	
	def private static allPrototypes(Classifier classifier) {
		switch classifier {
			ComponentClassifier:
				classifier.allPrototypes
			FeatureGroupType:
				classifier.allPrototypes
		}
	}
	
	def private static allContexts(ComponentClassifier classifier) {
		val validElements = newArrayList
		validElements.addAll(classifier.getAllFeatures().filter(Context))
		if (classifier instanceof ComponentImplementation) {
			validElements.addAll(classifier.allSubcomponents)
			if (classifier instanceof BehavioredImplementation) {
				validElements.addAll(classifier.allSubprogramCalls)
			}
		}
		validElements
	}
	
	def private static allConnectionEnds(Classifier classifier) {
		val connectionEnds = newArrayList
		connectionEnds.addAll(classifier.getAllFeatures())
		if (classifier instanceof ComponentImplementation) {
			connectionEnds.addAll(classifier.allSubcomponents.filter(ConnectionEnd))
			connectionEnds.addAll(classifier.allSubprogramProxies)
			connectionEnds.addAll(classifier.allPortProxies)
			connectionEnds.addAll(classifier.allInternalFeatures)
		}
		connectionEnds
	}
	
	def private static allFlowElements(Classifier classifier) {
		val ArrayList<FlowElement> flowElements = newArrayList
		flowElements.addAll(classifier.getAllFeatures().filter(DataAccess))
		switch classifier {
			ComponentType:
				flowElements.addAll(classifier.allFlowSpecifications)
			ComponentImplementation: {
				flowElements.addAll(classifier.type.allFlowSpecifications)
				flowElements.addAll(classifier.allConnections)
				flowElements.addAll(classifier.allSubcomponents)
			}
		}
		flowElements
	}
	
	def private static allEndToEndFlowElements(Classifier classifier) {
		val flowElements = newArrayList
		flowElements.addAll(classifier.allFlowElements)
		if (classifier instanceof ComponentImplementation) {
			flowElements.addAll(classifier.allEndToEndFlows)
		}
		flowElements
	}
	
	def private static allTriggerPorts(Classifier classifier) {
		val triggerPorts = newArrayList
		triggerPorts.addAll(classifier.getAllFeatures().filter(TriggerPort))
		if (classifier instanceof ComponentImplementation) {
			triggerPorts.addAll(classifier.allInternalFeatures)
			triggerPorts.addAll(classifier.allPortProxies)
		}
		triggerPorts
	}
	
	def private static allSubprogramProxies(ComponentImplementation implementation) {
		val allSubprogramProxies = newArrayList
		for (var ComponentImplementation currentImplementation = implementation; currentImplementation != null; currentImplementation = currentImplementation.extended) {
			allSubprogramProxies.addAll(currentImplementation.ownedSubprogramProxies)
		}
		allSubprogramProxies
	}
	
	def private static allPortProxies(ComponentImplementation implementation) {
		val allPortProxies = newArrayList
		for (var ComponentImplementation currentImplementation = implementation; currentImplementation != null; currentImplementation = currentImplementation.extended) {
			allPortProxies.addAll(currentImplementation.ownedPortProxies)
		}
		allPortProxies
	}
	
	def private static allFeatureClassifier(Feature feature) {
		var refinedFeature = feature
		while (refinedFeature.featureClassifier == null && refinedFeature.refined != null) {
			refinedFeature = refinedFeature.refined
		}
		refinedFeature.featureClassifier
	}
	
	def private static findFeatureGroupTypeForFeatureGroupPrototype(FeatureGroupPrototype prototype, Classifier containingClassifier) {
		PropertiesLinkingService.findFeatureGroupTypeForFeatureGroupPrototype(containingClassifier, prototype)
	}
	
	def private static findClassifierForComponentPrototype(ComponentPrototype prototype, Classifier containingClassifier) {
		PropertiesLinkingService.findClassifierForComponentPrototype(containingClassifier, prototype)
	}
	
	def private static findClassifierForComponentPrototype(ComponentPrototype prototype, Classifier classifierPrototypeContext, Subcomponent subcomponentPrototypeContext) {
		PropertiesLinkingService.findClassifierForComponentPrototype(classifierPrototypeContext, subcomponentPrototypeContext, prototype)
	}
	
	def private static scopeForElementsOfContext(Context context, Classifier containingClassifier, extension (Classifier)=>Iterable<? extends EObject> validMemberCollector) {
		val contextClassifier = switch context {
			FeatureGroup: {
				switch featureType : context.allFeatureType {
					FeatureGroupType:
						featureType
					FeatureGroupPrototype:
						featureType.findFeatureGroupTypeForFeatureGroupPrototype(containingClassifier)
				}
			}
			Feature: {
				switch featureClassifier : context.allFeatureClassifier {
					ComponentClassifier:
						featureClassifier
					ComponentPrototype:
						featureClassifier.findClassifierForComponentPrototype(containingClassifier)
				}
			}
			Subcomponent: {
				switch subcomponentType : context.allSubcomponentType {
					ComponentClassifier:
						subcomponentType
					ComponentPrototype:
						subcomponentType.findClassifierForComponentPrototype(containingClassifier)
				}
			}
			SubprogramCall: {
				switch calledSubprogram : context.calledSubprogram {
					ComponentClassifier:
						calledSubprogram
					SubprogramSubcomponent: {
						switch subcomponentType : calledSubprogram.allSubcomponentType {
							ComponentClassifier:
								subcomponentType
							ComponentPrototype:
								subcomponentType.findClassifierForComponentPrototype(containingClassifier)
						}
					}
					SubprogramAccess: {
						switch accessFeatureClassifier : calledSubprogram.allFeatureClassifier {
							ComponentClassifier:
								accessFeatureClassifier
							ComponentPrototype: {
								switch callContext : context.context {
									ComponentType:
										accessFeatureClassifier.findClassifierForComponentPrototype(callContext)
									FeatureGroup: {
										val prototypeContext = switch callContextFeatureType : callContext.allFeatureType {
											FeatureGroupType:
												callContextFeatureType
											FeatureGroupPrototype:
												callContextFeatureType.findFeatureGroupTypeForFeatureGroupPrototype(containingClassifier)
										}
										if (prototypeContext != null) {
											accessFeatureClassifier.findClassifierForComponentPrototype(prototypeContext)
										}
									}
									SubprogramGroupAccess: {
										val prototypeContext = switch callContextFeatureClassifier : callContext.allFeatureClassifier {
											ComponentClassifier:
												callContextFeatureClassifier
											ComponentPrototype:
												callContextFeatureClassifier.findClassifierForComponentPrototype(containingClassifier)
										}
										if (prototypeContext != null) {
											accessFeatureClassifier.findClassifierForComponentPrototype(prototypeContext)
										}
									}
									SubprogramGroupSubcomponent: {
										var Subcomponent callContextSubcomponent = callContext
										while (callContextSubcomponent.subcomponentType == null && callContextSubcomponent.refined != null) {
											callContextSubcomponent = callContextSubcomponent.refined
										}
										switch callContextSubcomponentType : callContextSubcomponent.subcomponentType {
											ComponentClassifier: {
												if (callContextSubcomponent.ownedPrototypeBindings.empty) {
													accessFeatureClassifier.findClassifierForComponentPrototype(callContextSubcomponentType)
												} else {
													accessFeatureClassifier.findClassifierForComponentPrototype(callContextSubcomponentType, callContextSubcomponent)
												}
											}
											ComponentPrototype: {
												var prototypeContext = callContextSubcomponentType.findClassifierForComponentPrototype(containingClassifier)
												if (prototypeContext != null) {
													accessFeatureClassifier.findClassifierForComponentPrototype(prototypeContext)
												}
											}
										}
									}
									default: //callContext is null.
										accessFeatureClassifier.findClassifierForComponentPrototype(containingClassifier)
								}
							}
						}
					}
					ComponentPrototype:
						calledSubprogram.findClassifierForComponentPrototype(containingClassifier)
				}
			}
		}
		if (contextClassifier != null) {
			validMemberCollector.apply(contextClassifier).scopeFor
		} else {
			IScope::NULLSCOPE
		}
	}
}
