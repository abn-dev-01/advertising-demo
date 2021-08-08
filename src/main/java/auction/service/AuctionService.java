package auction.service;

import auction.model.Advertising;
import auction.model.AuctionMechanism;
import auction.service.campaign.CampaignFactory;
import auction.service.campaign.Campaign;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This performs running Auction.
 */
@Service
@RequiredArgsConstructor
public class AuctionService {
    // beans
    private final CampaignFactory campaignFactory;

    private Campaign campaign;

    public List<Advertising> startAuction(
        final float weight,
        final AuctionMechanism auctionMechanism,
        final String keyword
    ) {
        campaign = campaignFactory.create(auctionMechanism);
        var limit = 10;

        return campaign.start(weight, keyword, limit);
    }
}
