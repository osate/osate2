package org.osate.xtext.aadl2.tests;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipselabs.xtext.utils.unittesting.FluentIssueCollection;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider;
import org.osate.xtext.aadl2.tests.OsateTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2UiInjectorProvider.class)
@SuppressWarnings("all")
public class PropertyTests extends OsateTest {
  private final static String TEST_PROJECT_NAME = "test";
  
  /**
   * Must build workspace before running any test. Otherwise we get exceptions.
   */
  @Before
  public void setUp() {
    final IProject test_project = this.createProject(PropertyTests.TEST_PROJECT_NAME, "packages");
    this.buildProject("Plugin_Resources", true);
    this.setResourceRoot("platform:/resource/test/packages");
  }
  
  @After
  public void cleanUp() {
    this.deleteProject(PropertyTests.TEST_PROJECT_NAME);
  }
  
  @Inject
  @Extension
  private ParseHelper<ModelUnit> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private IScopeProvider _iScopeProvider;
  
  @Test
  public void scope_A() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package p1");
      _builder.newLine();
      _builder.append("public");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("with p, ps1, ps;");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("system s1 extends p::s");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("properties");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("ps::prop => 10cm;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("ps1::prop1 => 10cm;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("period => 1sec;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end s1;");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("system implementation s1.i");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subcomponents");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("d: data;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end s1.i;");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("end p1;");
      _builder.newLine();
      Pair<String, String> _mappedTo = Pair.<String, String>of("p1.aadl", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("property set ps1 is");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("len_units1: type units (cm, m => cm * 100);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("prop1: aadlinteger units ps1::len_units1 applies to (system);");
      _builder_1.newLine();
      _builder_1.append("end ps;");
      _builder_1.newLine();
      Pair<String, String> _mappedTo_1 = Pair.<String, String>of("ps1.aadl", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("property set ps is");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("len_units: type units (cm, m => cm * 100);");
      _builder_2.newLine();
      _builder_2.append("  ");
      _builder_2.append("prop: aadlinteger units ps::len_units applies to (system);");
      _builder_2.newLine();
      _builder_2.append("end ps;");
      _builder_2.newLine();
      Pair<String, String> _mappedTo_2 = Pair.<String, String>of("ps.aadl", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package p");
      _builder_3.newLine();
      _builder_3.append("public");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("with ps;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("system s");
      _builder_3.newLine();
      _builder_3.append("    ");
      _builder_3.append("properties");
      _builder_3.newLine();
      _builder_3.append("      ");
      _builder_3.append("ps::prop => 10cm;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.append("end s;");
      _builder_3.newLine();
      _builder_3.append("  ");
      _builder_3.newLine();
      _builder_3.append("end p;");
      _builder_3.newLine();
      Pair<String, String> _mappedTo_3 = Pair.<String, String>of("p.aadl", _builder_3.toString());
      this.createFiles(_mappedTo, _mappedTo_1, _mappedTo_2, _mappedTo_3);
      this.suppressSerialization();
      final FluentIssueCollection result = this.testFile("p1.aadl");
      Resource _resource = result.getResource();
      EList<EObject> _contents = _resource.getContents();
      EObject _head = IterableExtensions.<EObject>head(_contents);
      final AadlPackage pkg = ((AadlPackage) _head);
      this.assertAllCrossReferencesResolvable(pkg);
      PublicPackageSection _ownedPublicSection = pkg.getOwnedPublicSection();
      EList<Classifier> _ownedClassifiers = _ownedPublicSection.getOwnedClassifiers();
      Classifier _head_1 = IterableExtensions.<Classifier>head(_ownedClassifiers);
      final EList<PropertyAssociation> pas = _head_1.getOwnedPropertyAssociations();
      PropertyAssociation _head_2 = IterableExtensions.<PropertyAssociation>head(pas);
      Property _property = _head_2.getProperty();
      String _name = _property.getName();
      Assert.assertEquals("prop", _name);
      PropertyAssociation _last = IterableExtensions.<PropertyAssociation>last(pas);
      Property _property_1 = _last.getProperty();
      String _name_1 = _property_1.getName();
      Assert.assertEquals("Period", _name_1);
      PublicPackageSection _ownedPublicSection_1 = pkg.getOwnedPublicSection();
      EList<Classifier> _ownedClassifiers_1 = _ownedPublicSection_1.getOwnedClassifiers();
      Classifier _last_1 = IterableExtensions.<Classifier>last(_ownedClassifiers_1);
      final SystemImplementation sysImpl = ((SystemImplementation) _last_1);
      final SystemInstance instance = InstantiateModel.buildInstanceModelFile(sysImpl);
      String _name_2 = instance.getName();
      Assert.assertEquals("s1_i_Instance", _name_2);
      EList<ComponentInstance> _componentInstances = instance.getComponentInstances();
      int _size = _componentInstances.size();
      Assert.assertEquals(1, _size);
      EList<ComponentInstance> _componentInstances_1 = instance.getComponentInstances();
      ComponentInstance _head_3 = IterableExtensions.<ComponentInstance>head(_componentInstances_1);
      String _name_3 = _head_3.getName();
      Assert.assertEquals("d", _name_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
