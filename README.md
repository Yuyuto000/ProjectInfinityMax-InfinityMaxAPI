Project:Infinity Max - Infinity Max API
=======
## Directory
```
infinitymax-api/
├── build.gradle / gradle.properties / gradlew
├── src/main/java/com/infinitymax/api/
│   ├── ProjectInfinityMaxAPI.java
│   │
│   ├── core/
│   │   ├── EventBus.java
│   │   ├── Event.java
│   │   ├── LoaderHooks.java
│   │   ├── NetworkHandler.java
│   │   ├── RegistryHandler.java
│   │   └── CompatLoader.java
│   │
│   ├── energy/
│   │   ├── IEnergyStorage.java
│   │   ├── EnergyManager.java
│   │   ├── EnergyNetwork.java
│   │   └── IEnergyCompat.java
│   │
│   ├── compat/
│   │   ├── fabric/
│   │   │   ├── FabricCompatInitializer.java
│   │   │   └── FabricEnergyCompat.java
│   │   │
│   │   └── neoforge/
│   │       ├── NeoForgeCompatInitializer.java
│   │       └── NeoForgeEnergyCompat.java
│   │
│   └── util/
│       └── LogHelper.java
│
└── src/main/resources/
    ├── fabric.mod.json
    └── META-INF/mods.
```
Features
======
This mod is the core API of Project Infinity Max and is responsible for connecting each Infinity Max Mod and its add-on mods.
This mod is a prerequisite mod. 
Introducing only:
**this mod does not add new items!** Also The true power of this mod will be realized when all other Infinity Max Mods are installed! Please be careful.

Supported loaders: NeoForge, Fabric
(If you use Fabric, Fabric API is required.)

Supported Minecraft Version 1.21.1

Mapping Names:
============
By default, the MDK is configured to use the official mapping names from Mojang for methods and fields 
in the Minecraft codebase. These names are covered by a specific license. All modders should be aware of this
license. For the latest license text, refer to the mapping file itself, or the reference copy here:
https://github.com/NeoForged/NeoForm/blob/main/Mojang.md

Additional Resources: 
==========
Community Documentation: https://docs.neoforged.net/  
NeoForged Discord: https://discord.neoforged.net/

Developer Memos:
======
IDEでライブラリが足りなかったり、問題が発生したりした場合は、
`gradlew --refresh-dependencies` を実行してローカルキャッシュをリフレッシュ
