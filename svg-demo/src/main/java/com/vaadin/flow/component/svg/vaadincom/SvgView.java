package com.vaadin.flow.component.svg.vaadincom;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.Circle;
import com.vaadin.flow.component.svg.elements.Path;
import com.vaadin.flow.component.svg.elements.Rect;
import com.vaadin.flow.component.svg.elements.SvgElement;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;
import elemental.json.Json;
import elemental.json.JsonObject;

@Route("")
public class SvgView extends DemoView {

    private static final long serialVersionUID = -9216144022041025031L;

    @Override
    protected void initView() {
        basicDemo();
    }

    private void basicDemo() {

        if (true) {
            runPlayground();
            return;
        }

        // begin-source-example
        // source-example-heading: Basic Demo
        Svg draw = new Svg();
        Rect rect = new Rect("rect", 100, 100);
        Circle circle = new Circle("circle", 100);

        rect.move(75, 0);
        rect.size(150, 150);

        circle.center(150, 75);
        circle.size(150);
        circle.attr("fill", "#396");

        draw.add(rect);
        draw.add(circle);
        // end-source-example

        addCard("Basic Demo", draw);
    }

    private void runPlayground() {


        Svg svg = new Svg();
        //svg.getElement().setAttribute("zoomable", "true");

        Circle circle1 = new Circle("circle1", 50);
        circle1.move(0, 30);
        svg.add(circle1);

        Circle rect = new Circle("circle2", 50);
        rect.setId("findMe");
        rect.setAttr("draggable", Json.create(true));
        rect.move(75, 0);
        svg.add(rect);

        Circle rect3 = new Circle("circle3", 50);
        rect3.move(150, 30);
        svg.add(rect3);

//        Path path = new Path("path1", "M0 0 H50 A20 20 0 1 0 100 50 v25 C50 125 0 85 0 85 z");
//        Path path = new Path("path1", "M50 0 L200 0 A20 20 0 1 1 200 50 L50 50 A20 20 0 1 1 50 0 z");
//        Path path = new Path("path1", "M50 0 L200 0");
        Path path = new Path("path1", "M50 0 Q125 40 200 0 A20 20 0 1 1 200 50 L50 50 A20 20 0 1 1 50 0 z");
        path.setFill("none");
        path.setStroke("#f06", 4, Path.LINE_CAP.ROUND, Path.LINE_JOIN.ROUND);

        path.move(0, 30);
        svg.add(path);

        add(new Button("Toggle Zoom", e -> svg.setZoomEnabled(!svg.isZoomEnabled())));

//        svg.getElement().addEventListener("svg-ready", e -> {
//            svg.getElement().executeJs("$0.draggable($0.findOneById('findMe'), true)", svg.getElement());
//        });

        svg.getElement().addEventListener("dragend", e -> {
            System.out.println("dragend event, id: " + e.getEventData().getString("event.detail.handler.el.node.id"));
        }).addEventData("event.detail.handler.el.node.id");
        svg.getElement().addEventListener("dragstart", e -> {
            System.out.println("dragstart event, id: " + e.getEventData().getString("event.detail.handler.el.node.id"));
        }).addEventData("event.detail.handler.el.node.id");
        svg.getElement().addEventListener("dragmove", e -> {
            System.out.println("dragmove event, id: " + e.getEventData().getString("event.detail.handler.el.node.id"));
        }).addEventData("event.detail.handler.el.node.id");


        add(svg);


    }
}
