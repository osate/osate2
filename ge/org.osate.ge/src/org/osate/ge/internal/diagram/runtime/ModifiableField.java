/**
 * Copyright (c) 2004-2024 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal.diagram.runtime;

import org.osate.ge.internal.model.EmbeddedBusinessObject;

/**
 * Enumeration of values which are tracked and for which notifications are sent to {@link DiagramModificationListener}
 */
public enum ModifiableField {
	/**
	 * Completeness
	 * @see DiagramElement#getCompleteness()
	 */
	COMPLETENESS,
	/**
	 * Label name
	 * @see DiagramElement#getLabelName()
	 */
	LABEL_NAME,
	/**
	 * User interface name
	 * @see DiagramElement#getUserInterfaceName()
	 */
	USER_INTERFACE_NAME,
	/**
	 * Graphical configuration
	 * @see DiagramElement#getGraphicalConfiguration()
	 */
	GRAPHICAL_CONFIGURATION,
	/**
	 * Position
	 * @see DiagramElement#getPosition()
	 */
	POSITION,
	/**
	 * Size
	 * @see DiagramElement#getSize()
	 */
	SIZE,
	/**
	 * Dock area
	 * @see DiagramElement#getDockArea()
	 */
	DOCK_AREA,
	/**
	 * Style
	 * @see DiagramElement#getStyle()
	 */
	STYLE,
	/**
	 * Connection bendpoints
	 * @see DiagramElement#getBendpoints()
	 */
	BENDPOINTS,
	/**
	 * Connection primary label position
	 * @see DiagramElement#getConnectionPrimaryLabelPosition()
	 */
	CONNECTION_PRIMARY_LABEL_POSITION,
	/**
	 * Relative reference
	 * @see DiagramElement#getRelativeReference()
	 */
	RELATIVE_REFERENCE,
	/**
	 * Diagram configuration
	 * @see AgeDiagram#getConfiguration()
	 */
	DIAGRAM_CONFIGURATION,
	/**
	 * Business object which are instances of {@link EmbeddedBusinessObject}
	 * @see EmbeddedBusinessObject
	 * @see DiagramElement#getBusinessObject()
	 */
	EMBEDDED_BUSINESS_OBJECT,
}