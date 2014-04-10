package org.osate.aadl2.errormodel.analysis.cma;

import java.util.ArrayList;
import java.util.List;

public class CMAReport {
	private List<CMAReportEntry> entries;
	
	public CMAReport ()
	{
		this.entries = new ArrayList<CMAReportEntry>();
	}
	
	public CMAReport (List<CMAReportEntry> e)
	{
		this.entries = e;
	}
	
	public void addEntry (CMAReportEntry entry)
	{
		this.entries.add (entry);
	}
	
	public void addEntries (List<CMAReportEntry> e)
	{
		this.entries.addAll(e);
	}
	
	public List<CMAReportEntry> getEntries()
	{
		return this.entries;
	}
}
