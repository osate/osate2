/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 Télécom ParisTech and CNRS
 * 
 * Télécom ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.annex.behavior.utils ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;

import edu.cmu.sei.aadl.aadl2.AadlPackage ;
import edu.cmu.sei.aadl.aadl2.Classifier ;
import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.ComponentImplementation ;
import edu.cmu.sei.aadl.aadl2.ComponentType ;
import edu.cmu.sei.aadl.aadl2.Feature ;
import edu.cmu.sei.aadl.aadl2.FeatureGroupType ;
import edu.cmu.sei.aadl.aadl2.Namespace ;
import edu.cmu.sei.aadl.aadl2.PackageRename ;
import edu.cmu.sei.aadl.aadl2.PackageSection ;
import edu.cmu.sei.aadl.aadl2.PrivatePackageSection ;
import edu.cmu.sei.aadl.aadl2.PropertySet ;
import edu.cmu.sei.aadl.aadl2.Prototype ;
import edu.cmu.sei.aadl.aadl2.PrototypeBinding ;
import edu.cmu.sei.aadl.aadl2.PublicPackageSection ;
import edu.cmu.sei.aadl.aadl2.Subcomponent ;
import edu.cmu.sei.aadl.modelsupport.eclipseinterface.OsateResourceManager ;

import fr.tpt.aadl.annex.behavior.aadlba.*;

/**
 * A collection of behavior annex visitors.
 * 
 * @author GET Telecom-Paristech
 * 
 */
public class AadlBaVisitors
{
   // Some names.
   
   public static final String INITIALIZE_ENTRYPOINT_PROPERTYSET = 
                                                       "Programming_Properties";
   public static final String INITIALIZE_ENTRYPOINT_PROPERTY_NAME =
                                                       "Initialize_Entrypoint" ;
   
   public static final String SEI_AADL2_PACKAGE_NAME = "edu.cmu.sei.aadl.aadl2";
   
   public static final String SEI_AADL2_CLASSIFIER_SUFFIX = "Classifier" ;
   
   /**
    * Returns the first occurrence of a Prototype within the given
    * component and its ancestors which name equals to a given name or
    * returns {@code null} if there isn't matching prototype found.  
    * 
    * @param cc the given aadl's component 
    * @param prototypeName the given name
    * @return the first occurrence of a Prototype related to the given name
    * or {@code null}
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
    * Returns the first occurrence of a PrototypeBinding within the given
    * component or component implementation and its ancestors which concerns
    * a prototype which name equals to the given one or {@code null} 
    * if there isn't matching PrototypeBinding found.
    * @param c the given component or component implementation
    * @param prototypeName the prototype name
    * @return the first occurrence of a PrototypeBinding or {@code null} 
    */
   public static PrototypeBinding findPrototypeBindingInComponent(
                                            Classifier c, String prototypeName)
   {
      PrototypeBinding result = null ;
      
      for(PrototypeBinding pb : c.getOwnedPrototypeBindings())
      {
         if(pb.getFormal() != null &&
            prototypeName.equalsIgnoreCase(pb.getFormal().getName()))
         {
            return pb ;
         }
      }
      
      if(result == null && c instanceof ComponentImplementation)
      {
         ComponentImplementation ci = (ComponentImplementation) c ;
         
         result = findPrototypeBindingInComponent(ci.getType(), prototypeName);
      }
      
      if(result == null && c.getExtended() != null)
      {
         result = findPrototypeBindingInComponent(c.getExtended(),
                                                  prototypeName) ;
      }
      
      return result ;
   }
   
   public static EList<BasicAction> getBasicActions(BehaviorAction BehAction)
   {
      EList<BasicAction> result = null ;
      
      if(BehAction instanceof BasicAction)
      {
         result = new BasicEList<BasicAction>() ;
         result.add((BasicAction) BehAction) ;
      }
      else
      {
         // Case of an loop statements (excepted if statement).
         if(BehAction instanceof LoopStatement)
         {
            result = getBasicActions(((LoopStatement)BehAction)
                                                   .getBehaviorActionsOwned()) ;
         }
         else  // Case of if statement.
         {
            result = new BasicEList<BasicAction>() ;
            IfStatement stat = (IfStatement) BehAction ;
            
            for(BehaviorActions bas : stat.getBehaviorActionsOwned())
            {
               result.addAll(getBasicActions(bas)) ;
            }
         }
         
         
      }
      
      return result ;
   }
   
   /**
    * Return the BasicAction objects contained in a given BehaviorActions
    * object (recursively). For a {@code null} given BehaviorActions object, the
    * returned list is an empty list.
    * 
    * 
    * @param BehAction the given BehaviorActions object or {@code null} (for
    * batch processing)
    * @return the list of BasicAction contained in the given BehaviorActions
    * object.
    */
   public static EList<BasicAction> getBasicActions(BehaviorActions BehActions)
   {
      EList<BasicAction> result = new BasicEList<BasicAction>() ;
      
      // A behavior transition may have no behavior actions.
      if(BehActions != null)
      {
         // Case of single behavior action.
         if(BehActions instanceof BehaviorAction)
         {
            result.addAll(getBasicActions((BehaviorAction)BehActions)) ;
         }
         else // Case of BehaviorActionCollection.
         {
            for(BehaviorAction BehAct : ((BehaviorActionCollection)BehActions)
                                                         .getBehaviorActions() )
            {
               result.addAll(getBasicActions(BehAct)) ;
            }
         }
      }   
      
      return result ;
   }
   
   
   /**
    * Return the package sections related to a given BehaviorAnnex. As 
    * "Classifier declarations in public sections are accessible to other
    * packages, while classifiers in private sections can only be referenced
    * within the private section of the same package".<br><br>
    * table[0] always refers to public section.
    * If the given BehaviorAnnex is declared in a private section, table's 
    * length equals to 2 and table[1] refers to the private section.
    * 
    * @param ba The given BehaviorAnnex
    * @return the package sections related to the given BehaviorAnnex.
    */
   public static PackageSection[] getBaPackageSections(BehaviorAnnex ba)
   {
      PackageSection result[] ;
      PackageSection container = AadlBaVisitors.getContainingPackageSection((edu.cmu.sei.aadl.aadl2.Element)ba);

      // Init contexts tab with current package's sections.
      // Private section is also investigated only if ba is declared in
      // package's private section. 
      if(container instanceof PrivatePackageSection)
      {
         result = new PackageSection[2] ;
         result[1] = container ;
         result[0] = ((AadlPackage) container.eContainer())
         .getPublicSection() ;
      }
      else
      {
         result = new PackageSection[1] ;
         result[0] = container ;
      }

      return result;
   }

   /**
    * Return the behavior transition that contains a given dispatch trigger or 
    * {@code null}.
    * 
    * @param trigg the given dispatch trigger
    * @return the behavior transition that contains the given dispatch trigger
    * or {@code null}.
    */
   static public BehaviorTransition getBehaviorTransition(Identifier trigg)
   {
      EObject result = trigg.eContainer() ;
      
      while (! (result instanceof BehaviorTransition))
      {
         result = result.eContainer() ;
      }
      
      return (BehaviorTransition) result ;
   }
   
   /**
    * Find the first occurrence of an BehaviorVariable within a given
    * BehaviorAnnex which name equals to a given name. Return {@code null} if no 
    * BehaviorVariable is found.
    * 
    * @param ba the given BehaviorAnnex
    * @param stateName the given name
    * @return the first occurrence of an BehaviorVariable related to the given
    * name or {@code null}.
    */
   public static BehaviorVariable findBehaviorVariable(BehaviorAnnex ba,
                                                       String variableName)
   {
      for(BehaviorVariable v : ba.getBehaviorVariables())
      {
         for(Declarator d : v.getLocalVariableDeclarators())
         {
            if(variableName.equalsIgnoreCase(d.getIdentifierOwned().getId()))
            {
               return v ;
            }
         }
      }
      return null ;
   }

   /**
    * Find the first occurrence of an Feature within a given aadl's component
    * which name equals to a given name. Return {@code null} if no Feature is
    * found.
    * 
    * @param cc the given aadl's component
    * @param featureName the given name 
    * @return the first occurrence of a Feature related to the given name or
    * {@code null}
    */
   public static Feature findFeatureInComponent(ComponentClassifier cc,
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
    * Find the first occurrence of a Subcomponent within a given aadls'
    * component which name equals to a given name. Return {@code null} if no
    * Subcomponent is found.  
    * 
    * @param cc the given aadl's component 
    * @param subComponentName the given name
    * @return the first occurrence of a Subcomponent related to the given name
    * or {@code null}
    */
   public static Subcomponent findSubcomponentInComponent
   (ComponentClassifier cc,
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
    * Find the first occurrence of an BehaviorState within a given BehaviorAnnex
    * which name equals to a given name. Return {@code null} if no 
    * BehaviorState is found.
    * 
    * @param ba the given BehaviorAnnex
    * @param stateName the given name
    * @return the first occurrence of an BehaviorState related to the given name
    * or {@code null}
    */
   public static BehaviorState findBehaviorState(BehaviorAnnex ba,
                                                 String stateName)
   {
      for(BehaviorState s : ba.getBehaviorStates())
      {
         for(Identifier id : s.getIdentifiers())
         {
            if(stateName.equalsIgnoreCase(id.getId()))
            {
               return s ;
            }
         }
      }
      return null ;
   }
   
   // DOC ME.
   public static EList<Identifier> getDispatchTriggers(
                                          DispatchTriggerLogicalExpression dtle)
   {
      EList<Identifier> result = new BasicEList<Identifier>();
      
      for(DispatchConjunction dc : dtle.getDispatchConjunctions())
      {
         result.addAll(dc.getDispatchTriggers()) ;
      }
      
      return result;
   }

   /**
    * Return the list of members within a given name space (inherit members
    * included) witch type matches with the specified one. If no members is
    * found, the returned list is a zero size list. 
    * 
    * @param <T> the specified type
    * @param cc the given name space
    * @param klass the specified type's class object
    * @return the members list
    */
   @SuppressWarnings("unchecked")
   public static <T> EList<T> getElementsInNamespace(Namespace ns,
         Class<T> klass)
         {
      EList<edu.cmu.sei.aadl.aadl2.NamedElement> lne = getMembers(ns) ;
      EList<T> result = new BasicEList<T>(lne.size()) ;
      for(edu.cmu.sei.aadl.aadl2.NamedElement ne : lne)
      {
         if(klass.isAssignableFrom(ne.getClass()))
         {
            result.add((T) ne) ;
         }
      }
      return result ;
         }

   /**
    * Return the behavior annex's parent component.
    * 
    * @param ba the behavior annex
    * @return the behavior annex's parent component
    */
   public static ComponentClassifier getParentComponent(BehaviorAnnex ba)
   {
      return (ComponentClassifier) ba.eContainer() ;
   }

   /**
    * Get all members, inherit members included, of a given name space.
    * 
    * @param cc the given name space
    * @return the component's members list
    */
   public static EList<edu.cmu.sei.aadl.aadl2.NamedElement> getMembers(Namespace ns)
   {
      return ns.getMembers() ;
   }

   /********************* Copied from NameResolver ****************************/


   /**
    * Dependencies:
    *       If propertySetName is the name of a different, non standard property set: WithStatementReference.
    */
   public static edu.cmu.sei.aadl.aadl2.NamedElement findNamedElementInPropertySet(String propertySetName, String elementName, Namespace context)
   {
      if (propertySetName == null)
      {
         for (PropertySet predeclaredPropertySet : OsateResourceManager.getPredeclaredPropertySets())
         {
            edu.cmu.sei.aadl.aadl2.NamedElement searchResult = predeclaredPropertySet.findNamedElement(elementName);
            if (searchResult != null)
               return searchResult;
         }
         return null;
      }
      else
      {
         PropertySet propertySet;
         if (context instanceof PropertySet && context.getName().equalsIgnoreCase(propertySetName))
            propertySet = (PropertySet)context;
         else
         {
            propertySet = findImportedPropertySet(propertySetName, context);
            if (propertySet == null)
               for (PropertySet predeclaredPropertySet : OsateResourceManager.getPredeclaredPropertySets())
                  if (predeclaredPropertySet.getName().equalsIgnoreCase(propertySetName))
                     propertySet = predeclaredPropertySet;
         }
         if (propertySet != null)
            return propertySet.findNamedElement(elementName);
         else
            return null;
      }
   }

   private static PropertySet findImportedPropertySet(String name, Namespace context)
   {
      EList<PropertySet> importedPropertySets;
      if (context instanceof PropertySet)
         importedPropertySets = ((PropertySet)context).getImportedPropertySets();
      else
         importedPropertySets = ((PackageSection)context).getImportedPropertySets();
      for (PropertySet importedPropertySet : importedPropertySets)
         if (importedPropertySet.getName().equalsIgnoreCase(name))
            return importedPropertySet;
      return null;
   }

   /**
    * Search for a {@link NamedElement} with the name {@code elementName} in the
    * package specified by {@code packageName}. This method will first check
    * that the specified package is accessible within {@code context}. This is
    * done by checking that {@code packageName} appears in a with statement or
    * package rename of {@code context} or {@code context}'s corresponding
    * {@link PublicPackageSection} if {@code context} is a
    * {@link PrivatePackageSection}. If the package is not accessible, then
    * {@code null} will be returned. If the element cannot be found in the
    * specified package, then {@code null} will be returned.
    * 
    * Dependencies: If packageName is null or refers to context: RenamesAll,
    * ComponentTypeRename, FeatureGroupTypeRename. If packageName refers to a
    * different package: WithStatementReference, PackageRenameReference.
    * 
    * @param packageName The name of the package that contains the element to
    * search for.
    * @param elementName The name of the element to search for.
    * @param context The {@link PackageSection} that needs to refer to the
    * specified {@link Element}.
    * @return The {@link NamedElement} or {@code null} if it cannot be found.
    */
   public static edu.cmu.sei.aadl.aadl2.NamedElement findNamedElementInAadlPackage(String packageName,
                                                                                   String elementName,
                                                                                   Namespace context)
   {
      if(context instanceof PackageSection
            && (packageName == null || context.getName().equalsIgnoreCase(
                  packageName)))
         {
           return findNamedElementInAadlPackage(elementName,
               (PackageSection) context) ;
         }
      else
      {
         AadlPackage aadlPackage = null ;

         if(context instanceof PackageSection)
         {
            PackageRename packageRename =
               findPackageRename(packageName, (PackageSection) context) ;
            if(packageRename != null)
               aadlPackage = packageRename.getRenamedPackage() ;
            else
               aadlPackage = findImportedPackage(packageName, context) ;
         }
         else
            aadlPackage = findImportedPackage(packageName, context) ;

         if(aadlPackage != null && aadlPackage.getPublicSection() != null)
            return aadlPackage.getPublicSection().findNamedElement(elementName,
                  true) ;
         else
            return null ;
      }
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
    * @param name The name of the {@link NamedElement} to search for.
    * @param context The {@link PackageSection} that contains the
    * {@link Element} that needs the search result.
    * @return The {@link NamedElement} or {@code null} if it cannot be found.
    */
   private static edu.cmu.sei.aadl.aadl2.NamedElement findNamedElementInAadlPackage(
                                                                                    String name,
                                                                                    PackageSection context)
   {
      edu.cmu.sei.aadl.aadl2.NamedElement result = context.findNamedElement(name, false) ;
      if(result == null && context instanceof PrivatePackageSection
            && ((AadlPackage) context.eContainer()).getPublicSection() != null)
         result =
            ((AadlPackage) context.eContainer()).getPublicSection()
            .findNamedElement(name, false) ;
      return result ;
   }

   /**
    * Search for a {@link PackageRename} in a package. If {@code context} is a
    * {@link PrivatePackageSection}, then this method will also search through
    * the {@link PackageRename}s of the corresponding
    * {@link PublicPackageSection}. The {@link PackageRename#isRenameAll()
    * renameAll} flag of the returned {@link PackageRename} will be {@code
    * false}.
    * 
    * @param name The name of the {@link PackageRename} to search for.
    * @param context The {@link PackageSection} that contains the
    * {@link Element} that needs a {@link PackageRename}.
    * @return The {@link PackageRename} or {@code null} if it cannot be found.
    */
   private static PackageRename findPackageRename(String name,
                                                  PackageSection context)
   {
      edu.cmu.sei.aadl.aadl2.NamedElement searchResult = context.findNamedElement(name, false) ;
      if(searchResult == null && context instanceof PrivatePackageSection
            && ((AadlPackage) context.eContainer()).getPublicSection() != null)
      {
         searchResult =
            ((AadlPackage) context.eContainer()).getPublicSection()
            .findNamedElement(name, false) ;
      }
      if(searchResult instanceof PackageRename)
         return (PackageRename) searchResult ;
      else
         return null ;
   }

   private static AadlPackage findImportedPackage(String name, Namespace context)
   {
      EList<AadlPackage> importedPackages ;
      if(context instanceof PropertySet)
         importedPackages = ((PropertySet) context).getImportedPackages() ;
      else
         importedPackages = ((PackageSection) context).getImportedPackages() ;
      for(AadlPackage importedPackage : importedPackages)
         if(importedPackage.getName().equalsIgnoreCase(name))
            return importedPackage ;
      if(context instanceof PrivatePackageSection
            && ((AadlPackage) context.eContainer()).getPublicSection() != null)
         for(AadlPackage importedPackage : ((AadlPackage) context.eContainer())
               .getPublicSection().getImportedPackages())
            if(importedPackage.getName().equalsIgnoreCase(name))
               return importedPackage ;
      return null ;
   }

   public static PackageSection getContainingPackageSection(edu.cmu.sei.aadl.aadl2.Element element)
   {
      edu.cmu.sei.aadl.aadl2.Element container = element.getOwner() ;
      while(container != null && !(container instanceof PackageSection))
         container = container.getOwner() ;
      return (PackageSection) container ;
   }

   /***************** End copied from NameResolver ****************************/
}