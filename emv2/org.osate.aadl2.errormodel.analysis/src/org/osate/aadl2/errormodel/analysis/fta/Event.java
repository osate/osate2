package org.osate.aadl2.errormodel.analysis.fta;

public class Event extends FTAElement
{
	private String name;
	private String description;
	private double probability;
	private Operator outgoingOperator;
	private Operator incomingOperator;
	private boolean showProbability;
	
	public Event ()
	{
		this.name = "unknown event";
		this.description = "unknown description";
		this.probability = 0.0;
		this.outgoingOperator = null;
		this.incomingOperator = null;
		this.showProbability = true;
	}
	
	public String getName ()
	{
		return this.name;
	}
	
	public void showProbability (boolean b)
	{
		this.showProbability = b;
	}
	
	public String getDescription ()
	{
		return this.description;
	}
	
	public double getProbability ()
	{
		return this.probability;
	}
	
	public void setName (String n)
	{
		this.name = n;
	}
	
	public void setDescription (String d)
	{
		this.description = d;
	}
	
	public void setProbability (double p)
	{
		this.probability = p;
	}
	
	public void setIncomingOperator (Operator i)
	{
		this.incomingOperator = i;
	}
	
	public void setOutgoingOperator (Operator o)
	{
		this.outgoingOperator = o;
	}
	
	public Operator getIncomingOperator ()
	{
		return this.incomingOperator;
	}
	
	public Operator getOutgoingOperator ()
	{
		return this.outgoingOperator;
	}
	
	public String toXML()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append ("<event name=\""+this.name+"\" description=\""+this.description+"\"");
		if (this.showProbability)
		{
			sb.append (" probability=\""+this.probability+"\"");
		}
		sb.append (">");

		
		sb.append ("\n");
		if (incomingOperator != null)
		{
			sb.append(incomingOperator.toXML());
		}
		sb.append ("</event>");
		sb.append ("\n");

		return sb.toString();
	}
}
