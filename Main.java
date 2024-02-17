import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import static jdk.internal.org.jline.utils.Colors.s;

public class Main {
    /*
    Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество дата _ рождения номер _ телефона пол

Форматы данных:
фамилия, имя, отчество - строки
дата _ рождения - строка формата dd.mm.yyyy
номер _ телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает, вернуть код ошибки, обработать его и показать пользователю сообщение,
что он ввел меньше или больше данных, чем требуется.
Приложение должно распарсить полученную строку и выделить из них требуемые значения. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы.
Можно использовать встроенные типы java и создавать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида
<Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

     */
    static Map<String, String> map = new LinkedHashMap<>();

    public static void main(String[] args) throws Exception {
//        System.out.println(getData());
//        System.out.println(Arrays.toString(parse(getData())));
        try {
            fileWrigter(parse(getData()));
        }
        catch (CountExcLess e){
            System.out.println("Введны не все данные");;
        }
        catch (CountExcMore e){
            System.out.println("Введны лишние данные");;
        }
        catch (MaleExc e){
            System.out.println("Пол введен некорректно введите f - если женский или m - если мужской");;
        }



    }

    public static String getData(){
        String data;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел ФИО, дату рождения, номер телефона, пол");
        System.out.println(">>> ");
        data = scanner.nextLine();
        return data;
    }

    public static String[] parse(String line) throws Exception {
        String[] arr = line.split(" ");

        System.out.println(Arrays.toString(arr));
        if (arr.length>6) throw new CountExcMore();
        if (arr.length<6) throw new CountExcLess();
        if(arr[5].matches("\\d*")) throw new PhoneExc();
        if(!Objects.equals(arr[5], "f") & !Objects.equals(arr[5], "m")) throw new MaleExc();

//        if (!arr[3].contains(".")) throw new DateExc();

//        System.out.println(arr[3]);
        String[] data = arr[3].split("\\.");
//        System.out.println(Arrays.toString(data));
        int dd, mm, year;

//        if((Integer.parseInt(data[0]).) throw new NumberFormatException();
        try {
            dd = Integer.parseInt(data[0]);
            mm = Integer.parseInt(data[1]);
            year = Integer.parseInt(data[2]);
        }
        catch (NumberFormatException e){
            System.out.println("неверный формат дня рождения");
            data[0]= String.valueOf("00");
            data[1]= String.valueOf("00");
            data[2]= String.valueOf("0000");
        }
//

        return arr;
    }

    public static void fileWrigter (String[] arr) throws IOException {

        File file = new File(arr[0]);
        if (file.exists()) {
            try (FileWriter fileWriter = new FileWriter(arr[0])) {
                fileWriter.write(Arrays.toString(arr));
                fileWriter.write("\n");
                System.out.println("Файл обновлен!");


            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try (FileWriter fileWriter = new FileWriter(arr[0])) {
                fileWriter.write(Arrays.toString(arr));
                fileWriter.write("\n");
                System.out.println("Файл создан");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
