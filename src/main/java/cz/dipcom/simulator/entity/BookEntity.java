package cz.dipcom.simulator.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookEntity {
    @Entity
    public class Book {
        @Id
        private Long id;
        @Column(nullable = false)
        private Boolean access_restricted;
        @Column(nullable = false)
        private String title;
        @Column(nullable = false)
        private String description;
        @Column(nullable = false)
        private Boolean digitized;
        @Column(nullable = false)
        private String date;
        @Column(nullable = false)
        private String language;
        @Column(nullable = false)
        private String type;
        @Column(nullable = false)
        private String url;

        @ElementCollection
        private List<String> aka;

        @ElementCollection
        private List<String> contributors;

        @ElementCollection
        private List<String> campaigns;

        @ElementCollection
        private List<String> imageUrls;

        @ElementCollection
        private List<String> mimeTypes;

        @ElementCollection
        private List<String> onlineFormats;

        @ElementCollection
        private List<String> originalFormats;

        @ElementCollection
        private List<String> otherTitles;

        @ElementCollection
        private List<String> partOfCollections;

        @ElementCollection
        private List<String> sites;

        @OneToOne
        private ItemEntity item;

        @OneToMany(mappedBy = "book")
        private List<ResourceEntity> resources;

        @OneToMany(mappedBy = "book")
        private List<SegmentEntity> segments;
        // Getters

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public Boolean getDigitized() {
            return digitized;
        }

        public String getDate() {
            return date;
        }

        public String getLanguage() {
            return language;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public List<String> getAka() {
            return aka;
        }

        public List<String> getContributors() {
            return contributors;
        }

        public List<String> getCampaigns() {
            return campaigns;
        }

        public List<String> getImageUrls() {
            return imageUrls;
        }

        public List<String> getMimeTypes() {
            return mimeTypes;
        }

        public List<String> getOnlineFormats() {
            return onlineFormats;
        }

        public List<String> getOriginalFormats() {
            return originalFormats;
        }

        public List<String> getOtherTitles() {
            return otherTitles;
        }

        public List<String> getPartOfCollections() {
            return partOfCollections;
        }

        public List<String> getSites() {
            return sites;
        }

        public ItemEntity getItem() {
            return item;
        }

        public List<ResourceEntity> getResources() {
            return resources;
        }

        public List<SegmentEntity> getSegments() {
            return segments;
        }

        public Boolean getAccess_restricted() {
            return access_restricted;
        }

        //Setters


        public void setId(Long id) {
            this.id = id;
        }

        public void setAccess_restricted(Boolean access_restricted) {
            this.access_restricted = access_restricted;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public void setDigitized(Boolean digitized) {
            this.digitized = digitized;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setAka(List<String> aka) {
            this.aka = aka;
        }

        public void setContributors(List<String> contributors) {
            this.contributors = contributors;
        }

        public void setCampaigns(List<String> campaigns) {
            this.campaigns = campaigns;
        }

        public void setImageUrls(List<String> imageUrls) {
            this.imageUrls = imageUrls;
        }

        public void setMimeTypes(List<String> mimeTypes) {
            this.mimeTypes = mimeTypes;
        }

        public void setOnlineFormats(List<String> onlineFormats) {
            this.onlineFormats = onlineFormats;
        }

        public void setOriginalFormats(List<String> originalFormats) {
            this.originalFormats = originalFormats;
        }

        public void setOtherTitles(List<String> otherTitles) {
            this.otherTitles = otherTitles;
        }

        public void setPartOfCollections(List<String> partOfCollections) {
            this.partOfCollections = partOfCollections;
        }

        public void setSites(List<String> sites) {
            this.sites = sites;
        }

        public void setItem(ItemEntity item) {
            this.item = item;
        }

        public void setResources(List<ResourceEntity> resources) {
            this.resources = resources;
        }

        public void setSegments(List<SegmentEntity> segments) {
            this.segments = segments;
        }
    }
}
