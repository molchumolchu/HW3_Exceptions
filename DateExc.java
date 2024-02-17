import java.util.zip.DataFormatException;

public class DateExc extends DataFormatException {
    public DateExc(String s) {
        super(s);
    }
    public DateExc() {
        super("Введен неверный формат даты");
    }
}
