package com.vaadin.flow.component.svg.elements;

import elemental.json.JsonValue;

/**
 * An enumeration containing the known supported types of svg element supported by the client-side implementation.
 *
 * @see SvgElement#setConstructor(SvgType, JsonValue...)
 */
public enum SvgType {
    RECT, CIRCLE, ELLIPSE, LINE, POLYLINE, POLYGON, PATH, TEXT, IMAGE, GROUP;

    /**
     * Returns the client-side compatible name for an entry in this enum.
     *
     * @return the client-side compatible name for this entry.
     */
    public String getClientSideType() {
        return this.name().toLowerCase().replaceAll("_", "-");
    }
}
