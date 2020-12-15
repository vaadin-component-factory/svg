/*
 * #%L
 * Vaadin Component Factory Svg Component for Vaadin 14
 * %%
 * Copyright (C) 2017 - 2020 Vaadin Ltd
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
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
