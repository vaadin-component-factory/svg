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

import elemental.json.Json;
import elemental.json.JsonArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Represents a grouping of svg elements.
 */
public class Group extends SvgElement {

    private final List<SvgElement> children = new ArrayList<>();

    /**
     * Creates a new group with the given id
     *
     * @param id the id of this group, never null
     */
    public Group(String id) {
        super(id);
        setConstructor(SvgType.GROUP);
    }

    /**
     * Adds a new child to this group.
     *
     * @param elements the elements to add, never null
     */
    public void addElements(SvgElement... elements) {
        Objects.requireNonNull(elements);
        children.addAll(Arrays.asList(elements));
        updateChildrenAttribute();
    }

    /**
     * Adds a new child to this group.
     *
     * @param element the element to add, never null
     */
    public void addElement(SvgElement element) {
        Objects.requireNonNull(element);
        if (!children.contains(element)) {
            children.add(element);
            updateChildrenAttribute();
        }
    }

    /**
     * Removes a child from this group.
     * If the child does not already exist in this group, nothing will be done.
     *
     * @param element the child to remove, never null
     */
    public void removeElement(SvgElement element) {
        Objects.requireNonNull(element);
        if (children.contains(element)) {
            children.remove(element);
            updateChildrenAttribute();
        }
    }

    protected void updateChildrenAttribute() {
        JsonArray jsonArray = Json.createArray();
        for (int i = 0; i < children.size(); i++) {
            jsonArray.set(i, val(children.get(i).getId()));
        }
        setAttribute("__elements", jsonArray);
    }
}
