package org.osate.pluginsupport.properties;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.RecordValue;

/**
 * @since 5.0
 */
public abstract class GeneratedRecord {
	public abstract RecordValue toPropertyExpression(ResourceSet resourceSet);
	
	protected Optional<BasicPropertyAssociation> findFieldValue(RecordValue recordValue, String fieldName) {
		return recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> Objects.equals(field.getProperty().getName(), fieldName))
				.findAny();
	}
	
	protected BasicProperty loadField(ResourceSet resourceSet, URI uri, String fieldName) {
		BasicProperty basicProperty = (BasicProperty) resourceSet.getEObject(uri, true);
		if (basicProperty == null) {
			throw new RuntimeException("Could not resolve BasicProperty '" + fieldName + "'.");
		}
		String foundName = basicProperty.getName();
		if (!Objects.equals(foundName, fieldName)) {
			throw new RuntimeException("Expected BasicProperty '" + fieldName + "', but found '" + foundName + "'.");
		}
		return basicProperty;
	}
}