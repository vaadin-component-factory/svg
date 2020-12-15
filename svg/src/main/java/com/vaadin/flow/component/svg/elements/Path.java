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
/**
 * Represents an SVG path
 */
public class Path extends SvgElement {

    /**
     * Defines how the shape of the end of a line should look like.
     */
    public enum LINE_CAP {
        BUTT, ROUND, SQUARE;

        public String getClientSideType() {
            return this.name().toLowerCase().replaceAll("_", "-");
        }
    }

    /**
     * Defines the shape of a line to use at the corners of paths.
     */
    public enum LINE_JOIN {
        ARCS, BEVEL, MITER, MITER_CLIP, ROUND;

        public String getClientSideType() {
            return this.name().toLowerCase().replaceAll("_", "-");
        }
    }

    /**
     * Creates a new path with the given id and initial path
     *
     * @param id   the id of this path
     * @param path the initial path to render
     */
    public Path(String id, String path) {
        super(id);
        setConstructor(SvgType.PATH, val(path));
        setPath(path);
    }

    /**
     * Sets the path for this path element.
     * @param path the path to set
     */
    public void setPath(String path) {
        setAttribute("path", path);
        pushUpdate("plot", val(path));
    }

    /**
     * Returns the path of this element as given (note will not automatically update based on client-side state).
     *
     * @return the path as given for this element
     */
    public String getPath() {
        return getStringAttribute("path");
    }

}
