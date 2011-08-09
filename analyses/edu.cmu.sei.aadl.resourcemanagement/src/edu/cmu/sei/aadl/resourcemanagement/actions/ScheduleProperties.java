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

import edu.cmu.sei.aadl.aadl2.NamedElement;
import edu.cmu.sei.aadl.aadl2.Property;
import edu.cmu.sei.aadl.aadl2.UnitLiteral;
import edu.cmu.sei.aadl.aadl2.instance.ComponentInstance;
import edu.cmu.sei.aadl.aadl2.instance.InstanceObject;
import edu.cmu.sei.aadl.modelsupport.properties.PropertyUtils;

public class ScheduleProperties
{
	private final Property period;
	private final Property deadline;
	private final Property computeExecutionTime;
	private final Property actualProcessorBinding;
	private final Property priority;
	private final UnitLiteral microSecond;
	
	public ScheduleProperties(final Property period, final Property deadline, final Property computeExecutionTime,
			final Property actualProcessorBinding, final Property priority, final UnitLiteral microSecond)
	{
		this.period = period;
		this.deadline = deadline;
		this.computeExecutionTime = computeExecutionTime;
		this.actualProcessorBinding = actualProcessorBinding;
		this.priority = priority;
		this.microSecond = microSecond;
	}
	
	public double getPeriod(final NamedElement ph)
	{
		return PropertyUtils.getScaledNumberValue(ph, period, microSecond,0.0);
	}
	
	public double getDeadline(final NamedElement ph)
	{
		return PropertyUtils.getScaledNumberValue(ph, deadline, microSecond, 0.0);
	}
	
	public double getComputeExecutionTimeMaximumValue(final NamedElement ph)
	{
		return PropertyUtils.getScaledRangeMaximum(ph, computeExecutionTime, microSecond,0.0);
	}
	
	public ComponentInstance getActualProcessorBinding(final InstanceObject io)
	{
		return (ComponentInstance) PropertyUtils.getInstanceObjectReference(io, actualProcessorBinding);
	}
	
	public long getPriority(final NamedElement ph, final long defaultValue)
	{
		return PropertyUtils.getIntegerValue(ph, priority, defaultValue);
	}
}