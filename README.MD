# Form and validations

Kotlin Multiplatform Library

### Publish to MavenCentral

1) Registering a Sonatype account as described here: 
   https://dev.to/kotlin/how-to-build-and-publish-a-kotlin-multiplatform-library-going-public-4a8k
2) Add developer id, name, email and the project url to
   `/convention-plugins/src/main/kotlin/convention.publication.gradle.kts`
3) Add the secrets to `local.properties`:

```
signing.keyId=...
signing.password=...
signing.secretKeyRingFile=...
ossrhUsername=...
ossrhPassword=...
```
* Generate the secretKeyRingFile
* https://dev.to/vladleesi/how-to-set-up-publication-signature-with-the-gradle-plugin-hfa

4) Run `./gradlew :formvalidations:publishAllPublicationsToSonatypeRepository`

### Build platform artifacts

#### Android aar

- Run `./gradlew :formvalidations:assembleRelease`
- Output: `/formvalidations/build/outputs/aar/formvalidations-release.aar`

#### JVM jar

- Run `./gradlew :formvalidations:jvmJar`
- Output: `/formvalidations/build/libs/formvalidations-jvm-1.0.jar`

#### iOS Framework

- Run `./gradlew :formvalidations:linkReleaseFrameworkIosArm64`
- Output: `/formvalidations/build/bin/iosArm64/releaseFramework/formvalidations.framework`

#### JS file

- Run `./gradlew :formvalidations:jsBrowserProductionWebpack`
- Output: `/formvalidations/build/dist/js/productionExecutable/formvalidations.js`

#### macOS Framework

- Run `./gradlew :formvalidations:linkReleaseFrameworkMacosArm64`
- Output: `/formvalidations/build/bin/macosArm64/releaseFramework/formvalidations.framework`

#### Linux static library

- Run `./gradlew :formvalidations:linkReleaseStaticLinuxX64`
- Output: `/formvalidations/build/bin/linuxX64/releaseStatic/libformvalidations.a`

#### Windows static library

- Run `./gradlew :formvalidations:linkReleaseStaticMingwX64`
- Output: `/formvalidations/build/bin/mingwX64/releaseStatic/libformvalidations.a`

#### Wasm binary file

- Run `./gradlew :formvalidations:wasmJsBrowserDistribution`
- Output: `/formvalidations/build/dist/wasmJs/productionExecutable/formvalidations-wasm-js.wasm`
