/**
 * Copyright (c) 2004-2026 Carnegie Mellon University and others. (see Contributors file).
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
package org.osate.reqspec.ui.wizards;

import java.io.StringReader;
import java.util.Map;

import org.eclipse.xtext.parser.IParser;
import org.osate.reqspec.services.ReqSpecGrammarAccess;
import org.osate.reqspec.ui.internal.ReqspecActivator;
import org.osate.ui.wizards.AbstractNewFileWizard;

import com.google.inject.Inject;

public class SystemRequirementsFileWizard extends AbstractNewFileWizard {
	private final String SYSTEM_REQUIREMENTS_LABEL = "System requirements name";
	private final String CLASSIFIER_LABEL = "Classifier";
	@Inject
	private IParser parser;
	@Inject
	private ReqSpecGrammarAccess grammarAccess;

	public SystemRequirementsFileWizard() {
		super("System Requirements", "reqspec", 1, ReqspecActivator.getInstance().getLog(), "org.osate.reqspec.ui");
		addField(SYSTEM_REQUIREMENTS_LABEL, fieldValue -> fieldValue.matches("\\S+")
				&& !parser.parse(grammarAccess.getQualifiedNameRule(), new StringReader(fieldValue)).hasSyntaxErrors());
		addField(CLASSIFIER_LABEL,
				fieldValue -> fieldValue.matches("\\S+")
						&& !parser.parse(grammarAccess.getAadlClassifierReferenceRule(), new StringReader(fieldValue))
								.hasSyntaxErrors());
	}

	@Override
	public String fileContents(final Map<String, String> fieldValues) {
		return "system requirements " + fieldValues.get(SYSTEM_REQUIREMENTS_LABEL) + " for "
				+ fieldValues.get(CLASSIFIER_LABEL) + " [\n\t\n]";
	}
}
