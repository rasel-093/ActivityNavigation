package com.example.activitynavigation

interface Destinations{
    val route:String
}
object Home:Destinations{
    override val route = "Home"
}
object MenuList:Destinations{
    override val route = "MenuList"
}