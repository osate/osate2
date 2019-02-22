package org.osate.analysis.architecture.unusedclassifiers;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;

public final class UnusedClassifierMarkerResolutionGenerator implements IMarkerResolutionGenerator2 {
	private static final IMarkerResolution[] RESOLVERS = { new UnusedClassifierMarkerResolution() };
	private static final IMarkerResolution[] EMPTY = new IMarkerResolution[0];

	public UnusedClassifierMarkerResolutionGenerator() {
		super();
	}

	@Override
	public IMarkerResolution[] getResolutions(final IMarker marker) {
		try {
			if (marker.getType().equals(FindUnusedClassifiersAnalysis.MARKER_TYPE)) {
				return RESOLVERS;
			}
		} catch (final CoreException e) {
			// fall through and return false below
		}
		return EMPTY;
	}

	@Override
	public boolean hasResolutions(final IMarker marker) {
		try {
			if (marker.getType().equals(FindUnusedClassifiersAnalysis.MARKER_TYPE)) {
				return true;
			}
		} catch (final CoreException e) {
			// fall through and return false below
		}
		return false;
	}

}
