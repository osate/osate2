/**
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
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
package org.osate.ge.aadl2;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.internal.Styles;
import org.osate.ge.aadl2.internal.util.AadlInheritanceUtil;
import org.osate.ge.graphics.Style;

/**
 * Utility class containing miscellaneous members useful for implementing graphical editor extensions.
 * @noextend
 * @since 2.0
 */
public final class GraphicalExtensionUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private GraphicalExtensionUtil() {
	}

	/**
	 * The default style for inherited diagram elements.
	 * An element is considered inherited if it was not defined by its graphical parent.
	 * For example a feature inside of a subcomponent is considered inherited. An element from an extended classifier which has not been refined
	 * is another example of an inherited element.
	 */
	public static final Style STYLE_INHERITED_ELEMENT = Styles.INHERITED_ELEMENT;

	/**
	 * Returns true if the business object context's business object is owned by an element other than the owner of the business object of the parent
	 * context. For example: a feature business object context is inherited when the parent business object context's business object is not the classifier
	 * in which it is declared such as a subcomponent or component implementation.
	 * @param boc the business object context to check
	 * @return true if the business object context's business object is owned by a business object other than the business object of the
	 * business object context's parent.
	 */
	public static boolean isInherited(final BusinessObjectContext boc) {
		return AadlInheritanceUtil.isInherited(boc);
	}
}
