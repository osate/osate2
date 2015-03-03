package org.osate.assure.evaluator;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.analysis.architecture.actions.CheckA429PortConnectionConsistency;
import org.osate.analysis.architecture.actions.CheckConnectionBindingConsistency;
import org.osate.analysis.architecture.actions.DoPortConnectionConsistency;
import org.osate.analysis.architecture.actions.DoPropertyTotals;
import org.osate.analysis.flows.actions.CheckFlowLatency;
import org.osate.analysis.resource.budgets.actions.DoPowerAnalysis;
import org.osate.assure.util.AssureUtilExtension;

@SuppressWarnings("all")
public class AnalysisPluginInterface {
  public static String flowLatencyAnalysis(final InstanceObject etefi) {
    String _xblockexpression = null;
    {
      final CheckFlowLatency checker = new CheckFlowLatency();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = etefi.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        EList<SystemOperationMode> _systemOperationModes = instance.getSystemOperationModes();
        final SystemOperationMode som = IterableExtensions.<SystemOperationMode>head(_systemOperationModes);
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, instance, som);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public static String PortDataConsistency(final InstanceObject ci) {
    String _xblockexpression = null;
    {
      final DoPortConnectionConsistency checker = new DoPortConnectionConsistency();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = ci.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, instance);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public static String A429Consistency(final InstanceObject ci) {
    String _xblockexpression = null;
    {
      final CheckA429PortConnectionConsistency checker = new CheckA429PortConnectionConsistency();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = ci.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, instance);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public static String ConnectionBindingConsistency(final InstanceObject ci) {
    String _xblockexpression = null;
    {
      final CheckConnectionBindingConsistency checker = new CheckConnectionBindingConsistency();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = ci.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, instance);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public static String PowerAnalysis(final InstanceObject ci) {
    String _xblockexpression = null;
    {
      final DoPowerAnalysis checker = new DoPowerAnalysis();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = ci.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, instance);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
  
  public static String MassAnalysis(final InstanceObject ci) {
    String _xblockexpression = null;
    {
      final DoPropertyTotals checker = new DoPropertyTotals();
      final String markerType = checker.getMarkerType();
      NamedElement _elementRoot = ci.getElementRoot();
      final SystemInstance instance = ((SystemInstance) _elementRoot);
      boolean _hasRun = AssureUtilExtension.getHasRun(markerType, instance);
      boolean _not = (!_hasRun);
      if (_not) {
        try {
          NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
          checker.invoke(_nullProgressMonitor, instance);
          AssureUtilExtension.setHasRun(markerType, instance);
        } catch (final Throwable _t) {
          if (_t instanceof Throwable) {
            final Throwable e = (Throwable)_t;
            AssureUtilExtension.unsetHasRun(markerType, instance);
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      }
      _xblockexpression = markerType;
    }
    return _xblockexpression;
  }
}
