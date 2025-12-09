package ir.ayantech.ayanhook.platform

import ir.ayantech.ayanhook.platform.model.ConfigData
import ir.ayantech.ayanhook.presentation.ui.theme.AppColors
import ir.ayantech.ayanhook.presentation.ui.theme.AppImages
import ir.ayantech.ayanhook.presentation.ui.theme.AppStrings
import ir.ayantech.ayanhook.presentation.ui.util.loadJsonFile
import kotlinx.serialization.json.Json


class ConfigProject {
    suspend fun getConfigProject(): ConfigData {
        val platform = getPlatform()
        BaseData.platform = platform.platform
        BaseData.marketName = platform.marketName
        BaseData.name = platform.name
        BaseData.applicationNameForPishkhan = platform.applicationNameForPishkhan
        BaseData.host = platform.host
        BaseData.schema = platform.schema
        BaseData.applicationName = platform.applicationName
        BaseData.baseUrl = platform.baseUrl
        BaseData.servicesBaseUrl = platform.servicesBaseUrl
        BaseData.versionControllingBaseUrl = platform.versionControllingBaseUrl
        BaseData.pushNotificationUrl = platform.pushNotificationUrl

        println("ogvqihqjegnow  "+platform.name)
        val config = Json.decodeFromString<ConfigData>(loadJsonFile(platform.name))
        AppColors.primary = config.colors.primary
        AppColors.background = config.colors.background
        AppColors.textPrimary = config.colors.textPrimary

        AppStrings.title = config.strings.title
        AppStrings.description = config.strings.description

        AppImages.logo(config.images.logo)

        println("ogvqihqjegnow  ConfigProject")
        return config
    }
}