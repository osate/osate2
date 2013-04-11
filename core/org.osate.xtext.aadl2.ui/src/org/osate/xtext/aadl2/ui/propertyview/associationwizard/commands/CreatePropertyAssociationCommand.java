package org.osate.xtext.aadl2.ui.propertyview.associationwizard.commands;

import java.util.List;

import org.eclipse.emf.common.command.AbstractCommand;
import org.osate.aadl2.ModalPropertyValue;
import org.osate.aadl2.Mode;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyAssociation;
import org.osate.aadl2.PropertyExpression;

/**
 * Command used by PropertyAssociationWizard to create a new PropertyAssociation and add
 * it to a NamedElement.  The creation of association takes place within this command to
 * notify the editor that unsaved changes have been made.  This command only executes the
 * final step in creating a PropertyAssociation, calling the setPropertyValue method.
 * The parser and linker must be used before using this command.
 * 
 * @author jseibel
 *
 */
public class CreatePropertyAssociationCommand extends AbstractCommand {
	private NamedElement holder = null;
	private Property definition = null;
	private PropertyExpression propertyExpression = null;
	private List<Mode> modes = null;
	private PropertyAssociation newAssociation = null;
	
	/**
	 * Used to create a non-modal PropertyAssociation.
	 * 
	 * @param holder The NamedElement that will contain the new PropertyAssociation.
	 * @param definition The Property for the new PropertyAssociation.
	 * @param propertyExpression The value for the new PropertyAssociation.
	 */
	public CreatePropertyAssociationCommand(NamedElement holder, Property definition, PropertyExpression propertyExpression) {
		this.holder = holder;
		this.definition = definition;
		this.propertyExpression = propertyExpression;
	}
	
	public CreatePropertyAssociationCommand(NamedElement holder, Property definition, PropertyExpression propertyExpression, List<Mode> modes) {
		this(holder, definition, propertyExpression);
		this.modes = modes;
	}
	
	@Override
	protected boolean prepare() {
		return true;
	}
	
	@Override
	public void execute() {
		newAssociation = holder.createOwnedPropertyAssociation();
		newAssociation.setProperty(definition);
		ModalPropertyValue mpv = newAssociation.createOwnedValue();
		mpv.setOwnedValue(propertyExpression);
		if (modes != null) {
			mpv.getInModes().addAll(modes);
		}
	}
	
	@Override
	public String getLabel() {
		return "Create property association";
	}
	
	@Override
	public boolean canUndo() {
		return false;
	}

	@Override
	public void redo() {
	}
	
	public PropertyAssociation getNewAssociation() {
		return newAssociation;
	}
}