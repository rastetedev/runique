package com.raulastete.run.presentation.run_overview

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.raulastete.core.presentation.designsystem.AnalyticsIcon
import com.raulastete.core.presentation.designsystem.LogoIcon
import com.raulastete.core.presentation.designsystem.LogoutIcon
import com.raulastete.core.presentation.designsystem.RunIcon
import com.raulastete.core.presentation.designsystem.RuniqueTheme
import com.raulastete.core.presentation.designsystem.components.RuniqueFloatingActionButton
import com.raulastete.core.presentation.designsystem.components.RuniqueScaffold
import com.raulastete.core.presentation.designsystem.components.RuniqueToolbar
import com.raulastete.core.presentation.designsystem.components.util.DropDownItem
import com.raulastete.run.presentation.R
import org.koin.androidx.compose.koinViewModel

@Composable
fun RunOverviewScreen(
    viewModel: RunOverviewViewModel = koinViewModel(),
    onNavigateToStartRun : () -> Unit
) {
    RunOverviewContent(
        onAction = {
            when (it) {
                RunOverviewAction.OnStartClick -> onNavigateToStartRun()
                else -> viewModel.onAction(it)
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RunOverviewContent(
    onAction: (RunOverviewAction) -> Unit
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(
        state = topAppBarState
    )
    RuniqueScaffold(
        topAppBar = {
            RuniqueToolbar(
                showBackButton = false,
                title = stringResource(id = R.string.runique),
                scrollBehavior = scrollBehavior,
                menuItems = listOf(
                    DropDownItem(
                        icon = AnalyticsIcon,
                        title = stringResource(id = R.string.analytics),
                        onClick = {
                            onAction(RunOverviewAction.OnAnalyticsClick)
                        }
                    ),
                    DropDownItem(
                        icon = LogoutIcon,
                        title = stringResource(id = R.string.logout),
                        onClick = {
                            onAction(RunOverviewAction.OnLogoutClick)
                        }
                    ),
                ),
                startContent = {
                    Icon(
                        imageVector = LogoIcon,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(30.dp)
                    )
                }
            )
        },
        floatingActionButton = {
            RuniqueFloatingActionButton(
                icon = RunIcon,
                onClick = {
                    onAction(RunOverviewAction.OnStartClick)
                }
            )
        },
        withGradient = true
    ) { padding ->
    }
}

@Preview
@Composable
private fun RunOverviewScreenPreview() {
    RuniqueTheme {
        RunOverviewContent(
            onAction = {}
        )
    }
}