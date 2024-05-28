plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}
rootProject.name = "untitled1"

include("shared:core")
include("shared:app")
include("company:core")
include("company:app")
