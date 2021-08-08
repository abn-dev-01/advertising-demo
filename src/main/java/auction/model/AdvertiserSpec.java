package auction.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

/**
 * The advertisers specify a list of triples of keywords, bids and a
 * total maximum budget.
 */
@Data
public class AdvertiserSpec {
    // many-to-one ~ Many advertiser`s specifications per one Advertiser
    private Advertiser advertiser;

    // A map of keyword and his bid, i.e. { `bank` = 0.37, `insurance` = 3.55 } 
    private Map<String, BigDecimal> keywordBid;
    
    // the maximum budget os started campaign.
    private BigDecimal maxBudget;
    
    // Advertising Specification
    private Advertising advertising;
}
