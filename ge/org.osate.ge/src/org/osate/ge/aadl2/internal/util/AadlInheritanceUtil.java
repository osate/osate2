/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.aadl2.internal.util;

import java.util.Optional;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.GraphicalExtensionUtil;

/**
 * Class containing utility functions related to model elements which may be owned by a business object other than the business object of the
 * graphical parent.
 *
 */
public final class AadlInheritanceUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private AadlInheritanceUtil() {
	}

	/**
	 * @see {@link GraphicalExtensionUtil#isInherited(BusinessObjectContext)}
	 */
	public static boolean isInherited(final BusinessObjectContext boc) {
		if (boc.getParent() != null && boc.getBusinessObject() instanceof Element) {
			final Element e = ((Element) boc.getBusinessObject());
			final Classifier c = e.getContainingClassifier();
			final NamedElement ne = getClassifierOrSubcomponent(boc.getParent()).orElse(null);
			if (c != null && ne != null && c != ne) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Walks up the business object context tree and returns the first business object which is a classifier or subcomponent
	 * @param boc the first business object context to check
	 * @return the classifier or subcomponent
	 */
	private static Optional<NamedElement> getClassifierOrSubcomponent(BusinessObjectContext boc) {
		while (boc != null) {
			final Object bo = boc.getBusinessObject();
			if (bo instanceof Classifier || bo instanceof Subcomponent) {
				return boc.getBusinessObject(NamedElement.class);
			}
			boc = boc.getParent();
		}

		return Optional.empty();
	}
}
