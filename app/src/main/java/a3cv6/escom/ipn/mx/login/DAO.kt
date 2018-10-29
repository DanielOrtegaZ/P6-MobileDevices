package a3cv6.escom.ipn.mx.login

import android.content.ContentValues
import android.content.Context
import android.util.Log

class DAO{

    fun insertUser(context:Context,user:User):Boolean{
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put(DBContract.User.COLUMN_NAME, user.name)
            put(DBContract.User.COLUMN_TOKEN, user.token)
            put(DBContract.User.COLUMN_USER, user.user)
        }

        val result = db?.insert(DBContract.User.TABLE_NAME, null, values)

        return !(result == -1L)
    }

    fun selectUser(context:Context,user:User):Boolean {
        val dbHelper = DBHelper(context)
        val db = dbHelper.readableDatabase

        val projection = arrayOf(DBContract.User.COLUMN_USER, DBContract.User.COLUMN_TOKEN, DBContract.User.COLUMN_NAME)
        val selection = " ${DBContract.User.COLUMN_USER} = ? AND ${DBContract.User.COLUMN_TOKEN} = ?"
        val selectionArgs = arrayOf(user.user, user.token)
        //val sortOrder = "${DBContract.User.COLUMN_USER} ASC"

        val cursor = db.query(
                DBContract.User.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        )

        with(cursor){
            if(moveToNext()){
                user.user = getString(getColumnIndex(DBContract.User.COLUMN_USER))
                user.token = getString(getColumnIndex(DBContract.User.COLUMN_TOKEN))
                user.name = getString(getColumnIndex(DBContract.User.COLUMN_NAME))
                return true
            }
        }
        return false
    }
}