package com.example.chrisswhuang.encryption;

import ru.bullyboo.encoder.Encoder;
import ru.bullyboo.encoder.methods.AES;
import ru.bullyboo.encoder.methods.Blowfish;

public class Encryption {

    private Encryption() {
    }

    private static class LazyHolder {
        private static final Encryption INSTANCE = new Encryption();
    }

    public static Encryption getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String encryptAES(String message, String key) {
        return Encoder.BuilderAES()
                .message(message)
                .method(AES.Method.AES_CBC_PKCS5PADDING)
                .key(key)
                .keySize(AES.Key.SIZE_128)
                .iVector("test vector")
                .encrypt();
    }

    public String decryptAES(String message, String key) {
        return Encoder.BuilderAES()
                .message(message)
                .method(AES.Method.AES_CBC_PKCS5PADDING)
                .key(key)
                .keySize(AES.Key.SIZE_128)
                .iVector("test vector").decrypt();
    }

    public String encryptBlowFish(String message, String key) {
        return Encoder.BuilderBlowfish()
                .message(message)
                .method(Blowfish.Method.BLOWFISH_CBC_PKCS5Padding)
                .key(key)
                .keySize(1)
                .iVector("test vector")
                .encrypt();
    }

    public String descryptBlowFish(String message, String key) {
        return Encoder.BuilderBlowfish()
                .message(message)
                .method(Blowfish.Method.BLOWFISH_CBC_PKCS5Padding)
                .key(key)
                .keySize(1)
                .iVector("test vector")
                .decrypt();
    }

    public void encryptDescryptAESDemo() {
        String encrypt = Encoder.BuilderAES()
                .message("test message")
                .method(AES.Method.AES_CBC_PKCS5PADDING)
                .key("test key")
                .keySize(AES.Key.SIZE_128)
                .iVector("test vector")
                .encrypt();

        System.out.println(encrypt);

        String descrypt = Encoder.BuilderAES()
                .message(encrypt)
                .method(AES.Method.AES_CBC_PKCS5PADDING)
                .key("test key")
                .keySize(AES.Key.SIZE_128)
                .iVector("test vector").decrypt();

        System.out.println(descrypt);
    }

    public void encryptDescryptBlowfishDemo() {
        String encrypt = Encoder.BuilderBlowfish()
                .message("test mesage")
                .method(Blowfish.Method.BLOWFISH_CBC_PKCS5Padding)
                .key("test key")
                .keySize(1)
                .iVector("test vector")
                .encrypt();

        System.out.println(encrypt);

        String descrypt = Encoder.BuilderBlowfish()
                .message(encrypt)
                .method(Blowfish.Method.BLOWFISH_CBC_PKCS5Padding)
                .key("test key")
                .keySize(1)
                .iVector("test vector")
                .decrypt();

        System.out.println(descrypt);
    }
}
