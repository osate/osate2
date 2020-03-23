/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.internal.aadlproperties;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.InstanceObject;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

/**
 * Implementation of ProcessedPropertyAssociation for use with instance property associations which are relevant to the diagram but
 * are owned by a business object which is not represented in the diagram.
 *
 */
class InstanceProcessedPropertyAssociation implements ProcessedPropertyAssociation {
	private final PropertyAssociation propertyAssociation;
	private final Iterable<InstanceObject> pathToPropertyAssociationContainer;
	private final int propertyAssociationOwnerAncestorLevel;

	public InstanceProcessedPropertyAssociation(final PropertyAssociation propertyAssociation,
			final Iterable<InstanceObject> pathToPropertyAssociationContainer) {
		this.propertyAssociation = Objects.requireNonNull(propertyAssociation,
				"propertyAssociation must not be null");
		this.pathToPropertyAssociationContainer = Objects.requireNonNull(pathToPropertyAssociationContainer,
				"pathToPropertyAssociationContainer must not be null");
		this.propertyAssociationOwnerAncestorLevel = -Iterables.size(pathToPropertyAssociationContainer);
	}

	@Override
	public PropertyAssociation getPropertyAssociation() {
		return propertyAssociation;
	}

	@Override
	public int getPropertyAssociationOwnerAncestorLevel() {
		return propertyAssociationOwnerAncestorLevel;
	}

	@Override
	public boolean isCompletelyProcessed() {
		return false;
	}

	@Override
	public String getUnprocessedPathDescription() {
		return StreamSupport.stream(pathToPropertyAssociationContainer.spliterator(), false).map(io -> Strings.nullToEmpty(io.getFullName()))
				.collect(Collectors.joining(".")).toLowerCase();
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