package org.osate.ge.internal.businessObjectHandlers;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.GraphicalConfigurationBuilder;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.CanStartConnection;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.ConnectionBuilder;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.internal.AgeDiagramProvider;
import org.osate.ge.internal.diagram.runtime.DiagramElement;
import org.osate.ge.internal.model.Note;
import org.osate.ge.internal.model.NoteReference;
import org.osate.ge.internal.util.BusinessObjectContextUtil;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;

public class NoteReferenceHandler {
	private static final Graphic graphic = ConnectionBuilder.create().build();
	private static final Style style = StyleBuilder.create().build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) NoteReference bo) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		return new PaletteEntry[] { PaletteEntryBuilder.create().connectionCreation().label("Note Reference")
				.icon(ImageHelper.getImage("NoteReference"))
				.category(Categories.ANNOTATION).build() };
	}

	@CanStartConnection
	public boolean canStartConnection(@Named(Names.SOURCE_BO) final Note note) {
		return true;
	}

	@CanCreate
	public boolean canCreate(
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) DiagramElement sourceDiagramElement,
			final @Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) DiagramElement dst) {
		return !BusinessObjectContextUtil.isAncestor(dst, sourceDiagramElement);
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.SOURCE_BUSINESS_OBJECT_CONTEXT) DiagramElement sourceDiagramElement,
			final @Named(Names.DESTINATION_BUSINESS_OBJECT_CONTEXT) DiagramElement destinationDiagramElement) {
		return Operation.create(createOp -> {
			createOp.supply(() -> StepResultBuilder.create()
					.showNewBusinessObject(sourceDiagramElement, new NoteReference(destinationDiagramElement.getId()))
					.build());
		});
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration(
			final @Named(Names.BUSINESS_OBJECT_CONTEXT) BusinessObjectContext boc,
			final @Named(Names.BUSINESS_OBJECT) NoteReference noteReference, final AgeDiagramProvider diagramProvider) {
		// Require the note reference's parent to be a note. This prevents being able to paste a note reference into other objects.
		if (boc.getParent() == null || !(boc.getParent().getBusinessObject() instanceof Note)) {
			return null;
		}

		// Try to get the referenced element
		final DiagramElement referencedElement = diagramProvider.getAgeDiagram()
				.findElementById(noteReference.getReferencedDiagramElementId());
		if (referencedElement == null) {
			return null;
		}

		return GraphicalConfigurationBuilder.create().graphic(graphic)
				.source(boc.getParent())
				.destination(referencedElement).style(style).build();
	}
}
