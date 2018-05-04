package org.osate.xtext.aadl2.documentation

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider
import org.osate.xtext.aadl2.services.Aadl2GrammarAccess

import static extension org.eclipse.xtext.nodemodel.util.NodeModelUtils.getNode

class Aadl2DocumentationProvider implements IEObjectDocumentationProvider {
	@Inject
	Aadl2GrammarAccess grammarAccess
	
	override getDocumentation(EObject o) {
		val hiddenNodes = o.node?.leafNodes?.takeWhile[hidden]
		val comments = hiddenNodes?.filter[grammarElement == grammarAccess.SL_COMMENTRule]
		val aadldoc = comments?.map[text]?.filter[startsWith("---")]
		aadldoc?.map[substring(3)]?.join("\n")
	}
}