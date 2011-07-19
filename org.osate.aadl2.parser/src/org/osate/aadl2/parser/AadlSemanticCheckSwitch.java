/*
 * <copyright>
 * Copyright  2009 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
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
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 * </copyright>
 */
package org.osate.aadl2.parser;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractImplementation;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.BusAccess;
import org.osate.aadl2.BusImplementation;
import org.osate.aadl2.BusType;
import org.osate.aadl2.ClassifierFeature;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentPrototypeReference;
import org.osate.aadl2.ComponentReference;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ComponentTypeRename;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ConstantValue;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataImplementation;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.DeviceImplementation;
import org.osate.aadl2.DeviceType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationValue;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.EventPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeaturePrototypeBinding;
import org.osate.aadl2.FeaturePrototypeReference;
import org.osate.aadl2.GroupExtension;
import org.osate.aadl2.ImplementationExtension;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.MemoryImplementation;
import org.osate.aadl2.MemoryType;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeFeature;
import org.osate.aadl2.Operation;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessType;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorType;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyReference;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupImplementation;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemType;
import org.osate.aadl2.ThreadGroupImplementation;
import org.osate.aadl2.ThreadGroupType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadType;
import org.osate.aadl2.TypeExtension;
import org.osate.aadl2.VirtualBusImplementation;
import org.osate.aadl2.VirtualBusType;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorType;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.aadl2.util.Aadl2Switch;


public class AadlSemanticCheckSwitch extends AadlProcessingSwitchWithProgress
{
	private static enum FeatureType
	{
		IN_DATA_PORT("an in data port"),
		OUT_DATA_PORT("an out data port"),
		IN_OUT_DATA_PORT("an in out data port"),
		IN_EVENT_PORT("an in event port"),
		OUT_EVENT_PORT("an out event port"),
		IN_OUT_EVENT_PORT("an in out event port"),
		IN_EVENT_DATA_PORT("an in event data port"),
		OUT_EVENT_DATA_PORT("an out event data port"),
		IN_OUT_EVENT_DATA_PORT("an in out event data port"),
		FEATURE_GROUP("a feature group"),
		PROVIDES_DATA_ACCESS("a provides data access"),
		REQUIRES_DATA_ACCESS("a requires data access"),
		PROVIDES_SUBPROGRAM_ACCESS("a provides subprogram access"),
		REQUIRES_SUBPROGRAM_ACCESS("a requires subprogram access"),
		PROVIDES_SUBPROGRAM_GROUP_ACCESS("a provides subprogram group access"),
		REQUIRES_SUBPROGRAM_GROUP_ACCESS("a requires subprogram group access"),
		PROVIDES_BUS_ACCESS("a provides bus access"),
		REQUIRES_BUS_ACCESS("a requires bus access"),
		ABSTRACT_FEATURE("an abstract feature"),
		PARAMETER("a parameter");
	
		private final String nameWithIndefiniteArticle;
		
		private FeatureType(String nameWithIndefiniteArticle)
		{
			this.nameWithIndefiniteArticle = nameWithIndefiniteArticle;
		}
	
		public String getNameWithIndefiniteArticle()
		{
			return nameWithIndefiniteArticle;
		}
	}
	
	private static final Map<ComponentCategory, Set<FeatureType>> acceptableFeaturesForTypes;
	private static final Map<ComponentCategory, Set<ComponentCategory>> acceptableSubcomponentCategoriesForImplementations;
	private static final Map<EClass, String> FEATURE_CLASS_NAMES_WITH_ARTICLE;
	
	public AadlSemanticCheckSwitch(final IProgressMonitor monitor, final AnalysisErrorReporterManager manager)
	{
		super(monitor, PROCESS_PRE_ORDER_ALL, manager);
	}
	
	public AadlSemanticCheckSwitch(final AnalysisErrorReporterManager manager)
	{
		this(new NullProgressMonitor(), manager);
	}

	@Override
	protected void initSwitches()
	{
		aadl2Switch = new Aadl2Switch<String>()
		{
			@Override
			public String caseComponentImplementation(ComponentImplementation componentImplementation)
			{
				checkComponentImplementationInPackageSection(componentImplementation);
				checkComponentImplementationModes(componentImplementation);				
				return NOT_DONE;
			}
			
			@Override
			public String caseTypeExtension(TypeExtension typeExtension)
			{
				checkTypeExtensionCategory(typeExtension);
				checkFeaturesOfExtendedAbstractType((ComponentType)typeExtension.getSpecific());
				return NOT_DONE;
			}
			
			@Override
			public String caseComponentType(ComponentType componentType)
			{
				checkComponentTypeModes(componentType);
				checkForInheritedFeatureArrays(componentType);
				return NOT_DONE;
			}
			
			@Override
			public String caseImplementationExtension(ImplementationExtension implementationExtension)
			{
				checkExtensionAndRealizationHierarchy(implementationExtension);
				checkImplementationExtensionCategory(implementationExtension);
				checkSubcomponentsOfExtendedAbstractImplementation((ComponentImplementation)implementationExtension.getSpecific());
				return NOT_DONE;
			}
			
			@Override
			public String caseRealization(Realization realization)
			{
				checkRealizationCategory(realization);
				return NOT_DONE;
			}
			
			@Override
			public String caseComponentTypeRename(ComponentTypeRename componentTypeRename)
			{
				checkComponentTypeRenameCategory(componentTypeRename);
				return NOT_DONE;
			}
			
			@Override
			public String caseSubcomponent(Subcomponent subcomponent)
			{
				checkSubcomponentCategory(subcomponent);				
				checkSubcomponentRefinementCategory(subcomponent);
				checkSubcomponentsHierarchy(subcomponent);
				return NOT_DONE;
			}
			
			@Override
			public String caseComponentPrototype(ComponentPrototype prototype)
			{
				checkComponentPrototypeCategory(prototype);
				checkRefinedOfComponentPrototype(prototype);
				checkCategoryOfRefinedComponentPrototype(prototype);
				checkArrayOfRefinedComponentPrototype(prototype);
				return NOT_DONE;
			}
			
			@Override
			public String caseComponentPrototypeBinding(ComponentPrototypeBinding binding)
			{
				checkComponentPrototypeBindingCategory(binding);
				checkFormalOfComponentPrototypeBinding(binding);
				return NOT_DONE;
			}
			
			@Override
			public String caseComponentReference(ComponentReference prototypeActual)
			{
				checkComponentPrototypeActualComponentCategory(prototypeActual);
				return NOT_DONE;
			}
			
			@Override
			public String caseComponentPrototypeReference(ComponentPrototypeReference prototypeActual)
			{
				checkComponentPrototypeActualPrototypeCategory(prototypeActual);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeaturePrototypeBinding(FeaturePrototypeBinding binding)
			{
				checkFeaturePrototypeBindingDirection(binding);
				checkFormalOfFeaturePrototypeBinding(binding);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding binding)
			{
				checkFormalOfFeatureGroupPrototypeBinding(binding);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeatureGroupPrototype(FeatureGroupPrototype prototype)
			{
				checkRefinedOfFeatureGroupPrototype(prototype);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeaturePrototype(FeaturePrototype prototype)
			{
				checkRefinedOfFeaturePrototype(prototype);
				checkDirectionOfRefinedFeaturePrototype(prototype);
				return NOT_DONE;
			}
			
			@Override
			public String caseDataType(DataType dataType)
			{
				checkForInheritedFlowsAndModesFromAbstractType(dataType);
				return NOT_DONE;
			}
			
			@Override
			public String caseDataImplementation(DataImplementation dataImplementation)
			{
				checkForInheritedFlowsAndModesFromAbstractImplementation(dataImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseThreadGroupImplementation(ThreadGroupImplementation threadGroupImplementation)
			{
				checkForInheritedCallSequenceFromAbstractImplementation(threadGroupImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseProcessorImplementation(ProcessorImplementation processorImplementation)
			{
				checkForInheritedCallSequenceFromAbstractImplementation(processorImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseVirtualProcessorImplementation(VirtualProcessorImplementation virtualProcessorImplementation)
			{
				checkForInheritedCallSequenceFromAbstractImplementation(virtualProcessorImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseMemoryType(MemoryType memoryType)
			{
				checkForInheritedFlowsFromAbstractType(memoryType);
				return NOT_DONE;
			}
			
			@Override
			public String caseMemoryImplementation(MemoryImplementation memoryImplementation)
			{
				checkForInheritedFlowsAndCallSequenceFromAbstractImplementation(memoryImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseBusType(BusType busType)
			{
				checkForInheritedFlowsFromAbstractType(busType);
				return NOT_DONE;
			}
			
			@Override
			public String caseBusImplementation(BusImplementation busImplementation)
			{
				checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(busImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseVirtualBusType(VirtualBusType virtualBusType)
			{
				checkForInheritedFlowsFromAbstractType(virtualBusType);
				return NOT_DONE;
			}
			
			@Override
			public String caseVirtualBusImplementation(VirtualBusImplementation virtualBusImplementation)
			{
				checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(virtualBusImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseDeviceImplementation(DeviceImplementation deviceImplementation)
			{
				checkForInheritedCallsFromAbstractImplementation(deviceImplementation);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeature(Feature feature)
			{
				checkTypeOfFeatureRefinement(feature);
				checkForFeatureArrays(feature);
				checkForArraysInRefinedFeature(feature);
				checkForArrayDimensionSizeInRefinedFeature(feature);
				return NOT_DONE;
			}
			
			@Override
			public String casePortConnection(PortConnection connection)
			{
				checkPortConnectionClassifiers(connection);
				return NOT_DONE;
			}
			
			@Override
			public String caseDirectedFeature(DirectedFeature feature)
			{
				checkFeatureDirectionInRefinement(feature);
				return NOT_DONE;
			}
			
			@Override
			public String caseAbstractFeature(AbstractFeature feature)
			{
				checkAbstractFeatureAndPrototypeDirectionConsistency(feature);
				checkForAddedDirectionInAbstractFeatureRefinement(feature);
				checkForAddedPrototypeOrClassifierInAbstractFeatureRefinement(feature);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeatureGroupType(FeatureGroupType featureGroupType)
			{
				checkForChainedInverseFeatureGroupTypes(featureGroupType);
				return NOT_DONE;
			}
			
			@Override
			public String caseGroupExtension(GroupExtension extension)
			{
				checkForExtendingAnInverseFeatureGroupType(extension);
				checkForInverseInFeatureGroupTypeExtension(extension);
				checkForRequiredInverseInFeatureGroupTypeExtension(extension);
				return NOT_DONE;
			}
			
			@Override
			public String caseFeatureGroup(FeatureGroup featureGroup)
			{
				checkForInverseInFeatureGroup(featureGroup);
				checkDirectionOfFeatureGroupMembers(featureGroup);
				return NOT_DONE;
			}
			
			@Override
			public String caseSubprogramAccess(SubprogramAccess subprogramAccess)
			{
				checkSubprogramAccessPrototypeReference(subprogramAccess);
				return NOT_DONE;
			}
			
			@Override
			public String caseSubprogramGroupAccess(SubprogramGroupAccess subprogramGroupAccess)
			{
				checkSubprogramGroupAccessPrototypeReference(subprogramGroupAccess);
				return NOT_DONE;
			}
			
			@Override
			public String caseAccess(Access access)
			{
				checkForAbstractFeatureDirectionInAccessRefinement(access);
				checkForAccessTypeInAccessRefinement(access);
				return NOT_DONE;
			}
			
			@Override
			public String caseDataAccess(DataAccess dataAccess)
			{
				checkDataAccessPrototypeReference(dataAccess);
				return NOT_DONE;
			}
			
			@SuppressWarnings("incomplete-switch")
			@Override
			public String caseOperation(Operation operation)
			{
				switch (operation.getOp())
				{
					case AND:
					case NOT:
					case OR:
						insertNecessaryListValueObjects(operation);
				}
				return NOT_DONE;
			}
			
			@Override
			public String caseEnumerationValue(EnumerationValue enumerationValue)
			{
				insertNecessaryListValueObjects(enumerationValue);
				return NOT_DONE;
			}
			
			@Override
			public String caseConstantValue(ConstantValue constantValue)
			{
				insertNecessaryListValueObjects(constantValue);
				return NOT_DONE;
			}
			
			@Override
			public String casePropertyReference(PropertyReference propertyReference)
			{
				insertNecessaryListValueObjects(propertyReference);
				return NOT_DONE;
			}
			//XXX: End of switch marker.
		};
	}
	
	/**
	 * Checks legality rule 3 in section 4.2 (Packages) on page 32.
	 * "A component implementation may be declared in both the public and private part of a package.
	 * In that case the declaration in the public part may only contain a properties subclause and a
	 * modes subclause."
	 * 
	 * Checks semantic rule 9 in section 4.2 (Packages) on page 33.
	 * "A component implementation can be declared in both the public and private section of a
	 * package.  If it is declared in both, then the public declaration is limited to containing
	 * property associations and modes and only those items are visible outside the package.  This
	 * allows component implementation to be made visible to other packages as variants of the same
	 * component type, while the details of the implementation, i.e., its realization expressed by
	 * the subcomponents and connections subclauses, are hidden in the private part.  The two
	 * declarations represent the same component implementation.
	 */
	private void checkComponentImplementationInPackageSection(ComponentImplementation componentImplementation)
	{
		if (componentImplementation.getOwner() instanceof PublicPackageSection &&
				((AadlPackage)componentImplementation.getElementRoot()).getPrivateSection() != null &&
				((AadlPackage)componentImplementation.getElementRoot()).getPrivateSection().findNamedElement(
						componentImplementation.getName()) instanceof ComponentImplementation)
		{
			for (EObject child : componentImplementation.eContents())
			{
				if (child instanceof ClassifierFeature && !(child instanceof ModeFeature))
				{
					error((Element)child, "When a component implementation is declared in both the public section and the private" +
							" section of a package, the implementation declaration in the public section can only contain a" +
							" properties subclause and a modes subclause.");
				}
			}
		}
	}
	
	/**
	 * Checks that the category of the component type rename is identical to the category of the
	 * specified component type.  This requirement is not in the standard yet.  Peter has been
	 * informed and it should be in a future errata.
	 */
	private void checkComponentTypeRenameCategory(ComponentTypeRename componentTypeRename)
	{
		if (!componentTypeRename.getCategory().getName().equals(componentTypeRename.getRenamedComponentType().getCategory()))
		{
			error(componentTypeRename, "The category of '" + componentTypeRename.getRenamedComponentType().getQualifiedName() +
					"' is not " + componentTypeRename.getCategory().getName());
		}
	}
	
	/**
	 * Checks legality rule 3 in section 4.3 (Component Types) on page 36.
	 * "The category of the component type being extended must match the category of the extending
	 * component type, i.e., they must be identical or the category being extended must be abstract."
	 */
	private void checkTypeExtensionCategory(TypeExtension typeExtension)
	{
		ComponentType parent = typeExtension.getExtended();
		ComponentType child = (ComponentType)typeExtension.getSpecific();
		if (!AadlParseUtil.canExtend(parent, child))
			error(typeExtension, "Cannot extend '" + parent.getQualifiedName() + "'.  Incompatible categories.");
	}
	
	/**
	 * Checks legality rule 5 in section 4.3 (Component Types) on page 36.
	 * "A component type must not contain both a requires_modes_subcluase and a modes_subclause."
	 * 
	 * Checks legality rule 6 in section 4.3 (Component Types) on page 36.
	 * "If the extended component type and an ancestor component type in the extends hierarchy
	 * contain modes subclauses, they must both be requires_modes_subclause or modes_subclause."
	 */
	private void checkComponentTypeModes(ComponentType componentType)
	{
		boolean containsModes = false;
		boolean containsRequiresModes = false;
		for (ComponentType currentType = componentType; currentType != null; currentType = currentType.getExtended())
		{
			for (Mode currentMode : currentType.getOwnedModes())
			{
				if (currentMode.isDerived())
					containsRequiresModes = true;
				else
					containsModes = true;
			}
		}
		if (containsModes && containsRequiresModes)
			error(componentType, "Component types cannot contain both modes and requires modes.");
	}
	
	/**
	 * Checks naming rule 6 in section 4.4 (Component Implementations) on page 41.
	 * "In a component implementation extension, the component type identifier of the component
	 * implementation being extended, which appears after the reserved word extends, must be the
	 * same as or an ancestor of the component type of the extension.  The component implementation
	 * being extended may exist in another package.  In this case the component implementation
	 * name is qualified with the package name."
	 */
	private void checkExtensionAndRealizationHierarchy(ImplementationExtension implementationExtension)
	{
		ComponentImplementation parent = implementationExtension.getExtended();
		ComponentImplementation child = (ComponentImplementation)implementationExtension.getSpecific();
		ComponentType typeOfParent = parent.getType();
		ComponentType typeOfChild = child.getType();
		boolean isAncestor = false;
		for (ComponentType currentType = typeOfChild; currentType != null && !isAncestor; currentType = currentType.getExtended())
			if (currentType.equals(typeOfParent))
				isAncestor = true;
		if (!isAncestor)
			error(implementationExtension,
					'\'' + typeOfParent.getQualifiedName() + "' is not an ancestor of '" + typeOfChild.getQualifiedName() + "'.");
	}
	
	/**
	 * Checks legality rule 3 in section 4.4 (Component Implementations) on page 42.
	 * "The category of the component implementation must be identical to the category of the
	 * component type for which the component implementation is declared."
	 */
	private void checkRealizationCategory(Realization realization)
	{
		ComponentType type = realization.getImplemented();
		ComponentImplementation implementation = (ComponentImplementation)realization.getSpecific();
		if (!type.getCategory().equals(implementation.getCategory()))
			error(realization, "The category of '" + type.getQualifiedName() + "' is not " + implementation.getCategory() + '.');
	}
	
	/**
	 * Checks legality rule 4 in section 4.4 (Component Implementation) on page 42.
	 * "If the component implementation extends another component implementation, the category of
	 * both must match, i.e., they must be identical or the category being extended must be abstract."
	 */
	private void checkImplementationExtensionCategory(ImplementationExtension implementationExtension)
	{
		ComponentImplementation parent = implementationExtension.getExtended();
		ComponentImplementation child = (ComponentImplementation)implementationExtension.getSpecific();
		if (!AadlParseUtil.canExtend(parent, child))
			error(implementationExtension, "Cannot extend '" + parent.getQualifiedName() + "'.  Incompatible categories.");
	}
	
	/**
	 * Checks legality rule 6 in section 4.4 (Component Implementations) on page 42.
	 * "If the component type of the component implementation contains a requires_modes_subclause
	 * then the component implementation must not contain any modes subclause."
	 * 
	 * Checks legality rule 7 in section 4.4 (Component Implementations) on page 42.
	 * "If modes are declared in the component type, then modes cannot be declared in component
	 * implementations."
	 */
	private void checkComponentImplementationModes(ComponentImplementation componentImplementation)
	{
		if (!componentImplementation.getOwnedModes().isEmpty())
		{
			boolean typeHasModes = false;
			for (ComponentType currentType = componentImplementation.getType(); currentType != null && !typeHasModes;
					currentType = currentType.getExtended())
			{
				if (!currentType.getOwnedModes().isEmpty())
					typeHasModes = true;
			}
			if (typeHasModes)
			{
				error(componentImplementation,
						"Implementation cannot contain modes because modes or requires modes are inherited from the type.");
			}
		}
	}
	
	/**
	 * Checks legality rule 9 in section 4.4 (Component Implementations) on page 42.
	 * "The category of a subcomponent being refined must match the category of the refining
	 * subcomponent declaration, i.e., they must be identical or the category being refined must be
	 * abstract."
	 * 
	 * Checks legality rule 3 in section 4.5 (Subcomponents) on page 47.
	 * "In a subcomponent refinement declaration the component category may be refined from abstract
	 * to one of the concrete component categories.  Otherwise the category must be the same as that
	 * of the subcomponent being refined."
	 */
	private void checkSubcomponentRefinementCategory(Subcomponent subcomponent)
	{
		ComponentCategory subcomponentCategory = subcomponent.getCategory();
		if (subcomponent.getRefined() != null)
		{
			ComponentCategory refinedCategory = subcomponent.getRefined().getCategory();
			if (!subcomponentCategory.equals(refinedCategory) && !refinedCategory.equals(ComponentCategory.ABSTRACT))
				error(subcomponent, "Cannot refine subcomponent.  Incompatible categories.");
		}
	}
	
	/**
	 * Checks legality rule 1 in section 4.5 (Subcomponents) on page 47.
	 * "The category of the subcomponent declaration must match the category of its corresponding
	 * component classifier reference or its prototype reference, i.e., they must be identical,
	 * or in the case of a classifier reference the referenced classifier category may be abstract."
	 */
	private void checkSubcomponentCategory(Subcomponent subcomponent)
	{
		ComponentCategory subcomponentCategory = subcomponent.getCategory();
		ComponentClassifier componentClassifier = subcomponent.getClassifier();
		ComponentPrototype componentPrototype = subcomponent.getPrototype();
		if (componentClassifier != null)
		{
			if (!subcomponentCategory.getName().equals(componentClassifier.getCategory()) &&
					!componentClassifier.getCategory().equals(ComponentCategory.ABSTRACT.getName()))
			{
				error(subcomponent, "The category of the subcomponent is incompatible with the category of the classifier");
			}
		}
		else if (componentPrototype != null)
		{
			if (!subcomponentCategory.equals(componentPrototype.getCategory()))
				error(subcomponent, "The category of the subcomponent is incompatible with the category of the prototype");
		}
	}
	
	/**
	 * Checks legality rule 7 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component type is refined to a concrete category, the features of the abstract
	 * component type must be acceptable for the concrete component type."
	 */
	private void checkFeaturesOfExtendedAbstractType(ComponentType componentType)
	{
		ComponentCategory typeCategory = null;
		if (componentType instanceof AbstractType)
			return;
		else if (componentType instanceof DataType)
			typeCategory = ComponentCategory.DATA;
		else if (componentType instanceof SubprogramType)
			typeCategory = ComponentCategory.SUBPROGRAM;
		else if (componentType instanceof SubprogramGroupType)
			typeCategory = ComponentCategory.SUBPROGRAM_GROUP;
		else if (componentType instanceof ThreadType)
			typeCategory = ComponentCategory.THREAD;
		else if (componentType instanceof ThreadGroupType)
			typeCategory = ComponentCategory.THREAD_GROUP;
		else if (componentType instanceof ProcessType)
			typeCategory = ComponentCategory.PROCESS;
		else if (componentType instanceof ProcessorType)
			typeCategory = ComponentCategory.PROCESSOR;
		else if (componentType instanceof VirtualProcessorType)
			typeCategory = ComponentCategory.VIRTUAL_PROCESSOR;
		else if (componentType instanceof MemoryType)
			typeCategory = ComponentCategory.MEMORY;
		else if (componentType instanceof BusType)
			typeCategory = ComponentCategory.BUS;
		else if (componentType instanceof VirtualBusType)
			typeCategory = ComponentCategory.VIRTUAL_BUS;
		else if (componentType instanceof DeviceType)
			typeCategory = ComponentCategory.DEVICE;
		else if (componentType instanceof SystemType)
			typeCategory = ComponentCategory.SYSTEM;
		Set<FeatureType> acceptableFeatureTypes = acceptableFeaturesForTypes.get(typeCategory);
		HashSet<FeatureType> typesOfInheritedFeatures = new HashSet<FeatureType>();
		for (ComponentType parent = componentType.getExtended(); parent instanceof AbstractType; parent = parent.getExtended())
			for (Feature feature : parent.getOwnedFeatures())
				typesOfInheritedFeatures.add(getFeatureType(feature));
		for (FeatureType featureType : typesOfInheritedFeatures)
		{
			if (!acceptableFeatureTypes.contains(featureType))
			{
				error(componentType.getOwnedExtension(), "A " + typeCategory.getName() +
						" type cannot extend an abstract type that contains " + featureType.getNameWithIndefiniteArticle() + '.');
			}
		}
	}
	
	/**
	 * Checks legality rule 8 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component implementation is refined to a concrete category, the subcomponents of
	 * the abstract component implementation must be acceptable for the concrete component implementation."
	 */
	private void checkSubcomponentsOfExtendedAbstractImplementation(ComponentImplementation componentImplementation)
	{
		ComponentCategory implementationCategory = null;
		if (componentImplementation instanceof AbstractImplementation)
			return;
		else if (componentImplementation instanceof DataImplementation)
			implementationCategory = ComponentCategory.DATA;
		else if (componentImplementation instanceof SubprogramImplementation)
			implementationCategory = ComponentCategory.SUBPROGRAM;
		else if (componentImplementation instanceof SubprogramGroupImplementation)
			implementationCategory = ComponentCategory.SUBPROGRAM_GROUP;
		else if (componentImplementation instanceof ThreadImplementation)
			implementationCategory = ComponentCategory.THREAD;
		else if (componentImplementation instanceof ThreadGroupImplementation)
			implementationCategory = ComponentCategory.THREAD_GROUP;
		else if (componentImplementation instanceof ProcessImplementation)
			implementationCategory = ComponentCategory.PROCESS;
		else if (componentImplementation instanceof ProcessorImplementation)
			implementationCategory = ComponentCategory.PROCESSOR;
		else if (componentImplementation instanceof VirtualProcessorImplementation)
			implementationCategory = ComponentCategory.VIRTUAL_PROCESSOR;
		else if (componentImplementation instanceof MemoryImplementation)
			implementationCategory = ComponentCategory.MEMORY;
		else if (componentImplementation instanceof BusImplementation)
			implementationCategory = ComponentCategory.BUS;
		else if (componentImplementation instanceof VirtualBusImplementation)
			implementationCategory = ComponentCategory.VIRTUAL_BUS;
		else if (componentImplementation instanceof DeviceImplementation)
			implementationCategory = ComponentCategory.DEVICE;
		else if (componentImplementation instanceof SystemImplementation)
			implementationCategory = ComponentCategory.SYSTEM;
		Set<ComponentCategory> acceptableSubcomponentCategories =
			acceptableSubcomponentCategoriesForImplementations.get(implementationCategory);
		HashSet<ComponentCategory> categoriesOfInheritedSubcomponents = new HashSet<ComponentCategory>();
		for (ComponentImplementation parent = componentImplementation.getExtended(); parent instanceof AbstractImplementation;
				parent = parent.getExtended())
		{
			for (Subcomponent subcomponent : parent.getOwnedSubcomponents())
				categoriesOfInheritedSubcomponents.add(subcomponent.getCategory());
		}
		for (ComponentCategory subcomponentCategory : categoriesOfInheritedSubcomponents)
		{
			if (!acceptableSubcomponentCategories.contains(subcomponentCategory))
			{
				error(componentImplementation.getOwnedExtension(), "A " + implementationCategory.getName() +
						" implementation cannot extend an abstract implementation that contains a " + subcomponentCategory.getName() +
						" subcomponent.");
			}
		}
	}
	
	/**
	 * Checks legality rule 7 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component type is refined to a concrete category, the features of the abstract
	 * component type must be acceptable for the concrete component type."
	 * 
	 * Checks legality rule 8 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component implementation is refined to a concrete category, the subcomponents of
	 * the abstract component implementation must be acceptable for the concrete component implementation."
	 */
	private void checkSubcomponentsHierarchy(Subcomponent subcomponent)
	{
		if (subcomponent.getCategory().equals(ComponentCategory.ABSTRACT))
			return;
		Subcomponent refinedSubcomponent = subcomponent;
		while (refinedSubcomponent.getClassifier() == null && refinedSubcomponent.getPrototype() == null &&
				refinedSubcomponent.getRefined() != null)
		{
			refinedSubcomponent = refinedSubcomponent.getRefined();
		}
		if (refinedSubcomponent.getClassifier() instanceof AbstractImplementation)
		{
			Set<ComponentCategory> acceptableSubcomponentCategories =
				acceptableSubcomponentCategoriesForImplementations.get(subcomponent.getCategory());
			HashSet<ComponentCategory> categoriesOfNestedSubcomponents = new HashSet<ComponentCategory>();
			for (ComponentImplementation impl = (ComponentImplementation)refinedSubcomponent.getClassifier();
					impl instanceof AbstractImplementation; impl = impl.getExtended())
			{
				for (Subcomponent nestedSubcomponent : impl.getOwnedSubcomponents())
					categoriesOfNestedSubcomponents.add(nestedSubcomponent.getCategory());
			}
			for (ComponentCategory nestedSubcomponentCategory : categoriesOfNestedSubcomponents)
			{
				if (!acceptableSubcomponentCategories.contains(nestedSubcomponentCategory))
				{
					error(subcomponent, "A " + subcomponent.getCategory().getName() +
							" subcomponent cannot refer to an abstract implementation that contains a " +
							nestedSubcomponentCategory.getName() + " subcomponent.");
				}
			}
		}
		AbstractType abstractType;
		if (refinedSubcomponent.getClassifier() instanceof AbstractType)
			abstractType = (AbstractType)refinedSubcomponent.getClassifier();
		else if (refinedSubcomponent.getClassifier() instanceof AbstractImplementation &&
				//This second part of this if expression will not be false for semantically correct models.
				((AbstractImplementation)refinedSubcomponent.getClassifier()).getOwnedRealization().getImplemented() instanceof AbstractType)
		{
			abstractType = ((AbstractImplementation)refinedSubcomponent.getClassifier()).getType();
		}
		else
			abstractType = null;
		if (abstractType != null)
		{
			Set<FeatureType> acceptableFeatureTypes = acceptableFeaturesForTypes.get(subcomponent.getCategory());
			HashSet<FeatureType> typesOfNestedFeatures = new HashSet<FeatureType>();
			for (ComponentType type = abstractType; type instanceof AbstractType; type = type.getExtended())
			{
				for (Feature nestedFeature : type.getOwnedFeatures())
					typesOfNestedFeatures.add(getFeatureType(nestedFeature));
			}
			for (FeatureType nestedFeatureType : typesOfNestedFeatures)
			{
				if (!acceptableFeatureTypes.contains(nestedFeatureType))
				{
					error(subcomponent, "A " + subcomponent.getCategory().getName() +
							" subcomponent cannot refer to an abstract type that contains " +
							nestedFeatureType.getNameWithIndefiniteArticle() + '.');
				}
			}
		}
	}
	
	/**
	 * Checks that the category of the prototype is identical to the category of the specified
	 * component classifier.  This requirement is not in the standard yet.  Peter has been
	 * informed and it should be in a future errata.
	 */
	private void checkComponentPrototypeCategory(ComponentPrototype prototype)
	{
		if (prototype.getConstrainingClassifier() != null &&
				!prototype.getCategory().getName().equals(prototype.getConstrainingClassifier().getCategory()))
		{
			error(prototype, "The category of '" + prototype.getConstrainingClassifier().getQualifiedName() +
					"' is not " + prototype.getCategory().getName());
		}
	}
	
	/**
	 * Checks legality rule 1 in section 4.7 (Prototypes) on page 56.
	 * "The component category declared in the component prototype binding must match the component
	 * category of the prototype or classifier being referenced, i.e., they must be identical, or
	 * the declared category component category of the prototype must be abstract."
	 * Peter needs to rewrite this rule into two separate rules.  The first will specify that the
	 * category of the formal prototype and the category specified in the binding must match (match
	 * also means that abstract can be refined to a concrete type).  The second will specify that
	 * the category specified in the binding and the category of the referenced classifier or
	 * prototype must match.  This method does the first check.
	 */
	private void checkComponentPrototypeBindingCategory(ComponentPrototypeBinding binding)
	{
		if (binding.getFormal() instanceof ComponentPrototype)
		{
			ComponentCategory formalCategory = ((ComponentPrototype)binding.getFormal()).getCategory();
			if (!formalCategory.equals(ComponentCategory.ABSTRACT))
			{
				for (ComponentPrototypeActual actual : binding.getActuals())
				{
					if (!formalCategory.equals(actual.getCategory()))
					{
						error(actual, "The category of the formal prototype is not compatible with the category specified in the" +
								" prototype binding.");
					}
				}
			}
		}
	}
	
	/**
	 * Checks legality rule 1 in section 4.7 (Prototypes) on page 56.
	 * "The component category declared in the component prototype binding must match the component
	 * category of the prototype or classifier being referenced, i.e., they must be identical, or
	 * the declared category component category of the prototype must be abstract."
	 * Peter needs to rewrite this rule into two separate rules.  The first will specify that the
	 * category of the formal prototype and the category specified in the binding must match (match
	 * also means that abstract can be refined to a concrete type).  The second will specify that
	 * the category specified in the binding and the category of the referenced classifier or
	 * prototype must match.  This method does the second check.
	 */
	private void checkComponentPrototypeActualComponentCategory(ComponentReference actual)
	{
		if (!actual.getClassifier().getCategory().equals(ComponentCategory.ABSTRACT.getName()) &&
				!actual.getCategory().getName().equals(actual.getClassifier().getCategory()))
		{
			error(actual, "The category of the referenced classifier is not compatible the category specified in the prototype binding.");
		}
	}
	
	/**
	 * Checks legality rule 1 in section 4.7 (Prototypes) on page 56.
	 * "The component category declared in the component prototype binding must match the component
	 * category of the prototype or classifier being referenced, i.e., they must be identical, or
	 * the declared category component category of the prototype must be abstract."
	 * Peter needs to rewrite this rule into two separate rules.  The first will specify that the
	 * category of the formal prototype and the category specified in the binding must match (match
	 * also means that abstract can be refined to a concrete type).  The second will specify that
	 * the category specified in the binding and the category of the referenced classifier or
	 * prototype must match.  This method does the second check.
	 */
	private void checkComponentPrototypeActualPrototypeCategory(ComponentPrototypeReference actual)
	{
		if (!actual.getPrototype().getCategory().equals(ComponentCategory.ABSTRACT) &&
				!actual.getCategory().equals(actual.getPrototype().getCategory()))
		{
			error(actual,
					"The category of the referenced prototype is not compatible with the category specified in the prototype binding.");
		}
	}
	
	/**
	 * Checks legality rule 6 in section 4.7 (Prototypes) on page 56.
	 * "If the direction is declared for feature prototypes, then the prototype actual satisfies the
	 * direction according to the same rules as for feature refinements (see Section 8); in the case
	 * of ports the direction must be in or out; in the case of data access, the access right must be
	 * read-only for in and write-only for out; in the case of bus access, subprogram access and
	 * subprogram group access the direction must not be in nor out."
	 * Peter is going to change the wording of this to make parts of it less restrictive.
	 * 
	 * Checks semantic rule 3 in section 4.7 (Prototypes) on page 57.
	 * "Prototypes can specify a parameterization of abstract features (feature) as well as feature
	 * group types for feature groups.  The prototype binding of an abstract feature can supply
	 * concrete features.  If a direction is specified for the abstract feature, the direction of the
	 * supplied feature must match."
	 */
	private void checkFeaturePrototypeBindingDirection(FeaturePrototypeBinding binding)
	{
		if (binding.getFormal() instanceof FeaturePrototype)
		{
			DirectionType formalDirection = ((FeaturePrototype)binding.getFormal()).getDirection();
			if (formalDirection != null && !formalDirection.equals(DirectionType.IN_OUT) &&
					!(binding.getActual() instanceof AccessSpecification))
			{
				DirectionType actualDirection;
				if (binding.getActual() instanceof FeaturePrototypeReference)
					actualDirection = ((FeaturePrototypeReference)binding.getActual()).getDirection();
				else
					actualDirection = ((PortSpecification)binding.getActual()).getDirection();
				if (!actualDirection.equals(formalDirection))
				{
					error(binding.getActual(),
							"The direction specified in the binding is inconsistent with the direction of the formal prototype.");
				}
			}
		}
	}
	
	/**
	 * Checks that the formal prototype of a ComponentPrototypeBinding is a ComponentPrototype.  This
	 * requirement is not explicitly in the standard.
	 */
	private void checkFormalOfComponentPrototypeBinding(ComponentPrototypeBinding binding)
	{
		if (!(binding.getFormal() instanceof ComponentPrototype))
			error(binding, '\'' + binding.getFormal().getName() + "' is not a component prototype.");
	}
	
	/**
	 * Checks that the formal prototype of a FeatureGroupPrototypeBinding is a FeatureGroupPrototype.
	 * This requirement is not explicitly in the standard.
	 */
	private void checkFormalOfFeatureGroupPrototypeBinding(FeatureGroupPrototypeBinding binding)
	{
		if (!(binding.getFormal() instanceof FeatureGroupPrototype))
			error(binding, '\'' + binding.getFormal().getName() + "' is not a feature group prototype.");
	}
	
	/**
	 * Checks that the formal prototype of a FeaturePrototypeBinding is a FeaturePrototype.  This
	 * requirement is not explicitly in the standard.
	 */
	private void checkFormalOfFeaturePrototypeBinding(FeaturePrototypeBinding binding)
	{
		if (!(binding.getFormal() instanceof FeaturePrototype))
			error(binding, '\'' + binding.getFormal().getName() + "' is not a feature prototype.");
	}
	
	/**
	 * Checks that component prototype refinements only refine component prototypes.  This requirement
	 * is not explicitly in the standard.
	 */
	private void checkRefinedOfComponentPrototype(ComponentPrototype prototype)
	{
		if (prototype.getRefined() != null && !(prototype.getRefined() instanceof ComponentPrototype))
			error(prototype, '\'' + prototype.getName() + "' is not a component prototype.");
	}
	
	/**
	 * Checks that feature group prototype refinements only refine feature group prototypes.  This
	 * requirement is not explicitly in the standard.
	 */
	private void checkRefinedOfFeatureGroupPrototype(FeatureGroupPrototype prototype)
	{
		if (prototype.getRefined() != null && !(prototype.getRefined() instanceof FeatureGroupPrototype))
			error(prototype, '\'' + prototype.getName() + "' is not a feature group prototype.");
	}
	
	/**
	 * Checks that feature prototype refinements only refine feature prototypes.  This requirement
	 * is not explicitly in the standard.
	 */
	private void checkRefinedOfFeaturePrototype(FeaturePrototype prototype)
	{
		if (prototype.getRefined() != null && !(prototype.getRefined() instanceof FeaturePrototype))
			error(prototype, '\'' + prototype.getName() + "' is not a feature prototype.");
	}
	
	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57.
	 * "A prototype refinement can increase the constraints on classifiers to be supplied.  The newly
	 * specified category, classifier, and array dimensions must satisfy the same matching rules as
	 * the prototype bindings."
	 * This method checks the component category only.
	 */
	private void checkCategoryOfRefinedComponentPrototype(ComponentPrototype prototype)
	{
		if (prototype.getRefined() != null && prototype.getRefined() instanceof ComponentPrototype)
		{
			ComponentCategory refinedPrototypeCategory = ((ComponentPrototype)prototype.getRefined()).getCategory();
			if (!refinedPrototypeCategory.equals(ComponentCategory.ABSTRACT) && !refinedPrototypeCategory.equals(prototype.getCategory()))
				error(prototype, "Incompatible category for prototype refinement.");
		}
	}
	
	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57.
	 * "A prototype refinement can increase the constraints on classifiers to be supplied.  The newly
	 * specified category, classifier, and array dimensions must satisfy the same matching rules as
	 * the prototype bindings."
	 * This method checks for array compatibility only.
	 */
	private void checkArrayOfRefinedComponentPrototype(ComponentPrototype prototype)
	{
		if (prototype.getRefined() != null && prototype.getRefined() instanceof ComponentPrototype)
		{
			ComponentPrototype refinedPrototype = (ComponentPrototype)prototype.getRefined();
			if (refinedPrototype.isArray() && !prototype.isArray())
				error(prototype, "Prototype must be an array because the refined prototype is an array.");
		}
	}
	
	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57.
	 * "A prototype refinement can increase the constraints on classifiers to be supplied.  The newly
	 * specified category, classifier, and array dimensions must satisfy the same matching rules as
	 * the prototype bindings."
	 * This method checks for feature direction only.
	 */
	private void checkDirectionOfRefinedFeaturePrototype(FeaturePrototype prototype)
	{
		if (prototype.getRefined() != null && prototype.getRefined() instanceof FeaturePrototype)
		{
			DirectionType refinedPrototypeDirection = ((FeaturePrototype)prototype.getRefined()).getDirection();
			if (refinedPrototypeDirection != null && !refinedPrototypeDirection.equals(DirectionType.IN_OUT) &&
					!refinedPrototypeDirection.equals(prototype.getDirection()))
			{
				error(prototype, "Incompatible direction for prototype refinement.");
			}
		}
	}
	
	/**
	 * Checks legality rule 2 in section 5.1 (Data) on page 62.
	 * "A data type declaration must not contain a flow specification or modes subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractType.
	 */
	private void checkForInheritedFlowsAndModesFromAbstractType(DataType dataType)
	{
		boolean parentHasFlowSpecs = false;
		boolean parentHasModes = false;
		boolean parentHasModeTransitions = false;
		for (ComponentType parentType = dataType.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended())
		{
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpecs = true;
			if (!parentType.getOwnedModes().isEmpty())
				parentHasModes = true;
			if (!parentType.getOwnedModeTransitions().isEmpty())
				parentHasModeTransitions = true;
		}
		if (parentHasFlowSpecs)
			error(dataType.getOwnedExtension(), "A data type cannot extend an abstract type that contains a flow specification.");
		if (parentHasModes)
			error(dataType.getOwnedExtension(), "A data type cannot extend an abstract type that contains modes.");
		if (parentHasModeTransitions)
			error(dataType.getOwnedExtension(), "A data type cannot extend an abstract type that contains a mode transition.");
	}
	
	/**
	 * Checks legality rule 4 in section 5.1 (Data) on page 62.
	 * "A data implementation must not contain a flow implementation, an end-to-end flow specification,
	 * or a modes subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedFlowsAndModesFromAbstractImplementation(DataImplementation dataImplementation)
	{
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasModes = false;
		boolean parentHasModeTransition = false;
		for (ComponentImplementation parentImplementation = dataImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!parentImplementation.getOwnedModes().isEmpty())
				parentHasModes = true;
			if (!parentImplementation.getOwnedModeTransitions().isEmpty())
				parentHasModeTransition = true;
		}
		if (parentHasFlowImpl)
		{
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow)
		{
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasModes)
		{
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains modes.");
		}
		if (parentHasModeTransition)
		{
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains a mode transition.");
		}
	}
	
	/**
	 * Checks legality rule 4 in section 5.5 (Thread Groups) on page 95.
	 * "A thread group must not contain a subprogam calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(ThreadGroupImplementation threadGroupImplementation)
	{
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = threadGroupImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence)
		{
			error(threadGroupImplementation.getOwnedExtension(),
					"A thread group implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 5 in section 6.1 (Processors) on page 102.
	 * "A processor implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(ProcessorImplementation processorImplementation)
	{
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = processorImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence)
		{
			error(processorImplementation.getOwnedExtension(),
					"A processor implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 4 in section 6.2 (Virtual Processors) on page 106.
	 * "A virtual processor implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(VirtualProcessorImplementation virtualProcessorImplementation)
	{
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = virtualProcessorImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence)
		{
			error(virtualProcessorImplementation.getOwnedExtension(),
					"A virtual processor implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 1 in section 6.3 (Memory) on page 109.
	 * "A memory type can contain bus access declarations, feature groups, a modes subclause, and
	 * property associations.  It must not contain flow specifications."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(MemoryType memoryType)
	{
		boolean parentHasFlowSpec = false;
		for (ComponentType parentType = memoryType.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended())
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpec = true;
		if (parentHasFlowSpec)
			error(memoryType.getOwnedExtension(), "A memory type cannot extend an abstract type that contains a flow specification.");
	}
	
	/**
	 * Checks legality rule 5 in section 6.3 (Memory) on page 110.
	 * "A memory implementation must not contain flows subclause, or subprogram calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedFlowsAndCallSequenceFromAbstractImplementation(MemoryImplementation memoryImplementation)
	{
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = memoryImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasFlowImpl)
		{
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow)
		{
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence)
		{
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 2 in section 6.4 (Buses) on page 111.
	 * "A bus type must not contain any flow specifications."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(BusType busType)
	{
		boolean parentHasFlowSpec = false;
		for (ComponentType parentType = busType.getExtended(); parentType instanceof AbstractType; parentType = parentType.getExtended())
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpec = true;
		if (parentHasFlowSpec)
			error(busType.getOwnedExtension(), "A bus type cannot extend an abstract type that contains a flow specification.");
	}
	
	/**
	 * Checks legality rule 5 in section 6.4 (Buses) on page 111.
	 * "A bus implementation must not contain a connections subclause, flows subclause, or
	 * subprogram calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(BusImplementation busImplementation)
	{
		boolean parentHasConnections = false;
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = busImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!parentImplementation.getOwnedConnections().isEmpty())
				parentHasConnections = true;
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasConnections)
		{
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains a connection.");
		}
		if (parentHasFlowImpl)
		{
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow)
		{
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence)
		{
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 2 in section 6.5 (Virtual Buses) on page 114.
	 * "A virtual bus type must not contain flow specifications."
	 * This rule is partly checked by the parser.  This method checks for inhertied members from an
	 * AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(VirtualBusType virtualBusType)
	{
		boolean parentHasFlowSpec = false;
		for (ComponentType parentType = virtualBusType.getExtended(); parentType instanceof AbstractType;
				parentType = parentType.getExtended())
		{
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpec = true;
		}
		if (parentHasFlowSpec)
		{
			error(virtualBusType.getOwnedExtension(),
					"A virtual bus type cannot extend an abstract type that contains a flow specification.");
		}
	}
	
	/**
	 * Checks legality rule 5 in section 6.5 (Virtual Buses) on page 114.
	 * "A virtual bus implementation must not contain a connections subclause, flows subclause, or
	 * subprogram calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(VirtualBusImplementation virtualBusImplementation)
	{
		boolean parentHasConnections = false;
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = virtualBusImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!parentImplementation.getOwnedConnections().isEmpty())
				parentHasConnections = true;
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasConnections)
		{
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains a connection.");
		}
		if (parentHasFlowImpl)
		{
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow)
		{
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence)
		{
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 2 in section 6.6 (Devices) on page 117.
	 * "A device component implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser.  This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedCallsFromAbstractImplementation(DeviceImplementation deviceImplementation)
	{
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = deviceImplementation.getExtended();
				parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation.getExtended())
		{
			if (!((AbstractImplementation)parentImplementation).getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence)
		{
			error(deviceImplementation.getOwnedExtension(),
					"A device implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}
	
	/**
	 * Checks legality rule 2 in section 8 (Features and Shared Access) on page 125.
	 * "A feature refinement declaration of a feature and the original feature must both be declared
	 * as port, parameter, access feature, or feature group, or the original feature must be declared
	 * as abstract feature."
	 * 
	 * Checks legality rule 4 in section 8.3 (Ports) on page 132.
	 * "The port category of a port refinement must be the same as the category of the port being
	 * refined, or the port being refined must be an abstract feature."
	 * This method was not written with L4 specifically in mind, but it does properly check L4.
	 * This is because there are separate meta-model classes for the various port categories (DataPort,
	 * EventPort, and EventDataPort).  If this data were stored in a field in Port, then this method
	 * would not be sufficient for L4.
	 */
	private void checkTypeOfFeatureRefinement(Feature feature)
	{
		if (feature.getRefined() != null && !(feature.getRefined() instanceof AbstractFeature) &&
				!feature.eClass().equals(feature.getRefined().eClass()))
		{
			error(feature, "Cannot refine " + FEATURE_CLASS_NAMES_WITH_ARTICLE.get(feature.getRefined().eClass()) + " into " +
					FEATURE_CLASS_NAMES_WITH_ARTICLE.get(feature.eClass()) + '.');
		}
	}
	
	/**
	 * Checks legality rule 3 in section 8 (Features and Shared Access) on page 125.
	 * "Feature arrays must only be declared for threads, devices, and processors."
	 */
	private void checkForFeatureArrays(Feature feature)
	{
		if (feature.getArraySpecification() != null)
		{
			ComponentType componentType = (ComponentType)feature.getOwner();
			if (!(componentType instanceof AbstractType) && !(componentType instanceof ThreadType) &&
					!(componentType instanceof DeviceType) && !(componentType instanceof ProcessorType))
			{
				error(feature, "Feature arrays can only be declared for abstract, thread, device, and processor classifiers.");
			}
		}
	}
	
	/**
	 * Checks legality rule 3 in section 8 (Features and Shared Access) on page 125.
	 * "Feature arrays must only be declared for threads, devices, and processors."
	 */
	private void checkForInheritedFeatureArrays(ComponentType componentType)
	{
		if (!(componentType instanceof AbstractType) && !(componentType instanceof ThreadType) && !(componentType instanceof DeviceType) &&
				!(componentType instanceof ProcessorType))
		{
			boolean parentHasFeatureArray = false;
			for (ComponentType parentType = componentType.getExtended(); parentType instanceof AbstractType;
					parentType = parentType.getExtended())
			{
				for (Feature inheritedFeature : parentType.getOwnedFeatures())
					if (inheritedFeature.getArraySpecification() != null)
						parentHasFeatureArray = true;
			}
			if (parentHasFeatureArray)
			{
				error(componentType.getOwnedExtension(),
						"A " + componentType.getCategory() + " type cannot extend an abstract type that contains feature arrays.");
			}
		}
	}
	
	/**
	 * Checks legality rule 4 in section 8 (Features and Shared Access) on page 125.
	 * "If the feature refinement specifies an array dimension, then the feature being refined must have
	 * an array dimension."
	 */
	private void checkForArraysInRefinedFeature(Feature feature)
	{
		if (feature.getArraySpecification() != null && feature.getRefined() != null && feature.getRefined().getArraySpecification() == null)
			error(feature.getArraySpecification(),
					"Cannot specify an array dimension because the refined feature doesn't have an array dimension.");
	}
	
	/**
	 * Checks legality rule 5 in section 8 (Features and Shared Access) on page 125.
	 * "If the refinement specifies an array dimension size, then the feature being refined must not have
	 * an array dimension size."
	 */
	private void checkForArrayDimensionSizeInRefinedFeature(Feature feature)
	{
		if (feature.getArraySpecification() != null && !feature.getArraySpecification().getSizes().isEmpty() &&
				feature.getRefined() != null && feature.getRefined().getArraySpecification() != null &&
				!feature.getRefined().getArraySpecification().getSizes().isEmpty())
		{
			error(feature.getArraySpecification().getSizes().get(0),
					"Cannot specify an array dimension size because the refined feature already specified the array dimension size.");
		}
	}
	
	/**
	 * Checks legality rule 1 in section 8.1 (Abstract Features) on page 126.
	 * "The feature direction in a refined feature declaration must be identical to the feature direction
	 * in the feature declaration being refined, or the feature being refined must not have a direction."
	 * 
	 * Checks legality rule 2 in section 8.1 (Abstract Features) on page 127.
	 * "If the direction of an abstract feature is specified, then the direction must be satisfied by the
	 * refinement (see also the rules for feature prototypes in Section 4.7); in the case of ports the
	 * direction must be in or out; in the case of data access, the access right must be read-only for in
	 * and write-only for out; in the case of bus access, subprogram access and subprogram group access
	 * the direction must not be in nor out."
	 * This method does not check access features.
	 * 
	 * Checks legality rule 5 in section 8.3 (Ports) on page 133.
	 * "The port direction of a port refinement must be the same as the direction of the feature being
	 * refined.  If the feature being refined is an abstract feature without direction, then all port
	 * directions are acceptable."
	 * 
	 * Checks legality rule 4 in section 8.5 (Subprogram Parameters) on page 148.
	 * "The parameter direction of a parameter refinement must be the same as the direction of the feature
	 * being refined.  If the feature being refined is an abstract feature without direction, then all
	 * parameter directions are acceptable."
	 */
	private void checkFeatureDirectionInRefinement(DirectedFeature feature)
	{
		DirectionType direction = feature.getDirection();
		if (feature.getRefined() instanceof DirectedFeature)
		{
			DirectionType refinedDirection = ((DirectedFeature)feature.getRefined()).getDirection();
			//For ports and parameters, the directions must be the same value.
			//All other DirectedFeatures have the option of refining from IN_OUT to IN or OUT.
			if (!direction.equals(refinedDirection) &&
					(feature.getRefined() instanceof Port || feature.getRefined() instanceof Parameter ||
							!refinedDirection.equals(DirectionType.IN_OUT)))
			{
				error(feature, "Incompatible direction in feature refinement.  The direction of the refined feature is '" +
						refinedDirection.getName() + "'.");
			}
		}
	}
	
	/**
	 * Checks legality rule 3 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature with a feature prototype identifier and the prototype being referenced must
	 * both specify the same direction or no direction."
	 */
	private void checkAbstractFeatureAndPrototypeDirectionConsistency(AbstractFeature feature)
	{
		if (feature.getPrototype() instanceof FeaturePrototype)
		{
			DirectionType featureDirection = feature.getDirection();
			DirectionType prototypeDirection = ((FeaturePrototype)feature.getPrototype()).getDirection();
			if (!featureDirection.equals(prototypeDirection))
			{
				if (prototypeDirection.equals(DirectionType.IN_OUT))
				{
					error(feature,
							"A direction cannot be specified on the abstract feature because its prototype does not specify a direction.");
				}
				else
				{
					error(feature, "The direction of the abstract feature must match the direction of its prototype." +
							"  The prototype's direction is '" + prototypeDirection.getName() + "'.");
				}
			}
		}
	}
	
	/**
	 * Checks legality rule 5 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature refinement declaration of a feature with a feature prototype reference must
	 * only add property associations."
	 */
	private void checkForAddedDirectionInAbstractFeatureRefinement(AbstractFeature feature)
	{
		AbstractFeature refinedFeature = (AbstractFeature)feature.getRefined();
		while (refinedFeature != null && !(refinedFeature.getPrototype() instanceof FeaturePrototype))
			refinedFeature = (AbstractFeature)refinedFeature.getRefined();
		if (refinedFeature != null)
		{
			if (refinedFeature.getDirection().equals(DirectionType.IN_OUT) && !feature.getDirection().equals(DirectionType.IN_OUT))
			{
				error(feature, "The refined feature refers to a feature prototype.  Therefore, a direction cannot be added in the" +
						" refinement because the direction will be specified in the prototype binding.");
			}
		}
	}
	
	/**
	 * Checks legality rule 5 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature refinement declaration of a feature with a feature prototype reference must
	 * only add property associations."
	 */
	private void checkForAddedPrototypeOrClassifierInAbstractFeatureRefinement(AbstractFeature feature)
	{
		AbstractFeature refinedFeature = (AbstractFeature)feature.getRefined();
		while (refinedFeature != null && !(refinedFeature.getPrototype() instanceof FeaturePrototype))
			refinedFeature = (AbstractFeature)refinedFeature.getRefined();
		if (refinedFeature != null)
		{
			if (feature.getClassifier() != null)
				error(feature, "Cannot refer to a classifier because the refined feature refers to a feature prototype.");
			else if (feature.getPrototype() != null && !feature.getPrototype().equals(refinedFeature.getPrototype()))
				error(feature, "The refiend feature already refers to a prototype.  The prototype cannot be changed in the refinement.");
		}
	}
	
	/**
	 * Checks legality rule 2 in section 8.2 (Feature Groups and Feature Group Types) on page 129.
	 * "A feature group type can be declared to be the inverse of another feature group type, as indicated
	 * by the reserved words inverse of and the name of a feature group type.  Any feature group type named
	 * in an inverse of statement cannot itself contain an inverse of statement.  This means that several
	 * feature groups can be declared to be the inverse of one feature group, e.g., B inverse of A and
	 * C inverse of A is acceptable.  However, chaining of inverses is not permitted, e.g., B inverse of A
	 * and C inverse of B is not acceptable."
	 */
	private void checkForChainedInverseFeatureGroupTypes(FeatureGroupType featureGroupType)
	{
		if (featureGroupType.getInverse() != null && featureGroupType.getInverse().getInverse() != null)
		{
			error(featureGroupType, "A feature group type cannot be an inverse of another feature group type that already contains an" +
					" 'inverse of' declaration.");
		}
	}
	
	/**
	 * Checks legality rule 3 in section 8.2 (Feature Groups and Feature Group Types) on page 129.
	 * "Only feature group types without inverse of or feature group types with features and inverse of
	 * can be extended."
	 */
	private void checkForExtendingAnInverseFeatureGroupType(GroupExtension extension)
	{
		FeatureGroupType extended = extension.getExtended();
		if (extended.getInverse() != null && extended.getOwnedFeatures().isEmpty())
		{
			error(extension, "Cannot extend a feature group type that contains an 'inverse of' declaration," +
					" but does not contain any locally defined features.");
		}
	}
	
	/**
	 * Checks legality rule 4 in section 8.2 (Feature Groups and Feature Group Types) on page 129.
	 * "A feature group type that is an extension of another feature group type without an inverse of
	 * cannot contain an inverse of statement."
	 */
	private void checkForInverseInFeatureGroupTypeExtension(GroupExtension extension)
	{
		FeatureGroupType extended = extension.getExtended();
		FeatureGroupType extending = (FeatureGroupType)extension.getSpecific();
		if (extending.getInverse() != null && extended.getInverse() == null)
		{
			error(extension, "A feature group type with an 'inverse of' declaration cannot extend a feature group type without an" +
					" 'inverse of' declaration.");
		}
	}
	
	/**
	 * Checks legality rule 5 in section 8.2 (Feature Groups and Feature Group Types) on page 129.
	 * "The feature group type that is an extension of another feature group type with features and
	 * inverse of that adds features must have an inverse of to identify the feature group type whose
	 * inverse it is."
	 */
	private void checkForRequiredInverseInFeatureGroupTypeExtension(GroupExtension extension)
	{
		FeatureGroupType extended = extension.getExtended();
		FeatureGroupType extending = (FeatureGroupType)extension.getSpecific();
		if (!extended.getOwnedFeatures().isEmpty() && extended.getInverse() != null && !extending.getOwnedFeatures().isEmpty() &&
				extending.getInverse() == null)
		{
			error(extending, "Must specify inverse because local features are defined and the extended feature group type has an" +
					" 'inverse of' declaration.");
		}
	}
	
	/**
	 * Checks legality rule 6 in section 8.2 (Feature Groups and Feature Group Types) on page 129.
	 * "A feature group declaration with an inverse of statement must only reference feature group
	 * types without an inverse of statement."
	 */
	private void checkForInverseInFeatureGroup(FeatureGroup featureGroup)
	{
		if (featureGroup.isInverse() && featureGroup.getFeatureGroupType() != null && featureGroup.getFeatureGroupType().getInverse() != null)
		{
			error(featureGroup, "Cannot specify 'inverse of' in the feature group because the referenced feature group type already" +
					" contains an 'inverse of' declaration.");
		}
	}
	
	/**
	 * Checks legality rule 13 in section 8.2 (Feature Groups and Feature Group Types) on page 129.
	 * "If an in or out direction is specified as part of a feature group declaration, then all features
	 * inside the feature group must satisfy this direction."
	 */
	private void checkDirectionOfFeatureGroupMembers(FeatureGroup featureGroup)
	{
		if (!featureGroup.getDirection().equals(DirectionType.IN_OUT) && featureGroup.getFeatureGroupType() != null)
		{
			for (Feature feature : featureGroup.getFeatureGroupType().getAllFeatures())
			{
				if (feature instanceof DirectedFeature && !((DirectedFeature)feature).getDirection().equals(featureGroup.getDirection()))
				{
					error(featureGroup, "All ports, parameters, feature groups, and abstract features in the referenced feature group" +
							" type must satisfy the direction specified in the feature group.");
				}
			}
		}
	}
	
	/**
	 * Checks a proposed legality rule for section 8.4 (Subprogram and Subprogram Group Access)
	 * "If a subprogram access refers to a component classifier or a component prototype, then the
	 * category of the classifier or prototype must be subprogram."
	 * For references to classifiers, the meta-model only allows for a subprogram classifier.  Therefore,
	 * this method only checks the prototype reference.
	 */
	private void checkSubprogramAccessPrototypeReference(SubprogramAccess subprogramAccess)
	{
		if (subprogramAccess.getPrototype() instanceof ComponentPrototype &&
				!((ComponentPrototype)subprogramAccess.getPrototype()).getCategory().equals(ComponentCategory.SUBPROGRAM))
		{
			error(subprogramAccess, "The category of the referenced component prototype must be subprogram.");
		}
	}
	
	/**
	 * Checks a proposed legality rule for section 8.4 (Subprogram and Subprogram Group Access)
	 * "If a subprogram group access refers to a component classifier or a component prototype, then
	 * the category of the classifier or prototype must be subprogram group."
	 * For references to classifiers, the meta-model only allows for a subprogram group classifier.
	 * Therefore, this method only checks the prototype reference.
	 */
	private void checkSubprogramGroupAccessPrototypeReference(SubprogramGroupAccess subprogramGroupAccess)
	{
		if (subprogramGroupAccess.getPrototype() instanceof ComponentPrototype &&
				!((ComponentPrototype)subprogramGroupAccess.getPrototype()).getCategory().equals(ComponentCategory.SUBPROGRAM_GROUP))
		{
			error(subprogramGroupAccess, "The category of the referenced component prototype must be subprogram group.");
		}
	}
	
	/**
	 * Checks a proposed legality rule for section 8.4 (Subprogram and Subprogram Group Access)
	 * "An abstract feature can be refined into a subprogram access or a subprogram group access.
	 * In this case, the abstract feature must not have a direction specified."
	 * 
	 * Checks a proposed legality rule for section 8.6 (Data Component Access)
	 * "An abstract feature can be refined into a data access.  In this case, the abstract feature
	 * must not have a direction specified."
	 * 
	 * Checks a proposed legality rule for section 8.7 (Bus Component Access)
	 * "An abstract feature can be refined into a bus access.  In this case, the abstract feature
	 * must not have a direction specified."
	 */
	private void checkForAbstractFeatureDirectionInAccessRefinement(Access access)
	{
		if (access.getRefined() instanceof AbstractFeature &&
				!((AbstractFeature)access.getRefined()).getDirection().equals(DirectionType.IN_OUT))
		{
			error(access, "An abstract feature with a direction specified cannot be refined into an access feature.");
		}
	}
	
	/**
	 * Checks a proposed legality rule for section 8.4 (Subprogram and Subprogram Group Access)
	 * "A provides subprogram access cannot be refined to a requires subprogram access and a requires
	 * subprogram access cannot be refined to a provides subprogram access.  Similarly, a provides
	 * subprogram group access cannot be refined to a requires subprogram group access and a requires
	 * subprogram group access cannot be refined to a provides subprogram group access."
	 * 
	 * Checks a proposed legality rule for section 8.6 (Data Component Access)
	 * "A provides data access cannot be refined to a requires data access and a requires data access
	 * cannot be refined to a provides data access."
	 * 
	 * Checks a proposed legality rule for section 8.7 (Bus Component Access)
	 * "A provides bus access cannot be refined to a requires bus access and a requires bus access
	 * cannot be refined to a provides bus access."
	 */
	private void checkForAccessTypeInAccessRefinement(Access access)
	{
		if (access.getRefined() instanceof Access && !access.getKind().equals(((Access)access.getRefined()).getKind()))
		{
			StringBuilder errorMessage = new StringBuilder("A ");
			errorMessage.append(getKeywordForAccessType(((Access)access.getRefined()).getKind()));
			errorMessage.append(" access cannot be refined into a ");
			errorMessage.append(getKeywordForAccessType(access.getKind()));
			errorMessage.append(" access.");
			error(access, errorMessage.toString());
		}
	}
	
	/**
	 * Checks a proposed legality rule for section 8.6 (Data Component Access)
	 * "If a data access refers to a component classifier or a component prototype, then the
	 * category of the classifier or prototype must be data."
	 * For references to classifiers, the meta-model only allows for a data classifier.  Therefore,
	 * this method only checks the prototype reference.
	 */
	private void checkDataAccessPrototypeReference(DataAccess dataAccess)
	{
		if (dataAccess.getPrototype() instanceof ComponentPrototype &&
				!((ComponentPrototype)dataAccess.getPrototype()).getCategory().equals(ComponentCategory.DATA))
		{
			error(dataAccess, "The category of the referenced component prototype must be data.");
		}
	}
	
	/**
	 * Quickly done to get ready for the course in November 2009.  Need to review this method
	 * and make sure that it is complete and in compliance with the standard.
	 * TODO: Review this method
	 */
	private void checkPortConnectionClassifiers(PortConnection connection)
	{
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if ((source instanceof DataAccess || source instanceof DataSubcomponent || source instanceof DataPort ||
				source instanceof EventDataPort) && (destination instanceof DataAccess || destination instanceof DataSubcomponent ||
						destination instanceof DataPort || destination instanceof EventDataPort))
		{
			ComponentClassifier sourceClassifier;
			ComponentClassifier destinationClassifier;
			if (source instanceof DataSubcomponent)
				sourceClassifier = ((DataSubcomponent)source).getAllClassifier();
			else
				sourceClassifier = ((Feature)source).getAllClassifier();
			if (destination instanceof DataSubcomponent)
				destinationClassifier = ((DataSubcomponent)destination).getAllClassifier();
			else
				destinationClassifier = ((Feature)destination).getAllClassifier();
			if (sourceClassifier != destinationClassifier)
			{
				if (sourceClassifier == null)
					warning(connection, '\'' + source.getName() + "' is missing a classifier.");
				else if (destinationClassifier == null)
					warning(connection, '\'' + destination.getName() + "' is missing a classifier.");
				else if (sourceClassifier instanceof ComponentType && destinationClassifier instanceof ComponentImplementation &&
						sourceClassifier.equals(((ComponentImplementation)destinationClassifier).getType()))
				{
					warning(connection, "The classifiers of '" + source.getName() + "' and '" + destination.getName() + "' do not match.");
				}
				else if (sourceClassifier instanceof ComponentImplementation && destinationClassifier instanceof ComponentType &&
						destinationClassifier.equals(((ComponentImplementation)sourceClassifier).getType()))
				{
					warning(connection, "The classifiers of '" + source.getName() + "' and '" + destination.getName() + "' do not match.");
				}
				else
					error(connection, '\'' + source.getName() + "' and '" + destination.getName() + "' have incompatible classifiers.");
			}
		}
	}
	
	/**
	 * Quickly added for the M1 release.  This may need to be reviewed when doing full type checking.
	 */
	private void insertNecessaryListValueObjects(PropertyExpression expression)
	{
		long actualLists = 0;
		Element owner = expression.getOwner();
		while (!(owner instanceof Property || owner instanceof PropertyConstant || owner instanceof ModalPropertyValue ||
				owner instanceof BasicPropertyAssociation))
		{
			if (!(owner instanceof ListValue))
			{
				/*
				 * The expression is part of a more complex expression.  ListValue objects can't exist at this level.
				 * Therefore, don't do anything.
				 */
				return;
			}
			actualLists++;
			owner = owner.getOwner();
		}
		long neededLists;
		if (owner instanceof Property)
			neededLists = ((Property)owner).getList();
		else if (owner instanceof PropertyConstant)
			neededLists = ((PropertyConstant)owner).getList();
		else if (owner instanceof ModalPropertyValue)
			neededLists = ((PropertyAssociation)owner.getOwner()).getProperty().getList();
		else //owner is an instance of BasicPropertyAssociation
			neededLists = ((BasicPropertyAssociation)owner).getProperty().getList();
		long listsToAdd = neededLists - actualLists;
		if (expression instanceof ConstantValue)
			listsToAdd -= ((ConstantValue)expression).getConstant().getList();
		else if (expression instanceof PropertyReference)
			listsToAdd -= ((PropertyReference)expression).getProperty().getList();
		if (listsToAdd > 0)
		{
			owner = expression.getOwner();
			ListValue newListValue = null;
			if (owner instanceof Property)
				newListValue = (ListValue)((Property)owner).createDefaultValue(Aadl2Package.eINSTANCE.getListValue());
			else if (owner instanceof PropertyConstant)
				newListValue = (ListValue)((PropertyConstant)owner).createConstantValue(Aadl2Package.eINSTANCE.getListValue());
			else if (owner instanceof ModalPropertyValue)
				newListValue = (ListValue)((ModalPropertyValue)owner).createOwnedValue(Aadl2Package.eINSTANCE.getListValue());
			else if (owner instanceof BasicPropertyAssociation)
				newListValue = (ListValue)((BasicPropertyAssociation)owner).createOwnedValue(Aadl2Package.eINSTANCE.getListValue());
			else //owner is an instance of ListValue
			{
				ListValue oldListValue = (ListValue)owner;
				for (ListIterator<PropertyExpression> iter = oldListValue.getOwnedListElements().listIterator(); iter.hasNext();)
				{
					if (iter.next() == expression)
					{
						newListValue = Aadl2Factory.eINSTANCE.createListValue();
						iter.set(newListValue);
						break;
					}
				}
			}
			listsToAdd--;
			for (long i = 0; i < listsToAdd; i++)
				newListValue = (ListValue)((ListValue)newListValue).createOwnedListElement(Aadl2Package.eINSTANCE.getListValue());
			newListValue.getOwnedListElements().add(expression);
		}
	}
	
	//XXX: End of check methods marker.
	
	private static FeatureType getFeatureType(Feature feature)
	{
		if (feature instanceof DataPort)
		{
			switch (((DataPort)feature).getDirection())
			{
				case IN:
					return FeatureType.IN_DATA_PORT;
				case OUT:
					return FeatureType.OUT_DATA_PORT;
				case IN_OUT:
					return FeatureType.IN_OUT_DATA_PORT;
			}
		}
		else if (feature instanceof EventPort)
		{
			switch (((EventPort)feature).getDirection())
			{
				case IN:
					return FeatureType.IN_EVENT_PORT;
				case OUT:
					return FeatureType.OUT_EVENT_PORT;
				case IN_OUT:
					return FeatureType.IN_OUT_EVENT_PORT;
			}
		}
		else if (feature instanceof EventDataPort)
		{
			switch (((EventDataPort)feature).getDirection())
			{
				case IN:
					return FeatureType.IN_EVENT_DATA_PORT;
				case OUT:
					return FeatureType.OUT_EVENT_DATA_PORT;
				case IN_OUT:
					return FeatureType.IN_OUT_EVENT_DATA_PORT;
			}
		}
		else if (feature instanceof FeatureGroup)
			return FeatureType.FEATURE_GROUP;
		else if (feature instanceof DataAccess)
		{
			switch (((DataAccess)feature).getKind())
			{
				case PROVIDED:
					return FeatureType.PROVIDES_DATA_ACCESS;
				case REQUIRED:
					return FeatureType.REQUIRES_DATA_ACCESS;
			}
		}
		else if (feature instanceof SubprogramAccess)
		{
			switch (((SubprogramAccess)feature).getKind())
			{
				case PROVIDED:
					return FeatureType.PROVIDES_SUBPROGRAM_ACCESS;
				case REQUIRED:
					return FeatureType.REQUIRES_SUBPROGRAM_ACCESS;
			}
		}
		else if (feature instanceof SubprogramGroupAccess)
		{
			switch (((SubprogramGroupAccess)feature).getKind())
			{
				case PROVIDED:
					return FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS;
				case REQUIRED:
					return FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS;
			}
		}
		else if (feature instanceof BusAccess)
		{
			switch (((BusAccess)feature).getKind())
			{
				case PROVIDED:
					return FeatureType.PROVIDES_BUS_ACCESS;
				case REQUIRED:
					return FeatureType.REQUIRES_BUS_ACCESS;
			}
		}
		else if (feature instanceof AbstractFeature)
			return FeatureType.ABSTRACT_FEATURE;
		else if (feature instanceof Parameter)
			return FeatureType.PARAMETER;
		return null;
	}
	
	private static String getKeywordForAccessType(AccessType accessType)
	{
		switch (accessType)
		{
			case PROVIDED:
				return "provides";
			case REQUIRED:
				return "requires";
			default:
				throw new AssertionError("Unhandled enum literal: " + accessType);
		}
	}
	
	static
	{
		HashMap<ComponentCategory, Set<FeatureType>> featuresForTypes = new HashMap<ComponentCategory, Set<FeatureType>>();
		
		//Abstract Types
		FeatureType[] featureTypesArray = new FeatureType[]{FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.REQUIRES_DATA_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.REQUIRES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE};
		Set<FeatureType> featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.ABSTRACT, Collections.unmodifiableSet(featureTypesSet));
		
		//Data Types
		featureTypesArray = new FeatureType[]{FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.DATA, Collections.unmodifiableSet(featureTypesSet));
		
		//Subprogram Types
		featureTypesArray = new FeatureType[]{FeatureType.OUT_EVENT_PORT, FeatureType.OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.REQUIRES_DATA_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.PARAMETER, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.SUBPROGRAM, Collections.unmodifiableSet(featureTypesSet));
		
		//Subprogram Group Types
		featureTypesArray = new FeatureType[]{FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.SUBPROGRAM_GROUP, Collections.unmodifiableSet(featureTypesSet));
		
		//Thread Types
		featureTypesArray = new FeatureType[]{FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS, FeatureType.REQUIRES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.THREAD, Collections.unmodifiableSet(featureTypesSet));
		
		//Thread Group Types
		featureTypesArray = new FeatureType[]{FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS, FeatureType.REQUIRES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.THREAD_GROUP, Collections.unmodifiableSet(featureTypesSet));
		
		//Process Types
		featureTypesArray = new FeatureType[]{FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS, FeatureType.REQUIRES_DATA_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.PROCESS, Collections.unmodifiableSet(featureTypesSet));
		
		//Processor Types
		featureTypesArray = new FeatureType[]{FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT,
				FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.PROCESSOR, Collections.unmodifiableSet(featureTypesSet));
		
		//Virtual Processor Types
		featureTypesArray = new FeatureType[]{FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT,
				FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT, FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.VIRTUAL_PROCESSOR, Collections.unmodifiableSet(featureTypesSet));
		
		//Memory Types
		featureTypesArray = new FeatureType[]{FeatureType.REQUIRES_BUS_ACCESS, FeatureType.PROVIDES_BUS_ACCESS, FeatureType.FEATURE_GROUP,
				FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.MEMORY, Collections.unmodifiableSet(featureTypesSet));
		
		//Bus Types
		featureTypesArray = new FeatureType[]{FeatureType.REQUIRES_BUS_ACCESS, FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.BUS, Collections.unmodifiableSet(featureTypesSet));
		
		//Virtual Bus Types
		featureTypesSet = Collections.emptySet();
		featuresForTypes.put(ComponentCategory.VIRTUAL_BUS, featureTypesSet);
		
		//Device Types
		featureTypesArray = new FeatureType[]{FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS, FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.DEVICE, Collections.unmodifiableSet(featureTypesSet));
		
		//System Types
		featureTypesArray = new FeatureType[]{FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS, FeatureType.REQUIRES_SUBPROGRAM_ACCESS, FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS, FeatureType.PROVIDES_BUS_ACCESS, FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_DATA_ACCESS, FeatureType.REQUIRES_DATA_ACCESS, FeatureType.ABSTRACT_FEATURE};
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.SYSTEM, Collections.unmodifiableSet(featureTypesSet));
		
		acceptableFeaturesForTypes = Collections.unmodifiableMap(featuresForTypes);
		
		HashMap<ComponentCategory, Set<ComponentCategory>> categoriesForImplementations =
			new HashMap<ComponentCategory, Set<ComponentCategory>>();
		
		//Abstract Implementations
		HashSet<ComponentCategory> categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory currentCategory : ComponentCategory.values())
			categoriesSet.add(currentCategory);
		categoriesForImplementations.put(ComponentCategory.ABSTRACT, Collections.unmodifiableSet(categoriesSet));
		
		//Data Implementations
		ComponentCategory[] categoriesArray = new ComponentCategory[]{ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
				ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.DATA, Collections.unmodifiableSet(categoriesSet));
		
		//Subprogram Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.DATA, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.SUBPROGRAM, Collections.unmodifiableSet(categoriesSet));
		
		//Subprogram Group Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.SUBPROGRAM, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.SUBPROGRAM_GROUP, Collections.unmodifiableSet(categoriesSet));
		
		//Thread Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.DATA, ComponentCategory.SUBPROGRAM, ComponentCategory.SUBPROGRAM_GROUP,
				ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.THREAD, Collections.unmodifiableSet(categoriesSet));
		
		//Thread Group Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.DATA, ComponentCategory.SUBPROGRAM, ComponentCategory.SUBPROGRAM_GROUP,
				ComponentCategory.THREAD, ComponentCategory.THREAD_GROUP, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.THREAD_GROUP, Collections.unmodifiableSet(categoriesSet));
		
		//Process Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.DATA, ComponentCategory.SUBPROGRAM, ComponentCategory.SUBPROGRAM_GROUP,
				ComponentCategory.THREAD, ComponentCategory.THREAD_GROUP, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.PROCESS, Collections.unmodifiableSet(categoriesSet));
		
		//Processor Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.MEMORY, ComponentCategory.BUS,
				ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.PROCESSOR, Collections.unmodifiableSet(categoriesSet));
		
		//Virtual Processor Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.VIRTUAL_BUS,
				ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.VIRTUAL_PROCESSOR, Collections.unmodifiableSet(categoriesSet));
		
		//Memory Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.MEMORY, ComponentCategory.BUS, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.MEMORY, Collections.unmodifiableSet(categoriesSet));
		
		//Bus Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.BUS, Collections.unmodifiableSet(categoriesSet));
		
		//Virtual Bus Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.VIRTUAL_BUS, Collections.unmodifiableSet(categoriesSet));
		
		//Device Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.DEVICE, Collections.unmodifiableSet(categoriesSet));
		
		//System Implementations
		categoriesArray = new ComponentCategory[]{ComponentCategory.DATA, ComponentCategory.SUBPROGRAM, ComponentCategory.SUBPROGRAM_GROUP,
				ComponentCategory.PROCESS, ComponentCategory.PROCESSOR, ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.MEMORY,
				ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS, ComponentCategory.DEVICE, ComponentCategory.SYSTEM,
				ComponentCategory.ABSTRACT};
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.SYSTEM, Collections.unmodifiableSet(categoriesSet));
		
		acceptableSubcomponentCategoriesForImplementations = Collections.unmodifiableMap(categoriesForImplementations);
		
		Map<EClass, String> featureClassNamesWithArticle = new HashMap<EClass, String>();
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getAbstractFeature(), "an abstract feature");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getBusAccess(), "a bus access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getDataAccess(), "a data access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getSubprogramAccess(), "a subprogram access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getSubprogramGroupAccess(), "a subprogram group access");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getFeatureGroup(), "a feature group");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getParameter(), "a parameter");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getDataPort(), "a data port");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getEventDataPort(), "an event data port");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getEventPort(), "an event port");
		FEATURE_CLASS_NAMES_WITH_ARTICLE = Collections.unmodifiableMap(featureClassNamesWithArticle);
	}
}