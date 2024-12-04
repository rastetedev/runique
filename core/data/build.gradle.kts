plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.raulastete.core.data"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.core.database)

    implementation(libs.timber)
}