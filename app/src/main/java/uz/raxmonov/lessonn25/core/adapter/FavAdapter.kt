package uz.raxmonov.lessonn25.core.adapter

import android.content.Context
import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CursorAdapter
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import net.cachapa.expandablelayout.ExpandableLayout
import uz.raxmonov.lessonn25.R
import uz.raxmonov.lessonn25.core.db.WordsDb
import uz.raxmonov.lessonn25.core.model.WordsModel

class FavAdapter(context: Context, cursor: Cursor) : CursorAdapter(context, cursor, false) {

    var co = 1
    override fun newView(context: Context, cursor: Cursor?, parent: ViewGroup?): View {


        return LayoutInflater.from(context).inflate(R.layout.fav_items, parent, false)


    }

    override fun bindView(view: View, context: Context, cursor: Cursor) {
        val textView: TextView = view.findViewById(R.id.words_list_fav)
        val translateView: TextView = view.findViewById(R.id.word_translation_fav)
        val favouriteView: ImageButton = view.findViewById(R.id.fav_fav)
        val wordModel = getWordData(cursor)

        textView.text = wordModel.uzbek
        translateView.text = wordModel.english

        favouriteView.setOnClickListener {
            co++
            if (co % 2 == 0) {
                favouriteView.isGone
            } else {
                favouriteView.isVisible
            }
            WordsDb.getInstance()!!.setIsFav(cursor)
        }
        val layout = view.findViewById<ExpandableLayout>(R.id.expandable_layout)
        view.setOnClickListener {

            layout.toggle(true)
        }
    }

    private fun getWordData(cursor: Cursor): WordsModel {

        return WordsModel(
            _id = cursor.getInt(0),
            english = cursor.getString(1),
            type = cursor.getInt(2),
            transcript = cursor.getString(3),
            uzbek = cursor.getString(4),
            isFav = cursor.getInt(5),
            isHistory = cursor.getInt(6)
        )
    }
}