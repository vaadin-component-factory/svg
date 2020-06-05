package com.vaadin.flow.component.svg.elements;

public enum SvgType {
    RECT, CIRCLE, ELLIPSE, LINE, POLYLINE, POLYGON, PATH, TEXT, IMAGE;

    public String getClientSideType() {
        return this.name().toLowerCase().replaceAll("_", "-");
    }
}
