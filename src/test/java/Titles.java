import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public enum Titles {
    SII, ONET, SELENIUM, FILMWEB, KOTUSZKOWO;

    public String getTitle() {
        switch (this) {
            case SII -> {
                return "Rozwiązania i usługi IT, inżynierii i BPO - Sii Polska";
            }
            case ONET -> {
                return "Onet – Jesteś na bieżąco";
            }
            case FILMWEB -> {
                return "Filmweb - filmy takie jak Ty!";
            }
            case SELENIUM -> {
                return "WebDriver | Selenium";
            }
            case KOTUSZKOWO -> {
                return "Kotuszkowo- blog o kotach";
            }
            default -> {
                return null;
            }
        }
    }
}

