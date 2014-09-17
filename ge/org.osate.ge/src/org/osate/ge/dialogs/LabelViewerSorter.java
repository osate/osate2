package org.osate.ge.dialogs;

import org.eclipse.jface.viewers.AbstractListViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * ViewerSorter designed to work with AbstractListViewers that have a LabelProvider derived label provider.
 * @author philip.alldredge
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
