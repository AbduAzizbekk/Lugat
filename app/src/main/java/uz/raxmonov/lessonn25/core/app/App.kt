package uz.raxmonov.lessonn25.core.app

import android.app.Application
import uz.raxmonov.lessonn25.core.db.WordsDb

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        WordsDb.init(this)
    }
}