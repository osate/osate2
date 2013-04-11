package org.osate.xtext.aadl2.ui.propertyview.associationwizard;

import org.eclipse.jface.wizard.WizardPage;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyExpression;

public abstract class AbstractPropertyValueWizardPage extends WizardPage {
	protected AbstractPropertyValueWizardPage(String pageName) {
		super(pageName);
		setTitle("Property Value");
	}
	
	public void setDefinition(Property definition) {
		setDescription("Enter a property value for " + definition.getQualifiedName() + ".");
		setDefinitionImpl(definition);
	}
	
	public abstract PropertyExpression getPropertyExpression();
	public abstract boolean isAppendSelected();
	public abstract boolean isConstantSelected();
	protected abstract void setDefinitionImpl(Property definition);
}
