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
package org.osate.alisa.workbench.ui.wizards;

import java.io.StringReader;
import java.util.Map;

import org.eclipse.xtext.parser.IParser;
import org.osate.alisa.workbench.services.AlisaGrammarAccess;
import org.osate.alisa.workbench.ui.internal.WorkbenchActivator;
import org.osate.ui.wizards.AbstractNewFileWizard;

import com.google.inject.Inject;

public class AssurancePlanFileWizard extends AbstractNewFileWizard {
	private final String CASE_LABEL = "Assurance case name";
	private final String PLAN_LABEL = "First assurance plan name";
	private final String IMPLEMENTATION_LABEL = "Component implementation";
	@Inject
	private IParser parser;
	@Inject
	private AlisaGrammarAccess grammarAccess;

	public AssurancePlanFileWizard() {
		super("Assurance Plan", "alisa", 3, WorkbenchActivator.getInstance().getLog(), "org.osate.alisa.workbench.ui");
		addField(CASE_LABEL, fieldValue -> fieldValue.matches("\\S+")
				&& !parser.parse(grammarAccess.getQualifiedNameRule(), new StringReader(fieldValue)).hasSyntaxErrors());
		addField(PLAN_LABEL, AbstractNewFileWizard::isValidId);
		addField(IMPLEMENTATION_LABEL,
				fieldValue -> fieldValue.matches("\\S+")
						&& !parser.parse(grammarAccess.getAadlClassifierReferenceRule(), new StringReader(fieldValue))
								.hasSyntaxErrors()
						&& fieldValue.contains("."));
	}

	@Override
	public String fileContents(final Map<String, String> fieldValues) {
		final String implementationName = fieldValues.get(IMPLEMENTATION_LABEL);
		final String typeName = implementationName.substring(0, implementationName.indexOf("."));
		return "assurance case " + fieldValues.get(CASE_LABEL) + " for " + typeName + " [\n\tassurance plan "
				+ fieldValues.get(PLAN_LABEL) + " for " + implementationName + " [\n\t\t\n\t]\n]";
	}
}
