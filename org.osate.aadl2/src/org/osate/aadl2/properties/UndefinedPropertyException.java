package org.osate.aadl2.properties;

public class UndefinedPropertyException extends PropertyLookupException {

	private static final long serialVersionUID = 6326839674605036753L;

	public UndefinedPropertyException(final String p_msg) {
		super(p_msg);
	}
}
