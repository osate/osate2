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
package org.osate.xtext.aadl2.resource.persistence

import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import org.apache.log4j.Logger
import org.eclipse.xtext.generator.IFileSystemAccessExtension3
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.osate.xtext.aadl2.generator.Aadl2OutputConfigurationProvider

class Aadl2ResourceStorageFacade extends ResourceStorageFacade {

	static val Logger LOG = Logger.getLogger(ResourceStorageFacade)

	new() {
		storeNodeModel = false
	}

	protected override getSourceContainerURI(StorageAwareResource resource) {
		resource.URI.trimSegments(resource.URI.segmentCount - 2).appendSegment("")
	}

	override void saveResource(StorageAwareResource resource, IFileSystemAccessExtension3 fsa) {
		val path = computeOutputPath(resource)
		val bout = new MyByteArrayOutputStream()
		val outStream = createResourceStorageWritable(bout)
		try {
			outStream.writeResource(resource)
		} catch (IOException e) {
			// something went wrong when writing the resource - stream's content is bogus and not written to disk
			LOG.warn("Cannot write storage for " + resource.URI, e)
			return;
		}
		fsa.generateFile(path, Aadl2OutputConfigurationProvider.AADLBIN_OUTPUT,
			new ByteArrayInputStream(bout.toByteArray, 0, bout.length))
	}

	private static class MyByteArrayOutputStream extends ByteArrayOutputStream {
		override synchronized toByteArray() {
			buf
		}

		def int length() {
			count
		}
	}
}
