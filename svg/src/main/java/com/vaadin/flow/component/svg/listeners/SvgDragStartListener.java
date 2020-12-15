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

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.SvgElement;
import elemental.json.JsonObject;

/**
 * Listener interface for listening to drag start events.
 */
public interface SvgDragStartListener extends ComponentEventListener<SvgDragStartListener.SvgDragStartEvent> {


    /**
     * Represents a drag start event on a client-side svg element.
     */
    public static class SvgDragStartEvent extends AbstractSvgEvent {

        private SvgElement element;

        /**
         * Creates a new event using the given source and indicator whether the
         * event originated from the client side or the server side.
         *
         * @param source       the source component
         * @param fromClient   <code>true</code> if the event originated from the client
         * @param element      the element where this event happened
         * @param rawEventData the raw event data for extended use
         */
        public SvgDragStartEvent(Svg source, boolean fromClient, SvgElement element, JsonObject rawEventData) {
            super(source, fromClient, rawEventData);
            this.element = element;
        }

        /**
         * Returns the svg element where the drag start happened.
         *
         * @return the {@link SvgElement} where this event happened
         */
        public SvgElement getElement() {
            return element;
        }
    }
}
