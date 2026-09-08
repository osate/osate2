# ALISA Xtend to Java 21 migration

## Baseline

- Revision: `e8a01c328d017c38f529d6874cdb659a85cfd122`
- JDK: Temurin 21.0.10
- Maven: 3.9.11
- Tycho: 4.0.13
- Xtext/Xtend: 2.39.0
- Scope: Xtend files under `alisa/` with fewer than 200 lines, excluding the legacy standalone test bundles
  `org.osate.categories.tests`, `org.osate.organization.tests`, `org.osate.reqspec.tests`,
  `org.osate.verify.tests`, and `org.osate.assure.resolute.tests`.
- Frozen reference: the original Xtend and generated Java were copied to a read-only temporary reference before
  source ownership changed.

The baseline 25-module ALISA reactor completed successfully. `AssureTests` ran 30 tests successfully.
`AlisaWorkbenchTests` contained no runnable test methods before conversion.

## Transition strategy

The migration used a controlled mixed Java/Xtend transition with Xtext/Xtend pinned at 2.39.0:

1. Inventory the selected Xtend sources and generated types.
2. Adopt the generated type shapes into maintained Java.
3. Resolve secondary generated types (`IAlisaGlobalReferenceFinder`, `IReqspecGlobalReferenceFinder`, and
   `IVerifyGlobalReferenceFinder`).
4. Compile the mixed source graph.
5. Replace generated implementation structure with direct Java 21.
6. Remove obsolete source paths and dependencies only after consumer scans.

The initial adoption gate exposed the three secondary interfaces. After materializing them, the mixed-language
production graph compiled before the final modernization and dependency cleanup.

## Unit ledger

Every type listed below has progressed through `inventoried -> characterized -> adopted -> modernized -> verified`.

| Bundle | Migration units | Status |
| --- | --- | --- |
| `org.osate.alisa.common` | `CommonFormatter`, `CommonValueConverters`, `CommonScopeProvider` | verified |
| `org.osate.alisa.common.ui` | `CommonOutlineTreeProvider`, `CommonDescriptionLabelProvider`, `CommonQuickfixProvider`, `CommonLabelProvider`, `CommonEObjectHoverProvider`, `CommonProposalProvider`, `AlisaToBeBuiltComputer` | verified |
| `org.osate.alisa.workbench` | `AlisaOutputConfigurationProvider`, `AlisaGenerator`, `AlisaWorkbenchUtilExtension`, `AlisaFormatter`, `AlisaGlobalReferenceFinder`, `AlisaScopeProvider`, `AlisaValidator` | verified |
| `org.osate.alisa.workbench.ui` | `AlisaProposalProvider`, `AlisaOutlineTreeProvider`, `AlisaEObjectHoverProvider`, `AlisaDescriptionLabelProvider`, `AlisaLabelProvider`, `AssurancePlanFileWizard`, `AlisaQuickfixProvider` | verified |
| `org.osate.alisa.workbench.tests` | `AlisaWorkbenchTests` | verified |
| `org.osate.categories` | `CategoriesScopeProvider`, `CategoriesFormatter`, `CategoriesValidator`, `CategoriesUtil` | verified |
| `org.osate.categories.ui` | `CategoriesFileWizard`, `CategoryFiltersFileWizard`, `CategoriesProposalProvider`, `CategoriesOutlineTreeProvider`, `AbstractCategoriesFileWizard`, `CategoriesDescriptionLabelProvider`, `CategoriesLabelProvider`, `CategoriesQuickfixProvider` | verified |
| `org.osate.organization` | `OrganizationUtil`, `OrganizationScopeProvider`, `OrganizationFormatter`, `OrganizationGenerator`, `OrganizationValidator` | verified |
| `org.osate.organization.ui` | `OrganizationProposalProvider`, `OrganizationOutlineTreeProvider`, `StakeholdersFileWizard`, `OrganizationDescriptionLabelProvider`, `OrganizationLabelProvider`, `OrganizationQuickfixProvider` | verified |
| `org.osate.reqspec` | `ReqSpecGenerator`, `ReqSpecFormatter`, `ReqSpecCrossReferenceSerializer`, `ReqspecGlobalReferenceFinder` | verified |
| `org.osate.reqspec.ui` | `ReqSpecOutlinePage`, `ReqSpecDescriptionLabelProvider`, `ConstantsFileWizard`, `GlobalRequirementsFileWizard`, `GoalsDocumentFileWizard`, `RequirementsDocumentFileWizard`, `ReqSpecEObjectHoverProvider`, `SystemRequirementsFileWizard`, `StakeholderGoalsFileWizard`, `ReqSpecLabelProvider`, `ReqSpecOutlineTreeProvider`, `ReqSpecOutlineNodeLabelProvider` | verified |
| `org.osate.verify` | `VerifyFormatter`, `VerificationMethodDispatchers`, `VerifyGlobalReferenceFinder`, `VerifyScopeProvider`, `AnalysisPluginInterface`, `VerifyUtilExtension` | verified |
| `org.osate.verify.ui` | `VerifyOutlineTreeProvider`, `VerifyDescriptionLabelProvider`, `VerificationMethodsFileWizard`, `VerificationPlanFileWizard`, `VerifyLabelProvider`, `VerifyEObjectHoverProvider`, `VerifyProposalProvider` | verified |

## Behavioral contracts and evidence

- Formatter dispatch keeps the generated `_format` method names, `@Extension`, `@XbaseGenerated`, and public
  `format(Object, IFormattableDocument)` bridge required by Xtext.
- Lazy global-reference and scope transformations remain repeatable lazy `Iterable` operations.
- Google collection helpers were replaced with standard Java collection and stream APIs. The former multimap keeps
  set semantics through `Map<String, Set<String>>`, while scope and reference pipelines retain lazy iteration.
- EMF containment and framework-owned lists remain EMF collections; no specialized collection was replaced.
- Verification-method dispatch preserves method-ID selection, null-target behavior, unknown-method fallback, and the
  exception timing for a null method.
- Ordinal formatting preserves the original suffix behavior, including the negative-index exception.
- Wizard output preserves tabs, whitespace-only lines, line endings, and terminal-newline behavior.
- Assurance-case hover output preserves the leading space produced by the original fold.
- Quick fixes preserve issue-data ordering, URI resolution order, and semantic modification behavior.
- Analysis plug-ins preserve marker lookup, invocation, success recording, failure cleanup, and swallowed `Throwable`
  behavior.
- Source comments describing incomplete formatter coverage, known validation limitations, builder workarounds, and
  content-assist filtering were restored from Xtend.

Characterization coverage added:

- `org.osate.assure.tests.XtendMigrationCompatibilityTests`
  - null dispatch and unknown-method fallback;
  - ordinal suffixes and negative-input exception behavior;
  - duplicate-set and unset behavior for verification run records.
- `org.osate.alisa.workbench.tests.XtendMigrationCompatibilityTests`
  - exact assurance-plan wizard output, including the two-tab whitespace-only line;
  - assurance-case hover fold spacing.

## Control-flow and idiomatic audit

The converted Java was searched for generated and equivalent scaffolding, including:

- `_xblockexpression`, `_xifexpression`, `_switchResult`, and `_matched`, including numbered forms;
- `ObjectExtensions`, `IterableExtensions`, `CollectionLiterals`, `StringConcatenation`, generated `Function*` and
  `Procedure*` locals, `Conversions`, and generated sneaky-throw wrappers;
- non-required underscore-prefixed locals, nested standalone result blocks, aliases, and redundant assignment chains.

No generated control-flow scaffolding or ordinary Xtend helper machinery remains in the selected conversion scope.
The retained underscore-prefixed names are Xtext dispatch methods or inherited framework fields.
No `com.google.common.collect` usage remains in the selected conversion scope. The two remaining Guava
`Predicate` imports are required by the Xtext content-assist API and are not collection utilities.

## Dependencies and metadata

- `xtend-gen` was removed from `.classpath` and `build.properties` only in bundles with no remaining Xtend source.
- `org.eclipse.xtend.lib` and macro dependencies were removed from fully converted bundles.
- `org.eclipse.xtext.xbase.lib` remains only where required by Xtext formatter annotations or the external
  `AbstractNewFileWizard.addField` callback signature.
- Bundles containing excluded or 200-plus-line Xtend files retain their generation paths and required runtime support.
- `org.osate.reqspec.ui` JRE and JDT compiler settings were synchronized to Java 21.
- Maintained Java was formatted with the current Eclipse 2025-12 workspace's `_Osate` profile, including tab
  indentation, 120-column wrapping, OSATE import grouping, and the profile's blank-line rules.

## Validation

Baseline and final reactor command:

```text
mvn -o -T5 -s releng/osate.releng/settings.xml -f alisa/pom.xml -Plocal
  -Dtycho.localArtifacts=default -Dpr.build=true -Dsign=false
  -Dspotbugs=false -Dcodecoverage=false -Djavadoc=false
  -DfailIfNoTests=false clean verify
```

Focused compatibility command:

```text
mvn -o -T5 -s releng/osate.releng/settings.xml -f alisa/pom.xml -Plocal
  -Dtycho.localArtifacts=default -Dpr.build=true -Dsign=false
  -Dspotbugs=false -Dcodecoverage=false -Djavadoc=false
  -Dtest=XtendMigrationCompatibilityTests -DfailIfNoTests=false clean verify
```

Results:

- Compatibility tests: 5 passed.
- Full ALISA reactor: 30 `AssureTests` passed; the Assure compatibility class adds 3 tests and the workbench
  compatibility class adds 2 runnable tests to the
  previously empty workbench test bundle.
- `git diff --check`: clean.
- Scope audit: 77 Xtend files converted; no selected Xtend file remains; 16 files of 200 or more lines and the five
  explicitly excluded legacy test bundles remain unchanged.

## Remaining work

None within the selected conversion scope. The excluded standalone test bundles and Xtend files with 200 or more
lines were intentionally left unchanged.
