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
