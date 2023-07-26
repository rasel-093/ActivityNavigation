package com.example.activitynavigation

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