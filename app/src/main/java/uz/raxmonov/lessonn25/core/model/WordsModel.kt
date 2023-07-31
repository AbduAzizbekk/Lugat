package uz.raxmonov.lessonn25.core.model

data class WordsModel(
    val _id: Int,
    val word: String,
    val translate: String,
    val favourite: Int,
    val lastUsed: Int
)
