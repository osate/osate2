package org.osate.analysis.security;

import java.util.Optional;

import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;

public class Util {

	public static Optional<PropertyExpression> getFieldValue(RecordValue rv, String fieldName) {
		return rv.getOwnedFieldValues()
				.stream()
				.filter((field) -> field.getProperty().getName().equalsIgnoreCase(fieldName))
				.findFirst()
				.map(BasicPropertyAssociation::getValue);
	}

}
