# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

OSATE2 is the Open Source AADL Tool Environment: an Eclipse-based IDE for the Architecture Analysis & Design Language (AADL). It is an Eclipse RCP / plug-in application built with Tycho. Documentation for end users lives at https://osate.org.

## Build

Toolchain: **JDK 21**, **Maven 3.9+**, **Tycho 4.0.x**, target platform **Eclipse 2025-12**, **Xtext 2.39**. The target platform is defined by the Tycho artifact `org.osate:osate2-platform` (see `releng/org.osate.build.target/osate2-platform.target`); do not rely on whatever Eclipse release is installed locally.

Common Maven invocations (run from the repo root; the parent POM wires in `releng`, `core`, `analyses`, `emv2`, `alisa`, `ge`, `ba`, `examples`):

- Local build, skip tests (matches `osate.build.local.launch`):
  `mvn -s releng/osate.releng/settings.xml -Plocal clean install -DskipTests -Dpr.build=true -Dtycho.localArtifacts=ignore -Dsign=false -Dspotbugs=false -Dcodecoverage=false -Djavadoc=false`
- Local build + tests: drop `-DskipTests` and use `osate.build.local.tests.launch` as reference.
- Full PR-style build (what Jenkins runs for PRs): `mvn -s releng/osate.releng/seisettings.xml clean verify -Plocal -Declipse.p2.mirrors=false -DfailIfNoTests=false -Dcodecoverage=true -Dspotbugs=true -Dpr.build=true`
- Product build: omit `-Dpr.build=true` so the `pr-build` profile (negated) activates `releng/org.osate.build.repository` and `releng/org.osate.build.product`.
- For release, CI, and final validation builds, do not select individual modules with `-pl`; build from the root reactor with `-Dtycho.localArtifacts=ignore` so Tycho resolves a clean, complete plug-in graph. The local iteration exception is described below.
- To narrow a test run, keep the root reactor command and add `-Dtest=ClassName` or `-Dtest=ClassName#method` with `-DfailIfNoTests=false` (the `tycho-surefire-plugin` configuration is inherited from `releng/org.osate.build.main/pom.xml`).

Most developers build via the Eclipse launch configurations in `releng/osate.releng/*.launch` (imported as the `osate.releng` project). `settings.xml` is the public settings file; `seisettings.xml` is SEI-internal (used by CI) and will not work outside that network.

The `maven-enforcer-plugin` requires Maven 3.9.0+. `jgit.dirtyWorkingTree=warning` locally, `error` in the `full` profile — the CI build fails on uncommitted changes.

### Fast local Tycho iteration

For local development, build the changed production bundle, its test bundle, and the feature that contains the production bundle. Select all three explicitly because Maven `-am` does not infer Tycho `Require-Bundle`, `Import-Package`, or `Fragment-Host` relationships.

For example:

```bash
mvn -o -s releng/osate.releng/settings.xml -Plocal \
  -pl :org.osate.analysis.modes,:org.osate.analysis.modes.tests,:org.osate.plugins.feature \
  -Dtycho.localArtifacts=default \
  -Dpr.build=true -Dsign=false \
  -Dspotbugs=false -Dcodecoverage=false -Djavadoc=false \
  clean install
```

- Use `-o` only after the target platform and Maven dependencies are cached locally.
- Use `install`, not only `verify`, when another Tycho build must consume the result. `install` publishes the bundle and its local p2 metadata under `~/.m2/repository`.
- Rebuild and install the owning feature whenever a contained bundle changes. Generated feature metadata requires the bundle's exact qualified version.
- To run selected tests, add `-Dtest=ClassName` or `-Dtest=ClassName#method` and `-DfailIfNoTests=false`.
- Treat this workflow as an iteration aid. Run a clean root-reactor build with `-Dtycho.localArtifacts=ignore` before release or CI handoff.

After installing the selected OSATE artifacts, the sibling language-server repository can be packaged from local Tycho artifacts:

```bash
mvn -o -f ../aadl-language-server/osate2-server/pom.xml \
  -DskipTests \
  -Dtycho.localArtifacts=default \
  verify
```

Do not distribute that raw repository without normalization. Tycho's local p2 catalog at `~/.m2/repository/.meta/p2-local-metadata.properties` accumulates artifacts from previous builds. Repository assembly from that catalog does not automatically select only the latest version: unversioned roots or `includeAllDependencies=true` can include multiple versions of the same bundle or feature.

### OSATE p2 repository

Do not assemble the OSATE update-site repository from accumulated local Tycho artifacts. Build it through the complete root reactor with `-Dtycho.localArtifacts=ignore`; this is the only supported path for the update-site repository.

Verify the generated repository before distribution. It must contain only the latest intended version of each OSATE bundle and feature. Treat duplicate versions of an IU as a packaging failure.

## Architecture

OSATE is a large multi-module Tycho reactor (~150 Eclipse bundles). Each top-level directory is a functional area whose bundles follow the Eclipse pattern: `x` (runtime), `x.ui` (UI contributions), `x.tests` (JUnit-plugin tests), `x.edit` / `x.feature` as needed. Nearly every runtime bundle's parent POM is `releng/org.osate.build.main/pom.xml`.

Top-level areas:
- `core/` — AADL metamodel and language infrastructure. `org.osate.aadl2` hosts the EMF metamodel (`models/aadl2.ecore`); `org.osate.xtext.aadl2*` is the Xtext grammar, scoping, validation, and editor; `org.osate.aadl2.instantiation` builds the instance model; `org.osate.aadl2.instance.textual*` is the textual concrete syntax for instance models; `org.osate.ui` and `org.osate.core` contribute the Eclipse UI and application glue. Everything else depends on `core/`.
- `analyses/` — static analyses over AADL models (flows, resource budgets, architecture checks, modes, binpacking, simulink importer, …). Produces the "OSATE plug-ins" feature.
- `emv2/` — the Error Model Annex v2 (error propagations, fault trees, hazard analysis).
- `alisa/` — Assurance / requirements DSLs: ReqSpec, Verify, Assure, Organization, Categories, Resolute integration. These are Xtext languages layered on top of AADL.
- `ge/` — the graphical AADL editor (Graphiti-based).
- `ba/` — the Behavior Annex (behavioral specifications for AADL components).
- `tools/` — standalone developer tools, notably `org.osate.propertiescodegen` which generates Java classes from AADL property sets.
- `examples/` — example AADL projects packaged as features.
- `releng/` — the Tycho reactor plumbing: parent POMs (`org.osate.build.main`), target platform (`org.osate.build.target`), p2 repository and product assembly (`org.osate.build.repository`, `org.osate.build.product`), aggregate JaCoCo report, and version-management scripts in `version-management/`.

Cross-cutting concerns:
- **Xtext**: several DSLs (AADL, EMV2, ReqSpec, Verify, Assure, Resolute, BA, instance textual). Each has a `.generator` / MWE2 workflow; changing a grammar requires regenerating via the Xtext UI or MWE2 launch. `src-gen/`, `xtend-gen/`, and `xsemantics-gen/` are generated and excluded from SonarCloud coverage but committed for Tycho.
- **Xtend and Xsemantics**: Xtend is compiled via `xtend-maven-plugin` into `xtend-gen/`; Xsemantics rules compile into `xsemantics-gen/`. Both directories are wiped by `mvn clean` (except `.gitignore`).
- **Extension points / annexes**: `org.osate.annexsupport` defines extension points that EMV2, BA, Resolute, ReqSpec, etc. plug into — this is how annex languages attach to the core AADL model.
- **Testing**: tests live in `*.tests` bundles and run under `tycho-surefire-plugin`. UI tests set `ui.test.vmargs` (`-XstartOnFirstThread` on macOS via the `macosx` profile); headless tests do not. Test logging is routed through `SimpleLog` at `error` level (see `test.logging*` properties in the main parent POM).
- **Baseline / API tooling**: API baseline is currently 2.18.0 (recent commit `Set API baseline 2.18.0`); changes that break API should be weighed against that baseline. The (currently commented-out) `tycho-p2-extras-plugin` compares against `lastStableRepository`.
- **SpotBugs + FindSecBugs**: activated with `-Dspotbugs=true`; config lives under `releng/org.osate.build.main/src/main/resources/spotbugs/`.

## Issue and pull request workflow

Use this workflow when investigating a defect and taking it through a GitHub issue, regression, production fix, and pull request. Keep each independently reviewable defect in its own issue, branch, and PR.

### Execution environment

- Run all `gh` operations and all Maven builds outside the sandbox. Request escalated execution before invoking either command.
- This includes authentication, issue and PR search or mutation, focused tests, analysis-bundle tests, and root-reactor, SpotBugs, and JaCoCo builds.

### Confirm the behavior

- Build the smallest valid external AADL model that reaches the defect through a supported entry point.
- Validate that the model has no unrelated AADL errors, then record the exact observable failure, exception, diagnostic, or invalid instance state.
- Confirm that the failure is independent of unresolved issues. If another known defect masks it, wait for the prerequisite fix or isolate the behavior with another valid external model.
- Do not add a factory, protected hook, or other production seam solely to force a private path from a test. Do not create an issue or production fix from static suspicion alone.

### GitHub issues

- Confirm `gh auth status`, then search open and closed `osate/osate2` issues before creating one. If authentication is missing or expired, stop and ask the user to authenticate.
- Create one issue for each independently fixable defect and create it before finalizing test names so the real issue number is used everywhere. Do not commit placeholder identifiers.
- Use a concise, behavior-oriented title ending with exactly ` 🤖`.
- Structure the body with `Summary`, `Reproduction`, `Expected behavior`, and `Relevant code` sections.
- In `Summary`, describe the observable failure and the inferred implementation mechanism. In `Reproduction`, give the smallest model shape or execution path and include exact exception text when relevant. In `Expected behavior`, state a testable result. In `Relevant code`, name the implicated files, classes, and methods.
- Clearly distinguish observed behavior from inferred causes. Preserve intended headless dependency boundaries; do not add UI bundles merely to satisfy an error path.

### Branches, regression tests, and commits

- Create a branch named `<issue-number>_<3-to-5-word-description>`, using lowercase `snake_case` and the real issue number, from the intended base commit.
- Never stack unrelated fixes. If a branch depends on an unmerged change, document that dependency in the PR and base or update the branch deliberately.
- Name the regression `Issue<number>Test.java`. Place core tests under `core/org.osate.core.tests/src/org/osate/core/tests/issues/`; for other bundles, follow the established nearby issue-test location.
- Store AADL fixtures as a separate OSATE project. For core tests use `core/org.osate.core.tests/models/issue<number>/`; for other bundles use their established `models/issue<number>/` location. Never embed the AADL model as a Java string.
- Each model project must include a `.project` named `issue<number>` and a `.gitignore` containing `/.aadlbin-gen/` and `/instances/`. Name the primary fixture `Issue<number>.aadl` unless established nearby tests require multiple descriptive files.
- Follow the surrounding Xtext test pattern: `XtextRunner`, `Aadl2InjectorProvider`, `XtextTest`, injected `TestHelper`, and `ValidationTestHelper.assertNoIssues` before exercising the behavior.
- Make the assertion specific to the reported defect. Confirm that the regression fails for the intended reason before the fix and passes afterward.
- Commit only the regression test and its model project first. Use the subject `Add regression test for issue #<number>`, followed by a blank line and a body explaining the modeled failure, assertion, and isolation from unrelated behavior.
- Implement the narrow production fix in a separate second commit. It must make the regression pass, preserve related characterization tests and headless boundaries, and avoid unrelated cleanup.
- Before every commit, stage only that commit's intended files, run `git diff --cached --check`, and inspect the staged diff. Preserve unrelated user changes.
- Unless the user requests otherwise or the issue requires explicitly approved supporting changes, the issue branch and PR must contain the regression commit followed by the production-fix commit.

### Validation and pull requests

- Run the focused regression from the repository root with a Maven lifecycle that executes Tycho tests, using `-Dtest=Issue<number>Test -DfailIfNoTests=false` when applicable.
- Run related existing tests separately when a combined selection could conceal zero matched tests. Inspect the selected bundles' Surefire reports and require non-zero test counts; a green reactor with zero matching tests is a failure.
- Before opening the PR, run this clean root-reactor build outside the sandbox:

```bash
mvn -s releng/osate.releng/settings.xml -Plocal \
  -Dtycho.localArtifacts=ignore \
  -Dpr.build=true -Dsign=false \
  -Dspotbugs=false -Dcodecoverage=false -Djavadoc=false \
  -DfailIfNoTests=false \
  clean install
```

- Run `git diff --check`, confirm the worktree is clean, verify that the branch diff contains only issue-specific regression assets and production changes, and confirm that the regression commit precedes the fix commit.
- Do not push a branch or open a PR unless the user asks.
- The PR title must end with exactly ` 🤖`.
- The PR body must include `Fixes #<issue-number>`, the cause and correction, the regression model and assertion, validation commands and results, dependencies on earlier PRs, and residual risk.
- Report the PR URL, validation results, and its dependency or merge-order position. Never run `gh pr merge`, enable auto-merge, or place the PR in a merge queue; present the validated PR to the user and stop.

## Versioning

Version is `2.19.0-SNAPSHOT` across the reactor. Bumps are done by the scripts in `releng/version-management/`, not by hand-editing POMs and MANIFESTs — mismatches between a bundle's `Bundle-Version`, its feature inclusion, and its pom `<version>` will break the Tycho build.

**Never modify `releng/version-management/release.xml`.** It is the Oomph version-management release baseline (referenced by every bundle's `.project` via `release.path`); the Oomph tooling maintains it, and hand-editing it will corrupt version-change detection.

## CI

`Jenkinsfile` runs on `OpenJDK21` + Maven `M3`. PR builds use `-Plocal -Dpr.build=true` with Sonar PR decoration; master builds use `-Pfull` and then `./deploy.sh`. JaCoCo, SpotBugs, and JUnit results are always collected from `**/target/...`.
