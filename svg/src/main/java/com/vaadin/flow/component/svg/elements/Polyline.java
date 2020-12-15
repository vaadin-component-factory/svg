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
package com.vaadin.flow.component.svg.elements;

import java.util.List;

/**
 * Represents a Polyline element.
 */
public class Polyline extends AbstractPolyElement {

    /**
     * Creates a new polyline element with the given id and initial points.
     *
     * @param id     the id of this element
     * @param points the initial points for this element
     */
    public Polyline(String id, List<PolyCoordinatePair> points) {
        super(id, points, SvgType.POLYLINE);
    }

}
