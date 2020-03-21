package org.osate.ui.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.statushandlers.StatusManager;
import org.osate.ui.OsateUiPlugin;

public final class AadlFileTypePropertyTester extends PropertyTester {
	@Override
	public boolean test(final Object receiver, final String property, final Object[] args, final Object expectedValue) {
		final boolean testAadlPackage = property.equals("aadlPackage");
		final boolean testAadlPropertySet = property.equals("aadlPropertySet");
		if (receiver instanceof IFile && (testAadlPackage || testAadlPropertySet)) {
			final IFile file = (IFile) receiver;
			if ("aadl".equalsIgnoreCase(file.getFileExtension()) && file.exists()) {
				switch (getAadlFileType(file)) {
				case PACKAGE:
					return testAadlPackage;
				case PROPERTY_SET:
					return testAadlPropertySet;
				case UNKNOWN:
					return false;
				}
			}
		}
		return false;
	}

	public enum AadlFileType {
		PACKAGE, PROPERTY_SET, UNKNOWN
	}

	public static AadlFileType getAadlFileType(IStorage storage) {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(storage.getContents()))) {
			for (String line = reader.readLine(); line != null; line = reader.readLine()) {
				int i = 0;
				while (i < line.length() && Character.isWhitespace(line.charAt(i))) {
					i++;
				}
				if (i < line.length() && !line.startsWith("--", i)) {
					String lowered = line.toLowerCase();
					if (lowered.startsWith("package", i)) {
						return AadlFileType.PACKAGE;
					} else if (lowered.startsWith("property", i)) {
						return AadlFileType.PROPERTY_SET;
					} else {
						return AadlFileType.UNKNOWN;
					}
				}
			}
		} catch (IOException e) {
			StatusManager.getManager().handle(new Status(IStatus.ERROR, OsateUiPlugin.PLUGIN_ID, e.getMessage(), e));
		} catch (CoreException e) {
			StatusManager.getManager().handle(e, OsateUiPlugin.PLUGIN_ID);
		}
		return AadlFileType.UNKNOWN;
	}
}
