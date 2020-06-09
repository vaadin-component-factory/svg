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

import java.util.Arrays;

/**
 * Represents a simple svg line
 */
public class Line extends AbstractPolyElement {

    /**
     * Creates a new line element with the given id, initial points and the provided SvgType
     *
     * @param id         the id of this element
     * @param startPoint the initial point for this element
     * @param endPoint   the end point for this element
     */
    public Line(String id, PolyCoordinatePair startPoint, PolyCoordinatePair endPoint) {
        super(id, Arrays.asList(new PolyCoordinatePair[]{startPoint, endPoint}), SvgType.LINE);
    }
}
