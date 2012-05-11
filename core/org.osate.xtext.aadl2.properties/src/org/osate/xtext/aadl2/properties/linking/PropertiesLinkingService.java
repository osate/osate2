package org.osate.xtext.aadl2.properties.linking;


import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.linking.impl.DefaultLinkingService;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractType;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.AccessConnectionEnd;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.CallContext;
import org.osate.aadl2.CallSpecification;
import org.osate.aadl2.CalledSubprogram;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeActual;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.ContainedNamedElement;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataPrototype;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.EnumerationType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureConnection;
import org.osate.aadl2.FeatureConnectionEnd;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupConnectionEnd;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeActual;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeBinding;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.NumberType;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.NumericRange;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnection;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordType;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramAccess;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramGroupAccess;
import org.osate.aadl2.SubprogramGroupSubcomponent;
import org.osate.aadl2.SubprogramGroupType;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramPrototype;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.impl.SubprogramImpl;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2ResourceImpl;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;
import org.osate.xtext.aadl2.properties.util.PSNode;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;


public class PropertiesLinkingService extends DefaultLinkingService {


	private static PropertiesLinkingService eInstance = null;

	public PropertiesLinkingService(){
		super();
	}

	public static PropertiesLinkingService getPropertiesLinkingService(){
		if (eInstance == null) {
			Resource rsrc = OsateResourceUtil.getResource(URI.createPlatformResourceURI(PredeclaredProperties.PLUGIN_RESOURCES_DIRECTORY_NAME+"/AADL_Project.aadl"));
			eInstance = (PropertiesLinkingService)((LazyLinkingResource)rsrc).getLinkingService();
		}
		return eInstance;
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


	
	 
	 
//	/**
//	 * check whether there are duplicate names
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
			// XXX: this code can be replicated in Aadl2LinkingService as it is called often in the core
			// resolve classifier reference
			EObject e = findClassifier(context, reference,  name);
			if (e != null ) {
				// the result satisfied the expected class
				return Collections.singletonList((EObject) e);
			}
			if (!(context instanceof Generalization) && sct.isSuperTypeOf(requiredType)){
				// need to resolve prototype
				EObject res = AadlUtil.getContainingClassifier(context)
						.findNamedElement(name);
				if (Aadl2Package.eINSTANCE.getDataPrototype()==reference ){
					if( res instanceof DataPrototype ){
						searchResult = res;
					}
				} else if ( res instanceof ComponentPrototype) {
					searchResult = res;
				}
			}
		} else 
			if (Aadl2Package.eINSTANCE.getModelUnit() == requiredType) {
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
			Classifier ns = AadlUtil.getContainingClassifier(context);
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
			Classifier ns = AadlUtil.getContainingClassifier(context);
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
			EObject res = AadlUtil.getContainingClassifier(context)
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
					// find next element in namespace of previous element
					ContainmentPathElement el = list.get(idx - 1);
					NamedElement ne = el.getNamedElement();
					if (ne instanceof Subcomponent) {
						Classifier ns = ((Subcomponent) ne).getClassifier();
						if (ns != null)
							res = ns.findNamedElement(name);
						// need to look for subprogram calls inside call sequences
						if (res == null){
							if (ne instanceof ThreadSubcomponent || ne instanceof SubprogramSubcomponent){
								if (ns instanceof ThreadImplementation){
									res = AadlUtil.findNamedElementInList(((ThreadImplementation)ns).callSpecifications(), name);
								} else if (ns instanceof SubprogramImplementation){
									res = AadlUtil.findNamedElementInList(((SubprogramImplementation)ns).callSpecifications(), name);
								}
							}
						}
					} else if (ne instanceof FeatureGroup) {
						Classifier ns = ((FeatureGroup) ne)
								.getAllFeatureGroupType();
						if (ns != null)
							res = ns.findNamedElement(name);
					} else if (ne instanceof SubprogramCall){
						// looking inside a subprogram that is being called
						CalledSubprogram called = ((SubprogramCall)ne).getCalledSubprogram();
						if (called instanceof SubprogramImplementation){
							res = ((SubprogramImplementation)called).findNamedElement(name);
						} else if (called instanceof SubprogramSubcomponent){
							Classifier ns = ((SubprogramSubcomponent)called).getAllClassifier();
							res = ns.findNamedElement(name);
						}
						
					}
				} else {
					Classifier ns = AadlUtil.getContainingClassifier(context);
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
			return superes;
		}
		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
		return Collections.<EObject> emptyList();
	}



	/**
	 * Look up package in EMF index or in resource set
	 * NOTE: the resource set does not have all resources loaded
	 * @param context Context of reference 
	 * @param name Package name
	 * @return aadl package or null
	 */
	public AadlPackage findAadlPackage(EObject context, String name) {
//		EReference reference = Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit();
		EReference reference = Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit();
		return findAadlPackage(context, name, reference);
	}
	

	/**
	 * Look up package in EMF index 
	 * NOTE: the resource set does not have all resources loaded
	 * @param context Context of reference 
	 * @param name Package name
	 * @param reference Ereference identifying the type of the reference
	 * @return aadl package or null
	 */
	public AadlPackage findAadlPackage(EObject context, String name, EReference reference) {
		EObject res = getIndexedObject(context, reference, name);
		if (res instanceof AadlPackage)
			return (AadlPackage)res;
		if (name == null || name.length() == 0)
			return null;
		return null;
	}

	/**
	 * Find referenced Package by resolving renames first and then making sure it is listed in a with clause
	 * If package name is null or that of the context return containing package
	 * @param packageName
	 * @param context location of the package reference
	 * @return aadl package
	 */
	public AadlPackage findAadlPackageReference(String packageName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName()
				.equalsIgnoreCase(packageName)))
			return 	(AadlPackage)((PackageSection) context).eContainer();
		else {
			AadlPackage aadlPackage = null;

			if (context instanceof PackageSection) {
				aadlPackage = resolvePackageRename(packageName,
						(PackageSection) context);
				if (aadlPackage == null)
					aadlPackage = AadlUtil.findImportedPackage(packageName, context);
			} else
				aadlPackage = AadlUtil.findImportedPackage(packageName, context);


			return aadlPackage;
		}
	}

	/**
	 * resolve package name by looking it up in PackageRename
	 * @param name package name
	 * @param context Package section with rename declarations
	 * @return aadl package or null
	 */
	public AadlPackage resolvePackageRename(String name,
			PackageSection context) {
		AadlPackage searchResult = resolvePackageRename(name, context.getOwnedPackageRenames());
		if (searchResult == null
				&& context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getPublicSection() != null) {
			PublicPackageSection pubsec = ((AadlPackage) context.eContainer())
					.getPublicSection();
			searchResult = resolvePackageRename(name, pubsec.getOwnedPackageRenames());
		}
			return searchResult;
	}
	
	/**
	 * find and return renamed package in list of package renames
	 * @param name package name to be resolved
	 * @param packageRenames list of package renames
	 * @return aadl package or null
	 */
	public AadlPackage resolvePackageRename(String name, EList<PackageRename> packageRenames){
		for (PackageRename namedElement : packageRenames) {
			if (namedElement.hasName() && namedElement.getName().equalsIgnoreCase(name)) {
				return namedElement.getRenamedPackage();
			}
		}
		return null;
	}



	/**
	 * look up property set in EMF index or resource set
	 * @param context
	 * @param name
	 * @return
	 */
	public PropertySet findPropertySet(Element context, String name) {
		EReference reference = Aadl2Package.eINSTANCE.getPropertySet_ImportedUnit();
		return findPropertySet(context, name, reference);
	}



	/**
	 * look property set up in EMF index, if not found search through resource set
	 * NOTE: resource set does not have all resources loaded
	 * @param context
	 * @param name Property set name
	 * @param reference EReference used to identify the type of object we are looking for
	 * @return
	 */
	public PropertySet findPropertySet(EObject context, String name, EReference reference) {
		EObject res = getIndexedObject(context, reference, name);
		if (res instanceof PropertySet)
			return (PropertySet)res;
		if (name == null || name.length() == 0)
			return null;
		return null;
	}


	/**
	 * find the component classifier taking into account rename aliases
	 * The name may be qualified with a package name
	 * We do not check whether the referenced package is in the with clause. This is checked separately
	 * @param context Element any model object that is the context of the reference
	 * @param name name to be resolved; may be unqualified or qualified with a package name
	 * @return ComponentClassifier or null
	 */
	public ComponentClassifier findComponentClassifier(Element context,String name){
		EReference reference = Aadl2Package.eINSTANCE.getComponentPrototype_ConstrainingClassifier();
		return (ComponentClassifier)findClassifier(context, reference, name);
	}

	public FeatureGroupType findFeatureGroupType(Element context,String name){
		EReference reference = Aadl2Package.eINSTANCE.getFeatureGroupPrototype_ConstrainingFeatureGroupType();
		return (FeatureGroupType)findClassifier(context, reference, name);
	}
	
	public FeatureGroupType findFeatureGroupType(EObject context,String name, EReference reference){
		return (FeatureGroupType)findClassifier(context, reference, name);
	}

	/**
	 * find the classifier taking into account rename aliases
	 * We do not check whether the referenced package is in the with clause. This is checked separately
	 * This is a helper method for findFeatureGroupType and findComponentClassifier
	 * @param context classifier reference context
	 * @param reference identifying attribute of reference
	 * @param name name to be resolved
	 * @return Classifier or null
	 */
	public EObject findClassifier(EObject context,
			EReference reference,  String name){
		Namespace scope = AadlUtil.getContainingTopLevelNamespace(context);
		EObject e = getIndexedObject(context, reference, name);
		if (e != null && reference.getEReferenceType().isSuperTypeOf(e.eClass())) {
			// the result satisfied the expected class
			Namespace ns = AadlUtil.getContainingTopLevelNamespace(e);
			if (ns instanceof PrivatePackageSection && scope != ns) return null;
			return e;
		}
		// need to do a local lookup as it was not found in the index.
		String packname = null;
		String cname = name;
		final int idx = name.lastIndexOf("::");
		if (idx != -1) {
			packname = name.substring(0, idx);
			cname = name.substring(idx + 2);
			// if rename is not a package rename, but component type rename then all is treated as component ID
			if (cname.equalsIgnoreCase("all")) return null;
		}
		// NOTE: checking whether the referenced package is imported is done by the validator.
		if (e == null && scope instanceof PackageSection){
			// the reference is from inside a package section. Lookup by identifier with or without qualification
			e = findNamedElementInAadlPackage(packname, cname, scope);
			if (e != null && reference.getEReferenceType().isSuperTypeOf(e.eClass())) {
				// the result satisfied the expected class
				return e;
			}
		}
		return null;
	}


	/**
	 * find a named element in a property set based on an optionally qualified name. 
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property constant
	 * The context object can be any model object, typically the object that is the context of the reference such as a property definition
	 * The reference is an EReference pointing to the the named element
	 * This method is a helper method for the FindPropertyConstant/Type/Definition methods
	 * @param context Element an AADL model element
	 * @param reference EReference
	 * @param name property type name possibly qualified with the property set name
	 * @return
	 */
	public EObject findPropertySetElement(EObject context,
			EReference reference, String name){
		// look for element in property set
		String psname = null;
		String pname = name;
		final int idx = name.lastIndexOf("::");
		if (idx != -1) {
			psname = name.substring(0, idx);
			pname = name.substring(idx + 2);
		}
		if (psname == null){
			return findNamedElementInPredeclaredPropertySets(pname, context,reference);
		} else {
			return getIndexedObject(context, reference, name);
		}
	}



	/**
	 * find property constant based on property constant name. 
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property constant
	 * The context object can be any model object, typically the object that is the context of the reference such as a property definition
	 * @param context Element an AADL model element
	 * @param name property type name possibly qualified with the property set name
	 * @return PropertyConstant the property type or null
	 */
	public PropertyConstant findPropertyConstant(EObject context,String name){
		// look for property constant in property set
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyConstant) {
			return (PropertyConstant)e;
		}
		return null;
	}




	public List<EObject> findPropertyConstant(EObject context,
			EReference reference, String name){
		// look for property constant in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyConstant) {
			return Collections.singletonList((EObject) e);
		}
		return Collections.<EObject> emptyList();
	}


	/**
	 * find property type based on property name. 
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property type
	 * The context object can be any model object, typically the object that is the context of the reference such as a property definition
	 * @param context Element an AADL model element
	 * @param name property type name possibly qualified with the property set name
	 * @return PropertyType the property type or null
	 */
	public PropertyType findPropertyType(EObject context,String name){
		// look for property type in property set
		EReference reference = Aadl2Package.eINSTANCE.getBasicProperty_PropertyType();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyType) {
			return (PropertyType)e;
		}
		return null;
	}


	public List<EObject> findPropertyType(EObject context,
			EReference reference, String name){
		// look for property constant in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof PropertyType) {
			return Collections.singletonList((EObject) e);
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * find property definition based on property name. 
	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property
	 * The context object can be any model object, typically the object that is the context of the reference such as a property association
	 * @param context Element an AADL model element
	 * @param name property name possibly qualified with the property set name
	 * @return Property the property definition or null
	 */
	public Property findPropertyDefinition(EObject context,String name){
		// look for property type in property set
		EReference reference = Aadl2Package.eINSTANCE.getPropertyAssociation_Property();
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof Property) {
			return (Property)e;
		}
		return null;
	}

//	/**
//	 * find property definition based on property name. 
//	 * The name is qualified with the property set name, or if unqualified is assumed to be a predeclared property
//	 * @param name property name possibly qualified with the property set name
//	 * @return Property the property definition or null
//	 */
//	public Property findPropertyDefinition(String name){
//		// look for property type in property set
//		EReference reference = Aadl2Package.eINSTANCE.getPropertyAssociation_Property();
//		EObject e = findPropertySetElement(PredeclaredProperties.getAadlProjectPropertySet(), reference, name);
//		if (e != null && e instanceof Property) {
//			return (Property)e;
//		}
//		return null;
//	}
//
	public List<EObject> findPropertyDefinitionAsList(EObject context,
			EReference reference, String name) {
		// look for property definition in property set
		EObject e = findPropertySetElement(context, reference, name);
		if (e != null && e instanceof Property) {
			return Collections.singletonList((EObject) e);
		}
		return Collections.<EObject> emptyList();
	}

	public PortConnectionEnd findPortConnectionEnd(PortConnection conn,
			Context cxt, String portName) {
		if (cxt == null) {
			EObject searchResult = ((ComponentImplementation) AadlUtil.getContainingClassifier(conn))
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
								AadlUtil.getContainingClassifier(conn),
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
						AadlUtil.getContainingClassifier(conn),
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
					&& featureGroup.getFeatureGroupPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(portName);
				if (searchResult instanceof PortConnectionEnd)
					return ((PortConnectionEnd) searchResult);
			} else if (featureGroup.getFeatureGroupPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						AadlUtil.getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getFeatureGroupPrototype());
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
			NamedElement searchResult = AadlUtil.getContainingClassifier(conn)
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
						AadlUtil.getContainingClassifier(conn),
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
					&& featureGroup.getFeatureGroupPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof Access)
					return (Access) searchResult;
			} else if (featureGroup.getFeatureGroupPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						AadlUtil.getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getFeatureGroupPrototype());
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
			NamedElement searchResult = AadlUtil.getContainingClassifier(conn)
					.findNamedElement(name);
			if (searchResult instanceof ParameterConnectionEnd)
				return (ParameterConnectionEnd) searchResult;
		} else if (cxt instanceof FeatureGroup) {
			FeatureGroup featureGroup = (FeatureGroup) cxt;
			while (featureGroup.getFeatureGroupType() == null
					&& featureGroup.getFeatureGroupPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof ParameterConnectionEnd)
					return (ParameterConnectionEnd) searchResult;
			} else if (featureGroup.getFeatureGroupPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						AadlUtil.getContainingClassifier(conn),
						(FeatureGroupPrototype) featureGroup.getFeatureGroupPrototype());
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
							AadlUtil.getContainingClassifier(conn),
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
								&& callContextFeatureGroup.getFeatureGroupPrototype() == null
								&& callContextFeatureGroup.getRefined() instanceof FeatureGroup) {
							callContextFeatureGroup = (FeatureGroup) callContextFeatureGroup
									.getRefined();
						}
						if (callContextFeatureGroup.getFeatureGroupType() != null)
							prototypeContext = callContextFeatureGroup
							.getFeatureGroupType();
						else if (callContextFeatureGroup.getFeatureGroupPrototype() instanceof FeatureGroupPrototype) {
							prototypeContext = findFeatureGroupTypeForFeatureGroupPrototype(
									AadlUtil.getContainingClassifier(conn),
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
									AadlUtil.getContainingClassifier(conn),
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
									AadlUtil.getContainingClassifier(conn),
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
								AadlUtil.getContainingClassifier(conn),
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
						AadlUtil.getContainingClassifier(conn),
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
						AadlUtil.getContainingClassifier(conn),
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
			NamedElement searchResult = AadlUtil.getContainingClassifier(connection)
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
						AadlUtil.getContainingClassifier(connection),
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
					&& featureGroup.getFeatureGroupPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof FeatureGroupConnectionEnd)
					return (FeatureGroupConnectionEnd) searchResult;
			} else if (featureGroup.getFeatureGroupPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						AadlUtil.getContainingClassifier(connection),
						(FeatureGroupPrototype) featureGroup.getFeatureGroupPrototype());
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
			NamedElement searchResult = AadlUtil.getContainingClassifier(connection)
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
						AadlUtil.getContainingClassifier(connection),
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
					&& featureGroup.getFeatureGroupPrototype() == null
					&& featureGroup.getRefined() instanceof FeatureGroup) {
				featureGroup = (FeatureGroup) featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null) {
				NamedElement searchResult = featureGroup.getFeatureGroupType()
						.findNamedElement(name);
				if (searchResult instanceof FeatureConnectionEnd)
					return ((FeatureConnectionEnd) searchResult);
			} else if (featureGroup.getFeatureGroupPrototype() != null) {
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(
						AadlUtil.getContainingClassifier(connection),
						(FeatureGroupPrototype) featureGroup.getFeatureGroupPrototype());
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
	public ComponentClassifier findClassifierForComponentPrototype(
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
	public ComponentClassifier findClassifierForComponentPrototype(
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
	public FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(
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
	 * Search for a {@link NamedElement} inside a package. If {@code context} is a
	 * {@link PublicPackageSection}, then this method will search through the
	 * {@link PublicPackageSection} only. If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will search through the
	 * {@link PrivatePackageSection} and its corresponding
	 * {@link PublicPackageSection}. 
	 * It will resolve any renames since it is a package internal lookup.
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
	public NamedElement findNamedElementInsideAadlPackage(String name,
			PackageSection context) {
		NamedElement result = context.findInternallyVisibleNamedElement(name);
		if (result == null
				&& context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null)
			result = ((AadlPackage) context.eContainer())
			.getOwnedPublicSection().findInternallyVisibleNamedElement(name);
		return result;
	}

	/**
	 * Search for a {@link NamedElement} with the name {@code elementName} in
	 * the containing package, which is also the specified by {@code packageName}. 
     * If the element cannot be found in the specified package, then {@code null} will be returned.
	 * 
	 * 
	 * @param packageName
	 *            The name of the package that contains the element to search
	 *            for, or null
	 * @param elementName
	 *            The name of the element to search for.
	 * @param context
	 *            The {@link PackageSection} that needs to refer to the
	 *            specified {@link Element}.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public NamedElement findNamedElementInAadlPackage(String packageName,
			String elementName, Namespace context) {
		if (context instanceof PackageSection
				&& (packageName == null || context.getName()
				.equalsIgnoreCase(packageName))){
			// lookup in package that has reference
			NamedElement ne = findNamedElementInsideAadlPackage(elementName,
					(PackageSection) context);
			return ne;
		} else {
			// lookup in another package as external reference
			// we need to do this because references that use package aliases did not get picked up
			AadlPackage aadlPackage = null;
			if (context instanceof PackageSection) {
				aadlPackage = resolvePackageRename(packageName,	(PackageSection) context);
				if (aadlPackage == null )
					aadlPackage = AadlUtil.findImportedPackage(packageName, context);
			} 
			if (aadlPackage != null
					&& aadlPackage.getOwnedPublicSection() != null)
				return aadlPackage.getOwnedPublicSection().findNamedElement(elementName);
			else
				return null;
		}
	}

	/**
	 * Find element in  predeclared property sets which do not require the qualification
	 * @param propertyName
	 * @param context
	 * @param reference
	 * @return
	 */
	public EObject findNamedElementInPredeclaredPropertySets(String propertyName,
			EObject context, EReference reference) {
		for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
			EObject res = getIndexedObject(context, reference,getQualifiedName(predeclaredPSName, propertyName));
			if (res != null)
				return res;
		}
		return null;
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
	public PrototypeBinding findPrototypeBinding(
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
	public PrototypeBinding findPrototypeBinding(
			Subcomponent subcomponent, Prototype prototype) {
		for (PrototypeBinding binding : subcomponent
				.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		return null;
	}
	


	public static EnumerationLiteral findEnumerationLiteral(Property property, String name){
		PropertyType propertyType = property.getPropertyType();
		if (propertyType instanceof EnumerationType)
			return ((EnumerationType)propertyType).findLiteral(name);
		return null;
	}

	public static UnitLiteral findUnitLiteral(Property property, String name){
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


	public static UnitLiteral findUnitLiteral(NumberValue nv, String name){
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		return findUnitLiteral(nv, reference, name);
	}

	public static List<EObject> findUnitLiteralAsList(EObject context,
			EReference reference, String name) {
		EObject e = findUnitLiteral(context,reference,name);
		if (e == null) return Collections.<EObject> emptyList(); 
		return Collections.singletonList((EObject) e);
	}

	public static UnitLiteral findUnitLiteral(EObject context,
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


	public static EnumerationLiteral findEnumerationLiteral(EnumerationType enumType, String name){
		return (EnumerationLiteral) enumType.findNamedElement(name);
	}

	public static EnumerationLiteral findEnumerationLiteral(NamedValue nv, String name){
		EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue();
		List<EObject> el = findEnumLiteralAsList(nv, reference, name);
		if (!el.isEmpty()&&el.get(0) instanceof EnumerationLiteral) return (EnumerationLiteral)el.get(0);
		return null;
	}

	public static List<EObject> findEnumLiteralAsList(EObject context,
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

}
