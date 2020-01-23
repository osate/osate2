/**
 * AADL-BA-FrontEnd
 * 
 * Copyright (c) 2011-2020 TELECOM ParisTech and CNRS
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

package org.osate.ba.analyzers;

import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.ecore.InternalEObject ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.ba.aadlba.AadlBaFactory ;
import org.osate.ba.aadlba.AadlBaPackage ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.PropertyNameField ;
import org.osate.ba.declarative.DeclarativeBehaviorTransition ;
import org.osate.ba.declarative.DeclarativePropertyName ;
import org.osate.ba.declarative.DeclarativePropertyReference ;
import org.osate.ba.declarative.Identifier ;
import org.osate.ba.texteditor.AadlBaHyperlink ;
import org.osate.ba.utils.AadlBaVisitors ;


/**
 * A collection of util methods for AADLBA Front End's declarative meta model.
 */
public class DeclarativeUtils
{
  
  /**
   * Instanciates the behavior transitions from the given behavior annex's
   * declarative behavior transitions.<BR><BR>
   * 
   * declarative behavior transitions design many source states to one
   * destination state. behavior transitions design one source state to one
   * destination state.
   * 
   * @param ba the given behavior annex
   */
  public static void reinstanciateBehaviorTransition(BehaviorAnnex ba, AadlBaHyperlink hl)
  {
    DeclarativeBehaviorTransition dbt = null ;
    List<BehaviorTransition> clones = new ArrayList<BehaviorTransition>();
    BehaviorTransition currentClone = null ;
    
    for(BehaviorTransition tmpBt : ba.getTransitions())
    {
      dbt = (DeclarativeBehaviorTransition) tmpBt ;
      
      for(Identifier idSrcState : dbt.getSrcStates())
      {
        currentClone = AadlBaFactory.eINSTANCE.createBehaviorTransition() ;
        currentClone.setName(dbt.getName()) ;
        
        BehaviorState srcState = (BehaviorState) idSrcState.getBaRef() ;
        currentClone.setSourceState(srcState) ;
        
        hl.addToHyperlinking(idSrcState.getAadlBaLocationReference(), srcState);
        
        currentClone.setCondition(dbt.getCondition()) ;
        currentClone.setDestinationState((BehaviorState) dbt.getDestState(). 
                                                                   getBaRef()) ;
        
        hl.addToHyperlinking(dbt.getDestState().getAadlBaLocationReference(), dbt.getDestState().getBaRef()	);
        
        currentClone.setActionBlock(dbt.getActionBlock()) ;
        currentClone.setPriority(dbt.getPriority()) ;
        currentClone.setLocationReference(dbt.getLocationReference()) ;
        clones.add(currentClone) ;
        
        AadlBaVisitors.putTransitionWhereSrc(srcState, currentClone) ;
      }
    }
    
    ba.unsetTransitions();
    ba.getTransitions().addAll(clones) ;
  }
  
  /**
   * Set the given behavior annex as the EMF parent container to the given 
   * Element object.  
   * 
   * @param ba the given behavior annex
   * @param child the given Element object
   */
  public static void setEcontainer(BehaviorAnnex ba, Element child)
  {
    InternalEObject iChild = (InternalEObject) child ;
    InternalEObject iBa = (InternalEObject) ba ;
    iChild.eBasicSetContainer(iBa, AadlBaPackage.BEHAVIOR_ANNEX, null) ;
  }
  
  /**
   * Print on the standard output, the data of the given DeclarativePropertyReference
   * object.
   * 
   * @param dpr the given DeclarativePropertyReference object
   */
  public static void printDeclarativePropertyReference(
                                               DeclarativePropertyReference dpr)
  {
    System.out.println("*****") ;
    
    if(dpr.isPropertySet())
    {
      System.out.println("dpr comes from a property set") ;
    }
    
    if(dpr.getQualifiedName() != null)
    {
      System.out.println("qualified name : " + unparseElement(dpr.getQualifiedName().getOsateRef())) ;
    }
    
    if(dpr.getReference() != null)
    {
      if(dpr.getReference().getOsateRef() != null)
      {
        System.out.println("reference osate : " + unparseElement(dpr.getReference().getOsateRef())) ;
      } 
      else
      {
        System.out.println("reference ba : " + unparseElement(dpr.getReference().getBaRef())) ;
      }
    }
    
    if(dpr.getPropertyNames().isEmpty() == false)
    {
      for(DeclarativePropertyName dpn : dpr.getPropertyNames())
      {
        System.out.println("  property name : " + unparseElement(dpn.getOsateRef())) ;
        
        System.out.println("  property name id \'" + dpn.getPropertyName().getId() +
                           "\' : " + unparseElement(dpn.getPropertyName().getOsateRef())) ;
        if(null != dpn.getField())
        {
          System.out.println("  field : " + unparsePropertyNameField(dpn.getField())) ;
        }
        
        if(dpn.isSetIndexes())
        {
          for(IntegerValue iv : dpn.getIndexes())
          {
            System.out.println("  index : " + unparseElement(iv)) ;
          }
        }
      }
    }
    
    System.out.println("*****") ;
  }
  
  public static String unparseElement(Element el)
  {
    String result ;
    
    if(el instanceof PropertyAssociation)
    {
      PropertyAssociation pa = (PropertyAssociation) el ;
      
      result = "" ;
      
      for(ModalPropertyValue mpv : pa.getOwnedValues())
      {
        result += mpv.getOwnedValue().toString() + " ; " ; 
      }
    }
    else
    {
      result = el.toString() ;
    }
    
    return result ;
  }
  
  public static String unparsePropertyNameField(PropertyNameField field)
  {
    return field.toString() ;
  }
}