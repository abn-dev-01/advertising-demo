package auction.service.bidder;

import auction.model.Advertising;
import org.springframework.stereotype.Component;

import java.util.TreeMap;

@Component
// Actually it is a @Repository in the Future implementation
public interface BidderService {

    /**
     * Found {@link auction.model.Advertising} by given `keyword`.
     *
     * @param keyword is a keyword
     *
     * @return A Map of {@link auction.model.Advertising} sorted by Bids by DESCENDING.
     */
    TreeMap<Float, Advertising> getAdvertisingByKeywordOnBidDesc(String keyword);
}
