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
package org.osate.ge.internal.ui.editor;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.platform.GraphitiConnectionEditPart;
import org.eclipse.graphiti.ui.platform.GraphitiShapeEditPart;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.internal.diagram.runtime.AgeDiagram;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.diagram.runtime.DiagramNode;
import org.osate.ge.internal.graphiti.diagram.GraphitiAgeDiagram;
import org.osate.ge.internal.ui.xtext.AgeXtextUtil;
import org.osate.xtext.aadl2.ui.propertyview.IAadlPropertySource;

/**
 * Adapter implementation for adapting selections to IAadlPropertySource for integration with the AADL Property Values view.
 *
 */
public class GraphitiEditPartAdapterFactory implements IAdapterFactory {
	@Override
	public <T> T getAdapter(Object adaptableObject, Class<T> adapterType) {
		// Get the business object
		final PictogramElement pe;
		final EditPart editPart;
		if (adaptableObject instanceof GraphitiShapeEditPart) {
			final GraphitiShapeEditPart part = (GraphitiShapeEditPart)adaptableObject;
			pe = part.getPictogramElement();
			editPart = part;
		} else if (adaptableObject instanceof GraphitiConnectionEditPart) {
			final GraphitiConnectionEditPart part = (GraphitiConnectionEditPart)adaptableObject;
			pe = part.getPictogramElement();
			editPart = part;
		} else {
			return null;
		}

		if (editPart.getViewer() == null) {
			return null;
		}

		final EditDomain editDomain = editPart.getViewer().getEditDomain();
		if(!(editDomain instanceof DefaultEditDomain)){
			return null;
		}

		final DefaultEditDomain defaultEditDomain = (DefaultEditDomain)editDomain;
		final IEditorPart editorPart = defaultEditDomain.getEditorPart();
		if(!(editorPart instanceof AgeDiagramEditor)) {
			return null;
		}

		final GraphitiAgeDiagram graphitiAgeDiagram = ((AgeDiagramEditor) editorPart).getGraphitiAgeDiagram();
		if (graphitiAgeDiagram == null) {
			return null;
		}

		final AgeDiagram ageDiagram = graphitiAgeDiagram.getAgeDiagram();
		if(ageDiagram == null) {
			return null;
		}

		final DiagramNode dn = graphitiAgeDiagram.getClosestDiagramNode(pe);
		if (DiagramNode.class.equals(adapterType)) {
			return adapterType.cast(dn);
		}

		final DiagramElement de = graphitiAgeDiagram.getClosestDiagramElement(pe);
		if(de == null) {
			return null;
		}

		if(IAadlPropertySource.class.equals(adapterType)) {
			// If the business object is an AADL Named Element
			if(de.getBusinessObject() instanceof NamedElement) {
				final NamedElement namedElement = (NamedElement)de.getBusinessObject();
				return adapterType.cast(new IAadlPropertySource() {
					private final IXtextDocument document = AgeXtextUtil.getDocumentByRootElement(namedElement.getElementRoot());
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
		} else if(DiagramElement.class.equals(adapterType)) {
			return adapterType.cast(de);
		} else if (BusinessObjectContext.class.equals(adapterType)) {
			return adapterType.cast(de);
		}

		return null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Class[] getAdapterList() {
		return new Class[] { IAadlPropertySource.class, BusinessObjectContext.class,
				DiagramElement.class, DiagramNode.class };
	}
}
