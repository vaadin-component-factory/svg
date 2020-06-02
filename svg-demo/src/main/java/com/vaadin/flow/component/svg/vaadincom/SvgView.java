package com.vaadin.flow.component.svg.vaadincom;

import com.vaadin.flow.component.svg.Svg;
import com.vaadin.flow.component.svg.elements.Circle;
import com.vaadin.flow.component.svg.elements.Rect;
import com.vaadin.flow.demo.DemoView;
import com.vaadin.flow.router.Route;

@Route("")
public class SvgView extends DemoView {

    private static final long serialVersionUID = -9216144022041025031L;

    @Override
    protected void initView() {
        basicDemo();
    }

    private void basicDemo() {
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
}
