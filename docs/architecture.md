# GeoRoot Architecture

GeoRoot is currently a Fabric 26.1.2 safe-start skeleton. The active code is intentionally minimal and does not mutate vanilla world generation.

## Current code packages

- `georoot.hop`: common mod entrypoint and shared constants.
- `georoot.hop.client`: client-only entrypoint.
- `georoot.hop.datagen`: Fabric datagen entrypoint and an empty dynamic registry provider.
- `georoot.hop.worldgen.biome`: future biome key and bootstrap organization.
- `georoot.hop.worldgen.feature`: future configured and placed feature organization.
- `georoot.hop.worldgen.surface`: future surface rule organization.

Java classes are for compile-time structure and executable behavior only. Plans, rationale, and safety notes belong in `docs/`, not in source classes.

## Layers

### Terrain and noise

Future terrain work may use namespaced `noise_settings` and `density_function` JSON. No terrain or noise JSON exists in the current stage.

### Features and trees

Future tree or feature work may use configured features and placed features. The current feature classes are empty holders and register nothing.

### Biomes

Future biome work may use bootstrap code or Fabric biome modification APIs after explicit approval. The current biome classes register no biomes and perform no biome modifications.

### Surface

Future surface work may add surface rule definitions after a separate review. The current surface package returns and registers no rules.

### Datagen

Datagen is wired as a dry run through `GeorootDataGenerator` and `GeorootWorldgenProvider`. The provider is intentionally empty, so `runDatagen` should not create terrain-affecting JSON.

### Diagnostics

Future diagnostics may include debug commands, logs, or exported overlays. No diagnostics layer is implemented yet.

## Safety rule

At this stage, vanilla worldgen must remain unchanged. Any future worldgen mutation must be small, reviewed, reversible, and documented before being enabled.
