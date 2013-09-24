package org.osate.xtext.aadl2.ui.propertyview.associationwizard;

import java.util.Iterator;

import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator.InvalidConcreteSyntaxException;
import org.osate.aadl2.AadlReal;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.ListType;
import org.osate.aadl2.PropertyType;
import org.osate.aadl2.RangeType;
import org.osate.aadl2.RecordType;

public class AssociationWizardUtil {
	private AssociationWizardUtil() {
	}
	
	public static String unparse(ISerializer serializer, PropertyType propertyType) {
		try {
			return serializer.serialize(propertyType).trim();
		}
		catch (InvalidConcreteSyntaxException e) {
			return manuallyUnparse(serializer, propertyType);
		}
	}
	
	private static String manuallyUnparse(ISerializer serializer, PropertyType propertyType) {
		if (propertyType instanceof ListType)
			return "list of " + manuallyUnparse(serializer, ((ListType)propertyType).getElementType());
		else if (propertyType instanceof RangeType)
			return "range of " + manuallyUnparse(serializer, ((RangeType)propertyType).getNumberType());
		else if (propertyType instanceof RecordType) {
			StringBuilder result = new StringBuilder("record (");
			for (Iterator<BasicProperty> iter = ((RecordType)propertyType).getOwnedFields().iterator(); iter.hasNext();) {
				BasicProperty recordField = iter.next();
				result.append(recordField.getName());
				result.append(": ");
				result.append(manuallyUnparse(serializer, recordField.getPropertyType()));
				result.append(';');
				if (iter.hasNext())
					result.append(' ');
			}
			result.append(')');
			return result.toString();
		}
		else if (propertyType instanceof AadlReal)
		{
			AadlReal aadlReal = (AadlReal)propertyType;
			if (aadlReal.getOwnedUnitsType() == null)
				return serializer.serialize(propertyType).trim();
			else
			{
				if (aadlReal.getRange() == null)
					return "aadlreal" + serializer.serialize(aadlReal.getOwnedUnitsType());
				else
					return "aadlreal" + serializer.serialize(aadlReal.getRange()) + serializer.serialize(aadlReal.getOwnedUnitsType());
			}
		}
		else
			return serializer.serialize(propertyType).trim();
	}
}