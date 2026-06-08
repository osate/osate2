/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.pluginsupport.properties;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.osate.aadl2.BasicProperty;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.RecordValue;

/**
 * @since 5.0
 */
public abstract class GeneratedRecord {
	public abstract RecordValue toPropertyExpression(ResourceSet resourceSet);
	
	protected Optional<BasicPropertyAssociation> findFieldValue(RecordValue recordValue, String fieldName) {
		return recordValue.getOwnedFieldValues()
				.stream()
				.filter(field -> Objects.equals(field.getProperty().getName(), fieldName))
				.findAny();
	}
	
	protected BasicProperty loadField(ResourceSet resourceSet, URI uri, String fieldName) {
		BasicProperty basicProperty = (BasicProperty) resourceSet.getEObject(uri, true);
		if (basicProperty == null) {
			throw new RuntimeException("Could not resolve BasicProperty '" + fieldName + "'.");
		}
		String foundName = basicProperty.getName();
		if (!Objects.equals(foundName, fieldName)) {
			throw new RuntimeException("Expected BasicProperty '" + fieldName + "', but found '" + foundName + "'.");
		}
		return basicProperty;
	}
}