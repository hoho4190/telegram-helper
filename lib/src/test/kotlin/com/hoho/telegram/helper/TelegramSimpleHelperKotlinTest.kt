package com.hoho.telegram.helper

import com.hoho.telegram.helper.model.TelegramInfo
import com.hoho.telegram.helper.util.TestUtil
import org.junit.jupiter.api.*
import org.junit.jupiter.api.function.Executable

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("TelegramSimpleHelper Test - Kotlin")
internal class TelegramSimpleHelperKotlinTest {

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
        TelegramSimpleHelper.setup(telegramInfo)
        val message = "TelegramSimpleHelper Kotlin Test"

        // when
        val sendResponseList = TelegramSimpleHelper.sendMessage("$message 1")
        val sendResponse = TelegramSimpleHelper.sendMessage(telegramInfo.chatIdList.first(), "$message 2")

        // then
        Assertions.assertAll(
            sendResponseList.map {
                Executable { Assertions.assertTrue(it.isOk) }
            }
        )
        Assertions.assertTrue(sendResponse.isOk)
    }
}