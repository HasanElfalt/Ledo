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
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 2", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 3", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 4", "Building an integral support system, " +
                        "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas")
        )

        lessons.add(
            Lesson("Support Systems", "Lesson 5", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas")
        )

        lessonsList.postValue(lessons)

        return lessonsList
    }
}