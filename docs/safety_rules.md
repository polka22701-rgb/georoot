# Safety Rules

- No worldgen mutation until `build`, `runClient`, and `runDatagen` are stable.
- No static mutable state in worldgen code.
- No client-only code in common or server worldgen code.
- No copying code from other mods.
- No API guessing; verify Fabric and Minecraft 26.1.2 names before implementation.
- Every mutation step must be small, reversible, and documented.
- Vanilla worldgen must remain unchanged until an explicit experiment step.
- Any `noise_settings` or `density_function` override must be reviewed before enabling.
- Do not add a custom `ChunkGenerator` without explicit approval.
- Do not add external worldgen libraries without explicit approval.
