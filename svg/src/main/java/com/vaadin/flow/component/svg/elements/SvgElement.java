package com.vaadin.flow.component.svg.elements;

import elemental.json.*;

import java.util.Objects;

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

/**
 * This is the base class for all the Svg elements and contains the attributes
 * as they were given to the client as well as any pending complex updates to
 * be sent.
 */
public abstract class SvgElement {

    private String id;

    private JsonObject attributes;
    // These are for more complex updates than single
    // attribute changes where the client-side has to
    // do calculations based on its current actual
    // state. For instance a "move" is relative to the
    // "current x,y", hence the update needs to call a
    // function on the client-side with specific values.
    private JsonArray updates;

    /**
     * Creates a new SvgElement with the given id
     *
     * @param id the id for this element, never null
     */
    public SvgElement(String id) {
        Objects.nonNull(id);
        setAttributes(Json.createObject());
        setUpdates(Json.createArray());
        setId(id);
    }

    /**
     * Moves the given element within the viewbox with the
     * relative values provided. I.e. the values given
     * represent a move frm the current position, not
     * absolute values.
     *
     * @param x the amount this element should move in the x-axis
     * @param y the amount this element should move in the y-axis
     */
    public void move(double x, double y) {
        pushUpdate("move", val(x), val(y));
    }

    /**
     * Flips the component in relation to the axis given. I.e.
     * <code>flip("x")</code> will flip the component relative
     * to the x-axis while <code>flip("y")</code> will flip the
     * component relative to the y-axis.
     *
     * @param axis the axis that the component flip should be measured against
     */
    public void flip(String axis) {
        pushUpdate("flip", val(axis));
    }

    /**
     * Rotates the component with the amount given in the angle.
     * For instance <code>rotate(90)</code> will rotate the component 90 degrees.
     *
     * @param angle the angle amount to rotate
     */
    public void rotate(double angle) {
        pushUpdate("rotate", val(angle));
    }

    /**
     * Returns the internal attributes JsonObject. This is primarily
     * intended as an internal method and does not include any
     * protections or logic to track changes. I.e. a developer
     * can fetch the array and make any changes or add attributes,
     * however it is recommended to use the approapriate public API
     * for this or extend the element and add proper public API if
     * customizations are needed.
     *
     * @return the actual attributes map for this {@link SvgElement}
     */
    public JsonObject toJson() {
        return getAttributes();
    }


    /**
     * Returns the id of this {@link SvgElement}
     *
     * @return the id of this element, should never be null
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of this element, should never be null.
     *
     * @param id the id of this element
     */
    protected void setId(String id) {
        Objects.requireNonNull(id);
        getAttributes().put("id", id);
        this.id = id;
    }

    /**
     * Sets the draggable flag for this element.
     *
     * @param draggable true if this element should be draggable, false otherwise
     */
    public void setDraggable(boolean draggable) {
        getAttributes().put("draggable", draggable);
    }

    /**
     * Returns the current draggable flag for this element as last given.
     *
     * @return true if the element should be draggable, false otherwise
     */
    public boolean isDraggable() {
        if (getAttributes().hasKey("draggable")) {
            return getAttributes().getBoolean("draggable");
        }
        return false;
    }

    /**
     * Sets the fill color of this element.
     *
     * @param color the color to use for filling the element
     */
    public void setFillColor(String color) {
        setAttribute("fill", color);
    }

    /**
     * Returns the current fill color of this element
     *
     * @return the current fill color
     */
    public String getFillColor() {
        return getStringAttribute("fill");
    }

    /**
     * Sets the stroke for this element.
     *
     * @param color the color used for the stroke, never null
     * @param width the width of this stroke
     * @see #setStroke(String, int, Path.LINE_CAP, Path.LINE_JOIN)
     */
    public void setStroke(String color, int width) {
        setStroke(color, width, null, null);
    }

    /**
     * Sets the stroke for this element.
     *
     * @param color    the color used for the stroke, never null
     * @param width    the width of this stroke
     * @param lineCap  the optional {@link Path.LINE_CAP} for this element
     * @param lineJoin the optional {@link Path.LINE_JOIN} for this element
     */
    public void setStroke(String color, int width, Path.LINE_CAP lineCap, Path.LINE_JOIN lineJoin) {
        Objects.nonNull(color);
        setAttribute("stroke", color);
        setAttribute("stroke-width", width);

        if (lineCap != null) {
            setAttribute("stroke-linecap", val(lineCap.getClientSideType()));
        }

        if (lineJoin != null) {
            setAttribute("stroke-linejoin", val(lineJoin.getClientSideType()));
        }
    }

    /**
     * Returns the pending updates for this element
     *
     * @return the array with pending updates
     */
    protected JsonArray getUpdates() {
        return updates;
    }

    /**
     * Internal method for setting the updates array.
     */
    protected void setUpdates() {
        JsonArray updates = Json.createArray();
        getAttributes().put("__updates", updates);
        this.updates = updates;
    }

    /**
     * Sets the given updates array to the attributes in preparation for sending it to the client-side.
     *
     * @param updates the updates array to set
     */
    protected void setUpdates(JsonArray updates) {
        getAttributes().put("__updates", updates);
        this.updates = updates;
    }

    /**
     * Returns the full set of attributes for this element.
     *
     * @return the internal attributes array for this element
     */
    JsonObject getAttributes() {
        return attributes;
    }

    /**
     * Sets the internal attributes array.
     *
     * @param attributes the array to set
     */
    protected void setAttributes(JsonObject attributes) {
        this.attributes = attributes;
    }

    /**
     * Sets the constructor value for the client side as well as the initial arguments list.
     * This is specific for the client-side svg.js implementation where the client-side
     * element will be instantiated with a specific consturctor and arguments list.
     *
     * @param type the constructor to call, known suitable values available in the
     *             {@link SvgType} enumeration.
     * @param args the initial constructor arguments to pass
     */
    protected void setConstructor(SvgType type, JsonValue... args) {
        assert type != null;
        getAttributes().put("__constructor", type.getClientSideType());
        getAttributes().put("__constructorArgs", createArgArray(args));
    }

    /**
     * Creates a Json array based on the provided Json values
     *
     * @param args the values to put into the array, never null
     * @return
     */
    protected static JsonArray createArgArray(JsonValue... args) {
        Objects.requireNonNull(args);
        JsonArray argsArray = Json.createArray();
        for (JsonValue arg : args) {
            argsArray.set(argsArray.length(), arg);
        }
        return argsArray;
    }

    /**
     * Creates a more complex update call where a specific client-side method
     * needs to be called with arguments in order to perform a client-side update.
     *
     * @param name the name of the client-side method to call
     * @param args the arguments to pass to the client-side method
     * @see #move(double, double)  as an example
     */
    protected void pushUpdate(String name, JsonValue... args) {
        JsonArray argArray = createArgArray(args);
        JsonObject update = Json.createObject();
        update.put("function", name);
        update.put("args", argArray);
        getUpdates().set(getUpdates().length(), update);
        setAttribute("__updates", getUpdates());
    }

    /**
     * Convenience method for converting a double to a JsonNumber.
     *
     * @param value the value to convert
     * @return the converted JsonNumber
     */
    protected static JsonNumber val(double value) {
        return Json.create(value);
    }

    /**
     * Convenience method for converting a Java String to a JsonString
     *
     * @param value the string to convert
     * @return the converted JsonString
     */
    protected static JsonString val(String value) {
        return Json.create(value);
    }

    /**
     * Convenience method for converting a Java Boolean to a JsonBoolean.
     *
     * @param value the boolean to convert
     * @return the converted JsonBoolean
     */
    protected static JsonBoolean val(Boolean value) {
        return Json.create(value);
    }

    /**
     * Sets the size of a SvgElement. Not all Svg components handle size in the same way,
     * hence this API is protected until the actual component exposes it publicly if it's applicable.
     *
     * @param width  the width of the svg element
     * @param height the height of the svg element
     */
    protected void size(double width, double height) {
        pushUpdate("size", val(width), val(height));
    }


    /**
     * Convenience method for setting a string attribute.
     *
     * @param key   the key to set
     * @param value the Java String value to set
     */
    protected void setAttribute(String key, String value) {
        setAttribute(key, val(value));
    }

    /**
     * Convenience methtod for setting a Java Boolean.
     *
     * @param key   the key to set
     * @param value the boolean value to set
     */
    protected void setAttribute(String key, boolean value) {
        setAttribute(key, val(value));
    }

    /**
     * Convenience mehtod for setting a Java number attribute.
     * Note that the number will be converted to a double before conversion.
     *
     * @param key   the key to set
     * @param value the value to convert
     */
    protected void setAttribute(String key, Number value) {
        if (value != null) {
            setAttribute(key, val(value.doubleValue()));
        } else {
            setAttribute(key, (JsonValue) null);
        }
    }

    /**
     * Maps a Json value to a key in the internal attributes array.
     *
     * @param key   the key to set
     * @param value the value to set
     */
    protected void setAttribute(String key, JsonValue value) {
        getAttributes().put(key, value);
    }

    /**
     * Retrns a value from the internal attributes map
     *
     * @param key the key to fetch
     * @return the value or null if not present
     */
    protected Object getAttribute(String key) {
        if (getAttributes().hasKey(key)) {
            return getAttributes().get(key);
        }

        return null;
    }

    /**
     * Convenience mehtod for getting a String attribute from the internal array.
     *
     * @param key the key to fetch
     * @return the String value or null if not set.
     */
    protected String getStringAttribute(String key) {
        if (getAttributes().hasKey(key)) {
            return getAttributes().getString(key);
        }
        return null;
    }

    /**
     * Convenience method for getting a Boolean attribute.
     *
     * @param key the key to fetch
     * @return the value or null if none set.
     */
    protected Boolean getBooleanAttribute(String key) {
        if (getAttributes().hasKey(key)) {
            return getAttributes().getBoolean(key);
        }

        return null;
    }

    /**
     * Convenience method for fetching a number attribute from the internal array.
     *
     * @param key the key to fetch
     * @return the value or null if none set
     */
    protected Number getNumberAttribute(String key) {
        if (getAttributes().hasKey(key)) {
            return getAttributes().getNumber(key);
        }
        return null;
    }

}
