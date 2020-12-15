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
     * @param source       the source component
     * @param fromClient   <code>true</code> if the event originated from the client
     * @param rawEventData the raw event data for extended use
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
     * @return the raw x value or null if not available
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
     * @return the raw y value or null if not available
     */
    public Double getElementY() {
        if (getRawEventData().hasKey("event.detail.handler.el.node.instance.y()")) {
            return getRawEventData().getNumber("event.detail.handler.el.node.instance.y()");
        }
        return null;
    }
}
