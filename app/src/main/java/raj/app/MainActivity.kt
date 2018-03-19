package raj.app

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import raj.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val name: String = ""
    private val rollNo: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.name = name
        binding.rollNo = rollNo

        binding.button.setOnClickListener { v: View? -> makeServerCall(binding.name.toString(), rollNo) }
    }

    private fun makeServerCall(name: String, rollNo: String) {
        val context = this
    }


}
