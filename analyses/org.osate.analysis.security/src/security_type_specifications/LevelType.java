package security_type_specifications;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;

public class LevelType {
	private final Optional<String> description;
	private final Optional<Level_FieldType> level;
	
	public LevelType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.description = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("description"))
				.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
				.findAny();
		this.level = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("level"))
				.map(field -> Level_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<Level_FieldType> getLevel() {
		return level;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				description,
				level
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof LevelType)) {
			return false;
		}
		LevelType other = (LevelType) obj;
		return Objects.equals(this.description, other.description)
				&& Objects.equals(this.level, other.level);
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
		this.level.ifPresent(field -> {
			builder.append("level => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum Level_FieldType {
		TOPSECRET("TopSecret"),
		SECRET("Secret"),
		CONFIDENTIAL("Confidential"),
		UNCLASSIFIED("Unclassified");
		
		private final String originalName;
		
		private Level_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static Level_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
