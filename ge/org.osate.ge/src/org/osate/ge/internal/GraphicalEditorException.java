/**
 * Copyright (c) 2004-2022 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.ge.internal;

import org.osate.ge.aadl2.AadlGraphicalEditorException;

/**
 * Runtime Exception thrown when an error occurs for which a specialized exception does not exist.
 * @since 3.0
 * @see AadlGraphicalEditorException
 */
public class GraphicalEditorException extends RuntimeException {
	/**
	 * Serializable version number for class
	 */
	private static final long serialVersionUID = 3483334265203033480L;

	/**
	 * Creates a new instance
	 * @param message is the message to include in the exception
	 */
	public GraphicalEditorException(final String message) {
		super(message);
	}

	/**
	 * Creates a new instance
	 * @param cause the cause of the exception. The exception which this exception wraps.
	 * @see RuntimeException#RuntimeException(Throwable)
	 */
	public GraphicalEditorException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Creates a new instance
	 * @param message is the message to include in the exception
	 * @param cause the cause of the exception. The exception which this exception wraps.
	 * @see RuntimeException#RuntimeException(String, Throwable)
	 */
	public GraphicalEditorException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
