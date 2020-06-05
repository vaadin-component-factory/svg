package com.vaadin.flow.component.svg.elements;

/**
 * Represents an SVG path
 */
public class Path extends SvgElement {

    public enum LINE_CAP {
        BUTT, ROUND, SQUARE;

        public String getClientSideType() {
            return this.name().toLowerCase().replaceAll("_", "-");
        }
    }

    public enum LINE_JOIN {
        ARCS, BEVEL, MITER, MITER_CLIP, ROUND;

        public String getClientSideType() {
            return this.name().toLowerCase().replaceAll("_", "-");
        }
    }

    public Path(String id, String path) {
        super(id);
        setConstructor(SvgType.PATH, val(path));
    }

    public void setFill(String fillType) {
        getAttributes().put("fill", val(fillType));
    }

    public void setStroke(String color, int width, LINE_CAP lineCap, LINE_JOIN lineJoin) {

        assert color != null;

        getAttributes().put("stroke", val(color));
        getAttributes().put("stroke-width", val(width));

        if (lineCap != null) {
            getAttributes().put("stroke-linecap", val(lineCap.getClientSideType()));
        }

        if (lineJoin != null) {
            getAttributes().put("stroke-linejoin", val(lineJoin.getClientSideType()));
        }

    }
}
