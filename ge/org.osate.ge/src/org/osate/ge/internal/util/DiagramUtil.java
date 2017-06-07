package org.osate.ge.internal.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import org.eclipse.core.resources.IFile;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.osate.ge.internal.diagram.CanonicalBusinessObjectReference;
import org.osate.ge.internal.services.impl.ReferenceEncoder;

public class DiagramUtil {
	private static final String legacyReferenceKey = "independentObject";	
	
	/**
	 * Returns whether a resource is a legacy diagram file.
	 * @param resource
	 * @return
	 */
	public static boolean isLegacy(final IFile diagramResource) {
		final File file = diagramResource.getLocation().toFile();				
		try(final FileInputStream is = new FileInputStream(file)) {
			final Reader reader = new InputStreamReader(is);
			final char[] xmlStart = "<?xml".toCharArray();
			final char[] buf = new char[xmlStart.length];
			if(reader.read(buf) == buf.length) {
				return Arrays.equals(xmlStart, buf);
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
