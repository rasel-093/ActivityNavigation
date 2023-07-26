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
object DashBoard:Destinations{
    override val route: String = "Home"
}
object Details:Destinations{
    override val route: String = "Details"
}