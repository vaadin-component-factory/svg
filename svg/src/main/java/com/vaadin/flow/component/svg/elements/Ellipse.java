package com.vaadin.flow.component.svg.elements;

/**
 * Represents an svg Ellipse element
 */
public class Ellipse extends SvgElement {

    /**
     * Creates a new Ellipse element with the given id, radial X and radial Y values
     *
     * @param id      the id of this ellipsis element
     * @param radialX the radial in the X-axis
     * @param radialY the radial in the Y-axis
     */
    public Ellipse(String id, double radialX, double radialY) {
        super(id);
        setConstructor(SvgType.ELLIPSE, val(radialX), val(radialY));
        setRadialX(radialX);
        setRadialY(radialY);
    }

    /**
     * Returns the radial Y value for this ellipsis.
     *
     * @param radialY the current radial Y for this ellipsis
     */
    public void setRadialY(double radialY) {
        setAttribute("ry", radialY);
    }

    /**
     * Returns the radial X value for this ellipsis.
     *
     * @param radialX the current radial X for this ellipsis
     */
    public void setRadialX(double radialX) {
        setAttribute("rx", radialX);
    }
    /**
     * Sets the center point of this ellipsis.
     *
     * @param cx the center x coordinate
     * @param cy the center y coordinate
     */
    public void center(double cx, double cy) {
        pushUpdate("center", val(cx), val(cy));
    }



}
