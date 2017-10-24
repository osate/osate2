package org.osate.ge.internal.ui.editor;

import org.osate.ge.internal.services.ColoringService;
import org.osate.ge.services.QueryService;

/**
 * Contains simple methods that are shared between UI contributions
 *
 */
class ContributionHelper {
	public static QueryService getQueryService(final AgeDiagramEditor editor) {
		if(editor == null) {
			return null;
		}

		return (QueryService)editor.getAdapter(QueryService.class);
	}

	public static ColoringService getColoringService(final AgeDiagramEditor editor) {
		if(editor == null) {
			return null;
		}

		return (ColoringService)editor.getAdapter(ColoringService.class);
	}
}
