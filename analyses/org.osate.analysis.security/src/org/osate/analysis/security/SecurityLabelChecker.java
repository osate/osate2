package org.osate.analysis.security;

import java.util.Optional;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.instance.AnnexInstance;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.properties.security.Security;
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
			checkValidContainment(fi);
			return DONE;
		}

		/**
		 * Check connection instance for security policy compliance:
		 * Data flow from source and destination label must conform to policy.
		 */
		@Override
		public Boolean caseConnectionInstance(final ConnectionInstance conni) {
			ConnectionInstanceEnd src = conni.getSource();
			ConnectionInstanceEnd dst = conni.getDestination();

			checkSameLabel(conni, src, dst);
			return DONE;
		}

		/**
		 * Check connection reference for security policy compliance:
		 * Data flow from source and destination label must be identical
		 */
//		@Override
//		public Boolean caseConnectionReference(ConnectionReference cref) {
//			ConnectionInstanceEnd src = cref.getSource();
//			ConnectionInstanceEnd dst = cref.getDestination();
//
//			checkSameLabel(cref, src, dst);
//			return PRUNE;
//		}

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

		/**
		 * Check flow specification for security policy compliance:
		 * Data flow from source and destination label must conform to policy.
		 */
		@Override
		public Boolean caseFlowSpecificationInstance(FlowSpecificationInstance fsi) {
			Optional<Boolean> trusted = Security.getDowngrading(fsi);

			if (!trusted.orElse(false)) {
				FeatureInstance src = fsi.getSource();
				FeatureInstance dst = fsi.getDestination();

				checkValidFlow(fsi, src, dst);
			}
			return DONE;
		}

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

	private void checkSameLabel(InstanceObject conn, ConnectionInstanceEnd src, ConnectionInstanceEnd dst) {
		Optional<SecurityLabel> srcLabel = LabelUtil.getLabel(src);
		Optional<SecurityLabel> dstLabel = LabelUtil.getLabel(dst);

		if (!srcLabel.isPresent() && !dstLabel.isPresent()) {
			String msg = "Missing security labels on connection ends";
			result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(msg, conn));
		} else {
			srcLabel.ifPresent(sl -> {
				if (dstLabel.isPresent()) {
					SecurityLabel dl = dstLabel.get();

					if (!sl.equals(dl)) {
						String msg = "Source security label " + sl.toString() + " does not match destination "
								+ dl.toString();
						result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, conn));
					}
				} else {
					String msg = "Missing security label on destination end: should be " + sl.toString();
					result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, conn));
				}
			});
		}
	}

	protected void checkValidFlow(InstanceObject flow, FeatureInstance src, FeatureInstance dst) {
		Optional<SecurityLabel> srcLabel = LabelUtil.getLabel(src);
		Optional<SecurityLabel> dstLabel = SecurityLabel.of(dst);

		if (!srcLabel.isPresent() && !dstLabel.isPresent()) {
			String msg = "Missing security labels on flow specification ends";
			result.getDiagnostics().add(ResultUtil.createInfoDiagnostic(msg, flow));
		} else if (srcLabel.isPresent()) {
			SecurityLabel sl = srcLabel.get();
			if (dstLabel.isPresent()) {
				SecurityLabel dl = dstLabel.get();

				if (!dl.dominates(sl)) {
					String msg = "Destination security label " + dl.toString() + " does not dominate source label "
							+ sl.toString();
					result.getDiagnostics().add(ResultUtil.createErrorDiagnostic(msg, flow));
				}
			} else {
				String msg = "Missing security label on destination end";
				result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, flow));
			}
		} else {
			String msg = "Missing security label on source end";
			result.getDiagnostics().add(ResultUtil.createWarningDiagnostic(msg, flow));
		}
	}

	boolean isTrusted(ComponentInstance ci) {
		return false;
	}

}
