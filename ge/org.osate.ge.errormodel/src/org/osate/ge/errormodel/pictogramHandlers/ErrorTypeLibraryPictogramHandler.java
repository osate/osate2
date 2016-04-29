/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.pictogramHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.ge.Graphic;
import org.osate.ge.GraphicFactory;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphicalRepresentation;
import org.osate.ge.di.GetName;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.di.Names;
import org.osate.ge.services.GraphicalEditorService;

public class ErrorTypeLibraryPictogramHandler {
	private static final Graphic graphic = GraphicFactory.createRectangle();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return true;
	}
	
	@GetChildren
	public Stream<Object> getChildren(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		// TODO: Also ensure that super type is added to diagram if it is part of another error type library?
		
		return Stream.concat(typeLib.getErrorModelLibrary().getTypes().stream(), 
				typeLib.getErrorModelLibrary().getTypes().stream(). // Error Type Extensions
					filter((et) -> et.getSuperType() != null).
					map((et) -> new ErrorTypeExtension(et.getSuperType(), et)));
	}

	@GetGraphicalRepresentation
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib, final GraphicalEditorService editorService) {
		editorService.openBusinessObject(typeLib);
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return "Error Type Library";
	}
}
