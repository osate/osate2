## Modes
The graphical editor allows editing the modes and mode transitions defined in the AADL model.



### Creating Modes
When editing a component type, modes can be created by selecting *Mode* from the palette.



### Setting the Initial Mode
A mode can be designated as the initial mode by right-clicking on it and selecting *Change to Initial Mode* from the context menu.



### Creating Mode Transitions
Mode transitions can be created using the palette.

1. Select *Mode Transition* from the palette.

2. Select the starting mode.

3. Select the destination mode. The *Select Trigger Ports* dialog will appear.

![](images/PortTriggerDialog.png)

4. Select the ports to use as the triggers for the transition. Multiple ports can be selected by holding down *Ctrl*.

5. Select *OK*. The new mode transition will appear.



### Setting Mode Transition Triggers
A mode transition's trigger ports can be modified by right-clicking on the mode transition and selecting *Set Mode Transition Triggers...* from the context menu.



### Switching Between Derived and Non-derived Modes
The editor allows specifying whether modes declared inside the component type are derived from its containing component. The usage of derived modes corresponds to a component type with a *requires modes* declaration while non-derived modes correspond to a component type with a *modes* declaration. 

The component type can be swapped between using derived and non-derived modes by right-clicking inside the component type and selecting *Change to Derived Modes* or *Change to Non-derived Modes* from the context menu.



### Highlighting
Selecting a mode from the mode drop-down in the toolbar will highlight elements applicable to the mode.



### Selecting Active Components
The editor allows specifying the modes in which a modal element, such as a subcomponent, is active as well as the mapping between modes in the case of derived modes. The modes can be specified by right-clicking on the element and selecting *Configure In Modes...* from the context menu.