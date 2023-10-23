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
import com.vaadin.flow.component.svg.elements.SvgElement;

public class AbstractSvgEvent extends ComponentEvent<Svg> {

    private final SvgElement svgElement;

    public AbstractSvgEvent(Svg source, boolean fromClient, String id) {
        super(source, fromClient);
        if (id != null && !id.isEmpty()) {
            svgElement = source.getSvgElements().stream().filter(element -> id.equals(element.getId())).findFirst().orElse(null);
        } else {
            svgElement = null;
        }
    }

    /**
     * Returns the svg element where the click happened
     * Can be null if the user is not clicking in an element
     *
     * @return the {@link SvgElement} where this event happened
     */
    public SvgElement getElement() {
        return svgElement;
    }
}
