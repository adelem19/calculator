package com.example.calkulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.calkulator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.io.IOException
import java.lang.ArithmeticException
import java.lang.Exception
import java.lang.NullPointerException
import java.lang.UnsupportedOperationException

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var res : Float = 0F



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {

            numShow(bNull, ptPrim, '0')
            numShow(bOne, ptPrim, '1')
            numShow(bTwo, ptPrim, '2')
            numShow(bThree, ptPrim, '3')
            numShow(bFour, ptPrim, '4')
            numShow(bFive, ptPrim, '5')
            numShow(bSix, ptPrim, '6')
            numShow(bSeven, ptPrim, '7')
            numShow(bEight, ptPrim, '8')
            numShow(bNine, ptPrim, '9')
           bPlus.setOnClickListener {
               val s = ptPrim.text.toString()
               if(s.elementAt(s.length-1) == '+'){

               }else {
                   ptPrim.append("+")
               }
           }
            bMinus.setOnClickListener {
                val s = ptPrim.text.toString()
                if(s.elementAt(s.length-1) == '-'){

                }else {
                    ptPrim.append("-")
                }
            }
            bMultiply.setOnClickListener {
                val s = ptPrim.text.toString()
                if(s.elementAt(s.length-1) == '*'){

                }else {
                    ptPrim.append("*")
                }
            }
            bDevision.setOnClickListener {
                val s = ptPrim.text.toString()
                if(s.elementAt(s.length-1) == '/'){

                }else {
                    ptPrim.append("/")
                }
            }
            bCova.setOnClickListener {
                val s = ptPrim.text.toString()
                if(s.elementAt(s.length-1) == '.'){

                }else {
                    ptPrim.append(".")
                }
            }

            numShow(bScobL, ptPrim, '(')
            numShow(bScobR, ptPrim,')')



            bDelete.setOnClickListener {

                ptPrim.setText(ptPrim.text.toString().dropLast(1))

            }

            bClear.setOnClickListener {
                ptPrim.setText("")
                tvShow.text = ""
            }

            binding.btResult.setOnClickListener {
                var resu = binding.ptPrim.text.toString()
                    var count = 0
                    var r = try{
                        ExpressionBuilder(resu).build().evaluate().toString()
                    }
                    catch (e : ArithmeticException){
                    Toast.makeText(this@MainActivity, "На ноль делить нельзя", Toast.LENGTH_SHORT).show()
                        count ++
                }catch (e2 : Exception){
                        Toast.makeText(this@MainActivity, "Проверьте выражение, возникла ошибка", Toast.LENGTH_SHORT).show()
                        count++
                }


                if(count == 0) {
                    if (r.toString().substring(r.toString().length - 2).equals(".0")) {
                        r = r.toString().replace(".0", "")
                    }
                    binding.ptPrim.append("=")
                    resu = ptPrim.text.toString()

                    ptPrim.setText(r.toString())
                    tvShow.append("$resu\n")
                    tvShow.append("${r.toString()}\n")
                }else {
                    ptPrim.setText("")
                }


            }
        }
    }

}