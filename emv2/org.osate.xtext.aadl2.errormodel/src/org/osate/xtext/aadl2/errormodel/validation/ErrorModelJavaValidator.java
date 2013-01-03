package org.osate.xtext.aadl2.errormodel.validation;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Connection;
import org.osate.aadl2.ConnectionEnd;
import org.osate.aadl2.Context;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature;
import org.osate.aadl2.Port;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.ElementTypeTransformation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPath;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagations;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSink;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorSource;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorTypes;
import org.osate.xtext.aadl2.errormodel.errorModel.ObservablePropagationConnection;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedObservableErrorPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMapping;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeToken;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;
import org.osate.xtext.aadl2.errormodel.errorModel.impl.ErrorModelPackageImpl;
import org.osate.xtext.aadl2.errormodel.util.EM2TypeSetUtil;
import org.osate.xtext.aadl2.errormodel.util.EM2Util;

 

public class ErrorModelJavaValidator extends AbstractErrorModelJavaValidator {

	@Override
		protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		return (eObject.eClass().getEPackage() == ErrorModelPackageImpl.eINSTANCE
				|| eObject instanceof Connection);
	}
	
	@Check(CheckType.FAST)
	public void caseErrorPropagation(
			ErrorPropagation errorPropagation) {
		checkDirectionType(errorPropagation);
		checkUniqueObservablePropagationPoint(errorPropagation);
	}
	
	@Check(CheckType.FAST)
	public void caseObservablePropagationConnection(ObservablePropagationConnection opc){
		checkObservableConnectionDirection(opc);
	}

	
	@Check(CheckType.FAST)
	public void caseErrorType(
			ErrorType et) {
		checkCyclicExtends(et);
	}
	
	@Check(CheckType.FAST)
	public void caseTypeSet(
			TypeSet ts) {
		checkTypeSetUniqueTypes(ts);
	}
	
	@Check(CheckType.FAST)
	public void caseTypeToken(
			TypeToken tt) {
		checkTypeTokenUniqueTypes(tt);
	}
	
	@Check(CheckType.FAST)
	public void caseElementTypeMapping(
			ElementTypeMapping etMapping) {
		checkElementMappingTypeConsistency(etMapping);
	}
	
	@Check(CheckType.FAST)
	public void caseElementTypeTransformation(
			ElementTypeTransformation etXform) {
		checkElementTransformTypeConsistency(etXform);
	}
	
	@Check(CheckType.NORMAL)
	public void caseErrorPropagations(
			ErrorPropagations errorPropagations) {
		checkOnePropagationAndContainmentPoint(errorPropagations);
	}
	
	@Check(CheckType.NORMAL)
	public void caseTypeMappingSet(
			TypeMappingSet tms) {
		checkElementRuleConsistency(tms);
	}
	
	@Check(CheckType.NORMAL)
	public void caseErrorModelLibrary(ErrorModelLibrary errorModelLibrary) {
		if (errorModelLibrary.getName() == null)
			errorModelLibrary.setName("etl");
		checkCyclicExtends(errorModelLibrary);
		checkUniqueErrorTypes(errorModelLibrary);
	}
	
	@Check(CheckType.NORMAL)
	public void ErrorBehaviorStateMachine(
			ErrorBehaviorStateMachine ebsm) {
		checkCyclicExtends(ebsm);
// TODO:		checkUniqueIdentifiers(ebsm);
	}
	
	@Check(CheckType.NORMAL)
	public void caseTypeUseContext(
			TypeUseContext typeUseContext) {
		checkMultipleUses(typeUseContext);
		checkMultipleErrorTypesInUsesTypes(typeUseContext);
	}
	
	@Check(CheckType.NORMAL)
	public void caseErrorSource(
			ErrorSource ef) {
		checkErrorSourceTypes(ef);
		checkFlowDirection(ef);
	}
	
	@Check(CheckType.NORMAL)
	public void caseErrorSink(
			ErrorSink ef) {
		checkErrorSinkTypes(ef);
		checkFlowDirection(ef);
	}
	
	@Check(CheckType.NORMAL)
	public void caseErrorPath(
			ErrorPath ef) {
		checkErrorPathTypes(ef);
		checkFlowDirection(ef);
	}
	
	@Check(CheckType.NORMAL)
	public void caseConnection(
			Connection conn) {
		checkConnectionErrorTypes(conn);
	}
	
	private void checkDirectionType(ErrorPropagation errorPropagation){
		DirectionType pd = errorPropagation.getDirection();
		Feature f = errorPropagation.getFeature();
		if (!Aadl2Util.isNull(f) && f instanceof Port){
			DirectionType portd = ((Port)f).getDirection();
			if (!(pd.
					getName().equalsIgnoreCase(portd.getName()) || portd == DirectionType.IN_OUT))
				error(errorPropagation,
					"Propagation direction does not match port direction.");
		}
	}
	
	private void checkOnePropagationAndContainmentPoint(ErrorPropagations errorPropagations){
		EList<ErrorPropagation> eps = errorPropagations.getPropagations();
		int epssize = eps.size();
		for (int i=0;i<epssize-1;i++){
			ErrorPropagation ep1 = eps.get(i);
			for (int k=i+1;k<epssize;k++){
				ErrorPropagation ep2 = eps.get(k);
				if (ep1.getFeature() == ep2.getFeature()){
					if (ep1.isNot() && ep2.isNot() || !ep1.isNot() && ! ep2.isNot()){
						error(ep2, (ep1.isNot()?"Error containment ":"Error propagation ")+EM2Util.getPrintName(ep2)+" already defined.");
					}
				}
			}
		}
	}
	
	private void checkFlowDirection(ErrorSource errorSource){
		ErrorPropagation ep = errorSource.getOutgoing();
		if (!Aadl2Util.isNull(ep)){
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.OUT))){
				error(errorSource,
						EM2Util.getPrintName(ep)+" of error source is not an outgoing propagation point.");
			}
		}
	}
	
	private void checkFlowDirection(ErrorSink errorSink){
		ErrorPropagation ep = errorSink.getIncoming();
		if (!Aadl2Util.isNull(ep)){
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.IN))){
				error(errorSink,
						EM2Util.getPrintName(ep)+" of error sink is not an incoming propagation point.");
			}
		}
	}
	
	private void checkFlowDirection(ErrorPath errorPath){
		ErrorPropagation ep = errorPath.getIncoming();
		if (!Aadl2Util.isNull(ep)){
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.IN))){
				error(errorPath,
					"Source "+EM2Util.getPrintName(ep)+" of error path is not an incoming propagation point.");
			}
		}
		ep = errorPath.getOutgoing();
		if (!Aadl2Util.isNull(ep)){
			DirectionType epd = ep.getDirection();
			if (!(epd.equals(DirectionType.OUT))){
				error(errorPath,
						"Target "+EM2Util.getPrintName(ep)+" of error path is not an outgoing propagation point.");
			}
		}
	}
	
	
	private void checkElementMappingTypeConsistency(ElementTypeMapping etMapping){
		ErrorType srcET = etMapping.getSource();
		ErrorType tgtET = etMapping.getTarget();
		if (!Aadl2Util.isNull(srcET) && !Aadl2Util.isNull(tgtET)){
			if (!EM2TypeSetUtil.inSameTypeHierarchy(srcET, tgtET)){
				error(etMapping,
				"Source and target error types are not in same type hierarchy");
			}
		}
	}
	
	private void checkElementTransformTypeConsistency(ElementTypeTransformation etXform){
		ErrorType srcET = etXform.getSource();
		ErrorType conET = etXform.getContributor();
		ErrorType tgtET = etXform.getTarget();
		if (!Aadl2Util.isNull(srcET) && !Aadl2Util.isNull(tgtET)){
			if (!EM2TypeSetUtil.inSameTypeHierarchy(srcET, tgtET)){
				error(etXform,
				"Source type "+srcET.getName()+" and target type "+tgtET.getName()+" are not in same type hierarchy");
			}
		}
		if (!Aadl2Util.isNull(srcET) && !Aadl2Util.isNull(conET)){
			if (!EM2TypeSetUtil.inSameTypeHierarchy(srcET, conET)){
				error(etXform,
				"Source type "+srcET.getName()+" and contributor type "+conET.getName()+" are not in same type hierarchy");
			}
		}
	}
	
	private void checkElementRuleConsistency(TypeMappingSet tms){
		HashSet<ErrorType> sourceTypes = new HashSet<ErrorType>();
		for (TypeMapping tm : tms.getMapping()){
			if (tm instanceof ElementTypeMapping){
				ErrorType et = ((ElementTypeMapping) tm).getSource();
				if (sourceTypes.contains(et)){
					error(tm,
					"Type "+et.getName()+" already being mapped");
				} else {
					sourceTypes.add(et);
				}
			}
		}
	}
	
	private void checkTypeSetUniqueTypes(TypeSet ts){
		EList<TypeToken> etlist = ts.getElementType();
		int size = etlist.size();
		for (int i = 0; i < size-1; i++) {
			TypeToken tok = etlist.get(i);
			for (int k = i+1; k < size; k++){
				TypeToken tok2 = etlist.get(k);
				if (EM2TypeSetUtil.contains(tok, tok2)||EM2TypeSetUtil.contains(tok2,tok)){
					error(ts,
							"Typeset elements "+EM2Util.getPrintName(tok)+" and "+EM2Util.getPrintName(tok2)+" are not disjoint.");
				}
			}
		}
	}
	

	private void checkTypeTokenUniqueTypes(TypeToken ts){
		HashSet<ErrorType> sourceTypes = new HashSet<ErrorType>();
		for (ErrorType et : ts.getType()){
			ErrorType root = EM2TypeSetUtil.rootType(et);
			if (sourceTypes.contains(root)){
				error(et,
						"Another element type has same root type "+root.getName()+" as "+et.getName());
			} else {
				sourceTypes.add(et);
			}
		}
	}

	private void checkMultipleUses(TypeUseContext tuc){
		HashSet<ErrorModelLibrary> etlset = new HashSet<ErrorModelLibrary>();
		for (ErrorModelLibrary etl : EM2Util.getUseTypes(tuc)){
			if (etlset.contains(etl)){
				error(tuc,
						"Error type library "+EM2Util.getPrintName(etl)+" exists more than once in 'uses types' clause");
			} else {
				etlset.add(etl);
			}
		}
	}

	private void checkMultipleErrorTypesInUsesTypes(TypeUseContext tuc){
		HashSet<ErrorTypes> etlset = new HashSet<ErrorTypes>();
		for (ErrorModelLibrary etl : EM2Util.getUseTypes(tuc)){
			EList<ErrorTypes> typeslist = etl.getTypes();
			for (ErrorTypes errorTypes : typeslist) {
				if (etlset.contains(errorTypes)){
					warning(tuc,
							"Error type or type set "+errorTypes.getName()+" in library "+etl.getName()+" exists in an earlier error type library. Please qualify any reference to it.");
				} else {
					etlset.add(errorTypes);
				}
			}
		}
	}

	private void checkUniqueObservablePropagationPoint(ErrorPropagation ep){
		if (!ep.isObservable()) return;
		for (ErrorPropagation oep : EM2Util.getContainingErrorPropagations(ep).getPropagations()){
			if (oep.isObservable() && oep != ep && oep.getName().equalsIgnoreCase(ep.getName())){
				error(ep,
						"Observable propagation point "+ep.getName()+" defined more than once in error propagations clause.");
			}
		}
		EObject searchResult = null;
		Classifier cl = AadlUtil.getContainingClassifier(ep);
		if (cl instanceof ComponentImplementation){
			searchResult = ((ComponentImplementation)cl).getType().findNamedElement(ep.getName());
		} else {
			searchResult = AadlUtil.getContainingClassifier(ep).findNamedElement(ep.getName());
		}
		if (searchResult != null){
			error(ep,
					"Observable propagation point "+ep.getName()+" conflicts with feature in component type "+cl.getName());
		}
	}
	
	private void checkObservableConnectionDirection(ObservablePropagationConnection opc){
		QualifiedObservableErrorPropagationPoint src = opc.getSource();
		QualifiedObservableErrorPropagationPoint dst = opc.getTarget();
		ErrorPropagation srcPoint = src.getObservablePoint();
		ErrorPropagation dstPoint = dst.getObservablePoint();
		if (srcPoint == null || dstPoint == null) return;
		if (!Aadl2Util.isNull(src.getSubcomponent()) && !Aadl2Util.isNull(dst.getSubcomponent())){
			if (!DirectionType.OUT.equals(srcPoint.getDirection())){
				error(opc, "Source "+srcPoint.getName()+" of observable connection must be outgoing");
			}
			if (!DirectionType.IN.equals(dstPoint.getDirection())){
				error(opc, "Destination "+dstPoint.getName()+" of observable connection must be incoming");
			}
		} else if (!Aadl2Util.isNull(src.getSubcomponent()) && Aadl2Util.isNull(dst.getSubcomponent())){
			if (!DirectionType.OUT.equals(srcPoint.getDirection())){
				error(opc, "Source "+srcPoint.getName()+" of observable connection must be outgoing");
			}
			if (!DirectionType.OUT.equals(dstPoint.getDirection())){
				error(opc, "Destination "+dstPoint.getName()+" of observable connection must be outgoing");
			}
		} else if (Aadl2Util.isNull(src.getSubcomponent()) && !Aadl2Util.isNull(dst.getSubcomponent())){
			if (!DirectionType.IN.equals(srcPoint.getDirection())){
				error(opc, "Source "+srcPoint.getName()+" of observable connection must be incoming");
			}
			if (!DirectionType.IN.equals(dstPoint.getDirection())){
				error(opc, "Destination "+dstPoint.getName()+" of observable connection must be incoming");
			}
		}
	}

	private void checkUniqueErrorTypes(ErrorModelLibrary etl){
		Hashtable<String, ErrorTypes> types = new Hashtable<String, ErrorTypes>(10,10);
		checkUniqueErrorTypes(etl, types);
	}

	private void checkUniqueErrorTypes(ErrorModelLibrary etl, Hashtable<String, ErrorTypes> types){
		for (ErrorModelLibrary xetl : etl.getExtends()){
			checkUniqueErrorTypes(xetl, types);
		}
		for (ErrorTypes et : etl.getTypes()){
			if (types.containsKey(et.getName())){
				ErrorModelLibrary xetl = EM2Util.getContainingErrorModelLibrary((ErrorTypes)types.get(et.getName()));
				if (EM2Util.getContainingErrorModelLibrary(et) == xetl){
					error(et, "Error type or type set (alias) with identifier "+et.getName()+" already exists in error type library");
				} else {
					info(et, "Error type or type set (alias) "+et.getName()+" shadows identifier in error type library "+etl.getName()+". Please qualify references to shadowed type or type set.");
				}
			} 
			types.put(et.getName(),et);
		}
	}

	private void checkCyclicExtends(ErrorModelLibrary etl){
		if (etl.getExtends() == null) return;
		HashSet<ErrorModelLibrary> result = new HashSet<ErrorModelLibrary>();
		recursiveCheckCyclicExtends(etl,result);
	}
	
	private void recursiveCheckCyclicExtends(ErrorModelLibrary etl, HashSet<ErrorModelLibrary> shetl){
		if (etl.getExtends() != null){
			shetl.add(etl);
			EList<ErrorModelLibrary> etllist = etl.getExtends();
			for (ErrorModelLibrary  xetl : etllist){
				if (shetl.contains(xetl)){
					error(xetl, "Cycle in extends of error type library "+etl.getName());
				} else {
					recursiveCheckCyclicExtends(xetl,shetl);
				}
			}
			shetl.remove(etl);
		}
	}

	private void checkCyclicExtends(ErrorType origet){
		ErrorType et = origet;
		if (et.getSuperType() == null) return;
		HashSet<ErrorType> result = new HashSet<ErrorType>();
		while (et.getSuperType() != null){
			result.add(et);
			et = et.getSuperType();
			if (result.contains(et)){
				error(origet, "Cycle in supertype hierarchy of error type "+origet.getName()+" at type "+et.getName());
				return;
			}
		}
	}

	private void checkCyclicExtends(ErrorBehaviorStateMachine origebsm){
		ErrorBehaviorStateMachine ebsm = origebsm;
		if (ebsm.getExtends() == null) return;
		HashSet<ErrorBehaviorStateMachine> result = new HashSet<ErrorBehaviorStateMachine>();
		while (ebsm.getExtends() != null){
			result.add(ebsm);
			ebsm = ebsm.getExtends();
			if (result.contains(ebsm)){
				error(origebsm, "Cycle in extends of error behavior state machine "+origebsm.getName());
				return;
			}
		}
	}
	
	private void checkErrorSourceTypes(ErrorSource ef){
		ErrorPropagation ep = ef.getOutgoing();
		if ( !EM2TypeSetUtil.contains(ep.getTypeSet(),ef.getTypeTokenConstraint())){
			error(ef,"Type token constraint "+EM2Util.getPrintName(ef.getTypeTokenConstraint())+" is not contained in type set of outgoing propagation "+EM2Util.getPrintName(ep)+EM2Util.getPrintName(ep.getTypeSet()));
		}
	}

	private void checkErrorSinkTypes(ErrorSink ef){
		ErrorPropagation ep = ef.getIncoming();
		if ( !EM2TypeSetUtil.contains(ep.getTypeSet(),ef.getTypeTokenConstraint())){
			error(ef,"Type token constraint is not contained in type set of incoming propagation \""+EM2Util.getPrintName(ep)+"\"");
		}
	}

	private void checkErrorPathTypes(ErrorPath ef){
		if (ef.getTypeTokenConstraint() != null){
			ErrorPropagation epin = ef.getIncoming();
			if ( !EM2TypeSetUtil.contains(epin.getTypeSet(),ef.getTypeTokenConstraint())){
				error(ef,"Type token constraint is not contained in type set of incoming propagation \""+EM2Util.getPrintName(epin)+"\"");
			}
		}
		if (ef.getTargetToken() != null){
			ErrorPropagation epout = ef.getOutgoing();
			if ( !EM2TypeSetUtil.contains(epout.getTypeSet(),ef.getTargetToken())){
				error(ef,"Target token is not contained in type set of outgoing propagation "+EM2Util.getPrintName(epout));
			}
		}
	}

	private void checkConnectionErrorTypes(Connection conn){
		ComponentImplementation cimpl = conn.getContainingComponentImpl();
		ConnectionEnd src = conn.getAllSource();
		Context srcCxt = conn.getAllSourceContext();
		ErrorPropagation srcprop = null;
		ErrorPropagation srccontain = null;
		ErrorPropagations srceps = null;
		if (srcCxt instanceof Subcomponent){
			ComponentClassifier cl = ((Subcomponent)srcCxt).getClassifier();
			srceps = EM2Util.getContainingErrorPropagations(cl);
		} else {
			srceps = EM2Util.getContainingErrorPropagations(cimpl);
		}
		if (srceps != null) {
			srcprop = EM2Util.findOutgoingErrorPropagation(srceps, src.getName());
			srccontain = EM2Util.findOutgoingErrorContainment(srceps, src.getName());
		}
		
		ConnectionEnd dst = conn.getAllDestination();
		Context dstCxt = conn.getAllDestinationContext();
		ErrorPropagations dsteps = null;
		ErrorPropagation dstprop = null;
		ErrorPropagation dstcontain = null;
		if (dstCxt instanceof Subcomponent){
			ComponentClassifier cl = ((Subcomponent)dstCxt).getClassifier();
			dsteps = EM2Util.getContainingErrorPropagations(cl);
		} else {
			dsteps = EM2Util.getContainingErrorPropagations(cimpl);
		}
		if (dsteps != null) {
			dstprop = EM2Util.findIncomingErrorPropagation(dsteps, dst.getName());
			dstcontain = EM2Util.findIncomingErrorContainment(dsteps, dst.getName());
		}

		if (srcprop != null && dstprop != null){
			if(! EM2TypeSetUtil.contains(dstprop.getTypeSet(),srcprop.getTypeSet())){
				error(conn,"Outgoing propagation  "+EM2Util.getPrintName(srcprop)+EM2Util.getPrintName(srcprop.getTypeSet()) +" has error types not handled by incoming propagation "+EM2Util.getPrintName(dstprop)+EM2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srccontain != null && dstcontain != null){
			if(! EM2TypeSetUtil.contains(srccontain.getTypeSet(),dstcontain.getTypeSet())){
				error(conn,"Outgoing containment  "+EM2Util.getPrintName(srcprop)+EM2Util.getPrintName(srcprop.getTypeSet()) +" does not contain error types listed by incoming containment "+EM2Util.getPrintName(dstprop)+EM2Util.getPrintName(dstprop.getTypeSet()));
			}
		}
		if (srcCxt instanceof Subcomponent && srcprop == null&&srccontain == null &&dstCxt instanceof Subcomponent&& (dstprop != null||dstcontain != null)){
			// TODO go to subcomponent's classifier
			warning(conn,"connection source has no error propagation/containment but target does: "+(dstprop!=null?EM2Util.getPrintName(dstprop):EM2Util.getPrintName(dstcontain)));
		}
		if (dstCxt instanceof Subcomponent && dstprop == null  &&dstCxt instanceof Subcomponent&& dstcontain == null && (srcprop != null||srccontain != null)){
			// TODO go to subcomponent's classifier
			warning(conn,"Connection target has no error propagation/containment but source does: "+(srcprop!=null?EM2Util.getPrintName(srcprop):EM2Util.getPrintName(srccontain)));
		}
		
		if (conn.isBidirectional()){
			// check for error flow in the opposite direction
			if (srceps != null) {
				dstprop = EM2Util.findIncomingErrorPropagation(srceps, src.getName());
				dstcontain = EM2Util.findIncomingErrorContainment(srceps, src.getName());
			}
			if (dsteps != null) {
				srcprop = EM2Util.findOutgoingErrorPropagation(dsteps, dst.getName());
				srccontain = EM2Util.findOutgoingErrorContainment(dsteps, dst.getName());
			}

			if (srcprop != null && dstprop != null){
				if(! EM2TypeSetUtil.contains(dstprop.getTypeSet(),srcprop.getTypeSet())){
					error(conn,"Outgoing propagation  "+EM2Util.getPrintName(srcprop)+EM2Util.getPrintName(srcprop.getTypeSet()) +" has error types not handled by incoming propagation "+EM2Util.getPrintName(dstprop)+EM2Util.getPrintName(dstprop.getTypeSet()));
				}
			}
			if (srccontain != null && dstcontain != null){
				if(! EM2TypeSetUtil.contains(srccontain.getTypeSet(),dstcontain.getTypeSet())){
					error(conn,"Outgoing containment  "+EM2Util.getPrintName(srcprop)+EM2Util.getPrintName(srcprop.getTypeSet()) +" does not contain error types listed by incoming containment "+EM2Util.getPrintName(dstprop)+EM2Util.getPrintName(dstprop.getTypeSet()));
				}
			}
			if (srcCxt instanceof Subcomponent &&dstCxt instanceof Subcomponent&& srcprop == null&&srccontain == null && (dstprop != null||dstcontain != null)){
				// TODO go to subcomponent's classifier
				warning(conn,"Connection source has no error propagation/containment but target does: "+(dstprop!=null?EM2Util.getPrintName(dstprop):EM2Util.getPrintName(dstcontain)));
			}
			if (dstCxt instanceof Subcomponent &&dstCxt instanceof Subcomponent&& dstprop == null && dstcontain == null && (srcprop != null||srccontain != null)){
				// TODO go to subcomponent's classifier
				warning(conn,"Connection target has no error propagation/containment but source does: "+(srcprop!=null?EM2Util.getPrintName(srcprop):EM2Util.getPrintName(srccontain)));
			}
			
		}
	}

}
