plugins {
    java
    id("org.springframework.boot") version "3.2.4"
    id("io.spring.dependency-management") version "1.1.4"

    id("org.sonarqube") version "4.0.0.2929"
    id("jacoco")
    id("checkstyle")
}


group = "pe.edu.upao.alozanoc"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    runtimeOnly("com.h2database:h2")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}


sonar {
    properties {
        property("sonar.projectName", "arquitecturaapp")
        property("sonar.projectKey", "arquitecturaapp")
        property("sonar.host.url", "http://localhost:9001")
        property("sonar.login", "sqa_757d7b36f0c1a229ebba160a88cf1a74ef094648");
    }
}

jacoco {
    toolVersion = "0.8.11"
    reportsDirectory = rootProject.file("reports/jacoco/jacocoRootReport")
}

tasks.withType<Pmd> {
    reports {
        xml.required = true
        html.required = true
    }
}

tasks.withType<Checkstyle> {
    reports {
        this.html.outputLocation = rootProject.file("reports/checkstyle/checkstyle.html")
    }
}


tasks.named("sonar") {
    dependsOn("jacocoTestReport")
}

tasks.named("jacocoTestReport") {
    dependsOn("test")
}