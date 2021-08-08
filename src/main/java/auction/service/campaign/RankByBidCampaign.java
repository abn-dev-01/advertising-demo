package auction.service.campaign;

import auction.exception.CampaignExecutionException;
import auction.model.Advertising;
import auction.service.bidder.BidderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service(RankByBidCampaign.QUALIFIER)
@RequiredArgsConstructor
@Log4j2
public class RankByBidCampaign implements Campaign {

    public static final String QUALIFIER = "rankByBidCampaign";

    // beans
    private final BidderService bidderService;

    @Override
    public List<Advertising> start(Object weight, String keyword, Integer limit) throws CampaignExecutionException {
        // here wj = 1 for each bidder, score = wj * bid[j] - we dont use the `weight` in this Campaign.

        // get bids for given `keyword` sorted by DESC on their Bids 
        var bidders = bidderService.getAdvertisingByKeywordOnBidDesc(keyword);
        LOG.debug("Bidders from a Repository sorted by DESC: {}", () -> bidders);

        var maxSize = limit == null || limit == 0 ? bidders.size() : limit;

        var advertising = bidders.entrySet()
                                 .stream()
                                 .limit(maxSize)
                                 .map(Map.Entry::getValue)
                                 .collect(Collectors.toList());
        LOG.debug("Found Advertising: {}", () -> CollectionUtils.size(advertising));

        return advertising;
    }
}
