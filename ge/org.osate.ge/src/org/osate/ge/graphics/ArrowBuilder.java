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
package org.osate.ge.graphics;

import org.osate.ge.graphics.internal.AgeConnectionTerminator;
import org.osate.ge.graphics.internal.ConnectionTerminatorSize;
import org.osate.ge.graphics.internal.ConnectionTerminatorType;

/**
 * Builder for creating arrow connection terminators. 
 * @noextend
 * @see ConnectionTerminator
 */
public class ArrowBuilder {
	private ConnectionTerminatorType terminatorType = ConnectionTerminatorType.FILLED_ARROW;
	private ConnectionTerminatorSize terminatorSize = ConnectionTerminatorSize.REGULAR;
	private boolean reversed = false;
	
	private ArrowBuilder() {} 
	
	/**
	 * Creates an arrow builder.
	 * @return a arrow builder
	 */
	public static ArrowBuilder create() {
		return new ArrowBuilder();
	}
	
	/**
	 * Configures the arrow builder to create a filled polygon arrow.
	 * @return this builder to allow method chaining.
	 */
	public ArrowBuilder filled() {
		terminatorType = ConnectionTerminatorType.FILLED_ARROW;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create an unfilled polygon arrow.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder open() {
		terminatorType = ConnectionTerminatorType.OPEN_ARROW;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create a line arrow.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder line() {
		terminatorType = ConnectionTerminatorType.LINE_ARROW;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create a small arrow.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder small() {
		terminatorSize = ConnectionTerminatorSize.SMALL;
		return this;
	}
	
	/**
	 * Configures the arrow builder to create a reversed arrow. Reversed arrows will point inwards rather than outwards.
	 * @return the arrow builder on which the method was invoked to allow method chaining
	 */
	public ArrowBuilder reverse() {
		reversed = true;
		return this;
	}
	
	/**
	 * Creates a connection terminator based on the current state of the arrow builder.
	 * @return the newly created connection terminator
	 */
	public ConnectionTerminator build() {
		return new AgeConnectionTerminator(terminatorType, terminatorSize, reversed);
	}
}
