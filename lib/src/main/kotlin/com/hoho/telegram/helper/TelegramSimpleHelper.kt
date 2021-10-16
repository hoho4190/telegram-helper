package com.hoho.telegram.helper

import com.hoho.telegram.helper.model.TelegramInfo
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import com.pengrad.telegrambot.response.SendResponse

/**
 * Telegram simple helper
 */
object TelegramSimpleHelper {
    private lateinit var telegramInfo: TelegramInfo
    private lateinit var telegramBot: TelegramBot

    /**
     * Setup telegram simple helper
     * @param telegramInfo
     */
    @JvmStatic
    fun setup(telegramInfo: TelegramInfo) {
        this.telegramInfo = telegramInfo
        this.telegramBot = TelegramBot(telegramInfo.token)
    }

    /**
     * Send message.
     * @param chatId
     * @param message
     */
    @JvmStatic
    fun sendMessage(chatId: Long, message: String): SendResponse {
        checkSetup()

        return telegramBot.execute(SendMessage(chatId, message))
    }

    /**
     * Send message to all chatIds.
     * @param message
     */
    @JvmStatic
    fun sendMessage(message: String): List<SendResponse> {
        checkSetup()

        if (telegramInfo.chatIdList.isEmpty()) {
            throw RuntimeException("TelegramInfo.chatIdList is empty")
        }

        return telegramInfo.chatIdList.map {
            sendMessage(it, message)
        }
    }

    /**
     * Check setup.
     */
    private fun checkSetup(): Boolean =
        if (!this::telegramInfo.isInitialized || !this::telegramBot.isInitialized) {
            throw RuntimeException("TelegramSimpleHelper is not initialized.")
        } else {
            true
        }
}