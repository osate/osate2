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
package org.osate.analysis.resource.management.handlers;

import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.CapacityComparator;
import EAnalysis.BinPacking.EDFScheduler;
import EAnalysis.BinPacking.Link;

public class AADLBus extends Link {

	public static final double DEFAULT_TRANSMISSION_TIME = 10.0e-6;

	public AADLBus() {
		super(new CapacityComparator(), new EDFScheduler(new BandwidthComparator()), 1 / DEFAULT_TRANSMISSION_TIME);
	}

	public AADLBus(double bytesPerSec) {
		super(new CapacityComparator(), new EDFScheduler(new BandwidthComparator()), bytesPerSec);
	}

	public static AADLBus createInstance(ComponentInstance bi) {
		double bytesPerSec = 0;
		bytesPerSec = 1.0 / getTransmissionTimePerByte(bi);
		AADLBus bus = new AADLBus(bytesPerSec);
		bus.setSemanticObject(bi);
		return bus;
	}

	private static double getTransmissionTimePerByte(final ComponentInstance proc) {
		RecordValue rv = GetProperties.getTransmissionTime(proc);
		if (rv == null)
			return DEFAULT_TRANSMISSION_TIME;
		RangeValue bpa = (RangeValue) PropertyUtils.getRecordFieldValue(rv, "PerByte");
		if (bpa != null) {
			NumberValue nv = bpa.getMaximumValue();
			return nv.getScaledValue(GetProperties.getSecUnitLiteral(proc));
		}
		return 0;
	}

	public String getReport() {
		String res = "Bus " + this.name + "Bytes per sec " + this.cyclesPerSecond;
		return res;
	}

}
