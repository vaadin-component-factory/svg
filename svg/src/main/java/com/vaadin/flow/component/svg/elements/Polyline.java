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
