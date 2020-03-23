package org.osate.ge.internal.ui.modelControllers;

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
import org.osate.ge.swt.direction.Direction;
import org.osate.ge.swt.direction.DirectionEditorModel;

/**
 * Direction model controller implementation which is driven by a business object selection
 *
 */
public class BusinessObjectSelectionDirectionModelController extends BaseObservableModel
implements DirectionEditorModel {
	private BusinessObjectSelection bos;
	private Direction direction = null;
	private boolean enabled = false;

	public BusinessObjectSelectionDirectionModelController(final BusinessObjectSelection bos) {
		setBusinessObjectSelection(bos);
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public Direction getDirection() {
		return direction;
	}

	@Override
	public void setDirection(Direction value) {
		if (direction != value) {
			// Modify the AADL model
			bos.modify(DirectedFeature.class, feature -> {
				if (feature instanceof AbstractFeature || feature instanceof FeatureGroup) {
					feature.setIn(value == Direction.IN);
					feature.setOut(value == Direction.OUT);
				} else {
					feature.setIn(value == Direction.IN_OUT || value == Direction.IN);
					feature.setOut(value == Direction.IN_OUT || value == Direction.OUT);
				}
			});
		}
	}

	/**
	 * Refreshes the internal state of the model based on the specified busienss object selection
	 */
	public void setBusinessObjectSelection(final BusinessObjectSelection value) {
		this.bos = Objects.requireNonNull(value, "value must not be null");

		// Update state
		final Direction newDirection = getDirectionFromFeatures(bos.boStream(DirectedFeature.class));
		final boolean newEnabled = newDirection != null || bos.boStream(DirectedFeature.class).findAny().isPresent();
		final boolean changed = direction != newDirection || enabled != newEnabled;
		if (changed) {
			this.enabled = newEnabled;
			this.direction = newDirection;
			triggerChangeEvent();
		}
	}

	private static Direction getDirectionFromFeatures(final Stream<DirectedFeature> features) {
		final List<Direction> directions = features.map(f -> directionTypeToDirection(f.getDirection())).distinct()
				.limit(2)
				.collect(Collectors.toList());
		return directions.size() == 1 ? directions.get(0) : null;
	}

	private static Direction directionTypeToDirection(final DirectionType dt) {
		if (dt == null) {
			return null;
		}

		switch (dt) {
		case IN:
			return Direction.IN;

		case IN_OUT:
			return Direction.IN_OUT;

		case OUT:
			return Direction.OUT;

		default:
			throw new RuntimeException("Unexpected DirectionType: " + dt);

		}
	}
}