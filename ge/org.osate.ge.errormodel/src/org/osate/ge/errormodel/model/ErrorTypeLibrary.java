package org.osate.ge.errormodel.model;

import java.util.Objects;

import org.eclipse.emf.ecore.EObject;
import org.osate.ge.EmfContainerProvider;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;

public class ErrorTypeLibrary implements EmfContainerProvider {
	private final ErrorModelLibrary errorModelLib;

	public ErrorTypeLibrary(final ErrorModelLibrary errorModelLib) {
		this.errorModelLib = Objects.requireNonNull(errorModelLib, "errorModelLib must not be null");
	}

	public final ErrorModelLibrary getErrorModelLibrary() {
		return errorModelLib;
	}

	@Override
	public EObject getEmfContainer() {
		return errorModelLib;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((errorModelLib == null) ? 0 : errorModelLib.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ErrorTypeLibrary other = (ErrorTypeLibrary) obj;
		if (errorModelLib == null) {
			if (other.errorModelLib != null) {
				return false;
			}
		} else if (!errorModelLib.equals(other.errorModelLib)) {
			return false;
		}
		return true;
	}
}
