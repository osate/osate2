package org.osate.ui.wizards

import com.google.inject.Inject
import java.io.StringReader
import org.eclipse.xtext.parser.IParser
import org.osate.ui.OsateUiPlugin
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess
import org.osate.xtext.aadl2.ui.MyAadl2Activator
import org.eclipse.xtext.scoping.IGlobalScopeProvider
import org.osate.aadl2.Aadl2Package
import org.eclipse.core.resources.IContainer
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.core.runtime.Path
import org.eclipse.core.resources.IFolder
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.ParserRule

abstract class AbstractNewModelUnitWizard extends AbstractNewFileWizard {
	@Inject private IParser parser
	// Not used locally, but subclasses need it to select parser rules
	@Inject protected Aadl2GrammarAccess grammarAccess
	@Inject private IGlobalScopeProvider globalScopeProvider
	@Inject private IQualifiedNameConverter qNameConverter;
	
	new(String titleFileType, String descriptionFileType) {
		super(titleFileType, descriptionFileType, "aadl", 1, OsateUiPlugin.^default.log, OsateUiPlugin.PLUGIN_ID)
		MyAadl2Activator.instance.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).injectMembers(this)
	}
	
	def protected (String) => boolean getFieldValidator(ParserRule rule) {
		[fieldValue | fieldValue.matches("\\S+") && 
			!parser.parse(rule, new StringReader(fieldValue)).hasSyntaxErrors
		]
	}  

	def private IEObjectDescription findModelUnitInScope(IContainer parent, String modelUnitName) {
		/* Parent might be a Project, which causes problems below, so let's append
		 * a bogus folder to it.
		 */
		val IFolder fakeFolder = parent.getFolder(Path.forPosix(".fake"))
		val Resource rsrc = OsateResourceUtil.getResource(fakeFolder)
		val scope = globalScopeProvider.getScope(rsrc, Aadl2Package.eINSTANCE.packageSection_ImportedUnit, null)
		val qualifiedName = qNameConverter.toQualifiedName(modelUnitName);
		scope.getSingleElement(qualifiedName)
	}
		
	/* Not going to get here if no project is selected, so parent will never be null */
	override String validateFileName(IContainer parent, String modelUnitName) {
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
			val foundFile = OsateResourceUtil.getOsateIFile(foundInScope.EObjectURI)
			val foundProject = foundFile.getProject()
			val label = if (foundInScope.EClass.equals(Aadl2Package.eINSTANCE.getAadlPackage())) "Package '" else "Property set '"
			if (foundProject === parent.getProject()) {
				// Case (1)
				errorMsg = label + modelUnitName + "' already exists in the selected project: '" + foundFile.projectRelativePath + "'"
			} else {
				// Case (2)
				errorMsg = label + modelUnitName + "' already exists in project '" + foundProject.name + "' that the selected project depends on: '" + foundFile.projectRelativePath + "'"
			}
		} else {
			/* See if the package exists in scope in any project that depends on the current project.
			 * This isn't an error for the current project, but it will mess up other projects.
			 */
			for (referencer : parent.getProject().referencingProjects) {
				val foundInScopeOfReferencer = findModelUnitInScope(referencer, modelUnitName)
				if (foundInScopeOfReferencer !== null) {
					val label = if (foundInScopeOfReferencer.EClass.equals(Aadl2Package.eINSTANCE.getAadlPackage())) "Package '" else "Property set '"
					val foundFile = OsateResourceUtil.getOsateIFile(foundInScopeOfReferencer.EObjectURI)
					val foundProject = foundFile.getProject()
					if (foundProject === referencer) {
						// Case (3)
						errorMsg = label + modelUnitName + "' already exists in project '" + referencer.name + "' that depends on the selected project: '" + foundFile.projectRelativePath + "'"
					} else {
						// Case (4)
						errorMsg = label + modelUnitName + "' already exists in project '" + foundProject.name + "' that is depended on by project '" + referencer.name + "' that depends on the selected project: '" + foundFile.projectRelativePath + "'"
					}
				}
			}
		}
		
		errorMsg
	}
}