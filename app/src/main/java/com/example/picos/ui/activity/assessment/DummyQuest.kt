package com.example.picos.ui.activity.assessment

object DummyQuest {

    fun getDummyQuestions() : ArrayList<DummyQuestions> {

        val questionList = ArrayList<DummyQuestions>()

        val q1 = DummyQuestions( 1, "How r u today?",
            "I'm fine",
            "Not bad",
            "Pretty good",
        "I feel terrible")

        val q2 = DummyQuestions( 2, "Lorem ipsum question",
            "Random",
            "Good",
            "Wonderful",
            "Awesome")

        val q3 = DummyQuestions( 3, "This is a dummy",
            "Dumm",
            "Dummy",
            "Dummy Quest",
            "Dummy Question")

        val q4 = DummyQuestions( 4, "When i was just a little girl",
            "I ask my mother",
            "what",
            "will",
            "I be?")


        questionList.add(q1)
        questionList.add(q2)
        questionList.add(q3)
        questionList.add(q4)


        return questionList
    }
}