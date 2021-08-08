package auction.exception;

/**
 * it is a common class for Campaign execution.
 */
public class CampaignExecutionException extends RuntimeException {

    public CampaignExecutionException(String message) {
        super(message);
    }

    public CampaignExecutionException(String message, Throwable cause) {
        super(message, cause);
    }

    public CampaignExecutionException(Throwable cause) {
        super(cause);
    }
}
