package org.osate.aadl2.errormodel.analysis.cma;

public class CMAReportEntry {
	private String source;
	private String mode;
	private String justification;
	private EntryType type;
	
	public enum EntryType {NONE, SPECIFICATION, ARCHITECTURE_DESIGN,INSTALLATION,OPERATION,ENVIRONMENTAL_FACTOR};
	
	public CMAReportEntry ()
	{
		source        = null;
		mode          = null;
		justification = null;
		type          = EntryType.NONE;
	}
	
	public void setSource (String s)
	{
		this.source = s;
	}
	
	public void setMode (String m)
	{
		this.mode = m;
	}
	
	public void setJustification (String j)
	{
		this.justification = j;
	}
	
	public String getJustification ()
	{
		return this.justification;
	}
	
	public String getMode ()
	{
		return this.mode;
	}
	
	public String getSource ()
	{
		return this.source;
	}
	
	public void setType (EntryType t)
	{
		this.type = t;
	}
	
	public EntryType getType ()
	{
		return this.type;
	}
	
	public boolean equalsTo (Object o)
	{
		if (o instanceof CMAReportEntry)
		{
			CMAReportEntry other = (CMAReportEntry) o;
			return (this.justification.equalsIgnoreCase(other.getJustification()) &&
					this.mode.equalsIgnoreCase(other.getMode()) &&
					this.source.equalsIgnoreCase(other.getSource())
					);
		}
		
		return false;
		
	}
}
