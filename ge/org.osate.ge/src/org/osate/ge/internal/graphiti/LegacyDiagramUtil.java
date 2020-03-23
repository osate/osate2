/**
 * Copyright (c) 2004-2020 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.ge.internal.graphiti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.internal.diagram.runtime.CanonicalBusinessObjectReference;
import org.osate.ge.internal.services.impl.ReferenceEncoder;

public class LegacyDiagramUtil {
	private static final String legacyReferenceKey = "independentObject";
	private static final String legacyDiagramIndicator = "graphiti";

	// All items are static
	private LegacyDiagramUtil() {
	}

	/**
	 * Returns whether a resource is a legacy diagram file.
	 * @param resource
	 * @return
	 */
	public static boolean isLegacy(final IFile diagramResource) {
		// Read the first couple of lines and look for the indicator that it is a Graphiti diagram.
		// If it is included, then we assume it is a legacy diagram. The indicator should be included in the Graphiti namespace reference.
		final File file = diagramResource.getLocation().toFile();
		try(final FileInputStream is = new FileInputStream(file)) {
			final BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			final String line1 = reader.readLine();
			final String line2 = reader.readLine();
			if((line1 != null && line1.contains(legacyDiagramIndicator)) || (line2 != null && line2.contains(legacyDiagramIndicator))) {
				return true;
			}
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}

		return false;
	}

	public static final CanonicalBusinessObjectReference getLegacyReference(final PictogramElement pe) {
		final String refStr = Graphiti.getPeService().getPropertyValue(pe, legacyReferenceKey);
		if(refStr == null) {
			return null;
		}

		return new CanonicalBusinessObjectReference(ReferenceEncoder.decode(refStr));
	}

}
