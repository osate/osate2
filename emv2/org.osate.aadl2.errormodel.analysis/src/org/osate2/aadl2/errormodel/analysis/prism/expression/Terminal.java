package org.osate2.aadl2.errormodel.analysis.prism.expression;

public class Terminal implements Expression
{
	private String name;
	private boolean isUpdate;
	
	public Terminal (String s)
	{
		this.name = s;
		this.isUpdate = false;
	}
	
	public Terminal (String s, boolean update)
	{
		this (s);
		this.isUpdate = update;
	}
	
	public void setUpdate (boolean b)
	{
		this.isUpdate = b;
	}
	
	public boolean getUpdate ()
	{
		return this.isUpdate;
	}
	
	public String toString ()
	{
		if (isUpdate)
		{
			return this.name +"\'";	
		}
		
		return this.name;
	}
}
