package com.hoho.telegram.helper;

import com.hoho.telegram.helper.model.TelegramInfo;
import com.hoho.telegram.helper.util.TestUtil;
import com.pengrad.telegrambot.response.SendResponse;
import org.junit.jupiter.api.*;

import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("TelegramSimpleHelper Test - Java")
public class TelegramSimpleHelperJavaTest {

    private List<TelegramInfo> telegramInfoList;

    @BeforeAll
    void setup(){
        telegramInfoList = TestUtil.getTelegramInfoList();
    }

    @Disabled
    @Test
    @DisplayName("Send message test")
    public void sendMessage() {
        // given
        TelegramInfo telegramInfo = telegramInfoList.get(0);
        TelegramSimpleHelper.setup(telegramInfo);
        String message = "TelegramSimpleHelper Java Test";

        // when
        List<SendResponse> sendResponseList = TelegramSimpleHelper.sendMessage(message + " 1");
        SendResponse sendResponse = TelegramSimpleHelper.sendMessage(
                telegramInfo.getChatIdList().stream().findFirst().orElse(0L),
                message + " 2"
        );

        // then
        Assertions.assertAll(
                sendResponseList.stream().map(res ->
                        () -> Assertions.assertTrue(res.isOk())
                )
        );
        Assertions.assertTrue(sendResponse.isOk());
    }
}
