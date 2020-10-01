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
package org.osate.ge.errormodel.filters;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Subcomponent;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.ge.errormodel.util.ErrorModelGeUtil;

public class ErrorModelFilterUtil {
	private ErrorModelFilterUtil() {
	}

	/**
	 * Returns true if the business object is a package with an EMV library
	 * @param bo the bo to check
	 * @return whether an EMV2 library was found
	 */
	public static boolean isPackageWithErrorModelLibrary(final Object bo) {
		if (!(bo instanceof AadlPackage)) {
			return false;
		}

		return ErrorModelGeUtil.getErrorModelLibrary((AadlPackage) bo).isPresent();
	}

	/**
	 * Returns true if the specified business object's containing classifier, extensions, or implemented types includes an EMV2 subclause.
	 * If the business object is subcomponent, the subcomponent's classifier is checked.
	 * @param bo the bo to check
	 * @return whether an EMV2 subclause was found
	 */
	public static boolean hasApplicableErrorModelSubclause(final Object bo) {
		final Classifier classifier;
		if (bo instanceof Subcomponent) {
			classifier = ((Subcomponent) bo).getAllClassifier();
		} else if (bo instanceof Element) {
			classifier = ((Element) bo).getContainingClassifier();
		} else if(bo instanceof KeywordPropagationPoint) {
			classifier = ((KeywordPropagationPoint) bo).getClassifier();
		} else {
			classifier = null;
		}

		if (classifier == null) {
			return false;
		}

		if (classifier.getSelfPlusAllExtended().stream().flatMap(ErrorModelGeUtil::getAllErrorModelSubclauses).findAny()
				.isPresent()) {
			return true;
		}

		if (classifier instanceof ComponentImplementation) {
			final ComponentType ct = ((ComponentImplementation) classifier).getType();
			if (ct != null) {
				if (ct.getSelfPlusAllExtended().stream().flatMap(ErrorModelGeUtil::getAllErrorModelSubclauses).findAny()
						.isPresent()) {
					return true;
				}
			}
		}

		return false;
	}
}
