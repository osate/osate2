package security_type_specifications;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;

public class CaveatType {
	private final Optional<String> description;
	private final Optional<Caveat_FieldType> caveat;
	
	public CaveatType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.description = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("description"))
				.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
				.findAny();
		this.caveat = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("caveat"))
				.map(field -> Caveat_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<Caveat_FieldType> getCaveat() {
		return caveat;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				description,
				caveat
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CaveatType)) {
			return false;
		}
		CaveatType other = (CaveatType) obj;
		return Objects.equals(this.description, other.description)
				&& Objects.equals(this.caveat, other.caveat);
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
		this.caveat.ifPresent(field -> {
			builder.append("caveat => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum Caveat_FieldType {
		FOUO("FOUO"),
		NOFORN("NOFORN"),
		NOCONTRACTOR("NOCONTRACTOR"),
		PROPIN("PROPIN"),
		IMCON("IMCON"),
		ORCON("ORCON"),
		NORELEASE("NORELEASE"),
		RELIDO("RELIDO"),
		REL_TO_PUBLIC("REL_TO_PUBLIC"),
		REL_TO_CONTRACTOR("REL_TO_CONTRACTOR");
		
		private final String originalName;
		
		private Caveat_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static Caveat_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
