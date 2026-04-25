package data;

import utils.RandomData;

public record NegativeLoginCase(
        String title,
        String language,
        String username,
        String password
) {

    public static NegativeLoginCase emptyCredentials(String language) {
        return new NegativeLoginCase(
                "Empty username and password",
                language,
                "",
                ""
        );
    }

    public static NegativeLoginCase usernameOnly(String language) {
        return new NegativeLoginCase(
                "Username only",
                language,
                RandomData.username(),
                ""
        );
    }

    public static NegativeLoginCase passwordOnly(String language) {
        return new NegativeLoginCase(
                "Password only",
                language,
                "",
                RandomData.password()
        );
    }

    public static NegativeLoginCase invalidCredentials(String language) {
        return new NegativeLoginCase(
                "Invalid username and password",
                language,
                RandomData.username(),
                RandomData.password()
        );
    }

    @Override
    public String toString() {
        return title + " - " + language;
    }
}
