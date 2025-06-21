pluginManagement {
    includeBuild("build-logic")
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "LocalChat"

include(":app")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":core:database")
include(":core:datastore")
include(":core:chatserver")
include(":core:designsystem")
include(":core:model")
include(":core:chatclient")
