/*
 * Created on July 7, 2004
 *
 * <copyright>
 * Copyright  2004 by Carnegie Mellon University, all rights reserved.
 *
 * Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
 * at http://www.eclipse.org/legal/cpl-v10.html.
 *
 * NO WARRANTY
 *
 * ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
 * CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE "DELIVERABLES") ARE ON AN "AS-IS" BASIS.
 * CARNEGIE MELLON UNIVERSITY MAKES NO WARRANTIES OF ANY KIND, EITHER EXPRESS OR IMPLIED AS TO ANY MATTER INCLUDING,
 * BUT NOT LIMITED TO, WARRANTY OF FITNESS FOR A PARTICULAR PURPOSE, MERCHANTABILITY, INFORMATIONAL CONTENT,
 * NONINFRINGEMENT, OR ERROR-FREE OPERATION. CARNEGIE MELLON UNIVERSITY SHALL NOT BE LIABLE FOR INDIRECT, SPECIAL OR
 * CONSEQUENTIAL DAMAGES, SUCH AS LOSS OF PROFITS OR INABILITY TO USE SAID INTELLECTUAL PROPERTY, UNDER THIS LICENSE,
 * REGARDLESS OF WHETHER SUCH PARTY WAS AWARE OF THE POSSIBILITY OF SUCH DAMAGES. LICENSEE AGREES THAT IT WILL NOT
 * MAKE ANY WARRANTY ON BEHALF OF CARNEGIE MELLON UNIVERSITY, EXPRESS OR IMPLIED, TO ANY PERSON CONCERNING THE
 * APPLICATION OF OR THE RESULTS TO BE OBTAINED WITH THE DELIVERABLES UNDER THIS LICENSE.
 *
 * Licensee hereby agrees to defend, indemnify, and hold harmless Carnegie Mellon University, its trustees, officers,
 * employees, and agents from all claims or demands made against them (and any related losses, expenses, or
 * attorney's fees) arising out of, or relating to Licensee's and/or its sub licensees' negligent use or willful
 * misuse of or negligent conduct or willful misconduct regarding the Software, facilities, or other rights or
 * assistance granted by Carnegie Mellon University under this License, including, but not limited to, any claims of
 * product liability, personal injury, death, damage to property, or violation of any laws or regulations.
 *
 * Carnegie Mellon University Software Engineering Institute authored documents are sponsored by the U.S. Department
 * of Defense under Contract F19628-00-C-0003. Carnegie Mellon University retains copyrights in all material produced
 * under this contract. The U.S. Government retains a non-exclusive, royalty-free license to publish or reproduce these
 * documents, or allow others to do so, for U.S. Government purposes only pursuant to the copyright license
 * under the contract clause at 252.227.7013.
 *
 * </copyright>
 *
 *
 * @version $Id: ARINC429ConnectionConsistency.java,v 1.1.2.1 2009-04-10 02:57:32 relief Exp $
 */
package org.osate.analysis.architecture;


import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.Element;
import org.osate.aadl2.Property;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.WriteToFile;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.ui.actions.AaxlReadOnlyAction;
import org.osate.ui.actions.AbstractAaxlAction;
import org.osate.xtext.aadl2.properties.util.CommunicationProperties;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;


/**
 * @author phf
 *
 * This class provides for checking properties on ports of a connection match up.
 *
 */
public class ARINC429ConnectionConsistency extends AadlProcessingSwitchWithProgress {
	AbstractAaxlAction action;
    public ARINC429ConnectionConsistency( final IProgressMonitor pm,
    		AbstractAaxlAction action) {
    	super(pm, PROCESS_PRE_ORDER_ALL);
    	this.action = action;
    }
    
    public final void initSwitches(){
		/* here we are creating the connection checking switches */
		String header = "connection,source,destination,source Word ID,destination Word ID, source Start Bit, destination Start Bit, source Numner Bits, destination Number Bits, \n\r";
    	csvlog(header);

		/* here we are creating the connection checking switches */
    	instanceSwitch = new InstanceSwitch() {
			/**
			 * check port properties for connection end points
			 */
    		public Object caseConnectionInstance(ConnectionInstance conni)  {
    			initcsvlog(conni);
    			FeatureInstance srcFI = (FeatureInstance) conni.getSource();
    			FeatureInstance dstFI = (FeatureInstance) conni.getDestination();
    			if ( srcFI == null || dstFI == null) {
    				error(conni, "Connection source or destination is null");
    				return DONE;
    			}
    			checkPortConsistency(srcFI,dstFI, conni);
    			return DONE;
    		}
		};
    }

	
    public void checkPortConsistency(FeatureInstance srcFI, FeatureInstance dstFI, ConnectionInstance conni){
    	Property WordID = GetProperties.lookupPropertyDefinition(conni,"ARINC429","WordID");
    	Property StartBit = GetProperties.lookupPropertyDefinition(conni,"ARINC429","StartBit");
    	Property NumberBits = GetProperties.lookupPropertyDefinition(conni,"ARINC429","NumberBits");
    	
    	if (WordID != null){
    		csvlog(conni.getName()+","+srcFI.getContainingComponentInstance().getName()+"."+srcFI.getName()+","+ dstFI.getContainingComponentInstance().getName()+"."+dstFI.getName()+",");
    		long srcWordID =PropertyUtils.getIntegerValue(srcFI,WordID,0);
    		long dstWordID =PropertyUtils.getIntegerValue(dstFI,WordID,0);
    		if (srcWordID > 0 && dstWordID > 0){
    			if (srcWordID != dstWordID){
    				error(conni, "Source Word ID "+srcWordID+" and Word ID "+dstWordID+" differ");
    			}
    			csvlog(srcWordID+","+ dstWordID+",");
    		} else {
    			csvlog(","+",");
    		}
    	}
    	if (StartBit != null){
    		long srcStartBit =PropertyUtils.getIntegerValue(srcFI, StartBit,-1);
    		long dstStartBit =PropertyUtils.getIntegerValue(dstFI, StartBit,-1);
    		if (srcStartBit > -1 && dstStartBit > -1){
    			if (srcStartBit != dstStartBit){
    				error(conni, "Source Start Bit "+srcStartBit+" and destination Start Bit "+dstStartBit+" differ");
    			}
        		csvlog(srcStartBit+","+ dstStartBit+",");
        	} else {
        		csvlog(","+",");
    		}
    	} else {
    		csvlog(","+",");
    	}
    	if (NumberBits != null){
    		long srcC =PropertyUtils.getIntegerValue(srcFI, NumberBits,0);
    		long dstC =PropertyUtils.getIntegerValue(dstFI, NumberBits,0);
    		if (srcC >0 && dstC > 0){
    			if (srcC != dstC){
    				error(conni, "Source number bits "+srcC+" and destination number bits "+dstC+" differ");
    			}
        		csvlog(srcC+","+ dstC+",");
        	} else {
        		csvlog(","+",");
    		}
    	} else {
    		csvlog(","+",");
    	}
    	csvlogNewline("");
    }


	private void initcsvlog(Element e){
	   	action.setCSVLog("ARINC429Consistency", e);
	}
	
	private String buffer = "";
	
	private void csvlog(String s){
		buffer = buffer+s;
	}
	private void csvlogNewline(String s){
		action.logInfo(buffer+s);
		buffer = "";
	}


}
