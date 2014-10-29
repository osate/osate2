package org.osate.aadl2.errormodel.analysis.cma;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.errormodel.analysis.cma.CMAReportEntry.EntryType;
import org.osate.aadl2.modelsupport.WriteToFile;

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
		for (CMAReportEntry currentEntry : this.entries)
		{
			if (currentEntry.equalsTo(entry))
			{
				return;
			}
		}
		this.entries.add (entry);
	}
	
	public void addEntries (List<CMAReportEntry> newEntries)
	{
		for (CMAReportEntry newEntry : newEntries)
		{
			this.addEntry(newEntry);
		}
	}
	
	public List<CMAReportEntry> getEntries()
	{
		return this.entries;
	}
	
	
	
	public List<CMAReportEntry> getEntriesPerType (EntryType et)
	{
		List<CMAReportEntry> ret = new ArrayList<CMAReportEntry>();
		for (CMAReportEntry re : this.entries)
		{
			if (re.getType() == et)
			{
				ret.add(re);
			}
		}
		return ret;
	}
	
	public void write (WriteToFile file)
	{
		List<CMAReportEntry> ents;
		
		
		ents = getEntriesPerType(EntryType.SPECIFICATION);
		if (ents.size() > 0)
		{
			file.addOutputNewline("Specification");
			file.addOutputNewline("Common Mode Source , Common Mode Error , Justification");
			for (CMAReportEntry ent : ents)
			{
				file.addOutputNewline(ent.getSource() + "," + ent.getMode() + "," + ent.getJustification());
			}
			file.addOutputNewline(" ");
		}
		
		ents = getEntriesPerType(EntryType.ARCHITECTURE_DESIGN);
		if (ents.size() > 0)
		{
			file.addOutputNewline("Design Architecture");
			file.addOutputNewline("Common Mode Source , Common Mode Error , Justification");
			for (CMAReportEntry ent : ents)
			{
				file.addOutputNewline(ent.getSource() + "," + ent.getMode() + "," + ent.getJustification());
			}
			file.addOutputNewline(" ");
		}
		
		ents = getEntriesPerType(EntryType.NONE);
		if (ents.size() > 0)
		{
			file.addOutputNewline("Others");
			file.addOutputNewline("Common Mode Source , Common Mode Error , Justification");
			for (CMAReportEntry ent : ents)
			{
				file.addOutputNewline(ent.getSource() + "," + ent.getMode() + "," + ent.getJustification());
			}
			file.addOutputNewline(" ");
		}
	}
}
