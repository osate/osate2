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

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.transform.NonInvertibleTransformException;
import javafx.scene.transform.Transform;

/**
 * Node intended to be used as the root of a diagram. Sizes children to preferred size and positions the nodes based on {@link PreferredPosition}
 */
public class DiagramRootNode extends Group {
	private final ReadOnlyObjectWrapper<Transform> sceneToLocalTransform = new ReadOnlyObjectWrapper<Transform>();

	public DiagramRootNode() {
		sceneToLocalTransform.bind(new ObjectBinding<Transform>() {
			{
				bind(localToSceneTransformProperty());
			}

			@Override
			protected Transform computeValue() {
				try {
					return getLocalToSceneTransform().createInverse();
				} catch (NonInvertibleTransformException e) {
					throw new AgeGefRuntimeException("Unable to create scene to localtransform");
				}
			}
		});
	}

	/**
	 * The transform between the scene and local coordinate system.
	 * @return the property for the transform between the scene and local coordinate system.
	 */
	public ReadOnlyObjectProperty<Transform> sceneToLocalTransform() {
		return sceneToLocalTransform.getReadOnlyProperty();
	}

	/**
	 * Returns the current value of {@link #sceneToLocalTransform()}
	 * @return the current value of {@link #sceneToLocalTransform()}
	 */
	public Transform getSceneToLocalTransform() {
		return sceneToLocalTransform().get();
	}

	@Override
	protected void layoutChildren() {
		// Position and size children
		for (final Node child : getChildren()) {
			if (child.isManaged()) {
				final Point2D position = getPreferredPositionOrDefault(child);
				child.setLayoutX(position.getX());
				child.setLayoutY(position.getY());

				if (child.isResizable()) {
					child.autosize();
				}
			}
		}
	}

	private Point2D getPreferredPositionOrDefault(final Node child) {
		final Point2D prefPosition = PreferredPosition.get(child);
		return prefPosition == null ? Point2D.ZERO : prefPosition;
	}
}
