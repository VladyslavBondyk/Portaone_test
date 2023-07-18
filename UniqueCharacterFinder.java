import java.util.HashMap;  // пакет використовується для зберігання кількості символів.
import java.util.Map; // використовується для визначення зіставлення символів з їх кількістю.
import java.util.Scanner;  // використовується для читання введених користувачем даних. scanner – база на початку вивчення джави)

public class UniqueCharacterFinder {        // відкриваємо клас
    public static void main(String[] args) {        //  головний метод = точка відліку програми на джаві
        Scanner scanner = new Scanner(System.in);        //  створюємо обєкт сканер для читання даних від юзера
        System.out.println("Enter the text:");        //  просимо ввести текст, щоб було зрозуміліше
        String text = scanner.nextLine();        //  читаємо текст від юзера і даємо їй назву text
        scanner.close();        //  закінчуємо роботу зі сканером, щоб менше грузити і без того тяжкий код :D

        //  викликаємо метод для пошуку унікального символу. і призначаємо змінну. парт ту нашого коду
        char uniqueCharacter = findUniqueCharacter(text);
        //  друкуємо перший унікальнйи символ з тексту юзера.
        System.out.println("The first unique character is: " + uniqueCharacter);        //
    }

    // новий метод який приймає Стрінг і повертає значення чар
    private static char findUniqueCharacter(String text) {
        // створюємо ХешМеп обєкт для зберігання Скіки разів зявляється символ
        Map<Character, Integer> charCountMap = new HashMap<>();
// розділяємо текст на слова, пробіли як розділювачі + повторюємо кожне слоо
        for (String word : text.split("\\s+")) {
            // створюємо c змінну для унік символу. міняємо слова на масив символів і повторюємо кожний символ
            for (char c : word.toCharArray()) {
                // ардейтимо кількість символів в чарКаунтМеп. Якщо символу нема = рахуємо до 0 і додаємо +1
                charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
            } //закриваємо повторення символів
        } //закриваємо повторення слів
        //дабл чек методу вище
        for (String word : text.split("\\s+")) {

            for (char c : word.toCharArray()) {
                // дабл чек що с == 1
                if (charCountMap.get(c) == 1) {
                    // показуємо с. с = унікальний символ.
                    return c;
                }
            }
        }
        // на випадок якщо символу не буде – побачимо аутпут  відповідний.
        throw new RuntimeException("No unique character found");        //
    }
}
