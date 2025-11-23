import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
    alias(libs.plugins.composeHotReload)
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_17)
        }
    }

    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }

    jvm()

    js(IR) {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
//            implementation(libs.ktor.client.okhttp)

            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences)
            implementation("com.github.AyanTech:AyanAds:1.1.13")
        }
        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.multiplatform.settings.no.arg)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

            implementation(libs.navigation.compose)
            implementation(libs.material.icons.core)
            implementation(libs.material3)

            implementation(libs.ktor.client.logging)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)

            implementation(libs.coil.compose)
            implementation(libs.coil.network.ktor)
            implementation(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)

            implementation(libs.voyager.navigator)
            implementation(libs.voyager.koin)
            implementation(libs.voyager.transitions)
        }
        jvmMain.dependencies {
            implementation("io.ktor:ktor-client-cio:3.3.1")
            implementation(compose.desktop.currentOs)
            implementation(libs.kotlinx.coroutinesSwing)
        }
        wasmJsMain.dependencies {
            implementation("io.ktor:ktor-client-js:3.3.1")
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
//            implementation("io.mockk:mockk-common:1.14.6")
        }
    }
}

android {
    namespace = "ir.ayantech.ayanhook"
    compileSdk = 36

    defaultConfig {
        applicationId = "ir.ayantech.ayanhook"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    flavorDimensions += "variant"

    val cafebazaar = "Cafebazaar"
    val myket = "Myket"
    val playstore = "Playstore"
    val packageNameIr = "ir.ayantech."
    val packageNameAe = "ae.ayanco."

    productFlavors {
        create("passport") {
            dimension = "variant"
            applicationId = "ir.ayantech.passport"
            versionCode = 11
            versionName = "1.1.1"
        }
        create("waterbillinquiry$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameIr}waterbillinquiry"
            versionCode = 11
            versionName = "1.1.1"
        }
        create("waterbillinquiry$myket") {
            dimension = "variant"
            applicationId = "${packageNameIr}waterbillinquiry"
            versionCode = 12
            versionName = "1.1.2"
        }

        create("waterbillinquiry$playstore") {
            dimension = "variant"
            applicationId = "${packageNameAe}waterbillinquiry"
            versionCode = 13
            versionName = "1.1.3"
        }

        create("gasbillinquiry$cafebazaar") {
            dimension = "variant"
            applicationId = "${packageNameIr}gasbillinquiry"
            versionCode = 11
            versionName = "1.1.1"
        }
        create("gasbillinquiry$myket") {
            dimension = "variant"
            applicationId = "${packageNameIr}gasbillinquiry"
            versionCode = 12
            versionName = "1.1.2"
        }
        create("gasbillinquiry$playstore") {
            dimension = "variant"
            applicationId = "${packageNameAe}gasbillinquiry"
            versionCode = 13
            versionName = "1.1.3"
        }

        applicationVariants.all {
            val flavorNames = productFlavors.joinToString("-") { it.name }
            outputs.all {
                (this as com.android.build.gradle.internal.api.BaseVariantOutputImpl).outputFileName =
                    "Hook-${flavorNames}-${versionName}-${versionCode}.apk"
            }
        }
    }

    sourceSets {
        getByName("waterbillinquiry$cafebazaar") {
            res.srcDirs("src\\androidMain\\waterbillinquiry\\res")
        }
        getByName("waterbillinquiry$myket") {
            res.srcDirs("src\\androidMain\\waterbillinquiry\\res")
        }
        getByName("waterbillinquiry$playstore") {
            res.srcDirs("src\\androidMain\\waterbillinquiry\\res")
        }
        getByName("gasbillinquiry$cafebazaar") {
            res.srcDirs("src\\androidMain\\gasbillinquiry\\res")
        }
        getByName("gasbillinquiry$myket") {
            res.srcDirs("src\\androidMain\\gasbillinquiry\\res")
        }
        getByName("gasbillinquiry$playstore") {
            res.srcDirs("src\\androidMain\\gasbillinquiry\\res")
        }
        getByName("passport") {
            res.srcDirs("src\\androidMain\\gasbillinquiry\\res")
        }
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

compose.desktop {
    application {
        mainClass = "ir.ayantech.ayanhook.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "ir.ayantech.ayanhook"
            packageVersion = "1.0.0"
        }
    }
}
