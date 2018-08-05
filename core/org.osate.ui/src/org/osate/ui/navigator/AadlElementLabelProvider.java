package org.osate.ui.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osate.aadl2.Element;
import org.osate.ui.UiUtil;

public class AadlElementLabelProvider extends AdapterFactoryLabelProvider {

	public AadlElementLabelProvider() {
		super(UiUtil.getAdapterFactory());
	}

	@Override
	public Image getImage(Object object) {
		if (object instanceof Element) {
			return super.getImage(object);
		}
		return null;
	}

	@Override
	public String getText(Object object) {
		if (object instanceof Element) {
			return super.getText(object);
		}
		return null;
	}

}
