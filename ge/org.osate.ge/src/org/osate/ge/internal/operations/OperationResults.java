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
package org.osate.ge.internal.operations;

import java.util.Objects;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.RelativeBusinessObjectReference;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;

/**
 * Simple mutable class that stores the result of an {@link org.osate.ge.operations.Operation}.
 * Built by combining individual step results. The RelativeBusinessObjectReference is stored because, if the business object is an EMF object,
 * the business object itself may be converted to a proxy before the results are processed.
 *
 */
public class OperationResults {
	public static class BusinessObjectToShowDetails {
		public BusinessObjectToShowDetails(final Object bo, final RelativeBusinessObjectReference ref) {
			this.bo = Objects.requireNonNull(bo, "bo must not be null");
			this.ref = Objects.requireNonNull(ref, "ref must not be null");
		}
		public final Object bo;
		public final RelativeBusinessObjectReference ref;
	}

	private final Multimap<BusinessObjectContext, BusinessObjectToShowDetails> containerToBoToShowDetails = HashMultimap.create();

	public Multimap<BusinessObjectContext, BusinessObjectToShowDetails> getContainerToBoToShowDetailsMap() {
		return containerToBoToShowDetails;
	}
}
