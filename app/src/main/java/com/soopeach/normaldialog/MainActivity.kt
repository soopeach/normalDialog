package com.soopeach.normaldialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            val builder = basicDialog()

            builder.show()

        }
    }

    fun basicDialog() : AlertDialog.Builder{

        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("다이얼로그 제목")
            .setMessage("다이얼로그 메시지\n1줄\n2줄\n3줄")
            .setCancelable(true)
            .setPositiveButton("확인", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "확인 버튼 클릭!", Toast.LENGTH_SHORT).show()
                }
            })
            .setNegativeButton("취소", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "취소 버튼 클릭!", Toast.LENGTH_SHORT).show()
                }
            })
            .setNeutralButton("뉴트럴", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "뉴트럴 버튼 클릭!", Toast.LENGTH_SHORT).show()
                }
            })
            .create()
        return builder
    }

    fun viewDialog() : AlertDialog.Builder{

        val dialogView = layoutInflater.inflate(R.layout.dialog_view, null)

        val passBtn = dialogView.findViewById<Button>(R.id.checkBtn)
        passBtn.setOnClickListener {
            Toast.makeText(this,"${dialogView.findViewById<EditText>(R.id.password).text}", Toast.LENGTH_SHORT).show()
        }

        val builder = AlertDialog.Builder(this)
            builder.setView(dialogView)
                .create()

        return builder
    }
}