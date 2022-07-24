plugins {
	kotlin("multiplatform") version "1.7.10"
}

group = "mikhaylutsyury"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "1.8"
		}
		withJava()
		testRuns["test"].executionTask.configure {
			useJUnitPlatform()
		}
	}
	js(BOTH) {
		browser {
			testTask {
				useMocha()
			}
			commonWebpackConfig {
				cssSupport.enabled = true
			}
		}
	}
	sourceSets {
		val commonMain by getting
		val commonTest by getting {
			dependencies {
				implementation(kotlin("test"))
			}
		}
		val jvmMain by getting
		val jvmTest by getting
		val jsMain by getting {
			dependencies {
				implementation(npm("bigdecimal", "0.6.1"))
			}
		}
		val jsTest by getting
	}
}
