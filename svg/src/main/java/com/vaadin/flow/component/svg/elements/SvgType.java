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

import elemental.json.JsonValue;
import org.apache.commons.lang3.text.WordUtils;

/**
 * An enumeration containing the known supported types of svg element supported by the client-side implementation.
 *
 * @see SvgElement#setConstructor(SvgType, JsonValue...)
 */
public enum SvgType {
    RECT, CIRCLE, ELLIPSE, LINE, POLYLINE, POLYGON, PATH, TEXT, IMAGE, GROUP, TEXT_PATH;

    /**
     * Returns the client-side compatible name for an entry in this enum.
     *
     * @return the client-side compatible name for this entry.
     */
    public String getClientSideType() {
        return WordUtils.uncapitalize(WordUtils.capitalizeFully(this.name(), '_').replace("_", ""));
    }
}
