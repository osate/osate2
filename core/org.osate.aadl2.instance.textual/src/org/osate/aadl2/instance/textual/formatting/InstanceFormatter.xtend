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
package org.osate.aadl2.instance.textual.formatting

import com.google.inject.Inject
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter
import org.eclipse.xtext.formatting.impl.FormattingConfig
import org.osate.aadl2.instance.textual.services.InstanceGrammarAccess

/**
 * This class contains custom formatting declarations.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
class InstanceFormatter extends AbstractDeclarativeFormatter {

	@Inject extension InstanceGrammarAccess
	
	override protected void configureFormatting(FormattingConfig c) {
		c.autoLinewrap = 1000
		findKeywordPairs("{", "}").forEach[
			c.setIndentationIncrement.after(first)
			c.setLinewrap.after(first)
			c.setIndentationDecrement.before(second)
			c.setLinewrap.before(second)
		]
		c.setLinewrap(1).after(systemOperationModeRule)
		c.setLinewrap(1).after(componentInstanceRule)
		c.setLinewrap(1).after(featureInstanceRule)
		c.setLinewrap(1).after(connectionInstanceRule)
		c.setLinewrap(1).after(connectionReferenceRule)
		c.setLinewrap(1).after(flowSpecificationInstanceRule)
		c.setLinewrap(1).after(endToEndFlowInstanceRule)
		c.setLinewrap(1).after(modeInstanceRule)
		c.setLinewrap(1).after(modeTransitionInstanceRule)
		c.setLinewrap(1).after(propertyAssociationInstanceRule)
	}
}