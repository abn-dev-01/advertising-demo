package auction.service;

import auction.model.Advertiser;
import auction.model.Advertising;
import auction.model.AuctionMechanism;
import auction.service.bidder.BidderService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.UUID;

@SpringBootTest
@Log4j2
class AuctionServiceTest {

    @Autowired
    private AuctionService auctionService;

    @MockBean
    private BidderService bidderService;

    TreeMap<Float, Advertising> mockReturnAdvertising = new TreeMap<>();
    Advertiser advertiser1;
    Advertiser advertiser2;
    Advertiser advertiser3;

    @BeforeEach
    void setUp() {
        advertiser1 = Advertiser.builder().id(1).name("adv1").build();
        advertiser2 = Advertiser.builder().id(2).name("adv2").build();
        advertiser3 = Advertiser.builder().id(3).name("adv3").build();

        mockReturnAdvertising = new TreeMap<>((o1, o2) -> 01 > 02 ? 1 : -1);
        var uuid_ = "123e4567-e89b-12d3-a456-55664244000";
        mockReturnAdvertising.put(1.0f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "1"))
                                                   .advertiser(advertiser1)
                                                   .build());
        mockReturnAdvertising.put(1.1f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "1"))
                                                   .advertiser(advertiser1)
                                                   .build());

        mockReturnAdvertising.put(1.2f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "2"))
                                                   .advertiser(advertiser2)
                                                   .build());
        mockReturnAdvertising.put(1.3f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "3"))
                                                   .advertiser(advertiser3)
                                                   .build());

        mockReturnAdvertising.put(2.0f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "1"))
                                                   .advertiser(advertiser1)
                                                   .build());
        mockReturnAdvertising.put(2.1f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "1"))
                                                   .advertiser(advertiser1)
                                                   .build());
        mockReturnAdvertising.put(2.2f, Advertising.builder()
                                                   .uuid(UUID.fromString(uuid_ + "1"))
                                                   .advertiser(advertiser1)
                                                   .build());
    }

    @Test
    @DisplayName("Test RANK BY BID")
    void start() {
        var weight = 1.0f;
        var givenAuctionMechanism = AuctionMechanism.RANK_BY_BID;
        List<Advertising> result = Collections.EMPTY_LIST;
        var givenKeyword = "invest";

        // mocks

        when(bidderService.getAdvertisingByKeywordOnBidDesc(givenKeyword))
            .thenReturn(mockReturnAdvertising);

        try {
            result = auctionService.startAuction(weight, givenAuctionMechanism, givenKeyword);
        } catch (Exception e) {
            // i want to see details of the exception...
            LOG.error("Test failed.", e);
        }
        Assertions.assertFalse(result.isEmpty(), "Unexpected result.");
        Assertions.assertEquals(mockReturnAdvertising.size(), result.size(), "Unexpected result count.");

        var it = result.iterator();
        var next = it.next();
        Assertions.assertEquals(next.getAdvertiser(), advertiser1, "Unexpected advertiser (1).");
        next = it.next();
        Assertions.assertEquals(next.getAdvertiser(), advertiser1, "Unexpected advertiser (2).");
        next = it.next();
        Assertions.assertEquals(next.getAdvertiser(), advertiser1, "Unexpected advertiser (3).");
        next = it.next();
        Assertions.assertEquals(next.getAdvertiser(), advertiser3, "Unexpected advertiser (4).");
    }
}
