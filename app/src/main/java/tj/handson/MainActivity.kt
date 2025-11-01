package tj.handson

import android.graphics.Rect
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tj.handson.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        applyTopBottomPaddingForEdgeToEdge(binding.root)
        setContentView(binding.root)
    }

    private fun applyTopBottomPaddingForEdgeToEdge(rootView: View) {
        ViewCompat.setOnApplyWindowInsetsListener(rootView) { view, insets ->
            // 상태바와 내비게이션 바 높이 얻기
            val statusBarHeight = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            val naviBarHeight = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom

            // 키보드가 올라왔을 때 아래쪽 패딩 계산
            val bottomPadding = getBottomPaddingChangedByKeyboard(view, naviBarHeight)

            // 상단/하단 패딩 적용
            view.setPadding(0, statusBarHeight, 0, bottomPadding)
            insets
        }
    }

    private fun getBottomPaddingChangedByKeyboard(view: View, naviBarHeight: Int): Int {
        // 화면에 키보드가 올라왔는지 확인하고, 올려졌으면 키보드 높이만큼 패딩 적용
        val rect = Rect().apply { view.rootView.getWindowVisibleDisplayFrame(this) }
        return if (isKeyBoardVisible(view.height, rect)) {
            view.height - rect.bottom
        } else {
            naviBarHeight
        }
    }

    private fun isKeyBoardVisible(screenHeight: Int, rect: Rect): Boolean {
        // 키보드가 화면에 올라왔는지 체크 (높이가 화면 높이의 13% 이상일 경우 키보드가 올라왔다고 판단)
        val keyboardHeight = screenHeight - rect.bottom
        return keyboardHeight > screenHeight * 0.13
    }
}