/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file).
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

/*
 * Created on Jun 9, 2004
 *
 * Static utility methods
 */
package org.osate.aadl2.modelsupport.util;

import static org.osate.aadl2.ComponentCategory.BUS;
import static org.osate.aadl2.ComponentCategory.DATA;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM;
import static org.osate.aadl2.ComponentCategory.SUBPROGRAM_GROUP;
import static org.osate.aadl2.ComponentCategory.VIRTUAL_BUS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.AbstractSubcomponent;
import org.osate.aadl2.Access;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.ArraySize;
import org.osate.aadl2.ArraySizeProperty;
import org.osate.aadl2.ArrayableElement;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.aadl2.DeviceSubcomponent;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.EndToEndFlowElement;
import org.osate.aadl2.EndToEndFlowSegment;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupConnection;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.FeaturePrototype;
import org.osate.aadl2.FeatureType;
import org.osate.aadl2.FlowElement;
import org.osate.aadl2.FlowEnd;
import org.osate.aadl2.FlowImplementation;
import org.osate.aadl2.FlowSegment;
import org.osate.aadl2.FlowSpecification;
import org.osate.aadl2.IntegerLiteral;
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
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.Realization;
import org.osate.aadl2.RefinableElement;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SubcomponentType;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.ThreadGroupSubcomponent;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.TriggerPort;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.aadl2.modelsupport.modeltraversal.SimpleSubclassCounter;
import org.osate.aadl2.modelsupport.modeltraversal.TraverseWorkspace;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.aadl2.parsesupport.AObject;
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
		PREDECLARED_PROPERTY_SET_NAMES = Collections.unmodifiableSet(predeclaredPropertySetNames);
	}

	public static Set<String> getPredeclaredPropertySetNames() {
		return PREDECLARED_PROPERTY_SET_NAMES;
	}

	public static boolean isPredeclaredPropertySet(String psname) {
		for (String predeclaredPSName : PREDECLARED_PROPERTY_SET_NAMES) {
			if (predeclaredPSName.equalsIgnoreCase(psname)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * find (first) Named Element matching name in the Elist; any elements that
	 * are not NamedElements are skipped.
	 *
	 * @param el Collection of NamedElements
	 * @param name String
	 * @return NamedElement
	 */
	public static NamedElement findNamedElementInList(Collection<?> el, String name) {
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
	 * find (first) Named Element matching name in the Elist; any elements that
	 * are not NamedElements are skipped.
	 *
	 * @param el Collection of NamedElements
	 * @param name String
	 * @return NamedElement
	 */
	public static NamedElement findNamedElementInList(Collection<?> el, String name, long idx) {
		if (el != null) {
			Iterator<?> it = el.iterator();

			while (it.hasNext()) {
				Object o = it.next();

				if (o instanceof NamedElement) {
					String n = ((NamedElement) o).getName();

					if (n != null && n.length() > 0 && name.equalsIgnoreCase(n)) {
						if (o instanceof FeatureInstance) {
							if (((FeatureInstance) o).getIndex() == 0 || ((FeatureInstance) o).getIndex() == idx) {
								return (NamedElement) o;
							}
						} else {
							return (NamedElement) o;
						}
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
	public static EList<NamedElement> findDoubleNamedElementsInList(Collection<?> el) {
		EList<NamedElement> result = new BasicEList<NamedElement>();
		final Set<String> seen = new HashSet<String>();

		if (el != null) {
			for (Object obj : el) {
				if (obj instanceof NamedElement) {
					final NamedElement lit = (NamedElement) obj;
					String name = lit.getName();
					if (name != null && !name.isEmpty()) {
						name = name.toLowerCase();
						if (!seen.add(name)) {
							result.add(lit);
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
		for (ModalElement cs : list) {
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
		return !(!AadlUtil.findDoubleNamedElementsInList(modeset).isEmpty() || noModeSet > 1
				|| (noModeSet > 0 && !allModes.isEmpty() && modeset.containsAll(allModes)));

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
	// * Get all component classifiers that are visible from the given Element.
	// * This includes all globally visible component classifiers;
	// * if aobj is null, then only the global component classifiers are
	// returned.
	// * if the Element aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the Element is in the proviate part of a package, also
	// includes the classifiers defined in the private part
	// * @param aobj Element
	// * @return EList of component classifiers
	// */
	// public static EList getAllVisibleComponentClassifiers(Element aobj,
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
	// Element nameSpace = aobj.getContainingClassifierNameSpace();
	// if (nameSpace instanceof AadlPrivate){
	// result.addAll(((AadlPrivate)nameSpace).getComponentClassifier(compCat));
	// }
	// return result;
	// }

	// TODO: [PROPERTIES] Uncomment after the class ComponentCategory is added
	// to the model.
	// /**
	// * Get all component types that are visible from the given Element.
	// * This includes all globally visible component types;
	// * if aobj is null, then only the global component types are returned.
	// * if the Element aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the Element is in the proviate part of a package, also
	// includes the types defined in the private part
	// * @param aobj Element
	// * @return EList of component types
	// */
	// public static EList<ComponentType> getAllVisibleComponentTypes(Element
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
	// Element.
	// * This includes all globally visible component implementations;
	// * if aobj is null, then only the global component implementations are
	// returned.
	// * if the Element aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the Element is in the proviate part of a package, also
	// includes the types defined in the private part
	// * @param aobj Element
	// * @return EList of component implementations
	// */
	// public static EList<ComponentImplementation>
	// getAllVisibleComponentImpls(Element aobj, ComponentCategory compCat){
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
	// * Get all Port Group Types that are visible from the given Element.
	// * This includes all globally visible component classifiers;
	// * if aobj is null, then only the global component classifiers are
	// returned.
	// * if the Element aobj is in an AadlSpec that is not a global package,
	// also includes those
	// * in the anon name space or in packages local to the aadl spec
	// * Finally, if the Element is in the proviate part of a package, also
	// includes the classifiers defined in the private part
	// * @param aobj Element
	// * @return EList of port group type
	// */
	// public static EList getAllVisiblePortGroupTypes(Element aobj){
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
	// Element nameSpace = aobj.getContainingClassifierNameSpace();
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
	// * {@link ResourceUtil#findPropertySet(String, Element)}.
	// */
	// public static EList<PropertyDefinition> getAllPropertyDefinition(final
	// Element context) {
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
	// ForAllElement().processTopDownComponentClassifier(si);
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
	// * @param root Element whose subtree is being searched
	// * @param result EList holding the used property definitions
	// * @return List holding the used property definitions
	// */
	// private static List<PropertyDefinition>
	// addUsedPropertyDefinitions(Element root, List<PropertyDefinition>
	// result){
	// TreeIterator<Element> it =
	// EcoreUtil.getAllContents(Collections.singleton(root));
	// while(it.hasNext()){
	// Element ao = it.next();
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

		return implName.substring(0, implName.length() - "Implementation".length())
				.equals(specName.substring(0, specName.length() - "Specification".length()));
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

		return implName.substring(0, implName.length() - "Implementation".length())
				.equals(typeName.substring(0, typeName.length() - "Type".length()));
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

		return subName.substring(0, subName.length() - "Subcomponent".length()).equals(cName.substring(0,
				cName.length() - (c instanceof ComponentImplementation ? "Implementation" : "Type").length()));
	}

	// TODO: [NAMESPACE] Rewrite with the new namespace scheme.
	// /**
	// * Removes packagename if current package
	// * @param o that contains the classsifier reference
	// * @param str
	// * @return String without package name
	// */
	// public static String ownPackage(Element o, String str){
	// Element ns = o.getContainingClassifierNameSpace();
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
	// public static Classifier findClassifierInNameSpace(Element fromNS,
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
	// private static EObject[] getNamespace(Element fromNS, String pkgName) {
	// EObject[] ns = new EObject[2];
	// Element thepack = fromNS;
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

	// TODO: [FORALLElement] Uncomment when ForAllElement is fixed.
	// /**
	// * get a sorted list of component classifier declaratations
	// * It is sorted such that subcomponents in component implementations refer
	// to
	// * previously declared component types or implementations
	// * @param aobj
	// * @return list of component classifiers
	// */
	// public static EList<ComponentClassifier>
	// getDeclarationOrderedComponentClassifiers(Element aobj){
	// final EList<ComponentClassifier> uniqueClassifiers = new
	// UniqueEList<ComponentClassifier>();
	// final EList topDownList;
	// if (aobj instanceof ComponentImplementation) {
	// topDownList = new
	// ForAllElement().processTopDownComponentImpl((ComponentImplementation)
	// aobj);
	// } else {
	// topDownList = new ForAllElement().processTopDownComponentImpl();
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
		if (source instanceof ComponentImplementation && dest instanceof ComponentType) {
			source = ((ComponentImplementation) source).getType();
		}
		if (dest instanceof ComponentImplementation && source instanceof ComponentType) {
			dest = ((ComponentImplementation) dest).getType();
		}
		return source == dest;
	}

	/**
	 * checks for legal classifier substitution.
	 * The standard allows a type to be refined into one of its
	 implementations.
	 * It is also acceptable to replace a type extension if its sole purpose
	 is to make the name visible in another package and/or to add property
	 values
	 * In the future we can allow implementation replacement and type
	 substitution by refined types or extended types
	 * origin or replacement may be null.
	 * @param origin Classifier
	 * @param replacement Classifier
	 * @return true if the classifier can be substituted
	 */
	public static boolean isokClassifierSubstitutionMatch(Classifier origin, Classifier replacement) {
		if (origin == null || replacement == null) {
			return true;
		}
		if (replacement instanceof FeatureGroupType && origin instanceof FeatureGroupType) {
			/*
			 * Don't have to refine, could leave the type alone. Refinement
			 * statement might be changing property values or modes.
			 */
			// ??? Do we allow replacement to be a subtype??
			return isokTypeClassifierMatch((FeatureGroupType) origin, (FeatureGroupType) replacement);

		}
		if (replacement instanceof ComponentType && origin instanceof ComponentType) {
			/*
			 * Don't have to refine, could leave the type alone. Refinement
			 * statement might be changing property values or modes.
			 */
			// ??? Do we allow replacement to be a subtype??
			return isokTypeClassifierMatch((ComponentType) origin, (ComponentType) replacement);

		}
		if (replacement instanceof ComponentImplementation && origin instanceof ComponentType) {
			ComponentType reptype = ((ComponentImplementation) replacement).getType();
			// an implementation has been added to a type
			if (isokTypeClassifierMatch((ComponentType) origin, reptype)) {
				return true;
			}
		} else if (replacement instanceof ComponentImplementation && origin instanceof ComponentImplementation) {
			// implementations must be for the same type
			ComponentType origtype = ((ComponentImplementation) origin).getType();
			ComponentType reptype = ((ComponentImplementation) replacement).getType();
			if (isokTypeClassifierMatch(origtype, reptype)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * checks for legal classifier substitution.
	 * The standard allows a type to be refined into one of its
	 implementations.
	 * It is also acceptable to replace a type extension if its sole purpose
	 is to make the name visible in another package and/or to add property
	 values
	 * In the future we can allow implementation replacement and type
	 substitution by refined types or extended types
	 * origin or replacement may be null.
	 * @param origin Classifier
	 * @param replacement Classifier
	 * @return true if the classifier can be substituted
	 */
	public static boolean isokClassifierSubstitutionTypeExtension(Classifier origin, Classifier replacement) {
		if (origin == null || replacement == null) {
			return true;
		}
		if (replacement instanceof FeatureGroupType && origin instanceof FeatureGroupType) {
			/*
			 * Don't have to refine, could leave the type alone. Refinement
			 * statement might be changing property values or modes.
			 */
			return isSameOrExtends(origin, replacement);

		}
		if (replacement instanceof ComponentType && origin instanceof ComponentType) {
			/*
			 * Don't have to refine, could leave the type alone. Refinement
			 * statement might be changing property values or modes.
			 */
			return isSameOrExtends(origin, replacement);

		}
		if (replacement instanceof ComponentImplementation && origin instanceof ComponentType) {
			ComponentType reptype = ((ComponentImplementation) replacement).getType();
			// an implementation has been added to a type
			return isSameOrExtends(origin, reptype);
		} else if (replacement instanceof ComponentImplementation && origin instanceof ComponentImplementation) {
			// implementations must be for the same type
			ComponentType origtype = ((ComponentImplementation) origin).getType();
			ComponentType reptype = ((ComponentImplementation) replacement).getType();
			return isSameOrExtends(origtype, reptype);
		}
		return false;
	}

	/**
	 * checks for legal type substitution.
	 * origin or replacement may be null.
	 * @param origin Component type
	 * @param reptype type Component type
	 * @return true if the Component type can be substituted
	 */
	public static boolean isokTypeClassifierMatch(ComponentType origin, ComponentType reptype) {
		return reptype == null || reptype == origin;
	}

	public static boolean isokTypeClassifierMatch(FeatureGroupType origin, FeatureGroupType reptype) {
		if (reptype == origin || reptype == null) {
			return true;
		}
		// an extension for the purpose of making name visible in another package
		// or refinement with only property associations
		FeatureGroupType repancestor = reptype.getExtended();
		if (repancestor == origin) {
			if (reptype.getOwnedFeatures() == null || reptype.getOwnedFeatures().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * return true if repl is the same classifier or an extension of the
	 original
	 * @param origin Classifier
	 * @param extension Classifier
	 * @return boolean true if repl is an extension of origin
	 */
	public static boolean isSameOrExtends(Classifier origin, Classifier extension) {

		/**
		 * If we have a feature group that is inverse, we have no clue to find
		 * if this is an extension because we cannot "extends" another
		 * type. So, we try to find the extension by using the inverse type.
		 */
//		if ((origin instanceof FeatureGroupType) && (((FeatureGroupType) origin).getInverse() != null)) {
//			origin = ((FeatureGroupType) origin).getInverse();
//		}
//
//		if ((extension instanceof FeatureGroupType) && (((FeatureGroupType) extension).getInverse() != null)) {
//			extension = ((FeatureGroupType) extension).getInverse();
//		}
//
//		while (origin != extension) {
//			extension = extension.getExtended();
//			if (extension == null) {
//				return false;
//			}
//		}
		Classifier ext = extension;
		int i = 0;
		while (ext != null && i < 100) {
			if (origin == ext) {
				return true;
			}
			ext = ext.getExtended();
			i++;
		}
		if (extension instanceof FeatureGroupType && origin instanceof FeatureGroupType) {
			if (extension.getExtended() == null && ((FeatureGroupType) extension).getInverse() != null
					&& ((FeatureGroupType) origin).getInverse() != null) {
				ext = ((FeatureGroupType) extension).getInverse();
				FeatureGroupType orig = ((FeatureGroupType) origin).getInverse();
				i = 0;
				while (ext != null && i < 100) {
					if (orig == ext) {
						return true;
					}
					ext = ext.getExtended();
					i++;
				}
			}
		}
		return false;
	}

	/**
	 * Returns {@code true} if {@code extension} is an extension of {@code origin} or {@code extension} is a
	 * {@link ComponentImplementation} and it's {@link ComponentType} is an extension of {@code origin}.
	 */
	public static boolean isSubClassifier(Classifier origin, Classifier extension) {
		if (origin instanceof ComponentType && extension instanceof ComponentImplementation) {
			return isSameOrExtends(origin, ((ComponentImplementation) extension).getType());
		} else {
			return isSameOrExtends(origin, extension);
		}
	}

	/**
	 * return true if repl is the same Subcomponent or a refinement of the
	 original
	 * @param origin RefinableElement
	 * @param refinement RefinableElement
	 * @return boolean true if repl is an extension of origin
	 */
	public static boolean isSameOrRefines(RefinableElement origin, RefinableElement refinement) {
		while (origin != refinement) {
			refinement = refinement.getRefinedElement();
			if (refinement == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * extract the set of feature group connections from the list of connections
	 *
	 * @param portconn list of port connections
	 * @return list of feature group connections
	 */
	public static EList<FeatureGroupConnection> getFeatureGroupConnection(Collection<?> portconn) {
		EList<FeatureGroupConnection> result = new BasicEList<FeatureGroupConnection>();
		for (Object pc : portconn) {
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
		for (T name : list) {
			copy.add((T) copier.copy(name));
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
	// public static EList<AadlPackage> getUsedPackages(List<? extends Element>
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
	// Element> aobjlist){
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
	// Element> aobjlist, boolean recurse){
	// EList<AadlPackage> packagerefFound = new UniqueEList<AadlPackage>();
	// for (Element ao : aobjlist){
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
	// Element root = dc.getElementRoot();
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
	// Element root = dc.getElementRoot();
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
	// Element root = cc.getElementRoot();
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
	// Element root = cc.getElementRoot();
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
			if (theElement != null) {
				return theElement;
			}
		}
		if (object instanceof IAdaptable) {
			theElement = ((IAdaptable) object).getAdapter(Element.class);
			if (theElement != null) {
				return theElement;
			}
		}
		if (object instanceof IFile
				&& WorkspacePlugin.INSTANCE_FILE_EXT.equalsIgnoreCase(((IFile) object).getFileExtension())) {
			Resource res = new ResourceSetImpl().getResource(OsateResourceUtil.toResourceURI((IResource) object), true);
			EList<EObject> rl = res.getContents();
			if (!rl.isEmpty() && rl.get(0) instanceof Element) {
				return (Element) rl.get(0);
			}
		}
		if (object instanceof IFile
				&& WorkspacePlugin.SOURCE_FILE_EXT.equalsIgnoreCase(((IFile) object).getFileExtension())) {
			Resource res = new ResourceSetImpl().getResource(OsateResourceUtil.toResourceURI((IResource) object), true);
			EList<EObject> rl = res.getContents();

			if (!rl.isEmpty() && rl.get(0) instanceof LazyLinkingResource) {
				if ((((LazyLinkingResource) rl.get(0)).getContents().size() > 0)
						&& (((LazyLinkingResource) rl.get(0)).getContents().get(0) instanceof Element)) {
					theElement = (Element) ((LazyLinkingResource) rl.get(0)).getContents().get(0);

					return theElement;
				}

			}
			if (!rl.isEmpty() && rl.get(0) instanceof Element) {

				theElement = (Element) rl.get(0);

				return theElement;

			}
		}
		if (object instanceof TreeSelection) {
			for (Iterator<?> iterator = ((TreeSelection) object).iterator(); iterator.hasNext();) {
				Object f = iterator.next();
				if (f instanceof IResource) {
					URI uri = OsateResourceUtil.toResourceURI((IResource) f);
					Resource res = new ResourceSetImpl().getResource(uri, true);
					EList<EObject> rl = res.getContents();
					if (!rl.isEmpty() && rl.get(0) instanceof Element) {
						return (Element) rl.get(0);
					}
				}
			}
			return null;
		}
		if (object instanceof EObjectURIWrapper) {
			EObjectURIWrapper wrapper = (EObjectURIWrapper) object;
			EObject eObject = new ResourceSetImpl().getEObject(wrapper.getUri(), true);
			if (eObject instanceof Element) {
				return (Element) eObject;
			}
		}
		return null;
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

	public static String getFeaturePrototypeName(FeaturePrototype ft, Element context) {
		if (Aadl2Util.isNull(ft)) {
			return "";
		}
		return ((NamedElement) ft).getName();
	}

	/*
	 * for classifier figure out whether it needs to be qualified
	 * Otherwise just return name.
	 * If null or proxy return empty string
	 */
	public static String getClassifierOrLocalName(NamedElement ne, Element context) {
		if (Aadl2Util.isNull(ne)) {
			return "";
		}
		if (ne instanceof Classifier) {
			return getClassifierName((Classifier) ne, context);
		} else {
			return ne.getName();
		}
	}

	public static String getSubcomponentTypeName(SubcomponentType st, Element context) {
		return getClassifierOrLocalName(st, context);
	}

	public static String getFeatureTypeName(FeatureType st, Element context) {
		return getClassifierOrLocalName((NamedElement) st, context);
	}

	public static String getClassifierName(Classifier cl, Element context) {
		if (Aadl2Util.isNull(cl)) {
			return "";
		}
		if (context instanceof Realization) {
			// get the name from the stored name in implementation
			ComponentImplementation ci = (ComponentImplementation) context.getOwner();
			return ci.getTypeName();
		}
		if (cl.getElementRoot().getName().equalsIgnoreCase(context.getElementRoot().getName())) {
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
	public static String getPropertySetElementName(NamedElement el) {
		NamedElement ps = (NamedElement) el.eContainer();
		if (isPredeclaredPropertySet(ps.getName())) {
			return el.getName();
		} else {
			return el.getQualifiedName();
		}

	}

//	/**
//	 * Find the Element whose location reference is close to the line number.
//	 *
//	 * @param modelelement The model element used as root of the search
//	 * @param location line number
//	 * @return Element
//	 */
//	public static Element findElement(Element modelelement, int location) {
//		return doFindElement(modelelement, location, modelelement);
//	}
//
//	/**
//	 * Find an Element whose reference location is the largest less or equal to
//	 * the location we are looking for. This find method cannot assume that the
//	 * elements of the object model are visited in unparse order. Therefore we
//	 * search the whole containment tree for the closest element whose location
//	 * reference is less or equal to the desired location.
//	 *
//	 * @param modelelement The model element and its sub elements to be visited
//	 * @param location The location as line whose Element equivalent we are
//	 *            trying to find
//	 * @param closestLocation the last Element whose location reference is less
//	 *            or equal than the location
//	 * @return Element the last visited Element whose location reference matches
//	 *         the condition
//	 */
//	private static Element doFindElement(Element modelelement, int location, Element closestLocation) {
//		LocationReference loc = modelelement.getLocationReference();
//		if (loc != null) {
//			int thisline = loc.getLine();
//			if (thisline > location) {
//				return closestLocation;
//			} else if (thisline == location) {
//				return modelelement;
//			} else {
//				// out location is less than the desired location. Check if it
//				// closer than the previously remembered location
//				LocationReference closeloc = closestLocation.getLocationReference();
//				if (closeloc == null) {
//					closestLocation = modelelement;
//				} else if (thisline > closeloc.getLine()) {
//					closestLocation = modelelement;
//				}
//			}
//		}
//		EList<EObject> list = modelelement.eContents();//getOwnedElements();		for (Iterator<Element> it = list.iterator(); it.hasNext();) {
//		for (Iterator<EObject> it = list.iterator(); it.hasNext();) {
//			Element child = (Element) it.next();
//			Element result = doFindElement(child, location, closestLocation);
//			if (result != closestLocation) {
//				closestLocation = result;
//			}
//		}
//		return closestLocation;
//	}
//
//	private static final String PropertySetLabel = "propertySet[@name=";
//	private static final String PackageLabel = "aadlPackage[@name=";

	public static Element getInstanceOrigin(InstanceObject io) {
		List<? extends NamedElement> el = io.getInstantiatedObjects();
		Element target = null;
		if (el.size() == 0) {
			return null;
		} else if (el.size() == 1) {
			target = el.get(0);
		} else if (el.size() > 1) {
			for (NamedElement o : el) {
				if (o instanceof Connection) {
					Connection conn = (Connection) o;
					if ((conn.getAllSourceContext() instanceof Subcomponent
							&& conn.getAllDestinationContext() instanceof Subcomponent)
							|| (conn.getAllSourceContext() == null || conn.getAllDestinationContext() == null)) {
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
	public static int countElementsBySubclass(final Element root, final Class<?> clazz) {
		final SimpleSubclassCounter counter = new SimpleSubclassCounter(clazz);
		counter.defaultTraversal(root);
		return counter.getCount();
	}

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
		if (sl == null) {
			return false;
		}
		for (Subcomponent o : sl) {
			if (o instanceof AbstractSubcomponent || o instanceof SystemSubcomponent || o instanceof ProcessSubcomponent
					|| o instanceof ThreadGroupSubcomponent || o instanceof ThreadSubcomponent
					|| o instanceof DeviceSubcomponent || o instanceof ProcessorSubcomponent) {
				return true;
			}
		}
		return false;
	}

	/**
	 * make sure the parent folders exist. If not they will be created. The
	 * final/last element is not tested
	 *
	 * @param path
	 */
	public static void makeSureFoldersExist(IPath path) {
		path = path.removeLastSegments(1);
		if (path.segmentCount() <= 1) {
			return;
		}
		IPath folderpath = path.removeFirstSegments(1);
		IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getProject(path.segment(0)).getFolder(folderpath);
		if (!folder.exists()) {
			makeSureFoldersExist(path);
			try {
				folder.create(true, true, null);
			} catch (CoreException e) {
			}
		}
	}

	/**
	 * determine whether a component instance has subcomponents that can have
	 * outgoing connections
	 *
	 * @param subcompinstances list of sub component instances
	 */
	public static boolean hasOutgoingPortSubcomponents(EList<? extends ComponentInstance> subcompinstances) {
		for (ComponentInstance o : subcompinstances) {
			EList<FeatureInstance> filist = o.getFeatureInstances();
			for (FeatureInstance fi : filist) {
				Feature f = fi.getFeature();
				if (isOutgoingPort(f)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * determine whether a feature instance has outgoing features
	 * will examine feature groups recursively
	 *
	 * @param fi FeatureInstance of a feature or feature group
	 */
	public static boolean hasOutgoingFeatures(FeatureInstance fi) {
		EList<FeatureInstance> filist = fi.getFeatureInstances();
		if (filist.isEmpty()) {
			// feature or feature group without features
			if (!fi.getFlowDirection().equals(DirectionType.IN)) {
				return true;
			}
		} else {
			for (FeatureInstance subfi : filist) {
				if (hasOutgoingFeatures(subfi)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get ingoing connections to subcomponents from a specified feature of the
	 * component impl
	 *
	 * @param feature component impl feature that is the source of a connection
	 * @param context the outer feature (feature group) or null
	 * @return EList connections with feature as source
	 */
	public static EList<Connection> getIngoingConnections(ComponentImplementation cimpl, Feature feature) {
		return getIngoingConnections(cimpl, feature, c -> true);
	}

	/**
	 * Get ingoing connections to subcomponents from a specified feature of the
	 * component impl
	 *
	 * @param feature component impl feature that is the source of a connection
	 * @param context the outer feature (feature group) or null
	 * @param useConnection Predicate that indicates if the connection should be added to the result.  Each ingoing
	 * connection is tested before being added to the result.  This predicate should return <code>true</code> if the
	 * connection should be added to the result.
	 * @return EList connections with feature as source
	 * @since 2.0
	 */
	public static EList<Connection> getIngoingConnections(ComponentImplementation cimpl, Feature feature,
			Predicate<Connection> useConnection) {
		EList<Connection> result = new BasicEList<Connection>();
		// The local feature could be a refinement of the feature through which the connection enters the component
		Feature local = (Feature) cimpl.findNamedElement(feature.getName());
		List<Feature> features = local.getAllFeatureRefinements();
		EList<Connection> cimplconns = cimpl.getAllConnections();
		for (Connection conn : cimplconns) {
			if (features.contains(conn.getAllSource()) && !(conn.getAllSourceContext() instanceof Subcomponent)
					|| (conn.isAllBidirectional() && features.contains(conn.getAllDestination())
							&& !(conn.getAllDestinationContext() instanceof Subcomponent))) {
				if (useConnection.test(conn)) {
					result.add(conn);
				}
			}
			if ((features.contains(conn.getAllSourceContext())
					|| (conn.isAllBidirectional() && features.contains(conn.getAllDestinationContext())))) {
				if (useConnection.test(conn)) {
					result.add(conn);
				}
			}
		}
		return result;
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
		for (ComponentInstance o : subcompinstances) {
			EList<FeatureInstance> filist = o.getFeatureInstances();
			for (FeatureInstance fi : filist) {
				Feature f = fi.getFeature();
				if (isOutgoingFeature(f)) {
					return true;
				}
			}
			// subcomponent can be access source
			ComponentCategory cat = o.getCategory();
			if (cat == DATA || cat == BUS || cat == VIRTUAL_BUS || cat == SUBPROGRAM || cat == SUBPROGRAM_GROUP) {
				return true;
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
		return (f instanceof Port && ((Port) f).getDirection().outgoing()) || (f instanceof Access)// && ((Access) f).getKind() == AccessType.REQUIRED)
				|| (f instanceof FeatureGroup)
				|| (f instanceof AbstractFeature && ((AbstractFeature) f).getDirection().outgoing());
	}

	/**
	 * determine whether the feature is an outgoing port or feature group
	 *
	 * @param f Feature
	 * @return boolean true if incoming
	 */
	public static boolean isIncomingFeature(Feature f) {
		return (f instanceof Port && ((Port) f).getDirection().incoming()) || (f instanceof Access)// && ((Access) f).getKind() == AccessType.REQUIRED)
				|| (f instanceof FeatureGroup)
				|| (f instanceof AbstractFeature && ((AbstractFeature) f).getDirection().incoming());
	}

	/**
	 * extract the set of feature group connections from the list of connections
	 *
	 * @param portconn list of port connections
	 * @return list of feature group connections
	 */
	public static EList<FeatureGroupConnection> getPortGroupConnection(Collection<? extends Connection> portconn) {
		EList<FeatureGroupConnection> result = new BasicEList<FeatureGroupConnection>();
		for (Connection pc : portconn) {
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
		Iterable<ConnectionInstance> it = src.allEnclosingConnectionInstances();
		for (ConnectionInstance conni : it) {
			if (src == conni.getSource() && dst == conni.getDestination()) {
				return conni;
			}
		}
		return null;
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
		for (IFile file : files) {
			ModelUnit target = (ModelUnit) AadlUtil.getElement(file);
			if (target != null) {
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
	public static EList<ComponentImplementation> getAllComponentImpl(AadlPackage o) {
		EList<ComponentImplementation> result = new BasicEList<ComponentImplementation>();
		PackageSection psec = o.getOwnedPublicSection();
		if (psec != null) {
			for (EObject oo : psec.getOwnedElements()) {
				if (oo instanceof ComponentImplementation) {
					result.add((ComponentImplementation) oo);
				}
			}
		}
		psec = o.getPrivateSection();
		if (psec != null) {
			for (EObject oo : psec.getOwnedElements()) {
				if (oo instanceof ComponentImplementation) {
					result.add((ComponentImplementation) oo);
				}
			}
		}
		return result;
	}

	/*
	 * return the base type walking down ListTypes
	 */
	public static PropertyType getBasePropertyType(PropertyType pt) {
		while (pt instanceof ListType) {
			pt = ((ListType) pt).getElementType();
		}
		return pt;
	}

	public static String getConnectionEndName(ConnectedElement ce) {
		Context cxt = ce.getContext();
		ConnectionEnd cend = ce.getConnectionEnd();
		if (cxt != null) {
			return cxt.getName() + '.' + cend.getName();
		} else {
			return cend.getName();
		}
	}

	public static String getFlowEndName(FlowEnd end) {
		Context cxt = end.getContext();
		Feature cend = end.getFeature();
		if (cxt != null) {
			return cxt.getName() + '.' + cend.getName();
		} else {
			return cend.getName();
		}
	}

	public static String getFlowSegmentName(FlowSegment end) {
		Context cxt = end.getContext();
		FlowElement cend = end.getFlowElement();
		if (cxt != null) {
			return cxt.getName() + '.' + cend.getName();
		} else {
			return cend.getName();
		}
	}

	public static String getFlowSegmentName(EndToEndFlowSegment end) {
		Context cxt = end.getContext();
		EndToEndFlowElement cend = end.getFlowElement();
		if (cxt != null) {
			return cxt.getName() + '.' + cend.getName();
		} else {
			return cend.getName();
		}
	}

	public static String getModeTransitionTriggerName(ModeTransitionTrigger end) {
		Context cxt = end.getContext();
		TriggerPort ce = end.getTriggerPort();
		if (cxt != null) {
			return cxt.getName() + '.' + ce.getName();
		} else {
			return ce.getName();
		}
	}

	public static NamedElement getContainingAnnex(EObject obj) {
		while (obj != null) {
			if (obj instanceof AnnexLibrary || obj instanceof AnnexSubclause) {
				return (NamedElement) obj;
			}
			obj = obj.eContainer();
		}
		return null;
	}

	/**
	 * get containing Classifier. If the object is already a classifier, return it
	 * @param element
	 * @return
	 */
	public static Classifier getContainingClassifier(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof Classifier)) {
			container = container.eContainer();
		}
		return (Classifier) container;
	}

	public static Classifier getContainingSubcomponentClassifier(EObject element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof Subcomponent) {
				return ((Subcomponent) container).getAllClassifier();
			}
			container = container.eContainer();
		}
		return null;
	}

	public static FeatureGroup getContainingFeatureGroup(EObject element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof FeatureGroup) {
				return (FeatureGroup) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public static SubprogramCall getContainingSubprogramCall(EObject element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof SubprogramCall) {
				return (SubprogramCall) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public static Feature getContainingFeature(EObject element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof Feature) {
				return (Feature) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public static Subcomponent getContainingSubcomponent(EObject element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof Subcomponent) {
				return (Subcomponent) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public static PropertyAssociation getContainingPropertyAssociation(EObject element) {
		EObject container = element;
		while (container != null) {
			if (container instanceof PropertyAssociation) {
				return (PropertyAssociation) container;
			}
			container = container.eContainer();
		}
		return null;
	}

	public static PackageSection getContainingPackageSection(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof PackageSection)) {
			container = container.eContainer();
		}
		return (PackageSection) container;
	}

	public static AadlPackage getContainingPackage(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof AadlPackage)) {
			container = container.eContainer();
		}
		return (AadlPackage) container;
	}

	public static PropertySet getContainingPropertySet(EObject element) {
		EObject container = element;
		while (container != null && !(container instanceof PropertySet)) {
			container = container.eContainer();
		}
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
			if (element instanceof Namespace) {
				return (Namespace) element;
			}
			return null;
		}
		EObject container = element;
		while (container != null && !(container instanceof PackageSection) && !(container instanceof PropertySet)) {
			container = container.eContainer();
		}
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
		if (name == null || context == null) {
			return null;
		}
		if (context instanceof PropertySet) {
			imports = ((PropertySet) context).getImportedUnits();
		} else {
			imports = ((PackageSection) context).getImportedUnits();
		}
		for (ModelUnit imported : imports) {
			if (imported instanceof AadlPackage && !imported.eIsProxy()) {
				String n = ((AadlPackage) imported).getName();
				if (name.equalsIgnoreCase(n)) {
					return (AadlPackage) imported;
				}
			}
		}
		if (context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null) {
			for (ModelUnit imported : ((AadlPackage) context.eContainer()).getOwnedPublicSection().getImportedUnits()) {
				if (imported instanceof AadlPackage && !imported.eIsProxy()
						&& name.equalsIgnoreCase(((AadlPackage) imported).getName())) {
					return (AadlPackage) imported;
				}
			}
		}
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
		if (pack == null) {
			return false;
		}
		if (context instanceof PropertySet) {
			imports = ((PropertySet) context).getImportedUnits();
		} else {
			imports = ((PackageSection) context).getImportedUnits();
		}
		for (ModelUnit imported : imports) {
			if (imported instanceof AadlPackage && !imported.eIsProxy()) {
				if (imported.getName().equalsIgnoreCase(pack.getName())) {
					return true;
				}
			}
		}
		if (context instanceof PrivatePackageSection
				&& ((AadlPackage) context.eContainer()).getOwnedPublicSection() != null) {
			for (ModelUnit imported : ((AadlPackage) context.eContainer()).getOwnedPublicSection().getImportedUnits()) {
				if (imported instanceof AadlPackage && !imported.eIsProxy()
						&& imported.getName().equalsIgnoreCase(pack.getName())) {
					return true;
				}
			}
		}
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
	public static PropertySet findImportedPropertySet(String name, EObject context) {
		EList<ModelUnit> importedPropertySets;
		if (name == null) {
			return null;
		}
		context = AadlUtil.getContainingTopLevelNamespace(context);
		if (context instanceof PropertySet) {
			importedPropertySets = ((PropertySet) context).getImportedUnits();
		} else {
			importedPropertySets = ((PackageSection) context).getImportedUnits();
		}
		for (ModelUnit importedPropertySet : importedPropertySets) {
			if (importedPropertySet instanceof PropertySet && !importedPropertySet.eIsProxy()
					&& name.equalsIgnoreCase(((PropertySet) importedPropertySet).getName())) {
				return (PropertySet) importedPropertySet;
			}
		}
		return null;
	}

	/**
	 * check whether property set is in the with clause of the containing top level name space (PackageSection or Property set) of the context.
	 * @param ps Property set
	 * @param context location at which property set reference is encountered
	 * @return aadl property set or null if not in import list
	 */
	public static boolean isImportedPropertySet(PropertySet ps, EObject context) {
		EList<ModelUnit> importedPropertySets;
		if (ps == null) {
			return false;
		}
		if (isPredeclaredPropertySet(ps.getName())) {
			return true;
		}
		context = AadlUtil.getContainingTopLevelNamespace(context);
		if (context instanceof PropertySet) {
			importedPropertySets = ((PropertySet) context).getImportedUnits();
		} else {
			importedPropertySets = ((PackageSection) context).getImportedUnits();
		}

		for (ModelUnit importedPropertySet : importedPropertySets) {
			if (importedPropertySet instanceof PropertySet && !importedPropertySet.eIsProxy()
					&& (importedPropertySet == ps
							|| (ps.getQualifiedName().equalsIgnoreCase(importedPropertySet.getQualifiedName())))) {
				return true;
			}
		}
		return false;
	}

	public static boolean isComplete(ConnectionInstance conni) {
		ConnectionInstanceEnd srcEnd = conni.getSource();
		ConnectionInstanceEnd dstEnd = conni.getDestination();
		ComponentInstance src = null;
		if (srcEnd instanceof ComponentInstance) {
			src = (ComponentInstance) srcEnd;
		} else if (srcEnd instanceof FeatureInstance) {
			src = srcEnd.getContainingComponentInstance();
		}
		ComponentInstance dst = null;
		if (dstEnd instanceof ComponentInstance) {
			dst = (ComponentInstance) dstEnd;
		} else if (dstEnd instanceof FeatureInstance) {
			dst = dstEnd.getContainingComponentInstance();
		}
		if (containedIn(src, dst) || containedIn(dst, src)) {
			return false;
		}
		return true;
	}

	public static boolean containedIn(InstanceObject element, ComponentInstance parent) {
		while (element != null) {
			if (element == parent) {
				return true;
			}
			element = (InstanceObject) element.getOwner();
		}
		return false;
	}

	public static IPath getResourcePath(NamedElement component) {
		Resource res = component.eResource();
		URI uri = res.getURI();
		IPath path = OsateResourceUtil.toIFile(uri).getFullPath();
		return path.removeLastSegments(1);
	}

	/**
	 * get the line number for a given model object in the core model
	 * This method makes use of the Xtext parse tree.
	 * @return line number or zero
	 */
	public static int getLineNumberFor(EObject obj) {
		if (obj == null) {
			return 0;
		}
		if (obj instanceof AObject) {
			LocationReference locref = ((AObject) obj).getLocationReference();
			if (locref != null) {
				return locref.getLine();
			}
		}
		INode node = NodeModelUtils.findActualNodeFor(obj);
		if (node != null) {
			return node.getStartLine();
		} else {
			EObject defaultannex = getContainingDefaultAnnex(obj);
			if (defaultannex != null) {
				node = NodeModelUtils.findActualNodeFor(obj);
				if (node != null) {
					return node.getStartLine();
				}
			}
		}
		return 0;
	}

	/**
	 * find the enclosing default annex subclause of library, otherwise return null
	 * @param obj
	 * @return
	 */
	public static EObject getContainingDefaultAnnex(EObject obj) {
		EObject res = obj;
		while (res != null && !(res instanceof DefaultAnnexSubclause) && !(res instanceof DefaultAnnexLibrary)) {
			res = res.eContainer();
		}
		return res;
	}

	public static PropertyAssociation findOwnedPropertyAssociation(NamedElement ne, String propName) {
		EList<PropertyAssociation> res = ne.getOwnedPropertyAssociations();
		for (PropertyAssociation propertyAssociation : res) {
			String pname = propertyAssociation.getProperty().getFullName();
			if (propName.equalsIgnoreCase(pname)) {
				return propertyAssociation;
			}
		}
		return null;
	}

	public static PropertyAssociation findOwnedPropertyAssociation(NamedElement ne, Property def) {
		EList<PropertyAssociation> res = ne.getOwnedPropertyAssociations();
		for (PropertyAssociation propertyAssociation : res) {
			Property pdef = propertyAssociation.getProperty();
			if (pdef.getFullName().equalsIgnoreCase(def.getFullName())) {
				return propertyAssociation;
			}
		}
		return null;
	}

	/*
	 * return the size of an arrayed named element.
	 * Find the array dimensions in the element or the element it refines.
	 */
	public static long getMultiplicity(NamedElement el) {
		if (!(el instanceof ArrayableElement)) {
			return 1;
		}
		ArrayableElement ae = (ArrayableElement) el;
		EList<ArrayDimension> dims = ae.getArrayDimensions();
		if (!dims.isEmpty()) {
			return calcSize(dims);
		} else {
			if (el instanceof Subcomponent) {
				Subcomponent sub = (Subcomponent) el;
				EList<Subcomponent> subs = sub.getAllSubcomponentRefinements();
				for (Subcomponent subcomponent : subs) {
					dims = subcomponent.getArrayDimensions();
					if (!dims.isEmpty()) {
						return calcSize(dims);
					}
				}
			} else if (el instanceof Feature) {
				Feature fe = (Feature) el;
				EList<Feature> feas = fe.getAllFeatureRefinements();
				for (Feature feature : feas) {
					dims = feature.getArrayDimensions();
					if (!dims.isEmpty()) {
						return calcSize(dims);
					}
				}
			}
		}
		return 1;
	}

	/*
	 * compute the size of the specified array
	 */
	public static long calcSize(EList<ArrayDimension> dims) {
		long size = 1;
		for (ArrayDimension dim : dims) {
			ArraySize asize = dim.getSize();
			size = size * getElementCount(asize);
		}
		return size;
	}

	public static long getElementCount(ArraySize as, ComponentInstance ci) {
		return getElementCount(as);
	}

	public static long getElementCount(ArraySize as) {
		long result = 0L;
		if (as == null) {
			return result;
		}
		if (as.getSizeProperty() == null) {
			result = as.getSize();
		} else {
			ArraySizeProperty asp = as.getSizeProperty();
			PropertyConstant pc = (PropertyConstant) asp;
			PropertyExpression cv = pc.getConstantValue();
			if (cv instanceof IntegerLiteral) {
				result = ((IntegerLiteral) cv).getValue();
			}
		}
		return result;
	}

	public static boolean isOutgoingConnection(Connection conn) {
		return conn.getAllSourceContext() instanceof Subcomponent
				&& !(conn.getAllDestinationContext() instanceof Subcomponent);
	}

	public static boolean isIncomingConnection(Connection conn) {
		return !(conn.getAllSourceContext() instanceof Subcomponent)
				&& (conn.getAllDestinationContext() instanceof Subcomponent);
	}

}
