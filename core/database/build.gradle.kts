plugins {
    alias(libs.plugins.runique.android.library)
    alias(libs.plugins.runique.android.room)
}

android {
    namespace = "com.raulastete.core.database"
}

dependencies {
    implementation(projects.core.domain)

    implementation(libs.org.mongodb.bson)
}