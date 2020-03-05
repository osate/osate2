/**
 * AADL-Utils
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 2.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * https://www.eclipse.org/legal/epl-2.0/
 */

package org.osate.utils;

import java.util.LinkedHashSet ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EReference ;
import org.eclipse.xtext.linking.lazy.LazyLinkingResource ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Namespace ;
import org.osate.aadl2.PackageSection ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.Subcomponent ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

/**
 * A collection of AADL2 visitors. 
 */
public class Aadl2Visitors
{
  /**
   * Get all members, inherit members included, of a given name space.
   * Member order is kept. Using LinkedHashSet avoids duplicated members
   * introduced by inheritance.
   * 
   * @param ns the given name space
   * @return the component's members LinkedHashSet
   */
  public static LinkedHashSet<NamedElement> getMembers(Namespace ns)
  {
     LinkedHashSet<NamedElement> result = new LinkedHashSet<NamedElement>() ;
     result.addAll(ns.getMembers()) ;
     return result ;
  }
  
  /**
   * Return the package section related to a given Element object.
   * 
   * @param element the given Element object
   * @return the package section related to the given Element object
   */
  public static PackageSection getContainingPackageSection(Element element)
  {
    Element container = element.getOwner() ;
    while(container != null && !(container instanceof PackageSection))
      container = container.getOwner() ;
    return (PackageSection) container ;
  }
  
  /**
   * Returns the list of members within a given name space (inherit members
   * included) witch type matches with the specified one. If no members is
   * found, the returned list is a empty list. The members order is kept.
   * The returned list is free from duplicated members (due to inheritance).
   * 
   * @param <T> the specified type
   * @param ns the given name space
   * @param klass the specified type's class object
   * @return the members list
   */
  @SuppressWarnings("unchecked")
  public static <T> EList<T> getElementsInNamespace(Namespace ns,
                                                    Class<T> klass)
  {
     Set<NamedElement> lne = getMembers(ns) ;
     EList<T> result = new BasicEList<T>(lne.size()) ;
     for(NamedElement ne : lne)
     {
        if(klass.isAssignableFrom(ne.getClass()))
        {
           result.add((T) ne) ;
        }
     }
     return result ;
  }
  
  /**
   * Find the first occurrence of a Subcomponent within a given aadls'
   * component (and ancestors) which name equals to a given name. Return
   * {@code null} if no Subcomponent is found.  
   * 
   * @param cc the given aadl's component 
   * @param subComponentName the given name
   * @return the first occurrence of a Subcomponent related to the given name
   * or {@code null}
   */
  public static Subcomponent findSubcomponentInComponent (Classifier cc,
                                                       String subComponentName)
  {
     Subcomponent result = null ;

     if(cc instanceof ComponentImplementation)
     {
        EList<Subcomponent> lsubcs = ((ComponentImplementation) cc)
        .getAllSubcomponents() ;
        for(Subcomponent subc : lsubcs)
        {
           if (subc.getName().equalsIgnoreCase(subComponentName))
           {
              result = subc ;
              break ;
           }
        }
     }

     return result ;
  }
  
  /**
   * Find the first occurrence of an Feature within a given aadl's component
   * (and ancestors) which name equals to a given name. Return {@code null} if
   * no Feature is found.
   * 
   * @param cc the given aadl's component
   * @param featureName the given name 
   * @return the first occurrence of a Feature related to the given name or
   * {@code null}
   */
  public static Feature findFeatureInComponent(Classifier cc,
                                                 String featureName)
  {
     for(Feature f : cc.getAllFeatures())
     {
        if(featureName.equalsIgnoreCase(f.getName()))
        {
           return f ;
        }
     }
     return null ;
  }
  
  /**
   * Returns the first occurrence of a Prototype within the given
   * component and its ancestors which name equals to a given name or
   * returns {@code null} if there isn't matching prototype found.  
   * 
   * @param c the given aadl's component 
   * @param prototypeName the given name
   * @return the first occurrence of a Prototype object related to the given
   * name or {@code null}
   */
  public static Prototype findPrototypeInComponent(Classifier c,
                                                   String prototypeName)
  {
     Prototype result = null ;

     EList<Prototype> lprotos = getElementsInNamespace(c, Prototype.class) ;
     
     for(Prototype proto : lprotos)
     {
        if (proto.getName().equalsIgnoreCase(prototypeName))
        {
           result = proto ;
           break ;
        }
     }
     
     return result ;
  }
  
  /**
   * Returns the first occurrence of a PrototypeBinding object within the given
   * component or component implementation and its ancestors which concerns
   * a prototype which name equals to the given one or {@code null} 
   * if there isn't matching PrototypeBinding object found.
   * @param c the given component or component implementation
   * @param prototypeName the prototype name
   * @return the first occurrence of a PrototypeBinding object or {@code null} 
   */
  public static PrototypeBinding findPrototypeBindingInComponent(
                                           Classifier c, String prototypeName)
  {
    if(c == null)
    {
      return null ;
    }
    
    PrototypeBinding result = null ;
     
     for(PrototypeBinding pb : c.getOwnedPrototypeBindings())
     {
        if(pb.getFormal() != null &&
           prototypeName.equalsIgnoreCase(pb.getFormal().getName()))
        {
           return pb ;
        }
     }
     
     // Recursive call for component implementation.
     if(result == null && c instanceof ComponentImplementation)
     {
        ComponentImplementation ci = (ComponentImplementation) c ;
        
        result = findPrototypeBindingInComponent(ci.getType(), prototypeName);
     }
     
     // Recursive call for parent component.
     if(result == null && c.getExtended() != null)
     {
        result = findPrototypeBindingInComponent(c.getExtended(),
                                                 prototypeName) ;
     }
     
     return result ;
  }
  
  /**
   * Fetch the service associated to the given package section.
   * If the package section's resource is a lazy load resource, it gives the
   * resource's service. 
   * 
   * @param context the given package section
   * @return the service associated to the given package section
   */
  public static PropertiesLinkingService getPropertiesLinkingService(PackageSection context)
  {
    if(context.eResource() instanceof LazyLinkingResource)
    {
      return (PropertiesLinkingService) ((LazyLinkingResource) context
          .eResource()).getLinkingService() ;
    }
    else
    {
      return new PropertiesLinkingService() ;
    }
  }

  /**
   * Find an element in a package based on their name from the given point of
   * view (package section) or return {@code null}.
   * 
   * @param elementName the element's name
   * @param packageName the package's name
   * @param context the given point of view
   * @return the element or {@code null}
   */
  public static NamedElement findElementInPackage(String elementName,
                                                  String packageName,
                                                  PackageSection context)
  {
    NamedElement result = null ;

    NamedElement rootContainer = context.getElementRoot() ;

    String currentNamespace = rootContainer.getName() ;

    PropertiesLinkingService pls =
        Aadl2Visitors.getPropertiesLinkingService(context) ;

    if(packageName == null || currentNamespace == null ||
       currentNamespace.equalsIgnoreCase(packageName))
    {
      // The element is declared into the current context.
      result = pls.findNamedElementInsideAadlPackage(elementName, context) ;
    }
    else
    // The element is defined into an imported package.
    {
      result =
          pls.findNamedElementInAadlPackage(packageName, elementName, context) ;
    }

    return result ;
  }

  /**
   * Find a property in a propertyset based on their name from the given point of
   * view (package section) or return {@code null}.
   * 
   * @param elementName the element's name
   * @param propertySetName the propertyset's name
   * @param context the given point of view
   * @return the property or {@code null}
   */
  public static NamedElement findElementInPropertySet(String elementName,
                                                      String propertySetName,
                                                      PackageSection context)
  {
    NamedElement result = null ;

    PropertiesLinkingService pls =
        Aadl2Visitors.getPropertiesLinkingService(context) ;

    // First in the predeclared propertysets.

    // Why this, i don't know ...
    EReference reference = Aadl2Package.eINSTANCE.getNamedValue_NamedValue() ;

    result =
        (NamedElement) pls
            .findNamedElementInPredeclaredPropertySets(elementName, context,
                                                       reference) ;
    // Then in the imported property sets.
    if(result == null)
    {
      PropertySet ps = null ;

      ps = pls.findPropertySet(context, propertySetName) ;

      if(ps != null)
      {
        result = ps.findNamedElement(elementName) ;
      }
    }

    return result ;
  }
}