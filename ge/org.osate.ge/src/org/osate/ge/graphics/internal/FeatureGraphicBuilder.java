package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Builder for creating feature graphics.
 * @noextend
 * @see Graphic
 */
public class FeatureGraphicBuilder {
	private Direction direction = Direction.IN_OUT;
	private FeatureGraphicType featureType = FeatureGraphicType.ABSTRACT;

	private FeatureGraphicBuilder() {}

	/**
	 * Creates a port graphic builder.
	 * @return a port graphic builder
	 */
	public static FeatureGraphicBuilder create() {
		return new FeatureGraphicBuilder();
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder abstractFeature() {
		this.featureType = FeatureGraphicType.ABSTRACT;
		return this;
	}

	/**
	 * Sets the type of port graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder eventPort() {
		this.featureType = FeatureGraphicType.EVENT_PORT;
		return this;
	}

	/**
	 * Sets the type of port graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder dataPort() {
		this.featureType = FeatureGraphicType.DATA_PORT;
		return this;
	}

	/**
	 * Sets the type of port graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder eventDataPort() {
		this.featureType = FeatureGraphicType.EVENT_DATA_PORT;
		return this;
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder subprogramAccess() {
		this.featureType = FeatureGraphicType.SUBPROGRAM_ACCESS;
		return this;
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder subprogramGroupAccess() {
		this.featureType = FeatureGraphicType.SUBPROGRAM_GROUP_ACCESS;
		return this;
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder dataAccess() {
		this.featureType = FeatureGraphicType.BUS_OR_DATA_ACCESS;
		return this;
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder busAccess() {
		this.featureType = FeatureGraphicType.BUS_OR_DATA_ACCESS;
		return this;
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder featureGroup() {
		this.featureType = FeatureGraphicType.FEATURE_GROUP;
		return this;
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder portProxy() {
		return abstractFeature();
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder eventSource() {
		return eventPort();
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder eventDataSource() {
		return eventDataPort();
	}

	/**
	 * Sets the type of feature graphic to create.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder subprogramProxy() {
		return subprogramAccess();
	}

	/**
	 * Sets the builder to build an input port.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder input() {
		this.direction = Direction.IN;
		return this;
	}

	/**
	 * Sets the builder to build an output port.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder output() {
		this.direction = Direction.OUT;
		return this;
	}

	/**
	 * Sets the builder to build a bidirectional port.
	 * @return this builder to allow method chaining.
	 */
	public FeatureGraphicBuilder bidirectional() {
		this.direction = Direction.IN_OUT;
		return this;
	}

	/**
	 * Creates a port graphic based on the current state of the builder.
	 * @return the newly created graphic
	 */
	public FeatureGraphic build() {
		return new FeatureGraphic(direction, featureType);
	}
}
