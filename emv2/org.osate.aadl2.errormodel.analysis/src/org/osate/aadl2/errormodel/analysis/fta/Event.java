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
	private String		identifier;
	
	
	public Event ()
	{
		this.identifier 		= "event" + generalId;
		this.name				= this.identifier;
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
	
	public void setIdentifier (String n)
	{
		this.identifier = n.replace(' ', '_');
	}
	
	public String getIdentifier ()
	{
		String suffix;
		switch (this.type)
		{
			case AND:
				{
					suffix = "_a";
					break;
				}
			case OR:
			{
				suffix = "_o";
				break;
			}
			default:
			{
				suffix = "_d";
				break;
			}
		}
		return this.identifier + suffix;

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
		StringBuffer sb;
		

		
		sb = new StringBuffer ();
		

		
		sb.append ("<event");
		if (this.type == EventType.NORMAL)
		{
			sb.append (" id=\""+this.name+"\" ");
		}
		else
		{
			sb.append (" id=\""+this.getIdentifier()+"\" ");
		}

		if (this.probability != 0.0)
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
	
	public String toPED()
	{
		double prob;
		String description;
		
		StringBuffer sb = new StringBuffer ();
		
		if (this.type == EventType.EVENT)
		{
			prob = this.getProbability();
			/**
			 * A probability of 0 makes the whole thing crash.
			 * So, we put a default prob of 0.1
			 */
			if (prob == 0)
			{
				prob = 0.1;
			}
			if (this.getDescription() != null)
			{
				description = this.getDescription();
			}
			else
			{
				description = this.name + "(no extended description)" ;
			}
			sb.append (this.identifier + ";;B;"+description+";"+prob+";L;\n");
			return sb.toString();
		}
		
		for (Event e : this.subEvents)
		{
			sb.append(e.toPED());
		}
		return sb.toString();
	}
	
	public String toFTA()
	{
		StringBuffer sb;
		

		
		sb = new StringBuffer ();
		String title = "";
		if (this.type == EventType.EVENT)
		{
//			String tmp = this.name;
//			tmp = tmp.replace(' ', '_');
//			tmp = tmp.replace('/', '-');
//			tmp = tmp.replace('(', '-');
//			tmp = tmp.replace(')', '-');
//			tmp = tmp.replace("__", "_");
//			
//			tmp = tmp.toLowerCase();
			sb.append ("B " + this.identifier + " 0\n");
			return sb.toString();
		}
		
		sb.append ("M " + this.identifier);
		
		if (this.type == EventType.NORMAL)
		{
			sb.append (" "+subEvents.size() +"\n");
		}
		else
		{
			sb.append (" 1\n");
		}
		
		title = this.name;
		
		if (this.getDescription() != null)
		{
			title = this.getDescription();
		}
		
		sb.append ("" + title.length() + " " + title + "\n");
		
		switch (this.type)
		{
			case AND:
			{
				sb.append ("A " + this.identifier + " " + this.subEvents.size()+"\n");
				break;
			}
			case OR:
			{
				sb.append ("O " + this.identifier + " " + this.subEvents.size()+"\n");
				break;
			}
			default:
			{
				break;
			}
		
		}
		for (Event e : this.subEvents)
		{
			sb.append(e.toFTA());
		}
		return sb.toString();
	}
	
	
}
