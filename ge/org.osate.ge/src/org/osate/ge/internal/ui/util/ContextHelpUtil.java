package org.osate.ge.internal.ui.util;

import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.PlatformUI;

public class ContextHelpUtil {
	private static final String DOC_PKG = "org.osate.ge.doc.";

	public static final String PROPERTIES_VIEW = buildContextId("properties_view");
	public static final String END_TO_END_TOOL = buildContextId("end_to_end_fs_tool");
	public static final String FLOW_IMPL_TOOL = buildContextId("flow_impl_tool");
	public static final String BINDING_TOOL = buildContextId("binding_tool");
	public static final String DIAGRAM_EDITOR = buildContextId("diagram_editor");
	public static final String DIAGRAM_CONFIG = buildContextId("diagram_config");
	public static final String SUBPROGRAM_CALL_SEQUENCES = buildContextId("subprogram_call_seq_tool");
	public static final String RENAMING_ELEMENTS = buildContextId("rename_element_tool");
	public static final String RESTORE_MISSING_DES = buildContextId("restore_missing_des_tool");
	public static final String OUTLINE_VIEW = buildContextId("outline_view");
	public static final String AADL_DIAGRAMS_VIEW = buildContextId("aadl_diagrams_view");

	private static String buildContextId(final String id) {
		return DOC_PKG + id;
	}

	public static void setHelp(final Control control, final String contextHelpId) {
		PlatformUI.getWorkbench().getHelpSystem().setHelp(control, contextHelpId);
	}
}
