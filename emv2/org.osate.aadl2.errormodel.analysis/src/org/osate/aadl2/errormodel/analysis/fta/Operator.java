package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.List;

abstract public class Operator extends FTAElement {

	private List<FTAElement> operands;
	
	public Operator ()
	{
		this.operands = new ArrayList<FTAElement>();
	}
	
	public void addOperand (FTAElement e)
	{
		for (FTAElement el : this.operands)
		{
			if ((e instanceof Event) && (el instanceof Event))
			{
				if (((Event)e).getName() == ((Event)el).getName())
				{
					return;
				}
			}
		}
		this.operands.add(e);
	}
	
	public List<FTAElement> getOperands ()
	{
		return this.operands;
	}
	
	
	public abstract String getOperatorString ();
	
	public String toXML()
	{
		StringBuffer sb2 = new StringBuffer ();
		sb2.append("<");
		sb2.append(this.getOperatorString());
		sb2.append(">\n");
		for (FTAElement e : this.operands)
		{
			sb2.append(e.toXML());
			sb2.append("\n");
		}
		sb2.append("</");
		sb2.append(this.getOperatorString());
		sb2.append(">");
		sb2.append("\n");
		return sb2.toString();
	}
}
