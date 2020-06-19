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
package org.osate.xtext.aadl2.ui.util;

import java.io.StringReader
import org.eclipse.core.resources.IContainer
import org.eclipse.core.runtime.Path
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.parser.IParser
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.eclipse.xtext.util.OnChangeEvictingCache
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess
import org.osate.xtext.aadl2.ui.MyAadl2Activator

final class Aadl2NameValidators {
	static val parser = MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(IParser)
	// Not used locally, but clients of the class use it to reference grammar rules
	public static val grammarAccess = MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(Aadl2GrammarAccess)

	static val globalScopeProvider = MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(IGlobalScopeProvider)
	static val qNameConverter = MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(IQualifiedNameConverter)

	// Common validators
	
	/* N.B. ID is a terminal lexical item and not a parse rule.  So we use INAME which is a parse rule
	 * defined by a simple ID.
	 */
	/** Validate ID terms (simple names) */
	public static val ID_VALIDATOR = getFieldValidator(true, grammarAccess.INAMERule)
	/** Validate package names (a::b::c) */
	public static val PACKAGE_NAME_VALIDATOR = getFieldValidator(true, grammarAccess.PNAMERule)
	
	// Singleton: disallow object creation
	private new() {
		super();
	}
	
	/**
	 * Get a predicate <code>(String) => boolean</code> for testing strings based on parse rules.  Returns true if the
	 * string parses using the given rule.  Intended for use in validating field values in UI dialogs.  
	 * @param checkWhiteSpace <code>true</code> to require that the text not contain any whitespace
	 * @param rule The non-terminal parse rule to use for checking
	 */
	static def (String) => boolean getFieldValidator(boolean checkWhiteSpace, ParserRule rule) {
		if (checkWhiteSpace) {
			[fieldValue | fieldValue.matches("\\S+") && 
				!parser.parse(rule, new StringReader(fieldValue)).hasSyntaxErrors
			]
		} else {
			[fieldValue | !parser.parse(rule, new StringReader(fieldValue)).hasSyntaxErrors]
		}
	}  
	

	private static def findModelUnitInScope(IContainer parent, String modelUnitName) {
		/* Parent might be a Project, which causes problems below, so let's append
		 * a bogus folder to it.
		 */
		val fakeFolder = parent.getFolder(Path.forPosix(".fake"));
		val rsrc = new ResourceSetImpl().createResource(OsateResourceUtil.toResourceURI(fakeFolder))
		// Clear the contents even though the resource is empty so that it will be marked as loaded.
		rsrc.contents.clear
		val scope = new OnChangeEvictingCache().execWithTemporaryCaching(rsrc, [resource |
			globalScopeProvider.getScope(resource, Aadl2Package.eINSTANCE.packageSection_ImportedUnit, null)
		])
		val qualifiedName = qNameConverter.toQualifiedName(modelUnitName);
		scope.getSingleElement(qualifiedName);
	}

	/**
	 * Check if the given model unit exists in the scope of the given parent container.  Returns
	 * <code>null</code> if it is does not, or an error message it it does.
	 */
	static def validateFileNameInScope(IContainer parent, String modelUnitName) {
		/*
		 * This method checks for 4 different error conditions.  Consider three projects:
		 * A, B, and C.  Assume project C depends on both A and B, and the neither A nor B
		 * depend on any other projects.
		 *
		 * (1) We are trying to create model unit M in a project X (could be A, B, or C)
		 * and X already directly contains M.
		 *
		 * (2) We are trying to create model unit M in project C and M already
		 * exists in A or C.
		 *
		 * These first two cases are true errors: We are trying to introduce a model unit
		 * into a namespace where the model unit already exists.  The next two cases aren't
		 * really errors, but they create errors elsewhere.
		 *
		 * (3) We are trying to create model unit M in project A or B and the model unit already
		 * exists in project C.  This is not really an error because the fact that C already
		 * contains M does not affect the namespace of A or B.  But adding M to
		 * A or B will mess up C, so we disallow it.  Ideally we should use a WARNING here and
		 * not an ERROR, but the wizards don't really give us this option.
		 *
		 * (4) We are trying to create model unit M in project A and M already
		 * exists in project B.  Because C depends on both A and B, it will have two versions
		 * of M in its namespace.  Again, this does not break project A, but will mess up C,
		 * so we disallow it.  Ideally we should use a WARNING here and  not an ERROR, but the
		 * wizards don't really give us this option.
		 */
		var String errorMsg = null
		val foundInScope = findModelUnitInScope(parent, modelUnitName)
		if (foundInScope !== null) {
			val foundFile = OsateResourceUtil.toIFile(foundInScope.EObjectURI)
			val foundProject = foundFile.getProject()
			val label = if (foundInScope.getEClass().equals(Aadl2Package.eINSTANCE.getAadlPackage()))  "Package '" else "Property set '"
			if (foundProject === parent.getProject()) {
				// Case (1)
				errorMsg = label + modelUnitName + "' already exists in the selected project: '" + foundFile.getProjectRelativePath() + "'"
			} else {
				// Case (2)
				errorMsg = label + modelUnitName + "' already exists in project '" + foundProject.getName() + "' that the selected project depends on: '" + foundFile.getProjectRelativePath() + "'"
			}
		} else {
			/* See if the package exists in scope in any project that depends on the current project.
			 * This isn't an error for the current project, but it will mess up other projects.
			 */
			for (referencer : parent.getProject().getReferencingProjects()) {
				val foundInScopeOfReferencer = findModelUnitInScope(referencer, modelUnitName);
				if (foundInScopeOfReferencer !== null) {
					val label = if (foundInScopeOfReferencer.getEClass().equals(Aadl2Package.eINSTANCE.getAadlPackage())) "Package '" else "Property set '"
					val foundFile = OsateResourceUtil.toIFile(foundInScopeOfReferencer.EObjectURI)
					val foundProject = foundFile.getProject()
					if (foundProject === referencer) {
						// Case (3)
						errorMsg = label + modelUnitName + "' already exists in project '" + referencer.getName() + "' that depends on the selected project: '" + foundFile.getProjectRelativePath() + "'"
					} else {
						// Case (4)
						errorMsg = label + modelUnitName + "' already exists in project '" + foundProject.getName() + "' that is depended on by project '" + referencer.getName() + "' that depends on the selected project: '" + foundFile.getProjectRelativePath() + "'"
					}
				}
			}
		}

		errorMsg
	}
}
