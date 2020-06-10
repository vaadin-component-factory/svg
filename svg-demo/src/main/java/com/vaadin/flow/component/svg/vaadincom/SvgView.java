package com.vaadin.flow.component.svg.vaadincom;
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

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.AbstractPolyElement;
import com.vaadin.flow.component.svg.elements.Circle;
import com.vaadin.flow.component.svg.elements.Ellipse;
import com.vaadin.flow.component.svg.elements.Image;
import com.vaadin.flow.component.svg.elements.Line;
import com.vaadin.flow.component.svg.elements.Path;
import com.vaadin.flow.component.svg.elements.Polygon;
import com.vaadin.flow.component.svg.elements.Polyline;
import com.vaadin.flow.component.svg.elements.Rect;
import com.vaadin.flow.component.svg.elements.Text;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class SvgView extends DemoView {

    private static final long serialVersionUID = -9216144022041025031L;

    @Override
    protected void initView() {
        basicDemo();
        complexDemo();
    }

    private void basicDemo() {

        // begin-source-example
        // source-example-heading: Basic Demo
        Svg draw = new Svg();
        Rect rect = new Rect("rect", 100, 100);
        Circle circle = new Circle("circle", 50);

        rect.move(75, 0);
        rect.size(150, 150);

        circle.center(150, 75);
        circle.setRadius(75);
        circle.setFillColor("#396");

        draw.add(rect);
        draw.add(circle);
        // end-source-example

        addCard("Basic Demo", draw);
    }

    private void complexDemo() {

        // begin-source-example
        // source-example-heading: Complex Demo
        VerticalLayout demoContainer = new VerticalLayout();
        HorizontalLayout controlButtons = new HorizontalLayout();
        demoContainer.add(controlButtons);
        Span dragDetail = new Span();
        demoContainer.add(dragDetail);

        Svg svg = new Svg();
        svg.viewbox(0, 0, 380, 380);
        svg.setWidth("100%");
        svg.setHeight("500px");

        double size = 100;
        double space = size + 20;
        double x = 20;
        double y = 20;
        String fillColor = "#ff0066";

        //Rect
        Rect rect = new Rect("rect1", size, size);
        rect.setFillColor(fillColor);
        rect.move(x, y);
        svg.add(rect);

        //Circle
        double circleRadial = size / 2;
        Circle circle = new Circle("circle1", circleRadial);
        circle.setFillColor(fillColor);
        circle.move(x += space, y);
        svg.add(circle);

        //Ellipse
        Ellipse ellipse = new Ellipse("ellipse1", circleRadial, circleRadial * 0.5);
        ellipse.setFillColor(fillColor);
        ellipse.move(x += space, y);
        svg.add(ellipse);

        //Line
        Line line = new Line("line", new AbstractPolyElement.PolyCoordinatePair(x = 20, y += space),
            new AbstractPolyElement.PolyCoordinatePair(x + size,
                y + size));
        line.setStroke(fillColor, 10, Path.LINE_CAP.ROUND, null);
        svg.add(line);

        //Polyline
        List<AbstractPolyElement.PolyCoordinatePair> points = new ArrayList<>();
        points.add(new Polyline.PolyCoordinatePair(50, 0));
        points.add(new Polyline.PolyCoordinatePair(60, 40));
        points.add(new Polyline.PolyCoordinatePair(100, 50));
        points.add(new Polyline.PolyCoordinatePair(60, 60));
        points.add(new Polyline.PolyCoordinatePair(50, 100));
        points.add(new Polyline.PolyCoordinatePair(40, 60));
        points.add(new Polyline.PolyCoordinatePair(0, 50));
        points.add(new Polyline.PolyCoordinatePair(40, 40));

        Polyline polyline = new Polyline("polyline", points);
        polyline.setFillColor("none");
        polyline.setStroke(fillColor, 4, Path.LINE_CAP.ROUND, Path.LINE_JOIN.ROUND);
        polyline.move(x += space, y);
        svg.add(polyline);

        //Polygon
        Polygon polygon = new Polygon("polygon", points);
        polygon.setFillColor(fillColor);
        polygon.move(x += space, y);
        svg.add(polygon);

        //Path
        Path path = new Path("path", "M0 0 H50 A20 20 0 1 0 100 50 v25 C50 125 0 85 0 85 z");
        path.setFillColor("none");
        path.setStroke(fillColor, 4, Path.LINE_CAP.ROUND, Path.LINE_JOIN.ROUND);
        path.move(x = 20, y += space);
        svg.add(path);

        //Text
        Text text = new Text("text", "Sample text.");
        text.setFontFamily("'Roboto', 'Noto', sans-serif");
        text.setFillColor(fillColor);
        text.move(x += space, y);
        svg.add(text);

        //Image
        Image image = new Image("image", "https://vaadin.com/images/hero-reindeer.svg");
        image.size(size, size);
        image.move(x += space, y);
        image.setDraggable(false);
        svg.add(image);

        demoContainer.add(svg);

        //Add control buttons
        controlButtons.add(new Button("Toggle Zoom", e -> svg.setZoomEnabled(!svg.isZoomEnabled())));
        controlButtons.add(new Button("Toggle draggable", e -> {
            svg.getSvgElements().forEach(el -> el.setDraggable(!el.isDraggable()));

            svg.getSvgElements().forEach(el -> {

                // Due to the nature of how the polygons are written, if we do an update
                // to them they will move back to 0,0. Hence, we have to move them back
                // to their desired location when we do an update.
                if (el == polyline) {
                    el.move(20 + space, 20 + space);
                }

                if (el == polygon) {
                    el.move(20 + space * 2, 20 + space);
                }

                svg.update(el);
            });
        }));
        controlButtons.add(new Button("Stroke black", e -> {
            svg.getSvgElements().forEach(el -> el.setStroke("#000000", 4, Path.LINE_CAP.ROUND, Path.LINE_JOIN.ROUND));
            svg.getSvgElements().forEach(el -> {

                // Due to the nature of how the polygons are written, if we do an update
                // to them they will move back to 0,0. Hence, we have to move them back
                // to their desired location when we do an update.
                if (el == polyline) {
                    el.move(20 + space, 20 + space);
                }

                if (el == polygon) {
                    el.move(20 + space * 2, 20 + space);
                }

                svg.update(el);
            });
        }));
        controlButtons.add(new Button("Display drag events", e -> {
            svg.addDragStartListener(event -> {
                Notification.show("Drag start: " + event.getElement().getId(), 2500, Notification.Position.MIDDLE);
                dragDetail.setText("Drag Start for: " + event.getElement().getId() + " X: " + event.getElementX() + " Y: " + event.getElementY());
            });

            svg.addDragEndListener(event -> {
                Notification.show("Drag End: " + event.getElement().getId(), 2500, Notification.Position.MIDDLE);
                dragDetail.setText("Drag End for: " + event.getElement().getId() + " X: " + event.getElementX() + " Y: " + event.getElementY());
            });

            dragDetail.setText("DragMove disabled for public demo due to potentially high request count.");
//            svg.addDragMoveListener(event -> {
//                dragDetail.setText("Drag Move for: " + event.getElement().getId() + " X: " + event.getElementX() + " Y: " + event.getElementY());
//            });

            e.getSource().setEnabled(false);
        }));

        controlButtons.add(new Button("Remove Line", e -> {
            svg.remove(line);
            e.getSource().setEnabled(false);
        }));


        // end-source-example
        addCard("Complex Demo", demoContainer);
    }


}
