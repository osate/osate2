/*
 * <copyright>
 * Copyright  2005 by Carnegie Mellon University, all rights reserved.
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

import edu.cmu.sei.aadl.aadl2.Property;
import edu.cmu.sei.aadl.aadl2.PropertyConstant;
import edu.cmu.sei.aadl.aadl2.UnitLiteral;
import edu.cmu.sei.aadl.aadl2.UnitsType;
import edu.cmu.sei.aadl.modelsupport.eclipseinterface.OsateResourceManager;
import edu.cmu.sei.contributes.sei.names.SEI;
import edu.cmu.sei.osate.ui.actions.AbstractAnalysis;
import edu.cmu.sei.osate.workspace.names.standard.AadlProject;
import edu.cmu.sei.osate.workspace.names.standard.CommunicationProperties;
import edu.cmu.sei.osate.workspace.names.standard.DeploymentProperties;
import edu.cmu.sei.osate.workspace.names.standard.MemoryProperties;
import edu.cmu.sei.osate.workspace.names.standard.TimingProperties;

public class BinpackAnalysis extends AbstractAnalysis
{
	private BinpackProperties properties;
	
	protected boolean runImpl()
	{
		return true;
	}

	protected boolean readyToRunImpl()
	{
		Property period = OsateResourceManager.findProperty(TimingProperties.PERIOD);
		if (period == null)
		{
			propertyDefinitionNotFound(TimingProperties._NAME, TimingProperties.PERIOD);
			return false;
		}
		Property deadline = OsateResourceManager.findProperty(TimingProperties.DEADLINE);
		if (deadline == null)
		{
			propertyDefinitionNotFound(TimingProperties._NAME, TimingProperties.DEADLINE);
			return false;
		}
		Property computeExecutionTime = OsateResourceManager.findProperty(TimingProperties.COMPUTE_EXECUTION_TIME);
		if (computeExecutionTime == null)
		{
			propertyDefinitionNotFound(TimingProperties._NAME, TimingProperties.COMPUTE_EXECUTION_TIME);
			return false;
		}
		Property schedulingProtocol = OsateResourceManager.findProperty(DeploymentProperties.SCHEDULING_PROTOCOL);
		if (schedulingProtocol == null)
		{
			propertyDefinitionNotFound(DeploymentProperties._NAME, DeploymentProperties.SCHEDULING_PROTOCOL);
			return false;
		}
		Property notCollocated = OsateResourceManager.findProperty(DeploymentProperties.NOT_COLLOCATED);
		if (notCollocated == null)
		{
			propertyDefinitionNotFound(DeploymentProperties._NAME, DeploymentProperties.NOT_COLLOCATED);
			return false;
		}
		Property actualProcessorBinding = OsateResourceManager.findProperty(DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
		if (actualProcessorBinding == null)
		{
			propertyDefinitionNotFound(DeploymentProperties._NAME, DeploymentProperties.ACTUAL_PROCESSOR_BINDING);
			return false;
		}
		Property allowedProcessorBinding = OsateResourceManager.findProperty(DeploymentProperties.ALLOWED_PROCESSOR_BINDING);
		if (allowedProcessorBinding == null)
		{
			propertyDefinitionNotFound(DeploymentProperties._NAME, DeploymentProperties.ALLOWED_PROCESSOR_BINDING);
			return false;
		}
		Property allowedProcessorBindingClass =
			OsateResourceManager.findProperty(DeploymentProperties.ALLOWED_PROCESSOR_BINDING_CLASS);
		if (allowedProcessorBindingClass == null)
		{
			propertyDefinitionNotFound(DeploymentProperties._NAME, DeploymentProperties.ALLOWED_PROCESSOR_BINDING_CLASS);
			return false;
		}
		UnitsType timeUnits = (UnitsType)OsateResourceManager.findPropertyType(AadlProject.TIME_UNITS);
		if (timeUnits == null)
		{
			unitsTypeNotFound(AadlProject._NAME, AadlProject.TIME_UNITS);
			return false;
		}
		UnitLiteral second = (UnitLiteral) timeUnits.findNamedElement(AadlProject.SEC_LITERAL);
		if (second == null)
		{
			unitLiteralNotFound(AadlProject.SEC_LITERAL, timeUnits);
			return false;
		}
		UnitLiteral nanoSecond = (UnitLiteral) timeUnits.findNamedElement(AadlProject.NS_LITERAL);
		if (nanoSecond == null)
		{
			unitLiteralNotFound(AadlProject.NS_LITERAL, timeUnits);
			return false;
		}
		
		Property referenceProcessor = OsateResourceManager.findProperty(SEI._NAME, SEI.REFERENCE_PROCESSOR);
		if (referenceProcessor == null)
		{
			propertyDefinitionNotFound(SEI._NAME, SEI.REFERENCE_PROCESSOR);
			return false;
		}
		//It is ok if referenceCycleTime cannot be found.
		PropertyConstant referenceCycleTime = OsateResourceManager.findPropertyConstant(SEI._NAME, SEI.REFERENCE_CYCLE_TIME);
		Property cycleTime = OsateResourceManager.findProperty(SEI._NAME, SEI.CYCLE_TIME);
		if (cycleTime == null)
		{
			propertyDefinitionNotFound(SEI._NAME, SEI.CYCLE_TIME);
			return false;
		}
		
		Property transmissionTime = OsateResourceManager.findProperty(CommunicationProperties.TRANSMISSION_TIME);
		if (transmissionTime == null)
		{
			propertyDefinitionNotFound(CommunicationProperties._NAME, CommunicationProperties.TRANSMISSION_TIME);
			return false;
		}
		
		Property size = OsateResourceManager.findProperty(MemoryProperties.SOURCE_DATA_SIZE);
		UnitsType sizeUnits = (UnitsType)OsateResourceManager.findPropertyType(AadlProject.SIZE_UNITS);
		UnitLiteral bits = (UnitLiteral) sizeUnits.findNamedElement(AadlProject.BITS_LITERAL);
		
		properties = new BinpackProperties(period, deadline, computeExecutionTime, schedulingProtocol, notCollocated, actualProcessorBinding,
				allowedProcessorBinding, allowedProcessorBindingClass, second, nanoSecond, referenceProcessor, referenceCycleTime, cycleTime, 
				transmissionTime, size, bits);
		return true;
		
	}
	
	protected String getMarkerType()
	{
		return "edu.cmu.sei.aadl.resourcemanagement.BinpackObjectMarker";
	}
}