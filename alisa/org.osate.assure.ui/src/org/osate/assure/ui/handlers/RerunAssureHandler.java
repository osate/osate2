package org.osate.assure.ui.handlers;

	import org.eclipse.core.commands.AbstractHandler;
	import org.eclipse.core.commands.ExecutionEvent;
	import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

	public class RerunAssureHandler extends AbstractHandler {
	    private final URI uri;
	    private final OpenAssureViewHandler assureHandler;

	    public RerunAssureHandler(EObject root, OpenAssureViewHandler assureHandler) {
	        this.uri = EcoreUtil.getURI(root);
	        this.assureHandler = assureHandler;
	    }

	    @Override
	    public Object execute(ExecutionEvent event) {
	        // Manually clear the proofs in case the uri is stale and executeURI does nothing
	        assureHandler.clearProofs();
	        return assureHandler.executeURI(uri);
	    }
	}
