package org.osate.xtext.aadl2.properties.linking;


import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.ImportScope;
import org.eclipse.xtext.scoping.impl.SelectableBasedScope;
import org.osate.aadl2.*;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.Activator;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.xtext.aadl2.properties.util.PSNode;

import com.google.inject.Inject;


public class PropertiesLinkingService extends DefaultLinkingService {


	private static PropertiesLinkingService eInstance = null;

	public PropertiesLinkingService(){
		super();
	}

	public static PropertiesLinkingService getPropertiesLinkingService(Element context){
		if (eInstance == null) {
			if (context.eResource() instanceof Aadl2ResourceImpl){
				Element root = context.getElementRoot();
				if (root instanceof SystemInstance){
					SystemImplementation si = ((SystemInstance)root).getSystemImplementation();
					LazyLinkingResource r = (LazyLinkingResource)si.eResource();
					eInstance = (PropertiesLinkingService)r.getLinkingService();
				}
			} else {
				LazyLinkingResource r = (LazyLinkingResource)context.eResource();
				eInstance = (PropertiesLinkingService)r.getLinkingService();
			}
		}
		return eInstance;
	}

	private static PSNode psNode = new PSNode();

	public  EObject getIndexedObject(EObject context,
			EReference reference, String crossRefString) {
		psNode.setText(crossRefString);
		List<EObject> el;
		try {
			el = super.getLinkedObjects(context, reference, psNode);
		} catch (Exception e) {
			return null;
		}
		EObject res = (el.isEmpty()?null: el.get(0));
		if (res != null&&res.eIsProxy()){
			res = EcoreUtil.resolve(res,context);
			if (res.eIsProxy()) return null;
		}
		return res;

		//	final IScope scope = getScope(context, reference);
		//	QualifiedName qualifiedLinkName =  QualifiedName.create(crossRefString);
		//	IEObjectDescription eObjectDescription = scope.getSingleElement(qualifiedLinkName);
		//	if (eObjectDescription != null) 
		//		return eObjectDescription.getEObjectOrProxy();
		//	return null;
	}


	
	
	@Inject
	private IQualifiedNameConverter qualifiedNameConverter;
	
//	/**
//	 * @return the all elements returned from the injected {@link IScopeProvider} which matches the text of the passed
//	 *         {@link LeafNode}
//	 */
//	public boolean hasDuplicateLinkedObjects(EObject context, EReference ref)
//			throws IllegalNodeException {
//		final EClass requiredType = ref.getEReferenceType();
//		if (requiredType == null)
//			return false;
//		if (!(context instanceof NamedElement)) return false;
//			String crossRefString = ((NamedElement)context).getName();
//			EObject eo = getIndexedObject(context, ref, crossRefString);
//			final IScope scope = getScope(context, ref);
//			if (scope instanceof ImportScope){
//				ImportScope is = (ImportScope)scope;
//				IScope ps = is.getParent();
//				Iterable<IEObjectDescription> el = ((SelectableBasedScope)ps).getAllElements();
//				for (IEObjectDescription ieObjectDescription : el) {
//					String s = ieObjectDescription.getQualifiedName().toString();
//					EObject eobj = ieObjectDescription.getEObjectOrProxy();
//					if (crossRefString.equalsIgnoreCase(ieObjectDescription.getQualifiedName().toString())){
//						Object e = ieObjectDescription.getEObjectOrProxy();
//					}
//				}
//			}
//		return false;
//	}
//	public boolean hasDuplicatesAadlPackage(EObject context) {
//	EReference reference = Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit();
//	boolean res = hasDuplicateLinkedObjects(context, reference);
//	return res;
//}
//
//public boolean hasDuplicatesClassifier(EObject context) {
//	EReference reference = Aadl2Package.eINSTANCE.getPackageSection_OwnedClassifier();
//	boolean res = hasDuplicateLinkedObjects(context, reference);
//	return res;
//}

	
	@Override
	public String getCrossRefNodeAsString(INode node)
			throws IllegalNodeException {
		if (node instanceof PSNode) {
			return getLinkingHelper().getCrossRefNodeAsString(node, false);
		} else {
			return getLinkingHelper().getCrossRefNodeAsString(node, true);
		}
	}


	/**
	 * returns the first linked object
	 */
	@Override
	public List<EObject> getLinkedObjects(EObject context,
			EReference reference, INode node) throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		if (requiredType == null)
			return Collections.<EObject> emptyList();
		EObject searchResult = null;

		final EClass cl = Aadl2Package.eINSTANCE.getClassifier();
		final EClass sct = Aadl2Package.eINSTANCE.getSubcomponentType();
		final EClass pt = Aadl2Package.eINSTANCE.getPropertyType();
		final String name = getCrossRefNodeAsString(node);
		if (sct.isSuperTypeOf(requiredType) || cl.isSuperTypeOf(requiredType)) {
			// resolve classifier reference
			EObject e = findClassifier(context, reference,  name);
			if (e != null ) {
				// the result satisfied the expected class
				return Collections.singletonList((EObject) e);
			}
			if (Aadl2Package.eINSTANCE.getPrototype().isSuperTypeOf(requiredType)){
				// need to resolve prototype
				EObject res = getContainingClassifier(context)
						.findNamedElement(name);
				if (Aadl2Package.eINSTANCE.getDataPrototype()==reference ){
					if( res instanceof DataPrototype ){
						searchResult = res;
					}
				} else if ( res instanceof ComponentPrototype) {
					searchResult = res;
				}
			}
		} else if (Aadl2Package.eINSTANCE.getModelUnit() == requiredType) {
			AadlPackage pack = findAadlPackage(context, name, reference);
			if (pack != null) {
				searchResult = pack;
			} else {
				PropertySet ps = findPropertySet(context, name, reference);
				if (ps != null) {
					searchResult = ps;
				}
			}

		} else if (Aadl2Package.eINSTANCE.getAadlPackage() == requiredType) {
			AadlPackage pack = findAadlPackage(context, name, reference);
			if (pack != null) {
				searchResult = pack;
			}

		} else if (Aadl2Package.eINSTANCE.getPropertySet() == requiredType) {
			PropertySet ps = findPropertySet(context, name, reference);
			if (ps != null) {
				searchResult = ps;
			}


		} else if (Aadl2Package.eINSTANCE.getFeature() == requiredType) {
			// Feature used in FlowSpec
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Feature) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject res = ns.findNamedElement(name);
			if (res != null && res instanceof Feature) {
				searchResult = res;
			}

		} else if (Aadl2Package.eINSTANCE.getSubcomponent() == requiredType) {
			// if context Subcomponent then find in extension source (refined
			// to)
			// prototype binding as context
			Classifier ns = getContainingClassifier(context);
			if (context instanceof Subcomponent) {
				// we need to resolve a refinement
				if (ns.getExtended() != null) {
					ns = ns.getExtended();
				} else {
					return Collections.emptyList();
				}
			}
			EObject res = ns.findNamedElement(name);
			if (res instanceof Subcomponent) {
				searchResult = res;
			}

		} else if (Aadl2Package.eINSTANCE.getProperty() == requiredType) {
			// look for property definition in property set
			return findPropertyDefinitionAsList(context, reference, name);


		}else if( Aadl2Package.eINSTANCE.getAbstractNamedValue() == requiredType ){
			// AbstractNamedValue: constant reference, property definition reference, unit literal, enumeration literal
			if (context instanceof NamedValue){
				List<EObject> res = findPropertyConstant(context, reference, name);
				if (res.isEmpty()){
					res = findPropertyDefinitionAsList(context, reference, name);
				}
				if (res.isEmpty() && name.indexOf("::")==-1){
					// names without qualifier. Must be enum/unit literal
					res = findEnumLiteralAsList(context, reference, name);
					if (res.isEmpty())
						res = findUnitLiteralAsList(context, reference, name);
				}
				return res;
			}

		} else if (Aadl2Package.eINSTANCE.getBasicProperty() == requiredType) {
			// look for record field definition
			if (context instanceof BasicPropertyAssociation) {
				BasicPropertyAssociation bpa = (BasicPropertyAssociation) context;
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				Element parent = bpa.getOwner();
				while (parent != null && !(parent instanceof BasicPropertyAssociation || parent instanceof PropertyAssociation
						|| parent instanceof Property || parent instanceof PropertyConstant)){
					parent = parent.getOwner();
				}
				PropertyType propertyType =null;
				if (parent instanceof BasicPropertyAssociation){
					BasicProperty bp = ((BasicPropertyAssociation)parent).getProperty();
					if (bp != null){
						propertyType=bp.getPropertyType();
					}
				} else if (parent instanceof PropertyAssociation){
					Property pd =((PropertyAssociation)parent).getProperty();
					if (pd != null){
						propertyType=pd.getPropertyType();
					}
				} else if (parent instanceof Property){
					propertyType =((Property)parent).getPropertyType();
				} else if (parent instanceof PropertyConstant){
					propertyType =((PropertyConstant)parent).getPropertyType();
				}
				propertyType = AadlUtil.getBasePropertyType(propertyType);

				if (propertyType != null && propertyType instanceof RecordType) {
					BasicProperty rf = (BasicProperty) ((RecordType) propertyType).findNamedElement(name);
					if (rf != null)
						searchResult = rf;
				}
			}

		} else if (Aadl2Package.eINSTANCE.getMode() == requiredType) {
			// referenced by mode transition and inmodes
			EObject res = getContainingClassifier(context)
					.findNamedElement(name);
			if (res != null && res instanceof Mode) {
				searchResult = res;
			}
			if (context instanceof ModeBinding && Aadl2Package.eINSTANCE.getModeBinding_DerivedMode()==reference ){
				return Collections.singletonList((EObject) searchResult);
			}

		} else if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			// containment path element
			if (context instanceof ContainmentPathElement) {
				EObject res = null;
				ContainedNamedElement path = (ContainedNamedElement) context
						.eContainer();
				EList<ContainmentPathElement> list = path
						.getContainmentPathElements();
				int idx = list.indexOf(context);
				if (idx > 0) {
					ContainmentPathElement el = list.get(idx - 1);
					NamedElement ne = el.getNamedElement();
					if (ne instanceof Subcomponent) {
						Classifier ns = ((Subcomponent) ne).getClassifier();
						if (ns != null)
							res = ns.findNamedElement(name);
					} else if (ne instanceof FeatureGroup) {
						Classifier ns = ((FeatureGroup) ne)
								.getFeatureGroupType();
						if (ns != null)
							res = ns.findNamedElement(name);
					}
				} else {
					Classifier ns = getContainingClassifier(context);
					if (ns != null)
						res = ns.findNamedElement(name);
				}
				if (res != null
						&& res instanceof NamedElement) {
					searchResult = res;
				}
			}
		} else {
			List<EObject> superes = super.getLinkedObjects(context, reference, node);
			if (superes.isEmpty()){
				Activator.logErrorMessage("Unhandled reference in LinkingService: "+reference.getName()+" to "+requiredType.getName());
			}
			return superes;
		}
		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
		return Collections.<EObject> emptyList();
	}


	public AadlPackage findAadlPackage(EObject context, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit();
		return findAadlPackage(context, name, reference);
	}
	


	public AadlPackage findAadlPackage(EObject context, String name, EReference reference) {
		EObject res = getIndexedObject(context, reference, name);
		if (res instanceof AadlPackage)
			return (AadlPackage)res;
		if (name == null || name.length() == 0)
			return null;
		ResourceSet rs = context.eResource().getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof AadlPackage)
						&& ((AadlPackage) rootObject).getName()
						.equalsIgnoreCase(name))
					return (AadlPackage) rootObject;
			}
		}
		return null;
	}

	public AadlPackage findAadlPackageReference(String packageName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName()
				.equalsIgnoreCase(packageName)))
			return 	(AadlPackage)((PackageSection) context).eContainer();
		else {
			AadlPackage aadlPackage = null;

			if (context instanceof PackageSection) {
				PackageRename packageRename = findPackageRename(packageName,
						(PackageSection) context);
				if (packageRename != null)
					aadlPackage = packageRename.getRenamedPackage();
				else
					aadlPackage = findImportedPackage(packageName, context);
			} else
				aadlPackage = findImportedPackage(packageName, context);


			return aadlPackage;
		}
	}

	/**
	 * Search for a {@link PackageRename} in a package. If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will also search through
	 * the {@link PackageRename}s of the corresponding
	 * {@link PublicPackageSection}. The {@link PackageRename#isRenameAll()
	 * renameAll} flag of the returned {@link PackageRename} will be
	 * {@code false}.
	 * 
	 * @param name
	 *            The name of the {@link PackageRename} to search for.
	 * @param context
	 *            The {@link PackageSection} that contains the {@link Element}
	 *            that needs a {@link PackageRename}.
	 * @return The {@link PackageRename} or {@code null} if it cannot be found.
	 */
	public PackageRename findPackageRename(String name,
			PackageSection context) {
		NamedElement searchResult = context.findNamedElement(name, false);
		if (searchResult == null
				&& context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getPublicSection() != null) {
			searchResult = ((AadlPackage) context.eContainer())
					.getPublicSection().findNamedElement(name, false);
		}
		if (searchResult instanceof PackageRename)
			return (PackageRename) searchResult;
		else
			return null;
	}

	public AadlPackage findImportedPackage(String name, EObject context) {
		EList<ModelUnit> imports;
		if (name == null) return null;
		if (!(context instanceof PropertySet || context instanceof PackageSection)) {
			context = getContainingTopLevelNamespace(context);
		}
		if (context instanceof PropertySet)
			imports = ((PropertySet) context).getImportedUnits();
		else
			imports = ((PackageSection) context).getImportedUnits();
		for (ModelUnit imported : imports) {
			if (imported instanceof AadlPackage && !imported.eIsProxy()) {
				String n = ((AadlPackage) imported).getName();
				if (name.equalsIgnoreCase(n))
					return (AadlPackage) imported;
			}
		}
		if (context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null)
			for (ModelUnit imported : ((AadlPackage) context.eContainer())
					.getOwnedPublicSection().getImportedUnits())
				if (imported instanceof AadlPackage && !imported.eIsProxy()
						&& ((AadlPackage) imported).getName().equalsIgnoreCase(
								name))
					return (AadlPackage) imported;
		// TODO need to handle public section declared in a separate package
		// declaration
		return null;
	}

	public PropertySet findImportedPropertySet(String name,
			EObject context) {
		EList<ModelUnit> importedPropertySets;
		if (name == null) return null;
		if (!(context instanceof PropertySet || context instanceof PackageSection)) {
			context = getContainingTopLevelNamespace(context);
		}
		if (context instanceof PropertySet)
			importedPropertySets = ((PropertySet) context).getImportedUnits();
		else
			importedPropertySets = ((PackageSection) context)
			.getImportedUnits();
		for (ModelUnit importedPropertySet : importedPropertySets)
			if (importedPropertySet instanceof PropertySet && !importedPropertySet.eIsProxy()
					&& ((PropertySet) importedPropertySet).getName()
					.equalsIgnoreCase(name))
				return (PropertySet) importedPropertySet;
		return null;
	}


	public PropertySet findPropertySet(EObject context, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit();
		return findPropertySet(context, name, reference);
	}



	public PropertySet findPropertySet(EObject context, String name, EReference reference) {
		EObject res = getIndexedObject(context, reference, name);
		if (res instanceof PropertySet)
			return (PropertySet)res;
		if (name == null || name.length() == 0)
			return null;
		ResourceSet rs = context.eResource().getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof PropertySet)
						&& ((PropertySet) rootObject).getName()
						.equalsIgnoreCase(name))
					return (PropertySet) rootObject;
			}
		}
		return null;
	}



	public ComponentClassifier findComponentClassifier(EObject context,String name){
		EReference reference = Aadl2Package.eINSTANCE.getComponentPrototype_ConstrainingClassifier();
		return (ComponentClassifier)findClassifier(context, reference, name);
	}

	public FeatureGroupType findFeatureGroupType(EObject context,String name){
		EReference reference = Aadl2Package.eINSTANCE.getFeatureGroupPrototype_ConstrainingFeatureGroupType();
		return (FeatureGroupType)findClassifier(context, reference, name);
	}
	public FeatureGroupType findFeatureGroupType(EObject context,String name, EReference reference){
		return (FeatureGroupType)findClassifier(context, reference, name);
	}

	protected EObject findClassifier(EObject context,
			EReference reference,  String name){
		EObject e = getIndexedObject(context, reference, name);
		if (e == null){
			final int idx = name.lastIndexOf("::");
			String packname = null;
			String cname = name;
			Namespace scope = getContainingPackageSection(context);
			if (scope == null)
				scope = getContainingPropertySet(context);
			if (idx != -1) {
				packname = name.substring(0, idx);
				cname = name.substring(idx + 2);
			}
			e = findNamedElementInAadlPackage(packname, cname, scope);
		}
		if (e != null && reference.getEReferenceType().isSuperTypeOf(e.eClass())) {
			// the result satisfied the expected class
			return e;
		}
		return null;
	}

	protected EObject findPropertySetElement(EObject context,
			EReference reference, String name){
		// look for element in property set
		//			EObject res = getIndexedObject(context, reference, name);
		//			if (res instanceof PropertyType || res instanceof PropertyConstant || res instanceof Property)
		//				return res;
		String psname = null;
		String pname = name;
		final int idx = name.lastIndexOf("::");
		if (idx != -1) {
			psname = name.substring(0, idx);
			pname = name.substring(idx + 2);
		}
		return findNamedElementInPropertySet(psname, pname,
				context, reference);
	}


	public PropertyConstant findPropertyConstant(EObject context,String name){
		// look for property constant in property set
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyConstant) {
			return (PropertyConstant)e;
		}
		return null;
	}


	protected List<EObject> findPropertyConstant(EObject context,
			EReference reference, String name){
		// look for property constant in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyConstant) {
			return Collections.singletonList((EObject) e);
		}
		return Collections.<EObject> emptyList();
	}


	public PropertyType findPropertyType(EObject context,String name){
		// look for property type in property set
		EReference reference = Aadl2Package.eINSTANCE.getBasicProperty_PropertyType();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyType) {
			return (PropertyType)e;
		}
		return null;
	}

	protected List<EObject> findPropertyType(EObject context,
			EReference reference, String name){
		// look for property constant in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyType) {
			return Collections.singletonList((EObject) e);
		}
		return Collections.<EObject> emptyList();
	}

	public Property findPropertyDefinition(EObject context,String name){
		// look for property type in property set
		EReference reference = Aadl2Package.eINSTANCE.getPropertyAssociation_Property();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof Property) {
			return (Property)e;
		}
		return null;
	}

	protected List<EObject> findPropertyDefinitionAsList(EObject context,
			EReference reference, String name) {
		// look for property definition in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof Property) {
			return Collections.singletonList((EObject) e);
		}
		return Collections.<EObject> emptyList();
	}

	public EnumerationLiteral findEnumerationLiteral(Property property, String name){
		PropertyType propertyType = property.getPropertyType();
		if (propertyType instanceof EnumerationType)
			return ((EnumerationType)propertyType).findLiteral(name);
		return null;
	}

	public UnitLiteral findUnitLiteral(Property property, String name){
		PropertyType propertyType = property.getPropertyType();
		UnitsType unitsType= null;
		if (propertyType instanceof NumberType)
			unitsType = ((NumberType) propertyType).getUnitsType();
		else if (propertyType instanceof RangeType)
			unitsType = ((RangeType) propertyType).getNumberType()
			.getUnitsType();
		if (unitsType != null) {
			return (UnitLiteral) unitsType
					.findNamedElement(name);
		}
		return null;
	}


	public UnitLiteral findUnitLiteral(NumberValue nv, String name){
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		return findUnitLiteral(nv, reference, name);
	}

	protected List<EObject> findUnitLiteralAsList(EObject context,
			EReference reference, String name) {
		EObject e = findUnitLiteral(context,reference,name);
		if (e == null) return Collections.<EObject> emptyList(); 
		return Collections.singletonList((EObject) e);
	}

	protected UnitLiteral findUnitLiteral(EObject context,
			EReference reference, String name) {
		// look for unit literal pointed to by baseUnit
		if (context instanceof UnitLiteral) {
			UnitsType unitsType = (UnitsType) ((UnitLiteral) context)
					.getOwner();
			UnitLiteral baseUnit = (UnitLiteral) unitsType
					.findNamedElement(name);
			if (baseUnit != null) {
				if (unitsType.getOwnedLiterals().indexOf(baseUnit) < unitsType
						.getOwnedLiterals()
						.indexOf(((UnitLiteral) context)))
					return baseUnit;
			}
		} else if (context instanceof NumberValue) {
			UnitsType unitsType = null;
			NumberValue numberValue = (NumberValue) context;
			Element owner = numberValue.getOwner();
			while (owner instanceof ListValue)
				owner = owner.getOwner();
			if (owner instanceof NumericRange) // Lower bound or upper bound
				// values of a number
				// property type.
				unitsType = ((NumberType) owner.getOwner()).getUnitsType();
			else {
				if (owner instanceof RangeValue)
					owner = owner.getOwner();
				PropertyType propertyType = null;
				if (owner instanceof PropertyConstant) // Value of the
					// property
					// constant.
				{
					// TODO: Need to check that the type of the property
					// constant is correct for the value.
					// We should do this when the type of the constant is
					// resolved in PropertyTypeReference.
					propertyType =  ((PropertyConstant) owner)
							.getPropertyType();
				} else if (owner instanceof Property) // Default value of a
					// property
					// definition.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the type of the definition is
					// resolved in PropertyValuePropertyTypeReference.
					propertyType = (PropertyType) ((Property) owner)
							.getPropertyType();
				} else if (owner instanceof ModalPropertyValue
						&& owner.getOwner() instanceof PropertyAssociation) 
					// Value of an association.
				{
					// TODO: Need to check that the type of the property
					// definition is correct for the value.
					// We should do this when the definition of the
					// association is resolved in
					// PropertyDefinitionReference.
					propertyType = (PropertyType) ((PropertyAssociation) owner
							.getOwner()).getProperty().getPropertyType();
				} else if (owner instanceof BasicPropertyAssociation) 
					// Inner value of a record value.
				{
					// TODO: Need to check that the type of the record field
					// is correct for the value.
					// We should do this when the record field of the record
					// value is resolved in PropertyRecordFieldReference.
					propertyType = (PropertyType) ((BasicPropertyAssociation) owner)
							.getProperty().getPropertyType();
				}
				propertyType = AadlUtil.getBasePropertyType(propertyType);
				if (propertyType instanceof NumberType)
					unitsType = ((NumberType) propertyType).getUnitsType();
				else if (propertyType instanceof RangeType)
					unitsType = ((RangeType) propertyType).getNumberType()
					.getUnitsType();
			}
			if (unitsType != null) {
				return (UnitLiteral) unitsType
						.findNamedElement(name);
			}
		}
		return null;
	}


	public EnumerationLiteral findEnumerationLiteral(EnumerationType enumType, String name){
		return (EnumerationLiteral) enumType.findNamedElement(name);
	}

	public EnumerationLiteral findEnumerationLiteral(NamedValue nv, String name){
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		List<EObject> el = findEnumLiteralAsList(nv, reference, name);
		if (!el.isEmpty()&&el.get(0) instanceof EnumerationLiteral) return (EnumerationLiteral)el.get(0);
		return null;
	}

	protected List<EObject> findEnumLiteralAsList(EObject context,
			EReference reference, String name) {
		// look for enumeration literal
		if (context instanceof NamedValue) {
			NamedValue value = (NamedValue) context;
			EObject owner = value.getOwner();
			while (owner instanceof ListValue) {
				owner = owner.eContainer();
			}
			PropertyType propertyType = null;
			if (owner instanceof PropertyConstant) // Value of the property
				// constant.
			{
				// TODO: Need to check that the type of the property
				// constant is correct for the value.
				// We should do this when the type of the constant is
				// resolved in PropertyTypeReference.
				propertyType = (PropertyType) ((PropertyConstant) owner)
						.getPropertyType();
			} else if (owner instanceof Property) // Default value of a
				// property definition.
			{
				// TODO: Need to check that the type of the property
				// definition is correct for the value.
				// We should do this when the type of the definition is
				// resolved in PropertyValuePropertyTypeReference.
				propertyType = (PropertyType) ((Property) owner).getPropertyType();
			} else if (owner instanceof ModalPropertyValue
					&& owner.eContainer() instanceof PropertyAssociation) // Value
				// of
				// an
				// association.
			{
				// TODO: Need to check that the type of the property
				// definition is correct for the value.
				// We should do this when the definition of the association
				// is resolved in PropertyDefinitionReference.
				Property p = ((PropertyAssociation) owner
						.eContainer()).getProperty();
				propertyType =  p.getPropertyType();
			} else if (owner instanceof BasicPropertyAssociation) // Inner
				// value
				// of a
				// record
				// value.
			{
				// TODO: Need to check that the type of the record field is
				// correct for the value.
				// We should do this when the record field of the record
				// value is resolved in PropertyRecordFieldReference.
				propertyType = (PropertyType) ((BasicPropertyAssociation) owner)
						.getProperty().getPropertyType();
			}

			propertyType = AadlUtil.getBasePropertyType(propertyType);
			if (propertyType != null
					&& propertyType instanceof EnumerationType) {
				EnumerationLiteral literal = (EnumerationLiteral) ((EnumerationType) propertyType)
						.findNamedElement(name);
				if (literal != null)
					return Collections.singletonList((EObject) literal);
			}
		}
		return Collections.<EObject> emptyList();
	}

	public PortConnectionEnd findPortConnectionEnd(PortConnection conn,
			Context cxt, String portName) {
		if (cxt == null) {
			EObject searchResult = ((ComponentImplementation) getContainingClassifier(conn))
					.findNamedElement(portName);
			if (searchResult instanceof Port
					|| searchResult instanceof DataSubcomponent
					|| (searchResult instanceof DataAccess && ((DataAccess) searchResult)
							.getKind() == AccessType.REQUIRED))
				return ((PortConnectionEnd) searchResult);
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getSubcomponentType() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			SubcomponentType sct = subcomponent.getSubcomponentType();
			if (sct instanceof Classifier) {
				EObject searchResult = ((Classifier)sct)
						.findNamedElement(portName);
				if (searchResult instanceof Port
						|| (cxt instanceof DataSubcomponent && searchResult instanceof DataSubcomponent)
						|| // data subcomponent . data subcomponent
						(searchResult instanceof DataAccess && ((DataAccess) searchResult)
								.getKind() == AccessType.PROVIDED))
					return ((PortConnectionEnd) searchResult);
			} else if (sct instanceof ComponentPrototype) {
				ComponentClassifier classifier = 
						findClassifierForComponentPrototype(
								getContainingClassifier(conn),
								((ComponentPrototype)sct));
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(portName);
					if (searchResult instanceof Port
							|| (cxt instanceof DataSubcomponent && searchResult instanceof DataSubcomponent)
							|| // data subcomponent . data subcomponent
							(searchResult instanceof DataAccess && ((DataAccess) searchResult)
									.getKind() == AccessType.PROVIDED))
						return ((PortConnectionEnd) searchResult);
				}
			}
		} else if (cxt instanceof DataPort || cxt instanceof EventDataPort)
			// DataPort or EventDataPort . data element
		{
			Feature context = (Port) cxt;
			while (context.getClassifier() == null
					&& context.getPrototype() == null
					&& context.getRefined() != null)
				context = context.getRefined();
			if (context.getClassifier() != null) {
				NamedElement searchResult = context.getClassifier()
						.findNamedElement(portName);
				if (searchResult instanceof DataSubcomponent)
					return ((DataSubcomponent) searchResult);
			} else if (context.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						(ComponentPrototype) context.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(portName);
					if (searchResult instanceof DataSubcomponent)
						return ((DataSubcomponent) searchResult);
				}
			}
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(portName);
				if (searchResult instanceof PortConnectionEnd)
					return ((PortConnectionEnd) searchResult);
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(portName);
					if (searchResult instanceof PortConnectionEnd)
						return ((PortConnectionEnd) searchResult);
				}
			}
		} else if (cxt instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) cxt;
			if (subprogramCall.getCalledSubprogram() != null) {
				CalledSubprogram calledSubprogram = subprogramCall.getCalledSubprogram();
				NamedElement searchResult=null;
				if (calledSubprogram instanceof SubprogramClassifier){
					searchResult = ((SubprogramClassifier)calledSubprogram).findNamedElement(portName);
				} else if (calledSubprogram instanceof SubprogramAccess){
					SubprogramClassifier spc = (SubprogramClassifier)((SubprogramAccess)calledSubprogram).getAllClassifier();
					if (spc != null)
						searchResult = spc.findNamedElement(portName);
					// TODO-phf: handle prototype reference in subprogram access feature
				} else if (calledSubprogram instanceof SubprogramPrototype){
					SubprogramPrototype spp = (SubprogramPrototype)calledSubprogram;
					if (spp.getConstrainingClassifier() != null){
						ComponentClassifier spcc=spp.getConstrainingClassifier();
						if (spcc != null) 
							searchResult = spcc.findNamedElement(portName);
					}
				}
				if (searchResult instanceof PortConnectionEnd)
					return ((PortConnectionEnd) searchResult);
			}
		}
		return null;
	}

	public ConnectionEnd findAccessConnectionEnd(AccessConnection conn,
			Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(conn)
					.findNamedElement(name);
			if (searchResult instanceof AccessConnectionEnd)
				return (AccessConnectionEnd) searchResult;
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof Access)
					return (Access) searchResult;
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof Access)
						return (Access) searchResult;
				}
			}
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof Access)
					return (Access) searchResult;
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof Access)
						return (Access) searchResult;
				}
			}
		} else if (cxt instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) cxt;
			if (subprogramCall.getCalledSubprogram() != null) {
				CalledSubprogram calledSubprogram = subprogramCall.getCalledSubprogram();
				NamedElement searchResult=null;
				if (calledSubprogram instanceof SubprogramClassifier){
					searchResult = ((SubprogramClassifier)calledSubprogram).findNamedElement(name);
				} else if (calledSubprogram instanceof SubprogramAccess){
					SubprogramClassifier spc = (SubprogramClassifier)((SubprogramAccess)calledSubprogram).getAllClassifier();
					if (spc != null)
						searchResult = spc.findNamedElement(name);
					// TODO-phf: handle prototype reference in subprogram access feature
				} else if (calledSubprogram instanceof SubprogramPrototype){
					SubprogramPrototype spp = (SubprogramPrototype)calledSubprogram;
					if (spp.getConstrainingClassifier() != null){
						ComponentClassifier spcc=spp.getConstrainingClassifier();
						if (spcc != null) 
							searchResult = spcc.findNamedElement(name);
					}
				}
				if (searchResult instanceof PortConnectionEnd)
					return ((PortConnectionEnd) searchResult);
			}
		}
		return null;
	}

	public ConnectionEnd findParameterConnectionEnd(
			ParameterConnection conn, Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(conn)
					.findNamedElement(name);
			if (searchResult instanceof ParameterConnectionEnd)
				return (ParameterConnectionEnd) searchResult;
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof ParameterConnectionEnd)
					return (ParameterConnectionEnd) searchResult;
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof ParameterConnectionEnd)
						return (ParameterConnectionEnd) searchResult;
				}
			}
		} else if (cxt instanceof SubprogramCall) {
			SubprogramCall subprogramCall = (SubprogramCall) cxt;
			if (subprogramCall.getCalledSubprogram() instanceof SubprogramClassifier) {
				NamedElement searchResult = ((SubprogramClassifier) subprogramCall
						.getCalledSubprogram()).findNamedElement(name);
				if (searchResult instanceof Parameter)
					return (Parameter) searchResult;
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramSubcomponent) {
				Subcomponent subcomponent = (SubprogramSubcomponent) subprogramCall
						.getCalledSubprogram();
				while (subcomponent.getClassifier() == null
						&& subcomponent.getPrototype() == null
						&& subcomponent.getRefined() != null)
					subcomponent = subcomponent.getRefined();
				if (subcomponent.getClassifier() != null) {
					NamedElement searchResult = subcomponent.getClassifier()
							.findNamedElement(name);
					if (searchResult instanceof Parameter)
						return (Parameter) searchResult;
				} else if (subcomponent.getPrototype() != null) {
					ComponentClassifier classifier = findClassifierForComponentPrototype(
							getContainingClassifier(conn),
							subcomponent.getPrototype());
					if (classifier != null) {
						NamedElement searchResult = classifier
								.findNamedElement(name);
						if (searchResult instanceof Parameter)
							return (Parameter) searchResult;
					}
				}
			} else if (subprogramCall.getCalledSubprogram() instanceof SubprogramAccess) {
				Feature access = (SubprogramAccess) subprogramCall
						.getCalledSubprogram();
				while (access.getClassifier() == null
						&& access.getPrototype() == null
						&& access.getRefined() != null)
					access = access.getRefined();
				if (access.getClassifier() != null) {
					NamedElement searchResult = access.getClassifier()
							.findNamedElement(name);
					if (searchResult instanceof Parameter)
						return (Parameter) searchResult;
				} else if (access.getPrototype() instanceof ComponentPrototype) {
					CallContext callContext = subprogramCall.getContext();
					if (callContext instanceof AbstractType
							|| callContext instanceof DataType
							|| callContext instanceof SubprogramGroupType) {
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								(ComponentType) callContext,
								(ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier
									.findNamedElement(name);
							if (searchResult instanceof Parameter)
								return (Parameter) searchResult;
						}
					} else if (callContext instanceof FeatureGroup) {
						FeatureGroup callContextFeatureGroup = (FeatureGroup) callContext;
						FeatureGroupType prototypeContext;
						while (callContextFeatureGroup.getFeatureGroupType() == null
								&& callContextFeatureGroup.getPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup
									.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null)
							prototypeContext = callContextFeatureGroup
							.getFeatureGroupType();
						else if (callContextFeatureGroup.getPrototype() instanceof FeatureGroupPrototype) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									getContainingClassifier(conn),
									(FeatureGroupPrototype) callContextFeatureGroup
									.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(
									prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier
										.findNamedElement(name);
								if (searchResult instanceof Parameter)
									return (Parameter) searchResult;
							}
						}
					} else if (callContext instanceof SubprogramGroupAccess) {
						Feature callContextAccess = (SubprogramGroupAccess) callContext;
						Classifier prototypeContext;
						while (callContextAccess.getClassifier() == null
								&& callContextAccess.getPrototype() == null
								&& callContextAccess.getRefined() != null) {
							callContextAccess = callContextAccess.getRefined();
						}
						if (callContextAccess.getClassifier() != null)
							prototypeContext = callContextAccess
							.getClassifier();
						else if (callContextAccess.getPrototype() instanceof ComponentPrototype) {
							prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(conn),
									(ComponentPrototype) callContextAccess
									.getPrototype());
						} else
							prototypeContext = null;
						if (prototypeContext != null) {
							ComponentClassifier classifier = findClassifierForComponentPrototype(
									prototypeContext,
									(ComponentPrototype) access.getPrototype());
							if (classifier != null) {
								NamedElement searchResult = classifier
										.findNamedElement(name);
								if (searchResult instanceof Parameter)
									return (Parameter) searchResult;
							}
						}
					} else if (callContext instanceof SubprogramGroupSubcomponent) {
						Subcomponent callContextSubcomponent = (SubprogramGroupSubcomponent) callContext;
						while (callContextSubcomponent.getClassifier() == null
								&& callContextSubcomponent.getPrototype() == null
								&& callContextSubcomponent.getRefined() != null) {
							callContextSubcomponent = callContextSubcomponent
									.getRefined();
						}
						if (callContextSubcomponent.getClassifier() != null) {
							ComponentClassifier classifier;
							if (callContextSubcomponent
									.getOwnedPrototypeBindings().isEmpty()) {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										(ComponentPrototype) access
										.getPrototype());
							} else {
								classifier = findClassifierForComponentPrototype(
										callContextSubcomponent.getClassifier(),
										callContextSubcomponent,
										(ComponentPrototype) access
										.getPrototype());
							}
							if (classifier != null) {
								NamedElement searchResult = classifier
										.findNamedElement(name);
								if (searchResult instanceof Parameter)
									return (Parameter) searchResult;
							}
						} else if (callContextSubcomponent.getPrototype() != null) {
							Classifier prototypeContext = findClassifierForComponentPrototype(
									getContainingClassifier(conn),
									callContextSubcomponent.getPrototype());
							if (prototypeContext != null) {
								ComponentClassifier classifier = findClassifierForComponentPrototype(
										prototypeContext,
										(ComponentPrototype) access
										.getPrototype());
								if (classifier != null) {
									NamedElement searchResult = classifier
											.findNamedElement(name);
									if (searchResult instanceof Parameter)
										return (Parameter) searchResult;
								}
							}
						}
					} else // callContext is null.
					{
						ComponentClassifier classifier = findClassifierForComponentPrototype(
								getContainingClassifier(conn),
								(ComponentPrototype) access.getPrototype());
						if (classifier != null) {
							NamedElement searchResult = classifier
									.findNamedElement(name);
							if (searchResult instanceof Parameter)
								return (Parameter) searchResult;
						}
					}
				}
			} else // subprogramCall.getCalledSubprogram() is null. The
				// subprogram call refers to a prototype.
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						(ComponentPrototype) subprogramCall.getCalledSubprogram());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof Parameter)
						return (Parameter) searchResult;
				}
			}
		} else // connection.getSourceContext() is a Parameter, DataPort, or
			// EventDataPort
		{
			Feature sourceContext = (Feature) cxt;
			while (sourceContext.getClassifier() == null
					&& sourceContext.getPrototype() == null
					&& sourceContext.getRefined() != null) {
				sourceContext = sourceContext.getRefined();
			}
			if (sourceContext.getClassifier() != null) {
				NamedElement searchResult = sourceContext.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof DataSubcomponent)
					return (DataSubcomponent) searchResult;
			} else if (sourceContext.getPrototype() instanceof ComponentPrototype) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(conn),
						(ComponentPrototype) sourceContext.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof DataSubcomponent)
						return (DataSubcomponent) searchResult;
				}
			}
		}
		return null;
	}

	public ConnectionEnd findFeatureGroupConnectionEnd(
			FeatureGroupConnection connection, Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(connection)
					.findNamedElement(name);
			if (searchResult instanceof FeatureGroupConnectionEnd)
				return (FeatureGroupConnectionEnd) searchResult;
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					return (FeatureGroupConnectionEnd) searchResult;
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						return (FeatureGroupConnectionEnd) searchResult;
				}
			}
		} else // connection.getSourceContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					return (FeatureGroupConnectionEnd) searchResult;
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof FeatureGroupConnectionEnd)
						return ((FeatureGroupConnectionEnd) searchResult);
				}
			}
		}
		return null;
	}

	public ConnectionEnd findFeatureConnectionEnd(
			FeatureConnection connection, Context cxt, String name) {
		if (cxt == null) {
			NamedElement searchResult = getContainingClassifier(connection)
					.findNamedElement(name);
			if (searchResult instanceof FeatureConnectionEnd)
				return ((FeatureConnectionEnd) searchResult);
		} else if (cxt instanceof Subcomponent) {
			Subcomponent subcomponent = (Subcomponent) cxt;
			while (subcomponent.getClassifier() == null
					&& subcomponent.getPrototype() == null
					&& subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null) {
				NamedElement searchResult = subcomponent.getClassifier()
						.findNamedElement(name);
				if (searchResult instanceof FeatureConnectionEnd)
					return ((FeatureConnectionEnd) searchResult);
			} else if (subcomponent.getPrototype() != null) {
				ComponentClassifier classifier = findClassifierForComponentPrototype(
						getContainingClassifier(connection),
						subcomponent.getPrototype());
				if (classifier != null) {
					NamedElement searchResult = classifier
							.findNamedElement(name);
					if (searchResult instanceof FeatureConnectionEnd)
						return ((FeatureConnectionEnd) searchResult);
				}
			}
		} else // connection.getSourceContext() is a FeatureGroup
		{
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof FeatureConnectionEnd)
					return ((FeatureConnectionEnd) searchResult);
			} else if (featureGroup.getPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						getContainingClassifier(connection),
						(FeatureGroupPrototype) featureGroup.getPrototype());
				if (featureGroupType != null) {
					NamedElement searchResult = featureGroupType
							.findNamedElement(name);
					if (searchResult instanceof FeatureConnectionEnd)
						return ((FeatureConnectionEnd) searchResult);
				}
			}
		}
		return null;
	}


	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference,
	 * PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference. Based on the type of
	 * containingClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes. Example:
	 * 
	 * abstract a prototypes p1: subprogram group; p2: subprogram group; end a;
	 * 
	 * abstract implementation a.i ( p1 => p2, p2 => p1) subcomponents sub:
	 * subprogram group p1; calls sequence1: { call1: subprogram
	 * sub.access_feature_1; end a.i;
	 * 
	 * This will cause a stack overflow!
	 */
	private ComponentClassifier findClassifierForComponentPrototype(
			Classifier containingClassifier, ComponentPrototype prototype) {
		// TODO: Need to check that the prototype binding is a component
		// prototype binding. In PrototypeFormalReference,
		// we should check that component prototypes are bound by component
		// prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(
				containingClassifier, prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			SubcomponentType st = ((ComponentPrototypeActual) binding
					.getActuals().get(0)).getSubcomponentType();
			if (st instanceof ComponentClassifier)
				return (ComponentClassifier) st;
			else // It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						containingClassifier, (ComponentPrototype) st);
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null
				&& prototype.getRefined() != null) {
			// TODO: Need to check that the component prototype refines a
			// component prototype.
			// This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference,
	 * PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * ComponentPrototypeRefinementReference. Based on the type of
	 * classifierPrototypeContext: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	private ComponentClassifier findClassifierForComponentPrototype(
			Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext,
			ComponentPrototype prototype) {
		// TODO: Need to check that the prototype binding is a component
		// prototype binding. In PrototypeFormalReference,
		// we should check that component prototypes are bound by component
		// prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding) findPrototypeBinding(
				classifierPrototypeContext, subcomponentPrototypeContext,
				prototype);
		if (binding != null && binding.getActuals().size() >= 1) {
			SubcomponentType st = ((ComponentPrototypeActual) binding
					.getActuals().get(0)).getSubcomponentType();
			if (st instanceof ComponentClassifier)
				return (ComponentClassifier) st;
			else // It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(
						classifierPrototypeContext,
						subcomponentPrototypeContext, ((ComponentPrototype) st));
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null
				&& prototype.getRefined() != null) {
			// TODO: Need to check that the component prototype refines a
			// component prototype.
			// This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}


	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference,
	 * PrototypeOrFeatureGroupTypeReference,
	 * FeatureGroupPrototypeClassifierReference,
	 * FeatureGroupPrototypeRefinementReference. Based on the type of
	 * containingClassifier: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	// TODO: Check for circular dependencies with prototypes.
	private FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(
			Classifier containingClassifier, FeatureGroupPrototype prototype) {
		// TODO: Need to check that the prototype binding is a feature group
		// prototype binding. In PrototypeFormalReference,
		// we should check that feature group prototypes are bound by feature
		// group prototype bindings.
		FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding) findPrototypeBinding(
				containingClassifier, prototype);
		if (binding != null) {
			if (binding.getActual() instanceof FeatureGroupPrototypeActual){
				FeatureType ft = ((FeatureGroupPrototypeActual) binding.getActual())
						.getFeatureType();
				if (ft instanceof FeatureGroupType){
					return (FeatureGroupType)ft;
				} else {
					FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(
							containingClassifier,
							((FeatureGroupPrototype) ft));
					if (featureGroupTypeForReferencedPrototype != null)
						return featureGroupTypeForReferencedPrototype;
				}
			}
		}
		while (prototype.getConstrainingFeatureGroupType() == null
				&& prototype.getRefined() != null) {
			// TODO: Need to check that the feature group prototype refines a
			// feature group prototype.
			// This should be done in FeatureGroupPrototypeRefinementReference.
			prototype = (FeatureGroupPrototype) prototype.getRefined();
		}
		if (prototype.getConstrainingFeatureGroupType() != null)
			return prototype.getConstrainingFeatureGroupType();
		else
			return null;
	}


	/**
	 * Search for a {@link NamedElement} in a package. If {@code context} is a
	 * {@link PublicPackageSection}, then this method will search through the
	 * {@link PublicPackageSection} only. If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will search through the
	 * {@link PrivatePackageSection} and its corresponding
	 * {@link PublicPackageSection}. This is different from
	 * {@link PrivatePackageSection#findNamedElement(String)} and
	 * {@link PrivatePackageSection#findNamedElement(String, boolean)} because
	 * those methods will not search through the corresponding
	 * {@link PublicPackageSection}. This method does use
	 * {@link PackageSection#findNamedElement(String, boolean)}, so it will
	 * search for {@link ComponentType}s and {@link FeatureGroupType}s in the
	 * renames statements.
	 * 
	 * Dependencies: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 * 
	 * @param name
	 *            The name of the {@link NamedElement} to search for.
	 * @param context
	 *            The {@link PackageSection} that contains the {@link Element}
	 *            that needs the search result.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public NamedElement findNamedElementInAadlPackage(String name,
			PackageSection context) {
		NamedElement result = context.findNamedElement(name);
		if (result == null
				&& context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null)
			result = ((AadlPackage) context.eContainer())
			.getOwnedPublicSection().findNamedElement(name);
		return result;
	}

	/**
	 * Search for a {@link NamedElement} with the name {@code elementName} in
	 * the package specified by {@code packageName}. This method will first
	 * check that the specified package is accessible within {@code context}.
	 * This is done by checking that {@code packageName} appears in a with
	 * statement or package rename of {@code context} or {@code context}'s
	 * corresponding {@link PublicPackageSection} if {@code context} is a
	 * {@link PrivatePackageSection}. If the package is not accessible, then
	 * {@code null} will be returned. If the element cannot be found in the
	 * specified package, then {@code null} will be returned.
	 * 
	 * Dependencies: If packageName is null or refers to context: RenamesAll,
	 * ComponentTypeRename, FeatureGroupTypeRename. If packageName refers to a
	 * different package: WithStatementReference, PackageRenameReference.
	 * 
	 * @param packageName
	 *            The name of the package that contains the element to search
	 *            for.
	 * @param elementName
	 *            The name of the element to search for.
	 * @param context
	 *            The {@link PackageSection} that needs to refer to the
	 *            specified {@link Element}.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public EObject findNamedElementInAadlPackage(String packageName,
			String elementName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName()
				.equalsIgnoreCase(packageName)))
			return findNamedElementInAadlPackage(elementName,
					(PackageSection) context);
		else {
			AadlPackage aadlPackage = null;

			if (context instanceof PackageSection) {
				PackageRename packageRename = findPackageRename(packageName,
						(PackageSection) context);
				if (packageRename != null)
					aadlPackage = packageRename.getRenamedPackage();
				else
					aadlPackage = findImportedPackage(packageName, context);
			} else
				aadlPackage = findImportedPackage(packageName, context);

			if (aadlPackage != null
					&& aadlPackage.getOwnedPublicSection() != null)
				return aadlPackage.getOwnedPublicSection().findNamedElement(
						elementName);
			else
				return null;
		}
	}

	/**
	 * Dependencies: If propertySetName is the name of a different, non standard
	 * property set: WithStatementReference.
	 */
	public EObject findNamedElementInPropertySet(String propertySetName,
			String elementName, EObject context, EReference reference) {
		if (propertySetName == null) {
			for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
				EObject res = getIndexedObject(context, reference,
						getQualifiedName(predeclaredPSName, elementName));
				if (res != null)
					return res;
			}
			for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
				PropertySet predeclaredPropertySet = findPropertySet(context,
						predeclaredPSName);
				if (predeclaredPropertySet != null) {
					NamedElement searchResult = predeclaredPropertySet
							.findNamedElement(elementName);
					if (searchResult != null)
						return searchResult;
				}
			}
			return null;
		} else {
			PropertySet propertySet = findPropertySet(context, propertySetName);//getContainingPropertySet(context);
			if (propertySet == null || 
					(propertySet != null && !propertySet.getName().equalsIgnoreCase(propertySetName))){
				propertySet = findImportedPropertySet(propertySetName, context);
			}
			if (propertySet != null)
				return propertySet.findNamedElement(elementName);
			else
				return null;
		}
	}

	public String getQualifiedName(String packageOrPropertySetName,
			String elementName) {
		if (packageOrPropertySetName == null)
			return elementName;
		else
			return packageOrPropertySetName + "::" + elementName;
	}

	/**
	 * Dependencies: PrototypeFormalReference. Based on the type of classifier:
	 * ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	public PrototypeBinding findPrototypeBinding(Classifier classifier,
			Prototype prototype) {
		for (PrototypeBinding binding : classifier.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifier.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(
					generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference. Based on the type of
	 * classifierPrototypeContext: ComponentTypeExtensionReference,
	 * ComponentImplementationExtensionReference, RealizationReference,
	 * FeatureGroupTypeExtendReference.
	 */
	private PrototypeBinding findPrototypeBinding(
			Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, Prototype prototype) {
		for (PrototypeBinding binding : subcomponentPrototypeContext
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (PrototypeBinding binding : classifierPrototypeContext
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifierPrototypeContext
				.getGeneralizations()) {
			PrototypeBinding result = findPrototypeBinding(
					generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}

	/**
	 * Dependencies: PrototypeFormalReference.
	 */
	private PrototypeBinding findPrototypeBinding(
			Subcomponent subcomponent, Prototype prototype) {
		for (PrototypeBinding binding : subcomponent
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		return null;
	}


	public Classifier getContainingClassifier(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof Classifier))
			container = container.eContainer();
		return (Classifier) container;
	}

	public PackageSection getContainingPackageSection(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PackageSection))
			container = container.eContainer();
		return (PackageSection) container;
	}

	public PropertySet getContainingPropertySet(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PropertySet))
			container = container.eContainer();
		return (PropertySet) container;
	}

	public Namespace getContainingTopLevelNamespace(EObject element) {
		if (element.eContainer() == null) {
			if (element instanceof Namespace) return (Namespace)element;
			return null;
		}
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PackageSection)
				&& !(container instanceof PropertySet))
			container = container.eContainer();
		return (Namespace) container;
	}

	public Namespace getContainingNamespace(EObject element) {
		EObject container = element.eContainer();
		while (container != null && !(container instanceof Namespace))
			container = container.eContainer();
		return (Namespace) container;
	}

}
