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
package org.osate.aadl2.instantiation;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;

/**
 * <p>
 * Should only be invoked from within an iteration of the system operation modes
 * <p>
 */
public class CheckInstanceSemanticsSwitch extends AadlProcessingSwitch {
	/** The current SOM, used for error message */
	private SystemOperationMode currentSOM;

	/** Message prepended to all reporter output */
	private String reportPrefix;

	/**
	 * The cache of contained property associations that apply to semantic
	 * connections.
	 */
	private SCProperties scProps;

	/**
	 * Mode context to be used for checking connection properties. Maps the
	 * system instance in {@link #root} to the current SOM in
	 * {@link #currentSOM}.
	 */
//	private final Map<InstanceModeContext, SystemOperationMode> modeBindings;
//
//	private final Property dispatchProtocolPD;
//
//	public CheckInstanceSemanticsSwitch(final SystemOperationMode som,
//			final Map<InstanceModeContext, SystemOperationMode> bindings, final SCProperties scp,
//			final AnalysisErrorReporterManager errMgr) {
//		super(PROCESS_POST_ORDER_ALL, errMgr);
//		this.currentSOM = som;
//		this.reportPrefix = currentSOM.getName().equalsIgnoreCase("No Modes") ? "" : "In SystemMode "
//				+ currentSOM.getName() + ": ";
//		this.modeBindings = bindings;
//		this.scProps = scp;
//
//		// TODO: Should do something when this fails
//		//dispatchProtocolPD = OsateResourceManager.findProperty(ThreadProperties.DISPATCH_PROTOCOL);
//	}

	@Override
	protected final void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
//			private boolean containsMemory = false;
//			private boolean containsThread = false;
//			private boolean containsProcessor = false;
//
//			public String caseSystemInstance(final SystemInstance si) {
//				if (!containsMemory) {
//					warning(si, reportPrefix + "System instance does not contain a memory component; "
//							+ "not an executable application system");
//				}
//				if (!containsThread) {
//					warning(si, reportPrefix + "System instance does not contain a thread component; "
//							+ "not an executable application system");
//				}
//				if (!containsProcessor) {
//					warning(si, reportPrefix + "System instance does not contain a processor component; "
//							+ "not an executable application system");
//				}
//				return DONE;
//			}
//
//			public String caseComponentInstance(final ComponentInstance ci) {
//				final ComponentCategory cc = ci.getCategory();
//
//				// Update data for executable application system check
//				if (cc.equals(ComponentCategory.THREAD))
//					containsThread = true;
//				if (cc.equals(ComponentCategory.MEMORY))
//					containsMemory = true;
//				if (cc.equals(ComponentCategory.PROCESSOR))
//					containsProcessor = true;
//
//				// thread-specific checks
//				if (cc.equals(ComponentCategory.THREAD))
//					checkThread(ci);
//				return DONE;
//			}
//
			@Override
			public String caseConnectionInstance(ConnectionInstance conni) {
				// checkDelayedConnectionEndPoints(conni);
				checkPropertyConsistency(conni);
				return NOT_DONE;
			}
		};
	}

//	private void checkThread(final ComponentInstance thread) {
//		try {
//			EnumerationLiteral dispatch = PropertyUtils.getEnumLiteral(thread, dispatchProtocolPD);
//			if (dispatch.getName().equalsIgnoreCase(AadlProject.APERIODIC_LITERAL)
//					|| dispatch.getName().equalsIgnoreCase(AadlProject.SPORADIC_LITERAL)) {
//				boolean hasTriggeringEvent = false;
//				// (1) look for a event or event data port that is in or in out
//				final Iterator<FeatureInstance> features = thread.getFeatureInstances().iterator();
//				while (features.hasNext()) {
//					final FeatureInstance fi = features.next();
//					final Feature f = fi.getFeature();
//					if (f instanceof EventPort || f instanceof EventDataPort) {
//						final DirectionType dir = ((Port) f).getDirection();
//						if (dir.equals(DirectionType.IN) || dir.equals(DirectionType.IN_OUT)) {
//							// (2) see if the port is the destination of a semantic connection
//							hasTriggeringEvent |= fi.getDstConnectionInstances().size() > 0;
//						}
//					}
//				}
//				if (!hasTriggeringEvent) {
//					error(thread, reportPrefix + "Aperiodic/sporadic thread doesn't have an incoming event connection");
//				}
//			} else if (AadlProject.PERIODIC_LITERAL.equalsIgnoreCase(dispatch.getName())
//					|| AadlProject.BACKGROUND_LITERAL.equalsIgnoreCase(dispatch.getName())) {
//				// TODO: Check dispatch port on periodic/background threads
//			}
//		} catch (PropertyNotPresentException e) {
//			//Do nothing.
//		}
//	}
//
//	private void checkDelayedConnectionEndPoints(final ConnectionInstance conni) {
//		/*
//		 * TODO: This is going to have to be revisted when we have parameter
//		 * connections instantiated.
//		 */
//		/*
//		 * if (conni.isDelayed()) { final ComponentInstance srcCI =
//		 * (ComponentInstance) conni.getSrc().eContainer(); final
//		 * ComponentInstance destCI = (ComponentInstance)
//		 * conni.getDst().eContainer(); final ComponentClassifier srcClassifier
//		 * = srcCI.getSubcomponent().getAllClassifier(); final
//		 * ComponentClassifier destClassifier =
//		 * destCI.getSubcomponent().getAllClassifier(); if (srcClassifier
//		 * instanceof ThreadClassifier || srcClassifier instanceof
//		 * DeviceClassifier) { boolean logError; try { EnumerationLiteral
//		 * dispatch = PropertyUtils.getEnumLiteral(srcCI, dispatchProtocolPD);
//		 * logError =
//		 * !AadlProject.PERIODIC_LITERAL.equalsIgnoreCase(dispatch.getName()); }
//		 * catch (PropertyNotPresentException e) { logError = true; } if
//		 * (logError) error(conni, reportPrefix +
//		 * "Source of delayed connection is not periodic"); } else {
//		 * warning(conni, reportPrefix +
//		 * "Source of delayed connection is not a thread or device"); } if
//		 * (destClassifier instanceof ThreadClassifier || destClassifier
//		 * instanceof DeviceClassifier) { boolean logError; try {
//		 * EnumerationLiteral dispatch = PropertyUtils.getEnumLiteral(destCI,
//		 * dispatchProtocolPD); logError =
//		 * !AadlProject.PERIODIC_LITERAL.equalsIgnoreCase(dispatch.getName()); }
//		 * catch (PropertyNotPresentException e) { logError = true; } if
//		 * (logError) error(conni, reportPrefix +
//		 * "Destination of delayed connection is not periodic"); } else {
//		 * error(conni, reportPrefix +
//		 * "Destination of delayed connection is not a thread or device"); } }
//		 */
//	}

	private void checkPropertyConsistency(ConnectionInstance conni) {
//		// may be null!
//		Map<Property, Map<Connection, List<ModalPropertyValue>>> propsLayer = scProps.get(conni);
//		List<ConnectionReference> connections = conni.getConnectionReferences();
//
//		// iterate over all the properties that apply to connections
//		Iterator<Property> propDecls = AadlUtil.getAllPropertyDefinitions().iterator();
//		while (propDecls.hasNext()) {
//			Property pd = propDecls.next();
//			if (conni.acceptsProperty(pd)) {
//				// may be null!
//				Map<Connection, Map<SystemOperationMode, List<? extends PropertyExpression>>> connLayer = (propsLayer == null) ? null
//						: propsLayer.get(pd);
//				try {
//					List<AadlModalPropertyValue> values = conni.getConnectionPropertyValues(pd);
//					boolean consistent = true;
//					List<? extends PropertyExpression> firstDefined = null;
//					int firstDefinedIdx = -1;
//					int badIndex = -1;
//
//					/*
//					 * Check that for all the connections for which the value is
//					 * present, the value is the same. Before we look in the
//					 * 'values' array, we check whether a contained property
//					 * association applied a value to the semantic connection by
//					 * naming the particular connection declaration.
//					 *
//					 * If '!consistent' then the value of 'badIndex' is the
//					 * location of the first inconsistent connection.
//					 */
//					for (int idx = 0; consistent && (idx < connections.size()); idx++) {
//						Connection conn = connections.get(idx);
//						Map<SystemOperationMode, List<? extends PropertyExpression>> somLayer = (connLayer == null) ? null
//								: connLayer.get(conn);
//						List<? extends PropertyExpression> value = (somLayer == null) ? null : somLayer.get(currentSOM);
//						if (value == null) {
//							/*
//							 * No value from the contained property
//							 * associations, so see what value is defined for
//							 * the Connection declaration.
//							 */
//							AadlModalPropertyValue mpv = values.get(idx);
//							AadlPropertyValue val = mpv.getValue(modeBindings);
//							if (!val.isNotPresent() && val.exists()) {
//								value = val.getValue();
//							}
//						}
//
//						/*
//						 * If 'value' is non-null we have a value for the
//						 * property from the particular connection declaration,
//						 * so see if it is consistent with the other connection
//						 * declarations.
//						 */
//						if (value != null) {
//							if (firstDefined != null) {
//								consistent &= firstDefined.equals(value);
//								badIndex = idx;
//							} else {
//								firstDefined = value;
//								firstDefinedIdx = idx;
//							}
//						}
//					}
//
//					if (!consistent) {
//						error(conni,
//								reportPrefix + "Value of property \"" + pd.getQualifiedName()
//										+ "\" is inconsistent across semantic connection: value at \""
//										+ getConnectionPath(conni, firstDefinedIdx) + "\" differs from value at \""
//										+ getConnectionPath(conni, badIndex) + "\"");
//					}
//				} catch (IllegalArgumentException e) {
//					error(conni, reportPrefix + "Property '" + pd.getQualifiedName()
//							+ "' is not accepted by one of the declarative "
//							+ "connections in the semantic connection: " + e.getMessage());
//				}
//			}
//		}
	}

	private static String getConnectionPath(ConnectionInstance conni, int idx) {
		StringBuffer sb = new StringBuffer();
		ConnectionReference connRef = conni.getConnectionReferences().get(idx);

		generateComponentPath(sb, connRef.getContext());
		sb.append(connRef.getName());
		return sb.toString();
	}

	private static void generateComponentPath(StringBuffer sb, ComponentInstance ci) {
		if (ci instanceof SystemInstance) {
			return;
		} else {
			generateComponentPath(sb, (ComponentInstance) ci.eContainer());
			sb.append(ci.getSubcomponent().getName());
			sb.append(".");
		}
	}
}
