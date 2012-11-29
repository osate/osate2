/************************************************************************************
 * Copyright (c) 2012 Brandon Breuil. Contributions by Peter Feiler.                                               *
 *                                                                                  *
 * All rights reserved. This program and the accompanying materials are made        *
 * available under the terms of the Eclipse Public License v1.0 which accompanies   *
 * this distribution, and is available at http://www.eclipse.org/legal/epl-v10.html *
 *                                                                                  *
 * Use is subject to the terms of Eclipse Public License v1.0.                      *
 *                                                                                  *
 ************************************************************************************/

package org.osate.imv.aadldiagram.visitors;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.osate.imv.aadldiagram.adapters.AadlComponentAdapter;
import org.osate.imv.aadldiagram.adapters.AadlConnectionAdapter;
import org.osate.imv.aadldiagram.adapters.AadlFeatureAdapter;
import org.osate.imv.aadldiagram.adapters.IAadlElementAdapter;


public class FilterVisitor extends AadlAdapterVisitor {

	private List<ViewerFilter> filters;
	private Viewer viewer;

	public FilterVisitor(List<ViewerFilter> filters, Viewer viewer) {
		this.filters = filters;
		this.viewer = viewer;
	}

	public void visitAadlComponentAdapter(AadlComponentAdapter adapter) {
		if(!adapter.isContainer())
			runFilters(adapter);
	}

	public void visitAadlFeatureAdapter(AadlFeatureAdapter adapter) {
		runFilters(adapter);
	}

	public void visitAadlConnectionAdapter(AadlConnectionAdapter adapter) {
		runFilters(adapter);
	}


	private void runFilters(IAadlElementAdapter adapter) {
		IAadlElementAdapter parentAdapter = adapter.getParentAdapter();
		IFigure figure = adapter.getFigure();
		boolean visible = true;

		// If the parent figure is not visible, then the children figures won't
		// be visible either; therefore,
		// there is no need to filter the children figures if the parent figure
		// is not visible.
		if (parentAdapter.getFigure().isVisible()) {
			for (Iterator<ViewerFilter> filterIterator = this.filters.iterator(); filterIterator.hasNext();) {
				ViewerFilter filter = filterIterator.next();
				visible = filter.select(this.viewer, parentAdapter.getModelElement(), adapter.getModelElement());
				if (!visible)
					break; // No need to apply anymore filters to this figure.
			}
		} else {
			visible = false;
		}

		figure.setVisible(visible);
	}

}
