/*******************************************************************************
 * Copyright (c) 2009 EclipseSource Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     EclipseSource Corporation - initial API and implementation
 *******************************************************************************/
package org.osate.ui.projectvisualization;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.osate.ui.OsateUiPlugin;

public class PDEVizImages {

	private static ImageRegistry PLUGIN_REGISTRY;

	public final static String ICONS_PATH = "icons/"; //$NON-NLS-1$

	private static final String PATH_OBJ = ICONS_PATH + "obj16/"; //$NON-NLS-1$

	public static final String IMG_FORWARD_ENABLED = "forward_enabled.gif"; //$NON-NLS-1$
	public static final String IMG_BACKWARD_ENABLED = "backward_enabled.gif"; //$NON-NLS-1$
	public static final String IMG_SNAPSHOT = "snapshot.gif"; //$NON-NLS-1$
	public static final String IMG_SAVEEDIT = "save_edit.gif"; //$NON-NLS-1$
	public static final String IMG_REQ_PLUGIN_OBJ ="req_plugins_obj.gif"; //$NON-NLS-1$
	public static final String IMG_SEARCH_CANCEL ="progress_rem.gif"; //$NON-NLS-1$
	public static final String IMG_CALLEES = "ch_callees.gif"; //$NON-NLS-1$
	public static final String IMG_CALLERS = "ch_callers.gif"; //$NON-NLS-1$
	public static final String IMG_FOCUS = "focus.gif"; //$NON-NLS-1$

	public static final ImageDescriptor DESC_FORWARD_ENABLED = create(PATH_OBJ, IMG_FORWARD_ENABLED);
	public static final ImageDescriptor DESC_BACKWARD_ENABLED = create(PATH_OBJ, IMG_BACKWARD_ENABLED);
	public static final ImageDescriptor DESC_SNAPSHOT = create(PATH_OBJ, IMG_SNAPSHOT);
	public static final ImageDescriptor DESC_SAVEEDIT = create(PATH_OBJ, IMG_SAVEEDIT);
	public static final ImageDescriptor DESC_REQ_PLUGIN_OBJ = create(PATH_OBJ, IMG_REQ_PLUGIN_OBJ);
	public static final ImageDescriptor DESC_SEARCH_CANCEL = create(PATH_OBJ, IMG_SEARCH_CANCEL);
	public static final ImageDescriptor DESC_CALLEES = create(PATH_OBJ, IMG_CALLEES);
	public static final ImageDescriptor DESC_CALLERS = create(PATH_OBJ, IMG_CALLERS);
	public static final ImageDescriptor DESC_FOCUS = create(PATH_OBJ, IMG_FOCUS);

	private static final void initialize() {
		PLUGIN_REGISTRY = OsateUiPlugin.getDefault().getImageRegistry();
		manage(IMG_FORWARD_ENABLED, DESC_FORWARD_ENABLED);
		manage(IMG_BACKWARD_ENABLED, DESC_BACKWARD_ENABLED);
		manage(IMG_SNAPSHOT, DESC_SNAPSHOT);
		manage(IMG_SAVEEDIT, DESC_SAVEEDIT);
		manage(IMG_REQ_PLUGIN_OBJ, DESC_REQ_PLUGIN_OBJ);
		manage(IMG_SEARCH_CANCEL, DESC_SEARCH_CANCEL);
		manage(IMG_CALLEES, DESC_CALLEES);
		manage(IMG_CALLERS, DESC_CALLERS);
		manage(IMG_FOCUS, DESC_FOCUS);
	}

	private static ImageDescriptor create(String prefix, String name) {
		return ImageDescriptor.createFromURL(makeIconURL(prefix, name));
	}

	public static Image get(String key) {
		if (PLUGIN_REGISTRY == null)
			initialize();
		return PLUGIN_REGISTRY.get(key);
	}

	private static URL makeIconURL(String prefix, String name) {
		String path = "$nl$/" + prefix + name; //$NON-NLS-1$
		return FileLocator.find(OsateUiPlugin.getDefault().getBundle(), new Path(path), null);
	}

	public static Image manage(String key, ImageDescriptor desc) {
		Image image = desc.createImage();
		PLUGIN_REGISTRY.put(key, image);
		return image;
	}

}
