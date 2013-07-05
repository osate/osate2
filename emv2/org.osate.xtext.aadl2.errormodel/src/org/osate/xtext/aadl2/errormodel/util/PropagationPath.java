package org.osate.xtext.aadl2.errormodel.util;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionInstanceEnd;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.xtext.aadl2.errormodel.errorModel.ErrorPropagation;
/**
 * Directional propagation path
 * 
 * @author phf
 *
 */
public class PropagationPath {
	PropagationPathEnd pathSrc;
	PropagationPathEnd pathDst;
	ConnectionInstance conni;
	
	
	public PropagationPath(
			ComponentInstance srcCI, ErrorPropagation srcEP,
			ComponentInstance dstCI, ErrorPropagation dstEP, ConnectionInstance conni) {
		this.pathSrc = new PropagationPathEnd(srcCI, srcEP);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
		this.conni = conni;
	}
	
	
	public PropagationPath(
			ConnectionInstance srcConni, 
			ComponentInstance dstCI, ErrorPropagation dstEP) {
		this.pathSrc = new PropagationPathEnd(srcConni, null);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
		this.conni = null;
	}
	
	public PropagationPath(
			ComponentInstance srcCI, ErrorPropagation srcEP,
			ConnectionInstance dstConni) {
		this.pathSrc = new PropagationPathEnd(srcCI, srcEP);
		this.pathDst = new PropagationPathEnd(dstConni, null);
		this.conni = null;
	}
	
	
	public ConnectionInstance getConnectionInstance() {
		return conni;
	}
	
	public PropagationPathEnd getPathSrc() {
		return pathSrc;
	}
	public ComponentInstance getSrcCI(){
			return pathSrc.getComponentInstance();
	}
	
	public ConnectionInstance getSrcConni(){
			return pathSrc.getConnectionInstance();
	}
	public void setPathSrc(PropagationPathEnd pathSrc) {
		this.pathSrc = pathSrc;
	}
	public PropagationPathEnd getPathDst() {
		return pathDst;
	}
	public ComponentInstance getDstCI()
	{
			return pathDst.getComponentInstance();
	}
	public ConnectionInstance getDstConni(){
			return pathDst.getConnectionInstance();
	}
	public void setPathDst(PropagationPathEnd pathDst) {
		this.pathDst = pathDst;
	}
}
