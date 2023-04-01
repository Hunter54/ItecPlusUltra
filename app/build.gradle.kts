import com.android.build.gradle.internal.tasks.factory.dependsOn

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.hilt)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.serialization)
    //    alias(libs.plugins.google.gms)
//    alias(libs.plugins.firebase.crashlytics)
}

android {
    namespace = "com.example.timieu2023"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.timieu2023"
        minSdk = 26
        targetSdk = 33
        versionCode = (findProperty("versionCode") as? String)?.toIntOrNull() ?: 1
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        getByName("debug") {
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
        flavorDimensions += listOf("environment")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    packagingOptions {
        resources.excludes.add("META-INF/notice.txt")
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementation(libs.bundles.compose)
    implementation(libs.room.runtime)
    implementation(libs.room.coroutines)
    annotationProcessor(libs.room.annotationProcessor)
    kapt(libs.room.annotationProcessor)
//    implementation(libs.bundles.firebase)
    implementation(libs.bundles.compose)
    implementation(libs.bundles.firebase)
    implementation(libs.bundles.hilt)
    implementation(libs.bundles.androidx)
    implementation(libs.kotlinx.coroutines.android)
    implementation("androidx.lifecycle:lifecycle-process:2.5.1")
    implementation(libs.coil)
    implementation(libs.media3)
    implementation(libs.media3Ui)
    implementation(libs.media3Session)
    implementation(libs.kotlinx.serialization)
    implementation(libs.maps)
    implementation(libs.playServicesMaps)
    implementation(libs.datastore)
    implementation(libs.bundles.retrofitAndSerialization)
    implementation(libs.squareup.okHttp)
    implementation(libs.maps.playServices)
    implementation(libs.maps.compose)
    implementation(libs.playServiceCodeScanner)
    kapt(libs.google.hiltandroidcompiler)
    testImplementation(libs.junit)
    testImplementation(libs.androidx.test.junit)
    testImplementation(libs.androidx.test.espresso.core)
    testImplementation(libs.compose.testing)
    testImplementation(libs.bundles.testing)
    debugImplementation(libs.compose.preview)
    debugImplementation(libs.compose.tooling)
    debugImplementation(libs.navigation)
    testCompileOnly(libs.hamcrest)
    testCompileOnly(libs.kotlinx.coroutines.test)
}