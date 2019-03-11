package org.osate.analysis.security;

import java.util.Optional;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.analysis.security.SecurityPolicy.Access;

public class SecurityLabelChecker extends AadlProcessingSwitch {

	private final SecurityPolicy policy;

	public SecurityLabelChecker(final AnalysisErrorReporterManager errMgr, final SecurityPolicy policy) {
		super(PROCESS_POST_ORDER_ALL, errMgr);
		this.policy = policy;
	}

	@Override
	protected void initSwitches() {

		instanceSwitch = new InstanceSwitch<String>() {

			/**
			 * Check if component containment complies with the security policy.
			 * Compare component's security label with the label of its container.
			 */
			@Override
			public String caseComponentInstance(ComponentInstance ci) {
				ComponentInstance parent = ci.getContainingComponentInstance();

				return checkValidContainment(ci, ci, parent);
			}

			/**
			 * Check connection instance for security policy compliance:
			 * Data flow from source and destination label must conform to policy.
			 */
			@Override
			public String caseConnectionInstance(final ConnectionInstance conni) {
				// TODO: what about other connection kinds?
				if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
					NamedElement src = conni.getSource();
					NamedElement dst = conni.getDestination();

					return checkValidFlow(conni, src, dst);
				}
				return DONE;
			}

			/**
			 * Check flow specification for security policy compliance:
			 * Data flow from source and destination label must conform to policy.
			 */
			@Override
			public String caseFlowSpecificationInstance(FlowSpecificationInstance fsi) {
				NamedElement src = fsi.getSource();
				NamedElement dst = fsi.getDestination();

				return checkValidFlow(fsi, src, dst);
			}

			/**
			 * Check connection reference for security policy compliance:
			 * Data flow from source and destination label must conform to policy.
			 */
			@Override
			public String caseConnectionReference(ConnectionReference cref) {
				ConnectionInstance conni = (ConnectionInstance) cref.getOwner();
				// TODO: handle other connection kinds
				if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
					NamedElement src = cref.getSource();
					NamedElement dst = cref.getDestination();

					checkValidFlow(cref, src, dst);
				}
				return DONE;
			}

			/**
			 * Check feature for security policy compliance:
			 * Security labels of feature and associated data type must conform
			 * to policy.
			 */
			@Override
			public String caseFeatureInstance(FeatureInstance fi) {
				FeatureCategory fc = fi.getCategory();
				// TODO: handle access features, feature groups
				if (fc == FeatureCategory.DATA_PORT || fc == FeatureCategory.EVENT_DATA_PORT) {
					NamedElement data = fi.getFeature().getAllClassifier();

					checkValidFlow(fi, data, fi);
				}
				ComponentInstance parent = fi.getContainingComponentInstance();

				checkValidContainment(fi, fi, parent);
				return DONE;
			}

			protected String checkValidFlow(Element element, NamedElement src, NamedElement dst) {
				return checkValidFlow(element, Access.FLOW, src, dst);
			}

			protected String checkValidContainment(Element element, NamedElement parent, NamedElement child) {
				if (parent == null || child == null) {
					return DONE;
				}
				try {
					Optional<SecurityLabel> parentLabel = SecurityLabel.of(parent);
					Optional<SecurityLabel> childLabel = SecurityLabel.of(child);

					if (parentLabel.isPresent() && childLabel.isPresent()) {
						SecurityLabel pl = parentLabel.get();
						SecurityLabel cl = childLabel.get();
						if (!policy.allows(Access.CONTAINMENT, pl, cl)) {
							error(element,
									"Security policy violation: " + cl.toString() + " contained in " + pl.toString());
						}
					} else {
						if (!parentLabel.isPresent() && childLabel.isPresent()) {
							error(parent, "Missing security label for " + parent.getQualifiedName());
						}
						if (parentLabel.isPresent() && !childLabel.isPresent()) {
							error(child, "Missing security label for " + child.getQualifiedName());
						}
					}
				} catch (InvalidModelException e) {
					error(e.getElement(), e.getMessage());
				}
				return DONE;
			}

			protected String checkValidFlow(Element element, Access dir, NamedElement src, NamedElement dst) {
				if (src == null || dst == null) {
					return DONE;
				}
				try {
					Optional<SecurityLabel> srcLabel = SecurityLabel.of(src);
					Optional<SecurityLabel> dstLabel = SecurityLabel.of(dst);

					if (srcLabel.isPresent() && dstLabel.isPresent()) {
						SecurityLabel sl = srcLabel.get();
						SecurityLabel dl = dstLabel.get();
						if (!policy.allows(dir, sl, dl)) {
							error(element,
									"Security policy violation: Flow from " + sl.toString() + " to "
									+ dl.toString());
						}
					} else {
						if (!srcLabel.isPresent() && dstLabel.isPresent()) {
							error(src, "Missing security label for " + src.getQualifiedName());
						}
						if (srcLabel.isPresent() && !dstLabel.isPresent()) {
							error(dst, "Missing security label for " + dst.getQualifiedName());
						}
					}
				} catch (InvalidModelException e) {
					error(e.getElement(), e.getMessage());
				}
				return DONE;
			}
		};
	}
}
