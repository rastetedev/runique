package com.raulastete.auth.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.raulastete.auth.presentation.R
import com.raulastete.core.presentation.designsystem.EmailIcon
import com.raulastete.core.presentation.designsystem.Poppins
import com.raulastete.core.presentation.designsystem.RuniqueTheme
import com.raulastete.core.presentation.designsystem.components.GradientBackground
import com.raulastete.core.presentation.designsystem.components.RuniqueActionButton
import com.raulastete.core.presentation.designsystem.components.textfields.RuniquePasswordTextField
import com.raulastete.core.presentation.designsystem.components.textfields.RuniqueTextField
import com.raulastete.core.presentation.ui.ObserveAsEvents
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = koinViewModel(),
    onLoginSuccess: () -> Unit,
    onSignUpClick: () -> Unit,
) {
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current

    ObserveAsEvents(viewModel.events) { event ->
        when(event) {
            is LoginEvent.Error -> {
                keyboardController?.hide()
                Toast.makeText(
                    context,
                    event.error.asString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
            LoginEvent.LoginSuccess -> {
                keyboardController?.hide()
                Toast.makeText(
                    context,
                    R.string.youre_logged_in,
                    Toast.LENGTH_LONG
                ).show()
                onLoginSuccess()
            }
        }
    }
    LoginContent(
        state = viewModel.state,
        onAction = { action ->
            when(action) {
                is LoginAction.OnRegisterClick -> onSignUpClick()
                else -> viewModel.onAction(action)
            }
        }
    )
}
@Composable
private fun LoginContent(
    state: LoginState,
    onAction: (LoginAction) -> Unit
) {
    GradientBackground {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.hi_there),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(id = R.string.runique_welcome_text),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(modifier = Modifier.height(48.dp))
            RuniqueTextField(
                state = state.email,
                startIcon = EmailIcon,
                endIcon = null,
                hint = stringResource(id = R.string.example_email),
                title = stringResource(id = R.string.email),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            RuniquePasswordTextField(
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onAction(LoginAction.OnTogglePasswordVisibility)
                },
                hint = stringResource(id = R.string.password),
                title = stringResource(id = R.string.password),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))
            RuniqueActionButton(
                text = stringResource(id = R.string.login),
                isLoading = state.isLoggingIn,
                enabled = state.canLogin && !state.isLoggingIn,
                onClick = {
                    onAction(LoginAction.OnLoginClick)
                },
            )
            val annotatedString = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontFamily = Poppins,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                ) {
                    append(stringResource(id = R.string.dont_have_an_account) + " ")
                    withLink(
                        link = LinkAnnotation.Clickable(
                            tag = "clickable_register_text",
                            styles = TextLinkStyles(
                                style = SpanStyle(
                                    fontWeight = FontWeight.SemiBold,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontFamily = Poppins
                                )
                            ),
                            linkInteractionListener = { onAction(LoginAction.OnRegisterClick) }
                        )
                    ){
                        append(stringResource(id = R.string.sign_up))
                    }
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .weight(1f),
                contentAlignment = Alignment.TopCenter
            ) {
                BasicText(
                    text = annotatedString,
                )
            }
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    RuniqueTheme {
        LoginContent(
            state = LoginState(),
            onAction = {}
        )
    }
}