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
         * @param source     the source component
         * @param fromClient <code>true</code> if the event originated from the client
         */
        public SvgDragMoveEvent(Svg source, boolean fromClient, SvgElement element, JsonObject rawEventData) {
            super(source, fromClient, rawEventData);
            this.element = element;
        }

        /**
         * Returns the svg element where the drag end happened
         *
         * @return
         */
        public SvgElement getElement() {
            return element;
        }
    }
}