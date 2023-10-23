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
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import com.vaadin.flow.component.svg.Svg;

/**
 * Listener interface for listening to mousedown events.
 */
public interface SvgMouseDownListener extends ComponentEventListener<SvgMouseDownListener.SvgMouseDownEvent> {

    /**
     * Represents a mousedown event on a client-side svg element.
     */
    @DomEvent("mousedown")
    class SvgMouseDownEvent extends AbstractSvgEvent {

        private final Double x;
        private final Double y;

        public SvgMouseDownEvent(Svg source, boolean fromClient, @EventData("event.srcElement.id") String id,
                                 @EventData("event.offsetX") Double x, @EventData("event.offsetY") Double y) {
            super(source, fromClient, id);
            this.x = x;
            this.y = y;
        }

        public Double getX() {
            return x;
        }

        public Double getY() {
            return y;
        }
    }
}
