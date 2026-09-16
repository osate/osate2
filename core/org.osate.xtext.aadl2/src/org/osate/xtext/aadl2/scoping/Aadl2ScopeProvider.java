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
package org.osate.xtext.aadl2.scoping;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractSubcomponentType;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.BusFeatureClassifier;
import org.osate.aadl2.BusSubcomponentType;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentImplementationReference;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DeviceSubcomponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlow;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureClassifier;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.Flow;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.MemorySubcomponentType;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.ModeTransition;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessSubcomponentType;
import org.osate.aadl2.ProcessorSubcomponentType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupSubcomponentType;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SystemSubcomponentType;
import org.osate.aadl2.ThreadGroupSubcomponentType;
import org.osate.aadl2.ThreadSubcomponentType;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.VirtualBusSubcomponentType;
import org.osate.aadl2.VirtualProcessorSubcomponentType;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.parsesupport.AObject;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;
import org.osate.xtext.aadl2.properties.scoping.PropertiesScopeProvider;

/**
 * This class contains custom scoping description.
 *
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it
 *
 */
public class Aadl2ScopeProvider extends PropertiesScopeProvider {
	private static final Function<Classifier, Iterable<? extends EObject>> CONNECTION_END_COLLECTOR = //
			classifier -> filterRefined(allConnectionEnds(classifier));

	private static final Function<Classifier, Iterable<? extends EObject>> FLOW_ELEMENT_COLLECTOR = //
			classifier -> filterRefined(allFlowElements(classifier));

	private static final Function<Classifier, Iterable<? extends EObject>> END_TO_END_FLOW_ELEMENT_COLLECTOR = //
			classifier -> filterRefined(allEndToEndFlowElements(classifier));

	private static final Function<Classifier, Iterable<? extends EObject>> TRIGGER_PORT_COLLECTOR = //
			classifier -> filterRefined(allTriggerPorts(classifier));

	// Reference is from TypeExtension in Aadl2.xtext
	public IScope scope_TypeExtension_extended(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from ImplementationExtension and ComponentImplementationReference in Aadl2.xtext
	public IScope scope_ComponentImplementation(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from GroupExtension in Aadl2.xtext
	public IScope scope_GroupExtension_extended(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from FeatureGroupPrototype in Aadl2.xtext
	public IScope scope_FeatureGroupPrototype_constrainingFeatureGroupType(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from FeatureGroupType in Aadl2.xtext
	public IScope scope_FeatureGroupType_inverse(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from Realization in Aadl2.xtext
	public IScope scope_Realization_implemented(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from SubprogramCall in Aadl2.xtext
	public IScope scope_SubprogramCall_context(Element context, EReference reference) {
		var scope = scope_Classifier(context, reference);
		var implementation = EcoreUtil2.getContainerOfType(context, BehavioredImplementation.class);
		return implementation == null ? scope
				: scopeFor(filterRefined(iterableOfType(implementation.getMembers(), CallContext.class)), scope);
	}

	// Reference is from SubprogramCall in Aadl2.xtext
	public IScope scope_SubprogramCall_calledSubprogram(Element context, EReference reference) {
		var subprogramCall = EcoreUtil2.getContainerOfType(context, SubprogramCall.class);
		var callContext = subprogramCall == null ? null : subprogramCall.getContext();
		if (callContext == null) {
			// No call context.  Add prototypes, subprogram accesses, and subprogram subcomponents from the classifier
			// to the scope.
			var members = EcoreUtil2.getContainerOfType(context, Classifier.class).getMembers();
			return scopeFor(filterRefined(iterableOfType(members, CalledSubprogram.class)),
					scope_Classifier(context, reference));
		}
		IScope scope = IScope.NULLSCOPE;
		Classifier callContextNamespace = null;
		switch (callContext) {
		case ComponentType componentType -> {
			/*
			 * Reference is in the form of "component_type.implementation" or "package::component_type.implementation".
			 * Add all implementations of the type from the type's package to the scope.
			 */
			var packageClassifiers = new ArrayList<Classifier>(EcoreUtil2
					.getContainerOfType(componentType, AadlPackage.class).getPublicSection().getOwnedClassifiers());
			var packageSectionForComponentType = EcoreUtil2.getContainerOfType(componentType, PackageSection.class);
			if (packageSectionForComponentType instanceof PrivatePackageSection && packageSectionForComponentType
					== EcoreUtil2.getContainerOfType(context, PrivatePackageSection.class)) {
				packageClassifiers.addAll(packageSectionForComponentType.getOwnedClassifiers());
			}
			var implementations = iterableOfType(iterableOfType(packageClassifiers, CalledSubprogram.class),
					ComponentImplementation.class);
			scope = scopeFor(filter(implementations, implementation -> implementation.getType() == componentType),
					implementation -> QualifiedName
							.create(implementation.getName().substring(implementation.getName().lastIndexOf('.') + 1)),
					IScope.NULLSCOPE);
			callContextNamespace = componentType;
		}
		case SubprogramGroupSubcomponent subcomponent -> callContextNamespace = subcomponent.getComponentType();
		case SubprogramGroupAccess access -> {
			if (access.getKind() == AccessType.REQUIRES
					&& access.getSubprogramGroupFeatureClassifier() instanceof Classifier featureClassifier) {
				callContextNamespace = featureClassifier;
			}
		}
		case FeatureGroup featureGroup -> callContextNamespace = featureGroup.getFeatureGroupType();
		default -> {
			// The call context does not contribute a namespace of its own.
		}
		}
		return callContextNamespace == null ? scope
				: scopeFor(filterRefined(iterableOfType(callContextNamespace.getMembers(), CalledSubprogram.class)),
						scope);
	}

	// Reference is from Prototype in Aadl2.xtext
	public IScope scope_ComponentPrototype_constrainingClassifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	/*
	 * Reference is from AbstractPrototype, BusPrototype, DataPrototype, DevicePrototype, MemoryPrototype,
	 * ProcessPrototype, ProcessorPrototype, SubprogramPrototype, SubprogramGroupPrototype, SystemPrototype,
	 * ThreadPrototype, ThreadGroupPrototype, VirtualBusPrototype, VirtualProcessorPrototype, FeatureGroupPrototype and
	 * FeaturePrototype in Aadl2.xtext
	 */
	public IScope scope_Prototype_refined(Classifier context, EReference reference) {
		var extended = context.getExtended();
		var prototypes = extended == null ? null : allPrototypes(extended);
		return prototypes == null ? IScope.NULLSCOPE : scopeFor(filterRefined(prototypes));
	}

	// Reference is from FeaturePrototype in Aadl2.xtext
	public IScope scope_FeaturePrototype_constrainingClassifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in
	// Aadl2.xtext
	public IScope scope_PrototypeBinding_formal(ComponentPrototypeActual context, EReference reference) {
		return context.getSubcomponentType() instanceof ComponentClassifier subcomponentType
				? scopeFor(filterRefined(subcomponentType.getAllPrototypes()))
				: IScope.NULLSCOPE;
	}

	// Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in
	// Aadl2.xtext
	public IScope scope_PrototypeBinding_formal(FeatureGroupPrototypeActual context, EReference reference) {
		return context.getFeatureType() instanceof FeatureGroupType featureType
				? scopeFor(filterRefined(featureType.getAllPrototypes()))
				: IScope.NULLSCOPE;
	}

	// Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in
	// Aadl2.xtext
	public IScope scope_PrototypeBinding_formal(ComponentImplementationReference context, EReference reference) {
		var implementation = context.getImplementation();
		return implementation == null ? IScope.NULLSCOPE : scopeFor(filterRefined(implementation.getAllPrototypes()));
	}

	// Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in
	// Aadl2.xtext
	public IScope scope_PrototypeBinding_formal(Subcomponent context, EReference reference) {
		var classifier = context.getAllClassifier();
		return classifier == null ? IScope.NULLSCOPE : scopeFor(filterRefined(classifier.getAllPrototypes()));
	}

	// Reference is from FeatureGroupPrototypeBinding, FeaturePrototypeBinding, and ComponentPrototypeBinding in
	// Aadl2.xtext
	public SimpleScope scope_PrototypeBinding_formal(Classifier context, EReference reference) {
		var prototypes = context.getGenerals()
				.stream()
				.flatMap(general -> allPrototypes(general).stream())
				.collect(Collectors.toCollection(LinkedHashSet::new));
		return scopeFor(filterRefined(prototypes));
	}

	// Reference is from FeatureGroupPrototypeActual in Aadl2.xtext
	public SimpleScope scope_FeatureGroupPrototypeActual_featureType(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, FeatureGroupPrototype.class);
	}

	// Reference is from PortSpecification in Aadl2.xtext
	public IScope scope_PortSpecification_classifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from AccessSpecification in Aadl2.xtext
	public IScope scope_AccessSpecification_classifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from FeaturePrototypeReference in Aadl2.xtext
	public SimpleScope scope_FeaturePrototypeReference_prototype(Classifier context, EReference reference) {
		return scopeFor(filterRefined(iterableOfType(allPrototypes(context), FeaturePrototype.class)));
	}

	// Reference is from ComponentReference in Aadl2.xtext
	public SimpleScope scope_ComponentPrototypeActual_subcomponentType(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, SubcomponentType.class);
	}

	/*
	 * Reference is from AbstractSubcomponent, SystemSubcomponent, ProcessSubcomponent, ThreadGroupSubcomponent,
	 * ThreadSubcomponent, SubprogramSubcomponent, SubprogramGroupSubcomponent, ProcessorSubcomponent,
	 * VirtualProcessorSubcomponent, DeviceSubcomponent, MemorySubcomponent, BusSubcomponent, VirtualBusSubcomponent,
	 * and DataSubcomponent in Aadl2.xtext
	 */
	public IScope scope_Subcomponent_refined(ComponentImplementation context, EReference reference) {
		var extended = context.getExtended();
		return extended == null ? IScope.NULLSCOPE : scopeFor(filterRefined(extended.getAllSubcomponents()));
	}

	// Reference is from AbstractSubcomponent in Aadl2.xtext
	public SimpleScope scope_AbstractSubcomponent_abstractSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, AbstractSubcomponentType.class);
	}

	// Reference is from SystemSubcomponent in Aadl2.xtext
	public SimpleScope scope_SystemSubcomponent_systemSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, SystemSubcomponentType.class);
	}

	// Reference is from ProcessSubcomponent in Aadl2.xtext
	public SimpleScope scope_ProcessSubcomponent_processSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, ProcessSubcomponentType.class);
	}

	// Reference is from ThreadGroupSubcomponent in Aadl2.xtext
	public SimpleScope scope_ThreadGroupSubcomponent_threadGroupSubcomponentType(Element context,
			EReference reference) {
		return scopeForImplementationPrototypes(context, reference, ThreadGroupSubcomponentType.class);
	}

	// Reference is from ThreadSubcomponent in Aadl2.xtext
	public SimpleScope scope_ThreadSubcomponent_threadSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, ThreadSubcomponentType.class);
	}

	// Reference is from SubprogramSubcomponent in Aadl2.xtext
	public SimpleScope scope_SubprogramSubcomponent_subprogramSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, SubprogramSubcomponentType.class);
	}

	// Reference is from SubprogramGroupSubcomponent in Aadl2.xtext
	public SimpleScope scope_SubprogramGroupSubcomponent_subprogramGroupSubcomponentType(Element context,
			EReference reference) {
		return scopeForImplementationPrototypes(context, reference, SubprogramGroupSubcomponentType.class);
	}

	// Reference is from ProcessorSubcomponent in Aadl2.xtext
	public SimpleScope scope_ProcessorSubcomponent_processorSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, ProcessorSubcomponentType.class);
	}

	// Reference is from VirtualProcessorSubcomponent in Aadl2.xtext
	public SimpleScope scope_VirtualProcessorSubcomponent_virtualProcessorSubcomponentType(Element context,
			EReference reference) {
		return scopeForImplementationPrototypes(context, reference, VirtualProcessorSubcomponentType.class);
	}

	// Reference is from DeviceSubcomponent in Aadl2.xtext
	public SimpleScope scope_DeviceSubcomponent_deviceSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, DeviceSubcomponentType.class);
	}

	// Reference is from MemorySubcomponent in Aadl2.xtext
	public SimpleScope scope_MemorySubcomponent_memorySubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, MemorySubcomponentType.class);
	}

	// Reference is from BusSubcomponent in Aadl2.xtext
	public SimpleScope scope_BusSubcomponent_busSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, BusSubcomponentType.class);
	}

	// Reference is from VirtualBusSubcomponent in Aadl2.xtext
	public SimpleScope scope_VirtualBusSubcomponent_virtualBusSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, VirtualBusSubcomponentType.class);
	}

	// Reference is from DataSubcomponent in Aadl2.xtext
	public SimpleScope scope_DataSubcomponent_dataSubcomponentType(Element context, EReference reference) {
		return scopeForImplementationPrototypes(context, reference, DataSubcomponentType.class);
	}

	// Reference is from DataPort, EventDataPort, EventPort, FeatureGroup, Parameter, SubprogramAccess,
	// SubprogramGroupAccess, BusAccess, DataAccess, and AbstractFeature in Aadl2.xtext
	public IScope scope_Feature_refined(Classifier context, EReference reference) {
		var extended = context.getExtended();
		return extended == null ? IScope.NULLSCOPE : scopeFor(filterRefined(extended.getAllFeatures()));
	}

	// Reference is from DataPort in Aadl2.xtext
	public SimpleScope scope_DataPort_dataFeatureClassifier(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, DataSubcomponentType.class);
	}

	// Reference is from EventDataPort in Aadl2.xtext
	public SimpleScope scope_EventDataPort_dataFeatureClassifier(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, DataSubcomponentType.class);
	}

	// Reference is from FeatureGroup in Aadl2.xtext
	public SimpleScope scope_FeatureGroup_featureType(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, FeatureType.class);
	}

	// Reference is from Parameter in Aadl2.xtext
	public SimpleScope scope_Parameter_dataFeatureClassifier(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, DataSubcomponentType.class);
	}

	// Reference is from SubprogramAccess in Aadl2.xtext
	public SimpleScope scope_SubprogramAccess_subprogramFeatureClassifier(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, SubprogramSubcomponentType.class);
	}

	// Reference is from SubprogramGroupAccess in Aadl2.xtext
	public SimpleScope scope_SubprogramGroupAccess_subprogramGroupFeatureClassifier(Element context,
			EReference reference) {
		return scopeForClassifierPrototypes(context, reference, SubprogramGroupSubcomponentType.class);
	}

	// Reference is from BusAccess in Aadl2.xtext
	public SimpleScope scope_BusAccess_busFeatureClassifier(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, BusFeatureClassifier.class);
	}

	// Reference is from DataAccess in Aadl2.xtext
	public SimpleScope scope_DataAccess_dataFeatureClassifier(Element context, EReference reference) {
		return scopeForClassifierPrototypes(context, reference, DataSubcomponentType.class);
	}

	// Reference is from AbstractFeature in Aadl2.xtext
	public SimpleScope scope_AbstractFeature_featurePrototype(Classifier context, EReference reference) {
		return scopeFor(filterRefined(iterableOfType(allPrototypes(context), FeaturePrototype.class)));
	}

	// Reference is from EventDataSource in Aadl2.xtext
	public IScope scope_EventDataSource_dataClassifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from PortProxy in Aadl2.xtext
	public IScope scope_PortProxy_dataClassifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from SubprogramProxy in Aadl2.xtext
	public IScope scope_SubprogramProxy_subprogramClassifier(Element context, EReference reference) {
		return scope_Classifier(context, reference);
	}

	// Reference is from ConnectedElement in Aadl2.xtext
	public SimpleScope scope_ConnectedElement_context(ComponentImplementation context, EReference reference) {
		return scopeFor(filterRefined(allContexts(context)));
	}

	// Reference is from ConnectedElement in Aadl2.xtext
	public IScope scope_ConnectedElement_connectionEnd(ConnectedElement context, EReference reference) {
		var classifier = EcoreUtil2.getContainerOfType(context, Classifier.class);
		if (context.eContainer() instanceof ConnectedElement) {
			return context.getConnectionEnd() instanceof Context current
					? scopeForElementsOfContext(current, classifier, CONNECTION_END_COLLECTOR)
					: IScope.NULLSCOPE;
		}
		return context.getContext() == null ? scopeFor(filterRefined(allConnectionEnds(classifier)))
				: scopeForElementsOfContext(context.getContext(), classifier, CONNECTION_END_COLLECTOR);
	}

	// Reference is from PortConnection, AccessConnection, FeatureGroupConnection, FeatureConnection, and
	// ParameterConnection in Aadl2.xtext
	public IScope scope_Connection_refined(ComponentImplementation context, EReference reference) {
		var extended = context.getExtended();
		return extended == null ? IScope.NULLSCOPE : scopeFor(filterRefined(extended.getAllConnections()));
	}

	/*
	 * Reference is from PortConnection, AccessConnection, FeatureGroupConnection, FeatureConnection,
	 * ParameterConnection, FlowSpecification, FlowImplementation, and EndToEndFlow in Aadl2.xtext
	 */
	public SimpleScope scope_ModalPath_inModeOrTransition(ComponentClassifier context, EReference reference) {
		return scopeFor(Stream
				.<ModeFeature>concat(context.getAllModes().stream(), context.getAllModeTransitions().stream())
				.toList());
	}

	public SimpleScope scope_FlowEnd_feature(Flow context, EReference reference) {
		return scopeFor(
				filterRefined(EcoreUtil2.getContainerOfType(context, Classifier.class).getAllFeatures()));
	}

	/*
	 * Reference is from FlowEnd in Aadl2.xtext
	 */
	public IScope scope_FlowEnd_feature(FlowEnd end, EReference reference) {
		var prev = end.getContext();
		if (prev == null) {
			return scopeFor(filterRefined(EcoreUtil2.getContainerOfType(end, Classifier.class).getAllFeatures()));
		}
		var feature = prev.getFeature();
		Classifier classifier = feature.getAllClassifier();
		if (classifier == null) {
			classifier = switch (feature) {
			case FeatureGroup featureGroup -> featureGroup.getFeatureGroupPrototype() == null ? null
					: featureGroup.getFeatureGroupPrototype().getConstrainingFeatureGroupType();
			case Port port -> port.getPrototype() == null ? null : port.getPrototype().getConstrainingClassifier();
			case null, default -> null;
			};
		}
		return classifier == null ? IScope.NULLSCOPE : scopeFor(filterRefined(classifier.getAllFeatures()));
	}

	// Reference is from FlowSpecRefinement in Aadl2.xtext
	public IScope scope_FlowSpecification_refined(ComponentType context, EReference reference) {
		var extended = context.getExtended();
		return extended == null ? IScope.NULLSCOPE : scopeFor(filterRefined(extended.getAllFlowSpecifications()));
	}

	// Reference is from FlowSourceImpl, FlowSinkImpl, and FlowPathImpl in Aadl2.xtext
	public IScope scope_FlowImplementation_specification(ComponentImplementation context, EReference reference) {
		var type = context.getType();
		return type == null ? IScope.NULLSCOPE : scopeFor(filterRefined(type.getAllFlowSpecifications()));
	}

	// Reference is from EndToEndFlow in Aadl2.xtext
	public IScope scope_EndToEndFlow_refined(ComponentImplementation context, EReference reference) {
		var extended = context.getExtended();
		return extended == null ? IScope.NULLSCOPE : scopeFor(filterRefined(extended.getAllEndToEndFlows()));
	}

	// Reference is from SubcomponentFlow in Aadl2.xtext
	public SimpleScope scope_FlowSegment_context(ComponentImplementation context, EReference reference) {
		return scopeFor(filterRefined(allContexts(context)));
	}

	/*
	 * Reference is from SubcomponentFlow and ConnectionFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the
	 * form of the FlowSegment.  When the FlowSegment is a single identifier, e.g. "conn1", then the passed context is a
	 * FlowImplementation.  In this case, we know that the FlowSegment's Context is null even though we can't access it
	 * and check it here.  When the FlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the
	 * passed context is a FlowSegment, thus calling the other scope method.
	 */
	public SimpleScope scope_FlowSegment_flowElement(FlowImplementation context, EReference reference) {
		return scopeFor(
				filterRefined(allFlowElements(EcoreUtil2.getContainerOfType(context, Classifier.class))));
	}

	/*
	 * Reference is from SubcomponentFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the
	 * form of the FlowSegment.  When the FlowSegment is a qualified reference, e.g. "subcomponent1.flowpath1", then the
	 * passed context is a FlowSegment and we can access and check the FlowSegment's Context object.
	 */
	public IScope scope_FlowSegment_flowElement(FlowSegment context, EReference reference) {
		var segmentContext = context.getContext();
		return segmentContext == null
				? scope_FlowSegment_flowElement((FlowImplementation) context.getOwner(), reference)
				: scopeForElementsOfContext(segmentContext,
						EcoreUtil2.getContainerOfType(context, Classifier.class), FLOW_ELEMENT_COLLECTOR);
	}

	// Reference is from ETESubcomponentFlow in Aadl2.xtext
	public SimpleScope scope_EndToEndFlowSegment_context(ComponentImplementation context, EReference reference) {
		return scopeFor(filterRefined(allContexts(context)));
	}

	/*
	 * Reference is from ETESubcomponentFlow and ETEConnectionFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the
	 * form of the EndToEndFlowSegment.  When the EndToEndFlowSegment is a single identifier, e.g. "conn1", then the
	 * passed context is an EndToEndFlow.  In this case, we know that the EndToEndFlowSegment's Context is null even
	 * though we can't access it and check it here.  When the EndToEndFlowSegment is a qualified reference, e.g.
	 * "subcomponent1.flowpath1", then the passed context is an EndToEndFlowSegment, thus calling the other scope
	 * method.
	 */
	public SimpleScope scope_EndToEndFlowSegment_flowElement(EndToEndFlow context, EReference reference) {
		return scopeFor(filterRefined(
				allEndToEndFlowElements(EcoreUtil2.getContainerOfType(context, Classifier.class))));
	}

	/*
	 * Reference is from ETESubcomponentFlow in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the
	 * form of the EndToEndFlowSegment.  When the EndToEndFlowSegment is a qualified reference, e.g.
	 * "subcomponent1.flowpath1", then the passed context is an EndToEndFlowSegment and we can access and check the
	 * EndToEndFlowSegment's Context object.
	 */
	public IScope scope_EndToEndFlowSegment_flowElement(EndToEndFlowSegment context, EReference reference) {
		var segmentContext = context.getContext();
		return segmentContext == null
				? scope_EndToEndFlowSegment_flowElement((EndToEndFlow) context.getOwner(), reference)
				: scopeForElementsOfContext(segmentContext,
						EcoreUtil2.getContainerOfType(context, Classifier.class),
						END_TO_END_FLOW_ELEMENT_COLLECTOR);
	}

	// Reference is from ModeTransition in Aadl2.xtext
	public SimpleScope scope_ModeTransition_source(ComponentClassifier context, EReference reference) {
		return scopeFor(context.getAllModes());
	}

	// Reference is from ModeTransition in Aadl2.xtext
	public SimpleScope scope_ModeTransition_destination(ComponentClassifier context, EReference reference) {
		return scopeFor(context.getAllModes());
	}

	// Reference is from Trigger in Aadl2.xtext
	public SimpleScope scope_ModeTransitionTrigger_context(ComponentClassifier context, EReference reference) {
		return scopeFor(filterRefined(allContexts(context)));
	}

	/*
	 * Reference is from Trigger in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the
	 * form of the ModeTransitionTrigger.  When the ModeTransitionTrigger is a single identifier, e.g. "eventport1",
	 * then the passed context is a ModeTransition. In this case, we know that the ModeTransitionTrigger's Context is
	 * null even though we can't access it and check it here.  When the ModeTransitionTrigger is a qualified reference,
	 * e.g. "featuregroup1.eventport1", then the passed context is a ModeTransitionTrigger, thus calling the other scope
	 * method.
	 */
	public SimpleScope scope_ModeTransitionTrigger_triggerPort(ModeTransition context, EReference reference) {
		return scopeFor(
				filterRefined(allTriggerPorts(EcoreUtil2.getContainerOfType(context, Classifier.class))));
	}

	/*
	 * Reference is from Trigger in Aadl2.xtext
	 * There are two methods for this scope because we can be given one of two possible context objects based upon the
	 * form of the ModeTransitionTrigger.  When the ModeTransitionTrigger is a qualified reference, e.g.
	 * "featuregroup1.eventport1", then the passed context is a ModeTransitionTrigger and we can access and check the
	 * ModeTransitionTrigger's Context object.
	 */
	public IScope scope_ModeTransitionTrigger_triggerPort(ModeTransitionTrigger context, EReference reference) {
		var triggerContext = context.getContext();
		return triggerContext == null
				? scope_ModeTransitionTrigger_triggerPort((ModeTransition) context.getOwner(), reference)
				: scopeForElementsOfContext(triggerContext,
						EcoreUtil2.getContainerOfType(context, Classifier.class), TRIGGER_PORT_COLLECTOR);
	}

	// Reference is from ModeRef in Aadl2.xtext
	public SimpleScope scope_ModeBinding_parentMode(ComponentImplementation context, EReference reference) {
		return scopeFor(context.getAllModes());
	}

	// Reference is from ModeRef in Aadl2.xtext
	public IScope scope_ModeBinding_derivedMode(Subcomponent context, EReference reference) {
		var classifier = resolveSubcomponentType(allSubcomponentType(context),
				EcoreUtil2.getContainerOfType(context, Classifier.class));
		return classifier == null ? IScope.NULLSCOPE : scopeFor(classifier.getAllModes());
	}

	// Reference is from UnitLiteralConversion in Aadl2.xtext
	public SimpleScope scope_UnitLiteral_baseUnit(UnitsType context, EReference reference) {
		return scopeFor(context.getOwnedLiterals());
	}

	// Reference is from RealType, UnnamedRealType, IntegerType, and UnnamedIntegerType in Aadl2.xtext
	public SimpleScope scope_NumberType_referencedUnitsType(Element context, EReference reference) {
		return scopeForVisibleDescriptions(context, reference);
	}

	// Reference is from RangeType and UnnamedRangeType in Aadl2.xtext
	public SimpleScope scope_RangeType_numberType(Element context, EReference reference) {
		return scopeForVisibleDescriptions(context, reference);
	}

	// Reference is from RecordField in Aadl2.xtext
	public SimpleScope scope_BasicProperty_referencedPropertyType(Element context, EReference reference) {
		return scopeForVisibleDescriptions(context, reference);
	}

	// Reference is from ListType in Aadl2.xtext
	public SimpleScope scope_ListType_referencedElementType(Element context, EReference reference) {
		return scopeForVisibleDescriptions(context, reference);
	}

	// Reference is from PropertyConstant in Aadl2.xtext
	public SimpleScope scope_PropertyConstant_referencedPropertyType(Element context, EReference reference) {
		return scopeForVisibleDescriptions(context, reference);
	}

	/**
	 * @since 2.0
	 */
	protected static ArrayList<ConnectionEnd> allConnectionEnds(Classifier classifier) {
		var connectionEnds = new ArrayList<ConnectionEnd>(classifier.getAllFeatures());
		if (classifier instanceof ComponentImplementation implementation) {
			iterableOfType(implementation.getAllSubcomponents(), ConnectionEnd.class).forEach(connectionEnds::add);
			connectionEnds.addAll(implementation.getAllSubprogramProxies());
			connectionEnds.addAll(implementation.getAllPortProxies());
			connectionEnds.addAll(implementation.getAllInternalFeatures());
		}
		return connectionEnds;
	}

	/**
	 * @since 2.0
	 */
	protected static IScope scopeForElementsOfContext(Context context, Classifier containingClassifier,
			Function<? super Classifier, ? extends Iterable<? extends EObject>> validMemberCollector) {
		Classifier contextClassifier = switch (context) {
		case FeatureGroup featureGroup -> resolveFeatureType(allFeatureType(featureGroup), containingClassifier);
		case Feature feature -> resolveFeatureClassifier(feature.getAllFeatureClassifier(), containingClassifier);
		case Subcomponent subcomponent -> resolveSubcomponentType(allSubcomponentType(subcomponent),
				containingClassifier);
		case SubprogramCall call -> resolveCalledSubprogram(call, containingClassifier);
		case null, default -> null;
		};
		return contextClassifier == null ? IScope.NULLSCOPE
				: scopeFor(validMemberCollector.apply(contextClassifier));
	}

	/*
	 * The scope of a subcomponent's classifier reference is the enclosing implementation's prototypes of the matching
	 * kind, layered on top of the visible classifiers.
	 */
	private <T extends AObject> SimpleScope scopeForImplementationPrototypes(Element context, EReference reference,
			Class<T> prototypeKind) {
		var prototypes = EcoreUtil2.getContainerOfType(context, ComponentImplementation.class).getAllPrototypes();
		return scopeFor(filterRefined(iterableOfType(prototypes, prototypeKind)),
				scope_Classifier(context, reference));
	}

	/*
	 * The scope of a feature's classifier reference is the enclosing classifier's prototypes of the matching kind,
	 * layered on top of the visible classifiers.
	 */
	private <T extends AObject> SimpleScope scopeForClassifierPrototypes(Element context, EReference reference,
			Class<T> prototypeKind) {
		var prototypes = allPrototypes(EcoreUtil2.getContainerOfType(context, Classifier.class));
		return scopeFor(filterRefined(iterableOfType(prototypes, prototypeKind)),
				scope_Classifier(context, reference));
	}

	/*
	 * Property types and units types may only be referenced by their qualified name or through one of the predeclared
	 * property sets.
	 */
	private SimpleScope scopeForVisibleDescriptions(Element context, EReference reference) {
		var descriptions = delegateGetScope(context, reference).getAllElements();
		return new SimpleScope(
				filter(descriptions,
						description -> Objects.equals(description.getName(), description.getQualifiedName())
								|| AadlUtil.isPredeclaredPropertySet(description.getQualifiedName().getFirstSegment())),
				true);
	}

	private static EList<Prototype> allPrototypes(Classifier classifier) {
		return switch (classifier) {
		case ComponentClassifier componentClassifier -> componentClassifier.getAllPrototypes();
		case FeatureGroupType featureGroupType -> featureGroupType.getAllPrototypes();
		case null, default -> null;
		};
	}

	private static ArrayList<Context> allContexts(ComponentClassifier classifier) {
		var validElements = new ArrayList<Context>();
		iterableOfType(classifier.getAllFeatures(), Context.class).forEach(validElements::add);
		if (classifier instanceof ComponentImplementation implementation) {
			validElements.addAll(implementation.getAllSubcomponents());
			if (implementation instanceof BehavioredImplementation behavioredImplementation) {
				validElements.addAll(allSubprogramCalls(behavioredImplementation));
			}
		}
		return validElements;
	}

	private static ArrayList<FlowElement> allFlowElements(Classifier classifier) {
		var flowElements = new ArrayList<FlowElement>();
		iterableOfType(classifier.getAllFeatures(), DataAccess.class).forEach(flowElements::add);
		iterableOfType(classifier.getAllFeatures(), SubprogramAccess.class).forEach(flowElements::add);
		if (classifier instanceof ComponentType type) {
			flowElements.addAll(type.getAllFlowSpecifications());
		} else if (classifier instanceof ComponentImplementation implementation) {
			flowElements.addAll(implementation.getType().getAllFlowSpecifications());
			flowElements.addAll(implementation.getAllConnections());
			flowElements.addAll(implementation.getAllSubcomponents());
		}
		return flowElements;
	}

	private static ArrayList<EndToEndFlowElement> allEndToEndFlowElements(Classifier classifier) {
		var flowElements = new ArrayList<EndToEndFlowElement>(allFlowElements(classifier));
		if (classifier instanceof ComponentImplementation implementation) {
			flowElements.addAll(implementation.getAllEndToEndFlows());
		}
		return flowElements;
	}

	private static ArrayList<TriggerPort> allTriggerPorts(Classifier classifier) {
		var triggerPorts = new ArrayList<TriggerPort>();
		iterableOfType(classifier.getAllFeatures(), TriggerPort.class).forEach(triggerPorts::add);
		if (classifier instanceof ComponentImplementation implementation) {
			triggerPorts.addAll(implementation.getAllInternalFeatures());
			triggerPorts.addAll(implementation.getAllPortProxies());
		}
		return triggerPorts;
	}

	private static FeatureGroupType resolveFeatureType(FeatureType featureType, Classifier containingClassifier) {
		return switch (featureType) {
		case FeatureGroupType featureGroupType -> featureGroupType;
		case FeatureGroupPrototype prototype -> findFeatureGroupTypeForFeatureGroupPrototype(prototype,
				containingClassifier);
		case null, default -> null;
		};
	}

	private static ComponentClassifier resolveFeatureClassifier(FeatureClassifier featureClassifier,
			Classifier containingClassifier) {
		return switch (featureClassifier) {
		case ComponentClassifier componentClassifier -> componentClassifier;
		case ComponentPrototype prototype -> findClassifierForComponentPrototype(prototype, containingClassifier);
		case null, default -> null;
		};
	}

	private static ComponentClassifier resolveSubcomponentType(SubcomponentType subcomponentType,
			Classifier containingClassifier) {
		return switch (subcomponentType) {
		case ComponentClassifier componentClassifier -> componentClassifier;
		case ComponentPrototype prototype -> findClassifierForComponentPrototype(prototype, containingClassifier);
		case null, default -> null;
		};
	}

	private static ComponentClassifier resolveCalledSubprogram(SubprogramCall call, Classifier containingClassifier) {
		return switch (call.getCalledSubprogram()) {
		case ComponentClassifier componentClassifier -> componentClassifier;
		case SubprogramSubcomponent subcomponent -> resolveSubcomponentType(allSubcomponentType(subcomponent),
				containingClassifier);
		case SubprogramAccess access -> switch (access.getAllFeatureClassifier()) {
			case ComponentClassifier componentClassifier -> componentClassifier;
			case ComponentPrototype prototype -> resolveAccessPrototype(prototype, call.getContext(),
					containingClassifier);
			case null, default -> null;
			};
		case ComponentPrototype prototype -> findClassifierForComponentPrototype(prototype, containingClassifier);
		case null, default -> null;
		};
	}

	/*
	 * The subprogram access is typed by a prototype, so the classifier that binds the prototype has to be found through
	 * the call context.
	 */
	private static ComponentClassifier resolveAccessPrototype(ComponentPrototype accessFeatureClassifier,
			CallContext callContext, Classifier containingClassifier) {
		return switch (callContext) {
		case ComponentType componentType -> findClassifierForComponentPrototype(accessFeatureClassifier, componentType);
		case FeatureGroup featureGroup -> {
			var prototypeContext = resolveFeatureType(allFeatureType(featureGroup), containingClassifier);
			yield prototypeContext == null ? null
					: findClassifierForComponentPrototype(accessFeatureClassifier, prototypeContext);
		}
		case SubprogramGroupAccess access -> {
			var prototypeContext = resolveFeatureClassifier(access.getAllFeatureClassifier(), containingClassifier);
			yield prototypeContext == null ? null
					: findClassifierForComponentPrototype(accessFeatureClassifier, prototypeContext);
		}
		case SubprogramGroupSubcomponent subcomponent -> {
			Subcomponent callContextSubcomponent = subcomponent;
			while (callContextSubcomponent.getSubcomponentType() == null
					&& callContextSubcomponent.getRefined() != null) {
				callContextSubcomponent = callContextSubcomponent.getRefined();
			}
			yield switch (callContextSubcomponent.getSubcomponentType()) {
			case ComponentClassifier classifier -> callContextSubcomponent.getOwnedPrototypeBindings().isEmpty()
					? findClassifierForComponentPrototype(accessFeatureClassifier, classifier)
					: findClassifierForComponentPrototype(accessFeatureClassifier, classifier, callContextSubcomponent);
			case ComponentPrototype prototype -> {
				var prototypeContext = findClassifierForComponentPrototype(prototype, containingClassifier);
				yield prototypeContext == null ? null
						: findClassifierForComponentPrototype(accessFeatureClassifier, prototypeContext);
			}
			case null, default -> null;
			};
		}
		// callContext is null.
		case null, default -> findClassifierForComponentPrototype(accessFeatureClassifier, containingClassifier);
		};
	}

	private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(FeatureGroupPrototype prototype,
			Classifier containingClassifier) {
		return PropertiesLinkingService.findFeatureGroupTypeForFeatureGroupPrototype(containingClassifier, prototype);
	}

	private static ComponentClassifier findClassifierForComponentPrototype(ComponentPrototype prototype,
			Classifier containingClassifier) {
		return PropertiesLinkingService.findClassifierForComponentPrototype(containingClassifier, prototype);
	}

	private static ComponentClassifier findClassifierForComponentPrototype(ComponentPrototype prototype,
			Classifier classifierPrototypeContext, Subcomponent subcomponentPrototypeContext) {
		return PropertiesLinkingService.findClassifierForComponentPrototype(classifierPrototypeContext,
				subcomponentPrototypeContext, prototype);
	}

	/*
	 * Lazily selects the elements of the given type. The result is repeatable, so it can be handed to the equally lazy
	 * scope pipeline.
	 */
	private static <T> Iterable<T> iterableOfType(Iterable<?> elements, Class<T> type) {
		return () -> StreamSupport.stream(elements.spliterator(), false)
				.filter(type::isInstance)
				.map(type::cast)
				.iterator();
	}

	/*
	 * Lazily selects the elements that satisfy the given predicate. The result is repeatable, so it can be handed to
	 * the equally lazy scope pipeline.
	 */
	private static <T> Iterable<T> filter(Iterable<T> elements, Predicate<? super T> predicate) {
		return () -> StreamSupport.stream(elements.spliterator(), false).filter(predicate).iterator();
	}
}
