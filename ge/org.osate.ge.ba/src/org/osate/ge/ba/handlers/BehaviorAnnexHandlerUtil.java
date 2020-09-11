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
package org.osate.ge.ba.handlers;

import java.util.Objects;
import java.util.Optional;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DefaultAnnexSubclause;
import org.osate.ge.aadl2.AnnexHandler;
import org.osate.ge.ba.util.BehaviorAnnexSelectionUtil;

public class BehaviorAnnexHandlerUtil {
	private BehaviorAnnexHandlerUtil() {
	}

	/**
	 * Retrieves the diagram context for the selected behavior diagram elements
	 * Will return empty if the selected element is not a behavior diagram element
	 */
	public static Optional<DefaultAnnexSubclause> getBehaviorAnnexDiagramContext(final IEditorPart activeEditor) {
		final ISelection selection = Objects.requireNonNull(BehaviorAnnexSelectionUtil.getCurrentSelection(),
				"ISelection cannot be null");
		return BehaviorAnnexSelectionUtil.getDiagramContext(selection, activeEditor);
	}

	/**
	 * Creates the file name for the behavior annex diagram
	 */
	public static String getFilename(final Classifier classifier, final DefaultAnnexSubclause annexSubclause) {
		final StringBuilder fileName = new StringBuilder(classifier.getQualifiedName().replaceAll("::|:|\\.", "_"));
		fileName.append("_behavior_");
		return fileName.append(AnnexHandler.getAnnexSubclauseIndex(annexSubclause, true)).toString();
	}
}
