package org.osate.core.tests.aadl2javavalidator

import com.itemis.xtext.testing.FluentIssueCollection
import com.itemis.xtext.testing.XtextRunner2
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.core.test.Aadl2UiInjectorProvider
import org.osate.core.test.OsateTest

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner2)
@InjectWith(Aadl2UiInjectorProvider)
class DataSizePropertyTest extends OsateTest {
	override getProjectName() {
		"Data_Size_Property_Test"
	}
	
	//Tests checkDataSizeProperty
	@Test
	def void testDataSizeProperty() {
		val dataTestFileName = "dataTest.aadl"
		createFiles(dataTestFileName -> '''
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
		''')
		suppressSerialization
		val testFileResult = testFile(dataTestFileName)
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
		issueCollection.sizeIs(issueCollection.issues.size)
		assertConstraints(issueCollection)
	}
}