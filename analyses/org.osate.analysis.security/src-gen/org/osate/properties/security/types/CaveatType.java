package org.osate.properties.security.types;

import org.eclipse.emf.common.util.URI;
import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.pluginsupport.properties.GeneratedEnumeration;

public enum CaveatType implements GeneratedEnumeration {
	FOUO("FOUO", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.0"),
	NOFORN("NOFORN", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.1"),
	IMCON("IMCON", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.2"),
	RELIDO("RELIDO", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.3"),
	CUI("CUI", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.4"),
	PROPIN("PROPIN", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.5"),
	ORCON("ORCON", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.6"),
	REL_TO("REL_TO", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.7"),
	DISPLAY_ONLY("Display_Only", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.8"),
	FISA("FISA", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.9"),
	EXIDS("EXIDS", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.10"),
	NODIS("NODIS", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.11"),
	SBU("SBU", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.12"),
	SBU_NF("SBU_NF", "platform:/resource/SecurityPropertiesUpdate/Property_Files/Security_Type_Specifications.aadl#/0/@ownedPropertyType.1/@ownedLiteral.13");
	
	private final String originalName;
	private final URI uri;
	
	private CaveatType(String originalName, String uri) {
		this.originalName = originalName;
		this.uri = URI.createURI(uri);
	}
	
	public static CaveatType valueOf(PropertyExpression propertyExpression) {
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
