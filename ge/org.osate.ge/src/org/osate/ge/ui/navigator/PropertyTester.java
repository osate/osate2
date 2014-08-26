package org.osate.ge.ui.navigator;

import org.eclipse.core.resources.IFolder;

public class PropertyTester extends org.eclipse.core.expressions.PropertyTester {
	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if(receiver instanceof IFolder) {
			final IFolder folder = (IFolder)receiver;
			if(property.equals("name")) {
				if(folder.getName().equalsIgnoreCase(expectedValue.toString())) {
					return true;
				}	
			}
		}
		
		return false;
	}
}
