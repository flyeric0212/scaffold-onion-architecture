package top.flyeric.jasypt;

import static org.assertj.core.api.Assertions.assertThat;

import com.ulisesbocchio.jasyptspringboot.configuration.StringEncryptorBuilder;
import com.ulisesbocchio.jasyptspringboot.properties.JasyptEncryptorConfigurationProperties;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    @Test
    public void encrypt() {
        JasyptEncryptorConfigurationProperties properties = new JasyptEncryptorConfigurationProperties();
        properties.setPassword("abc!23");
        StringEncryptor encryptor = new StringEncryptorBuilder(properties, "").build();

        String originString = "test";
        String encryptedString = encryptor.encrypt(originString);
        System.out.println("encryptedString : " + encryptedString);

        String decryptString = encryptor.decrypt(encryptedString);
        assertThat(decryptString).isEqualTo(originString);
    }

}
