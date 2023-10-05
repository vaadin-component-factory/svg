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

import elemental.json.JsonValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a abstract Polygon or Polyline element. This is essentially the
 * common base class for all "point" based lines or objects.
 */
public abstract class AbstractPolyElement extends SvgElement {

    private final List<Polyline.PolyCoordinatePair> coordinatePairs = new ArrayList<>();

    /**
     * Creates a new PolyElement with the given id, initial points and the provided SvgType
     *
     * @param id      the id of this element
     * @param points  the initial points for this poly element
     * @param svgType the type of this poly element (Polygon, Polyline)
     */
    public AbstractPolyElement(String id, List<Polyline.PolyCoordinatePair> points, SvgType svgType) {
        super(id);
        coordinatePairs.addAll(points);
        setConstructor(svgType, convertCoordinatesToJsonString());
        setCoordinatePairs(points);
    }

    /**
     * Sets the coordinate pairs for this Poly element, effectively clearing previous values
     *
     * @param points the points to set
     */
    public void setCoordinatePairs(List<PolyCoordinatePair> points) {
        getCoordinatePairs().clear();
        getCoordinatePairs().addAll(points);
        updatePointsAttribute();
    }

    /**
     * Adds a single point in the last position of the coordinate pairs list.
     *
     * @param point the point to add
     */
    public void addCoordinatePair(PolyCoordinatePair point) {
        getCoordinatePairs().add(point);
        updatePointsAttribute();
    }

    /**
     * Removes a given point from the list of coordinate pairs from this poly element.
     *
     * @param point the point to remove
     */
    public void removeCoordinatePair(PolyCoordinatePair point) {
        getCoordinatePairs().remove(point);
        updatePointsAttribute();
    }

    /**
     * Updates the points attribute based on the current internal coordinate points list
     * in order for the values to eventually be sent to the client side.
     */
    protected void updatePointsAttribute() {
        setAttribute("points", convertCoordinatesToJsonString());
    }

    /**
     * Converts the current coordinate pairs to a JsonString in order to set the attribute
     *
     * @return the Json value of all of the current coordinate pairs
     */
    protected JsonValue convertCoordinatesToJsonString() {
        StringBuilder sb = new StringBuilder();
        getCoordinatePairs().stream().forEach(entry -> sb.append(entry.getPairValueAsString()).append(" "));
        return val(sb.toString());
    }

    /**
     * Returns the current list of coordinate pairs.
     * Note that if this list is modified externally {@link #updatePointsAttribute()}
     * must be called once all updates are done. Additionally in order for the
     * values to actually make it to the client side {@link com.vaadin.flow.component.svg.Svg#update(SvgElement)}
     * must be called with this element as the argument.
     *
     * @return the current internal list of coordinate points
     */
    protected List<PolyCoordinatePair> getCoordinatePairs() {
        return coordinatePairs;
    }

    /**
     * Represents a PolyElement coordinate pair. Since all PolyElements
     * are built based on (x,y) point pairs, this class is the Java-side
     * equivalent for that API. The class is intended to be immutable as
     * there is no mechanism to monitor the values if they are changed
     * after being added.
     */
    public static class PolyCoordinatePair {

        private final double polyX;
        private final double polyY;

        /**
         * Creates a new {@link PolyCoordinatePair} with the given x and y coordinates for this point.
         *
         * @param polyX the x coordinate for this point
         * @param polyY the y coordinate for this point
         */
        public PolyCoordinatePair(double polyX, double polyY) {
            this.polyX = polyX;
            this.polyY = polyY;
        }

        /**
         * Returns the x coordinate for this point.
         *
         * @return the x coordinate for this point.
         */
        public double getPolyX() {
            return polyX;
        }

        /**
         * Returns the y coordinate for this point.
         *
         * @return the y coordinate for this point
         */
        public double getPolyY() {
            return polyY;
        }

        /**
         * Return the values of this {@link PolyCoordinatePair}
         * in a format that can be sent to the client-side.
         *
         * @return the client-side specific way of representing a poly element coordinate pair.
         */
        String getPairValueAsString() {
            return polyX + "," + polyY;
        }
    }
}
