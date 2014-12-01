package org.osate.ge.properties;

import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.AbstractPropertySectionFilter;

public class BindingsFilter extends AbstractPropertySectionFilter {
	@Override
	protected boolean accept(final PictogramElement pictogramElement) {
		return pictogramElement instanceof Diagram;
	}
}
