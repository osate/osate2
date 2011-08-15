package edu.cmu.sei.aadl.resourcemanagement.actions;

import org.osate.aadl2.instance.ComponentInstance;

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
	
	public static AADLBus createInstance(ComponentInstance bi, BinpackProperties properties){
		double bitsPerSec=0;		
		bitsPerSec = 1.0/getTransmissionTime(bi, properties);
		AADLBus bus = new AADLBus(bitsPerSec);
		bus.setSemanticObject(bi);
		return bus;
	}
	
	private static double getTransmissionTime(final ComponentInstance proc, BinpackProperties properties) {
		return properties.getTransmissionTimeMultiplier(proc, DEFAULT_TRANSMISSION_TIME);
	}

}
