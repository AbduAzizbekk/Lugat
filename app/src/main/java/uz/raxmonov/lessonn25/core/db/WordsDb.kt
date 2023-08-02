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
        val query = "SELECT * FROM translate ORDER BY eng_word ASC"
        return mDataBase.rawQuery(query, arrayOf())
    }

    fun getUzbEng(): Cursor {
        val query = "SELECT * FROM translate ORDER BY uzb_word ASC"
        return mDataBase.rawQuery(query, arrayOf())
    }

    fun getFav(): Cursor {
        val query = "SELECT * FROM translate WHERE favourite=1"
        return mDataBase.rawQuery(query, arrayOf())
    }

    //INSERT INTO translate (favourite) VALUES ("1")
    fun getStory(): Cursor {
        val query = "SELECT * FROM translate WHERE last_used"
        return mDataBase.rawQuery(query, arrayOf())
    }
}