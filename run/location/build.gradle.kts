plugins {
    alias(libs.plugins.runique.android.library)
}

android {
    namespace = "com.raulastete.run.location"
}

dependencies {
    implementation(projects.core.domain)
    implementation(projects.run.domain)

    implementation(libs.androidx.core.ktx)

    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.google.android.gms.play.services.location)

    implementation(libs.bundles.koin)
}