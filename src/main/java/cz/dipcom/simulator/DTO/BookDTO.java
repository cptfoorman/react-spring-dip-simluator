package cz.dipcom.simulator.DTO;


import java.time.LocalDateTime;
import java.util.List;

public class BookDTO {
    private Long id;
    private Boolean access_restricted;
    private String title;
    private String description;
    private Boolean digitized;
    private LocalDateTime date;
    private String language;
    private String type;
    private String url;

    private List<String> aka;
    private List<String> contributors;
    private List<String> campaigns;
    private List<String> imageUrls;
    private List<String> mimeTypes;
    private List<String> onlineFormats;
    private List<String> originalFormats;
    private List<String> otherTitles;
    private List<String> partOfCollections;
    private List<String> sites;

    private ItemDTO item;
    private List<ResourceDTO> resources;
    private List<SegmentDTO> segments;


    // Constructors,

    public BookDTO(Long id,
                   Boolean access_restricted,
                   String title, String description,
                   Boolean digitized,
                   LocalDateTime date,
                   String language,
                   String type,
                   String url,
                   List<String> aka,
                   List<String> contributors,
                   List<String> campaigns,
                   List<String> imageUrls,
                   List<String> mimeTypes,
                   List<String> onlineFormats,
                   List<String> originalFormats,
                   List<String> otherTitles,
                   List<String> partOfCollections,
                   List<String> sites,
                   ItemDTO item, List<ResourceDTO> resources, List<SegmentDTO> segments) {
        this.id = id;
        this.access_restricted = access_restricted;
        this.title = title;
        this.description = description;
        this.digitized = digitized;
        this.date = date;
        this.language = language;
        this.type = type;
        this.url = url;
        this.aka = aka;
        this.contributors = contributors;
        this.campaigns = campaigns;
        this.imageUrls = imageUrls;
        this.mimeTypes = mimeTypes;
        this.onlineFormats = onlineFormats;
        this.originalFormats = originalFormats;
        this.otherTitles = otherTitles;
        this.partOfCollections = partOfCollections;
        this.sites = sites;
        this.item = item;
        this.resources = resources;
        this.segments = segments;
    }

    public BookDTO() {
    }
    // Getters

    public Long getId() {
        return id;
    }

    public Boolean getAccess_restricted() {
        return access_restricted;
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

    public LocalDateTime getDate() {
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

    public ItemDTO getItem() {
        return item;
    }

    public List<ResourceDTO> getResources() {
        return resources;
    }

    public List<SegmentDTO> getSegments() {
        return segments;
    }

    // Setters

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

    public void setDate(LocalDateTime date) {
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

    public void setItem(ItemDTO item) {
        this.item = item;
    }

    public void setResources(List<ResourceDTO> resources) {
        this.resources = resources;
    }

    public void setSegments(List<SegmentDTO> segments) {
        this.segments = segments;
    }
}
