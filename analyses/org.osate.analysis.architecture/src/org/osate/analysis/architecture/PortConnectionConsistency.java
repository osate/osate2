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
 * @version $Id: PortConnectionConsistency.java,v 1.1.2.6 2009-04-14 15:02:20 jseibel Exp $
 */
package org.osate.analysis.architecture;


import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.BasicPropertyAssociation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;
import org.osate.aadl2.RangeValue;
import org.osate.aadl2.RecordValue;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.impl.ClassifierValueImpl;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.util.InstanceSwitch;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitchWithProgress;
import org.osate.contribution.sei.names.DataModel;
import org.osate.contribution.sei.names.SEI;
import org.osate.xtext.aadl2.properties.util.GetProperties;
import org.osate.xtext.aadl2.properties.util.PropertyUtils;

/**
 * @author phf
 *
 * This class provides for checking properties on ports of a connection match up.
 *
 */
public class PortConnectionConsistency extends AadlProcessingSwitchWithProgress {
	
    public PortConnectionConsistency( final IProgressMonitor pm,
    		final AnalysisErrorReporterManager errMgr) {
    	super(pm, PROCESS_PRE_ORDER_ALL, errMgr);
    }
    
    public final void initSwitches(){
		/* here we are creating the connection checking switches */
    	csvlog = new UnparseText();
		String header = "connection,source,destination,source Data Size,destination Data Size, source Rate, destination Rate, source Base Type, destination Base Type, source Measurement UNit, destiantion Measurement Unit, \n\r";
    	csvlog(header);

		/* here we are creating the connection checking switches */
    	instanceSwitch = new InstanceSwitch() {
			/**
			 * check port properties for connection end points
			 */
    		public Object casePortConnectionInstance(ConnectionInstance conni)  {
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
    	
    	csvlog(conni.getName()+","+srcFI.getContainingComponentInstance().getName()+"."+srcFI.getName()+","+ dstFI.getContainingComponentInstance().getName()+"."+dstFI.getName()+",");
    	double srcDataSize =GetProperties.getSourceDataSizeInBytes(srcFI);
    	double dstDataSize =GetProperties.getSourceDataSizeInBytes(dstFI);
    	if (srcDataSize > 0 && dstDataSize > 0){
    		if (srcDataSize != dstDataSize){
    			error(conni, "Source data size "+srcDataSize+"Bytes and destination data size "+dstDataSize+"Bytes differ");
    		}
    		csvlog(srcDataSize+","+ dstDataSize+",");
    	} else {
    		csvlog(","+",");
    	}
    	RecordValue srcRate = GetProperties.getOutPutRate(srcFI);
    	RecordValue dstRate =GetProperties.getInPutRate(dstFI);
    	if(srcRate != null&& dstRate!= null){
    		double srcRateValue = getDataRate(srcRate);
    		double dstRateValue = getDataRate(dstRate);
    		if (srcRateValue > 0 && dstRateValue > 0){
    			if (srcRateValue != dstRateValue){
    				error(conni, "Source data rate "+srcRateValue+" and destination data rate "+dstRateValue+" differ");
    			}
    			csvlog(srcRateValue+","+ dstRateValue+",");
    		} else {
    			csvlog(","+",");
    		}
    	}
    	// now try it as SAVI::Data_Rate
		double srcRateValue = getSEIDataRate(srcFI);
		double dstRateValue = getSEIDataRate(dstFI);
		if (srcRateValue > 0 && dstRateValue > 0){
			if (srcRateValue != dstRateValue){
				error(conni, "Source data rate "+srcRateValue+" and destination data rate "+dstRateValue+" differ");
			}
			csvlog(srcRateValue+","+ dstRateValue+",");
		} else {
			csvlog(","+",");
		}
		Classifier srcC = GetProperties.getSingleBaseType(srcFI);
    	Classifier dstC = GetProperties.getSingleBaseType(dstFI);
    	if (srcC != null&& dstC != null){
    		if (srcC != null && dstC != null){
    			if (srcC != dstC){
    				error(conni, "Source base type "+srcC.getName()+" and destination base type "+dstC.getName()+" differ");
    			}
    			csvlog(srcC.getName()+","+ dstC.getName()+",");
    		} else {
    			csvlog(","+",");
    		}
    	} else {
    		csvlog(","+",");
    	}
    	String srcS =GetProperties.getMeasurementUnit(srcFI);
    	String dstS =GetProperties.getMeasurementUnit(dstFI);
    	if (srcS != null && srcS.length() > 0&& dstS != null && dstS.length() > 0){
    		if (!srcS.equalsIgnoreCase(dstS)){
    			error(conni, "Source measurement unit "+srcS+" and destination measurement unit "+dstS+" differ");
    		}
    		csvlog(srcS+","+ dstS+",");
    	} else {
    		csvlog(","+",");
    	}
    	csvlogNewline("");
    }
    
    private double getDataRate(RecordValue rate){
    	BasicPropertyAssociation vr = GetProperties.getRecordField(rate.getOwnedFieldValues(), "Value_Range");
    	if (vr == null) return 0;
		RangeValue rv = (RangeValue) vr.getOwnedValue();
		PropertyExpression maximum = rv.getMaximum().evaluate(null).first().getValue();
		return ((NumberValue) maximum).getScaledValue();
    }
    
    private double getSEIDataRate(NamedElement ne){
		Property dr = GetProperties.lookupPropertyDefinition(ne,SEI._NAME, SEI.DATA_RATE);
		if (dr == null) return 0;
		return PropertyUtils.getRealValue(ne, dr,0.0);
    }

	
	private UnparseText csvlog ;
	
	public String getCSVContent(){
		return csvlog.getParseOutput();
	}

	private void csvlog(String s){
		csvlog.addOutput(s);
	}
	private void csvlogNewline(String s){
		csvlog.addOutputNewline(s);
	}
	


}
