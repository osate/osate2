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

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression;

public class AadlBaGetProperties
{
   /**
    * Dispatch trigger's property values.
    */
	public static final String HYBRID = "Hybrid" ;
	public static final String TIMED = "Timed" ;

	/**
	 * Return the list of property expressions (PropertyExpression) associated
	 * to a given property name within a given component and its ancestor if the
	 * given component is a component implementation. The returned list'size 
	 * is > 1 when the given component associated to the given classifier has
	 * refined the given property.
	 * 
	 * @param cc the given component
	 * @param propertyName the given property
	 * @return the list of property expressions. The list may be empty.
	 */
	public static EList<PropertyExpression> getPropertyExpression(Classifier cc,
			                                            String propertyName)
    {
		EList<PropertyExpression> result = new BasicEList<PropertyExpression>();

		EList<PropertyAssociation> lpa = getPropertyAssociations(cc,
				                                                 propertyName) ;

		for (PropertyAssociation pa : lpa)
		{
			result.addAll(getPropertyExpression(pa)) ;
		}

		// If no property value is found, search within parent container if only
		// the given component is a component implementation. Recursive call.
		if(result.isEmpty() && cc instanceof ComponentImplementation )
		{
			cc = ((ComponentImplementation) cc).getType() ;
			result = getPropertyExpression(cc, propertyName) ;
		}

		return result ;
    }

	/**
	 * Return the property association which match
	 * the given propertyName if it is defined
	 * 
	 * @param cc a given component classifier
	 * @param propertyName a given property name
	 * @return the property association
	 */
	public static PropertyAssociation getPropertyAssociation(Classifier cc,
			                                                String propertyName)
	{
		Property p = null ;

		// FIXME : TODO : improve function, get properties from component type
		// too
		if(!cc.isNoProperties())
		{
			for(PropertyAssociation pa : cc.getAllPropertyAssociations())
			{
				p = pa.getProperty() ;
				if(p.getName().equalsIgnoreCase(propertyName))
				{
					return pa ;
				}
			}
		}
		return null ;
	}

	/**
	 * Return the list of property association which match
	 * the given propertyName if several property association
	 * is defined
	 * 
	 * @param cc a given component classifier
	 * @param propertyName a given property name
	 * @return the list of property association which match
	 * the given propertyName
	 */
	public static EList<PropertyAssociation> getPropertyAssociations(
			                                 Classifier cc,
			                                 String propertyName)
	{
		Property p = null ;
		EList<PropertyAssociation> lpa = null ;

		EList<PropertyAssociation> lparesult = 
			                             new BasicEList<PropertyAssociation>() ;
		
		// FIXME : TODO : improve function, get properties from component type
		// too
		if(cc != null && !cc.isNoProperties())
		{
			lpa = cc.getAllPropertyAssociations() ;

			for(PropertyAssociation pa : lpa)
			{
				p = pa.getProperty() ;
				// Sometime, properties don't have name.
				if(p.getName() != null && p.getName().
						                         equalsIgnoreCase(propertyName))
				{
					lparesult.add(pa) ;
				}
			}
		}
		return lparesult ;
	}

	/**
	 * 
	 * @param pa a given property association
	 * @return the list of property expression of the property
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

}
