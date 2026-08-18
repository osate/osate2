#!/usr/bin/env python3
"""Scoped coverage gate for the across-first connection traversal (issue #3037).

Tycho cannot enforce a JaCoCo rule scoped to one package of one bundle, so this reads the
JaCoCo XML report and fails below either floor, which is what the plan's coverage gate asks
for. It also classifies every uncovered line so that the report can be read rather than
argued with.

Usage, after running the core tests with coverage:

    mvn -o -s releng/osate.releng/settings.xml -Plocal \\
      -pl :org.osate.aadl2.instantiation,:org.osate.core.tests \\
      -Dtycho.localArtifacts=default -Dpr.build=true -Dcodecoverage=true \\
      -DfailIfNoTests=false clean install

    mvn -o -pl :org.osate.aadl2.instantiation -s releng/osate.releng/settings.xml -Plocal \\
      org.jacoco:jacoco-maven-plugin:0.8.13:report \\
      -Djacoco.dataFile=$PWD/core/org.osate.core.tests/target/jacoco.exec

    python3 releng/scripts/check-across-first-coverage.py

A line is classified as defensive when it is a null or invariant check that throws, or the
throw itself. Such a line is unreachable from any test, because the package is not exported
and production never passes what it rejects; reaching it would mean an implementation defect.
Defensive lines and branches are reported and then excluded from the floors. Everything else
counts, and a floor miss fails.

The floors are lower than the plan's 90 and 85 by reviewer decision; see the comment on them.
"""

import re
import sys
import xml.etree.ElementTree as ET
from pathlib import Path

REPORT = Path("core/org.osate.aadl2.instantiation/target/site/jacoco/jacoco.xml")
SOURCES = Path("core/org.osate.aadl2.instantiation/src")
PACKAGE = "org.osate.aadl2.instantiation.internal"
# The plan asked for 90% line and 85% branch. The floors here are the measured coverage of the
# reachable code, rounded down, and they are lower because of what remains: not-applicable and
# failure outcomes in endpoint resolution, and mapping fallbacks in leaf expansion, which need
# either invalid models the corpus does not have or unit access to a package that is deliberately
# unexported. The reviewer settled that on 2026-08-18, with the gap list below as the record.
# Treat them as a ratchet: they may rise, and a fall means a test was lost.
LINE_FLOOR = 89.0
BRANCH_FLOOR = 77.0

THROWS = re.compile(r"throw new (IllegalArgumentException|IllegalStateException)")

# Temporary migration scaffolding, removed with the rest of it in Phase 6. Its branches are the
# recording flags, whose disabled side only production takes and no test measures.
SCAFFOLDING = {"TraversalObservations.java"}


def source_lines(class_name):
    path = SOURCES / (class_name.split("$")[0].replace(".", "/") + ".java")
    if not path.exists():
        return {}
    return {number: text for number, text in enumerate(path.read_text().split("\n"), 1)}


def defensive_block(lines, number):
    """Whether this line is an invariant check that throws, or part of the throw it guards.

    A guard and the throw it owns are one piece of defensive code: the branch the guard does not
    take is the unreachable one, and counting it as a missing test would ask for a test that
    constructs an invalid internal value, which the unexported package does not allow and
    production never does.
    """
    text = lines.get(number, "")
    if THROWS.search(text):
        return True
    # a throw split over several lines: look back for the throw that owns this continuation
    for back in range(number - 1, max(0, number - 5), -1):
        earlier = lines.get(back, "").rstrip()
        if THROWS.search(earlier) and earlier.endswith(("(", ",", "+")):
            return True
        if earlier.endswith((";", "}", "{")):
            break
    # a guard whose body throws, within the next few lines
    if text.strip().startswith(("if (", "} else if (")):
        for ahead in range(number + 1, number + 5):
            following = lines.get(ahead, "").strip()
            if not following:
                continue
            if THROWS.search(following):
                return True
            break
    return False


def main():
    if not REPORT.exists():
        sys.exit("No JaCoCo report at " + str(REPORT) + ". See the usage note in this script.")

    tree = ET.parse(REPORT)
    package = None
    for candidate in tree.getroot().findall("package"):
        if candidate.get("name").replace("/", ".") == PACKAGE:
            package = candidate
    if package is None:
        sys.exit("The report has no data for " + PACKAGE)

    sources = {}
    for sourcefile in package.findall("sourcefile"):
        sources[sourcefile.get("name")] = sourcefile

    counted = {"line": [0, 0], "branch": [0, 0]}
    defensive = {"line": 0, "branch": 0}
    gaps = []

    for name, sourcefile in sorted(sources.items()):
        if name in SCAFFOLDING:
            continue
        lines = source_lines(PACKAGE + "." + name[:-5])
        for line in sourcefile.findall("line"):
            number = int(line.get("nr"))
            missed_instructions = int(line.get("mi"))
            covered_instructions = int(line.get("ci"))
            missed_branches = int(line.get("mb"))
            covered_branches = int(line.get("cb"))
            is_defensive = defensive_block(lines, number)
            missed_line = 1 if covered_instructions == 0 and missed_instructions > 0 else 0
            covered_line = 1 if covered_instructions > 0 else 0
            if is_defensive:
                defensive["line"] += missed_line
                defensive["branch"] += missed_branches
                if missed_line or missed_branches:
                    gaps.append((name, number, "defensive", lines.get(number, "").strip()))
                continue
            counted["line"][0] += covered_line
            counted["line"][1] += missed_line
            counted["branch"][0] += covered_branches
            counted["branch"][1] += missed_branches
            if missed_line or missed_branches:
                gaps.append((name, number, "missing test" if missed_line else "partial branch",
                             lines.get(number, "").strip()))

    line_total = counted["line"][0] + counted["line"][1]
    branch_total = counted["branch"][0] + counted["branch"][1]
    line_pct = 100.0 * counted["line"][0] / line_total if line_total else 100.0
    branch_pct = 100.0 * counted["branch"][0] / branch_total if branch_total else 100.0

    print(PACKAGE)
    print("  reachable lines    %.1f%% (%d of %d), floor %.0f%%"
          % (line_pct, counted["line"][0], line_total, LINE_FLOOR))
    print("  reachable branches %.1f%% (%d of %d), floor %.0f%%"
          % (branch_pct, counted["branch"][0], branch_total, BRANCH_FLOOR))
    print("  excluded as defensive: %d lines, %d branches" % (defensive["line"], defensive["branch"]))
    print("  excluded as temporary scaffolding: " + ", ".join(sorted(SCAFFOLDING)))
    print()
    for name, number, kind, text in gaps:
        print("  %-34s %5d  %-14s %s" % (name, number, kind, text[:80]))

    failed = []
    if line_pct < LINE_FLOOR:
        failed.append("line coverage %.1f%% is below the %.0f%% floor" % (line_pct, LINE_FLOOR))
    if branch_pct < BRANCH_FLOOR:
        failed.append("branch coverage %.1f%% is below the %.0f%% floor" % (branch_pct, BRANCH_FLOOR))
    if failed:
        sys.exit("\nFAILED: " + "; ".join(failed))
    print("\nPASSED")


if __name__ == "__main__":
    main()
