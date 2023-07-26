package com.example.activitynavigation

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.activitynavigation.HomeB.icon
import java.lang.reflect.Type

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //MyNavigation()
            MyApp()
        }
    }
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            MyBottomNavigation(navController = navController)
        }
    ) {
        Box(modifier = Modifier.padding(it) ){
            NavHost(navController = navController, startDestination = HomeB.route ){
                composable(HomeB.route){
                    HomeBScreen()
                }
                composable(SettingB.route){
                    SettingsScreen()
                }
            }
        }
    }
}
@Composable
fun MyBottomNavigation(navController: NavController){
    val destinationList = listOf<Destination>(
        HomeB,SettingB
    )
    val selectedIndex  = rememberSaveable {
        mutableStateOf(0)
    }
    BottomNavigation() {
        destinationList.forEachIndexed(){index, destination ->
            BottomNavigationItem(
                label = { Text(text = destination.title)},
                icon = { Icon(imageVector = destination.icon, contentDescription = destination.title )},
                selected = selectedIndex.value == index,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinationList[index].route){
                        popUpTo(HomeB.route)
                        launchSingleTop = true
                    }
                }
            )
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
