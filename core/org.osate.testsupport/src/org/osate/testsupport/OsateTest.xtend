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
package org.osate.testsupport

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import java.util.Comparator
import java.util.List
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
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding
import org.eclipse.xtext.validation.Issue
import org.junit.After
import org.junit.Before
import org.junit.ComparisonFailure
import org.osate.aadl2.modelsupport.util.AadlUtil
import org.osate.core.AadlNature
import org.osate.pluginsupport.PluginSupportUtil

import static extension org.eclipse.emf.ecore.util.EcoreUtil.getURI
import static extension org.junit.Assert.assertEquals
import static extension org.osate.aadl2.modelsupport.util.AadlUtil.isPredeclaredPropertySet

/**
 * Add a couple of utility methods for managing files in the test workspace
 * 
 * @deprecated Will be removed in 2.7.
 */
 @Deprecated
abstract class OsateTest extends XtextTest {
	@Inject
	IScopeProvider scopeProvider

	@Inject
	@SerializerScopeProviderBinding
	IScopeProvider serializerScopeProvider

	static val Logger LOGGER = Logger.getLogger(OsateTest);

	protected val workspaceRoot = ResourcesPlugin.workspace.root

	@Before
	def setUp() {
		createProject(projectName)
		setResourceRoot("platform:/resource/" + projectName)
	}

	@After
	def cleanUp() {
		deleteProject(projectName)
	}

	def String getProjectName() {
		class.simpleName
	}

	/**
	 * Create a project with subdirectories in the current workspace.
	 */
	def createProject(String projectName, String... srcDirs) {
		val project = workspaceRoot.getProject(projectName)
		val operation = new WorkspaceModifyOperation() {
			override def execute(IProgressMonitor monitor) {
				if (!project.exists) {
					project.create(monitor)
					project.open(monitor)

					val description = project.getDescription
					description.natureIds = #["org.eclipse.xtext.ui.shared.xtextNature", AadlNature.ID]
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

	def protected String readFile(String path) {
		var String result = ''
		try {
			val url = new URL('platform:/plugin/' + path)
			val inputStream = url.openConnection().inputStream
			val in = new BufferedReader(new InputStreamReader(inputStream))
			var String inputLine

			while ((inputLine = in.readLine()) !== null) {
				result += inputLine + '\n'
			}
			
			in.close()
		} catch (IOException e) {
			result = ''
		}
		result
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

		LOGGER.info("creating " + uri + " in test method " + this.class.simpleName + "." +
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

	/**
	 * @deprecated Use {@link AssertHelper#assertError()}
	 */
	@Deprecated
	def protected static assertError(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.ERROR, expectedMessages)
	}

	/**
	 * @deprecated Use {@link AssertHelper#assertWarning()}
	 */
	@Deprecated
	def protected static assertWarning(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		String... expectedMessages) {
		assertIssue(eObject, allIssues, issueCollection, Severity.WARNING, expectedMessages)
	}

	/**
	 * @deprecated Use {@link AssertHelper#assertIssue()}
	 */
	@Deprecated
	def protected static assertIssue(EObject eObject, List<Issue> allIssues, FluentIssueCollection issueCollection,
		Severity severity, String... expectedMessages) {
		val issuesForEObject = allIssues.filter[it.severity == severity && uriToProblem == eObject.URI]
		val messagesForEObject = issuesForEObject.map[message]
		if (messagesForEObject.toSet != expectedMessages.toSet) {
			throw new ComparisonFailure("", expectedMessages.join("\n"), messagesForEObject.join("\n"))
		}
		issuesForEObject.forEach[issueCollection.addIssue(it)]
	}

	/**
	 * @deprecated Use {@link AssertHelper#assertScope()}
	 */
	@Deprecated
	def protected assertScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(scopeProvider, context, reference, expected)
	}

	/**
	 * @deprecated Use {@link AssertHelper#assertSerializerScope()}
	 */
	@Deprecated
	def protected assertSerializerScope(EObject context, EReference reference, Iterable<String> expected) {
		assertScope(serializerScopeProvider, context, reference, expected)
	}

	@Deprecated
	def private assertScope(
		IScopeProvider scopeProvider,
		EObject context,
		EReference reference,
		Iterable<String> expected
	) {
		val expectedNames = expected.sortWith(CUSTOM_NAME_COMPARATOR).join(", ")
		val actual = scopeProvider.getScope(context, reference).allElements.filter[eObjectDescription |
			val resourceURI = eObjectDescription.EObjectURI.trimFragment
			val fileName = resourceURI.trimFileExtension.segments.last
			!PluginSupportUtil.contributedAadl.contains(resourceURI) || fileName.predeclaredPropertySet
		]
		val actualNames = actual.map[name.toString("::")].sortWith(CUSTOM_NAME_COMPARATOR).join(", ")
		expectedNames.assertEquals(actualNames)
	}

	/*
	 * Compares two aadl names such that simple names are less than qualified names.
	 * If the name is qualified then names in predeclared property sets are greater than names in other packages or property sets.
	 * 
	 * Example: "id" < "ps::id" < "Memory_Properties::Heap_Size"
	 */
	/**
	 * @deprecated Use {@link AssertHelper#CUSTOM_NAME_COMPARATOR}
	 */
	@Deprecated
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

		// Xtend requires this method to be overriden.  I should file a bug with Xtend
		override equals(Object obj) {
			class == obj.class
		}
	}
}
