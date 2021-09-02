package config;

import com.fasterxml.jackson.annotation.JsonMerge;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Data;
import lombok.Getter;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;

import static util.ResourceUtil.getResourceAsStream;

public final class TestConfig {

    private static final String CONFIG_FILE = "config.yaml";

    @Getter
    final private static Config config = new Config();

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            ObjectReader reader = mapper.readerForUpdating(config);
            reader.readValue(IOUtils.toString(getResourceAsStream(CONFIG_FILE), "UTF-8"));
            File fileConfig = new File(CONFIG_FILE);
            if (fileConfig.exists()) {
                reader.readValue(fileConfig);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Data
    public static class Config {
        @JsonMerge
        private Base base;
        @JsonMerge
        private String browser;
        @JsonMerge
        private String remote;
        @JsonMerge
        private Methods methods;
        @JsonMerge
        private ApiBackend apiBackend;
        @JsonMerge
        private Keys keys;
    }

    @Data
    public static class Base {
        @JsonMerge
        private String url;
    }

    @Data
    public static class Methods {
        @JsonMerge
        private String addUser;
    }

    @Data
    public static class ApiBackend {
        @JsonMerge
        private String url;
    }

    @Data
    public static class Keys {
        @JsonMerge
        private String apiKey;
    }
}