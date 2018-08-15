package org.osate.ui.navigator;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.osate.aadl2.Element;
import org.osate.aadl2.PrivatePackageSection;
import org.osate.aadl2.PublicPackageSection;
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
		if (object instanceof PublicPackageSection) {
			return "public";
		}
		if (object instanceof PrivatePackageSection) {
			return "private";
		}
		if (object instanceof Element) {
			return super.getText(object);
		}
		return null;
	}

}
