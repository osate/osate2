# Commands
Commands are objects which are activated to perform an action. When a pictogram element is right clicked, commands are shown in the context menu which appears.

Commands are registered using the **org.osate.ge.commands** extension point. The modification of the model or diagram from commands is not supported at this time.

#### Required Annotations:
* [GetLabel](../api/org/osate/ge/di/GetLabel.html)
* [Activate](../api/org/osate/ge/di/Activate.html)

#### Optional Annotations:
* [IsAvailable](../api/org/osate/ge/di/IsAvailable.html)
* [CanActivate](../api/org/osate/ge/di/CanActivate.html)
