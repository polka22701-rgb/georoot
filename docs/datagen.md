# Datagen

Run datagen with:

```powershell
.\gradlew.bat runDatagen
```

Generated resources are expected under `src/main/generated` when providers write output. The current dry-run provider is empty, so it is acceptable for no JSON files to be produced.

Generated JSON must be reviewed before commit. Terrain-affecting files require extra review, especially:

- `noise_settings`
- `density_function`
- `worldgen/biome`
- `configured_feature`
- `placed_feature`
- surface rule data

Do not manually write final worldgen JSON into `src/main/resources/data/georoot/worldgen` during the dry-run stage. Terrain overrides require a separate approved implementation step.
