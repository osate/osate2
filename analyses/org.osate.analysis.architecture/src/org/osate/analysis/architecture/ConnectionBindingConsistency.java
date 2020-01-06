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
package org.osate.analysis.architecture;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.InstanceModelUtil;

/**
 * @author phf
 *
 * This class provides for checking whether delta streams are communicated over protocols with guaranteed delivery.
 *
 */
public class ConnectionBindingConsistency extends AadlProcessingSwitchWithProgress {

	private AbstractAaxlHandler handler;

	public ConnectionBindingConsistency(final IProgressMonitor pm, final AbstractAaxlHandler handler) {
		super(pm, PROCESS_PRE_ORDER_ALL);
		this.handler = handler;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public final void initSwitches() {
		/* here we are creating the connection checking switches */

		/* here we are creating the connection checking switches */
		instanceSwitch = new InstanceSwitch() {
			/**
			 * check physical connectivity of port connection instances
			 */
			@Override
			public Object caseConnectionInstance(ConnectionInstance conni) {
				if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
					ComponentInstance srcHW = InstanceModelUtil.getHardwareComponent(conni.getSource());
					ComponentInstance dstHW = InstanceModelUtil.getHardwareComponent(conni.getDestination());
					if (!conni.isComplete()) {
						return DONE;
					}
					if (srcHW == null || dstHW == null) {
						handler.warning(conni, "Connection source and/or destination is not bound to hardware");
						return DONE;
					}
					List<ComponentInstance> bindings = InstanceModelUtil.getPhysicalConnectionBinding(conni);
					if (bindings.isEmpty()) {
						List<ComponentInstance> result = InstanceModelUtil.connectedByBus(srcHW, dstHW);
						if (result.isEmpty()) {
							handler.error(conni,
									"Hardware (processor or device) of connection source and destination are not physically connected by bus.");
						}
					} else {
						ComponentInstance ci = bindings.get(0);
						if (bindings.size() == 1) {
							if (!InstanceModelUtil.connectedToBus(srcHW, ci)) {
								handler.error(conni,
										"Hardware (processor or device) of connection source is not physically connected by bus specified in connection binding.");
							}
							if (!InstanceModelUtil.connectedToBus(dstHW, ci)) {
								handler.error(conni,
										"Hardware (processor or device) of connection destination is not physically connected by bus specified in connection binding.");
							}
						} else {
							if (!InstanceModelUtil.connectedToBus(srcHW, ci)) {
								handler.error(conni,
										"The first bus in the connection binding is not connected to the source hardware component.");
							}
							ci = bindings.get(bindings.size() - 1);
							if (!InstanceModelUtil.connectedToBus(srcHW, ci)) {
								handler.error(conni,
										"The first bus in the connection binding is not connected to the source hardware component.");
							}
						}
					}
				}
				return DONE;
			}
		};
	}

}
