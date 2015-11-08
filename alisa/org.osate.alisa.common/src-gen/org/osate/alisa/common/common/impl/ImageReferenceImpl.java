/**
 */
package org.osate.alisa.common.common.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.osate.alisa.common.common.CommonPackage;
import org.osate.alisa.common.common.ImageReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Image Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.osate.alisa.common.common.impl.ImageReferenceImpl#getImgfile <em>Imgfile</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ImageReferenceImpl extends MinimalEObjectImpl.Container implements ImageReference
{
  /**
   * The default value of the '{@link #getImgfile() <em>Imgfile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImgfile()
   * @generated
   * @ordered
   */
  protected static final String IMGFILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImgfile() <em>Imgfile</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImgfile()
   * @generated
   * @ordered
   */
  protected String imgfile = IMGFILE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImageReferenceImpl()
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
    return CommonPackage.Literals.IMAGE_REFERENCE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImgfile()
  {
    return imgfile;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImgfile(String newImgfile)
  {
    String oldImgfile = imgfile;
    imgfile = newImgfile;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, CommonPackage.IMAGE_REFERENCE__IMGFILE, oldImgfile, imgfile));
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
      case CommonPackage.IMAGE_REFERENCE__IMGFILE:
        return getImgfile();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case CommonPackage.IMAGE_REFERENCE__IMGFILE:
        setImgfile((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case CommonPackage.IMAGE_REFERENCE__IMGFILE:
        setImgfile(IMGFILE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
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
      case CommonPackage.IMAGE_REFERENCE__IMGFILE:
        return IMGFILE_EDEFAULT == null ? imgfile != null : !IMGFILE_EDEFAULT.equals(imgfile);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (imgfile: ");
    result.append(imgfile);
    result.append(')');
    return result.toString();
  }

} //ImageReferenceImpl
