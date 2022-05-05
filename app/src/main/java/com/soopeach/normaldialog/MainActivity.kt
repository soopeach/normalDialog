package com.soopeach.normaldialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.btn)

        button.setOnClickListener {
            val builder = checkBoxDialog()
            builder.show()
        }
    }

    fun basicDialog(): AlertDialog.Builder {

        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("다이얼로그 제목")
            .setMessage("다이얼로그 메시지\n1줄\n2줄\n3줄")
//            .setCancelable(false)
            .setPositiveButton("확인", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "확인 버튼 클릭!", Toast.LENGTH_SHORT).show()
                }
            })
            .setNegativeButton("취소", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "취소 버튼 클릭!", Toast.LENGTH_SHORT).show()
                }
            })
            .setNeutralButton("뉴트럴", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "뉴트럴 버튼 클릭!", Toast.LENGTH_SHORT).show()
                }
            })
            .create()
        return builder

    }

    fun listDialog(): AlertDialog.Builder {

        val builder = AlertDialog.Builder(this)
        val color = arrayOf("빨강", "주황", "노랑", "초록", "파랑", "남색", "보라", "하얀")

        builder.setTitle("리스트 다이어로그")
            .setItems(color, object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, pos: Int) {
                    Toast.makeText(baseContext, "${color[pos]}", Toast.LENGTH_SHORT).show()
                }

            })

        builder.create()

        return builder
    }

    fun radioButtonDialog(): AlertDialog.Builder{

        val itemList = arrayOf("1번 아이템", "2번 아이템", "3번 아이템")
        var checkedItem = 0
        val builder = AlertDialog.Builder(this)

        builder.setTitle("라디오 버튼 다이얼로그")
            .setSingleChoiceItems(itemList, checkedItem, object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, pos: Int) {
                    checkedItem = pos
                }
            })
            .setPositiveButton("선택한 아이템 출력", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "${itemList[checkedItem]}", Toast.LENGTH_SHORT).show()
                }
            })

        builder.create()

        return builder

    }

    fun checkBoxDialog(): AlertDialog.Builder{

        var itemList = arrayOf("1번 아이템", "2번 아이템", "3번 아이템", "4번 아이템", "5번 아이템")
        var checkedItems = arrayListOf<String>()
        val builder = AlertDialog.Builder(this)

        builder.setTitle("체크박스 다이얼로그")
            .setMultiChoiceItems(itemList, null, object : DialogInterface.OnMultiChoiceClickListener {
                override fun onClick(dialog: DialogInterface, pos: Int, isChecked: Boolean) {
                    if(isChecked){
                        checkedItems.add(itemList[pos])
                    } else if(checkedItems.contains(itemList[pos])){
                        checkedItems.remove(itemList[pos])
                    }
                }
            })
            .setPositiveButton("선택한 아이템들 출력", object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(baseContext, "${checkedItems}", Toast.LENGTH_SHORT).show()
                }
            })

        builder.create()

        return builder

    }

    fun viewDialog(): AlertDialog.Builder {

        val dialogView = layoutInflater.inflate(R.layout.dialog_view, null)

        val passBtn = dialogView.findViewById<Button>(R.id.checkBtn)
        passBtn.setOnClickListener {
            Toast.makeText(
                this,
                "${dialogView.findViewById<EditText>(R.id.password).text}",
                Toast.LENGTH_SHORT
            ).show()
        }

        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
            .create()

        return builder
    }


}