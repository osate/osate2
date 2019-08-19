/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: ConnectionBindingConsistency.java,v 1.1.2.4 2008-12-01 13:23:35 relief Exp $
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
