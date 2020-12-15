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

import java.util.Arrays;

/**
 * Represents a simple svg line
 */
public class Line extends AbstractPolyElement {

    /**
     * Creates a new line element with the given id, initial points and the provided SvgType
     *
     * @param id         the id of this element
     * @param startPoint the initial point for this element
     * @param endPoint   the end point for this element
     */
    public Line(String id, PolyCoordinatePair startPoint, PolyCoordinatePair endPoint) {
        super(id, Arrays.asList(new PolyCoordinatePair[]{startPoint, endPoint}), SvgType.LINE);
    }
}
