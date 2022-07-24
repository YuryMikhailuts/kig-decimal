plugins {
	kotlin("multiplatform") version "1.6.10"
}

group = "mikhaylutsyury"
version = "1.0-SNAPSHOT"

repositories {
	mavenCentral()
}

java {
	sourceCompatibility = JavaVersion.VERSION_11
	targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
	jvm {
		compilations.all {
			kotlinOptions.jvmTarget = "11"
		}
		withJava()
		testRuns["test"].executionTask.configure {
			useJUnitPlatform()
		}
	}
	js(BOTH) {
		browser {
			testTask {
				useMocha {
					timeout = "30000"
				}
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
