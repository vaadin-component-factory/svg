package com.vaadin.flow.component.svg.elements;


import java.util.List;

/**
 * Represents a Polyline element.
 */
public class Polyline extends AbstractPolyElement {

    /**
     * Creates a new polyline element with the given id and initial points.
     *
     * @param id     the id of this element
     * @param points the initial points for this element
     */
    public Polyline(String id, List<PolyCoordinatePair> points) {
        super(id, points, SvgType.POLYLINE);
    }

}
