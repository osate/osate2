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
package org.osate.ge.aadl2;

/**
 * Contains IDs for content filters so that they can be referenced by annex plugins.
 * @since 2.0
 */
public class AadlContentFilterIds {
	private AadlContentFilterIds() {
	}

	public static final String INTERNAL_FEATURES = "internalFeatures";
	public static final String ACCESS_CONNECTIONS = "accessConnections";
	public static final String CONNECTIONS = "connections";
	public static final String CALLED_SUBPROGRAMS = "calledSubprogram";
	public static final String CLASSIFIERS = "classifiers";
	public static final String FEATURE_CONECTIONS = "featureConnections";
	public static final String FEATURES = "features";
	public static final String FEATURE_GROUP_CONNECTIONS = "featureGroupConnections";
	public static final String FEATURE_GROUP_TYPES = "featureGroupTypes";
	public static final String FLOW_SPECIFICATIONS = "flowSpecifications";
	public static final String GENERALIZATIONS = "generalizations";
	public static final String MODES = "modes";
	public static final String MODE_TRANSITIONS = "modeTransitions";
	public static final String MODE_TRANSITION_TRIGGER_NAMES = "modeTransitionTriggerNames";
	public static final String PARAMETER_CONNECTIONS = "parameterConnections";
	public static final String PORT_CONNECTIONS = "portConnections";
	public static final String PROCESSOR_FEATURES = "processorFeatures";
	public static final String SUBCOMPONENTS = "subcomponents";
	public static final String SUBCOMPONENT_TYPE = "subcomponentType";
	public static final String SUBPROGRAM_CALLS = "subprogramCalls";
	public static final String SUBPROGRAM_CALL_ORDERS = "subprogramCallOrders";
	public static final String SUBPROGRAM_CALL_SEQUENCES = "subprogramCallSequences";
}
