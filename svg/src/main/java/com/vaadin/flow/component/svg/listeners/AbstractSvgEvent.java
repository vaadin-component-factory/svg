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
package com.vaadin.flow.component.svg.listeners;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.svg.Svg;
import elemental.json.JsonObject;

/**
 * Represents the common parts of SvgEvents like drag start, drag end and drag move.
 */
public class AbstractSvgEvent extends ComponentEvent<Svg> {
    private JsonObject rawEventData;

    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source     the source component
     * @param fromClient <code>true</code> if the event originated from the client
     */
    public AbstractSvgEvent(Svg source, boolean fromClient, JsonObject rawEventData) {
        super(source, fromClient);
        this.rawEventData = rawEventData;
    }

    /**
     * Returns the raw event data that was passed from the client to the server
     *
     * @return the raw event data from the client
     */
    public JsonObject getRawEventData() {
        return rawEventData;
    }

    /**
     * Returns the raw x value of the dragged element or null if not available
     *
     * @return
     */
    public Double getElementX() {
        if (getRawEventData().hasKey("event.detail.handler.el.node.instance.x()")) {
            return getRawEventData().getNumber("event.detail.handler.el.node.instance.x()");
        }
        return null;
    }

    /**
     * Returns the raw x value of the dragged element or null if not available
     *
     * @return
     */
    public Double getElementY() {
        if (getRawEventData().hasKey("event.detail.handler.el.node.instance.y()")) {
            return getRawEventData().getNumber("event.detail.handler.el.node.instance.y()");
        }
        return null;
    }
}
