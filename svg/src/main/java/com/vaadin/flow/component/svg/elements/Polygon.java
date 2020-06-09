package com.vaadin.flow.component.svg.elements;

import java.util.List;

/**
 * Represents a Svg Polygon element.
 */
public class Polygon extends AbstractPolyElement {

    /**
     * Creates a new Polygon element with the given id and initial points
     *
     * @param id     the id for this element
     * @param points the inital points for this element
     */
    public Polygon(String id, List<PolyCoordinatePair> points) {
        super(id, points, SvgType.POLYGON);
    }

}
