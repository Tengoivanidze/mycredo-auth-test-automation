package data;

public final class AuthTestData {

    private static final String[] SUPPORTED_LANGUAGES = {
            "ქართული",
            "მეგრული",
            "სვანური"
    };

    private AuthTestData() {
    }

    public static String[] supportedLanguages() {
        return SUPPORTED_LANGUAGES.clone();
    }
}
