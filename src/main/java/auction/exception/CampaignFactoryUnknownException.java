package auction.exception;

public class CampaignFactoryUnknownException extends RuntimeException {

    public CampaignFactoryUnknownException(String message) {
        super(message);
    }

    public CampaignFactoryUnknownException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampaignFactoryUnknownException(Throwable cause) {
        super(cause);
    }
}
