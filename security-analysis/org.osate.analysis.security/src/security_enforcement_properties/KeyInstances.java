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
