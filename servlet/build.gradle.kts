plugins {
    java
    war
}

group = "org.veegee"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.servlet:javax.servlet-api:3.1.0")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.war {
    // These are default
//    webAppDirectory = file("src/main/webapp")  // default; enable and edit to override
//    from("src/rootContent") // adds a file-set to the root of the archive
//    webInf { from("src/additionalWebInf") } // adds a file-set to the WEB-INF dir.
//    webXml = file("src/main/resources/WEB-INF/web.xml")  // default; enable and edit to override
    archiveFileName = "servlet.war"
}
