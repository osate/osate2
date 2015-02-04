package org.osate.assure.ui.outline;

import com.google.inject.Inject;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.ui.PluginImageHelper;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.actions.AbstractFilterOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.assure.assure.AssurePackage;
import org.osate.assure.assure.ClaimResult;

@SuppressWarnings("all")
public class AssureFilterOperationsContribution extends AbstractFilterOutlineContribution {
  private final static String PREFERENCE_KEY = "ui.outline.filterOperations";
  
  @Inject
  private PluginImageHelper imageHelper;
  
  private EObject modelObject = null;
  
  public void setModelObject(final EObject eo) {
    this.modelObject = eo;
  }
  
  public EObject getModelObject() {
    return this.modelObject;
  }
  
  public boolean apply(final IOutlineNode node) {
    final EObjectNode nn = ((EObjectNode) node);
    final boolean result = false;
    final IStatus res = nn.<IStatus>readOnly(
      new IUnitOfWork<IStatus, EObject>() {
        public IStatus exec(final EObject eobj) throws Exception {
          if ((eobj instanceof ClaimResult)) {
            AssureFilterOperationsContribution.this.modelObject = eobj;
            return Status.OK_STATUS;
          } else {
            return Status.CANCEL_STATUS;
          }
        }
      });
    boolean _or = false;
    if ((!(node instanceof EObjectNode))) {
      _or = true;
    } else {
      EClass _eClass = ((EObjectNode) node).getEClass();
      EClass _claimResult = AssurePackage.eINSTANCE.getClaimResult();
      boolean _equals = _eClass.equals(_claimResult);
      boolean _not = (!_equals);
      _or = _not;
    }
    return _or;
  }
  
  public String getPreferenceKey() {
    return AssureFilterOperationsContribution.PREFERENCE_KEY;
  }
  
  public void configureAction(final Action action) {
    action.setText("Hide TBDs");
    action.setDescription("Hide TBDs");
    action.setToolTipText("Hide TBDs");
    ImageDescriptor _imageDescriptor = this.getImageDescriptor();
    action.setImageDescriptor(_imageDescriptor);
  }
  
  public ImageDescriptor getImageDescriptor() {
    Image _image = this.imageHelper.getImage("Operation.gif");
    return ImageDescriptor.createFromImage(_image);
  }
}
