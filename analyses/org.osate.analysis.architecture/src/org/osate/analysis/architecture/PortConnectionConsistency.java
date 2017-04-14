/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
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
 *
 * </copyright>
 *
 *
 * @version $Id: PortConnectionConsistency.java,v 1.1.2.6 2009-04-14 15:02:20 jseibel Exp $
 */
package org.osate.analysis.architecture;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.ui.actions.AbstractAaxlAction;
import org.osate.xtext.aadl2.properties.util.GetProperties;

/**
 * @author phf
 *
 * This class provides for checking properties on ports of a connection match up.
 *
 */
public class PortConnectionConsistency extends AadlProcessingSwitchWithProgress {

	private AbstractAaxlAction action;

	public PortConnectionConsistency(final IProgressMonitor pm, AbstractAaxlAction action) {
		super(pm, PROCESS_PRE_ORDER_ALL);
		this.action = action;
	}

	@Override
	public final void initSwitches() {

		/* here we are creating the connection checking switches */
		instanceSwitch = new InstanceSwitch() {
			/**
			 * check port properties for connection end points
			 */
			@Override
			public Object caseConnectionInstance(ConnectionInstance conni) {
//				monitorUpdate(conni.getName());
				ConnectionInstanceEnd srcFI = conni.getSource();
				ConnectionInstanceEnd dstFI = conni.getDestination();
				if (srcFI == null || dstFI == null) {
					error(conni, "Connection source or destination is null");
					return DONE;
				}
				if (srcFI instanceof FeatureInstance && dstFI instanceof FeatureInstance) {
					checkPortConsistency((FeatureInstance) srcFI, (FeatureInstance) dstFI, conni);
				}
				return DONE;
			}
		};
	}

	public void doHeaders() {
	}

	public void checkPortConsistency(FeatureInstance srcFI, FeatureInstance dstFI, ConnectionInstance conni) {
		double srcDataSize = GetProperties.getSourceDataSizeInBytes(srcFI);
		double dstDataSize = GetProperties.getSourceDataSizeInBytes(dstFI);

		RecordValue srcRate = GetProperties.getOutPutRate(srcFI);
		RecordValue dstRate = GetProperties.getInPutRate(dstFI);
		EnumerationLiteral srcRU = null;
		EnumerationLiteral dstRU = null;
		double srcMaxRateValue = 0;
		double dstMaxRateValue = 0;
		double srcMinRateValue = 0;
		double dstMinRateValue = 0;
		if (srcRate != null && dstRate != null) {
			srcRU = GetProperties.getRateUnit(srcRate);
			dstRU = GetProperties.getRateUnit(dstRate);
			srcMaxRateValue = GetProperties.getMaxDataRate(srcRate);
			dstMaxRateValue = GetProperties.getMaxDataRate(dstRate);
			srcMinRateValue = GetProperties.getMinDataRate(srcRate);
			dstMinRateValue = GetProperties.getMinDataRate(dstRate);
		}
		// now try it as SEI::Data_Rate
		double srcRateValue = GetProperties.getMessageRatePerSecond(srcFI);
		double dstRateValue = GetProperties.getMessageRatePerSecond(dstFI);

		Classifier srcC = GetProperties.getSingleBaseType(srcFI);
		Classifier dstC = GetProperties.getSingleBaseType(dstFI);

		String srcS = GetProperties.getMeasurementUnit(srcFI);
		String dstS = GetProperties.getMeasurementUnit(dstFI);

		// error logging

		if (srcDataSize > 0 && dstDataSize > 0) {
			if (srcDataSize != dstDataSize) {
				error(conni, "Source data size " + srcDataSize + " Bytes and destination data size " + dstDataSize
						+ " Bytes differ");
			}
		} else {
			if (srcDataSize == 0 && dstDataSize > 0)
				error(conni, "Source data size is missing or zero");
			if (dstDataSize == 0 && srcDataSize > 0)
				error(conni, "Destination data size is missing or zero");
		}

		if (srcRU != null && dstRU != null && srcRU != dstRU) {
			error(conni, "Source rate unit " + srcRU.getName() + " and destination rate unit " + dstRU.getName()
					+ " differ");
		}

		if (srcMaxRateValue > 0 && dstMaxRateValue > 0) {
			if (srcMaxRateValue > dstMaxRateValue) {
				error(conni, "Maximum source data rate " + srcMaxRateValue
						+ " is greater than maximum destination data rate " + dstMaxRateValue);
			}
			if (srcMinRateValue < dstMinRateValue) {
				error(conni, "Minimum source data rate " + srcMinRateValue
						+ " is less than minimum destination data rate " + dstMinRateValue);
			}
		} else {
			if (srcRate != null || dstRate != null) {
				error(conni, "Missing input rate or output rate");
			}
		}

		if (srcRateValue > 0 && dstRateValue > 0) {
			if (srcRateValue != dstRateValue) {
				error(conni,
						"Source data rate " + srcRateValue + " and destination data rate " + dstRateValue + " differ");
			}
		} else {
			if (srcRateValue == 0 && dstRateValue > 0)
				error(conni, "Source data rate is missing or zero");
			if (dstRateValue == 0 && srcRateValue > 0)
				error(conni, "Destination data rate is missing or zero");
		}

		if (srcC != null && dstC != null) {
			if (srcC != dstC) {
				error(conni, "Source base type " + srcC.getName() + " and destination base type " + dstC.getName()
						+ " differ");
			}
		} else {
			if (srcC == null && dstC != null)
				error(conni, "Source base type is missing");
			if (dstC == null && srcC != null)
				error(conni, "Destination base type is missing");
		}

		if (srcS.length() > 0 && dstS.length() > 0) {
			if (!srcS.equalsIgnoreCase(dstS)) {
				error(conni,
						"Source measurement unit " + srcS + " and destination measurement unit " + dstS + " differ");
			}
		} else {
			if (srcS.length() == 0 && dstS.length() > 0)
				error(conni, "Source measurement unit is missing");
			if (dstS.length() == 0 && srcS.length() > 0)
				error(conni, "Destination measurement unit is missing");
		}
	}

	private static NamedElement previousNE = null;

	protected void error(NamedElement el, String s) {
		super.error(el, s);
		if (previousNE == null || previousNE != el) {
			if (previousNE != null)
				action.logInfo("");
			action.logInfo(el.getName() + "," + s);
		} else {
			action.logInfo("," + s);
		}
		previousNE = el;
	}

}
