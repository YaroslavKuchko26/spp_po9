interface EncryptionStrategy {
    String encrypt(String text);
}
class VowelRemovalStrategy implements EncryptionStrategy {
    @Override
    public String encrypt(String text) {
        return text.replaceAll("[aeiouAEIOU]", "");
    }
}
class LetterShiftStrategy implements EncryptionStrategy {
    private int shift;

    public LetterShiftStrategy(int shift) {
        this.shift = shift;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = (char) (c + shift);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(c);
            }
        }

        return encryptedText.toString();
    }
}
class XorEncryptionStrategy implements EncryptionStrategy {
    private String key;

    public XorEncryptionStrategy(String key) {
        this.key = key;
    }

    @Override
    public String encrypt(String text) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char keyChar = key.charAt(i % key.length());
            char encryptedChar = (char) (c ^ keyChar);
            encryptedText.append(encryptedChar);
        }

        return encryptedText.toString();
    }
}
class TextFileEncryptor {
    private EncryptionStrategy encryptionStrategy;

    public void setEncryptionStrategy(EncryptionStrategy encryptionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
    }

    public String encryptText(String text) {
        if (encryptionStrategy != null) {
            return encryptionStrategy.encrypt(text);
        } else {
            throw new IllegalStateException("Encryption strategy is not set.");
        }
    }
}
public class Lab6_3 {
    public static void main(String[] args) {
        TextFileEncryptor encryptor = new TextFileEncryptor();

        encryptor.setEncryptionStrategy(new VowelRemovalStrategy());
        String encryptedText1 = encryptor.encryptText("Hello, World!");
        System.out.println("Vowel Removal Encryption: " + encryptedText1);

        encryptor.setEncryptionStrategy(new LetterShiftStrategy(4));
        String encryptedText2 = encryptor.encryptText("aaaa");
        System.out.println("Letter Shift Encryption: " + encryptedText2);

        encryptor.setEncryptionStrategy(new XorEncryptionStrategy("secret"));
        String encryptedText3 = encryptor.encryptText("aaaa");
        System.out.println("XOR Encryption: " + encryptedText3);
    }
}