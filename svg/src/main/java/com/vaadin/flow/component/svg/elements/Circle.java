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
 * Represents a Circle svg element.
 */
public class Circle extends SvgElement {

    /**
     * Creates a Circle element with the given Radius
     *
     * @param id     the unique id of this circle
     * @param radius the radius of this circle
     */
    public Circle(String id, double radius) {
        super(id);
        setConstructor(SvgType.CIRCLE, val(radius * 2));
        setRadius(radius);
    }

    /**
     * Sets the radius of this Circle element.
     *
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        setAttribute("r", radius);
    }

    /**
     * Returns the current radius of this Circle element
     *
     * @return the radius of this circle
     */
    public double getRadius() {
        Number radius = getNumberAttribute("radius");
        return radius != null ? radius.doubleValue() : -1;
    }

    /**
     * Sets the center point of this circle.
     *
     * @param cx the center x coordinate
     * @param cy the center y coordinate
     */
    public void center(double cx, double cy) {
        pushUpdate("center", val(cx), val(cy));
    }

}
