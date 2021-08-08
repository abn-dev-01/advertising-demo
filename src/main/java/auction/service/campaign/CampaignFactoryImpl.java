package auction.service.campaign;

import auction.exception.CampaignFactoryUnknownException;
import auction.model.AuctionMechanism;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Log4j2
@RequiredArgsConstructor
public class CampaignFactoryImpl implements CampaignFactory {

    @Qualifier(RankByBidCampaign.QUALIFIER)
    private final Campaign rankByBidCampaign;

    @Override
    public Campaign create(AuctionMechanism auctionMechanism) {
        Campaign factory;
        switch (auctionMechanism) {
            case RANK_BY_BID:
                factory = rankByBidCampaign;
                break;
            case RANK_BY_REVENUE:
                throw new NotImplementedException("RANK_BY_REVENUE not implemented yet");
//                break;
            case FIRST_PRICE:
                throw new NotImplementedException("FIRST_PRICE not implemented yet");
//                break;
            case SECOND_PRICE:
                throw new NotImplementedException("SECOND_PRICE not implemented yet");
//                break;
            default:
                throw new CampaignFactoryUnknownException("Unknown campaign: `" + auctionMechanism + "`");
        }
        return factory;
    }
}
