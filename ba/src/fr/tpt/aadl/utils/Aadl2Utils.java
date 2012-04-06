/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.utils;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.List ;

import org.eclipse.emf.ecore.EObject ;
import org.eclipse.xtext.nodemodel.INode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.Property ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

public class Aadl2Utils
{
  public static String DEFAULT_ACCESS_RIGHT = null ; 
  
  public static List<Feature> orderFeatures(ComponentType cpt)
  {
    List<Feature> res = new ArrayList<Feature>() ;
    res.addAll(cpt.getOwnedFeatures()) ;
    FeaturePositionComparator comparator = new FeaturePositionComparator() ;
    Collections.sort(res, comparator) ;
    return res ;
  }
  
  public static class FeaturePositionComparator implements Comparator<Feature>
  {

    @Override
    public int compare(Feature arg0,
                       Feature arg1)
    {
      if(arg0.getLocationReference() != null &&
            arg1.getLocationReference() != null)
      {
        if(arg0.getLocationReference().getLine() < arg1.getLocationReference()
              .getLine())
        {
          return -1 ;
        }

        if(arg0.getLocationReference().getLine() > arg1.getLocationReference()
              .getLine())
        {
          return 1 ;
        }

        return 0 ;
      }

      INode node0 = NodeModelUtils.findActualNodeFor(arg0) ;
      int offset0 = node0.getOffset() ;
      int line0 = node0.getStartLine() ;
      INode node1 = NodeModelUtils.findActualNodeFor(arg1) ;
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
  
  // Returns null if there is not default right set.
  public static String getAccessRight(DataAccess data)
  {
    String result = null ;
    
    try
    {
      result = PropertyUtils.getEnumValue(data, "Access_Right") ;
    }
    catch(Exception e)
    {
      if(DEFAULT_ACCESS_RIGHT == null)
      {
        PropertiesLinkingService pls = null ;
        
        pls = PropertiesLinkingService.getPropertiesLinkingService(data) ;
        
        EObject ne = null ;
        
        ne = pls.findNamedElementInPropertySet("Memory_Properties",
                                               "Access_Right", data, null);
        try
        {
          Property prop = (Property) ne ;
          NamedValue nv = (NamedValue) prop.getDefaultValue() ;
          result = ((EnumerationLiteral) nv.getNamedValue()).getName();
        }
        catch(Exception e1)
        {
          return null ;
        }
      }
      else
      {
        return DEFAULT_ACCESS_RIGHT ;
      }
    }
    
    return result ;
  }
}
