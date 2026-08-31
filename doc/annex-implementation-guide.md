# Implementing an AADL Annex in OSATE

This guide describes how to implement an Xtext-based AADL annex for OSATE, including Eclipse editor integration, model instantiation, and standalone language-server support.

It is based on these source snapshots:

- OSATE master at `6455731c10`, especially `core/org.osate.annexsupport` and `emv2/`
- OSATE branch `2409_rename_propagation_points` at `7c21bd473e`
- [`osate/contract-annex`](https://github.com/osate/contract-annex) at `9ec42866d078b1baedc8662c161aca552790f7e2`
- `~/git/aadl-language-server` at `4ee23805dc80239e7e991239aac6518b2ac92aca`

The contract-annex repository is useful as a small, clearly separated example, but it targets an older OSATE/Xtext generation. Its root POM still references OSATE `2.14.0-SNAPSHOT`, its bundles use Java 17, and its test module is commented out of the reactor. Copy its architecture, not its versions or build configuration. EMV2 is the better reference for current OSATE integration.

## 1. The essential architecture

AADL does not initially parse annex text with the annex grammar. The AADL grammar creates a placeholder object containing the raw delimited text:

```text
.aadl resource
  -> DefaultAnnexLibrary or DefaultAnnexSubclause
       name = annex name
       sourceText = "{** ... **}"
  -> AnnexParserAgent looks up the annex parser by name
  -> annex Xtext parser parses the text without the delimiters
  -> parsed AnnexLibrary or AnnexSubclause is attached to the placeholder
  -> annex linking, validation, indexing, formatting, and editor services
```

The relevant host rules are in:

- `core/org.osate.xtext.aadl2/src/org/osate/xtext/aadl2/Aadl2.xtext`
- `core/org.osate.xtext.aadl2/src/org/osate/xtext/aadl2/parsing/AnnexParserAgent.java`
- `core/org.osate.annexsupport/src/org/osate/annexsupport/AnnexParseUtil.java`

This creates two related but distinct languages:

1. The host AADL language owns the `.aadl` resource and the `annex name {** ... **};` delimiters.
2. The annex Xtext language owns the parsed objects inside the delimiters and may also have a standalone file extension such as `.emv2` or `.contract`.

That distinction is the source of most editor and language-server integration issues.

## 2. Recommended bundle layout

A practical annex normally needs these bundles:

| Bundle | Responsibility |
| --- | --- |
| `org.example.myannex` | Xtext grammar, generated Ecore model, parser, scoping, serializer, validation, and runtime Guice module |
| `org.example.myannex.ide` | Xtext generic IDE services used by language servers |
| `org.example.myannex.ui` | Eclipse editor services, content assist, outline, quick fixes, and UI refactoring |
| `org.example.myannex.annex` | Optional separate adapter containing the OSATE annex parser, linker, unparser, and extension registrations |
| `org.example.myannex.tests` | Embedded-AADL parser, linker, validator, serializer, editor, and regression tests |
| `org.example.myannex.feature` | Installable feature containing every required runtime bundle |
| `org.example.myannex.repository` | Optional standalone p2 repository |
| `org.example.myannex.instance` | Optional annex instance model and `AnnexInstantiator` |
| `org.example.myannex.analysis` | Optional analyses and Eclipse commands |

EMV2 keeps its parser/linker/unparser adapter in the main Xtext runtime bundle. Contract Annex puts the same three classes in a small `org.osate.contract.annex` bundle. Both work.

Use a separate adapter bundle when:

- the Xtext language should remain usable without the AADL embedding layer;
- annex extension registration should have a small dependency surface; or
- the language and OSATE adapter have different release or reuse boundaries.

Keeping the adapter in the runtime bundle is simpler when the language exists only as an AADL annex.

## 3. Define the grammar as an AADL annex language

### 3.1 Reuse the AADL properties grammar

Both EMV2 and Contract Annex build on OSATE's properties grammar:

```xtext
grammar org.example.myannex.MyAnnex
with org.osate.xtext.aadl2.properties.Properties

generate myAnnex "https://example.org/aadl/my-annex"

import "http://aadl.info/AADL/2.0" as aadl2
import "http://www.eclipse.org/emf/2002/Ecore" as ecore
```

This gives the annex access to AADL property expressions and the AADL metamodel. Use a stable, globally unique EPackage namespace URI.

### 3.2 Provide the two OSATE entry rules

The grammar must expose rules whose declared return types are the AADL annex base classes:

```xtext
AnnexLibrary returns aadl2::AnnexLibrary:
    MyAnnexLibrary
;

AnnexSubclause returns aadl2::AnnexSubclause:
    MyAnnexSubclause
;

MyAnnexLibrary:
    {MyAnnexLibrary}
    declarations+=Declaration*
;

MyAnnexSubclause:
    {MyAnnexSubclause}
    statements+=Statement*
;
```

This causes the generated classes to extend the AADL implementation classes. For example:

- `ErrorModelLibraryImpl extends AnnexLibraryImpl`
- `ErrorModelSubclauseImpl extends AnnexSubclauseImpl`
- `ContractLibraryImpl extends AnnexLibraryImpl`
- `ContractSubclauseImpl extends AnnexSubclauseImpl`

Do not include `annex`, `{**`, `**}`, or the final AADL semicolon in these embedded entry rules. `AnnexParserAgent` strips the delimiters before invoking the annex parser.

If standalone annex files are useful, add a separate root rule that can represent a complete standalone document. EMV2 has an `EMV2Root` in addition to the embedded `AnnexLibrary` and `AnnexSubclause` rules.

### 3.3 Make naming behavior explicit

AADL identifiers are case-insensitive. If annex identifiers should behave the same way, configure the generated parser and namespace scoping accordingly:

```mwe2
fragment = parser.antlr.XtextAntlrGeneratorFragment2 {
    options = {
        ignoreCase = true
    }
}

fragment = scoping.ImportNamespacesScopingFragment2 {
    ignoreCase = true
}
```

EMV2 does this explicitly. Do not accidentally introduce case-sensitive annex references merely because that is Xtext's default.

### 3.4 Generate runtime, IDE, and UI projects

The MWE2 workflow should:

- register `org.osate.aadl2.Aadl2Package`;
- register the AADL genmodel;
- generate the runtime model and serializer;
- generate a generic IDE project;
- generate the Eclipse UI project when Eclipse support is required;
- generate validation, scoping, formatting, content-assist, and refactoring support as needed; and
- use a unique standalone extension such as `myannex`.

Commit generated `src-gen`, `xtend-gen`, and other generated sources according to the surrounding OSATE conventions. Regenerate after every grammar change.

## 4. Implement the runtime language services

The generated runtime module is only a starting point. A useful annex commonly needs bindings for:

- `IQualifiedNameProvider`
- `IQualifiedNameConverter`
- `IGlobalScopeProvider`
- the local/imported namespace scope-provider delegate
- `IValueConverterService`
- `ISerializer`
- `ITransientValueService`
- `ICrossReferenceSerializer`
- `TextRegionAccessBuilder`
- the generated or custom validator

EMV2's current reference is:

`emv2/org.osate.xtext.aadl2.errormodel/src/org/osate/xtext/aadl2/errormodel/ErrorModelRuntimeModule.java`

Contract Annex has the smaller equivalent:

`org.osate.contract/src/org/osate/contract/ContractRuntimeModule.java`

For an annex that references AADL objects, use OSATE-aware global scoping rather than Xtext's default global scope. EMV2 and Contract use `DelegatingEClassGlobalScopeProvider` in Eclipse/runtime mode and custom imported-namespace-aware local scope providers.

The annex's qualified-name provider must describe both:

- annex declarations that should be exported to the index; and
- references into the containing AADL package, classifier, feature, property set, or other annex libraries.

Add direct tests for same-file, cross-file, public/private, extension, and realization visibility. Parsing successfully does not prove that the index or scope is correct.

## 5. Connect the Xtext language to OSATE annex support

### 5.1 Annex parser

Implement `org.osate.annexsupport.AnnexParser`. The implementation should:

1. obtain the annex injector through its unique standalone extension;
2. inject the generated parser;
3. call `AnnexParseUtil.parse`;
4. select the library or subclause grammar rule; and
5. return the standalone extension from `getFileExtension()`.

Condensed pattern:

```java
public final class MyAnnexAnnexParser implements AnnexParser {
    @Inject
    private org.example.myannex.parser.antlr.MyAnnexParser parser;

    public MyAnnexAnnexParser() {
        var provider = IResourceServiceProvider.Registry.INSTANCE
                .getResourceServiceProvider(URI.createFileURI("dummy.myannex"));
        provider.get(Injector.class).injectMembers(this);
    }

    @Override
    public AnnexLibrary parseAnnexLibrary(
            String annexName,
            String source,
            String filename,
            int line,
            int column,
            ParseErrorReporter reporter) {
        return (AnnexLibrary) AnnexParseUtil.parse(
                parser,
                source,
                parser.getGrammarAccess().getMyAnnexLibraryRule(),
                filename,
                line,
                column,
                reporter);
    }

    @Override
    public AnnexSubclause parseAnnexSubclause(
            String annexName,
            String source,
            String filename,
            int line,
            int column,
            ParseErrorReporter reporter) {
        return (AnnexSubclause) AnnexParseUtil.parse(
                parser,
                source,
                parser.getGrammarAccess().getMyAnnexSubclauseRule(),
                filename,
                line,
                column,
                reporter);
    }

    @Override
    public String getFileExtension() {
        return "myannex";
    }
}
```

Use `AnnexParseUtil` rather than directly calling the generated parser. It:

- prefixes whitespace so annex node offsets line up with the containing `.aadl` document;
- stores the annex `IParseResult` in a `ParseResultHolder`; and
- maps syntax diagnostics back to the AADL resource.

Formatting, indexing, outline, content assist, and other OSATE services later use that retained parse result to recover the annex injector and node model.

### 5.2 Annex linking service

Implement `AnnexLinkingService` using the annex injector's linking service and qualified-name provider:

```java
public final class MyAnnexLinkingService implements AnnexLinkingService {
    @Inject
    private DefaultLinkingService linkingService;

    @Inject
    private IQualifiedNameProvider nameProvider;

    // Constructor injects members from dummy.myannex, as in the parser.

    @Override
    public List<EObject> resolveAnnexReference(
            String annexName,
            EObject context,
            EReference reference,
            INode node) {
        return annexName.equalsIgnoreCase("myannex")
                ? linkingService.getLinkedObjects(context, reference, node)
                : List.of();
    }

    @Override
    public QualifiedName getFullyQualifiedName(EObject object) {
        return nameProvider.getFullyQualifiedName(object);
    }
}
```

`AnnexParserAgent` invokes the AADL resource's linker on the parsed annex object. `Aadl2LinkingService` delegates annex references back to the registered annex linking service.

### 5.3 Annex unparser

Implement `AnnexUnparser` with the annex serializer:

```java
public final class MyAnnexUnparser implements AnnexUnparser {
    @Inject
    private ISerializer serializer;

    @Override
    public String unparseAnnexLibrary(AnnexLibrary library, String indent) {
        return serializer.serialize(library);
    }

    @Override
    public String unparseAnnexSubclause(AnnexSubclause subclause, String indent) {
        return serializer.serialize(subclause);
    }
}
```

EMV2 and Contract both assign a synthetic subclause name immediately before serialization because their grammar/serializer expects one. Avoid permanent model mutation in new code. Prefer a transient-value service, a serializer customization, or restoring any temporary value in a `finally` block.

Round-trip tests should serialize an embedded annex, replace its source text, reparse the complete AADL file, and assert that it has no syntax or linking errors.

### 5.4 Register the generated package and annex adapters

Register the generated EPackage and the three basic annex services in `plugin.xml`:

```xml
<extension point="org.eclipse.emf.ecore.generated_package">
  <package
      uri="https://example.org/aadl/my-annex"
      class="org.example.myannex.myAnnex.MyAnnexPackage"
      genModel="model/generated/MyAnnex.genmodel"/>
</extension>

<extension point="org.osate.annexsupport.parser">
  <parser
      id="org.example.myannex.parser"
      name="My Annex Parser"
      annexName="myannex"
      annexNSURI="https://example.org/aadl/my-annex"
      class="org.example.myannex.annex.MyAnnexAnnexParser"/>
</extension>

<extension point="org.osate.annexsupport.linkingservice">
  <linkingservice
      id="org.example.myannex.linkingservice"
      name="My Annex Linking Service"
      annexName="myannex"
      class="org.example.myannex.annex.MyAnnexLinkingService"/>
</extension>

<extension point="org.osate.annexsupport.unparser">
  <unparser
      id="org.example.myannex.unparser"
      name="My Annex Unparser"
      annexName="myannex"
      class="org.example.myannex.annex.MyAnnexUnparser"/>
</extension>
```

Keep these values consistent:

- the AADL spelling after `annex`;
- the parser, linker, and unparser `annexName`;
- the parser's standalone file extension;
- the Xtext setup's registered extensions; and
- the generated package namespace URI.

Include `annexNSURI` on the parser registration. OSATE records the mapping and uses it to suppress annex validation after syntax or resolution failures, preventing cascaded diagnostics. EMV2 supplies it; Contract Annex does not and should not be copied in that respect.

Annex names are looked up case-insensitively by the registries, but using one canonical spelling avoids confusing metadata and tests.

## 6. Understand validation and indexing

After parsing, OSATE attaches the parsed annex object to its `DefaultAnnexLibrary` or `DefaultAnnexSubclause`. The parsed object is part of the containing AADL resource, not a separate `.myannex` resource.

Important consequences:

- offsets must remain relative to the `.aadl` document;
- AADL resource validation can encounter annex EObjects;
- the annex EPackage and validator must be registered before validation;
- the annex resource-description strategy is selected through the retained parse result or annex name;
- cross-file annex declarations must be exported with stable qualified names; and
- parse or link failures should prevent follow-on semantic validation.

`AnnexAwareResourceDescriptionStrategy` asks the annex injector for its own `IDefaultResourceDescriptionStrategy`. Test the exported index, not just live in-memory scoping.

Custom validators should use ordinary Xtext `@Check` methods and attach diagnostics to the most precise structural feature or index. Add tests for:

- no issues on a valid complete AADL model;
- the exact issue code and feature for invalid input;
- unresolved AADL references;
- unresolved annex references;
- duplicate names with AADL-compatible case handling; and
- recovery after a syntax error is fixed.

## 7. Eclipse editor integration

The generated `.ui` project provides services for standalone `.myannex` files. Embedded text is edited in the AADL editor, so verify each desired feature there separately:

- syntax highlighting;
- content assist;
- hover;
- go to definition;
- find references;
- formatting;
- outline and labels;
- quick fixes; and
- rename.

OSATE's AADL editor has annex-aware paths that recover the annex injector from `ParseResultHolder`, including completion, formatting, labels, outline, and resource descriptions. The `org.osate.annexsupport` bundle also exposes optional extension points for:

- `parser`
- `unparser`
- `resolver`
- `linkingservice`
- `textpositionresolver`
- `instantiator`
- `highlighter`
- `contentassist`

Implement only the optional extensions your annex semantics require. For an Xtext annex, first determine whether the current annex-aware AADL service already delegates through the retained parse result before adding a parallel legacy extension.

### 7.1 UI rename is a separate integration

Branch `2409_rename_propagation_points` demonstrates that generated standalone rename support is not sufficient for an object selected inside an AADL editor.

The branch adds:

- an Eclipse command handler that detects an EMV2 `PropagationPoint` under the AADL editor selection;
- routing from the AADL editor to the EMV2 UI injector;
- an annex-specific dependent-elements calculator;
- an annex-specific reference-updater dispatcher; and
- a rename-support factory that prevents dispatch back to the containing `.aadl` provider.

Ordinary AADL targets are delegated to the existing AADL handler. Keep this kind of domain-specific routing in the annex bundles rather than adding annex cases to generic AADL core.

UI refactoring uses the Eclipse/Xtext UI APIs under `org.eclipse.xtext.ui.refactoring`. Language-server rename uses different APIs and needs a separate implementation.

## 8. Instantiation support

If annex declarations need an instance representation, implement `AnnexInstantiator` and register it with `org.osate.annexsupport.instantiator`.

The interface has two phases:

```java
void instantiateAnnex(
        ComponentInstance instance,
        String annexName,
        AnalysisErrorReporterManager errorManager);

void instantiateAnnex(
        SystemInstance instance,
        String annexName,
        AnalysisErrorReporterManager errorManager);
```

The component overload is called once for each annex on each component instance. The system overload is called once after component processing for the system instance.

EMV2 keeps its instance Ecore model and instantiator in:

- `emv2/org.osate.aadl2.errormodel.instance/model`
- `emv2/org.osate.aadl2.errormodel.instance/src/.../instantiator/EMV2AnnexInstantiator.java`
- `emv2/org.osate.aadl2.errormodel.instance/plugin.xml`

Keep declarative parsing/linking independent from instance construction. Tests should separately cover:

- inheritance and classifier realization;
- mode-sensitive declarations;
- containment paths;
- property instantiation;
- references to instance objects;
- malformed declarative models; and
- whole-system postprocessing.

## 9. Language-server integration

### 9.1 Initialize Eclipse plug-in metadata

The standalone AADL language server starts with:

```java
EcorePlugin.ExtensionProcessor.process(null);
```

before launching Xtext's server. This loads `plugin.xml` metadata so the OSATE annex registries can discover parser, linker, unparser, instantiator, and generated-package extensions.

For other headless applications, either initialize the extension registry the same way or call the programmatic methods on `AnnexRegistry`, such as `registerAnnex`.

Do not assume that placing an annex bundle on the Java classpath automatically registers its `plugin.xml` extensions.

### 9.2 Provide an IDE setup

Generate or implement:

- `MyAnnexIdeModule`
- `MyAnnexIdeSetup`
- `META-INF/services/org.eclipse.xtext.ISetup`

Typical setup:

```java
public class MyAnnexIdeSetup extends MyAnnexStandaloneSetup {
    @Override
    public Injector createInjector() {
        return Guice.createInjector(
                Modules2.mixin(new MyAnnexRuntimeModule(), new MyAnnexIdeModule()));
    }
}
```

The generated service file should name the setup class:

```text
org.example.myannex.ide.MyAnnexIdeSetup
```

Make sure `build.properties` includes the generated service file in the packaged bundle. Inspect the built JAR rather than assuming PDE includes it.

### 9.3 Use language-server-aware scoping

`~/git/aadl-language-server` replaces OSATE's default scope providers with `Aadl2LsGlobalScopeProvider` so references work in its multi-root, project-description-based workspace.

For EMV2 it defines:

- `ErrorModelLsRuntimeModule`, extending the normal EMV2 runtime module;
- `ErrorModelLsSetup`, mixing that runtime module with `ErrorModelIdeModule`; and
- explicit registration in the language server's setup service file and provider registry.

An annex that resolves AADL or cross-project annex objects should follow this pattern:

```java
public class MyAnnexLsRuntimeModule extends MyAnnexRuntimeModule {
    @Override
    public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
        return Aadl2LsGlobalScopeProvider.class;
    }

    public Class<? extends IEClassGlobalScopeProvider> bindIEClassGlobalScopeProvider() {
        return Aadl2LsGlobalScopeProvider.class;
    }
}
```

Use the server's actual workspace scope provider rather than creating a second filesystem or project-discovery implementation.

### 9.4 Make setup ordering deterministic

Xtext discovers setups through `META-INF/services/org.eclipse.xtext.ISetup`. Multiple setups can claim the same extension, and service/JAR iteration order is not a safe precedence rule.

The AADL language server therefore builds a registry with `ResourceServiceProviderServiceLoader` and then explicitly re-registers:

1. `Aadl2LsSetup`
2. `ErrorModelLsSetup`

This ensures the language-server-flavored AADL provider owns `.aadl`, including the server extension endpoints and LS global scope provider.

When adding another annex:

- add its LS setup to the server and test service files;
- register it explicitly in the server registry;
- document whether it claims only its standalone extension or also decorates `.aadl`; and
- apply all `.aadl` decorators only after the final AADL provider has been selected.

Avoid designs where each annex independently overwrites the `.aadl` slot. Compose wrappers or use an explicit dispatcher so multiple annexes can coexist.

### 9.5 Embedded operations dispatch through `.aadl`

This is the central lesson from branch 2409.

The URI of an embedded annex object is still a URI into an `.aadl` resource. Xtext's language server selects services by the resource URI, so rename and similar operations initially obtain services from the AADL provider, not the annex's `.myannex` provider.

Basic parsing works because `AnnexParserAgent` explicitly delegates into the annex parser. That does not imply that every IDE service is automatically annex-aware.

For annex-specific IDE behavior inside `.aadl`, use a narrowly scoped AADL-provider decorator. The 2409 branch adds `EmbeddedErrorModelResourceServiceProvider`, which:

- delegates validation, resource descriptions, containers, encoding, URI handling, and every unrelated service to AADL;
- overrides only `IRenameStrategy2`; and
- delegates non-EMV2 rename targets to the original AADL rename strategy.

This is preferable to replacing the complete AADL provider or adding EMV2-specific behavior to AADL core.

If the language server constructs its own provider registry after the annex IDE setup runs, it must reapply the exported decorator to that final registry. Otherwise later AADL registration silently removes the annex behavior.

### 9.6 Do not use the AADL partial serializer for embedded annex objects

The first language-server implementation on branch 2409 tried the generic serializer-based rename path. It failed because the AADL partial serializer had no serialization context for a nested EMV2 `PropagationPoint`.

For an annex object embedded in AADL:

- locate the containing `DefaultAnnexLibrary` or `DefaultAnnexSubclause`;
- obtain its `sourceText` semantic region from the modifiable `.aadl` document;
- use the annex node model and semantic references to identify affected tokens;
- rewrite only the annex source region; and
- reparse and validate the resulting complete AADL document.

Do not perform an unrestricted textual replacement. A matching identifier may be unrelated or may occur in comments and strings.

The 2409 strategy identifies relevant semantic leaves, edits replacements from the end of the region toward the beginning, and delegates all non-EMV2 changes.

Also avoid whole-resource usage scans when a narrower semantic traversal is available. An early broad cross-reference scan made the regression take more than eight minutes; restricting inspection to concrete, non-derived EMV2 references reduced it to seconds.

### 9.7 UI and LSP APIs are different

Implement and test both paths when the annex promises the operation:

| Environment | Relevant API family |
| --- | --- |
| Eclipse UI | LTK and `org.eclipse.xtext.ui.refactoring` |
| Xtext language server | `IRenameStrategy2`, `RenameService2`, and `IChangeSerializer` |

A working Eclipse rename is not evidence that LSP rename works, and the reverse is also true.

### 9.8 Package every required bundle

The inspected AADL language-server repository:

- builds a complete OSATE p2 repository first;
- builds the language-server reactor against that repository;
- includes the OSATE core, plug-ins, and EMV2 features in its repository category;
- includes all dependencies in the language-server repository; and
- checks for duplicate bundle versions.

For a new annex, package at least:

- annex runtime bundle;
- annex adapter bundle, if separate;
- annex IDE bundle;
- generated model dependencies;
- required OSATE bundles;
- the installable annex feature; and
- the language-server bundle that references the annex LS setup.

The server bundle must have OSGi dependencies for classes it imports directly. Export any annex IDE package that the server must use, such as a provider decorator.

Validate the built repository's actual `plugins/` contents. Do not infer packaged behavior from the target platform or Maven dependency graph alone.

If the final client launches a flat classpath, inspect that classpath too. Generated parsers and their ANTLR runtimes must be compatible. The current release script also rejects duplicate symbolic-name versions, with an intentional exception for the two required `org.antlr.runtime` generations.

## 10. Testing strategy

### 10.1 Runtime and embedded-AADL tests

Use an injector provider that registers the annex standalone setup before creating the normal AADL test injector:

```java
public class MyAnnexInjectorProvider extends Aadl2InjectorProvider {
    @Override
    protected Injector internalCreateInjector() {
        MyAnnexStandaloneSetup.doSetup();
        return super.internalCreateInjector();
    }
}
```

Parse complete external `.aadl` files through `TestHelper`. Do not limit testing to direct calls of the annex parser.

For valid models:

```java
var pkg = testHelper.parseFile("models/my_test/model.aadl");
validationHelper.assertNoIssues(pkg);
```

Then retrieve and inspect the parsed annex:

```java
var placeholder = (DefaultAnnexSubclause) classifier.getOwnedAnnexSubclauses().getFirst();
var parsed = (MyAnnexSubclause) placeholder.getParsedAnnexSubclause();
```

Use separate AADL model projects for realistic indexing tests. Include:

```text
/.aadlbin-gen/
/instances/
```

in each model project's `.gitignore`, and give the project both the AADL and Xtext natures.

### 10.2 Minimum test matrix

At minimum, cover:

1. annex library parsing;
2. annex subclause parsing;
3. syntax diagnostics with correct `.aadl` ranges;
4. references from annex to AADL;
5. references from AADL or another annex section to annex declarations;
6. same-file and cross-file annex references;
7. public/private visibility and project dependencies;
8. semantic validation;
9. serialization and complete-document reparse;
10. formatting of embedded annex text;
11. Eclipse content assist/definition/rename when supported;
12. language-server diagnostics and definition;
13. language-server rename or other mutating operations when supported;
14. instance-model construction when present; and
15. packaged repository and runtime classpath contents.

### 10.3 Test the real language server

The AADL language-server tests open `.aadl` documents and assert LSP results. Follow that pattern rather than testing only the annex IDE injector.

Useful assertions include:

- the annex produces no unexpected `DiagnosticSeverity.Error`;
- diagnostic ranges point inside the annex text;
- definition locations resolve to the correct `.aadl` file and range;
- workspace and cross-project references resolve;
- a rename edits all semantic occurrences and no unrelated text;
- the edited source reparses with no issues; and
- the packaged server still advertises its custom JSON-RPC methods after annex setups are registered.

Branch 2409's `Issue2409Test` is a useful direct test of the serializer/change strategy, while `plugins/org.osate.aadl.ls.tests/.../Emv2ParsingTest.java` exercises the actual LSP surface.

## 11. Build and packaging guidance

Add every bundle to:

- its area's parent POM;
- the owning feature;
- the root reactor or external annex reactor;
- coverage configuration when applicable; and
- the update-site or language-server repository.

Do not leave the test bundle commented out as in the current contract-annex root POM.

For local OSATE iteration, select the changed runtime bundle, test bundle, and owning feature together. Install the runtime and feature when another Tycho reactor must consume them. Before release or language-server handoff, run a clean root build with `-Dtycho.localArtifacts=ignore`.

The standalone language-server build is a producer/consumer sequence:

1. build and install the complete pinned OSATE reactor;
2. build and verify the language-server reactor against the resulting OSATE p2 repository;
3. inspect the generated language-server repository for duplicates and missing annex bundles; and
4. run tests against the packaged runtime.

Do not assemble a distributable repository from an accumulated local Tycho catalog. It can contain multiple versions of the same bundle.

## 12. Common failure modes

### Annex remains raw text

Likely causes:

- parser extension was not registered;
- headless startup did not process `plugin.xml`;
- `annexName` does not match;
- parser bundle is missing from the product;
- standalone extension provider is not registered; or
- parser constructor cannot obtain the annex injector.

### Parser runs but references remain unresolved

Check:

- linking-service registration;
- qualified-name provider;
- local and global scope providers;
- resource-description exports;
- AADL public/private visibility metadata;
- project/container configuration; and
- language-server-specific global scope bindings.

### Standalone annex files work but embedded `.aadl` editing fails

The generated `.ide` or `.ui` service is being selected only for `.myannex`. Add or verify the AADL editor/LSP delegation path for the desired feature.

### Eclipse works but the language server does not

Check:

- `META-INF/services/org.eclipse.xtext.ISetup`;
- explicit setup ordering in the server registry;
- extension-registry initialization;
- LS-specific scope-provider bindings;
- annex bundles in the generated repository;
- the final `.aadl` provider after all registrations; and
- actual LSP tests rather than Eclipse injector tests.

### Rename or quick fix reports a serializer context error

The operation is trying to serialize an annex EObject through the AADL serializer. Edit the containing annex source region using the annex node model or serialize the annex root with the annex serializer.

### Validation cascades after syntax errors

Verify that the parser extension supplies `annexNSURI` and that parsing goes through `AnnexParseUtil`, allowing OSATE to associate the annex package and suppress invalid follow-on validation.

### Product builds but the distributed server fails

Inspect:

- generated p2 `plugins/`;
- duplicate bundle symbolic names and versions;
- packaged service-loader files;
- exported packages;
- OSGi `Require-Bundle` entries;
- the launcher's final classpath; and
- parser/runtime compatibility, especially ANTLR.

## 13. Implementation checklist

- [ ] Choose a canonical annex name, standalone extension, Java package, bundle prefix, and EPackage URI.
- [ ] Create grammar rules returning `aadl2::AnnexLibrary` and `aadl2::AnnexSubclause`.
- [ ] Decide and configure identifier case sensitivity.
- [ ] Register the AADL EPackage/genmodel in the MWE2 workflow.
- [ ] Generate runtime, IDE, and UI projects.
- [ ] Implement naming, scoping, serializer, value converters, and validation.
- [ ] Implement `AnnexParser` with `AnnexParseUtil`.
- [ ] Implement `AnnexLinkingService`.
- [ ] Implement `AnnexUnparser`.
- [ ] Register the generated package and annex services in `plugin.xml`.
- [ ] Include `annexNSURI` in parser registration.
- [ ] Add optional text-position, content-assist, highlighter, or instantiator extensions only when needed.
- [ ] Add Eclipse embedded-editor tests.
- [ ] Add an LS runtime module and setup when workspace scoping differs from Eclipse.
- [ ] Add the setup to service-loader files.
- [ ] Register setups deterministically in the language server.
- [ ] Decorate the final `.aadl` provider for annex-specific embedded IDE services.
- [ ] Keep ordinary AADL behavior delegated to the AADL provider.
- [ ] Add real LSP diagnostics, definition, and mutation tests.
- [ ] Add runtime, adapter, IDE, UI, test, feature, and repository modules to the build.
- [ ] Inspect generated JARs, service files, p2 metadata, and final runtime classpaths.
- [ ] Run a clean complete OSATE build before publishing or handing off to another reactor.

## 14. Source map

### OSATE annex framework

- `core/org.osate.annexsupport/plugin.xml`
- `core/org.osate.annexsupport/schema/*.exsd`
- `core/org.osate.annexsupport/src/org/osate/annexsupport/AnnexRegistry.java`
- `core/org.osate.annexsupport/src/org/osate/annexsupport/AnnexParseUtil.java`
- `core/org.osate.annexsupport/src/org/osate/annexsupport/ParseResultHolder.java`
- `core/org.osate.xtext.aadl2/src/org/osate/xtext/aadl2/parsing/AnnexParserAgent.java`
- `core/org.osate.xtext.aadl2/src/org/osate/xtext/aadl2/linking/Aadl2LinkingService.java`
- `core/org.osate.xtext.aadl2/src/org/osate/xtext/aadl2/scoping/AnnexAwareResourceDescriptionStrategy.java`

### EMV2

- `emv2/org.osate.xtext.aadl2.errormodel/src/org/osate/xtext/aadl2/errormodel/ErrorModel.xtext`
- `emv2/org.osate.xtext.aadl2.errormodel/src/org/osate/xtext/aadl2/errormodel/GenerateErrorModel.mwe2`
- `emv2/org.osate.xtext.aadl2.errormodel/src/org/osate/xtext/aadl2/errormodel/ErrorModelRuntimeModule.java`
- `emv2/org.osate.xtext.aadl2.errormodel/src/org/osate/xtext/aadl2/errormodel/parsing/`
- `emv2/org.osate.xtext.aadl2.errormodel.ide/`
- `emv2/org.osate.xtext.aadl2.errormodel.ui/`
- `emv2/org.osate.aadl2.errormodel.instance/`
- `emv2/org.osate.aadl2.errormodel.tests/`
- `emv2/org.osate.xtext.aadl2.errormodel.feature/feature.xml`

### Branch 2409

Inspect these with `git show 2409_rename_propagation_points:<path>`:

- `emv2/org.osate.xtext.aadl2.errormodel.ide/src/org/osate/xtext/aadl2/errormodel/ide/ErrorModelIdeSetup.java`
- `emv2/org.osate.xtext.aadl2.errormodel.ide/src/org/osate/xtext/aadl2/errormodel/ide/refactoring/EmbeddedErrorModelResourceServiceProvider.java`
- `emv2/org.osate.xtext.aadl2.errormodel.ide/src/org/osate/xtext/aadl2/errormodel/ide/refactoring/EmbeddedErrorModelRenameStrategy.java`
- `emv2/org.osate.xtext.aadl2.errormodel.ui/src/org/osate/xtext/aadl2/errormodel/ui/refactoring/`
- `emv2/org.osate.aadl2.errormodel.tests/src/org/osate/aadl2/errormodel/tests/issues/Issue2409Test.java`

### Contract Annex

- `org.osate.contract/src/org/osate/contract/Contract.xtext`
- `org.osate.contract/src/org/osate/contract/GenerateContract.mwe2`
- `org.osate.contract/src/org/osate/contract/ContractRuntimeModule.java`
- `org.osate.contract.annex/plugin.xml`
- `org.osate.contract.annex/src/org/osate/contract/annex/`
- `org.osate.contract.ide/`
- `org.osate.contract.ui/`
- `org.osate.contract.tests/`
- `org.osate.contract.feature/feature.xml`

### AADL language server

- `~/git/aadl-language-server/org.osate.aadl.ls/src/org/osate/aadl/ls/RunAadl2Server.java`
- `~/git/aadl-language-server/org.osate.aadl.ls/src/org/osate/aadl/ls/AadlServerModule.java`
- `~/git/aadl-language-server/org.osate.aadl.ls/src/org/osate/aadl/ls/setup/Aadl2LsResourceServiceProviderRegistry.java`
- `~/git/aadl-language-server/org.osate.aadl.ls/src/org/osate/aadl/ls/setup/ErrorModelLsSetup.java`
- `~/git/aadl-language-server/org.osate.aadl.ls/src/org/osate/aadl/ls/setup/ErrorModelLsRuntimeModule.java`
- `~/git/aadl-language-server/org.osate.aadl.ls/src/META-INF/services/org.eclipse.xtext.ISetup`
- `~/git/aadl-language-server/plugins/org.osate.aadl.ls.tests/`
- `~/git/aadl-language-server/releng/org.osate.aadl.ls.repository/category.xml`
- `~/git/aadl-language-server/scripts/build-test-release`
