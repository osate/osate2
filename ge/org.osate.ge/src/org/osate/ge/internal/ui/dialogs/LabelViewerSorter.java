/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.internal.ui.dialogs;

import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * ViewerSorter designed to work with AbstractListViewers that have a LabelProvider derived label provider.
 *
 */
public class LabelViewerSorter extends ViewerSorter {
	@Override
	public int compare(final Viewer viewer, final Object o1, final Object o2) {
		if(!(viewer instanceof AbstractListViewer)) {
			throw new RuntimeException("AbstractListViewer expected");			
		}
		
		final AbstractListViewer alv = (AbstractListViewer)viewer;
		
		if(!(alv.getLabelProvider() instanceof LabelProvider)) {
			throw new RuntimeException("LabelProvider expected");
		}
		
		final LabelProvider labelProvider = (LabelProvider)alv.getLabelProvider();
		final String s1 = labelProvider.getText(o1);
		final String s2 = labelProvider.getText(o2);
		
		return s1.compareToIgnoreCase(s2);
	}
}
