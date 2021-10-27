package org.osate.aadl2.contrib.thread;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum PosixSchedulingPolicy implements GeneratedEnumeration {
	SCHED_FIFO("SCHED_FIFO", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Thread_Properties.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.0"),
	SCHED_RR("SCHED_RR", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Thread_Properties.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.1"),
	SCHED_OTHERS("SCHED_OTHERS", "platform:/plugin/org.osate.aadl2.contrib/resources/properties/Predeclared_Property_Sets/Thread_Properties.aadl#/0/@ownedProperty.3/@ownedPropertyType/@ownedLiteral.2");
	
	private final String originalName;
	private final URI uri;
	
	private PosixSchedulingPolicy(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static PosixSchedulingPolicy valueOf(PropertyExpression propertyExpression) {
		AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
		return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
	}
	
	@Override
	public URI getURI() {
		return uri;
	}
	
	@Override
	public String toString() {
		return originalName;
	}
}
