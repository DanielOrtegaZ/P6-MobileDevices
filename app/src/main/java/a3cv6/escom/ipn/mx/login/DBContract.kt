package a3cv6.escom.ipn.mx.login

import android.provider.BaseColumns

class DBContract{

    // Un objeto por tabla
    object User : BaseColumns{
        const val TABLE_NAME = "User"
        const val COLUMN_NAME = "Name"
        const val COLUMN_TOKEN = "Token"
        const val COLUMN_USER = "User"
    }
}