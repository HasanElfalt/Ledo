package com.elfalt.ledo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfalt.ledo.pojo.Lesson

class LessonViewModel : ViewModel() {

    private val lessonsList : MutableLiveData<List<Lesson>> by lazy { MutableLiveData<List<Lesson>>() }
    var lessonOne   = true
    var lessonTwo   = false
    var lessonThree = false
    var lessonFour  = false


    fun getLessonData() : LiveData<List<Lesson>>{

        val lessons : MutableList<Lesson> = mutableListOf()

        lessons.add(
            Lesson("Support Systems", "Lesson 1", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "9YlRIvdokMg",
            lessonOne)
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 2", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "tGdsOXZpyWE",
            lessonTwo)
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 3", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "Q7gBf8WE3i8",
            lessonThree)
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 4", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "R9qVa4LoJx8",
            lessonFour)
        )

        lessonsList.postValue(lessons)

        return lessonsList
    }
}