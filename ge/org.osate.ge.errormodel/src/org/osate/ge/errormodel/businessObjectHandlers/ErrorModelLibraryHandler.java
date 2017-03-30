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

import org.osate.ge.di.GetChildren;
import org.osate.ge.di.GetGraphic;
import org.osate.ge.di.IsApplicable;
import org.osate.ge.errormodel.model.ErrorTypeExtension;
import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.RectangleBuilder;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

// ErrorModelLibraries should not be graphically represented? It's children should belong to the parent?
public class ErrorModelLibraryHandler {	
	private static final Graphic graphic = RectangleBuilder.create().build();
	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return true;
	}
	
	@GetGraphic
	public Graphic getGraphicalRepresentation() {
		return graphic;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		// TODO: Type extensions should be children to the sub type?
		return Stream.concat(lib.getTypes().stream(), 
				lib.getTypes().stream(). // Error Type Extensions
					filter((et) -> et.getSuperType() != null).
					map((et) -> new ErrorTypeExtension(et.getSuperType(), et)));
	}
}
