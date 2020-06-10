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

import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.SvgElement;
import elemental.json.JsonObject;

/**
 * Listener interface for listening to drag move events.
 * Note, this is potentially a very heavy listener as all move events are sent to the server, use with caution.
 */
public interface SvgDragMoveListener extends ComponentEventListener<SvgDragMoveListener.SvgDragMoveEvent> {

    /**
     * Represents a drag move event on a client-side svg element.
     */
    public static class SvgDragMoveEvent extends AbstractSvgEvent {

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
        public SvgDragMoveEvent(Svg source, boolean fromClient, SvgElement element, JsonObject rawEventData) {
            super(source, fromClient, rawEventData);
            this.element = element;
        }

        /**
         * Returns the svg element where the drag end happened
         *
         * @return the {@link SvgElement} where this event happened
         */
        public SvgElement getElement() {
            return element;
        }
    }
}
