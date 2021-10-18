# Telegram Helper
[![Release](https://jitpack.io/v/hoho4190/telegram-helper.svg)](https://jitpack.io/#hoho4190/telegram-helper)

## Usage
```kotlin
// TelegramHelper
val telegramInfo = TelegramInfo(TOKEN, CHAT_ID)
val telegramHelper = TelegramHelper(telegramInfo)
val responseList: List<SendResponse> = telegramHelper.sendMessage(MESSAGE)

// TelegramSimpleHelper
val telegramInfo = TelegramInfo(TOKEN, CHAT_ID)
TelegramSimpleHelper.setup(telegramInfo)
val responseList: List<SendResponse> = TelegramSimpleHelper.sendMessage(MESSAGE)
```
