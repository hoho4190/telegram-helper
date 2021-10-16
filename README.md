# Telegram Helper [![Release](https://jitpack.io/v/hoho4190/telegram-helper.svg)](https://jitpack.io/#hoho4190/telegram-helper)

### Kotlin
```kotlin
val telegramInfo = TelegramInfo(TOKEN, CHAT_ID)
val telegramHelper = TelegramHelper(telegramInfo)
val responseList: List<SendResponse> = telegramHelper.sendMessage(MESSAGE)
```

### Java
```java 
TelegramInfo telegramInfo = new TelegramInfo(TOKEN, CHAT_ID);
TelegramHelper telegramHelper = new TelegramHelper(telegramInfo);
List<SendResponse> responseList = telegramHelper.sendMessage(MESSAGE);
```