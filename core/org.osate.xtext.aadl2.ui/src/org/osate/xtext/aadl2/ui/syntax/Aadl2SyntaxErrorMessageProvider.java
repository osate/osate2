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
package org.osate.xtext.aadl2.ui.syntax;

import org.antlr.runtime.MismatchedTokenException;
import org.antlr.runtime.MissingTokenException;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.nodemodel.SyntaxErrorMessage;
import org.eclipse.xtext.parser.antlr.SyntaxErrorMessageProvider;
import org.osate.aadl2.AadlPackage;

public class Aadl2SyntaxErrorMessageProvider extends SyntaxErrorMessageProvider {

	@Override
	public SyntaxErrorMessage getSyntaxErrorMessage(IParserErrorContext context) {
		EObject contextobj = context.getCurrentContext();
		RecognitionException ex = context.getRecognitionException();
		String msg = context.getDefaultMessage();
		if (ex == null) {
			if (msg.endsWith("'_'")) {
				msg = "Illegal identifier";
			} else if (msg.startsWith("mismatched ch")) {
				msg = "Identifier cannot end with '_'";
			}
		}
		if (ex instanceof MissingTokenException) {
			msg = msg.replaceFirst("RULE_ID at", "identifier before");
		}
		if (ex instanceof MismatchedTokenException) {
			// mismatched input 'xxx' expecting 'end'
			msg = msg.replaceFirst("mismatched input", "Not allowed: ");
		}
		if (ex instanceof NoViableAltException) {
			// no viable alternative at input 'xxx'
			msg = msg.replaceFirst("no viable alternative at input", "Not allowed: ")
					+ ". Missing defining identifier or earlier keyword may be out of place.";
		}
		if (contextobj == null) {
			msg = "Incomplete package or property set declaration";
		} else if (contextobj instanceof AadlPackage) {
			String packname = ((AadlPackage) contextobj).getName() != null ? ((AadlPackage) contextobj).getName() : "";
			if (ex instanceof NoViableAltException) {
				msg = "Missing public or private in package " + packname;
			}
		}
		return new SyntaxErrorMessage(msg, Diagnostic.SYNTAX_DIAGNOSTIC);
	}

}
