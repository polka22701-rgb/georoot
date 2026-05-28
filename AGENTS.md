# Georoot — Codex Project Instructions

## Project Identity

Georoot is a Fabric Minecraft terrain/worldgen mod for Minecraft 26.1.2.

Runtime target:
- Minecraft: 26.1.2
- Java: 25
- Mod loader: Fabric

Georoot is a terrain-first overhaul.

Main goals:
- improve landforms;
- improve terrain transitions;
- improve mountains;
- improve rivers;
- improve oceans and shores;
- improve the overall world feel.

Georoot must not become a biome pack.

Vanilla biomes must remain the foundation of the world. Compatibility with biome mods is important where technically possible.

## Core Design Direction

Development priority:

1. Terrain and landscape shape.
2. Surface visual rules.
3. Features and vegetation.
4. Biome-level changes.

The core of Georoot is:
- landscape;
- terrain;
- noise;
- density;
- macro relief;
- smooth transitions.

SurfaceRules are a secondary visual layer. They should support terrain readability, not replace terrain design.

ConfiguredFeature and PlacedFeature should be used only when they are actually needed.

Vanilla biomes should remain recognizable. Biome replacement is not the main goal.

BiomeModifications must be used cautiously and compatibly.

Do not add TerraBlender, Biolith, Lithostitched or similar libraries without a separate decision, reason and risk review.

## Non-Negotiable Safety Rules

1. Do not invent Fabric, Minecraft, Loom, Mojang mapping or worldgen APIs.
2. Do not treat outdated Yarn-style tutorials as a source of truth.
3. Verify all Minecraft/Fabric 26.1.2 APIs against the actual project dependencies, MCP/tools, official sources or inspected source code.
4. If the exact class, method or signature is unknown, find and verify it before using it.
5. Do not change Gradle, Fabric, Java or Minecraft versions without explicit user permission.
6. Do not change runtime hooks or worldgen hooks without a separate explicit task.
7. Do not delete files or directories without explicit user permission.
8. Do not add dependencies without explaining why they are necessary.
9. Do not run destructive Git commands without explicit user permission.
10. Before any changes, run or inspect `git status`.
11. If the working tree is dirty, stop and report the changed files to the user before editing.
12. Do not overwrite user changes.
13. Do not hide uncertainty.

Forbidden without explicit permission:
- `git reset --hard`;
- `git clean`;
- force push;
- rebase;
- squash;
- merge;
- tag creation;
- dependency changes;
- Gradle wrapper changes;
- Java version changes;
- Minecraft/Fabric/Loom version changes;
- deleting files;
- replacing worldgen architecture.

## External Project Notes

External project notes may exist outside the repository, for example:

```text
C:\Users\polka\OneDrive\Desktop\Georoot проект\
```

These documents are reference notes only.

They may be used for:
- terminology;
- architectural ideas;
- risk discovery;
- project goals;
- validation targets;
- checklists;
- debugging strategy.

They must not be used as direct source implementation.

Do not copy from them:
- code;
- JSON;
- configs;
- algorithms;
- implementation details.

Any sample code from these documents must be treated as unverified pseudocode until it has been checked against:
- the actual project dependencies;
- Minecraft 26.1.2 APIs;
- Fabric API for 26.1.2;
- current project code.

## Reference Mods Policy

The following projects may be used only as inspiration/reference:

- Tectonic;
- TerraForged / ReTerraForged;
- RTG / RTG+;
- Lithosphere;
- Big Globe;
- Geophilic;
- Biomes O' Plenty;
- TerraBlender;
- Biolith;
- Lithostitched;
- Noisium;
- C2ME;
- Chunky;
- other terrain, biome, worldgen or optimization mods.

Do not copy:
- source code;
- JSON files;
- configs;
- density functions;
- noise settings;
- algorithms;
- implementation structure verbatim.

Allowed high-level ideas:
- terrain-first design;
- cautious density/noise changes;
- compatibility with biome mods;
- data-driven decoration;
- separation of keys, builders and registration;
- debug evidence before terrain mutation;
- thread-safety in chunk/worldgen code;
- performance-aware worldgen design.

If an idea comes from another project, describe it as inspiration/reference, not as source implementation.

## Worldgen Rules

Georoot worldgen must follow these principles:

1. Terrain-first.
2. Macro relief before detail.
3. Smooth transitions before dramatic isolated features.
4. No biome replacement as the main goal.
5. Avoid hardcoded hacks.
6. Avoid seed-specific or coordinate-specific patches.
7. Density/noise changes must be small and reviewable.
8. Terrain mutations require debug evidence.
9. Risky changes require a rollback or disable plan.
10. Validation must consider seed, coordinates, biome and context.
11. Extreme cases matter: p95, p99 and top outliers should be reviewed where relevant.

Terrain mutation includes changes to:
- density functions;
- noise settings;
- terrain samplers;
- chunk generation;
- biome source behavior;
- world preset wiring;
- surface rules that materially affect generation;
- registry/datagen worldgen output.

Any terrain mutation must include:

1. Motivation.
2. Exact touched files.
3. Expected visual effect.
4. Debug or analysis evidence.
5. Known risks.
6. Rollback or disable strategy.
7. Test plan.
8. Seed and coordinate validation plan where relevant.

Useful evidence may include:
- debug overlay CSV;
- height samples;
- slope samples;
- density/noise samples;
- river/coast/ocean diagnostics;
- p95/p99/top outlier reports;
- before/after screenshots;
- latest logs;
- crash reports.

## Docs-Only Rules

If a task is read-only or docs-only, do not modify:

- Java code;
- Gradle files;
- resources;
- mixins;
- worldgen JSON;
- datagen classes;
- generated runtime files.

Docs-only changes may touch only documentation files such as:

- `docs/`;
- `README.md`;
- project instruction files such as `AGENTS.md`, if explicitly requested.

Even for docs-only tasks, do not edit files unless the user explicitly asks for edits.

At the end of a docs-only task, explicitly state that code/runtime files were not changed.

Documentation must distinguish:
- observed evidence;
- hypothesis;
- implementation plan;
- implementation result;
- validation result;
- risk;
- uncertainty.

Do not claim runtime behavior changed if only documentation changed.

## Code and Runtime Task Rules

For code/runtime tasks, use this workflow:

1. Analyze the current state.
2. Check `git status`.
3. Identify relevant files.
4. Prepare a plan.
5. Explain risks.
6. Make minimal changes.
7. Run appropriate checks.
8. Report results.

Do not:
- make broad refactors without need;
- mix docs-only changes with runtime/code changes unless explicitly requested;
- format unrelated files;
- rewrite architecture casually;
- touch high-risk areas without explaining the risk.

After changes, report:

1. changed files;
2. why they changed;
3. remaining risks;
4. checks performed;
5. checks not performed;
6. suggested verification command;
7. safe suggested commit message.

## Java Source Rules

`src/main/java/` is a high-risk runtime area.

Before changing Java code:

1. Inspect current architecture.
2. Identify exact classes and methods.
3. Verify Minecraft/Fabric 26.1.2 APIs.
4. Explain the intended behavior.
5. Explain runtime/worldgen risks.

Do not:
- invent mappings;
- invent class names;
- invent method signatures;
- blindly port old tutorial code;
- add mixins unless explicitly requested;
- change chunk generation behavior without a rollback plan;
- introduce mutable global worldgen state.

High-risk Java areas:
- chunk generator;
- terrain sampler;
- density/noise logic;
- region selector;
- height combiner;
- registry bootstrap;
- world preset setup;
- datagen;
- mixins;
- debug overlay command logic.

## Resources Rules

`src/main/resources/` can affect runtime loading, registries, datapacks, assets and worldgen JSON.

Before editing resources:

1. Identify whether the file is metadata, asset, data, lang, registry, worldgen JSON or mixin config.
2. Check namespace and paths.
3. Do not rename files casually.
4. Do not change the mod id without explicit permission.

High-risk resource files:
- `fabric.mod.json`;
- mixin configs;
- worldgen JSON;
- dimension files;
- world preset files;
- registry-related data.

Do not:
- invent registry keys;
- invent JSON formats;
- copy configs from other mods;
- change namespace without checking references;
- claim compatibility without testing.

## Gradle and Version Rules

Do not change these without explicit user permission:

- `build.gradle`;
- `settings.gradle`;
- `gradle.properties`;
- `gradle/wrapper/*`;
- Java version;
- Minecraft version;
- Fabric Loader version;
- Fabric API version;
- Loom version.

If a version or dependency change seems necessary, first explain:

1. why it is needed;
2. what files would change;
3. what risks it creates;
4. how to roll it back;
5. which verification commands should be run.

## `run/` Directory Rules

`run/` is a development runtime and diagnostics directory.

It may be read for:
- `run/logs/latest.log`;
- `run/logs/debug.log`;
- `run/crash-reports/`;
- debug overlay CSV;
- worldgen/debug exports;
- local reproduction evidence.

Do not treat `run/` as core source code.

Do not commit unless explicitly selected and justified:
- `run/saves/`;
- `run/logs/`;
- `run/crash-reports/`;
- `run/options.txt`;
- local config files;
- temporary CSV files;
- screenshots or exports without a documented purpose.

Debug overlay CSV files may be analyzed, but should not be committed without explicit purpose.

CSV/debug analysis should preserve:
- raw values;
- derived labels;
- seed;
- coordinates;
- dimension;
- biome/context where available;
- p95/p99/top outliers where useful.

## `tools/` Directory Rules

`tools/` may be used for read-only analysis helpers.

Allowed:
- CSV analyzers;
- debug overlay analyzers;
- report generators;
- validation helpers;
- scripts that inspect project files without modifying runtime code.

Tools must be safe by default.

By default, tools must not:
- delete files;
- overwrite raw evidence;
- modify source code;
- modify resources;
- modify Gradle files;
- mutate runtime data.

Any destructive or write operation must require:
- an explicit flag;
- a clear output path;
- overwrite behavior documentation;
- separate user permission where appropriate.

CSV/debug analysis must be reproducible:
- document input path;
- document command;
- document output path;
- keep raw evidence separate from interpreted conclusions.

## Performance and Thread-Safety Rules

Worldgen and chunk generation may run in parallel.

Do not use:
- mutable static state in worldgen code;
- global `Random`;
- non-deterministic shared mutable caches;
- cross-chunk reads that assume synchronous generation;
- lighting data during generation phase.

If randomness is needed, use the context-provided random source where available.

Do not assume lighting is valid during `Feature` placement or terrain generation.

Do not add optimization mods as dependencies without a separate reason and compatibility review.

When considering compatibility with C2ME, Noisium, ScalableLux or similar tools:
- avoid shared mutable state;
- keep generation deterministic where possible;
- isolate per-chunk/per-context state;
- avoid relying on generation order;
- document any known compatibility risk.

## Verification Commands

Prefer safe, targeted checks.

Useful commands:

```powershell
git status --short --branch
```

Shows branch and dirty working tree.

```powershell
.\gradlew.bat tasks
```

Lists available Gradle tasks.

```powershell
.\gradlew.bat compileJava
```

Checks Java compilation.

```powershell
.\gradlew.bat processResources
```

Checks resource processing, including `fabric.mod.json` expansion.

```powershell
.\gradlew.bat check
```

Runs configured checks if available.

```powershell
.\gradlew.bat build
```

Runs a broader build. This may take longer.

```powershell
.\gradlew.bat runDatagen
```

Use when datagen is configured and datagen/worldgen generated resources need validation.

```powershell
.\gradlew.bat runClient
```

Use only when runtime Minecraft/Fabric behavior needs validation. This can take time.

Do not run long commands without explaining why they are needed.

If a command may take significant time, first explain:
- what it verifies;
- why it is relevant;
- what failure would mean.

If a command fails, report the failure honestly and summarize the relevant error.

## Git Rules

Before editing, check:

```powershell
git status --short --branch
```

If there are existing changes:

1. stop;
2. report them;
3. do not overwrite them;
4. do not revert them;
5. ask or proceed only if the requested change is clearly safe and isolated.

Never run destructive Git operations without explicit user permission.

## Communication Rules

When reporting to the user:

1. Use Russian.
2. Be direct and factual.
3. Do not overstate results.
4. Do not hide errors.
5. Say when something was not checked.
6. Say when code/runtime files were not changed.
7. For risky tasks, stop and explain the risk before editing.
8. For incomplete information, explain exactly what needs verification.

For every completed code/runtime change, provide:

1. summary;
2. changed files;
3. why they changed;
4. remaining risks;
5. verification commands;
6. checks actually run;
7. next safe step;
8. suggested commit message.

## Risk Classification

Low-risk:
- docs;
- comments;
- README updates;
- planning notes;
- read-only analysis instructions.

Medium-risk:
- helper scripts;
- debug analysis tools;
- non-runtime diagnostics;
- validation reports.

High-risk:
- worldgen behavior;
- chunk generation;
- density/noise logic;
- registry bootstrap;
- world preset wiring;
- Fabric entrypoints;
- mixins;
- datagen;
- resources affecting registries;
- Gradle/Fabric/Minecraft/Java versions.

High-risk changes require explicit user approval before editing.
