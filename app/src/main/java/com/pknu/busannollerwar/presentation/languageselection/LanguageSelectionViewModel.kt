package com.pknu.busannollerwar.presentation.languageselection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pknu.busannollerwar.presentation.languageselection.LanguageSelectionEvent.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class LanguageSelectionViewModel @Inject constructor() : ViewModel() {

    private val _eventFlow: MutableSharedFlow<LanguageSelectionEvent> =
        MutableSharedFlow<LanguageSelectionEvent>()
    val eventFlow get() = _eventFlow.asSharedFlow()

    fun setLanguage(language: Language){
        event(SetLanguage(language))
        navigateToHome()
    }

    private fun navigateToHome() = event(NavigateToHome)

    private fun event(event: LanguageSelectionEvent) =
        viewModelScope.launch { _eventFlow.emit(event) }
}