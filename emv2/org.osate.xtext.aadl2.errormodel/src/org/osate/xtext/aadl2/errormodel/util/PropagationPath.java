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
			ConnectionInstanceEnd srcCI, ErrorPropagation srcEP,
			ConnectionInstanceEnd dstCI, ErrorPropagation dstEP, ConnectionInstance conni) {
		this.pathSrc = new PropagationPathEnd(srcCI, srcEP);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
		this.conni = conni;
	}
	
	
	public PropagationPath(
			ConnectionInstance srcConni, 
			ConnectionInstanceEnd dstCI, ErrorPropagation dstEP) {
		this.pathSrc = new PropagationPathEnd(srcConni, null);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
		this.conni = null;
	}
	
	public PropagationPath(
			ConnectionInstanceEnd srcCI, ErrorPropagation srcEP,
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
	public ConnectionInstanceEnd getSrcCIE(){
		return pathSrc.getConnectionInstanceEnd();
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
	public ConnectionInstanceEnd getDstCIE()
	{
			return pathDst.getConnectionInstanceEnd();
	}
	public ConnectionInstance getDstConni(){
			return pathDst.getConnectionInstance();
	}
	public void setPathDst(PropagationPathEnd pathDst) {
		this.pathDst = pathDst;
	}
}
