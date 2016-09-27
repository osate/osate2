/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 * 
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 * 
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 * 
 * See COPYRIGHT file for full details.
 */
package org.osate.alisa.common.validation;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.osate.alisa.common.common.AFunctionCall;
import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.typing.validation.CommonTypeSystemValidator;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class CommonValidator extends CommonTypeSystemValidator {
	public final static String UNSUPPORTED_FUNCTION = "UnSupportedFunction";

	public final static List<String> SupportedFunctions = Collections.<String> unmodifiableList(
			CollectionLiterals.<String> newArrayList("max", "min", "abs", "floor", "ceil", "round", "atTime", "prev"));

	@Check
	public void checkAFeatureCall(final AFunctionCall call) {
		String function = call.getFunction();
		if (!CommonValidator.SupportedFunctions.contains(function)) {
			this.warning("Unsupported function " + function, CommonPackage.Literals.AFUNCTION_CALL__FUNCTION,
					CommonValidator.UNSUPPORTED_FUNCTION);
		}
	}
}
