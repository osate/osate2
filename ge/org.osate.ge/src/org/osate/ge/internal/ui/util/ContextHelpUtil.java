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
package org.osate.ge.internal.ui.util;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

/**
 * Utility class related to context sensitive help
 *
 */
public final class ContextHelpUtil {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private ContextHelpUtil() {
	}

	private static final String DOC_PKG = "org.osate.ge.doc.";

	/**
	 * Help context ID for the properties view
	 */
	public static final String PROPERTIES_VIEW = buildContextId("properties_view");

	/**
	 * Help context ID for the end of the end flow specification tool
	 */
	public static final String END_TO_END_TOOL = buildContextId("end_to_end_fs_tool");

	/**
	 * Help context ID for flow implementation tool
	 */
	public static final String FLOW_IMPL_TOOL = buildContextId("flow_impl_tool");

	/**
	 * Help context ID for the binding tool
	 */
	public static final String BINDING_TOOL = buildContextId("binding_tool");

	/**
	 * Help context ID for the diagram editor
	 */
	public static final String DIAGRAM_EDITOR = buildContextId("diagram_editor");

	/**
	 * Help context ID for diagram configuration dialog
	 */
	public static final String DIAGRAM_CONFIG = buildContextId("diagram_config");

	/**
	 * Help context ID for the create subprogram call sequence dialog
	 */
	public static final String SUBPROGRAM_CALL_SEQUENCES = buildContextId("subprogram_call_seq_tool");

	/**
	 * Help context ID for renaming elements
	 */
	public static final String RENAMING_ELEMENTS = buildContextId("rename_element_tool");

	/**
	 * Help context ID for the restoring missing diagram elements
	 */
	public static final String RESTORE_MISSING_DES = buildContextId("restore_missing_des_tool");

	/**
	 * Help context ID for the outline view
	 */
	public static final String OUTLINE_VIEW = buildContextId("outline_view");

	/**
	 * Help context ID for the AADL Diagrams view
	 */
	public static final String AADL_DIAGRAMS_VIEW = buildContextId("aadl_diagrams_view");

	private static String buildContextId(final String id) {
		return DOC_PKG + id;
	}

	/**
	 * Sets the help context for the specified control
	 * @param control the control for which to set the help context
	 * @param helpContextId the ID of the context specific help
	 */
	public static void setHelp(final Control control, final String helpContextId) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, helpContextId);
	}
}
