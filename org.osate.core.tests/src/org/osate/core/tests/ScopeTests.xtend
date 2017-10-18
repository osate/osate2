package org.osate.core.tests

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.AadlPackage
import org.osate.aadl2.SubprogramImplementation
import org.osate.core.test.Aadl2UiInjectorProvider

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(Aadl2UiInjectorProvider))
class ScopeTests {
	@Inject extension ParseHelper<AadlPackage>
	@Inject extension ValidationTestHelper
	@Inject extension IScopeProvider

	@Test
	def void scope_Classifier_InMode() {
		val pkg = '''
			package scopeInModes
			public

			  subprogram sb1
			    modes
			      m1: initial mode;
			  end sb1;
			  
			  subprogram sb2 extends sb1
			    modes
			      m2: mode;
			  end sb2;
			  
			  subprogram implementation sb2.i
			    subcomponents
			      d: data in modes (m1);
			  end sb2.i;

			end scopeInModes;
		'''.parse
		
		val subcomp = (pkg.ownedPublicSection.ownedClassifiers.last as SubprogramImplementation).ownedDataSubcomponents.head

		Assert.assertEquals("d", subcomp.name)
		subcomp => [
			assertScope(Aadl2Package::eINSTANCE.modalElement_InMode, "m2, m1")
		]
	} 
	
	@Test
	def void scope_CallSequence_InMode() {
		val pkg = '''
			package scopeInModes
			public

			  subprogram sb1
			  end sb1;
			  
			  subprogram implementation sb1.i1
			    modes
			      m1: initial mode;
			  end sb1.i1;

			  subprogram implementation sb1.i2 extends sb1.i1
			    calls
			      cl1: {
			      	cl11: subprogram sb1;
			      } in modes (m1, m2);
			    modes
			      m2: mode;
			  end sb1.i2;

			end scopeInModes;
		'''.parse
		
		val callSeq = (pkg.ownedPublicSection.ownedClassifiers.last as SubprogramImplementation).ownedSubprogramCallSequences.head

		Assert.assertEquals("cl1", callSeq.name)
		callSeq => [
			assertScope(Aadl2Package::eINSTANCE.modalElement_InMode, "m2, m1")
		]
	} 
	
	def private assertScope(EObject context, EReference reference, CharSequence expected) {
		context.assertNoErrors
		Assert.assertEquals(expected, context.getScope(reference).allElements.map[name].join(", "))
	}
	
}
