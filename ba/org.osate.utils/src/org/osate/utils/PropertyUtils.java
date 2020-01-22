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

import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.Aadl2Factory ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.AadlInteger ;
import org.osate.aadl2.AbstractNamedValue ;
import org.osate.aadl2.BasicProperty ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.BooleanLiteral ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ClassifierValue ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.ComputedValue ;
import org.osate.aadl2.ContainedNamedElement ;
import org.osate.aadl2.ContainmentPathElement ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RangeValue ;
import org.osate.aadl2.RealLiteral ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.RefinableElement ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.UnitLiteral ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.xtext.aadl2.properties.util.AadlProject ;
import org.osate.xtext.aadl2.properties.util.GetProperties ;

/**
 * Toolbox to extract property values from AADL components instances.
 */
public class PropertyUtils {
  
  /**
   * Returns the latest definition of the property association that matches to
   * the given propertyName for the given named element. Otherwise it returns
   * {@code null}.
   * <br><br>
   * Property association evaluation order is as follow:
   * <br><br>
   * 1. Find the property association within the given named element itself.
   * <br>
   * 2. Find the property association that applies to the given named element
   *    within the named element's parent containers.
   * <br>
   * 3. If the named element is a component instance, find the property
   *    association within the component instance's component implementation.
   * <br>
   * 4. If the named element is a component implementation, first look within
   *    it and its ancestors then its component type (and the component type
   *    's ancestors).
   * <br>   
   * 5. If the named element is a component type, find the property association
   *    within it and its ancestors. 
   * 
   * @param propertyName a given property name
   * @param owner a given named element
   * @return the latest definition of the property association that matches
   * the given propertyName or {@code null}.
   */
  public static PropertyAssociation findPropertyAssociation(String propertyName,
                                                 NamedElement owner)
  {
    // 1. Look within the owner.    
    for (PropertyAssociation pa : owner.getOwnedPropertyAssociations())
    {
      // Sometime property doesn't have name.
      if (pa.getProperty().getName() == null)
      {
        continue;
      }

      if (pa.getProperty().getName().equalsIgnoreCase(propertyName))
      {
        return pa;
      }
    }

    PropertyAssociation result = null ;
    
    // 2. Look within parent containers if they defined an property that applies
    // the given property.

    result = isInAppliesTo(owner, propertyName) ;
    
    if(result == null)
    {
      List<PropertyAssociation> pas = new ArrayList<PropertyAssociation>() ;
      
      // 3. If the named element is a component instance, look within 
      // its associated component implementation.
      
      if (owner instanceof ComponentInstance)
      {
        ComponentInstance inst = (ComponentInstance) owner;
        ComponentImplementation ci = inst.getContainingComponentImpl();
        if(ci != null)
        {
          owner = ci ;
        }
      }
      
      // 4. If the named element is a component implementation, look within it.
      //    and its interface. 
      
      if(owner instanceof ComponentImplementation)
      {
        ComponentImplementation ci = (ComponentImplementation) owner ;
        pas.addAll(ci.getAllPropertyAssociations()) ;
        owner = ci.getType() ;
      }
      
      // 5. If the named element is a component type, look within it. 
      
      if(owner instanceof ComponentType)
      {
        ComponentType type = (ComponentType) owner;
        pas.addAll(type.getAllPropertyAssociations()) ;
      }
      
      if(false == pas.isEmpty())
      {
        // The first property association found represents the latest definition
        // of the given property.
        for(PropertyAssociation pa : pas)
        {
          Property p = pa.getProperty() ;
          // Sometime, properties don't have name.
          if(p.getName() != null && p.getName().equalsIgnoreCase(propertyName))
          {
            result = pa ;
            break ;
          }
        }
      }
    }
    
    return result ;
  }
  
  private static PropertyAssociation isInAppliesTo(NamedElement owner,
                                                   String propertyName)
  {
    EObject parent = owner.eContainer() ;
    String ownerName = owner.getName() ;
    
    while(parent != null)
    {
      if(parent instanceof NamedElement)
      {
        EList<PropertyAssociation> pas = ((NamedElement)parent).
                                                getOwnedPropertyAssociations() ;
        
        for(PropertyAssociation pa: pas)
        {
          String propName = pa.getProperty().getName() ;
          
          if(propName != null && propName.equalsIgnoreCase(propertyName))
          {
            for (ContainedNamedElement cne: pa.getAppliesTos())
            {
              EList<ContainmentPathElement> paths = cne.getContainmentPathElements() ;
              ContainmentPathElement lastEl = paths.get(paths.size()-1) ;
              String lastElName = lastEl.getNamedElement().getName() ;
              if(lastElName.equalsIgnoreCase(ownerName))
              {
                return pa ;
              }
            }
          }
        }
      }
      
      parent = parent.eContainer() ;
    }
    
    return null ;
  }
  
  /**
   * Extract integer value from a specified property. Convert it
   * to a given unit. 
   * May return null
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @param unit
   * 			target unit for conversion
   * @return property value.
   */
  public static Long getIntValue(NamedElement i, String propertyName, String targetUnit) {
	    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

	    if (pa != null) {
	      Property p = pa.getProperty();

	      if (p.getName().equalsIgnoreCase(propertyName)) {
	        List<ModalPropertyValue> values = pa.getOwnedValues();

	        if (values.size() == 1) {
	          ModalPropertyValue v = values.get(0);
	          PropertyExpression expr = v.getOwnedValue();

	          if (expr instanceof IntegerLiteral) {
	            IntegerLiteral il = (IntegerLiteral) expr;
	            final UnitLiteral unit = il.getUnit();
	            if (unit != null) {
	              // Warning: the cast from double to long is licit
	              // only if the result of the conversion is an
	              // integer
	              return (long) il.getScaledValue(targetUnit);
	            }

	            return ((IntegerLiteral) expr).getValue();
	          }
	        }
	      }
	    }

	    return null ;
	  }
  
  
  /**
   * Extract integer value from a specified property. May return null
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static Long getIntValue(NamedElement i, String propertyName) {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof IntegerLiteral) {
            return ((IntegerLiteral) expr).getValue();
          }
        }
      }
    }

    return null ;
  }

  /**
   *    * TODO: DOC ME !
   * 
   * May return null
   * 
   * @param i
   * @param propertyName
   * @return
   */
  public static RecordValue getRecordValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof RecordValue) {
            return ((RecordValue) expr);
          }
        }
      }
    }

    return null ;
  }
  
  public static List<RecordValue> getListRecordValue(NamedElement ne,
                                                     String propertyName)
  {
    List<RecordValue> result = null ;
    
    ListValue lv = getListValue(ne, propertyName) ;
    
    if(lv != null)
    {
      EList<PropertyExpression> pes = lv.getOwnedListElements() ;
      
      if(pes.size() != 0 && pes.get(0) instanceof RecordValue)
      {
        result = new ArrayList<RecordValue>(pes.size()) ;
        
        for (PropertyExpression pe : pes)
        {
          result.add((RecordValue) pe) ;
        }
      }
    }
    
    return result ;
  }
  
  public static ListValue getListValue(NamedElement ne,
                                       String propertyName)
  {
     PropertyAssociation pa = findPropertyAssociation(propertyName, ne);

     if (pa != null)
     {
       Property p = pa.getProperty();

       if (p.getName().equalsIgnoreCase(propertyName))
       {
         List<ModalPropertyValue> values = pa.getOwnedValues();

         if (values.size() == 1)
         {
           ModalPropertyValue v = values.get(0);
           PropertyExpression expr = v.getOwnedValue();

           if (expr instanceof ListValue)
           {
             return (ListValue) expr;
           }
         }
       }
     }
     
     return null ;
  }
                                               
  /**
   * Extract float value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static Float getFloatValue(NamedElement i, String propertyName, String unit)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof NumberValue) {
            NumberValue val = (NumberValue) expr;
            float fVal = 0f;

            if (val instanceof IntegerLiteral) {
              fVal = ((IntegerLiteral) val).getValue();
            } else if (val instanceof RealLiteral) {
              fVal = (float) ((RealLiteral) val).getValue();
            }

            return UnitConversion.convertInMs(fVal, val.getUnit().getName());
          }
        }
      }
    }
    // try on a refined NamedElement
    if(i instanceof RefinableElement)
    {
      RefinableElement re = (RefinableElement) i;
      if(re.getRefinedElement()!=null)
      return getFloatValue(re.getRefinedElement(), propertyName, unit);
    }
    
    return null ;
  }

  /**
   * Extract float value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static Float getFloatValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof IntegerLiteral) {
            return (float) ((IntegerLiteral) expr).getValue();
          } else if (expr instanceof RealLiteral) {
            return (float) ((RealLiteral) expr).getValue();
          }
        }
      }
    }
    // try on a refined NamedElement
    if(i instanceof RefinableElement)
    {
      RefinableElement re = (RefinableElement) i;
      if(re.getRefinedElement()!=null)
      return getFloatValue(re.getRefinedElement(), propertyName);
    }
    
    return null ;
  }

  /**
   * Extract boolean value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static Boolean getBooleanValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof BooleanLiteral) {
            return (boolean) ((BooleanLiteral) expr).getValue();
          }
        }
      }
    }

    return null ;
  }

  /**
   * Extract String value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static String getStringValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof StringLiteral) {
            return ((StringLiteral) expr).getValue();
          }
        }
      }
    }

    return null ;
  }

  /**
   * Extract String list value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static List<String> getStringListValue(NamedElement i, String propertyName)
  {
    List<String> res = new ArrayList<String>();
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;

            for (PropertyExpression pe : lv.getOwnedListElements()) {
              if (pe instanceof StringLiteral) {
                StringLiteral sl = (StringLiteral) pe;
                res.add(sl.getValue());
              } else if (pe instanceof NamedValue) {
                NamedValue nv = (NamedValue) pe;

                if (nv.getNamedValue() instanceof EnumerationLiteral) {
                  EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
                  res.add(el.getName());
                }
              }
            }

            if (!res.isEmpty()) {
              return res;
            }
          }
        }
      }
    }

    return null ;
  }

  /**
   * Extract enumeration value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   *             enumeration.
   */
  public static String getEnumValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof EnumerationLiteral) {
            return ((EnumerationLiteral) expr).getName();
          } else if (expr instanceof NamedValue) {
            NamedValue nv = (NamedValue) expr;

            if (nv.getNamedValue() instanceof EnumerationLiteral) {
              EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
              return el.getName();
            }
          }
        }
      }
    }
    // try on a refined NamedElement
    if(i instanceof RefinableElement)
    {
      RefinableElement re = (RefinableElement) i;
      if(re.getRefinedElement()!=null)
      return getEnumValue(re.getRefinedElement(), propertyName);
    }
    return null ;
  }

  /**
   * Extract range value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static RangeValue getRangeValue(NamedElement i, String propertyName) {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof RangeValue) {
            return (RangeValue) expr;
          }
        }
      }
    }

    return null;
  }

  /**
   * Extract minimum range value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static NumberValue getMinRangeValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof RangeValue) {
            NumberValue n = ((RangeValue) expr).getMinimumValue();
            return n;
          } else if (expr instanceof NumberValue) {
            return (NumberValue) expr;
          }
        }
      }
    }

    return null ;
  }

  /**
   * Extract maximum range value from a specified property. May return null.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static NumberValue getMaxRangeValue(NamedElement i, String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, i);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof RangeValue) {
            NumberValue n = ((RangeValue) expr).getMaximumValue();
            return n;
          } else if (expr instanceof NumberValue) {
            return (NumberValue) expr;
          }
        }
      }
    }

    return null ;
  }

  /**
   * Extract maximum range value from a specified property.
   * 
   * @param i
   *            component instance.
   * @param propertyName
   *            property name.
   * @return property value.
   */
  public static double getMaxRangeValue(NamedElement i, String propertyName,
                                        float defaultValue)
  {
    RealLiteral rl = (RealLiteral) getMaxRangeValue(i, propertyName) ;
    if(rl != null)
    {
      return rl.getValue() ;
    }
    else
    {
      return defaultValue ;
    }
  }
  
  /**
   * TODO: DOC ME !
   * 
   * May return null.
   * 
   * @param propertyName
   * @param owner
   * @return
   */
  public static ComponentInstance getPropertyComponentRef(String propertyName,
                                                          NamedElement owner)
  {
    PropertyExpression val = getPropertyValue(propertyName, owner);
    if(val != null)
    {
      return (ComponentInstance) ((InstanceReferenceValue) val).
                                                  getReferencedInstanceObject();
    }
    else
    {
      return null ;
    }
  }
  
  /**
   * TODO: DOC ME !
   * 
   * May return null.
   * 
   * @param propertyName
   * @param owner
   * @return
   */
  public static PropertyExpression getPropertyValue(String propertyName,
                                                    NamedElement owner)
  {
    PropertyAssociation assign = findPropertyAssociation(propertyName, owner);

    if (assign != null) {
      return assign.getOwnedValues().get(0).getOwnedValue();
    }

    return null ;
  }

  /**
   * TODO: DOC ME !
   * 
   * May return null.
   * 
   * @param owner
   * @param propertyName
   * @return
   */
  public static Classifier getClassifierValue(NamedElement owner,
                                              String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, owner);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof ClassifierValue) {
            return ((ClassifierValue) expr).getClassifier();
          }
        }
      }
    }

    return null ;
  }

  public static PropertyAssociation createIntegerAssignment(String propertyName,
                                                            long value)
  {
    Property property = Aadl2Factory.eINSTANCE.createProperty();
    PropertyAssociation assignment = Aadl2Factory.eINSTANCE.createPropertyAssociation();
    ModalPropertyValue modalPropertyValue = Aadl2Factory.eINSTANCE.createModalPropertyValue();
    IntegerLiteral propertyValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
    property.setName(propertyName);
    propertyValue.setValue(value);
    modalPropertyValue.setOwnedValue(propertyValue);
    assignment.setProperty(property);
    assignment.getOwnedValues().add(modalPropertyValue);
    return assignment;
  }

  public static boolean setFloatValue(NamedElement e, String propertyName,
                                      float value)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, e);

    if (pa != null)
    {
      RealLiteral r = Aadl2Factory.eINSTANCE.createRealLiteral();
      r.setValue(value);
      r.setUnit(getUnit(pa));
      pa.getOwnedValues().get(0).setOwnedValue(r);
      return true;
    }

    return false;
  }
  
  // May return null.
  private static UnitLiteral getUnit(PropertyAssociation pa)
  {
    PropertyExpression e = pa.getOwnedValues().get(0).getOwnedValue() ;
    if(e instanceof NumberValue)
    {
      return ((NumberValue) e).getUnit() ;
    }
    else if(e instanceof RangeValue)
    {
      return ((RangeValue) e).getMaximumValue().getUnit() ;
    }
    else
    {
      return null ;
    }
  }
  
  /**
   * TODO: DOC ME !
   * 
   * May return null.
   * 
   * 
   * @param object
   * @param propertyName
   * @return
   */
  public static List<ComponentInstance> getComponentInstanceList(NamedElement object,
                                                            String propertyName)
  {
    List<ComponentInstance> res = null ;
    PropertyAssociation pa = findPropertyAssociation(propertyName, object) ;

    if(pa != null)
    {
      res = new ArrayList<ComponentInstance>() ;
      Property p = pa.getProperty() ;

      if(p.getName().equals(propertyName))
      {
        List<ModalPropertyValue> values = pa.getOwnedValues() ;

        if(values.size() == 1)
        {
          ModalPropertyValue v = values.get(0) ;
          PropertyExpression expr = v.getOwnedValue() ;

          if(expr instanceof ListValue)
          {
            ListValue lv = (ListValue) expr ;

            for(PropertyExpression pe : lv.getOwnedListElements())
            {
              if(pe instanceof InstanceReferenceValue)
              {
                InstanceReferenceValue c = ((InstanceReferenceValue) pe) ;
                res.add((ComponentInstance)c.getReferencedInstanceObject()) ;
              }
            }
          }
        }
      }
    }

    return res ;
  }
  
  /**
   * May return an empty list.
   * 
   * 
   * @param object
   * @param propertyName
   * @return
   */
  public static List<Subcomponent> getSubcomponentList(NamedElement object,
                                                       String propertyName)
  {
    List<Subcomponent> res = new ArrayList<Subcomponent>() ;
    PropertyAssociation pa = findPropertyAssociation(propertyName, object) ;
    if (pa == null)
      return null ;
    else {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) 
      {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;
            
            for(PropertyExpression pe : lv.getOwnedListElements())
            {
              if(pe instanceof ReferenceValue)
              {
                ReferenceValue c = ((ReferenceValue) pe) ;
                for(ContainmentPathElement cpe :
                  c.getContainmentPathElements())
                {
                  res.add((Subcomponent) cpe.getNamedElement()) ;
                }
              }
            }
          }
        }
      }
      return res;
    }
  }
  
  /**
   * 
   * TODO: DOC ME !
   * 
   * May return null.
   * 
   * 
   * @param object
   * @param propertyName
   * @return
   */
  public static List<Long> getIntListValue(NamedElement object,
                                           String propertyName)
  {
    List<Long> res = new ArrayList<Long>();
    PropertyAssociation pa = findPropertyAssociation(propertyName, object);

    if (pa == null)
      return null ;
    else {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;

            for (PropertyExpression pe : lv.getOwnedListElements()) {
              if (pe instanceof IntegerLiteral) {
                Long c = ((IntegerLiteral) pe).getValue();
                res.add(c);
              }
            }
          }
        }
      }
    }
    // try on a refined NamedElement
    if(object instanceof RefinableElement)
    {
      RefinableElement re = (RefinableElement) object;
      if(re.getRefinedElement()!=null)
      {
        List<Long> l = getIntListValue((ProcessorSubcomponent)re.getRefinedElement(),
                                   propertyName) ;
        if(l != null)
        {
          res.addAll(l);
        }
      }
    }
    return res;
  }

  /**
   * May return an empty list.
   * 
   * 
   * @param object
   * @param propertyName
   * @return
   */
  public static List<Subcomponent> getSubcomponentList(ProcessorSubcomponent object,
                                                       String propertyName)
  {
    List<Subcomponent> res = new ArrayList<Subcomponent>();
    PropertyAssociation pa = findPropertyAssociation(propertyName, object);

    if (pa != null) {
      Property p = pa.getProperty();

      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();

        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();

          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;

            for (PropertyExpression pe : lv.getOwnedListElements()) {
              if (pe instanceof ReferenceValue) {
                ReferenceValue c = ((ReferenceValue) pe);
                ContainmentPathElement cpe = c.getContainmentPathElements().
                                   get(c.getContainmentPathElements().size()-1);
                res.add((Subcomponent) cpe.getNamedElement());
              }
            }
          }
        }
      }
    }
    // try on a refined NamedElement
    if(object instanceof RefinableElement)
    {
      RefinableElement re = (RefinableElement) object;
      if(re.getRefinedElement()!=null)
      {
        List<Subcomponent> l = getSubcomponentList((ProcessorSubcomponent)re.getRefinedElement(),
                                                   propertyName) ;
        if(! l.isEmpty())
        {
          res.addAll(l);
        }
      }
    }
    return res;
  }
  
   /**
   * Returns the list of property expressions (PropertyExpression) associated
   * to a given property name {@link #findPropertyAssociation(String, NamedElement)}.
   * The list may be empty.
   * 
   * @see #findPropertyAssociation(String, NamedElement)
   * @param ne the given named element
   * @param propertyName the given property
   * @return the list of property expressions. The list may be empty.
   */
  public static EList<PropertyExpression> findPropertyExpression(NamedElement ne,
                                                            String propertyName)
  {
    PropertyAssociation pa = findPropertyAssociation(propertyName, ne) ;
    
    if(pa != null)
    {
      return getPropertyExpression(pa) ;
    }
    else
    {
      return new BasicEList<PropertyExpression>(0) ;
    }
  }
  
  /**
   * Returns the list of PropertyExpression objects binded to the 
   * given PropertyAssociation. The list may be empty.
   * 
   * @param pa the given property association
   * @return the list of property expressions. The list may be empty
   */

  public static EList<PropertyExpression> getPropertyExpression(
                                                   PropertyAssociation pa)
  {
    EList<ModalPropertyValue> lmpv = null ;
    EList<PropertyExpression> result = new BasicEList<PropertyExpression>();

    lmpv = pa.getOwnedValues() ;

    for(ModalPropertyValue mpv : lmpv)  
    {
      result.add(mpv.getOwnedValue());
    }
    return result ;
  }

  /**
   * Returns the first property expression or abstract named element (
   * EnumerationLiteral, Property, PropertyConstant, UnitLiteral) that matches
   * to the given String object within the given ProperyExpression object.
   * If the property expression doesn't exist, it returns {@code null}. 
   * 
   * @param pe the given ProperyExpression object
   * @param toBeMatched the given String object
   * @return the first matching property expression or abstract named element.
   * otherwise return {@code null}
   * 
   * @throws UnsupportedOperationException for other property values than:
   *   _ StringLiteral
   *   _ ListValue (recursion supported)
   *   _ ClassifierValue
   *   _ InstanceReferenceValue
   *   _ ComputedValue
   *   _ RecordValue (based on field matching)
   *   _ NamedValue (returns abstract named element)
   */
  public static Element getValue(PropertyExpression pe,
                                 String toBeMatched)
  {
    Element tmp = null ;
    int id = pe.eClass().getClassifierID() ;
    
    switch(id)
    {
      case Aadl2Package.STRING_LITERAL:
      {
        StringLiteral sl = (StringLiteral) pe ;
        if(sl.getValue().equalsIgnoreCase(toBeMatched))
        {
          return sl ;
        }
        
        return null ;
      }
      
      case Aadl2Package.LIST_VALUE:
      {
        ListValue lv = (ListValue) pe ;
        
        EList<PropertyExpression> pel = lv.getOwnedListElements() ;
        for(PropertyExpression ownedPe : pel)
        {
          tmp = getValue(ownedPe, toBeMatched) ;
          
          if(tmp != null)
          {
            return tmp ;
          }
        }
        
        return null ;
      }
      
      case Aadl2Package.RECORD_VALUE:
      {
        RecordValue rv = (RecordValue) pe ;
        for (BasicPropertyAssociation bpa : rv.getOwnedFieldValues())
        {
          if(bpa.getProperty().getName().equalsIgnoreCase(toBeMatched))
          {
            return bpa.getValue() ;
          }
        }
        
        return null ;
      }
      
      case Aadl2Package.CLASSIFIER_VALUE:
      {
        ClassifierValue cv = (ClassifierValue) pe ;
        if(cv.getClassifier().getName().equalsIgnoreCase(toBeMatched))
        {
          return cv ;
        }
        else
        {
          return null ;
        }
      }
      
      case Aadl2Package.REFERENCE_VALUE:
      {
        InstanceReferenceValue irv = (InstanceReferenceValue) pe ;
        if(irv.getReferencedInstanceObject().getName().
                                                  equalsIgnoreCase(toBeMatched))
        {
          return irv ;
        }
        else
        {
          return null ;
        }
      }
      
      case Aadl2Package.COMPUTED_VALUE:
      {
        ComputedValue cv = (ComputedValue) pe ;
        if(cv.getFunction().equalsIgnoreCase(toBeMatched))
        {
          return  cv ;
        }
        else
        {
          return null ;
        }
      }
      
      case Aadl2Package.NAMED_VALUE:
      {
        NamedValue nv = (NamedValue) pe ;
        AbstractNamedValue anv = nv.getNamedValue() ;
        if(anv instanceof NamedElement)
        {
          NamedElement ne = (NamedElement) anv ;
          String name = ((NamedElement)anv).getName() ;
          
          // Consider as a final node.
          if(name.equalsIgnoreCase(toBeMatched))
          {
            return ne ;
          }
          else if(ne instanceof Property) // Or a structure.
          {
            Property p = (Property) ne ;
            if(p.getDefaultValue() != null)
            {
              tmp = getValue(p.getDefaultValue(), toBeMatched) ;
              return tmp ;
            }
          }
        }
        else
        {
          String msg = anv.getClass().getSimpleName() + " is not supported" ;
          System.err.println(msg) ;
          throw new UnsupportedOperationException(msg) ;
        }
        
        return null ;
      }
      
      default:
      {
        String msg = pe.getClass().getSimpleName() + " is not supported" ;
        System.err.println(msg) ;
        throw new UnsupportedOperationException(msg) ;
      }
    }
  }
  
  /**
   * Returns the BasicProperty (Property or RecordField) object that the given
   * PropertyExpression object belongs.
   * 
   * @param pe the given PropertyExpression object
   * @return the BasicProperty object that contains the given PropertyExpression object
   */
  public static BasicProperty getContainingProperty(PropertyExpression pe)
  {
    EObject tmp = pe.eContainer() ;
    int classId = tmp.eClass().getClassifierID() ;
    
    while(false == (Aadl2Package.BASIC_PROPERTY_ASSOCIATION == classId ||
                    Aadl2Package.PROPERTY_ASSOCIATION == classId ||
                    Aadl2Package.PROPERTY == classId))
    {
      tmp = tmp.eContainer() ;
      classId = tmp.eClass().getClassifierID() ;
    }
    
    if(Aadl2Package.PROPERTY_ASSOCIATION == classId)
    {
      return ((PropertyAssociation)tmp).getProperty() ;
    }
    else if(Aadl2Package.BASIC_PROPERTY_ASSOCIATION == classId)
    {
      BasicPropertyAssociation bpa = (BasicPropertyAssociation) tmp ;
      return bpa.getProperty() ;
    }
    else
    {
      return ((Property)tmp) ;
    }
  }
}