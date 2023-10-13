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

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.osate.aadl2.AbstractNamedValue;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.EnumerationLiteral;
import org.osate.aadl2.ListValue;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RecordValue;

import aadl_project.Size;

public class DataAuthenticationType {
	private final Optional<AuthenticationAlgorithm_FieldType> authenticationAlgorithm;
	private final Optional<List<Classifier>> authenticationKeyType;
	private final Optional<HashAlgorithm_FieldType> hashAlgorithm;
	private final Optional<Size> hashLength;
	
	public DataAuthenticationType(PropertyExpression propertyExpression) {
		RecordValue recordValue = (RecordValue) propertyExpression;
		this.authenticationAlgorithm = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authentication_algorithm"))
				.map(field -> AuthenticationAlgorithm_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.authenticationKeyType = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("authentication_key_type"))
				.map(field -> {
					return ((ListValue) field.getOwnedValue()).getOwnedListElements().stream().map(element1 -> {
						return ((ClassifierValue) element1).getClassifier();
					}).collect(Collectors.toList());
				})
				.findAny();
		this.hashAlgorithm = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("hash_algorithm"))
				.map(field -> HashAlgorithm_FieldType.valueOf(field.getOwnedValue()))
				.findAny();
		this.hashLength = recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> field.getProperty().getName().equals("hash_length"))
				.map(field -> new Size(field.getOwnedValue()))
				.findAny();
	}
	
	public Optional<AuthenticationAlgorithm_FieldType> getAuthenticationAlgorithm() {
		return authenticationAlgorithm;
	}
	
	public Optional<List<Classifier>> getAuthenticationKeyType() {
		return authenticationKeyType;
	}
	
	public Optional<HashAlgorithm_FieldType> getHashAlgorithm() {
		return hashAlgorithm;
	}
	
	public Optional<Size> getHashLength() {
		return hashLength;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(
				authenticationAlgorithm,
				authenticationKeyType,
				hashAlgorithm,
				hashLength
		);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DataAuthenticationType)) {
			return false;
		}
		DataAuthenticationType other = (DataAuthenticationType) obj;
		return Objects.equals(this.authenticationAlgorithm, other.authenticationAlgorithm)
				&& Objects.equals(this.authenticationKeyType, other.authenticationKeyType)
				&& Objects.equals(this.hashAlgorithm, other.hashAlgorithm)
				&& Objects.equals(this.hashLength, other.hashLength);
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		this.authenticationAlgorithm.ifPresent(field -> {
			builder.append("authentication_algorithm => ");
			builder.append(field);
			builder.append(';');
		});
		this.authenticationKeyType.ifPresent(field -> {
			builder.append("authentication_key_type => ");
			builder.append(field.stream().map(element1 -> {
				return "classifier (" + element1.getQualifiedName() + ")";
			}).collect(Collectors.joining(", ", "(", ")")));
			builder.append(';');
		});
		this.hashAlgorithm.ifPresent(field -> {
			builder.append("hash_algorithm => ");
			builder.append(field);
			builder.append(';');
		});
		this.hashLength.ifPresent(field -> {
			builder.append("hash_length => ");
			builder.append(field);
			builder.append(';');
		});
		builder.append(']');
		return builder.toString();
	}
	
	public enum AuthenticationAlgorithm_FieldType {
		RSA("RSA"),
		ELGAMAL("ElGamal"),
		DSA("DSA"),
		ECC("ECC"),
		ECDSA("ECDSA"),
		CBC_MAC("CBC_MAC"),
		GCM("GCM"),
		HMAC("HMAC"),
		CMAC("CMAC"),
		OMAC("OMAC"),
		UMAC("UMAC"),
		POLY1305_AES("Poly1305_AES");
		
		private final String originalName;
		
		private AuthenticationAlgorithm_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static AuthenticationAlgorithm_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
	
	public enum HashAlgorithm_FieldType {
		MD5("MD5"),
		SHA1("SHA1"),
		SHA2("SHA2"),
		SHA3("SHA3"),
		RIPEMD("RIPEMD"),
		WHIRLPOOL("Whirlpool"),
		CHACHA20("ChaCha20"),
		BLAKE("BLAKE");
		
		private final String originalName;
		
		private HashAlgorithm_FieldType(String originalName) {
			this.originalName = originalName;
		}
		
		public static HashAlgorithm_FieldType valueOf(PropertyExpression propertyExpression) {
			AbstractNamedValue abstractNamedValue = ((NamedValue) propertyExpression).getNamedValue();
			return valueOf(((EnumerationLiteral) abstractNamedValue).getName().toUpperCase());
		}
		
		@Override
		public String toString() {
			return originalName;
		}
	}
}
