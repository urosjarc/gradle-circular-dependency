plugins {
    kotlin("jvm")
}

group = "com.urosjarc"
version = "0.0.0"

kotlin {
    jvmToolchain(19)
}
repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}

tasks.test {
    useJUnitPlatform()
}
