/*
 * <copyright>
 * Copyright  2006 by Carnegie Mellon University, all rights reserved.
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
package edu.cmu.sei.aadl.resourcemanagement.actions;

import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.PropertyValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.aadl2.properties.PropertyDoesNotApplyToHolderException;
import org.osate.aadl2.properties.PropertyIsListException;
import org.osate.aadl2.properties.PropertyIsModalException;
import org.osate.aadl2.properties.PropertyNotPresentException;
import org.osate.xtext.aadl2.properties.GetProperties;
import org.osate.xtext.aadl2.properties.PropertyUtils;

public class BinpackProperties
{
	
	public double getPeriodAsNanoSecond(final NamedElement ph)
	{
		return PropertyUtils.getScaledNumberValue(ph, period, nanoSecond, AADLThread.DEFAULT_PERIOD_NANOSECOND);
	}
	
	public double getDeadlineAsSecond(final NamedElement ph)
	{
		return PropertyUtils.getScaledNumberValue(ph, deadline, second);
	}
	
	public double getDeadlineAsNanoSecond(final NamedElement ph)
	{
		return PropertyUtils.getScaledNumberValue(ph, deadline, nanoSecond);
	}
	
	public double getComputeExecutionTime(final NamedElement ph)
	{
		return PropertyUtils.getScaledRangeMaximum(ph, computeExecutionTime, second);
	}
	
	public List getSchedulingProtocol(final NamedElement ph)
	{
		return ph.getPropertyValueList(schedulingProtocol);
	}
	
	public List getNotCollocated(final NamedElement ph)
	{
		return ph.getPropertyValueList(notCollocated);
	}
	
	public PropertyValue getActualProcessorBindingPropertyValue(final NamedElement ph)
	{
		return (PropertyValue) ph.getSimplePropertyValue(actualProcessorBinding);
	}
	
	public void setActualProcessorBindingDefinitionToAssociation(final PropertyAssociation pa)
	{
		pa.setProperty(actualProcessorBinding);
	}
	
	public PropertyAssociation setActualProcessorBindingPropertyValue(final NamedElement ph, final PropertyValue pv)
	{
		return ph.setPropertyValue(actualProcessorBinding, pv);
	}
	
	public void removeActualProcessorBindingPropertyAssociations(final NamedElement ph)
	{
		ph.removePropertyAssociations(actualProcessorBinding);
	}
	
	public List getAllowedProcessorBinding(final NamedElement ph)
	{
		return ph.getPropertyValueList(allowedProcessorBinding);
	}
	
	public List getAllowedProcessorBindingClass(final NamedElement ph)
	{
		return ph.getPropertyValueList(allowedProcessorBindingClass);
	}
	
	public PropertyValue getReferenceProcessorPropertyValue(final NamedElement ph) 
	throws InvalidModelException, PropertyNotPresentException, PropertyIsModalException, IllegalStateException,
	IllegalArgumentException, PropertyDoesNotApplyToHolderException, PropertyIsListException
	{
		return (PropertyValue) ph.getSimplePropertyValue(referenceProcessor);
	}
	
	public boolean referenceCycleTimeExists()
	{
		return referenceCycleTime != null;
	}
	
	public double getReferenceCycleTime()
	{
		return ((NumberValue)referenceCycleTime.getConstantValue()).getScaledValue(second);
	}
	
	public List getTransmissionTimePropertyValue(final NamedElement ph) {
		return ph.getPropertyValueList(transmissionTime);
	}
	
	public double getTransmissionTimeMultiplier(final NamedElement ph, final double defaultValue) {
		try {
			final List list = getTransmissionTimePropertyValue(ph);
			// get the multiplier only
			if (list.size() >= 2) {
				final RangeValue range = (RangeValue) list.get(1);	
				PropertyExpression maximum = range.getMaximum().evaluate(null).first().getValue();
				if (maximum instanceof NumberValue) {
					return ((NumberValue)maximum).getScaledValue(GetProperties.getSecUnitLiteral(ph));
				} else {
					return defaultValue;
				}
			} else {
				// Badly formed property value
				return defaultValue;
			}
		} catch (final PropertyNotPresentException e) {
			return defaultValue;
		}

	}
}