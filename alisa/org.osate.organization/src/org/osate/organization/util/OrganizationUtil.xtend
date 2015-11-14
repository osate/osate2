package org.osate.organization.util
import static extension org.eclipse.xtext.EcoreUtil2.*
import org.osate.organization.organization.Stakeholder
import org.osate.organization.organization.Organization

class OrganizationUtil {
	def containingOrganization(Stakeholder sh){
		sh.getContainerOfType(typeof(Organization))
	}
}