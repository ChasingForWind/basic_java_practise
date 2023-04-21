package SPI相关;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<MessageService> loader = ServiceLoader.load(MessageService.class);
        for (MessageService service : loader) {
            service.send("hello world");
        }
        Iterator<MessageService> iterator = loader.iterator();
    }
}
