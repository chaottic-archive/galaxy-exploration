plugins {
    id("org.spongepowered.gradle.vanilla") version "0.2.1-SNAPSHOT"
}

group = "com.chaottic"
version = "1.0-SNAPSHOT"

minecraft {
    version("1.19.4")
    accessWideners(project.file("src/main/resources/galaxy_exploration.aw"))
}