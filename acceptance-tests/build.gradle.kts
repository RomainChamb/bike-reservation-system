plugins {
    id("java")
    id("org.springframework.boot") version "3.4.3"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.barbebroux"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation ("org.springframework.boot:spring-boot-starter-thymeleaf")

    // Spring Boot testing utilities
    testImplementation ("org.springframework.boot:spring-boot-starter-test")

    // Selenium + junit 5
    testImplementation("org.seleniumhq.selenium:selenium-java:4.35.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Optional: WebDriverManager (simple local driver management)
    testImplementation("io.github.bonigarcia:webdrivermanager:5.3.2")

    //Testcontainers + Selenium
    testImplementation("org.testcontainers:junit-jupiter:1.19.0")
    testImplementation("org.testcontainers:postgresql:1.19.0")
    testImplementation("org.testcontainers:selenium:1.19.0")

    testImplementation("org.assertj:assertj-core:3.27.6")
}

tasks.test {
    useJUnitPlatform()
}

tasks.bootJar {
    enabled = false
}