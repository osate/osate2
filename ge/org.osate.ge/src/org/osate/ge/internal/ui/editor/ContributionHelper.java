package org.osate.ge.internal.ui.editor;

import org.osate.aadl2.NamedElement;
import org.osate.ge.internal.query.Queryable;
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

	public static String getPath(final Queryable q) {
		final Object bo = q.getBusinessObject();
		if (bo instanceof NamedElement) {
			final String parentPath = getPath(q.getParent());
			final String name = ((NamedElement) bo).getName();
			return parentPath.length() == 0 ? name : parentPath + "::" + name;
		} else {
			return "";
		}
	}
}
