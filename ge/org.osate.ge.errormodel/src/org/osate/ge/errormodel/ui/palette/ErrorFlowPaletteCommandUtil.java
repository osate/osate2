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
package org.osate.ge.errormodel.ui.palette;

import java.util.Optional;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.aadl2.AadlGraphicalEditorException;
import org.osate.ge.errormodel.combined.CombinedErrorModelSubclause;
import org.osate.ge.errormodel.model.KeywordPropagationPoint;
import org.osate.ge.errormodel.model.KeywordPropagationPointType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.PropagationPoint;

/**
 * Utility functions for implementing the palette commands related to {@link ErrorFlow} elements.
 *
 */
public class ErrorFlowPaletteCommandUtil {
	private ErrorFlowPaletteCommandUtil() {}

	/**
	 * Checks the specified end business object context to determine if it is a valid endpoint for an error flow.
	 * This should only be called for business object contexts which have passed {@link #isPotentialEnd(BusinessObjectContext)}
	 * Specifically, it checks if the business object context represents an "all" propagation point or if it points to
	 * propagation point which has an appropriate propagation associated with it.
	 * @param combined the applicable combined subclause
	 * @param endBoc the business object context of the propagation point that is being checked to determine if it is a valid
	 * end.
	 * @param requiredPropagationDirection the required direction of the propagation
	 * @return true if the end was valid. False if the end was not valid and an error was displayed.
	 */
	public static final boolean validateAndShowError(CombinedErrorModelSubclause combined,
			final BusinessObjectContext endBoc,
			final DirectionType requiredPropagationDirection) {
		if (isAll(endBoc) || findErrorPropagation(combined, endBoc, requiredPropagationDirection).isPresent()) {
			return true;
		}

		final String propagationDirectionLabel = (requiredPropagationDirection == DirectionType.IN ? "incoming"
				: "outgoing");
		MessageDialog.openError(Display.getDefault().getActiveShell(), "Unable to Create Error Flow",
				"Unable to create error flow. An " + propagationDirectionLabel
						+ " propagation is required for the " + propagationDirectionLabel
						+ " propagation point to create an error flow");
		return false;

	}

	/**
	 * Finds an error propagation in the combined subclause which is associated with a specified business object context
	 * and has the specified direction. Does not return error containments.
	 * @param combined the combined subclause to check.
	 * @param boc the business object context which the propagation must be associated with.
	 * @param requiredDirection the required direction of the propagation.
	 * @return an optional containing the matching error propagation.
	 */
	public static final Optional<ErrorPropagation> findErrorPropagation(final CombinedErrorModelSubclause combined,
			final BusinessObjectContext boc, final DirectionType requiredDirection) {
		return combined.getPropagations().getPropagationsForBusinessObjectContext(boc).filter(p -> {
			return !p.isNot() && p.getDirection() == requiredDirection;
		}).findAny();
	}

	public static final ErrorPropagation findErrorPropagationOrThrow(final CombinedErrorModelSubclause combined,
			final BusinessObjectContext boc, final DirectionType requiredDirection) {
		return findErrorPropagation(combined, boc, requiredDirection)
				.orElseThrow(
						() -> new AadlGraphicalEditorException("Unexpected case. Unable to find error propagation."));
	}

	/**
	 * Checks whether the business object context is an "all" keyword propagation point.
	 * @param boc the business object to check.
	 * @return whether the business object context's business object is an "all" Keyword propagation point.
	 */
	public static boolean isAll(final BusinessObjectContext boc) {
		final Object targetBo = boc.getBusinessObject();
		return targetBo instanceof KeywordPropagationPoint
				&& ((KeywordPropagationPoint) targetBo).getType() == KeywordPropagationPointType.ALL;

	}

	/**
	 * Returns true if the specified business object context is a potential end to an error flow.
	 * @param end the business object context to check
	 * @return true if the specified business object context has a business object type that could be used as an end to an
	 * error flow.
	 */
	public static boolean isPotentialEnd(final BusinessObjectContext end) {
		final Object bo = end.getBusinessObject();
		return bo instanceof Feature || bo instanceof KeywordPropagationPoint || bo instanceof PropagationPoint;
	}
}
