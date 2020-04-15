package security_enforcement_properties;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;

import security_type_specifications.DataSecurityTypes;

public class DataSecurity {
	private final Optional<String> description;
	private final Optional<DataSecurityTypes> dataSecurityType;
	
	public DataSecurity(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.description = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("description"))
				.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
				.findAny();
		this.dataSecurityType = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("data_security_type"))
				.map(field -> DataSecurityTypes.valueOf(field.getOwnedValue()))
				.findAny();
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<DataSecurityTypes> getDataSecurityType() {
		return dataSecurityType;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				description,
				dataSecurityType
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DataSecurity)) {
			return false;
		}
		DataSecurity other = (DataSecurity) obj;
		return Objects.equals(this.description, other.description)
				&& Objects.equals(this.dataSecurityType, other.dataSecurityType);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.description.ifPresent(field -> {
			builder.append("description => \"");
			builder.append(field);
			builder.append("\";");
		});
		this.dataSecurityType.ifPresent(field -> {
			builder.append("data_security_type => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
}
