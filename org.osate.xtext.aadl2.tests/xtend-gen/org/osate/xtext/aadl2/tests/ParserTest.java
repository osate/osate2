package org.osate.xtext.aadl2.tests;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemType;
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider;
import org.osate.xtext.aadl2.tests.OsateTest;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2UiInjectorProvider.class)
@SuppressWarnings("all")
public class ParserTest extends OsateTest {
  @Inject
  @Extension
  private ParseHelper<ModelUnit> _parseHelper;
  
  private final String projectRoot = "platform:/resource/test/";
  
  @Before
  public void setUp() {
    final IProject test_project = this.createProject("test", "packages");
    this.buildProject("Plugin_Resources", true);
    this.setResourceRoot((this.projectRoot + "packages"));
  }
  
  @Test
  public void testParsing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package example");
      _builder.newLine();
      _builder.append("public");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("system sys");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("subcomponents");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("none;");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("properties");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("none;");
      _builder.newLine();
      _builder.append("end example;");
      _builder.newLine();
      final ModelUnit model = this._parseHelper.parse(_builder);
      final AadlPackage pack = ((AadlPackage) model);
      String _name = pack.getName();
      Assert.assertEquals("example", _name);
      PublicPackageSection _publicSection = pack.getPublicSection();
      EList<Classifier> _ownedClassifiers = _publicSection.getOwnedClassifiers();
      Classifier _get = _ownedClassifiers.get(0);
      final SystemType sys = ((SystemType) _get);
      String _name_1 = sys.getName();
      Assert.assertEquals("sys", _name_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
