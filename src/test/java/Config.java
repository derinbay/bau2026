import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    // prevent crashing if it's missing
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public static String getTrendyolEmail() {
        return get("TRENDYOL_EMAIL");
    }

    public static String getTrendyolPassword() {
        return get("TRENDYOL_PASSWORD");
    }

    private static String get(String key) {
        // fetch from env
        String value = dotenv.get(key);
        
        // if not present in env, try system environment variables
        if (value == null || value.isEmpty()) {
            value = System.getenv(key);
        }
        
        if (value == null) {
            throw new RuntimeException("config key named '" + key + "' not found in anywhere.");
        }
        return value;
    }
}
