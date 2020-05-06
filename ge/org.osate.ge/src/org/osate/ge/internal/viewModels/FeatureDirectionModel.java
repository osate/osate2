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
package org.osate.ge.internal.viewModels;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.osate.aadl2.AbstractFeature;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.FeatureGroup;
import org.osate.ge.BusinessObjectSelection;
import org.osate.ge.swt.BaseObservableModel;
import org.osate.ge.swt.selectors.SelectorModel;

/**
 * Model implementation which is driven by a business object selection
 *
 */
public class FeatureDirectionModel extends BaseObservableModel
implements SelectorModel<DirectionType> {
	private BusinessObjectSelection bos;
	private DirectionType direction = null;
	private boolean enabled = false;

	public FeatureDirectionModel(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public Stream<DirectionType> getElements() {
		return Stream.of(DirectionType.values());
	}

	@Override
	public DirectionType getSelectedElement() {
		return direction;
	}

	@Override
	public void setSelectedElement(DirectionType value) {
		if (direction != value) {
			// Modify the AADL model
			bos.modify(DirectedFeature.class, feature -> {
				if (feature instanceof AbstractFeature || feature instanceof FeatureGroup) {
					feature.setIn(value == DirectionType.IN);
					feature.setOut(value == DirectionType.OUT);
				} else {
					feature.setIn(value == DirectionType.IN_OUT || value == DirectionType.IN);
					feature.setOut(value == DirectionType.IN_OUT || value == DirectionType.OUT);
				}
			});
		}
	}

	@Override
	public String getLabel(DirectionType element) {
		switch (element) {
		case IN:
			return "Input";
		case OUT:
			return "Output";
		case IN_OUT:
			return "Bidirectional";
		default:
			return element.toString();

		}
	}

	/**
	 * Refreshes the internal state of the model based on the specified business object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		// Update state
		final DirectionType newDirection = getDirectionTypeFromFeatures(bos.boStream(DirectedFeature.class));
		final boolean newEnabled = newDirection != null || bos.boStream(DirectedFeature.class).findAny().isPresent();
		final boolean changed = direction != newDirection || enabled != newEnabled;
		if (changed) {
			this.enabled = newEnabled;
			this.direction = newDirection;
			triggerChangeEvent();
		}
	}

	private static DirectionType getDirectionTypeFromFeatures(final Stream<DirectedFeature> features) {
		final List<DirectionType> directions = features.map(f -> f.getDirection()).distinct().limit(2)
				.collect(Collectors.toList());
		return directions.size() == 1 ? directions.get(0) : null;
	}
}