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
import org.osate.ge.di.IsApplicable;
import org.osate.ge.errormodel.model.ErrorTypeLibrary;
import org.osate.ge.di.Names;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorModelLibraryHandler {	
	@IsApplicable
	public boolean isApplicable(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return true;
	}
	
	@GetChildren
	public Stream<?> getChildren(final @Named(Names.BUSINESS_OBJECT) ErrorModelLibrary lib) {
		return Stream.concat(Stream.of(new ErrorTypeLibrary(lib)), lib.getBehaviors().stream());
	}
}
