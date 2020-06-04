package com.vaadin.flow.component.svg;

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

import com.vaadin.flow.component.svg.elements.SvgElement;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

@Tag("vcf-svg")
@NpmPackage(value = "@vaadin-component-factory/vcf-svg", version = "0.1.9")
@JsModule("@vaadin-component-factory/vcf-svg/src/vcf-svg.js")
public class Svg extends Component {

    /**
     * Initializes a new Svg.
     */
    public Svg() {
    }

    public void add(SvgElement element) {
        getElement().callJsFunction("add", element.toJson());
    }

    public void update(SvgElement element) {
        getElement().callJsFunction("update", element.toJson());
    }

    public void viewbox(double minx, double miny, double width, double height) {
        getElement().callJsFunction("viewbox", minx, miny, width, height);
    }

    private static final long serialVersionUID = 4669224429512601365L;
}
