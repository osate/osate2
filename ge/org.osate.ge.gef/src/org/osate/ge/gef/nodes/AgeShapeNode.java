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
package org.osate.ge.gef.nodes;

import org.eclipse.gef.fx.nodes.Connection;
import org.osate.ge.fx.BusNode;

import javafx.beans.value.ChangeListener;
import javafx.geometry.BoundingBox;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

// TODO
public class AgeShapeNode extends Region {
	private final Region shape = new BusNode(); // TODO: Rework
	private final Label label;
	private double shapeWidth = -1;
	private double shapeHeight = -1;
	// TODO: Use group to manage child features?
	// private final Pane childContainer = new Pane();

	public AgeShapeNode() {
		shape.setManaged(false);

		// Label experiment
		label = new Label("GEF5 Test");
		label.setLayoutX(-50);
		label.setManaged(false);

		getChildren().addAll(shape, label);

		// TODO: How to remove listener.
		// TODO: Could use invalidation listener?
		layoutBoundsProperty().addListener((ChangeListener<Bounds>) (observable, oldValue, newValue) -> {
			if (newValue.getWidth() > 2 && newValue.getHeight() > 2) {
				shape.resize(newValue.getWidth(), newValue.getHeight());
			}
		});
	}

	// TODO: Rename. Not a shape. Shouldn't be exposed?
	public Region getInnerShape() {
		return shape;
	}

	@Override
	protected void layoutChildren() {
		// //we directly layout our children from within resize
		// Size the label
		label.resize(label.prefWidth(-1), label.prefHeight(-1));
		super.layoutChildren();

		// TODO: Get bounds in parent is including unmanaged shapes such as the label...
		// TODO: Instead of using localToParent, just add translation and layout offset manually? This will introduce scaling which is
		// typically not done as part of layout? Could just document. Shouldn't cause problems.
		double minX = 0;
		double minY = 0;
		for (final Node child : getChildren()) {
			if (child.isManaged()) {
				// TODO: Need to determine the proper way to do this. The idea is to get the bounds of the shape before the layout
				// X and Y translation has been added. This will allow the shape shrink based on it's preferred size.
				final Bounds layoutBoundsInParentFinal = child.localToParent(child.getLayoutBounds());
				final double offsetX = child.getLayoutX();
				final double offsetY = child.getLayoutY();
				final Bounds layoutBoundsInParent = new BoundingBox(layoutBoundsInParentFinal.getMinX() - offsetX,
						layoutBoundsInParentFinal.getMinY() - offsetY, layoutBoundsInParentFinal.getWidth(),
						layoutBoundsInParentFinal.getHeight());
				minX = Math.min(minX, layoutBoundsInParent.getMinX());
				minY = Math.min(minY, layoutBoundsInParent.getMinY());
			}
		}

		if (minX < 0 || minY < 0) {
			for (final Node child : getChildren()) {
				// TODO: Assume connections will be marked as unmanaged
				if (child.isManaged()) {
					child.setLayoutX(-minX);
					child.setLayoutY(-minY);
				}
			}
		}

		// TODO: Appropriate/Necessary?
		requestLayout();

		// getParent().requestLayout();
		// TODO: When to request layout?

		// TODO: Position and size other children

		// TODO: Position and size label

		// shape.setLayoutX(0);
		// shape.setPrefWidth(200); // TODO: How should this work?
		// shape.setPrefWidth(value);

		// super.layoutChildren();

		// this.getLay

		// TODO: Use translateX and Y to handle negative coordinates from children? Would message up feature groups?
		// TODO: In any case, decide how to handle

	};

	// TODO: Why use getBoundsInParent() for some things and getLayoutBounds()
	// TODO: getBoundsInParent includes unmanaged
	// TODO: Will be needed when nested?
	@Override
	protected double computePrefWidth(final double height) {
		double w = 100; // TODO
		for (final Node child : getChildren()) {
			// TODO: Connections should be unmanaged?
			if (child.isManaged() && !(child instanceof Connection) && child != shape) {
				w = Math.max(w, child.getBoundsInParent().getMaxX());
			}
		}

		w = Math.max(w, shapeWidth);

		return w;
	}

	@Override
	protected double computePrefHeight(final double width) {
		double h = 100; // TODO
		for (final Node child : getChildren()) {
			// TODO: Connections should be unmanaged?
			if (child.isManaged() && !(child instanceof Connection) && child != shape) {
				h = Math.max(h, child.getBoundsInParent().getMaxY());
			}
		}

		h = Math.max(h, shapeHeight);

		return h;
	}

	// TODO: Change behavior. Should just be getChildren() but we inherit from Group
	public void addInnerChild(final Node child) {
		/* childContainer. */getChildren().add(child);
	}

	public void removeInnerChild(final Node child) {
		/* childContainer. */getChildren().remove(child);
	}

	// Sets the preferred size of the shape. The actual size may be different depending on children.
	public final void setPreferredShapeSize(final double width, final double height) {
		shapeWidth = width;
		shapeHeight = height;

		requestLayout();
	}
}
