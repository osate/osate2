package org.osate.analysis.security;

import java.util.Optional;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.result.AnalysisResult;
import org.osate.result.Result;
import org.osate.result.util.ResultUtil;

public class SecurityLabelChecker {

	private final SecurityPolicy policy;

	private static final Boolean DONE = Boolean.TRUE;

	private static final Boolean PRUNE = Boolean.FALSE;

	Result result;

	public SecurityLabelChecker(SecurityPolicy policy) {
		this.policy = policy;
	}

	public AnalysisResult invoke(SystemInstance root) {
		LabelPropagator propagator = new LabelPropagator(null, null);
		propagator.propagate(root);
		AnalysisResult analysisResult = ResultUtil.createAnalysisResult("Security", root);
		result = ResultUtil.createResult("", root);
		analysisResult.getResults().add(result);

		for (TreeIterator<Element> iter = EcoreUtil.getAllContents(root.eResource(), true); iter.hasNext();) {
			Element elem = iter.next();
			if (instanceSwitch.doSwitch(elem) == PRUNE) {
				iter.prune();
			}
		}
		return analysisResult;
	}

	private InstanceSwitch<Boolean> instanceSwitch = new InstanceSwitch<Boolean>() {

		/**
		 * Check if component containment complies with the security policy.
		 * Compare component's security label with the label of its container.
		 */
		@Override
		public Boolean caseComponentInstance(ComponentInstance ci) {

			if (isTrusted(ci)) {
				return DONE;
			}
			checkValidContainment(ci);
			return DONE;
		}

		/**
		 * Check feature for security policy compliance:
		 * Security labels of feature and associated data type must conform
		 * to policy.
		 */
		@Override
		public Boolean caseFeatureInstance(FeatureInstance fi) {

			if (isTrusted(fi.getContainingComponentInstance())) {
				return DONE;
			}

			checkValidContainment(fi);
			return DONE;
		}

		@Override
		public Boolean caseConnectionInstance(org.osate.aadl2.instance.ConnectionInstance object) {
			return DONE;
		};

		@Override
		public Boolean caseEndToEndFlowInstance(org.osate.aadl2.instance.EndToEndFlowInstance object) {
			return PRUNE;
		};

		@Override
		public Boolean caseSystemOperationMode(org.osate.aadl2.instance.SystemOperationMode object) {
			return DONE;
		};

		@Override
		public Boolean caseAnnexInstance(AnnexInstance object) {
			return PRUNE;
		}

		@Override
		public Boolean casePropertyAssociation(PropertyAssociation object) {
			return PRUNE;
		}

//		/**
//		 * Check connection instance for security policy compliance:
//		 * Data flow from source and destination label must conform to policy.
//		 */
//		@Override
//		public Boolean caseConnectionInstance(final ConnectionInstance conni) {
//
//			if (isTrusted(conni.getContainingComponentInstance())) {
//				return Boolean.TRUE;
//			}
//
//			// TODO: what about other connection kinds?
//			if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
//				NamedElement src = conni.getSource();
//				NamedElement dst = conni.getDestination();
//
//				return checkValidFlow(conni, src, dst);
//			}
//			return Boolean.TRUE;
//		}
//
//		/**
//		 * Check flow specification for security policy compliance:
//		 * Data flow from source and destination label must conform to policy.
//		 */
//		@Override
//		public Boolean caseFlowSpecificationInstance(FlowSpecificationInstance fsi) {
//
//			if (isTrusted(fsi.getContainingComponentInstance())) {
//				return Boolean.TRUE;
//			}
//
//			NamedElement src = fsi.getSource();
//			NamedElement dst = fsi.getDestination();
//
//			return checkValidFlow(fsi, src, dst);
//		}
//
//		/**
//		 * Check connection reference for security policy compliance:
//		 * Data flow from source and destination label must conform to policy.
//		 */
//		@Override
//		public Boolean caseConnectionReference(ConnectionReference cref) {
//			ConnectionInstance conni = (ConnectionInstance) cref.getOwner();
//
//			if (isTrusted(conni.getContainingComponentInstance())) {
//				return Boolean.TRUE;
//			}
//			// TODO: handle other connection kinds
//			if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
//				NamedElement src = cref.getSource();
//				NamedElement dst = cref.getDestination();
//
//				checkValidFlow(cref, src, dst);
//			}
//			return Boolean.TRUE;
//		}
//
	};

	private void checkValidContainment(InstanceObject io) {
		Optional<SecurityLabel> omin = LabelUtil.getMinLabel(io);
		Optional<SecurityLabel> omax = LabelUtil.getMaxLabel(io);
		Optional<SecurityLabel> olabel = LabelUtil.getLabel(io);

		if (omax.isPresent() && omin.isPresent() && !(omax.get()).dominates(omin.get())) {
			String msg = "Inconsistent security labels: " + io.getQualifiedName() + " has no valid security label";
			result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
		} else {
			omax.ifPresent(max -> {
				if (olabel.isPresent()) {
					SecurityLabel l = olabel.get();

					if (!max.dominates(l)) {
						String msg = "Security label not dominated by " + max.toString() + " of containing element";
						result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
					}
				} else {
					String msg = "Missing security label, must be dominated by " + max.toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
				}
			});
			omin.ifPresent(min -> {
				if (olabel.isPresent()) {
					SecurityLabel l = olabel.get();

					if (!l.dominates(min)) {
						String msg = "Security label does not dominate " + min.toString();
						result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, io));
					} else if (!l.equals(min)) {
						String msg = "Least privilege violation: Label should be " + min.toString();
						result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
					}
				} else {
					String msg = "Missing security label: should be " + omin.toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, io));
				}
			});
		}
	}

//	protected Boolean checkValidFlow(Element element, NamedElement src, NamedElement dst) {
//		return checkValidFlow(element, Access.FLOW, src, dst);
//	}
//
//	protected Boolean checkValidFlow(Element element, Access dir, NamedElement src, NamedElement dst) {
//		if (src == null || dst == null) {
//			return Boolean.TRUE;
//		}
//		try {
//			Optional<SecurityLabel> srcLabel = SecurityLabel.of(src);
//			Optional<SecurityLabel> dstLabel = SecurityLabel.of(dst);
//
//			if (srcLabel.isPresent() && dstLabel.isPresent()) {
//				SecurityLabel sl = srcLabel.get();
//				SecurityLabel dl = dstLabel.get();
//				if (!policy.allows(dir, sl, dl)) {
//					error(element, "Security policy violation: Flow from " + sl.toString() + " to " + dl.toString());
//				}
//			} else {
//				if (!srcLabel.isPresent() && dstLabel.isPresent()) {
//					error(src, "Missing security label for " + src.getQualifiedName());
//				}
//				if (srcLabel.isPresent() && !dstLabel.isPresent()) {
//					error(dst, "Missing security label for " + dst.getQualifiedName());
//				}
//			}
//		} catch (InvalidModelException e) {
//			error(e.getElement(), e.getMessage());
//		}
//		return Boolean.TRUE;
//	}

	boolean isTrusted(ComponentInstance ci) {
		return false;
	}

}
