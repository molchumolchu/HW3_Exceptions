public class CountExcMore extends RuntimeException{
    public CountExcMore(String message) {
        super(message);
    }
    public CountExcMore() {
        super("Введны лишние параметры");
    }
}
