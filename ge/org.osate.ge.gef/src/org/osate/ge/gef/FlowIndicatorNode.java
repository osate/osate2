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
package org.osate.ge.gef;

import org.eclipse.gef.fx.anchors.IAnchor;
import org.eclipse.gef.fx.anchors.StaticAnchor;
import org.eclipse.gef.geometry.planar.Point;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.ObjectBinding;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

/**
 * Extension of {@link BaseConnectionNode} which is intended to represent a flow indicator. Allows setting the start
 * anchor. The end anchor of the connection is placed at the local origin. Flow indicators are positioned relative to
 * a positioning reference node. This is necessary to allow flow indicators to be positioned relative to the reference
 * node without being a child of the reference node. If the flow indicator is a child of the reference node then it
 * will affect its geometry bounds and may have a negative effect on chopbox anchors of the reference node.
 */
public class FlowIndicatorNode extends BaseConnectionNode {
	private StaticAnchor anchor = new StaticAnchor(this, new Point(0.0, 0.0));
	private Node positioningReference;

	/**
	 * Creates a new instance
	 */
	public FlowIndicatorNode() {
		setEndAnchor(anchor);
	}

	/**
	 * Returns the positioning reference or throws an exception. It is expected that the positioning reference will be set
	 * using {@link #setPositioningReference(Node)} shortly after creation. The translation of this node will be set such that the
	 * position using layoutX and layoutY of the node will be relative to the specified node.
	 * @return the node to which the position is relative.
	 */
	public Node getPositioningReferenceOrThrow() {
		if(positioningReference == null) {
			throw new AgeGefRuntimeException("Positioning reference not set");
		}

		return positioningReference;
	}

	public void setPositioningReference(final Node value) {
		this.positioningReference = value;

		// This assumes the parent of the node does not change
		final ObjectBinding<Point2D> translateBinding = new ObjectBinding<Point2D>() {
			{
				bind(value.localToSceneTransformProperty(), getParent().localToSceneTransformProperty());
			}

			@Override
			protected Point2D computeValue() {
				Transform referenceToScene;
				try {
					referenceToScene = positioningReference.localToSceneTransformProperty().get();
					final Transform sceneToParent = getParent().localToSceneTransformProperty().get().createInverse();
					final Transform referenceToLocal = sceneToParent.createConcatenation(referenceToScene);
					return referenceToLocal.transform(0, 0);
				} catch (NonInvertibleTransformException e) {
					throw new AgeGefRuntimeException("Unable to get inverse of local to scene transform", e);
				}
			}
		};

		this.translateXProperty().bind(new DoubleBinding() {
			{
				bind(translateBinding);
			}

			@Override
			protected double computeValue() {
				return translateBinding.get().getX();
			}
		});

		this.translateYProperty().bind(new DoubleBinding() {
			{
				bind(translateBinding);
			}

			@Override
			protected double computeValue() {
				return translateBinding.get().getY();
			}
		});
	}

	@Override
	public void setStartAnchor(final IAnchor anchor) {
		super.setStartAnchor(anchor);
	}
}
