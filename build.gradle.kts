plugins {
    kotlin("jvm") version "2.1.21"
}

group = "net.exoad"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
val flatlafVersion = "3.6"

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.formdev:flatlaf:${flatlafVersion}")
    implementation("com.formdev:flatlaf-intellij-themes:${flatlafVersion}")
    implementation("com.formdev:flatlaf-extras:${flatlafVersion}")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}