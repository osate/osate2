/**
 * Copyright 2015 Carnegie Mellon University. All Rights Reserved.
 *
 * NO WARRANTY. THIS CARNEGIE MELLON UNIVERSITY AND SOFTWARE ENGINEERING INSTITUTE
 * MATERIAL IS FURNISHED ON AN "AS-IS" BASIS. CARNEGIE MELLON UNIVERSITY MAKES NO
 * WARRANTIES OF ANY KIND, EITHER EXPRESSED OR IMPLIED, AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR PURPOSE OR MERCHANTABILITY,
 * EXCLUSIVITY, OR RESULTS OBTAINED FROM USE OF THE MATERIAL. CARNEGIE MELLON
 * UNIVERSITY DOES NOT MAKE ANY WARRANTY OF ANY KIND WITH RESPECT TO FREEDOM FROM
 * PATENT, TRADEMARK, OR COPYRIGHT INFRINGEMENT.
 *
 * Released under the Eclipse Public License (http://www.eclipse.org/org/documents/epl-v10.php)
 *
 * See COPYRIGHT file for full details.
 */

package org.osate.assure.tests

import com.google.inject.Inject
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import org.osate.testsupport.TestResourceSetHelper
import org.junit.BeforeClass
import org.eclipse.emf.ecore.resource.ResourceSet
import org.junit.Before
import org.eclipse.emf.common.util.URI
import java.net.URL
import java.io.IOException
import org.eclipse.emf.ecore.resource.Resource
import java.util.Collections
import java.io.InputStream

@RunWith(XtextRunner)
@InjectWith(FullAlisaInjectorProvider)  
class AssureTests extends XtextTest {
	@Inject
	TestHelper<AadlPackage> aadl2TestHelper

	@Inject
	TestResourceSetHelper rsHelper;

	val projectprefix = "org.osate.assure.tests/models/SimpleControlSystem/"
	val propertiesprefix = projectprefix+"Properties/"
	val aadlprefix = projectprefix+"aadl/"
	val alisaprefix = projectprefix+"alisa/"
	val resoluteprefix = projectprefix+"resolute/"
	
	var ResourceSet rset

	/**
	 * load all files into a clean resource set (reloaded with registered contributions.
	 * return the first resource as result
	 * return null if we encounter an IOException
	 * @param referencedPaths
	 * @return true if all loaded successfully
	 */
	def Resource loadFiles(String filePath, String... referencedPaths) {
		val rs = rsHelper.getResourceSet();
		return addFiles(rs, filePath, referencedPaths);
	}

	/**
	 * add files to specified resource set.
	 * return resource for first file (filePath)
	 * @param rs
	 * @param filePath
	 * @param referencedPaths
	 * @return
	 */
	def Resource addFiles(ResourceSet rs, String filePath, String... referencedPaths) {
		for (String name : referencedPaths) {
			addFile(rs,name);
		}
		return addFile(rs, filePath);
	}

	/**
	 * add specified file to resource set.
	 * return it as Resource
	 * @param rs
	 * @param filePath
	 * @return
	 */
	def Resource addFile(ResourceSet rs, String filePath) {
		val refres = rs.createResource(URI.createURI(filePath));
		try {
			val url = new URL("file:" + System.getProperty("user.dir") + "/../" + filePath);
			val inputStream = url.openConnection().getInputStream();
			refres.load(inputStream, Collections.EMPTY_MAP);
			return refres;
		} catch (IOException e) {
			return null;
		}
	}
	

	@Test
	def void aadltest() {
		val resource = loadFiles(aadlprefix+"SimpleControlSystem.aadl",propertiesprefix+"ACVIP.aadl", 
			propertiesprefix+"Physical.aadl",aadlprefix+"PhysicalResources.aadl",aadlprefix+"DataDictionary.aadl",
			aadlprefix+"Platform.aadl",aadlprefix+"Software.aadl", aadlprefix+"DigitalControlSystem.aadl"
			,alisaprefix+"sei.org" ,alisaprefix+"authors.constants" 
			,alisaprefix+"Resolute.methodregistry"
			,alisaprefix+"globalReq.reqspec" ,alisaprefix+"GlobalVPlan.verify" ,alisaprefix+"Peter.reqspec"
			, resoluteprefix+"BasicResolute.aadl"
		)
		resource.contents.head as AadlPackage => [
			"SimpleControlSystem".assertEquals(name)	
			
			]	
		}
	
}