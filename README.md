# Telegram Helper [![Release](https://jitpack.io/v/hoho4190/telegram-helper.svg)](https://jitpack.io/#hoho4190/telegram-helper)

### Kotlin
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

### Java
```java
// TelegramHelper
TelegramInfo telegramInfo = new TelegramInfo(TOKEN, CHAT_ID);
TelegramHelper telegramHelper = new TelegramHelper(telegramInfo);
List<SendResponse> responseList = telegramHelper.sendMessage(MESSAGE);

// TelegramSimpleHelper
TelegramInfo telegramInfo = new TelegramInfo(TOKEN, CHAT_ID);
TelegramSimpleHelper.setup(telegramInfo);
List<SendResponse> sendResponseList = TelegramSimpleHelper.sendMessage(MESSAGE);
```