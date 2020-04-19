package com.home.kakaodemo

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.agoda.kakao.screen.Screen.Companion.onScreen
import com.home.kakaodemo.screen.HomeActivityScreen
import com.home.kakaodemo.view.HomeActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    @Rule
    @JvmField
    val rule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testRecyclerView() {
        onScreen<HomeActivityScreen> {
            kRecyclerView {
                Thread.sleep(2000)
                firstChild<HomeActivityScreen.FirstItem> {}
                perform {
                    isVisible()
                    click()
                }
                Thread.sleep(2000)
            }
        }
    }
}
