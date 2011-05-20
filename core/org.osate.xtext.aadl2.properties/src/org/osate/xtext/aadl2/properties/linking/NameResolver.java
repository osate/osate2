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
package org.osate.xtext.aadl2.properties.linking;

import java.io.IOException;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototype;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.ComponentPrototypeReference;

import org.osate.aadl2.ComponentReference;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupPrototype;
import org.osate.aadl2.FeatureGroupPrototypeBinding;
import org.osate.aadl2.FeatureGroupReference;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.Generalization;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Namespace;
import org.osate.aadl2.PackageRename;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Port;
import org.osate.aadl2.PortConnection;
import org.osate.aadl2.PortConnectionEnd;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PropertySet;
import org.osate.aadl2.Prototype;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemSubcomponent;
import org.osate.aadl2.FeatureGroupPrototypeReference;


public class NameResolver
{
	private final Aadl2Package aadl2Package = Aadl2Factory.eINSTANCE.getAadl2Package();
	
	
	
//	public static Context findPortConnectionSourceContextReference(PortConnection connection, String contextName)
//	{
//		EObject searchResult = getContainingClassifier(connection).findNamedElement(contextName);
//		if (searchResult instanceof FeatureGroup || searchResult instanceof Subcomponent || searchResult instanceof DataPort ||
//				searchResult instanceof EventDataPort)
//		{
//			return((Context)searchResult);
//		}
//		return null;
//	}
//	

	public static ConnectionEnd findPortConnectionEnd(PortConnection conn, Context cxt, String portName)
	{
		if (cxt == null)
		{
			EObject searchResult = ((ComponentImplementation)getContainingClassifier(conn)).findNamedElement(portName);
			if (searchResult instanceof Port)
				return ((ConnectionEnd)searchResult);
		}
		else if (cxt instanceof FeatureGroup)
		{
			FeatureGroup featureGroup = (FeatureGroup)cxt;
			while (featureGroup.getFeatureGroupType() == null && featureGroup.getPrototype() == null &&
					featureGroup.getRefined() instanceof FeatureGroup)
			{
				featureGroup = (FeatureGroup)featureGroup.getRefined();
			}
			if (featureGroup.getFeatureGroupType() != null)
			{
				NamedElement searchResult = featureGroup.getFeatureGroupType().findNamedElement(portName);
				if (searchResult instanceof PortConnectionEnd)
					 return((PortConnectionEnd)searchResult);
			}
			else if (featureGroup.getPrototype() != null)
			{
				FeatureGroupType featureGroupType = findFeatureGroupTypeForFeatureGroupPrototype(getContainingClassifier(conn),
						(FeatureGroupPrototype)featureGroup.getPrototype());
				if (featureGroupType != null)
				{
					NamedElement searchResult = featureGroupType.findNamedElement(portName);
					if (searchResult instanceof PortConnectionEnd)
						return((PortConnectionEnd)searchResult);
				}
			}
		}
		else if (cxt instanceof Subcomponent)
		{
			Subcomponent subcomponent = (Subcomponent)cxt;
			while (subcomponent.getClassifier() == null && subcomponent.getPrototype() == null && subcomponent.getRefined() != null)
				subcomponent = subcomponent.getRefined();
			if (subcomponent.getClassifier() != null)
			{
				EObject searchResult = subcomponent.getClassifier().findNamedElement(portName);
				if (searchResult instanceof ConnectionEnd)
					return ((ConnectionEnd)searchResult);
			}
			else if (subcomponent.getPrototype() != null)
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(getContainingClassifier(conn),
						subcomponent.getPrototype());
				if (classifier != null)
				{
					NamedElement searchResult = classifier.findNamedElement(portName);
					if (searchResult instanceof DataSubcomponent)
						return((DataSubcomponent)searchResult);
				}
			}
		}
		else if (cxt instanceof DataPort || cxt instanceof EventDataPort)
			//connection.getContext() is a DataPort or EventDataPort
		{
			Feature context = (Port)cxt;
			while (context.getClassifier() == null && context.getPrototype() == null && context.getRefined() != null)
				context = context.getRefined();
			if (context.getClassifier() != null)
			{
				NamedElement searchResult = context.getClassifier().findNamedElement(portName);
				if (searchResult instanceof DataSubcomponent)
					return((DataSubcomponent)searchResult);
			}
			else if (context.getPrototype() instanceof ComponentPrototype)
			{
				ComponentClassifier classifier = findClassifierForComponentPrototype(getContainingClassifier(conn),
						(ComponentPrototype)context.getPrototype());
				if (classifier != null)
				{
					NamedElement searchResult = classifier.findNamedElement(portName);
					if (searchResult instanceof DataSubcomponent)
						return((DataSubcomponent)searchResult);
				}
			}
		}
		return null;
	}
	
//	private static String reconstructPath(List<ContainmentPathElement> path)
//	{
//		if (path.size() == 0)
//			throw new IllegalArgumentException("path cannot be an empty list.");
//		StringBuilder pathAsString = new StringBuilder(path.get(0).getNamedElement().getName());
//		for (int i = 1; i < path.size(); i++)
//		{
//			pathAsString.append('.');
//			pathAsString.append(path.get(i).getNamedElement().getName());
//		}
//		return pathAsString.toString();
//	}
	
	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * 				 ComponentPrototypeRefinementReference.
	 * 		Based on the type of containingClassifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 												   RealizationReference, FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.  Example:
	 * 
	 * abstract a
	 * prototypes
	 *   p1: subprogram group;
	 *   p2: subprogram group;
	 * end a;
	 * 
	 * abstract implementation a.i (
	 *          p1 => p2,
	 *          p2 => p1)
	 * subcomponents
	 *   sub: subprogram group p1;
	 * calls
	 *   sequence1: {
	 *     call1: subprogram sub.access_feature_1;
	 * end a.i;
	 * 
	 * This will cause a stack overflow!
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(Classifier containingClassifier, ComponentPrototype prototype)
	{
		//TODO: Need to check that the prototype binding is a component prototype binding.  In PrototypeFormalReference,
		//		we should check that component prototypes are bound by component prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding)findPrototypeBinding(containingClassifier, prototype);
		if (binding != null && binding.getActuals().size() >= 1)
		{
			if (binding.getActuals().get(0) instanceof ComponentReference)
				return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
			else //It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(containingClassifier,
						((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null)
		{
			//TODO: Need to check that the component prototype refines a component prototype.
			//		This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype)prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}
	
	/**
	 * Dependencies: PrototypeFormalReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * 				 ComponentPrototypeRefinementReference.
	 * 		Based on the type of classifierPrototypeContext: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 														 RealizationReference, FeatureGroupTypeExtendReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
	private static ComponentClassifier findClassifierForComponentPrototype(Classifier classifierPrototypeContext,
			Subcomponent subcomponentPrototypeContext, ComponentPrototype prototype)
	{
		//TODO: Need to check that the prototype binding is a component prototype binding.  In PrototypeFormalReference,
		//		we should check that component prototypes are bound by component prototype bindings.
		ComponentPrototypeBinding binding = (ComponentPrototypeBinding)findPrototypeBinding(classifierPrototypeContext,
				subcomponentPrototypeContext, prototype);
		if (binding != null && binding.getActuals().size() >= 1)
		{
			if (binding.getActuals().get(0) instanceof ComponentReference)
				return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
			else //It is a ComponentPrototypeReference
			{
				ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(classifierPrototypeContext,
						subcomponentPrototypeContext, ((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
				if (classifierForReferencedPrototype != null)
					return classifierForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null)
		{
			//TODO: Need to check that the component prototype refines a component prototype.
			//		This should be done in ComponentPrototypeRefinementReference.
			prototype = (ComponentPrototype)prototype.getRefined();
		}
		if (prototype.getConstrainingClassifier() != null)
			return prototype.getConstrainingClassifier();
		else
			return null;
	}
	
	/**
	 * Dependencies: PrototypeFormalReference, ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 				 RealizationReference, ClassifierReference, PrototypeOrClassifierReference, ComponentPrototypeClassifierReference,
	 * 				 ComponentPrototypeRefinementReference.
	 */
	/*
	 * TODO: Check for circular dependencies with prototypes.
	 */
//	private static ComponentClassifier findClassifierForComponentPrototype(Classifier topLevelClassifier, List<Subcomponent> subcomponents,
//			ComponentPrototype prototype)
//	{
//		if (subcomponents.size() == 1)
//		{
//			ComponentPrototypeBinding binding = (ComponentPrototypeBinding)findPrototypeBinding(topLevelClassifier, prototype);
//			if (binding != null && binding.getActuals().size() >= 1)
//			{
//				if (binding.getActuals().get(0) instanceof ComponentReference)
//					return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
//				else //It is a ComponentPrototypeReference
//				{
//					ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(topLevelClassifier,
//							subcomponents, ((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
//					if (classifierForReferencedPrototype != null)
//						return classifierForReferencedPrototype;
//				}
//			}
//		}
//		else
//		{
//			ComponentPrototypeBinding binding =
//				(ComponentPrototypeBinding)findPrototypeBinding(getContainingClassifier(subcomponents.get(subcomponents.size() - 1)),
//						prototype);
//			if (binding != null && binding.getActuals().size() >= 1)
//			{
//				if (binding.getActuals().get(0) instanceof ComponentReference)
//					return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
//				else //It is a ComponentPrototypeReference
//				{
//					ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(topLevelClassifier,
//							subcomponents, ((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
//					if (classifierForReferencedPrototype != null)
//						return classifierForReferencedPrototype;
//				}
//			}
//			else
//			{
//				binding = (ComponentPrototypeBinding)findPrototypeBinding(subcomponents.get(subcomponents.size() - 2), prototype);
//				if (binding != null)
//				{
//					if (binding.getActuals().get(0) instanceof ComponentReference)
//						return ((ComponentReference)binding.getActuals().get(0)).getClassifier();
//					else //It is a ComponentPrototypeReference
//					{
//						ComponentClassifier classifierForReferencedPrototype = findClassifierForComponentPrototype(topLevelClassifier,
//								subcomponents.subList(0, subcomponents.size() - 1),
//								((ComponentPrototypeReference)binding.getActuals().get(0)).getPrototype());
//						if (classifierForReferencedPrototype != null)
//							return classifierForReferencedPrototype;
//					}
//				}
//			}
//		}
//		while (prototype.getConstrainingClassifier() == null && prototype.getRefined() != null)
//		{
//			//TODO: Need to check that the component prototype refines a component prototype.
//			//		This should be done in ComponentPrototypeRefinementReference.
//			prototype = (ComponentPrototype)prototype.getRefined();
//		}
//		if (prototype.getConstrainingClassifier() != null)
//			return prototype.getConstrainingClassifier();
//		else
//			return null;
//	}
	
	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
	 * 				 FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference.
	 * 		Based on the type of containingClassifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 												   RealizationReference, FeatureGroupTypeExtendReference.
	 */
	//TODO: Check for circular dependencies with prototypes.
	private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(Classifier containingClassifier,
			FeatureGroupPrototype prototype)
	{
		//TODO: Need to check that the prototype binding is a feature group prototype binding.  In PrototypeFormalReference,
		//		we should check that feature group prototypes are bound by feature group prototype bindings.
		FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding)findPrototypeBinding(containingClassifier, prototype);
		if (binding != null)
		{
			if (binding.getActual() instanceof FeatureGroupReference)
				return ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
			else //It is a FeatureGroupPrototypeReference
			{
				FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(containingClassifier,
						((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
				if (featureGroupTypeForReferencedPrototype != null)
					return featureGroupTypeForReferencedPrototype;
			}
		}
		while (prototype.getConstrainingFeatureGroupType() == null && prototype.getRefined() != null)
		{
			//TODO: Need to check that the feature group prototype refines a feature group prototype.
			//		This should be done in FeatureGroupPrototypeRefinementReference.
			prototype = (FeatureGroupPrototype)prototype.getRefined();
		}
		if (prototype.getConstrainingFeatureGroupType() != null)
			return prototype.getConstrainingFeatureGroupType();
		else
			return null;
	}
	
	/**
	 * Dependencies: PrototypeFormalReference, FeatureGroupTypeReference, PrototypeOrFeatureGroupTypeReference,
	 * 				 FeatureGroupPrototypeClassifierReference, FeatureGroupPrototypeRefinementReference.
	 * 		Based on the type of topLevelClassifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 												 RealizationReference, FeatureGroupTypeExtendReference.
	 */
	//TODO: Check for circular dependencies with prototypes.
//	private static FeatureGroupType findFeatureGroupTypeForFeatureGroupPrototype(Classifier topLevelClassifier,
//			List<StructuralFeature> subcomponentsAndFeatureGroups, FeatureGroupPrototype prototype)
//	{
//		if (subcomponentsAndFeatureGroups.size() == 1)
//		{
//			FeatureGroupPrototypeBinding binding = (FeatureGroupPrototypeBinding)findPrototypeBinding(topLevelClassifier, prototype);
//			if (binding != null)
//			{
//				if (binding.getActual() instanceof FeatureGroupReference)
//					return ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
//				else //It is a FeatureGroupPrototypeReference
//				{
//					FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(topLevelClassifier,
//							subcomponentsAndFeatureGroups, ((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
//					if (featureGroupTypeForReferencedPrototype != null)
//						return featureGroupTypeForReferencedPrototype;
//				}
//			}
//		}
//		else
//		{
//			FeatureGroupPrototypeBinding binding =
//				(FeatureGroupPrototypeBinding)findPrototypeBinding(
//						getContainingClassifier(subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() - 1)), prototype);
//			if (binding != null)
//			{
//				if (binding.getActual() instanceof FeatureGroupReference)
//					return ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
//				else //It is a FeatureGroupPrototypeReference
//				{
//					FeatureGroupType featureGroupTypeForReferencedPrototype = findFeatureGroupTypeForFeatureGroupPrototype(topLevelClassifier,
//							subcomponentsAndFeatureGroups, ((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
//					if (featureGroupTypeForReferencedPrototype != null)
//						return featureGroupTypeForReferencedPrototype;
//				}
//			}
//			else if (subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() - 2) instanceof Subcomponent)
//			{
//				binding = (FeatureGroupPrototypeBinding)findPrototypeBinding(
//						(Subcomponent)subcomponentsAndFeatureGroups.get(subcomponentsAndFeatureGroups.size() - 2), prototype);
//				if (binding != null)
//				{
//					if (binding.getActual() instanceof FeatureGroupReference)
//						return ((FeatureGroupReference)binding.getActual()).getFeatureGroupType();
//					else //It is a FeatureGroupPrototypeReference
//					{
//						FeatureGroupType featureGroupTypeForReferencedPrototype =
//							findFeatureGroupTypeForFeatureGroupPrototype(topLevelClassifier,
//									subcomponentsAndFeatureGroups.subList(0, subcomponentsAndFeatureGroups.size() - 1),
//									((FeatureGroupPrototypeReference)binding.getActual()).getPrototype());
//						if (featureGroupTypeForReferencedPrototype != null)
//							return featureGroupTypeForReferencedPrototype;
//					}
//				}
//			}
//		}
//		while (prototype.getConstrainingFeatureGroupType() == null && prototype.getRefined() != null)
//			prototype = (FeatureGroupPrototype)prototype.getRefined();
//		if (prototype.getConstrainingFeatureGroupType() != null)
//			return prototype.getConstrainingFeatureGroupType();
//		else
//			return null;
//	}
	
	public static AadlPackage findImportedPackage(String name, EObject context)
	{
		EList<AadlPackage> imports;
		if (context instanceof PropertySet)
			imports = ((PropertySet)context).getImportedPackages();
		else
			imports = ((PackageSection)context).getImportedPackages();
		for (AadlPackage imported : imports){
			String n = ((AadlPackage)imported).getName();
			if (name.equalsIgnoreCase(n))
				return (AadlPackage)imported;
		}
		if (context instanceof PrivatePackageSection && ((AadlPackage)context.eContainer()).getOwnedPublicSection() != null)
			for (AadlPackage imported : ((AadlPackage)context.eContainer()).getOwnedPublicSection().getImportedPackages())
				if (imported instanceof AadlPackage && ((AadlPackage)imported).getName().equalsIgnoreCase(name))
					return (AadlPackage)imported;
		// TODO need to handle public section declared in a separate package declaration
		return null;
	}
	
	private static PropertySet findImportedPropertySet(String name, EObject context)
	{
		EList<PropertySet> importedPropertySets;
		if (context instanceof PropertySet)
			importedPropertySets = ((PropertySet)context).getImportedPropertySets();
		else
			importedPropertySets = ((PackageSection)context).getImportedPropertySets();
		for (PropertySet importedPropertySet : importedPropertySets)
			if (importedPropertySet instanceof PropertySet&&((PropertySet)importedPropertySet).getName().equalsIgnoreCase(name))
				return (PropertySet)importedPropertySet;
		return null;
	}
	
	public static PackageSection getContainingPackageSection(EObject element)
	{
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PackageSection))
			container = container.eContainer();
		return (PackageSection)container;
	}
	
	public static PropertySet getContainingPropertySet(EObject element)
	{
		EObject container = element.eContainer();
		while (container != null  && !(container instanceof PropertySet))
			container = container.eContainer();
		return (PropertySet)container;
	}
	
	private static Namespace getContainingTopLevelNamespace(EObject element)
	{
		EObject container = element.eContainer();
		while (container != null && !(container instanceof PackageSection) && !(container instanceof PropertySet))
			container = container.eContainer();
		return (Namespace)container;
	}
	
	private static Namespace getContainingNamespace(EObject element)
	{
		EObject container = element.eContainer();
		while (container != null && !(container instanceof Namespace))
			container = container.eContainer();
		return (Namespace)container;
	}
	
//	private static PropertyAssociation getContainingPropertyAssociation(ContainmentPathElement pathElement)
//	{
//		EObject container = pathelement.eContainer();
//		while (container != null && !(container instanceof PropertyAssociation))
//			container = container.eContainer();
//		return (PropertyAssociation)container;
//	}
	
	/**
	 * Converts the first character of the String s to upper case and converts all other characters to lower case.
	 * This is used to make messages to the user look nice.
	 */
	private static String capitalizeFirstLetterOnly(String s)
	{
		StringBuilder builder = new StringBuilder(s.toLowerCase());
		builder.setCharAt(0, Character.toUpperCase(builder.charAt(0)));
		return builder.toString();
	}
	
	/**
	 * Search for a {@link NamedElement} in a package.  If {@code context} is a {@link PublicPackageSection}, then this
	 * method will search through the {@link PublicPackageSection} only.  If {@code context} is a
	 * {@link PrivatePackageSection}, then this method will search through the {@link PrivatePackageSection} and its
	 * corresponding {@link PublicPackageSection}.  This is different from
	 * {@link PrivatePackageSection#findNamedElement(String)} and
	 * {@link PrivatePackageSection#findNamedElement(String, boolean)} because those methods will not search through
	 * the corresponding {@link PublicPackageSection}.  This method does use
	 * {@link PackageSection#findNamedElement(String, boolean)}, so it will search for {@link ComponentType}s and
	 * {@link FeatureGroupType}s in the renames statements.
	 * 
	 * Dependencies: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 * 
	 * @param name The name of the {@link NamedElement} to search for.
	 * @param context The {@link PackageSection} that contains the {@link Element} that needs the search result.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public static NamedElement findNamedElementInAadlPackage(String name, PackageSection context)
	{
		NamedElement result = context.findNamedElement(name);
		if (result == null && context instanceof PrivatePackageSection && ((AadlPackage)context.eContainer()).getOwnedPublicSection() != null)
			result = ((AadlPackage)context.eContainer()).getOwnedPublicSection().findNamedElement(name);
		return result;
	}
	
	/**
	 * Search for a {@link NamedElement} with the name {@code elementName} in the package specified by
	 * {@code packageName}.  This method will first check that the specified package is accessible within {@code context}.
	 * This is done by checking that {@code packageName} appears in a with statement or package rename of {@code context}
	 * or {@code context}'s corresponding {@link PublicPackageSection} if {@code context} is a {@link PrivatePackageSection}.
	 * If the package is not accessible, then {@code null} will be returned.  If the element cannot be found in the specified
	 * package, then {@code null} will be returned.
	 * 
	 * Dependencies:
	 * 		If packageName is null or refers to context: RenamesAll, ComponentTypeRename, FeatureGroupTypeRename.
	 * 		If packageName refers to a different package: WithStatementReference, PackageRenameReference.
	 * 
	 * @param packageName The name of the package that contains the element to search for.
	 * @param elementName The name of the element to search for.
	 * @param context The {@link PackageSection} that needs to refer to the specified {@link Element}.
	 * @return The {@link NamedElement} or {@code null} if it cannot be found.
	 */
	public static EObject findNamedElementInAadlPackage(String packageName, String elementName, Namespace context)
	{
		if (context instanceof PackageSection && (packageName == null || ((AadlPackage)context.eContainer()).getName().equalsIgnoreCase(packageName)))
			return findNamedElementInAadlPackage(elementName, (PackageSection)context);
		else
		{
			AadlPackage aadlPackage = null;
			
			if (context instanceof PackageSection)
			{
				PackageRename packageRename = findPackageRename(packageName, (PackageSection)context);
				if (packageRename != null)
					aadlPackage = packageRename.getRenamedPackage();
				else
					aadlPackage = findImportedPackage(packageName, context);
			}
			else
				aadlPackage = findImportedPackage(packageName, context);
			
			if (aadlPackage != null && aadlPackage.getOwnedPublicSection() != null)
				return aadlPackage.getOwnedPublicSection().findNamedElement(elementName);
			else
				return null;
		}
	}
	
	/**
	 * Dependencies:
	 * 		If propertySetName is the name of a different, non standard property set: WithStatementReference.
	 */
	public static EObject findNamedElementInPropertySet(String propertySetName, String elementName, Namespace context)
	{
		if (propertySetName == null)
		{
//			for (PropertySet predeclaredPropertySet : OsateResourceManager.getPredeclaredPropertySets())
//			{
//				NamedElement searchResult = predeclaredPropertySet.findNamedElement(elementName);
//				if (searchResult != null)
//					return searchResult;
//			}
			return null;
		}
		else
		{
			PropertySet propertySet;
			if (context instanceof PropertySet && ((PropertySet)context).getName().equalsIgnoreCase(propertySetName))
				propertySet = (PropertySet)context;
			else
			{
				propertySet = findImportedPropertySet(propertySetName, context);
//				if (propertySet == null)
//					for (PropertySet predeclaredPropertySet : OsateResourceManager.getPredeclaredPropertySets())
//						if (predeclaredPropertySet.getName().equalsIgnoreCase(propertySetName))
//							propertySet = predeclaredPropertySet;
			}
			if (propertySet != null)
				return propertySet.findNamedElement(elementName);
			else
				return null;
		}
	}
	
	/**
	 * Search for a {@link PackageRename} in a package.  If {@code context} is a {@link PrivatePackageSection}, then
	 * this method will also search through the {@link PackageRename}s of the corresponding {@link PublicPackageSection}.
	 * The {@link PackageRename#isRenameAll() renameAll} flag of the returned {@link PackageRename} will be {@code false}.
	 * 
	 * @param name The name of the {@link PackageRename} to search for.
	 * @param context The {@link PackageSection} that contains the {@link Element} that needs a {@link PackageRename}.
	 * @return The {@link PackageRename} or {@code null} if it cannot be found.
	 */
	private static PackageRename findPackageRename(String name, PackageSection context)
	{
		NamedElement searchResult = context.findNamedElement(name, false);
		if (searchResult == null && context instanceof PrivatePackageSection &&
				((AadlPackage)context.eContainer()).getPublicSection() != null)
		{
			searchResult = ((AadlPackage)context.eContainer()).getPublicSection().findNamedElement(name, false);
		}
		if (searchResult instanceof PackageRename)
			return (PackageRename)searchResult;
		else
			return null;
	}
	
	public static String getQualifiedName(String packageOrPropertySetName, String elementName)
	{
		if (packageOrPropertySetName == null)
			return elementName;
		else
			return packageOrPropertySetName + "::" + elementName;
	}
	
	public static Classifier getContainingClassifier(EObject element)
	{
		EObject container = element.eContainer();
		while (container != null && !(container instanceof Classifier))
			container = container.eContainer();
		return (Classifier)container;
	}
	
	/**
	 * Dependencies: PrototypeFormalReference.
	 * 		Based on the type of classifier: ComponentTypeExtensionReference, ComponentImplementationExtensionReference, RealizationReference,
	 * 										 FeatureGroupTypeExtendReference.
	 */
	private static PrototypeBinding findPrototypeBinding(Classifier classifier, Prototype prototype)
	{
		for (PrototypeBinding binding : classifier.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifier.getGeneralizations())
		{
			PrototypeBinding result = findPrototypeBinding(generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}
	
	/**
	 * Dependencies: PrototypeFormalReference.
	 * 		Based on the type of classifierPrototypeContext: ComponentTypeExtensionReference, ComponentImplementationExtensionReference,
	 * 														 RealizationReference, FeatureGroupTypeExtendReference.
	 */
	private static PrototypeBinding findPrototypeBinding(Classifier classifierPrototypeContext, Subcomponent subcomponentPrototypeContext,
			Prototype prototype)
	{
		for (PrototypeBinding binding : subcomponentPrototypeContext.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (PrototypeBinding binding : classifierPrototypeContext.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		for (Generalization generalization : classifierPrototypeContext.getGeneralizations())
		{
			PrototypeBinding result = findPrototypeBinding(generalization.getGeneral(), prototype);
			if (result != null)
				return result;
		}
		return null;
	}
	
	public static AadlPackage findAadlPackage(EObject context, String name)
	{
		if (name == null || name.length() == 0)
			return null;
		ResourceSet rs = context.eResource().getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof AadlPackage )
						&& ((AadlPackage) rootObject).getName()
								.equalsIgnoreCase(name))
					return (AadlPackage) rootObject;
			}
		}
		/* load the resource from the file system */
		Resource res= context.eResource();
		URI uri=res.getURI().trimFileExtension().trimSegments(1).appendSegment(name).appendFileExtension("aadl2");
		Resource xtextResource;
		try {
			xtextResource = context.eResource().getResourceSet().getResource(uri , true);
		} catch (Exception e) {
			try{
			xtextResource = context.eResource().getResourceSet().getResource(uri , false);
			if (xtextResource != null){
					xtextResource.delete(null);
				}
			} catch (Exception ee) {
			}
			 return null;
		}
		if (xtextResource == null) return null;
		if (!xtextResource.getContents().isEmpty()) {
			EObject rootObject = xtextResource.getContents().get(0);
			if ((rootObject instanceof AadlPackage )
					&& ((AadlPackage) rootObject).getName()
							.equalsIgnoreCase(name))
				return (AadlPackage) rootObject;
		} else {
			try {
				xtextResource.delete(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	public static PropertySet findPropertySet(EObject context, String name)
	{
		if (name == null || name.length() == 0)
			return null;
		ResourceSet rs = context.eResource().getResourceSet();
		for (Resource resource : rs.getResources()) {
			if (!resource.getContents().isEmpty()) {
				EObject rootObject = resource.getContents().get(0);
				if ((rootObject instanceof PropertySet )
						&& ((PropertySet) rootObject).getName()
								.equalsIgnoreCase(name))
					return (PropertySet) rootObject;
			}
		}
		/* load the resource from the file system */
		Resource res= context.eResource();
		URI uri=res.getURI().trimFileExtension().trimSegments(1).appendSegment(name).appendFileExtension("aadl2");
		Resource xtextResource;
		try {
			xtextResource = context.eResource().getResourceSet().getResource(uri , true);
		} catch (Exception e) {
			try{
			xtextResource = context.eResource().getResourceSet().getResource(uri , false);
			if (xtextResource != null){
					xtextResource.delete(null);
				}
			} catch (Exception ee) {
			}
			 return null;
		}
		if (xtextResource == null) return null;
		if (!xtextResource.getContents().isEmpty()) {
			EObject rootObject = xtextResource.getContents().get(0);
			if ((rootObject instanceof PropertySet )
					&& ((PropertySet) rootObject).getName()
							.equalsIgnoreCase(name))
				return (PropertySet) rootObject;
		} else {
			try {
				xtextResource.delete(null);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	/**
	 * Dependencies: PrototypeFormalReference.
	 */
	private static PrototypeBinding findPrototypeBinding(Subcomponent subcomponent, Prototype prototype)
	{
		for (PrototypeBinding binding : subcomponent.getOwnedPrototypeBindings())
			if (binding.getFormal().equals(prototype))
				return binding;
		return null;
	}
	
}