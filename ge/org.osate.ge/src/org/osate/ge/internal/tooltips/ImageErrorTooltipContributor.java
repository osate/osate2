package org.osate.ge.internal.tooltips;

import javax.inject.Named;

import org.eclipse.core.runtime.IPath;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.di.Activate;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.util.ImageHelper;

public class ImageErrorTooltipContributor {
	@Activate
	public void getTooltip(final Composite parent, @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc) {
		if (boc instanceof DiagramElement) {
			final DiagramElement de = (DiagramElement) boc;
			final Style style = de.getStyle();
			if (style != null && Boolean.TRUE.equals(style.getShowAsImage())) {
				final IPath imagePath = style.getImagePath();
				if (ImageHelper.findImage(imagePath) == null) {
					final Label lbl = new Label(parent, SWT.NONE);
					lbl.setText("Unable to load image: " + imagePath.toPortableString());
				}
			}
		}
	}
}
