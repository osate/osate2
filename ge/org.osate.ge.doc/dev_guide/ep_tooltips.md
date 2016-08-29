# Tooltip Contributors
Tooltip contributors are objects which contribute tooltip contents for a model element. When the user's cursor hovers over a pictogram element, tooltip contributors are activated to populate the tooltip.  If no content is provided, the tooltip is not shown.

Tooltip contributors are registered using the **org.osate.ge.tooltips** extension point. 

## Examples
* org.osate.ge.internal.tooltips.FeatureTooltipContributor

## Required Annotations:
* [Activate](../api/org/osate/ge/di/Activate.html)
