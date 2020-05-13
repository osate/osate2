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

import java.util.Objects;
import java.util.stream.Stream;

import org.osate.ge.swt.ChangeEvent;
import org.osate.ge.swt.EventSource;

/**
 * Abstract decorator for {@link PrototypeBindingsModel}
 */
public abstract class PrototypeBindingsModelDecorator<N, D, T, C> implements PrototypeBindingsModel<N, D, T, C> {
	private final PrototypeBindingsModel<N, D, T, C> inner;

	/**
	 * Creates a new instance
	 * @param inner the model to decorate.
	 */
	public PrototypeBindingsModelDecorator(final PrototypeBindingsModel<N, D, T, C> inner) {
		this.inner = Objects.requireNonNull(inner, "inner must not be null");
	}

	@Override
	public EventSource<ChangeEvent> changed() {
		return inner.changed();
	}

	@Override
	public Stream<N> getChildren(final N parent) {
		return inner.getChildren(parent);
	}

	@Override
	public String getLabel(final N node) {
		return inner.getLabel(node);
	}

	@Override
	public String getValueLabel(final N node) {
		return inner.getValueLabel(node);
	}

	@Override
	public String getChildrenLabel(final N node) {
		return inner.getChildrenLabel(node);
	}

	@Override
	public Stream<D> getDirectionOptions(final N node) {
		return inner.getDirectionOptions(node);
	}

	@Override
	public String getDirectionLabel(final D direction) {
		return inner.getDirectionLabel(direction);
	}

	@Override
	public D getDirection(final N node) {
		return inner.getDirection(node);
	}

	@Override
	public void setDirection(final N node, final D value) {
		inner.setDirection(node, value);
	}

	@Override
	public Stream<T> getTypeOptions(final N node) {
		return inner.getTypeOptions(node);
	}

	@Override
	public String getTypeLabel(final T type) {
		return inner.getTypeLabel(type);
	}

	@Override
	public T getType(final N node) {
		return inner.getType(node);
	}

	@Override
	public void setType(final N node, final T value) {
		inner.setType(node, value);
	}

	@Override
	public Stream<C> getClassifierOptions(final N node) {
		return inner.getClassifierOptions(node);
	}

	@Override
	public String getClassifierLabel(final C classifier) {
		return inner.getClassifierLabel(classifier);
	}

	@Override
	public C getClassifier(final N node) {
		return inner.getClassifier(node);
	}

	@Override
	public void setClassifier(final N node, final C value) {
		inner.setClassifier(node, value);
	}

	@Override
	public String validateNode(final N node) {
		return inner.validateNode(node);
	}

	@Override
	public void flush() {
		inner.flush();
	}
}
