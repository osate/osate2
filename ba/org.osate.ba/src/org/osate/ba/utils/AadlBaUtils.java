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

package org.osate.ba.utils;

import java.lang.System ;
import java.util.Comparator ;
import java.util.List ;
import java.util.ListIterator ;

import javax.naming.OperationNotSupportedException ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.* ;
import org.osate.aadl2.ThreadGroup ;
import org.osate.ba.aadlba.* ;
import org.osate.ba.aadlba.FeatureType ;
import org.osate.ba.analyzers.TypeHolder ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.Aadl2Visitors ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.Aadl2Utils.DataAccessRight ;
import org.osate.utils.names.DataModelProperties ;

/**
 * A collection of static utils methods.
 */
public class AadlBaUtils {

  /**
   * String separator for a component reference name.
   */
  public static final String STRING_NAME_SEPARATOR = "." ;

  /**
   * Returns the last data representation from the property stack of the given data
   * classifier or DataRepresentation.UNKNOWN if Data_Model::Data_Representation
   * property is not set or if the data classifier represents a data structure.
   *
   * @param c the given data classifier
   * @return the data representation or DataRepresentation.UNKNOWN
   */
  public static DataRepresentation getDataRepresentation(DataClassifier c)
  {
    DataRepresentation result = null ;
    
    if(c == null)
    {
      result = DataRepresentation.UNKNOWN ;
    }
    else
    {
      
      EList<PropertyExpression> l = 
            PropertyUtils.findPropertyExpression(c,
              DataModelProperties.DATA_REPRESENTATION) ;
      if(l.size() > 0)
      {
        // Fetches the last enumeration value from the inheritance stack of 
        // properties. 
        NamedValue nv = (NamedValue) l.get(l.size() - 1) ;
        String tmp = ((EnumerationLiteral) nv.getNamedValue()).getName() ;
        result = DataRepresentation.getByName(tmp) ;

        if(result == null)
        {
          result = DataRepresentation.UNKNOWN ;
        }
      }
      else
      {
        result = DataRepresentation.UNKNOWN ;
      }
    }

    return result ;
  }

  /**
   * Returns the data representation of the given BehaviorVariable object
   * or DataRepresentation.UNKNOWN if Data_Model::Data_Representation
   * property is not set or if the BehaviorVariable object represents a 
   * data structure.
   *
   * @param bv the given BehaviorVariable object
   * @return the data representation or DataRepresentation.UNKNOWN
   */
  public static DataRepresentation getDataRepresentation(BehaviorVariable bv)
  {
    Element el = bv.getDataClassifier() ;

    return getDataRepresentation((DataClassifier) el) ;
  }

  /**
   * Returns the data representation associated to the given PropertyType
   * object.
   * <BR><BR>
   * Note : this method only supports the following property types :
   * <BR>_ Aadl integer
   * <BR>_ Aadl real
   * <BR>_ Aadl string
   * <BR>_ Aadl boolean
   * <BR>_ Enumeration
   * <BR><BR>
   * @param type the given PropertyType object.
   * @return the data representation associated to the given PropertyType 
   * object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(PropertyType type)
  {
    if(type instanceof AadlInteger)
      return DataRepresentation.INTEGER ;
    else if(type instanceof AadlReal)
      return DataRepresentation.FLOAT ;
    else if (type instanceof AadlString)
      return DataRepresentation.STRING ;
    else if(type instanceof AadlBoolean)
      return DataRepresentation.BOOLEAN ;
    else if(type instanceof EnumerationType)
      return DataRepresentation.ENUM ;
    else
    {
      // Not implemented:
      // ClassifierType, EnumerationType, ListType, NonListType, NumberType,
      // RangeType, RecordType, ReferenceType, UnitsType
      String errorMsg = "getDataRepresentation: " +
                        type.getClass().getSimpleName()+
                        " from " + type.eContainer().toString() +
                        " is not supported yet." ;
      throw new UnsupportedOperationException(errorMsg) ;
    }
  }
  
  /**
   * Returns the data representation associated to the given PropertyAssociation
   * object.
   * <BR><BR>
   * Note : {@link #getDataRepresentation(PropertyExpression)} to see restrictions.
   * @param pa the given PropertyAssociation object.
   * @return the data representation associated to the given PropertyAssociation 
   * object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(PropertyAssociation pa)
  {
    ModalPropertyValue mpv = pa.getOwnedValues().get(pa.getOwnedValues().size()-1);
    return getDataRepresentation(mpv.getOwnedValue());
  }
  
  /**
   * Returns the data representation associated to the given PropertyExpression
   * object.
   * <BR><BR>
   * Note : this method only supports the following property types :
   * <BR>_ Boolean literal
   * <BR>_ Integer literal
   * <BR>_ Real literal
   * <BR>_ String literal
   * <BR><BR>
   * @param pe the given PropertyExpression object.
   * @return the data representation associated to the given PropertyExpression 
   * object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(PropertyExpression pe)
  {
    int type = pe.eClass().getClassifierID() ;
    switch(type)
    {
      case Aadl2Package.BOOLEAN_LITERAL: return DataRepresentation.BOOLEAN ;
      case Aadl2Package.INTEGER_LITERAL: return DataRepresentation.INTEGER ;
      case Aadl2Package.REAL_LITERAL: return DataRepresentation.FLOAT ;
      case Aadl2Package.STRING_LITERAL: return DataRepresentation.STRING ;
      
      default:
      {
        // Not implemented:
        // ClassifierValue, ComputedValue, InstanceReferenceValue,
        // ListValue, NamedValue, NumberValue, Operation, PropertyValue,
        // RangeValue, RecordValue, ReferenceValue
        String errorMsg = "getDataRepresentation: " + pe.getClass().getSimpleName() +
            " from " + pe.eContainer().toString() + " is not supported yet." ;
        throw new UnsupportedOperationException(errorMsg) ;
      }
    }
  }
  
  /**
   * Returns the data representation associated to the given
   * BehaviorPropertyConstant object <BR><BR>
   * Note : {@link #getDataRepresentation(PropertyType)} to see restrictions. 
   * <BR><BR> 
   * @param pc the given BehaviorPropertyConstant object
   * @return the data representation associated to the given 
   * BehaviorPropertyConstant object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(
                                                    BehaviorPropertyConstant pc)
  {
    return getDataRepresentation((pc.getProperty().getPropertyType())) ;
  }

  /**
   * Returns the data representation associated to the given PropertyReference
   * object <BR><BR>
   * Note : {@link #getDataRepresentation(PropertyType)} and 
   * {@link #getDataRepresentation(PropertyExpression)} to see restrictions. 
   * <BR><BR>
   * @param pv the given PropertyReference object
   * @return the data representation associated to the given
   * PropertyReference object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(PropertyReference pr)
  {
    EList<PropertyNameHolder> holders = pr.getProperties() ;
    PropertyNameHolder last = holders.get(holders.size()-1);
    Element el = last.getProperty().getElement() ;
    
    if(el instanceof PropertyType || el instanceof BasicProperty)
    {
      return getDataRepresentation(((BasicProperty) el).getPropertyType()) ;
    }
    else if(el instanceof PropertyAssociation)
    {
      return getDataRepresentation((PropertyAssociation) el) ;
    }
    else if(el instanceof PropertyExpression)
    {
      return getDataRepresentation((PropertyExpression) el) ;
    }
    else if(el instanceof EnumerationLiteral)
    {
      return DataRepresentation.ENUM_LITERAL ;
    }
    else
    {
      String errorMsg = "getDataRepresentation: " + el.getClass().getSimpleName() +
                        " is not supported yet." ;
      System.err.println(errorMsg) ;
      throw new UnsupportedOperationException(errorMsg) ;
    }
  }
  
  /**
   * Returns the PropertyType object associated to the given PropertyElementHolder
   * given object.
   * @param holder the PropertyElementHolder given object
   * @return the associated PropertyType object
   */
  public static PropertyType getPropertyType(PropertyElementHolder holder)
  {
    PropertyType result = null ;
    
    Element el = holder.getElement() ;
    
    if(el instanceof PropertyType)
    {
      result = (PropertyType) el ;
    }
    else if(el instanceof BasicProperty)
    {
      result = ((BasicProperty)el).getPropertyType() ;
    }
    else if(el instanceof PropertyAssociation)
    {
      result = ((PropertyAssociation)el).getProperty().getPropertyType() ;
    }
    else if(el instanceof PropertyExpression)
    {
      result = PropertyUtils.getContainingProperty((PropertyExpression) el).
                                                             getPropertyType() ;
    }
    else if(el instanceof EnumerationLiteral)
    {
      result = (EnumerationType) el.eContainer() ;
    }
    return result ;
  }

  /**
   * Returns the data representation associated to the given ValueConstant
   * object <BR><BR>
   * Note : {@link #getDataRepresentation(PropertyType)} 
   *                        to see restrictions on property constant and value. 
   * <BR><BR>
   * @param v the given ValueConstant object
   * @return the data representation associated to the given ValueConstant
   * object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(ValueConstant v)
  {
    if(v instanceof BehaviorPropertyConstant)
    {
      return getDataRepresentation((BehaviorPropertyConstant) v)  ;
    }
    else if (v instanceof PropertyReference) 
    {
      return getDataRepresentation((PropertyReference) v)  ;
    }
    else if(v instanceof BehaviorIntegerLiteral)
    {
      return DataRepresentation.INTEGER ;
    }
    else if(v instanceof BehaviorRealLiteral)
    {
      return DataRepresentation.FLOAT ;
    }
    else if (v instanceof BehaviorStringLiteral)
    {
      return DataRepresentation.STRING ;
    }
    else if (v instanceof BehaviorBooleanLiteral)
    {
      return DataRepresentation.BOOLEAN ;
    }
    else // Behavior enumeration literal case. 
    {
      return DataRepresentation.ENUM ;  
    }
  }

  /**
   * Returns the data representation of the given ValueVariable object
   * or DataRepresentation.UNKNOWN if Data_Model::Data_Representation
   * property is not set or if the ValueVariable object represents a data
   * structure.
   *
   * @param v the given ValueVariable object
   * @return the data representation or DataRepresentation.UNKNOWN
   */
  public static DataRepresentation getDataRepresentation(ValueVariable v)
  {
    if(v instanceof PortCountValue)
    {
      return DataRepresentation.INTEGER ;
    }
    else if(v instanceof PortFreshValue)
    {
      return DataRepresentation.BOOLEAN ;
    }
    else
    {
      // Either ElementHolder or DataComponentReference object.
      Element el = null ;
        
      if(v instanceof ElementHolder)
      {
        if(v instanceof PrototypeHolder)
        {
          PrototypeHolder ph = (PrototypeHolder) v ;
           
          if (ph.getPrototypeBinding() != null)
          {
            el = ph.getPrototypeBinding() ;
          }
          else
          {
            el = ph.getPrototype() ;
          }
        }
        else
        {
          el = ((ElementHolder)v).getElement() ;
        }
      }
      else // DataComponentReference case.
      {
        DataComponentReference dcr = (DataComponentReference) v ;
          
        DataHolder lastElement = dcr.getData().get(dcr.getData().size()-1) ;
        el = lastElement.getElement() ;
      }
      
      if(el instanceof Abstract)
      {
        return DataRepresentation.UNKNOWN ;
      }
      else if(el instanceof Feature)
      {
        Classifier c = ((Feature) el).getClassifier() ;
        
        if(c instanceof DataClassifier)
          return getDataRepresentation((DataClassifier) c) ;
        else // Abstract type or anything else.
          return DataRepresentation.UNKNOWN ;
      }
      else if(el instanceof DataSubcomponent)
      {
        return getDataRepresentation((DataClassifier)((DataSubcomponent)
                  el).getClassifier());
      }
      else if(el instanceof BehaviorVariable)
      {
        // Behavior case.      
        return getDataRepresentation((BehaviorVariable)el) ;
      }
      else
      {
        // Prototype cases.
        Classifier klass ;
        ComponentClassifier baParentComponent = 
              (ComponentClassifier) v.getContainingClassifier() ;
          
        klass = AadlBaUtils.getClassifier(el, baParentComponent) ;
        return getDataRepresentation((DataClassifier) klass) ;
      }
    }
  }

  /**
   * Returns the data representation associated to the given Value object.
   * or DataRepresentation.UNKNOWN if Data_Model::Data_Representation
   * property is not set or if the Value object represents a data
   * structure.
   * <BR><BR>
   * Note : {@link #getDataRepresentation(PropertyType)} 
   *                        to see restrictions on property constant and value. 
   * <BR><BR>
   * @param v the given Value object
   * @return the data representation associated to the given Value object or
   * DataRepresentation.UNKNOWN
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static DataRepresentation getDataRepresentation(Value v)
  {
    if(v instanceof ValueVariable)
      return getDataRepresentation((ValueVariable) v) ;
    else return getDataRepresentation((ValueConstant) v) ;
  }

  /**
   * Constructs a string base on the name of the given behavior states list,
   * separated by the given separator symbol.
   * 
   * @param bsl the given behavior states list
   * @param separator the name separator symbol
   * @return the string build on the given behavior state's names and given 
   * separator
   */
  public static String identifierListToString(EList<BehaviorState> bsl,
                                              String separator)
  {
    String[] ls = new String[bsl.size()] ;
    int i = 0 ;

    for(BehaviorState bs : bsl)
    {
      ls[i] = bs.getName() ;
      i++ ;
    }

    return Aadl2Utils.concatenateString(separator, ls) ;
  }
  
  /**
   * Returns the given Element object's classifier.
   * If the Element object is a prototype, it will try to resolve it as 
   * follow: returns the data prototype binded classifier at first withing the
   * element's parent container otherwise the constraining classifier.
   * It returns {@code null} if the prototype is not defined.
   * <BR><BR>
   * This method support instances of:<BR>
   * <BR>_Feature (port, data access, subprogram access, parameter, etc.)
   * <BR>_Subcomponent (data subcomponent, subprogram subcomponent, etc.)
   * <BR>_BehaviorVariable
   * <BR>_IterativeVariable (for/forall's iterative variable)
   * <BR>_Prototype (all excepted FeatureGroupPrototype)
   * <BR>_PrototypeBinding (all excepted FeatureGroupPrototypeBinding)
   * <BR>_ClassifierValue (struct or union data subcomponent)
   * <BR><BR>
   * If the given Element object is not one of those types, an
   * UnsupportedOperationException is thrown. 
   * 
   * @param el the given Element object
   * @param parentContainer the element's parent component.
   * @return the given element's classifier or {@code null} if the prototype is
   * not defined
   * @exception UnsupportedOperationException for unsupported element
   * object types.
   */
  public static Classifier getClassifier(Element el,
                                         Classifier parentContainer)
  {
    Classifier result = null ;

    if(el instanceof Feature)
    {
      Feature f = (Feature) el ;
      
      if(el instanceof FeatureGroup)
      {
        org.osate.aadl2.FeatureType ft = ((FeatureGroup)el).getFeatureType() ;
        
        if (ft != null)
        {
          if(ft instanceof FeatureGroupType)
          {
            result = (FeatureGroupType) ft ;
          }
          else // FeatureGroupPrototype case
          {
            result = getClassifier((FeatureGroupPrototype)ft, parentContainer) ;
          }
        }
      }
      else
      {
        // Feature case.
        result = f.getClassifier() ;

        // Resolves data prototype.
        // Feature without classifier returns null.
        if(result == null && f.getPrototype() != null)
        {
          result = prototypeResolver((ComponentPrototype)
                                                f.getPrototype(),
                                                parentContainer) ;
        }
      }
    }
    else if(el instanceof Subcomponent) 
    {
      Subcomponent sub = (Subcomponent) el ;
      
      if(el instanceof SubprogramGroupSubcomponent)
      {
        result = ((SubprogramGroupSubcomponent)el).getClassifier() ;
      }
      else
      {
        // Subcomponent case.
        result = sub.getClassifier();
        
        // Resolves data prototype.
        // Subcomponent without classifier returns null.
        if(result == null && sub.getPrototype() != null)
        {
          result = prototypeResolver(sub.getPrototype(),
                                              parentContainer) ;
        }
      }
    }
    else if(el instanceof BehaviorVariable) 
    {
      // Local variable case (BehaviorVariable).
      BehaviorVariable bv = (BehaviorVariable) el ;
      result = bv.getDataClassifier() ;
    }
    else if(el instanceof IterativeVariable)
    {       
      // Iterative variable case.
      result = ((IterativeVariable) el).getDataClassifier() ;
    }
    else if (el instanceof Prototype)
    {
      result = prototypeResolver((Prototype) el, parentContainer) ;
    }
    else if (el instanceof PrototypeBinding)
    {
      // Prototype binding case.
      result = prototypeBindingResolver((PrototypeBinding) el) ;
    }
    else if (el instanceof ClassifierValue)
    {
      // struct or union member case (ClassifierValue).
      result = ((ClassifierValue) el).getClassifier() ;
    }
    else if(el instanceof StructUnionElement)
    {
      return ((StructUnionElement)el).getDataClassifier() ;
    }
    else
    {
      // Reports error.
      String errorMsg = "getClassifier : " +  el.getClass().getSimpleName()+
                        " is not supported yet." ;

      System.err.println(errorMsg);
      throw new UnsupportedOperationException(errorMsg) ;
    }

    return result ;
  }

  /**
   * Resolves the given prototype by returning the binded classifier
   * or if there is no binded classifier, the constraining classifier.
   * It returns {@code null} if the given prototype is not defined. 
   * 
   * @param prototype the given prototype
   * @param parentContainer the element's parent component
   * @return the binded classifier at first then the constraining classifier or
   * {@code null}
   */
  public static Classifier prototypeResolver(Prototype prototype,
                                               Classifier parentContainer)
  {
    Classifier result = null ;

    // First find a prototype bind as prototype may be binded several times.
    PrototypeBinding pb = Aadl2Visitors.findPrototypeBindingInComponent(
        parentContainer,
        prototype.getName()) ;

    if(pb != null)
    {
      result = prototypeBindingResolver(pb) ;
    }
    else
    {
      // If there is no prototype binding found, returns the constraining
      // classifier from the prototype declaration (it may be null).
            
      if(prototype instanceof ComponentPrototype)
      {
        result = ((ComponentPrototype) prototype).getConstrainingClassifier() ;
      }
      else if (prototype instanceof FeaturePrototype)
      {
        result = ((FeaturePrototype) prototype).getConstrainingClassifier() ;
      }
      else if (prototype instanceof FeatureGroupPrototype)
      {
        result = ((FeatureGroupPrototype) prototype).getConstrainingFeatureGroupType() ;
      }
      else
      {
        // Reports error.
        String errorMsg = "prototypeResolver : " +  prototype.getClass().getSimpleName()+
                          " is not supported yet." ;

        System.err.println(errorMsg);
        throw new UnsupportedOperationException(errorMsg) ;
      }
    }

    return result ;
  }

  /**
   * Resolves the given prototype binding by returning the binded classifier
   * It returns {@code null} if the given prototype binding is not defined. 
   * 
   * @param pb the given prototype binding
   * @return the binded classifier or {@code null}
   */
  public static Classifier prototypeBindingResolver(PrototypeBinding pb)
  {
    Classifier result = null ;
    
    if(pb instanceof ComponentPrototypeBinding)
    {
      ComponentPrototypeBinding cpb ;
      cpb = (ComponentPrototypeBinding) pb ;

      // Takes the last binding.
      ComponentPrototypeActual cpa = cpb.getActuals().
          get(cpb.getActuals().size() -1) ;
      
      result = (Classifier) cpa.getSubcomponentType() ;
    }
    else if (pb instanceof FeaturePrototypeBinding)
    {
      FeaturePrototypeBinding fpb ;
      fpb = (FeaturePrototypeBinding) pb ;
      FeaturePrototypeActual fpa = fpb.getActual() ;
      
      if (fpa instanceof AccessSpecification)
      {
        result = ((AccessSpecification) fpa).getClassifier() ; 
      }
      else if(fpa instanceof PortSpecification)
      {
        result = ((PortSpecification)fpa).getClassifier() ;
      }
      else
      {
        // Reports error.
        String errorMsg = "prototypeBindingResolver : " + 
            fpa.getClass().getSimpleName()+
            " is not supported yet." ;

        System.err.println(errorMsg);
        throw new UnsupportedOperationException(errorMsg) ;
      }
    }
    else if (pb instanceof FeatureGroupPrototypeBinding)
    {
      FeatureGroupPrototypeBinding fgpb = (FeatureGroupPrototypeBinding) pb ;
      result = (FeatureGroupType) fgpb.getActual().getFeatureType() ;
    }
    else
    {
      // Reports error.
      String errorMsg = "prototypeBindingResolver : " + 
          pb.getClass().getSimpleName()+
          " is not supported yet." ;

      System.err.println(errorMsg);
      throw new UnsupportedOperationException(errorMsg) ;
    }
    
    return result ;
  }

  /**
   * Returns the DataClassifier of the element binded to the given 
   * Value object. A target instance can be given to this method as 
   * Target instance can be cast into ValueVariable reference.
   * <BR><BR>
   *  Notes: <BR><BR>
   *  <BR>_ ValueVariable : {@link #getClassifier(Element, Classifier)} 
   *                                 to see the restrictions.
   *  <BR>_ ValueConstant : Property constant and property reference are not supported:
   *  returns {@code null}.
   *  <BR><BR>
   * 
   * @param v the given Value object
   * @return the binded component's DataClassifier object or {@code null} for
   * the ValueConstant objects
   * @exception UnsupportedOperationException for unsupported binded 
   * object types.
   */
  public static DataClassifier getDataClassifier(Value v)
  {
    return getDataClassifier(v, null) ;
  }
  
  /**
   * Returns the DataClassifier object associated to the given Target object.  
   * 
   * @param t the given Target object
   * @return the DataClassifier object
   * @exception UnsupportedOperationException for unsupported cases
   */
  public static DataClassifier getDataClassifier(Target t)
  {
    return getDataClassifier(t, null);
  }
  
  
  /**
   * Returns the DataClassifier object associated to the given List of PrototypeBinging objects.
   * 
   * @param prototypeBindings the list of PrototypeBinging object
   * @param dp the DataPrototype searched for in prototypeBindings
   * @return the DataClassifier object (null if not found)
   */
  private static DataClassifier getDataClassifier(List<PrototypeBinding> prototypeBindings, DataPrototype dp)
  {
    for(PrototypeBinding pb: prototypeBindings)
    {
      if(pb instanceof ComponentPrototypeBinding && pb.getFormal().equals(dp))
      {
        ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) pb;
        ComponentPrototypeActual cpa = cpb.getActuals().get(cpb.getActuals().size()-1);
        if(cpa.getSubcomponentType() instanceof DataClassifier)
          return (DataClassifier) cpa.getSubcomponentType();
      }
    }
    return null;
  }
  
  /**
   * Returns the DataClassifier object associated to the given Target object.
   * 
   * @param t the given Target object
   * @param parentContainer the object that contains the element binded to the
   * given Target Object (and not the Target container)
   * @return the DataClassifier object
   * @exception UnsupportedOperationException for unsupported cases
   */
  public static DataClassifier getDataClassifier(Target t, NamedElement parentContainer)
  {
    NamedElement result ;
    
    if (t instanceof DataHolder)
    {
      result = ((DataHolder) t).getElement();
    }
    else if (t instanceof DataComponentReference)
    {
      DataComponentReference r = (DataComponentReference) t;
      DataHolder h = r.getData().get(r.getData().size() - 1);
      result = ((DataHolder) h).getElement();
    }
    else
    {
      throw new UnsupportedOperationException('\'' +
        t.getClass().getSimpleName() + "\' is not yet supported") ;
    }
    
    if(result instanceof DataClassifier)
    {
      return (DataClassifier) result ;
    }
    else if(result instanceof DataSubcomponent)
    {
      DataSubcomponentType dst = ((DataSubcomponent) result).getDataSubcomponentType(); 
      if(dst instanceof DataPrototype)
      {
        DataPrototype dp = (DataPrototype) dst;
        if (t instanceof DataComponentReference)
        {
          DataComponentReference r = (DataComponentReference) t;
          return prototypeBindingResolverForDataComponentReference(r, dp, parentContainer);
        }
      }
      else if(dst instanceof DataClassifier)
        return (DataClassifier) dst;
    }
    else if (result instanceof BehaviorVariable)
    {
      BehaviorVariable bv = (BehaviorVariable) result;
      return bv.getDataClassifier();
    }
    else if(result instanceof DataAccess)
    {
      DataAccess da = (DataAccess) result;
      if(da.getDataFeatureClassifier() instanceof DataClassifier)
        return (DataClassifier) da.getDataFeatureClassifier();
      else if(da.getDataFeatureClassifier() instanceof Prototype)
      {
        return (DataClassifier) getClassifier(da.getDataFeatureClassifier(), (Classifier) parentContainer);
      }
    }
    else if (result instanceof Parameter)
    {
      Parameter p = (Parameter) result;
      if(p.getDataFeatureClassifier() instanceof DataClassifier)
        return (DataClassifier) p.getDataFeatureClassifier();
      else if(p.getDataFeatureClassifier() instanceof Prototype)
      {
        return (DataClassifier) getClassifier(p.getDataFeatureClassifier(), (Classifier) parentContainer);
      }
    }
    else // Abstract components case.
    {
      return null ;
    }
    // Prototype case
    return null;
  }
  
  
  /**
   * Returns the DataClassifier object associated to prototype binding in a DataComponentReference
   * 
   * @param r the DataComponentRefenrence object from which the binding will be resolved
   * @param dp the DataPrototpye object that enables to identify the targeted prototype binding
   * @param parentContainer the object that contains the element binded to the
   * given DataComponentRefenrence
   * @return the DataClassifier object
   */
  private static DataClassifier
          prototypeBindingResolverForDataComponentReference(DataComponentReference r,
                                                            DataPrototype dp,
                                                            NamedElement parentContainer)
  {
    if(r.getData().size()>1)
    {
      DataHolder h = r.getData().get(r.getData().size() - 2);
      NamedElement parent = h.getElement();
      if(parent instanceof Classifier)
      {
        Classifier c = (Classifier) parent;
        return getDataClassifier(c.getOwnedPrototypeBindings(), dp);
      }
      if(parent instanceof Subcomponent)
      {
        Subcomponent s = (Subcomponent) parent;
        return getDataClassifier(s.getOwnedPrototypeBindings(), dp);
      }
      else if (parent instanceof DataAccess)
      {
        DataAccess da = (DataAccess) parent;
        DataSubcomponentType parentDst = da.getDataFeatureClassifier();
        Classifier c = (Classifier) parentDst;
        DataClassifier matchedPrototype = getDataClassifier(c.getOwnedPrototypeBindings(), dp);
        if(matchedPrototype == null)
        {
          if(parentContainer instanceof ComponentType)
          {
            ComponentType ct = (ComponentType) parentContainer;
            for(Feature f: ct.getOwnedFeatures())
            {
              if(f instanceof DataAccess && f.getName().equals(parent.getName()))
              {
                DataAccess containerDa = (DataAccess) f;
                DataSubcomponentType containerDst = containerDa.getDataFeatureClassifier();
                Classifier c2 = (Classifier) containerDst;
                return getDataClassifier(c2.getOwnedPrototypeBindings(), dp);
              }
            }
          }
        }
      }
      else if(parent instanceof DataPort)
      {
        DataPort dataport = (DataPort) parent;
        DataSubcomponentType parentDst = dataport.getDataFeatureClassifier();
        Classifier c = (Classifier) parentDst;
        DataClassifier matchedPrototype = getDataClassifier(c.getOwnedPrototypeBindings(), dp);
        if(matchedPrototype == null)
        {
          if(parentContainer instanceof ComponentType)
          {
            ComponentType ct = (ComponentType) parentContainer;
            for(Feature f: ct.getOwnedFeatures())
            {
              if(f instanceof DataPort && f.getName().equals(parent.getName()))
              {
                DataPort containerDp = (DataPort) f;
                DataSubcomponentType containerDst = containerDp.getDataFeatureClassifier();
                Classifier c2 = (Classifier) containerDst;
                return getDataClassifier(c2.getOwnedPrototypeBindings(), dp);
              }
            }
          }
        }
      }
    }
    return null;
  }

  /**
   * Returns the DataClassifier of the element binded to the given 
   * Value object. A target instance can be given to this method as 
   * Target instance can be cast into ValueVariable reference.
   * <BR><BR>
   *  Notes: <BR><BR>
   *  <BR>_ ValueVariable : {@link #getClassifier(Element, Classifier)} 
   *                                 to see the restrictions.
   *  <BR>_ ValueConstant : Property constant and property reference are not supported:
   *  returns {@code null}.
   *  <BR><BR>
   * 
   * @param v the given Value object
   * @param parentContainer only for AADLBA declarative objects which have no
   * parent set, yet
   * @return the binded component's DataClassifier object or {@code null} for
   * the ValueConstant objects and for the Abstract components objects.
   * @exception UnsupportedOperationException for unsupported binded 
   * object types.
   */
  public static DataClassifier getDataClassifier(Value v, ComponentClassifier
                                                                parentContainer)
  {
    Classifier result = null ;
    
    if(v instanceof ValueVariable)
    {
      // Either ElementHolder or DataComponentReference object.
      Element el = null ;
      
      if(v instanceof ElementHolder)
      {
        el = ((ElementHolder)v).getElement() ;
      }
      else // DataComponentReference case.
      {
        DataComponentReference dcr = (DataComponentReference) v ;
        
        DataHolder lastElement = dcr.getData().get(dcr.getData().size()-1) ;
        el = lastElement.getElement() ;
      }
      
      if(parentContainer == null)
      {
        parentContainer = (ComponentClassifier) v.getContainingClassifier() ;
      }
      
      result = getClassifier(el, parentContainer) ;
    }
    else // Property constant and property reference are not supported.
    {
      result = null ;
    }
    
    if(result instanceof DataClassifier)
    {
      return (DataClassifier) result ;
    }
    else // Abstract components case.
    {
      return null ;
    }
  }

  private static TypeHolder getTypeHolder(DataClassifier klass)
  {
    TypeHolder result = new TypeHolder() ;
    result.klass = klass ;
    result.dataRep = getDataRepresentation(klass) ;
    return result ;
  }

  /**
   * Returns the TypeHolder (data representation and component's DataClassifier
   * if any) of the given Value object.
   * <BR><BR>
   * Notes: {@link #getDataRepresentation(PropertyType)} and 
   *        {@link #getDataClassifier(Value)} to see restrictions. 
   * <BR><BR>
   * @param v the given Value object
   * @param parentContainer only for AADLBA declarative objects which have no
   * parent set, yet
   * @return the type holder of the given Value object
   * @exception UnsupportedOperationException for the unsupported types
   */
  private static TypeHolder getTypeHolder(Value v,
                                          ComponentClassifier parentContainer)
  {
    TypeHolder result = new TypeHolder();

    try
    {
      result.dataRep = getDataRepresentation(v) ;
    } catch (UnsupportedOperationException e)
    {
      result.dataRep = DataRepresentation.UNKNOWN ;
    }

    // Port count value and port fresh value are, respectively, universal
    // integer and universal boolean. So their data classifier field must be 
    // null.
    if(v instanceof ValueVariable &&
       (! (v instanceof PortCountValue || v instanceof PortFreshValue))
      )
    {
      result.klass = getDataClassifier(v, parentContainer) ;
    }
    // else: nothing.
    // getDataClassifier doesn't support property constant and property reference

    return result ;
  }

  /**
   * Returns the TypeHolder (data representation and component's DataClassifier
   * if any) of the given IterativeVariable object.
   * 
   * @param uccr the given IterativeVariable object.
   * @return the type holder of the given IterativeVariable
   * object.
   * @exception UnsupportedOperationException for the unsupported types
   */
  private static TypeHolder getTypeHolder(IterativeVariable iv)
  {
    TypeHolder result = new TypeHolder();
    result.klass = iv.getDataClassifier() ;
    result.dataRep = getDataRepresentation(result.klass) ;

    return result ;
  }
  
  /**
   * Returns the TypeHolder (data representation and component's DataClassifier
   * if any) of the given Element object.
   * <BR><BR>
   * For now, only the following objects are supported:<BR>
   * <BR>_ IterativeVariable
   * <BR>_ DataClassifier
   * <BR>_ Target
   * <BR>_ Value
   * <BR><BR>
   * 
   * @param el the given Element object.
   * @return the type holder of the given Element object
   * @exception UnsupportedOperationException for the unsupported types
   * or Element instances.
   * @exception DimensionException in any case of array dimension overflow. 
   */
  public static TypeHolder getTypeHolder(Element el)
                                                      throws DimensionException
  {
    return getTypeHolder(el, null) ;
  }
                                    
  /**
   * Returns the TypeHolder (data representation and component's DataClassifier
   * if any) of the given Element object.
   * <BR><BR>
   * For now, only the following objects are supported:<BR>
   * <BR>_ IterativeVariable
   * <BR>_ DataClassifier
   * <BR>_ Target
   * <BR>_ Value
   * <BR><BR>
   * 
   * @param el the given Element object.
   * @param parentContainer only for AADLBA declarative objects which have no
   * parent set, yet
   * @return the type holder of the given Element object. If the given element
   * is null, it returns the default type holder object.
   * @exception UnsupportedOperationException for the unsupported types
   * or Element instances.
   * @exception DimensionException in any case of array dimension overflow. 
   */
  public static TypeHolder getTypeHolder(Element el,
                                         ComponentClassifier parentContainer)
                                                      throws DimensionException
  {
    TypeHolder result = null ;
    
    if (el instanceof IterativeVariable)
    {
      IterativeVariable iv = (IterativeVariable) el ;
      
      result = getTypeHolder(iv) ;
      
      processArrayDataRepresentation(el, result, 0) ;
      
      return result ;
    }
    else if (el instanceof DataClassifier)
    {
      DataClassifier dc = (DataClassifier) el ;
      result = getTypeHolder(dc) ;
      return result ;
    }
    else if (el instanceof ValueConstant)
    {
      return result = getTypeHolder((ValueConstant) el, parentContainer) ;
    }
    else if(el instanceof Target || el instanceof ValueVariable )
    {  
      result = getTypeHolder((Value) el, parentContainer) ;

      // The declared variable dimension: the number of [] in the element 
      // declaration.
      int declaredDim = 0 ;

      // The expression dimension: the number of [] in the expression.
      // Only targets and values can express dimension. 
      int exprDim = 0 ;

      boolean hasToProcessDataRepresentation = false ;
      
      // Flag in order to process data representation if declared dimension
      // is zero and if the given element is an element values of a
      // for/forall statement.
      if(el.eContainer() instanceof ForOrForAllStatement)
      {
         hasToProcessDataRepresentation = true ;
      }
      
      // Either ElementHolder or DataComponentReference object.
      Element bindedEl = null ;
      ElementHolder elHolder = null ;
      
      if(el instanceof ElementHolder)
      {
        elHolder = (ElementHolder) el ; 
        bindedEl = elHolder.getElement() ;
      }
      else // DataComponentReference case.
      {
        DataComponentReference dcr = (DataComponentReference) el ;
        
        elHolder = dcr.getData().get(dcr.getData().size()-1) ;
      }
      
      bindedEl = elHolder.getElement() ;
      
      if(elHolder instanceof IndexableElement)
      {
        IndexableElement ie = (IndexableElement) elHolder ;
        
        if(ie.isSetArrayIndexes())
        {
          exprDim = ie.getArrayIndexes().size() ;
        }
      }
      
      // Set up the declared, expression dimension and dimension sizes.
      if(bindedEl instanceof ArrayableElement)
      {
        ArrayableElement ae = (ArrayableElement) bindedEl ;

        if(false == ae.getArrayDimensions().isEmpty())
        {
          EList<ArrayDimension> adl = ae.getArrayDimensions() ; 

          declaredDim = adl.size() ;

          if(exprDim <= declaredDim)
          {
            long[] ds = new long[declaredDim - exprDim];
            for(int i=exprDim; i<declaredDim; i++)
            {
              ds[i-exprDim]=adl.get(i).getSize().getSize();
            }
            result.dimension_sizes=ds;
          }
        }
      }
      
      // The given type is not expressed as an array in AADL standard core
      // way.
      // Let's evaluate the array behavior of the given type in the Data
      // Model Annex standard way if any dimension is expressed (exprDim !=0)
      // or if the element is an element values of a for/forall statement.
      if(declaredDim == 0 && (exprDim > 0 || hasToProcessDataRepresentation))
      {
         processArrayDataRepresentation(el, result, exprDim) ;
      }
      else
      {
        if(exprDim <= declaredDim)
        {
          result.dimension = declaredDim - exprDim ;
        }
        else
        {
          // The given type is expressed as an array in AADL standard
          // core way. We don't evaluate array behavior expressed in 
          // the Data Model Annex standard as we don't want to mix up
          // the two standards.
          String msg = "mixs up AADL standard array and data model array" ;
          throw new DimensionException(el, msg, true) ;
        }
      }
      
      return result ;
    }
    else if (el == null || el instanceof Abstract)
    {
      // returns the default type holder for untyped prototypes.
      return new TypeHolder() ; 
    }
    else
    {
      String errorMsg = "getTypeHolder : " + el.getClass().getSimpleName()
          + " is not supported yet at line " +
          Aadl2Utils.getLocationReference(el).getLine() + "." ;
      System.err.println(errorMsg) ;
      throw new UnsupportedOperationException(errorMsg) ;
    }
  }
  
  // Evaluates the array behavior of the given type in the Data Model Annex
  // standard way. Set up dimension and dimension sizes of the given  
  // TypeHolder object.
  // The given expression dimension is used as an dimension offset.
  private static void processArrayDataRepresentation(Element el,
                                                     TypeHolder type,
                                                     int exprDim)
                                                      throws DimensionException
  {
    // Treats only type declared as an array. Otherwise returns.
    if(type.dataRep == DataRepresentation.ARRAY)
    {
      // Fetches the array element data type.             
      ClassifierValue cv = AadlBaUtils.getBaseType(type.klass) ;

      if(cv != null && cv.getClassifier() instanceof DataClassifier)
      {
        DataClassifier dc = (DataClassifier) cv.getClassifier() ; 
        type.klass = dc ;
        type.dataRep = AadlBaUtils.getDataRepresentation(dc) ;
      }
      else
      {
        type.klass = null ;
      }
      
      EList<PropertyExpression> pel = 
                                 PropertyUtils.findPropertyExpression(type.klass,
                                                DataModelProperties.DIMENSION) ;
      int declareDimBT = 0 ;
      long[] declareDimSizeBT ;

      if(false == pel.isEmpty())
      {
         // pel has only one element, according to AADL core standard.
         PropertyExpression pe = pel.get(pel.size() - 1);
         
         if(pe instanceof ListValue)
         {
           ListValue lv = (ListValue) pe;
           EList<PropertyExpression> lve = lv.getOwnedListElements() ;
           declareDimBT= lve.size() ;
               
          if(declareDimBT >= exprDim)
          {
            declareDimSizeBT = new long[declareDimBT - exprDim] ;

            for(int i = exprDim ; i < declareDimBT ; i++)
            {
              IntegerLiteral il = (IntegerLiteral) lve.get(i) ;
              declareDimSizeBT[i - exprDim] = il.getValue() ;
            }

            type.dimension = declareDimBT - exprDim ;
            type.dimension_sizes = declareDimSizeBT ;
          }
          else
          {
            String msg = "must be an array but is resolved as " +
                           type.klass.getQualifiedName() ;
            
            throw new DimensionException(el, msg, false) ;
          }
        }
      }
      else 
      {
        // Returning -1 and null means that the expression is declared as an
        // array but the dimension property is not set.  
        
        type.dimension = -1 ;
        type.dimension_sizes = null ;
        return ;
//        String msg = "is declared as an array but the dimension property is not set" ;
//        throw new DimensionException(el, msg, true) ;
      }
    }
    else
    {
      return ;
    }
  }
  
  /**
   * Compare a given name to a given list of behavior named
   * elements. The matching is base on behavior named element's name
   * (case insensitive).
   * 
   * @param name the given name
   * @param lbne the given list of behavior named elements
   * @return the first behavior named element form the given list which has the
   * same name as the given name. {@code null} otherwise
   */
  public static <T extends BehaviorNamedElement> T compareNamedElementList
                                                                (String name,
                                                                 EList<T> lbne)
  {
    for(T bne2 : lbne)
    {
      if(name.equalsIgnoreCase(bne2.getName()))
      {
        return bne2 ;
      }
    }

    return null ;
  }
  
  /**
   * Compare the given Target objects.<BR><BR> 
   * 
   * This comparator is base on name and not on object's hash number, meaning 
   * that two different Target instances with the same name are 
   * considered as equals.
   * 
   * This comparator doesn't support array indexes comparison, meaning that two
   * target instances with the same name and different array indexes
   * are considered as equals.
   * <BR><BR>
   * 
   * @param tar0 the first name
   * @param tar1 the second name
   * @return {@code true} if the given Target objects are the same.
   * Otherwise returns {@code false}  
   */
  public static boolean isSameTarget(Target tar0, Target tar1)
  {
    if(tar0 instanceof ElementHolder && tar1 instanceof DataComponentReference ||
       tar1 instanceof ElementHolder && tar0 instanceof DataComponentReference)
    {
      return false ;
    }
    else
    {
      if(tar0 instanceof ElementHolder && tar1 instanceof ElementHolder)
      {
        return isSameElementHolder((ElementHolder)tar0, (ElementHolder)tar1) ;
      }
      else
      {
        EList<DataHolder> dhl0 = ((DataComponentReference) tar0).getData() ;
        EList<DataHolder> dhl1 = ((DataComponentReference) tar1).getData() ;
        
        if(dhl0.size() == dhl1.size())
        {
          ListIterator<DataHolder> it1 = dhl1.listIterator() ;
          DataHolder dh1 = null ;
          boolean result = true ;
          
          for(DataHolder dh0 : dhl0)
          {
            dh1 = it1.next() ;
            result &= isSameElementHolder(dh0, dh1) ;
          }
          
          return result ;
        }
        else
        {
          return false ;
        }
      }
    }
  }
  
  private static boolean isSameElementHolder(ElementHolder eh0,
                                             ElementHolder eh1)
  {
    String name0 = eh0.getElement().getName() ;
    String name1 = eh1.getElement().getName() ;
    
    return name0.equalsIgnoreCase(name1) ;
  }

  /**
   * Create a behavior time comparator.<BR><BR>
   * 
   * This comparator supports time units (from AADL property set Time_Units)
   * comparison. For example, comparing 60 sec and 1 min returns 0.<BR><BR>
   * 
   * It only supports behavior time objects with integer constant literal.
   * Otherwise it throws a ClassCastException. 
   * 
   * @return a behavior time comparator
   * @throws UnsupportedOperationException if behavior time objects are not 
   * integer constant literal
   */
  public static Comparator<BehaviorTime> createBehaviorTimeComparator()
  {
    return new Comparator<BehaviorTime>()
    {
      public int compare(BehaviorTime behT1, BehaviorTime behT2)
      {
        IntegerValue iv1 = behT1.getIntegerValue() ;
        IntegerValue iv2 = behT2.getIntegerValue() ;

        if(iv1 instanceof BehaviorIntegerLiteral &&
            iv2 instanceof BehaviorIntegerLiteral)
        {
          double d1 = new Long(((BehaviorIntegerLiteral)iv1).getValue())
          .doubleValue() ;
          double d2 = new Long(((BehaviorIntegerLiteral)iv2).getValue())
          .doubleValue() ;

          UnitLiteral unit1 = (UnitLiteral) behT1.getUnit() ;
          UnitLiteral unit2 = (UnitLiteral) behT2.getUnit() ;

          double relativeFact = unit1.getAbsoluteFactor(unit2) ; 

          // Convert to the smallest time unit. In order to keep 
          // the highest precision.
          if (relativeFact < 1)
          {
            d2 *= unit2.getAbsoluteFactor(unit1) ; 
          }
          else
          {
            d1 *= relativeFact ;
          }

          return (d1<d2 ? -1 : (d1==d2 ? 0 : 1));
        }
        else
        {
          throw new UnsupportedOperationException("Can only compare " + 
              "BehaviorTime with IntegerLiteral at line " +
              behT1.getLocationReference().getLine() + ".") ;
        }
      }
    } ;
  }

  /**
   * Analyze the given AADL Osate element and return its enumeration type.
   * 
   * It's an improved version of Osate2 org.osate.parser.AadlSemanticCheckSwitch#getFeatureType 
   *  
   * @param el the given AADL Osate element
   * @return the given AADL Osate element's type
   * @exception UnsupportedOperationException for the unsupported types
   */
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
  public static org.osate.ba.aadlba.FeatureType getFeatureType(Element el)
  {
    if (el instanceof DataPort)
    {
      switch (((DataPort)el).getDirection())
      {
      case IN:
        return FeatureType.IN_DATA_PORT;
      case OUT:
        return FeatureType.OUT_DATA_PORT;
      case IN_OUT:
        return FeatureType.IN_OUT_DATA_PORT;
      }
    }
    else if (el instanceof EventPort)
    {
      switch (((EventPort)el).getDirection())
      {
      case IN:
        return FeatureType.IN_EVENT_PORT;
      case OUT:
        return FeatureType.OUT_EVENT_PORT;
      case IN_OUT:
        return FeatureType.IN_OUT_EVENT_PORT;
      }
    }
    else if (el instanceof EventDataPort)
    {
      switch (((EventDataPort)el).getDirection())
      {
      case IN:
        return FeatureType.IN_EVENT_DATA_PORT;
      case OUT:
        return FeatureType.OUT_EVENT_DATA_PORT;
      case IN_OUT:
        return FeatureType.IN_OUT_EVENT_DATA_PORT;
      }
    }
    else if (el instanceof FeatureGroup)
      return FeatureType.FEATURE_GROUP;
    else if (el instanceof DataAccess)
    {
      switch (((DataAccess)el).getKind())
      {
      case PROVIDES:
        return FeatureType.PROVIDES_DATA_ACCESS;
      case REQUIRES:
        return FeatureType.REQUIRES_DATA_ACCESS;
      }
    }
    else if (el instanceof SubprogramAccess)
    {
      switch (((SubprogramAccess)el).getKind())
      {
      case PROVIDES:
        return FeatureType.PROVIDES_SUBPROGRAM_ACCESS;
      case REQUIRES:
        return FeatureType.REQUIRES_SUBPROGRAM_ACCESS;
      }
    }
    else if (el instanceof SubprogramGroupAccess)
    {
      switch (((SubprogramGroupAccess)el).getKind())
      {
      case PROVIDES:
        return FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS;
      case REQUIRES:
        return FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS;
      }
    }
    else if (el instanceof BusAccess)
    {
      switch (((BusAccess)el).getKind())
      {
      case PROVIDES:
        return FeatureType.PROVIDES_BUS_ACCESS;
      case REQUIRES:
        return FeatureType.REQUIRES_BUS_ACCESS;
      }
    }
    else if (el instanceof AbstractFeature)
      return FeatureType.ABSTRACT_FEATURE;

    // **** BEGIN IMPROVEMENT ************************************************
    
    else if (el instanceof Parameter)
    {
      switch(((Parameter) el).getDirection())
      {
      case IN:
        return FeatureType.IN_PARAMETER ;

      case OUT:
        return FeatureType.OUT_PARAMETER ;

      case IN_OUT:
        return FeatureType.IN_OUT_PARAMETER ;
      }
    }
    else if (el instanceof Prototype)
    {
      if (el instanceof ComponentPrototype)
      {
        switch (el.eClass().getClassifierID())
        {
          case Aadl2Package.SUBPROGRAM_PROTOTYPE:
            return FeatureType.SUBPROGRAM_PROTOTYPE ;
          case Aadl2Package.SUBPROGRAM_GROUP_PROTOTYPE:
            return FeatureType.SUBPROGRAM_GROUP_PROTOTYPE;
          case Aadl2Package.THREAD_PROTOTYPE:
            return FeatureType.THREAD_PROTOTYPE;
          case Aadl2Package.THREAD_GROUP_PROTOTYPE:
            return FeatureType.THREAD_GROUP_PROTOTYPE;
          default: return FeatureType.COMPONENT_PROTOTYPE ;
        }
      }
      else if(el instanceof FeaturePrototype)
      {
        return getFeaturePrototypeType((FeaturePrototype) el) ;
      }
      else if (el instanceof FeatureGroupPrototype)
      {
        return FeatureType.FEATURE_GROUP_PROTOTYPE ;
      }
    }
    else if (el instanceof PrototypeBinding)
    {
      if(el instanceof ComponentPrototypeBinding)
      {
        return FeatureType.COMPONENT_PROTOTYPE_BINDING ;
      }
      else if (el instanceof FeatureGroupPrototypeBinding)
      {
        return FeatureType.FEATURE_GROUP_PROTOTYPE_BINDING ;
      }
      else // FeaturePrototypeBinding case. 
      {
        return FeatureType.FEATURE_PROTOTYPE_BINDING ;
      }
    }
    else if (el instanceof org.osate.aadl2.PropertyConstant)
      return FeatureType.PROPERTY_CONSTANT ;
    else if (el instanceof org.osate.aadl2.Property)
      return FeatureType.PROPERTY_VALUE ;
    else if (el instanceof ClassifierValue)
      return FeatureType.CLASSIFIER_VALUE ;
    else if (el instanceof SubprogramGroup)
      return FeatureType.SUBPROGRAM_GROUP ;
    else if (el instanceof SubprogramGroupAccess)
    {
      switch (((SubprogramGroupAccess)el).getKind())
      {
        case PROVIDES: return FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS ;
        case REQUIRES: return FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS ;
      }
    }
    else if (el instanceof ThreadGroup )
      return FeatureType.THREAD_GROUP ;
    else if (el instanceof SystemSubcomponent)
      return FeatureType.SYSTEM_SUBCOMPONENT ;
            
            
    // ALWAYS PUT THE FOLLOWING TESTS AT THE END OF THE METHOD :
    // these classifiers are high level classifiers.

    else if (el instanceof SubprogramSubcomponent)
      return FeatureType.SUBPROGRAM_SUBCOMPONENT ;
    else if (el instanceof SubprogramClassifier)
      return FeatureType.SUBPROGRAM_CLASSIFIER ;
    else if (el instanceof DataSubcomponent)
      return FeatureType.DATA_SUBCOMPONENT ;
    else if (el instanceof DataClassifier)
      return FeatureType.DATA_CLASSIFIER ;
    else if (el instanceof ProcessorClassifier)
    {
      return FeatureType.PROCESSOR_CLASSIFIER ;
    }
    else if (el instanceof ProcessClassifier)
    {
      return FeatureType.PROCESS_CLASSIFIER ;
    }

    String errorMsg = "getFeatureType : " + el.getClass().getSimpleName()+ 
        " is not supported yet at line " +
        Aadl2Utils.getLocationReference(el).getLine() +
        "." ;
    System.err.println(errorMsg) ;
    throw new UnsupportedOperationException(errorMsg) ;
  }

  /**
   * Analyze the given behavior annex feature and returns its type.
   * 
   * @param el the given behavior annex feature
   * @return the given behavior annex feature's type
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static BehaviorFeatureType getBehaviorAnnexFeatureType(
                                                             BehaviorElement el)
  {
    if(el instanceof org.osate.ba.aadlba.BehaviorVariable)
      return BehaviorFeatureType.BEHAVIOR_VARIABLE ;
    else if (el instanceof IterativeVariable)
      return BehaviorFeatureType.ITERATIVE_VARIABLE ;

    String errorMsg = "feature : " + el.getClass().getSimpleName()+ 
        " is not supported yet." ;
    System.err.println(errorMsg) ;
    throw new UnsupportedOperationException(errorMsg) ;
  }

  /**
   * If the given value expression is composed of an single value, it returns
   * this value otherwise {@code null}. Recursive method.
   * 
   * @param ve the given value expression
   * @return the value or {@code null}
   */
  public static Value isOnlyOneValue(ValueExpression ve)
  {
    Relation firstRelation = ve.getRelations().get(0) ;
    SimpleExpression firstSE = firstRelation.getFirstExpression() ;
    Term firstTerm = firstSE.getTerms().get(0) ;
    Factor firstFactor = firstTerm.getFactors().get(0) ;
    Value firstValue = firstFactor.getFirstValue() ; 

    if(ve.getRelations().size() == 1)
    {
      if(firstRelation.getSecondExpression() == null)
      {
        if(firstSE.getTerms().size() == 1)
        {
          if(firstTerm.getFactors().size() == 1)
          {
            if (firstFactor.getSecondValue() == null)
            {
              // Recursive case.
              if(firstValue instanceof ValueExpression)
              {
                return isOnlyOneValue((ValueExpression) firstValue) ;
              }
              else
              {
                return firstValue ;
              }
            }
          }
        }
      }
    }

    return null ;
  }

  /**
   * Translates the given ComponentPrototypeBinding object into a FeatureType
   * enumeration.
   * 
   * @param cpb the given ComponentPrototypeBinding
   * @return the translation in FeatureType object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static FeatureType getCompPrototypeType(ComponentPrototypeBinding cpb)
  {
    ComponentPrototypeActual cpa = cpb.getActuals().get(
                                                    cpb.getActuals().size()-1) ;
    switch(cpa.getCategory())
    {
      case SUBPROGRAM:
        return FeatureType.SUBPROGRAM_PROTOTYPE ;
      case SUBPROGRAM_GROUP:
        return FeatureType.SUBPROGRAM_GROUP_PROTOTYPE ;
      case THREAD:
        return FeatureType.THREAD_PROTOTYPE ;
      case THREAD_GROUP:
        return FeatureType.THREAD_GROUP_PROTOTYPE ;
      
      default :
      {
        // Reports error.
        String errorMsg = "getCompPrototypeType : " + 
              cpa.getCategory() + " is not supported yet." ;
        System.err.println(errorMsg);
        throw new UnsupportedOperationException(errorMsg) ;
      }
    }
  }
  
  /**
   * Translates the given FeaturePrototypeBinding object into a FeatureType
   * enumeration.
   * 
   * @param fpb the given FeaturePrototypeBinding
   * @return the translation in FeatureType object
   * @exception UnsupportedOperationException for the unsupported types
   */
  public static FeatureType getFeatPrototypeType(FeaturePrototypeBinding fpb)
  {
    FeaturePrototypeActual fpa = fpb.getActual() ;

    if(fpa instanceof AccessSpecification)
    {
      AccessSpecification as = (AccessSpecification) fpa ;

      boolean isRequired = as.getKind() == AccessType.REQUIRES ;

      switch(as.getCategory())
      {
      case BUS :
      {
        return  (isRequired) ? FeatureType.REQUIRES_BUS_ACCESS_PROTOTYPE :
          FeatureType.PROVIDES_BUS_ACCESS_PROTOTYPE ;
      }

      case DATA :
      {
        return  (isRequired) ? FeatureType.REQUIRES_DATA_ACCESS_PROTOTYPE :
          FeatureType.PROVIDES_DATA_ACCESS_PROTOTYPE ;
      }

      case SUBPROGRAM :
      {
        return  (isRequired) ? FeatureType.REQUIRES_SUBPROGRAM_ACCESS_PROTOTYPE:
          FeatureType.PROVIDES_SUBPROGRAM_ACCESS_PROTOTYPE ;
      }

      case SUBPROGRAM_GROUP :
      {
        return  (isRequired) ? 
          FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE :
          FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS_PROTOTYPE ;
      }

      }
    }
    else if (fpa instanceof PortSpecification)
    {
      PortSpecification ps = (PortSpecification) fpa ;

      if(ps.getCategory() == PortCategory.DATA)
      {
        switch (ps.getDirection())
        {
        case IN : return  FeatureType.IN_DATA_PORT_PROTOTYPE ; 
        case OUT : return  FeatureType.OUT_DATA_PORT_PROTOTYPE ; 
        case IN_OUT : return  FeatureType.IN_OUT_DATA_PORT_PROTOTYPE ; 
        }
      }
      else if (ps.getCategory() == PortCategory.EVENT)
      {
        switch (ps.getDirection())
        {
        case IN : return  FeatureType.IN_EVENT_PORT_PROTOTYPE ; 
        case OUT : return  FeatureType.OUT_EVENT_PORT_PROTOTYPE ; 
        case IN_OUT : return  FeatureType.IN_OUT_EVENT_PORT_PROTOTYPE ; 
        }
      }
      else
      {
        switch (ps.getDirection())
        {
        case IN : return  FeatureType.IN_EVENT_DATA_PORT_PROTOTYPE ; 
        case OUT : return  FeatureType.OUT_EVENT_DATA_PORT_PROTOTYPE ; 
        case IN_OUT : return  FeatureType.IN_OUT_EVENT_DATA_PORT_PROTOTYPE ; 
        }
      }
    }
    else if(fpa instanceof FeatureGroupPrototypeActual)
    {
      return FeatureType.FEATURE_GROUP_PROTOTYPE ;
    }
    else
    {
      // Reports error.
      String errorMsg = "getFeatPrototypeType : " + 
          fpa.getClass().getSimpleName() + " is not supported yet." ;
      System.err.println(errorMsg);
      throw new UnsupportedOperationException(errorMsg) ;
    }

    return FeatureType.NONE ;
  }

  private static FeatureType getFeaturePrototypeType(FeaturePrototype fp)
  {
    switch (fp.getDirection())
    {
    case IN : return FeatureType.IN_FEATURE_PROTOTYPE ;
    case OUT : return FeatureType.OUT_FEATURE_PROTOTYPE ;
    case IN_OUT : return FeatureType.IN_OUT_FEATURE_PROTOTYPE ;
    default : return FeatureType.FEATURE_PROTOTYPE ;
    }
  }

  /**
   * Returns the direction type of the given Element or {@code null} if the 
   * given Element is not an instance of DirectedFeature excepted 
   * DataSubcomponent.<BR><BR>
   * 
   * Note: DataSubcomponent returns DirectionType.IN_OUT <BR><BR>
   * 
   * @param el the given Element
   * @return the direction type or {@code null}
   */
  private static DirectionType getDirectionType(Element el)
  {
    if(el instanceof DirectedFeature)
    {
      return ((DirectedFeature) el).getDirection() ;
    }
    else if (el instanceof DataSubcomponent)
    {
      return DirectionType.IN_OUT ;
    }
    else
    {
      return null ;
    }
  }

  /**
   * Returns the last value of the base type property of the given component or
   * {@code null} if the base type property is not set.
   * 
   * @param component the given component
   * @return the last value of the base type property or {@code null}
   */
  public static ClassifierValue getBaseType(Classifier component) 
  {
    PropertyExpression pe ;
    EList<PropertyExpression> le ;
    Element el ;

    EList<PropertyExpression> lpe = 
                                PropertyUtils.findPropertyExpression(component,
                                                DataModelProperties.BASE_TYPE) ;
    if(lpe != null && (! lpe.isEmpty()))
    {
      pe = lpe.get(lpe.size() -1) ;

      // Syntax with ()
      if(pe instanceof ListValue)
      {
        le = ((ListValue) pe).getOwnedListElements() ;

        if(le != null && (! le.isEmpty()))
        {
          el = le.get(le.size() -1) ;

          if(el instanceof ClassifierValue)
          {
            return (ClassifierValue) el ;
          }
        }
      }
      // Syntax without ()
      else if(pe instanceof ClassifierValue)
      {
        return (ClassifierValue) pe ;
      }
    }

    return null ;
  }

  /**
   * Returns the direction type of the object binded to the given Target or 
   * {@code null} if the binded object is not an instance of : <BR><BlockQuote> 
   * _ DirectedFeature.<BR>
   * _ Data subcomponent.<BR>
   * _ Local variable.<BR></BlockQuote>
   * (see {@link #getDirectionType(org.osate.aadl2.Element)}).
   * <BR><BR>
   * Notes:<BR><BR>
   * _  Behavior variable always returns DirectionType.IN_OUT as
   *    behavior variable is a valid Target and ValueVariable.
   * <BR><BR>   
   * _ Iterative variable always returns DirectionType.IN as iterative variables
   *   is a valid value variable but not a target.
   * <BR><BR>
   * _ Data subcomponent always returns DirectionType.IN_OUT as
   *   data subcomponent is valid Target and ValueVariable.
   * 
   * <BR><BR>
   * @param tar the given Target
   * @return the direction type or {@code null}
   */
  public static DirectionType getDirectionType(Target tar)
  {
    if(tar instanceof IterativeVariable)   
    {
      return DirectionType.IN ;
    }
    else if(tar instanceof BehaviorVariableHolder)
    {
      return DirectionType.IN_OUT ;
    }
    else if(tar instanceof ElementHolder) // The other ElementHolders.
    {
      return getDirectionType(((ElementHolder)tar).getElement()) ;
    }
    else // Data component reference. 
    {
      EList<DataHolder> dhl = ((DataComponentReference)tar).getData() ;
      
      return getDirectionType(dhl.get(dhl.size() -1).getElement()) ;
    }
  }
  
  /**
   * If the given Target object is a DataAccessHolder object or a
   * DataComponentReference object which the last element is a DataAccessHolder
   * object, it returns the data access right or "unknown" if the default
   * data access right is not set.
   * 
   * @see org.osate.utils.Aadl2Utils#getAccessRight
   * @param tar the given Target object
   * @return the data access right or "unknown"
   */
  public static String getAccessRight(Target tar)
  {
    ElementHolder el = null ;
    
    if(tar instanceof ElementHolder) // The other ElementHolders.
    {
      el = (ElementHolder) tar ;
    }
    else // Data component reference. 
    {
      EList<DataHolder> dhl = ((DataComponentReference)tar).getData() ;
      el = dhl.get(dhl.size() -1) ;
    }
    
    if (el instanceof DataAccessHolder          ||
        el instanceof DataAccessPrototypeHolder ||
        el instanceof FeaturePrototypeHolder)
    {
      return Aadl2Utils.getAccessRight(el.getElement()) ;
    }
    else
    {
      return "unknown" ;
    }
  }
  
  /**
   * Same as {@link #getAccessRight(Target)}, if the given Target object is a
   * DataAccessHolder object or a DataComponentReference object which the last
   * element is a DataAccessHolder object, it returns the DataAccessRight enum
   * reference or {@link org.osate.utils.Aadl2Utils.DataAccessRight#unknown} if the default data access
   * right is not set.
   * 
   * @see org.osate.utils.Aadl2Utils#getAccessRight
   * @param tar the given Target object
   * @return the data access right or {@link org.osate.utils.Aadl2Utils.DataAccessRight#unknown}
   */
  public static DataAccessRight getDataAccessRight(Target tar)
  {
    return DataAccessRight.getDataAccessRight(getAccessRight(tar)) ;
  }  

  /**
   * Returns the name of the given ModeTransitionTrigger object.
   * 
   * @param mtt the given ModeTransitionTrigger object
   * @return a name
   */
  public static String getName(ModeTransitionTrigger mtt)
  {
    return mtt.getTriggerPort().getName() ;
  }
  
  /**
   * Compares behavior transition priorities. 
   * 
   * Returns {@code true} if bt1 priority is > bt2 or bt2 has otherwise execution
   * condition and bt1 hasn't. Otherwise returns {@code false}. 
   * 
   * @param bt1 a behavior transition
   * @param bt2 an other behavior transition
   * @return  {@code true} if bt1 priority is > bt2 or bt2 has otherwise execution
   * condition and bt1 hasn't. Otherwise {@code false}. 
   */
  public static boolean compareBehaviorTransitionPriority(BehaviorTransition bt1,
                                                         BehaviorTransition bt2)
  {
    boolean o1 = bt1.getCondition() instanceof Otherwise ;
    boolean o2 = bt2.getCondition() instanceof Otherwise ;
    
    long p1 = (bt1.getPriority() >= 0) ? 
                                        (bt1.getPriority()) :
                                        (AadlBaVisitors.DEFAULT_TRANSITION_PRIORITY) ;
    
    long p2 = (bt2.getPriority() >= 0) ? 
                                        (bt2.getPriority()) :
                                        (AadlBaVisitors.DEFAULT_TRANSITION_PRIORITY) ;
            
    boolean p = p1 > p2 ;
    
    if (o1 || o2)
    {
      if(o1 && o2)
      {
        return p ;
      }
      else
      {
        return o2 ;
      }
    }
    else
    {
      return p ;
    }
  }
  
  /**
   * If the given PropertyReference object represents a string literal from
   * a property string list declared in a classifier (property Enumerators), it
   * returns the Classifier object and the StringLiteral object
   * (see DataModelEnumLiteral). Otherwise, it throws an
   * OperationNotSupportedException.
   * 
   * @see DataModelEnumLiteral
   * @param ref the given PropertyReference object
   * @return a DataModelEnumLiteral object
   * @throws OperationNotSupportedException
   */
  public static DataModelEnumLiteral toDataModelEnumLiteral(PropertyReference ref)
                                           throws OperationNotSupportedException
  {
    DataModelEnumLiteral result = new DataModelEnumLiteral() ;
    
    if(ref instanceof ClassifierPropertyReference)
    {
      ClassifierPropertyReference cpr = (ClassifierPropertyReference) ref ;
      result.classifier = cpr.getClassifier() ;
      
      EList<PropertyNameHolder> properties = cpr.getProperties() ;
      
      if(properties.size() == 2)
      {
        // The first property name is supposed to be a property association 
        // Enumerators. Don't need to check it. 
        
        result.stringLiteral = extractStringLiteral(properties.get(1)) ;
      }
      else
      {
        throw new OperationNotSupportedException("this property reference not supported") ;
      }
      
    }
    else
    {
      throw new OperationNotSupportedException(ref.getClass().getSimpleName() +
                                               " not supported") ;
    }
    
    return result ;
  }
  
  // If the given PropertyNameHolder object only contains a StringLiteral, 
  // it returns it. Otherwise it throws an OperationNotSupportedException.
  private static StringLiteral extractStringLiteral(PropertyNameHolder pnh)
                                           throws OperationNotSupportedException
  {
    if(pnh.getField() != null)
    {
      throw new OperationNotSupportedException("property fields not supported");
    }
    else
    {
      Element el = pnh.getProperty().getElement() ;
      
      if(el instanceof StringLiteral)
      {
        return (StringLiteral) el ;
      }
      else
      {
        throw new UnsupportedOperationException(el.getClass().getSimpleName() 
                                                + " not supported") ;
      }
    }
  }
}
