package com.vaadin.flow.component.svg.elements;

/**
 * Represents a SVG image
 */
public class Image extends SvgElement {

    /**
     * Creates a new svg image with the given id and image url
     *
     * @param id       the id for this Image element
     * @param imageUrl the url for the image that should be shown in this Image element
     */
    public Image(String id, String imageUrl) {
        super(id);
        setConstructor(SvgType.IMAGE, val(imageUrl));
    }

    @Override
    public void size(double width, double height) {
        super.size(width, height);
    }

    /**
     * Set the image URL for this Image element.
     *
     * @param imageUrl the url to use for this image
     */
    public void setImageUrl(String imageUrl) {
        setAttribute("image", imageUrl);
    }

    /**
     * Returns the current Image URL for this image.
     *
     * @return the current image url
     */
    public String getImageUrl() {
        return getStringAttribute("image");
    }

}
