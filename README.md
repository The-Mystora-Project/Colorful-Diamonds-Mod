# Colorful Diamonds Mod

Color diamonds with any of Minecraft's 16 dyes, then use them to make matching blocks, armor, and tools. This repository contains the shared mod code and the Fabric, Forge, and Quilt versions.

## License

The original code and artwork in this repository are licensed under the [MIT License](LICENSE). Minecraft and any third-party materials retain their respective owners' rights.

## Building

Set `JAVA_HOME` to a JDK 17 installation, then run `./gradlew build` from the repository root. To launch a development client, run `./gradlew :fabric:runClient` or `./gradlew :forge:runClient`. For IntelliJ IDEA, `./gradlew :forge:genIntellijRuns` generates the Forge run configuration. The release JARs are written to `fabric/build/libs`, `forge/build/libs`, and `quilt/build/libs`.

The `common` directory holds shared source and resources. Each loader project compiles them alongside its own entrypoint and handles registration with its native loader APIs. Architectury is not required to build or run the mod.
