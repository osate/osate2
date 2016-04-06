package org.osate.ge.query;

public interface FilterArguments<A> {
	Object getBusinessObject();
	A getQueryArgument();
}
