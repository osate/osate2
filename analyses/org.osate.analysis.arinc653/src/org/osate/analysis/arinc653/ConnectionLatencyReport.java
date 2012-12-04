package org.osate.analysis.arinc653;

import org.osate.aadl2.instance.ComponentInstance;

public class ConnectionLatencyReport {

	private ComponentInstance partitionSource;
	private ComponentInstance partitionDestination;
	
	private long latency;
	
	public ConnectionLatencyReport (ComponentInstance ps, ComponentInstance pd, long l)
	{
		partitionSource = ps;
		partitionDestination = pd;
		latency = l;
	}
	
	public ComponentInstance getPartitionSource ()
	{
		return this.partitionSource;
	}
	
	public ComponentInstance getPartitionDestination ()
	{
		return this.partitionDestination;
	}
	
	public long getLatency ()
	{
		return this.latency;
	}
	
	public boolean equalsTo (ConnectionLatencyReport clr)
	{
		return ((this.latency == clr.getLatency()) &&
				(this.partitionDestination.getName() == clr.getPartitionDestination().getName()) &&
				(this.partitionSource.getName() == clr.getPartitionSource().getName()));
	}
	
}
