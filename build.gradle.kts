import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "dev.tonimatas"
version = "1.0.0"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("dev.discordmk:quark:1.0.0")
    implementation("com.formdev:flatlaf:3.4")
}

tasks.withType<ShadowJar> {
    archiveClassifier.set("")
    mergeServiceFiles()
    exclude("META-INF/LICENSE")
    
    manifest.attributes("Main-Class" to "dev.discordmk.neutron.Main")
}

tasks.jar {
    archiveClassifier.set("plain")
}
