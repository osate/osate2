package org.osate.ge.internal.businessObjectHandlers;

import java.util.UUID;

import javax.inject.Named;

import org.osate.ge.BusinessObjectContext;
import org.osate.ge.Categories;
import org.osate.ge.GraphicalConfiguration;
import org.osate.ge.PaletteEntry;
import org.osate.ge.PaletteEntryBuilder;
import org.osate.ge.di.BuildCreateOperation;
import org.osate.ge.di.CanCreate;
import org.osate.ge.di.CanDelete;
import org.osate.ge.di.GetGraphicalConfiguration;
import org.osate.ge.di.GetName;
import org.osate.ge.di.GetPaletteEntries;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.di.Names;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.InternalGraphicalConfigurationBuilder;
import org.osate.ge.graphics.internal.NoteGraphicBuilder;
import org.osate.ge.internal.model.Note;
import org.osate.ge.internal.util.ImageHelper;
import org.osate.ge.operations.Operation;
import org.osate.ge.operations.StepResultBuilder;

public class NoteHandler {
	private final Graphic graphic = NoteGraphicBuilder.create().build();

	@IsApplicable
	@CanDelete
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) Note bo) {
		return true;
	}

	@GetPaletteEntries
	public PaletteEntry[] getPaletteEntries(final @Named(Names.DIAGRAM_BO) Object diagramBo) {
		return new PaletteEntry[] { PaletteEntryBuilder.create().label("Note")
				.icon(ImageHelper.getImage("Note"))
				.category(Categories.ANNOTATION).build() };
	}

	@CanCreate
	public boolean canCreate(final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc) {
		return !(targetBoc.getBusinessObject() instanceof Note);
	}

	@BuildCreateOperation
	public Operation buildCreateOperation(
			final @Named(Names.TARGET_BUSINESS_OBJECT_CONTEXT) BusinessObjectContext targetBoc) {
		return Operation.create(createOp -> {
			createOp.supply(() -> StepResultBuilder.create()
					.showNewBusinessObject(targetBoc, new Note(UUID.randomUUID())).build());
		});
	}

	@GetGraphicalConfiguration
	public GraphicalConfiguration getGraphicalConfiguration() {
		return InternalGraphicalConfigurationBuilder.create().primaryLabelIsMultiline(true).graphic(graphic)
				.style(StyleBuilder
						.create(Style.EMPTY)
						.labelsLeft().labelsTop().build())
				.build();
	}


	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) Note note) {
		return note.getText().trim();
	}
}
