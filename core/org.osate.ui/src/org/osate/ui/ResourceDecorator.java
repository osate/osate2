package org.osate.ui;

import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;
import org.osate.ui.handlers.AadlFileTypePropertyTester;
import org.osate.xtext.aadl2.ui.resource.ContributedAadlStorage;

/**
 * @since 6.3
 */
public class ResourceDecorator implements ILightweightLabelDecorator {

	@Override
	public void decorate(Object element, IDecoration decoration) {
		if (element instanceof ContributedAadlStorage) {
			decoration.addOverlay(OsateUiPlugin.getImageDescriptor("icons/AadlNature.gif"), IDecoration.TOP_RIGHT);
		} else {
			AadlFileTypePropertyTester tester = new AadlFileTypePropertyTester();
			if (tester.test(element, "aadlPackage", null, null)
					|| tester.test(element, "aadlPropertySet", null, null)) {
				decoration.addOverlay(OsateUiPlugin.getImageDescriptor("icons/AadlNature.gif"), IDecoration.TOP_RIGHT);
			}
		}
	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}
}