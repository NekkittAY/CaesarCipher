import java.util.Scanner;


class CaesarCipher {  

    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                encryptedText.append((char) (base + (character - base + shift) % 26));
            } else {
                encryptedText.append(character);
            }
        }
        return encryptedText.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - (shift % 26));
    }
}



public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите текст:");
        String text = scanner.nextLine();

        System.out.println("Введите шаг сдвига:");
        int shift = scanner.nextInt();

        System.out.println("Выберите действие: 1 - Шифрование, 2 - Дешифрование");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        String result;
        if (choice == 1) {
            result = CaesarCipher.encrypt(text, shift);
            System.out.println("Зашифрованный текст: " + result);
        } else if (choice == 2) {
            result = CaesarCipher.decrypt(text, shift);
            System.out.println("Расшифрованный текст: " + result);
        } else {
            System.out.println("Неверный выбор.");
        }

        scanner.close();
    }
}
