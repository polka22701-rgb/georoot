# First Safe Worldgen Experiment Plan

## Experiment goal

The first terrain JSON experiment should be inactive or isolated. It must not affect normal world creation.

## Safety gate before implementation

- `.\gradlew.bat build` passes.
- `.\gradlew.bat runClient` launches.
- `.\gradlew.bat runDatagen` passes.
- Docs match current behavior.
- The working tree is clean or intentionally staged.
- A rollback plan exists.

## Proposed inactive experiment shape

Use a georoot-namespaced test `density_function` that is not referenced by vanilla overworld generation. A docs-only JSON design is also acceptable before generating any actual resource.

Do not connect the test resource to `noise_settings` yet.

## Future implementation steps

1. Add one georoot-namespaced density function.
2. Run datagen.
3. Validate that the generated JSON exists and is namespaced under `georoot`.
4. Confirm no vanilla worldgen resource changed.
5. Only later consider a disposable-world test or isolated preset.

## Risks

- Invalid `density_function` syntax.
- Accidental `minecraft:overworld` override.
- Bad generated resources path.
- Stale docs.
- False confidence from a JSON file that exists but is unused.

## Rollback

- Remove the generated JSON.
- Revert the experiment commit.
- Keep the previous safe tag.

## Codex rule

The next prompt must explicitly say whether implementation is allowed. Until then, do not implement the experiment.
