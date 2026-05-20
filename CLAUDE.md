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
- Single module + its tests: `mvn -s releng/osate.releng/settings.xml -Plocal -pl core/org.osate.aadl2,core/org.osate.core.tests -am verify` (Tycho requires `-am` to pull in reactor dependencies; you cannot build a single bundle in isolation).
- Single test class/method: `-Dtest=ClassName` or `-Dtest=ClassName#method` on a test-bundle module (the `tycho-surefire-plugin` configuration is inherited from `releng/org.osate.build.main/pom.xml`).

Most developers build via the Eclipse launch configurations in `releng/osate.releng/*.launch` (imported as the `osate.releng` project). `settings.xml` is the public settings file; `seisettings.xml` is SEI-internal (used by CI) and will not work outside that network.

The `maven-enforcer-plugin` requires Maven 3.9.0+. `jgit.dirtyWorkingTree=warning` locally, `error` in the `full` profile — the CI build fails on uncommitted changes.

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

## Versioning

Version is `2.19.0-SNAPSHOT` across the reactor. Bumps are done by the scripts in `releng/version-management/`, not by hand-editing POMs and MANIFESTs — mismatches between a bundle's `Bundle-Version`, its feature inclusion, and its pom `<version>` will break the Tycho build.

## CI

`Jenkinsfile` runs on `OpenJDK21` + Maven `M3`. PR builds use `-Plocal -Dpr.build=true` with Sonar PR decoration; master builds use `-Pfull` and then `./deploy.sh`. JaCoCo, SpotBugs, and JUnit results are always collected from `**/target/...`.
