data class Question (
	val prompt: String,
	val options: List<String>,
	val correctIndex: Int,
	val imageRes: Int? = null
)
