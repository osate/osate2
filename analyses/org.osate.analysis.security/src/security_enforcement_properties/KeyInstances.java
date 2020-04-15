package security_enforcement_properties;

import java.util.Objects;
import java.util.Optional;

import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstanceReferenceValue;

public class KeyInstances {
	private final Optional<InstanceObject> privateKey;
	private final Optional<InstanceObject> publicKey;
	private final Optional<InstanceObject> singleKey;
	
	public KeyInstances(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.privateKey = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("private_key"))
				.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
				.findAny();
		this.publicKey = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("public_key"))
				.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
				.findAny();
		this.singleKey = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("single_key"))
				.map(field -> ((InstanceReferenceValue) field.getOwnedValue()).getReferencedInstanceObject())
				.findAny();
	}
	
	public Optional<InstanceObject> getPrivateKey() {
		return privateKey;
	}
	
	public Optional<InstanceObject> getPublicKey() {
		return publicKey;
	}
	
	public Optional<InstanceObject> getSingleKey() {
		return singleKey;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				privateKey,
				publicKey,
				singleKey
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof KeyInstances)) {
			return false;
		}
		KeyInstances other = (KeyInstances) obj;
		return Objects.equals(this.privateKey, other.privateKey)
				&& Objects.equals(this.publicKey, other.publicKey)
				&& Objects.equals(this.singleKey, other.singleKey);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.privateKey.ifPresent(field -> {
			builder.append("private_key => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		this.publicKey.ifPresent(field -> {
			builder.append("public_key => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		this.singleKey.ifPresent(field -> {
			builder.append("single_key => reference (");
			builder.append(field.getName());
			builder.append(");");
		});
		builder.append(']');
		return builder.toString();
	}
}
