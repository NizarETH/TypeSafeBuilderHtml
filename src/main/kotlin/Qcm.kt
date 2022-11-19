package html


import html.QCMBean.Companion.qcm

data class QCMBean(var qcmId : Int=-1, var question : String = "", var answers : ArrayList<AnswerBean> = ArrayList()) {

    companion object {
        fun qcm(init:QCMBean.()->Unit) = QCMBean().apply {
            init()
        }
    }
    fun answer(answer:String = "") = AnswerBean(answer).apply {
        answers.add(this)
    }
}
data class AnswerBean(var answer:String = "")
fun main() {


    val result =  qcm {
        qcmId = 1
        question = "How many cat ?"
        answer("1")
        answer("2")
    }
    println(result)
}