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
public class BusinessObjectSelectionFeatureDirectionModel extends BaseObservableModel
implements SelectorModel<DirectionType> {
	private BusinessObjectSelection bos;
	private DirectionType direction = null;
	private boolean enabled = false;

	public BusinessObjectSelectionFeatureDirectionModel(final BusinessObjectSelection bos) {
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
	 * Refreshes the internal state of the model based on the specified busienss object selection
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