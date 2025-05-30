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
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

/**
 * @author lwrage
 * @version $Id: AnnexInstantiatorProxy.java,v 1.4 2009-10-09 18:49:32 lwrage Exp $
 */
public class AnnexInstantiatorProxy extends AnnexProxy implements AnnexInstantiator {

	/** The annex instantiator instance. */
	private AnnexInstantiator instantiator = null;

	/**
	 * Create a new annex instantiator proxy.
	 */
	AnnexInstantiatorProxy(IConfigurationElement configElem) {
		super(configElem);
	}

	/**
	 * @since 2.0
	 */
	@Override
	public void instantiateAnnex(ComponentInstance instance, String annexName,
			AnalysisErrorReporterManager errorManager) {
		AnnexInstantiator instantiator = getInstantiator();

		if (instantiator == null) {
			return;
		}
		instantiator.instantiateAnnex(instance, annexName, errorManager);
	}

	@Override
	public void instantiateAnnex(SystemInstance instance, String annexName, AnalysisErrorReporterManager errorManager) {
		AnnexInstantiator instantiator = getInstantiator();

		if (instantiator == null) {
			return;
		}
		instantiator.instantiateAnnex(instance, annexName, errorManager);
	}

	private AnnexInstantiator getInstantiator() {
		if (instantiator != null) {
			return instantiator;
		}
		try {
			instantiator = (AnnexInstantiator) configElem.createExecutableExtension(ATT_CLASS);
		} catch (Exception e) {
			AnnexPlugin.logError("Failed to instantiate " + annexName + " instantiator " + className + " in type: " + id
					+ " in plugin " + configElem.getDeclaringExtension().getContributor().getName(), e);
		}
		return instantiator;
	}

}
