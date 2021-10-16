package com.hoho.telegram.helper.model

import kotlinx.serialization.Serializable
import java.util.LinkedHashSet

/**
 * Telegram info
 */
@Serializable
data class TelegramInfo(
    val token: String
) {
    var chatIdList: LinkedHashSet<Long> = linkedSetOf()

    constructor(token: String, chatId: Long) : this(token) {
        this.chatIdList = linkedSetOf(chatId)
    }

    constructor(token: String, chatIdList: LinkedHashSet<Long>) : this(token) {
        this.chatIdList = chatIdList
    }

    constructor(token: String, vararg chatIds: Long) : this(token) {
        this.chatIdList = linkedSetOf(*chatIds.toTypedArray())
    }

    override fun toString(): String {
        return "TelegramInfo(token='$token', chatIdList=$chatIdList)"
    }
}