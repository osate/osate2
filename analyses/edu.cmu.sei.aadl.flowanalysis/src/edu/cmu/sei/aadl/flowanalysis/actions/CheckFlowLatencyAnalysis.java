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
package edu.cmu.sei.aadl.flowanalysis.actions;

import org.eclipse.core.runtime.NullProgressMonitor;

import edu.cmu.sei.aadl.aadl2.ComponentImplementation;
import edu.cmu.sei.aadl.aadl2.Property;
import edu.cmu.sei.aadl.aadl2.UnitLiteral;
import edu.cmu.sei.aadl.aadl2.UnitsType;
import edu.cmu.sei.aadl.aadl2.instance.SystemInstance;
import edu.cmu.sei.aadl.flowanalysis.FlowLatencyAnalysisSwitch;
import edu.cmu.sei.aadl.modelsupport.eclipseinterface.OsateResourceManager;
import edu.cmu.sei.contributes.sei.names.SEI;
import edu.cmu.sei.osate.ui.actions.AbstractAnalysis;
import edu.cmu.sei.osate.workspace.names.standard.AadlProject;
import edu.cmu.sei.osate.workspace.names.standard.CommunicationProperties;
import edu.cmu.sei.osate.workspace.names.standard.ThreadProperties;
import edu.cmu.sei.osate.workspace.names.standard.TimingProperties;

public class CheckFlowLatencyAnalysis extends AbstractAnalysis
{
	private FlowLatencyProperties properties;
	
	protected boolean runImpl()
	{
		if (getParameter() instanceof SystemInstance)
		{ // TODO
		}
		else
		{
			final FlowLatencyAnalysisSwitch flowLatencySwitch = new FlowLatencyAnalysisSwitch(properties, new NullProgressMonitor(), getErrorManager());
			flowLatencySwitch.processBottomUpComponentImpl(); //(ComponentImplementation)getParameter());
		}
		return getErrorManager().getNumErrors() == 0;
	}

	protected boolean readyToRunImpl()
	{
		final Property partitionLatency =
			OsateResourceManager.findProperty(
					SEI._NAME, SEI.PARTITION_LATENCY);
		if (partitionLatency == null)
		{
			propertyDefinitionNotFound(SEI._NAME, SEI.PARTITION_LATENCY);
			return false;
		}
		final Property isPartition =
			OsateResourceManager.findProperty(
				SEI._NAME, SEI.IS_PARTITION);
		if (isPartition == null)
		{
			propertyDefinitionNotFound(SEI._NAME, SEI.IS_PARTITION);
			return false;
		}
		Property dispatchProtocol = OsateResourceManager.findProperty(ThreadProperties.DISPATCH_PROTOCOL);
		if (dispatchProtocol == null)
		{
			propertyDefinitionNotFound(ThreadProperties._NAME, ThreadProperties.DISPATCH_PROTOCOL);
			return false;
		}
		Property deviceDispatchProtocol = OsateResourceManager.findProperty(ThreadProperties.DISPATCH_PROTOCOL);
		if (deviceDispatchProtocol == null)
		{
			propertyDefinitionNotFound(ThreadProperties._NAME, ThreadProperties.DISPATCH_PROTOCOL);
			return false;
		}
		Property Latency = OsateResourceManager.findProperty(CommunicationProperties.LATENCY);
		if (Latency == null)
		{
			propertyDefinitionNotFound(CommunicationProperties._NAME, CommunicationProperties.LATENCY);
			return false;
		}
		Property actualLatencyPD = OsateResourceManager.findProperty(CommunicationProperties.ACTUAL_LATENCY);
		if (actualLatencyPD == null)
		{
			propertyDefinitionNotFound(CommunicationProperties._NAME, CommunicationProperties.ACTUAL_LATENCY);
			return false;
		}
		Property deadlinePD = OsateResourceManager.findProperty(TimingProperties.DEADLINE);
		if (deadlinePD == null)
		{
			propertyDefinitionNotFound(TimingProperties._NAME, TimingProperties.DEADLINE);
			return false;
		}
		Property periodPD = OsateResourceManager.findProperty(TimingProperties.PERIOD);
		if (periodPD == null)
		{
			propertyDefinitionNotFound(TimingProperties._NAME, TimingProperties.PERIOD);
			return false;
		}
		Property queuesizePD = OsateResourceManager.findProperty(CommunicationProperties.QUEUE_SIZE);
		if (queuesizePD == null)
		{
			propertyDefinitionNotFound(CommunicationProperties._NAME, CommunicationProperties.QUEUE_SIZE);
			return false;
		}
		UnitsType TimeUnits = (UnitsType)OsateResourceManager.findPropertyType(AadlProject.TIME_UNITS);
		if (TimeUnits == null)
		{
			unitsTypeNotFound(AadlProject._NAME, AadlProject.TIME_UNITS);
			return false;
		}
		UnitLiteral MicroSec = (UnitLiteral) TimeUnits.findNamedElement(AadlProject.US_LITERAL);
		if (MicroSec == null)
		{
			unitLiteralNotFound(AadlProject.US_LITERAL, TimeUnits);
			return false;
		}
		properties = new FlowLatencyProperties(dispatchProtocol, partitionLatency, isPartition, Latency,
				 actualLatencyPD, deadlinePD, periodPD, MicroSec,queuesizePD);
		return true;
	}
	
	protected String getMarkerType()
	{
		return "edu.cmu.sei.aadl.flowanalysis.FlowLatencyObjectMarker";
	}
}