package uz.raxmonov.lessonn25.core.db

import android.content.Context
import android.database.Cursor
import uz.raxmonov.lessonn25.core.lib.DbHelper

class WordsDb private constructor(context: Context) : DbHelper(context, "dictionary.db") {

    companion object {
        private var wordsDb: WordsDb? = null
        fun init(context: Context) {
            if (wordsDb == null) {
                wordsDb = WordsDb(context = context)

            }

        }

        fun getInstance(): WordsDb? = wordsDb
    }


    fun getEngUzb(): Cursor {
        val query = "SELECT * FROM dictionary ORDER BY uzbek ASC"
        return mDataBase.rawQuery(query, arrayOf())
    }

    fun getUzbEng(): Cursor {
        val query = "SELECT * FROM dictionary ORDER BY english ASC"
        return mDataBase.rawQuery(query, arrayOf())
    }

    fun getFav(): Cursor {
        val query = "SELECT * FROM dictionary WHERE isFav=1"
        return mDataBase.rawQuery(query, arrayOf())
    }

    //    fun setIsFav(cursor: Cursor): Cursor? {
//        val query = "UPDATE dictionary SET isFav=\"+998947201080\" WHERE name=$cursor"
//        return mDataBase.rawQuery(query, arrayOf())
//    }
//    //
    fun getStory(): Cursor {
        val query = "SELECT * FROM dictionary WHERE isHistory"
        return mDataBase.rawQuery(query, arrayOf())
    }
}