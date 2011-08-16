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
package edu.cmu.sei.aadl.flowanalysis.actions;


import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.UnitsType;
import org.osate.aadl2.properties.PropertyLookupException;


public class FlowLatencyProperties
{
	private final Property dispatchProtocol;
	private final Property partitionLatency;
	private final Property isPartition;
	private final Property Latency;
	private final Property actualLatencyPD;
	private final Property deadlinePD;
	private final Property periodPD;
	private final Property queuesizePD;
	private final UnitLiteral MicroSec;
	
	public FlowLatencyProperties(final Property dispatchProtocol, 
			final Property partitionLatency, final Property isPartition, final Property Latency,
			final Property actualLatencyPD, final Property deadlinePD, final Property periodPD,
			final UnitLiteral MicroSec, final Property queuesizePD)
	{
		this.dispatchProtocol = dispatchProtocol;
		this.partitionLatency = partitionLatency;
		this.isPartition = isPartition;
		this.Latency = Latency;
		this.actualLatencyPD = actualLatencyPD;
		this.deadlinePD = deadlinePD;
		this.periodPD = periodPD;
		this.MicroSec = MicroSec;
		this.queuesizePD = queuesizePD;
	}

	public FlowLatencyProperties()
	{
		this.partitionLatency = lookupPropertyDefinition(SEI._NAME, SEI.PARTITION_LATENCY);
		this.isPartition = lookupPropertyDefinition(SEI._NAME, SEI.IS_PARTITION);
		this.dispatchProtocol = lookupPropertyDefinition(ThreadProperties.DISPATCH_PROTOCOL);
		this.Latency = lookupPropertyDefinition(CommunicationProperties.LATENCY);
		this.actualLatencyPD = lookupPropertyDefinition(CommunicationProperties.ACTUAL_LATENCY);
		this.deadlinePD = lookupPropertyDefinition(TimingProperties.DEADLINE);
		this.periodPD = lookupPropertyDefinition(TimingProperties.PERIOD);
		this.queuesizePD = lookupPropertyDefinition(CommunicationProperties.QUEUE_SIZE);
		this.MicroSec = lookupUnitLiteral(AadlProject.TIME_UNITS, AadlProject.US_LITERAL);
	}
	protected final Property lookupPropertyDefinition(
			final String ps, final String name) {
		final Property pd = 
			OsateResourceManager.findProperty(ps, name);
		return pd;
	}
	protected final Property lookupPropertyDefinition(
			final String name) {
		final Property pd = 
			OsateResourceManager.findProperty(name);
		return pd;
	}
	protected final UnitLiteral lookupUnitLiteral(
			final String unitType, final String literalName) {
		// Through ClassCastException if the type is not a unit type
		final UnitsType type = (UnitsType) lookupPropertyType(unitType);
		if (type != null) {
			final UnitLiteral literal = (UnitLiteral) type.findNamedElement(literalName);
			return literal;
		} else {
			return null;
		}
	}
	protected final PropertyType lookupPropertyType(final String name) {
		final PropertyType pt = 
			OsateResourceManager.findPropertyType(name);
		return pt;
	}
	
	public EnumerationLiteral getDispatchProtocol(final NamedElement ph)
	{
		try
		{
		return PropertyUtils.getEnumLiteral(ph, dispatchProtocol);
		}
		catch (PropertyLookupException e)
		{
			return null;
		}
	}
	
	public EnumerationLiteral getDeviceDispatchProtocol(final NamedElement ph)
	{
		try
		{
		return PropertyUtils.getEnumLiteral(ph, dispatchProtocol);
		}
		catch (PropertyLookupException e)
		{
			return null;
		}
	}
	
	public double getPartitionLatency(final NamedElement ph, final double defaultValue)
	{
		try
		{
			return PropertyUtils.getScaledNumberValue(ph, partitionLatency, MicroSec, defaultValue);
		}
		catch (PropertyLookupException e)
		{
			return defaultValue;
		}
	}
	
	public boolean getIsPartition(final NamedElement ph)
	{
		try
		{
			return PropertyUtils.getBooleanValue(ph, isPartition);
		}
		catch (PropertyLookupException e)
		{
			return false;
		}
	}
	
	public PropertyAssociation setLatency(final NamedElement ph, final long value)
	{
		try {
			final IntegerLiteral newIntegerValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			newIntegerValue.setValue((int)value);
			newIntegerValue.setValue(Long.toString(value));
			newIntegerValue.setUnit(MicroSec);
			return ph.setPropertyValue(Latency, newIntegerValue);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	
	public PropertyAssociation setActualLatency(final NamedElement ph, final long value)
	{
		try {
			final IntegerLiteral newIntegerValue = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			newIntegerValue.setValue((int)value);
			newIntegerValue.setValue(Long.toString(value));			
			newIntegerValue.setUnit(MicroSec);
			return ph.setPropertyValue(actualLatencyPD, newIntegerValue);
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	
	public double getLatency(final NamedElement ph)
	{
		try
		{
			return PropertyUtils.getScaledNumberValue(ph, Latency, MicroSec);
		}
		catch (PropertyLookupException e)
		{
			return 0.0;
		}
	}
	
 public double getActualLatency(final NamedElement ph)
	{
		try
		{
			return PropertyUtils.getScaledNumberValue(ph, actualLatencyPD, MicroSec);
		}
		catch (PropertyLookupException e)
		{
			return 0.0;
		}
	}
	
	public double getDeadline(final NamedElement ph)
	{
		try
		{
			return PropertyUtils.getScaledNumberValue(ph, deadlinePD, MicroSec);
		}
		catch (PropertyLookupException e)
		{
			return 0.0;
		}
	}
	
	public long getQueueSize(final NamedElement ph)
	{
		try
		{
			return PropertyUtils.getIntegerValue(ph, queuesizePD, 0);
		}
		catch (PropertyLookupException e)
		{
			return 0;
		}
	}

	
	public double getPeriod(final NamedElement ph)
	{
		try
		{
			return PropertyUtils.getScaledNumberValue(ph, periodPD, MicroSec);
		}
		catch (PropertyLookupException e)
		{
			return 0.0;
		}
	}
}