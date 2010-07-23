package fr.tpt.aadl.annex.behavior.utils ;

import org.eclipse.emf.common.util.BasicEList ;
import org.eclipse.emf.common.util.EList ;

import edu.cmu.sei.aadl.aadl2.ComponentClassifier ;
import edu.cmu.sei.aadl.aadl2.ComponentImplementation ;
import edu.cmu.sei.aadl.aadl2.ContainmentPathElement ;
import edu.cmu.sei.aadl.aadl2.ModalPropertyValue ;
import edu.cmu.sei.aadl.aadl2.NamedElement ;
import edu.cmu.sei.aadl.aadl2.Property ;
import edu.cmu.sei.aadl.aadl2.PropertyAssociation ;
import edu.cmu.sei.aadl.aadl2.PropertyValue;
import edu.cmu.sei.aadl.aadl2.ReferenceValue ;

public class AadlBaGetProperties
{

	// Property type identifiers
	public static final String DISPATCH_TRIGGER = "Dispatch_Trigger" ;

	// Property value identifiers
	public static final String HYBRID = "Hybrid" ;
	public static final String TIMED = "Timed" ;

	/**
	 * Return the list of property values (PropertyValue) associated to a given
	 * property name within a given component and its ancestor if the given
	 * component is a component implementation.
	 * 
	 * @param cc the given component
	 * @param propertyName the given property name
	 * @return the list of property values. The list may be empty.
	 */
	public static EList<PropertyValue> getPropertyValue(ComponentClassifier cc,
			String propertyName)
			{
		EList<PropertyValue> result = new BasicEList<PropertyValue>() ;

		EList<PropertyAssociation> lpa = getPropertyAssociations(cc, propertyName) ;

		for (PropertyAssociation pa : lpa)
		{
			result.addAll(getPropertyValue(pa)) ;
		}

		// If no property value is found, search within parent container if only
		// the given component is a component implementation. Recursive call.
		if(result.isEmpty() && cc instanceof ComponentImplementation )
		{
			cc = ((ComponentImplementation) cc).getType() ;
			result = getPropertyValue(cc, propertyName) ;
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
	public static PropertyAssociation getPropertyAssociation(ComponentClassifier cc, String propertyName)
	{
		Property p = null ;

		// FIXME : TODO : improve function, get properties from component type too
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
	public static EList<PropertyAssociation> getPropertyAssociations(ComponentClassifier cc, String propertyName)
	{
		Property p = null ;
		EList<PropertyAssociation> lpa = null ;

		EList<PropertyAssociation> lparesult = new BasicEList<PropertyAssociation>() ;

		// FIXME : TODO : improve function, get properties from component type too
		if(!cc.isNoProperties())
		{
			lpa = cc.getAllPropertyAssociations() ;

			for(PropertyAssociation pa : lpa)
			{
				p = pa.getProperty() ;
				if(p.getName().equalsIgnoreCase(propertyName))
				{
					lparesult.add(pa) ;
				}
			}
		}
		return lparesult ;
	}

	/**
	 * 
	 * @param lpa property association lists
	 * @return
	 */

	public static EList<String> getPropertyDispatchTriggers(EList<PropertyAssociation> lpa)
	{
		ReferenceValue rv = null ;
		EList<ContainmentPathElement> lcpe = null ;
		EList<ModalPropertyValue> lmpv = null ;

		EList<String> result = new BasicEList<String>() ;

		for(PropertyAssociation pa : lpa)
		{
			lmpv = pa.getOwnedValues() ;

			for(ModalPropertyValue mpv : lmpv)
			{
				rv = (ReferenceValue) mpv.getOwnedValue() ;
				lcpe = rv.getContainmentPathElements() ;

				for(ContainmentPathElement cpe : lcpe)
				{
					NamedElement ne = cpe.getNamedElement() ;
					result.add(ne.getName()) ;
				}
			}
		}
		return result ;
	}

	/**
	 * 
	 * @param pa a given property association
	 * @return the list of property values of the property
	 */

	public static EList<PropertyValue> getPropertyValue(PropertyAssociation pa)
	{
		EList<ModalPropertyValue> lmpv = null ;
		EList<PropertyValue> result = new BasicEList<PropertyValue>() ;

		lmpv = pa.getOwnedValues() ;

		for(ModalPropertyValue mpv : lmpv)	
		{
			result.add((PropertyValue) mpv.getOwnedValue());
		}
		return result ;
	}

}
