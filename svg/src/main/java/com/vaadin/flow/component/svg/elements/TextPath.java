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
 * Represents an SVG textPath element.
 */
public class TextPath extends SvgElement {

    /**
     * Creates a new TextPath element with the given href and text.
     *
     * @param href path id to which this textPath is linked
     * @param text the text to display
     */
    public TextPath(String href, String text) {
        super("textpath-" + href);
        setConstructor(SvgType.TEXT_PATH, val(text));
        this.setAttribute("href", "#" + href);
        this.setAttribute("dominant-baseline", "text-after-edge");
    }

    /**
     * Set an offset from the start of the path for the initial current text position along the path.
     *
     * @param offset could be a number or a percentage
     */
    public void setStartOffset(String offset) {
        this.setAttribute("startOffset", offset);
    }

    /**
     * The baseline-shift attribute allows repositioning of the dominant-baseline
     * relative to the dominant-baseline of the parent text content element.
     *
     * @param offset could be a number or a percentage
     */
    public void setBaselineShift(String offset) {
        this.setAttribute("baseline-shift", offset);
    }

    /**
     * Sets the font size of this textPath element, this can be in absolute (px) or relative (ex: em, ex) values.
     *
     * @param fontSize the font size to use
     */
    public void setFontSize(String fontSize) {
        setAttribute("font-size", fontSize);
    }
}
