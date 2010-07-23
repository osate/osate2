/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.annex.behavior.aadlba.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;
import fr.tpt.aadl.annex.behavior.aadlba.NamedElement;
import fr.tpt.aadl.annex.behavior.aadlba.Namespace;

import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaValidator;

import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamespaceImpl#getOwnedMember <em>Owned Member</em>}</li>
 *   <li>{@link fr.tpt.aadl.annex.behavior.aadlba.impl.NamespaceImpl#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class NamespaceImpl extends NamedElementImpl implements Namespace
{
   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   protected NamespaceImpl()
   {
      super();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   protected EClass eStaticClass()
   {
      return AadlBaPackage.Literals.NAMESPACE;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<NamedElement> getOwnedMember()
   {
      // TODO: implement this method to return the 'Owned Member' containment reference list
      // Ensure that you remove @generated or mark it @generated NOT
      // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
      // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
      throw new UnsupportedOperationException();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetOwnedMember()
   {
      // TODO: implement this method to return whether the 'Owned Member' containment reference list is set
      // Ensure that you remove @generated or mark it @generated NOT
      throw new UnsupportedOperationException();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<NamedElement> getMember()
   {
      // TODO: implement this method to return the 'Member' containment reference list
      // Ensure that you remove @generated or mark it @generated NOT
      // The list is expected to implement org.eclipse.emf.ecore.util.InternalEList and org.eclipse.emf.ecore.EStructuralFeature.Setting
      // so it's likely that an appropriate subclass of org.eclipse.emf.ecore.util.EcoreEList should be used.
      throw new UnsupportedOperationException();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean isSetMember()
   {
      // TODO: implement this method to return whether the 'Member' containment reference list is set
      // Ensure that you remove @generated or mark it @generated NOT
      throw new UnsupportedOperationException();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean members_distinguishable(DiagnosticChain diagnostics, Map<Object, Object> context)
   {
      // TODO: implement this method
      // -> specify the condition that violates the invariant
      // -> verify the details of the diagnostic, including severity and message
      // Ensure that you remove @generated or mark it @generated NOT
      if (false)
      {
         if (diagnostics != null)
         {
            diagnostics.add
               (new BasicDiagnostic
                  (Diagnostic.ERROR,
                   AadlBaValidator.DIAGNOSTIC_SOURCE,
                   AadlBaValidator.NAMESPACE__MEMBERS_DISTINGUISHABLE,
                   EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "members_distinguishable", EObjectValidator.getObjectLabel(this, context) }),
                   new Object [] { this }));
         }
         return false;
      }
      return true;
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public EList<String> getNamesOfMember(NamedElement element)
   {
      // TODO: implement this method
      // Ensure that you remove @generated or mark it @generated NOT
      throw new UnsupportedOperationException();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   public boolean membersAreDistinguishable()
   {
      // TODO: implement this method
      // Ensure that you remove @generated or mark it @generated NOT
      throw new UnsupportedOperationException();
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
   {
      switch (featureID)
      {
         case AadlBaPackage.NAMESPACE__OWNED_MEMBER:
            return ((InternalEList<?>)getOwnedMember()).basicRemove(otherEnd, msgs);
         case AadlBaPackage.NAMESPACE__MEMBER:
            return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
      }
      return super.eInverseRemove(otherEnd, featureID, msgs);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public Object eGet(int featureID, boolean resolve, boolean coreType)
   {
      switch (featureID)
      {
         case AadlBaPackage.NAMESPACE__OWNED_MEMBER:
            return getOwnedMember();
         case AadlBaPackage.NAMESPACE__MEMBER:
            return getMember();
      }
      return super.eGet(featureID, resolve, coreType);
   }

   /**
    * <!-- begin-user-doc -->
    * <!-- end-user-doc -->
    * @generated
    */
   @Override
   public boolean eIsSet(int featureID)
   {
      switch (featureID)
      {
         case AadlBaPackage.NAMESPACE__OWNED_MEMBER:
            return isSetOwnedMember();
         case AadlBaPackage.NAMESPACE__MEMBER:
            return isSetMember();
      }
      return super.eIsSet(featureID);
   }

} //NamespaceImpl
