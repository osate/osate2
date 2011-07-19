/* <copyright>
 * Copyright  2004-2006 by Carnegie Mellon University, all rights reserved.
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
 * @version $Id: AbstractSimpleTraversal.java,v 1.5 2010-03-29 19:17:54 jseibel Exp $
 */
package org.osate.aadl2.modelsupport.modeltraversal;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.modelsupport.eclipseinterface.OsateResourceManager;
import org.osate.aadl2.util.Aadl2ResourceImpl;


abstract class AbstractSimpleTraversal extends AbstractTraversal {

	public AbstractSimpleTraversal(final IProcessingMethod pm) {
		super(pm);
	}

	/**
	 * Process all AADL models in the AadlWorkspace.
	 * 
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 * 
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	public final EList<Element> visitWorkspace() {
		final EList<Resource> resources = OsateResourceManager.getResourceSet().getResources();
		for (Iterator<Resource> it = resources.iterator(); processingMethod.notCancelled() && it.hasNext();) {
			final Resource res = it.next();
			if (res instanceof Aadl2ResourceImpl) {
				final EList<EObject> rc = res.getContents();
				if (!rc.isEmpty()) {
					final Element o = (Element) res.getContents().get(0);
					visitRoot(o);
				}
			}
		}
		return processingMethod.getResultList();
	}

	/**
	 * Process all declarative AADL models in the AadlWorkspace.
	 * 
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 * 
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	public final EList visitWorkspaceDeclarativeModels() {
		final EList<Resource> resources = OsateResourceManager.getResourceSet().getResources();
		for (Iterator<Resource> it = resources.iterator(); processingMethod.notCancelled() && it.hasNext();) {
			final Resource res = it.next();
			if (res instanceof Aadl2ResourceImpl) {
				final EList<EObject> rc = res.getContents();
				if (!rc.isEmpty()) {
					final Element o = (Element) res.getContents().get(0);
					if (!(o instanceof InstanceObject)) {
						visitRoot(o);
					}
				}
			}
		}
 		return processingMethod.getResultList();
	}
	
	/**
	 * Process all AADL instance models in the AadlWorkspace.
	 * 
	 * <p>
	 * This method checks whether the processing has been cancelled after
	 * visiting each element, and terminates the processing if the traversal has
	 * been cancelled.
	 * 
	 * @return The {@link IProcessingMethod#getResultList() result list} of the
	 *         encapsulated processing method.
	 */
	public final EList visitWorkspaceInstanceModels() {
		final EList<Resource> resources = OsateResourceManager.getResourceSet().getResources();
		for (Iterator<Resource> it = resources.iterator(); processingMethod.notCancelled() && it.hasNext();) {
			final Resource res = it.next();
			if (res instanceof Aadl2ResourceImpl) {
				final EList<EObject> rc = res.getContents();
				if (!rc.isEmpty()) {
					final Element o = (Element) res.getContents().get(0);
					if ((o instanceof InstanceObject)) {
						visitRoot(o);
					}
				}
			}
		}
		return processingMethod.getResultList();
	}
}
