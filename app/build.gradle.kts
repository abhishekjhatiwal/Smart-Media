plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.google.gms.google.services)

    id ("kotlin-android")
    id ("kotlin-kapt")
    id("com.google.dagger.hilt.android")
//    id ("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.smartmedia"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.smartmedia"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)


    // Media3 for video playback and text extraction
    implementation("androidx.media3:media3-exoplayer:1.8.0")
    implementation("androidx.media3:media3-ui:1.8.0")
    implementation("androidx.media3:media3-common:1.8.0")
    implementation("androidx.media3:media3-transformer:1.8.0")

    // Jetpack Compose
    implementation("androidx.compose.material3:material3:1.4.0")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Firebase dependencies
    implementation(platform("com.google.firebase:firebase-bom:34.4.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-ai:17.4.0")
//    implementation("com.google.firebase:firebase-vertexai")

    implementation ("androidx.compose.material:material-icons-extended:1.7.8")

    implementation("com.github.kotvertolet:youtube-jextractor:0.3.4") {
        exclude(group = "com.squareup.okhttp3", module = "okhttp")
        exclude(group = "com.squareup.okhttp3", module = "okhttp-urlconnection")
        exclude(group = "com.squareup.okhttp3", module = "logging-interceptor")
    }

    implementation("com.squareup.okhttp3:okhttp:5.2.1")
    implementation("com.squareup.okhttp3:okhttp-urlconnection:5.2.1")
    implementation("com.squareup.okhttp3:logging-interceptor:5.2.1")
    implementation("com.google.code.gson:gson:2.13.2")

    implementation ("com.pierfrancescosoffritti.androidyoutubeplayer:core:13.0.0")


    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-guava:1.10.2") // use latest version
    implementation("io.coil-kt:coil-compose:2.7.0")

    implementation("com.google.mlkit:genai-image-description:1.0.0-beta1")

    //Hilt
    implementation ("com.google.dagger:hilt-android:2.57.2")
    kapt ("com.google.dagger:hilt-android-compiler:2.57.2")
    // Hilt dependencies
    kapt("com.google.dagger:hilt-compiler:2.57.2")

    // Hilt Navigation Compose (for hiltViewModel())
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")

    // Hilt ViewModel (optional, usually included with hilt-navigation-compose)

    // ViewModel support
    implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.3.0")
    kapt ("androidx.hilt:hilt-compiler:1.3.0")
}