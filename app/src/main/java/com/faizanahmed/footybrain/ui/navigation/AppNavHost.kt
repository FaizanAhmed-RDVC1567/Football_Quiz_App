package com.faizanahmed.footybrain.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.lifecycle.viewmodel.compose.viewModel
import com.faizanahmed.footybrain.ui.screens.CategoryScreen
import com.faizanahmed.footybrain.ui.screens.QuizScreen
import com.faizanahmed.footybrain.ui.screens.ResultScreen
import com.faizanahmed.footybrain.viewmodel.QuizViewModel

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController(),
    quizViewModel: QuizViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = Routes.CATEGORY) {

        composable(Routes.CATEGORY) {
            CategoryScreen { selectedCategory ->
                quizViewModel.startQuiz(selectedCategory)
                navController.navigate("quiz/$selectedCategory")
            }
        }

        composable(
            route = Routes.QUIZ,
            arguments = listOf(navArgument("category") { type = NavType.StringType })
        ) { backStackEntry ->
            val category = backStackEntry.arguments?.getString("category") ?: ""
            QuizScreen(category = category, viewModel = quizViewModel) { score ->
                navController.navigate("result/$score") {
                    popUpTo(Routes.CATEGORY) { inclusive = false }
                }
            }
        }

        composable(
            route = Routes.RESULT,
            arguments = listOf(navArgument("score") { type = NavType.IntType })
        ) { backStackEntry ->
            val score = backStackEntry.arguments?.getInt("score") ?: 0
            ResultScreen(score = score) {
                navController.popBackStack(Routes.CATEGORY, inclusive = false)
            }
        }
    }
}
