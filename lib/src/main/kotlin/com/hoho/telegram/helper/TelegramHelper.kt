package com.hoho.telegram.helper

import com.hoho.telegram.helper.model.TelegramInfo
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.request.SendMessage
import com.pengrad.telegrambot.response.SendResponse

/**
 * Telegram helper
 */
class TelegramHelper(
    private val telegramInfo: TelegramInfo
) {
    private var telegramBot: TelegramBot = TelegramBot(telegramInfo.token)

    /**
     * Send message.
     * @param chatId
     * @param message
     */
    fun sendMessage(chatId: Long, message: String): SendResponse {
        return telegramBot.execute(SendMessage(chatId, message))
    }

    /**
     * Send message to all chatIds.
     * @param message
     */
    fun sendMessage(message: String): List<SendResponse> {
        if (telegramInfo.chatIdList.isEmpty()) {
            throw RuntimeException("TelegramInfo.chatIdList is empty")
        }

        return telegramInfo.chatIdList.map {
            sendMessage(it, message)
        }
    }
}