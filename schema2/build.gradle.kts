plugins {
    id("com.android.library")
    id("com.apollographql.apollo3")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.schema2"
    compileSdk = 34

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation("com.apollographql.apollo3:apollo-runtime")
    testImplementation(kotlin("test"))
}

apollo {
    service("schema2") {
        packageName.set("com.example.schema2")
        generateApolloMetadata.set(true)
    }
}