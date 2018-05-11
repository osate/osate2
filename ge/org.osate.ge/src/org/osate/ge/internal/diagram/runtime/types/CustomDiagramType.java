package org.osate.ge.internal.diagram.runtime.types;

import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.ge.DiagramType;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;

/**
 * Diagram type that includes minimal contents.
 *
 */
public class CustomDiagramType implements DiagramType {
	public static final String ID = "custom";

	@Override
	public String getId() {
		return ID;
	}

	@Override
	public String getName() {
		return "Custom Diagram";
	}

	@Override
	public boolean isApplicableToContext(final Object contextBo) {
		return contextBo == null || contextBo instanceof AadlPackage || contextBo instanceof Classifier
				|| contextBo instanceof SystemInstance;
	}

	@Override
	public ImmutableSet<String> getDefaultContentFilters(final Object bo) {
		return DiagramTypeUtil.getDefaultContentFilters(bo);
	}

	@Override
	public ImmutableCollection<String> getDefaultAadlPropertyNames() {
		return ImmutableSet.of();
	}

	@Override
	public boolean isUserCreatable() {
		return false;
	}
}
