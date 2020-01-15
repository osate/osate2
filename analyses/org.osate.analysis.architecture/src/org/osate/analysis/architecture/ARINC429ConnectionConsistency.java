/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.analysis.architecture;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * @author phf
 *
 * This class provides for checking properties on ports of a connection match up.
 *
 */
public class ARINC429ConnectionConsistency extends AadlProcessingSwitchWithProgress {
	AbstractAaxlHandler handler;

	public ARINC429ConnectionConsistency(final IProgressMonitor pm, AbstractAaxlHandler handler) {
		super(pm, PROCESS_PRE_ORDER_ALL);
		this.handler = handler;
	}

	public final void initSwitches() {
		/* here we are creating the connection checking switches */
		instanceSwitch = new InstanceSwitch<String>() {
			/**
			 * check port properties for connection end points
			 */
			public String caseConnectionInstance(ConnectionInstance conni) {
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
		Property WordID = GetProperties.lookupPropertyDefinition(conni, "ARINC429", "WordID");
		Property StartBit = GetProperties.lookupPropertyDefinition(conni, "ARINC429", "FirstBit");
		Property NumberBits = GetProperties.lookupPropertyDefinition(conni, "ARINC429", "NumberBits");

		long srcWordID = PropertyUtils.getIntegerValue(srcFI, WordID, 0);
		long dstWordID = PropertyUtils.getIntegerValue(dstFI, WordID, 0);
		long srcStartBit = PropertyUtils.getIntegerValue(srcFI, StartBit, -1);
		long dstStartBit = PropertyUtils.getIntegerValue(dstFI, StartBit, -1);
		long srcC = PropertyUtils.getIntegerValue(srcFI, NumberBits, 0);
		long dstC = PropertyUtils.getIntegerValue(dstFI, NumberBits, 0);

		// error logging

		if (srcWordID > 0 && dstWordID > 0) {
			if (srcWordID != dstWordID) {
				error(conni, "Source Word ID " + srcWordID + " and Word ID " + dstWordID + " differ");
			}
		}
		if (srcStartBit > -1 && dstStartBit > -1) {
			if (srcStartBit != dstStartBit) {
				error(conni,
						"Source Start Bit " + srcStartBit + " and destination Start Bit " + dstStartBit + " differ");
			}
		}
		if (srcC > 0 && dstC > 0) {
			if (srcC != dstC) {
				error(conni, "Source number bits " + srcC + " and destination number bits " + dstC + " differ");
			}
		}
	}

	private static NamedElement previousNE = null;

	private void error(NamedElement el, String s) {
		super.error(el, s);
		if (previousNE == null || previousNE != el) {
			if (previousNE != null)
				handler.logInfo("");
			handler.logInfo(el.getName() + "," + s);
		} else {
			handler.logInfo("," + s);
		}
		previousNE = el;
	}

}
