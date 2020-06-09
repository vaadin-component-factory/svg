package com.vaadin.flow.component.svg.elements;

/**
 * Represents an SVG text element.
 */
public class Text extends SvgElement {

    /**
     * Creates a new Text element with the given id and text.
     *
     * @param id   the id for this text element
     * @param text the text to show for this text element
     */
    public Text(String id, String text) {
        super(id);
        setConstructor(SvgType.TEXT, val(text));
        setText(text);
    }

    /**
     * Sets the visible text for this Text element.
     *
     * @param text the text to show
     */
    public void setText(String text) {
        setAttribute("text", text);
    }

    /**
     * Returns the current text on this text element.
     *
     * @return the current text on this text element.
     */
    public String getText() {
        return getStringAttribute("text");
    }

    /**
     * Sets the font family to use for this Text element.
     * Note that the browser must support the font that is specified here.
     * <p>
     * This attribute can have multiple values (i.e. webfonts with fallback)
     * for instance: setFontFamily("'Roboto', 'Noto', sans-serif");
     *
     * @param fontFamily the font family to use for this text element.
     */
    public void setFontFamily(String fontFamily) {
        setAttribute("font-family", fontFamily);
    }

    /**
     * Returns the current font family used for this Text element.
     *
     * @return the current font family
     */
    public String getFontFamily() {
        return getStringAttribute("font-family");
    }

    /**
     * Sets the font size of this text element, this can be in absolute (px) or relative (ex: em, ex) values.
     * @param fontSize the font size to use
     */
    public void setFontSize(String fontSize){
        setAttribute("font-size", fontSize);
    }

    /**
     * Returns the font size for this text element.
     * @return the font size or null if none set
     */
    public String getFontSize(){
        return getStringAttribute("font-size");
    }


}
