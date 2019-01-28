package org.osate.analysis.security;

import java.util.Optional;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionKind;
import org.osate.aadl2.instance.FlowSpecificationInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.properties.InvalidModelException;
import org.osate.analysis.security.SecurityPolicy.Access;

public class ConnectionInstanceLabelChecker extends AadlProcessingSwitch {

	private final SecurityPolicy policy;

	public ConnectionInstanceLabelChecker(final AnalysisErrorReporterManager errMgr, final SecurityPolicy policy) {
		super(PROCESS_POST_ORDER_ALL, errMgr);
		this.policy = policy;
	}

	@Override
	protected void initSwitches() {
		instanceSwitch = new InstanceSwitch<String>() {
			@Override
			public String caseConnectionInstance(final ConnectionInstance conni) {
				if (conni.getKind().equals(ConnectionKind.PORT_CONNECTION)) {
					NamedElement src = conni.getSource();
					NamedElement dst = conni.getDestination();
					if (src == null || dst == null) {
						return DONE;
					}
					try {
						Optional<SecurityLabel> srcLabel = SecurityLabel.of(src);
						Optional<SecurityLabel> dstLabel = SecurityLabel.of(dst);

						if (srcLabel.isPresent() && dstLabel.isPresent()) {
							SecurityLabel sl = srcLabel.get();
							SecurityLabel dl = dstLabel.get();
							if (policy.validAccess(Access.WRITE, sl, dl)) {
								error(conni, "Security policy violation: Write access from label " + sl.toString()
										+ " to label " + dl.toString());
							}
							if (policy.validAccess(Access.READ, dl, sl)) {
								error(conni, "Security policy violation: Read access from label " + dl.toString()
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
				}
				return DONE;
			}

			@Override
			public String caseFlowSpecificationInstance(FlowSpecificationInstance object) {
				// TODO Auto-generated method stub
				return super.caseFlowSpecificationInstance(object);
			}
		};
	}
}
