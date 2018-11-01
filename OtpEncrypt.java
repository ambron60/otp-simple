import java.util.Scanner;

public class OtpEncrypt {
    public static void main(String[] args) {
        System.out.println();
        System.out.print("Enter or paste plaintext: ");
        Scanner input = new Scanner(System.in);
        String plainText = input.nextLine();
        plainText = plainText.replaceAll("[^\\p{L}\\p{N}]", "").toUpperCase();  // Leave alpha chars
        System.out.format("Your key will require %d characters or more.. ", plainText.length());
        System.out.print("Enter your key: ");
        Scanner oneTimePadKey = new Scanner(System.in);
        String oneTimePad = oneTimePadKey.nextLine();

        // Remove whitespaces from OTP
        // Trim OTP to match Plaintext size
        // Convert to uppercase
        try {
            oneTimePad = oneTimePad.replaceAll("[^\\p{L}\\p{N}]", "");
            oneTimePad = oneTimePad.substring(0, plainText.length());
            oneTimePad = oneTimePad.toUpperCase();
        } catch (Exception exception) {
            System.out.println("Key size must match or exceed plaintext size. Try again.");
            System.exit(0); // Abort program.
        }

        // Convert plaintext into array of characters
        // Assign new array length (PLAINTEXT)
        // Convert each character in plain text array to its numerical equivalent
        char[] plain = plainText.toCharArray();
        int[] plains = new int[plain.length];
        CharToNum(plain, plains);

        // Convert pad into array of characters
        // Assign new array length (OTP-KEY)
        // Convert each key in plain text array to its numerical equivalent
        char[] key = oneTimePad.toCharArray();
        int[] keys = new int[key.length];
        CharToNum(key, keys);

        // Iterate plaintext and OTP arrays. Add values and calculate modulus
        int[] cipherNum = new int[plain.length];
        int cipherChar;
        for (int k = 0; k < plains.length; k++) {
            cipherChar = ((plains[k] + keys[k]) % 26);
            cipherNum[k] = cipherChar;
        }
        char[] cipherCharacter = new char[cipherNum.length];
        NumToChar(cipherNum, cipherCharacter);

        System.out.format("\nCIPHER-TEXT: ");  // Output cipher text
        for (char j : cipherCharacter) {
            System.out.print(j);
        }
        System.out.println();
    }

    private static void CharToNum(char[] plainTextCharacter, int[] plainArray) {
        for (int charIndex = 0; charIndex < plainTextCharacter.length; charIndex++) {
            switch (plainTextCharacter[charIndex]) {
                case 'A':
                    plainArray[charIndex] = 0;
                    break;
                case 'B':
                    plainArray[charIndex] = 1;
                    break;
                case 'C':
                    plainArray[charIndex] = 2;
                    break;
                case 'D':
                    plainArray[charIndex] = 3;
                    break;
                case 'E':
                    plainArray[charIndex] = 4;
                    break;
                case 'F':
                    plainArray[charIndex] = 5;
                    break;
                case 'G':
                    plainArray[charIndex] = 6;
                    break;
                case 'H':
                    plainArray[charIndex] = 7;
                    break;
                case 'I':
                    plainArray[charIndex] = 8;
                    break;
                case 'J':
                    plainArray[charIndex] = 9;
                    break;
                case 'K':
                    plainArray[charIndex] = 10;
                    break;
                case 'L':
                    plainArray[charIndex] = 11;
                    break;
                case 'M':
                    plainArray[charIndex] = 12;
                    break;
                case 'N':
                    plainArray[charIndex] = 13;
                    break;
                case 'O':
                    plainArray[charIndex] = 14;
                    break;
                case 'P':
                    plainArray[charIndex] = 15;
                    break;
                case 'Q':
                    plainArray[charIndex] = 16;
                    break;
                case 'R':
                    plainArray[charIndex] = 17;
                    break;
                case 'S':
                    plainArray[charIndex] = 18;
                    break;
                case 'T':
                    plainArray[charIndex] = 19;
                    break;
                case 'U':
                    plainArray[charIndex] = 20;
                    break;
                case 'V':
                    plainArray[charIndex] = 21;
                    break;
                case 'W':
                    plainArray[charIndex] = 22;
                    break;
                case 'X':
                    plainArray[charIndex] = 23;
                    break;
                case 'Y':
                    plainArray[charIndex] = 24;
                    break;
                case 'Z':
                    plainArray[charIndex] = 25;
                    break;
                default:
                    break;
            }
        }
    }

    private static void NumToChar(int[] cipherChar, char[] cipherArray) {
        for (int i = 0; i < cipherChar.length; i++) {
            switch (cipherChar[i]) {
                case 0:
                    cipherArray[i] = 'A';
                    break;
                case 1:
                    cipherArray[i] = 'B';
                    break;
                case 2:
                    cipherArray[i] = 'C';
                    break;
                case 3:
                    cipherArray[i] = 'D';
                    break;
                case 4:
                    cipherArray[i] = 'E';
                    break;
                case 5:
                    cipherArray[i] = 'F';
                    break;
                case 6:
                    cipherArray[i] = 'G';
                    break;
                case 7:
                    cipherArray[i] = 'H';
                    break;
                case 8:
                    cipherArray[i] = 'I';
                    break;
                case 9:
                    cipherArray[i] = 'J';
                    break;
                case 10:
                    cipherArray[i] = 'K';
                    break;
                case 11:
                    cipherArray[i] = 'L';
                    break;
                case 12:
                    cipherArray[i] = 'M';
                    break;
                case 13:
                    cipherArray[i] = 'N';
                    break;
                case 14:
                    cipherArray[i] = 'O';
                    break;
                case 15:
                    cipherArray[i] = 'P';
                    break;
                case 16:
                    cipherArray[i] = 'Q';
                    break;
                case 17:
                    cipherArray[i] = 'R';
                    break;
                case 18:
                    cipherArray[i] = 'S';
                    break;
                case 19:
                    cipherArray[i] = 'T';
                    break;
                case 20:
                    cipherArray[i] = 'U';
                    break;
                case 21:
                    cipherArray[i] = 'V';
                    break;
                case 22:
                    cipherArray[i] = 'W';
                    break;
                case 23:
                    cipherArray[i] = 'X';
                    break;
                case 24:
                    cipherArray[i] = 'Y';
                    break;
                case 25:
                    cipherArray[i] = 'Z';
                    break;
                default:
                    break;
            }
        }
    }
}
