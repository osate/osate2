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
package org.osate.ge.internal.diagram.runtime.styling;

import java.util.Objects;

import org.osate.ge.graphics.Style;
import org.osate.ge.graphics.StyleBuilder;
import org.osate.ge.graphics.internal.AgeConnection;
import org.osate.ge.internal.diagram.runtime.DiagramConfiguration;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Calculates final style for diagram elements.
 *
 */
public class StyleCalculator implements StyleProvider {
	private Style diagramConnectionStyle;
	private final StyleProvider overrideStyleProvider;

	/**
	 * @param config is the diagram configuration which determines one of the styles which is applied.
	 * @param overrideStyleProvider is a style provider whose returned style overrides all other styles.
	 */
	public StyleCalculator(final DiagramConfiguration config, final StyleProvider overrideStyleProvider) {
		setDiagramConfiguration(config);
		this.overrideStyleProvider = Objects.requireNonNull(overrideStyleProvider,
				"overrideStyleProvider must not be null");
	}

	/**
	 * Sets the diagram configuration used when building styles.
	 * @param config
	 */
	public final void setDiagramConfiguration(final DiagramConfiguration config) {
		this.diagramConnectionStyle = getDiagramConnectionStyle(
				Objects.requireNonNull(config, "config must not be null"));
	}

	/**
	 * Gets the final style object based on the following style priorities:
	 *     Style from override style provider.
	 *     Diagram Element Style
	 *     Diagram Connection Style (Connections only)
	 *     Diagram Element Graphical Configuration
	 *     Default Style
	 */
	@Override
	public Style getStyle(final DiagramElement de) {
		return StyleBuilder.create(overrideStyleProvider.getStyle(de), de.getStyle(),
				getDiagramConfigurationStyle(de),
				de.getGraphicalConfiguration().style, Style.DEFAULT).build();
	}

	private Style getDiagramConfigurationStyle(final DiagramElement de) {
		if (de.getGraphic() instanceof AgeConnection) {
			return diagramConnectionStyle;
		} else {
			return Style.EMPTY;
		}
	}

	private static Style getDiagramConnectionStyle(final DiagramConfiguration config) {
		final StyleBuilder diagramConnectionStyleBuilder = StyleBuilder.create(Style.EMPTY);
		diagramConnectionStyleBuilder.primaryLabelVisible(config.getConnectionPrimaryLabelsVisible());
		return diagramConnectionStyleBuilder.build();
	}
}
