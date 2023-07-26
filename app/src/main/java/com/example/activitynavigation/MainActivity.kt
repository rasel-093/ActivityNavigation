package com.example.activitynavigation

import android.os.Bundle
import android.view.MenuInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import java.lang.reflect.Type

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNavigation()
        }
    }
}

@Composable
fun MyNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = DashBoard.route ){
        composable(Home.route){
            HomeScreen(navController)
        }
        composable(
            MenuList.route + "/{${MenuList.argOrderNo}}",
            arguments = listOf(
                navArgument(MenuList.argOrderNo){ type = NavType.IntType}
            )
        ){
            MenuListScreen(it.arguments?.getInt(MenuList.argOrderNo))
        }
        composable(DashBoard.route){
            DashBoardScreen(navController)
        }
        composable(Details.route){
            DetailsScreen()
        }
    }
}
