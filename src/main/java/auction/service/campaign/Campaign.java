package auction.service.campaign;

import auction.exception.CampaignExecutionException;
import auction.model.Advertising;

import java.util.List;

public interface Campaign {
    /**
     * Start an Auction Campaign.
     *
     * @param weight  of each Advertiser. Is an initial argument.
     * @param keyword is a search keyword
     * @param limit   means how much records returns, o or null is unlimited.
     *
     * @return true when Campaign is started.
     */
    List<Advertising> start(Object weight, String keyword, Integer limit) throws CampaignExecutionException;
}
