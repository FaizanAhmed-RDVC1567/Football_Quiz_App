@Composable
fun QuestionCard(question: Question, onOptionSelected: (Int) -> Unit) {
	Column(modifier = Modifier.padding(16)) {

		question.imageRes?.let {
			Image(
				painter = painterResource(id = it),
				contentDescription = null,
				modifier = Modifier.fillMaxWidth()
			)
		}

		Text(
			text = question.prompt,
			style = MaterialTheme.typography.headlineSmall,
			modifier = Modifier.padding(vertical = 16.dp
		)

		question.actions.forEachIndexed { index, option ->
			Button(
				onClick = { onOptionSelected(index) },
				modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
			) {
				text(option)
			}
		}
	}
}
