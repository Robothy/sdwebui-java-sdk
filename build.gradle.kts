import java.nio.file.Files

plugins {
    `java-library`
    jacoco
    `maven-publish`
    id("io.franzbecker.gradle-lombok") version "5.0.0"
    id("com.robothy.github-repository-release-plugin") version "1.1"
    signing
//    id 'com.robothy.cn-repo' version '1.8'
}


group = "io.github.robothy"

repositories {
    mavenLocal()
    mavenCentral()
}

val jacksonVersion = "2.15.2"
val apacheHttpClient5Version = "5.2.1"
val junitVersion = "5.9.1"
val lombokVersion = "1.18.30"
val mockServerVersion = "5.14.0"


dependencies {
    implementation("org.apache.httpcomponents.client5:httpclient5:${apacheHttpClient5Version}")
    implementation("com.fasterxml.jackson.core:jackson-databind:${jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-annotations:${jacksonVersion}")
    implementation("com.fasterxml.jackson.core:jackson-core:${jacksonVersion}")
    runtimeOnly("com.fasterxml.jackson.module:jackson-modules-java8:${jacksonVersion}")

    // lombok
    implementation("org.projectlombok:lombok:${lombokVersion}")
    annotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testAnnotationProcessor("org.projectlombok:lombok:${lombokVersion}")
    testImplementation("org.projectlombok:lombok:${lombokVersion}")

    implementation("org.mock-server:mockserver-junit-jupiter-no-dependencies:${mockServerVersion}")
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-api")
}

java {
    withSourcesJar()
    withJavadocJar()
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.compileJava {
    options.encoding = "UTF-8"
}

tasks.compileTestJava {
    options.encoding = "UTF-8"
}

tasks.test {
    useJUnitPlatform()
}

tasks.register<JacocoReport>("mergeReports") {
    group = "verification"

    executionData.from(project.fileTree(".") {
        include("**/build/jacoco/*.exec")
    })

    // kotlin source
    sourceDirectories.from(project.fileTree(".") {
        include("**/src/main/java/**")
    })

    classDirectories.from(project.fileTree(".") {
        include("**/build/classes/kotlin/main/**")
    })

    reports {
        xml.required.set(true)
        html.required.set(true)
        //csv.required.set(true)
    }
}

tasks.getByName("mergeReports").dependsOn("test")



publishing {

    publications {
        create<MavenPublication>("maven") {
            groupId = project.group.toString()
            artifactId = project.name
            from(components["java"]).apply {
                pom {
                    name = "sdwebui-java-sdk"
                    setDescription("Stable Diffusion Web UI Java SDK")
                    url = "https://github.com/Robothy/sdwebui-java-sdk"

                    licenses {
                        license {
                            name = "The Apache License, Version 2.0"
                            url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                        }
                    }

                    developers {
                        developer {
                            id = "robothy"
                            name = "Fuxiang Luo"
                            email = "robothyluo@gmail.com"
                        }
                    }

                    scm {
                        url = "https://github.com/Robothy/sdwebui-java-sdk.git"
                    }

                }
            }

        }
    }

    repositories {
        mavenLocal()

        repositories {
            mavenLocal()
            maven {
                name = "GitHubPackages"
                url = uri("https://maven.pkg.github.com/Robothy/sdwebui-java-sdk")
                credentials {
                    username = (project.findProperty("GITHUB_USERNAME") ?: System.getenv("GITHUB_USERNAME")).toString()
                    password = (project.findProperty("GITHUB_TOKEN") ?: System.getenv("GITHUB_TOKEN")).toString()
                }
            }

            maven {
                name = "MavenCentral"
                url = uri("https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/")
                credentials {
                    username = findProperty("OSSRH_USERNAME").toString()
                    password = findProperty("OSSRH_PASSWORD").toString()
                }
            }

        }
    }
}

signing {
    val signingKey = findProperty("signing.secretKeyRingFile")?.
        let { Files.readString(file(it).toPath()) } ?:
        findProperty("signing.secretKey").toString()

    val signingPassword = findProperty("signing.password").toString()
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["maven"])
}