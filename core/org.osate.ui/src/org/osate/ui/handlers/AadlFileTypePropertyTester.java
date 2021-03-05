/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
 * All Rights Reserved.
 * 
 * NO WARRANTY. ALL MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY
 * KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING, BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE
 * OR MERCHANTABILITY, EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON UNIVERSITY DOES NOT
 * MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Created, in part, with funding and support from the United States Government. (see Acknowledgments file).
 * 
 * This program includes and/or can make use of certain third party source code, object code, documentation and other
 * files ("Third Party Software"). The Third Party Software that is used by this program is dependent upon your system
 * configuration. By using this program, You agree to comply with any and all relevant Third Party Software terms and
 * conditions contained in any such Third Party Software or separate license file distributed with such Third Party
 * Software. The parties who own the Third Party Software ("Third Party Licensors") are intended third party benefici-
 * aries to this license with respect to the terms applicable to their Third Party Software. Third Party Software li-
 * censes only apply to the Third Party Software and not any other portion of this program or this program as a whole.
 */
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

	/**
	 * @since 5.0
	 */
	public enum AadlFileType {
		PACKAGE, PROPERTY_SET, UNKNOWN
	}

	/**
	 * @since 5.0
	 */
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
