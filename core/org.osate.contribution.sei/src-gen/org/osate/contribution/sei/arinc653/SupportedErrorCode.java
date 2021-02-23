package org.osate.contribution.sei.arinc653;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

/**
 * @since 1.2
 */
public enum SupportedErrorCode implements GeneratedEnumeration {
	MODULE_CONFIG("Module_Config", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.0"),
	MODULE_INIT("Module_Init", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.1"),
	MODULE_SCHEDULING("Module_Scheduling", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.2"),
	PARTITION_SCHEDULING("Partition_Scheduling", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.3"),
	PARTITION_CONFIG("Partition_Config", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.4"),
	PARTITION_HANDLER("Partition_Handler", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.5"),
	PARTITION_INIT("Partition_Init", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.6"),
	DEADLINE_MISS("Deadline_Miss", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.7"),
	APPLICATION_ERROR("Application_Error", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.8"),
	NUMERIC_ERROR("Numeric_Error", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.9"),
	ILLEGAL_REQUEST("Illegal_Request", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.10"),
	STACK_OVERFLOW("Stack_Overflow", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.11"),
	MEMORY_VIOLATION("Memory_Violation", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.12"),
	HARDWARE_FAULT("Hardware_Fault", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.13"),
	POWER_FAIL("Power_Fail", "platform:/plugin/org.osate.contribution.sei/resources/properties/ARINC653.aadl#/0/@ownedPropertyType.0/@ownedLiteral.14");

	private final String originalName;
	private final URI uri;

	private SupportedErrorCode(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}

	public static SupportedErrorCode valueOf(PropertyExpression propertyExpression) {
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
