plugins {
	id("buildSrc.common")
}

dependencies {
	implementation(project(":company:core"))
	implementation(project(":shared:core"))
	implementation(project(":shared:app"))
}
