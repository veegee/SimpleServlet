plugins {
    ear
}

dependencies {
    deploy(project(":servlet", "archives"))
}


tasks.ear {
//    appDirectory = file("src/main/application")  // use application metadata found in this folder
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
}
