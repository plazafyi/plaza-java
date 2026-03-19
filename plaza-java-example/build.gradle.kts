plugins {
    id("plaza.java")
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":plaza-java-core"))
    implementation(project(":plaza-java-client-okhttp"))
}

tasks.withType<JavaCompile>().configureEach {
    // Allow using more modern APIs, like `List.of` and `Map.of`, in examples.
    options.release.set(9)
}

application {
    // Use `./gradlew :plaza-java-example:run` to run `Main`
    // Use `./gradlew :plaza-java-example:run -Pexample=Something` to run `SomethingExample`
    mainClass = "com.plazafyi.example.${
        if (project.hasProperty("example"))
            "${project.property("example")}Example"
        else
            "Main"
    }"
}
