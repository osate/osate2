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
package org.osate.ge.internal.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.osate.ge.GraphicalEditor;
import org.osate.ge.graphics.Dimension;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.services.DiagramExportService;

/**
 * Extension of {@link DiagramExportService} which provides an APIs for exporting from an open diagram editor.
 *
 */
public interface InternalDiagramExportService extends DiagramExportService {
	/**
	 * Exports a diagram as an image file.
	 * @param editor contains the diagram being exported.
	 * @param outputStream the stream to which to write the image.
	 * @param format either "svg" or a name of a {@link ImageIO} writer format
	 * @param exportNode the diagram node to export. Must not be null.
	 * @param scaling how much to scale the diagram when exporting.
	 * @throws IOException
	 */
	void export(final GraphicalEditor editor, final OutputStream outputStream, final String format,
			final DiagramNode exportNode, final double scaling) throws IOException;

	/**
	 * Exports a diagram as a raster image.
	 * @param editor editor contains the diagram being exported.
	 * @param exportNode exportNode the diagram node to export. Must not be null.
	 * @param scaling how much to scale the diagram when exporting.
	 * @return
	 */
	BufferedImage export(final GraphicalEditor editor, final DiagramNode exportNode, final double scaling);

	/**
	 * Gets the dimensions of the image produced by exporting the specified node. The returned may contain fractional values.
	 * @param editor is the editor which contains the specified node.
	 * @param exportNode the node which is to be exported. Must not be null.
	 * @return the dimensions.
	 */
	Dimension getDimensions(final GraphicalEditor editor, final DiagramNode exportNode);
}
