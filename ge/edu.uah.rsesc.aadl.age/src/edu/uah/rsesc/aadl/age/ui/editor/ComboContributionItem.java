package edu.uah.rsesc.aadl.age.ui.editor;

import org.eclipse.jface.action.ControlContribution;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

public class ComboContributionItem extends ControlContribution {
	private Combo combo;

	protected ComboContributionItem(final String id) {
		super(id);
	}

	@Override
	protected Control createControl(final Composite parent) {
		//System.out.println("CREATING CONTROL");
		combo = new Combo(parent, 0);
		combo.addDisposeListener(new DisposeListener() {
			@Override
			public void widgetDisposed(DisposeEvent e) {
				onControlDisposed();
			}
			
		});
		
		combo.addSelectionListener(new SelectionListener() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				onSelection(combo.getText());
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
			}			
		});
		return combo;
	}

	public Combo getCombo() {
		if(combo == null || combo.isDisposed())
			return null;
		
		return combo;
	}
	
	protected void onControlDisposed() {
		
	}
	
	protected void onSelection(final String txt) {
		
	}
}
