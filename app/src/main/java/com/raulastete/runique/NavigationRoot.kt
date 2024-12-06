package com.raulastete.runique

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.raulastete.auth.presentation.intro.IntroScreen
import com.raulastete.auth.presentation.register.RegisterScreen

@Composable
fun NavigationRoot(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = Graph.Auth
    ) {
        authGraph(navController = navHostController)

    }
}

private fun NavGraphBuilder.authGraph(navController: NavHostController) {

    navigation<Graph.Auth>(startDestination = Destination.Intro) {

        composable<Destination.Intro> {
            IntroScreen(
                onNavigateToSignIn = {

                },
                onNavigateToSignUp = {
                    navController.navigate(Destination.Register)
                }
            )
        }

        composable<Destination.Register> {
            RegisterScreen(
                onSignInClick = {
                    navController.navigate("") {
                        popUpTo(Destination.Register) {
                            inclusive = true
                            saveState = true
                        }
                        restoreState = true
                    }
                },
                onSuccessfulRegistration = {

                }
            )
        }
    }

}