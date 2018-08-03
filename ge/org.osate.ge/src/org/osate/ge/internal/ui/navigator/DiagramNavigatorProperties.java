package org.osate.ge.internal.ui.navigator;

import org.eclipse.ui.navigator.IExtensionStateModel;

public class DiagramNavigatorProperties {
	public static String PROPERTY_SHOW_ANNOTATIONS = "org.osate.ge.show_annotations";
	public static String PROPERTY_GROUP_BY_DIAGRAM_TYPE = "org.osate.ge.group_by_diagram_type";
	public static String PROPERTY_GROUP_BY_DIAGRAM_CONTEXT = "org.osate.ge.group_by_diagram_context";

	public static void setShowAnnotations(final IExtensionStateModel stateModel, final boolean value) {
		stateModel.setProperty(PROPERTY_SHOW_ANNOTATIONS, value);
	}

	public static boolean getShowAnnotations(final IExtensionStateModel stateModel) {
		return stateModel.getBooleanProperty(PROPERTY_SHOW_ANNOTATIONS);
	}

	public static void setGroupByDiagramType(final IExtensionStateModel stateModel, final boolean value) {
		stateModel.setProperty(PROPERTY_GROUP_BY_DIAGRAM_TYPE, value);
	}

	public static boolean getGroupByDiagramType(final IExtensionStateModel stateModel) {
		return stateModel.getBooleanProperty(PROPERTY_GROUP_BY_DIAGRAM_TYPE);
	}

	public static void setGroupByDiagramContext(final IExtensionStateModel stateModel, final boolean value) {
		stateModel.setProperty(PROPERTY_GROUP_BY_DIAGRAM_CONTEXT, value);
	}

	public static boolean getGroupByDiagramContext(final IExtensionStateModel stateModel) {
		return stateModel.getBooleanProperty(PROPERTY_GROUP_BY_DIAGRAM_CONTEXT);
	}
}
