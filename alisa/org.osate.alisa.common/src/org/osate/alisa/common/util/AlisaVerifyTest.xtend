package org.osate.alisa.common.util

import com.google.inject.Inject
import org.apache.log4j.Logger
import org.eclipse.emf.ecore.EClass
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.resource.IEObjectDescription
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider
import org.osate.aadl2.Aadl2Package
import org.osate.aadl2.instance.ComponentInstance
import org.junit.runners.Parameterized.Parameters
import org.junit.runners.Parameterized.Parameter

abstract class AlisaVerifyTest {

	private static Logger LOGGER = Logger.getLogger(AlisaVerifyTest);
//	
//	@Parameters
//	public ComponentInstance root

	@Inject
	protected ResourceSet resourceSet;

	@Inject
	private static ResourceDescriptionsProvider rdp;
	@Inject 
	private IQualifiedNameConverter qualifiedNameConverter ;

	def EObject findGlobalEObject(EClass myEClass, String qname) {
		val rds = rdp.getResourceDescriptions(resourceSet);
		val Iterable<IEObjectDescription> classifier = rds.getExportedObjects(myEClass, qualifiedNameConverter?.toQualifiedName(qname), true);
		classifier.head.EObjectOrProxy
	}

	def EObject findComponentImplementation(String qname) {
		findGlobalEObject(Aadl2Package.eINSTANCE.componentImplementation, qname)
	}

	
	
}
