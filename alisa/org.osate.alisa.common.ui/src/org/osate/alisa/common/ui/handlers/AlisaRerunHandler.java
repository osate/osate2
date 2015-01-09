package org.osate.alisa.common.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osate.aadl2.Element;

public class AlisaRerunHandler extends AbstractHandler {
	private final URI uri;
	private final AlisaHandler alisaHandler;

	public AlisaRerunHandler(Element root, AlisaHandler alisaHandler) {
		this.uri = EcoreUtil.getURI(root);
		this.alisaHandler = alisaHandler;
	}

	@Override
	public Object execute(ExecutionEvent event) {
		// Manually clear the proofs in case the uri is stale and executeURI does nothing
		alisaHandler.clearProofs();
		return alisaHandler.executeURI(uri);
	}

}
