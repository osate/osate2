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
package org.osate.ge.errormodel.ui.swt;

import java.util.Collection;
import java.util.Optional;

import org.osate.ge.errormodel.ui.viewmodels.NamedObjectsProvider;
import org.osate.ge.swt.ObservableModel;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorState;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;

/**
 * Model interface used with {@link FaultSourceEditorDialog} and {@link FaultSourceField}
 *
 */
public interface FaultSourceEditorModel extends ObservableModel {
	/**
	 * Whether the allow editing. If this method returns false, then the set methods should not be called.
	 * @return whether the allow editing.
	 */
	boolean isEnabled();

	/**
	 * Gets the current value of the fault source.
	 * @return the current fault source. Must not return null.
	 */
	FaultSource getFaultSource();

	/**
	 * Updates the fault source.
	 * @param value the new fault source.
	 */
	void setFaultSource(FaultSource value);

	/**
	 * Returns the error behavior states that are referenceable by the type source.
	 * @return the error behavior state options to present to the user.
	 */
	Collection<ErrorBehaviorState> getStateOptions();

	/**
	 * Returns the error types that are referenceable by the type source.
	 * @return the error types options to present to the user.
	 */
	NamedObjectsProvider<ErrorTypes> getErrorTypeOptions();

	/**
	 * A string representation of the type tokens referenced by the fault source.
	 * @return the label.
	 */
	String getTypeTokensLabel();

	/**
	 * Returns a description of an error with the model or the current value. If present, it should be displayed to the user.
	 * @return the current error.
	 */
	Optional<String> getError();
}
