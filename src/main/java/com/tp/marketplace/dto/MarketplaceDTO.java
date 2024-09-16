package com.tp.marketplace.dto;

public class MarketplaceDTO {

    private Integer marketplaceId;
    private String marketplaceName;
    private String location;

    // Constructors
    public MarketplaceDTO() {}

    public MarketplaceDTO(Integer marketplaceId, String marketplaceName, String location) {
        this.marketplaceId = marketplaceId;
        this.marketplaceName = marketplaceName;
        this.location = location;
    }

    // Getters and Setters
    public Integer getMarketplaceId() {
        return marketplaceId;
    }

    public void setMarketplaceId(Integer marketplaceId) {
        this.marketplaceId = marketplaceId;
    }

    public String getMarketplaceName() {
        return marketplaceName;
    }

    public void setMarketplaceName(String marketplaceName) {
        this.marketplaceName = marketplaceName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
