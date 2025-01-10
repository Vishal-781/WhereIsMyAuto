package com.example.whereismyauto.home

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.example.whereismyauto.home.model.AutoLine
import com.example.whereismyauto.home.model.AutoStation
import com.example.whereismyauto.ui.theme.Yellow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _autoLines = MutableStateFlow<List<AutoLine>>(createAutoLines())
    val autoLines = _autoLines.asStateFlow()
    private fun createAutoLines(): List<AutoLine> {
        // First define all shared stations with single position
        val sharedStations = mapOf(
            "MG" to AutoStation("MG", "Main Gate", Offset(350f, 100f), true, listOf(1, 2, 3, 4)),
            "UGC" to AutoStation("UGC", "UGC Colony", Offset(250f, 200f), true, listOf(1, 2)),
            "HC" to AutoStation("HC", "Health Center", Offset(250f, 300f), true, listOf(1, 2)),
            "I2H" to AutoStation("I2H", "i2H/iRH", Offset(250f, 600f), true, listOf(1, 2)),
            "RDC" to AutoStation("RDC", "RD Chowk", Offset(350f, 900f), true, listOf(1, 3)),
            "AH" to AutoStation("AH", "Aquamarine Hostel", Offset(350f, 1200f), true, listOf(1, 3)),
            "DTB" to AutoStation("DTB", "DT Bunglow", Offset(500f, 300f), true, listOf(3, 4)),
            "PHS" to AutoStation("PHS", "Petrolium/HSS", Offset(500f, 600f), true, listOf(3, 4)),
            "SAC" to AutoStation("SAC", "SAC", Offset(350f, 1050f),false, listOf(2,3))
        )
        val allStations = mapOf(
            "MG" to AutoStation("MG", "Main Gate", Offset(350f, 100f), true, listOf(1, 2, 3, 4)),
            "UGC" to AutoStation("UGC", "UGC Colony", Offset(250f, 200f), true, listOf(1, 2)),
            "HC" to AutoStation("HC", "Health Center", Offset(250f, 300f), true, listOf(1, 2)),
            "I2H" to AutoStation("I2H", "i2H/iRH", Offset(250f, 600f), true, listOf(1, 2)),
            "RDC" to AutoStation("RDC", "RD Chowk", Offset(250f, 900f), true, listOf(1, 3)),
            "AH" to AutoStation("AH", "Aquamarine Hostel", Offset(250f, 1200f), true, listOf(1, 3)),
            "DTB" to AutoStation("DTB", "DT Bunglow", Offset(500f, 300f), true, listOf(3, 4)),
            "PHS" to AutoStation("PHS", "Petrolium/HSS", Offset(500f, 600f), true, listOf(3, 4)),
            "SAC" to AutoStation("SAC", "SAC", Offset(350f, 1050f),false, listOf(2,3)),
            "CW" to AutoStation("CW", "Central Workshop", Offset(350f, 700f),false, listOf(1)),
            "NLHC" to AutoStation("NLHC", "NLHC", Offset(350f, 850f),false, listOf(1)),
            "Q180" to AutoStation("Q180", "180 Quarters", Offset(370f, 320f),false, listOf(2)),
            "SC" to AutoStation("SC", "Staff Colony", Offset(370f, 400f),false, listOf(2)),
            "SCUB" to AutoStation("SCUB", "Staff Club", Offset(370f, 500f),false, listOf(2)),
            "AC" to AutoStation("AC", "Academic Complex", Offset(100f, 200f),false, listOf(2)),
            "RR" to AutoStation("RR", "Ring Road", Offset(500f, 400f),false, listOf(3)),
            "LIB" to AutoStation("LIB", "Library", Offset(500f, 750f),false, listOf(3)),
            "ROS" to AutoStation("ROS", "Rosaline", Offset(650f, 400f),false, listOf(4)),
            "TC" to AutoStation("TC", "Teachers Colony", Offset(650f, 450f),false, listOf(4)),
            "IH" to AutoStation("IH", "International Hostel", Offset(650f, 500f),false, listOf(4)),
            "JHM" to AutoStation("JHM", "Jal/Hawa Mahal", Offset(650f, 550f),false, listOf(4)),
            "OL" to AutoStation("OL", "Old Library", Offset(800f, 700f),false, listOf(4)),
            "AB" to AutoStation("AB", "Admin Block", Offset(800f, 500f),false, listOf(4)),
            "LG" to AutoStation("LG", "Lower Ground", Offset(800f, 400f),false, listOf(4)),
            "SAH" to AutoStation("SAH", "SAH/EDC", Offset(800f, 200f),false, listOf(4))


        ).toMutableMap<String, AutoStation>()

        return listOf(
            AutoLine(
                id = 1,
                name = "Blue Line",
                color = Color.Blue,
                stations = listOf(
                    sharedStations["MG"]!!,
                    sharedStations["UGC"]!!,
                    sharedStations["HC"]!!,
                    sharedStations["I2H"]!!,
//                    MetroStation("CW", "Central Workshop", Offset(350f, 700f)),
                    allStations["CW"]!!,
//                    MetroStation("NLHC", "NLHC", Offset(350f, 850f)),
                    allStations["NLHC"]!!,
                    sharedStations["RDC"]!!,
                    sharedStations["SAC"]!!,
                    sharedStations["AH"]!!
                ),
                path = listOf(
                    sharedStations["MG"]!!.position,
                    sharedStations["UGC"]!!.position,
                    sharedStations["HC"]!!.position,
                    sharedStations["I2H"]!!.position,
//                    Offset(350f, 700f),
                    allStations["CW"]!!.position,
//                    Offset(350f, 850f),
                    allStations["NLHC"]!!.position,
                    sharedStations["RDC"]!!.position,
                    sharedStations["SAC"]!!.position,
                    sharedStations["AH"]!!.position
                )
            ),
            AutoLine(
                id = 2,
                name = "Red Line",
                color = Color.Red,
                stations = listOf(
                    sharedStations["MG"]!!,
                    sharedStations["UGC"]!!,
                    sharedStations["HC"]!!,
//                    MetroStation("Q180", "180 Quarters", Offset(250f, 400f)),
//                    MetroStation("SC", "Staff Colony", Offset(250f, 500f)),
//                    MetroStation("SCUB", "Staff Club", Offset(250f, 600f)),

                    allStations["Q180"]!!,
                    allStations["SC"]!!,
                    allStations["SCUB"]!!,
                    sharedStations["I2H"]!!,
//                    MetroStation("AC", "Academic Complex", Offset(200f, 800f))
                    allStations["AC"]!!,
                    sharedStations["MG"]!!
                ),
                path = listOf(
                    sharedStations["MG"]!!.position,
                    sharedStations["UGC"]!!.position,
                    sharedStations["HC"]!!.position,
//                    Offset(250f, 400f),
//                    Offset(250f, 500f),
//                    Offset(250f, 600f),

                    allStations["Q180"]!!.position,
                    allStations["SC"]!!.position,
                    allStations["SCUB"]!!.position,
                    sharedStations["I2H"]!!.position,
//                    Offset(200f, 800f)
                    allStations["AC"]!!.position,
                    sharedStations["MG"]!!.position
                )
            ),
            AutoLine(
                id = 3,
                name = "Green Line",
                color = Color.Green,
                stations = listOf(
                    sharedStations["MG"]!!,
                    sharedStations["DTB"]!!,
                    AutoStation("RR", "Ring Road", Offset(500f, 400f)),
                    sharedStations["PHS"]!!,
                    AutoStation("LIB", "Library", Offset(500f, 750f)),
                    sharedStations["RDC"]!!,
                    sharedStations["SAC"]!!,
                    sharedStations["AH"]!!
                ),
                path = listOf(
                    sharedStations["MG"]!!.position,
                    sharedStations["DTB"]!!.position,
                    Offset(500f, 500f),
                    sharedStations["PHS"]!!.position,
                    Offset(500f, 750f),
                    sharedStations["RDC"]!!.position,
                    sharedStations["SAC"]!!.position,
                    sharedStations["AH"]!!.position
                )
            ),
            AutoLine(
                id = 4,
                name = "Yellow Line",
                color = Yellow,
                stations = listOf(
                    sharedStations["MG"]!!,
                    sharedStations["DTB"]!!,
//                    MetroStation("ROS", "Rosaline", Offset(600f, 400f)),
                    allStations["ROS"]!!,
//                    MetroStation("TC", "Teachers Colony", Offset(600f, 450f)),
//
//                    MetroStation("IH", "International Hostel", Offset(600f, 500f)),
//                    MetroStation("JHM", "Jal/Hawa Mahal", Offset(600f, 550f)),
                    allStations["TC"]!!,
                    allStations["IH"]!!,
                    allStations["JHM"]!!,
                    sharedStations["PHS"]!!,
//                    MetroStation("OL", "Old Library", Offset(800f, 700f)),
//                    MetroStation("AB", "Admin Block", Offset(800f, 500f)),
//                    MetroStation("LG", "Lower Ground", Offset(800f, 400f)),
//                    MetroStation("SAH", "SAH/EDC", Offset(800f, 200f)),
                    allStations["OL"]!!,
                    allStations["AB"]!!,
                    allStations["LG"]!!,
                    allStations["SAH"]!!,
                    sharedStations["MG"]!!

                ),
                path = listOf(
                    sharedStations["MG"]!!.position,
                    sharedStations["DTB"]!!.position,
                    allStations["ROS"]!!.position,
                    allStations["TC"]!!.position,
                    allStations["IH"]!!.position,
                    allStations["JHM"]!!.position,
                    sharedStations["PHS"]!!.position,
                    sharedStations["PHS"]!!.position,
//                    Offset(800f, 700f),
//                    Offset(800f, 500f),
//                    Offset(800f, 400f),
//                    Offset(800f, 200f),
                    allStations["OL"]!!.position,
                    allStations["AB"]!!.position,
                    allStations["LG"]!!.position,
                    allStations["SAH"]!!.position,
                    sharedStations["MG"]!!.position

                )
            )
        )
    }
}