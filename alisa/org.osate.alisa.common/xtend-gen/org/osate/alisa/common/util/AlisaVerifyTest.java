package org.osate.alisa.common.util;

import com.google.inject.Inject;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.osate.aadl2.Aadl2Package;

@SuppressWarnings("all")
public abstract class AlisaVerifyTest {
  private static Logger LOGGER = Logger.getLogger(AlisaVerifyTest.class);
  
  @Inject
  protected ResourceSet resourceSet;
  
  @Inject
  private static ResourceDescriptionsProvider rdp;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public EObject findGlobalEObject(final EClass myEClass, final String qname) {
    EObject _xblockexpression = null;
    {
      final IResourceDescriptions rds = AlisaVerifyTest.rdp.getResourceDescriptions(this.resourceSet);
      QualifiedName _qualifiedName = null;
      if (this.qualifiedNameConverter!=null) {
        _qualifiedName=this.qualifiedNameConverter.toQualifiedName(qname);
      }
      final Iterable<IEObjectDescription> classifier = rds.getExportedObjects(myEClass, _qualifiedName, true);
      IEObjectDescription _head = IterableExtensions.<IEObjectDescription>head(classifier);
      _xblockexpression = _head.getEObjectOrProxy();
    }
    return _xblockexpression;
  }
  
  public EObject findComponentImplementation(final String qname) {
    EClass _componentImplementation = Aadl2Package.eINSTANCE.getComponentImplementation();
    return this.findGlobalEObject(_componentImplementation, qname);
  }
}
