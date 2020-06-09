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
         * @param source     the source component
         * @param fromClient <code>true</code> if the event originated from the client
         */
        public SvgDragStartEvent(Svg source, boolean fromClient, SvgElement element, JsonObject rawEventData) {
            super(source, fromClient, rawEventData);
            this.element = element;
        }

        /**
         * Returns the svg element where the drag start happened.
         *
         * @return
         */
        public SvgElement getElement() {
            return element;
        }
    }
}