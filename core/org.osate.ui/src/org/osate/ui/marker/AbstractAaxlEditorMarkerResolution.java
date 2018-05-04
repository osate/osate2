package org.osate.ui.marker;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.command.Command;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.views.markers.WorkbenchMarkerResolution;
import org.osate.aadl2.Element;
import org.osate.ui.UiUtil;

/**
 * An abstract marker resolution implementation for AADL object models that
 * makes sure the resolution is performed as an command in the AAXL editor. The
 * resolution is parameterized by the abstract {@link #getTarget()} method by an
 * AObject that is the object to be acted upon. This object is used to determine
 * which EMF Resource should be opened in the editor. The editor is opened if it
 * is not already open, and the editor is made the front and active editor.
 *
 * @author aarong
 *
 */
public abstract class AbstractAaxlEditorMarkerResolution extends WorkbenchMarkerResolution {
	protected final IMarker origMarker;

	protected AbstractAaxlEditorMarkerResolution(final IMarker m) {
		origMarker = m;
	}

	/**
	 * Executes the resolution by executing the command returned by
	 * {@link #getCommand(IMarker)} in the editor opened on the Resource
	 * containing the object returned by {@link #getTarget()}. The method
	 * {@link #getTarget(IMarker)} is always called before the method
	 * {@link #getCommand(IMarker)}.
	 *
	 * @see UiUtil#openEditorAndExecute(Element, Command)
	 */
	@Override
	public final void run(final IMarker marker) {
		UiUtil.openEditorAndExecute(getTarget(marker), getCommand(marker));
	}

	/**
	 * Find the other markers that are fixable by this resolution.  Tests
	 * individual markers by calling the method {@link #testMarker(IMarker)}.
	 */
	@Override
	public final IMarker[] findOtherMarkers(final IMarker[] markers) {
		final List markersList = new ArrayList(markers.length);
		for (int i = 0; i < markers.length; i++) {
			final IMarker marker = markers[i];
			if (marker != origMarker && testMarker(marker)) {
				markersList.add(marker);
			}
		}
		final IMarker[] result = new IMarker[markersList.size()];
		return (IMarker[]) markersList.toArray(result);
	}

	/**
	 * Test whether the given marker is fixable by this resolution. This default
	 * implementation always returns <code>false</code>.
	 *
	 * @param marker
	 *            The marker to test
	 * @return Whether this resolution can be applied to the given marker.
	 */
	protected boolean testMarker(final IMarker marker) {
		return false;
	}

	/**
	 * No description by default.
	 * @return <code>null</code>
	 */
	@Override
	public String getDescription() {
		return null;
	}

	/**
	 * Returns no image by default.
	 * @return <code>null</code>.
	 */
	@Override
	public Image getImage() {
		return null;
	}

	/**
	 * Get the model object that determines which EMF Resource is opened to
	 * perform the command. Guaranteed to always be executed before
	 * {@link #getCommand(IMarker)}.
	 *
	 * @param marker
	 *            The marker being resolved.
	 */
	protected abstract Element getTarget(IMarker marker);

	/**
	 * Get the command to execute to perform the marker resolution. The target
	 * object is available through the field {@link #targetObject}.  Will
	 * always be executed <em>after</em> {link {@link #getTarget(IMarker)}}.
	 *
	 * @param marker
	 *            The marker being resolved.
	 */
	protected abstract Command getCommand(IMarker marker);
}
