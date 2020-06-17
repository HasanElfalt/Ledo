package com.elfalt.ledo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfalt.ledo.pojo.Lesson

class LessonViewModel : ViewModel() {

    private val lessonsList : MutableLiveData<List<Lesson>> by lazy { MutableLiveData<List<Lesson>>() }

    fun getLessonData() : LiveData<List<Lesson>>{

        val lessons : MutableList<Lesson> = mutableListOf()

        lessons.add(
            Lesson("Support Systems", "Lesson 1", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "9YlRIvdokMg")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 2", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "tGdsOXZpyWE")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 3", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "Q7gBf8WE3i8")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 4", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "R9qVa4LoJx8")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 5", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "uyQIx2p7Qe8")
        )

        lessonsList.postValue(lessons)

        return lessonsList
    }
}