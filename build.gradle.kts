plugins {
    id("java")
    war
    ear
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
//    deploy(project(path = ":war", configuration = "war"))
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
}

tasks.ear {
//    appDirectory = file("src/main/app")  // use application metadata found in this folder
//    libDirName = "APP-INF/lib" // put dependent libraries into APP-INF/lib inside the generated EAR
    deploymentDescriptor {  // custom entries for application.xml:
//      fileName = "application.xml"  // same as the default value
//      version = "6"  // same as the default value
        applicationName = "MainApplication"
        initializeInOrder = true
//        displayName = "Custom Ear"  // defaults to project.name
//         defaults to project.description if not set
//        description = "My customized EAR for the Gradle documentation"
//        libraryDirectory = "APP-INF/lib"  // not needed, above libDirName setting does this
//        module("my.jar", "java")  // won't deploy as my.jar isn't deploy dependency
//        webModule("my.war", "/")  // won't deploy as my.war isn't deploy dependency
//        securityRole("admin")
//        securityRole("superadmin")
//        withXml { // add a custom node to the XML
//            asElement().apply {
//                appendChild(ownerDocument.createElement("data-source").apply { textContent = "my/data/source" })
//            }
//        }
    }

    project(":earproject") {
        apply(plugin = "ear")
    }

    dependencies {
        deploy(project(path = ":", ))
    }
}