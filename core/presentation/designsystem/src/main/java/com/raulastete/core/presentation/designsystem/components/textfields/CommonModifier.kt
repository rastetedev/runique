package com.raulastete.core.presentation.designsystem.components.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RuniqueTextFieldModifier(isFocused: Boolean) = Modifier
    .clip(RoundedCornerShape(16.dp))
    .background(
        if (isFocused) {
            MaterialTheme.colorScheme.primary.copy(
                alpha = 0.05f
            )
        } else {
            MaterialTheme.colorScheme.surface
        }
    )
    .border(
        width = 1.dp,
        color = if (isFocused) {
            MaterialTheme.colorScheme.primary
        } else {
            Color.Transparent
        },
        shape = RoundedCornerShape(16.dp)
    )
    .padding(horizontal = 12.dp)