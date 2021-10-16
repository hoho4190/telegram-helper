package com.hoho.telegram.helper.util

import com.hoho.telegram.helper.model.TelegramInfo
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.nio.charset.Charset

object TestUtil {

    /**
     * Telegram info resource file name
     */
    private const val TEL_INFO_RES_FILE_NAME = "telegram-info-list.json"

    /**
     * Finds a resource with the given name.
     * And reads the entire content as a String the specified charset (default is UTF-8).
     *
     * @param fileName
     * @param charset default is UTF-8
     */
    @JvmOverloads
    fun readResource(fileName: String, charset: Charset = Charsets.UTF_8): String =
        javaClass.classLoader.getResource(fileName)!!.readText(charset)

    /**
     * Convert json string to TelegramInfo List
     *
     * @param jsonString json string
     */
    fun convertToTelegramInfoList(jsonString: String): List<TelegramInfo> =
        Json.decodeFromString(jsonString)

    /**
     * Get TelegramInfo List
     */
    @JvmStatic
    fun getTelegramInfoList(): List<TelegramInfo> =
        convertToTelegramInfoList(readResource(TEL_INFO_RES_FILE_NAME))
}