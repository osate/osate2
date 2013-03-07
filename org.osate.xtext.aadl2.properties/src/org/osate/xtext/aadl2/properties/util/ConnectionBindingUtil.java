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
 * @version $Id: ConnectionBindingUtil.java,v 1.3 2010-05-07 20:01:18 lwrage Exp $
 */
package org.osate.xtext.aadl2.properties.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;


/**
 * @author phf This class provides for checking whether delta streams are
 *         communicated over protocols with guaranteed delivery.
 */
// TODO-LW: check for access connection where needed, consider access direction
public class ConnectionBindingUtil {

	public static ComponentInstance getHardwareComponent(FeatureInstance fi) {
		ComponentInstance ci = fi.getContainingComponentInstance();
		if (ci.getCategory() == ComponentCategory.DEVICE) {
			return ci;
		}
		List<ComponentInstance> ciList = GetProperties.getActualProcessorBinding(ci);
		ci = ciList.isEmpty() ? null : ciList.get(0);
		return ci;
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if
	 * same component), or null (no connection).
	 * 
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	public static List<ComponentInstance> connectedByBus(ComponentInstance srcHW, ComponentInstance dstHW) {
		EList<ComponentInstance> visitedBuses = new UniqueEList<ComponentInstance>();
		return doConnectedByBus(srcHW, dstHW, visitedBuses);
	}

	/**
	 * returns list of buses connecting to HW components. Can be empty list (if
	 * same component), or null (no connection).
	 * 
	 * @param source HW component
	 * @param destination HW component
	 * @return list of buses involved in the physical connection
	 */
	protected static List<ComponentInstance> doConnectedByBus(ComponentInstance srcHW, ComponentInstance dstHW, EList<ComponentInstance> visitedBuses) {
		if (srcHW == null || dstHW == null)
			return visitedBuses;
		if (srcHW == dstHW)
			return visitedBuses;
		EList<FeatureInstance> busaccesslist = srcHW.getFeatureInstances();
		for (Iterator<FeatureInstance> it = busaccesslist.iterator(); it.hasNext();) {
			FeatureInstance fi = (FeatureInstance) it.next();
			if (fi.getCategory() == FeatureCategory.BUS_ACCESS) {
				for (ConnectionInstance aci : fi.getDstConnectionInstances()) {
					ComponentInstance curBus = (ComponentInstance) aci.getSource();
					if (!visitedBuses.contains(curBus)) {
						if (connectedToBus(dstHW, curBus)) {
							EList<ComponentInstance> res = new BasicEList<ComponentInstance>();
							res.add(curBus);
							return res;
						} else {
							// first check if there is a bus this bus is connected to
							visitedBuses.add(curBus);
							List<ComponentInstance> res = doConnectedByBus(curBus, dstHW, visitedBuses);
							if (res != null) {
								res.add(0, curBus);
								return res;
							} else {
								// check for buses that are connected to this bus
								for (ConnectionInstance srcaci : curBus.getSrcConnectionInstances()) {
									ComponentInstance bi = srcaci.getDestination().getContainingComponentInstance();
									if (bi.getCategory() == ComponentCategory.BUS) {
										if (connectedToBus(dstHW, bi)) {
											res = new BasicEList<ComponentInstance>();
											res.add(bi);
											return res;
										} else {
											visitedBuses.add(bi);
											res = doConnectedByBus(bi, dstHW, visitedBuses);
											if (res != null) {
												res.add(0, curBus);
												return res;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return null;
	}

	/**
	 * is hardware component connected (directly) to the given bus
	 * 
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return true if they are connected by bus access connection
	 */
	public static boolean connectedToBus(ComponentInstance HWcomp, ComponentInstance bus) {
		for (ConnectionInstance srcaci : bus.getSrcConnectionInstances()) {
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp) {
				return true;
			}
		}
		return false;
	}

	/**
	 * is hardware component connected (directly) to the given bus, incl. bus to
	 * bus
	 * 
	 * @param HWcomp ComponentInstance hardware component
	 * @param bus ComponentInstance bus component
	 * @return access connection instance if they are connected by bus access
	 *         connection
	 */
	public static ConnectionInstance getBusAccessConnection(ComponentInstance HWcomp, ComponentInstance bus) {
		for (ConnectionInstance srcaci : bus.getSrcConnectionInstances()) {
			if (srcaci.getDestination().getContainingComponentInstance() == HWcomp) {
				return srcaci;
			}
		}
		if (HWcomp.getCategory() == ComponentCategory.BUS) {
			// check the other way
			for (ConnectionInstance srcaci : HWcomp.getSrcConnectionInstances()) {
				if (srcaci.getDestination().getContainingComponentInstance() == bus) {
					return srcaci;
				}
			}
		}
		return null;
	}

}
