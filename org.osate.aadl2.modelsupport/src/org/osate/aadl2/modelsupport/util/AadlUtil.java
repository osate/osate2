/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
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
 *
 * </copyright>
 *
 *
 * @version $Id: AadlUtil.java,v 1.14 2009-10-15 15:48:17 jseibel Exp $
 */

/*
 * Created on Jun 9, 2004
 *
 * Static utility methods
 */
package org.osate.aadl2.modelsupport.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.TreeSelection;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractConnectionEnd;
import org.osate.aadl2.Access;
import org.osate.aadl2.AccessKind;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.InternalEvent;
import org.osate.aadl2.ListType;
import org.osate.aadl2.ModalElement;
import org.osate.aadl2.Mode;
import org.osate.aadl2.ModeTransitionTrigger;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorPort;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.ProcessorSubprogram;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.Realization;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.aadl2.modelsupport.modeltraversal.SimpleSubclassCounter;
import org.osate.aadl2.modelsupport.modeltraversal.TraverseWorkspace;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.parsesupport.LocationReference;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.workspace.WorkspacePlugin;


/**
 * Static utility methods for processing AADL meta model objects.
 * 
 * @author phf
 */
public final class AadlUtil {
	/**
	 * Private empty constructor to prevent instantiation of the class.
	 */
	private AadlUtil() {
		// empty!
	}

	// Constants for namespace resolution
	private static final int PUBLIC = 0;

	private static final int PRIVATE = 1;

	private static final Set<String> PREDECLARED_PROPERTY_SET_NAMES;

	static {
		HashSet<String> predeclaredPropertySetNames = new HashSet<String>();
		predeclaredPropertySetNames.add("AADL_Project");
		predeclaredPropertySetNames.add("Deployment_Properties");
		predeclaredPropertySetNames.add("Thread_Properties");
		predeclaredPropertySetNames.add("Timing_Properties");
		predeclaredPropertySetNames.add("Communication_Properties");
		predeclaredPropertySetNames.add("Memory_Properties");
		predeclaredPropertySetNames.add("Programming_Properties");
		predeclaredPropertySetNames.add("Modeling_Properties");
		PREDECLARED_PROPERTY_SET_NAMES = Collections
				.unmodifiableSet(predeclaredPropertySetNames);
	}
	
	public static Set<String> getPredeclaredPropertySetNames(){
		return PREDECLARED_PROPERTY_SET_NAMES;
	}

	public static boolean isPredeclaredPropertySet(String psname){
		for (String predeclaredPSName : PREDECLARED_PROPERTY_SET_NAMES) {
			if (psname.equalsIgnoreCase(predeclaredPSName)) return true;
		}
		return false;
	}

	/**
	 * find (first) Named Element matching name in the Elist; any elements that
	 * are not NamedElements are skipped.
	 * 
	 * @param el Elist of NamedElements
	 * @param name String
	 * @return NamedElement
	 */
	public static NamedElement findNamedElementInList(List<?> el, String name) {
		if (el != null) {
			Iterator<?> it = el.iterator();

			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();

					if (n != null && n.length() > 0 && name.equalsIgnoreCase(n)) {
						return (NamedElement) o;
					}
				}
			}
		}
		return null;
	}

	/**
	 * find all Named Elements matching name in the Elist; any elements that are
	 * not NamedElements are skipped.
	 * 
	 * @param el Elist of NamedElements
	 * @param name String
	 * @return EList of NamedElements that match the name
	 */
	public static EList<NamedElement> findNamedElementsInList(List<?> el, String name) {
		EList<NamedElement> result = new BasicEList<NamedElement>();

		if (el != null) {
			Iterator<?> it = el.iterator();
			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();
					if (n != null && name.length() > 0 && name.equalsIgnoreCase(n)) {
						result.add((NamedElement) o);
					}
				}
			}
		}
		return result;
	}

	/**
	 * Check to see if all NamedElements in the Elist have a unique name. The
	 * list can contain object that are not NamedElements. This implementation
	 * utilizes List Iterators.
	 * 
	 * @param el EList or NamedElements or other objects
	 * @return EList of NameElements that are defining a previously defined name
	 */
	public static EList<NamedElement> findDoubleNamedElementsInList(List<?> el) {
		EList<NamedElement> result = new BasicEList<NamedElement>();
		final Set seen = new HashSet();

		if (el != null) {
			for (final Iterator i = el.iterator(); i.hasNext();) {
				final Object obj = i.next();
				if (obj instanceof NamedElement){
					final NamedElement lit = (NamedElement)obj;
					final String name = lit.getName().toLowerCase();
					if (name != null || name.isEmpty()){
						if (seen.contains(name)) {
							result.add(lit);
						} else {
							seen.add(name);
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * Compare the EClass of the two EObjects
	 * 
	 * @param c1 EObject
	 * @param c2 EObject
	 * @return true if their EClasses are the same
	 */
	public static boolean sameEClass(EObject c1, EObject c2) {
		return c1.eClass() == c2.eClass();
	}

	/**
	 * Check to ensure that there is at most one list element per mode
	 * 
	 * @param list list of ModeMembers
	 * @return true if at most one element per mode
	 */
	public static boolean oncePerMode(List<? extends ModalElement> list, List<? extends Mode> allModes) {
		int noModeSet = 0;
		EList<Mode> modeset = new BasicEList<Mode>();
		for (Iterator<? extends ModalElement> it = list.iterator(); it.hasNext();) {
			ModalElement cs = it.next();
			// TODO: [MODES] Uncomment when ModalElement.isNoMode() is created.
			// if (! cs.isNoMode())
			{
				EList<Mode> modes = cs.getInModes();
				if (modes.isEmpty()) {
					noModeSet++;
				} else {
					modeset.addAll(modes);
				}
			}
		}
		/*
		 * Once per mode is NOT true, if modeset has a duplicate, or we have
		 * more than one modeless declaration, or we have a modeless declaration
		 * and explicit declarations for all the possible modes.
		 */
		return !(!AadlUtil.findDoubleNamedElementsInList(modeset).isEmpty() || noModeSet > 1 || (noModeSet > 0
				&& !allModes.isEmpty() && modeset.containsAll(allModes)));

		// return AadlUtil.findDoubleNamedElementsInList(modeset).isEmpty() &&
		// noModeSet <2;
	}

	// TODO: [SPECIFICATION] Rewrite this because there are no more AadlSpecs.
	// /**
	// * Get all component implementations; in all anon. name spaces and from
	// all packages (public and private parts)
	// * @return EList of component impl
	// */
	// public static EList<ComponentImplementation> getAllComponentImpl(){
	// EList<ComponentImplementation> result = new
	// BasicEList<ComponentImplementation>();
	// EList<Resource> resources =
	// ResourceUtil.getResourceSet().getResources();
	// for (Resource res : resources) {
	// EList<EObject> content = res.getContents();
	// if (!content.isEmpty()){
	// EObject root = content.get(0);
	// if (root instanceof AadlSpec){
	// result.addAll(getAllComponentImpl((AadlSpec)root));
	// }
	// }
	// }
	// return result;
	// }

	// TODO: [SPECIFICATION] Rewrite this because there are no more AadlSpecs.
	// /**
	// * Get all component implementations; in anon. name space and from all
	// packages
	// * @param as AadlSpec
	// * @return EList of component impl
	// */
	// private static EList<ComponentImplementation>
	// getAllComponentImpl(AadlSpec as){
	// EList<ComponentImplementation> result = new
	// BasicEList<ComponentImplementation>();
	// EList<EObject> cont = as.eContents();
	// for (EObject o : cont) {
	// if (o instanceof ComponentImplementation)
	// result.add((ComponentImplementation)o);
	// else if (o instanceof AadlPackage){
	// result.addAll(getAllComponentImpl((AadlPackage) o));
	// }
	// }
	// return result;
	// }

	// TODO: [SPECIFICATION] Rewrite this because there are no more AadlSpecs.
	// TODO: [PROPERTIES] In OSATE 1, ComponentCategory was in the property
	// package. The rewrite may have to wait until the properties are done.
	// /**
	// * Get all component classifiers that are visible from the given aobject.
	// * This includes all globally visible component classifiers;
	// * if aobj is null, then only the global component classifiers are
	// returned.
	// * if the AObject aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the aobject is in the proviate part of a package, also
	// includes the classifiers defined in the private part
	// * @param aobj AObject
	// * @return EList of component classifiers
	// */
	// public static EList getAllVisibleComponentClassifiers(AObject aobj,
	// ComponentCategory compCat){
	// EList result = new BasicEList();
	// EList<Resource> resources =
	// ResourceUtil.getResourceSet().getResources();
	// for (Resource res : resources){
	// EList<EObject> content = res.getContents();
	// if (!content.isEmpty()){
	// EObject root = content.get(0);
	// if (root instanceof AadlSpec){
	// AadlSpec aspec = (AadlSpec)root;
	// if ( aspec.isPackage()){
	// result.addAll(aspec.getAllComponentClassifiers(compCat));
	// }
	// }
	// }
	// }
	// if (aobj == null){
	// return result;
	// }
	// AadlSpec as = aobj.getAadlSpec();
	// if (as == null){
	// return result;
	// }
	// if (as.isSpecification() ){
	// result.addAll(as.getAllComponentClassifiers(compCat));
	// }
	// AObject nameSpace = aobj.getContainingClassifierNameSpace();
	// if (nameSpace instanceof AadlPrivate){
	// result.addAll(((AadlPrivate)nameSpace).getComponentClassifier(compCat));
	// }
	// return result;
	// }

	// TODO: [PROPERTIES] Uncomment after the class ComponentCategory is added
	// to the model.
	// /**
	// * Get all component types that are visible from the given aobject.
	// * This includes all globally visible component types;
	// * if aobj is null, then only the global component types are returned.
	// * if the AObject aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the aobject is in the proviate part of a package, also
	// includes the types defined in the private part
	// * @param aobj AObject
	// * @return EList of component types
	// */
	// public static EList<ComponentType> getAllVisibleComponentTypes(AObject
	// aobj, ComponentCategory compCat){
	// EList<ComponentType> result = new BasicEList<ComponentType>();
	// EList classifiers = getAllVisibleComponentClassifiers(aobj,compCat);
	// for (Iterator it = classifiers.iterator(); it.hasNext();){
	// Object obj = it.next();
	// if (obj instanceof ComponentType){
	// result.add((ComponentType)obj);
	// }
	// }
	// return result;
	// }

	// TODO: [PROPERTIES] Uncomment after the class ComponentCategory is added
	// to the model.
	// /**
	// * Get all component implementations that are visible from the given
	// aobject.
	// * This includes all globally visible component implementations;
	// * if aobj is null, then only the global component implementations are
	// returned.
	// * if the AObject aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the aobject is in the proviate part of a package, also
	// includes the types defined in the private part
	// * @param aobj AObject
	// * @return EList of component implementations
	// */
	// public static EList<ComponentImplementation>
	// getAllVisibleComponentImpls(AObject aobj, ComponentCategory compCat){
	// EList<ComponentImplementation> result = new
	// BasicEList<ComponentImplementation>();
	// EList classifiers = getAllVisibleComponentClassifiers(aobj,compCat);
	// for (Iterator it = classifiers.iterator(); it.hasNext();){
	// Object obj = it.next();
	// if (obj instanceof ComponentImplementation){
	// result.add((ComponentImplementation)obj);
	// }
	// }
	// return result;
	// }

	// TODO: [SPECIFICATION] Rewrite this because there are no more AadlSpecs.
	// /**
	// * Get all Port Group Types that are visible from the given aobject.
	// * This includes all globally visible component classifiers;
	// * if aobj is null, then only the global component classifiers are
	// returned.
	// * if the AObject aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the aobject is in the proviate part of a package, also
	// includes the classifiers defined in the private part
	// * @param aobj AObject
	// * @return EList of port group type
	// */
	// public static EList getAllVisiblePortGroupTypes(AObject aobj){
	// EList result = new BasicEList();
	// EList<Resource> resources =
	// ResourceUtil.getResourceSet().getResources();
	// for (Resource res : resources){
	// EList<EObject> content = res.getContents();
	// if (!content.isEmpty()){
	// EObject root = content.get(0);
	// if (root instanceof AadlSpec){
	// AadlSpec aspec = (AadlSpec)root;
	// if ( aspec.isPackage()){
	// result.addAll(aspec.getAllPortGroupTypes());
	// }
	// }
	// }
	// }
	// if (aobj == null){
	// return result;
	// }
	// AadlSpec as = aobj.getAadlSpec();
	// if (as == null){
	// return result;
	// }
	// if (as.isSpecification() ){
	// result.addAll(as.getAllPortGroupTypes());
	// }
	// AObject nameSpace = aobj.getContainingClassifierNameSpace();
	// if (nameSpace instanceof AadlPrivate){
	// result.addAll(((AadlPrivate)nameSpace).getPortGroupType());
	// }
	// return result;
	// }

	// TODO: [PROPERTIES] Uncomment after properties are done.
	// private static EList<PropertyDefinition> getPropertyDefinitions(final
	// Set<PropertySet> propSets) {
	// final EList<PropertyDefinition> result = new
	// BasicEList<PropertyDefinition>();
	// for (PropertySet ps : propSets) {
	// for (EObject o : ps.eContents()){
	// if (o instanceof PropertyDefinition) {
	// result.add((PropertyDefinition)o);
	// }
	// }
	// }
	// return result;
	// }

	// TODO: [PROPERTIES] Uncomment after properties are done.
	// /**
	// * Get all the properties defined in the global property sets.
	// */
	// public static EList<PropertyDefinition> getAllPropertyDefinition() {
	// final Set<PropertySet> propSets =
	// ResourceUtil.getAllPropertySets();
	// return getPropertyDefinitions(propSets);
	// }

	// TODO: [PROPERTIES] Uncomment after properties are done.
	// /**
	// * Get all the property definitions, including those defined in any local
	// * property sets.
	// *
	// * @param context
	// * The model object on whose behalf the lookup is being
	// * performed. See
	// * {@link ResourceUtil#findPropertySet(String, AObject)}.
	// */
	// public static EList<PropertyDefinition> getAllPropertyDefinition(final
	// AObject context) {
	// final Set<PropertySet> propSets =
	// ResourceUtil.getAllPropertySets(context);
	// return getPropertyDefinitions(propSets);
	// }

	// TODO: [PROPERTIES] Uncomment after properties are done.
	// /**
	// * Get all property definitions that are used in the Aadl model.
	// * This includes the predeclared properties and any property definitions
	// * in user declared property sets.
	// * @param si System Implementation
	// * @return property definitions
	// */
	// public static EList<PropertyDefinition>
	// getAllUsedPropertyDefinition(SystemImpl si){
	// EList<PropertyDefinition> result = new UniqueEList<PropertyDefinition>();
	//
	// EList allUsedClassifiers = new
	// ForAllAObject().processTopDownComponentClassifier(si);
	// // collect topdown component impl. do it and its type to find PA
	// for (Iterator it = allUsedClassifiers.iterator(); it.hasNext();){
	// ComponentClassifier cc = (ComponentClassifier) it.next();
	// addUsedPropertyDefinitions(cc,result);
	// }
	// return result;
	// }

	// TODO: [PROPERTIES] Uncomment after properties are done.
	// /**
	// * find all property associations and add its property definition to the
	// reesults
	// * @param root AObject whose subtree is being searched
	// * @param result EList holding the used property definitions
	// * @return List holding the used property definitions
	// */
	// private static List<PropertyDefinition>
	// addUsedPropertyDefinitions(AObject root, List<PropertyDefinition>
	// result){
	// TreeIterator<AObject> it =
	// EcoreUtil.getAllContents(Collections.singleton(root));
	// while(it.hasNext()){
	// AObject ao = it.next();
	// if (ao instanceof PropertyAssociation){
	// PropertyDefinition pd =
	// ((PropertyAssociation)ao).getPropertyDefinition();
	// if (pd != null){
	// result.add(pd);
	// }
	// }
	// }
	// return result;
	// }

	/**
	 * Check whether the flow specification and flow implementation are both
	 * flow paths, flow sources, or flow sinks
	 * 
	 * @param fi flow implementation
	 * @param fs flow specification
	 * @return true if the both are paths, or both sources, or both sinks
	 */
	public static boolean canImplement(FlowImplementation fi, FlowSpecification fs) {
		String implName = fi.eClass().getName();
		String specName = fs.eClass().getName();

		return implName.substring(0, implName.length() - "Implementation".length()).equals(
				specName.substring(0, specName.length() - "Specification".length()));
	}

	/**
	 * Check to see that a component type and a component implementation have
	 * the same category
	 * 
	 * @param impl ComponentImplementation
	 * @param type ComponentType
	 * @return true if their categories match
	 */
	public static boolean canImplement(ComponentImplementation impl, ComponentType type) {
		String implName = impl.eClass().getName();
		String typeName = type.eClass().getName();

		return implName.substring(0, implName.length() - "Implementation".length()).equals(
				typeName.substring(0, typeName.length() - "Type".length()));
	}

	/**
	 * Check to see if the category of the subcomponent and the classifier match
	 * 
	 * @param sub Subcomponent
	 * @param c ComponentClassifier
	 * @return true if the categories match
	 */
	public static boolean sameCategory(Subcomponent sub, ComponentClassifier c) {
		String subName = sub.eClass().getName();
		String cName = c.eClass().getName();

		return subName.substring(0, subName.length() - "Subcomponent".length()).equals(
				cName.substring(0, cName.length()
						- (c instanceof ComponentImplementation ? "Implementation" : "Type").length()));
	}

	// TODO: [NAMESPACE] Rewrite with the new namespace scheme.
	// /**
	// * Removes packagename if current package
	// * @param o that contains the classsifier reference
	// * @param str
	// * @return String without package name
	// */
	// public static String ownPackage(AObject o, String str){
	// AObject ns = o.getContainingClassifierNameSpace();
	//
	// if (ns instanceof PackageSection){
	// AadlPackage ap = (AadlPackage)ns.eContainer();
	// String pname = ap.getName();
	// int idx = str.lastIndexOf("::");
	// if (idx == -1 ){
	// return str;
	// }
	// String pck = str.substring(0,idx);
	// String name = str.substring(idx+2);
	// if (pname != null && pname.equalsIgnoreCase(pck))
	// return name;
	// }
	// return str;
	// }

	// TODO: [NAMESPACE] Rewrite with the new namespace scheme.
	// /**
	// * Find a component classifier by name.
	// *
	// * @param fromNS
	// * The package where to start the search (AadlSpec or
	// * AadlPackageSection). Necessary to determine namespace.
	// * @param ner
	// * Identification of the classifier to find.
	// * @return Reference to the classifier, null if not found.
	// */
	// public static Classifier findClassifierInNameSpace(AObject fromNS,
	// NamedElementReference ner) {
	// String packName;
	// String name;
	// EObject[] namespace = null;
	//
	// if (ner == null) {
	// return null;
	// }
	//
	// packName = ner.getContextName();
	// name = ner.getElementName();
	// if ( name == null || name.length() == 0) return null;
	//
	// namespace = getNamespace(fromNS, packName);
	//
	// // lookup component type in namespace
	// // type must be in same package as implementation
	// for (int i = PUBLIC; i <= PRIVATE; i++) {
	// if (namespace[i] != null) {
	// EList<EObject> nscontent = namespace[i].eContents();
	// NamedElement ne = AadlUtil.findNamedElementInList(nscontent, name);
	// if (ne instanceof Classifier) {
	// return (Classifier) ne;
	// }
	// }
	// }
	// // not found
	// return null;
	// }

	// TODO: [NAMESPACE] Rewrite with the new namespace scheme.
	// /**
	// * Determine namespace that is accessible from a starting package. The top
	// * level AADL specification is treated as a package with an empty name and
	// * a public section only.
	// *
	// * @param fromNS
	// * The starting namespace, an AadlSpec or AadlSection.
	// * @param pkgName
	// * The package to looked at.
	// * @return The first array element is an EList containing public elements
	// * in package pkgName, the second element contains visible private
	// * elements
	// */
	// private static EObject[] getNamespace(AObject fromNS, String pkgName) {
	// EObject[] ns = new EObject[2];
	// AObject thepack = fromNS;
	// AadlPackage pack = null;
	// AadlPackage pack2 = null;
	//
	// // no package name given, namespace is same package or the spec
	// if (pkgName == null || pkgName.length() == 0) {
	// if (thepack instanceof AadlSpec) {
	// ns[PUBLIC] = thepack;
	// return ns;
	// } else {
	// pkgName = ((AadlPackage) thepack.eContainer()).getName();
	// }
	// }
	//
	// pack = ResourceUtil.findPublicAadlPackage(pkgName,fromNS);
	// if (pack != null ){
	// pack2 = ResourceUtil.findPrivateOnlyAadlPackage(pkgName,fromNS);
	// }
	// String mypkgname;
	//
	// if (fromNS instanceof AadlSpec) {
	// mypkgname = "";
	// } else {
	// mypkgname = ((AadlPackage) fromNS.eContainer()).getName();
	// }
	// if (pack != null) {
	// if (ns[PUBLIC] == null) {
	// ns[PUBLIC] = pack.getAadlPublic();
	// }
	//
	// // access to private section in own package only
	// if (ns[PRIVATE] == null && pkgName.equalsIgnoreCase(mypkgname)) {
	// ns[PRIVATE] = pack.getAadlPrivate();
	// }
	// }
	// if (pack2 != null) {
	//
	// // access to private section in own package only
	// if (ns[PRIVATE] == null && pkgName.equalsIgnoreCase(mypkgname)) {
	// ns[PRIVATE] = pack2.getAadlPrivate();
	// }
	// }
	// return ns;
	// }

	// TODO: [FORALLAOBJECT] Uncomment when ForAllAObject is fixed.
	// /**
	// * get a sorted list of component classifier declaratations
	// * It is sorted such that subcomponents in component implementations refer
	// to
	// * previously declared component types or implementations
	// * @param aobj
	// * @return list of component classifiers
	// */
	// public static EList<ComponentClassifier>
	// getDeclarationOrderedComponentClassifiers(AObject aobj){
	// final EList<ComponentClassifier> uniqueClassifiers = new
	// UniqueEList<ComponentClassifier>();
	// final EList topDownList;
	// if (aobj instanceof ComponentImplementation) {
	// topDownList = new
	// ForAllAObject().processTopDownComponentImpl((ComponentImplementation)
	// aobj);
	// } else {
	// topDownList = new ForAllAObject().processTopDownComponentImpl();
	// }
	// for (int i = topDownList.size(); i>0; i--){
	// ComponentImplementation ci = (ComponentImplementation)
	// topDownList.get(i-1);
	// ComponentType ct = ci.getType();
	// uniqueClassifiers.add(ct);
	// uniqueClassifiers.add(ci);
	// }
	// return uniqueClassifiers;
	// }

	/**
	 * check to see that the source classifier matches that of the destination
	 * implementations must be the same, types must be the same; if the source
	 * is an implementation and the destination is a type their types must match
	 * In case of the feature group the feature group types must match
	 * 
	 * @param source Classifier
	 * @param dest Classifier
	 * @return true if their classifiers match
	 */
	public static boolean matchingClassifier(Classifier source, Classifier dest) {
		/*
		 * TODO the standard states that matching type only is only allowed if
		 * there is zero or one implementation It may be desirable to allow the
		 * desintation to be a type while the source specifies an implementation
		 * indicating that the recipient can handle any implementation
		 * 
		 * Currently we do match type only if one of the two side has a type
		 * only
		 */
		if (source instanceof ComponentImplementation && dest instanceof ComponentType)
			source = ((ComponentImplementation) source).getType();
		if (dest instanceof ComponentImplementation && source instanceof ComponentType)
			dest = ((ComponentImplementation) dest).getType();
		return source == dest;
	}

	// TODO: [SUBCOMPONENTS] Uncomment when
	// ComponentImplementation.getSubcomponents() is created.
	// /**
	// * checks for legal classifier substitution.
	// * The standard allows a type to be refined into one of its
	// implementations.
	// * It is also acceptable to replace a type extension if its sole purpose
	// is to make the name visible in another package and/or to add property
	// values
	// * In the future we can allow implementation replacement and type
	// substitution by refined types or extended types
	// * origin or replacement may be null.
	// * @param origin Classifier
	// * @param replacement Classifier
	// * @return true if the classifier can be substituted
	// */
	// public static boolean isokClassifierSubstitution(Classifier origin,
	// Classifier replacement) {
	// if (origin == null || replacement == null) return true;
	// if (replacement instanceof ComponentType && origin instanceof
	// ComponentType) {
	// /* Don't have to refine, could leave the type alone. Refinement
	// * statement might be changing property values or modes.
	// */
	// // ??? Do we allow replacement to be a subtype??
	// return isokTypeSubstitution((ComponentType) origin, (ComponentType)
	// replacement);
	//			
	// }
	// if (replacement instanceof ComponentImplementation && origin instanceof
	// ComponentType){
	// ComponentType reptype = ((ComponentImplementation)replacement).getType();
	// // an implementation has been added to a type
	// if (isokTypeSubstitution((ComponentType)origin,reptype)) return true;
	// } else if (replacement instanceof ComponentImplementation && origin
	// instanceof ComponentImplementation){
	// // implementations must be the same
	// if( origin == replacement ) return true;
	// if (AadlUtil.isSameOrExtends(origin, replacement)){
	// EList osubl = ((ComponentImplementation)origin).getXAllSubcomponent();
	// EList rsubl =
	// ((ComponentImplementation)replacement).getXAllSubcomponent();
	// if (osubl.size() == rsubl.size()) return true;
	// }
	// // replacement of implementation for same type or type with refined
	// properties is ok
	// if (isokTypeSubstitution(((ComponentImplementation)origin).getType(),
	// ((ComponentImplementation)replacement).getType())){
	// return true;
	// }
	// }
	// return false;
	// }

	// TODO [ASKLUTZ] Rewrite after Joe asks Lutz about
	// ComponentType.getXFeatures(boolean) and FeatureGroup.isRefined().
	// /**
	// * checks for legal type substitution.
	// * It is acceptable to replace a type extension if its sole purpose is to
	// make the name visible in another package and/or to add property values
	// * In the future we can allow type substitution by refined types or
	// extended types
	// * origin or replacement may be null.
	// * @param origin Component type
	// * @param reptype type Component type
	// * @return true if the Component type can be substituted
	// */
	// public static boolean isokTypeSubstitution(ComponentType origin,
	// ComponentType reptype) {
	// if (reptype == origin|| reptype == null) return true;
	// // an extension for the purpose of making name visible in another package
	// or refinement with only property associations
	// ComponentType repancestor = (ComponentType) reptype.getExtended();
	// if (repancestor == origin){
	// if (reptype.getXFeatures(false) == null ||
	// reptype.getXFeature().isEmpty()) return true;
	// EList fl = reptype.getXFeature();
	// for (Iterator it = fl.iterator(); it.hasNext();){
	// Feature f = (Feature)it.next();
	// if (! (f instanceof FeatureGroup)) return false;
	// if (!f.isRefined()) return false;
	// }
	// return true;
	// }
	// return false;
	// }

	// TODO: [MODEL] Uncomment after Classifier.getExtended() is created.
	// /**
	// * return true if repl is the same classifier or an extension of the
	// original
	// * @param origin Classifier
	// * @param repl Classifier
	// * @return boolean true if repl is an extension of origin
	// */
	// public static boolean isSameOrExtends(Classifier origin, Classifier
	// repl){
	// while (origin != repl) {
	// repl = repl.getXExtend();
	// if (repl == null) return false;
	// }
	// return true;
	// }

	/**
	 * extract the set of feature group connections from the list of connections
	 * 
	 * @param portconn list of port connections
	 * @return list of feature group connections
	 */
	public static EList<FeatureGroupConnection> getFeatureGroupConnection(Collection<?> portconn) {
		EList<FeatureGroupConnection> result = new BasicEList<FeatureGroupConnection>();
		for (Iterator<?> it = portconn.iterator(); it.hasNext();) {
			Object pc = it.next();
			if (pc instanceof FeatureGroupConnection) {
				result.add((FeatureGroupConnection) pc);
			}
		}
		return result;
	}

	/**
	 * Returns a list of the self-contained copies of each {@link EObject} in
	 * the given list.
	 * 
	 * @param list the list of objects to copy.
	 * @return the list of copies.
	 * @see EcoreUtil#copy(org.eclipse.emf.ecore.EObject)
	 */
	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> copyList(final List<? extends T> list) {
		if (list == null) {
			return null;
		}

		final List<T> copy = new ArrayList<T>(list.size());
		final EcoreUtil.Copier copier = new EcoreUtil.Copier();
		for (final Iterator<? extends T> i = list.iterator(); i.hasNext();) {
			copy.add((T) copier.copy(i.next()));
		}
		copier.copyReferences();
		return copy;
	}

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified list
	// of component classifiers or port group classifiers
	// * @param aobjlist
	// * @return list of packages
	// */
	// public static EList<AadlPackage> getUsedPackages(List<? extends AObject>
	// aobjlist){
	// return doGetUsedPackages(aobjlist, false);
	// }

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified list
	// of component classifiers or port group classifiers
	// * recursively consider the features in port groups
	// * @param aobjlist
	// * @return list of packages
	// */
	// public static EList<AadlPackage> getAllUsedPackages(List<? extends
	// AObject> aobjlist){
	// return doGetUsedPackages(aobjlist, true);
	// }

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified list
	// of component classifiers or port group classifiers
	// * recursively consider the features in port groups if so indicated
	// * @param aobjlist
	// * @param recurse
	// * @return list of packages
	// */
	// private static EList<AadlPackage> doGetUsedPackages(List<? extends
	// AObject> aobjlist, boolean recurse){
	// EList<AadlPackage> packagerefFound = new UniqueEList<AadlPackage>();
	// for (AObject ao : aobjlist){
	// if (ao instanceof ComponentType){
	// usedPackages(packagerefFound, (ComponentType)ao, recurse);
	// } else if (ao instanceof ComponentImplementation){
	// usedPackages(packagerefFound, (ComponentImplementation)ao);
	// } else if (ao instanceof FeatureGroupType){
	// usedPackages(packagerefFound, (FeatureGroupType)ao, recurse);
	// }
	// }
	// return packagerefFound;
	// }

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified
	// component type
	// * @param ct ComponentType
	// * @return list of packages
	// */
	// public static List<AadlPackage> getUsedPackages(ComponentType ct){
	// EList<AadlPackage> packagerefFound = new UniqueEList<AadlPackage>();
	// return usedPackages(packagerefFound,ct,false);
	// }

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified
	// component type
	// * recurseively consider the features in port groups
	// * @param ct ComponentType
	// * @return list of packages
	// */
	// public static List<AadlPackage> getAllUsedPackages(ComponentType ct){
	// EList<AadlPackage> packagerefFound = new UniqueEList<AadlPackage>();
	// return usedPackages(packagerefFound,ct,true);
	// }

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified
	// component type
	// * @param ci ComponentImpl
	// * @return list of packages
	// */
	// public static List<AadlPackage> getUsedPackages(ComponentImplementation
	// ci){
	// EList<AadlPackage> packagerefFound = new UniqueEList<AadlPackage>();
	// return usedPackages(packagerefFound,ci);
	// }

	// TODO: [ASKLUTZ] Uncomment after Joe asks Lutz about
	// Classifier.allFeatures().
	// /**
	// * get list of packages referenced by the features of the specified port
	// group type
	// * @param pgt PortGroupType
	// * @return list of packages
	// */
	// public static List<AadlPackage> getUsedPackages(FeatureGroupType pgt){
	// EList<AadlPackage> packagerefFound = new UniqueEList<AadlPackage>();
	// return usedPackages(packagerefFound,pgt, false);
	// }

	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about
	// ComponentType.allFeatures().
	// /**
	// * add packages referenced by the component type's features to the list of
	// package references
	// * @param packrefFound
	// * @param obj
	// */
	// private static List<AadlPackage> usedPackages(List<AadlPackage>
	// packrefFound, ComponentType obj, boolean recurse){
	// EList featurelist = obj.getXAllFeature();
	// for (Iterator it = featurelist.iterator(); it.hasNext();){
	// Feature f = (Feature) it.next();
	// Classifier dc = f.getXAllClassifier();
	// if (dc != null){
	// AObject root = dc.getAObjectRoot();
	// if (root instanceof AadlPackage){
	// packrefFound.add((AadlPackage)root);
	// }
	// if (recurse && dc instanceof PortGroup){
	// PortGroupType pgt = ((PortGroup)dc).getPortGroupType();
	// if (pgt != null){
	// usedPackages(packrefFound,pgt, recurse);
	// }
	// }
	// }
	// }
	// return packrefFound;
	// }

	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about
	// FeatureGroupType.allFeatures().
	// /**
	// * add packages referenced by the component type's features to the list of
	// package references
	// * @param packrefFound
	// * @param obj
	// */
	// private static List<AadlPackage> usedPackages(List<AadlPackage>
	// packrefFound, FeatureGroupType obj, boolean recurse){
	// EList featurelist = obj.getXAllFeature();
	// for (Iterator it = featurelist.iterator(); it.hasNext();){
	// Feature f = (Feature) it.next();
	// Classifier dc = f.getXAllClassifier();
	// if (dc != null){
	// AObject root = dc.getAObjectRoot();
	// if (root instanceof AadlPackage){
	// packrefFound.add((AadlPackage)root);
	// }
	// if (recurse && dc instanceof PortGroup){
	// PortGroupType pgt = ((PortGroup)dc).getPortGroupType();
	// if (pgt != null){
	// usedPackages(packrefFound,pgt, recurse);
	// }
	// }
	// }
	// }
	// return packrefFound;
	// }

	// TODO: [SUBCOMPONENTS] Rewrite after
	// ComponentImplementation.getSubcomponents() is created.
	// /**
	// * add packages referenced by the component type's features to the list of
	// package references
	// * @param packrefFound
	// * @param obj
	// */
	// private static List<AadlPackage> usedPackages(List<AadlPackage>
	// packrefFound, ComponentImplementation obj){
	// EList subcomplist = obj.getXAllSubcomponent();
	// for (Iterator it = subcomplist.iterator(); it.hasNext();){
	// Subcomponent f = (Subcomponent) it.next();
	// Classifier cc = f.getXAllClassifier();
	// if (cc != null){
	// AObject root = cc.getAObjectRoot();
	// if (root instanceof AadlPackage){
	// packrefFound.add((AadlPackage)root);
	// }
	// }
	// }
	// EList calls = obj.getXAllCallSequence();
	// for (Iterator iit = calls.iterator(); iit.hasNext();) {
	// EList calllist = ((CallSequence) iit.next()).getCall();
	// for (Iterator it = calllist.iterator(); it.hasNext();) {
	// Subcomponent sc = (Subcomponent) it.next();
	// ComponentClassifier cc = sc.getXAllClassifier();
	// if (cc != null){
	// AObject root = cc.getAObjectRoot();
	// if (root instanceof AadlPackage){
	// packrefFound.add((AadlPackage)root);
	// }
	// }
	// }
	// }
	// return packrefFound;
	// }

	/**
	 * Try to retrieve an {@link org.osate.aadl2.Element} from an object.
	 * This method is intended to be used with objects that obtained from a
	 * selection event, i.e., from the
	 * {@link org.eclipse.jface.viewers.ISelectionChangedListener#selectionChanged(org.eclipse.jface.viewers.SelectionChangedEvent)}
	 * method.
	 * <p>
	 * If the object is an Element, it is returned. Otherwise, the method tries
	 * to adapt the object to an Element. The Object could be an Element, IAdaptable, an instance model resource,
	 * or a TreeSelection of a IFile in the Navigator
	 * 
	 * @param object The object to get an Element from.
	 * @return The Element, or <code>null</code> if no Element can be obtained
	 *         from the given object.
	 */
	public static Element getElement(final Object object) {
		Element theElement = null;
		// Is it an Element?
		if (object instanceof Element) {
			theElement = (Element) object;
			if (theElement != null) return theElement;
		}
		if (object instanceof IAdaptable) {
		  theElement = (Element) ((IAdaptable) object).getAdapter(Element.class);
		  if (theElement != null) return theElement;
	    }
		if (object instanceof IResource && ((IResource)object).getFileExtension().equalsIgnoreCase(WorkspacePlugin.INSTANCE_FILE_EXT)){
			Resource res = OsateResourceUtil.getResource((IResource)object);
			EList<EObject> rl = res.getContents();
			if (rl.isEmpty()&& rl.get(0) instanceof Element) return (Element) rl.get(0);
		}
		if (object instanceof TreeSelection){
			for (Iterator iterator = ((TreeSelection)object).iterator(); iterator.hasNext();) {
				Object f = (Object) iterator.next();
				if (f instanceof IResource){
					Resource res = OsateResourceUtil.getResource((IResource)f);
					EList<EObject> rl = res.getContents();
					if (rl.isEmpty()&& rl.get(0) instanceof Element) return (Element) rl.get(0);
				}
			}
			return null;
		}
		return  null;
	}

	/**
	 * find Meta model class in meta model packages
	 * 
	 * @param classname the class name to be qualified with the package name
	 * @return String qualified class name
	 */
	public static String getQualifiedClassName(String classname) {
		EPackage pkg = EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
		if (pkg.getEClassifier(classname) != null) {
			return pkg.getName() + ":" + classname;
		}
		// TODO: [PROPERTIES] Uncomment after properties have been created.
		// pkg =
		// EPackage.Registry.INSTANCE.getEPackage(PropertyPackage.eNS_URI);
		// if (pkg.getEClassifier(classname) != null){
		// return pkg.getName()+":"+classname;
		// }
		return classname;
	}

	/**
	 * find Meta model class object in meta model packages
	 * 
	 * @param classname the class name to be found
	 * @return EClass classs object
	 */
	public static EClass findMetaModelClass(String classname) {
		Collection<Object> packages = EPackage.Registry.INSTANCE.values();
		for (Object o : packages) {
			if (o instanceof EPackage) {
				EPackage pkg = (EPackage) o;
				EClassifier ec = pkg.getEClassifier(classname);
				if (ec != null && ec instanceof EClass) {
					return (EClass) ec;
				}
			}
		}
		return null;
	}
	
	public static String getFeaturePrototypeName(FeaturePrototype ft, Element context){
		if (Aadl2Util.isNull(ft)) return "";
		return ((NamedElement)ft).getName();
	}
	
	/*
	 * for classifier figure out whether it needs to be qualified
	 * Otherwise just return name.
	 * If null or proxy return empty string
	 */
	public static String getClassifierOrLocalName(NamedElement ne, Element context){
		if (Aadl2Util.isNull(ne)) return "";
		if (ne instanceof Classifier){
			return getClassifierName((Classifier) ne, context);
		} else {
			return ((NamedElement)ne).getName();
		}
	}
	
	public static String getSubcomponentTypeName(SubcomponentType st, Element context){
		return getClassifierOrLocalName(st, context);
	}
	
	public static String getFeatureTypeName(FeatureType st, Element context){
		return getClassifierOrLocalName((NamedElement)st, context);
	}

	public static String getClassifierName(Classifier cl, Element context){
		if (Aadl2Util.isNull(cl)) return "";
		if (context instanceof Realization){
			// get the name from the stored name in implementation
			ComponentImplementation ci = (ComponentImplementation)context.getOwner();
			return ci.getTypeName();
		}
		if (cl.getElementRoot().getName().equalsIgnoreCase(context.getElementRoot().getName())){
			return cl.getName();
		} else {
			return cl.getQualifiedName();
		}
	}
	
	/**
	 * get the qualified name of an element in the property set (property definition/type/constant
	 * @param el
	 * @return
	 */
	public static String getPropertySetElementName(NamedElement el){
		NamedElement ps = (NamedElement)el.eContainer();
		if (isPredeclaredPropertySet(ps.getName())){
			return el.getName();
		} else {				
			return el.getQualifiedName();
		}

	}

	/**
	 * Find the Element whose location reference is close to the line number.
	 * 
	 * @param modelelement The model element used as root of the search
	 * @param location line number
	 * @return Element
	 */
	public static Element findElement(Element modelelement, int location) {
		return doFindElement(modelelement, location, modelelement);
	}

	/**
	 * Find an Element whose reference location is the largest less or equal to
	 * the location we are looking for. This find method cannot assume that the
	 * elements of the object model are visited in unparse order. Therefore we
	 * search the whole containment tree for the closest element whose location
	 * reference is less or equal to the desired location.
	 * 
	 * @param modelelement The model element and its sub elements to be visited
	 * @param location The location as line whose Element equivalent we are
	 *            trying to find
	 * @param closestLocation the last Element whose location reference is less
	 *            or equal than the location
	 * @return Element the last visited Element whose location reference matches
	 *         the condition
	 */
	private static Element doFindElement(Element modelelement, int location, Element closestLocation) {
		LocationReference loc = modelelement.getLocationReference();
		if (loc != null) {
			int thisline = loc.getLine();
			if (thisline > location) {
				return closestLocation;
			} else if (thisline == location) {
				return modelelement;
			} else {
				// out location is less than the desired location. Check if it
				// closer than the previously remembered location
				LocationReference closeloc = closestLocation.getLocationReference();
				if (closeloc == null) {
					closestLocation = modelelement;
				} else if (thisline > closeloc.getLine()) {
					closestLocation = modelelement;
				}
			}
		}
		EList<EObject> list = modelelement.eContents();// getChildren();
		for (Iterator<EObject> it = list.iterator(); it.hasNext();) {
			Element child = (Element) it.next();
			Element result = doFindElement(child, location, closestLocation);
			if (result != closestLocation) {
				closestLocation = result;
			}
		}
		return closestLocation;
	}

	private static final String PropertySetLabel = "propertySet[@name=";
	private static final String PackageLabel = "aadlPackage[@name=";


	// TODO: [SPECIFICATION] Consider removing or modifying.
	// /**
	// * add classifier to the name space. A name space is either an AadlSpec or
	// an AadlPackageSection or a property set
	// * @param nameSpace an AadlSpec, AadlPackageSection
	// * @param classifier
	// */
	// public static boolean addClassifier(AObject nameSpace, Classifier
	// classifier){
	// if (nameSpace instanceof AadlSpec){
	// ((AadlSpec)nameSpace).addClassifier(classifier);
	// return true;
	// }
	// if (nameSpace instanceof AadlPackageSection){
	// ((AadlPackageSection)nameSpace).addClassifier(classifier);
	// return true;
	// }
	// return false;
	// }

	// TODO: [INSTANCE] Uncomment after instances are created.
	// /**
	// * find the connection instance with src as its source and dst as its
	// destination
	// * @param src InstanceObject
	// * @param dst InstanceObject
	// * @return ConnectionInstance or null if not found
	// */
	// public static ConnectionInstance findConnectionInstance(InstanceObject
	// src, InstanceObject dst){
	// SystemInstance si = src.getSystemInstance();
	// EList cilist = si.getConnectionInstance();
	// for (Iterator it = cilist.iterator();it.hasNext();){
	// ConnectionInstance conni = (ConnectionInstance)it.next();
	// if (src == conni.getXSrc() && dst == conni.getXDst()){
	// return conni;
	// }
	// }
	// return null;
	// }
	
	public static Element getInstanceOrigin(InstanceObject io) {
		List<? extends NamedElement> el = io.getInstantiatedObjects();
		Element target = null;
		if (el.size() == 0) {
			return null;
		} else if (el.size() == 1) {
			target = el.get(0);
		} else if (el.size() > 1) {
			for (Iterator<? extends NamedElement> it = el.iterator(); it.hasNext();) {
				NamedElement o = it.next();
				if (o instanceof Connection) {
					Connection conn = (Connection)o;
					if ((conn.getAllSourceContext() instanceof Subcomponent && conn.getAllDestinationContext() instanceof Subcomponent) ||
							(conn.getAllSourceContext() == null || conn.getAllDestinationContext() == null)) {
						target = conn;
						break;
					}
				}
			}
			if (target instanceof InstanceObject) {
				target = el.get(0);
			}
		}
		return target;
	}

	// TODO: [MODEL] This method is only used to support some of the ui goto
	// actions. It is used in conjunction with
	// AObject.getReferencedObject() by the CoreEditor's
	// CoreActionBarContributor. This needs to be rethought and
	// rewritten after the model is complete. I don't like it that we have ui
	// support code in the model. However, even
	// if we don't rethink this method, it will still need to be rewritten to
	// reflect the new Aadl2 meta-model.
	// /**
	// * Does the object have a classifier reference
	// * @param obj AObject
	// * @return true of it has a classifier reference. This reference will be
	// returned by getReferencedObject
	// */
	// public static boolean hasClassifier(AObject obj){
	// return (obj instanceof Subcomponent
	// || obj instanceof DataPort || obj instanceof EventDataPort
	// || obj instanceof Parameter || obj instanceof FeatureGroup
	// || obj instanceof BusAccess || obj instanceof DataAccess
	// || obj instanceof ComponentImplementation || obj instanceof Subprogram);
	// }

	/*
	 * ================================================================ Methods
	 * for counting elements in models
	 * ================================================================
	 */

	 /**
	 * For the subtree rooted at the given node, count the number of model
	 * elements whose class extends from the given model element type. For
	 * example,
	 * 
	 * <pre>
	 * int numSubs = AadlUtil.countElementsBySubclass(root, Subcomponent.class);
	 * </pre>
	 * 
	 * @param root
	 *            The root of the subtree.
	 * @param clazz
	 *            The class to count instances of.
	 * @return The number of model elements in the given subtree that are
	 *         instances of the given class or one of its subclasses.
	 */
	public static int countElementsBySubclass(final Element root,
			final Class clazz) {
		final SimpleSubclassCounter counter = new SimpleSubclassCounter(clazz);
		counter.defaultTraversal(root);
		return counter.getCount();
	}
	// TODO: [MULTIPLESUBCLASSCOUNTER] Uncomment after MultipleSubclassCounter
	// has been moved to OSATE 2.
	// /**
	// * For the subtree rooted at the given node, count the number of model
	// * elements whose class extends from one of the given model element types.
	// * For example,
	// *
	// * <pre>
	// * int count = AadlUtil.countElementsBySubclass(root,
	// * new Class[] { DataClassifier.class, BusClassifier.class });
	// * </pre>
	// *
	// * @param root
	// * The root of the subtree.
	// * @param classes
	// * The classes to count instances of.
	// * @return The number of model elements in the given subtree whose
	// * class is, or extends from, one of the given classes.
	// */
	// public static int countElementsBySubclass(final AObject root, final
	// Class[] classes) {
	// final MultipleSubclassCounter counter = new
	// MultipleSubclassCounter(classes);
	// counter.defaultTraversal(root);
	// return counter.getCount();
	// }
	// TODO: [SIMPLEEXACTCLASSCOUNTER] Uncomment after SimpleExactClassCounter
	// has been moved to OSATE 2.
	// /**
	// * For the subtree rooted at the given node, count the number of model
	// * elements whose class is the given model element type.
	// * For example,
	// *
	// * <pre>
	// * int count = AadlUtil.countElementsExactClass(root, DataType.class);
	// * </pre>
	// *
	// * @param root
	// * The root of the subtree.
	// * @param clazz
	// * The class to count instances of.
	// * @return The number of model elements in the given subtree whose
	// * class is the given class.
	// */
	// public static int countElementsExactClass(final AObject root, final Class
	// clazz) {
	// final SimpleExactClassCounter counter = new
	// SimpleExactClassCounter(clazz);
	// counter.defaultTraversal(root);
	// return counter.getCount();
	// }
	// TODO: [MULTIPLEEXACTCLASSCOUNTER] Uncomment after
	// MultipleExactClassCounter has been moved to OSATE 2.
	// /**
	// * For the subtree rooted at the given node, count the number of model
	// * elements whose class is one of the given model element types.
	// * For example,
	// *
	// * <pre>
	// * int count = AadlUtil.countElementsBySubclass(root,
	// * new Class[] { DataType.class, BusType.class });
	// * </pre>
	// *
	// * @param root
	// * The root of the subtree.
	// * @param classes
	// * The classes to count instances of.
	// * @return The number of model elements in the given subtree whose
	// * class is one of the given classes.
	// */
	// public static int countElementsExactClass(final AObject root, final
	// Class[] classes) {
	// final MultipleExactClassCounter counter = new
	// MultipleExactClassCounter(classes);
	// counter.defaultTraversal(root);
	// return counter.getCount();
	// }
	// TODO: [SPECIFICATION] Rewrite after the new URIs have been figured out.
	// /**
	// * Returns a URI for the eObject,
	// * i.e., either
	// * the eProxyURI,
	// * the URI of the eResource with the fragment produced by the eResource,
	// * or the URI consisting of just the fragment that would be produced by a
	// default Resource
	// * with the eObject as its only contents.
	// * @param eObject the object for which to get the URI.
	// * @return the URI for the object.
	// */
	// public static URI getURI(EObject eObject)
	// {
	// // If it's a proxy, use that.
	// //
	// URI proxyURI = ((InternalEObject)eObject).eProxyURI();
	// if (proxyURI != null)
	// {
	// return proxyURI;
	// }
	// else
	// {
	// // If it is in a resource, form the URI relative to that resource.
	// //
	// EObject eRootContainer = EcoreUtil.getRootContainer(eObject);
	// Resource resource = eRootContainer.eResource();
	// if (resource != null)
	// {
	// return
	// resource.getURI().appendFragment(resource.getURIFragment(eObject));
	// }
	// else
	// {
	// // Implement the default encoding algorithm.
	// //
	// StringBuffer result = new StringBuffer("/");
	// List<String> uriFragmentPath = new ArrayList<String>();
	// for (EObject container = eObject.eContainer(); container != null;
	// container = eObject.eContainer())
	// {
	// uriFragmentPath.add(((InternalEObject)container).eURIFragmentSegment(eObject.eContainmentFeature(),
	// eObject));
	// eObject = container;
	// }
	// if (eObject instanceof NamedElement) {
	// final String objectName = ((NamedElement) eObject).getName();
	// if (objectName != null && objectName.length() > 0) {
	// String fragment = (eObject instanceof
	// AadlSpec?"aadlSpec":"systemInstance") + "[@name=" + objectName + "]";
	// uriFragmentPath.add(fragment);
	// }
	// }
	//
	//
	// int size = uriFragmentPath.size();
	// if (size > 0)
	// {
	// for (int i = size - 1;; --i)
	// {
	// result.append(uriFragmentPath.get(i));
	// if (i == 0)
	// {
	// break;
	// }
	// else
	// {
	// result.append('/');
	// }
	// }
	// }
	//
	// return URI.createURI(result.toString());
	// }
	// }
	// }
	// TODO: [INSTANCE] Uncomment after instances have been completed.
	// /**
	// * get the ComponentClassifierSelection for a component instance
	// * The selection is determined by the classifier of the subcomponent, and
	// may
	// * be overridden by a ComponentClassifierSelection property value.
	// * @return ComponentClassifier
	// */
	// public static ComponentClassifier
	// getComponentClassifierSelection(ComponentInstance ci){
	// EList<Subcomponent> target = new BasicEList<Subcomponent>();
	// Subcomponent sub = ci.getSubcomponent();
	// ComponentClassifier result =
	// sub!=null?getComponentClassifierSelection(sub.getPropertyAssociation(),target):null;
	// ci = ci.getContainingComponentInstance();
	// while (ci != null){
	// target.add(0,sub);
	// sub = ci.getSubcomponent();
	// ComponentClassifier res = null;
	// if (sub != null){
	// EList proplist = sub.getPropertyAssociation();
	// res = getComponentClassifierSelection(proplist,target);
	// }
	// if (res != null ) {
	// result = res;
	// } else {
	// ComponentImpl cimpl = ci.getXComponentImpl();
	// if (cimpl != null && cimpl.getProperties() != null){
	// res =
	// getComponentClassifierSelection(cimpl.getAllPropertyAssociation(),target);
	// if (res != null){
	// result =res;
	// }
	// }
	// }
	// ci = ci.getContainingComponentInstance();
	// }
	// return result;
	// }
	// TODO: [PROPERTIES] Uncomment after properties have been completed.
	// /**
	// * get ComponentClassifier from ComponentClassifierSelection property
	// * Find it in the property list
	// * @param proplist EList of property associations
	// * @param target subcomponent list to be matched by applies to. Empty list
	// is ok.
	// * @return ComponentClassifier
	// */
	// protected static ComponentClassifier getComponentClassifierSelection(List
	// proplist, List<Subcomponent> target){
	// if (proplist == null) return null;
	// for (Iterator it = proplist.iterator(); it.hasNext();){
	// PropertyAssociation prop = (PropertyAssociation)it.next();
	// EList applieslist = prop.getAppliesTo();
	// if (prop.getPropertyDefinition() == null) return null;
	// String propname = prop.getPropertyDefinition().getQualifiedName();
	// if (propname != null &&
	// propname.equalsIgnoreCase("SEI::ComponentClassifierSelection")){
	// if (target != null && target.equals(applieslist)){
	// EList pvlist = prop.getPropertyValue();
	// if (pvlist.size() == 1){
	// PropertyValue pv = (PropertyValue)pvlist.get(0);
	// if (pv instanceof ClassifierValue){
	// ComponentClassifier cc = ((ClassifierValue)pv).getComponentClassifier();
	// if (cc != null) return cc;
	// }
	// }
	// }
	// }
	// }
	// return null;
	// }
	// TODO: [INSTANCE] Uncomment after instances have been completed.
	// /**
	// * determine whether a component instance has subcomponents that can have
	// outgoing connections
	// * @param subcompinstances list of sub component instances
	// */
	// public static boolean hasOutgoingPortSubcomponents(EList
	// subcompinstances){
	// for (Iterator it = subcompinstances.iterator(); it.hasNext();){
	// ComponentInstance o = (ComponentInstance)it.next();
	// EList filist = o.getFeatureInstance();
	// for (Iterator fit = filist.iterator(); fit.hasNext();){
	// FeatureInstance fi = (FeatureInstance)fit.next();
	// Feature f = fi.getFeature();
	// if (isOutgoingPort(f)){
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	// TODO: [INSTANCE] Uncomment after instances have been completed.
	// /**
	// * determine whether a component instance has subcomponents that can have
	// outgoing connections
	// * @param subcompinstances list of sub component instances
	// */
	// public static boolean hasAccessSource(EList subcompinstances){
	// for (Iterator it = subcompinstances.iterator(); it.hasNext();){
	// ComponentInstance o = (ComponentInstance)it.next();
	// Subcomponent sub = o.getSubcomponent();
	// if (sub instanceof DataSubcomponent || sub instanceof BusSubcomponent){
	// return true;
	// }
	// EList filist = o.getFeatureInstance();
	// for (Iterator fit = filist.iterator(); fit.hasNext();){
	// FeatureInstance fi = (FeatureInstance)fit.next();
	// Feature f = fi.getFeature();
	// if (isOutgoingAccess(f)){
	// return true;
	// }
	// }
	// }
	// return false;
	// }
	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about ComponentAccess and
	// AccessDirection.
	// /**
	// * determine whether a feature is an outgoing access feature
	// * @param f Feature
	// * @return boolean true if outgoing
	// */
	// public static boolean isOutgoingAccess(Feature f){
	// return (f instanceof ComponentAccess &&
	// ((ComponentAccess)f).getAllDirection().equals(AccessDirection.PROVIDED_LITERAL));
	// }
	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about the difference between
	// getDirection() and getAllDirection().
	// /**
	// * determine whether the feature is an outgoing port or port group
	// * @param f Feature
	// * @return boolean true if outgoing
	// */
	// public static boolean isOutgoingPort(Feature f){
	// return (f instanceof PortFeature &&
	// ((PortFeature)f).getAllDirection().outgoing())
	// || (f instanceof FeatureGroup);
	// }
	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about the difference between
	// getDirection() and getAllDirection().
	// /**
	// * determine whether a feature can have outgoing connections
	// * @param f Feature
	// * @return boolean true if outgoing
	// */
	// public static boolean isOutgoingFeature(Feature f){
	// return (f instanceof PortFeature &&
	// ((PortFeature)f).getAllDirection().outgoing())
	// || (f instanceof FeatureGroup)
	// || (f instanceof ComponentAccess &&
	// ((ComponentAccess)f).getAllDirection().equals(AccessDirection.PROVIDED_LITERAL));
	// }
	/**
	 * determine whether a component instance has subcomponents with ports
	 * 
	 * @param subcompinstances list of sub component instances
	 */
	public static boolean hasPortComponents(ComponentImplementation compimpl) {
		if (compimpl == null) {
			return false;
		}
		EList<Subcomponent> sl = compimpl.getAllSubcomponents();
		if (sl == null)
			return false;
		for (Iterator<Subcomponent> it = sl.iterator(); it.hasNext();) {
			Subcomponent o = it.next();
			if (o instanceof SystemSubcomponent || o instanceof ProcessSubcomponent
					|| o instanceof ThreadGroupSubcomponent || o instanceof ThreadSubcomponent
					|| o instanceof DeviceSubcomponent || o instanceof ProcessorSubcomponent) {
				return true;
			}
		}
		return false;
	}

	// TODO: [FEATURECONTEXT] Rewrite after I figure out the Aadl 2 equivalent
	// of FeatureContext.
	// /**
	// * determine whether two feature context match
	// * @param firstfxt feature context
	// * @param secondfxt feature context
	// * @return boolean true if same or contained in
	// */
	// public static boolean match(FeatureContext firstfxt,FeatureContext
	// secondfxt ){
	// if (firstfxt == secondfxt) return true;
	// if (firstfxt instanceof Subcomponent && secondfxt instanceof
	// Subcomponent){
	// return AadlUtil.isSameOrRefined((Subcomponent)firstfxt,
	// (Subcomponent)secondfxt);
	// } else if (firstfxt instanceof Classifier && secondfxt instanceof
	// Classifier){
	// return AadlUtil.isSameOrExtends((Classifier)firstfxt,
	// (Classifier)secondfxt);
	// }
	// return false;
	// }

	// TODO: [INSTANCE] Uncomment after instances have been created.
	// /**
	// * determine whether two feature instances are the same or one is
	// contained in the other
	// * @param firstfi feature instance
	// * @param secondfi feature instance that may be a port group
	// * @return boolean true if same or contained in
	// */
	// public static boolean isSameOrContainedIn(FeatureInstance
	// firstfi,FeatureInstance secondfi ){
	// NamedElement cfi = firstfi;
	// while (cfi instanceof FeatureInstance){
	// if (secondfi == cfi){
	// return true;
	// }
	// cfi = (NamedElement)cfi.eContainer();
	// }
	// cfi = secondfi;
	// while (cfi instanceof FeatureInstance){
	// if (firstfi == cfi){
	// return true;
	// }
	// cfi = (NamedElement)cfi.eContainer();
	// }
	// return false;
	// }

	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about refines.
	// /**
	// * determine whether two features are the same or one is a refinement of
	// the other
	// * @param firstfi feature
	// * @param secondfi feature
	// * @return boolean true if same or refined
	// */
	// public static boolean isSameOrRefined(Feature firstfi,Feature secondfi ){
	// if (firstfi == secondfi) return true;
	// Feature cfi = firstfi;
	// while (cfi instanceof Feature){
	// if (secondfi == cfi){
	// return true;
	// }
	// cfi = (Feature)cfi.getRefinesFeature();
	// }
	// cfi = secondfi;
	// while (cfi instanceof Feature){
	// if (firstfi == cfi){
	// return true;
	// }
	// cfi = (Feature)cfi.getRefinesFeature();
	// }
	// return false;
	// }

	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about refines.
	// /**
	// * determine whether two connections are the same or one is a refinement
	// of the other
	// * @param firstconn Connection
	// * @param secondconn Connection
	// * @return boolean true if same or refined
	// */
	// public static boolean isSameOrRefined(Connection firstconn,Connection
	// secondconn ){
	// if (firstconn == secondconn) return true;
	// Connection cfi = firstconn;
	// while (cfi instanceof Connection){
	// if (secondconn == cfi){
	// return true;
	// }
	// cfi = cfi.getXRefines();
	// }
	// cfi = secondconn;
	// while (cfi instanceof Connection){
	// if (firstconn == cfi){
	// return true;
	// }
	// cfi = cfi.getXRefines();
	// }
	// return false;
	// }

	// TODO: [ASKLUTZ] Rewrite after Joe asks Lutz about refines.
	// /**
	// * determine whether two subcomponents are the same or one is a refinement
	// of the other
	// * @param firstfi subcomponent
	// * @param secondfi subcomponent
	// * @return boolean true if same or refined
	// */
	// public static boolean isSameOrRefined(Subcomponent firstfi,Subcomponent
	// secondfi ){
	// if (firstfi == secondfi) return true;
	// Subcomponent cfi = firstfi;
	// while (cfi instanceof Subcomponent){
	// if (secondfi == cfi){
	// return true;
	// }
	// cfi = (Subcomponent)cfi.getXRefines();
	// }
	// cfi = secondfi;
	// while (cfi instanceof Subcomponent){
	// if (firstfi == cfi){
	// return true;
	// }
	// cfi = (Subcomponent)cfi.getXRefines();
	// }
	// return false;
	// }

	// TODO: [INSTANCE] Uncomment after instances have been created.
	// /**
	// * determine whether two feature instances are the same or one is
	// contained in the other
	// * @param childci component instance
	// * @param parentci feature instance that may be a port group
	// * @return boolean true if same or contained in
	// */
	// public static boolean isContainedIn(ComponentInstance
	// childci,ComponentInstance parentci ){
	// NamedElement cfi = (NamedElement)childci.eContainer();
	// while (cfi instanceof ComponentInstance){
	// if (parentci == cfi){
	// return true;
	// }
	// cfi = (NamedElement)cfi.eContainer();
	// }
	// return false;
	// }

	/**
	 * make sure the parent folders exist. If not they will be created. The
	 * final/last element is not tested
	 * 
	 * @param path
	 */
	public static void makeSureFoldersExist(IPath path) {
		path = path.removeLastSegments(1);
		if (path.segmentCount() <= 1)
			return;
		IPath folderpath = path.removeFirstSegments(1);
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0)).getFolder(folderpath);
		if (!folder.exists()) {
			makeSureFoldersExist(path);
			try {
				folder.create(true, false, null);
			} catch (CoreException e) {
			}
		}
	}

	private static EList<Property> getPropertyDefinitions(final Set<PropertySet> propSets) {
		final EList<Property> result = new BasicEList<Property>();
		for (PropertySet ps : propSets) {
			result.addAll(ps.getOwnedProperties());
		}
		return result;
	}

	/**
	 * determine whether a component instance has subcomponents that can have
	 * outgoing connections
	 * 
	 * @param subcompinstances list of sub component instances
	 */
	public static boolean hasOutgoingPortSubcomponents(EList<? extends ComponentInstance> subcompinstances) {
		for (Iterator<? extends ComponentInstance> it = subcompinstances.iterator(); it.hasNext();) {
			ComponentInstance o = it.next();
			EList<FeatureInstance> filist = o.getFeatureInstances();
			for (Iterator<FeatureInstance> fit = filist.iterator(); fit.hasNext();) {
				FeatureInstance fi = fit.next();
				Feature f = fi.getFeature();
				if (isOutgoingPort(f)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * determine whether the feature is an outgoing port or feature group
	 * 
	 * @param f Feature
	 * @return boolean true if outgoing
	 */
	public static boolean isOutgoingPort(Feature f) {
		return (f instanceof Port && ((Port) f).getDirection().outgoing()) || (f instanceof FeatureGroup);
	}

	/**
	 * determine whether a component instance has subcomponents that can have
	 * outgoing connections
	 * 
	 * @param subcompinstances list of sub component instances
	 */
	public static boolean hasOutgoingFeatureSubcomponents(EList<? extends ComponentInstance> subcompinstances) {
		for (Iterator<? extends ComponentInstance> it = subcompinstances.iterator(); it.hasNext();) {
			ComponentInstance o = it.next();
			EList<FeatureInstance> filist = o.getFeatureInstances();
			for (Iterator<FeatureInstance> fit = filist.iterator(); fit.hasNext();) {
				FeatureInstance fi = fit.next();
				Feature f = fi.getFeature();
				if (isOutgoingFeature(f)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * determine whether the feature is an outgoing port or feature group
	 * 
	 * @param f Feature
	 * @return boolean true if outgoing
	 */
	public static boolean isOutgoingFeature(Feature f) {
		return (f instanceof Port && ((Port) f).getDirection().outgoing()) 
				|| (f instanceof Access )//&& ((Access) f).getKind() == AccessType.REQUIRED)
				|| (f instanceof FeatureGroup);
	}


	/**
	 * extract the set of feature group connections from the list of connections
	 * 
	 * @param portconn list of port connections
	 * @return list of feature group connections
	 */
	public static EList<FeatureGroupConnection> getPortGroupConnection(Collection<? extends Connection> portconn) {
		EList<FeatureGroupConnection> result = new BasicEList<FeatureGroupConnection>();
		for (Iterator<? extends Connection> it = portconn.iterator(); it.hasNext();) {
			Connection pc = it.next();
			if (pc instanceof FeatureGroupConnection) {
				result.add((FeatureGroupConnection) pc);
			}
		}
		return result;
	}

	/**
	 * find the connection instance with src as its source and dst as its
	 * destination
	 * 
	 * @param src InstanceObject
	 * @param dst InstanceObject
	 * @return ConnectionInstance or null if not found
	 */
	public static ConnectionInstance findConnectionInstance(InstanceObject src, InstanceObject dst) {
		SystemInstance si = src.getSystemInstance();
		EList<ConnectionInstance> cilist = si.getConnectionInstances();
		for (Iterator<ConnectionInstance> it = cilist.iterator(); it.hasNext();) {
			ConnectionInstance conni = it.next();
			if (src == conni.getSource() && dst == conni.getDestination()) {
				return conni;
			}
		}
		return null;
	}

	/**
	 * Get all property definitions that are used in the Aadl model. This
	 * includes the predeclared properties and any property definitions in user
	 * declared property sets.
	 * 
	 * @param si System Implementation
	 * @return property definitions
	 */
	public static EList<Property> getAllUsedPropertyDefinition(SystemImplementation si) {
		EList<Property> result = new UniqueEList<Property>();

		EList allUsedClassifiers = new ForAllElement().processTopDownComponentClassifier(si);
		// collect topdown component impl. do it and its type to find PA
		for (Iterator it = allUsedClassifiers.iterator(); it.hasNext();) {
			ComponentClassifier cc = (ComponentClassifier) it.next();
			addUsedPropertyDefinitions(cc, result);
		}
		return result;
	}

	/**
	 * find all property associations and add its property definition to the
	 * results
	 * 
	 * @param root Element whose subtree is being searched
	 * @param result EList holding the used property definitions
	 * @return List holding the used property definitions
	 */
	private static List<Property> addUsedPropertyDefinitions(Element root, List<Property> result) {
		TreeIterator<Element> it = EcoreUtil.getAllContents(Collections.singleton(root));
		while (it.hasNext()) {
			Element ao = it.next();
			if (ao instanceof PropertyAssociation) {
				Property pd = ((PropertyAssociation) ao).getProperty();
				if (pd != null) {
					result.add(pd);
				}
			}
		}
		return result;
	}

	/**
	 * Get all component implementations; in all anon. name spaces and from all
	 * packages (public and private parts)
	 * 
	 * @return EList of component impl
	 */
	public static EList<ComponentImplementation> getAllComponentImpl() {
		EList<ComponentImplementation> result = new BasicEList<ComponentImplementation>();
		HashSet<IFile> files = TraverseWorkspace.getAadlFilesInWorkspace();
		for (IFile file : files){
			ModelUnit target = (ModelUnit)AadlUtil.getElement(file);
			if (target != null){
				if (target instanceof AadlPackage) {
					result.addAll(getAllComponentImpl((AadlPackage) target));
				}
			}
		}
		return result;
	}

	/**
	 * Get all component implementation; in anon. name space and from all
	 * packages
	 * 
	 * @param o AadlPackage
	 * @return EList of component impl
	 */
	private static EList<ComponentImplementation> getAllComponentImpl(AadlPackage o) {
		EList<ComponentImplementation> result = new BasicEList<ComponentImplementation>();
		PackageSection psec = o.getOwnedPublicSection();
		if (psec != null) {
			for (EObject oo : psec.eContents()) {
				if (oo instanceof ComponentImplementation)
					result.add((ComponentImplementation) oo);
			}
		}
		psec = o.getPrivateSection();
		if (psec != null) {
			for (EObject oo : psec.eContents()) {
				if (oo instanceof ComponentImplementation)
					result.add((ComponentImplementation) oo);
			}
		}
		return result;
	}
	/*
	 * return the base type walking down ListTypes
	 */
	public static PropertyType getBasePropertyType(PropertyType pt){
		while (pt instanceof ListType){
			pt=((ListType)pt).getElementType();
		}
		return pt;
	}
	
	public static String getConnectionEndName(AbstractConnectionEnd end){
		if (end instanceof ConnectedElement){
			ConnectedElement ce = (ConnectedElement) end;
			Context cxt = ce.getContext();
			ConnectionEnd cend = ce.getConnectionEnd();
			if (cxt != null){
				return cxt.getName()+'.'+cend.getName();
			} else {
				return cend.getName();
			}
		} else if (end instanceof ProcessorPort || end instanceof ProcessorSubprogram){
			return "processor."+((NamedElement)end).getName();
		} else if (end instanceof InternalEvent){
			return "self."+((NamedElement)end).getName();
		}
		return "<?>";
	}

	public static String getFlowEndName(FlowEnd end){
		Context cxt = end.getContext();
		Feature cend = end.getFeature();
		if (cxt != null){
			return cxt.getName()+'.'+cend.getName();
		} else {
			return cend.getName();
		}
	}

	public static String getFlowSegmentName(FlowSegment end){
		Context cxt = end.getContext();
		FlowElement cend = end.getFlowElement();
		if (cxt != null){
			return cxt.getName()+'.'+cend.getName();
		} else {
			return cend.getName();
		}
	}
	public static String getFlowSegmentName(EndToEndFlowSegment end){
		Context cxt = end.getContext();
		EndToEndFlowElement cend = end.getFlowElement();
		if (cxt != null){
			return cxt.getName()+'.'+cend.getName();
		} else {
			return cend.getName();
		}
	}

	
	public static String getModeTransitionTriggerName(ModeTransitionTrigger end){
		if (end instanceof TriggerPort){
			TriggerPort ce = (TriggerPort) end;
			Context cxt = ce.getContext();
			Port cend = ce.getPort();
			if (cxt != null){
				return cxt.getName()+'.'+cend.getName();
			} else {
				return cend.getName();
			}
		} else if (end instanceof ProcessorPort ){
			return "processor."+((NamedElement)end).getName();
		} else if (end instanceof InternalEvent){
			return "self."+((NamedElement)end).getName();
		}
		return "<?>";
	}

	public static Classifier getContainingClassifier(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof Classifier))
			container = container.eContainer();
		return (Classifier) container;
	}

	public static PackageSection getContainingPackageSection(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof PackageSection))
			container = container.eContainer();
		return (PackageSection) container;
	}

	public static AadlPackage getContainingPackage(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof AadlPackage))
			container = container.eContainer();
		return (AadlPackage) container;
	}

	public static PropertySet getContainingPropertySet(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof PropertySet))
			container = container.eContainer();
		return (PropertySet) container;
	}

	/**
	 * get containing property set or package section
	 * if element is already top level name space return itself
	 * @param element a model element
	 * @return property set or package section
	 */
	public static Namespace getContainingTopLevelNamespace(EObject element) {
		if (element.eContainer() == null) {
			if (element instanceof Namespace) return (Namespace)element;
			return null;
		}
		EObject container = element;
		while (container != null && !(container instanceof PackageSection)
				&& !(container instanceof PropertySet))
			container = container.eContainer();
		return (Namespace) container;
	}
	
	

	/**
	 * find package name in the with clause of the containing top level name space (PackageSection or Property set) of the context.
	 * @param name Package name
	 * @param context location at which package reference is encountered
	 * @return aadl package or null if not in import list
	 */
	public static AadlPackage findImportedPackage(String name, Namespace context) {
		EList<ModelUnit> imports;
		if (name == null) return null;
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
						&& name.equalsIgnoreCase(((AadlPackage) imported).getName()))
					return (AadlPackage) imported;
		// TODO need to handle public section declared in a separate package
		// declaration
		return null;
	}

	/**
	 * check whether package is in the with clause of the containing top level name space (PackageSection or Property set) of the context.
	 * @param pack Aadl Package 
	 * @param context location at which package reference is encountered
	 * @return ture if found
	 */
	public static boolean isImportedPackage(AadlPackage pack, Namespace context) {
		EList<ModelUnit> imports;
		if (pack == null) return false;
		if (context instanceof PropertySet)
			imports = ((PropertySet) context).getImportedUnits();
		else
			imports = ((PackageSection) context).getImportedUnits();
		for (ModelUnit imported : imports) {
			if (imported instanceof AadlPackage && !imported.eIsProxy()) {
				if (imported.getName().equalsIgnoreCase(pack.getName()))
					return true;
			}
		}
		if (context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null)
			for (ModelUnit imported : ((AadlPackage) context.eContainer())
					.getOwnedPublicSection().getImportedUnits())
				if (imported instanceof AadlPackage && !imported.eIsProxy()
						&& imported.getName().equalsIgnoreCase(pack.getName()))
					return true;
		// TODO need to handle public section declared in a separate package
		// declaration
		return false;
	}


	/**
	 * find property set name in the with clause of the containing top level name space (PackageSection or Property set) of the context.
	 * @param name Property set name
	 * @param context location at which property set reference is encountered
	 * @return aadl property set or null if not in import list
	 */
	public static PropertySet findImportedPropertySet(String name,
			EObject context) {
		EList<ModelUnit> importedPropertySets;
		if (name == null) return null;
		context = AadlUtil.getContainingTopLevelNamespace(context);
		if (context instanceof PropertySet)
			importedPropertySets = ((PropertySet) context).getImportedUnits();
		else
			importedPropertySets = ((PackageSection) context).getImportedUnits();
		for (ModelUnit importedPropertySet : importedPropertySets)
			if (importedPropertySet instanceof PropertySet && !importedPropertySet.eIsProxy()
					&& name.equalsIgnoreCase(((PropertySet) importedPropertySet).getName()))
				return (PropertySet) importedPropertySet;
		return null;
	}

	/**
	 * check whether property set is in the with clause of the containing top level name space (PackageSection or Property set) of the context.
	 * @param ps Property set 
	 * @param context location at which property set reference is encountered
	 * @return aadl property set or null if not in import list
	 */
	public static boolean isImportedPropertySet(PropertySet ps,
			EObject context) {
		EList<ModelUnit> importedPropertySets;
		if (ps == null) return false;
		if (isPredeclaredPropertySet(ps.getName())) return true;
		context = AadlUtil.getContainingTopLevelNamespace(context);
		if (context instanceof PropertySet)
			importedPropertySets = ((PropertySet) context).getImportedUnits();
		else
			importedPropertySets = ((PackageSection) context).getImportedUnits();
		for (ModelUnit importedPropertySet : importedPropertySets)
			if (importedPropertySet instanceof PropertySet && !importedPropertySet.eIsProxy()
					&& importedPropertySet == ps)
				return true;
		return false;
	}
	

	/*
	 * retrieve all annex subclauses of a given name that belong to a Classifier.
	 * The list contains the subclause (if any) of the classifier and the subclause of any classifier being extended.
	 * Note that each classifier can only have one 
	 */
	public static EList<AnnexSubclause> getAllAnnexSubclauses(Classifier cl,String annexName) {
		final EList<AnnexSubclause> result = new BasicEList<AnnexSubclause>();
		final EList<Classifier> classifiers = cl.getAllExtendPlusSelf();
		for (final ListIterator<Classifier> i = classifiers.listIterator(classifiers.size()); i.hasPrevious();) {
			final Classifier current = i.previous();
			EList<AnnexSubclause> asclist = AadlUtil.findAnnexSubclause(current,annexName);
			result.addAll(asclist);
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	/**
	 * returns all subclauses whose names match. Note that a classifier can have multiple subclauses of the same annex if each subclause is mode specific.
	 * @param annexName
	 * @param c
	 * @return EList<AnnexSubclause>
	 */
	public static EList<AnnexSubclause> findAnnexSubclause(Classifier c, String annexName){
		return (EList)findNamedElementsInList(c.getOwnedAnnexSubclauses(), annexName);
	}

	public static AnnexLibrary findPublicAnnexLibrary(AadlPackage p, String annexName){
		PackageSection ps = p.getOwnedPublicSection();
		AnnexLibrary res = null;
		if (ps != null){
			res = (AnnexLibrary)findNamedElementInList(ps.getOwnedAnnexLibraries(), annexName);
		}
		return res;
	}
	
	public static AnnexLibrary findPrivateAnnexLibrary( AadlPackage p,String annexName){
		PackageSection ps = p.getOwnedPrivateSection();
		AnnexLibrary res = null;
		if (ps != null){
			res = (AnnexLibrary)findNamedElementInList(ps.getOwnedAnnexLibraries(), annexName);
		}
		return res;
	}

}