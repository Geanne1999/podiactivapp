package br.uea.transirie.mypay.mycoffee.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import br.uea.transirie.mypay.mycoffee.model.Question
import com.example.podiactivapp.R
import kotlinx.android.synthetic.main.item_question_frequent.view.*

class ResearchQuestionsAdapter(
    private val context: Context,
    private val listQuestions: MutableList<Question>
): BaseAdapter(){
    companion object {
        data class ViewHolder(val view: View) {
            val txtQuestion = view.txtQuestion
            val txtReponse= view.txtReponse
        }
    }
    fun swapData(novaListaPerguntas: List<Question>){
        listQuestions.clear()
        listQuestions.addAll(novaListaPerguntas)
        notifyDataSetChanged()
    }

    override fun getCount(): Int = listQuestions.size

    override fun getItem(position: Int): Any = listQuestions[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val packQuestionAnswer= listQuestions[position]
        val holder: ViewHolder
        val row: View
        if (convertView == null) {
            row = LayoutInflater.from(context).inflate(R.layout.item_question_frequent, parent, false)
            holder = ViewHolder(row)
            row.tag = holder
        } else {
            row = convertView
            holder = convertView.tag as ViewHolder
        }
        holder.txtQuestion.text=packQuestionAnswer.question
        holder.txtReponse.text=packQuestionAnswer.answer
        return row
    }
}