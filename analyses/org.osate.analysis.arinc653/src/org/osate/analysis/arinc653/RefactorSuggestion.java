package org.osate.analysis.arinc653;

import org.osate.aadl2.NamedElement;

public class RefactorSuggestion 
{
	private int kind;
	private String message;
	NamedElement component;
	
	public static final int KIND_INVALID = -1;
	
	public RefactorSuggestion ()
	{
		message = null;
		component = null;
		kind = KIND_INVALID;
	}
	
	public RefactorSuggestion (String m)
	{
		this ();
		this.setMessage(m);
	}
	
	public RefactorSuggestion (NamedElement ne, String m)
	{
		this ();
		this.setAssociatedComponent(ne);
		this.setMessage(m);
	}
	
	public void setKind (int k)
	{
		this.kind = k;
	}
	
	public int getKind ()
	{
		return this.kind;
	}
	
	
	public String getMessage ()
	{
		return this.message;
	}
	
	public void setMessage (String m)
	{
		this.message = m;
	}
	
	public void setAssociatedComponent (NamedElement ne)
	{
		component = ne;
	}
	
	public NamedElement getAssociatedComponent ()
	{
		return this.component;
	}
}
