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
 * Represents an SVG text element.
 */
public class Text extends SvgElement {

    /**
     * Creates a new Text element with the given id and text.
     *
     * @param id   the id for this text element
     * @param text the text to show for this text element
     */
    public Text(String id, String text) {
        super(id);
        setConstructor(SvgType.TEXT, val(text));
        setText(text);
    }

    /**
     * Sets the visible text for this Text element.
     *
     * @param text the text to show
     */
    public void setText(String text) {
        setAttribute("text", text);
    }

    /**
     * Returns the current text on this text element.
     *
     * @return the current text on this text element.
     */
    public String getText() {
        return getStringAttribute("text");
    }

    /**
     * Sets the font family to use for this Text element.
     * Note that the browser must support the font that is specified here.
     * <p>
     * This attribute can have multiple values (i.e. webfonts with fallback)
     * for instance: setFontFamily("'Roboto', 'Noto', sans-serif");
     *
     * @param fontFamily the font family to use for this text element.
     */
    public void setFontFamily(String fontFamily) {
        setAttribute("font-family", fontFamily);
    }

    /**
     * Returns the current font family used for this Text element.
     *
     * @return the current font family
     */
    public String getFontFamily() {
        return getStringAttribute("font-family");
    }

    /**
     * Sets the font size of this text element, this can be in absolute (px) or relative (ex: em, ex) values.
     *
     * @param fontSize the font size to use
     */
    public void setFontSize(String fontSize) {
        setAttribute("font-size", fontSize);
    }

    /**
     * Returns the font size for this text element.
     *
     * @return the font size or null if none set
     */
    public String getFontSize() {
        return getStringAttribute("font-size");
    }


}
