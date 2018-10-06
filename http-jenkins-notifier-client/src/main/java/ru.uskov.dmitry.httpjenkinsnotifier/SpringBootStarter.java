package ru.uskov.dmitry.httpjenkinsnotifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import java.io.File;

@SpringBootApplication
public class SpringBootStarter {

    private static final String AUDIO_PATH_PROPERTY = "audio.path";

    public static void main(String[] args) {
        SimpleCommandLinePropertySource ps = new SimpleCommandLinePropertySource(args);
        String audioPathProperty = ps.getProperty(AUDIO_PATH_PROPERTY);
        boolean valid = validateAudioPathProperty(audioPathProperty);
        if (!valid) {
            return;
        }
        System.out.println(AUDIO_PATH_PROPERTY + "=" + audioPathProperty);
        SpringApplication.run(SpringBootStarter.class, args);
    }

    private static boolean validateAudioPathProperty(String property) {
        String invalidPathPrefix = "Invalid '" + AUDIO_PATH_PROPERTY + "' property. ";
        if (property == null) {
            System.err.println(invalidPathPrefix + "Property '" + AUDIO_PATH_PROPERTY + "' is not set. Add it as command line argument: --" + AUDIO_PATH_PROPERTY + "=path/to/audio");
            return false;
        }
        File file = new File(property);
        if (!file.isDirectory()) {
            System.err.println(invalidPathPrefix + "'" + property + "' is not a directory");
            return false;
        }
        return true;
    }
}
