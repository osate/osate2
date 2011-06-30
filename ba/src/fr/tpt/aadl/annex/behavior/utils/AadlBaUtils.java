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

package fr.tpt.aadl.annex.behavior.utils;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.Iterator ;
import java.util.List ;

import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.AadlBoolean ;
import edu.cmu.sei.aadl.aadl2.AadlInteger ;
import edu.cmu.sei.aadl.aadl2.AadlReal ;
import edu.cmu.sei.aadl.aadl2.AadlString ;
import edu.cmu.sei.aadl.aadl2.AbstractFeature ;
import edu.cmu.sei.aadl.aadl2.AccessSpecification;
import edu.cmu.sei.aadl.aadl2.AccessType;
import edu.cmu.sei.aadl.aadl2.ArrayableElement ;
import edu.cmu.sei.aadl.aadl2.BusAccess ;
import edu.cmu.sei.aadl.aadl2.Classifier;
import edu.cmu.sei.aadl.aadl2.ClassifierValue;
import edu.cmu.sei.aadl.aadl2.ComponentClassifier;
import edu.cmu.sei.aadl.aadl2.ComponentPrototype ;
import edu.cmu.sei.aadl.aadl2.ComponentPrototypeActual;
import edu.cmu.sei.aadl.aadl2.ComponentPrototypeBinding ;
import edu.cmu.sei.aadl.aadl2.ComponentReference;
import edu.cmu.sei.aadl.aadl2.DataAccess ;
import edu.cmu.sei.aadl.aadl2.DataClassifier ;
import edu.cmu.sei.aadl.aadl2.DataPort ;
import edu.cmu.sei.aadl.aadl2.DataSubcomponent ;
import edu.cmu.sei.aadl.aadl2.DirectedFeature ;
import edu.cmu.sei.aadl.aadl2.DirectionType ;
import edu.cmu.sei.aadl.aadl2.EnumerationValue ;
import edu.cmu.sei.aadl.aadl2.EventDataPort ;
import edu.cmu.sei.aadl.aadl2.EventPort ;
import edu.cmu.sei.aadl.aadl2.Feature ;
import edu.cmu.sei.aadl.aadl2.FeatureGroup ;
import edu.cmu.sei.aadl.aadl2.FeatureGroupPrototype ;
import edu.cmu.sei.aadl.aadl2.FeatureGroupPrototypeBinding ;
import edu.cmu.sei.aadl.aadl2.FeaturePrototype ;
import edu.cmu.sei.aadl.aadl2.FeaturePrototypeActual;
import edu.cmu.sei.aadl.aadl2.FeaturePrototypeBinding;
import edu.cmu.sei.aadl.aadl2.ListValue;
import edu.cmu.sei.aadl.aadl2.ModeTransitionTrigger ;
import edu.cmu.sei.aadl.aadl2.NamedElement ;
import edu.cmu.sei.aadl.aadl2.Parameter ;
import edu.cmu.sei.aadl.aadl2.PortCategory;
import edu.cmu.sei.aadl.aadl2.PortSpecification;
import edu.cmu.sei.aadl.aadl2.Property ;
import edu.cmu.sei.aadl.aadl2.PropertyExpression;
import edu.cmu.sei.aadl.aadl2.PropertyType ;
import edu.cmu.sei.aadl.aadl2.Prototype ;
import edu.cmu.sei.aadl.aadl2.PrototypeBinding ;
import edu.cmu.sei.aadl.aadl2.Subcomponent ;
import edu.cmu.sei.aadl.aadl2.SubprogramAccess ;
import edu.cmu.sei.aadl.aadl2.SubprogramClassifier ;
import edu.cmu.sei.aadl.aadl2.SubprogramGroupAccess ;
import edu.cmu.sei.aadl.aadl2.SubprogramSubcomponent ;
import edu.cmu.sei.aadl.aadl2.TriggerPort ;
import edu.cmu.sei.aadl.aadl2.UnitLiteral ;
import edu.cmu.sei.aadl.aadl2.Element ;

import fr.tpt.aadl.annex.behavior.aadlba.*;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.names.DataModelProperties;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser ;

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
      
      EList<PropertyExpression> l = 
                 AadlBaGetProperties.getPropertyExpression(c,
                		              DataModelProperties.DATA_REPRESENTATION) ;
      if(l.size() > 0)
      {
         // Fetches the last enumeration value from the inheritance stack of 
    	 // properties.
    	 String tmp = ((EnumerationValue)l.get(l.size()-1))
                                                       .getLiteral().getName() ;
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
      Element el = bv.getDataUniqueComponentClassifierReference().getAadlRef() ;
      
      return getDataRepresentation((DataClassifier) el) ;
   }
   
   /**
    * Returns the data representation associated to the given property type
    * object.
    * <BR><BR>
    * Note : this method doesn't support the following property types :
    * <BR>_ ClassifierType
    * <BR>_ EnumerationType
    * <BR>_ NumberType
    * <BR>_ RangeType
    * <BR>_ RecordType
    * <BR>_ ReferenceType
    * <BR>_ UnitsType
    * <BR><BR>
    * @param type the given property type object.
    * @return the data representation associated to the given property type 
    * object
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static DataRepresentation getDataRepresentation(PropertyType type)
   {
      if(type instanceof AadlInteger)
         return DataRepresentation.INTEGER ;
      else
         if(type instanceof AadlReal)
            return DataRepresentation.FLOAT ;
         else
            if (type instanceof AadlString)
               return DataRepresentation.STRING ;
            else
               if(type instanceof AadlBoolean)
                  return DataRepresentation.BOOLEAN ;
               else
               {
                  // TODO to be implemented ? :
                  // ClassifierType, EnumerationType, NumberType, RangeType,
                  // RecordType, ReferenceType, UnitsType cases.
                  String errorMsg = "getDataRepresentation : " +
                     type.getClass().getSimpleName()+
                        " from " + type.eContainer().toString() +
                                                      " is not supported yet." ;
                  System.err.println(errorMsg) ;
                  throw new UnsupportedOperationException(errorMsg) ;
               }
   }
   
   /**
    * Returns the data representation associated to the given behavior property
    * constant object <BR><BR>
    * Note : {@link #getDataRepresentation(PropertyType)} to see restrictions. 
    * <BR><BR> 
    * @param pc the given behavior property constant object
    * @return the data representation associated to the given behavior property
    * constant object
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static DataRepresentation getDataRepresentation(
                                                    BehaviorPropertyConstant pc)
   {
      return getDataRepresentation(((edu.cmu.sei.aadl.aadl2.PropertyConstant)
            pc.getAadlRef()).getOwnedType()) ;
   }
   
   /**
    * Returns the data representation associated to the given behavior property
    * value object <BR><BR>
    * Note : {@link #getDataRepresentation(PropertyType)} to see restrictions. 
    * <BR><BR>
    * @param pv the given behavior property value object
    * @return the data representation associated to the given behavior property
    * value object
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static DataRepresentation getDataRepresentation(
                                                       BehaviorPropertyValue pv)
   {
      return getDataRepresentation(((Property)pv.getAadlRef()).getOwnedType()) ;
   }
   
   /**
    * Returns the data representation associated to the given value constant.
    * object <BR><BR>
    * Note : {@link #getDataRepresentation(PropertyType)} 
    *                        to see restrictions on property constant and value. 
    * <BR><BR>
    * @param v the given value constant object
    * @return the data representation associated to the given value constant
    * object
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static DataRepresentation getDataRepresentation(ValueConstant v)
   {
      if(v instanceof BehaviorPropertyConstant)
      {
         return getDataRepresentation((BehaviorPropertyConstant) v)  ;
      }
      else 
      {
         if(v instanceof BehaviorPropertyValue)
         {
            return getDataRepresentation((BehaviorPropertyValue) v)  ;
         }
         
         if(v instanceof BehaviorIntegerLiteral)
         {
            return DataRepresentation.INTEGER ;
         }
         else
         {
            if(v instanceof BehaviorRealLiteral)
            {
               return DataRepresentation.FLOAT ;
            }
            else
            {
               if (v instanceof BehaviorStringLiteral)
               {
                  return DataRepresentation.STRING ;
               }
               else
               {
                  return DataRepresentation.BOOLEAN ;
               }
            }
         }
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
      else
      {
         if(v instanceof PortFreshValue)
         {
            return DataRepresentation.BOOLEAN ;
         }
         else
         {
            // Either Name or DataComponentReference object.
            Element el = AadlBaUtils.getBindedElement(v);
            
            if(el instanceof Feature)
            {
               return getDataRepresentation((DataClassifier)((Feature) el).
                                                              getClassifier()) ;
            }
            else if(el instanceof Subcomponent)
            {
               
               return getDataRepresentation((DataClassifier)((Subcomponent)
                         el).getClassifier());
                 
            }
            else if(el instanceof BehaviorVariable)
            {
            	// Behavior case.      
               return getDataRepresentation((BehaviorVariable)el) ;
            }
            else if (el instanceof UniqueComponentClassifierReference)
            {
               // Iterative variable case (Unique component classifier 
         	   // reference case).
               DataClassifier c = (DataClassifier) 
                     ((UniqueComponentClassifierReference) el).getAadlRef() ;
           
               return getDataRepresentation(c) ;
            }
            else
            {
            	// FeaturePrototypeBinding case.
            	Classifier klass ;
            	ComponentClassifier baParentComponent = 
            		         (ComponentClassifier) v.getContainingClassifier() ;
            	klass = AadlBaUtils.getClassifier(el, baParentComponent) ;
            	return getDataRepresentation((DataClassifier) klass) ;
            }
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
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static DataRepresentation getDataRepresentation(Value v)
   {
      if(v instanceof ValueVariable)
         return getDataRepresentation((ValueVariable) v) ;
      else return getDataRepresentation((ValueConstant) v) ;
   }

   /**
    * Concatenates the strings contained in the given array by inserting
    * between the strings, the given separator.
    * 
    * @param separator the given string separator
    * @param toBeConcatenated the given string array
    * @return the concatenated strings
    */
   public static String concatenateString(String separator,
                                   String ... toBeConcatenated)
   {
      StringBuilder result = new StringBuilder () ;
      
      for(String s : toBeConcatenated)
      {
         result.append(s) ;
         result.append(separator) ;
      }
      
      // Remove the last separator.
      result.delete(result.length()- separator.length(), result.length()) ;
      
      return result.toString() ;
   }
   
   /**
    * Returns {@code true} if the given string is found (case not sensitive)
    * into the given string array. Otherwise returns {@code false}.  
    * If the given string is {@code null}, it returns {@code false}.  
    * 
    * @param s the given string or {@code null}
    * @param stringArray the given string array
    * @return {@code true} if the given string is found (case not sensitive) 
    * into the given string array. Otherwise {@code false}. 
    */
   public static boolean contains(String s, String[] stringArray )
   {
      for(String tmp : stringArray)
      {
         if(tmp.equalsIgnoreCase(s))
         {
            return true ;
         }
      }
      
      return false ;
   }
   
   /**
    * Returns {@code true} if the given object is found (based on java address)
    * into the given object array. Otherwise returns {@code false}.  
    * If the given object is {@code null}, it returns {@code false}.  
    * 
    * @param element the given object or {@code null}
    * @param array the given object array
    * @return {@code true} if the given object is found ((based on java address)
    * into the given object array. Otherwise {@code false}. 
    */
   public static boolean contains(Object element, Object[] array)
   {
      for(Object tmp : array)
      {
         if(tmp.equals(element))
         {
            return true ;
         }
      }
      
      return false ;
   }
   
   /**
    * Returns the given element object's classifier. It will try to resolve 
    * data prototype and returns the data prototype binded classifier at first
    * then the constraining classifier. It returns {@code null} is the data
    * prototype is not defined.
    * <BR><BR>
    * This method support instance of:<BR>
    * <BR>_Feature (port, data access, subprogram access, parameter, etc.)
    * <BR>_Subcomponent (data subcomponent, subprogram subcomponent, etc.)
    * <BR>_BehaviorVariable
    * <BR>_UniqueComponentClassifierReference (for/forall's iterative variable)
    * <BR>_Prototype (all excepted FeatureGroupPrototype)
    * <BR>_PrototypeBinding (all excepted FeatureGroupPrototypeBinding)
    * <BR>_ClassifierValue (struct or union data subcomponent)
    * <BR><BR>
    * If the given Element object is not one of those types, an
    * UnsupportedOperationException is thrown. 
    * 
    * @param el the given Element object
    * @param baParentContainer the ba's parent component.
    * @return the given element's classifier or {@code null} if the data
    * prototype is not defined
    * @exception UnsupportedOperationException thrown for unsupported element
    * object types.
    */
   public static Classifier getClassifier(Element el,
		                                    ComponentClassifier baParentContainer)
   {
	  Classifier result = null ;
	   
	  if(el instanceof Feature) 
      {
		 // Feature case.
         result = ((Feature) el).getClassifier() ;
         
         // Resolves data prototype.
         if(result == null)
         {
        	 result = componentPrototypeResolver((ComponentPrototype)
        			                            ((Feature) el).getPrototype(),
        			                             baParentContainer) ;
         }
      }
	  else if(el instanceof Subcomponent) 
      {
    	 // Subcomponent case.
    	 result = ((Subcomponent) el).getClassifier();
             
         // Resolves data prototype.
         if(result == null)
         {
           result = componentPrototypeResolver(
             	                   ((Subcomponent) el).getPrototype(),
             			           baParentContainer) ;
         }
      }
	  else if(el instanceof BehaviorVariable) 
      {
    	 // Local variable case (BehaviorVariable).
    	 BehaviorVariable bv = (BehaviorVariable) el ;
         result = (Classifier)
                    bv.getDataUniqueComponentClassifierReference().getAadlRef();
      }
	  else if(el instanceof UniqueComponentClassifierReference)
      {      	
    	 // Iterative variable case (Unique component classifier 
         // reference case).
    	 result = (Classifier)
             ((UniqueComponentClassifierReference) el).getAadlRef() ;
      }
	  else if (el instanceof Prototype)
	  {
		 if(el instanceof ComponentPrototype)
		 {
			 ComponentPrototype cp = (ComponentPrototype) el ;
			 result = cp.getConstrainingClassifier() ;
		 }
		 else if (el instanceof FeaturePrototype)
		 {
			 FeaturePrototype fp = (FeaturePrototype) el ;
			 result = fp.getConstrainingClassifier() ;
		 }
		 else
		 {
			 // Reports error.
			 String errorMsg = "getClassifier : " + 
      	        el.getClass().getSimpleName()+
      	        " is not supported yet." ;
			 
			 System.err.println(errorMsg);
			 throw new UnsupportedOperationException(errorMsg) ;
		 }
	  }
	  else if (el instanceof PrototypeBinding)
      {
    	 // Prototype binding case.
    	  
    	 if (el instanceof FeaturePrototypeBinding)
         {
             FeaturePrototypeActual fpa ;
    		 fpa = ((FeaturePrototypeBinding)el).getActual() ;
    		 
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
    			 String errorMsg = "getClassifier : " + 
          	        fpa.getClass().getSimpleName()+
          	        " is not supported yet." ;
    			 
    			 System.err.println(errorMsg);
    			 throw new UnsupportedOperationException(errorMsg) ;
    		 }
         }
         else // ComponentPrototypeBinding case.
         {
            EList<ComponentPrototypeActual> lcpa ;
            lcpa = ((ComponentPrototypeBinding) el).getActuals() ;
            
            // Takes the last binding.
            ComponentPrototypeActual cpa = lcpa.get(lcpa.size() -1) ;
            
            if(cpa instanceof ComponentReference)
            {
            	result = ((ComponentReference) cpa).getClassifier() ;
            }
            else
            {
   			    // Reports error.
            	String errorMsg = "getClassifier : " + 
            	   cpa.getClass().getSimpleName()+
            	   " is not supported yet." ;
            	
   			    System.err.println(errorMsg);
   			    throw new UnsupportedOperationException(errorMsg) ;
   		    }
         }
      }
	  else 
      {
		 // struct or union member case (ClassifierValue).
         result = ((ClassifierValue) el).getClassifier() ;
      }

	  return result ;
   }
   
   /**
    * Resolves the given component prototype by returning the binded classifier
    * or if there is no binded classifier, the constraining classifier.
    * It returns {@code null} if the given component prototype is not defined. 
    * 
    * @param prototype the given component prototype
    * @param baParentContainer the ba's parent component
    * @return the binded classifier at first then the constraining classifier or
    * {@code null}
    */
   public static Classifier componentPrototypeResolver(
		                                  ComponentPrototype prototype,
		                                  ComponentClassifier baParentContainer)
   {
	   Classifier result = null ;
	   
	   // First find a prototype bind as prototype may be binded several times.
	   PrototypeBinding pb = AadlBaVisitors.findPrototypeBindingInComponent(
			                                baParentContainer,
			                                prototype.getName()) ;
	   
	   
       
	   if(pb != null)
	   {
		   ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) pb ;
		   
		   // Takes the last binding.
	       ComponentPrototypeActual cpa = cpb.getActuals().
	                                           get(cpb.getActuals().size() -1) ;
	       
	       result = ((ComponentReference) cpa).getClassifier() ;
	   }
	   else
	   {
		   // If there is no prototype binding found, returns the constraining
		   // classifier from the prototype declaration (it may be null).
		   result = prototype.getConstrainingClassifier() ;
	   }
	   
	   return result ;
   }

   /**
    * Returns the DataClassifier of the element binded to the given 
    * ValueVariable object. A target instance can be given to this method as 
    * Target instance can be cast into ValueVariable reference.
    * <BR><BR>
    *  NOTE : {@link #getClassifier(Element, ComponentClassifier)} 
    *  to see the restrictions
    * 
    * @param vv the given ValueVariable object
    * @return the binded component's DataClassifier object
    * @exception UnsupportedOperationException thrown for unsupported binded 
    * object types.
    */
   public static DataClassifier getDataClassifier(ValueVariable vv)
   {
      Element el = AadlBaUtils.getBindedElement(vv) ;

      ComponentClassifier baParentComponent = (ComponentClassifier) 
                                                  vv.getContainingClassifier() ;
      
      return (DataClassifier) getClassifier(el, baParentComponent) ;
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
    * Note : {@link #getDataRepresentation(PropertyType)} 
    *                        to see restrictions on property constant and value. 
    * <BR><BR>
    * @param v the given Value object
    * @return the type holder of the given Value object
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   private static TypeHolder getTypeHolder(Value v)
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
      if(
           v instanceof ValueVariable &&
           (! (v instanceof PortCountValue || v instanceof PortFreshValue))
        )
      {
         result.klass = getDataClassifier((ValueVariable) v) ;
      }
      // Else : ValueConstant doesn't have any Classifier.
     
      return result ;
   }
   
   /**
    * Returns the TypeHolder (data representation and component's DataClassifier
    * if any) of the given UniqueComponentClassifierReference object.
    * 
    * @param uccr the given UniqueComponentClassifierReference object.
    * @return the type holder of the given UniqueComponentClassifierReference
    * object.
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   private static TypeHolder getTypeHolder(UniqueComponentClassifierReference uccr)
   {
      TypeHolder result = new TypeHolder();
      result.klass = (DataClassifier) uccr.getAadlRef() ;
      result.dataRep = getDataRepresentation(result.klass) ;
      
      return result ;
   }
   
   /**
    * Returns the TypeHolder (data representation and component's DataClassifier
    * if any) of the given Element object.
    * <BR><BR>
    * For now, only the following objects are supported:<BR>
    * <BR>_ UniqueComponentClassifierReference
    * <BR>_ DataClassifier
    * <BR>_ Target
    * <BR>_ Value
    * <BR><BR>
    * 
    * @param el the given Element object.
    * @return the type holder of the given Element object
    * @exception UnsupportedOperationException thrown for the unsupported types
    * or Element instances.
    */
   public static TypeHolder getTypeHolder(Element el)
   {
      if (el instanceof UniqueComponentClassifierReference)
      {
         return getTypeHolder((UniqueComponentClassifierReference) el) ;
      }
      else if (el instanceof DataClassifier)
      {
         return getTypeHolder((DataClassifier) el) ;
      }
      else if(el instanceof Target || el instanceof Value )
      {  
         TypeHolder result = null ;
         
         result = getTypeHolder((Value) el) ;
         
         // The declared variable dimension: the number of [] in the element 
         // declaration.
         int delcaredDim = 0 ;
         
         // The expression dimension: the number of [] in the expression.
         int exprDim = 0 ;
         
         String localVariableName = null ;
         
         // Considers for/forall iteration over an array dcr as a 
         // expression dimension equals to 1.
         if(el.eContainer() instanceof ForOrForAllStatement && 
            el instanceof DataComponentReference)
         {
            exprDim++ ;
         }
         
         // Set up  the expression dimension.
         if(el instanceof Name || el instanceof DataComponentReference)
         {
            Name n ;
            
            if (el instanceof Name)
            {
               n = (Name) el ;
            }
            else
            {
               EList<Name> nl = ((DataComponentReference) el).getNames() ;
               
               n = nl.get(nl.size() -1) ;
            }
            
            if(n.isSetArrayIndexes())
            {
               exprDim += n.getArrayIndexes().size() ;
            }
            
            localVariableName = n.getIdentifierOwned().getId() ;
         }
         
         Element bindedEl = getBindedElement((BehaviorElement) el) ;
         
         // Set up the declared dimension.
         if(bindedEl instanceof ArrayableElement)
         {
            ArrayableElement ae = (ArrayableElement) bindedEl ;
            
            if(ae.getArraySpecification() != null)
            {
               delcaredDim = (int) ae.getArraySpecification().getDimension() ;
            }
         }
         else if(bindedEl instanceof BehaviorVariable)
         {
            BehaviorVariable bv = (BehaviorVariable) bindedEl ;
            
            for(Declarator dcl : bv.getLocalVariableDeclarators())
            {
               if(dcl.getIdentifierOwned().getId().
                       equalsIgnoreCase(localVariableName))
               {
                  if(dcl.isSetArraySizes())
                  {
                     delcaredDim = dcl.getArraySizes().size() ;
                  }
               }
            }
         }
         
         if(exprDim <= delcaredDim)
         {
            result.dimension = delcaredDim - exprDim ;
         }
         else
         {
            processArrayDataRepresentation(result, exprDim - delcaredDim) ;
         }
         
         return result ;
      }
      else
      {
         String errorMsg = "getTypeHolder : " + el.getClass().getSimpleName()
          + " is not supported yet at line " +
            el.getLocationReference().getLine() + "." ;
         System.err.println(errorMsg) ;
         throw new UnsupportedOperationException(errorMsg) ;
      }
   }
   
   // Resolves the type holder of data type declared as an array with its 
   // array element type :
   // if an array index is provided or if the element is contained in a 
   // for/forall statement.
   // its data representation is set with the data type's base type one.
   // its classifier is set with the data type's base type.
   private static void processArrayDataRepresentation(TypeHolder type,
		                                                int exprDim)
   {
      int declaredDim = 0 ;
      
      while(exprDim > 0)
      {
         // Treats only type declared as an array. Otherwise returns.
         // XXX If expression dimension is greater than the declared dimension
         // type holder is taken from the last declared dimension and type 
         // dimension is set to zero.
         if(type.dataRep == DataRepresentation.ARRAY)
         {
            EList<PropertyExpression> l = 
               AadlBaGetProperties.getPropertyExpression(type.klass,
                                 DataModelProperties.DIMENSION) ;
            if(l.size() > 0)
            {
               // Fetches the last enumeration value from the inheritance 
               // stack of properties.
               declaredDim = (int) ((edu.cmu.sei.aadl.aadl2.IntegerLiteral)l.
                               get(l.size()-1)).getValue() ;
            }
            else
            {
               // XXX default array dimension when a data type is declared as
               // an array.
               
               declaredDim = 1 ;
            }
            
            exprDim -= declaredDim ;
            
            // Fetches the data type when expression dimension is greater             
            ClassifierValue cv = AadlBaUtils.getBaseType(type.klass) ;
            
            if(cv != null && cv.getClassifier() instanceof DataClassifier)
            {
               DataClassifier dc = (DataClassifier) cv.getClassifier() ; 
               
               type.dataRep = AadlBaUtils.getDataRepresentation(dc) ;
               type.klass = dc ;
            }
            else
            {
               type.dataRep = DataRepresentation.UNKNOWN ;
            }
            
            if(exprDim >= 0)
            {
               continue ;
            }
            else
            {
               type.dimension = -1 * exprDim ;
               return ;
            }
         }
         else
         {
            // If expression dimension is greater than the declared dimension
            // type holder is taken from the last dimension of the declared one.
            
            if(exprDim > 0)
            {
               type.klass = null ;
               type.dataRep = DataRepresentation.UNKNOWN ;
               type.dimension = 0 ;
            }
            
            return ;
         }
      }
   }
   
  /**
    * Compare the given lists of strings. Return {@code true} if they are 
    * equivalents: they contain the same strings in any order.
    * Case is insensitive. {@code false} otherwise.<BR><BR>
    * This method is different from List.equals see {@link List#equals(Object)}.
    * 
    * @param list1 an list of strings
    * @param list2 an other list of strings
    * @return {@code true} if the lists are equivalents, {@code false} otherwise
    */
   public static boolean compareStringList(List<String> list1,
                                           List<String> list2)
   {
      if(list1.size() == list2.size())
      {
         ArrayList<String> l1 = new ArrayList<String>(list1) ;
         ArrayList<String> l2 = new ArrayList<String>(list2) ;
         
         Comparator<String> c = new Comparator<String>()
         {
            public int compare(String o1, String o2)
            {
               return o1.compareToIgnoreCase(o2) ;
            }
         } ;
         
         Collections.sort(l1, c) ;
         Collections.sort(l2, c) ;
         
         Iterator<String> it1 = l1.iterator() ;
         Iterator<String> it2 = l2.iterator() ;
         
         String s1, s2 ;
         
         while(it1.hasNext())
         {
            s1 = it1.next() ;
            s2 = it2.next() ;
            
            if(! s1.equalsIgnoreCase(s2))
               return false ;
         }
         
         return true ;
      }
      else
      {
         return false ;
      }
   }
   
   /**
    * Compare a given identifier to a given list of identifiers.
    * The matching is base on identifiers' name (case insensitive).
    * 
    * @param id the given identifier.
    * @param lid the given list of identifiers
    * @return the first identifier form the given list which has the same
    * name as the given identifier.{@code null} otherwise.
    */
   public static Identifier compareIdentifiersList(Identifier id,
                                                   EList<Identifier> lid)
   {
      for(Identifier id2 : lid)
      {
         if(id.getId().equalsIgnoreCase(id2.getId()))
         {
            return id2 ;
         }
      }
      
      return null ;
   }
   
   /**
    * Compare the given Target objects.<BR><BR> 
    * 
    * This method is based on {@link #isSameName(Name, Name)} and 
    * {@link #isSameDataComponentReference(DataComponentReference,
    * DataComponentReference)}.<BR><BR> 
    * 
    * This comparator doesn't support array indexes comparison, meaning that two
    * target with the same identifiers and different array indexes
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
      if(tar0 instanceof Name && tar1 instanceof DataComponentReference ||
         tar1 instanceof Name && tar0 instanceof DataComponentReference)
      {
         return false ;
      }
      else
      {
         if(tar0 instanceof Name && tar1 instanceof Name)
            return isSameName((Name) tar0, (Name) tar1) ;
         else
            return isSameDataComponentReference((DataComponentReference) tar0,
                                                (DataComponentReference) tar1);
      }
   }
   
   /**
    * Compare the given Name objects.<BR><BR> 
    * 
    * This method is based on {@link String#equalsIgnoreCase(String)} : it 
    * compares the name's identifier one to one.<BR><BR> 
    * 
    * This comparator doesn't support array indexes comparison, meaning that two
    * names with the same identifiers and different array indexes
    * are considered as equals.
    * <BR><BR>
    * 
    * @param n0 the first name
    * @param n1 the second name
    * @return {@code true} if the given Name objects are the same.
    * Otherwise return {@code false}  
    */
   public static boolean isSameName(Name n0, Name n1)
   {
      String s0 = n0.getIdentifierOwned().getId() ;
      String s1 = n1.getIdentifierOwned().getId() ;
      return s0.equalsIgnoreCase(s1) ;
   }
   
   /**
    * Compare the given DataComponentReference objects.<BR><BR> 
    * 
    * This method is based on {@link #isSameName(Name, Name)} : it compares 
    * the dcr's names one to one.<BR><BR> 
    * 
    * This comparator doesn't support array indexes comparison, meaning that two
    * data component references with the same identifiers and different
    * array indexes are considered as equals.
    * <BR><BR>
    * 
    * @param dcr0 the first data component reference
    * @param dcr1 the second data component reference
    * @return {@code true} if the given DataComponentReference are the same.
    * Otherwise return {@code false}  
    */
   public static boolean isSameDataComponentReference(
		                                            DataComponentReference dcr0,
                                                    DataComponentReference dcr1)
   {
      EList<Name> ln0 = null ;
      EList<Name> ln1 = null ;
            
      ln0 = dcr0.getNames() ;
      ln1 = dcr1.getNames() ;
      
      if(ln0.size() == ln1.size())
      {
         for(int i = 0 ; i < ln0.size() ; i++)
         {
            if(! isSameName(ln0.get(i), ln1.get(i)))
            {
               return false;
            }
         }
         
         return true ;
      }
      else // Two dcr with difference sizes of name list can't be the same.
      {
         return false ;
      }
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
            IntegerValue iv1 = behT1.getIntegerValueOwned() ;
            IntegerValue iv2 = behT2.getIntegerValueOwned() ;
            
            if(iv1 instanceof BehaviorIntegerLiteral &&
               iv2 instanceof BehaviorIntegerLiteral)
            {
                  double d1 = new Long(((BehaviorIntegerLiteral)iv1).getValue())
                                                                .doubleValue() ;
                  double d2 = new Long(((BehaviorIntegerLiteral)iv2).getValue())
                                                                .doubleValue() ;
                  
                  UnitLiteral unit1 = (UnitLiteral) behT1.getUnitIdentifier()
                                                    .getAadlRef() ;
                  UnitLiteral unit2 = (UnitLiteral) behT2.getUnitIdentifier()
                                                    .getAadlRef() ;
                  
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
    * Constructs a string with the identifiers, separated by the given separator
    * symbol, of the given list of Identifier objects .
    * 
    * @param l the given list of Identifier objects
    * @param separator the list separator symbol
    * @return the string composed of all identifiers
    */
   public static String identifierListToString(EList<Identifier> l,
                                               String separator) {
      String[] ls = new String[l.size()] ;
      int i = 0 ;
      
      for(Identifier id : l)
      {
         ls[i] = id.getId() ;
         i++ ;
      }
      
      return concatenateString(separator, ls) ;
   }
   
   /**
    * Unparses the given list of Name objects. Each Name are separeted by the
    * given separator string.
    * 
    * @param nl the given list of Name objects
    * @param separator the given separator string
    * @return unparsed list of Name objects
    */
   public static String nameListToString(EList<Name> nl, String separator)
   {
      AadlBaUnparser unparser = new AadlBaUnparser() ;
      unparser.processEList(nl, separator) ;
      return unparser.getOutput() ; 
   }
   
   /**
    * Analyze the given AADL Osate element and return its type.
    * 
    * It's an improved version of Osate2 {@link
    * edu.cmu.sei.aadl.parser.AadlSemanticCheckSwitch#getFeatureType} 
    *  
    * @param el the given AADL Osate element
    * @return the given AADL Osate element's type
    * @exception UnsupportedOperationException thrown for the unsupported types
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
   public static 
   fr.tpt.aadl.annex.behavior.aadlba.FeatureType 
                               getFeatureType(edu.cmu.sei.aadl.aadl2.Element el)
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
            case PROVIDED:
               return FeatureType.PROVIDES_DATA_ACCESS;
            case REQUIRED:
               return FeatureType.REQUIRES_DATA_ACCESS;
         }
      }
      else if (el instanceof SubprogramAccess)
      {
         switch (((SubprogramAccess)el).getKind())
         {
            case PROVIDED:
               return FeatureType.PROVIDES_SUBPROGRAM_ACCESS;
            case REQUIRED:
               return FeatureType.REQUIRES_SUBPROGRAM_ACCESS;
         }
      }
      else if (el instanceof SubprogramGroupAccess)
      {
         switch (((SubprogramGroupAccess)el).getKind())
         {
            case PROVIDED:
               return FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS;
            case REQUIRED:
               return FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS;
         }
      }
      else if (el instanceof BusAccess)
      {
         switch (((BusAccess)el).getKind())
         {
            case PROVIDED:
               return FeatureType.PROVIDES_BUS_ACCESS;
            case REQUIRED:
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
            switch(((ComponentPrototype) el).getCategory())
            {
               case SUBPROGRAM:
                  return FeatureType.SUBPROGRAM_PROTOTYPE ;
                  
               default:
                  return FeatureType.COMPONENT_PROTOTYPE ;
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
      else if (el instanceof edu.cmu.sei.aadl.aadl2.PropertyConstant)
         return FeatureType.PROPERTY_CONSTANT ;
      else if (el instanceof edu.cmu.sei.aadl.aadl2.Property)
         return FeatureType.PROPERTY_VALUE ;
      else if (el instanceof ClassifierValue)
    	  return FeatureType.CLASSIFIER_VALUE ;
      
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
         
      String errorMsg = "getFeatureType : " + el.getClass().getSimpleName()+ 
                                          " is not supported yet at line " +
                                          el.getLocationReference().getLine() +
                                          "." ;
      System.err.println(errorMsg) ;
      throw new UnsupportedOperationException(errorMsg) ;
   }
   
   /**
    * Return the element binded to the given behavior annex element.
    * 
    * @param el the given behavior annex element
    * @return the binded element
    */
   public static  Element getBindedElement(BehaviorElement el)
   {
      edu.cmu.sei.aadl.aadl2.Element result = el.getAadlRef() ;
      
      if(result == null)
      {
         result = el.getBaRef() ;
      }

      return result ;
   }

   /**
    * Analyze the given behavior annex feature and returns its type.
    * 
    * @param el the given behavior annex feature
    * @return the given behavior annex feature's type
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static BehaviorFeatureType getBehaviorAnnexFeatureType(
                                                             BehaviorElement el)
   {
      if(el instanceof fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable)
         return BehaviorFeatureType.BEHAVIOR_VARIABLE ;
      else if (el instanceof fr.tpt.aadl.annex.behavior.aadlba.
                                          UniqueComponentClassifierReference)
         return BehaviorFeatureType.UNIQUE_COMPONENT_CLASSIFIER_REFERENCE ;
      
      String errorMsg = "feature : " + el.getClass().getSimpleName()+ 
      " is not supported yet." ;
      System.err.println(errorMsg) ;
      throw new UnsupportedOperationException(errorMsg) ;
   }
   
   /**
    * Returns the type of the element binded to the given behavior
    * annex element.
    * 
    * @param el the given behavior annex element
    * @return the type of the linked element
    */
   public static Enum<?> getType(BehaviorElement el)
   {
      edu.cmu.sei.aadl.aadl2.Element testedEl = AadlBaUtils.getBindedElement(el);
      
      Enum<?> result ;
      
      if (testedEl instanceof BehaviorElement)
      {
         result = AadlBaUtils.getBehaviorAnnexFeatureType(
                                                     (BehaviorElement)testedEl);
      }
      else
      {
         result = AadlBaUtils.getFeatureType(testedEl) ;
      }
      
      return result ;
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
      SimpleExpression firstSE = firstRelation.getSimpleExpressionOwned() ;
      Term firstTerm = firstSE.getTerms().get(0) ;
      Factor firstFactor = firstTerm.getFactors().get(0) ;
      Value firstValue = firstFactor.getValueOwned() ; 
      
      if(ve.getRelations().size() == 1)
      {
         if(firstRelation.getSimpleExpressionSdOwned() == null)
         {
            if(firstSE.getTerms().size() == 1)
            {
               if(firstTerm.getFactors().size() == 1)
               {
                  if (firstFactor.getValueSdOwned() == null)
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
    * Translates the given FeaturePrototypeBinding object into a FeatureType
    * object.
    * 
    * @param fpb the given FeaturePrototypeBinding
    * @return the translation in FeatureType object
    * @exception UnsupportedOperationException thrown for the unsupported types
    */
   public static FeatureType getFeatPrototypeType(FeaturePrototypeBinding fpb)
   {
	   FeaturePrototypeActual fpa = fpb.getActual() ;
	   
	   if(fpa instanceof AccessSpecification)
	   {
		   AccessSpecification as = (AccessSpecification) fpa ;
		   
		   boolean isRequired = as.getKind() == AccessType.REQUIRED ;
		   
		   switch(as.getCategory())
		   {
		      case BUS :
		      {
		    	  return  (isRequired) ? FeatureType.REQUIRES_BUS_ACCESS :
		    		  FeatureType.PROVIDES_BUS_ACCESS ;
		      }
		    		  
		      case DATA :
		      {
		    	  return  (isRequired) ? FeatureType.REQUIRES_DATA_ACCESS :
		    		  FeatureType.PROVIDES_DATA_ACCESS ;
		      }
		      
		      case SUBPROGRAM :
		      {
		    	  return  (isRequired) ? FeatureType.REQUIRES_SUBPROGRAM_ACCESS :
		    		  FeatureType.PROVIDES_SUBPROGRAM_ACCESS ;
		      }
		   
		      case SUBPROGRAM_GROUP :
		      {
		    	  return  (isRequired) ? FeatureType.REQUIRES_SUBPROGRAM_GROUP_ACCESS :
		    		  FeatureType.PROVIDES_SUBPROGRAM_GROUP_ACCESS ;
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
			   		case IN : return  FeatureType.IN_DATA_PORT ; 
			   		case OUT : return  FeatureType.OUT_DATA_PORT ; 
			   		case IN_OUT : return  FeatureType.IN_OUT_DATA_PORT ; 
			   }
		   }
		   else if (ps.getCategory() == PortCategory.EVENT)
		   {
			   switch (ps.getDirection())
			   {
			   		case IN : return  FeatureType.IN_EVENT_PORT ; 
			   		case OUT : return  FeatureType.OUT_EVENT_PORT ; 
			   		case IN_OUT : return  FeatureType.IN_OUT_EVENT_PORT ; 
			   }
		   }
		   else
		   {
			   switch (ps.getDirection())
			   {
			   		case IN : return  FeatureType.IN_EVENT_DATA_PORT ; 
			   		case OUT : return  FeatureType.OUT_EVENT_DATA_PORT ; 
			   		case IN_OUT : return  FeatureType.IN_OUT_EVENT_DATA_PORT ; 
			   }
		   }
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
    * given Element is not an instance of DirectedFeature.
    * 
    * @param el the given Element
    * @return the direction type or {@code null}
    */
   public static DirectionType getDirectionType(Element el)
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
           AadlBaGetProperties.getPropertyExpression(component,
	              DataModelProperties.BASE_TYPE) ;
		  
	   if(lpe != null && (! lpe.isEmpty()))
	   {
		   pe = lpe.get(lpe.size() -1) ;
		   
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
	   }
	   
	   return null ;
   }
  
   
   /**
    * Returns the direction type of the object binded to the given Target or 
    * {@code null} if the binded object is not an instance of : <BR><BlockQuote> 
    * _ DirectedFeature.<BR>
    * _ Data subcomponent.<BR>
    * _ Local variable.<BR></BlockQuote>
    * (see {@link #getDirectionType(edu.cmu.sei.aadl.aadl2.Element)}).
    * <BR><BR>
    * Notes:
    * _  AADLBA's local variable always returns DirectionType.IN_OUT as
    * As local variable are valid Target and ValueVariable.
    * 
    * _ Data subcomponent 
    * 
    * <BR><BR>
    * @param tar the given Target
    * @return the direction type or {@code null}
    */
   public static DirectionType getDirectionType(Target tar)
   {
      if(tar.getAadlRef() != null)
      {
         return getDirectionType(tar.getAadlRef()) ;
      }
      else // As local variable are valid Target and ValueVariable,
           // local variable are considered as IN_OUT.
      {
         return DirectionType.IN_OUT ;
      }
   }
   
   /**
    * Returns the name of the given ModeTransitionTrigger object.
    * 
    * @param mtt the given ModeTransitionTrigger object
    * @return a name
    */
   public static String getName(ModeTransitionTrigger mtt)
   {
      if(mtt instanceof NamedElement)
      {
         return ((NamedElement) mtt).getName() ;
      }
      else
      {
         return ((TriggerPort) mtt).getPort().getName() ;
      }
   }
   
   /**
    * Returns the subprogram name of the given SubprogramCallAction object.
    * 
    * @param sca the given SubprogramCallAction object
    * @return the subprogram name
    */
   public static String getName(SubprogramCallAction sca)
   {
      String result ;
      
      if(sca.getSubprogramReference() != null)
      {
         result = sca.getSubprogramReference().getQualifiedName() ; 
      }
      else
      {
         result = AadlBaUtils.
            nameListToString(sca.getSubprogramNames(), STRING_NAME_SEPARATOR);
      }
      
      return result ;
   }
}