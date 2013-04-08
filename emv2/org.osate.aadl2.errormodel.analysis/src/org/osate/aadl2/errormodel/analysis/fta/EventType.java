package org.osate.aadl2.errormodel.analysis.fta;

public enum EventType
{
	AND, OR, XOR, NORMAL;
	
	
	public static String toString (EventType t)
	{
		switch (t)
		{
			case AND:
			{
				return "and";
			}
			
			case OR:
			{
				return "or";
			}
			
			case XOR:
			{
				return "xor";
			}
			default:
				return "";
		}
	}
}