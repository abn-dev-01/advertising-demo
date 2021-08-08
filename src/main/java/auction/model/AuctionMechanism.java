package auction.model;


public enum AuctionMechanism {
    RANK_BY_BID,        // (wj= 1)
    RANK_BY_REVENUE,    // (wj= α1j)
    FIRST_PRICE,        // when the bidder who secures a slot pays their bid amount per click.
    SECOND_PRICE        // when the bidder pays per click the lowest bid necessary to retain his position.
    ;
}
