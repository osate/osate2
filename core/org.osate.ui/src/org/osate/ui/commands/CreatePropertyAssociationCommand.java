/*
*
* <copyright>
* Copyright � 2004 by Carnegie Mellon University, all rights reserved.
*
* Use of the Open Source AADL Tool Environment (OSATE) is subject to the terms of the license set forth
* at http://www.eclipse.org/legal/cpl-v10.html.
*
* NO WARRANTY
*
* ANY INFORMATION, MATERIALS, SERVICES, INTELLECTUAL PROPERTY OR OTHER PROPERTY OR RIGHTS GRANTED OR PROVIDED BY
* CARNEGIE MELLON UNIVERSITY PURSUANT TO THIS LICENSE (HEREINAFTER THE �DELIVERABLES�) ARE ON AN �AS-IS� BASIS.
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
* attorney�s fees) arising out of, or relating to Licensee�s and/or its sub licensees� negligent use or willful
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
*/

package org.osate.ui.commands;


/**
 * Command used by PropertyAssociationDialog to create a new PropertyAssociation and add
 * it to a PropertyHolder.  The creation of association takes place within this command to
 * notify the editor that unsaved changes have been made.  This command only executes the
 * final step in creating a PropertyAssociation, calling the setPropertyValue method.
 * The lexer, parser, name resolver, and numeric resolver must be used before using this command.
 * 
 * @author jseibel
 *
 */
//TODO: Fix when fixing the property view.
public class CreatePropertyAssociationCommand/* extends AbstractCommand*/
{
//	private PropertyHolder holder = null;
//	private PropertyDefinition definition = null;
//	private List values = null;
//	private List modes = null;
//	private PropertyAssociation newAssociation = null;
//	
//	/**
//	 * Used to create a non-modal list-valued PropertyAssociation.
//	 * 
//	 * @param holder The PropertyHolder that will contain the new PropertyAssociation.
//	 * @param definition The PropertyDefinintion for the new PropertyAssociation.
//	 * @param values The list of values for the new PropertyAssociation.
//	 */
//	public CreatePropertyAssociationCommand(PropertyHolder holder, PropertyDefinition definition, List values)
//	{
//		this.holder = holder;
//		this.definition = definition;
//		this.values = values;
//	}
//	
//	/**
//	 * Used to create a non-modal scalar-valued PropertyAssociation.
//	 * 
//	 * @param holder The PropertyHolder that will contain the new PropertyAssociation.
//	 * @param definition The PropertyDefinintion for the new PropertyAssociation.
//	 * @param value The value for the new PropertyAssociation.
//	 */
//	public CreatePropertyAssociationCommand(PropertyHolder holder, PropertyDefinition definition, PropertyValue value)
//	{
//		this(holder, definition, Collections.singletonList(value));
//	}
//	
//	/**
//	 * Used to create modal list-valued PropertyAssociation.
//	 * 
//	 * @param holder The PropertyHolder that will contain the new PropertyAssociation.
//	 * @param definition The PropertyDefinition for the new PropertyAssociation.
//	 * @param values The list of values for the new PropertyAssociation.
//	 * @param modes The list of modes that the new PropertyAssociation will exist in.
//	 */
//	public CreatePropertyAssociationCommand(PropertyHolder holder, PropertyDefinition definition, List values, List modes)
//	{
//		this(holder, definition, values);
//		this.modes = modes;
//	}
//	
//	/**
//	 * Used to create modal scalar-valued PropertyAssociation.
//	 * 
//	 * @param holder The PropertyHolder that will contain the new PropertyAssociation.
//	 * @param definition The PropertyDefinition for the new PropertyAssociation.
//	 * @param values The list of values for the new PropertyAssociation.
//	 * @param modes The list of modes that the new PropertyAssociation will exist in.
//	 */
//	public CreatePropertyAssociationCommand(PropertyHolder holder, PropertyDefinition definition, PropertyValue value, List modes)
//	{
//		this(holder, definition, Collections.singletonList(value));
//		this.modes = modes;
//	}
//	
//	public boolean prepare()
//	{
//		return true;
//	}
//	
//	public void execute()
//	{
//		if (modes == null)
//			newAssociation = holder.setPropertyValue(definition, values);
//		else
//			newAssociation = holder.setPropertyValue(definition, values, modes);
//	}
//
//	public String getLabel() {
//		return "Create property association";
//	}
//	
//    public boolean canUndo() {
//    	return false;
//    }
//
//	public void redo()
//	{
//	}
//
//	public PropertyAssociation getNewAssocition()
//	{
//		return newAssociation;
//	}
}