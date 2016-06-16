package org.osate.core.test

import com.google.inject.Inject
import java.io.ByteArrayInputStream
import java.util.Comparator
import java.util.List
import java.util.Set
import org.apache.log4j.Logger
import org.eclipse.core.resources.IContainer
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.jobs.IJobManager
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding
import org.eclipse.xtext.validation.Issue
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.junit.After
import org.junit.Before
import org.junit.ComparisonFailure
import org.osate.aadl2.ModelUnit
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.core.AadlNature

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isPredeclaredPropertySet

/**
 * Add a couple of utility methods for managing files in the test workspace
 */
abstract class OsateTest extends XtextTest {
	@Inject
	IScopeProvider scopeProvider
	
	@Inject
	@SerializerScopeProviderBinding
	IScopeProvider serializerScopeProvider

	static val Logger LOGGER = Logger.getLogger(OsateTest);

	protected val workspaceRoot = ResourcesPlugin.workspace.root
	
	Set<String> pluginResourcesNames
	
	@Before
	def setUp() {
		createProject(projectName)
		buildProject("Plugin_Resources", true)
		setResourceRoot("platform:/resource/" + projectName)
	}
	
	@After
	def cleanUp() {
		deleteProject(projectName)
	}
	
	def String getProjectName()

	/**
      * Create a project with subdirectories in the current workspace.
      */
	def createProject(String projectName, String... srcDirs) {
		val project = workspaceRoot.getProject(projectName)
		val operation = new WorkspaceModifyOperation() {
			override def execute(IProgressMonitor monitor) {
				PredeclaredProperties.initPluginContributedAadl
				val plugin_resources = pluginResources
				if (!project.exists) {
					project.create(monitor)
					project.open(monitor)

					val description = project.getDescription
					description.natureIds = #["org.eclipse.xtext.ui.shared.xtextNature", AadlNature.ID]
					description.referencedProjects = #[plugin_resources]
					project.setDescription(description, monitor)

					for (srcDir : srcDirs) {
						val src = project.getFolder(srcDir)
						src.create(true, true, monitor)
					}
				}
			}
		}
		operation.run(null)

		project
	}

	def deleteProject(String projectName) {
		val operation = new WorkspaceModifyOperation() {
			override def execute(IProgressMonitor monitor) {
				workspaceRoot.getProject(projectName).delete(true, true, null)
			}
		}
		operation.run(null)
		waitForBuild
	}

	/**
	 * Build the named project. Optionally wait until the build is done.
	 */
	def buildProject(String name, boolean wait) {
		pluginResources
		val project = workspaceRoot.getProject(name)
		Assert.isTrue(project.exists, "Project " + name + " does not exist in the workspace")
		buildProject(project, wait)
	}

	/**
	 * Build a given project. Optionally wait until the build is done.
	 */
	def buildProject(IProject project, boolean wait) {
		pluginResources
		try {
			project.build(IncrementalProjectBuilder.CLEAN_BUILD, null)
		} catch (CoreException e) {
			e.printStackTrace
		}

		if (wait) {
			waitForBuild
		}
	}

	/**
	 * Check if plugin resources exists, wait up to 10s. Return project.
	 */
	def getPluginResources() {
		val project = workspaceRoot.getProject(PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME)
		var int i;
		for (; !project.exists && i < 20; i++) {
			Thread.sleep(500);
		}
		Assert.isTrue(project.exists,
			"Project " + PredeclaredProperties.PLUGIN_RESOURCES_PROJECT_NAME + " does not exist in the workspace")
		project
	}

	/**
	 * Create a set of files in the workspace given as filename -> text pairs
	 */
	def protected createFiles(Pair<String, String>... models) {
		val operation = new WorkspaceModifyOperation() {
			override def execute(IProgressMonitor monitor) {
				for (Pair<String, String> model : models) {
					val uri = URI.createURI(resourceRoot + "/" + model.key)
					createFile(uri, model.value)
				}
			}
		}
		operation.run(null)
		waitForBuild
	}

	def IFile createFile(URI uri, String content) {
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))

		Assert.isTrue(file.getParent.exists)

		LOGGER.info(
			"creating " + uri + " in test method " + this.class.simpleName + "." +
				new Throwable().fillInStackTrace.getStackTrace().get(1).methodName)

		try {
			val stream = new ByteArrayInputStream(content.getBytes(file.charset))
			if (file.exists) {
				file.setContents(stream, true, true, null)
			} else {
				file.create(stream, true, null)
			}
			stream.close()
		} catch (Exception e) {
			LOGGER.error(e)
		}
		file
	}

	def void waitForBuild() {
		val IJobManager jobManager = Job.getJobManager();
		try {
			jobManager.join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
			jobManager.join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
		} catch (InterruptedException e) {
			waitForBuild
		}
	}

	def protected static assertError(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.ERROR, expectedMessages)
	}
	
	def protected static assertWarning(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection, String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.WARNING, expectedMessages)
	}
	
	def protected static assertIssue(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection, Severity severity, String... expectedMessages) {
		val issuesForEObject = allIssues.filter[it.severity == severity && uriToProblem == eObject.URI]
		val messagesForEObject = issuesForEObject.map[message]
		if (messagesForEObject.toSet != expectedMessages.toSet) {
			throw new ComparisonFailure("", expectedMessages.join("\n"), messagesForEObject.join("\n"))
		}
		issuesForEObject.forEach[issueCollection.addIssue(it)]
	}
	
	def protected assertScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(scopeProvider, context, reference, false, expected)
	}
	
	def protected assertScopeModelUnitNamesOnly(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(scopeProvider, context, reference, true, expected)
	}
	
	def protected assertSerializerScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(serializerScopeProvider, context, reference, false, expected)
	}
	
	def private assertScope(IScopeProvider scopeProvider, EObject context, EReference reference,
		boolean scopingForModelUnits, Iterable<String> expected
	) {
		if (pluginResourcesNames == null) {
			pluginResourcesNames = pluginResources.allMembers.filter(IFile).filter[name.toLowerCase.endsWith(".aadl")].map[
				val uri = URI.createPlatformResourceURI(it.fullPath.toString, false)
				val modelUnit = context.eResource.resourceSet.getResource(uri, true).contents.head as ModelUnit
				modelUnit.name.toLowerCase
			].toSet
		}
		val expectedNames = expected.sortWith(CUSTOM_NAME_COMPARATOR).join(", ")
		val actualNames = scopeProvider.getScope(context, reference).allElements.map[name.toString("::")].filter[
			val separatorIndex = lastIndexOf("::")
			val modelUnitName = if (scopingForModelUnits || separatorIndex == -1) {
				it
			} else {
				substring(0, separatorIndex)
			}
			modelUnitName.predeclaredPropertySet || !pluginResourcesNames.contains(modelUnitName.toLowerCase)
		].sortWith(CUSTOM_NAME_COMPARATOR).join(", ")
		expectedNames.assertEquals(actualNames)
	}
	
	def private static Iterable<IResource> getAllMembers(IContainer container) {
		container.members.map[if (it instanceof IContainer) {
			allMembers
		} else {
			#[it]
		}].flatten
	}
	
	/*
	 * Compares two aadl names such that simple names are less than qualified names.
	 * If the name is qualified then names in predeclared property sets are greater than names in other packages or property sets.
	 * 
	 * Example: "id" < "ps::id" < "Memory_Properties::Heap_Size"
	 */
	val static CUSTOM_NAME_COMPARATOR = new Comparator<String>() {
		override compare(String o1, String o2) {
			val o1SeparatorIndex = o1.indexOf("::")
			val o2SeparatorIndex = o2.indexOf("::")
			if (o1SeparatorIndex == -1 && o2SeparatorIndex == -1) {
				o1.compareTo(o2)
			} else if (o1SeparatorIndex == -1) {
				-1
			} else if (o2SeparatorIndex == -1) {
				1
			} else {
				val o1PsIsPredeclared = AadlUtil::isPredeclaredPropertySet(o1.substring(0, o1SeparatorIndex))
				val o2PsIsPredeclared = AadlUtil::isPredeclaredPropertySet(o2.substring(0, o2SeparatorIndex))
				if (o1PsIsPredeclared == o2PsIsPredeclared) {
					o1.compareTo(o2)
				} else if (o2PsIsPredeclared) {
					-1
				} else {
					1
				}
			}
		}

		//Xtend requires this method to be overriden.  I should file a bug with Xtend
		override equals(Object obj) {
			class == obj.class
		}
	}
}
