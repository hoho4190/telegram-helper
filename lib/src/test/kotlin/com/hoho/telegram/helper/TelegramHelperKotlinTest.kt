package com.hoho.telegram.helper

import com.hoho.telegram.helper.model.TelegramInfo
import com.hoho.telegram.helper.util.TestUtil
import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("TelegramHelper Test - Kotlin")
internal class TelegramHelperKotlinTest {

    private lateinit var telegramInfoList: List<TelegramInfo>

    @BeforeAll
    fun setup() {
        telegramInfoList = TestUtil.getTelegramInfoList()
    }

    @Disabled
    @Test
    @DisplayName("Send message test")
    fun sendMessage() {
        // given
        val telegramInfo = telegramInfoList.first()
        val telegramHelper = TelegramHelper(telegramInfo)
        val message = "kotlin message"

        // when
        val sendResponseList = telegramHelper.sendMessage("$message 1")
        val sendResponse = telegramHelper.sendMessage(telegramInfo.chatIdList.first(), "$message 2")

        // then
        Assertions.assertAll(
            sendResponseList.map {
                Executable { Assertions.assertTrue(it.isOk) }
            }
        )
        Assertions.assertTrue(sendResponse.isOk)
    }
}