public class MaleExc extends Exception{
    public MaleExc(String message) {
        super(message);
    }
    public MaleExc() {
        super("Некорректно определен пол");
    }
}
