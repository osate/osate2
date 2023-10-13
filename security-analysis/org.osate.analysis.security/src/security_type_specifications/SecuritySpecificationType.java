/*******************************************************************************
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 *
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 *
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 *
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party beneficiaries
 * to this license with respect to the terms applicable to their Third Party Software. Third Party Software licenses
 * only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 *******************************************************************************/
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
