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

import java.io.File ;
import java.net.URL ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.Iterator ;
import java.util.List ;

import org.eclipse.core.runtime.FileLocator ;
import org.eclipse.core.runtime.Platform ;
import org.eclipse.xtext.nodemodel.ICompositeNode ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.AbstractFeature ;
import org.osate.aadl2.AccessConnection ;
import org.osate.aadl2.BehavioredImplementation ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentPrototypeActual ;
import org.osate.aadl2.ComponentPrototypeBinding ;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.ConnectionEnd ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataPort ;
import org.osate.aadl2.DataPrototype ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.EventDataPort ;
import org.osate.aadl2.EventPort ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.FeatureClassifier ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.ParameterConnection ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.Prototype ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.SubcomponentType ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.parsesupport.LocationReference ;
import org.osate.xtext.aadl2.properties.util.GetProperties ;
import org.osgi.framework.Bundle ;

public class Aadl2Utils
{
  public static String DEFAULT_ACCESS_RIGHT = null ; 
  
  /**
   * Returns the sorted (see FeaturePositionComparator) list of features (included
   * inherited features) owned by the given Classifier object.
   * 
   * @param cpt the given Classifier object
   * @return the sorted list of features owned by the given Component object
   */
  public static List<Feature> orderFeatures(Classifier cpt)
  {
	  List<PrototypeBinding> inheritedBindings = Collections.emptyList();
	  return orderFeatures(cpt, inheritedBindings);
  }
  
  /**
   * Returns the sorted (see FeaturePositionComparator) list of features (included
   * inherited features) owned by the given Classifier object.
   * 
   * @param cpt the given Classifier object
   * @param inheritedBindings inherited prototype bindings
   * @return the sorted list of features owned by the given Component object
   */
  public static List<Feature> orderFeatures(Classifier cpt, List<PrototypeBinding> inheritedBindings)
  {
	  //List<PrototypeBinding> bindings = cpt.getOwnedPrototypeBindings();
	  List<PrototypeBinding> bindings = new ArrayList<PrototypeBinding>();
    bindings.addAll(cpt.getOwnedPrototypeBindings());
    bindings.addAll(inheritedBindings);
	  
	  List<Feature> res = new ArrayList<Feature>() ;
    for(Feature f : cpt.getAllFeatures())
    {
    	res.add(getBindedFeature(bindings, f));
    }
    
    //res.addAll(cpt.getAllFeatures()) ;
    FeaturePositionComparator comparator = new FeaturePositionComparator() ;
    Collections.sort(res, comparator) ;
    return res ;
  }
  
  private static Feature getBindedFeature(List<PrototypeBinding> bindings, Feature f)
  {
	  FeatureClassifier cl = f.getFeatureClassifier();
	  if ((! (cl instanceof DataPrototype)) || bindings==null || bindings.isEmpty())
	  {
		  return f;
	  }
	  if ((f instanceof EventPort) || (f instanceof AbstractFeature))
	  {
		  return f;
	  }
	  
	  DataPrototype proto = (DataPrototype) cl;
	  
	  for(PrototypeBinding b : bindings)
	  {
		  if (!(b instanceof ComponentPrototypeBinding))
		  {
			  continue;
		  }
		  
		  ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) b;
		  Prototype p = b.getFormal();
		  if (p.getName().equals(proto.getName()))
		  {
			  List<ComponentPrototypeActual> actuals = cpb.getActuals();
			  if (actuals!=null && !actuals.isEmpty())
			  {
				  ComponentPrototypeActual actual = actuals.get(0);
				  SubcomponentType st = actual.getSubcomponentType();
				  if (!(st instanceof DataClassifier))
				  {
					  continue;
				  }
				  DataClassifier dc = (DataClassifier) st;
				  return setFeatureClassifier(f, dc);
			  }
		  }
	  }
	  
	  return f;
  }
  
  private static Feature setFeatureClassifier(Feature f, DataClassifier dc)
  {
	  if (f instanceof Parameter)
	  {
		  ((Parameter) f).setDataFeatureClassifier(dc);
	  }
	  else if (f instanceof DataAccess)
	  {
		  ((DataAccess) f).setDataFeatureClassifier(dc);
	  }
	  else if (f instanceof DataPort)
	  {
		  ((DataPort) f).setDataFeatureClassifier(dc);
	  }
	  else if (f instanceof EventDataPort)
	  {
		  ((EventDataPort) f).setDataFeatureClassifier(dc);
	  }
	  return f;
  }
  
  /*
  public static List<StructuralFeature> orderFeaturesAndFeaturesPrototype(ComponentType cpt)
  {
    List<StructuralFeature> result = new  ArrayList<StructuralFeature>() ;
    
    for (NamedElement ne : Aadl2Visitors.getMembers(cpt))
    {
      if (ne instanceof Feature || ne instanceof FeaturePrototype)
      {
        result.add((StructuralFeature) ne) ;
      }
    }
    
    FeaturePositionComparator comparator = new FeaturePositionComparator() ;
    Collections.sort(result, comparator) ;
    
    return result ;
  }
  */
  public static ConnectionEnd getConnectedEnd(SubprogramCall sc , Feature p)
  {
	NamedElement parent = (NamedElement) sc.eContainer().eContainer();
	if(parent instanceof BehavioredImplementation)
	{
	  BehavioredImplementation bi = (BehavioredImplementation) parent;
	  for( ParameterConnection paramCnx: bi.getOwnedParameterConnections())
	  {
		ConnectedElement sourceConnectedElement = (ConnectedElement) paramCnx.getSource();
		ConnectedElement destinationConnectedElement = (ConnectedElement) paramCnx.getDestination();
		if(sourceConnectedElement.getContext() == sc 
				&& sourceConnectedElement.getConnectionEnd() == p)
		  return destinationConnectedElement.getConnectionEnd();
		else if (destinationConnectedElement.getContext() == sc 
				&& destinationConnectedElement.getConnectionEnd() == p)
		  return sourceConnectedElement.getConnectionEnd();
	  }
	  for(AccessConnection accessCnx: bi.getOwnedAccessConnections())
	  {
		ConnectedElement sourceConnectedElement = (ConnectedElement) accessCnx.getSource();
		ConnectedElement destinationConnectedElement = (ConnectedElement) accessCnx.getDestination();
		if(sourceConnectedElement.getContext() == sc 
				&& sourceConnectedElement.getConnectionEnd() == p)
		  return destinationConnectedElement.getConnectionEnd();
		else if (destinationConnectedElement.getContext() == sc 
				&& destinationConnectedElement.getConnectionEnd() == p)
		  return sourceConnectedElement.getConnectionEnd();
	  }
	}
	return null;
  } 
  
  public static boolean isInOutParameter(Parameter p)
  {
	return p.getDirection().equals(DirectionType.IN_OUT);
  }
  
  public static boolean isOutParameter(Parameter p)
  {
	  return p.getDirection().equals(DirectionType.OUT);
  }
  
  public static boolean isReadWriteDataAccess(DataAccess da)
  {
    String accessRight = getAccessRight(da);
    return accessRight.equalsIgnoreCase("Read_Write");
  }
  
  public static boolean isWriteOnlyDataAccess(DataAccess da)
  {
    String accessRight = getAccessRight(da);	  
    return accessRight.equalsIgnoreCase("Write_Only");
  }
  
  /**
   * Implementation of a feature comparator based on the postion of the features
   * in the aadl code.
   * <BR><BR>
   * Returns 1 if arg1 is declared after arg0.<BR>
   * Returns -1 if arg0 is declared after arg1.<BR>
   * Returns 0 if arg0 and arg1 are declared on the same line.
   */
  public static class FeaturePositionComparator implements Comparator<Feature>
  {

    @Override
    public int compare(Feature arg0,
                       Feature arg1)
    {
      Feature ancestor0 = arg0.getRefined() != null ? arg0.getRefined() : arg0;
      Feature ancestor1 = arg1.getRefined() != null ? arg1.getRefined() : arg1;
      
      INode node0 = NodeModelUtils.findActualNodeFor(ancestor0) ;
      int offset0 = node0.getOffset() ;
      int line0 = node0.getStartLine() ;
      INode node1 = NodeModelUtils.findActualNodeFor(ancestor1) ;
      int offset1 = node1.getOffset() ;
      int line1 = node1.getStartLine() ;

      if(line0 < line1)
      {
        return -1 ;
      }

      if(line0 == line1)
      {
        if(offset0 < offset1)
        {
          return -1 ;
        }

        if(offset0 > offset1)
        {
          return 1 ;
        }
      }

      if(line0 > line1)
      {
        return 1 ;
      }

      return 0 ;
    }
  }
  
  /**
   * Returns the parameter usage (by_reference, by_value) of the given NamedElement object.<BR>
   * <BR>
   * 
   * Returns the local "Parameter_Usage" property value, if it is set. Otherwise,
   * returns the default parameter value found in Generation_Properties (home
   * made property set). If the default parameter value is not found,
   * returns an empty string (not {@code null}).  
   * 
   * @param ne the given NamedElement object
   * @return local parameter usage or default parameter usage or an empty string
   */
  public static String getParameterUsage(NamedElement ne)
  {
    String result = PropertyUtils.getEnumValue(ne, "Parameter_Usage") ;
    if(result == null)
    {
      Property prop = GetProperties.lookupPropertyDefinition(ne, "Code_Generation_Properties", "Parameter_Usage");
      if(prop != null)
      {
        NamedValue nv = (NamedValue) prop.getDefaultValue() ;
        if(nv != null)
        {
          result = ((EnumerationLiteral) nv.getNamedValue()).getName();
        }
        else
        {
          return "" ;
        }
      }
      else
      {
        return "" ;
      }
    }	    
    return result ;
  }
  
  /**
   * Returns the access right of the given NamedElement object.<BR>
   * <BR>
   * 
   * Returns the local "Access_Right" property value, if it is set. Otherwise,
   * returns the default access right value found in Memory_Properties (pre
   * declared property set). If the default access right is not found, it
   * returns "unknown".  
   * 
   * @param ne the given NamedElement object
   * @return local access right or default access right or "unknown"
   */
  public static String getAccessRight(NamedElement ne)
  {
    String result = PropertyUtils.getEnumValue(ne, "Access_Right") ;
    if(result == null)
    {
      if(DEFAULT_ACCESS_RIGHT == null)
      {
        Property prop = GetProperties.lookupPropertyDefinition(ne, "Memory_Properties", "Access_Right");
        if(prop != null)
        {
          NamedValue nv = (NamedValue) prop.getDefaultValue() ;
          result = ((EnumerationLiteral) nv.getNamedValue()).getName();
          DEFAULT_ACCESS_RIGHT = result ;
        }
        else
        {
          return "unknown" ;
        }
      }
      else
      {
        return DEFAULT_ACCESS_RIGHT ;
      }
    }
    
    return result ;
  }
  
  /**
   * Same as {@link #getAccessRight(NamedElement)}, it returns the access right
   * of the given NamedElement object, using DataAccessRight enumeration.
   * <BR><BR>
   * 
   * Returns the local "Access_Right" property value, if it is set. Otherwise,
   * returns the default access right value found in Memory_Properties (pre
   * declared property set). If the default access right is not found, it
   * returns DataAccessRight.unknown .  
   * 
   * @param ne the given NamedElement object
   * @return local access right or default access right or DataAccessRight.unknown
   */
  public static DataAccessRight getDataAccessRight(NamedElement ne)
  {
    return DataAccessRight.getDataAccessRight(getAccessRight(ne)) ;
  }
  
  /**
   * Convenient enumeration class for data access right checking.
   * <BR><BR>
   * 
   * {@link DataAccessRight#getDataAccessRight(String)} to translate
   * data access right expressed in string object into a DataAccessRight
   * enumeration reference. 
   */
  public enum DataAccessRight
  {
    unknown("unknown"), read_only("read only"), write_only("write only"),
    read_write("read and write") ;

    String literal ;

    DataAccessRight(
                    String literal)
    {
      this.literal = literal ;
    }

    // Do not use Enum.Valueof because if literal is null, Enum will throw an
    // uncatched exceptions.
    public static DataAccessRight getDataAccessRight(String literal)
    {
      try
      {
        return valueOf(literal) ;
      }
      catch(IllegalArgumentException e)
      {
        return unknown ;
      }
    }
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
    result.setLength(result.length()- separator.length()) ;

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
  public static boolean contains(String s, Iterable<String> stringArray )
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
   * Returns {@code true} if the given object is found (based on equals method)
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
   * Return the location reference of the given Element object. 
   * 
   * @param e the given Element
   * @return a LocationReference object
   */
  public static LocationReference getLocationReference(Element e)
  {
    LocationReference result = null ;
    
    result = e.getLocationReference() ;
    
    if(result == null)
    {
      ICompositeNode node = NodeModelUtils.findActualNodeFor(e);
      
      result = new LocationReference() ;
      
      if(node != null && e.eResource() != null)
      {
        result.setFilename(e.eResource().getURI().lastSegment()) ;
        result.setOffset(node.getOffset()) ;
        result.setLength(node.getLength()) ;
        result.setLine(node.getStartLine()) ;
      }
      else
      {
        // DEBUG
        System.err.println("Aadl2Utils.getLocationReference: node or eResource " +
        		               "not found for " + e) ;
      }
    }

    return result ;
  }
  
  /**
   * Convert a relative path of file or directory contained in a given plugin
   * into a absolute path.  
   * 
   * @param pluginId the given plugin identification
   * @param relativePath the relative path of file or directory
   * @return the absolute path
   * @throws Exception raised if the plugin is not found or the relative path
   * points to nowhere
   */
  public static File getPluginFile(String pluginId, String relativePath) throws Exception
  {
    File result = null ;
    
    if(Platform.isRunning())
    {
      Bundle bundle = Platform.getBundle(pluginId);
      if(bundle == null)
      {
        throw new Exception("plugin: " + pluginId + " is not found");
      }
      
      URL rootURL = bundle.getEntry(relativePath) ;
      if(rootURL == null)
      {
        throw new Exception("file or directory: " + relativePath + " is not found");
      }
            
      result = new File(FileLocator.toFileURL(rootURL).getFile()) ;
    }
    
    return result ;
  }
  
  /**
   * Returns the absolute path of the corresponding plugin identificated by
   * the given plugin id.   
   * 
   * @param pluginId the given plugin identification
   * @return the plugin in absolute path
   * @throws Exception raised if the plugin is not found
   */
  public static File getAbsolutePluginPath(String pluginId) throws Exception
  {
    File result = getPluginFile(pluginId, "") ;
    return result ;
  }
}