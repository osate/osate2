package org.osate.xtext.aadl2.errormodel.linking;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.eclipse.xtext.nodemodel.INode;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AnnexLibrary;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentClassifier;
import org.osate.aadl2.ContainmentPathElement;
import org.osate.aadl2.DefaultAnnexLibrary;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.FeatureGroup;
import org.osate.aadl2.FeatureGroupType;
import org.osate.aadl2.InternalFeature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.PackageSection;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.modelsupport.util.AadlUtil;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionElement;
import org.osate.xtext.aadl2.errormodel.errorModel.ConditionExpression;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorStateMachine;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorBehaviorTransition;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorDetection;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorFlow;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelLibrary;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelPackage;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorModelSubclause;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorType;
import org.osate.xtext.aadl2.errormodel.errorModel.FeatureorPPReference;
import org.osate.xtext.aadl2.errormodel.errorModel.QualifiedPropagationPoint;
import org.osate.xtext.aadl2.errormodel.errorModel.RecoverEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.RepairEvent;
import org.osate.xtext.aadl2.errormodel.errorModel.SubcomponentElement;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeMappingSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeTransformationSet;
import org.osate.xtext.aadl2.errormodel.errorModel.TypeUseContext;
import org.osate.xtext.aadl2.errormodel.util.EMV2Util;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;
import org.osate.xtext.aadl2.properties.util.EMFIndexRetrieval;

public class EMLinkingService extends PropertiesLinkingService {

	public EMLinkingService() {
		super();
	}

	/**
	 * find the closest subcomponent classifier before the element at idx.
	 * @param cpe
	 * @return
	 */
	private ComponentClassifier getLastComponentClassifier(ContainmentPathElement cpe) {
		EObject obj = cpe;
		while (obj instanceof ContainmentPathElement) {
			NamedElement el = ((ContainmentPathElement) obj).getNamedElement();
			if (el instanceof Subcomponent) {
				return ((Subcomponent) el).getAllClassifier();
			}
			obj = obj.eContainer().eContainer();
		}
		return null;
	}

	@Override
	public List<EObject> getLinkedObjects(EObject context, EReference reference, INode node)
			throws IllegalNodeException {
		final EClass requiredType = reference.getEReferenceType();
		EObject searchResult = null;
		if (requiredType == null) {
			return Collections.<EObject> emptyList();
		}
		Element cxt = (Element) context;
		final String name = getCrossRefNodeAsString(node);
		if (Aadl2Package.eINSTANCE.getNamedElement() == requiredType) {
			// containment path element
			if (context instanceof ContainmentPathElement) {
				EObject previous = context.eContainer();
				Element cxtElement = (Element) context;
				FeatureGroupType cxtFGT = null;
				String epFGPrefix = "";
				if (previous instanceof ContainmentPathElement) {
					ContainmentPathElement previousNamedElement = (ContainmentPathElement) previous;
					// use the last component on the path as context for lookup of error model elements
					ComponentClassifier cxtPathComp = getLastComponentClassifier(previousNamedElement);
					if (cxtPathComp != null) {
						cxtElement = cxtPathComp;
					}
					// deal with feature groups and features as identifiers of error propagations
					NamedElement ne = previousNamedElement.getNamedElement();
					if (ne instanceof FeatureGroup) {
						FeatureGroup fg = (FeatureGroup) ne;
						cxtFGT = fg.getAllFeatureGroupType();
						epFGPrefix = fg.getName() + ".";
						EObject obj = previousNamedElement;
						while (obj instanceof ContainmentPathElement) {
							NamedElement prevne = ((ContainmentPathElement) obj).getNamedElement();
							if (prevne instanceof FeatureGroup) {
								epFGPrefix = epFGPrefix + ((FeatureGroup) prevne).getName() + ".";
							} else if (prevne instanceof ErrorPropagation) {
								epFGPrefix = epFGPrefix + EMV2Util.getPrintName((ErrorPropagation) prevne) + ".";
								break;
							} else {
								break;
							}
							obj = obj.eContainer().eContainer();
						}
					} else if (ne instanceof ErrorPropagation) {
						// we resolved previous entry to an error propagation
						// It may represent the context of the feature, e.g., when both the fg and the feature have an error propagation
						EList<FeatureorPPReference> flist = ((ErrorPropagation) ne).getFeatureorPPRefs();
						if (!flist.isEmpty()) {
							FeatureorPPReference fop = flist.get(flist.size() - 1);
							if (fop instanceof FeatureGroup) {
								cxtFGT = ((FeatureGroup) fop).getAllFeatureGroupType();
							}
						}
						epFGPrefix = EMV2Util.getPrintName((ErrorPropagation) ne) + ".";
						cxtElement = ne;
					} else if (ne instanceof ErrorFlow) {
						cxtElement = ne;
					}
				} else {
					Classifier found = ((ContainmentPathElement) context).getContainingClassifier();
					if (found != null) {
						cxtElement = found;
					}
				}
				// find annex subclause as context for error model identifier lookup
				if (!Aadl2Util.isNull(cxtElement)) {
					searchResult = EMV2Util.findErrorPropagation(cxtElement, epFGPrefix + name, DirectionType.OUT);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findErrorPropagation(cxtElement, epFGPrefix + name, DirectionType.IN);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findPropagationPoint(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findErrorFlow(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findErrorBehaviorEvent(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findErrorBehaviorState(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findErrorBehaviorTransition(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findErrorDetection(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findOutgoingPropagationCondition(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = EMV2Util.findConnectionErrorSource(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					if (cxtFGT != null) {
						// if previous element was feature group, look up next feature group in its type
						// we do not want to return features as they should get resolved to an error propagation
						NamedElement finding = cxtFGT.findNamedElement(name);
						if (finding instanceof FeatureGroup) {
							searchResult = finding;
						}
					}
					if (cxtElement instanceof Classifier) {
						// look up subcomponent in classifier of previous subcomponent, or feature group
						// we do not want to return features as they should get resolved to an error propagation
						NamedElement finding = ((Classifier) cxtElement).findNamedElement(name);
						if (finding != null) {
							searchResult = finding;
						}
					}
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = findErrorType(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
					searchResult = findTypeSet(cxtElement, name);
					if (searchResult != null) {
						return Collections.singletonList(searchResult);
					}
				}
			} else if (context instanceof RecoverEvent || context instanceof RepairEvent) {
				Classifier ns = AadlUtil.getContainingClassifier(context);
				searchResult = ns.findNamedElement(name);
// checked by validator
//				if (ne instanceof ModeTransition || ne instanceof EventPort || ne instanceof InternalEvent){
//					searchResult = ne;
//				}
			} else if (context instanceof FeatureorPPReference) {
				ErrorPropagation ep = (ErrorPropagation) context.eContainer();
				EList<FeatureorPPReference> frefs = ep.getFeatureorPPRefs();
				int idx = frefs.indexOf(context);
				Classifier cl = null;
				if (idx > 0) {
					FeatureorPPReference enclosingfg = frefs.get(idx - 1);
					NamedElement fg = enclosingfg.getFeatureorPP();
					if (fg instanceof FeatureGroup) {
						cl = ((FeatureGroup) fg).getFeatureGroupType();
					}
				} else {
					cl = AadlUtil.getContainingClassifier(context);
				}
				if (cl != null) {
					NamedElement ne = cl.findNamedElement(name);
					if (ne instanceof Feature || ne instanceof InternalFeature) {
						searchResult = ne;
					} else {
						// find propagation point
						searchResult = EMV2Util.findPropagationPoint(cl, name);
					}
				}
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorType() == requiredType) {
			searchResult = findErrorType(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeSet() == requiredType) {
			searchResult = findTypeSet(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorTypes() == requiredType) {
			searchResult = findErrorType(cxt, name);
			if (searchResult == null) {
				searchResult = findTypeSet(cxt, name);
			}

		} else if (ErrorModelPackage.eINSTANCE.getPropagationPoint() == requiredType) {
			ComponentClassifier cl;
			// find propagation point
			if (context instanceof QualifiedPropagationPoint) {
				QualifiedPropagationPoint qpp = (QualifiedPropagationPoint) context;
				SubcomponentElement sub = qpp.getSubcomponents().get(qpp.getSubcomponents().size() - 1);
				cl = sub.getSubcomponent().getAllClassifier();
				if (!Aadl2Util.isNull(cl)) {
					searchResult = EMV2Util.findPropagationPoint(cl, name);
				}
			}
		} else if (ErrorModelPackage.eINSTANCE.getErrorModelLibrary() == requiredType) {
			searchResult = findErrorModelLibrary(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorStateOrTypeSet() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorState(cxt, name);
			if (searchResult == null) {
				searchResult = findTypeSet(cxt, name);
			}

		} else if (ErrorModelPackage.eINSTANCE.getErrorPropagation() == requiredType) {
			if (reference.getName().equalsIgnoreCase("outgoing")) {
				searchResult = EMV2Util.findErrorPropagation(cxt, name, DirectionType.OUT);
			} else if (reference.getName().equalsIgnoreCase("incoming")) {
				searchResult = EMV2Util.findErrorPropagation(cxt, name, DirectionType.IN);
			} else {
				searchResult = EMV2Util.findErrorPropagation(cxt, name, null);
			}

		} else if (ErrorModelPackage.eINSTANCE.getTypeMappingSet() == requiredType) {
			searchResult = findTypeMappingSet(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getTypeTransformationSet() == requiredType) {
			searchResult = findTypeTransformationSet(context, name);
		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorStateMachine() == requiredType) {
			searchResult = findErrorBehaviorStateMachine(context, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorState() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorState((Element) context, name);

		} else if (ErrorModelPackage.eINSTANCE.getEventOrPropagation() == requiredType) {
			searchResult = EMV2Util.findErrorPropagation(cxt, name, DirectionType.IN);
			if (searchResult == null) {
				if (context instanceof ConditionExpression
						&& (EMV2Util.getConditionExpressionContext((ConditionExpression) context) instanceof ErrorDetection || EMV2Util
								.getConditionExpressionContext((ConditionExpression) context) instanceof ErrorBehaviorTransition)) {
					// find it only for transitions
					searchResult = EMV2Util.findErrorBehaviorEvent(cxt, name);
				}
			}

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorEvent() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorEvent(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorBehaviorTransition() == requiredType) {
			searchResult = EMV2Util.findErrorBehaviorTransition(cxt, name);

		} else if (ErrorModelPackage.eINSTANCE.getErrorFlow() == requiredType) {
			searchResult = EMV2Util.findErrorFlow(cxt.getContainingClassifier(), name);

		} else if (Aadl2Package.eINSTANCE.getSubcomponent() == requiredType) {
//		} else if (Aadl2Package.eINSTANCE.getSubcomponent().isSuperTypeOf(requiredType)) {
			if (context instanceof SubcomponentElement) {
				EObject ce = context.eContainer();
				EList<SubcomponentElement> sublist = (ce instanceof ConditionElement) ? ((ConditionElement) ce)
						.getSubcomponents() : ((QualifiedPropagationPoint) ce).getSubcomponents();
				int idx = sublist.indexOf(context);
				Classifier ns = AadlUtil.getContainingClassifier(context);
				if (idx > 0) {
					SubcomponentElement se = sublist.get(idx - 1);
					Subcomponent subcomponent = se.getSubcomponent();
					ns = subcomponent.getAllClassifier();
				}
				if (ns != null) {
					EObject res = ns.findNamedElement(name);
					if (res instanceof Subcomponent) {
						searchResult = res;
					}
				}
			}
		}
		if (searchResult != null) {
			return Collections.singletonList(searchResult);
		}
		return Collections.<EObject> emptyList();
	}

	/**
	 * name is qualified with annex name
	 * @param context
	 * @param name
	 * @return
	 */
	public AnnexLibrary getActualAnnexLibrary(EObject context, String name) {
		EObject eo = EMFIndexRetrieval.getEObjectOfType(context, ErrorModelPackage.eINSTANCE.getErrorModelLibrary(),
				name);
		if (eo instanceof ErrorModelLibrary) {
			ErrorModelLibrary dal = (ErrorModelLibrary) eo;
			if (dal != null) {
				return dal;// .getParsedAnnexLibrary();
			}
		}
		return null;
	}

	/**
	 * name is qualified with annex name
	 * @param context
	 * @param name
	 * @return
	 */
	public AnnexSubclause getActualAnnexSubclause(EObject context, String name) {
		ErrorModelSubclause dasc = (ErrorModelSubclause) EMFIndexRetrieval.getEObjectOfType(context,
				ErrorModelPackage.eINSTANCE.getErrorModelSubclause(), name);
		if (dasc != null) {
			return dasc;// .getParsedAnnexSubclause();
		}
		return null;
	}

	/**
	 * find the error model library. The String name refers to the package and the default EML name is added ("emv2")
	 * @param context context of search to identify package and EML
	 * @param name
	 * @return
	 */
	public ErrorModelLibrary findErrorModelLibrary(EObject context, String name) {
		ErrorModelLibrary eml = (ErrorModelLibrary) getActualAnnexLibrary(context, "emv2$" + name);
		if (eml != null) {
			return eml;
		}
		ErrorModelLibrary owneml = EMV2Util.getContainingErrorModelLibrary((Element) context);
		if (owneml != null) {
			AadlPackage pack = AadlUtil.getContainingPackage(context);
			if (pack != null) {
				String emlname = pack.getName();
				if (name.equalsIgnoreCase(emlname)) {
					return owneml;
				}
			}
		}
		AadlPackage ap = AadlUtil.findImportedPackage(name, AadlUtil.getContainingTopLevelNamespace(context));
		if (ap == null) {
			return null;
		}
		PackageSection ps = ap.getOwnedPublicSection();
		EList<AnnexLibrary> all = ps.getOwnedAnnexLibraries();
		for (AnnexLibrary al : all) {
			if (al instanceof DefaultAnnexLibrary) {
				DefaultAnnexLibrary dal = (DefaultAnnexLibrary) al;
				if (dal instanceof ErrorModelLibrary) {
					return (ErrorModelLibrary) dal.getParsedAnnexLibrary();
				}
			}
		}
		return null;
	}

	public TypeMappingSet findTypeMappingSet(EObject context, String name) {
		ErrorModelLibrary eml = findErrorModelLibrary(context, Aadl2Util.getPackageName(name));
		if (eml != null) {
			EList<TypeMappingSet> tmsl = eml.getMappings();
			for (TypeMappingSet tms : tmsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(tms.getName())) {
					return tms;
				}
			}
		}
		return null;
	}

	public TypeTransformationSet findTypeTransformationSet(EObject context, String name) {
		ErrorModelLibrary eml = findErrorModelLibrary(context, Aadl2Util.getPackageName(name));
		if (eml != null) {
			EList<TypeTransformationSet> tmsl = eml.getTransformations();
			for (TypeTransformationSet tms : tmsl) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(tms.getName())) {
					return tms;
				}
			}
		}
		return null;
	}

	public ErrorBehaviorStateMachine findErrorBehaviorStateMachine(EObject context, String name) {
		ErrorModelLibrary eml = findErrorModelLibrary(context, Aadl2Util.getPackageName(name));
		if (eml != null) {
			EList<ErrorBehaviorStateMachine> ebsml = eml.getBehaviors();
			for (ErrorBehaviorStateMachine ebsm : ebsml) {
				if (Aadl2Util.getItemNameWithoutQualification(name).equalsIgnoreCase(ebsm.getName())) {
					return ebsm;
				}
			}
		}
		return null;
	}

	public ErrorType findErrorType(Element context, String typeName) {
		return (ErrorType) findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getErrorType());
	}

	public TypeSet findTypeSet(Element context, String typeName) {
		return (TypeSet) findEMLNamedTypeElement(context, typeName, ErrorModelPackage.eINSTANCE.getTypeSet());
	}

	/**
	 * find an error type or type set
	 * The context is either an errormodel element, or a classifier as context of a containment path.
	 * @param context
	 * @param qualTypeName
	 * @param eclass
	 * @return
	 */
	public EObject findEMLNamedTypeElement(Element context, String qualTypeName, EClass eclass) {
		String packName = Aadl2Util.getPackageName(qualTypeName);
		String typeName = Aadl2Util.getItemNameWithoutQualification(qualTypeName);
		if (packName != null) {
			// qualified reference; look there only
			ErrorModelLibrary eml = findErrorModelLibrary(context, packName);
			// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
			return findEMLNamedTypeElement(eml, typeName, eclass);
		}
		ErrorModelLibrary owneml = EMV2Util.getContainingErrorModelLibrary(context);
		TypeUseContext tuns = EMV2Util.getContainingTypeUseContext(context);
		List<ErrorModelLibrary> otheremls = null;
		;
		if (tuns == null && context instanceof Classifier) {
			otheremls = EMV2Util.getErrorModelSubclauseWithUseTypes((Classifier) context);
		} else if (tuns != null) {
			// we are in a transformation set, mapping set etc.
			otheremls = EMV2Util.getUseTypes(tuns);
		} else if (owneml != null) {
			// lookup in own EML if we are inside an ErrorModelLibrary
			EObject res = findNamedTypeElementInThisEML(owneml, typeName, eclass);
			if (res != null) {
				return res;
			}
			otheremls = owneml.getExtends();
		}
		if (otheremls != null) {
			for (ErrorModelLibrary etll : otheremls) {
				// PHF: change to findNamedElementInThisEML if we do not make inherited names externally visible
				EObject res = findEMLNamedTypeElement(etll, typeName, eclass);
				if (res != null) {
					return res;
				}
			}
		}
		return null;
	}

	public EObject findNamedTypeElementInThisEML(ErrorModelLibrary eml, String typeName, EClass eclass) {
		if (eml == null) {
			return null;
		}
		if (eclass == ErrorModelPackage.eINSTANCE.getErrorType()) {
			EList<ErrorType> elt = eml.getTypes();
			for (ErrorType ets : elt) {
				if (typeName.equalsIgnoreCase(ets.getName())) {
					return ets;
				}
			}
		} else {
			EList<TypeSet> elt = eml.getTypesets();
			for (TypeSet ets : elt) {
				if (typeName.equalsIgnoreCase(ets.getName())) {
					return ets;
				}
			}
		}
		return null;
	}

}
