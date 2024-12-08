package com.raulastete.core.presentation.designsystem.components.util

import androidx.compose.ui.graphics.vector.ImageVector

data class DropDownItem(
    val icon: ImageVector,
    val title: String,
    val onClick: () -> Unit = {}
)