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
/**
 * Represents an SVG path
 */
public class Path extends SvgElement {

    /**
     * Defines how the shape of the end of a line should look like.
     */
    public enum LINE_CAP {
        BUTT, ROUND, SQUARE;

        public String getClientSideType() {
            return this.name().toLowerCase().replaceAll("_", "-");
        }
    }

    /**
     * Defines the shape of a line to use at the corners of paths.
     */
    public enum LINE_JOIN {
        ARCS, BEVEL, MITER, MITER_CLIP, ROUND;

        public String getClientSideType() {
            return this.name().toLowerCase().replaceAll("_", "-");
        }
    }

    /**
     * Creates a new path with the given id and initial path
     *
     * @param id   the id of this path
     * @param path the initial path to render
     */
    public Path(String id, String path) {
        super(id);
        setConstructor(SvgType.PATH, val(path));
        setPath(path);
    }

    /**
     * Sets the path for this path element.
     * @param path the path to set
     */
    public void setPath(String path) {
        setAttribute("path", path);
        pushUpdate("plot", val(path));
    }

    /**
     * Returns the path of this element as given (note will not automatically update based on client-side state).
     *
     * @return the path as given for this element
     */
    public String getPath() {
        return getStringAttribute("path");
    }

}
