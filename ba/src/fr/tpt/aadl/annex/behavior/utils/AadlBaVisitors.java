/**
 * AADL-BA-FrontEnd
 * 
 * Copyright © 2011 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
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

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.LinkedHashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;

import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentClassifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Namespace ;
import org.osate.aadl2.PackageSection ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.PrivatePackageSection ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.Subcomponent ;

import fr.tpt.aadl.annex.behavior.aadlba.*;
import fr.tpt.aadl.annex.behavior.declarative.*;

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
   
   public static final String SEI_AADL2_PACKAGE_NAME = "org.osate.aadl2";
   
   public static final String SEI_AADL2_CLASSIFIER_SUFFIX = "Classifier" ;
   
   public static final long DEFAULT_TRANSITION_PRIORITY ;
   
   static 
   {
     DEFAULT_TRANSITION_PRIORITY = AadlBaFactory.eINSTANCE.
                                      createBehaviorTransition().getPriority() ;
   }
   
   /**
    * Returns the first occurrence of a Prototype within the given
    * component and its ancestors which name equals to a given name or
    * returns {@code null} if there isn't matching prototype found.  
    * 
    * @param c the given aadl's component 
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
                                                   .getBehaviorActions()) ;
         }
         else if(BehAction instanceof IfStatement)
         {
            IfStatement stat = (IfStatement) BehAction ;
            
            result = getBasicActions(stat.getBehaviorActions()) ;
            
            if(stat.getElseStatement() != null)
            {
              result.addAll(getBasicActions(stat.getElseStatement().
                                                        getBehaviorActions())) ;
            }
         }
         else // ElseStatement case.
         {
           ElseStatement elseStat = (ElseStatement) BehAction ;
           result = getBasicActions(elseStat.getBehaviorActions()) ;
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
    * @param BehActions the given BehaviorActions object or {@code null} (for
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
                                                         .getActions() )
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
      PackageSection container = AadlBaVisitors.getContainingPackageSection(
    		                                (org.osate.aadl2.Element)ba);

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
    * BehaviorAnnex which name equals to the given name. Return {@code null}
    * if no BehaviorVariable is found.
    * 
    * @param ba the given BehaviorAnnex
    * @param variableName the given name
    * @return the first occurrence of an BehaviorVariable related to the given
    * name or {@code null}.
    */
   public static BehaviorVariable findBehaviorVariable(BehaviorAnnex ba,
                                                       String variableName)
   {
      for(BehaviorVariable v : ba.getVariables())
      {
        if(v.getName().equalsIgnoreCase(variableName))
        {
           return v ;
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
    * Find the first occurrence of a Subcomponent within a given aadls'
    * component which name equals to a given name. Return {@code null} if no
    * Subcomponent is found.  
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
      for(BehaviorState s : ba.getStates())
      {
    	  if(stateName.equalsIgnoreCase(s.getName()))
          {
             return s ;
          }
      }
      return null ;
   }
   
   // DOC ME.
   public static EList<DispatchTrigger> getDispatchTriggers(
                                          DispatchTriggerLogicalExpression dtle)
   {
      EList<DispatchTrigger> result = new BasicEList<DispatchTrigger>();
      
      for(DispatchConjunction dc : dtle.getDispatchConjunctions())
      {
         result.addAll(dc.getDispatchTriggers()) ;
      }
      
      return result;
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
    * Returns the behavior annex's parent component.
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

   public static PackageSection getContainingPackageSection(
           org.osate.aadl2.Element element)
   {
	   org.osate.aadl2.Element container = element.getOwner() ;
	   while(container != null && !(container instanceof PackageSection))
		   container = container.getOwner() ;
	   return (PackageSection) container ;
   }
   
   
  public static final Map<BehaviorAnnex, Set<Port>> _IS_FRESH = 
         new HashMap<BehaviorAnnex, Set<Port>>() ;

  public static boolean isFresh(BehaviorAnnex ba,
                                Port port)
  {
    Set<Port> ports = _IS_FRESH.get(ba) ;
    if(ports != null)
    {
      return ports.contains(port) ;
    }
    else
    {
      return false ;
    }
  }

  public static void putFreshPort(BehaviorAnnex ba,
                                  Port port)
  {
    Set<Port> ports = _IS_FRESH.get(ba) ;
    if(ports == null)
    {
      ports = new HashSet<Port>() ;
      _IS_FRESH.put(ba, ports) ;
    }

    ports.add(port) ;
  }

  private static final Map<BehaviorState, List<BehaviorTransition>> 
    _SRC_IN_TRANS = new HashMap<BehaviorState, List<BehaviorTransition>>() ;

  // Sorted (insertion) behavior transitions list owned by behavior state
  // according to their priority (highest to the lowest).
  // In case of equality, the order of transition appearance in the aadl
  // code is applied.
  // Behavior transition which have execution condition set to "otherwise"
  // will be set at the end of the list.
  // May return empty list.
  public static List<BehaviorTransition> getTransitionWhereSrc(BehaviorState
                                                                state)
  {
    List<BehaviorTransition> result = _SRC_IN_TRANS.get(state) ;
    if(result == null)
    {
      result = new BasicEList<BehaviorTransition>(0) ;
    }

    return result ;
  }

  public static void putTransitionWhereSrc(BehaviorState state,
                                           BehaviorTransition bt)
  {
    List<BehaviorTransition> list = _SRC_IN_TRANS.get(state) ;
    
    if(list == null)
    {
      list = new ArrayList<BehaviorTransition>() ;
      _SRC_IN_TRANS.put(state, list) ;
    }
    
    if(false == list.contains(bt))
    {
      addAndSort(list, bt) ;
    }
  }
  
  private static void addAndSort(List<BehaviorTransition> btl,
                                 BehaviorTransition bt)
  {
    // TODO to be optimized.
    btl.add(bt) ;
    
    BehaviorTransition tmp = null ;
    int i ;
    int j ;

    for(i = btl.size() - 2 ; i >= 0 ; i--)
    {
      tmp = btl.get(i) ;
      j = i ;
      
      while(j < btl.size() - 1 &&
            AadlBaUtils.compareBehaviorTransitionPriority(btl.get(j + 1), tmp))
      {
        btl.set(j, btl.get(j+1)) ;
        j++ ;
      }

      btl.set(j, tmp) ;
    }
  }
}