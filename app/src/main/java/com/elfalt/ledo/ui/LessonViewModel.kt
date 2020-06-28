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


    fun getLessonData(courseName : String) : LiveData<List<Lesson>>{

        lessonsList.postValue(
            when(courseName){
                "Self Awareness" -> getSelfLessons()
                "Mind Mapping"   -> getMindLessons()
                else         -> getPersonalLessons()
            }
        )

        return lessonsList
    }

    private fun getSelfLessons() : List<Lesson>{

        val lessons : MutableList<Lesson> = mutableListOf()

        lessons.add(
            Lesson("Support Systems", "Lesson 1", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "9YlRIvdokMg",
                lessonOne)
        )

        lessons.add(
            Lesson("Core Values", "Lesson 2", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "tGdsOXZpyWE",
                lessonTwo)
        )

        lessons.add(
            Lesson("Strength & Weakness", "Lesson 3", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "Q7gBf8WE3i8",
                lessonThree)
        )

        lessons.add(
            Lesson("Goal & Aspiration", "Lesson 4", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "uyQIx2p7Qe8",
                lessonFour)
        )

        return lessons
    }

    private fun getMindLessons() : List<Lesson>{

        val lessons : MutableList<Lesson> = mutableListOf()

        lessons.add(
            Lesson("Support Systems", "Lesson 1", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "xges9V4rLms",
                lessonOne)
        )

        lessons.add(
            Lesson("Core Values", "Lesson 2", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "5nTuScU70As",
                lessonTwo)
        )

        lessons.add(
            Lesson("Strength & Weakness", "Lesson 3", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "kCKZ75VDaSI",
                lessonThree)
        )

        lessons.add(
            Lesson("Goal & Aspiration", "Lesson 4", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "xCyjFipytRE",
                lessonFour)
        )

        return lessons
    }

    private fun getPersonalLessons() : List<Lesson>{

        val lessons : MutableList<Lesson> = mutableListOf()

        lessons.add(
            Lesson("Support Systems", "Lesson 1", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "9q-AlAG8a2Q",
                lessonOne)
        )

        lessons.add(
            Lesson("Core Values", "Lesson 2", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "s3B7OeEHGRo",
                lessonTwo)
        )

        lessons.add(
            Lesson("Strength & Weakness", "Lesson 3", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "HowKJbgc5wI",
                lessonThree)
        )

        lessons.add(
            Lesson("Goal & Aspiration", "Lesson 4", "Building an integral support system, " +
                    "Pushes you to grow, strech more, mainly asks why things wont work and bullet proofs ideas", "PYlaowox_fw",
                lessonFour)
        )

        return lessons
    }
}