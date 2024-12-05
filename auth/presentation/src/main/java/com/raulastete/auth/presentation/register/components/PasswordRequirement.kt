package com.raulastete.auth.presentation.register.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulastete.core.presentation.designsystem.CheckIcon
import com.raulastete.core.presentation.designsystem.CrossIcon
import com.raulastete.core.presentation.designsystem.RuniqueDarkRed
import com.raulastete.core.presentation.designsystem.RuniqueGreen
import com.raulastete.core.presentation.designsystem.RuniqueTheme

@Composable
fun PasswordRequirement(
    text: String,
    isValid: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = if (isValid) {
                CheckIcon
            } else {
                CrossIcon
            },
            contentDescription = null,
            tint = if (isValid) RuniqueGreen else RuniqueDarkRed
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun PasswordRequirementPreview() {
    RuniqueTheme {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            PasswordRequirement(text = "Min 8 password length", isValid = true)
            PasswordRequirement(text = "Min 8 password length", isValid = false)
        }
    }
}