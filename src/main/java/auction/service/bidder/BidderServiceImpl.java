package auction.service.bidder;

import auction.model.Advertising;
import org.springframework.stereotype.Service;

import java.util.TreeMap;

@Service
public class BidderServiceImpl implements BidderService {
    @Override
    public TreeMap<Float, Advertising> getAdvertisingByKeywordOnBidDesc(String keyword) {
        return null;
    }
}
