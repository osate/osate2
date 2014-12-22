package org.osate.organization;

import org.eclipse.xtext.EcoreUtil2;
import org.osate.organization.organization.Organization;
import org.osate.organization.organization.Stakeholder;

@SuppressWarnings("all")
public class OrganizationUtil {
  public static Organization containingOrganization(final Stakeholder sh) {
    return EcoreUtil2.<Organization>getContainerOfType(sh, Organization.class);
  }
}
