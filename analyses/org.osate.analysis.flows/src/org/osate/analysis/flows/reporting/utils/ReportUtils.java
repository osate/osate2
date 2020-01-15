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
package org.osate.analysis.flows.reporting.utils;

import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;

public class ReportUtils {

	/**
	 * @param root - the root object related to the report
	 * @param subDirectory - the directory where we store the report, relative to the root object
	 * @param reportType - the type of the report (latency, etc.)
	 * @param fileSuffix - any suffix for the file
	 * @param fileExtension - the file extension (.csv, .xls, etc.)
	 * @return the path for the file.
	 */
	public static IPath getReportPath(EObject root, String subDirectory, String reportPostfix, String fileExtension) {
		String filename = null;
		subDirectory = subDirectory.replaceAll(" ", "");
		Resource res = root.eResource();
		URI uri = res.getURI();
		IPath path = OsateResourceUtil.toIFile(uri).getFullPath();
		if (root instanceof InstanceObject) {
			path = path.removeFileExtension();
			filename = path.lastSegment() + "__" + reportPostfix;
			path = path.removeLastSegments(1).append("/reports/" + subDirectory + "/" + filename);
		} else {
			filename = path.lastSegment() + reportPostfix;
			path = path.removeLastSegments(1).append("/reports/" + subDirectory + "/" + filename);
		}

		path = path.addFileExtension(fileExtension);
		return path;
	}

}
