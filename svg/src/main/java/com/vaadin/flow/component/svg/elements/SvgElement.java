package com.vaadin.flow.component.svg.elements;

import elemental.json.*;

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

public abstract class SvgElement {

  private JsonObject attributes;
  private JsonArray updates;
  private String id;

  public SvgElement(String id) {
    setAttributes(Json.createObject());
    setUpdates(Json.createArray());
    setId(id);
  }

  public void move(double x, double y) {
    pushUpdate("move", val(x), val(y));
  }

  public void center(double cx, double cy) {
    pushUpdate("center", val(cx), val(cy));
  }

  public void size(double width) {
    pushUpdate("size", val(width));
  }

  public void size(double width, double height) {
    pushUpdate("size", val(width), val(height));
  }

  public void attr(String name, double value) {
    JsonObject update = Json.createObject();
    update.put(name, value);
    pushUpdate("attr", update);
  }

  public void attr(String name, String value) {
    JsonObject update = Json.createObject();
    update.put(name, value);
    pushUpdate("attr", update);
  }

  public void attr(String name, Boolean value) {
    JsonObject update = Json.createObject();
    update.put(name, value);
    pushUpdate("attr", update);
  }

  public JsonObject toJson() {
    return getAttributes();
  }

  public void setConstructor(String type, JsonValue... args) {
    getAttributes().put("__constructor", type);
    getAttributes().put("__constructorArgs", createArgArray(args));
  }

  public void setAttr(String name, JsonValue value) {
    getAttributes().put(name, value);
  }

  public static JsonArray createArgArray(JsonValue... args) {
    JsonArray argsArray = Json.createArray();
    for (JsonValue arg : args) {
      argsArray.set(argsArray.length(), arg);
    }
    return argsArray;
  }

  public void pushUpdate(String name, JsonValue... args) {
    JsonArray argArray = createArgArray(args);
    JsonObject update = Json.createObject();
    update.put("function", name);
    update.put("args", argArray);
    getUpdates().set(getUpdates().length(), update);
    setAttr("__updates", getUpdates());
  }

  public static JsonNumber val(double value) {
    return Json.create(value);
  }

  public static JsonString val(String value) {
    return Json.create(value);
  }

  public static JsonBoolean val(Boolean value) {
    return Json.create(value);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    getAttributes().put("id", id);
    this.id = id;
  }

  public JsonArray getUpdates() {
    return updates;
  }

  public void setUpdates() {
    JsonArray updates = Json.createArray();
    getAttributes().put("__updates", updates);
    this.updates = updates;
  }

  public void setUpdates(JsonArray updates) {
    getAttributes().put("__updates", updates);
    this.updates = updates;
  }

  public JsonObject getAttributes() {
    return attributes;
  }

  public void setAttributes(JsonObject attributes) {
    this.attributes = attributes;
  }
}
