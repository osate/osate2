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
