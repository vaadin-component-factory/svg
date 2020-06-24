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
package com.vaadin.flow.component.svg;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.svg.elements.SvgElement;
import com.vaadin.flow.component.svg.listeners.SvgDragEndListener;
import com.vaadin.flow.component.svg.listeners.SvgDragMoveListener;
import com.vaadin.flow.component.svg.listeners.SvgDragStartListener;
import com.vaadin.flow.dom.DomListenerRegistration;
import com.vaadin.flow.shared.Registration;
import elemental.json.JsonObject;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

/**
 * The display portion of the Vaadin Component Factory Svg component.
 * This is the component that is used to display one or more {@link SvgElement}
 * elements as well as listen to events on said elements.
 */
@Tag("vcf-svg")
@NpmPackage(value = "@vaadin-component-factory/vcf-svg", version = "1.0.4")
@JsModule("@vaadin-component-factory/vcf-svg/src/vcf-svg.js")
public class Svg extends Component implements HasSize, HasStyle {

    private static final long serialVersionUID = 4669224429512601365L;
    private static final Logger log = Logger.getLogger(Svg.class.getName());

    private Set<SvgElement> svgElements = new HashSet<>();
    private DomListenerRegistration dragstartDomRegistration;
    private DomListenerRegistration dragendDomRegistration;
    private DomListenerRegistration dragmoveDomRegistration;

    /**
     * Initializes a new Svg.
     */
    public Svg() {

    }

    /**
     * Adds a new {@link SvgElement} to this {@link Svg} component.
     *
     * @param element the element to add, never null
     */
    public void add(SvgElement element) {
        Objects.requireNonNull(element);
        getElement().callJsFunction("add", element.cloneAttributesToJson());
        svgElements.add(element);
        element.clearUpdates();
    }

    /**
     * Pan and zoom viewport to the element.
     *
     * @param element the element to pan to.
     */
    public void panTo(SvgElement element) {

        getElement().callJsFunction("panTo", "[id='" + element.getId() + "']");
    }

    /**
     * Pan and zoom the viewport to the element.
     *
     * @param element the element to pan to.
     * @param scale enable zoom to fit to viewport while panning.
     * @param transitionDuration duration of the pan and zoom animation.
     */
    public void panTo(SvgElement element, Boolean scale, double transitionDuration) {

        getElement().callJsFunction("panTo", "[id='" + element.getId() + "']", scale, transitionDuration);
    }

    /**
     * Removes the given element from this Svg component if it exists.
     *
     * @param element the element to remove
     */
    public void remove(SvgElement element) {

        //Only call the client-side if the element actually existed here before.
        if (svgElements.remove(element)) {
            getElement().callJsFunction("remove", element.getId());
        }
    }

    /**
     * Used to update a single Svg element whose attributes might have changed.
     *
     * @param element the element to update to the client side.
     */
    public void update(SvgElement element) {

        getElement().callJsFunction("update", element.cloneAttributesToJson());
        element.clearUpdates();
    }

    /**
     * A convenience method for updating multiple elements at once.
     *
     * @param elements the elements to update
     * @see #update(SvgElement)
     */
    public void update(Collection<SvgElement> elements) {
        if (elements != null) {
            elements.forEach(this::update);
        }
    }

    /**
     * A convenience method for updating multiple elements at once.
     *
     * @param elements the elements to update
     * @see #update(SvgElement)
     */
    public void update(SvgElement... elements) {
        if (elements != null) {
            Arrays.stream(elements).forEach(this::update);
        }
    }

    /**
     * Sets the viewbox of the Svg element on the client-side This can be used to tune the
     * client-side viewport of this svg component. Note that the viewbox of the SVG element is
     * different than the size of the web component which can be set with
     * {@link Svg#setWidth(String)} {@link Svg#setHeight(String)}
     *
     * @param minx   the minimum x-axis value
     * @param miny   the minimum y-axis value
     * @param width  the width of the viewbox
     * @param height the height of the viewbox
     */
    public void viewbox(double minx, double miny, double width, double height) {
        getElement().callJsFunction("viewbox", minx, miny, width, height);
    }

    /**
     * Sets the zoom feature to enabled or disabled.
     * By default the zoom feature is disabled.
     *
     * @param zoomEnabled - true enabled, false disabled
     */
    public void setZoomEnabled(boolean zoomEnabled) {
        getElement().setProperty("zoomable", zoomEnabled);
    }

    /**
     * Returns the enabled state of the zoom feature.
     *
     * @return true if enabled, false if disabled
     * @see #setZoomEnabled(boolean)
     */
    @Synchronize("zoomable-changed")
    public boolean isZoomEnabled() {
        return getElement().getProperty("zoomable", false);
    }

    /**
     * Retuns the current set of {@link SvgElement} in this Svg component.
     *
     * @return an unmodifiable copy of the internal set of known elements
     */
    public Set<SvgElement> getSvgElements() {
        return Collections.unmodifiableSet(svgElements);
    }

    /**
     * Adds a drag start event listner to this {@link Svg} component that will be triggered when a draggable component
     * has started to be dragged on the client-side.
     *
     * @param listener the listener to add
     * @return the registration for managing the listener
     */
    public Registration addDragStartListener(SvgDragStartListener listener) {
        //In general we don't want the client-side to send events to the server unless we're actually listening to them.
        ensureDomDragStartEventListenerRegistered();
        return addListener(SvgDragStartListener.SvgDragStartEvent.class, listener);
    }

    /**
     * Adds a drag start event listner to this {@link Svg} component that will be triggered when a draggable component
     * has started to be dragged on the client-side.
     *
     * @param listener the listener to add
     * @return the registration for managing the listener
     */
    public Registration addDragEndListener(SvgDragEndListener listener) {
        //In general we don't want the client-side to send events to the server unless we're actually listening to them.
        ensureDomDragEndEventListenerRegistered();
        return addListener(SvgDragEndListener.SvgDragEndEvent.class, listener);
    }


    /**
     * Adds a drag move event listener to this {@link Svg} component that will be triggered when a draggable component
     * has moved from it's previous position on the client-side.
     * <p>
     * Warn, this is potentially a very heavy listener as every single move is sent to the server, use with caution.
     * <p>
     * Consider using {@link #addDragStartListener(SvgDragStartListener)} and {@link #addDragEndListener(SvgDragEndListener)}
     * instead as the client-server latency makes it unfeasible for the server to react to single px moves anyway.
     *
     * @param listener the listener to add
     * @return the registration for managing the listener
     */
    public Registration addDragMoveListener(SvgDragMoveListener listener) {
        //In general we don't want the client-side to send events to the server unless we're actually listening to them.
        ensureDomDragMoveEventListenerRegistered();
        return addListener(SvgDragMoveListener.SvgDragMoveEvent.class, listener);
    }

    /**
     * This method will add dragStartEventListener if not already added.
     */
    protected void ensureDomDragStartEventListenerRegistered() {
        if (dragstartDomRegistration == null) {
            dragstartDomRegistration = getElement().addEventListener("dragstart", e -> {
                onDragStartEvent(e.getEventData().getString("event.detail.handler.el.node.id"), e.getEventData());
            }).addEventData("event.detail.handler.el.node.id")
                .addEventData("event.detail.handler.el.node.instance.x()")
                .addEventData("event.detail.handler.el.node.instance.y()");
        }
    }

    /**
     * This method will add dragEndEventListener if not already added.
     */
    protected void ensureDomDragEndEventListenerRegistered() {
        if (dragendDomRegistration == null) {
            dragendDomRegistration = getElement().addEventListener("dragend", e -> {
                onDragEndEvent(e.getEventData().getString("event.detail.handler.el.node.id"), e.getEventData());
            }).addEventData("event.detail.handler.el.node.id")
                .addEventData("event.detail.handler.el.node.instance.x()")
                .addEventData("event.detail.handler.el.node.instance.y()");
        }
    }


    /**
     * This method will add dragEndEventListener if not already added.
     */
    protected void ensureDomDragMoveEventListenerRegistered() {
        if (dragmoveDomRegistration == null) {
            dragmoveDomRegistration = getElement().addEventListener("dragmove", e -> {
                onDragMoveEvent(e.getEventData().getString("event.detail.handler.el.node.id"), e.getEventData());
            }).addEventData("event.detail.handler.el.node.id")
                .addEventData("event.detail.handler.el.node.instance.x()")
                .addEventData("event.detail.handler.el.node.instance.y()");

            //e.detail.handler.el.node.instance.x();
        }
    }

    /**
     * Fires a drag start event if an svgElement is found in this Svg component based on the elementId provided.
     * Note that if an svgElement is not found, no events will be fired.
     *
     * @param elementId    the element id to look for.
     * @param rawEventData the raw event data for extended use
     */
    protected void onDragStartEvent(String elementId, JsonObject rawEventData) {
        Optional<SvgElement> element = findElementForId(elementId);
        if (!element.isPresent()) {
            log.fine("onDragStartEvent fired but no element found in internal list for id: " + elementId + " suppressing event as mapping cannot " +
                "be done.");
        }
        element.ifPresent(svgElement -> fireEvent(new SvgDragStartListener.SvgDragStartEvent(this, true, svgElement, rawEventData)));
    }

    /**
     * Fires a drag end event if an svgElement is found in this Svg component based on the elementId provided.
     * Note that if an svgElement is not found, no events will be fired.
     *
     * @param elementId    the element id to look for.
     * @param rawEventData the raw event data for extended use
     */
    protected void onDragEndEvent(String elementId, JsonObject rawEventData) {
        Optional<SvgElement> element = findElementForId(elementId);
        if (!element.isPresent()) {
            log.fine("onDragEndEvent fired but no element found in internal list for id: " + elementId + " suppressing event as mapping cannot " +
                "be done.");
        }
        element.ifPresent(svgElement -> fireEvent(new SvgDragEndListener.SvgDragEndEvent(this, true, svgElement, rawEventData)));

    }

    /**
     * Fires a drag move event if an svgElement is found in this Svg component based on the elementId provided.
     * Note that if an svgElement is not found, no events will be fired.
     *
     * @param elementId    the element id to look for.
     * @param rawEventData the raw event data for extended use
     */
    protected void onDragMoveEvent(String elementId, JsonObject rawEventData) {
        Optional<SvgElement> element = findElementForId(elementId);
        if (!element.isPresent()) {
            log.fine("onDragMoveEvent fired but no element found in internal list for id: " + elementId + " suppressing event as mapping cannot " +
                "be done.");
        }
        element.ifPresent(svgElement -> fireEvent(new SvgDragMoveListener.SvgDragMoveEvent(this, true, svgElement, rawEventData)));

    }

    /**
     * Helper method to convert a elementId to a svgElement in this Svg component.
     *
     * @param elementId the elementId to look for
     * @return an optional containing the svgElement or empty if none found.
     */
    protected Optional<SvgElement> findElementForId(String elementId) {
        return svgElements.stream().filter(element -> elementId.equals(element.getId())).findFirst();
    }

}
