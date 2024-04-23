package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.model.Event

class DataSource {
    fun loadEvent(): List<Event> {
        return listOf<Event>(
            Event(R.string.conf, R.drawable.conf,R.string.dateConf),
            Event(R.string.minipr, R.drawable.projet2,R.string.dateMinipr),
            Event(R.string.algo, R.drawable.algo1,R.string.dateAlgo),
            Event(R.string.jardinage, R.drawable.jardin,R.string.dateJard),
            Event(R.string.sport, R.drawable.sport,R.string.dateSport),
            Event(R.string.recep, R.drawable.recep,R.string.dateRecep)
        )
    }
}