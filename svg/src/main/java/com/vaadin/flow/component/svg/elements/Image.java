/*
 * #%L
 * Vaadin Component Factory Svg Component for Vaadin 14
 * %%
 * Copyright (C) 2017 - 2020 Vaadin Ltd
 * %%
 * This program is available under Commercial Vaadin Add-On License 3.0
 * (CVALv3).
 * 
 * See the file license.html distributed with this software for more
 * information about licensing.
 * 
 * You should have received a copy of the CVALv3 along with this program.
 * If not, see <http://vaadin.com/license/cval-3>.
 * #L%
 */
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
