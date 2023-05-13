plugins {
    id("java")
    id("io.freefair.lombok") version "8.0.1"
}

group = "com.chaottic"
version = "1.0-SNAPSHOT"

val common = project("common")

subprojects {
    apply(plugin = "java")
    apply(plugin = "io.freefair.lombok")

    project.takeIf { it != common }?.let {

        dependencies {
            implementation(common)
        }
    }
}

allprojects {
    repositories {
        mavenCentral()
    }

    dependencies {
        testImplementation(platform("org.junit:junit-bom:5.9.1"))
        testImplementation("org.junit.jupiter:junit-jupiter")
    }

    tasks.test {
        useJUnitPlatform()
    }
}