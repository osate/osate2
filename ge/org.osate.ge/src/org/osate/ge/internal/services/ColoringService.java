/**
 * Copyright (c) 2004-2023 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.services;

import java.util.Map;

import org.osate.aadl2.NamedElement;
import org.osate.ge.BusinessObjectContext;
import org.osate.ge.graphics.Color;
import org.osate.ge.internal.diagram.runtime.DiagramElement;

/**
 * Contains methods to handle highlighting objects based on editor state
 *
 */
public interface ColoringService {
	/**
	 * Object used to override the color of a diagram element.
	 * Note: This API should be reworked to allow the implementation to apply multiple changes at once and to allow
	 * overriding more than just the foreground color. This could be be replaced with a POJO which contains a mapping of
	 * overridden styles. The coloring service could allow activating and deactivating the object.
	 *
	 */
	interface Coloring {
		/**
		 * Resets any colors previously set by {@link #setForeground(DiagramElement, Color)} and
		 * prevents further calls to this object from affecting the diagram.
		 */
		void dispose();

		/**
		 * Sets the foreground color of a diagram element
		 * @param de the diagram element for which to set the foreground color.
		 * @param color setting color to null returns the element to its default color.
		 * @see org.osate.ge.graphics.StyleBuilder#foregroundColor(Color)
		 */
		void setForeground(DiagramElement de, Color color);

		/**
		 * Resets any colors previously set by {@link #setForeground(DiagramElement, Color)}.
		 */
		void clear();
	}

	/**
	 * Allows the caller to override the colors of specific diagram elements.
	 * The returned Coloring object is used to configure colors.
	 * The returned object must be disposed() when coloring is no longer desired. Overrides default highlighting.
	 * @return the object to use to override colors.
	 */
	Coloring adjustColors();

	/**
	 * Returns a map containing colors which should override the foreground color of the associated diagram element.
	 * @return a map containing colors which should override the foreground color of the associated diagram element.
	 */
	Map<DiagramElement, Color> buildForegroundColorMap();

	/**
	 * Sets the AADL mode to highlight. The specified element, and model elements which are in the mode will be highlighted.
	 * TODO: This should be removed from this service. The mode highlighting should be refactored to rely on the
	 * coloring service's API.
	 * Must be called from the UI thread
	 * @param ne the {@link org.osate.aadl2.Mode}, {@link org.osate.aadl2.ModeTransition},
	 * {@link org.osate.aadl2.instance.ModeInstance}, or {@link org.osate.aadl2.instance.ModeTransitionInstance} to highlight
	 * @param boc the diagram node which contains a child for the specified mode
	 */
	void setHighlightedMode(NamedElement ne, BusinessObjectContext boc);

	/**
	 * Sets the AADL flow to highlight. Highlights model elements which are referenced by the flow.
	 * If a flow specification is specified, the flow implementations are highlighted.
	 * TODO: This should be removed from this service. The flow highlighting should be refactored to rely on the
	 * coloring service's API.
	 * Must be called from the UI thread
	 * @param ne the {@link org.osate.aadl2.FlowSpecification} or {@link org.osate.aadl2.EndToEndFlow} to highlight
	 * @param boc the diagram node which contains a child for the specified flow
	 */
	void setHighlightedFlow(NamedElement ne, BusinessObjectContext boc);
}