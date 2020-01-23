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