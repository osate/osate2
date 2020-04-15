package security_type_specifications;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.StringLiteral;

public class SubjectAuthenticationType {
	private final Optional<String> description;
	private final Optional<AuthenticationAccessType_FieldType> authenticationAccessType;
	private final Optional<List<TwoAndMultiLayeredFactors_FieldType>> twoAndMultiLayeredFactors;
	private final Optional<AuthenticationProtocol_FieldType> authenticationProtocol;
	private final Optional<AuthenticationRole_FieldType> authenticationRole;
	
	public SubjectAuthenticationType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.description = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("description"))
				.map(field -> ((StringLiteral) field.getOwnedValue()).getValue())
				.findAny();
		this.authenticationAccessType = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authentication_access_type"))
				.map(field -> AuthenticationAccessType_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.twoAndMultiLayeredFactors = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("two_and_multi_layered_factors"))
				.map(field -> {
					return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
						return TwoAndMultiLayeredFactors_FieldType.valueOf(element1);
					}).collect(Collectors.toList());
				})
				.findAny();
		this.authenticationProtocol = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authentication_protocol"))
				.map(field -> AuthenticationProtocol_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.authenticationRole = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authentication_role"))
				.map(field -> AuthenticationRole_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
	}
	
	public Optional<String> getDescription() {
		return description;
	}
	
	public Optional<AuthenticationAccessType_FieldType> getAuthenticationAccessType() {
		return authenticationAccessType;
	}
	
	public Optional<List<TwoAndMultiLayeredFactors_FieldType>> getTwoAndMultiLayeredFactors() {
		return twoAndMultiLayeredFactors;
	}
	
	public Optional<AuthenticationProtocol_FieldType> getAuthenticationProtocol() {
		return authenticationProtocol;
	}
	
	public Optional<AuthenticationRole_FieldType> getAuthenticationRole() {
		return authenticationRole;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				description,
				authenticationAccessType,
				twoAndMultiLayeredFactors,
				authenticationProtocol,
				authenticationRole
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SubjectAuthenticationType)) {
			return false;
		}
		SubjectAuthenticationType other = (SubjectAuthenticationType) obj;
		return Objects.equals(this.description, other.description)
				&& Objects.equals(this.authenticationAccessType, other.authenticationAccessType)
				&& Objects.equals(this.twoAndMultiLayeredFactors, other.twoAndMultiLayeredFactors)
				&& Objects.equals(this.authenticationProtocol, other.authenticationProtocol)
				&& Objects.equals(this.authenticationRole, other.authenticationRole);
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
		this.authenticationAccessType.ifPresent(field -> {
			builder.append("authentication_access_type => ");
			builder.append(field);
			builder.append(';');
		});
		this.twoAndMultiLayeredFactors.ifPresent(field -> {
			builder.append("two_and_multi_layered_factors => ");
			builder.append(field.stream().map(Object::toString).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.authenticationProtocol.ifPresent(field -> {
			builder.append("authentication_protocol => ");
			builder.append(field);
			builder.append(';');
		});
		this.authenticationRole.ifPresent(field -> {
			builder.append("authentication_role => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AuthenticationAccessType_FieldType {
		NO_AUTHENTICATION("no_authentication"),
		SINGLE_PASSWORD("single_password"),
		SMART_CARD("smart_card"),
		IP_ADDR("ip_addr"),
		TWO_FACTOR("two_factor"),
		MULTI_LAYERED("multi_layered"),
		BIO_METRIC("bio_metric");
		
		private final String originalName;
		
		private AuthenticationAccessType_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static AuthenticationAccessType_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum TwoAndMultiLayeredFactors_FieldType {
		NO_MULTIFACTOR("no_multifactor"),
		SMART_CARD("smart_card"),
		TOKEN("token"),
		PIV("PIV"),
		OTP("OTP"),
		BIOMETRIC("biometric"),
		MULTI_LAYERED("multi_layered");
		
		private final String originalName;
		
		private TwoAndMultiLayeredFactors_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static TwoAndMultiLayeredFactors_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum AuthenticationProtocol_FieldType {
		NO_AUTHENTICATION("no_authentication"),
		CERT_SERVICES("cert_services"),
		EAP("EAP"),
		PAP("PAP"),
		SPAP("SPAP"),
		CHAP("CHAP"),
		MS_CHAP("MS_CHAP"),
		RADIUS("Radius"),
		IAS("IAS"),
		KERBEROS("Kerberos"),
		SSL("SSL"),
		TLS("TLS"),
		NTLM("NTLM");
		
		private final String originalName;
		
		private AuthenticationProtocol_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static AuthenticationProtocol_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum AuthenticationRole_FieldType {
		NO_AUTHENTICATION("no_authentication"),
		AUTHENTICATOR("authenticator"),
		ACCESSOR("accessor"),
		PROVIDER("provider"),
		REQUIRER("requirer"),
		MUTUAL("mutual");
		
		private final String originalName;
		
		private AuthenticationRole_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static AuthenticationRole_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
