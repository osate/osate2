/*******************************************************************************
 * Copyright (C) 2016 University of Alabama in Huntsville (UAH)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * The US Government has unlimited rights in this work in accordance with W31P4Q-10-D-0092 DO 0105.
 *******************************************************************************/
package org.osate.ge.errormodel.businessObjectHandlers;

import java.util.stream.Stream;

import javax.inject.Named;

import org.osate.aadl2.NamedElement;
import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetDiagramName;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.GetName;
import org.osate.ge.di.HandleDoubleClick;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.di.Names;
import org.osate.ge.services.GraphicalEditorService;

public class ErrorTypeLibraryHandler {
	private static final Graphic graphic = RectangleBuilder.create().build();
	
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

	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@HandleDoubleClick
	public void onDoubleclick(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib, final GraphicalEditorService editorService) {
		editorService.openBusinessObject(typeLib);
	}

	@GetDiagramName
	public String getTitle(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		final NamedElement elementRoot = typeLib.getErrorModelLibrary().getElementRoot();
		final String packageName = elementRoot == null ? "" : elementRoot.getQualifiedName();
		return packageName + " : Error Type Library";
	}
	
	@GetName
	public String getName(final @Named(Names.BUSINESS_OBJECT) ErrorTypeLibrary typeLib) {
		return "Error Type Library";
	}
}
