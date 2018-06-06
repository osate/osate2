package org.osate.core.tests.issues

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.AbstractImplementation
import org.osate.aadl2.IntegerLiteral
import org.osate.aadl2.ListValue
import org.osate.aadl2.RangeValue
import org.osate.aadl2.RecordValue
import org.osate.aadl2.instantiation.InstantiateModel
import org.osate.testsupport.Aadl2UiInjectorProvider
import org.osate.testsupport.OsateTest

import static org.junit.Assert.*

@RunWith(XtextRunner)
@InjectWith(Aadl2UiInjectorProvider)
class Issue835Test extends OsateTest {
	@Test
	def void issue835() {
		val aadlFile = "issue835.aadl"
		createFiles(aadlFile -> aadlText, "ps835.aadl" -> psText)
		suppressSerialization
		val result = testFile(aadlFile)
		
		val pkg = result.resource.contents.head as AadlPackage
		val cls = pkg.ownedPublicSection.ownedClassifiers
		assertTrue('Component implementation "C.i" not found', cls.exists[name == 'C.i'])

		// instantiate
		val sysImpl = cls.findFirst[name == 'C.i'] as AbstractImplementation
		val instance = InstantiateModel::buildInstanceModelFile(sysImpl)
		assertEquals('C_i_Instance', instance.name)

		// check if Property associations have correct values
		val pas = instance.ownedPropertyAssociations
		val exp0 = pas.get(0).ownedValues.get(0).ownedValue as RecordValue
		val f0 = exp0.ownedFieldValues.get(0).ownedValue as IntegerLiteral
		assertTrue('Expected value 2 for ps835::rp.f', f0.value == 2)
		val f1 = exp0.ownedFieldValues.get(1).ownedValue as ListValue
		val e0 = f1.ownedListElements.get(0) as IntegerLiteral
		assertTrue('Expected value 2 for ps835::rp.f1#0', e0.value == 2)
		val e1 = f1.ownedListElements.get(0) as IntegerLiteral
		assertTrue('Expected value 2 for ps835::rp.f1#1', e1.value == 2)
		val exp1 = pas.get(1).ownedValues.get(0).ownedValue as RangeValue
		val min = exp1.minimum as IntegerLiteral
		assertTrue('Expected value 2 for min compute execution time', min.value == 2)
		val max = exp1.maximum as IntegerLiteral
		assertTrue('Expected value 2 for max compute execution time', max.value == 2)
	}

	val psText = '''
		property set ps835 is
			c: constant Time => 2ms;
			rt: type record (f: Time; f1: list of Time;);
			rp: ps835::rt applies to (all);
		end ps835;
	'''
	
	val aadlText = '''
		package issue835
		public
			with ps835;
			abstract C
			end C;
			
			abstract implementation C.i
				properties
					ps835::rp => [f => ps835::c; f1 => (ps835::c, ps835::c);];
					compute_execution_time => ps835::c .. ps835::c;
			end C.i;
		
		end issue835;
	'''
}