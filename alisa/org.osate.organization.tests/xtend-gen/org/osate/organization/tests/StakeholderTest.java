package org.osate.organization.tests;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.organization.OrganizationInjectorProvider;
import org.osate.organization.organization.Organization;
import org.osate.organization.organization.OrganizationPackage;
import org.osate.organization.organization.Stakeholder;
import org.osate.organization.validation.OrganizationValidator;

@RunWith(XtextRunner.class)
@InjectWith(OrganizationInjectorProvider.class)
@SuppressWarnings("all")
public class StakeholderTest {
  @Inject
  @Extension
  private ParseHelper<Organization> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testParsing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("organization Feiler");
      _builder.newLine();
      _builder.append("stakeholder Peter");
      _builder.newLine();
      final Organization organization = this._parseHelper.parse(_builder);
      EList<Stakeholder> _stakeholder = organization.getStakeholder();
      final Stakeholder sh = _stakeholder.get(0);
      String _name = sh.getName();
      Assert.assertEquals("Peter", _name);
      String _name_1 = organization.getName();
      Assert.assertEquals("Feiler", _name_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValidation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("organization Feiler");
      _builder.newLine();
      _builder.append("stakeholder Peter");
      _builder.newLine();
      _builder.append("stakeholder Peter");
      _builder.newLine();
      final Organization organization = this._parseHelper.parse(_builder);
      EClass _stakeholder = OrganizationPackage.eINSTANCE.getStakeholder();
      this._validationTestHelper.assertError(organization, _stakeholder, 
        OrganizationValidator.DUPLICATE_STAKEHOLDER, 
        "Duplicate stakeholder \'Peter\'");
      EClass _stakeholder_1 = OrganizationPackage.eINSTANCE.getStakeholder();
      this._validationTestHelper.assertError(organization, _stakeholder_1, 
        OrganizationValidator.DUPLICATE_STAKEHOLDER, 
        "Duplicate stakeholder \'Peter\'");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
