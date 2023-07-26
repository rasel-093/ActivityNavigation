package com.example.activitynavigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

interface Destinations{
    val route:String
}
object Home:Destinations{
    override val route = "Home"
}
object MenuList:Destinations{
    //This line is written to pass arguments from one activity to another activity
    const val argOrderNo = "OrderNo"
    override val route = "MenuList"
}
object DashBoard:Destinations{
    override val route: String = "Home"
}
object Details:Destinations{
    override val route: String = "Details"
}
//This interface is for Bottom navigation
interface Destination{
    val route : String
    val icon : ImageVector
    val title : String
}
object HomeB : Destination{
    override val route = "HommeB"
    override val icon = Icons.Filled.Home
    override  val title = "Home"
}
object SettingB : Destination{
    override val route = "SettingB"
    override val icon = Icons.Filled.Settings
    override  val title = "Setting"
}