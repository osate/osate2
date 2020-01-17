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
package org.osate.ge.graphics.internal;

import org.osate.ge.graphics.Graphic;

/**
 * Graphic which will be used to represent connections. Not public API.
 */
public class AgeConnection implements Graphic {
	public final AgeConnectionTerminator srcTerminator;
	public final AgeConnectionTerminator dstTerminator;
	public final boolean isFlowIndicator;

	private AgeConnection(final AgeConnectionTerminator srcTerminator, final AgeConnectionTerminator dstTerminator,
			final boolean isFlowIndicator) {
		this.srcTerminator = srcTerminator;
		this.dstTerminator = dstTerminator;
		this.isFlowIndicator = isFlowIndicator;
	}

	/**
	 * Create a connection which is not a flow indicator.
	 * @param lineStyle
	 * @param srcTerminator
	 * @param dstTerminator
	 * @return
	 */
	public static AgeConnection createNormal(final AgeConnectionTerminator srcTerminator,
			final AgeConnectionTerminator dstTerminator) {
		return new AgeConnection(srcTerminator, dstTerminator, false);
	}

	public static AgeConnection createFlowIndicator(final AgeConnectionTerminator srcTerminator,
			final AgeConnectionTerminator dstTerminator) {
		return new AgeConnection(srcTerminator, dstTerminator, true);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dstTerminator == null) ? 0 : dstTerminator.hashCode());
		result = prime * result + (isFlowIndicator ? 1231 : 1237);
		result = prime * result + ((srcTerminator == null) ? 0 : srcTerminator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AgeConnection other = (AgeConnection) obj;
		if (dstTerminator == null) {
			if (other.dstTerminator != null) {
				return false;
			}
		} else if (!dstTerminator.equals(other.dstTerminator)) {
			return false;
		}
		if (isFlowIndicator != other.isFlowIndicator) {
			return false;
		}
		if (srcTerminator == null) {
			if (other.srcTerminator != null) {
				return false;
			}
		} else if (!srcTerminator.equals(other.srcTerminator)) {
			return false;
		}
		return true;
	}
}
