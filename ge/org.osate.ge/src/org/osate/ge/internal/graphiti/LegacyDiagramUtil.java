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
