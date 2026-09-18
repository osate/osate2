# Behavior Annex Issues Affected by Instance-Scoped Property Values

This review covers the 19 issues carrying the `ba` label that were open on September 12, 2026. Five directly require effective property values. Four more are partially affected because their type logic derives types from Data Model properties.

## Directly affected issues

| Issue | Why instance-model checking is required |
| --- | --- |
| [#3187 — dispatch protocol and trigger compatibility](https://github.com/osate/osate2/issues/3187) | `Dispatch_Protocol`, `Dispatch_Trigger`, and `Period` can differ between instances through contained property associations. The existing D.4 checker queries the declarative containing classifier. Structural trigger and category checks can remain declarative. |
| [#3188 — `Input_Time`/`Output_Time` consistency](https://github.com/osate/osate2/issues/3188) | The check compares BA freeze and send actions with effective properties on particular port instances. Contained property associations can override either property at an arbitrary containment path. |
| [#3190 — variable initialization](https://github.com/osate/osate2/issues/3190) | Any conclusion based on `Data_Model::Initial_Value` must use the effective value for the relevant data or feature instance. Explicit BA initializers, initializer typing, and control-flow definite-assignment analysis can remain declarative. |
| [#3191 — property-reference units](https://github.com/osate/osate2/issues/3191) | This issue needs to be split. Whether the property's declared type is unitless or time-valued can be checked declaratively. Selecting and preserving the referenced value and its written unit cannot: `element#P` denotes an instance-dependent value. |
| [#3192 — `Subprogram_Call_Protocol` restrictions](https://github.com/osate/osate2/issues/3192) | `Behavior_Properties::Subprogram_Call_Protocol` is effective on a particular subprogram-access instance. The same access declaration may be HSER in one instance and LSER or ASER in another because of contained property associations. |

## Type-related issues partially affected

| Issue | Instance-dependent portion |
| --- | --- |
| [#2669 — action blocks not fully typechecked](https://github.com/osate/osate2/issues/2669) | The reproduction determines the port's enum type from `Data_Representation` and `Enumerators`, both property values that may be overridden on a feature instance. |
| [#3173 — omitted loop classifier](https://github.com/osate/osate2/issues/3173) | Grammar acceptance and integer-range inference are declarative. Inference from ports or arrays uses effective `Data_Representation`, `Base_Type`, and `Dimension` values and resolved prototype actuals, so that portion is instance-specific. |
| [#3181 — communication and call signatures](https://github.com/osate/osate2/issues/3181) | Target category, parameter count and order, and direction are structural. Actual/formal type compatibility becomes instance-specific wherever it uses Data Model representation, array, range, or feature properties. |
| [#3199 — declared type conformance](https://github.com/osate/osate2/issues/3199) | The source fix checks classifier identity, literal compatibility, and statically declared Data Model properties. It does not establish conformance after contained overrides or effective prototype bindings. Those checks, including instance-specific operator applicability, arrays, ranges, and property-reference values, remain [#3229](https://github.com/osate/osate2/issues/3229). |

## Issues not inherently affected

The other open BA issues are not inherently affected by contained property associations:

- #3217, #3189, #3186, #3179, #3178, #3170, #2667, #2347, and #2279 concern structural, syntactic, scoping, or control-flow rules that do not require effective property values.
- #3185 can conservatively treat property references in guards as unknown during declarative exhaustiveness analysis. Any attempt to evaluate those references belongs in the instance pass.

## Recently closed issues

Three issues closed during the September 2026 BA work are materially affected by the same boundary:

| Issue | Effect of instance-scoped property values |
| --- | --- |
| [#3153 — restore BA diagnostics](https://github.com/osate/osate2/issues/3153) | Registering and invoking the BA validator was correct, but it also exposed legacy D.4 checks that read `Dispatch_Protocol` and `Period` from the declarative containing classifier. The issue can remain closed for restoring validation dispatch, while #3187 and #3188 own moving property-dependent rules to an instance pass. |
| [#3172 — preserve `self` property references](https://github.com/osate/osate2/issues/3172) | Resolving `self` to the containing classifier is correct. Translation currently goes further and resolves `self#P` to a declarative `PropertyAssociation`; a contained association may override it for a particular component instance. The prefix and property definition must remain symbolic until instance evaluation. |
| [#3210 — property-referenced behavior array extents](https://github.com/osate/osate2/issues/3210) | The original issue incorrectly described `input#Queue_Size` as having an unambiguous declarative value. The final fix correctly stopped materializing a numeric extent, but the preserved property reference can still contain a declaratively selected association through the shared property-reference translator. The issue description and the G12 conformance text therefore do not describe the final instance boundary accurately. |

Two other closed issues have instance-dependent type-checking portions without invalidating their structural fixes:

- [#3174](https://github.com/osate/osate2/issues/3174) correctly represents internal event and event-data actions and checks their structural categories. Its data-type compatibility portion must use instance-effective Data Model properties when type conformance is enabled.
- [#2155](https://github.com/osate/osate2/issues/2155) can remain closed for its specific linking and model-loading regression. It does not establish that property-derived BA typing is correct in the presence of contained property associations; that broader work belongs to #3199 and the instance pass.

The other recently closed property-related issues do not require follow-up for this reason:

- #3211 concerns a bare property reference with neither a value owner nor a property default. A contained association cannot supply a value without an owner.
- #3176 is sound for literal and property-constant extents. Property constants cannot be overridden by contained associations, while element-prefixed property references are covered by #3210.
- #3208 enforces the structural distinction between an inadmissible behavior-variable reference and an admissible property reference without evaluating the property.

## Architectural reason

The current BA validation path cannot soundly evaluate effective property values:

- `BehaviorAnnexValidator.checkBehaviorAnnex` receives a declarative `ComponentClassifier` and passes that classifier into the translator, type checker, and rules checker.
- During instantiation, `CacheContainedPropertyAssociationsSwitch` resolves contained associations and copies them onto the matching instance objects.
- `InstanceObjectImpl.getPropertyValueInternal` checks those cached local values before falling back to the declarative model.
- The BA plug-in registers parser, linker, unparser, and text-position services, but no annex instantiator or other instance-checking hook.

Consequently, source diagnostics cannot establish conformance for effective instance properties. The #3199 source policy also checks statically declared Data Model properties; its diagnostics describe those declarations, not the values after contained overrides. Checking effective values needs an instance-side BA validation or analysis entry point under [#3229](https://github.com/osate/osate2/issues/3229) that evaluates the annex separately in each `ComponentInstance` context and reports against the affected instance, with source navigation where possible.

The declarative validator should retain checks whose answer cannot vary between instances, including syntax, name resolution, structural category and direction rules, property-definition type restrictions, and property-independent portions of type checking.

## Regression strategy

Each property-dependent check should be exercised with a system that instantiates the same component classifier at least twice and overrides the relevant property through a contained association for only one instance. The two instances must produce different BA results. This demonstrates why a diagnostic on the shared declarative annex would be unsound and prevents declarative property lookup from being reintroduced accidentally.

For partially affected issues, tests should separately cover the declarative and instance portions. For example, #3191 can test the property's declared unit category during source validation while testing selected values and units on instances.

## Related documentation inconsistency

The G12 discussion in `ba/doc/conformance.md` still says that an element-prefixed property array size is evaluated into the strict extent. The current array-size translator instead preserves the written property reference because the value belongs to a component instance. The shared property-reference translator still selects a declarative association when it finds one, so both the documentation and that remaining translation behavior should be updated to reflect the instance boundary.
