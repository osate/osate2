package org.osate.codegen.checker.report;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;

public class ErrorReport {
	private NamedElement component;
	private String message;
	
	public ErrorReport (NamedElement c, String m)
	{
		this.component = c;
		this.message = m;
	}
	
	public NamedElement getComponent() {
		return component;
	}
	public void setComponent(ComponentInstance component) {
		this.component = component;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
