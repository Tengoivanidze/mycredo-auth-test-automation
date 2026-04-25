package data;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.function.Function;

public final class AuthDataProvider {

    private AuthDataProvider() {
    }

    @DataProvider(name = "emptyCredentialsCases")
    public static Object[][] emptyCredentialsCases() {
        return cases(NegativeLoginCase::emptyCredentials);
    }

    @DataProvider(name = "usernameOnlyCases")
    public static Object[][] usernameOnlyCases() {
        return cases(NegativeLoginCase::usernameOnly);
    }

    @DataProvider(name = "passwordOnlyCases")
    public static Object[][] passwordOnlyCases() {
        return cases(NegativeLoginCase::passwordOnly);
    }

    @DataProvider(name = "invalidCredentialsCases")
    public static Object[][] invalidCredentialsCases() {
        return cases(NegativeLoginCase::invalidCredentials);
    }

    private static Object[][] cases(Function<String, NegativeLoginCase> caseFactory) {
        return Arrays.stream(AuthTestData.supportedLanguages())
                .map(language -> new Object[]{caseFactory.apply(language)})
                .toArray(Object[][]::new);
    }
}
