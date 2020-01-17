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
package org.osate.core.tests.aadl2javavalidator

import com.google.inject.Inject
import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextTest
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.testsupport.Aadl2InjectorProvider
import org.osate.testsupport.TestHelper

import static extension org.junit.Assert.assertEquals
import static extension org.osate.testsupport.AssertHelper.assertError

@RunWith(XtextRunner)
@InjectWith(Aadl2InjectorProvider)
class DataSizePropertyTest extends XtextTest {
	
	@Inject
	TestHelper<AadlPackage> testHelper

	//Tests checkDataSizeProperty
	@Test
	def void testDataSizeProperty() {
		val dataTest ='''
			package dataTest
			public
				data d1
				end d1;
				
				data implementation d1.i1
					properties
						Data_Size => 2 Bytes;
				end d1.i1;
				
				data implementation d1.i2
					subcomponents
						sub1: data;
						sub2: data;
					properties
						Data_Size => 2 Bytes;
				end d1.i2;
				
				data implementation d1.i3
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data {Data_Size => 3 Bytes;};
					properties
						Data_Size => 4 Bytes;
				end d1.i3;
				
				data implementation d1.i4
					subcomponents
						sub1: data {Data_Size => 1 KByte;};
						sub2: data {Data_Size => 500 Bytes;};
					properties
						Data_Size => 1500 Bytes;
				end d1.i4;
				
				data implementation d1.i5
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data {Data_Size => 1 Bytes;};
					properties
						Data_Size => 4 Bytes;
				end d1.i5;
				
				data implementation d1.i6
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data;
					properties
						Data_Size => 4 Bytes;
				end d1.i6;
				
				data implementation d1.i7
					subcomponents
						sub1: data {Data_Size => 5 Bytes;};
						sub2: data;
					properties
						Data_Size => 4 Bytes;
				end d1.i7;
				
				data implementation d1.i8
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data d1.i9;
					properties
						Data_Size => 3 Bytes;
				end d1.i8;
				
				data implementation d1.i9
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data {Data_Size => 1 Bytes;};
				end d1.i9;
				
				data implementation d1.i10
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data d1.i9;
					properties
						Data_Size => 2 Bytes;
				end d1.i10;
				
				data implementation d1.i11
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data d1.i12;
					properties
						Data_Size => 3 Bytes;
				end d1.i11;
				
				data implementation d1.i12
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data;
				end d1.i12;
				
				data implementation d1.i13
					subcomponents
						sub1: data {Data_Size => 1 Bytes;};
						sub2: data d1.i12;
					properties
						Data_Size => 1 Bytes;
				end d1.i13;
			end dataTest;
		'''
		val testFileResult = issues = testHelper.testString(dataTest)
		val issueCollection = new FluentIssueCollection(testFileResult.resource, newArrayList, newArrayList)
		testFileResult.resource.contents.head as AadlPackage => [
			"dataTest".assertEquals(name)
			publicSection.ownedClassifiers.get(5) => [
				"d1.i5".assertEquals(name)
				//Tests checkDataSizeProperty
				assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i5" (4 Bytes) is larger than the sum of its subcomponents (2 Bytes).')
			]
			publicSection.ownedClassifiers.get(6) => [
				"d1.i6".assertEquals(name)
				//Tests checkDataSizeProperty
				assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i6" (4 Bytes) is larger than the sum of its subcomponents (1 Bytes).')
			]
			publicSection.ownedClassifiers.get(7) => [
				"d1.i7".assertEquals(name)
				//Tests checkDataSizeProperty
				assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i7" (4 Bytes) is smaller than the sum of its subcomponents (5 Bytes).')
			]
			publicSection.ownedClassifiers.get(10) => [
				"d1.i10".assertEquals(name)
				//Tests checkDataSizeProperty
				assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i10" (2 Bytes) is smaller than the sum of its subcomponents (3 Bytes).')
			]
			publicSection.ownedClassifiers.get(11) => [
				"d1.i11".assertEquals(name)
				//Tests checkDataSizeProperty
				assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i11" (3 Bytes) is larger than the sum of its subcomponents (2 Bytes).')
			]
			publicSection.ownedClassifiers.get(13) => [
				"d1.i13".assertEquals(name)
				//Tests checkDataSizeProperty
				assertError(testFileResult.issues, issueCollection, 'Data size of "d1.i13" (1 Bytes) is smaller than the sum of its subcomponents (2 Bytes).')
			]
		]
		issueCollection.sizeIs(testFileResult.issues.size)
		assertConstraints(issueCollection)
	}
}