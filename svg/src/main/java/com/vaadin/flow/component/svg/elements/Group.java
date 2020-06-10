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

    private List<SvgElement> children = new ArrayList<>();

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
