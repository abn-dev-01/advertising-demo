package auction.service.campaign;

import auction.model.AuctionMechanism;

public interface CampaignFactory {
    /**
     * Create Auction Campaign depending on `auctionMechanism`.
     *
     * @param auctionMechanism - is a type of Auction mechanism.
     *
     * @return a {@link Campaign} instance.
     */
    Campaign create(AuctionMechanism auctionMechanism);
}
