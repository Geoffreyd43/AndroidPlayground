plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    application
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

sourceSets.main {
    java.srcDirs("src/main/kotlin")
}

application {
    mainClass.set("com.example.kotlinplayground.PlaygroundKt")
}
