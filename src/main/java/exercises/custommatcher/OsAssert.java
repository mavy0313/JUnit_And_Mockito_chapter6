package exercises.custommatcher;

import org.fest.assertions.*;

public class OsAssert extends GenericAssert<OsAssert, OperatingSystem> {

    public OsAssert(OperatingSystem actual) {
        super(OsAssert.class, actual);
    }

    public static OsAssert assertThat(OperatingSystem actual) {
        return new OsAssert(actual);
    }

    public OsAssert is128bit() {
        isNotNull();
        String errorMessage = String.format(
                "Expected os's bit to be <%s> but was <%s>",
                "128", actual.getNbOfBits());

        Assertions.assertThat(actual.getNbOfBits())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(128);
        return this;
    }

    public OsAssert wasReleasedIn(int year) {
        isNotNull();
        String errorMessage = String.format(
                "Expected os's release year to be <%s> but was <%s>",
                year, actual.getReleaseYear());

        Assertions.assertThat(actual.getReleaseYear())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(year);
        return this;
    }

    public OsAssert hasVersion(String version) {
        isNotNull();
        String errorMessage = String.format(
                "Expected os's version to be <%s> but was <%s>",
                version, actual.getVersion());

        Assertions.assertThat(actual.getVersion())
                .overridingErrorMessage(errorMessage)
                .isEqualTo(version);
        return this;
    }
}
