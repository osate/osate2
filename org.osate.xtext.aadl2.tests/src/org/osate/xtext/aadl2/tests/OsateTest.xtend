package org.osate.xtext.aadl2.tests

import java.io.ByteArrayInputStream
import org.apache.log4j.Logger
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IProject
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.Assert
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.jobs.IJobManager
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipselabs.xtext.utils.unittesting.XtextTest
import org.osate.aadl2.modelsupport.resources.PredeclaredProperties
import org.osate.core.AadlNature

/**
 * Add a couple of utility methods for managing files in the test workspace
 */
class OsateTest extends XtextTest {

	static val Logger LOGGER = Logger.getLogger(OsateTest);

	protected val workspaceRoot = ResourcesPlugin.workspace.root

	/**
      * Create a project with subdirectories in the current workspace.
      */
	def createProject(String projectName, String... srcDirs) {
		val project = workspaceRoot.getProject(projectName)
		val operation = new WorkspaceModifyOperation() {
			override def execute(IProgressMonitor monitor) {
				PredeclaredProperties.initPluginContributedAadl()
				val plugin_resources = workspaceRoot.getProject("Plugin_Resources")

				Assert.isTrue(plugin_resources.exists, "Plugin_Resources project does not exist")
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
	}

	/**
	 * Build the named project. Optionally wait until the build is done.
	 */
	def buildProject(String name, boolean wait) {
		val project = workspaceRoot.getProject(name)
		Assert.isTrue(project.exists, "Project " + name + " does not exist in the workspace")
		buildProject(project, wait)
	}

	/**
	 * Build a given project. Optionally wait until the build is done.
	 */
	def buildProject(IProject project, boolean wait) {
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

	def waitForBuild() {
		val IJobManager jobManager = Job.getJobManager();
		try {
			jobManager.join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
			jobManager.join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
		} catch (InterruptedException e) {
			// just continue
		}
	}
}
