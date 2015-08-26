package org.osate.assure.jvmmodel

import com.google.inject.Inject
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.osate.assure.assure.AssuranceCase

class AssureJvmModelInferrer extends AbstractModelInferrer {
	
	@Inject extension JvmTypesBuilder
	@Inject extension IQualifiedNameProvider

	def dispatch infer(AssuranceCase entity, extension IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
		accept(entity.toClass( entity.fullyQualifiedName )) [
			
		]
	}
	
}