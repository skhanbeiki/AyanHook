package ir.ayantech.ayanhook.presentation.base

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import ir.ayantech.ayanhook.platform.ConfigProject
import ir.ayantech.ayanhook.platform.model.ConfigData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel(
    private val configProject: ConfigProject
) : ScreenModel {

    private val _config = MutableStateFlow(ConfigData())
    val config: StateFlow<ConfigData> = _config.asStateFlow()

    init {
        screenModelScope.launch {
            _config.value = configProject.getConfigProject()
        }
    }
}