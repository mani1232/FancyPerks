plugins {
    `java-library`
    id("xyz.jpenilla.run-paper") version "2.0.1" // Adds runServer and runMojangMappedServer tasks for testing
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version "8.1.1";
}

group = "de.oliver"
description = "Simple plugin that adds perks to your server"
version = "1.1.0"
val mcVersion = "1.20.1"

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://jitpack.io")
    maven("https://repo.fancyplugins.de/releases/")
    maven("https://repo.alessiodp.com/releases/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:$mcVersion-R0.1-SNAPSHOT")

    implementation("de.oliver:FancyLib:1.0.5.1")
    compileOnly("net.kyori:adventure-text-minimessage:4.13.1")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7.1")
    compileOnly("net.luckperms:api:5.4")
}

tasks {
    runServer {
        minecraftVersion(mcVersion)
    }

    shadowJar{
        archiveClassifier.set("")
    }

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
                from(project.components["java"])
            }
        }
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything

        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release.set(17)
    }
    javadoc {
        options.encoding = Charsets.UTF_8.name() // We want UTF-8 for everything
    }
    processResources {
        filteringCharset = Charsets.UTF_8.name() // We want UTF-8 for everything
        val props = mapOf(
            "version" to project.version,
            "description" to project.description,
        )
        inputs.properties(props)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}