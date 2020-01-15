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
package org.osate.xtext.aadl2.errormodel.util;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

/**
 * Directional propagation path
 *
 * @author phf
 *
 */
public class PropagationPathRecord {
	PropagationPathEnd pathSrc;
	PropagationPathEnd pathDst;
	ConnectionInstance conni;

	/**
	 * propagation path between error propagations of component instances
	 */
	public PropagationPathRecord(ComponentInstance srcCI, ErrorPropagation srcEP, ComponentInstance dstCI,
			ErrorPropagation dstEP, ConnectionInstance conni) {
		pathSrc = new PropagationPathEnd(srcCI, srcEP);
		pathDst = new PropagationPathEnd(dstCI, dstEP);
		this.conni = conni;
	}

	/**
	 * propagation path for bindings (no connection instance exists)
	 */
	public PropagationPathRecord(ComponentInstance srcCI, ErrorPropagation srcEP, ComponentInstance dstCI,
			ErrorPropagation dstEP) {
		pathSrc = new PropagationPathEnd(srcCI, srcEP);
		pathDst = new PropagationPathEnd(dstCI, dstEP);
		conni = null;
	}

	/**
	 * propagation path for connection bindings (no connection instance exists)
	 * srcConni is the source
	 */
	public PropagationPathRecord(ConnectionInstance srcConni, ComponentInstance dstCI, ErrorPropagation dstEP) {
		pathSrc = new PropagationPathEnd(srcConni, null);
		pathDst = new PropagationPathEnd(dstCI, dstEP);
		conni = null;
	}

	/**
	 * propagation path for connection bindings (no connection instance exists)
	 * dstConni is the destination of the propagation
	 */
	public PropagationPathRecord(ComponentInstance srcCI, ErrorPropagation srcEP, ConnectionInstance dstConni) {
		pathSrc = new PropagationPathEnd(srcCI, srcEP);
		pathDst = new PropagationPathEnd(dstConni, null);
		conni = null;
	}

	public boolean isConnectionPath() {
		return this.conni != null;
	}

	public boolean isComponentBindingPath() {
		return !isConnectionPath() && pathSrc.getComponentInstance() != null && pathDst.getComponentInstance() != null;
	}

	public boolean isConnectionBindingPath() {
		return !isConnectionPath() && !isComponentBindingPath();
	}

	public ConnectionInstance getConnectionInstance() {
		return conni;
	}

	public PropagationPathEnd getPathSrc() {
		return pathSrc;
	}

	public ComponentInstance getSrcCI() {
		return pathSrc.getComponentInstance();
	}

	public ConnectionInstance getSrcConni() {
		return pathSrc.getConnectionInstance();
	}

	public void setPathSrc(PropagationPathEnd pathSrc) {
		this.pathSrc = pathSrc;
	}

	public PropagationPathEnd getPathDst() {
		return pathDst;
	}

	public ComponentInstance getDstCI() {
		return pathDst.getComponentInstance();
	}

	public ConnectionInstance getDstConni() {
		return pathDst.getConnectionInstance();
	}

	public void setPathDst(PropagationPathEnd pathDst) {
		this.pathDst = pathDst;
	}
}
