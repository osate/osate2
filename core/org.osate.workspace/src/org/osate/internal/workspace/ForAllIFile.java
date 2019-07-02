/*
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: ForAllIFile.java,v 1.4 2009-10-07 16:46:48 lwrage Exp $
 */
package org.osate.internal.workspace;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

/**
 * ForAllIFile operates on all files in a container hierarchy
 *
 * @author phf
 *
 * @deprecated Will be removed in 2.6.0.
 */
@Deprecated
public class ForAllIFile {
	public static final String copyright = "Copyright 2004 by Carnegie Mellon University, all rights reserved";

	protected final EList<IFile> resultList = new BasicEList<IFile>();

	/**
	 * Create a new traversal that uses the given error manager and used the
	 * given default traversal algorithm.
	 */
	public ForAllIFile() {
	}

	/**
	 * placeholder to be overwritten by real action in each list element
	 *
	 * @param obj IFile
	 * @return true always
	 */
	protected boolean suchThat(IFile obj) {
		return true;
	}

	/**
	 * placeholder to be overwritten by real action in each list element the
	 * default implementation creates a list of elements satisfying the
	 * condition
	 *
	 * @param obj IFile
	 */
	protected void action(IFile obj) {
		resultList.add(obj);
	}

	/**
	 * Can be re-implemented by each concrete switch performs object processing
	 * specific to the switch
	 */

	protected void process(IFile theFile) {
		if (suchThat(theFile)) {
			action(theFile);
		}
		return;
	}

	/**
	 * Does preorder processing of containment hierarchy The default
	 * implementation applies the suchThat condition and if true adds the
	 * element to the result list
	 *
	 * @param obj root object
	 * @return EList result list of IFile
	 */
	public final EList<IFile> traverse(IResource obj) {
		if (obj == null) {
			return resultList;
		}
		if (obj instanceof IFile) {
			process((IFile) obj);
		} else if (obj instanceof IContainer) {
			IResource[] list;
			try {
				list = ((IContainer) obj).members();
				for (int it = 0; it < list.length; it++) {
					traverse(list[it]);
				}
			} catch (CoreException e) {
			}
		}
		return resultList;
	}
}