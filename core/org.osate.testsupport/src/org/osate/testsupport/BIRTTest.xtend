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

import com.itemis.xtext.testing.XtextTest
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.net.URL
import java.util.Map
import org.eclipse.birt.core.framework.Platform
import org.eclipse.birt.report.engine.api.EngineConfig
import org.eclipse.birt.report.engine.api.EngineConstants
import org.eclipse.birt.report.engine.api.IReportEngineFactory
import org.eclipse.birt.report.engine.api.RenderOption
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.Path
import org.eclipse.core.runtime.jobs.IJobManager
import org.eclipse.core.runtime.jobs.Job
import org.eclipse.emf.common.util.URI
import org.eclipse.ui.actions.WorkspaceModifyOperation
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.osate.core.AadlNature

/*
 * TODO This test creates files in the workspace, and then the report loads them in. The JavaScript in the rptdesign
 * files should be modified to take the model objects as parameters so that the tests can be rewritten to not require a
 * workspace. 
 */
abstract class BIRTTest extends XtextTest {
	val factory = Platform.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY) as IReportEngineFactory
	val config = new EngineConfig => [appContext.put(EngineConstants.APPCONTEXT_CLASSLOADER_KEY, this.class.classLoader)]
	
	val workspaceRoot = ResourcesPlugin.workspace.root
	
	def void assertReport(String rptdesignUrl, String expectedReport, Map<String, ?> runAndRenderParameters) {
		val output = new ByteArrayOutputStream
		factory.createReportEngine(config) => [
			val report = openReportDesign(new URL(rptdesignUrl).openConnection.inputStream)
			createRunAndRenderTask(report) => [
				parameterValues = runAndRenderParameters
				renderOption = new RenderOption => [
					emitterID = "org.eclipse.birt.report.engine.emitter.html"
					outputStream = output
				]
				run
				close
			]
			destroy
		]
		val actualReport = output.toString
		Assert.assertEquals(expectedReport, actualReport.replaceAll('''AUTOGENBOOKMARK[^"]*''', '').replaceAll('''\p{Alpha}* \d{1,2}, \d{4}.{1,2}\d{1,2}:\d{2} (A|P)M''', ''))
	}
	
	// Copied from OsateTest
	@Before
	def setUp() {
		createProject(projectName)
		setResourceRoot("platform:/resource/" + projectName)
	}
	
	// Copied from OsateTest
	@After
	def cleanUp() {
		deleteProject(projectName)
	}
	
	// Copied from OsateTest
	def String getProjectName() {
		class.simpleName
	}
	
	/**
	 * Create a project with subdirectories in the current workspace.
	 */
	// Copied from OsateTest
	def createProject(String projectName, String... srcDirs) {
		val project = workspaceRoot.getProject(projectName)
		val operation = new WorkspaceModifyOperation() {
			override execute(IProgressMonitor monitor) {
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
	
	// Copied from OsateTest
	def deleteProject(String projectName) {
		val operation = new WorkspaceModifyOperation() {
			override execute(IProgressMonitor monitor) {
				workspaceRoot.getProject(projectName).delete(true, true, null)
			}
		}
		operation.run(null)
		waitForBuild
	}
	
	/**
	 * Create a set of files in the workspace given as filename -> text pairs
	 */
	// Copied from OsateTest
	def protected createFiles(Pair<String, String>... models) {
		val operation = new WorkspaceModifyOperation() {
			override execute(IProgressMonitor monitor) {
				for (Pair<String, String> model : models) {
					val uri = URI.createURI(resourceRoot + "/" + model.key)
					createFile(uri, model.value)
				}
			}
		}
		operation.run(null)
		waitForBuild
	}
	
	// Copied from OsateTest
	def IFile createFile(URI uri, String content) {
		val file = workspaceRoot.getFile(new Path(uri.toPlatformString(true)))

		Assert.assertTrue(file.getParent.exists)

		val stream = new ByteArrayInputStream(content.getBytes(file.charset))
		if (file.exists) {
			file.setContents(stream, true, true, null)
		} else {
			file.create(stream, true, null)
		}
		stream.close()
		file
	}
	
	// Copied from OsateTest
	def void waitForBuild() {
		val IJobManager jobManager = Job.getJobManager();
		try {
			jobManager.join(ResourcesPlugin.FAMILY_AUTO_BUILD, null);
			jobManager.join(ResourcesPlugin.FAMILY_MANUAL_BUILD, null);
		} catch (InterruptedException e) {
			waitForBuild
		}
	}
}