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
