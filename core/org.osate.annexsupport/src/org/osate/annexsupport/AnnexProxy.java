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
package org.osate.annexsupport;

import org.eclipse.core.runtime.IConfigurationElement;

/**
 * @author lwrage
 * @version $Id: AnnexProxy.java,v 1.2 2005-08-29 14:23:28 lwrage Exp $
 */
abstract public class AnnexProxy {
	protected static final String ATT_ID = "id";
	protected static final String ATT_NAME = "name";
	protected static final String ATT_ANNEXNAME = "annexName";
	protected static final String ATT_ANNEXNSURI = "annexNSURI";
	protected static final String ATT_CLASS = "class";

	protected final IConfigurationElement configElem;

	protected final String id;
	protected final String name;
	protected final String annexName;
	protected final String className;

	protected AnnexProxy(String id, String name, String annexName, String className) {
		this.id = id;
		this.name = name;
		this.annexName = annexName;
		this.className = className;
		configElem = null;
	}

	protected AnnexProxy(IConfigurationElement configElem) {
		this.configElem = configElem;
		id = getAttribute(ATT_ID, null);
		name = getAttribute(ATT_NAME, id);
		annexName = getAttribute(ATT_ANNEXNAME, null);
		className = getAttribute(ATT_CLASS, null);
	}

	private String getAttribute(String name, String defaultValue) {
		if (configElem == null) {
			return null;
		}
		String value = configElem.getAttribute(name);

		if (value != null) {
			return value;
		}
		if (defaultValue != null) {
			return defaultValue;
		}
		throw new IllegalArgumentException("Missing " + name + " attribute");
	}
}
