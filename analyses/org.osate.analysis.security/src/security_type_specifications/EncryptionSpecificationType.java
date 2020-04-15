package security_type_specifications;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;

public class EncryptionSpecificationType {
	private final Optional<AlgorithmName_FieldType> algorithmName;
	private final Optional<EncryptionMode_FieldType> encryptionMode;
	private final Optional<Padding_FieldType> padding;
	private final Optional<Classifier> keyClassifier;
	
	public EncryptionSpecificationType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.algorithmName = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("algorithm_name"))
				.map(field -> AlgorithmName_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.encryptionMode = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("encryption_mode"))
				.map(field -> EncryptionMode_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.padding = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("padding"))
				.map(field -> Padding_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.keyClassifier = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("key_classifier"))
				.map(field -> ((ClassifierValue) field.getOwnedValue()).getClassifier())
				.findAny();
	}
	
	public Optional<AlgorithmName_FieldType> getAlgorithmName() {
		return algorithmName;
	}
	
	public Optional<EncryptionMode_FieldType> getEncryptionMode() {
		return encryptionMode;
	}
	
	public Optional<Padding_FieldType> getPadding() {
		return padding;
	}
	
	public Optional<Classifier> getKeyClassifier() {
		return keyClassifier;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				algorithmName,
				encryptionMode,
				padding,
				keyClassifier
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof EncryptionSpecificationType)) {
			return false;
		}
		EncryptionSpecificationType other = (EncryptionSpecificationType) obj;
		return Objects.equals(this.algorithmName, other.algorithmName)
				&& Objects.equals(this.encryptionMode, other.encryptionMode)
				&& Objects.equals(this.padding, other.padding)
				&& Objects.equals(this.keyClassifier, other.keyClassifier);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.algorithmName.ifPresent(field -> {
			builder.append("algorithm_name => ");
			builder.append(field);
			builder.append(';');
		});
		this.encryptionMode.ifPresent(field -> {
			builder.append("encryption_mode => ");
			builder.append(field);
			builder.append(';');
		});
		this.padding.ifPresent(field -> {
			builder.append("padding => ");
			builder.append(field);
			builder.append(';');
		});
		this.keyClassifier.ifPresent(field -> {
			builder.append("key_classifier => classifier (");
			builder.append(field.getQualifiedName());
			builder.append(");");
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AlgorithmName_FieldType {
		OTP("OTP"),
		DES("DES"),
		TRIPLEDES("TripleDES"),
		AES("AES"),
		BLOWFISH("Blowfish"),
		TWOFISH("TwoFish"),
		RSA("RSA"),
		ECC("ECC");
		
		private final String originalName;
		
		private AlgorithmName_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static AlgorithmName_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum EncryptionMode_FieldType {
		ECB("ECB"),
		CBC("CBC"),
		CFB("CFB"),
		CTR("CTR"),
		GCM("GCM");
		
		private final String originalName;
		
		private EncryptionMode_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static EncryptionMode_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum Padding_FieldType {
		NO_PADDING("no_padding"),
		BLOCK_CIPHER("block_cipher"),
		OAEP("OAEP");
		
		private final String originalName;
		
		private Padding_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static Padding_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
