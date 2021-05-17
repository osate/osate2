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
package org.osate.ge.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.stream.ImageOutputStream;

import org.eclipse.core.resources.IFile;

// TODO: Rename
/**
 * @since 3.0
 */
public interface DiagramExportService {
	public static enum ImageFormat {
		JPEG, PNG, SVG
	}

	default void export(final IFile diagramFile, final File outputFile, final ImageFormat format) throws IOException {
		try (FileOutputStream output = new FileOutputStream(outputFile)) {
			export(diagramFile, output, format);
		}
	}

	default void export(final IFile diagramFile, final ImageOutputStream outputStream, final ImageFormat format)
			throws IOException {
		export(diagramFile, new OutputStream() {
			@Override
			public void close() throws IOException {
				outputStream.close();
				super.close();
			}

			@Override
			public void flush() throws IOException {
				outputStream.flush();
				super.flush();
			}

			@Override
			public void write(final int b) throws IOException {
				outputStream.write(b);
			}

			@Override
			public void write(byte[] b) throws IOException {
				outputStream.write(b);
			}

			@Override
			public void write(byte[] b, int off, int len) throws IOException {
				outputStream.write(b, off, len);
				super.write(b, off, len);
			}

		}, format);
	}

	void export(final IFile diagramFile, final OutputStream outputStream, final ImageFormat format) throws IOException;
}
