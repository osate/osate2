/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.aadl2.instantiation.internal;

import java.util.List;

import org.osate.aadl2.Connection;
import org.osate.aadl2.instance.EndToEndFlowInstance;

/**
 * One instantiated variant of an end-to-end flow declaration, in the shape end-to-end flow instantiation published
 * before it kept candidates of its own.
 * <p>
 * This is the legacy view of a candidate: the flow instance together with the declarative connections that lead into
 * its first and out of its last flow element. It is produced only when a caller of
 * {@code CreateEndToEndFlowsSwitch.instantiateEndToEndFlow} supplies a map to fill in; the traversal itself works on
 * the session's own candidates.
 */
public final class ETEInfo {
	public final List<Connection> preConns;
	public final EndToEndFlowInstance etei;
	public final List<Connection> postConns;

	public ETEInfo(List<Connection> preConns, EndToEndFlowInstance etei, List<Connection> postConns) {
		this.preConns = preConns;
		this.etei = etei;
		this.postConns = postConns;
	}
}
