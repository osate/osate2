/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.aadl2.internal.aadlproperties;

import java.util.Objects;

import org.osate.aadl2.PropertyAssociation;

/**
 * ProcessedPropertyAssociation implementation for property associations which do not include applies to clauses.
 */
class LocalProcessedPropertyAssociation implements ProcessedPropertyAssociation {
	private final PropertyAssociation propertyAssociation;

	public LocalProcessedPropertyAssociation(final PropertyAssociation propertyAssociation) {
		this.propertyAssociation = Objects.requireNonNull(propertyAssociation,
				"propertyAssociation must not be null");
	}

	@Override
	public PropertyAssociation getPropertyAssociation() {
		return propertyAssociation;
	}

	@Override
	public int getPropertyAssociationOwnerAncestorLevel() {
		return 0;
	}

	@Override
	public boolean isCompletelyProcessed() {
		return true;
	}

	@Override
	public String getUnprocessedPathDescription() {
		return "";
	}

	@Override
	public boolean hasArrayIndices() {
		return false;
	}

	@Override
	public boolean isBindingSpecific() {
		return false;
	}

	@Override
	public boolean isModal() {
		return false;
	}
}