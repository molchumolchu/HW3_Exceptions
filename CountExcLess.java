public class CountExcLess extends RuntimeException{
    public CountExcLess(String message) {
        super(message);
    }
    public CountExcLess() {
        super("Введны не все параметры");
    }
}
