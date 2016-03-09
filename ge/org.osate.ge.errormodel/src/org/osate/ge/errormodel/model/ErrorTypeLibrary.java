package org.osate.ge.errormodel.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.ext.ReferenceEObjectProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorTypeLibrary implements ReferenceEObjectProvider {
	private final ErrorModelLibrary errorModelLib;
	
	public ErrorTypeLibrary(final ErrorModelLibrary errorModelLib) {
		this.errorModelLib = Objects.requireNonNull(errorModelLib, "errorModelLib must not be null");
	}
	
	public final ErrorModelLibrary getErrorModelLibrary() {
		return errorModelLib;
	}

	@Override
	public EObject getRefereneEObject() {
		return errorModelLib;
	}
}
