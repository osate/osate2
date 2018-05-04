package org.osate.xtext.aadl2.ui.util;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.xtext.aadl2.ui.MyAadl2Activator;

public final class Aadl2NameValidators {
	private static final IGlobalScopeProvider globalScopeProvider = MyAadl2Activator.getInstance()
			.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(IGlobalScopeProvider.class);
	private static final IQualifiedNameConverter qNameConverter = MyAadl2Activator.getInstance()
			.getInjector(MyAadl2Activator.ORG_OSATE_XTEXT_AADL2_AADL2).getInstance(IQualifiedNameConverter.class);

	// Singleton: disallow object creation
	private Aadl2NameValidators() {
		super();
	}

	private static IEObjectDescription findModelUnitInScope(IContainer parent, String modelUnitName) {
		/* Parent might be a Project, which causes problems below, so let's append
		 * a bogus folder to it.
		 */
		final IFolder fakeFolder = parent.getFolder(Path.forPosix(".fake"));
		final Resource rsrc = OsateResourceUtil.getResource(fakeFolder);
		final IScope scope = globalScopeProvider.getScope(rsrc, Aadl2Package.eINSTANCE.getPackageSection_ImportedUnit(),
				null);
		final QualifiedName qualifiedName = qNameConverter.toQualifiedName(modelUnitName);
		return scope.getSingleElement(qualifiedName);
	}

	/**
	 * Check if the given model unit exists in the scope of the given parent container.  Returns
	 * <code>null</code> if it is does not, or an error message it it does.
	 */
	public static String validateFileNameInScope(IContainer parent, String modelUnitName) {
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
		String errorMsg = null;
		final IEObjectDescription foundInScope = findModelUnitInScope(parent, modelUnitName);
		if (foundInScope != null) {
			final IFile foundFile = OsateResourceUtil.getOsateIFile(foundInScope.getEObjectURI());
			final IProject foundProject = foundFile.getProject();
			final String label = (foundInScope.getEClass().equals(Aadl2Package.eINSTANCE.getAadlPackage())) ? "Package '" : "Property set '";
			if (foundProject.equals(parent.getProject())) {
				// Case (1)
				errorMsg = label + modelUnitName + "' already exists in the selected project: '" + foundFile.getProjectRelativePath() + "'";
			} else {
				// Case (2)
				errorMsg = label + modelUnitName + "' already exists in project '" + foundProject.getName() + "' that the selected project depends on: '" + foundFile.getProjectRelativePath() + "'";
			}
		} else {
			/* See if the package exists in scope in any project that depends on the current project.
			 * This isn't an error for the current project, but it will mess up other projects.
			 */
			for (IProject referencer : parent.getProject().getReferencingProjects()) {
				final IEObjectDescription foundInScopeOfReferencer = findModelUnitInScope(referencer, modelUnitName);
				if (foundInScopeOfReferencer != null) {
					final String label = (foundInScopeOfReferencer.getEClass().equals(Aadl2Package.eINSTANCE.getAadlPackage())) ? "Package '" : "Property set '";
					final IFile foundFile = OsateResourceUtil.getOsateIFile(foundInScopeOfReferencer.getEObjectURI());
					final IProject foundProject = foundFile.getProject();
					if (foundProject.equals(referencer)) {
						// Case (3)
						errorMsg = label + modelUnitName + "' already exists in project '" + referencer.getName() + "' that depends on the selected project: '" + foundFile.getProjectRelativePath() + "'";
					} else {
						// Case (4)
						errorMsg = label + modelUnitName + "' already exists in project '" + foundProject.getName() + "' that is depended on by project '" + referencer.getName() + "' that depends on the selected project: '" + foundFile.getProjectRelativePath() + "'";
					}
				}
			}
		}

		return errorMsg;
	}

}
