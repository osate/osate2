package org.osate.aadl2.errormodel.analysis.cma;

import java.util.ArrayList;
import java.util.List;

import org.osate.aadl2.errormodel.analysis.cma.CMAReportEntry.EntryType;
import org.osate.aadl2.modelsupport.WriteToFile;

public class CMAReport {
	private List<CMAReportEntry> entries;

	public CMAReport() {
		entries = new ArrayList<CMAReportEntry>();
	}

	public CMAReport(List<CMAReportEntry> e) {
		entries = e;
	}

	public void addEntry(CMAReportEntry entry) {
		for (CMAReportEntry currentEntry : entries) {
			if (currentEntry.equalsTo(entry)) {
				return;
			}
		}
		entries.add(entry);
	}

	public void addEntries(List<CMAReportEntry> newEntries) {
		for (CMAReportEntry newEntry : newEntries) {
			addEntry(newEntry);
		}
	}

	public List<CMAReportEntry> getEntries() {
		return entries;
	}

	public List<CMAReportEntry> getEntriesPerType(EntryType et) {
		List<CMAReportEntry> ret = new ArrayList<CMAReportEntry>();
		for (CMAReportEntry re : entries) {
			if (re.getType() == et) {
				ret.add(re);
			}
		}
		return ret;
	}

	public void write(WriteToFile file) {
		List<CMAReportEntry> ents;

		file.addOutputNewline("Source , Severity, Common Mode Type, Cause, Components , Justification");

		ents = getEntries();

		for (CMAReportEntry ent : ents) {
			file.addOutputNewline(ent.getSource() + "," + ent.getSeverity() + "," + ent.getTypeString() + ","
					+ ent.getMode() + "," + ent.getComponentsString() + "," + ent.getJustification());
		}
		file.addOutputNewline(" ");

	}
}
