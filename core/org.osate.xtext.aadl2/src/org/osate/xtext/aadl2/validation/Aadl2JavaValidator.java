
package org.osate.xtext.aadl2.validation;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.osate.aadl2.*;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;


public class Aadl2JavaValidator extends AbstractAadl2JavaValidator {

	

	
	@Check(CheckType.FAST)
	public void caseComponentImplementation(
			ComponentImplementation componentImplementation) {
		checkEndId(componentImplementation);
		checkComponentImplementationUniqueNames(componentImplementation);	
		checkComponentImplementationInPackageSection(componentImplementation);
		checkComponentImplementationModes(componentImplementation);
	}

	@Check(CheckType.FAST)
	public void caseTypeExtension(TypeExtension typeExtension) {
		checkTypeExtensionCategory(typeExtension);
		checkFeaturesOfExtendedAbstractType((ComponentType) typeExtension.getSpecific());
		checkClassifierReference(typeExtension.getExtended(), typeExtension);
	}

	@Check(CheckType.FAST)
	public void caseComponentType(ComponentType componentType) {
		checkEndId(componentType);
		checkComponentTypeUniqueNames(componentType);
		checkComponentTypeModes(componentType);
		checkForInheritedFeatureArrays(componentType);
	}

	@Check(CheckType.FAST)
	public void caseImplementationExtension(
			ImplementationExtension implementationExtension) {
		checkExtensionAndRealizationHierarchy(implementationExtension);
		checkImplementationExtensionCategory(implementationExtension);
		checkSubcomponentsOfExtendedAbstractImplementation((ComponentImplementation) implementationExtension
				.getSpecific());
		checkClassifierReference(implementationExtension.getExtended(), implementationExtension);
	}

	@Check(CheckType.FAST)
	public void caseRealization(Realization realization) {
		checkRealizationCategory(realization);
	}

	@Check(CheckType.FAST)
	public void caseComponentTypeRename(ComponentTypeRename componentTypeRename) {
		checkComponentTypeRenameCategory(componentTypeRename);
		checkClassifierReference(componentTypeRename.getRenamedComponentType(), componentTypeRename);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupTypeRename(FeatureGroupTypeRename fgtRename) {
		checkClassifierReference(fgtRename.getRenamedFeatureGroupType(), fgtRename);
	}

	@Check(CheckType.FAST)
	public void caseSubcomponent(Subcomponent subcomponent) {
		checkSubcomponentCategory(subcomponent);
		checkSubcomponentRefinementCategory(subcomponent);
		checkSubcomponentsHierarchy(subcomponent);
		checkClassifierReference(subcomponent.getClassifier(), subcomponent);
//		checkPropertyAssocs(subcomponent);
	}

	@Check(CheckType.FAST)
	public void caseComponentPrototype(ComponentPrototype prototype) {
		checkComponentPrototypeCategory(prototype);
		checkRefinedOfComponentPrototype(prototype);
		checkCategoryOfRefinedComponentPrototype(prototype);
		checkArrayOfRefinedComponentPrototype(prototype);
		checkClassifierReference(prototype.getConstrainingClassifier(), prototype);
	}

	@Check(CheckType.FAST)
	public void caseComponentPrototypeBinding(ComponentPrototypeBinding binding) {
		checkComponentPrototypeBindingCategory(binding);
		checkFormalOfComponentPrototypeBinding(binding);
	}

	@Check(CheckType.FAST)
	public void caseComponentPrototypeActual(ComponentPrototypeActual prototypeActual) {
		checkComponentPrototypeActualComponentCategory(prototypeActual);
		if (prototypeActual.getSubcomponentType() instanceof Classifier){
			checkClassifierReference((Classifier)prototypeActual.getSubcomponentType(), prototypeActual);
		}
	}

	@Check(CheckType.FAST)
	public void caseFeaturePrototypeBinding(FeaturePrototypeBinding binding) {
		checkFeaturePrototypeBindingDirection(binding);
		checkFormalOfFeaturePrototypeBinding(binding);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupPrototypeBinding(
			FeatureGroupPrototypeBinding binding) {
		checkFormalOfFeatureGroupPrototypeBinding(binding);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupPrototypeActual(FeatureGroupPrototypeActual prototypeActual) {
		if (prototypeActual.getFeatureType() instanceof Classifier){
			checkClassifierReference((Classifier)prototypeActual.getFeatureType(), prototypeActual);
		}
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupPrototype(FeatureGroupPrototype prototype) {
		checkRefinedOfFeatureGroupPrototype(prototype);
	}

	@Check(CheckType.FAST)
	public void caseFeaturePrototype(FeaturePrototype prototype) {
		checkRefinedOfFeaturePrototype(prototype);
		checkDirectionOfRefinedFeaturePrototype(prototype);
	}

	@Check(CheckType.FAST)
	public void casePortSpecification(PortSpecification portspec) {
			checkClassifierReference(portspec.getClassifier(), portspec);
	}

	@Check(CheckType.FAST)
	public void caseAccessSpecification(AccessSpecification accessspec) {
			checkClassifierReference(accessspec.getClassifier(), accessspec);
	}

	@Check(CheckType.FAST)
	public void caseComponentImplementationReference(ComponentImplementationReference ciref) {
			checkClassifierReference(ciref.getImplementation(), ciref);
	}

	@Check(CheckType.FAST)
	public void caseDataType(DataType dataType) {
		checkForInheritedFlowsAndModesFromAbstractType(dataType);

	}

	@Check(CheckType.FAST)
	public void caseDataImplementation(DataImplementation dataImplementation) {
		checkForInheritedFlowsAndModesFromAbstractImplementation(dataImplementation);

	}

	@Check(CheckType.FAST)
	public void caseThreadGroupImplementation(
			ThreadGroupImplementation threadGroupImplementation) {
		checkForInheritedCallSequenceFromAbstractImplementation(threadGroupImplementation);

	}

	@Check(CheckType.FAST)
	public void caseProcessorImplementation(
			ProcessorImplementation processorImplementation) {
		checkForInheritedCallSequenceFromAbstractImplementation(processorImplementation);

	}

	@Check(CheckType.FAST)
	public void caseVirtualProcessorImplementation(
			VirtualProcessorImplementation virtualProcessorImplementation) {
		checkForInheritedCallSequenceFromAbstractImplementation(virtualProcessorImplementation);

	}

	@Check(CheckType.FAST)
	public void caseMemoryType(MemoryType memoryType) {
		checkForInheritedFlowsFromAbstractType(memoryType);

	}

	@Check(CheckType.FAST)
	public void caseMemoryImplementation(
			MemoryImplementation memoryImplementation) {
		checkForInheritedFlowsAndCallSequenceFromAbstractImplementation(memoryImplementation);

	}

	@Check(CheckType.FAST)
	public void caseBusType(BusType busType) {
		checkForInheritedFlowsFromAbstractType(busType);

	}

	@Check(CheckType.FAST)
	public void caseBusImplementation(BusImplementation busImplementation) {
		checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(busImplementation);

	}

	@Check(CheckType.FAST)
	public void caseVirtualBusType(VirtualBusType virtualBusType) {
		checkForInheritedFlowsFromAbstractType(virtualBusType);

	}

	@Check(CheckType.FAST)
	public void caseVirtualBusImplementation(
			VirtualBusImplementation virtualBusImplementation) {
		checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(virtualBusImplementation);

	}

	@Check(CheckType.FAST)
	public void caseDeviceImplementation(
			DeviceImplementation deviceImplementation) {
		checkForInheritedCallsFromAbstractImplementation(deviceImplementation);

	}

	@Check(CheckType.FAST)
	public void caseFeature(Feature feature) {
		checkTypeOfFeatureRefinement(feature);
		checkForFeatureArrays(feature);
		checkForArraysInRefinedFeature(feature);
		checkForArrayDimensionSizeInRefinedFeature(feature);
		checkClassifierReference(feature.getClassifier(),feature);
//		checkPropertyAssocs(feature);
	}

	
	@Check(CheckType.FAST)
	public void caseConnection(Connection connection) {
		checkDefiningID(connection);

	}
	
	@Check(CheckType.FAST)
	public void casePortConnection(PortConnection connection) {
		checkPortConnectionClassifiers(connection);
		checkPortConnectionDirection(connection);
		checkPortConnectionEnds(connection);

	}

	@Check(CheckType.FAST)
	public void caseDirectedFeature(DirectedFeature feature) {
		checkFeatureDirectionInRefinement(feature);

	}

	@Check(CheckType.FAST)
	public void caseAbstractFeature(AbstractFeature feature) {
		checkAbstractFeatureAndPrototypeDirectionConsistency(feature);
		checkForAddedDirectionInAbstractFeatureRefinement(feature);
		checkForAddedPrototypeOrClassifierInAbstractFeatureRefinement(feature);

	}

	@Check(CheckType.FAST)
	public void caseFeatureGroupType(FeatureGroupType featureGroupType) {
		checkEndId(featureGroupType);
		checkForChainedInverseFeatureGroupTypes(featureGroupType);

	}

	@Check(CheckType.FAST)
	public void caseGroupExtension(GroupExtension extension) {
		checkForExtendingAnInverseFeatureGroupType(extension);
		checkForInverseInFeatureGroupTypeExtension(extension);
		checkForRequiredInverseInFeatureGroupTypeExtension(extension);
		checkClassifierReference(extension.getExtended(), extension);
	}

	@Check(CheckType.FAST)
	public void caseFeatureGroup(FeatureGroup featureGroup) {
		checkForInverseInFeatureGroup(featureGroup);
		checkDirectionOfFeatureGroupMembers(featureGroup);
	}

	@Check(CheckType.FAST)
	public void caseSubprogramAccess(SubprogramAccess subprogramAccess) {
		checkSubprogramAccessPrototypeReference(subprogramAccess);
	}

	@Check(CheckType.FAST)
	public void caseSubprogramGroupAccess(
			SubprogramGroupAccess subprogramGroupAccess) {
		checkSubprogramGroupAccessPrototypeReference(subprogramGroupAccess);
	}

	@Check(CheckType.FAST)
	public void caseAccess(Access access) {
		checkForAbstractFeatureDirectionInAccessRefinement(access);
		checkForAccessTypeInAccessRefinement(access);
	}

	@Check(CheckType.FAST)
	public void caseDataAccess(DataAccess dataAccess) {
		checkDataAccessPrototypeReference(dataAccess);
	}

	@Check(CheckType.FAST)
	public void caseSubprogramCall(SubprogramCall callSpec) {
		if (callSpec.getCalledSubprogram() instanceof Classifier){
			checkClassifierReference((Classifier)callSpec.getCalledSubprogram(),callSpec);
		}
		if (callSpec.getContext() instanceof Classifier){
			checkClassifierReference((Classifier)callSpec.getContext(),callSpec);
		}
	}
	
//	@Check(CheckType.FAST)
//	public void caseAadlPackage(AadlPackage pack){
////		checkEndId(pack);
////		if (PropertiesLinkingService.getPropertiesLinkingService(pack).hasDuplicatesAadlPackage(pack)){
////			error(pack,"Duplicate packages "+ pack.getName());
////		}
//	}

	
	
	@Check(CheckType.FAST)
	public void caseModelUnit(ModelUnit pack){
		checkEndId(pack);
	}


	@Check(CheckType.FAST)
	public void casePackageRename(PackageRename packrename) {
		checkPackageReference(packrename.getRenamedPackage(), packrename);
	}


	
//	
//	@Check(CheckType.FAST)
//	public void caseClassifier(Classifier pack){
//		if (PropertiesLinkingService.getPropertiesLinkingService(pack).hasDuplicatesClassifier(pack)){
//			error(pack,"Duplicate classifiers "+ pack.getName());
//		}
//	}

//	@Check(CheckType.FAST)
//	public void caseAadlPackageSection(PackageSection ps) {
//		checkPropertyAssocs(ps);
//	}
//
//	@Check(CheckType.FAST)
//	public void caseMode(Mode m) {
//		checkPropertyAssocs(m);
//	}
//
//	@Check(CheckType.FAST)
//	public void caseComponentClassifier(ComponentClassifier cc) {
//		checkPropertyAssocs(cc);
//	}
//
//	@Check(CheckType.FAST)
//	public void caseThreadSubcomponent(ThreadSubcomponent ts) {
//		checkPropertyAssocs(ts);
//	}
//
//	// public void caseFeatureGroupType(FeatureGroupType f){
//	// checkPropertyAssocs(f);
//	// }
//	// public void caseConnection(Connection conn) {
//	// checkPropertyAssocs(conn);
//	// }

//
//	/**
//	 * Check that PropertyReference elements that are referenced in boolean
//	 * expressions have boolean type.
//	 */
//	@Check(CheckType.FAST)
//	public void casePropertyReference(PropertyReference bopr) {
//		checkPropertyReference(bopr);
//	}
//
//	@Check(CheckType.FAST)
//	public void casePropertyConstant(PropertyConstant pc) {
//		checkPropertyConstant(pc);
//	}

//
//	@Check(CheckType.FAST)
//	public void caseFlowSpec(FlowSpecification fs) {
//		checkPropertyAssocs(fs);
//	}
//
//	@Check(CheckType.FAST)
//	public void caseFlowSequence(FlowSequence fs) {
//		checkPropertyAssocs(fs);
//	}
//
//	/**
//	 * check property definition
//	 */
//	@Check(CheckType.FAST)
//	public void caseProperty(Property pd) {
//		checkProperty(pd);
//	}

	@Check(CheckType.FAST)
	public void caseUnitsType(final UnitsType ut) {
		final Set seen = new HashSet();
		final EList literals = ut.getOwnedLiterals();
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(literals);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(ne, "Unit '" + ne.getName()
						+ "' previously declared in enumeration");
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseEnumerationType(final EnumerationType et) {
		final Set seen = new HashSet();
		final EList literals = et.getOwnedLiterals();
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(literals);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(ne, "Literal '" + ne.getName()
						+ "' previously declared in enumeration");
			}
		}
	}

	@Check(CheckType.FAST)
	public void caseRangeType(RangeType nt) {
//		checkRangeType(nt);
		if (nt.getNumberType() != nt.getOwnedNumberType()){
			checkPropertySetElementReference(nt.getNumberType(), nt);
		}
	}

	@Check(CheckType.FAST)
	public void caseBasicProperty(BasicProperty bp) {
		if (bp.getPropertyType() != bp.getOwnedPropertyType()){
			checkPropertySetElementReference(bp.getPropertyType(), bp);
		}
	}

	@Check(CheckType.FAST)
	public void caseProperty(Property bp) {
		if (bp.getPropertyType() != bp.getOwnedPropertyType()){
			checkPropertySetElementReference(bp.getPropertyType(), bp);
		}
		checkPropertyDefinition(bp);
	}

	@Check(CheckType.FAST)
	public void caseListType(ListType bp) {
		if (bp.getElementType() != bp.getOwnedElementType()){
			checkPropertySetElementReference(bp.getElementType(), bp);
		}
	}

	@Check(CheckType.FAST)
	public void casePropertyConstant(PropertyConstant bp) {
		if (bp.getPropertyType() != bp.getOwnedPropertyType()){
			checkPropertySetElementReference(bp.getPropertyType(), bp);
		}
		checkPropertyConstant(bp);
	}
	
	@Check(CheckType.FAST)
	public void caseNumberType(NumberType nt) {
		checkNumberType(nt);
		if (nt.getUnitsType() != nt.getOwnedUnitsType()){
			checkPropertySetElementReference(nt.getUnitsType(), nt);
		}
	}

	@Check(CheckType.FAST)
	public void caseAadlinteger(final AadlInteger ai) {
		checkAadlinteger(ai);
	}

	
	/**
	 * check ID at after 'end'
	 */
	public void checkEndId(Classifier cl){
		ICompositeNode n = NodeModelUtils.getNode(cl);
		INode lln = getLastLeaf(n).getPreviousSibling();
		while (lln instanceof HiddenLeafNode){
			lln = lln.getPreviousSibling();
		}
		String ss = lln.getText();
		ss = ss.replaceAll(" ","");
//		while (ss.startsWith(" ")){
//			ss = ss.substring(1);
//		}
		if (!cl.getName().equalsIgnoreCase(ss)){
			error(cl, "Ending '" + ss +
					"' does not match defining identifier '"
					+ cl.getName()+"'");
		}
	}
	
	public void checkEndId(ModelUnit mu){
		ICompositeNode n = NodeModelUtils.getNode(mu);
		INode lln =getPreviousNode(getLastLeaf(n));
		String ss = lln.getText();
		lln = getPreviousNode(lln);
		while (lln.getText().equalsIgnoreCase("::")){
			lln = getPreviousNode(lln);
			ss = lln.getText()+"::"+ss;
		}
		if (!mu.getName().equalsIgnoreCase(ss)){
			error(mu, "Ending '" + ss +
					"' does not match defining identifier '"
					+ mu.getName()+"'");
		}
	}
	
	public void checkPackageReference(AadlPackage pack, Element context){
		if (Aadl2Util.isNull(pack)) return;
		Namespace contextNS = AadlUtil.getContainingTopLevelNamespace(context);
		if (!AadlUtil.isImportedPackage(pack, contextNS)){
			error(context, "The referenced package '" + pack.getName() +"' is not listed in a with clause.");
		}
	}

	
	protected INode getLastLeaf(INode node) {
		INode result = node;
		while (result instanceof ICompositeNode)
			result = ((ICompositeNode) result).getLastChild();
		return result != null ? result : node;
	}
	
	protected INode getPreviousNode(INode node) {
		INode lln = node.getPreviousSibling();
		while (lln instanceof HiddenLeafNode){
			lln = lln.getPreviousSibling();
		}
		return lln;
	}
	
	/**
	 * check for unique names in component type
	 */
	public void checkComponentTypeUniqueNames(ComponentType type) {
		// process in core package
		EList l = new BasicEList();
		l.addAll(type.getAllFlowSpecifications());	
		l.addAll(type.getAllFeatures());
		l.addAll(type.getAllModes());
		l.addAll(type.getAllModeTransitions());
		l.addAll(type.getAllPrototypes());
		EList<NamedElement> doubles = AadlUtil.findDoubleNamedElementsInList(l);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(ne,
						ne.eClass().getName() +
						" identifier '" + ne.getName() + "' previously defined. Maybe you forgot 'refined to'");
			}
		}
	}
	
	/**
	 * check for unique names in implementation
	 */
	public void checkComponentImplementationUniqueNames(ComponentImplementation impl) {
		// process in core package
		EList usedNames = new BasicEList();
		usedNames.addAll(impl.getAllPrototypes());
		usedNames.addAll(impl.getAllFeatures());
		usedNames.addAll(impl.getAllSubcomponents());
		usedNames.addAll(impl.getAllConnections());
		usedNames.addAll(impl.getAllModes());
		usedNames.addAll(impl.getAllModeTransitions());
		usedNames.addAll(impl.getType().getAllFlowSpecifications());
		usedNames.addAll( impl.getAllEndToEndFlows());
		EList<SubprogramCallSequence> csl = null;
		if (impl instanceof ThreadImplementation){
			csl = ((ThreadImplementation)impl).getOwnedSubprogramCallSequences();
		} else if (impl instanceof SubprogramImplementation){
			csl = ((SubprogramImplementation)impl).getOwnedSubprogramCallSequences();
		}
		if (csl != null){
			usedNames.addAll(csl);
			for (SubprogramCallSequence subprogramCallSequence : csl) {
				usedNames.addAll(subprogramCallSequence.getOwnedCallSpecifications());
			}
		}
	
		EList<NamedElement> doubles =
				AadlUtil.findDoubleNamedElementsInList(usedNames);
		if (doubles.size() > 0) {
			for (NamedElement ne : doubles) {
				error(impl, "Identifier '" + ne.getName() +
						"' has previously been defined in implementation '"
						+ impl.getQualifiedName()+ "' or in type '"+impl.getTypeName()+"'");
			}
		}
	}


	/*
	 * supporting semantic check methods They can on the error reporter thus
	 * reside in here
	 */

	/**
	 * Checks legality rule 3 in section 4.2 (Packages) on page 32. "A component
	 * implementation may be declared in both the public and private part of a
	 * package. In that case the declaration in the public part may only contain
	 * a properties subclause and a modes subclause."
	 * 
	 * Checks semantic rule 9 in section 4.2 (Packages) on page 33. "A component
	 * implementation can be declared in both the public and private section of
	 * a package. If it is declared in both, then the public declaration is
	 * limited to containing property associations and modes and only those
	 * items are visible outside the package. This allows component
	 * implementation to be made visible to other packages as variants of the
	 * same component type, while the details of the implementation, i.e., its
	 * realization expressed by the subcomponents and connections subclauses,
	 * are hidden in the private part. The two declarations represent the same
	 * component implementation.
	 */
	private void checkComponentImplementationInPackageSection(
			ComponentImplementation componentImplementation) {
		if (componentImplementation.getOwner() instanceof PublicPackageSection
				&& ((AadlPackage) componentImplementation.getElementRoot())
						.getPrivateSection() != null
				&& ((AadlPackage) componentImplementation.getElementRoot())
						.getPrivateSection().findNamedElement(
								componentImplementation.getName()) instanceof ComponentImplementation) {
			for (EObject child : componentImplementation.eContents()) {
				if (child instanceof ClassifierFeature
						&& !(child instanceof ModeFeature)) {
					error("When a component implementation is declared in both the public section and the private"
							+ " section of a package, the implementation declaration in the public section can only contain a"
							+ " properties subclause and a modes subclause.",
							(Element) child,
							Aadl2Package.eINSTANCE
									.getComponentClassifier_OwnedMode());
				}
			}
		}
	}

	/**
	 * Checks that the category of the component type rename is identical to the
	 * category of the specified component type. This requirement is not in the
	 * standard yet. Peter has been informed and it should be in a future
	 * errata.
	 */
	private void checkComponentTypeRenameCategory(
			ComponentTypeRename componentTypeRename) {
		if (Aadl2Util.isNull(componentTypeRename.getRenamedComponentType())){
//			error(componentTypeRename,"Component type rename reference could not be resolved.");
			return;
		}
		if (!componentTypeRename.getCategory().getName()
				.equals(componentTypeRename.getRenamedComponentType()
						.getCategory())) {
			error("The category of '"
					+ componentTypeRename.getRenamedComponentType()
							.getQualifiedName() + "' is not "
					+ componentTypeRename.getCategory().getName(),
					componentTypeRename,
					Aadl2Package.eINSTANCE
							.getComponentTypeRename_RenamedComponentType());
		}
	}

	/**
	 * Checks legality rule 3 in section 4.3 (Component Types) on page 36. "The
	 * category of the component type being extended must match the category of
	 * the extending component type, i.e., they must be identical or the
	 * category being extended must be abstract."
	 */
	private void checkTypeExtensionCategory(TypeExtension typeExtension) {
		ComponentType parent = typeExtension.getExtended();
		ComponentType child = (ComponentType) typeExtension.getSpecific();
		if (!canExtend(parent, child))
			error("Cannot extend '" + parent.getQualifiedName()
					+ "'.  Incompatible categories.", parent,
					Aadl2Package.eINSTANCE.getComponentType_OwnedExtension());
	}

	/**
	 * Checks legality rule 5 in section 4.3 (Component Types) on page 36.
	 * "A component type must not contain both a requires_modes_subcluase and a modes_subclause."
	 * 
	 * Checks legality rule 6 in section 4.3 (Component Types) on page 36. "If
	 * the extended component type and an ancestor component type in the extends
	 * hierarchy contain modes subclauses, they must both be
	 * requires_modes_subclause or modes_subclause."
	 */
	private void checkComponentTypeModes(ComponentType componentType) {
		boolean containsModes = false;
		boolean containsRequiresModes = false;
		for (ComponentType currentType = componentType; currentType != null; currentType = currentType
				.getExtended()) {
			for (Mode currentMode : currentType.getOwnedModes()) {
				if (currentMode.isDerived())
					containsRequiresModes = true;
				else
					containsModes = true;
			}
		}
		if (containsModes && containsRequiresModes)
			error(componentType,
					"Component types cannot contain both modes and requires modes.");
	}

	/**
	 * Checks naming rule 6 in section 4.4 (Component Implementations) on page
	 * 41. "In a component implementation extension, the component type
	 * identifier of the component implementation being extended, which appears
	 * after the reserved word extends, must be the same as or an ancestor of
	 * the component type of the extension. The component implementation being
	 * extended may exist in another package. In this case the component
	 * implementation name is qualified with the package name."
	 */
	private void checkExtensionAndRealizationHierarchy(
			ImplementationExtension implementationExtension) {
		ComponentImplementation parent = implementationExtension.getExtended();
		ComponentImplementation child = (ComponentImplementation) implementationExtension
				.getSpecific();
		ComponentType typeOfParent = parent.getType();
		ComponentType typeOfChild = child.getType();
		boolean isAncestor = false;
		for (ComponentType currentType = typeOfChild; currentType != null
				&& !isAncestor; currentType = currentType.getExtended())
			if (currentType.equals(typeOfParent))
				isAncestor = true;
		if (!isAncestor)
			error(implementationExtension,
					'\'' + typeOfParent.getQualifiedName()
							+ "' is not an ancestor of '"
							+ typeOfChild.getQualifiedName() + "'.");
	}

	/**
	 * Checks legality rule 3 in section 4.4 (Component Implementations) on page
	 * 42. "The category of the component implementation must be identical to
	 * the category of the component type for which the component implementation
	 * is declared."
	 */
	private void checkRealizationCategory(Realization realization) {
		ComponentType type = realization.getImplemented();
		ComponentImplementation implementation = (ComponentImplementation) realization
				.getSpecific();
		if (!type.getCategory().equals(implementation.getCategory()))
			error(realization, "The category of '" + type.getQualifiedName()
					+ "' is not " + implementation.getCategory() + '.');
	}

	/**
	 * Checks legality rule 4 in section 4.4 (Component Implementation) on page
	 * 42. "If the component implementation extends another component
	 * implementation, the category of both must match, i.e., they must be
	 * identical or the category being extended must be abstract."
	 */
	private void checkImplementationExtensionCategory(
			ImplementationExtension implementationExtension) {
		ComponentImplementation parent = implementationExtension.getExtended();
		ComponentImplementation child = (ComponentImplementation) implementationExtension
				.getSpecific();
		if (!canExtend(parent, child))
			error(implementationExtension,
					"Cannot extend '" + parent.getQualifiedName()
							+ "'.  Incompatible categories.");
	}

	/**
	 * Checks legality rule 6 in section 4.4 (Component Implementations) on page
	 * 42. "If the component type of the component implementation contains a
	 * requires_modes_subclause then the component implementation must not
	 * contain any modes subclause."
	 * 
	 * Checks legality rule 7 in section 4.4 (Component Implementations) on page
	 * 42. "If modes are declared in the component type, then modes cannot be
	 * declared in component implementations."
	 */
	private void checkComponentImplementationModes(
			ComponentImplementation componentImplementation) {
		if (!componentImplementation.getOwnedModes().isEmpty()) {
			boolean typeHasModes = false;
			for (ComponentType currentType = componentImplementation.getType(); currentType != null
					&& !typeHasModes; currentType = currentType.getExtended()) {
				if (!currentType.getOwnedModes().isEmpty())
					typeHasModes = true;
			}
			if (typeHasModes) {
				error(componentImplementation,
						"Implementation cannot contain modes because modes or requires modes are inherited from the type.");
			}
		}
	}

	/**
	 * Checks legality rule 9 in section 4.4 (Component Implementations) on page
	 * 42. "The category of a subcomponent being refined must match the category
	 * of the refining subcomponent declaration, i.e., they must be identical or
	 * the category being refined must be abstract."
	 * 
	 * Checks legality rule 3 in section 4.5 (Subcomponents) on page 47. "In a
	 * subcomponent refinement declaration the component category may be refined
	 * from abstract to one of the concrete component categories. Otherwise the
	 * category must be the same as that of the subcomponent being refined."
	 */
	private void checkSubcomponentRefinementCategory(Subcomponent subcomponent) {
		ComponentCategory subcomponentCategory = subcomponent.getCategory();
		if (subcomponent.getRefined() != null) {
			ComponentCategory refinedCategory = subcomponent.getRefined()
					.getCategory();
			if (!subcomponentCategory.equals(refinedCategory)
					&& !refinedCategory.equals(ComponentCategory.ABSTRACT))
				error(subcomponent,
						"Cannot refine subcomponent.  Incompatible categories.");
		}
	}

	/**
	 * Checks legality rule 1 in section 4.5 (Subcomponents) on page 47. "The
	 * category of the subcomponent declaration must match the category of its
	 * corresponding component classifier reference or its prototype reference,
	 * i.e., they must be identical, or in the case of a classifier reference
	 * the referenced classifier category may be abstract."
	 */
	private void checkSubcomponentCategory(Subcomponent subcomponent) {
		ComponentCategory subcomponentCategory = subcomponent.getCategory();
		ComponentClassifier componentClassifier = subcomponent.getClassifier();
		ComponentPrototype componentPrototype = subcomponent.getPrototype();
		if (componentClassifier != null) {
			if (!subcomponentCategory.getName().equals(
					componentClassifier.getCategory())
					&& !componentClassifier.getCategory().equals(
							ComponentCategory.ABSTRACT.getName())) {
				error(subcomponent,
						"The category of the subcomponent is incompatible with the category of the classifier");
			}
		} else if (componentPrototype != null) {
			if (!subcomponentCategory.equals(getComponentPrototypeCategory(componentPrototype)))
				error(subcomponent,
						"The category of the subcomponent is incompatible with the category of the prototype");
		}
	}

	/**
	 * Checks legality rule 7 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component type is refined to a concrete category, the
	 * features of the abstract component type must be acceptable for the
	 * concrete component type."
	 */
	private void checkFeaturesOfExtendedAbstractType(ComponentType componentType) {
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
		Set<FeatureType> acceptableFeatureTypes = acceptableFeaturesForTypes
				.get(typeCategory);
		HashSet<FeatureType> typesOfInheritedFeatures = new HashSet<FeatureType>();
		for (ComponentType parent = componentType.getExtended(); parent instanceof AbstractType; parent = parent
				.getExtended())
			for (Feature feature : parent.getOwnedFeatures())
				typesOfInheritedFeatures.add(getFeatureType(feature));
		for (FeatureType featureType : typesOfInheritedFeatures) {
			if (!acceptableFeatureTypes.contains(featureType)) {
				error(componentType.getOwnedExtension(),
						"A "
								+ typeCategory.getName()
								+ " type cannot extend an abstract type that contains "
								+ featureType.getNameWithIndefiniteArticle()
								+ '.');
			}
		}
	}

	/**
	 * Checks legality rule 8 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component implementation is refined to a concrete
	 * category, the subcomponents of the abstract component implementation must
	 * be acceptable for the concrete component implementation."
	 */
	private void checkSubcomponentsOfExtendedAbstractImplementation(
			ComponentImplementation componentImplementation) {
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
		Set<ComponentCategory> acceptableSubcomponentCategories = acceptableSubcomponentCategoriesForImplementations
				.get(implementationCategory);
		HashSet<ComponentCategory> categoriesOfInheritedSubcomponents = new HashSet<ComponentCategory>();
		for (ComponentImplementation parent = componentImplementation
				.getExtended(); parent instanceof AbstractImplementation; parent = parent
				.getExtended()) {
			for (Subcomponent subcomponent : parent.getOwnedSubcomponents())
				categoriesOfInheritedSubcomponents.add(subcomponent
						.getCategory());
		}
		for (ComponentCategory subcomponentCategory : categoriesOfInheritedSubcomponents) {
			if (!acceptableSubcomponentCategories
					.contains(subcomponentCategory)) {
				error(componentImplementation.getOwnedExtension(),
						"A "
								+ implementationCategory.getName()
								+ " implementation cannot extend an abstract implementation that contains a "
								+ subcomponentCategory.getName()
								+ " subcomponent.");
			}
		}
	}

	/**
	 * Checks legality rule 7 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component type is refined to a concrete category, the
	 * features of the abstract component type must be acceptable for the
	 * concrete component type."
	 * 
	 * Checks legality rule 8 in section 4.6 (Abstract Components) on page 53.
	 * "If an abstract component implementation is refined to a concrete
	 * category, the subcomponents of the abstract component implementation must
	 * be acceptable for the concrete component implementation."
	 * Note: this also covers rule L5 in section 4.6.
	 */
	private void checkSubcomponentsHierarchy(Subcomponent subcomponent) {
		if (subcomponent.getCategory().equals(ComponentCategory.ABSTRACT))
			return;
		Subcomponent refinedSubcomponent = subcomponent;
		while (refinedSubcomponent.getClassifier() == null
				&& refinedSubcomponent.getPrototype() == null
				&& refinedSubcomponent.getRefined() != null) {
			refinedSubcomponent = refinedSubcomponent.getRefined();
		}
		if (refinedSubcomponent.getClassifier() instanceof AbstractImplementation) {
			Set<ComponentCategory> acceptableSubcomponentCategories = acceptableSubcomponentCategoriesForImplementations
					.get(subcomponent.getCategory());
			HashSet<ComponentCategory> categoriesOfNestedSubcomponents = new HashSet<ComponentCategory>();
			for (ComponentImplementation impl = (ComponentImplementation) refinedSubcomponent
					.getClassifier(); impl instanceof AbstractImplementation; impl = impl
					.getExtended()) {
				for (Subcomponent nestedSubcomponent : impl
						.getOwnedSubcomponents())
					categoriesOfNestedSubcomponents.add(nestedSubcomponent
							.getCategory());
			}
			for (ComponentCategory nestedSubcomponentCategory : categoriesOfNestedSubcomponents) {
				if (!acceptableSubcomponentCategories
						.contains(nestedSubcomponentCategory)) {
					error(subcomponent,
							"A "
									+ subcomponent.getCategory().getName()
									+ " subcomponent cannot refer to an abstract implementation that contains a "
									+ nestedSubcomponentCategory.getName()
									+ " subcomponent.");
				}
			}
		}
		AbstractType abstractType;
		if (refinedSubcomponent.getClassifier() instanceof AbstractType)
			abstractType = (AbstractType) refinedSubcomponent.getClassifier();
		else if (refinedSubcomponent.getClassifier() instanceof AbstractImplementation
				&&
				// This second part of this if expression will not be false for
				// semantically correct models.
				((AbstractImplementation) refinedSubcomponent.getClassifier())
						.getOwnedRealization().getImplemented() instanceof AbstractType) {
			abstractType = ((AbstractImplementation) refinedSubcomponent
					.getClassifier()).getType();
		} else
			abstractType = null;
		if (abstractType != null) {
			Set<FeatureType> acceptableFeatureTypes = acceptableFeaturesForTypes
					.get(subcomponent.getCategory());
			HashSet<FeatureType> typesOfNestedFeatures = new HashSet<FeatureType>();
			for (ComponentType type = abstractType; type instanceof AbstractType; type = type
					.getExtended()) {
				for (Feature nestedFeature : type.getOwnedFeatures())
					typesOfNestedFeatures.add(getFeatureType(nestedFeature));
			}
			for (FeatureType nestedFeatureType : typesOfNestedFeatures) {
				if (!acceptableFeatureTypes.contains(nestedFeatureType)) {
					error(subcomponent,
							"A "
									+ subcomponent.getCategory().getName()
									+ " subcomponent cannot refer to an abstract type that contains "
									+ nestedFeatureType
											.getNameWithIndefiniteArticle()
									+ '.');
				}
			}
		}
	}

	/**
	 * Checks that the category of the prototype is identical to the category of
	 * the specified component classifier. 
	 * Rule L2 in section 4.7 (revised AADLV2)
	 * "The component category of the optional component classifier reference in the component prototype declaration must match
	 * the category in the prototype declaration."
	 */
	private void checkComponentPrototypeCategory(ComponentPrototype prototype) {
		if (prototype.getConstrainingClassifier() != null
				&& !getComponentPrototypeCategory(prototype).getName()
						.equals(prototype.getConstrainingClassifier().getCategory())) {
			error(prototype, "The category of '"
					+ prototype.getConstrainingClassifier().getQualifiedName()
					+ "' is not " + getComponentPrototypeCategory(prototype).getName());
		}
	}

	/**
	 * Checks legality rule 1 in section 4.7 (Prototypes) on page 56. "The
	 * component category declared in the component prototype binding must match
	 * the component category of the prototype, or the declared category component category
	 * of the prototype must be abstract." 
	 */
	private void checkComponentPrototypeBindingCategory(
			ComponentPrototypeBinding binding) {
		if (binding.getFormal() instanceof ComponentPrototype) {
			ComponentCategory formalCategory = getComponentPrototypeCategory((ComponentPrototype) binding.getFormal());
			if (!formalCategory.equals(ComponentCategory.ABSTRACT)) {
				for (ComponentPrototypeActual actual : binding.getActuals()) {
					if (!formalCategory.equals(actual.getCategory())) {
						error(actual,
								"The category of the formal prototype is not compatible with the category specified in the"
										+ " prototype binding.");
					}
				}
			}
		}
	}

	/**
	 * Checks legality rule 10 in section 4.7 (Prototypes) on page 56. "(L10)	The component category of the classifier reference 
	 * or prototype reference in a prototype binding declaration must match the category of the prototype."
	 */
	private void checkComponentPrototypeActualComponentCategory(
			ComponentPrototypeActual actual) {
		if (actual.eIsProxy()){
			error(actual,
					"The prototype actual could not be found.");
		} else {
			SubcomponentType st = actual.getSubcomponentType();
			if (st == null){
				error(actual,
						"The classifier or prototype of the prototype actual could not be found.");
			} else
			if (!actual.getCategory().equals(ComponentCategory.ABSTRACT)
				&& !actual
						.getCategory()
						.getName()
						.equals(st instanceof ComponentClassifier ? ((ComponentClassifier) st)
								.getCategory() : getComponentPrototypeCategory((ComponentPrototype) st))) {
			error(actual,
					"The category of the referenced classifier is not compatible the category specified in the prototype binding.");
		}
		}
	}

	/**
	 * Checks legality rule 6 in section 4.7 (Prototypes) on page 56. "If the
	 * direction is declared for feature prototypes, then the prototype actual
	 * satisfies the direction according to the same rules as for feature
	 * refinements (see Section 8); in the case of ports the direction must be
	 * in or out; in the case of data access, the access right must be read-only
	 * for in and write-only for out; in the case of bus access, subprogram
	 * access and subprogram group access the direction must not be in nor out."
	 * Peter is going to change the wording of this to make parts of it less
	 * restrictive.
	 * 
	 * Checks legality rule 11 in section 4.7 (Prototypes) on page 57.
	 * "(L11)	If a direction is specified for an abstract feature in a prototype declaration, 
	 * then the direction of the prototype actual must match that declared in the prototype."
	 */
	private void checkFeaturePrototypeBindingDirection(
			FeaturePrototypeBinding binding) {
		if (binding.getFormal() instanceof FeaturePrototype) {
			DirectionType formalDirection = ((FeaturePrototype) binding
					.getFormal()).getDirection();
			if (formalDirection != null
					&& !formalDirection.equals(DirectionType.IN_OUT)
					&& !(binding.getActual() instanceof AccessSpecification)) {
				DirectionType actualDirection;
				if (binding.getActual() instanceof FeaturePrototypeReference)
					actualDirection = ((FeaturePrototypeReference) binding
							.getActual()).getDirection();
				else
					actualDirection = ((PortSpecification) binding.getActual())
							.getDirection();
				if (!actualDirection.equals(formalDirection)) {
					error(binding.getActual(),
							"The direction specified in the binding is inconsistent with the direction of the formal prototype.");
				}
			}
		}
	}

	/**
	 * Checks that the formal prototype of a ComponentPrototypeBinding is a
	 * ComponentPrototype. Rule L12 in Section 4.7.
	 */
	private void checkFormalOfComponentPrototypeBinding(
			ComponentPrototypeBinding binding) {
		if (!(binding.getFormal() instanceof ComponentPrototype))
			error(binding, '\'' + binding.getFormal().getName()
					+ "' is not a component prototype.");
	}

	/**
	 * Checks that the formal prototype of a FeatureGroupPrototypeBinding is a
	 * FeatureGroupPrototype. Rule L12 in Section 4.7.
	 */
	private void checkFormalOfFeatureGroupPrototypeBinding(
			FeatureGroupPrototypeBinding binding) {
		if (!(binding.getFormal() instanceof FeatureGroupPrototype))
			error(binding, '\'' + binding.getFormal().getName()
					+ "' is not a feature group prototype.");
	}

	/**
	 * Checks that the formal prototype of a FeaturePrototypeBinding is a
	 * FeaturePrototype. Rule L12 in Section 4.7.
	 */
	private void checkFormalOfFeaturePrototypeBinding(
			FeaturePrototypeBinding binding) {
		if (!(binding.getFormal() instanceof FeaturePrototype))
			error(binding, '\'' + binding.getFormal().getName()
					+ "' is not a feature prototype.");
	}

	/**
	 * Checks that component prototype refinements only refine component
	 * prototypes. Rule L13 in Section 4.7.
	 */
	private void checkRefinedOfComponentPrototype(ComponentPrototype prototype) {
		if (prototype.getRefined() != null
				&& !(prototype.getRefined() instanceof ComponentPrototype))
			error(prototype, '\'' + prototype.getName()
					+ "' is not a component prototype.");
	}

	/**
	 * Checks that feature group prototype refinements only refine feature group
	 * prototypes. Rule L12 in Section 4.7.
	 */
	private void checkRefinedOfFeatureGroupPrototype(
			FeatureGroupPrototype prototype) {
		if (prototype.getRefined() != null
				&& !(prototype.getRefined() instanceof FeatureGroupPrototype))
			error(prototype, '\'' + prototype.getName()
					+ "' is not a feature group prototype.");
	}

	/**
	 * Checks that feature prototype refinements only refine feature prototypes.
	 * Rule L12 in Section 4.7.
	 */
	private void checkRefinedOfFeaturePrototype(FeaturePrototype prototype) {
		if (prototype.getRefined() != null
				&& !(prototype.getRefined() instanceof FeaturePrototype))
			error(prototype, '\'' + prototype.getName()
					+ "' is not a feature prototype.");
	}

	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57. "A
	 * prototype refinement can increase the constraints on classifiers to be
	 * supplied. The newly specified category, classifier, and array dimensions
	 * must satisfy the same matching rules as the prototype bindings." This
	 * method checks the component category only.
	 */
	private void checkCategoryOfRefinedComponentPrototype(
			ComponentPrototype prototype) {
		if (prototype.getRefined() != null
				&& prototype.getRefined() instanceof ComponentPrototype) {
			ComponentCategory refinedPrototypeCategory = getComponentPrototypeCategory((ComponentPrototype) prototype.getRefined());
			if (!refinedPrototypeCategory.equals(ComponentCategory.ABSTRACT)
					&& !refinedPrototypeCategory
							.equals(getComponentPrototypeCategory(prototype)))
				error(prototype,
						"Incompatible category for prototype refinement.");
		}
	}

	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57. "A
	 * prototype refinement can increase the constraints on classifiers to be
	 * supplied. The newly specified category, classifier, and array dimensions
	 * must satisfy the same matching rules as the prototype bindings." This
	 * method checks for array compatibility only.
	 */
	private void checkArrayOfRefinedComponentPrototype(
			ComponentPrototype prototype) {
		if (prototype.getRefined() != null
				&& prototype.getRefined() instanceof ComponentPrototype) {
			ComponentPrototype refinedPrototype = (ComponentPrototype) prototype
					.getRefined();
			if (refinedPrototype.isArray() && !prototype.isArray())
				error(prototype,
						"Prototype must be an array because the refined prototype is an array.");
		}
	}

	/**
	 * Checks semantic rule 6 in section 4.7 (Prototypes) on page 57. "A
	 * prototype refinement can increase the constraints on classifiers to be
	 * supplied. The newly specified category, classifier, and array dimensions
	 * must satisfy the same matching rules as the prototype bindings." This
	 * method checks for feature direction only.
	 */
	private void checkDirectionOfRefinedFeaturePrototype(
			FeaturePrototype prototype) {
		if (prototype.getRefined() != null
				&& prototype.getRefined() instanceof FeaturePrototype) {
			DirectionType refinedPrototypeDirection = ((FeaturePrototype) prototype
					.getRefined()).getDirection();
			if (refinedPrototypeDirection != null
					&& !refinedPrototypeDirection.equals(DirectionType.IN_OUT)
					&& !refinedPrototypeDirection.equals(prototype
							.getDirection())) {
				error(prototype,
						"Incompatible direction for prototype refinement.");
			}
		}
	}

	/**
	 * Checks legality rule 2 in section 5.1 (Data) on page 62.
	 * "A data type declaration must not contain a flow specification or modes subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractType.
	 */
	private void checkForInheritedFlowsAndModesFromAbstractType(
			DataType dataType) {
		boolean parentHasFlowSpecs = false;
		boolean parentHasModes = false;
		boolean parentHasModeTransitions = false;
		for (ComponentType parentType = dataType.getExtended(); parentType instanceof AbstractType; parentType = parentType
				.getExtended()) {
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpecs = true;
			if (!parentType.getOwnedModes().isEmpty())
				parentHasModes = true;
			if (!parentType.getOwnedModeTransitions().isEmpty())
				parentHasModeTransitions = true;
		}
		if (parentHasFlowSpecs)
			error(dataType.getOwnedExtension(),
					"A data type cannot extend an abstract type that contains a flow specification.");
		if (parentHasModes)
			error(dataType.getOwnedExtension(),
					"A data type cannot extend an abstract type that contains modes.");
		if (parentHasModeTransitions)
			error(dataType.getOwnedExtension(),
					"A data type cannot extend an abstract type that contains a mode transition.");
	}

	/**
	 * Checks legality rule 4 in section 5.1 (Data) on page 62. "A data
	 * implementation must not contain a flow implementation, an end-to-end flow
	 * specification, or a modes subclause." This rule is partly checked by the
	 * parser. This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedFlowsAndModesFromAbstractImplementation(
			DataImplementation dataImplementation) {
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasModes = false;
		boolean parentHasModeTransition = false;
		for (ComponentImplementation parentImplementation = dataImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!parentImplementation.getOwnedModes().isEmpty())
				parentHasModes = true;
			if (!parentImplementation.getOwnedModeTransitions().isEmpty())
				parentHasModeTransition = true;
		}
		if (parentHasFlowImpl) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasModes) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains modes.");
		}
		if (parentHasModeTransition) {
			error(dataImplementation.getOwnedExtension(),
					"A data implementation cannot extend an abstract implementation that contains a mode transition.");
		}
	}

	/**
	 * Checks legality rule 4 in section 5.5 (Thread Groups) on page 95.
	 * "A thread group must not contain a subprogam calls subclause." This rule
	 * is partly checked by the parser. This method checks for inherited members
	 * from an AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(
			ThreadGroupImplementation threadGroupImplementation) {
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = threadGroupImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence) {
			error(threadGroupImplementation.getOwnedExtension(),
					"A thread group implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 5 in section 6.1 (Processors) on page 102.
	 * "A processor implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(
			ProcessorImplementation processorImplementation) {
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = processorImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence) {
			error(processorImplementation.getOwnedExtension(),
					"A processor implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 4 in section 6.2 (Virtual Processors) on page 106.
	 * "A virtual processor implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedCallSequenceFromAbstractImplementation(
			VirtualProcessorImplementation virtualProcessorImplementation) {
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = virtualProcessorImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence) {
			error(virtualProcessorImplementation.getOwnedExtension(),
					"A virtual processor implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 1 in section 6.3 (Memory) on page 109. "A memory
	 * type can contain bus access declarations, feature groups, a modes
	 * subclause, and property associations. It must not contain flow
	 * specifications." This rule is partly checked by the parser. This method
	 * checks for inherited members from an AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(MemoryType memoryType) {
		boolean parentHasFlowSpec = false;
		for (ComponentType parentType = memoryType.getExtended(); parentType instanceof AbstractType; parentType = parentType
				.getExtended())
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpec = true;
		if (parentHasFlowSpec)
			error(memoryType.getOwnedExtension(),
					"A memory type cannot extend an abstract type that contains a flow specification.");
	}

	/**
	 * Checks legality rule 5 in section 6.3 (Memory) on page 110.
	 * "A memory implementation must not contain flows subclause, or subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedFlowsAndCallSequenceFromAbstractImplementation(
			MemoryImplementation memoryImplementation) {
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = memoryImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasFlowImpl) {
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence) {
			error(memoryImplementation.getOwnedExtension(),
					"A memory implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 6.4 (Buses) on page 111.
	 * "A bus type must not contain any flow specifications." This rule is
	 * partly checked by the parser. This method checks for inherited members
	 * from an AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(BusType busType) {
		boolean parentHasFlowSpec = false;
		for (ComponentType parentType = busType.getExtended(); parentType instanceof AbstractType; parentType = parentType
				.getExtended())
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpec = true;
		if (parentHasFlowSpec)
			error(busType.getOwnedExtension(),
					"A bus type cannot extend an abstract type that contains a flow specification.");
	}

	/**
	 * Checks legality rule 5 in section 6.4 (Buses) on page 111. "A bus
	 * implementation must not contain a connections subclause, flows subclause,
	 * or subprogram calls subclause." This rule is partly checked by the
	 * parser. This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(
			BusImplementation busImplementation) {
		boolean parentHasConnections = false;
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = busImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!parentImplementation.getOwnedConnections().isEmpty())
				parentHasConnections = true;
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasConnections) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains a connection.");
		}
		if (parentHasFlowImpl) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence) {
			error(busImplementation.getOwnedExtension(),
					"A bus implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 6.5 (Virtual Buses) on page 114.
	 * "A virtual bus type must not contain flow specifications." This rule is
	 * partly checked by the parser. This method checks for inhertied members
	 * from an AbstractType.
	 */
	private void checkForInheritedFlowsFromAbstractType(
			VirtualBusType virtualBusType) {
		boolean parentHasFlowSpec = false;
		for (ComponentType parentType = virtualBusType.getExtended(); parentType instanceof AbstractType; parentType = parentType
				.getExtended()) {
			if (!parentType.getOwnedFlowSpecifications().isEmpty())
				parentHasFlowSpec = true;
		}
		if (parentHasFlowSpec) {
			error(virtualBusType.getOwnedExtension(),
					"A virtual bus type cannot extend an abstract type that contains a flow specification.");
		}
	}

	/**
	 * Checks legality rule 5 in section 6.5 (Virtual Buses) on page 114. "A
	 * virtual bus implementation must not contain a connections subclause,
	 * flows subclause, or subprogram calls subclause." This rule is partly
	 * checked by the parser. This method checks for inherited members from an
	 * AbstractImplementation.
	 */
	private void checkForInheritedConnectionsFlowsAndCallsFromAbstractImplementation(
			VirtualBusImplementation virtualBusImplementation) {
		boolean parentHasConnections = false;
		boolean parentHasFlowImpl = false;
		boolean parentHasETEFlow = false;
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = virtualBusImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!parentImplementation.getOwnedConnections().isEmpty())
				parentHasConnections = true;
			if (!parentImplementation.getOwnedFlowImplementations().isEmpty())
				parentHasFlowImpl = true;
			if (!parentImplementation.getOwnedEndToEndFlows().isEmpty())
				parentHasETEFlow = true;
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasConnections) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains a connection.");
		}
		if (parentHasFlowImpl) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains a flow implementation.");
		}
		if (parentHasETEFlow) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains an end to end flow.");
		}
		if (parentHasCallSequence) {
			error(virtualBusImplementation.getOwnedExtension(),
					"A virtual bus implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 6.6 (Devices) on page 117.
	 * "A device component implementation must not contain a subprogram calls subclause."
	 * This rule is partly checked by the parser. This method checks for
	 * inherited members from an AbstractImplementation.
	 */
	private void checkForInheritedCallsFromAbstractImplementation(
			DeviceImplementation deviceImplementation) {
		boolean parentHasCallSequence = false;
		for (ComponentImplementation parentImplementation = deviceImplementation
				.getExtended(); parentImplementation instanceof AbstractImplementation; parentImplementation = parentImplementation
				.getExtended()) {
			if (!((AbstractImplementation) parentImplementation)
					.getOwnedSubprogramCallSequences().isEmpty())
				parentHasCallSequence = true;
		}
		if (parentHasCallSequence) {
			error(deviceImplementation.getOwnedExtension(),
					"A device implementation cannot extend an abstract implementation that contains subprogram calls.");
		}
	}

	/**
	 * Checks legality rule 2 in section 8 (Features and Shared Access) on page
	 * 125. "A feature refinement declaration of a feature and the original
	 * feature must both be declared as port, parameter, access feature, or
	 * feature group, or the original feature must be declared as abstract
	 * feature."
	 * 
	 * Checks legality rule 4 in section 8.3 (Ports) on page 132. "The port
	 * category of a port refinement must be the same as the category of the
	 * port being refined, or the port being refined must be an abstract
	 * feature." This method was not written with L4 specifically in mind, but
	 * it does properly check L4. This is because there are separate meta-model
	 * classes for the various port categories (DataPort, EventPort, and
	 * EventDataPort). If this data were stored in a field in Port, then this
	 * method would not be sufficient for L4.
	 */
	private void checkTypeOfFeatureRefinement(Feature feature) {
		Feature refined = feature.getRefined();
		if (!Aadl2Util.isNull(refined)
				&& !(feature.getRefined() instanceof AbstractFeature)
				&& !feature.eClass().equals(refined.eClass())) {
			error(feature,
					"Cannot refine "
							+ FEATURE_CLASS_NAMES_WITH_ARTICLE.get(refined.eClass())
							+ " into "
							+ FEATURE_CLASS_NAMES_WITH_ARTICLE.get(feature
									.eClass()) + '.');
		}
	}

	/**
	 * Checks legality rule 3 in section 8 (Features and Shared Access) on page
	 * 125.
	 * "Feature arrays must only be declared for threads, devices, and processors."
	 */
	private void checkForFeatureArrays(Feature feature) {
		if (!feature.getArrayDimensions().isEmpty()) {
			ComponentType componentType = (ComponentType) feature.getOwner();
			if (!(componentType instanceof AbstractType)
					&& !(componentType instanceof ThreadType)
					&& !(componentType instanceof DeviceType)
					&& !(componentType instanceof ProcessorType)) {
				error(feature,
						"Feature arrays can only be declared for abstract, thread, device, and processor classifiers.");
			}
		}
	}

	/**
	 * Checks legality rule 3 in section 8 (Features and Shared Access) on page
	 * 125.
	 * "Feature arrays must only be declared for threads, devices, and processors."
	 */
	private void checkForInheritedFeatureArrays(ComponentType componentType) {
		if (!(componentType instanceof AbstractType)
				&& !(componentType instanceof ThreadType)
				&& !(componentType instanceof DeviceType)
				&& !(componentType instanceof ProcessorType)) {
			boolean parentHasFeatureArray = false;
			for (ComponentType parentType = componentType.getExtended(); parentType instanceof AbstractType; parentType = parentType
					.getExtended()) {
				for (Feature inheritedFeature : parentType.getOwnedFeatures())
					if (!inheritedFeature.getArrayDimensions().isEmpty())
						parentHasFeatureArray = true;
			}
			if (parentHasFeatureArray) {
				error(componentType.getOwnedExtension(),
						"A "
								+ componentType.getCategory()
								+ " type cannot extend an abstract type that contains feature arrays.");
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 8 (Features and Shared Access) on page
	 * 125. "If the feature refinement specifies an array dimension, then the
	 * feature being refined must have an array dimension."
	 */
	private void checkForArraysInRefinedFeature(Feature feature) {
		if (!feature.getArrayDimensions().isEmpty()
				&& feature.getRefined() != null
				&& feature.getRefined().getArrayDimensions().isEmpty())
			error(feature,
					"Cannot specify an array dimension because the refined feature doesn't have an array dimension.");
	}

	/**
	 * Checks legality rule 5 in section 8 (Features and Shared Access) on page
	 * 125. "If the refinement specifies an array dimension size, then the
	 * feature being refined must not have an array dimension size."
	 */
	private void checkForArrayDimensionSizeInRefinedFeature(Feature feature) {
		// TODO-phf: Now we have to check the list of ArrayDimensions if each
		// has the size field set.
		// if (!feature.getArrayDimensions().isEmpty() &&
		// !feature.getArraySpecification().getSizes().isEmpty() &&
		// feature.getRefined() != null &&
		// !feature.getRefined().getArrayDimensions().isEmpty() &&
		// !feature.getRefined().getArraySpecification().getSizes().isEmpty())
		// {
		// error(feature.getArraySpecification().getSizes().get(0),
		// "Cannot specify an array dimension size because the refined feature already specified the array dimension size.");
		// }
	}

	/**
	 * Checks legality rule 1 in section 8.1 (Abstract Features) on page 126.
	 * "The feature direction in a refined feature declaration must be identical
	 * to the feature direction in the feature declaration being refined, or the
	 * feature being refined must not have a direction."
	 * 
	 * Checks legality rule 2 in section 8.1 (Abstract Features) on page 127.
	 * "If the direction of an abstract feature is specified, then the direction
	 * must be satisfied by the refinement (see also the rules for feature
	 * prototypes in Section 4.7); in the case of ports the direction must be in
	 * or out; in the case of data access, the access right must be read-only
	 * for in and write-only for out; in the case of bus access, subprogram
	 * access and subprogram group access the direction must not be in nor out."
	 * This method does not check access features.
	 * 
	 * Checks legality rule 5 in section 8.3 (Ports) on page 133. "The port
	 * direction of a port refinement must be the same as the direction of the
	 * feature being refined. If the feature being refined is an abstract
	 * feature without direction, then all port directions are acceptable."
	 * 
	 * Checks legality rule 4 in section 8.5 (Subprogram Parameters) on page
	 * 148. "The parameter direction of a parameter refinement must be the same
	 * as the direction of the feature being refined. If the feature being
	 * refined is an abstract feature without direction, then all parameter
	 * directions are acceptable."
	 */
	private void checkFeatureDirectionInRefinement(DirectedFeature feature) {
		DirectionType direction = feature.getDirection();
		if (feature.getRefined() instanceof DirectedFeature) {
			DirectionType refinedDirection = ((DirectedFeature) feature
					.getRefined()).getDirection();
			// For ports and parameters, the directions must be the same value.
			// All other DirectedFeatures have the option of refining from
			// IN_OUT to IN or OUT.
			if (!direction.equals(refinedDirection)
					&& (feature.getRefined() instanceof Port
							|| feature.getRefined() instanceof Parameter || !refinedDirection
								.equals(DirectionType.IN_OUT))) {
				error(feature,
						"Incompatible direction in feature refinement.  The direction of the refined feature is '"
								+ refinedDirection.getName() + "'.");
			}
		}
	}

	/**
	 * Checks legality rule 3 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature with a feature prototype identifier and the
	 * prototype being referenced must both specify the same direction or no
	 * direction."
	 */
	private void checkAbstractFeatureAndPrototypeDirectionConsistency(
			AbstractFeature feature) {
		if (feature.getPrototype() instanceof FeaturePrototype) {
			DirectionType featureDirection = feature.getDirection();
			DirectionType prototypeDirection = ((FeaturePrototype) feature
					.getPrototype()).getDirection();
			if (!featureDirection.equals(prototypeDirection)) {
				if (prototypeDirection.equals(DirectionType.IN_OUT)) {
					error(feature,
							"A direction cannot be specified on the abstract feature because its prototype does not specify a direction.");
				} else {
					error(feature,
							"The direction of the abstract feature must match the direction of its prototype."
									+ "  The prototype's direction is '"
									+ prototypeDirection.getName() + "'.");
				}
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature refinement declaration of a feature with a feature
	 * prototype reference must only add property associations."
	 */
	private void checkForAddedDirectionInAbstractFeatureRefinement(
			AbstractFeature feature) {
		AbstractFeature refinedFeature = (AbstractFeature) feature.getRefined();
		while (refinedFeature != null
				&& !(refinedFeature.getPrototype() instanceof FeaturePrototype))
			refinedFeature = (AbstractFeature) refinedFeature.getRefined();
		if (refinedFeature != null) {
			if (refinedFeature.getDirection().equals(DirectionType.IN_OUT)
					&& !feature.getDirection().equals(DirectionType.IN_OUT)) {
				error(feature,
						"The refined feature refers to a feature prototype.  Therefore, a direction cannot be added in the"
								+ " refinement because the direction will be specified in the prototype binding.");
			}
		}
	}

	/**
	 * Checks legality rule 4 in section 8.1 (Abstract Features) on page 127.
	 * "An abstract feature refinement declaration of a feature with a feature
	 * prototype reference must only add property associations."
	 */
	private void checkForAddedPrototypeOrClassifierInAbstractFeatureRefinement(
			AbstractFeature feature) {
		AbstractFeature refinedFeature = (AbstractFeature) feature.getRefined();
		while (refinedFeature != null
				&& !(refinedFeature.getPrototype() instanceof FeaturePrototype))
			refinedFeature = (AbstractFeature) refinedFeature.getRefined();
		if (refinedFeature != null) {
			if (feature.getClassifier() != null)
				error(feature,
						"Cannot refer to a classifier because the refined feature refers to a feature prototype.");
			else if (feature.getPrototype() != null
					&& !feature.getPrototype().equals(
							refinedFeature.getPrototype()))
				error(feature,
						"The refiend feature already refers to a prototype.  The prototype cannot be changed in the refinement.");
		}
	}

	/**
	 * Checks legality rule 2 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "A feature group type can be declared to be the
	 * inverse of another feature group type, as indicated by the reserved words
	 * inverse of and the name of a feature group type. Any feature group type
	 * named in an inverse of statement cannot itself contain an inverse of
	 * statement. This means that several feature groups can be declared to be
	 * the inverse of one feature group, e.g., B inverse of A and C inverse of A
	 * is acceptable. However, chaining of inverses is not permitted, e.g., B
	 * inverse of A and C inverse of B is not acceptable."
	 */
	private void checkForChainedInverseFeatureGroupTypes(
			FeatureGroupType featureGroupType) {
		if (featureGroupType.getInverse() != null
				&& featureGroupType.getInverse().getInverse() != null) {
			error(featureGroupType,
					"A feature group type cannot be an inverse of another feature group type that already contains an"
							+ " 'inverse of' declaration.");
		}
	}

	/**
	 * Checks legality rule 3 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "Only feature group types without inverse of or
	 * feature group types with features and inverse of can be extended."
	 */
	private void checkForExtendingAnInverseFeatureGroupType(
			GroupExtension extension) {
		FeatureGroupType extended = extension.getExtended();
		if (extended.getInverse() != null
				&& extended.getOwnedFeatures().isEmpty()) {
			error(extension,
					"Cannot extend a feature group type that contains an 'inverse of' declaration,"
							+ " but does not contain any locally defined features.");
		}
	}

	/**
	 * Checks legality rule 4 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "A feature group type that is an extension of another
	 * feature group type without an inverse of cannot contain an inverse of
	 * statement."
	 */
	private void checkForInverseInFeatureGroupTypeExtension(
			GroupExtension extension) {
		FeatureGroupType extended = extension.getExtended();
		FeatureGroupType extending = (FeatureGroupType) extension.getSpecific();
		if (extending.getInverse() != null && extended.getInverse() == null) {
			error(extension,
					"A feature group type with an 'inverse of' declaration cannot extend a feature group type without an"
							+ " 'inverse of' declaration.");
		}
	}

	/**
	 * Checks legality rule 5 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "The feature group type that is an extension of
	 * another feature group type with features and inverse of that adds
	 * features must have an inverse of to identify the feature group type whose
	 * inverse it is."
	 */
	private void checkForRequiredInverseInFeatureGroupTypeExtension(
			GroupExtension extension) {
		FeatureGroupType extended = extension.getExtended();
		FeatureGroupType extending = (FeatureGroupType) extension.getSpecific();
		if (!extended.getOwnedFeatures().isEmpty()
				&& extended.getInverse() != null
				&& !extending.getOwnedFeatures().isEmpty()
				&& extending.getInverse() == null) {
			error(extending,
					"Must specify inverse because local features are defined and the extended feature group type has an"
							+ " 'inverse of' declaration.");
		}
	}

	/**
	 * Checks legality rule 6 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "A feature group declaration with an inverse of
	 * statement must only reference feature group types without an inverse of
	 * statement."
	 */
	private void checkForInverseInFeatureGroup(FeatureGroup featureGroup) {
		if (featureGroup.isInverse()
				&& featureGroup.getFeatureGroupType() != null
				&& featureGroup.getFeatureGroupType().getInverse() != null) {
			error(featureGroup,
					"Cannot specify 'inverse of' in the feature group because the referenced feature group type already"
							+ " contains an 'inverse of' declaration.");
		}
	}

	/**
	 * Checks legality rule 13 in section 8.2 (Feature Groups and Feature Group
	 * Types) on page 129. "If an in or out direction is specified as part of a
	 * feature group declaration, then all features inside the feature group
	 * must satisfy this direction."
	 */
	private void checkDirectionOfFeatureGroupMembers(FeatureGroup featureGroup) {
		if (!featureGroup.getDirection().equals(DirectionType.IN_OUT)
				&& featureGroup.getFeatureGroupType() != null) {
			for (Feature feature : featureGroup.getFeatureGroupType()
					.getAllFeatures()) {
				if (feature instanceof DirectedFeature
						&& !((DirectedFeature) feature).getDirection().equals(
								featureGroup.getDirection())) {
					error(featureGroup,
							"All ports, parameters, feature groups, and abstract features in the referenced feature group"
									+ " type must satisfy the direction specified in the feature group.");
				}
			}
		}
	}

	/**
	 * Checks legality rule L1 for section 8.4 (Subprogram and
	 * Subprogram Group Access) "If a subprogram access refers to a component
	 * classifier or a component prototype, then the category of the classifier
	 * or prototype must be subprogram." For references to classifiers, the
	 * meta-model only allows for a subprogram classifier. Therefore, this
	 * method only checks the prototype reference.
	 */
	private void checkSubprogramAccessPrototypeReference(
			SubprogramAccess subprogramAccess) {
		Prototype sp = subprogramAccess.getPrototype();
		if (sp != null &&!(subprogramAccess.getPrototype() instanceof SubprogramPrototype)) {
			error(subprogramAccess,
					"The category of the referenced component prototype must be subprogram.");
		}
	}

	/**
	 * Checks legality rule L2 for section 8.4 (Subprogram and
	 * Subprogram Group Access) "If a subprogram group access refers to a
	 * component classifier or a component prototype, then the category of the
	 * classifier or prototype must be subprogram group." For references to
	 * classifiers, the meta-model only allows for a subprogram group
	 * classifier. Therefore, this method only checks the prototype reference.
	 */
	private void checkSubprogramGroupAccessPrototypeReference(
			SubprogramGroupAccess subprogramGroupAccess) {
		Prototype sp = subprogramGroupAccess.getPrototype();
		if (sp != null && !(sp instanceof SubprogramGroupPrototype)) {
			error(subprogramGroupAccess,
					"The category of the referenced component prototype must be subprogram group.");
		}
	}

	/**
	 * Checks legality rule L3 for section 8.4 (Subprogram and
	 * Subprogram Group Access) "An abstract feature can be refined into a
	 * subprogram access or a subprogram group access. In this case, the
	 * abstract feature must not have a direction specified."
	 * 
	 * Checks legality rule L4 for section 8.6 (Data Component Access)
	 * "An abstract feature can be refined into a data access. In this case, the
	 * abstract feature must not have a direction specified."
	 * 
	 * Checks legality rule L4 for section 8.7 (Bus Component Access)
	 * "An abstract feature can be refined into a bus access. In this case, the
	 * abstract feature must not have a direction specified."
	 */
	private void checkForAbstractFeatureDirectionInAccessRefinement(
			Access access) {
		if (access.getRefined() instanceof AbstractFeature
				&& !((AbstractFeature) access.getRefined()).getDirection()
						.equals(DirectionType.IN_OUT)) {
			error(access,
					"An abstract feature with a direction specified cannot be refined into an access feature.");
		}
	}

	/**
	 * Checks legality rule L6 for section 8.4 (Subprogram and
	 * Subprogram Group Access) "A provides subprogram access cannot be refined
	 * to a requires subprogram access and a requires subprogram access cannot
	 * be refined to a provides subprogram access. Similarly, a provides
	 * subprogram group access cannot be refined to a requires subprogram group
	 * access and a requires subprogram group access cannot be refined to a
	 * provides subprogram group access."
	 * 
	 * Checks legality rule L3 for section 8.6 (Data Component Access)
	 * "A provides data access cannot be refined to a requires data access and a
	 * requires data access cannot be refined to a provides data access."
	 * 
	 * Checks rule L3 for section 8.7 (Bus Component Access) "A
	 * provides bus access cannot be refined to a requires bus access and a
	 * requires bus access cannot be refined to a provides bus access."
	 */
	private void checkForAccessTypeInAccessRefinement(Access access) {
		if (access.getRefined() instanceof Access
				&& !access.getKind().equals(
						((Access) access.getRefined()).getKind())) {
			StringBuilder errorMessage = new StringBuilder("A ");
			errorMessage.append(getKeywordForAccessType(((Access) access
					.getRefined()).getKind()));
			errorMessage.append(" access cannot be refined into a ");
			errorMessage.append(getKeywordForAccessType(access.getKind()));
			errorMessage.append(" access.");
			error(access, errorMessage.toString());
		}
	}

	/**
	 * Checks legality rule L1 for section 8.6 (Data Component Access)
	 * "If a data access refers to a component classifier or a component
	 * prototype, then the category of the classifier or prototype must be
	 * data." For references to classifiers, the meta-model only allows for a
	 * data classifier. Therefore, this method only checks the prototype
	 * reference.
	 */
	private void checkDataAccessPrototypeReference(DataAccess dataAccess) {
		Prototype dp = dataAccess.getPrototype();
		if (dp != null && !(dp instanceof DataPrototype)) {
			error(dataAccess,
					"The category of the referenced component prototype must be data.");
		}
	}
	
	private void checkDefiningID(Connection conn){
		String name = conn.getName();
		if (name == null){
			warning(conn, "Connection is missing defining identifier. Required in AADL V2.1");
		}
	}

	/**
	 * Quickly done to get ready for the course in November 2009. Need to review
	 * this method and make sure that it is complete and in compliance with the
	 * standard. TODO: Review this method
	 */
	private void checkPortConnectionClassifiers(PortConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if ((source instanceof DataAccess || source instanceof DataSubcomponent
				|| source instanceof DataPort || source instanceof EventDataPort)
				&& (destination instanceof DataAccess
						|| destination instanceof DataSubcomponent
						|| destination instanceof DataPort || destination instanceof EventDataPort)) {
			ComponentClassifier sourceClassifier;
			ComponentClassifier destinationClassifier;
			if (source instanceof DataSubcomponent)
				sourceClassifier = ((DataSubcomponent) source)
						.getAllClassifier();
			else
				sourceClassifier = ((Feature) source).getAllClassifier();
			if (destination instanceof DataSubcomponent)
				destinationClassifier = ((DataSubcomponent) destination)
						.getAllClassifier();
			else
				destinationClassifier = ((Feature) destination)
						.getAllClassifier();
			if (sourceClassifier != destinationClassifier) {
				if (sourceClassifier == null)
					warning(connection, '\'' + source.getName()
							+ "' is missing a classifier.");
				else if (destinationClassifier == null)
					warning(connection, '\'' + destination.getName()
							+ "' is missing a classifier.");
				else if (sourceClassifier instanceof ComponentType
						&& destinationClassifier instanceof ComponentImplementation
						&& sourceClassifier
								.equals(((ComponentImplementation) destinationClassifier)
										.getType())) {
					warning(connection,
							"The classifiers of '" + source.getName()
									+ "' and '" + destination.getName()
									+ "' do not match.");
				} else if (sourceClassifier instanceof ComponentImplementation
						&& destinationClassifier instanceof ComponentType
						&& destinationClassifier
								.equals(((ComponentImplementation) sourceClassifier)
										.getType())) {
					warning(connection,
							"The classifiers of '" + source.getName()
									+ "' and '" + destination.getName()
									+ "' do not match.");
				} else
					error(connection, '\'' + source.getName() + "' and '"
							+ destination.getName()
							+ "' have incompatible classifiers.");
			}
		}
	}


	/**
	 * Check direction of ConnectionEnd in port connections
	 */
	private void checkPortConnectionDirection(PortConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		DirectionType srcDirection = DirectionType.IN_OUT;
		DirectionType dstDirection = DirectionType.IN_OUT;
		if (source instanceof DirectedFeature)
			srcDirection = ((DirectedFeature)source).getDirection();
		if (destination instanceof DirectedFeature)
			dstDirection = ((DirectedFeature)destination).getDirection();
		if (source instanceof DataSubcomponent || source instanceof DataAccess){
			// TODO check access right to limit to in or out
		}
		if (destination instanceof DataSubcomponent || destination instanceof DataAccess){
			// TODO check access right to limit to in or out
		}
		Context srcContext = connection.getAllSourceContext();
		Context dstContext = connection.getAllDestinationContext();
		if (srcContext instanceof FeatureGroup && ((FeatureGroup)srcContext).isInverse()){
			srcDirection = srcDirection.getInverseDirection();
		}
		if (dstContext instanceof FeatureGroup && ((FeatureGroup)dstContext).isInverse()){
			dstDirection = dstDirection.getInverseDirection();
		}
		if (srcContext instanceof FeatureGroup && ((FeatureGroup)srcContext).getFeatureGroupType().getInverse()!= null){
			srcDirection = srcDirection.getInverseDirection();
		}
		if (dstContext instanceof FeatureGroup && ((FeatureGroup)dstContext).getFeatureGroupType().getInverse()!= null){
			dstDirection = dstDirection.getInverseDirection();
		}
		if ((srcContext instanceof Subcomponent  && dstContext instanceof Subcomponent)
				// between ports of subcomponents
				|| (srcContext == null && source instanceof DataSubcomponent  && dstContext instanceof Subcomponent)
					// from a data subcomponent to a port
				|| (dstContext == null && destination instanceof DataSubcomponent  && srcContext instanceof Subcomponent)
					// from a data subcomponent to a port
				){
			if (!(srcDirection.outgoing() && dstDirection.incoming())){
				error(connection, "Source feature '" + source.getName() + "' must be outgoing and destination feature '"+destination.getName() +"' must be incoming.");
			}
			return;
		} else {
			// going up or down hierarchy
		       if (!((srcDirection.outgoing() && dstDirection.outgoing())||(srcDirection.incoming() && dstDirection.incoming()))){
	               error(connection, "Source feature '" + source.getName() + "' and destination feature '"+destination.getName() +"' must have same direction.");
	           }
	           if (srcContext instanceof Subcomponent){
	        	   if (!(srcDirection.outgoing()))
		               error(connection, "Outgoing connection requires outgoing feature '" + srcContext.getName()+"."+ source.getName() + "'.");
	        	   if (!(dstDirection.outgoing()))
		               error(connection, "Outgoing connection requires outgoing feature '" + destination.getName() + "'.");
	           }
	           if (dstContext instanceof Subcomponent){
	        	   if (!(dstDirection.incoming()))
		               error(connection, "Incoming connection requires incoming feature '" + dstContext.getName()+"."+ destination.getName() + "'.");
	        	   if (!(srcDirection.incoming()))
		               error(connection, "Incoming connection requires incoming feature '" + source.getName() + "'.");
	           }
	     }
	}

	/**
	 * Check connection ends of port connections
	 * Section 9.2 Legality rule L5
	 */
	private void checkPortConnectionEnds(PortConnection connection) {
		ConnectionEnd source = connection.getAllSource();
		ConnectionEnd destination = connection.getAllDestination();
		if (source instanceof EventPort && !(destination instanceof EventPort)){
			error(connection, "Source event port '" + source.getName() + "' must be connected to an event port destination.");
			return;
		}
		if (source instanceof DataPort && !(destination instanceof EventPort || destination instanceof DataPort 
				|| destination instanceof EventDataPort || destination instanceof DataSubcomponent || destination instanceof DataAccess)){
			error(connection, "Source data port '" + source.getName() + "' must be connected to an event, data, or event data port, data subcomponent or data access destination.");
			return;
		}
		if (source instanceof EventDataPort && !(destination instanceof EventPort || destination instanceof DataPort 
				|| destination instanceof EventDataPort || destination instanceof DataSubcomponent || destination instanceof DataAccess)){
			error(connection, "Source event data port '" + source.getName() + "' must be connected to an event, data, or event data port, data subcomponent or data access destination.");
			return;
		}
		if (source instanceof DataSubcomponent && !(destination instanceof EventPort || destination instanceof DataPort 
				|| destination instanceof EventDataPort )){
			error(connection, "Source data subcomponent '" + source.getName() + "' must be connected to an event, data, or event data port destination.");
			return;
		}
		if (source instanceof DataAccess && !(destination instanceof EventPort || destination instanceof DataPort 
				|| destination instanceof EventDataPort )){
			error(connection, "Source data access feature '" + source.getName() + "' must be connected to an event, data, or event data port destination.");
			return;
		}
	}

	/**
	 * @param pn
	 */
	private void checkPropertyDefinition(final Property pn) {
		// Check the type correctness of the default value, if any
		typeCheckPropertyValues(pn.getPropertyType(),  pn.getDefaultValue());
	}


	private void checkPropertyConstant(final PropertyConstant pc) {
		/* Check the type correctness of the values.  The parser enforces
		 * some of this, but can't do it if the type is given by reference,
		 * and it cannot check that a int or real is within range.
		 */
		typeCheckPropertyValues(pc.getPropertyType(), pc.getConstantValue());
	}

//
//	/**
//	 * check property associations for the aObject element
//	 * @param element aObject. It may not have a Properties object.
//	 */
//	private void checkPropertyAssocs(
//		final NamedElement element, final boolean isSubcomponent) {
//		final List assocs;
//		if (element instanceof Classifier) {
//			/* 15 February 2007: Not sure this what should really be done.
//			 * This breaks list +=> for one thing.  Taking this out for
//			 * the moment; it was put in on 6 Feb 2007.
//			 */
////			assocs = ((Classifier) element).getAllPropertyAssociations();
//			assocs = element.getOwnedPropertyAssociations();
//		} else {
//			assocs = element.getOwnedPropertyAssociations();
//		}
//		if (assocs == null) return;
//
//		// map: PropertyDeclaration -> set of mode-binding pairs
//		final Map propsToModes = new HashMap();
//		// 2 level map: PropertyDeclaration -> EList of property holders -> set of mode-binding pairs
//		final Map containedPropsToModes = new HashMap();
//		for (final Iterator iter = assocs.iterator(); iter.hasNext(); ) {
//			final PropertyAssociation pa = (PropertyAssociation) iter.next();
//			// check only if property name was resolved
//			final Property pd = pa.getProperty();
//			if (pd != null)	{
//				/* This is where we should check constant property
//				 * associations, but it's too much work to do that.
//				 */
//				if (pa.isConstant()) {
//					warning(pa,
//							"Constant property associations are not checked");
//				}
//				
//				/* Check that the association follows the prop's  "applies to".
//				 */
//				checkAssociationAppliesTo(element, pa);
//
//				/* Check that this PA hasn't already associated a value with
//				 * the property (modulo modes).
//				 */
//				checkUniqueAssociation(element, propsToModes, pa);
//				checkUniqueContainedAssociation(element, containedPropsToModes, pa);
//				
//				// Check that the association has good "in modes"
//				checkInModes(element, pa);
//				
//				// Check that the association is type correct
//				typeCheckPropertyValues(pd.getPropertyType(), pd.isList(), pa.getOwnedValues());
//
//				// Check "list of" issues
//				checkListOf(pa);
//
//				// Check that Overflow_handling_protocol and Queue_size only
//				// appear on in event ports and in event data ports
//				checkPortProperties(element, pa);
//			}
//		}
//	}
//
//	private static class ModeBindingPair {
//		private final Mode mode;
//		private final ComponentClassifier binding;
//		
//		public ModeBindingPair(final Mode m, final ComponentClassifier cc) {
//			mode = m;
//			binding = cc;
//		}
//		
//		public boolean equals(final Object o) {
//			if (o instanceof ModeBindingPair) {
//				final ModeBindingPair mbp = (ModeBindingPair) o;
//				return ((mode == null && mbp.mode == null) || mode.equals(mbp.mode))
//					&& ((binding == null && mbp.binding == null) || binding.equals(mbp.binding));
//			} else {
//				return false;
//			}
//		}
//		
//		public int hashCode() {
//			final int hc1 = (mode == null) ? 0 : mode.hashCode();
//			final int hc2 = (binding == null) ? 0 : binding.hashCode();
//			return hc1 * 13 + hc2;
//		}
//		
//		public String toString() {
//			final String s1 = (mode == null) ? "none" : mode.getName();
//			final String s2 = (binding == null) ? "none" : binding.getQualifiedName();
//			return "(" + s1 + ", " + s2 + ")";
//		}
//	}
//	
//	private static final List NULL_LIST = Collections.singletonList(null);
//	
//	private static Set createPairs(final List modes, final List bindings) {
//		final Set pairs = new HashSet();
//		
//		final List modesList = (modes == null || modes.isEmpty()) ? NULL_LIST : modes;
//		final List bindingsList = (bindings == null || bindings.isEmpty()) ? NULL_LIST : bindings;		
//		for (final Iterator i = modesList.iterator(); i.hasNext();) {
//			final Mode mode = (Mode) i.next();
//			for (final Iterator j = bindingsList.iterator(); j.hasNext();) {
//				final ComponentClassifier binding = (ComponentClassifier) j.next();
//				pairs.add(new ModeBindingPair(mode, binding));
//			}
//		}
//		return pairs;
//	}
//	
//	private void checkUniqueAssociation(
//			final NamedElement ph, final Map propsToModes, final PropertyAssociation pa) {
//		if (pa.getAppliesTos() == null || pa.getAppliesTos().size() == 0) {
//			final Property pd = pa.getProperty();
//			Set definedInModes = (Set) propsToModes.get(pd);
//			if (definedInModes == null) {
//				definedInModes = new HashSet();
//				propsToModes.put(pd, definedInModes);
//			}
//			checkForDuplicateAssociation(ph, pa, definedInModes);
//		}
//	}
//
//	private void checkUniqueContainedAssociation(
//			final NamedElement ph, 
//			final Map containedPropsToModes, final PropertyAssociation pa) {
//		final String appliesTo = unparseContainedAppliesToPath(pa);
//		if (appliesTo.length() > 0) {
//			final Property pd = pa.getProperty();
//			Map subMap = (Map) containedPropsToModes.get(pd);
//			if (subMap == null) {
//				subMap = new HashMap();
//				containedPropsToModes.put(pd, subMap);
//			}
//			Set definedInModes = (Set) subMap.get(appliesTo);
//			if (definedInModes == null) {
//				definedInModes = new HashSet();
//				subMap.put(appliesTo, definedInModes);
//			}
//			checkForDuplicateAssociation(ph, pa, definedInModes);
//		}
//	}
//
//	/**
//	 * @param pa
//	 * @param definedInModes
//	 */
//	private void checkForDuplicateAssociation(
//			final NamedElement ph, 
//			final PropertyAssociation pa, Set definedInModes) {
//		final EList inBinding = pa.getInBindings();
//		final Set pairs = createPairs(inModes, inBinding);
//		final Set alreadyDefined = new HashSet();
//		for (final Iterator i = pairs.iterator(); i.hasNext(); ) {
//			final ModeBindingPair mbp = (ModeBindingPair) i.next();
//			if (definedInModes.contains(mbp)) {
//				alreadyDefined.add(mbp);
//			}
//		}
//		definedInModes.addAll(pairs);
//		
//		if (!alreadyDefined.isEmpty()) {
//			final String appliesTo = unparseContainedAppliesToPath(pa);
//			for (final Iterator i = alreadyDefined.iterator(); i.hasNext();) {
//				final ModeBindingPair mbp = (ModeBindingPair) i.next();
//				error(ph,
//						"\"" + ph.getName() + "\" has multiple property associations for \"" + 
//						pa.getProperty().getQualifiedName() + "\"" +
//						((appliesTo.length() == 0) ? "" : (" applying to " + appliesTo)) +
//						((mbp.mode == null) ? "" : (" in mode " + mbp.mode.getName())) +
//						((mbp.binding == null) ? "" : (" in binding " + mbp.binding.getQualifiedName())));
//			}
//		}
//	}
//
//	private String unparseContainedAppliesToPath(final PropertyAssociation pa) {
//		final List appliesTo = pa.getAppliesTos();
//		final StringBuffer sb = new StringBuffer();
//		for (final Iterator i = appliesTo.iterator(); i.hasNext();) {
//			final NamedElement ne = (NamedElement) i.next();
//			sb.append(ne.getName());
//			if (i.hasNext()) sb.append('.');
//		}
//		return sb.toString();
//	}
//	
//	/**
//	 * Checks legality rule from Section 4.5 Subcomponents:
//	 *
//	 * <blockquote>If the subcomponent declaration contains an in_modes
//	 * statement and any of its property associations also contains an in_modes
//	 * statement, then the modes named in the property association must be a
//	 * subset of those named in the subcomponent declaration. </blockquote>
//	 *
//	 * @param element
//	 *            The property holder whose in_modes should be checked. This
//	 *            method is only interested in SubprogramSubcomponent,
//	 *            Subcomponent, Connection, and FlowSequence elements.
//	 *
//	 * @param pa
//	 *            The particular property association whose in_modes must be a
//	 *            subset of the modes in which <code>element</code> exists.
//	 */
//	private void checkInModes(final NamedElement element, final PropertyAssociation pa) {
//		final EList innerModes = pa.getInModes();
//		if (innerModes != null) {
//			EList outerModes = null;
//			if (element instanceof SubprogramSubcomponent) {
//				/* We need to treat SubprogramSubcomponents specially because
//				 * the modes they exist in are controlled by the CallSequence.
//				 */
//				final SubprogramCallSequence cs = (SubprogramCallSequence) element.eContainer();
//				outerModes = cs.getInModes();
//			} else if (element instanceof Subcomponent
//					|| element instanceof Connection
//					|| element instanceof FlowElement) {
//				outerModes = ((ModalElement) element).getInModes();
//			}
//
//			if (outerModes != null) {
//				// Empty set means that no modes were declared, i.e., all modes
//				if (!outerModes.isEmpty()
//						&& !outerModes.containsAll(innerModes)) {
//					error(pa,
//							"Property association has more modes than its container");
//				}
//			}
//		}
//	}
//
//	/**
//	 * Check that non-list properties do not get associated with a list of
//	 * values:
//	 *
//	 * <blockquote>
//	 * If the property declaration for the associated property name
//	 * does not contain the reserved words list of, the property_value must be a
//	 * single_property_value. If the property declaration for the associated
//	 * property name contains the reserved words list of, the property_value can
//	 * be a single_property_value, which is interpreted to be a list of one
//	 * value.
//	 *
//	 * The property association operator +=> must only be used if the property
//	 * declaration for the associated property name contains the reserved words
//	 * list of.
//	 * </blockquote>
//	 *
//	 * @param pa
//	 */
//	private void checkListOf(final PropertyAssociation pa) {
//		final Property pn = pa.getProperty();
//		if (pn == null)
//			return;
//		final EList value = pa.getOwnedValues();
//		if (!pn.isList()) {
//			// Must only have one value associated with the property
//			if (value == null || value.size() == 0) {
//				error(pa,
//						"Scalar properties must have a value");
//			} else if (value.size() > 1) {
//				error(pa,
//						"Scalar properties cannot be associated with a list");
//			}
//			if (pa.isAppend()) {
//				error(pa,
//						"Cannot append to a scalar property");
//			}
//		}
//	}
//
//	/**
//	 * Checks contraints on the <code>Overflow_Handling_Protocol</code>,
//	 * <code>Queue_Processing_Protocol</code>, <code>Dequeue_Protocol</code>,
//	 * <code>Queue_Size</code> properties as specificed in Section 8.1 Ports:
//	 *
//	 * <blockquote>The property names Overflow_Handling_Protocol,
//	 * Queue_Processing_Protocol, Dequeue_Protocol, and Queue_Size
//	 * may only appear in property associations for in event ports and in event
//	 * data ports. </blockquote>
//	 * 
//	 * <p>The <code>applies to</code> clause in the property definition
//	 * already makes sure they only appear on <code>event port</code> 
//	 * and <code>event data port</code> (and <code>subprogram</code> for all
//	 * but <code>Dequeue_Protocol</code>).  So here we check that the port 
//	 * is an <code>in port</code>.
//	 *
//	 * @param ph
//	 *            The property holder
//	 * @param pa
//	 *            The property association to check
//	 */
//	private void checkPortProperties(final NamedElement ph, final PropertyAssociation pa) {
//		if (ph instanceof EventPort || ph instanceof EventDataPort) {
//			final Property pd = pa.getProperty();
//			if (pd == PropertiesLinkingService.getPropertiesLinkingService(ph).findPropertyDefinition(ph,CommunicationProperties.OVERFLOW_HANDLING_PROTOCOL) ||
//					pd.getName().equalsIgnoreCase(CommunicationProperties.QUEUE_SIZE) ||
//					pdgetName().equalsIgnoreCase(CommunicationProperties.UE_PROCESSING_PROTOTOCOL) ||
//					pd == DEQUEUE_PROTOCOL_PD) {
//				final DirectionType dir = ((Port) ph).getDirection();
//				if (dir != DirectionType.IN) {
//					error(pa,
//							"Property \"" + pd.getName() +
//							"\" is only allowed on in event ports and in event data ports");
//				}
//			}
//		}
//	}
//
//

	private static FeatureType getFeatureType(Feature feature) {
		if (feature instanceof DataPort) {
			switch (((DataPort) feature).getDirection()) {
			case IN:
				return FeatureType.IN_DATA_PORT;
			case OUT:
				return FeatureType.OUT_DATA_PORT;
			case IN_OUT:
				return FeatureType.IN_OUT_DATA_PORT;
			}
		} else if (feature instanceof EventPort) {
			switch (((EventPort) feature).getDirection()) {
			case IN:
				return FeatureType.IN_EVENT_PORT;
			case OUT:
				return FeatureType.OUT_EVENT_PORT;
			case IN_OUT:
				return FeatureType.IN_OUT_EVENT_PORT;
			}
		} else if (feature instanceof EventDataPort) {
			switch (((EventDataPort) feature).getDirection()) {
			case IN:
				return FeatureType.IN_EVENT_DATA_PORT;
			case OUT:
				return FeatureType.OUT_EVENT_DATA_PORT;
			case IN_OUT:
				return FeatureType.IN_OUT_EVENT_DATA_PORT;
			}
		} else if (feature instanceof FeatureGroup)
			return FeatureType.FEATURE_GROUP;
		else if (feature instanceof DataAccess) {
			switch (((DataAccess) feature).getKind()) {
			case PROVIDED:
				return FeatureType.PROVIDES_DATA_ACCESS;
			case REQUIRED:
				return FeatureType.REQUIRES_DATA_ACCESS;
			}
		} else if (feature instanceof SubprogramAccess) {
			switch (((SubprogramAccess) feature).getKind()) {
			case PROVIDED:
				return FeatureType.PROVIDES_SUBPROGRAM_ACCESS;
			case REQUIRED:
				return FeatureType.REQUIRES_SUBPROGRAM_ACCESS;
			}
		} else if (feature instanceof SubprogramGroupAccess) {
			switch (((SubprogramGroupAccess) feature).getKind()) {
			case PROVIDED:
				return FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS;
			case REQUIRED:
				return FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS;
			}
		} else if (feature instanceof BusAccess) {
			switch (((BusAccess) feature).getKind()) {
			case PROVIDED:
				return FeatureType.PROVIDES_BUS_ACCESS;
			case REQUIRED:
				return FeatureType.REQUIRES_BUS_ACCESS;
			}
		} else if (feature instanceof AbstractFeature)
			return FeatureType.ABSTRACT_FEATURE;
		else if (feature instanceof Parameter)
			return FeatureType.PARAMETER;
		return null;
	}

	private static String getKeywordForAccessType(AccessType accessType) {
		switch (accessType) {
		case PROVIDED:
			return "provides";
		case REQUIRED:
			return "requires";
		default:
			throw new AssertionError("Unhandled enum literal: " + accessType);
		}
	}

	static {
		HashMap<ComponentCategory, Set<FeatureType>> featuresForTypes = new HashMap<ComponentCategory, Set<FeatureType>>();

		// Abstract Types
		FeatureType[] featureTypesArray = new FeatureType[] {
				FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT,
				FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT,
				FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE };
		Set<FeatureType> featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.ABSTRACT,
				Collections.unmodifiableSet(featureTypesSet));

		// Data Types
		featureTypesArray = new FeatureType[] {
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.DATA,
				Collections.unmodifiableSet(featureTypesSet));

		// Subprogram Types
		featureTypesArray = new FeatureType[] { FeatureType.OUT_EVENT_PORT,
				FeatureType.OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.PARAMETER, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.SUBPROGRAM,
				Collections.unmodifiableSet(featureTypesSet));

		// Subprogram Group Types
		featureTypesArray = new FeatureType[] {
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.FEATURE_GROUP, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.SUBPROGRAM_GROUP,
				Collections.unmodifiableSet(featureTypesSet));

		// Thread Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT,
				FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.THREAD,
				Collections.unmodifiableSet(featureTypesSet));

		// Thread Group Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT,
				FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.THREAD_GROUP,
				Collections.unmodifiableSet(featureTypesSet));

		// Process Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT,
				FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.PROCESS,
				Collections.unmodifiableSet(featureTypesSet));

		// Processor Types
		featureTypesArray = new FeatureType[] {
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT,
				FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT,
				FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.PROCESSOR,
				Collections.unmodifiableSet(featureTypesSet));

		// Virtual Processor Types
		featureTypesArray = new FeatureType[] {
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.IN_DATA_PORT, FeatureType.OUT_DATA_PORT,
				FeatureType.IN_OUT_DATA_PORT, FeatureType.IN_EVENT_PORT,
				FeatureType.OUT_EVENT_PORT, FeatureType.IN_OUT_EVENT_PORT,
				FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.VIRTUAL_PROCESSOR,
				Collections.unmodifiableSet(featureTypesSet));

		// Memory Types
		featureTypesArray = new FeatureType[] {
				FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.FEATURE_GROUP,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.MEMORY,
				Collections.unmodifiableSet(featureTypesSet));

		// Bus Types
		featureTypesArray = new FeatureType[] {
				FeatureType.REQUIRES_BUS_ACCESS, FeatureType.FEATURE_GROUP,
				FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.BUS,
				Collections.unmodifiableSet(featureTypesSet));

		// Virtual Bus Types
		featureTypesSet = Collections.emptySet();
		featuresForTypes.put(ComponentCategory.VIRTUAL_BUS, featureTypesSet);

		// Device Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT,
				FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.DEVICE,
				Collections.unmodifiableSet(featureTypesSet));

		// System Types
		featureTypesArray = new FeatureType[] { FeatureType.IN_DATA_PORT,
				FeatureType.OUT_DATA_PORT, FeatureType.IN_OUT_DATA_PORT,
				FeatureType.IN_EVENT_PORT, FeatureType.OUT_EVENT_PORT,
				FeatureType.IN_OUT_EVENT_PORT, FeatureType.IN_EVENT_DATA_PORT,
				FeatureType.OUT_EVENT_DATA_PORT,
				FeatureType.IN_OUT_EVENT_DATA_PORT, FeatureType.FEATURE_GROUP,
				FeatureType.PROVIDES_SUBPROGRAM_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_ACCESS,
				FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS,
				FeatureType.PROVIDES_BUS_ACCESS,
				FeatureType.REQUIRES_BUS_ACCESS,
				FeatureType.PROVIDES_DATA_ACCESS,
				FeatureType.REQUIRES_DATA_ACCESS, FeatureType.ABSTRACT_FEATURE };
		featureTypesSet = new HashSet<FeatureType>();
		for (FeatureType featureType : featureTypesArray)
			featureTypesSet.add(featureType);
		featuresForTypes.put(ComponentCategory.SYSTEM,
				Collections.unmodifiableSet(featureTypesSet));

		acceptableFeaturesForTypes = Collections
				.unmodifiableMap(featuresForTypes);

		HashMap<ComponentCategory, Set<ComponentCategory>> categoriesForImplementations = new HashMap<ComponentCategory, Set<ComponentCategory>>();

		// Abstract Implementations
		HashSet<ComponentCategory> categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory currentCategory : ComponentCategory.values())
			categoriesSet.add(currentCategory);
		categoriesForImplementations.put(ComponentCategory.ABSTRACT,
				Collections.unmodifiableSet(categoriesSet));

		// Data Implementations
		ComponentCategory[] categoriesArray = new ComponentCategory[] {
				ComponentCategory.DATA, ComponentCategory.SUBPROGRAM,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.DATA,
				Collections.unmodifiableSet(categoriesSet));

		// Subprogram Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.SUBPROGRAM,
				Collections.unmodifiableSet(categoriesSet));

		// Subprogram Group Implementations
		categoriesArray = new ComponentCategory[] {
				ComponentCategory.SUBPROGRAM, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.SUBPROGRAM_GROUP,
				Collections.unmodifiableSet(categoriesSet));

		// Thread Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA,
				ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.THREAD,
				Collections.unmodifiableSet(categoriesSet));

		// Thread Group Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA,
				ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.THREAD,
				ComponentCategory.THREAD_GROUP, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.THREAD_GROUP,
				Collections.unmodifiableSet(categoriesSet));

		// Process Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA,
				ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.THREAD,
				ComponentCategory.THREAD_GROUP, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.PROCESS,
				Collections.unmodifiableSet(categoriesSet));

		// Processor Implementations
		categoriesArray = new ComponentCategory[] {
				ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.MEMORY,
				ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.PROCESSOR,
				Collections.unmodifiableSet(categoriesSet));

		// Virtual Processor Implementations
		categoriesArray = new ComponentCategory[] {
				ComponentCategory.VIRTUAL_PROCESSOR,
				ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.VIRTUAL_PROCESSOR,
				Collections.unmodifiableSet(categoriesSet));

		// Memory Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.MEMORY,
				ComponentCategory.BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.MEMORY,
				Collections.unmodifiableSet(categoriesSet));

		// Bus Implementations
		categoriesArray = new ComponentCategory[] {
				ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.BUS,
				Collections.unmodifiableSet(categoriesSet));

		// Virtual Bus Implementations
		categoriesArray = new ComponentCategory[] {
				ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.VIRTUAL_BUS,
				Collections.unmodifiableSet(categoriesSet));

		// Device Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.BUS,
				ComponentCategory.VIRTUAL_BUS, ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.DEVICE,
				Collections.unmodifiableSet(categoriesSet));

		// System Implementations
		categoriesArray = new ComponentCategory[] { ComponentCategory.DATA,
				ComponentCategory.SUBPROGRAM,
				ComponentCategory.SUBPROGRAM_GROUP, ComponentCategory.PROCESS,
				ComponentCategory.PROCESSOR,
				ComponentCategory.VIRTUAL_PROCESSOR, ComponentCategory.MEMORY,
				ComponentCategory.BUS, ComponentCategory.VIRTUAL_BUS,
				ComponentCategory.DEVICE, ComponentCategory.SYSTEM,
				ComponentCategory.ABSTRACT };
		categoriesSet = new HashSet<ComponentCategory>();
		for (ComponentCategory category : categoriesArray)
			categoriesSet.add(category);
		categoriesForImplementations.put(ComponentCategory.SYSTEM,
				Collections.unmodifiableSet(categoriesSet));

		acceptableSubcomponentCategoriesForImplementations = Collections
				.unmodifiableMap(categoriesForImplementations);

		Map<EClass, String> featureClassNamesWithArticle = new HashMap<EClass, String>();
		featureClassNamesWithArticle.put(
				Aadl2Package.eINSTANCE.getAbstractFeature(),
				"an abstract feature");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getBusAccess(),
				"a bus access");
		featureClassNamesWithArticle.put(
				Aadl2Package.eINSTANCE.getDataAccess(), "a data access");
		featureClassNamesWithArticle.put(
				Aadl2Package.eINSTANCE.getSubprogramAccess(),
				"a subprogram access");
		featureClassNamesWithArticle.put(
				Aadl2Package.eINSTANCE.getSubprogramGroupAccess(),
				"a subprogram group access");
		featureClassNamesWithArticle.put(
				Aadl2Package.eINSTANCE.getFeatureGroup(), "a feature group");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getParameter(),
				"a parameter");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getDataPort(),
				"a data port");
		featureClassNamesWithArticle
				.put(Aadl2Package.eINSTANCE.getEventDataPort(),
						"an event data port");
		featureClassNamesWithArticle.put(Aadl2Package.eINSTANCE.getEventPort(),
				"an event port");
		FEATURE_CLASS_NAMES_WITH_ARTICLE = Collections
				.unmodifiableMap(featureClassNamesWithArticle);
	}

	private static enum FeatureType {
		IN_DATA_PORT("an in data port"), OUT_DATA_PORT("an out data port"), IN_OUT_DATA_PORT(
				"an in out data port"), IN_EVENT_PORT("an in event port"), OUT_EVENT_PORT(
				"an out event port"), IN_OUT_EVENT_PORT("an in out event port"), IN_EVENT_DATA_PORT(
				"an in event data port"), OUT_EVENT_DATA_PORT(
				"an out event data port"), IN_OUT_EVENT_DATA_PORT(
				"an in out event data port"), FEATURE_GROUP("a feature group"), PROVIDES_DATA_ACCESS(
				"a provides data access"), REQUIRES_DATA_ACCESS(
				"a requires data access"), PROVIDES_SUBPROGRAM_ACCESS(
				"a provides subprogram access"), REQUIRES_SUBPROGRAM_ACCESS(
				"a requires subprogram access"), PROVIDES_SUBPROGRAM_GROUP_ACCESS(
				"a provides subprogram group access"), REQUIRES_SUBPROGRAM_GROUP_ACCESS(
				"a requires subprogram group access"), PROVIDES_BUS_ACCESS(
				"a provides bus access"), REQUIRES_BUS_ACCESS(
				"a requires bus access"), ABSTRACT_FEATURE(
				"an abstract feature"), PARAMETER("a parameter");

		private final String nameWithIndefiniteArticle;

		private FeatureType(String nameWithIndefiniteArticle) {
			this.nameWithIndefiniteArticle = nameWithIndefiniteArticle;
		}

		public String getNameWithIndefiniteArticle() {
			return nameWithIndefiniteArticle;
		}
	}

	private static final Map<ComponentCategory, Set<FeatureType>> acceptableFeaturesForTypes;
	private static final Map<ComponentCategory, Set<ComponentCategory>> acceptableSubcomponentCategoriesForImplementations;
	private static final Map<EClass, String> FEATURE_CLASS_NAMES_WITH_ARTICLE;


	/**
	 * Checks if {@code child} can extend {@code parent}.
	 */
	public static boolean canExtend(ComponentType parent, ComponentType child)
	{
		return parent.eClass()==child.eClass() || parent instanceof AbstractType;
	}

	/**
	 * Checks if {@code child} can extend {@code parent}.
	 */
	public static boolean canExtend(ComponentImplementation parent, ComponentImplementation child)
	{
		return parent.eClass()==child.eClass() || parent instanceof AbstractImplementation;
	}
	
	public static ComponentCategory getComponentPrototypeCategory(ComponentPrototype prototype)
	{
	String eClassname =  prototype.eClass().getName();
	String s= eClassname.substring(0, eClassname.length()-9);
	ComponentCategory prototypeCategory = ComponentCategory.get(s.toLowerCase());
	return prototypeCategory;
	}
	
	/**
	 * Check that a number type is well formed.  The range values (if any)
	 * should be such that the lower bound is not greater than the upper bound.
	 * Satisfies legality rule from Section 10.1.1:
	 *
	 * <blockquote>
	 * The value of the first numeric literal that appears in a range of a
	 * number_type must not be greater than the value of the second numeric
	 * literal.
	 * </blockquote>
	 */
	protected void checkNumberType(final NumberType nt) {
		/* NOTE: NumericResolver + Parser already make sure the bounds are
		 * both reals or both integers, as appropriate.
		 */
		final NumericRange range = nt.getRange();
		if (range == null) return;
		PropertyExpression	lowerPE = (PropertyExpression)range.getLowerBound();
		PropertyExpression	upperPE = (PropertyExpression)range.getUpperBound();
		// TODO : handle NamedValue
		if (lowerPE instanceof NamedValue){
			if (((NamedValue)lowerPE).getNamedValue() instanceof PropertyConstant){
				lowerPE=((PropertyConstant)((NamedValue)lowerPE).getNamedValue()).getConstantValue();
			}
		}
		if (upperPE instanceof NamedValue){
			if (((NamedValue)upperPE).getNamedValue() instanceof PropertyConstant){
				upperPE=((PropertyConstant)((NamedValue)upperPE).getNamedValue()).getConstantValue();
			}
		}
		NumberValue lowerNV = lowerPE instanceof NumberValue? (NumberValue)lowerPE: null;
		NumberValue upperNV = upperPE instanceof NumberValue? (NumberValue)upperPE: null;
		if (lowerNV != null && upperNV != null) {
			/* Check: (1) the bounds have units if the type has units;
			 * (2) the lower bounds is <= the upper bound.
			 */
			if (lowerNV instanceof NumberValue){
				
			}
			if (nt.getUnitsType() != null) {
				if (lowerNV.getUnit() == null) {
					error(nt,
							"lower bound is missing a unit");
				}
				if (upperNV.getUnit() == null) {
					error(nt,
							"upper bound is missing a unit");
				}
			}
			final double lower = lowerNV.getScaledValue();
			final double upper = upperNV.getScaledValue();
			if (lower > upper) {
				error(nt,
						"Range lower bound is greater than range upper bound");
			}
		}
	}

	/**
	 * Check that if an aadlinteger type has units that the units have only
	 * integer multipliers.
	 */
	protected void checkAadlinteger(final AadlInteger ai) {
		final UnitsType units = ai.getUnitsType();
		if (units != null) {
			for (Iterator i = units.getOwnedLiterals().iterator(); i.hasNext();) {
				final UnitLiteral ul = (UnitLiteral) i.next();
				final NumberValue factor = ul.getFactor();
				if (factor != null && !(factor instanceof IntegerLiteral)) {
					error(ai,
							"Integer type has unit (" + ul.getName() +
							") with non-integer factor (" +
							ul.getFactor().toString() + ")");
				}
			}
		}
	}


}

