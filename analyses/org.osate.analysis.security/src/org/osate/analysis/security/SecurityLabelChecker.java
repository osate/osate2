package org.osate.analysis.security;

import java.util.Optional;

import org.osate.aadl2.Element;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.ConnectionReference;
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
			
//			@Override
//			public String caseConnectionInstance(final ConnectionInstance conni) {
//				if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
//					NamedElement src = conni.getSource();
//					NamedElement dst = conni.getDestination();
//
//					return checkValid(conni, src, dst);
//				}
//				return DONE;
//			}

			@Override
			public String caseFlowSpecificationInstance(FlowSpecificationInstance fsi) {
				NamedElement src = fsi.getSource();
				NamedElement dst = fsi.getDestination();

				return checkValid(fsi, src, dst);
			}

			@Override
			public String caseConnectionReference(ConnectionReference cref) {
				NamedElement src = cref.getSource();
				NamedElement dst = cref.getDestination();

				return checkValid(cref, src, dst);
			}

			protected String checkValid(Element element, NamedElement src, NamedElement dst) {
				if (src == null || dst == null) {
					return DONE;
				}
				try {
					Optional<SecurityLabel> srcLabel = SecurityLabel.of(src);
					Optional<SecurityLabel> dstLabel = SecurityLabel.of(dst);

					if (srcLabel.isPresent() && dstLabel.isPresent()) {
						SecurityLabel sl = srcLabel.get();
						SecurityLabel dl = dstLabel.get();
						if (!policy.isValid(Access.WRITE, sl, dl)) {
							error(element, "Security policy violation: Write access from label " + sl.toString()
									+ " to label " + dl.toString());
						}
						if (!policy.isValid(Access.READ, dl, sl)) {
							error(element, "Security policy violation: Read access from label " + dl.toString()
									+ " to label " + sl.toString());
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
