/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.swt.classifiers;

import java.util.Objects;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.osate.ge.swt.BorderedCLabel;
import org.osate.ge.swt.SwtUtil;

/**
 * View for editing prototype bindings
 *
 * @param <N> is the type of the nodes provided by the model.
 * @param <D> is the type of the direction options.
 * @param <T> is the type of the type options.
 * @param <C> is the type of the classifiers.
 * @since 1.1
 */
public class PrototypeBindingsEditor<N, D, T, C> extends Composite {
	private final PrototypeBindingsModel<N, D, T, C> model;
	private final N parentNode;
	private final Runnable changeListener = this::refresh;

	/**
	 * Create a new instance
	 * @param parent the widget which is the parent of the editor. Must not be null.
	 * @param model the model which provides the contents for the editor
	 * @param parentNode the node whose children are being edited by this editor.
	 */
	public PrototypeBindingsEditor(final Composite parent, final PrototypeBindingsModel<N, D, T, C> model,
			N parentNode) {
		super(parent, SWT.NONE);
		this.model = Objects.requireNonNull(model, "model must not be null");
		this.parentNode = parentNode;
		SwtUtil.setColorsToMatchParent(this);
		this.setLayout(GridLayoutFactory.swtDefaults().numColumns(2).create());
		model.changed().addListener(changeListener);
		refresh();
	}

	private void refresh() {
		if (!this.isDisposed()) {
			final Control[] children = this.getChildren();
			int nextChildIndex = 0;
			for (N b : (Iterable<N>) model.getChildren(parentNode)::iterator) {
				// Label
				final BorderedCLabel label = children.length > nextChildIndex
						? (BorderedCLabel) children[nextChildIndex]
						: new BorderedCLabel(this);
				SwtUtil.setColorsToMatchParent(label);
				label.setText(model.getLabel(b));
				label.setLayoutData(
						GridDataFactory.swtDefaults().grab(false, false).align(SWT.FILL, SWT.CENTER).create());
				nextChildIndex++;

				// Component for editing the "value" for the binding.
				@SuppressWarnings("unchecked")
				final PrototypeBindingActualEditor<N, D, T, C> bindingActualEditor = children.length > nextChildIndex
						? (PrototypeBindingActualEditor<N, D, T, C>) children[nextChildIndex]
						: new PrototypeBindingActualEditor<>(this, model, b);
				bindingActualEditor.setNode(b);
				bindingActualEditor.setLayoutData(
						GridDataFactory.swtDefaults().grab(true, false).align(SWT.FILL, SWT.CENTER).create());
				nextChildIndex++;
			}

			// Remove other children
			for (int i = nextChildIndex; i < children.length; i++) {
				children[i].dispose();
			}

			requestLayout();
		}
	}

	/**
	 * Entry point for an interactive test application.
	 * @param args command line arguments
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public static void main(String[] args) {
		SwtUtil.run(shell -> new PrototypeBindingsEditor<>(shell, new TestPrototypeBindingsModel(), null));
	}
}
