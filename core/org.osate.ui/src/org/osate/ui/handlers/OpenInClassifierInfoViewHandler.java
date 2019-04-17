/**
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
 * </copyright>
 *
 * @version $Id: ConversionAction.java,v 1.5 2007-06-28 22:02:52 jseibel Exp $
 */
package org.osate.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.osate.aadl2.AccessSpecification;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ClassifierValue;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.PortSpecification;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.EObjectURIWrapper;
import org.osate.ui.utils.SelectionHelper;
import org.osate.ui.views.ClassifierInfoView;

public class OpenInClassifierInfoViewHandler extends AbstractHandler {
	@Override
	public Object execute(final ExecutionEvent event) throws ExecutionException {
		// (1) Set the input on the view to the currently selected classifier
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		Classifier input = null;
		if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
			final Object selectedObject = ((IStructuredSelection) selection).getFirstElement();
			if (selectedObject != null) {
				if (selectedObject instanceof EObjectURIWrapper) {
					final EObjectURIWrapper wrapper = (EObjectURIWrapper) selectedObject;
					final URI uri = wrapper.getUri();
					input = (Classifier) new ResourceSetImpl().getEObject(uri, true);
				} else if (selectedObject instanceof EObjectNode) {
					try {
						final EObjectNode eObjectNode = (EObjectNode) selectedObject;
						final URI eObjectURI = eObjectNode.getEObjectURI();
						input = (Classifier) new ResourceSetImpl().getEObject(eObjectURI, true);
					} catch (final Exception e) {
						input = null;
					}
				}
			}
		} else if (selection instanceof TextSelection) {
			final EObject selectedObject = SelectionHelper.getEObjectFromSelection(selection);
			input = getClassifierFrom(selectedObject);
		}

		if (input != null) {
			// (2) Bring the classifier info view to the front and make sure it is open
			final ClassifierInfoView view = ClassifierInfoView.open(HandlerUtil.getActiveWorkbenchWindow(event));

			// (3) Set the input
			view.setInput(input);
		}

		// Done, we are always supposed to return null
		return null;
	}

	private static Classifier getClassifierFrom(final EObject eObject) {
		if (eObject instanceof AccessSpecification) {
			return ((AccessSpecification) eObject).getClassifier();
		} else if (eObject instanceof Classifier) {
			return (Classifier) eObject;
		} else if (eObject instanceof ClassifierValue) {
			return ((ClassifierValue) eObject).getClassifier();
		} else if (eObject instanceof Feature) {
			return ((Feature) eObject).getClassifier();
		} else if (eObject instanceof FeatureGroup) {
			return ((FeatureGroup) eObject).getClassifier();
		} else if (eObject instanceof PortSpecification) {
			return ((PortSpecification) eObject).getClassifier();
		} else if (eObject instanceof Subcomponent) {
			return ((Subcomponent) eObject).getClassifier();
		} else {
			// See if we are inside a Classifier
			EObject current = eObject;
			while (current != null && !(current instanceof Classifier)) {
				current = current.eContainer();
			}
			return (Classifier) current;
		}
	}
}