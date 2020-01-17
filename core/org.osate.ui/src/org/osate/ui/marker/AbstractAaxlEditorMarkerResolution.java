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
