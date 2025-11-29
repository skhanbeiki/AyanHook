package ir.ayantech.ayanhook
import kotlinx.serialization.Serializable

@Serializable
data class ProjectConfig(
    val name: String,
    val applicationName: String,
    val applicationNameForPishkhan: String,
    val host: String,
    val schema: String,

    val baseUrl: String,
    val servicesBaseUrl: String,
    val versionControllingBaseUrl: String,
    val pushNotificationUrl: String
)
