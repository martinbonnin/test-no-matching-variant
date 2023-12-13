plugins {
    id("com.android.library")
    id("com.apollographql.apollo3")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mylibrary"
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
    service("schema1") {
        packageName.set("com.example.schema1")
        srcDir("src/main/graphql/service1")
    }
    service("schema2") {
        packageName.set("com.example.schema2")
        srcDir("src/main/graphql/service2")
    }

    generateSourcesDuringGradleSync = false
}

dependencies {
    implementation(project(":schema1"))
    add("apolloSchema1Consumer", project(":schema1"))
    implementation(project(":schema2"))
    add("apolloSchema2Consumer", project(":schema2"))
}