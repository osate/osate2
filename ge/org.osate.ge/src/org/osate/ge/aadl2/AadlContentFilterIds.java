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
package org.osate.ge.aadl2;

import org.osate.ge.ContentFilter;

/**
 * Contains IDs for content filters related to AADL2. The primary use case for these constants is defining diagram types.
 * @since 2.0
 */
public final class AadlContentFilterIds {
	/**
	 * Private constructor to prevent instantiation.
	 */
	private AadlContentFilterIds() {
	}

	/**
	 * The ID of the {@link ContentFilter} which matches internal features
	 */
	public static final String INTERNAL_FEATURES = "internalFeatures";

	/**
	 * The ID of the {@link ContentFilter} which matches access connections
	 */
	public static final String ACCESS_CONNECTIONS = "accessConnections";

	/**
	 * The ID of the {@link ContentFilter} which matches connections
	 */
	public static final String CONNECTIONS = "connections";

	/**
	 * The ID of the {@link ContentFilter} which matches called subprograms
	 */
	public static final String CALLED_SUBPROGRAMS = "calledSubprogram";

	/**
	 * The ID of the {@link ContentFilter} which matches classifiers
	 */
	public static final String CLASSIFIERS = "classifiers";

	/**
	 * The ID of the {@link ContentFilter} which matches feature connections
	 */
	public static final String FEATURE_CONECTIONS = "featureConnections";

	/**
	 * The ID of the {@link ContentFilter} which matches features
	 */
	public static final String FEATURES = "features";

	/**
	 * The ID of the {@link ContentFilter} which matches feature group connections
	 */
	public static final String FEATURE_GROUP_CONNECTIONS = "featureGroupConnections";

	/**
	 * The ID of the {@link ContentFilter} which matches feature group types
	 */
	public static final String FEATURE_GROUP_TYPES = "featureGroupTypes";

	/**
	 * The ID of the {@link ContentFilter} which matches flow specifications
	 */
	public static final String FLOW_SPECIFICATIONS = "flowSpecifications";

	/**
	 * The ID of the {@link ContentFilter} which matches generalizations
	 */
	public static final String GENERALIZATIONS = "generalizations";

	/**
	 * The ID of the {@link ContentFilter} which matches modes
	 */
	public static final String MODES = "modes";

	/**
	 * The ID of the {@link ContentFilter} which matches mode transitions
	 */
	public static final String MODE_TRANSITIONS = "modeTransitions";

	/**
	 * The ID of the {@link ContentFilter} which matches mode transition trigger names
	 */
	public static final String MODE_TRANSITION_TRIGGER_NAMES = "modeTransitionTriggerNames";

	/**
	 * The ID of the {@link ContentFilter} which matches parameter connections
	 */
	public static final String PARAMETER_CONNECTIONS = "parameterConnections";

	/**
	 * The ID of the {@link ContentFilter} which matches port connections
	 */
	public static final String PORT_CONNECTIONS = "portConnections";

	/**
	 * The ID of the {@link ContentFilter} which matches processor features
	 */
	public static final String PROCESSOR_FEATURES = "processorFeatures";

	/**
	 * The ID of the {@link ContentFilter} which matches subcomponents
	 */
	public static final String SUBCOMPONENTS = "subcomponents";

	/**
	 * The ID of the {@link ContentFilter} which matches subcomponent type labels
	 */
	public static final String SUBCOMPONENT_TYPE = "subcomponentType";

	/**
	 * The ID of the {@link ContentFilter} which subprogram calls
	 */
	public static final String SUBPROGRAM_CALLS = "subprogramCalls";

	/**
	 * The ID of the {@link ContentFilter} which matches subprogram call order objects
	 */
	public static final String SUBPROGRAM_CALL_ORDERS = "subprogramCallOrders";

	/**
	 * The ID of the {@link ContentFilter} which matches subprogram call sequences
	 */
	public static final String SUBPROGRAM_CALL_SEQUENCES = "subprogramCallSequences";
}
