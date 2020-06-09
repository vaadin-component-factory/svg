package com.vaadin.flow.component.svg.elements;

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

/**
 * Represents a Rectangle svg element
 */
public class Rect extends SvgElement {

    /**
     * Creates a new Rectangle element with the given id, width and height
     * @param id
     * @param width
     * @param height
     */
    public Rect(String id, double width, double height) {
        super(id);
        setConstructor(SvgType.RECT, val(width), val(height));
    }

    @Override
    public void size(double width, double height) {
        super.size(width, height);
    }
}
