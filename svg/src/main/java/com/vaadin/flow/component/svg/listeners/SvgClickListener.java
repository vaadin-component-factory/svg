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
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.Circle;
import com.vaadin.flow.component.svg.elements.SvgElement;
import elemental.json.JsonObject;

/**
 * Listener interface for listening to drag start events.
 */
public interface SvgClickListener extends ComponentEventListener<SvgClickListener.SvgClickEvent> {


    /**
     * Represents a drag start event on a client-side svg element.
     */
    @DomEvent("click")
    class SvgClickEvent extends ComponentEvent<Svg> {

        private SvgElement element;

        /**
         * Creates a new event using the given source and indicator whether the
         * event originated from the client side or the server side.
         *
         * @param source       the source component
         * @param fromClient   <code>true</code> if the event originated from the client
         */
        public SvgClickEvent(Svg source, boolean fromClient,  @EventData("event.srcElement.id") String id) {
            super(source, fromClient);
            if (id != null && !id.isEmpty()) {
                element = source.getSvgElements().stream().filter(element -> id.equals(element.getId())).findFirst().orElse(null);
            } else {
                element = null;
            }
        }

        /**
         * Returns the svg element where the click happened
         * Can be null if the user is not clicking in an element
         *
         * @return the {@link SvgElement} where this event happened
         */
        public SvgElement getElement() {
            return element;
        }
    }
}
