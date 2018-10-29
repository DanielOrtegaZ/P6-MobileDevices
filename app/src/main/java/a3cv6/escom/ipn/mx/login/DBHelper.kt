package a3cv6.escom.ipn.mx.login

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import android.widget.Toast

class DBHelper(context:Context) : SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION){

    private val SQL_CREATE_ENTRIES =
            "CREATE TABLE ${DBContract.User.TABLE_NAME} (" +
                    "${DBContract.User.COLUMN_USER} TEXT PRIMARY KEY," +
                    "${DBContract.User.COLUMN_TOKEN} TEXT," +
                    "${DBContract.User.COLUMN_NAME} TEXT)"
    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${DBContract.User.TABLE_NAME}"

    override fun onCreate(db: SQLiteDatabase){
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        super.onDowngrade(db, oldVersion, newVersion)
    }

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "Login.db"
    }

}
