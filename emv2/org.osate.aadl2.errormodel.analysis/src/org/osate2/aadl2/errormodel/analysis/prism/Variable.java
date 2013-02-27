package org.osate2.aadl2.errormodel.analysis.prism;

public class Variable {
	private String name;
	private int nValues;
	private int initialValue;
	
	public Variable (String n, int nv)
	{
		this.name = n;
		this.nValues = nv;
	}
	
	public String getPRISMCode ()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append (this.name);
		sb.append (" : ");
		sb.append (" [ 0 .. " + this.nValues + "] init 0;");
		return sb.toString();
	}
	
	
}
