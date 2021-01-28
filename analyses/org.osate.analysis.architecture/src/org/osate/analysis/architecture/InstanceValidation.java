/**
 * Copyright (c) 2004-2021 Carnegie Mellon University and others. (see Contributors file). 
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
package org.osate.analysis.architecture;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.modeltraversal.ForAllElement;
import org.osate.ui.handlers.AbstractAaxlHandler;
import org.osate.xtext.aadl2.properties.util.GetProperties;

public class InstanceValidation {
	private final AbstractAaxlHandler handler;
	private boolean isOK = true;

	public InstanceValidation(final AbstractAaxlHandler handler) {
		this.handler = handler;
	}

	public boolean checkReferenceProcessor(SystemInstance root) {
		isOK = true;
		ForAllElement mal = new ForAllElement() {
			@Override
			protected void process(Element obj) {
				checkForReferenceProcessor(obj);
			}
		};
		mal.processPreOrderComponentInstance(root, ComponentCategory.THREAD);
		return isOK;
	}

	protected void checkForReferenceProcessor(Element obj) {
		if (obj instanceof ComponentInstance) {
			ComponentInstance ci = (ComponentInstance) obj;
			double et = GetProperties.getMaximumComputeExecutionTimeinSec(ci);
			if (et != 0) {
				ComponentClassifier refproc = GetProperties.getReferenceProcessor(ci);
				if (refproc == null) {
					isOK = false;
					handler.error(ci, "Thread instance " + ci.getComponentInstancePath()
							+ " has execution time, but no Reference_Processor. Please this property.");
				}
			}
		}

	}

}
