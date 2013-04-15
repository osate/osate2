package org.osate.aadl2.errormodel.analysis.fta;

import java.util.ArrayList;
import java.util.List;



public class Event
{
	private String 		name;
	private String 		description;
	private double 		probability;
	private List<Event> subEvents;
	private boolean 	showProbability;
	private EventType 	type;
	private static int 	generalId = 1;

	
	
	public Event ()
	{
		this.name 				= "event" + generalId;
		this.description 		= null;
		this.probability 		= 0.0;
		this.showProbability 	= false;
		this.type				= EventType.NORMAL;
		this.subEvents 			= new ArrayList<Event>();
		generalId++;
	}
	
	
	public EventType getEventType ()
	{
		return this.type;
	}
	
	public void setEventType (EventType et)
	{
		this.type = et;
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
		this.showProbability = true;
	}
	
	public List<Event> getSubEvents ()
	{
		return this.subEvents;
	}
	
	public void addSubEvent (Event e)
	{
		this.subEvents.add (e);
	}
	
	public String toXML()
	{
		StringBuffer sb = new StringBuffer ();
		sb.append ("<event id=\""+this.name+"\" ");
		if (this.showProbability)
		{
			sb.append (" probability=\""+this.probability+"\"");
		}
		if (this.type != EventType.NORMAL)
		{
			sb.append (" type=\""+EventType.toString(this.type)+"\"");
		}
		if (this.description != null)
		{
			sb.append (" description="+this.description);
		}
		sb.append (">");

		
		sb.append ("\n");
		for (Event e : this.subEvents)
		{
			sb.append(e.toXML());
		}
		sb.append ("</event>");
		sb.append ("\n");

		return sb.toString();
	}
}
