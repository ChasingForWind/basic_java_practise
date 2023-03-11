package SPI相关;

public class SmsMessageServiceImpl implements MessageService{

    public SmsMessageServiceImpl() {
        System.out.println("MyMessageService constructor called");
        System.out.println("Classloader: " + getClass().getClassLoader());
    }

    @Override
    public void send(String message) {
        System.out.println("hello 我是 Sms SPI， 我发送的信息是：" + message);
    }
}
