import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-parcelize")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
}

val localDate: LocalDate = LocalDate.now()
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")
val date: String = localDate.format(formatter)

android {
    compileSdk = 34

    defaultConfig {
        applicationId = "com.crr"
        setProperty("archivesBaseName", "crr-1.0.0-$date") //renames app
        minSdk = 23
        targetSdk = 34
        versionCode = 10000
        versionName = "1.0.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        multiDexEnabled = true
        namespace = "com.crr"
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.8"
    }

    kotlin {
        jvmToolchain(17) // uses Java 17 for code compilation, bypasses system's java version/independent of it. Specifies JDK version
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17 // compiles with java 17 features
        targetCompatibility = JavaVersion.VERSION_17 // java 17 is the minimum java version that bytecode is compatible with
    }

    kotlinOptions {
        jvmTarget = "17" // applies to the Kotlin compiler to compile kotlin code. Uses java 17 features
    }
}

val retrofitVersion = "2.9.0"
val lottieVersion = "6.0.0"
val coreKtxVersion = "1.10.1"
val appCompatVersion = "1.7.0-alpha01"
val materialVersion = "1.8.0"
val navFragmentVersion = "2.3.4"
val constraintLayoutVersion = "2.1.3"
val jUnitVersion = "4.13"
val extJUnitVersion = "1.1.5"
val espressoVersion = "3.3.0"
val okhttpVersion = "4.12.0"
val recyclerViewVersion = "1.2.1"
val cardViewVersion = "1.0.0"
val glideVersion = "4.14.2"
val roomVersion = "2.6.1"
val browserVersion = "1.3.0"
val viewPagerVersion = "1.1.0"
val lifecycleExtVersion = "2.2.0"
val lifecycleVersion = "2.7.0"
val cryptoVersion = "1.1.0-alpha01"
val shimmerVersion = "0.5.0"
val composeVersion = "1.5.4"
val actComposeVersion = "1.6.0"
val navComposeVersion = "2.7.7"
val hiltVersion = "1.2.0"
val material3Version = "1.2.1"
val coilVersion = "1.5.2"
val ktCoilVersion = "2.2.2"
val accompanistVersion = "0.34.0"
val gmsVersion = "20.7.0"
val gmsPhoneVersion = "18.0.2"
val gmsLiteVersion = "22.4.0"
val jdkVersion = "1.9.22"
val gAccompanistVersion = "0.28.0"
val fragmentVersion = "1.5.6"
val watchVersion = "1.4.7"

dependencies {
    implementation("com.airbnb.android:lottie:$lottieVersion")
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("com.google.android.material:material:$materialVersion")
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    testImplementation("junit:junit:$jUnitVersion")
    androidTestImplementation("androidx.test.ext:junit:$extJUnitVersion")
    androidTestImplementation("androidx.test.espresso:espresso-core:$espressoVersion")
    implementation("androidx.browser:browser:$browserVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    implementation("androidx.compose.foundation:foundation:$composeVersion")
    implementation("androidx.compose.foundation:foundation-layout:$composeVersion")
    implementation("androidx.compose.material:material:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.ui:ui-graphics:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-test-manifest:$composeVersion")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$jdkVersion")

}