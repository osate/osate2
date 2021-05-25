/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.gef.ui.editor;

import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorPart;
import org.osate.ge.internal.ui.editor.ComboContributionItem;

import javafx.beans.value.ChangeListener;

/**
 * Contribution item for selecting the zoom level
 */
public class ZoomSelectorContributionItem extends ComboContributionItem {
	private final ChangeListener<Number> zoomListener = (observable, oldValue, newValue) -> {
		updateSelection();
	};

	private AgeEditor editor;

	public ZoomSelectorContributionItem() {
		super(null);
	}

	@Override
	public void dispose() {
		if (editor != null) {
			editor.zoomProperty().removeListener(zoomListener);
		}

		super.dispose();
	}

	@Override
	protected Control createControl(final Composite parent) {
		final Control result = super.createControl(parent);
		setControlEnabled(editor != null);

		final ComboViewer comboViewer = getComboViewer();
		if (comboViewer != null) {
			comboViewer.setLabelProvider(new LabelProvider() {
				@Override
				public String getText(final Object element) {
					final double value = (double) element;
					return ((int) (value * 100)) + "%";
				}
			});

			comboViewer.setInput(AgeEditor.ZOOM_LEVELS);
			updateSelection();
		}

		return result;

	}

	public final void setActiveEditor(final IEditorPart newEditor) {
		if (editor != newEditor) {
			setControlEnabled(newEditor != null);
			if (editor != null) {
				editor.zoomProperty().removeListener(zoomListener);
			}

			if (newEditor instanceof AgeEditor) {
				editor = (AgeEditor) newEditor;
				editor.zoomProperty().addListener(zoomListener);
			} else {
				editor = null;
			}
			updateSelection();
		}
	}

	private void updateSelection() {
		final ComboViewer comboViewer = getComboViewer();
		if (comboViewer == null || editor == null) {
			return;
		}

		// Update the selection
		comboViewer.setSelection(new StructuredSelection(editor.getZoom()));
	}

	@Override
	protected void onSelection(final Object value) {
		if (editor != null) {
			editor.setZoom((double) value);
		}
	}
}
