/**
 * Copyright (c) 2004-2025 Carnegie Mellon University and others. (see Contributors file). 
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
 * @version $Id: AnnexParserRegistry.java,v 1.3 2007-07-10 20:41:44 jseibel Exp $
 */
public class AnnexParserRegistry extends AnnexRegistry {

	protected AnnexParserRegistry() {
		initialize(ANNEX_PARSER_EXT_ID);
	}

	public AnnexParser getAnnexParser(String annexName) {
		AnnexParser parser = (AnnexParser) extensions.get(annexName.toLowerCase());

		if (parser == null) {
			parser = (AnnexParser) extensions.get("*");
		}
		return parser;
	}

	@Override
	protected final Object getDefault() {
		return new DefaultAnnexParser();
	}

	/**
	 * Factory method for annex parser proxies.
	 * @param configElem
	 */
	@Override
	protected AnnexProxy createProxy(IConfigurationElement configElem) {
		return new AnnexParserProxy(configElem);
	}
}
