package security_type_specifications;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;

public class SecuritySpecificationType {
	private final Optional<String> description;
	private final Optional<EncryptionSpecificationType> encryption;
	private final Optional<DataAuthenticationType> authentication;
	private final Optional<AuthenticatedEncryptionForm_FieldType> authenticatedEncryptionForm;
	
	public SecuritySpecificationType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.description = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("description"))
				.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
				.findAny();
		this.encryption = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("encryption"))
				.map(field -> new EncryptionSpecificationType(field.getOwnedValue()))
				.findAny();
		this.authentication = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authentication"))
				.map(field -> new DataAuthenticationType(field.getOwnedValue()))
				.findAny();
		this.authenticatedEncryptionForm = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authenticated_encryption_form"))
				.map(field -> AuthenticatedEncryptionForm_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<EncryptionSpecificationType> getEncryption() {
		return encryption;
	}
	
	public Optional<DataAuthenticationType> getAuthentication() {
		return authentication;
	}
	
	public Optional<AuthenticatedEncryptionForm_FieldType> getAuthenticatedEncryptionForm() {
		return authenticatedEncryptionForm;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				description,
				encryption,
				authentication,
				authenticatedEncryptionForm
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SecuritySpecificationType)) {
			return false;
		}
		SecuritySpecificationType other = (SecuritySpecificationType) obj;
		return Objects.equals(this.description, other.description)
				&& Objects.equals(this.encryption, other.encryption)
				&& Objects.equals(this.authentication, other.authentication)
				&& Objects.equals(this.authenticatedEncryptionForm, other.authenticatedEncryptionForm);
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
		this.encryption.ifPresent(field -> {
			builder.append("encryption => ");
			builder.append(field);
			builder.append(';');
		});
		this.authentication.ifPresent(field -> {
			builder.append("authentication => ");
			builder.append(field);
			builder.append(';');
		});
		this.authenticatedEncryptionForm.ifPresent(field -> {
			builder.append("authenticated_encryption_form => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AuthenticatedEncryptionForm_FieldType {
		GCM("GCM"),
		CBC_MAC("CBC_MAC"),
		ENCRYPT_THEN_MAC("encrypt_then_MAC"),
		MAC_THEN_ENCRYPT("MAC_then_encrypt"),
		ENCRYPT_AND_MAC("encrypt_and_MAC"),
		AEAD("AEAD"),
		SIGNCRYPTION("signcryption");
		
		private final String originalName;
		
		private AuthenticatedEncryptionForm_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static AuthenticatedEncryptionForm_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
