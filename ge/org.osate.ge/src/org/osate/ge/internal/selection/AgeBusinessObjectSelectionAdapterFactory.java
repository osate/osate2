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
package org.osate.ge.internal.selection;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.e4.core.contexts.EclipseContextFactory;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.services.AadlModificationService;
import org.osate.ge.internal.ui.util.SelectionUtil;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.xtext.aadl2.ui.propertyview.IAadlPropertySource;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

// Only supports adaptable objects of type ISelection
public class AgeBusinessObjectSelectionAdapterFactory implements IAdapterFactory {
	@Override
	public <T> T getAdapter(final Object adaptableObject, final Class<T> adapterType) {
		final ISelection selection = (ISelection)adaptableObject;

		if (BusinessObjectSelection.class.equals(adapterType)) {
			final Bundle bundle = FrameworkUtil.getBundle(getClass());
			final IEclipseContext context = EclipseContextFactory.getServiceContext(bundle.getBundleContext());
			final AadlModificationService modificationService = context.get(AadlModificationService.class);
			if (modificationService == null) {
				return null;
			}

			return adapterType
					.cast(new AgeBusinessObjectSelection(SelectionUtil.getSelectedBusinessObjectContexts(selection),
							modificationService));
		} else if (IAadlPropertySource.class.equals(adapterType) && adaptableObject instanceof IStructuredSelection) {
			final IStructuredSelection ss = (IStructuredSelection) adaptableObject;
			if (ss.getFirstElement() instanceof DiagramElement) {
				final DiagramElement de = (DiagramElement) ss.getFirstElement();
				// If the business object is an AADL Named Element
				if (de.getBusinessObject() instanceof NamedElement) {
					final NamedElement namedElement = (NamedElement) de.getBusinessObject();
					return adapterType.cast(new IAadlPropertySource() {
						private final IXtextDocument document = AgeXtextUtil
								.getDocumentByRootElement(namedElement.getElementRoot());
						private final NamedElement element = namedElement;

						@Override
						public IXtextDocument getDocument() {
							return document;
						}

						@Override
						public NamedElement getNamedElement() {
							return element;
						}
					});
				}
			}
		}

		return null;
	}

	@Override
	public Class<?>[] getAdapterList() {
		return new Class[] { IAadlPropertySource.class, BusinessObjectSelection.class };
	}

}
