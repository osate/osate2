package org.osate.alisa.workbench.generator;

import java.util.Set;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

@SuppressWarnings("all")
public class AlisaOutputConfigurationProvider extends OutputConfigurationProvider {
  public final String ALISA_GEN = "./assure";
  
  public Set<OutputConfiguration> getOutputConfigurations() {
    Set<OutputConfiguration> _outputConfigurations = super.getOutputConfigurations();
    final Procedure1<Set<OutputConfiguration>> _function = new Procedure1<Set<OutputConfiguration>>() {
      public void apply(final Set<OutputConfiguration> it) {
        OutputConfiguration _head = IterableExtensions.<OutputConfiguration>head(it);
        _head.setOutputDirectory(AlisaOutputConfigurationProvider.this.ALISA_GEN);
      }
    };
    return ObjectExtensions.<Set<OutputConfiguration>>operator_doubleArrow(_outputConfigurations, _function);
  }
}
