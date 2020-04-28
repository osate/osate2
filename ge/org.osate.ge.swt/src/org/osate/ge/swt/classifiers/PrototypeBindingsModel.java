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
package org.osate.ge.swt.classifiers;

import java.util.stream.Stream;

import org.osate.ge.swt.ObservableModel;

/**
 * Model for editing a tree of nodes which each may have a direction, a type, and a classifier. Intended for selecting and editing prototype binding and classifier references.
 *
 * It is critical that values set using this model not automatically change or clear other values. Furthermore it is critical that children returned are consistent.
 * For example if the classifier is changed and then reverted, the values returned by the model should be the same. This functionality is required to allow users of the model
 * to revert changes by tracking values before setting them.
 *
 * @param <N> is the type of the nodes.
 * @param <D> is the type of the direction options.
 * @param <T> is the type of the type options.
 * @param <C> is the type of the classifiers.
 */
public interface PrototypeBindingsModel<N, D, T, C> extends ObservableModel {
	/**
	 * Returns a stream of child nodes for the specified node.
	 * @param parent is the node for which to return the children. If null, returns the children for the root.
	 * @return is a stream of nodes.
	 */
	Stream<N> getChildren(N parent);

	/**
	 * Returns a string that can be shown to the user to identify the node.
	 * @param node is the node for which to return the label.
	 * @return the label for the node. Must not return null.
	 */
	String getLabel(N node);

	/**
	 * Returns a string that can be shown to the user to describe the value of the node. This will generally contain the labels for the classifier, direction, type, and children.
	 * @param node is the node for which to return the value label.
	 * @return the value label for the node. Must not return null.
	 */
	String getValueLabel(N node);

	/**
	 * Returns a string that can be shown to the user to describe the children of the node. This will generally contain the name and value labels for the subset of children which
	 * have values that can be displayed.
	 * @param node is the node for which to return the children label.
	 * @return the label for the children. Must not be null.
	 */
	String getChildrenLabel(N node);

	/**
	 * Returns values which may be set as the direction of the specified node.
	 * @param node is the node for which to return potential direction values.
	 * @return directions which may be set for the specified node.
	 */
	Stream<D> getDirectionOptions(N node);

	/**
	 * Returns a string that can be shown to the user to represent a direction.
	 * @param direction is the direction for which to return the label.
	 * @return the label for the direction. Must not return null.
	 */
	String getDirectionLabel(D direction);

	/**
	 * Returns the direction of the specified node.
	 * @param node the node for which to return the direction.
	 * @return the node's direction. Returns null if the value is unavailable or the value is not set.
	 */
	D getDirection(N node);

	/**
	 * Sets the direction of the specified node.
	 * @param node is the node for which to set the direction.
	 * @param value the new direction for the node.
	 */
	void setDirection(N node, D value);

	/**
	 * Returns values which may be set as the type of the specified node.
	 * @param node is the node for which to return potential type values.
	 * @return types which may be set for the specified node.
	 */
	Stream<T> getTypeOptions(N node);

	/**
	 * Returns a string that can be shown to the user to represent a type.
	 * @param type is the type for which to return the label.
	 * @return the label for the type. Must not return null.
	 */
	String getTypeLabel(T type);

	/**
	 * Returns the type of the specified node.
	 * @param node the node for which to return the type.
	 * @return the node's type. Returns null if the value is unavailable or the value is not set.
	 */
	T getType(N node);

	/**
	 * Sets the type of the specified node.
	 * @param node is the node for which to set the type.
	 * @param value the new type for the node.
	 */
	void setType(N node, T value);

	/**
	 * Returns values which may be set as the classifier of the specified node.
	 * @param node is the node for which to return potential classifier values.
	 * @return classifiers which may be set for the specified node.
	 */
	Stream<C> getClassifierOptions(N node);

	/**
	 * Returns a string that can be shown to the user to represent a classifier.
	 * @param classifier is the classifier for which to return the label.
	 * @return the label for the classifier. Must not return null.
	 */
	String getClassifierLabel(C classifier);

	/**
	 * Returns the classifier of the specified node.
	 * @param node the node for which to return the classifier.
	 * @return the node's classifier. Returns null if the value is unavailable or the value is not set.
	 */
	C getClassifier(N node);

	/**
	 * Sets the classifier of the specified node.
	 * @param node is the node for which to set the classifier.
	 * @param value the new classifier for the node.
	 */
	void setClassifier(N node, C value);

	/**
	 * Validates the value of a node. Returns an error message if an error is detected.
	 * @param node is the node to validate.
	 * @return an error message if validation failed. Otherwise, null.
	 */
	String validateNode(N node);

	/**
	 * Requests that changes be flushed to the underlying model.
	 * The model is not required to wait until this method is called but may wait to allow batching modifications.
	 * This method must be called to ensure changes are committed to the underlying model.
	 */
	void flush();
}
