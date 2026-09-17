# Property code generator

The optional Maven `tools` profile builds the property generator, its Eclipse
UI handler, and the generator's JUnit tests. All sources use Java 21. Normal root
builds do not include these bundles.

To build and test only the tools reactor, run from the repository root after
installing the OSATE dependencies:

```sh
mvn -o -T5 -s releng/osate.releng/settings.xml -f tools/pom.xml -Plocal,tools \
  -Dtycho.localArtifacts=default -Dpr.build=true -Dsign=false \
  -Dspotbugs=false -Dcodecoverage=false -Djavadoc=false \
  clean verify
```

Use `verify` to execute the Tycho tests. The 26 exact-output tests also compile
their generated Java, including imported property sets, using the JDK compiler
with `--release 21`. They continue to compare imports, indentation, and final
newlines. Generated Java uses `var` for obvious local types, pattern matching,
expression lambdas, and `Optional.isEmpty()`. Blank lines contain no spaces or
tabs. List extraction uses `Stream.toList()`, so returned lists are unmodifiable,
including nested lists and lists extracted from constants and record fields.

Six additional tests load the freshly compiled classes and exercise scalar
getters, constant and property references, missing values, defaults, modes,
nested lists and rejection of list mutations, ranges, imported enums and units, and nested
record round-tripping. These tests use the validated AADL project in
`org.osate.propertiescodegen.tests/models/generatedjava/`.

A JDK with the Java compiler is required. Compilation failures include compiler
diagnostics, and temporary source/class files and class loaders are cleaned up
after each test.

Test reports are written to
`org.osate.propertiescodegen.tests/target/surefire-reports/`.
