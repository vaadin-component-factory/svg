package com.vaadin.flow.component.svg.elements;

import java.util.Objects;

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
