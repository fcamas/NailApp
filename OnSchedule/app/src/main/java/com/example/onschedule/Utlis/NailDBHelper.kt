package com.example.onschedule.Utlis

class NailDBHelper {
    fun insertTask(nailModel: NailModel) {
        db = writableDatabase
        val values = ContentValues()
        values.put(COL_2, nailModel.fullName)
        values.put(COL_3, nailModel.email)
        values.put(COL_4, nailModel.phone)
        values.put(COL_5, nailModel.time)
        values.put(COL_6, nailModel.service)
        values.put(COL_7, nailModel.task)
        values.put(COL_8, 0)
        db.insert(TABLE_NAME, null, values)
    }

    fun updateStatus(id: Int, status: Int) {
        db = writableDatabase
        val values = ContentValues()
        values.put(COL_8, status)
        db.update(TABLE_NAME, values, "ID=?", arrayOf(id.toString()))
    }
}