public class PhoneExc extends RuntimeException{
    public PhoneExc(String message) {
        super(message);
    }
    public PhoneExc() {
        super("Номер телефона введен не корректно");
    }
}
