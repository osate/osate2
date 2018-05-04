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
