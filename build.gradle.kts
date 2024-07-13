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
