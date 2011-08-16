package edu.cmu.sei.aadl.resourcemanagement.actions;

import org.osate.aadl2.NumberValue;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.xtext.aadl2.properties.GetProperties;
import org.osate.xtext.aadl2.properties.PropertyUtils;

import EAnalysis.BinPacking.BandwidthComparator;
import EAnalysis.BinPacking.CapacityComparator;
import EAnalysis.BinPacking.EDFScheduler;
import EAnalysis.BinPacking.Link;


public class AADLBus extends Link {

	public static final double DEFAULT_TRANSMISSION_TIME = 10.0e-6;

	public AADLBus(){
		super(new CapacityComparator(),new EDFScheduler(new BandwidthComparator()), 1000);
	}
	
	public AADLBus(double cyclesPerSec){
		super(new CapacityComparator(), new EDFScheduler(new BandwidthComparator()), cyclesPerSec);
	}
	
	public static AADLBus createInstance(ComponentInstance bi){
		double bitsPerSec=0;		
		bitsPerSec = 1.0/getTransmissionTime(bi);
		AADLBus bus = new AADLBus(bitsPerSec);
		bus.setSemanticObject(bi);
		return bus;
	}
	
	private static double getTransmissionTime(final ComponentInstance proc) {
		RecordValue rv = GetProperties.getTransmissionTime(proc);
		if (rv == null) return DEFAULT_TRANSMISSION_TIME;
		RangeValue bpa = (RangeValue)PropertyUtils.getRecordFieldValue(rv, "PerByte");
		NumberValue nv = bpa.getMaximumValue();
		return nv.getScaledValue(GetProperties.getSecUnitLiteral(proc));
	}

}
