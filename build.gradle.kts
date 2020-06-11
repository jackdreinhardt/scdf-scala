plugins {
    scala
    idea
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
}

group = "com.example"
version = "0.0.1.SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

val scalaCompilerPlugin = configurations.create("scalaCompilerPlugin")

repositories {
    mavenCentral()
}

dependencies {
    // scala
    implementation("org.scala-lang:scala-library:2.12.10")

    // spring
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:Hoxton.SR5"))
    implementation(platform("org.springframework.cloud:spring-cloud-stream-dependencies:Horsham.SR5"))
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.cloud:spring-cloud-starter-function-web:3.0.7.RELEASE")
    implementation("org.springframework.cloud:spring-cloud-starter-stream-kafka:3.0.5.RELEASE")
}
