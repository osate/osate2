package edu.uah.rsesc.aadl.age.dialogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class SetInModesDialog extends TitleAreaDialog {
	private final List<Control> modeControls = new ArrayList<Control>(); // A list of all controls that are involved in configuring modes. Will be disabled when the all modes check box is selected.
	private final List<String> localModes;
	private final List<String> childModes;
	private final Map<String, String> localToChildModeMap;
	private boolean inAllModes;

	public SetInModesDialog(final Shell parentShell, final List<String> localModes, final List<String> childModes, final Map<String, String> localToChildModeMap) {
		super(parentShell);
		this.localModes = localModes;
		this.childModes = childModes;
		this.localToChildModeMap = new HashMap<String, String>(localToChildModeMap);
		this.inAllModes = localToChildModeMap.size() == 0;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Modes");
	    setMessage("Select the modes for the element.", IMessageProvider.INFORMATION);	
	}	
	
	public Map<String, String> getLocalToChildModeMap() {
		return inAllModes ? new HashMap<String, String>() : localToChildModeMap;
	}
	
	@Override
  	protected Control createDialogArea(final Composite parent) {
	    final Composite area = (Composite)super.createDialogArea(parent);
	    
	    ScrolledComposite scrolled = new ScrolledComposite(area, SWT.H_SCROLL | SWT.V_SCROLL);
		scrolled.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); 
		scrolled.setLayout(new GridLayout());	
		scrolled.setExpandVertical(true); 
		scrolled.setExpandHorizontal(true); 
	    		
	    final Composite container = new Composite(scrolled, SWT.NONE);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true)); 
	    final GridLayout layout = new GridLayout(childModes == null ? 1 : 3, false);
	    container.setLayout(layout);
	    
	    // All modes checkbox
	    final Button allModesBtn = new Button(container, SWT.CHECK);
	    allModesBtn.setText("All Modes");
	    final GridData allModesGridData = new GridData();
	    allModesGridData.horizontalSpan = layout.numColumns;
	    allModesBtn.setLayoutData(allModesGridData);
	    allModesBtn.setSelection(inAllModes);
	    
	    final Label separator = new Label(container, SWT.HORIZONTAL | SWT.SEPARATOR);
	    final GridData separatorLayoutData = new GridData(GridData.FILL_HORIZONTAL);
	    separatorLayoutData.horizontalSpan = layout.numColumns;
	    separator.setLayoutData(separatorLayoutData);

	    // Add controls for each of the local modes
	    for(final String localMode : localModes) {
	    	addLocalMode(container, localMode);
	    }	    
	    
	    scrolled.setContent(container); 
	    scrolled.setMinSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
	    
	    updateEnabledStateOfModeControls(!allModesBtn.getSelection());
	    allModesBtn.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(final SelectionEvent e) {
	    		updateEnabledStateOfModeControls(!allModesBtn.getSelection());
	    		inAllModes = allModesBtn.getSelection();
	    	}
	    });
	    
	    return area;
	}
	
	private void updateEnabledStateOfModeControls(final boolean value) {
		for(final Control c : modeControls) {
			c.setEnabled(value);
		}
	}
	
	private void addLocalMode(Composite container, final String modeName) {
	    final Button modeBtn = new Button(container, SWT.CHECK);
	    modeBtn.setText(modeName);
	    modeControls.add(modeBtn);
	    
	    // Set checked state
	    if(localToChildModeMap.containsKey(modeName)) {
		    modeBtn.setSelection(true);
	    }
	    
	    // Create child mode drop down
	    final Combo childModeFld;
	    
	    if(childModes == null) {
	    	childModeFld = null;
	    }
	    else {
		    final Label mappedLabel = new Label(container, SWT.CENTER);
		    mappedLabel.setText("->");
		    modeControls.add(mappedLabel);
		    
		    // Create mapped child mode combo
		    childModeFld = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
		    modeControls.add(childModeFld);
		    childModeFld.add("");
		    for(final String childMode : childModes) {
		    	 childModeFld.add(childMode);
		    }
		    
		    final String mappedChildModeName = localToChildModeMap.get(modeName);
		    if(mappedChildModeName != null) {
		    	childModeFld.setText(mappedChildModeName);		    	
		    }
		    
	    }	    
	    
	    // Handle selections to the mode button or the child mode combo
	    final SelectionListener selectionListener = new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(final SelectionEvent e) {
	    		if(e.getSource() == childModeFld && childModeFld.getText().length() > 0) {	    			
	    			modeBtn.setSelection(true);
	    		}
	    		
	    		if(modeBtn.getSelection()) {
	    			final String selectedChildModeName = (childModeFld != null && childModeFld.getText().length() > 0) ? childModeFld.getText() : null;
	    			localToChildModeMap.put(modeName, selectedChildModeName);
	    		} else {
	    			localToChildModeMap.remove(modeName);
	    		}
	    	}
	    };
	    
	    // Register selection listeners
	    modeBtn.addSelectionListener(selectionListener);
	    if(childModeFld != null) {
	    	childModeFld.addSelectionListener(selectionListener);	    	
	    }
	}
}
