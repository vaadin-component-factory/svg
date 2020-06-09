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
