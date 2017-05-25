package org.osate.xtext.aadl2.properties.util;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;

import com.google.inject.Inject;

public class EMFIndexRetrieval {

	@Inject
	private static ResourceDescriptionsProvider rdp;

	@Inject
	private static IResourceServiceProvider.Registry rspr;

	public static void registerResourceProviders(ResourceDescriptionsProvider frdp,
			IResourceServiceProvider.Registry frspr) {
		rdp = frdp;
		rspr = frspr;
	}

	private static IResourceDescription.Manager getManager(Resource res) {
		IResourceServiceProvider resourceServiceProvider = rspr.getResourceServiceProvider(res.getURI());
		return resourceServiceProvider.getResourceDescriptionManager();
	}

	public static void printEMFIndexEMV2(EObject context) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(context.eResource().getResourceSet());
		Iterable<IResourceDescription> rdlist = rds.getAllResourceDescriptions();
//		 	for (IResourceDescription iResourceDescription : rdlist) {
//				Iterable<IReferenceDescription> reflist = iResourceDescription.getReferenceDescriptions();
//				for (IReferenceDescription iReferenceDescription : reflist) {
//					URI srcURI=iReferenceDescription.getSourceEObjectUri();
//					URI dstURI = iReferenceDescription.getTargetEObjectUri();
//					EReference ref = iReferenceDescription.getEReference();
//					System.out.println("Ref ");
//				}
//			}
		Iterable<IEObjectDescription> packagedlist = rds.getExportedObjects(); // dObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
		for (IEObjectDescription eod : packagedlist) {
			System.out.println("EDesc: " + eod.getQualifiedName());
		}
	}
	
	/**
	* get all packages in workspace by looking them up in EMF index 
	* @param res resource
	* @return list of AADL packages in IEObjectDescription format
	*/
	public static EList<IEObjectDescription> getAllPackagesInWorkspace(ResourceSet resourceSet) {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(resourceSet);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
		for (IEObjectDescription eod : packagedlist) {
			packlist.add(eod);
		}
		return packlist;
	}

	/**
	* get all packages in workspace by looking them up in EMF index 
	* @param res resource
	* @return list of AADL packages in IEObjectDescription format
	*/
	public static EList<IEObjectDescription> getAllPackagesInWorkspace(EObject context) {
		return getAllPackagesInWorkspace(context.eResource().getResourceSet());
	}

	/**
	* get package in workspace by looking it up in EMF index 
	* @param pname String package name
	* @param resoruceSet the resource in which the models are expected
	* @return AADL package
	*/
	public static AadlPackage getPackageInWorkspace(String pname, ResourceSet resourceSet) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(resourceSet);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
		for (IEObjectDescription eod : packagedlist) {
			if (eod.getName().toString("::").equalsIgnoreCase(pname)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, resourceSet);
				if (!Aadl2Util.isNull(res)) {
					return (AadlPackage) res;
				}
			}
		}
		return null;
	}

	/**
	* get package in workspace by looking it up in EMF index 
	* @param pname String package name
	* @return AADL package
	*/
	public static AadlPackage getPackageInWorkspace(EObject context, String pname) {
		return getPackageInWorkspace(context, pname, context.eResource().getResourceSet());
	}

	/**
	* get package in workspace by looking it up in EMF index 
	* @param pname String package name
	* @return AADL package
	*/
	public static AadlPackage getPackageInWorkspace(EObject context, String pname, ResourceSet resourceSet) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(resourceSet);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getAadlPackage());
		for (IEObjectDescription eod : packagedlist) {
			if (eod.getName().toString("::").equalsIgnoreCase(pname)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, resourceSet);
				if (!Aadl2Util.isNull(res)) {
					return (AadlPackage) res;
				}
			}
		}
		return null;
	}

	/**
	* get all property sets in workspace by looking them up in EMF index 
	* @param res resource
	* @return list of property sets in IEObjectDescription format
	*/
	public static EList<IEObjectDescription> getAllPropertySetsInWorkspace(EObject context) {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(context.eResource().getResourceSet());
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet());
		for (IEObjectDescription eod : packagedlist) {
			packlist.add(eod);
		}
		return packlist;
	}

	/**
	* get PropertySet in workspace by looking it up in EMF index
	* @param context EObject to retrieve the ResoruceSet for the EMF Index 
	* @param pname String PropertySet name
	* @return PropertySet or null
	*/
	public static PropertySet getPropertySetInWorkspace(EObject context, String pname) {
		ResourceSet rset = context.eResource().getResourceSet();
		IResourceDescriptions rds = rdp.getResourceDescriptions(rset);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet());
		for (IEObjectDescription eod : packagedlist) {
			if (eod.getName().toString("::").equalsIgnoreCase(pname)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, rset);
				if (!Aadl2Util.isNull(res)) {
					return (PropertySet) res;
				}
			}
		}
		return null;
	}

	/**
	* get PropertySet in workspace by looking it up in EMF index 
	* @param pname String PropertySet name
	* @return PropertySet or null
	*/
	public static PropertySet getPropertySetInWorkspace(String pname, ResourceSet resourceSet) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(resourceSet);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertySet());
		for (IEObjectDescription eod : packagedlist) {
			if (eod.getName().toString("::").equalsIgnoreCase(pname)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, resourceSet);
				if (!Aadl2Util.isNull(res)) {
					return (PropertySet) res;
				}
			}
		}
		return null;
	}

//	 /**
//	 * get the Property Definition by looking it up in EMF index
//	 * @param pdname String name of property Definition (predeclared properties do not have to be qualified)
//	 * @return Property or null
//	 */
//	 public static Property getPropertyDefinitionInWorkspace(String pdname){
//	 	 return getPropertyDefinitionInWorkspace(OsateResourceUtil.getResourceSet(), pdname);
//	 }

	/**
	* get the Property Definition by looking it up in EMF index 
	* @param context an object in the same resource set
	* @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	* @return Property or null
	*/
	public static Property getPropertyDefinitionInWorkspace(EObject context, String pdname) {
		return getPropertyDefinitionInWorkspace(context.eResource().getResourceSet(), pdname);
	}

	/**
	* get the Property Definition by looking it up in EMF index 
	* @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	* @return Property or null
	*/
	public static Property getPropertyDefinitionInWorkspace(ResourceSet rs, String pdname) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(rs);
		Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(Aadl2Package.eINSTANCE.getProperty());
		for (IEObjectDescription eod : packagedlist) {
			if (pdname.lastIndexOf("::") == -1) {
				String name = eod.getName().toString("::");
				for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
					if (name.equalsIgnoreCase(predeclaredPSName + "::" + pdname)) {
						EObject res = eod.getEObjectOrProxy();
						res = EcoreUtil.resolve(res, rs);
						if (!Aadl2Util.isNull(res)) {
							return (Property) res;
						}
					}
				}
			} else {
				if (eod.getName().toString("::").equalsIgnoreCase(pdname)) {
					EObject res = eod.getEObjectOrProxy();
					res = EcoreUtil.resolve(res, rs);
					if (!Aadl2Util.isNull(res)) {
						return (Property) res;
					}
				}
			}
		}
		return null;
	}

	/**
	* get the Property Type by looking it up in EMF index 
	* @param context an object in the same resoruce set
	* @param ptname String name of property type (predeclared properties do not have to be qualified)
	* @return Property or null
	*/
	public static PropertyType getPropertyTypeInWorkspace(EObject context, String ptname) {
		return getPropertyTypeInWorkspace(context.eResource().getResourceSet(), ptname);
	}

	/**
	* get the Property Type by looking it up in EMF index 
	* @param ptname String name of property type (predeclared properties do not have to be qualified)
	* @return Property or null
	*/
	public static PropertyType getPropertyTypeInWorkspace(ResourceSet rs, String ptname) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(rs);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertyType());
		for (IEObjectDescription eod : packagedlist) {
			if (ptname.lastIndexOf("::") == -1) {
				String name = eod.getName().toString("::");
				for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
					if (name.equalsIgnoreCase(predeclaredPSName + "::" + ptname)) {
						EObject res = eod.getEObjectOrProxy();
						res = EcoreUtil.resolve(res, rs);
						if (!Aadl2Util.isNull(res)) {
							return (PropertyType) res;
						}
					}
				}
			} else {
				if (eod.getName().toString("::").equalsIgnoreCase(ptname)) {
					EObject res = eod.getEObjectOrProxy();
					res = EcoreUtil.resolve(res, rs);
					if (!Aadl2Util.isNull(res)) {
						return (PropertyType) res;
					}
				}
			}
		}
		return null;
	}

	/**
	* get the Property Constant by looking it up in EMF index 
	* @param context an object in the same resource set
	* @param pcname String name of property Constant (predeclared properties do not have to be qualified)
	* @return Property or null
	*/
	public static PropertyConstant getPropertyConstantInWorkspace(EObject context, String pcname) {
		return getPropertyConstantInWorkspace(context.eResource().getResourceSet(), pcname);
	}

	/**
	* get the Property Constant by looking it up in EMF index 
	* @param pcname String name of property Constant (predeclared properties do not have to be qualified)
	* @return Property or null
	*/
	public static PropertyConstant getPropertyConstantInWorkspace(ResourceSet rs, String pcname) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(rs);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getPropertyConstant());
		for (IEObjectDescription eod : packagedlist) {
			if (pcname.lastIndexOf("::") == -1) {
				String name = eod.getName().toString("::");
				for (String predeclaredPSName : AadlUtil.getPredeclaredPropertySetNames()) {
					if (name.equalsIgnoreCase(predeclaredPSName + "::" + pcname)) {
						EObject res = eod.getEObjectOrProxy();
						res = EcoreUtil.resolve(res, rs);
						if (!Aadl2Util.isNull(res)) {
							return (PropertyConstant) res;
						}
					}
				}
			} else {
				if (eod.getName().toString("::").equalsIgnoreCase(pcname)) {
					EObject res = eod.getEObjectOrProxy();
					res = EcoreUtil.resolve(res, rs);
					if (!Aadl2Util.isNull(res)) {
						return (PropertyConstant) res;
					}
				}
			}
		}
		return null;
	}

	/**
	* get all packages and property sets in workspace by looking them up in EMF index 
	* @param res resource
	* @return list of AADL packages and property sets in IEObjectDescription format
	*/
	public static EList<IEObjectDescription> getAllModelUnitsInWorkspace(ResourceSet rs) {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(rs);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getModelUnit());
		for (IEObjectDescription eod : packagedlist) {
			packlist.add(eod);
		}
		return packlist;
	}

	/**
	* get all classifiers in all packages by looking them up in EMF index 
	* @param res resource
	* @return list of classifiers in IEObjectDescription format
	* 
	* @deprecated use {@link #getAllClassifiersInWorkspace(EObject)} instead.
	*/
	@Deprecated
	public static EList<IEObjectDescription> getAllClassifiersInWorkspace() {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier());
		for (IEObjectDescription eod : packagedlist) {
			packlist.add(eod);
		}
		return packlist;
	}

	/**
	* get all classifiers in all packages by looking them up in EMF index 
	* @param res resource
	* @return list of classifiers in IEObjectDescription format
	*/
	public static EList<IEObjectDescription> getAllClassifiersInWorkspace(EObject context) {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(context.eResource().getResourceSet());
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier());
		for (IEObjectDescription eod : packagedlist) {
			packlist.add(eod);
		}
		return packlist;
	}

	/**
	* get all EObjects in by looking them up in EMF index 
	* @param context EObject in the same resourceset as the EObjects we are looking for
	* @param eObjectType EClass of desired EObjects
	* @return list of EObjects in IEObjectDescription format
	*/
	public static Iterable<IEObjectDescription> getAllEObjectsOfTypeInWorkspace(EClass eObjectType) {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(OsateResourceUtil.getResourceSet());
		Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(eObjectType);
		return packagedlist;
//	 	 for (IEObjectDescription eod : packagedlist) {
//	 			 packlist.add(eod);
//	 	 }
//	 	 return packlist;
	}

	/**
	* get all EObjects in by looking them up in EMF index 
	* @param context EObject in the same resourceset as the EObjects we are looking for
	* @param eObjectType EClass of desired EObjects
	* @return list of EObjects in IEObjectDescription format
	*/
	public static Iterable<IEObjectDescription> getAllEObjectsOfTypeInWorkspace(EObject context, EClass eObjectType) {
		EList<IEObjectDescription> packlist = new BasicEList<IEObjectDescription>();
		IResourceDescriptions rds = rdp.getResourceDescriptions(context.eResource().getResourceSet());
		Iterable<IEObjectDescription> packagedlist = rds.getExportedObjectsByType(eObjectType);
		return packagedlist;
//	 	 for (IEObjectDescription eod : packagedlist) {
//	 			 packlist.add(eod);
//	 	 }
//	 	 return packlist;
	}

	/**
	 * find EObject by name in EObjectDescription list
	 * @param context to identify the resourceset
	 * @param edl EObjectDescription list
	 * @param name String qualified name of EObject to be found
	 * @return EObject
	 */
	public static EObject getEObject(EObject context, Iterable<IEObjectDescription> edl, String name) {
		for (IEObjectDescription eod : edl) {
			if (eod.getName().toString("::").equalsIgnoreCase(name)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, context.eResource().getResourceSet());
				if (!Aadl2Util.isNull(res)) {
					return res;
				}
			}
		}
		return null;
	}

	/**
	 * find EObject by name in EObjectDescription list
	 * @param context to identify the resourceset
	 * @param edl EObjectDescription list
	 * @param name String qualified name of EObject to be found
	 * @return EObject
	 */
	public static EObject getEObjectOfType(EObject context, EClass eObjectType, String name) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(context.eResource().getResourceSet());
		Iterable<IEObjectDescription> edlist = rds.getExportedObjectsByType(eObjectType);
		for (IEObjectDescription eod : edlist) {
			if (eod.getName().toString("::").equalsIgnoreCase(name)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, context.eResource().getResourceSet());
				if (!Aadl2Util.isNull(res)) {
					return res;
				}
			}
		}
		return null;
	}

	/**
	 * get the Classifier by looking it up in EMF index 
	 * @param cname String name of classifier, which must be qualified with a package name
	 * @return Classifier or null
	 * 
	 * @deprecated use {@link #getClassifierInWorkspace(ResourceSet, String)} instead
	 */
	@Deprecated
	public static Classifier getClassifierInWorkspace(String cname) {
		return getClassifierInWorkspace(OsateResourceUtil.getResourceSet(), cname);
	}

	/**
	 * get the Classifier by looking it up in EMF index 
	 * @param context an object in the same resource set
	 * @param cname String name of classifier, which must be qualified with a package name
	 * @return Classifier or null
	 */
	public static Classifier getClassifierInWorkspace(Element context, String cname) {
		return getClassifierInWorkspace(context.eResource().getResourceSet(), cname);
	}

	/**
	 * get the Property Definition by looking it up in EMF index 
	 * @param pdname String name of property Definition (predeclared properties do not have to be qualified)
	 * @return Property or null
	 */
	public static Classifier getClassifierInWorkspace(ResourceSet rs, String cname) {
		IResourceDescriptions rds = rdp.getResourceDescriptions(rs);
		Iterable<IEObjectDescription> packagedlist = rds
				.getExportedObjectsByType(Aadl2Package.eINSTANCE.getClassifier());
		for (IEObjectDescription eod : packagedlist) {
			if (eod.getName().toString("::").equalsIgnoreCase(cname)) {
				EObject res = eod.getEObjectOrProxy();
				res = EcoreUtil.resolve(res, rs);
				if (!Aadl2Util.isNull(res)) {
					return (Classifier) res;
				}
			}
		}
		return null;
	}

}
