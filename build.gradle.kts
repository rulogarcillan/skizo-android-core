plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    buildFeatures {
        viewBinding = true
    }
    compileSdkVersion(Dependencies.SdkVersion.sdkVersion)
    buildToolsVersion(Dependencies.SdkVersion.buildVersion)

    defaultConfig {
        minSdkVersion(Dependencies.SdkVersion.minSdkVersion)
        targetSdkVersion(Dependencies.SdkVersion.sdkVersion)
        versionCode = 1
        versionName = "1.0"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    lintOptions {
        isCheckReleaseBuilds = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

}

dependencies {
    implementation(Dependencies.Kotlin.stdlib)
    implementation(Dependencies.Kotlin.coroutinesCore)
    implementation(Dependencies.Android.preference)
    implementation(Dependencies.Android.recyclerView)

    implementation(Dependencies.LibsTest.all)
}
