package uz.raxmonov.lessonn25.core.model

data class WordsModel(
    val _id: Int,
    val english: String,
    val type: Int,
    val transcript: String,
    val uzbek: String,
    val isFav: Int,
    val isHistory: Int
)
