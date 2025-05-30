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
package org.osate.ge.internal.ui.navigator;

import org.eclipse.ui.navigator.IExtensionStateModel;

/**
 * Utility class containing property constants for the AADL Diagram view preferences and extension state model.
 * The extension state model is the state shared between the components of the AADL Diagram view. Preferences are used to allow restoring
 * state when the view is opened.
 *
 */
final class DiagramNavigatorProperties {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private DiagramNavigatorProperties() {
	}

	/**
	 * The name of the boolean preference for whether to show annotations
	 */
	public static final String PROPERTY_SHOW_ANNOTATIONS = "org.osate.ge.show_annotations";

	/**
	 * The name of the boolean preference for whether to group diagrams by diagram type
	 */
	public static final String PROPERTY_GROUP_BY_DIAGRAM_TYPE = "org.osate.ge.group_by_diagram_type";

	/**
	 * The name of the boolean preference for whether to group diagrams by their context
	 */
	public static final String PROPERTY_GROUP_BY_DIAGRAM_CONTEXT = "org.osate.ge.group_by_diagram_context";

	/**
	 * Sets the value of the show annotations flag of an extension state model
	 * @param stateModel the extenion's state model
	 * @param value the new value
	 */
	public static void setShowAnnotations(final IExtensionStateModel stateModel, final boolean value) {
		stateModel.setProperty(PROPERTY_SHOW_ANNOTATIONS, value);
	}

	/**
	 * Returns the value of the show annotations flag from an extension state model
	 * @param stateModel the extension state model
	 * @return the value of the show annotations flag
	 */
	public static boolean getShowAnnotations(final IExtensionStateModel stateModel) {
		return stateModel.getBooleanProperty(PROPERTY_SHOW_ANNOTATIONS);
	}

	/**
	 * Sets the value of the group by diagram type flag of an extension state model
	 * @param stateModel the extenion's state model
	 * @param value the new value
	 */
	public static void setGroupByDiagramType(final IExtensionStateModel stateModel, final boolean value) {
		stateModel.setProperty(PROPERTY_GROUP_BY_DIAGRAM_TYPE, value);
	}

	/**
	 * Returns the value of the group by diagram type flag from an extension state model
	 * @param stateModel the extension state model
	 * @return the value of the group by diagram type flag
	 */
	public static boolean getGroupByDiagramType(final IExtensionStateModel stateModel) {
		return stateModel.getBooleanProperty(PROPERTY_GROUP_BY_DIAGRAM_TYPE);
	}

	/**
	 * Sets the value of the group by diagram context of an extension state model
	 * @param stateModel the extenion's state model
	 * @param value the new value
	 */
	public static void setGroupByDiagramContext(final IExtensionStateModel stateModel, final boolean value) {
		stateModel.setProperty(PROPERTY_GROUP_BY_DIAGRAM_CONTEXT, value);
	}

	/**
	 * Returns the value of the group by diagram context flag from an extension state model
	 * @param stateModel the extension state model
	 * @return the value of the group by diagram context flag
	 */
	public static boolean getGroupByDiagramContext(final IExtensionStateModel stateModel) {
		return stateModel.getBooleanProperty(PROPERTY_GROUP_BY_DIAGRAM_CONTEXT);
	}
}
