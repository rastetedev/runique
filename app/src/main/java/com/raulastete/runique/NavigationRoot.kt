package com.raulastete.runique

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.raulastete.auth.presentation.intro.IntroScreen
import com.raulastete.auth.presentation.login.LoginScreen
import com.raulastete.auth.presentation.register.RegisterScreen
import com.raulastete.run.presentation.active_run.ActiveRunScreen
import com.raulastete.run.presentation.run_overview.RunOverviewScreen

@Composable
fun NavigationRoot(
    navHostController: NavHostController,
    isLoggedIn: Boolean
) {
    NavHost(
        navController = navHostController,
        startDestination = if (isLoggedIn) Graph.Run else Graph.Auth
    ) {
        authGraph(navController = navHostController)
        runGraph(navController = navHostController)
    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {
    navigation<Graph.Auth>(startDestination = Destination.Intro) {

        composable<Destination.Intro> {
            IntroScreen(
                onNavigateToSignIn = {
                    navController.navigate(Destination.Login)
                },
                onNavigateToSignUp = {
                    navController.navigate(Destination.Register)
                }
            )
        }

        composable<Destination.Register> {
            RegisterScreen(
                onNavigateToSignIn = {
                    navController.navigate(Destination.Login) {
                        popUpTo(Destination.Register) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {
                    navController.navigate(Destination.Login)
                }
            )
        }

        composable<Destination.Login> {
            LoginScreen(
                onLoginSuccess = {
                    navController.navigate(Graph.Run) {
                        popUpTo(Graph.Auth) {
                            inclusive = true
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(Destination.Register) {
                        popUpTo(Destination.Login) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                }
            )
        }
    }
}

private fun NavGraphBuilder.runGraph(navController: NavHostController) {
    navigation<Graph.Run>(
        startDestination = Destination.RunOverview,
    ) {
        composable<Destination.RunOverview> {
            RunOverviewScreen(
                onNavigateToStartRun = {
                    navController.navigate(Destination.ActiveRun)
                }
            )
        }

        composable<Destination.ActiveRun>(
            enterTransition = {
                slideIntoContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Left,
                    animationSpec = tween(durationMillis = 500)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Right,
                    animationSpec = tween(durationMillis = 500)
                )
            }
        ) {
            ActiveRunScreen(
                onNavigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}