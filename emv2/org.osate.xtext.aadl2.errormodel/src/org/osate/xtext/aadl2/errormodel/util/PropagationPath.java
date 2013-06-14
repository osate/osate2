package org.osate.xtext.aadl2.errormodel.util;

import org.osate.aadl2.impl.ConnectionImpl;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
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
	
	
	public PropagationPath(
			ComponentInstance srcCI, ErrorPropagation srcEP,
			ComponentInstance dstCI, ErrorPropagation dstEP) {
		this.pathSrc = new PropagationPathEnd(srcCI, srcEP);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
	}
	
	
	public PropagationPath(
			ConnectionInstance srcConni, 
			ComponentInstance dstCI, ErrorPropagation dstEP) {
		this.pathSrc = new PropagationPathEnd(srcConni, null);
		this.pathDst = new PropagationPathEnd(dstCI, dstEP);
	}
	
	public PropagationPath(
			ComponentInstance srcCI, ErrorPropagation srcEP,
			ConnectionInstance dstConni) {
		this.pathSrc = new PropagationPathEnd(srcCI, srcEP);
		this.pathDst = new PropagationPathEnd(dstConni, null);
	}
	
	
	public PropagationPathEnd getPathSrc() {
		return pathSrc;
	}
	public ComponentInstance getSrcCI(){
		if (pathSrc == null)
		{
			return null;
		}
		if (pathSrc.getComponentInstance() != null)
		{
			return pathSrc.getComponentInstance();
		}
		return null;
	}
	public ConnectionInstance getSrcConni(){
		if (pathSrc == null)
		{
			return null;
		}
		if (pathSrc.getComponentInstance() != null)
		{
			return pathSrc.getConnectionInstance();
		}
		return null;
	}
	public void setPathSrc(PropagationPathEnd pathSrc) {
		this.pathSrc = pathSrc;
	}
	public PropagationPathEnd getPathDst() {
		return pathDst;
	}
	public ComponentInstance getDstCI()
	{
		if (pathDst == null)
		{
			return null;
		}
		if (pathDst.getComponentInstance() != null)
		{
			return pathDst.getComponentInstance();
		}
		return null;
	}
	public ConnectionInstance getDstConni(){
		if (pathDst == null)
		{
			return null;
		}
		if (pathDst.getComponentInstance() != null)
		{
			return pathDst.getConnectionInstance();
		}
		return null;
	}
	public void setPathDst(PropagationPathEnd pathDst) {
		this.pathDst = pathDst;
	}
}
