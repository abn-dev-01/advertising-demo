package auction.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// @Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Advertising {
    private UUID uuid;
    private Advertiser advertiser;
    private String title;
    private String description;
    private String url;
}
