package org.osate.xtext.aadl2.tests;

import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.xtext.aadl2.Aadl2UiInjectorProvider;

@RunWith(XtextRunner.class)
@InjectWith(Aadl2UiInjectorProvider.class)
@SuppressWarnings("all")
public class ScopeTests {
  @Before
  public void setUp() {
    IWorkspace _workspace = ResourcesPlugin.getWorkspace();
    final IWorkspaceRoot workspaceRoot = _workspace.getRoot();
    final IProject project = workspaceRoot.getProject("Plugin_Resources");
    boolean _exists = project.exists();
    Assert.assertTrue(_exists);
    try {
      NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
      project.build(IncrementalProjectBuilder.CLEAN_BUILD, _nullProgressMonitor);
    } catch (final Throwable _t) {
      if (_t instanceof CoreException) {
        final CoreException e = (CoreException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  @Inject
  @Extension
  private ParseHelper<AadlPackage> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Inject
  @Extension
  private IScopeProvider _iScopeProvider;
  
  @Test
  public void scope_Classifier_InMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package scopeInModes");
      _builder.newLine();
      _builder.append("public");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subprogram sb1");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("modes");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("m1: initial mode;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end sb1;");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subprogram sb2 extends sb1");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("modes");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("m2: mode;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end sb2;");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subprogram implementation sb2.i");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("subcomponents");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("d: data in modes (m1);");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end sb2.i;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("end scopeInModes;");
      _builder.newLine();
      final AadlPackage pkg = this._parseHelper.parse(_builder);
      PublicPackageSection _ownedPublicSection = pkg.getOwnedPublicSection();
      EList<Classifier> _ownedClassifiers = _ownedPublicSection.getOwnedClassifiers();
      Classifier _last = IterableExtensions.<Classifier>last(_ownedClassifiers);
      EList<DataSubcomponent> _ownedDataSubcomponents = ((SubprogramImplementation) _last).getOwnedDataSubcomponents();
      final DataSubcomponent subcomp = IterableExtensions.<DataSubcomponent>head(_ownedDataSubcomponents);
      String _name = subcomp.getName();
      Assert.assertEquals("d", _name);
      final Procedure1<DataSubcomponent> _function = new Procedure1<DataSubcomponent>() {
        public void apply(final DataSubcomponent it) {
          EReference _modalElement_InMode = Aadl2Package.eINSTANCE.getModalElement_InMode();
          ScopeTests.this.assertScope(it, _modalElement_InMode, "m2, m1");
        }
      };
      ObjectExtensions.<DataSubcomponent>operator_doubleArrow(subcomp, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void scope_CallSequence_InMode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package scopeInModes");
      _builder.newLine();
      _builder.append("public");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subprogram sb1");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end sb1;");
      _builder.newLine();
      _builder.append("  ");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subprogram implementation sb1.i1");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("modes");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("m1: initial mode;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end sb1.i1;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("  ");
      _builder.append("subprogram implementation sb1.i2 extends sb1.i1");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("calls");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("cl1: {");
      _builder.newLine();
      _builder.append("      \t");
      _builder.append("cl11: subprogram sb1;");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("} in modes (m1, m2);");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("modes");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("m2: mode;");
      _builder.newLine();
      _builder.append("  ");
      _builder.append("end sb1.i2;");
      _builder.newLine();
      _builder.newLine();
      _builder.append("end scopeInModes;");
      _builder.newLine();
      final AadlPackage pkg = this._parseHelper.parse(_builder);
      PublicPackageSection _ownedPublicSection = pkg.getOwnedPublicSection();
      EList<Classifier> _ownedClassifiers = _ownedPublicSection.getOwnedClassifiers();
      Classifier _last = IterableExtensions.<Classifier>last(_ownedClassifiers);
      EList<SubprogramCallSequence> _ownedSubprogramCallSequences = ((SubprogramImplementation) _last).getOwnedSubprogramCallSequences();
      final SubprogramCallSequence callSeq = IterableExtensions.<SubprogramCallSequence>head(_ownedSubprogramCallSequences);
      String _name = callSeq.getName();
      Assert.assertEquals("cl1", _name);
      final Procedure1<SubprogramCallSequence> _function = new Procedure1<SubprogramCallSequence>() {
        public void apply(final SubprogramCallSequence it) {
          EReference _modalElement_InMode = Aadl2Package.eINSTANCE.getModalElement_InMode();
          ScopeTests.this.assertScope(it, _modalElement_InMode, "m2, m1");
        }
      };
      ObjectExtensions.<SubprogramCallSequence>operator_doubleArrow(callSeq, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private void assertScope(final EObject context, final EReference reference, final CharSequence expected) {
    this._validationTestHelper.assertNoErrors(context);
    IScope _scope = this._iScopeProvider.getScope(context, reference);
    Iterable<IEObjectDescription> _allElements = _scope.getAllElements();
    final Function1<IEObjectDescription, QualifiedName> _function = new Function1<IEObjectDescription, QualifiedName>() {
      public QualifiedName apply(final IEObjectDescription it) {
        return it.getName();
      }
    };
    Iterable<QualifiedName> _map = IterableExtensions.<IEObjectDescription, QualifiedName>map(_allElements, _function);
    String _join = IterableExtensions.join(_map, ", ");
    Assert.assertEquals(expected, _join);
  }
}
