package ru.vkbot;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.*;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;

public class Bot {
    public static void main(String[] args) throws ClientException, ApiException, InterruptedException
    {
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        Random random = new Random();
        Keyboard keyboard = new Keyboard();

        List<List<KeyboardButton>> allKey = new ArrayList<>();
        List<KeyboardButton> line1 = new ArrayList<>();
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Мастер").setType(KeyboardButtonActionType.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Консультанция").setType(KeyboardButtonActionType.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        line1.add(new KeyboardButton().setAction(new KeyboardButtonAction().setLabel("Цены").setType(KeyboardButtonActionType.TEXT)).setColor(KeyboardButtonColor.POSITIVE));
        allKey.add(line1);
        keyboard.setButtons(allKey);
        GroupActor actor = new GroupActor(32164718,
                "vk1.a.mmedQiyqNR_kKi3t2RUHyhVSAhA3PpDtHTxD_1nsCKZMAwvzvIiQgQ1Yin1erv3BCBb7Nys5guqeEdeuCxZ4luJZTPuRzWJO-nfswwZE4SclDGL8tEA7MbRkxii8WE4ZhcHr_NkInVt7SAu21Uty8GoPLhBRZ_hv-YKG80zL_q1bev8ow1zlauJQ4Wc02FNAP6CoM8HCqNlX8vd3Iserwg");
        Integer ts = vk.messages().getLongPollServer(actor).execute().getTs();
        int stage1 = 0;

        while (true) {
            MessagesGetLongPollHistoryQuery historyQuery = vk.messages().getLongPollHistory(actor).ts(ts);
            List<Message> messages = historyQuery.execute().getMessages().getItems();
            if (!messages.isEmpty()) {
                for (Message message : messages) {
                    try {

                        if (message.getText().equals("Консультанция")) {
                            String str = "Заполните форму по шаблону! Отвечайте да или нет в ближайшее время вас проконсультируют!\n" +
                                    "1. Вы выбрали место для тату?: да/нет";
//                                    "2. Вы выбрали размер татуировки?: нет\n" +
//                                    "3. Вы выбрали тату которое хотите набить?: нет\n" +
//                                    "4. Вам нужна помощь с выбором эскиза?: да\n" +
//                                    "5. На какую сумму расчистывете?";
                            stage1 = 10;
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().equals("Мастер")) {
                            stage1 = 0;
                            String str = "Ваше сообщение уже передано мастеру. Он свяжеться с вами, в ближайшее время. Можете оставить ваш номер телефона.";
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else  if (message.getText().equals("Цены")) {
                            stage1 = 0;
                            String str = "Маленькое тату. Размер: 3х3 от 2000 \n" +
                                    "Среднее тату. Размер 8х7: от 5000\n" +
                                    "Большое тату. Размер 15х8: от 10000\n";
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().toLowerCase().equals("ева")) {
                            stage1 = 0;
                            vk.messages().send(actor).message("Вас приветсвует ассистент Ева").userId(message.getFromId()).randomId(random.nextInt(10000)).keyboard(keyboard).execute();
                        }  else if (message.getText().toLowerCase().equals("'ева'")) {
                            stage1 = 0;
                            vk.messages().send(actor).message("Вас приветсвует ассистент Ева").userId(message.getFromId()).randomId(random.nextInt(10000)).keyboard(keyboard).execute();
                        } else if ((message.getText().toLowerCase().equals("да") || message.getText().toLowerCase().equals("нет")) && stage1 == 10) {
                            String str = "2. Вы выбрали размер татуировки?: Если 'да' введите размер татуировки и отправьте. Затем новым сообщением напишите да/нет\n";
//
                            stage1 = 1;
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if ((message.getText().toLowerCase().equals("да") || message.getText().toLowerCase().equals("нет")) && stage1 == 1) {
                        String str = "3. Вы выбрали тату которое хотите набить?: да/нет\n";
//                                    "4. Вам нужна помощь с выбором эскиза?: да\n" +
//                                    "5. На какую сумму расчистывете?";
                            stage1 = 2;
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().toLowerCase().equals("да") && stage1 == 2) {
                            String str = "4. Пришлите изображение\n";
//                                    "5. На какую сумму расчистывете?";
                            stage1 = 3;
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (message.getText().toLowerCase().equals("нет") && stage1 == 2) {
                            String str = "4. Вам помочь с выбором эскиза? да/нет\n";
//                                    "5. На какую сумму расчистывете?";
                            stage1 = 3;
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (stage1 == 3) {
                            String str = "5. На какую сумму расчистывете?\n";
                            stage1 = 4;
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        } else if (stage1 == 4) {
                            String str = "Благодарим за заполнение формы. Мастер свяжеться с вами в ближайшее время.";
                            vk.messages().send(actor).message(str).userId(message.getFromId()).randomId(random.nextInt(10000)).execute();
                        }
                        else {
                            vk.messages().send(actor).message("").userId(message.getFromId()).randomId(random.nextInt(10000)).keyboard(keyboard).execute();
                        }
                    } catch (ApiException | ClientException e) {e.printStackTrace();}
                }
            }
            ts = vk.messages().getLongPollServer(actor).execute().getTs();
            Thread.sleep(500);
        }
    }
}
