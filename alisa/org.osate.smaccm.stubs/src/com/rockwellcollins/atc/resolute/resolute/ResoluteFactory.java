/**
 */
package com.rockwellcollins.atc.resolute.resolute;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

public class ResoluteFactory implements EFactory {

	public static ResoluteFactory eINSTANCE = new ResoluteFactory();

	@Override
	public EList<EAnnotation> getEAnnotations() {
		return null;
	}

	@Override
	public EAnnotation getEAnnotation(String source) {
		return null;
	}

	@Override
	public EClass eClass() {
		return null;
	}

	@Override
	public Resource eResource() {
		return null;
	}

	@Override
	public EObject eContainer() {
		return null;
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return null;
	}

	@Override
	public EReference eContainmentFeature() {
		return null;
	}

	@Override
	public EList<EObject> eContents() {
		return null;
	}

	@Override
	public TreeIterator<EObject> eAllContents() {
		return null;
	}

	@Override
	public boolean eIsProxy() {
		return false;
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature) {
		return null;
	}

	@Override
	public Object eGet(EStructuralFeature feature, boolean resolve) {
		return null;
	}

	@Override
	public void eSet(EStructuralFeature feature, Object newValue) {
	}

	@Override
	public boolean eIsSet(EStructuralFeature feature) {
		return false;
	}

	@Override
	public void eUnset(EStructuralFeature feature) {
	}

	@Override
	public Object eInvoke(EOperation operation, EList<?> arguments) throws InvocationTargetException {
		return null;
	}

	@Override
	public EList<Adapter> eAdapters() {
		return null;
	}

	@Override
	public boolean eDeliver() {
		return false;
	}

	@Override
	public void eSetDeliver(boolean deliver) {
	}

	@Override
	public void eNotify(Notification notification) {
	}

	@Override
	public EPackage getEPackage() {
		return null;
	}

	@Override
	public void setEPackage(EPackage value) {
	}

	@Override
	public EObject create(EClass eClass) {
		return null;
	}

	@Override
	public Object createFromString(EDataType eDataType, String literalValue) {
		return null;
	}

	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		return null;
	}

	public FunctionDefinition createFunctionDefinition() {
		return new FunctionDefinition() {
			
			@Override
			public void setName(String string) {
			}
		};
	}

	public FnCallExpr createFnCallExpr() {
		return null;
	}

	public RealExpr createRealExpr() {
		return null;
	}

	public StringExpr createStringExpr() {
		return null;
	}

	public IntExpr createIntExpr() {
		return null;
	}

	public BoolExpr createBoolExpr() {
		return null;
	}

	public NestedDotID createNestedDotID() {
		return null;
	}

	public ThisExpr createThisExpr() {
		return null;
	}

}
