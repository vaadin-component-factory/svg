package com.vaadin.flow.component.svg.elements;

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

import com.vaadin.flow.component.Unit;

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
        Number radius = getNumberAttribute("r");
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

    @Override
    public void setPosition(double x, double y, Unit unit) {
        setAttribute("cx", x + unit.getSymbol());
        setAttribute("cy", y + unit.getSymbol());
    }

}
