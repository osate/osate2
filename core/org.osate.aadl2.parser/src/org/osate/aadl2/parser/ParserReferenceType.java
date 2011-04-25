package org.osate.aadl2.parser;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public enum ParserReferenceType {
	//This can be removed when Dio removes flow implementation refinements from the parser.
	@UnusedReferenceType
	RefinementReference,
	
	//Used internally by the parser.  The parser really should be modified and this reference type should be removed.
	@UnusedReferenceType
	ProcessorSubprogramCallReference,
	
	//Used internally by the parser.  The parser really should be modified and this reference type should be removed.
	@UnusedReferenceType
	ModeTriggerFromSelfReference,

	//Used internally by the parser.  The parser really should be modified and this reference type should be removed.
	@UnusedReferenceType
	ModeTriggerFromProcessorReference,
	
	//Deal with this later.
	@UnusedReferenceType
	AnnexElementReference,
	
	//No Dependencies
	WithStatementReference,
	
	//No Dependencies
	BaseUnitIdentifierReference,
	
	PackageRenameReference(WithStatementReference),
	
	// ComponentTypeRename containes two labels
	// the first one identifies the package
	// the second one identifies the classifier
	ComponentTypeRename(WithStatementReference),

	// FeatureGroupTypeRename containes two labels
	// the first one identifies the package
	// the second one identifies the classifier
	FeatureGroupTypeRename(WithStatementReference),
	
	RenamesAll(WithStatementReference),
	
	DimensionPropertyReference(WithStatementReference),
	
	PropertyValuePropertyTypeReference(WithStatementReference),
	
	PropertyTypeReference(WithStatementReference),
	
	RangeTypePropertyTypeReference(WithStatementReference),
	
	PropertyDefinitionReference(WithStatementReference),
	
	PropertyUnitsTypeReference(WithStatementReference),
	
	// the first label may be a sign
	RealRangeLowerBoundConstantReference(WithStatementReference),
	
	//the first label may be a sign
	RealRangeUpperBoundConstantReference(WithStatementReference),

	//the first label may be a sign
	IntegerRangeLowerBoundConstantReference(WithStatementReference),
	
	//the first label may be a sign
	IntegerRangeUpperBoundConstantReference(WithStatementReference),

	LowerBoundPropertyConstantReference(WithStatementReference),
	
	UpperBoundPropertyConstantReference(WithStatementReference),
	
	DeltaPropertyConstantReference(WithStatementReference),
	
	// the first label may be a sign
	PropertyOrConstantReference(WithStatementReference),
	
	BooleanOrConstantPropertyOrConstantReference(WithStatementReference),
	
	// it can contains two labels
	// 1) package name (optional)
	// 2) classifier name with an optional ".impl" to encode the implementation
	// the impl was decide to be bundled in the second label because if
	// forms a single name
	ClassifierReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),

	RealizationReference(ComponentTypeRename),

	// it can contain two labels:
	// 1) optional package name
	// 2) type name
	ComponentTypeExtensionReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),
	
	// It can contains three labels:
	// 1) optional package name
	// 2) type name,
	// 3) implementation name
	ComponentImplementationExtensionReference(WithStatementReference, PackageRenameReference),
	
	// This is a reference for an individual element in an array
	// It is expected to have a list of the size of the array
	// Example in the data_subcomponent parser rule.
	// The addition of these references are in the order they appear
	// in the "array list." So resolving them in order should give you
	// the order in which they appear in the specific array. This also
	// means that all the array element reference for the same array
	// are in a single continuous segment of the unresolvedReference array.
	// This reference must be a reference to an implementation, i.e., it
	// should contain type.impl. The parser verifies this.
	ArrayElementClassifierReference(WithStatementReference, PackageRenameReference),
	
	// contains two labels: package::subprogram
	PackageSubprogramCallReference(WithStatementReference, PackageRenameReference),
	
	FeatureGroupTypeExtendReference(WithStatementReference, PackageRenameReference, RenamesAll, FeatureGroupTypeRename),
	
	FeatureGroupTypeReference(WithStatementReference, PackageRenameReference, RenamesAll, FeatureGroupTypeRename),
	
	FeatureClassifierReference(WithStatementReference, PackageRenameReference),
	
	FeaturePortSpecificationClassifierReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),

	FeatureAccessSpecificationClassifierReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),
	
	FeatureGroupClassifierReference(WithStatementReference, PackageRenameReference),
	
	PortClassifierReference(WithStatementReference, PackageRenameReference),
	
	AccessFeatureClassifierReference(WithStatementReference, PackageRenameReference),
	
	FeatureGroupPrototypeClassifierReference(WithStatementReference, PackageRenameReference, RenamesAll, FeatureGroupTypeRename),
	
	FeaturePrototypeClassifierReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),
	
	ComponentPrototypeClassifierReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),
	
	FeatureGroupTypeInverseOfReference(WithStatementReference, PackageRenameReference, RenamesAll, FeatureGroupTypeRename),
	
	ClassifierValueComponentTypeReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename, FeatureGroupTypeRename),

	ClassifierValueComponentImplementationReference(WithStatementReference, PackageRenameReference),
	
	//Can be dependent on itself if there are nested record values.  This self-dependency is taken care of as a special case in the name resolver.
	PropertyRecordFieldReference(PropertyValuePropertyTypeReference, PropertyDefinitionReference, PropertyTypeReference),
	
	PropertyAssociationInBindingReference(WithStatementReference, PackageRenameReference, RenamesAll, ComponentTypeRename),
	
	ParameterClassifierReference(WithStatementReference, PackageRenameReference),
	
	SubcomponentClassifierReference(WithStatementReference, PackageRenameReference),
	
	ParameterRefinementReference(ComponentTypeExtensionReference),
	
	FlowSpecificationRefinementReference(ComponentTypeExtensionReference),

	SubcomponentRefinementReference(ComponentImplementationExtensionReference),
	
	EndToEndFlowRefinementReference(ComponentImplementationExtensionReference),
	
	ConnectionRefinementReference(ComponentImplementationExtensionReference),

	// contains one mode reference in the in_modes parsing rule.
	// A continuous segment of InModeRefernce's will be added in
	// the order they appear in the syntax rule: "in modes (m1,m2,...)"
	InModesReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// contains three labels: package::context.subprogram
	PackageAndContextSubprogramCallReference(WithStatementReference, PackageRenameReference, ComponentTypeExtensionReference),
	
	// a subprogram call reference of the form "subprogram", i.e.,
	// only one label.
	// This identifier can also be a prototype
	SubprogramCallReference(ComponentTypeExtensionReference, RealizationReference, ComponentImplementationExtensionReference, RenamesAll, ComponentTypeRename),

	// the source context of a feature connection
	FeatureConnectionSourceContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// the destination context of a feature connection
	FeatureConnectionDestinationContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// reference to context of source of a port connection
	PortConnectionDestinationContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// reference to context of source of a port connection
	PortConnectionSourceContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	ParameterConnectionSourceContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	ParameterConnectionDestinationContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	AccessConnectionSourceContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	AccessConnectionDestinationContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	FeatureGroupConnectionSourceContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// This is a reference from the implementation
	// to the specification it is implementing
	FlowImplementationSpecificationReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// it contains a single label that identifies the external port
	ModeTriggerFromExternalPortReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),

	// Same as ClassifierReference but:
	// This is either a prototype (look for it first)
	// or a classifier
	// it contains one label with the identifier that we
	// already know has no package, and one resolved object
	// (in ReferenceRecord.getResolvedObjects()): ComponentCategory
	// to be added to the resolved actual
	PrototypeOrClassifierReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference,
			RealizationReference, RenamesAll, ComponentTypeRename),

	PrototypeOrFeatureGroupTypeReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference,
			RealizationReference, RenamesAll, FeatureGroupTypeRename),

	FeaturePrototypeReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference),

	FeatureClassifierOrPrototypeReference(ComponentTypeExtensionReference),
	
	FeatureGroupPrototypeOrClassifierReference(RenamesAll, FeatureGroupTypeRename, ComponentTypeExtensionReference),
	
	PortPrototypeOrClassifierReference(ComponentTypeExtensionReference, RenamesAll, ComponentTypeRename),
	
	AccessFeaturePrototypeOrClassifierReference(RenamesAll, ComponentTypeRename, ComponentTypeExtensionReference),
	
	FeatureGroupPrototypeRefinementReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference),
	
	FeaturePrototypeRefinementReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference),
	
	ComponentPrototypeRefinementReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference),
	
	AbstractFeatureRefinementReference(ComponentTypeExtensionReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	FeatureGroupRefinementReference(ComponentTypeExtensionReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	PortRefinementReference(ComponentTypeExtensionReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	AccessFeatureRefinementReference(ComponentTypeExtensionReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	PropertyUnitLiteralReference(PropertyUnitsTypeReference, PropertyTypeReference, RangeTypePropertyTypeReference, PropertyValuePropertyTypeReference,
			PropertyDefinitionReference, PropertyRecordFieldReference),
	
	EnumerationLiteralOrPropertyOrConstantReference(PropertyTypeReference, PropertyValuePropertyTypeReference, PropertyRecordFieldReference,
			PropertyDefinitionReference, WithStatementReference),
	
	BooleanOrConstantEnumerationLiteralOrPropertyOrConstantReference(WithStatementReference, PropertyTypeReference, PropertyValuePropertyTypeReference,
			PropertyRecordFieldReference, PropertyDefinitionReference),
	
	SourceModeReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),
	
	DestinationModeReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),
	
	ModeOrTransitionReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference),
	
	FeatureGroupConnectionDestinationContextReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference), 
	
	ParameterPrototypeOrClassifierReference(ComponentTypeExtensionReference, RenamesAll, ComponentTypeRename),
	
	// the prototype formal is the reference back to the prototype in a
	// prototype binding
	PrototypeFormalReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, FeatureGroupTypeExtendReference,
			SubcomponentClassifierReference, ArrayElementClassifierReference, ClassifierReference, FeatureGroupTypeReference),
	
	SubcomponentPrototypeOrClassifierReference(RenamesAll, ComponentTypeRename, ComponentTypeExtensionReference, RealizationReference,
			ComponentImplementationExtensionReference),
	
	FlowSpecificationInFeatureReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference,
			FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference, FeatureGroupTypeExtendReference,
			FeatureGroupTypeInverseOfReference, PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
			FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference),
	
	FlowSpecificationOutFeatureReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference,
			FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference, FeatureGroupTypeExtendReference,
			FeatureGroupTypeInverseOfReference, PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
			FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference),
	
	//FlowImplementationConnectionReference and FlowImplementationFlowElementReference must be declared next to each other.  This is required so that
	//ReferenceRecordComparator will compare them properly.  They must be equivalent so that the references are resolved based upon parse order.
	//See ReferenceRecordComparator for the actual magic.
	FlowImplementationConnectionReference(ComponentImplementationExtensionReference),
	
	FlowImplementationFlowElementReference(ComponentImplementationExtensionReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference,
			SubcomponentRefinementReference, ComponentTypeExtensionReference, RealizationReference, PrototypeFormalReference, ClassifierReference,
			PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference),
	
	// reference to the source port
	PortConnectionSourcePortReference(PortConnectionSourceContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference, PrototypeFormalReference, FeatureGroupTypeReference,
			PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference,
			SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, ClassifierReference, PrototypeOrClassifierReference,
			ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference, PortClassifierReference, PortPrototypeOrClassifierReference,
			PortRefinementReference, FeatureClassifierReference, FeatureClassifierOrPrototypeReference, AbstractFeatureRefinementReference),
	
	// reference to the source port
	PortConnectionDestinationPortReference(PortConnectionDestinationContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference, PrototypeFormalReference, FeatureGroupTypeReference,
			PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference,
			SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, ClassifierReference, PrototypeOrClassifierReference,
			ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference, PortClassifierReference, PortPrototypeOrClassifierReference,
			PortRefinementReference, FeatureClassifierReference, FeatureClassifierOrPrototypeReference, AbstractFeatureRefinementReference),
	
	AccessConnectionSourceReference(AccessConnectionSourceContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference,
			FeatureGroupPrototypeRefinementReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference),
	
	AccessConnectionDestinationReference(AccessConnectionDestinationContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference,
			FeatureGroupPrototypeRefinementReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference),
	
	//This also has a self-dependency.  For a chain of elements, a different ReferenceRecord is created for each element.
	//The resolution of the current element depends on the previous element being resolved.
	ContainedPathElementReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference, SubcomponentClassifierReference,
			SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference, PrototypeFormalReference, ClassifierReference,
			PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference, FeatureGroupClassifierReference,
			FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference,
			FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference),
	
	// referencingObject = mode
	// from syntax m => m1: labels m and m1 are added in that order
	ModeMappingReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference, SubcomponentClassifierReference,
			SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference, PrototypeFormalReference, ClassifierReference,
			PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference),
	
	// the source of a feature connection
	FeatureConnectionSourceReference(FeatureConnectionSourceContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
			ComponentPrototypeRefinementReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	// the destination of a feature connection
	FeatureConnectionDestinationReference(FeatureConnectionDestinationContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
			ComponentPrototypeRefinementReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	FeatureGroupConnectionDestinationReference(FeatureGroupConnectionDestinationContextReference, ComponentTypeExtensionReference,
			ComponentImplementationExtensionReference, RealizationReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference,
			SubcomponentRefinementReference, PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
			ComponentPrototypeRefinementReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	// contains two labels: context.subprogram
	ContextSubprogramCallReference(ComponentTypeExtensionReference, RealizationReference, ComponentImplementationExtensionReference, RenamesAll,
			ComponentTypeRename, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
			ComponentPrototypeRefinementReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
			FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference, AccessFeatureClassifierReference,
			AccessFeaturePrototypeOrClassifierReference, AccessFeatureRefinementReference),
	
	FeatureGroupConnectionSourceReference(FeatureGroupConnectionSourceContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
			ComponentPrototypeRefinementReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference,
			FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference),
	
	FlowImplementationInFeatureReference(FlowImplementationSpecificationReference, FlowSpecificationInFeatureReference, FlowSpecificationRefinementReference),
	
	FlowImplementationOutFeatureReference(FlowImplementationSpecificationReference, FlowSpecificationOutFeatureReference, FlowSpecificationRefinementReference),
	
	ParameterConnectionSourceReference(ParameterConnectionSourceContextReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
			RealizationReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference,
			PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference,
			FeatureGroupPrototypeRefinementReference, PackageSubprogramCallReference, PackageAndContextSubprogramCallReference, SubprogramCallReference,
			ContextSubprogramCallReference, SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference,
			ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference,
			AccessFeatureClassifierReference, AccessFeaturePrototypeOrClassifierReference, AccessFeatureRefinementReference, FeatureClassifierReference,
			FeatureClassifierOrPrototypeReference, AbstractFeatureRefinementReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference,
			ParameterClassifierReference, ParameterPrototypeOrClassifierReference, ParameterRefinementReference, PortClassifierReference,
			PortPrototypeOrClassifierReference, PortRefinementReference),
	
	ParameterConnectionDestinationReference(ParameterConnectionDestinationContextReference, ComponentTypeExtensionReference,
			ComponentImplementationExtensionReference, RealizationReference, FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference,
			FeatureGroupRefinementReference, PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
			FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference, PackageSubprogramCallReference,
			PackageAndContextSubprogramCallReference, SubprogramCallReference, ContextSubprogramCallReference, SubcomponentClassifierReference,
			SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference, ClassifierReference, PrototypeOrClassifierReference,
			ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference, AccessFeatureClassifierReference,
			AccessFeaturePrototypeOrClassifierReference, AccessFeatureRefinementReference, FeatureClassifierReference, FeatureClassifierOrPrototypeReference,
			AbstractFeatureRefinementReference, FeatureGroupTypeExtendReference, FeatureGroupTypeInverseOfReference, ParameterClassifierReference,
			ParameterPrototypeOrClassifierReference, ParameterRefinementReference, PortClassifierReference, PortPrototypeOrClassifierReference,
			PortRefinementReference),
	
	// it contains two labels. The first one identifies the subcomponent
	// or feature group and the second identifies its port
	ModeTriggerFromSubcomponentOrFeatureGroupReference(ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference,
			SubcomponentClassifierReference, SubcomponentPrototypeOrClassifierReference, SubcomponentRefinementReference, PrototypeFormalReference,
			ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference, ComponentPrototypeRefinementReference,
			FeatureGroupClassifierReference, FeatureGroupPrototypeOrClassifierReference, FeatureGroupRefinementReference, FeatureGroupTypeExtendReference,
			FeatureGroupTypeInverseOfReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference, FeatureGroupPrototypeClassifierReference,
			FeatureGroupPrototypeRefinementReference, PackageAndContextSubprogramCallReference, PackageSubprogramCallReference, ContextSubprogramCallReference,
			SubprogramCallReference, AccessFeatureClassifierReference, AccessFeaturePrototypeOrClassifierReference, AccessFeatureRefinementReference,
			FeatureClassifierReference, FeatureClassifierOrPrototypeReference, AbstractFeatureRefinementReference);
	
	
	private final ParserReferenceType[] dependenciesArray;
	private final Set<ParserReferenceType> dependencies;
	
	private ParserReferenceType(ParserReferenceType... dependenciesArray)
	{
		this.dependenciesArray = dependenciesArray;
		HashSet<ParserReferenceType> dependencies = new HashSet<ParserReferenceType>();
		for (ParserReferenceType currentDependency : dependenciesArray)
			dependencies.add(currentDependency);
		this.dependencies = Collections.unmodifiableSet(dependencies);
	}
	
	public Set<ParserReferenceType> getDependencies()
	{
		return dependencies;
	}
	
	public static void main(String[] args) throws NoSuchFieldException
	{
		checkUnusedReferenceTypesForDependencies();
		checkForDuplicateDependencies();
		checkForSelfDependency();
		System.out.println("Finished checking ParserReferenceType");
	}
	
	private static void checkForDuplicateDependencies()
	{
		for (ParserReferenceType currentLiteral : ParserReferenceType.values())
			for (int i = 0; i < currentLiteral.dependenciesArray.length; i++)
				for (int j = i + 1; j < currentLiteral.dependenciesArray.length; j++)
					if (currentLiteral.dependenciesArray[i].equals(currentLiteral.dependenciesArray[j]))
						System.out.println(currentLiteral.dependenciesArray[i] + " appears more than once in " + currentLiteral);
	}
	
	private static void checkForSelfDependency()
	{
		for (ParserReferenceType currentLiteral : ParserReferenceType.values())
			for (ParserReferenceType currentDependency : currentLiteral.dependencies)
				if (currentDependency.equals(currentLiteral))
					System.out.println(currentLiteral + " depends on itself");
	}
	
	private static void checkUnusedReferenceTypesForDependencies() throws NoSuchFieldException
	{
		HashSet<ParserReferenceType> unusedReferenceTypes = new HashSet<ParserReferenceType>();
		for (ParserReferenceType currentLiteral : ParserReferenceType.values())
			if (ParserReferenceType.class.getDeclaredField(currentLiteral.name()).getAnnotation(UnusedReferenceType.class) != null)
				unusedReferenceTypes.add(currentLiteral);
		if (unusedReferenceTypes.size() > 0)
		{
			for (ParserReferenceType currentUnusedLiteral : unusedReferenceTypes)
				if (currentUnusedLiteral.dependencies.size() > 0)
					System.out.println("Unused type " + currentUnusedLiteral + " cannot have dependencies");
			for (ParserReferenceType currentLiteral : ParserReferenceType.values())
				for (ParserReferenceType currentDependency : currentLiteral.dependencies)
					if (unusedReferenceTypes.contains(currentDependency))
						System.out.println(currentLiteral + " depends on the unused type " + currentDependency);
		}
	}
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	private static @interface UnusedReferenceType{}
}