package org.osate.xtext.aadl2.errormodel.util;

import org.osate.aadl2.impl.ConnectionImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;

public class PropagationPath {
	PropagationPathEnd pathSrc;
	PropagationPathEnd pathDst;
	ConnectionInstance conni;
	public PropagationPath(PropagationPathEnd pathSrc,
			PropagationPathEnd pathDst, ConnectionInstance conni) {
		this.pathSrc = pathSrc;
		this.pathDst = pathDst;
		this.conni = conni;
	}
	public PropagationPath(
			ComponentInstance srcCI, ErrorPropagation srcEP,
			ComponentInstance dstCI, ErrorPropagation dstEP,
			ConnectionInstance conni) {
		this.pathSrc = new PropagationPathEnd(srcCI, srcEP);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
		this.conni = conni;
	}
	public PropagationPathEnd getPathSrc() {
		return pathSrc;
	}
	public ComponentInstance getSrcCI(){
		return pathSrc==null?null:pathSrc.getComponentInstance();
	}
	public void setPathSrc(PropagationPathEnd pathSrc) {
		this.pathSrc = pathSrc;
	}
	public PropagationPathEnd getPathDst() {
		return pathDst;
	}
	public ComponentInstance getDstCI(){
		return pathDst==null?null:pathDst.getComponentInstance();
	}
	public void setPathDst(PropagationPathEnd pathDst) {
		this.pathDst = pathDst;
	}
	public ConnectionInstance getConni() {
		return conni;
	}
	public void setConni(ConnectionInstance conni) {
		this.conni = conni;
	}
	
}
