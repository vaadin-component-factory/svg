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
