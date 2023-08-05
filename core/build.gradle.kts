plugins {
    id("java")
    idea
}

idea {
    module {
        isDownloadSources = true
        isDownloadJavadoc = true
    }
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}