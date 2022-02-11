/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge;

import org.osate.ge.graphics.Graphic;
import org.osate.ge.graphics.Style;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Builder for creating {@link GraphicalConfiguration} instances
 * @noextend
 * @see GraphicalConfiguration
 */
public class GraphicalConfigurationBuilder {
	private Graphic graphic;
	private Style style = Style.EMPTY;
	private DockingPosition defaultDockingPosition = DockingPosition.NOT_DOCKABLE;
	private DiagramElement connectionSource;
	private DiagramElement connectionDestination;
	private String annotation;

	/**
	 * See {@link GraphicalConfiguration#isPrimaryLabelIsMultiline()}. This field is protected because it was designed for internal use. It may be
	 * removed or promoted to API in a future release. Internal users should use {@link org.osate.ge.graphics.internal.InternalGraphicalConfigurationBuilder} to set this field.
	 * @noreference This field is not intended to be referenced by clients.
	 */
	protected boolean primaryLabelIsMultiline;

	/**
	 * Creates a new instance
	 */
	protected GraphicalConfigurationBuilder() {
	}

	/**
	 * Creates a new instance of the builder.
	 * @return a new instance of the builder.
	 */
	public static GraphicalConfigurationBuilder create() {
		return new GraphicalConfigurationBuilder();
	}

	/**
	 * Configures the builder to build an instance with the specified graphic.
	 * @param value the graphic to include in the graphical configuration.
	 * @return this builder to allow method chaining.
	 * @see GraphicalConfiguration#getGraphic()
	 */
	public GraphicalConfigurationBuilder graphic(final Graphic value) {
		this.graphic = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified default docking position.
	 * @param value the default docking position to include in the graphical configuration.
	 * @return this builder to allow method chaining.
	 * @see GraphicalConfiguration#getDefaultDockingPosition()
	 */
	public GraphicalConfigurationBuilder defaultDockingPosition(final DockingPosition value) {
		this.defaultDockingPosition = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified connection source.
	 * @param value the source to include in the graphical configuration.
	 * @return this builder to allow method chaining.
	 * @see GraphicalConfiguration#getConnectionSource()
	 */
	public GraphicalConfigurationBuilder source(final BusinessObjectContext value) {
		this.connectionSource = (DiagramElement) value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified connection destination.
	 * @param value the destination to include in the graphical configuration.
	 * @return this builder to allow method chaining.
	 * @see GraphicalConfiguration#getConnectionDestination()
	 */
	public GraphicalConfigurationBuilder destination(final BusinessObjectContext value) {
		this.connectionDestination = (DiagramElement) value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified style.
	 * @param value the style to include in the graphical configuration.
	 * @return this builder to allow method chaining.
	 * @see GraphicalConfiguration#getStyle()
	 */
	public GraphicalConfigurationBuilder style(final Style value) {
		this.style = value;
		return this;
	}

	/**
	 * Configures the builder to build an instance with the specified annotation text.
	 * Annotations are only supported for use with shape graphics at this time.
	 * @param value is the value for the annotation.
	 * @return this builder to allow method chaining.
	 * @see GraphicalConfiguration#getAnnotation()
	 */
	public GraphicalConfigurationBuilder annotation(final String value) {
		this.annotation = value;
		return this;
	}

	/**
	 * Creates a new graphical configuration with the configured values.
	 * @return a new graphical configuration with the configured values.
	 */
	public GraphicalConfiguration build() {
		return new GraphicalConfiguration(graphic, defaultDockingPosition, connectionSource,
				connectionDestination,
				style, annotation, primaryLabelIsMultiline);
	}
}
