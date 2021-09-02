package util;

import java.io.InputStream;

public class ResourceUtil {
    public static InputStream getResourceAsStream(String path)
    {
        var resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
        if (resource == null) {
            throw new RuntimeException(String.format("Could not find %s file in resources dir", path));
        }
        return resource;
    }
}